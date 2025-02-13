# Setup instructions 

This repository contains two Quarkus projects:

- sse-endpoint, which is a dummy server sending an SSE stream
- the root project, which calls the sse-endpoint server, transforms the object received in the stream, and returns the stream. This is what allows reproducing the issue.

To launch the two projects, here are the steps:

```
mvn clean install
mvn clean compile quarkus:dev

cd sse-endpoint
mvn clean install
mvn clean compile quarkus:dev
```

# Reproduction instructions

To replicate the memory leak, you need to execute the following request several times, waiting for the stream to end before launching another one:

```
curl --location 'http://localhost:7001/hello/stream'
```

