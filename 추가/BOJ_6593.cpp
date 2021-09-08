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

int L,R,C;
int stz, sty, stx, edz, edy, edx;
char m[31][31][31]{};
int vi[31][31][31]{};
int dz[6] = {-1,1,0,0,0,0};
int dy[6] = {0,0,-1,1,0,0};
int dx[6] = {0,0,0,0,-1,1};

int bfs(){
    queue<dpi> q;
    q.push({{0,stz},{sty,stx}});
    vi[stz][sty][stx] = true;

    while(!q.empty()){
        int cd = q.front().xx.xx;
        int cz = q.front().xx.yy;
        int cy = q.front().yy.xx;
        int cx = q.front().yy.yy;
        q.pop();

        if(cz==edz && cy==edy && cx==edx) return cd;

        for(int i=0; i<6; i++){
            int nz = cz + dz[i];
            int ny = cy + dy[i];
            int nx = cx + dx[i];
            if(nz<0 || ny<0 || nx<0 || nz>=L || ny>=R || nx>=C) continue;
            if(vi[nz][ny][nx] || m[nz][ny][nx]=='#') continue;
            q.push({{cd+1,nz},{ny,nx}});
            vi[nz][ny][nx] = true;
        }
    }
    return -1;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    while(1){
        cin>>L>>R>>C;
        if(!L && !R && !C) break;

        memset(vi,0,sizeof(vi));
        string str;
        for(int i=0; i<L; i++){
            for(int j=0; j<R; j++){
                cin>>str;
                for(int k=0; k<C; k++){
                    m[i][j][k] = str[k];
                    if(m[i][j][k] == 'S') {
                        stz = i;
                        sty = j;
                        stx = k;
                    } else if(m[i][j][k] == 'E'){
                        edz = i;
                        edy = j;
                        edx = k;
                    }
                }
            }
        }

        int res = bfs();
        if(res==-1) cout<<"Trapped!"<<'\n';
        else cout<<"Escaped in "<<res<<" minute(s)."<<'\n';
        
    }
    

}
