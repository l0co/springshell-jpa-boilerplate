#!/bin/bash

gradle build -x test
java -jar build/libs/`ls build/libs | grep jar | grep -v plain`
