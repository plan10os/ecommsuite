package com.ltmg;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.context.ApplicationContextBuilder;
import io.micronaut.context.ApplicationContextConfigurer;
import io.micronaut.context.annotation.ContextConfigurer;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import io.dekorate.kubernetes.annotation.KubernetesApplication;
import io.dekorate.knative.annotation.KnativeApplication;
import io.dekorate.kubernetes.annotation.Label;
import io.dekorate.kubernetes.annotation.Port;
import io.dekorate.kubernetes.annotation.Probe;
import io.dekorate.prometheus.annotation.EnableServiceMonitor;
import io.dekorate.halkyon.annotation.HalkyonComponent;

@OpenAPIDefinition(
    info = @Info(
            title = "ecommsuite",
            version = "0.0"
    )
)
@KubernetesApplication(
    name = "ecommsuite",
    labels = @Label(key = "app", value = "ecommsuite"),
    ports = @Port(name = "http", containerPort = 8080),
    livenessProbe = @Probe(httpActionPath = "/health/liveness", initialDelaySeconds = 5, timeoutSeconds = 3, failureThreshold = 10),
    readinessProbe = @Probe(httpActionPath = "/health/readiness", initialDelaySeconds = 5, timeoutSeconds = 3, failureThreshold = 10)
)
@KnativeApplication(
    name = "ecommsuite",
    labels = @Label(key = "app", value = "ecommsuite"),
    ports = @Port(name = "http", containerPort = 8080),
    livenessProbe = @Probe(httpActionPath = "/health/liveness", initialDelaySeconds = 5, timeoutSeconds = 3, failureThreshold = 10),
    readinessProbe = @Probe(httpActionPath = "/health/readiness", initialDelaySeconds = 5, timeoutSeconds = 3, failureThreshold = 10)
)
@EnableServiceMonitor(port = "http", path="/prometheus")
@HalkyonComponent(name = "ecommsuite")
public class Application {

    @ContextConfigurer
    public static class Configurer implements ApplicationContextConfigurer {
        @Override
        public void configure(@NonNull ApplicationContextBuilder builder) {
            builder.defaultEnvironments("dev");
        }
    }
    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}