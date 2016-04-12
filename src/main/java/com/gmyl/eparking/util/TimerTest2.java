package com.gmyl.eparking.util;

import java.util.Date;
import java.util.Random;
import java.util.Timer;

public class TimerTest2{   
	  
    public static void main(String[] args){   
        Timer timer = new Timer();   
        MyTask myTask1 = new MyTask();   

        
        timer.schedule(myTask1, 1000, 2000);  //任务1 一秒钟后执行，每两秒执行一次。 
        System.out.println(myTask1.getBum());
      
          
    }   
  
    static class MyTask extends java.util.TimerTask{   
        
    	int bum;
        @Override   
        public void run(){   
        	int i=0;
        	Random rd = new Random();
        	i = rd.nextInt(100);
            System.out.println(new Date() + "      " + i);   
        }
		public int getBum() {
			return bum;
		}
		public void setBum(int bum) {
			this.bum = bum;
		}   
        
        
   
    }   
    
}   