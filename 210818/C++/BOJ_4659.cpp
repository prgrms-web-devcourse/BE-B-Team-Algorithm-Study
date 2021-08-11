#include<bits/stdc++.h>
using namespace std;

int N;

// 모음 포함 O
// 연속글자X But ee, oo 허용
// 3연속 자음 or 모음 X
bool chkMo(char ch){
    if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') return true;
    return false;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    string str;
    while(1){
        cin>>str;
        if(str=="end") break;

        bool res = true;
        bool mo = false;
        for(int i=0; i<str.size(); i++){
            if(chkMo(str[i])) mo = true;
            if(i<str.size()-1){
                if(str[i]==str[i+1]) {
                    if(str[i]=='e' || str[i]=='o');
                    else {
                        res = false;
                        break;
                    }
                }
            }
            if(i<str.size()-2){
                bool x = chkMo(str[i]);
                bool y = chkMo(str[i+1]);
                bool z = chkMo(str[i+2]);
                if((x && y && z) || (!x && !y && !z)){
                    res = false;
                    break;
                }
            }
        }
        
        if(res && mo)
            cout<<'<'<<str<<'>'<<" is acceptable."<<'\n';
        else
            cout<<'<'<<str<<'>'<<" is not acceptable."<<'\n';
    }
    
}