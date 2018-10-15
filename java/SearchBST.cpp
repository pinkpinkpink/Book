#include<stdio.h>
#include<stdio.h>
#define Status
#define SearchBST


Status SearchBST(BiTree T,KeyType key,BiTreee f,BiTree &p){
    if(!T){
        p=f;return FALSE;           //查找不成功
        else if EQ(key.T > data.key)
        {
            p=T;return TRUE;        //查找成功
        }
        else if LT(key,T ->data.key) SearchBST(T->Child,key,T,p);           //在左子树中继续查找
        else SearchBST(T->Child,key,T,p);                                   //在右子树继续查找

    }

} 

Status InsertBST(BiTree &T,ElemType e){
    if(!SearchBST(T,e,key,NULL,p)){
        s = (BiTree)malloc(sizeof(BiTNode));
        s->data = e;
        s->1Child = s->rChild = NULL;
        if(!p) T = s;                                           //被插结点为新的根结点
        else if LT(e.key,p->data.key)p->lChild =s;              //被插结点*s为左孩子
        else p ->rchild=s;                                      //被插结点*s为右孩子
        
        return True;
    }
    else return false;

}

Status DeleteBST(BiTree &T,KeyType key){


}

typedef struct BTNode(){
    int keynum;
    struct BTNode * parent;
    keyType key[m+1];
    struct BTNode * ptr[m+1];
    Record *recptr[m+1];
}BTNode,*BTree;
typedef struct{
        BTNode *pt;
        int i;
        int tag;
}Result;

//B-树的查找操作的实现

Result SearchBTree(BTree T,KeyType K){
    p = T; q = NULL; found = FALSE; i = 0;
    while(p && !found){
        n = p->keynum; i = Search(p,K);
        if(i>0,&& p > Key[i]==k)found TRUE;
        else{ q = p,p = p->Ptri[i];}
        

    }
    if (found) return (p,i,1);
    else rerurn (q,i,0);

}