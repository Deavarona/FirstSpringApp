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