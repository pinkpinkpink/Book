#include<stdio.h>
#include<stdlib.h>
#include<stdarg.h>
#define MAX_ARRAY_DIM 8
#define Status
#define ElemType
typedef struct{
    ElemType * base;
    int dim;
    int * bounds;
    int * constants;

}Array;

Status InitArray{Array &A,int dim,...};

Status DestroyArray(Array &A);

Status Value(Array A,ElemType &e,...);

Status Assign(Array A,ElemType &e,...);

//基本操作的算法描述

Status InitArray(Array &A,int dim,...){
    if(dim < 1 || dim >MAX_ARRAY_DIM) return ERROR;
    A.dim = dim;
    A.bounds = (int *)malloc(dim * sizeof(int));
    if(!A.bounds) exit(OVERFLOW);
    elemtotal = 1;
    va_start(ap,dim);
    for(i = 0; i < dim;++i){
        A.bounds[i] = va_arg(ap,int);
        if(A.bounds[i]<0) return UNDEREDFLOW;
        elemtotal * = A.bounds[i];

    }

}