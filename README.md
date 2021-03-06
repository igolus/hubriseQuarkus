# HubRise connector Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

This project ease the integration of a POS System with [HubRise](https://www.hubrise.com/) system.

## Need support for implementation

You want to integrate Hubrise with your POS, I can help you to achieve the integration you can contact me 

on [linkedIn](https://www.linkedin.com/in/guillaume-rousseau-582a3867/) or by email: igolus@gmail.com

## Connection with hubrise

![](https://raw.githubusercontent.com/igolus/hubriseQuarkus/master/images/sequence1.jpg?token=GHSAT0AAAAAABTM2OD5WOFC4AKIUCBWX4FIYUHN3BA)



## Insert order in the POS system

![](https://raw.githubusercontent.com/igolus/hubriseQuarkus/master/images/sequence2.jpg?token=GHSAT0AAAAAABTM2OD5XCWWH7SYLBWNAC7WYUHN73Q)

## Building the application

```shell script
mvn clean install
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
cd hubriseQuarkus
mvn quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Register HubRise callBack

Use local tunnel: https://theboroer.github.io/localtunnel-www/

 to expose your server on the net:

```shell script
lt -p 8080
```

The browse to your exposed service ex:

https://witty-frog-31.loca.lt/connectHubrisePage

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/rest-json-quickstart-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

