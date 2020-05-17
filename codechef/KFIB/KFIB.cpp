#include <stdio.h>
#define N_max 200001
#define P 1000000007

long long dp[N_max];

long long calc(int N, int K) {
	if(dp[N] != -1)
		return dp[N];

	if(N <= K)
		return 1;

	dp[N] = 0;
	int i;
	for(i = 1; i <= K; i++) {
		if(N - i <= K)
			break;
		else
			dp[N] = (dp[N] + calc(N-i, K)) % P;
	}

	dp[N] = (dp[N] + K - i + 1) % P;

	return dp[N];
}

int main() {
	int N, K;

	scanf("%d", &N);
	scanf("%d", &K);

	for(int i = 0; i <= N; i++) {
		dp[i] = -1;
	}

	printf("%lld\n", calc(N, K));

	return 0;
}
