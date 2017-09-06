# Dependency Injection
Dependency Injection (https://en.wikipedia.org/wiki/Dependency_injection) is used to achieve
Dependency inversion principle (https://en.wikipedia.org/wiki/Dependency_inversion_principle)
and Inversion of control (https://en.wikipedia.org/wiki/Inversion_of_control ,
 http://martinfowler.com/bliki/InversionOfControl.html )

## Dependency Inversion Principle

High level modules should not depend upon low level modules. Both should depend upon abstractions

Abstractions should not depend upon details. Details should depend upon abstractions

## Inversion of Control
“Don’t call us, we’ll call you”

[Extracted from https://en.wikipedia.org/wiki/Inversion_of_control] 
In traditional programming, the flow of the business logic is determined by objects that are statically bound to one another. With inversion of control, the flow depends on the object graph that is built up during program execution. Such a dynamic flow is made possible by object interactions that are defined through abstractions. This run-time binding is achieved by mechanisms such as dependency injection or a service locator. In IoC, the code could also be linked statically during compilation, but finding the code to execute by reading its description from external configuration instead of with a direct reference in the code itself.


## Example of Dependency Injection
Let’s say we have a Client that needs to use a Service. Without dependency injection code could be something like this:

```java
// An example without dependency injection
public class Client {
    // Internal reference to the service used by this client
    private ServiceExample service;

    // Constructor
    Client() {
        // Specify a specific implementation in the constructor instead of using dependency injection
        service = new ServiceExample();
    }

    // Method within this client that uses the services
    public String greet() {
        return "Hello " + service.getName();
    }
}
```

Note that the Client creates a new ServiceExample in its constructor method which poses the following programming flaws:
* The Client depends upon a concrete class
* The Client is not flexible, if it needs another kind of Service the Client code should be modified
* The Client is tightly coupled with ServiceExample. If the Service is modified the Client may be  broken

### Three types of dependency injection
There are at least three ways an object can receive a reference to an external module:
* Constructor injection: the dependencies are provided through a class constructor.
* Setter injection: the client exposes a setter method that the injector uses to inject the dependency.
* Interface injection: the dependency provides an injector method that will inject the dependency into any client passed to it. Clients must implement an interface that exposes a setter method that accepts the dependency.

#### Constructor injection
This method requires the client to provide a parameter in a constructor for the dependency.

```java
// Constructor
Client(Service service) {
    // Save the reference to the passed-in service inside this client
    this.service = service;
}
```

#### Setter injection
This method requires the client to provide a setter method for the dependency.

```java
// Setter method
public void setService(Service service) {
    // Save the reference to the passed-in service inside this client
    this.service = service;
}
```

#### Interface injection
This is simply the client publishing a role interface to the setter methods of the client's dependencies. It can be used to establish how the injector should talk to the client when injecting dependencies.

```Java
// Service setter interface.
public interface ServiceSetter {
    public void setService(Service service);
}

// Client class
public class Client implements ServiceSetter {
    // Internal reference to the service used by this client.
    private Service service;

    // Set the service that this client is to use.
    @Override
    public void setService(Service service) {
        this.service = service;
    }
}
```

* Construction injection is preferred when all dependencies can be build before hand because one can ensure that the Client object is in a correct state when it is used.

* Setter injection gives a lot of flexibility to the Client because the Service can be changed in any moment during the execution. The drawback is that the Client may be used before the dependency is injected.

# Dependency Injection in Spring
We have three ways of indicating/configuring the dependency injection:
* With XML files: this tends to be an old-fashined way of working with Spring so we aren't going to use it in this semester
* With java configuration: is the most explicit way. The advantage is its explicitness and that all injection configurations are centralized in one or few files
* With implicit bean discovery and automatic wiring: uses the whole power of Spring machinery. The main drawbacks are its implicitness (sometimes it is hard to know what's going on) and that some Spring annotations are scattered all over the "domain" java files.

In this repository you'll find an example inspired from the one in the book Spring in Action. There are three branches:
* master: corresponds to a first example with java configuration where the name of the beans methods are used
* javaConfig: illustrates how to use the bean names for injection
* AutomaticWiring: uses the implicit bean discovery

The example basically consists of Knights that can embrace in different types of Quests wich are injected to them. There are two kinds of knight (BraveKnight and DamselRescuingKnight) and two kind of Quests (SlayDragonQuest and RescueDamselQuest). The first kind of knight uses the first kind of quest and the second kind of knight the second kind of quest.

* Master: The configuration file defines two knights of the type BraveKnight and one of DamselRescuingKnight, and one quest of type SlayDragonQuest. Note that the DamselRescuingKnight is creating its own quest in the contruction method, that is, it is not using the dependency injection. See also that the other two knigths in the configuration file are calling directly the quest() method to inject the desired quest.

* javaConfig: Here the configuration file defines the same knights but two different quest (one for each type of quest). Observe also that the DamselRescuingKnight is now using the dependency injection. The main difference with the former brach is that the injection is done by the name of the definied beans rather than calling the defining methods.

* automaticWiring: Here the configuration file only indicates where the Spring must scan to look for the beans that should create. In the package domain (the one that is scanned) contains classes that are noted as @Component indicating that an object of the classes must be created (the beans). Note that knights are injected the quest by means of the @Autowired anotation.

See that in the last case only one object of each class is created. So we cannot have two differents knights of the same type as we had in the first two branches.

## Beans Lifecycle

Spring is in charge of creating and destroing all beans as instructed by programmers through the different configuration files. The lifecycle of a bean rougthy speaking consists of a phase creation, use and destruction. The creation phase can be divided in discovery, object creation, setting attributes and initializing. The phase of destruction consists on a method for disposing resources. These phases are done through callback methods (called by the Spring framework) that can be customized by the programmer. However it is not usually necessary to do so.

Also there is a phase of destroing 

![alt text](https://github.com/LabInternetPub/DependencyInjection/blob/master/img/Spring-bean-life-cycle.png "Bean lifecycle")

Once the beans are created they "live" in an ApplicationContext where they can be found and used. There are diffent scopes for the beans, most of which are only available in a web application:
* Singleton: the default. A single instance object is created for each definition class
* Prototype: there may be several instance objects for a given class
* Request, Session, GlobalSession, Application, WebSocket: correspond to web related scopes that we'll see during the course
