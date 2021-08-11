#include<bits/stdc++.h>
using namespace std;

string getStr(double k){
    if(k>=90.0) return "A";
    else if(k>=80.0) return "B";
    else if(k>=70.0) return "C";
    else if(k>=50.0) return "D";
    else return "F";
}

double sum[11]{};
int maxSc[11]{};
int minSc[11]{};
string solution(vector<vector<int>> sc) {
    memset(minSc,0x3f,sizeof(minSc));
    for(int i=0; i<sc.size(); i++) {
        for(int j=0; j<sc.size(); j++){
            if(i==j) continue;
            sum[j] += sc[i][j];
            maxSc[j] = max(maxSc[j], sc[i][j]);
            minSc[j] = min(minSc[j], sc[i][j]);
        }
    }
    
    string ans = "";
    double sz = sc.size();
    for(int i=0; i<sc.size(); i++){
        if(sc[i][i]>maxSc[i] || sc[i][i]<minSc[i]){
            ans += getStr(sum[i]/(sz-1));
        } else {
            sum[i] += sc[i][i];
            ans += getStr(sum[i]/sz);
        }
    }
    
    return ans;
}