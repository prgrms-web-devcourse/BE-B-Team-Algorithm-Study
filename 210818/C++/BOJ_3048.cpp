#include<bits/stdc++.h>
using namespace std;
using pic = pair<int,char>;

int N,M,K;
vector<pic> v;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    string a,b;
    cin>>a>>b;
    cin>>K;
    reverse(a.begin(), a.end());

    int tmp=K;
    for(int i=N-1; i>=0; i--){
        v.push_back({i+tmp, a[i]});
        if(!tmp) continue;
        else tmp--;
    }
        
    tmp=K;
    for(int i=0; i<M; i++){
        v.push_back({i+N-tmp, b[i]});
        if(!tmp) continue;
        else tmp--;
    }
    
    sort(v.begin(), v.end());
    for(auto val : v) cout<<val.second;
    
}