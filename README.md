
포트사용 프로세스 종료
```
FOR /F "tokens=5 delims= " %P IN ('netstat -nao ^| findstr 127.0.0.1:8080 ^| findstr LISTENING') DO TaskKill.exe /F /PID %P
```


App Engine Java Application
Copyright (C) 2010-2012 Google Inc.

## Skeleton application for use with App Engine Java.

Requires [Apache Maven](http://maven.apache.org) 3.0 or greater, and JDK 6+ in order to run.

To build, run

    mvn package

Building will run the tests, but to explicitly run tests you can use the test target

    mvn test

To start the app, use the [App Engine Maven Plugin](http://code.google.com/p/appengine-maven-plugin/) that is already included in this demo.  Just run the command.

    mvn appengine:devserver

For further information, consult the [Java App Engine](https://developers.google.com/appengine/docs/java/overview) documentation.

To see all the available goals for the App Engine plugin, run

    mvn help:describe -Dplugin=appengine
