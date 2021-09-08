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

int N,M,cnt=0;
int m[101][101]{};
int vi[101][101]{};
int dy[4] = {-1,1,0,0};
int dx[4] = {0,0,-1,1};

void printm(){
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            cout<<m[i][j]<<' ';
        }
        cout<<'\n';
    }
    cout<<'\n';
}


int bfs(){
    memset(vi,0,sizeof(vi));

    queue<pii> q;
    q.push({0,0});
    vi[0][0] = true;

    while(!q.empty()){
        int cy = q.front().xx;
        int cx = q.front().yy;
        q.pop();

        for(int i=0; i<4; i++){
            int ny = cy + dy[i];
            int nx = cx + dx[i];
            if(ny<0 || nx<0 || ny>=N || nx>=M || vi[ny][nx]) continue;
            if(!m[ny][nx]) q.push({ny,nx});
            vi[ny][nx] = true;
        }
    }

    int ret = cnt;
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            if(m[i][j] && vi[i][j]) {m[i][j] = 0; cnt--;}
        }
    }

    return ret;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;

    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            cin>>m[i][j];
            if(m[i][j]) cnt++;
        }
    }

    for(int i=1; ; i++) {
        int ret = bfs();
        if(cnt==0) {
            cout<<i<<'\n';
            cout<<ret;
            break;
        }
    }
    
}


