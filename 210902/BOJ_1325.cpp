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
using psi = pair<string,int>;

const int INF = 0x3f3f3f3f;
const ll INF64 = 0x3f3f3f3f3f3f3f3f;

int N,M;
vector<int> adj[10001]{};
bool vi[10001]{};
vector<pii> arr;

int bfs(int st){
    memset(vi,0,sizeof(vi));
    queue<int> q;
    q.push(st);
    vi[st] = true;

    int ret = 1;
    while (!q.empty()) {
        int cn = q.front();
        q.pop();

        for(auto next : adj[cn]){
            if(vi[next]) continue;
            q.push(next);
            vi[next] = true;
            ret++;
        }
    }
    return ret;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    int a,b;
    for(int i=0; i<M; i++){
        cin>>a>>b;
        adj[b].push_back(a);
    }

    for(int i=1; i<=N; i++) arr.push_back({bfs(i), i});

    sort(arr.begin(), arr.end(), [&](pii a, pii b) -> bool{
        if(a.xx == b.xx) return a.yy < b.yy;
        return a.xx > b.xx;
    });

    int pre = -1;
    for(auto val : arr){
        if(pre!=-1 && pre!=val.xx) break;
        pre = val.xx;
        cout<<val.yy<<'\n';
    }

}