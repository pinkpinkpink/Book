#include<stdio.h>
#include<stdlib.h>
#define String
/**定位函数*/
int Index(String S,String T,int pos){
    if(pos>0){
        n = StrLength(S); m = StrLength(T); i = pos;
        while(i < n + m -1){
            /**SubString求子串SubString(& Sub,S,pos,len)*/
            SubString(Sub,S,i,m);
            if(StrCompare(sub,T)!=0) ++i;
            else return i;

        }
        return 0;
    }

}

Status SubString(SString,&Sub,SString,int pos,int len){
    if(pos < 1 || pos > S[0] || len < 0 || len > S[0] -pos +1){
        return Error;
        Sub[1...len] = S[pos...pos+len-1];
        sub[0] = len;
        return OK;
    }

}