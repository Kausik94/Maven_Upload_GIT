#!/bin/bash

psql \
    -X \
    -U postgres \
    -f ./db_schema_sql.sql \
    --echo-all \
    --set AUTOCOMMIT=off \
    --set ON_ERROR_STOP=on \
    
