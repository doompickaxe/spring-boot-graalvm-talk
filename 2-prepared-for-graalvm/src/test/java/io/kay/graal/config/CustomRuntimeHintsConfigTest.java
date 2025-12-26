package io.kay.graal.config;

import org.junit.jupiter.api.Test;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.predicate.RuntimeHintsPredicates;

import static org.assertj.core.api.Assertions.assertThat;

class CustomRuntimeHintsConfigTest {

    @Test
    void includesLiquibaseChangelog() {
        // given
        RuntimeHints hints = new RuntimeHints();

        // when
        new CustomRuntimeHintsConfig().registerHints(hints, getClass().getClassLoader());

        // then
        assertThat(RuntimeHintsPredicates.resource().forResource("db/liquibase/master.xml")).accepts(hints);
    }
}
