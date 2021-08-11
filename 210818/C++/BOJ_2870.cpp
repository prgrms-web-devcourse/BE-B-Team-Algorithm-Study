#include<bits/stdc++.h>
using namespace std;

int N;
vector<string> v;

bool chkNum(char ch){
    if(ch>='0' && ch<='9') return true;
    else return false;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    string str;
    for(int i=0; i<N; i++){
        cin>>str;
        str += ".";
        int st = -1;
        for(int k=0; k<str.size(); k++){
            if(chkNum(str[k])){
                if(st==-1 && str[k]!='0') st = k;
            } else {
                if(k==0) continue;
                if(chkNum(str[k-1])){
                    if(st==-1) v.push_back("0");
                    else v.push_back(str.substr(st, k-st));
                    st = -1;
                }
            }
            
        }
    }
    
    sort(v.begin(), v.end(), [&](string a, string b) -> bool{
        if(a.size()==b.size()) return a<b;
        return a.size() < b.size();
    });

    for(auto val : v)
        cout<<val<<'\n';
    
}