import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static int n;
    static int ans;
    static int[] v1;
    static int[] v2;
    static int[] v3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = 0;
        v1 = new int[n]; // 열 체크 배열
        v2 = new int[2 * n]; // 좌측 대각선 체크 배열
        v3 = new int[2 * n]; // 우측 대각선 체크 배열

        // 첫 번째 행부터 퀸 배치 시작
        dfs(0);

        // 결과 출력
        System.out.println(ans);
    }

    // 퀸을 배치 dfs 메서드 , c = col , r = row
    static void dfs(int r) {
        // 모든 행에 퀸을 배치한 경우
        if (r == n) {
            // 경우의 수 증가
            ans++;
            return;
        }

        // 현재 행의 각 열에 대해 퀸을 놓을 수 있는지 체크
        for (int c = 0; c < n; c++) {
            // 현재 열과 좌우 대각선에 퀸이 없는 경우
            if (v1[c] == 0 && v2[r + c] == 0 && v3[r - c + n] == 0) {
                // 퀸을 해당 위치에 놓음
                v1[c] = v2[r + c] = v3[r - c + n] = 1;
                // 다음 행으로 이동하여 퀸을 배치 시도
                dfs(r + 1);
                // 현재 위치에서 퀸을 제거 (백트래킹)
                v1[c] = v2[r + c] = v3[r - c + n] = 0;
            }
        }
    }
}
