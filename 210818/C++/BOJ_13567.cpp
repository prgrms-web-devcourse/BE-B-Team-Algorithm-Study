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

int M,N;
int dy[4] = {1,0,-1,0};
int dx[4] = {0,1,0,-1};
int cy=0, cx=0, cdir=1;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>M>>N;
    string str;
    int k;
    while(N--){
        cin>>str;
        cin>>k;
        if(str=="MOVE"){
            cy += k * dy[cdir];
            cx += k * dx[cdir];
        } else {
            if(k==0) cdir = (cdir+3)%4;
            else cdir = (cdir+1)%4;
        }
        
        if(cy<0 || cx<0 || cy>M || cx>M) {
            cout<<-1;
            return 0;
        }
    }
    
    cout<<cx<<' '<<cy;
}