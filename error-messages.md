# Missing runtime hints

## Error

```text
Caused by: java.util.ServiceConfigurationError: 
    org.hibernate.bytecode.spi.BytecodeProvider: 
        Provider org.hibernate.bytecode.internal.bytebuddy.BytecodeProviderImpl not found
```

## Solution

Add class to runtime hints:

1. Either with @RegisterReflectionForBinding
2. Spring Boots RuntimeHintsRegistrar
3. reflect-config.json (suggested)

```json
[
  {
    "name": "org.hibernate.bytecode.internal.bytebuddy.BytecodeProviderImpl",
    "allDeclaredMethods": true,
    "allDeclaredFields": true,
    "allDeclaredConstructors": true
  }
]
```

# Included too much from resources folder

## Error

```text
Failed to resolve the class file version of the current VM: Java version must be positive: 0
```

# Solution

Avoid complete wildcard pattern:

```
hints.resources().registerPattern("**"); // <-- NEVER do this
```

# Missing resource hints of own resources

## Error

```text
org.springframework.beans.factory.BeanCreationException: 
    Error creating bean with name 'entityManagerFactory': 
        Failed to initialize dependency 'liquibase' of LoadTimeWeaverAware bean 'entityManagerFactory': 
        Error creating bean with name 'liquibase': liquibase.exception.CommandExecutionException: 
        liquibase.exception.ChangeLogParseException: The file /db/liquibase/master.xml was not found in the configured search path: ...
```

# Solution

Add needed resources in Spring Boot RuntimeHintsRegistrar:

```java
hints.resources().

registerPattern("db/**");
```

# Missing resource hints of library resources

## Error

```text
liquibase.parser.core.xml.XSDLookUpException: 
  Unable to resolve xml entity http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-4.31.xsd. 
  liquibase.secureParsing is set to 'true' which does not allow remote lookups. 
  Check for spelling or capitalization errors and missing extensions such as liquibase-commercial in your XSD definition.
```

## Solution

Add resource bundle in resource-config.json:

```json
{
  "resources": [
    {
      "pattern": "\\Qwww.liquibase.org/xml/ns/dbchangelog/dbchangelog-4.31.xsd\\E"
    },
    {
      "pattern": "\\Qwww.liquibase.org/xml/ns/dbchangelog/dbchangelog-ext.xsd\\E"
    }
  ]
}

```

# Missing runtime hints for jackson, usually solved by annotations

## Error

```text
com.fasterxml.jackson.databind.exc.InvalidDefinitionException: 
  Cannot construct instance of `io.kay.graal.clients.PushServerResponse`: 
    cannot deserialize from Object value (no delegate- or property-based Creator): 
    this appears to be a native image, 
    in which case you may need to configure reflection for the class that is to be deserialized
```

## Solution

Add `@RegisterReflectionForBinding` annotation

```java

@RegisterReflectionForBinding({PushServerRequest.class, PushServerResponse.class})
public PushServerResponse sendSms(String message) {
    return restClient.post()
        .uri("/send-sms")
        .body(new PushServerRequest(message))
        .retrieve()
        .body(PushServerResponse.class);
}
```

# NoSuchMethodException or ClassNotFoundException

## Error

```text
java.lang.NoSuchMethodException: io.kay.some.class.EventDto$Builder.clearId()
```

## Solution

Add hint for field/method/class either at

1. Spring Boot's RuntimeHintsRegistrar
2. reflect-config.json
