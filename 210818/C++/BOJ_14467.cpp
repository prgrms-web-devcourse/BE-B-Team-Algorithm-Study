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
int m[11]{};

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    int a,b;
    memset(m,-1,sizeof(m));

    int res = 0;
    for(int i=0; i<N; i++){
        cin>>a>>b;
        if(m[a]==-1) m[a] = b;
        else {
            if(m[a]!=b) {
                res++;
                m[a] = b;
            }
        }
    }
    
    cout<<res;
}