#include <stdio.h>
#define mod_quantity 163577857
#define K_max 2501
#define N_max 2501

long long dp[N_max][K_max];

long long get_number_of_ways(long long N, long long K) {
	if(dp[N][K] != -1)
		return dp[N][K];

	int i, j;

	dp[N][K] = 1;
	if(N != 1) {
		dp[N][K] = (get_number_of_ways(N - 1, K) + (long long)(N)) % mod_quantity;
		for(j = 1; j < K; j++) {
			dp[N][K] = (dp[N][K] + (long long)(N) * get_number_of_ways(N - 1, j)) % mod_quantity;
		}
	}
	
	return dp[N][K];
}

int main() {
	int i, j, T;
	long long N, K;
	
	scanf("%d", &T);

	for(i = 0; i < N_max; i++) {
		for(j = 0; j < K_max; j++) {
			dp[i][j] = -1;
		}
	}

	for(i = 0; i < T; i++) {
		scanf("%lld", &N);
		scanf("%lld", &K);
		printf("%lld\n", get_number_of_ways(N, K));
	}

	
	for(i = 1; i < 10; i++) {
		for(j = 1; j < 10; j++) {
			printf("%lld ", get_number_of_ways(i, j));
		}
		printf("\n");
	}
	
	
	return 0;
}
