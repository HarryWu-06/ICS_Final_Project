
public class GlobalVariables {
	public static class characterVariable{
		public static final int RUNR = 0;
		public static final int RUNL = 1;
		public static final int JUMPR = 2;
		public static final int JUMPL = 3;
		public static final int ATTACKR = 4;
		public static final int ATTACKL = 5;
		public static final int HURT = 6;
		public static final int STAND = 7;
		
		public static int getSpriteNum(int action) {
			switch(action) {
			case RUNR:
				return 5;
			case RUNL:
				return 5;
			case JUMPR:
				return 3;
//			case JUMPL:
//				return 3;
//			case :
//				return 0;
//			case :
//				return 0;
//			case :
//				return 0;
			default:
				return 0;
			}
		}
	}
}
