#!/bin/bash

export SPARK_MAJOR_VERSION=2;

spark-submit spark-count-assembly-1.0.jar \
    --tabela "p_desenvolvimento_db.crm_flat_crm_parquet_2" \
    --filterbyfilter 1 \
    "0" "DS_PRDT IN ('PF_CONTROLE')" \
    "1" "FL_PRIOR_XSELL_1 IN ('XSELL')" \
    "2" "CAST( substr(ID_COBERTURA, 4, 1) AS FLOAT) >= 1" \
    "3" "CAST( substr(ID_DISP, 4, 1) AS FLOAT) >= 1" \
    "4" "ELEG_OUTBOUND IN ('SIM')" \
    "5" "FL_FUNCIONARIO IN ('NÃO')" \
    "6" "FL_INADIMPLENCIA_CPF IN ('NÃO')" \
    "7" "FL_CNVGNT_FIXA_FULL IN ('NÃO')" \
    "8" "ESTDO_LNHA IN ('ATIVO')" \
    "9" "UF_ENDR IN ('SP')" \
    "10" "CAST( substr(FL_LNHA_UNICA_DCTO, 1, 1) AS FLOAT) >= 1" \
    "11" "CAST( substr(FL_PSSE_FIXA_BIN, 1, 1) +  substr(FL_PSSE_FIXA_BIN, 3, 1) +  substr(FL_PSSE_FIXA_BIN, 4, 1) +  substr(FL_PSSE_FIXA_BIN, 6, 1) +  substr(FL_PSSE_FIXA_BIN, 7, 1) +  substr(FL_PSSE_FIXA_BIN, 8, 1) +  substr(FL_PSSE_FIXA_BIN, 9, 1) +  substr(FL_PSSE_FIXA_BIN, 10, 1) +  substr(FL_PSSE_FIXA_BIN, 11, 1) AS FLOAT) = 0" \
    "12" "CAST( substr(FL_ABORD_DMC_BIN, 1, 1) AS FLOAT) = 0"
