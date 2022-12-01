## Spring Boot with Flyway, MySql and VCAP Services

This project demonstrates how one can be run a Spring Boot project locally and see the 
[Java CFEnv](https://github.com/pivotal-cf/java-cfenv) library do its magic in setting certain properties based on the 
existence of VCAP_SERVICES environment variable.  The source of this variable is located in the vcap_services.json file. 

Launch a MySql 5.7 instance via a terminal.
```bash
docker-compose up -d
```

In another terminal, set the necessary environment variables.

Activate the cloud profile.
```bash
export SPRING_PROFILES_ACTIVE=cloud
```

Set the VCAP_SERVICES enviroment variable.
```bash
export VCAP_SERVICES=$(cat vcap_services.json)
```

Now launch the application:
```bash
./gradlew bootRun
```
Navigate to the properties actuator endpoint:

http://localhost:8080/actuator/configprops

If you search for cf, you can see the properties set by the [Java CFEnv](https://github.com/pivotal-cf/java-cfenv) library.
You can also search the logs to see where the CfDataSourceEnvironmentPostProcessor and CfEnvironmentPostProcessor were 
activated.