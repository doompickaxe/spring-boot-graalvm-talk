# Spring Boot with GraalVM Talk

When Spring Boot 3 came out and announced that it supports GraalVM and native images
I was intrigued and wanted to try it out at work.
I got the approval of the CTO and experimented a little bit.
It did not take too long to work, but it has its upsides & downsides.

When I talked to friends or former colleagues none of those really used it successfully in production, which
gave me some motivation to share my experiences around this topic.
Hopefully more people at least try it and give it a shot.

Have a look at [my slides](slides/index.html) and the projects in this repo.

## modules

* 1-normal-spring-boot: A sample application that does not run on GraalVM to have a comparison to GraalVM native images
* 2-prepared-for-graalvm: The same application as in `1-normal-spring-boot` but adapted and running with GraalVM and
  compiling it to native images
* 4-spring-boot-4: Same as 2 but using Spring Boot 4
* 6-java25: Same as 2 but using Java 25
* 8-cloud-gateway: Using Spring Cloud Starter Gateway compiling to native images.
