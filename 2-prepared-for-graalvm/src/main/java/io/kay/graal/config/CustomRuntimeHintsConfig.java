package io.kay.graal.config;

import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

// native image: 3. step
@Configuration
@ImportRuntimeHints(CustomRuntimeHintsConfig.class)
public class CustomRuntimeHintsConfig implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        hints.resources().registerPattern("db/**");
        // .registerPattern("**") <-- NEVER do this

        // prevents ClassNotFoundException & MethodNotFoundException
        hints.reflection().registerType(
            com.zaxxer.hikari.HikariConfig.class,
            MemberCategory.INTROSPECT_DECLARED_CONSTRUCTORS,
            MemberCategory.INTROSPECT_DECLARED_METHODS
        );
        // alternatively: look into the resources folder META-INF/native-image/<group>/hints
    }

    private void unusedMethod(String name) {
        // does nothing
    }
}
