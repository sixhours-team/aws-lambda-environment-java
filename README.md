# AWS Lambda Environment Java

This is a sample project showing the AWS Lambda configuration per environment.

Depending on the stage in which the lambda function is executing (`dev`, `stage`, `prod`), the configuration values 
for user's first & last name will be read, while the lambda function code remains unchanged. The environment in which 
the lambda function is executed is read from the lambda function environment variable. For this sample application, the 
lambda function environment variable with key `LAMBDA_ENVIRONMENT` and values `dev`, `stage` and `prod` has been defined.

## Build

To build and package the lambda function run following gradle command:

`./gradlew clean build`

The resulting *.zip* deployment package can be found in `build/distributions` directory of the project.

## Properties

Lambda configuration properties can be set in your `application.yml` file. Below is the full list of supported properties 
for the lambda function:

```.properties
environment: # lambda function environment (one of: dev, stage, prod)
user:
  firstName: # first name for given environment
  lastName: # last name for given environemnt
```

## Usage

Build the project and create the lambda function by uploading the *.zip* deployment package using the [AWS Management Console](https://aws.amazon.com/console/)
or the [AWS CLI](https://aws.amazon.com/cli/). Setup the lambda function [environment variable](http://docs.aws.amazon.com/lambda/latest/dg/env_variables.html) key-value pair. 
