# What 

This repository contains a POC that demonstrates how to deploy a web application from an arbitrary set of modules. 

A custom MonolithWebAppClassLoader makes this possible via loading classes from monolith locations. 

These locations can be either hardcoded or discovered by parsing the pom file that comprise the web app.

# Why

The approach allows deploying from scattered classes directories or jar files without having to assemble them into a war file.

# Does it reload classes

Yes, I have verified this by changing and compiling MyServlet class from webapp module

# WebApp module
Although this is structured as a web app it is merely for making it look like one. It never gets built as a war file; the packaging it uses is `jar` 

# How to run

Checkout repository into $USER_HOME/projects/tomcat-monolith-loader-test

Install Apache Tomcat into $USER_HOME/appservers/apache-tomcat-8.5.78

# Modules

## custom-class-loader 

The module contains customizations of Tomcat classes that allow loading of resources. The module should be built into $TOMCAT_HOME/lib/

## webapp

The module contains an actual web-app with a servlet, however the web-app never gets built as a war or deployed to a tomcat. 

Tomcat service is configured to deploy from the webapp content directly. It does find the WEB-INF/web.xml and index.html but not the servlet. 

The servlet is discovered using customized Monolith aware customizations from custom-class-loader module

# How does Tomcat know to load customized classes

Upon loading of the context from webapp/src/main/webapp location it will find META-INF/context.xml which configures customizations

# Other changes to Tomcat

add ConsoleHandler to the key below in $TOMCAT_HOME/conf/logging.properties

```
org.apache.catalina.core.ContainerBase.[Catalina].[localhost].handlers = 2localhost.org.apache.juli.AsyncFileHandler,java.util.logging.ConsoleHandler
```



