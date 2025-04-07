#!/bin/bash
echo "Start: Sleep 20 seconds"
sleep 30;

# Creando el topic 'created.transaction'
echo "Creando el topic  =>> 'ms.client.neg.client.event'"
kafka-topics --create --if-not-exists --zookeeper zookeeper:2181 --partitions 2 --replication-factor 1 --topic 'ms.client.neg.client.event'


# Comando de espera infinita para mantener el contenedor en ejecución
tail -f /dev/null