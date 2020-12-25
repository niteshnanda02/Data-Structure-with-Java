package com.company.BackTracking;

import java.util.Arrays;

public class wordSearch {
    public static void main(String[] args) {
        char[][] a={
                {'D','D','D','G','D','D'},
                {'B','B','D','E','B','S'},
                {'B','S','K','E','S','K'},
                {'D','D','D','S','K','E'},
                {'D','D','D','D','D','E'},
                {'D','D','D','D','D','G'}
        };
        System.out.println(new Solution().exist(a,"GEEKS"));
    }
}
class Solution {
    static int[] x={0,1,0,-1},y={1,0,-1,0};
    public int exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean[][] visited=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    for(boolean[] a:visited)
                        Arrays.fill(a,false);
                    visited[i][j]=true;
                    count+=exist(board,visited,word,i,j,n,m,1);
                }
            }
        }
        return count;
    }

    int exist(char[][] b,boolean[][] visited,String w,int r,int c,int n,int m,int i){
        if(i==w.length()){
            return 1;
        }
        if(r>=n||c>=m)
            return 0;

        int count=0;
        for(int k=0;k<4;k++){
            int row=r+x[k];
            int col=c+y[k];
            if(row<0||row>=n||col<0||col>=m||visited[row][col])
                continue;
            if(b[row][col]==w.charAt(i)&&!visited[row][col]){
                visited[row][col]=true;
                count+=exist(b,visited,w,row,col,n,m,i+1);
                visited[row][col]=false;
            }
        }

        return count;
    }
}
