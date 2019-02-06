#!/usr/bin/env bash
mvn clean install
echo 'Building docker image...'
docker build -t gabrielkirsten/uol-customer-api .