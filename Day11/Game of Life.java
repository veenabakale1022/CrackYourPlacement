class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols= board[0].length;

        int[] dx ={-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy ={-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i=0; i<rows;i++){
            for(int j=0; j<cols; j++){
                int liveNeighbors = 0;

                for(int k=0; k<8;k++){
                    int x =i+ dx[k];
                    int y = j+dy[k];

                    if(x >=0 && x < rows && y >= 0 && y < cols && (board[x][y] == 1 || board [x][y] == -1)){
                        liveNeighbors++;
                    }
                }
                if(board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)){
                    board[i][j] = -1;
                } else if(board[i][j] == 0 && liveNeighbors == 3){
                    board[i][j] = 2;
                }
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j] == -1){
                    board[i][j]=0;
                }else if(board[i][j] == 2){
                    board[i][j] =1;
                }
            }
        }
        
    }
}
