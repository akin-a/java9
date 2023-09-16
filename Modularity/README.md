# java9

## Modules

https://jenkov.com/tutorials/java/modules.html

1) Modules are a group of packages.
2) As part of Jigsaw project, all the Java Platform APIs have been split up into separate modules
3) The benefit of splitting all the Java APIs up into modules is that you can now specify what modules of the Java platform your application requires. 
   Knowing what Java Platform modules your application requires, Java can package up your application including only the Java Platform modules that your application actually uses.
4) Before Java 9 and the Java Platform Module System you would have had to package all of the Java Platform APIs with your Java application because there was no official way of reliably checking what classes your Java application used.
   Since the Java Platform APIs have grown quite large over the years, your application would get a large amount of Java classes included in its distribution, many of which your application would probably not be using.
5) The unused classes makes your application distributable bigger than it needs to be. With the Java Platform Module System you can now package your application with only the modules of the Java Platform APIs that your application is actuallly using.
   This will result in smaller application distributables.
   
   
## LEX Course

1) For over 20 years, Java has been extensively used for building complex enterprise applications.
2) Java 9 has brought the biggest overhaul of the Java platform itself.
3) The main reasons for bringing such a big change in Java platform are as follows:
       - The JDK/JRE is too big to easily maintain and to scale down for small devices.
         e.g. rt.jar which contains all the commonly used packages like java.lang, java.util, is of around 60 MB in size
	   - Weak encapsulation : here is no encapsulation above packages, not even by JARs. This also reduces security.