
#include<stdio.h>
#include<stdlib.h>
#define Status

/**堆分配存储表示*/
typedef struct{
    char * ch;      //按串分配存储区
    int length;     //串长度
}HString;

Status StrInsert(HString &S,int pos,HString T){
    if(pos < 1 || pos > S.length + 1){
        return ERROR;
    }
    if(T.length){}

}

Status StrAssign(HString &T,char chars);

int StrLength(HString S);
//返回S的元素个数

int StrCompare(HString S,HString T);
//