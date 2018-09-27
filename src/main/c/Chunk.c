#include<stdio.h>
#include<stdlib.h>
#define Status
#define CHUNKSIZE 80        //用户自定义块大小
/**串的块链存储表示*/
typedef struct Chunk{
    char ch[CHUNKSIZE];
    struct Chunk *next;
}Chunk;

typedef struct{
    Chunk *head,*tail;      //串的头指针和尾指针
    int curlen;             //串的当前长度
}LString;