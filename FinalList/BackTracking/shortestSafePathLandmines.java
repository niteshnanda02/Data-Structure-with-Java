package com.company.BackTracking;

public class shortestSafePathLandmines {
    static int[] x={-1,0,1,0},y={0,1,0,-1};
    static int minPath=Integer.MAX_VALUE;
    public static void main(String[] args) {
        int[][] a={
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 }
        };
        solve(a,a.length,a[0].length);
        System.out.println(minPath);
    }
    private static void solve(int[][] a, int n, int m) {
        //we eliminate all 4 adjacent element of landmine with -1
        boolean[][] vis=new boolean[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if(a[i][j]==0){
                    for (int k = 0; k <4 ; k++) {
                        int nr=i+x[k],nc=j+y[k];
                        if(isSafe(nr,nc,n,m,a, vis)){
                            a[nr][nc]=-1;
                        }
                    }
                }
            }
        }


        for (int i = 0; i <n ; i++) {
            if(a[i][0]==1){
            solveUtil(a,vis,4,0,n,m,0);

            }
        }

    }

    private static void solveUtil(int[][] a, boolean[][] vis, int row, int col, int n, int m, int count) {
        if(col==m-1){
            minPath=Math.min(minPath,count);
            return;
        }
        vis[row][col]=true;

        for (int i = 0; i <4 ; i++) {
            int nr=row+x[i],nc=col+y[i];
            if(isSafe(nr,nc,n,m,a,vis)){
                solveUtil(a,vis,nr,nc,n,m,count+1);
            }
        }
        vis[row][col]=false;

    }

    private static boolean isSafe(int nr, int nc, int n, int m, int[][] a, boolean[][] vis) {
        if(nr<0||nr>=n||nc<=0||nc>=m||a[nr][nc]!=1||vis[nr][nc])
            return false;
        return true;
    }
}
