# devtools
__Turn on auto reload in intellJ__
<!--check SO to make it work in intelliJ-->
File>Settings>Build, Execution, Deployment>Compiler> check 'Build project automatically'
</br>&</br>
File>Settings>Advanced Settings> check 'Allow auto-make to start even if developed application is currently running'


__pom.xml__
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

__application.properties__
```application.properties
# Automatic Reload
spring.devtools.livereload.enabled=false      #Set false to disable live reload

# Excluding Resources from Auto Reload
spring.devtools.restart.exclude=static/**,public/**

# Include/Exclude Additional Paths
spring.devtools.restart.additional-paths=script/**
spring.devtools.restart.additional-exclude=styles/**

```

<!-- references -->
<!-- https://howtodoinjava.com/spring-boot/developer-tools-module-tutorial/ -->
