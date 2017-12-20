
public class Board {
	
	char[][] board1;
	boolean[][] board2;
	int height;
	int width;
	public MsGUI gui;
	boolean[][] flag;
	
	public Board(int n) {	
	
		this.height = n;
		this.width = n;
		this.board1 = new char[n][n];
		this.board2 = new boolean[n][n];
		this.flag = new boolean[n][n];
		
		for(int i=0; i< board2.length; i++){
			for(int j = 0; j<board2[0].length; j++) {
					board2[i][j] = true;
			}
		}
		
		for(int i=0; i< board2.length; i++){
			for(int j = 0; j<board2[0].length; j++) {
					flag[i][j] = true;
			}
		}
		int count = 0;
		 while(count != height) {
			 int a =(int) ((Math.random() * height) );
			 int b =(int) ((Math.random() * height) );
					if(this.board1[a][b] != 'b') {
			    		this.board1[a][b] = 'b'; 
			    		count++;
					}
		}
		 char a = '0';
		 for(int i=0; i< board2.length; i++){
				for(int j = 0; j<board2[0].length; j++) {
							a='0';
						if(board1[i][j] !='b') {
							board1[i][j] = a;
							
						if(i-1 >= 0  && j-1>= 0)	 {
							
							if(board1[i-1][j-1] == 'b')
								a++;
						}if(i + 1 < height && j - 1 >= 0) {
							if(board1[i+1][j-1] == 'b')
								a++;
							
						}if(i + 1 < height && j+1 < height){
							if(board1[i+1][j+1] == 'b')
								a++;
						}if(i-1>=0 && j +1 < height) {
							if(board1[i-1][j+1] == 'b')
								a++;
						}if(i-1 >= 0)	{
							
							if(board1[i-1][j] == 'b')
								a++;
						}if(i + 1 < height){
							
							if(board1[i+1][j] == 'b')
								a++;
						}if(j-1>= 0){
							
							if(board1[i][j-1] == 'b')
								a++;
						}if(j +1 < height){
							
							if(board1[i][j+1] == 'b')
								a++;
						}
								
								
								board1[i][j] = a; 
								
						
						}
					
						
				}
			}
	
	}
		
		 
	
	
	 public void revealCell(int row, int col) {
		 if(row < 0 || row > this.board2.length -1) {
			 
			 return;
		 }
 		if(col < 0 || col > board2[0].length -1 ){
 				return;
 			}
		 if(this.board2[row][col] == true && this.flag[row][col] == false ) {
			 return;
		 }
		 if(this.board2[row][col] == true) {
		 
		 this.board2[row][col] = false;
		 
		 if(this.board1[row][col] == 'b') {
			 gui.lose("YOU LOSE!");
		 }
		 
		  
		 if(this.board1[row][col] == '0') {
			 revealCell(row-1, col-1);revealCell(row, col-1);
			 revealCell(row+1, col-1); revealCell(row-1, col+1); revealCell(row+1, col);
			 revealCell(row, col+1); revealCell(row-1, col); revealCell(row+1, col+1);
		 }
		 
		 } int count = 0;
		 for(int i=0; i< board2.length; i++){
			for(int j = 0; j<board2[0].length; j++) {
				if(this.board2[i][j] == false){
					count++;
				}
			}
		}
		 if(count == (this.height*this.height) - this.height) {
			gui.win("You Win!");
			return;
			}
	}	 
	 

	
	
	
	public boolean isFlagged(int row, int col) {
		if(this.flag[row][col] == false && this.board2[row][col] == true){
			return true;
		}else{
			return false;
		}
	}
	
	public int getHeight() {
		return board1.length;
	}
	
	public int getWidth() {
		return board1[0].length;
	}
	
	public void flagCell(int row, int col) {
		if(flag[row][col] == true) {	 
			flag[row][col] = false;
			return;
		}
		
	}

	
	public void unflagCell(int row, int col) {
		if(flag[row][col] == false) {	 
			flag[row][col] = true;
			return;
		}
	}
	
	public boolean isRevealed(int x, int y) {	
		if(this.board2[x][y] == false){
			return true;
		}else{
		return false;
		}
		
	}
	public char getValue(int row, int col) {
		if(this.flag[row][col] == false && this.board2[row][col] == true){
			
			return 'F';}
		if(this.board2[row][col] == true) {
			return ' ';
		}
		
		return this.board1[row][col];
	}
	
}
