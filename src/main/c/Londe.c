#include<stdio.h>
#include<stdlib.h>
#include<malloc/malloc.h>
#define OVERFLOW
#define LN LNode*
#define LEN sizeof(struct Lnode)
typedef int Status;
typedef int ElemType;

/**链表的结点的数据结构*/
typedef struct Lnode{

    ElemType num;
    struct Lnode *next;


}Lnode,*LinkList;   //*LinkList 定义链表头指针

/**链表初始构建函数*/
Status InitList(LinkList &L){
    L = (LinkList)malloc(sizeof(Lnode));
    if(L==0)
    exit(OVERFLOW);
    L->next = NULL;
    return OK;


}

Status DestroyList_L(LinkList &L){
    LinkList p;
    while(){
        Lnode 

    }

}