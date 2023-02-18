Use this to solve .idea garbage that is still not included into .gitignore:

``` 
git rm -r --cached .idea
```

Say thanks to [source](https://bigdata-etl.com/gitignore-intellij-not-working-idea-git/)

# Lecture notes

This file is a space for small notes I'd like to mark after listening lectures.

### Notes for [Lesson 2](https://youtu.be/nLCYk1ySY_U)

- Bean is some kind of Spring Object.
- application.yml is a configuration for Spring Framework.
  Reading this file, Spring creates configured beans by determined template.
- constructor-args
- ClassPathXmlApplicationContext only for files in resources directory
- context.getBean(bean-id, class-bean-you-want-to-get); Don't forget to close context.close();

### Notes for [Lesson 4](https://youtu.be/Ns0IxBXDbWw)

- **Bean is a Java Object**. Java Object created with Spring Framework is called Bean.
  To create Beans Java classes are used (also as for usual Java Objects).
- Creating dependencies inside objects/beans produces difficulties
  ('cause even weak dependencies complicate code and future code changings & development).
  To avoid dependencies **inside** object/bean we can use **Inversion of Control (IoC) design pattern**.
- Using IoC we bring dependency inside from outside. | Programming on interface level.
- Spring can be configured in 3 ways:
    - XML configuring file
    - Java annotations & few XML configuration
    - Using only Java code
- Do not use Interfaces in application.xml as beans ('cause impossible to create an object of interface).

### Notes for [Lesson 5](https://youtu.be/MjnVZgMnTT0)

- **Working with Spring steps:**
    - **To create Java class - future Beans.**
    - **To create Beans and their dependencies with Spring (XML/annotations/Java code).**
    - **After creating all Beans are places in Spring container.**
- Dependency Injection (DI) ways:
    - Using constructor.
    - Using setter.
    - Scope, Factory Method etc.
    - XML/annotations/Java code.
    - Autowiring.
- Dependency Injection (DI) is used to avoid manual dependency and objects creation.

### Notes for [Lesson 6](https://youtu.be/dBxRmUH3Af8)

- We used Reference for constructor as DI way.
- We use Value for setter as DI way.
- We can use File for setter as DI way.
- For application.xml <property>: application.xml takes setter name from Java class.
  It knows about "set" and camel case in names and ignores them using only second part converting from camel case to
  lower case.
  So for <property name="music"/> the only setter we need in MusicPlayer.java is void setMusic (M in upper case).
- If you don't use constructor-args in application.xml don't forget to create default constructor in appropriate Java
  class.
- Using <property name="music"/> Spring creates a Bean with default constructor and only then set values with setter.
- To read properties from file use <context:property-placeholder location="classpath:player.properties"/>. All files
  placed in "resources" directory are also placed as "classpath".
- ${} to get values from .properties file.
- To inject List of references:
  ```
  <property name="musicList">
            <list>
                <ref bean="rockMusic"/>
                <ref bean="classicalMusic"/>
                <ref bean="rapMusic"/>
            </list>
        </property> 
  ```
- To inject List of values:

 ```
  <property name="musicList">
            <list>
                <ref bean="rockMusic"/>
                <ref bean="classicalMusic"/>
                <ref bean="rapMusic"/>
            </list>
        </property> 
  ```

- It's possible to use:

``` 
<util:list id="myList" value-type="java.lang.String">
    <value>foo</value>
    <value>bar</value>
</util:list>
```

### Notes for [Lesson 7](https://youtu.be/IcwWPjeBpFU)

- Scope - область видимости
- Scope задает то, как Spring будет создавать бины.
- Singleton is default scope. It creates only one object of one bean and the rest objects based on that bean just refer
  to it instead of creating new object. Many objects - one link.
- Singleton is used when the object is stateless.
- Changing the state of one object we change states of every object.
- Prototype creates new object everytime we use getBean().
- Prototype is used when bean is stateful.

### Notes for [Lesson 8](https://youtu.be/MVbBLoZrT2A)

Bean Lifecycle: Spring application starting -> Spring container starting -> An object of a bean is created ->
Dependency Injection -> Init method of the bean is called -> Bean is used -> Destroy method of the bean is called ->
Spring application closing.

Жизненный цикл бина: Запуск спринг приложения -> Запуск спринг контейнера -> Создание объекта бина -> Внедрение
зависимостей -> Вызов инит-метода бина -> Бин готов к использованию, использование бина -> Вызов дестрой-метода ->
Остановка спринг приложения.

- Init-method is used for initialization of recourses, DBs, foreign files.
- Destroy-method is used for resources clearing, threads closing (input and output), closing DBs access.
- Инит и дестрой методы:
    - Любой модификатор доступа.
    - Любой тип возвращаемого значения, но в этом нет смысла - нет возможности его получить.
    - Название метода может быть любым.
    - Метод **не должен** принимать на вход какие-либо аргументы.
    - ДЛЯ БИНОВ СО SCOPE PROTOTYPE SPRING НЕ ВЫЗЫВАЕТ DESTROY METHOD.
        - Spring не берет на себя полный ЖЦ бинов со scope prototype. Spring отдает prototype бины клиенту и больше о
          них не заботится, в отличии от singleton бинов.
        - Вызывается столько инит-методов prototype бинов, сколько их было создано.
- If we use factory method we can say Spring the factory method. Then the object will be created with factory method
  instead of direct "new".
- Scope singleton >>> factory method with "new" everytime.

### Notes for [Lesson 9](https://youtu.be/aXDMYy930b4)

- Java Annotations - special comment type in code that helps:
    - to give instructions to Java compiler (ex: @Override)
    - to give instructions to code analysers
    - to give metadata that is used by Java app (with reflection) or other apps & frameworks (ex: Spring Framework)
- Reasons to use Java Annotations:
    - shorter than XML configuration
    - handier than XML configuration
    - code is more clear
- Spring scans all classes
- Annotation @Component marks class as Bean (future Spring Object)
- Do not use @Component on interfaces - you cannot create object of interface
- @Component creates ID with nameOfClass. You can write custom id using @Component("newId")

### Notes for [Lesson 10](https://youtu.be/KvyD2Vg4b1Q)

- Annotation @Autowired helps to inject dependencies automatically. Spring searches for suitable bean on its own.
- Steps:
    - Spring scans all classes with @Component annotation and creates beans for these classes.
    - Spring scans all created beans and checks if at least one bean is possible to inject to place with @Autowired.
    - If one bean is perfectly suitable it is injected as dependency.
    - If there's no suitable beans we get an error.
    - If there's more than 1 suitable beans we get an error.
- Annotation @Autowired searches for a bean by their type (class or interface).
- @Autowired can be used on fields, setters and constructors.
- @Autowired injects dependencies even into private fields (using Java Reflection API).
- @Autowired does not care how the method is called, it injects dependencies even into quackQuack(Interface interface).
- @Autowired can be used for 2 different injections in one method: @Autowired / method(First first, Second second).
- If in first we have second and in second we have third, firstly, Spring injects third to second, then second to first.
- Does not matter where to use @Autowired (setter, constructor, field), but **please** do use only one type per project.

### Notes for [Lesson 11](https://youtu.be/pDTzRsuGrDU)

- To specify bean when we use @Autowired on interface we can use @Qualifier("beanId")
- It can be used on setter, constructor, field

### Notes for [Lesson 12](https://youtu.be/oNfK1FJ7Lkw)

- @Scope("singleton"), @Scope("prototype")
- @Value("${musicPlayer.name}"), for application.xml <context:property-placeholder location="classpath:
  player.properties"/>
- @PostConstructor marks init-method
- @PreDestroy marks destroy-method
- @PostConstruct and @PreDestroy in Java 9+ require
- destroy-method won't appear if you don't use context.close()

``` 
<dependency>
    <groupId>javax.annotation</groupId>
    <artifactId>javax.annotation-api</artifactId>
    <version>1.3.2</version>
</dependency>
```

### Notes for [Lesson 13](https://youtu.be/stuAmyyootQ)

- We can config app with XML, Java+XML, only Java
- When we config app only with Java we use @Configuration public class ConfigClass instead of application.xml
- Clear @Configuration class is equal to clear application.xml (with xmlns)
- All tags are replaced with Annotations: <context:component:scan base-package=""/> -> @ComponentScan("")
- Manual <bean/> creation can be replaced with manual @Bean **in** @Configuration class but @Component is more handy to
  use
- ClassPathXmlApplicationContext -> AnnotationConfigApplicationContext
- DI with manual beans creation:

```
@Configuration
public class SpringConfig {
  @Bean
  public ClassicalMusic musicBean() {
        return new ClassicalMusic();
    }
    
  @Bean
  public MusicPlayer musicPlayer() {
        return new MusicPlayer(musicBean());
    }
}
```

- There musicPlayer and musicBean are also ID's of beans
- MusicPlayer(musicBean()) is DI of musicBean into MusicPlayer
- Since the default scope is singleton musicBean is created only once
- <context:property-placeholder location="classpath"> -> @PropertySource("classpath:")