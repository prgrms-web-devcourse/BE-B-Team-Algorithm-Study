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
map<int, string> m;

//이름 dd mm yyyy
int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    string str;
    int dd;
    int mm;
    int yyyy;

    for(int i=0; i<N; i++){
        cin>>str;
        cin>>dd>>mm>>yyyy;
        int res = yyyy*10000 + mm*100+ dd;
        m[res] = str;
    }

    cout<<(--m.end())->second<<'\n';
    cout<<m.begin()->second<<'\n';
    
}