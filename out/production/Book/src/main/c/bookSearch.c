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
}WordListType;       //词表类型(顺序表)

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
WordListType wlType;


//基本操作

void InitIndexList(IndexListType indexlist);
//初始化操作

void Getline(FILE f);
//从文件f读入书目信息到缓冲区buffer

void ExtractKeyWord(ElemType &bno);

void PutText(FILE g,IndexListType indexlist);
//生成索引表indexlist输出到文件g

void GetWord(int i,HString &wd){
    p = *(wdlist.item + i);
    //取表中的第i个字符串
    StrAssign(wd,p);
    //生成关键字的字符串

}

void InsertNewKey(int i,StrType wd){
    for(j = indexlist.last -1; j >= i; --j){
        indexlist.item[j+1] == index.item[j];
        StrCopy(indexlist.item[i].key,wd);          //串赋值
        Initlist(Indexlist.item[i].bnolist);        //初始化书号索引表
        ++ idxlist.last;

    }

};

void InsertNewBook(IndexListType &indexlist,int i,int bno){
    if(!MakeNode(p,bno)) rerurn OVERFLOW;
    Appand(indexlist.item[i].bnolist,p);
    //插入新的书号索引
    return OK；
};

void main(){
    if(f = OpenFile("BookInfo.txt","r")){
            if(g = OpenFile("BookIndex.txt"),"w")
            InitIndexList(indexlist);
            //初始化索引表
            while(!feof(f)){
                Getline(f);
                ExtractKeyWord(bno);

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