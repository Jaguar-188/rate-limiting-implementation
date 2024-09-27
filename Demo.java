import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo {

    public static void main(String[] args) throws InterruptedException {


        RateLimit rateLimit = new RateLimit();

        /*
            Service 1 is calling rate limiting function
         */
        System.out.println("------Service 1 is calling-------");
        for (int i=1;i<=10;i++){
            boolean flag = rateLimit.callRateLimiting();
            System.out.println("Request "+ i + " is "+flag);
        }
        /*
            Service 2 is calling rate limiting function
         */
        Thread.sleep(1000);
        System.out.println("------Service 2 is calling-------");
        for (int i=1;i<=10;i++){
            boolean flag = rateLimit.callRateLimiting();
            System.out.println("Request "+ i + " is "+flag);
        }
        /*
            Service 3 is calling rate limiting function
         */
        Thread.sleep(5000);
        System.out.println("------Service 3 is calling-------");
        for (int i=1;i<=10;i++){
            boolean flag = rateLimit.callRateLimiting();
            System.out.println("Request "+ i + " is "+flag);
        }
    }
}

class RateLimit{

    int count = 1;
    long initialTime = System.currentTimeMillis();
    final int maxRequests = 5;
    final long timeFrame = 1000;

//    public RateLimit() {
//        this.initialTime = System.currentTimeMillis();
//    }

    public Boolean callRateLimiting(){

        long startTime = System.currentTimeMillis();
        if(startTime - initialTime > timeFrame){
            initialTime = startTime;
            count = 1;
        }

        if(count <= maxRequests){
            count++;
            return true;
        }
        else{
            count++;
            return false;
        }
    }
}


