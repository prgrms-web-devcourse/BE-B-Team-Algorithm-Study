#include<bits/stdc++.h>
#define xx first
#define yy second
using namespace std;
using pii = pair<int,int>;

const int INF = 0x3f3f3f3f;

int N;
int m[11][11]{};
int dy[5] = {-1,1,0,0,0};
int dx[5] = {0,0,-1,1,0};

bool validate(pii a, pii b, pii c){
    set<pii> s;
    for(int i=0; i<5; i++){
        pii na = {a.xx + dy[i], a.yy + dx[i]};
        pii nb = {b.xx + dy[i], b.yy + dx[i]};
        pii nc = {c.xx + dy[i], c.yy + dx[i]};
        if(s.count(na)) return false;
        else s.insert(na);
        if(s.count(nb)) return false;
        else s.insert(nb);
        if(s.count(nc)) return false;
        else s.insert(nc);
    }
    return true;
}

int calCost(pii a, pii b, pii c){
    int sum = 0;
    for(int i=0; i<5; i++){
        sum += m[a.xx + dy[i]][a.yy + dx[i]];
        sum += m[b.xx + dy[i]][b.yy + dx[i]];
        sum += m[c.xx + dy[i]][c.yy + dx[i]];
    }
    return sum;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            cin>>m[i][j];
        }
    }

    int minc = INF;
    for(int a=0; a<N*N; a++){
        if(a/N==0 || a/N==N-1 || a%N==0 || a%N==N-1) continue;
        pii fa = {a/N,a%N};
        for(int b=a+1; b<N*N; b++){
            if(b/N==0 || b/N==N-1 || b%N==0 || b%N==N-1) continue;
            pii fb = {b/N,b%N};
            for(int c=b+1; c<N*N; c++){
                if(c/N==0 || c/N==N-1 || c%N==0 || c%N==N-1) continue;
                pii fc = {c/N,c%N};
                if(!validate(fa,fb,fc)) continue;
                int sum = calCost(fa,fb,fc);
                minc = min(sum, minc);
            }
        }
    }

    cout<<minc;
}
