package example3;

class JoinTestThread extends Thread{
    Thread t;
    static long sum=0;
    JoinTestThread(String n, Thread t){
        this.setName(n);
        this.t=t;
    }

    public void run() {
        System.out.println("Thread "+this.getName()+" has entered the run() method");
        try {
            int min;
            if (t != null) {
                t.join();
                min=20000;
            }else min=50000;
            System.out.println("Thread " + this.getName());
            int find = (int)(Math.random()*30000)+min;
            sum += find+1;
            for(int i = 2; i<find; i++){
                if(find%i==0)
                    sum+=i;
            }
            Thread.sleep(3000);
            System.out.println("Thread " + this.getName() + " has terminated operation.");
            System.out.println("Sum of divisors of " + find + " is: " + sum + " for Thread " + this.getName());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
