#include<stdio.h>
#include<stdlib.h>
#define SString
#define int
#define next
#define Index
/**
 * 子串函数的定位函数Index(S,T,pos)
 * 串的模式匹配
 * */

int IndexPattern(SString S,SString T,int pos){
    i = pos; j=1;
    while(i < S[0] && j < T[0]){
        if(S[i] = T[j]){
            ++i;    ++j;        //继续比较后缀字符
        }
        else{
            i = i - j +2;   j = 1;      //指针后缀开始重新匹配
        }
        if(j > T[0]){
            return i - T[0];

        }
        else return 0;
    }


}

int Index KMP(SString S,SString T,int pos){
    //利用模式串T的next函数求T在主串S中第pos字符之后的位置
    i = pos; j = 1;
    while(i <= S[0] && j <= T[0]){
        if(j = 0 || S[i] = T[j]){ ++i;++j;}
        else j = next[j];           //模式串向右移动
        if(j > T[0]) return i - T[0];
        else return 0;

    }

}