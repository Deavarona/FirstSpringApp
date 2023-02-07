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