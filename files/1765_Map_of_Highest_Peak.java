class Solution {
    public int[][] highestPeak(int[][] water) {
        int n=water.length;
        int m=water[0].length;

        int ans[][]=new int[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(ans[i],Integer.MAX_VALUE);
        }

        Queue<int[]>q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(water[i][j]==1){
                    q.add(new int[]{i,j});
                    ans[i][j]=0;
                }
            }
        }

        int a[]={1,0,-1,0};
        int b[]={0,1,0,-1};

        while(!q.isEmpty()){
            int c[]=q.remove();

            int x=c[0];
            int y=c[1];

            for(int i=0;i<4;i++){
                int xx=x+a[i];
                int yy=y+b[i];
                if(xx>=0 && xx<n && yy>=0 && yy<m && ans[xx][yy]>ans[x][y]+1){
                    ans[xx][yy]=ans[x][y]+1;
                    q.add(new int[]{xx,yy});
                }
            }
        }

        return ans;
    }
}
