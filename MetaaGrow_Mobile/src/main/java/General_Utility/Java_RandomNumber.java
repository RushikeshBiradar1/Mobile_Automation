package General_Utility;

import java.util.Random;

public class Java_RandomNumber {
	


	public int getRandomNum() {
		// TODO Auto-generated method stub
		Random ran = new Random();
		int RanNum = ran.nextInt(1000);
		return RanNum;
	}
	

}
