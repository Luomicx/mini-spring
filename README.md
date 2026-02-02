# Mini-Spring

- 本项目用于学习 Spring 底层代码及逻辑，通过源码的简单实现来搭建一个最小可行性的 Spring 框架。

- 现处于开发阶段 ing

## Day01 DI & IoC Container & XML Parse

### 实现 IoC Container

- 目标：定义 Bean 的“身份信息”，即元数据信息

- 核心类：
    - `BeanDefinition`: 存储 Bean 的类信息（目前字段包括： [bean, beanClass, beanClassName, PropertyValues]）
    - `BeanFactory`: 接口类，定义 `Object getBean(String name)` 和 `void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;`
    - `AbstractBeanFactory`: 工厂的抽象类，定义了 Bean 生产的标准流程，使用 **模版模式（Template Pattern）**
    - `AutoWireCapableBeanFactory`: Bean 工厂实现类，通过 **使用 Java 的反射技术将类名变为真实的实例对象**
- 意义：规范了 Bean 的获取方式，统一由 Factory 生产并提供。

这一步实现了 **解耦**， 将创建对象的控制权从开发者转交给了框架，也实现了 **职责分离**，`AbstractBeanFactory` 负责管理，`AutoWireCapableBeanFactory` 负责执行（使用反射创建对象）。

**反射**：允许程序在 **运行期间** 动态地探索和操作类的内部属性
$$
\text{ClassName (String)} \xrightarrow{\text{Class.forName()}} \text{Class Object} \xrightarrow{\text{newInstance()}} \text{Object Instance}
$$

### Bean Property Population

#### 实现 Bean 属性填充

-目标：在 Bean 实例化之后，将其依赖的属性（基本类型或引用类型）自动注入到 Bean 实例中。

- 核心类：
    - `PropertyValue`: 定义具体的 Bean 属性信息，包含 `name`（属性名）和 `value`（属性值）。- `PropertyValues`: 属性集合，用于封装一个 Bean 所有的 `PropertyValue`。
    - `BeanReference`: 这是一个引用占位符。当 Bean 的属性依赖于另一个 Bean 时，无法直接在 `BeanDefinition` 中存储实例，而是存储一个 `BeanReference(beanName)`。
    - `AbstractAutowireCapableBeanFactory`: 扩展 `createBean` 流程。在 `createBeanInstance` 之后，调用 `applyPropertyValues` 进行属性填充。
- 意义：完成了 **DI（依赖注入）** 的核心逻辑。容器不仅负责创建对象，还负责装配对象。

在此阶段，我们解决了 **Bean 之间的依赖问题**。当遇到 `BeanReference` 类型的属性值时，容器会递归调用 `getBean` 方法，确保依赖的 Bean 被优先创建。

**属性注入流程**：
$$
\text{Instantiate Bean} \xrightarrow{\text{Get PropertyValues}} \text{Iterate Properties} \xrightarrow{\text{Resolve Value (Literal or BeanReference)}} \text{Reflection set()} \xrightarrow{\text{Ready Bean}}
$$
特别是对于 **BeanReference** 的解析：
$$
\text{Value isBeanReference} \xrightarrow{\text{getName()}} \text{getBean(refName)} \xrightarrow{\text{Recursion}} \text{Return Dependent Bean Instance}
$$


### Resource Loading & XML Parsing

### 实现配置文件加载

- 目标：脱离手动创建 `BeanDefinition` 的方式，通过解析 XML 配置文件自动注册 Bean。
- 核心类：
    - `Resource`: 资源抽象接口，定义 `getInputStream()`，实现类包括 `ClassPathResource`, `FileSystemResource`, `UrlResource`。
    - `ResourceLoader`: 资源加载器，根据路径（如 `classpath:` 前缀）返回具体的 `Resource` 实现。
    - `BeanDefinitionReader`: 定义读取 `BeanDefinition` 的接口。
    - `XmlBeanDefinitionReader`: 具体实现类，负责加载 XML 文件，解析 `<bean>` 标签，组装 `BeanDefinition` 并注册到 `BeanDefinitionRegistry`。
- 意义：实现了 **配置与代码的分离**。用户只需维护 XML 文件，无需修改 Java 代码即可管理 Bean 的依赖关系和生命周期。

这一步引入了 **资源抽象** 层，使得框架可以统一处理不同来源的配置（文件系统、类路径、网络 URL）。同时遵循了 **单一职责原则**：`ResourceLoader` 负责加载文件，`XmlBeanDefinitionReader` 负责解析内容，`BeanFactory` 负责注册和生产 Bean。

**加载与注册流程**：
$$
\text{Location Path} \xrightarrow{\text{ResourceLoader}} \text{Resource} \xrightarrow{\text{XmlBeanDefinitionReader}} \text{Parse XML} \xrightarrow{\text{Register BeanDefinition}} \text{BeanFactory}
$$
**总结：** 第一天实现了 BeanFactory 整个流水线的建造，还有 XML 解析和 LoadResource，其中用到了 Java 的反射机制、URL（java.net 包）、Document（org.w3c.dom.Document）。这些组件是首次接触，其中 URL 是资源定位符，用于在运行过程中去本地或者网络资源中获取相应的包来进行配置注入；Document 是将我们获取到的 URL 之后转为 InputStream 流然后进行读取为 DOM 结构，通过 DOM 结构对 XML 文件进行解析，获取 ROOT 和相关资源标签中的内容，比如 `<property>  <bean>` 来获取其中的属性从而配置到我们的 Bean 中。通过手敲代码，对 Spring 框架的 IoC 和 DI 更加清晰，也对相关框架的认识更加透彻