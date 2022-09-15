#!/bin/sh

WILDFLY_USERNAME=wf-user
WILDFLY_PASSWORD=wf-password

./wildfly-26.1.2.Final/bin/add-user.sh ${WILDFLY_USERNAME} ${WILDFLY_PASSWORD}
