## Micronaut 3.8.3 Documentation

- [User Guide](https://docs.micronaut.io/3.8.3/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.8.3/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.8.3/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Handler

[AWS Lambda Handler](https://docs.aws.amazon.com/lambda/latest/dg/java-handler.html)

Handler: io.micronaut.function.aws.proxy.MicronautLambdaHandler


- [Jib Gradle Plugin](https://plugins.gradle.org/plugin/com.google.cloud.tools.jib)
## Push GraalVM Native Image To Docker Registry Workflow

Workflow file: [`.github/workflows/graalvm.yml`](.github/workflows/graalvm.yml)

### Workflow description
For pushes to the `master` branch, the workflow will:
1. Setup the build environment with respect to the selected java/graalvm version.
2. Login to docker registry based on provided configuration.
3. Build, tag and push Docker image with Micronaut application to the Docker container image.

### Dependencies on other GitHub Actions
- [Docker login](`https://github.com/docker/login-action`)(`docker/login`)
- [Setup GraalVM](`https://github.com/DeLaGuardo/setup-graalvm`)(`DeLaGuardo/setup-graalvm`)

### Setup
Add the following GitHub secrets:

| Name | Description |
| ---- | ----------- |
| DOCKER_USERNAME | Username for Docker registry authentication. |
| DOCKER_PASSWORD | Docker registry password. |
| DOCKER_REPOSITORY_PATH | Path to the docker image repository inside the registry, e.g. for the image `foo/bar/micronaut:0.1` it is `foo/bar`. |
| DOCKER_REGISTRY_URL | Docker registry url. |
#### Configuration examples
Specifics on how to configure public cloud docker registries like DockerHub, Google Container Registry (GCR), AWS Container Registry (ECR),
Oracle Cloud Infrastructure Registry (OCIR) and many more can be found in [docker/login-action](https://github.com/docker/login-action)
documentation.

#### DockerHub

- `DOCKER_USERNAME` - DockerHub username
- `DOCKER_PASSWORD` - DockerHub password or personal access token
- `DOCKER_REPOSITORY_PATH` - DockerHub organization or the username in case of personal registry
- `DOCKER_REGISTRY_URL` - No need to configure for DockerHub

> See [docker/login-action for DockerHub](https://github.com/docker/login-action#dockerhub)

#### Google Container Registry (GCR)
Create service account with permission to edit GCR or use predefined Storage Admin role.

- `DOCKER_USERNAME` - set exactly to `_json_key`
- `DOCKER_PASSWORD` - content of the service account json key file
- `DOCKER_REPOSITORY_PATH` - `<project-id>/foo`
- `DOCKER_REGISTRY_URL` - `gcr.io`

> See [docker/login-action for GCR](https://github.com/docker/login-action#google-container-registry-gcr)

#### AWS Elastic Container Registry (ECR)
Create IAM user with permission to push to ECR (or use AmazonEC2ContainerRegistryFullAccess role).

- `DOCKER_USERNAME` - access key ID
- `DOCKER_PASSWORD` - secret access key
- `DOCKER_REPOSITORY_PATH` - no need to set
- `DOCKER_REGISTRY_URL` - set to `<aws-account-number>.dkr.ecr.<region>.amazonaws.com`

> See [docker/login-action for ECR](https://github.com/docker/login-action#aws-elastic-container-registry-ecr)

#### Oracle Infrastructure Cloud Registry (OCIR)
[Create auth token](https://www.oracle.com/webfolder/technetwork/tutorials/obe/oci/registry/index.html#GetanAuthToken) for authentication.

- `DOCKER_USERNAME` - username in format `<tenancy>/<username>`
- `DOCKER_PASSWORD` - account auth token
- `DOCKER_REPOSITORY_PATH` - `<tenancy>/<registry>/foo`
- `DOCKER_REGISTRY_URL` - set to `<region>.ocir.io`

> See [docker/login-action for OCIR](https://github.com/docker/login-action#oci-oracle-cloud-infrastructure-registry-ocir)


## Push To Docker Registry Workflow

Workflow file: [`.github/workflows/gradle.yml`](.github/workflows/gradle.yml)

### Workflow description
For pushes to the `master` branch, the workflow will:
1. Setup the build environment with respect to the selected java/graalvm version.
2. Login to docker registry based on provided configuration.
3. Build, tag and push Docker image with Micronaut application to the Docker container image.

### Dependencies on other GitHub Actions
- [Docker login](`https://github.com/docker/login-action`)(`docker/login`)
- [Setup GraalVM](`https://github.com/DeLaGuardo/setup-graalvm`)(`DeLaGuardo/setup-graalvm`)

### Setup
Add the following GitHub secrets:

| Name | Description |
| ---- | ----------- |
| DOCKER_USERNAME | Username for Docker registry authentication. |
| DOCKER_PASSWORD | Docker registry password. |
| DOCKER_REPOSITORY_PATH | Path to the docker image repository inside the registry, e.g. for the image `foo/bar/micronaut:0.1` it is `foo/bar`. |
| DOCKER_REGISTRY_URL | Docker registry url. |
#### Configuration examples
Specifics on how to configure public cloud docker registries like DockerHub, Google Container Registry (GCR), AWS Container Registry (ECR),
Oracle Cloud Infrastructure Registry (OCIR) and many more can be found in [docker/login-action](https://github.com/docker/login-action)
documentation.

#### DockerHub

- `DOCKER_USERNAME` - DockerHub username
- `DOCKER_PASSWORD` - DockerHub password or personal access token
- `DOCKER_REPOSITORY_PATH` - DockerHub organization or the username in case of personal registry
- `DOCKER_REGISTRY_URL` - No need to configure for DockerHub

> See [docker/login-action for DockerHub](https://github.com/docker/login-action#dockerhub)

#### Google Container Registry (GCR)
Create service account with permission to edit GCR or use predefined Storage Admin role.

- `DOCKER_USERNAME` - set exactly to `_json_key`
- `DOCKER_PASSWORD` - content of the service account json key file
- `DOCKER_REPOSITORY_PATH` - `<project-id>/foo`
- `DOCKER_REGISTRY_URL` - `gcr.io`

> See [docker/login-action for GCR](https://github.com/docker/login-action#google-container-registry-gcr)

#### AWS Elastic Container Registry (ECR)
Create IAM user with permission to push to ECR (or use AmazonEC2ContainerRegistryFullAccess role).

- `DOCKER_USERNAME` - access key ID
- `DOCKER_PASSWORD` - secret access key
- `DOCKER_REPOSITORY_PATH` - no need to set
- `DOCKER_REGISTRY_URL` - set to `<aws-account-number>.dkr.ecr.<region>.amazonaws.com`

> See [docker/login-action for ECR](https://github.com/docker/login-action#aws-elastic-container-registry-ecr)

#### Oracle Infrastructure Cloud Registry (OCIR)
[Create auth token](https://www.oracle.com/webfolder/technetwork/tutorials/obe/oci/registry/index.html#GetanAuthToken) for authentication.

- `DOCKER_USERNAME` - username in format `<tenancy>/<username>`
- `DOCKER_PASSWORD` - account auth token
- `DOCKER_REPOSITORY_PATH` - `<tenancy>/<registry>/foo`
- `DOCKER_REGISTRY_URL` - set to `<region>.ocir.io`

> See [docker/login-action for OCIR](https://github.com/docker/login-action#oci-oracle-cloud-infrastructure-registry-ocir)


- [Shadow Gradle Plugin](https://plugins.gradle.org/plugin/com.github.johnrengelman.shadow)
## Feature graphql documentation

- [Micronaut GraphQL documentation](https://micronaut-projects.github.io/micronaut-graphql/latest/guide/index.html)


## Feature jax-rs-security documentation

- [Micronaut JAX-RS Micronaut Security support documentation](https://micronaut-projects.github.io/micronaut-jaxrs/latest/guide/index.html)


## Feature oci-devops-build-ci documentation

- [https://docs.oracle.com/en-us/iaas/Content/devops/using/build_specs.htm](https://docs.oracle.com/en-us/iaas/Content/devops/using/build_specs.htm)


## Feature object-storage-aws documentation

- [Micronaut Object Storage - AWS documentation](https://micronaut-projects.github.io/micronaut-object-storage/latest/guide/)

- [https://aws.amazon.com/s3/](https://aws.amazon.com/s3/)


## Feature rss documentation

- [Micronaut RSS Feed documentation](https://micronaut-projects.github.io/micronaut-rss/latest/guide/index.html#whatsNew)


## Feature agorapulse-micronaut-worker documentation

- [https://agorapulse.github.io/micronaut-worker/](https://agorapulse.github.io/micronaut-worker/)


## Feature multi-tenancy documentation

- [Micronaut Multitenancy documentation](https://docs.micronaut.io/latest/guide/index.html#multitenancy)


## Feature coherence-session documentation

- [Micronaut Coherence HTTP Session Store documentation](https://micronaut-projects.github.io/micronaut-coherence/latest/guide/#coherenceHttpSessions)

- [https://coherence.java.net/](https://coherence.java.net/)


## Feature tracing-opentelemetry-exporter-jaeger documentation

- [Micronaut OpenTelemetry Exporter Jaeger documentation](http://localhost/micronaut-tracing/guide/index.html#opentelemetry)

- [https://opentelemetry.io](https://opentelemetry.io)


## Feature kubernetes-rxjava2-client documentation

- [Micronaut Kubernetes RxJava2 Client documentation](https://micronaut-projects.github.io/micronaut-kubernetes/latest/guide/#kubernetes-client)

- [https://github.com/kubernetes-client/java/wiki](https://github.com/kubernetes-client/java/wiki)


## Feature dekorate-kubernetes documentation

- [Micronaut Dekorate Kubernetes Support documentation](https://micronaut-projects.github.io/micronaut-kubernetes/latest/guide/index.html)

- [https://github.com/dekorateio/dekorate#kubernetes](https://github.com/dekorateio/dekorate#kubernetes)


## Feature elasticsearch documentation

- [Micronaut Elasticsearch Driver documentation](https://micronaut-projects.github.io/micronaut-elasticsearch/latest/guide/index.html)


## Feature email-amazon-ses documentation

- [Micronaut SES Email documentation](https://micronaut-projects.github.io/micronaut-email/latest/guide/index.html#ses)

- [https://aws.amazon.com/ses/](https://aws.amazon.com/ses/)


## Feature dekorate-halkyon documentation

- [Micronaut Dekorate Halkyon Support documentation](https://micronaut-projects.github.io/micronaut-kubernetes/latest/guide/index.html)

- [https://github.com/dekorateio/dekorate#halkyon-crd](https://github.com/dekorateio/dekorate#halkyon-crd)


## Feature github-workflow-ci documentation

- [https://docs.github.com/en/actions](https://docs.github.com/en/actions)


## Feature openapi documentation

- [Micronaut OpenAPI Support documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)

- [https://www.openapis.org](https://www.openapis.org)


## Feature microstream documentation

- [Micronaut MicroStream documentation](https://micronaut-projects.github.io/micronaut-microstream/latest/guide)

- [https://microstream.one/](https://microstream.one/)


## Feature aws-lambda documentation

- [Micronaut AWS Lambda Function documentation](https://micronaut-projects.github.io/micronaut-aws/latest/guide/index.html#lambda)


## Feature aws-v2-sdk documentation

- [Micronaut AWS SDK 2.x documentation](https://micronaut-projects.github.io/micronaut-aws/latest/guide/)

- [https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/welcome.html](https://docs.aws.amazon.com/sdk-for-java/v2/developer-guide/welcome.html)


## Feature problem-json documentation

- [Micronaut Problem JSON documentation](https://micronaut-projects.github.io/micronaut-problem-json/latest/guide/index.html)


## Feature assertj documentation

- [https://assertj.github.io/doc/](https://assertj.github.io/doc/)


## Feature knative documentation

- [Micronaut Knative Support documentation](https://micronaut-projects.github.io/micronaut-kubernetes/latest/guide/index.html)

- [https://knative.dev/](https://knative.dev/)


## Feature discovery-consul documentation

- [Micronaut Consul Service Discovery documentation](https://docs.micronaut.io/latest/guide/index.html#serviceDiscoveryConsul)

- [https://www.consul.io](https://www.consul.io)


## Feature security-oauth2 documentation

- [Micronaut Security OAuth 2.0 documentation](https://micronaut-projects.github.io/micronaut-security/latest/guide/index.html#oauth)


## Feature dynamodb documentation

- [Micronaut Amazon DynamoDB documentation](https://micronaut-projects.github.io/micronaut-aws/latest/guide/#dynamodb)

- [https://aws.amazon.com/dynamodb/](https://aws.amazon.com/dynamodb/)


## Feature agorapulse-micronaut-console documentation

- [https://agorapulse.github.io/micronaut-console/](https://agorapulse.github.io/micronaut-console/)


## Feature kubernetes-informer documentation

- [Micronaut Kubernetes Informer Support documentation](https://micronaut-projects.github.io/micronaut-kubernetes/latest/guide/#kubernetes-informer)

- [https://github.com/kubernetes-client/java/wiki](https://github.com/kubernetes-client/java/wiki)


## Feature coherence documentation

- [Micronaut Coherence documentation](https://micronaut-projects.github.io/micronaut-coherence/latest/guide/)

- [https://coherence.java.net/](https://coherence.java.net/)


## Feature github-workflow-graal-docker-registry documentation

- [https://docs.github.com/en/free-pro-team@latest/actions](https://docs.github.com/en/free-pro-team@latest/actions)


## Feature config-kubernetes documentation

- [Micronaut Kubernetes Distributed Configuration documentation](https://micronaut-projects.github.io/micronaut-kubernetes/latest/guide/#config-client)


## Feature mqtt documentation

- [Micronaut MQTT v5 Messaging documentation](https://micronaut-projects.github.io/micronaut-mqtt/latest/guide/index.html)


## Feature agorapulse-micronaut-permissions documentation

- [https://agorapulse.github.io/micronaut-permissions/](https://agorapulse.github.io/micronaut-permissions/)


## Feature dekorate-servicecatalog documentation

- [Micronaut Dekorate Service Catalog Support documentation](https://micronaut-projects.github.io/micronaut-kubernetes/latest/guide/index.html)

- [https://github.com/dekorateio/dekorate#service-catalog](https://github.com/dekorateio/dekorate#service-catalog)


## Feature hibernate-validator documentation

- [Micronaut Hibernate Validator documentation](https://micronaut-projects.github.io/micronaut-hibernate-validator/latest/guide/index.html)


## Feature jms-sqs documentation

- [Micronaut AWS SQS JMS Messaging documentation](https://micronaut-projects.github.io/micronaut-jms/snapshot/guide/index.html)


## Feature awaitility documentation

- [https://github.com/awaitility/awaitility](https://github.com/awaitility/awaitility)


## Feature agorapulse-gru-http documentation

- [https://agorapulse.github.io/gru/](https://agorapulse.github.io/gru/)


## Feature microstream-rest documentation

- [Micronaut MicroStream REST documentation](https://micronaut-projects.github.io/micronaut-microstream/latest/guide/#rest)

- [https://docs.microstream.one/manual/storage/rest-interface/index.html](https://docs.microstream.one/manual/storage/rest-interface/index.html)


## Feature jackson-xml documentation

- [Micronaut Jackson XML serialization/deserialization documentation](https://micronaut-projects.github.io/micronaut-jackson-xml/latest/guide/index.html)

- [https://github.com/FasterXML/jackson-dataformat-xml](https://github.com/FasterXML/jackson-dataformat-xml)


## Feature kubernetes-reactor-client documentation

- [Micronaut Kubernetes Reactor Client documentation](https://micronaut-projects.github.io/micronaut-kubernetes/latest/guide/#kubernetes-client)

- [https://github.com/kubernetes-client/java/wiki](https://github.com/kubernetes-client/java/wiki)


## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)


## Feature mqttv3 documentation

- [Micronaut MQTT v3 Messaging documentation](https://micronaut-projects.github.io/micronaut-mqtt/latest/guide/index.html)


## Feature netflix-hystrix documentation

- [Micronaut Netflix Hystrix documentation](https://docs.micronaut.io/latest/guide/index.html#netflixHystrix)


## Feature tracing-opentelemetry-http documentation

- [Micronaut OpenTelemetry HTTP documentation](http://localhost/micronaut-tracing/guide/index.html#opentelemetry)


## Feature coherence-data documentation

- [Micronaut Coherence Data documentation](https://micronaut-projects.github.io/micronaut-coherence/latest/guide/#repository)

- [https://coherence.java.net/](https://coherence.java.net/)


## Feature amazon-api-gateway documentation

- [Micronaut Amazon API Gateway REST API documentation](https://micronaut-projects.github.io/micronaut-aws/latest/guide/index.html#amazonApiGateway)

- [https://docs.aws.amazon.com/apigateway/](https://docs.aws.amazon.com/apigateway/)


## Feature dekorate-jaeger documentation

- [Micronaut Dekorate Jaeger Support documentation](https://micronaut-projects.github.io/micronaut-kubernetes/latest/guide/index.html)

- [https://github.com/dekorateio/dekorate#jaeger-annotations](https://github.com/dekorateio/dekorate#jaeger-annotations)


## Feature dekorate-prometheus documentation

- [Micronaut Dekorate Prometheus Support documentation](https://micronaut-projects.github.io/micronaut-kubernetes/latest/guide/index.html)

- [https://github.com/dekorateio/dekorate#prometheus-annotations](https://github.com/dekorateio/dekorate#prometheus-annotations)


## Feature management documentation

- [Micronaut Management documentation](https://docs.micronaut.io/latest/guide/index.html#management)


## Feature mongo-sync documentation

- [Micronaut MongoDB Synchronous Driver documentation](https://micronaut-projects.github.io/micronaut-mongodb/latest/guide/index.html)

- [https://docs.mongodb.com](https://docs.mongodb.com)


## Feature mockito documentation

- [https://site.mockito.org](https://site.mockito.org)


## Feature jmx documentation

- [Micronaut JMX endpoints documentation](https://micronaut-projects.github.io/micronaut-jmx/latest/guide/index.html)


## Feature aws-secrets-manager documentation

- [Micronaut AWS Secrets Manager documentation](https://micronaut-projects.github.io/micronaut-aws/latest/guide/#distributedconfigurationsecretsmanager)

- [https://aws.amazon.com/secrets-manager/](https://aws.amazon.com/secrets-manager/)


## Feature tracing-opentelemetry-zipkin documentation

- [Micronaut OpenTelemetry Zipkin documentation](https://micronaut-projects.github.io/micronaut-tracing/latest/guide/#opentelemetry)

- [https://opentelemetry.io](https://opentelemetry.io)


## Feature aws-codebuild-workflow-ci documentation

- [https://docs.aws.amazon.com/codebuild/latest/userguide](https://docs.aws.amazon.com/codebuild/latest/userguide)


## Feature micronaut-aot documentation

- [Micronaut AOT documentation](https://micronaut-projects.github.io/micronaut-aot/latest/guide/)


## Feature reactor documentation

- [Micronaut Reactor documentation](https://micronaut-projects.github.io/micronaut-reactor/snapshot/guide/index.html)


## Feature serialization-jsonp documentation

- [Micronaut Serialization JSON-B and JSON-P documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)


## Feature serialization-bson documentation

- [Micronaut Serialization BSON documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)


## Feature aws-parameter-store documentation

- [Micronaut AWS Parameter Store Distributed Configuration documentation](https://micronaut-projects.github.io/micronaut-aws/latest/guide/index.html#parametersStore)

- [https://docs.aws.amazon.com/systems-manager/latest/userguide/systems-manager-parameter-store.html](https://docs.aws.amazon.com/systems-manager/latest/userguide/systems-manager-parameter-store.html)


## Feature jax-rs documentation

- [Micronaut JAX-RS support documentation](https://micronaut-projects.github.io/micronaut-jaxrs/latest/guide/index.html)


## Feature cache-hazelcast documentation

- [Micronaut Hazelcast Cache documentation](https://micronaut-projects.github.io/micronaut-cache/latest/guide/index.html#hazelcast)

- [https://hazelcast.org/](https://hazelcast.org/)


## Feature camunda-external-worker documentation

- [https://github.com/camunda-community-hub/micronaut-camunda-external-client](https://github.com/camunda-community-hub/micronaut-camunda-external-client)


## Feature security documentation

- [Micronaut Security documentation](https://micronaut-projects.github.io/micronaut-security/latest/guide/index.html)


## Feature tracing-opentelemetry-exporter-zipkin documentation

- [Micronaut OpenTelemetry Exporter Zipkin documentation](http://localhost/micronaut-tracing/guide/index.html#opentelemetry)

- [https://opentelemetry.io](https://opentelemetry.io)


## Feature testcontainers documentation

- [https://www.testcontainers.org/](https://www.testcontainers.org/)


## Feature email-mailjet documentation

- [Micronaut Mailjet Email documentation](https://micronaut-projects.github.io/micronaut-email/latest/guide/index.html#mailjet)

- [https://www.mailjet.com](https://www.mailjet.com)


## Feature kafka documentation

- [Micronaut Kafka Messaging documentation](https://micronaut-projects.github.io/micronaut-kafka/latest/guide/index.html)


## Feature data-mongodb-reactive documentation

- [Micronaut Data MongoDB Reactive documentation](https://micronaut-projects.github.io/micronaut-data/latest/guide/#mongo)

- [https://docs.mongodb.com](https://docs.mongodb.com)


## Feature kafka-streams documentation

- [Micronaut Kafka Streams documentation](https://micronaut-projects.github.io/micronaut-kafka/latest/guide/index.html#kafkaStream)


## Feature config-consul documentation

- [Micronaut Consul Distributed Configuration documentation](https://docs.micronaut.io/latest/guide/index.html#distributedConfigurationConsul)

- [https://www.consul.io](https://www.consul.io)


## Feature security-session documentation

- [Micronaut Security Session documentation](https://micronaut-projects.github.io/micronaut-security/latest/guide/index.html#session)


## Feature security-jwt documentation

- [Micronaut Security JWT documentation](https://micronaut-projects.github.io/micronaut-security/latest/guide/index.html)


## Feature jms-activemq-artemis documentation

- [Micronaut ActiveMQ Artemis JMS Messaging documentation](https://micronaut-projects.github.io/micronaut-jms/snapshot/guide/index.html)


## Feature tracing-opentelemetry-xray documentation

- [Micronaut OpenTelemetry XRay Tracing documentation](https://micronaut-projects.github.io/micronaut-tracing/latest/guide/#opentelemetry)

- [https://docs.aws.amazon.com/xray/latest/devguide/aws-xray.html](https://docs.aws.amazon.com/xray/latest/devguide/aws-xray.html)


## Feature coherence-grpc-client documentation

- [Micronaut Coherence gRPC Client documentation](https://micronaut-projects.github.io/micronaut-coherence/latest/guide/#grpc)

- [https://coherence.java.net/](https://coherence.java.net/)


## Feature tracing-opentelemetry-jaeger documentation

- [Micronaut OpenTelemetry Jaeger documentation](https://micronaut-projects.github.io/micronaut-tracing/latest/guide/#opentelemetry)

- [https://opentelemetry.io](https://opentelemetry.io)


## Feature dekorate-knative documentation

- [Micronaut Dekorate Knative Support documentation](https://micronaut-projects.github.io/micronaut-kubernetes/latest/guide/index.html)

- [https://github.com/dekorateio/dekorate#knative](https://github.com/dekorateio/dekorate#knative)


## Feature localstack documentation

- [https://www.testcontainers.org/modules/localstack/](https://www.testcontainers.org/modules/localstack/)


## Feature email-sendgrid documentation

- [Micronaut Sendgrid Email documentation](https://micronaut-projects.github.io/micronaut-email/latest/guide/index.html#sendgrid)

- [https://docs.sendgrid.com/for-developers](https://docs.sendgrid.com/for-developers)


## Feature jms-core documentation

- [Micronaut JMS documentation](https://micronaut-projects.github.io/micronaut-jms/snapshot/guide/index.html)


## Feature kubernetes documentation

- [Micronaut Kubernetes Support documentation](https://micronaut-projects.github.io/micronaut-kubernetes/latest/guide/index.html)

- [https://kubernetes.io/docs/home/](https://kubernetes.io/docs/home/)


## Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)


## Feature jdbc-hikari documentation

- [Micronaut Hikari JDBC Connection Pool documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#jdbc)


## Feature rabbitmq documentation

- [Micronaut RabbitMQ Messaging documentation](https://micronaut-projects.github.io/micronaut-rabbitmq/latest/guide/index.html)


## Feature tracing-opentelemetry-annotations documentation

- [Micronaut OpenTelemetry Annotations documentation](https://micronaut-projects.github.io/micronaut-tracing/latest/guide/#opentelemetry)

- [https://opentelemetry.io](https://opentelemetry.io)


## Feature hibernate-jpa documentation

- [Micronaut Hibernate JPA documentation](https://micronaut-projects.github.io/micronaut-sql/latest/guide/index.html#hibernate)


## Feature gitlab-workflow-ci documentation

- [https://docs.gitlab.com/ee/ci/](https://docs.gitlab.com/ee/ci/)


## Feature tracing-opentelemetry-exporter-otlp documentation

- [Micronaut OpenTelemetry Exporter OTLP documentation](http://localhost/micronaut-tracing/guide/index.html#opentelemetry)

- [https://opentelemetry.io](https://opentelemetry.io)


## Feature swagger-ui documentation

- [Micronaut Swagger UI documentation](https://micronaut-projects.github.io/micronaut-openapi/latest/guide/index.html)

- [https://swagger.io/tools/swagger-ui/](https://swagger.io/tools/swagger-ui/)


## Feature coherence-distributed-configuration documentation

- [Micronaut Coherence Distributed Configuration documentation](https://micronaut-projects.github.io/micronaut-coherence/latest/guide/#distributedConfiguration)

- [https://coherence.java.net/](https://coherence.java.net/)


## Feature mongo-reactive documentation

- [Micronaut MongoDB Reactive Driver documentation](https://micronaut-projects.github.io/micronaut-mongodb/latest/guide/index.html)

- [https://docs.mongodb.com](https://docs.mongodb.com)


## Feature tracing-opentelemetry-exporter-logging documentation

- [Micronaut OpenTelemetry Exporter Logging documentation](http://localhost/micronaut-tracing/guide/index.html#opentelemetry)

- [https://opentelemetry.io](https://opentelemetry.io)


## Feature flyway documentation

- [Micronaut Flyway Database Migration documentation](https://micronaut-projects.github.io/micronaut-flyway/latest/guide/index.html)

- [https://flywaydb.org/](https://flywaydb.org/)


## Feature camunda-zeebe documentation

- [https://github.com/camunda-community-hub/micronaut-zeebe-client](https://github.com/camunda-community-hub/micronaut-zeebe-client)


## Feature camunda-platform7 documentation

- [https://github.com/camunda-community-hub/micronaut-camunda-bpm](https://github.com/camunda-community-hub/micronaut-camunda-bpm)


## Feature github-workflow-docker-registry documentation

- [https://docs.github.com/en/free-pro-team@latest/actions](https://docs.github.com/en/free-pro-team@latest/actions)


## Feature microstream-cache documentation

- [Micronaut MicroStream Cache documentation](https://micronaut-projects.github.io/micronaut-microstream/latest/guide/#cache)

- [https://docs.microstream.one/manual/cache/index.html](https://docs.microstream.one/manual/cache/index.html)


## Feature views-handlebars documentation

- [Micronaut Handlebars Views documentation](https://micronaut-projects.github.io/micronaut-views/latest/guide/index.html#handlebars)

- [https://jknack.github.io/handlebars.java/](https://jknack.github.io/handlebars.java/)


