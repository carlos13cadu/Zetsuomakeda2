package jogo;

public class timer extends Thread{
	Thread a1 = new Thread(){     //cria o thread
        @Override
        public void run(){
            for (int i = 0; i < 10000; i++) {
                System.out.println(i +" :a1");
                
            }
        }
    };
    
    Thread a2 = new Thread(){
        @Override
        public void run(){
            for (int i = 0; i < 10000; i+=5) {
                System.out.println(i + " :a2");
            }
        }
    };
    //a2.start();        //chama o thread
    //a1.start();
    
}
