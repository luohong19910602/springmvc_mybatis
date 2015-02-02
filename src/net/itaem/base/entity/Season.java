package net.itaem.base.entity;
/**
	 * 定义一个枚举
	 * */
	public enum Season{
		
		ONE("one"), TWO("two"), THREE("three"), FOUR("four");
		
		private Season(String str){
        	System.out.println(str);
		}
		
		private Season(){
			
		}
		@Override
		public String toString(){
			return "the season.";
		}
		
		public static void main(String[] args) {
			System.out.println(ONE);
			System.out.println(TWO);
			System.out.println(THREE);
			System.out.println(FOUR);
			
		}
	}
	