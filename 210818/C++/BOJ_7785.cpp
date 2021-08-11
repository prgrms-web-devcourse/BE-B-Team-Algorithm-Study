#include<bits/stdc++.h>
#define xx first
#define yy second
using namespace std;
using ll = long long;
using pii = pair<int,int>;
using pll = pair<ll,ll>;
using tpi = tuple<int,int,int>;
using tpl = tuple<ll,ll,ll>;
using dpi = pair<pii,pii>;
using dpl = pair<pll,pll>;
using pis = pair<int,string>;

const int INF = 0x3f3f3f3f;
const ll INF64 = 0x3f3f3f3f3f3f3f3f;

int N;
set<string, greater<string>> s;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    string a,b;
    for(int i=0; i<N; i++){
        cin>>a>>b;
        if(b=="enter"){
            s.insert(a);
        } else {
            s.erase(a);
        }
    }
    
    for(auto val : s) cout<<val<<'\n';
}