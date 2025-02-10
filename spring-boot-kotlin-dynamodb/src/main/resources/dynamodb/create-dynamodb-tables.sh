#!/bin/bash

aws dynamodb create-table \
    --table-name Items \
    --attribute-definitions AttributeName=id,AttributeType=S \
    --key-schema AttributeName=id,KeyType=HASH \
    --billing-mode PAY_PER_REQUEST \
    --endpoint-url http://localhost:8000

echo "DynamoDB table 'Items' created successfully!"