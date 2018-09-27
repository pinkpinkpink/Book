#include<stdio.h>
#include<stdlib.h>
#define MaxBookList
#define MaxKeyList
#define MaxLineLen
#define MaxWorldNum
#define HString
#define LinkList
#define Status
typedef struct{
    char * item[];       //字符串数组
    int last;           //词表的长度
}WorldListType;       //词表类型(顺序表)

typedef int ElemType;   //链表数据类型为整形

typedef struct{
    HString key;        //关键字
    LinkList bookList;      //存放书号索引的链表
}IndexTermType;             //索引项

typedef struct{
    IndexTermType item[MaxkeyNum + 1];
    int last;
}IndexListType;            

//主要变量

char * buf;         //书目缓冲区
WorldListType wlType;


//基本操作

void InitIndexList(IndexListType indexlist);
//初始化操作

void Getline(FILE f);
//从文件f读入书目信息到缓冲区buffer

void ExtractKeyWorld(ElemType &bno);

void PutText(FILE g,IndexListType indexlist);
//生成索引表indexlist输出到文件g

void GetWorld(int i,HString wd);

void InsertNewKey(IndexListType &indexlist,int i,HString wd);

void InsertNewBook(IndexListType &indexlist,int i,int bno);

void main(){
    if(f = OpenFile("BookInfo.txt","r")){
            if(g = OpenFile("BookIndex.txt"),"w")
            InitIndexList(indexlist);
            //初始化索引表
            while(!feof(f)){
                Getline(f);
                ExtractKeyWorld(bno);

            }
            PutText(g,indexlist);
    }
}

/**索引表的插入*/
Status InsertIndexList(IndexListType & indexlist，int bno){
    for(i = 0; i <wdlist.last;++i){
        GetWorld(i,wd);
        j = Locate(indexlist,wd,b);
        if(!b) InsertNewKey(idexlist,j,wd);
        return (InsertBook(idexlist,j,bno));


    }

}