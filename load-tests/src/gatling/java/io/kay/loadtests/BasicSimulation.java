package io.kay.loadtests;

import io.gatling.javaapi.core.PopulationBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;

public class BasicSimulation extends Simulation {

    private static final Stream<TestApp> apps = IntStream.rangeClosed(1, 7).mapToObj(BasicSimulation::testApp);

    record TestApp(HttpProtocolBuilder http, ScenarioBuilder scenario) {
    }

    private static TestApp testApp(int number) {
        return new TestApp(
            http.baseUrl("http://localhost:80%d0".formatted(number)).acceptHeader("application/json"),
            scenario("Scenario App-%d".formatted(number)).exec(http("App %d".formatted(number)).get("/groups"))
        );
    }

    {
        setUp(apps
            .map(app -> app.scenario()
                .injectOpen(
                    nothingFor(3),
                    rampUsers(5_000).during(10)
                )
                .protocols(app.http()))
            .reduce(PopulationBuilder::andThen)
            .get()
        );
    }
}
