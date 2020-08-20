#include<bits/stdc++.h>
#define moduli 998244353
#define int long long int
#define ld long double
#define F first
#define S second
#define P pair<int,int>
#define pb push_back
#define vi vector<int>
#define vvi vector<vector<int>>
#define vb vector<bool>
#define um unordered_map

using namespace std;

bool cant_be_formed(vector<int> c) {

    int xxor = 0;
    for (int i = 0; i < c.size(); ++i)
    {
        xxor = (xxor ^ c[i]);
    }

    if (xxor != 0) {
        return true;
    }
    return false;
}

void solve(int tc) {
    int i, j, k, n, m, ans = 0, cnt = 0, sum = 0;
    cin >> n;
    vector<int>a(n), b(n), c;

    int minimum1 = INT_MAX;
    int minimum2 = INT_MAX;

    map<int, int> mpa, mpb;

    for (int i = 0; i < n; ++i)
    {
        cin >> a[i];

        minimum1 = min(minimum1, a[i]);
        c.pb(a[i]);

        auto it = mpa.find(a[i]);
        if (it != mpa.end()) {
            mpa[a[i]]++;
        }
        else {
            mpa.insert({a[i], 1});
        }

    }
    for (int i = 0; i < n; ++i)
    {
        cin >> b[i];
        minimum2 = min(minimum2, b[i]);

        auto it = mpb.find(b[i]);
        if (it != mpb.end()) {
            mpb[b[i]]++;
        }
        else {
            mpb.insert({b[i], 1});
        }

        c.pb(b[i]);
    }
    int minimum = min(minimum2, minimum1);

    a.clear();
    b.clear();


    for (auto aa : mpa) {
        auto it = mpb.find(aa.F);

        if (it == mpb.end()) {
            int range = aa.S / 2;
            for (int i = 0; i < range; ++i)
            {
                a.pb(aa.F);
            }
        }
        else {
            int second_array_value = mpb[aa.F];
            if (aa.S != second_array_value and aa.S > second_array_value) {
                int range = (aa.S - second_array_value) / 2;

                for (int i = 0; i < range; ++i)
                {
                    a.pb(aa.F);
                }
            }
        }
    }
    // cout << minimum << endl;


    for (auto bb : mpb) {
        auto it = mpa.find(bb.F);

        if (it == mpa.end()) {
            int range = bb.S / 2;
            for (int i = 0; i < range; ++i)
            {
                b.pb(bb.F);
            }
        }
        else {
            int second_array_value = mpa[bb.F];
            if (bb.S != second_array_value and bb.S > second_array_value) {
                int range = (bb.S - second_array_value) / 2;
                for (int i = 0; i < range; ++i)
                {
                    b.pb(bb.F);
                }
            }
        }
    }

    // for (auto x : d) {
    //     cout << x << ' ';
    // }
    // cout << endl;

    sort(a.begin(), a.end());
    sort(b.begin(), b.end(), greater<int>());





    for (int i = 0; i < a.size(); ++i)
    {
        int option1 = min(a[i], b[i]);
        int option2 = minimum * 2;

        int answer = min(option2, option1);
        sum += answer;
    }

    if (!cant_be_formed(c)) {
        cout << sum << endl;
    }
    else {
        cout << -1 << endl;
    }


}


int32_t main()
{
// #ifndef ONLINE_JUDGE
//     freopen("input.txt", "r", stdin);
//     freopen("output.txt", "w", stdout);
// #endif

    ios_base:: sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int t; cin >> t; while (t--)
    {
        int tc = 1;
        solve(tc);
        tc++;
    }
}