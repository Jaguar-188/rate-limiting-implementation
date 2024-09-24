public class Demo {

    public static void main(String[] args) throws InterruptedException {


        RateLimit rateLimit = new RateLimit();

        /*
            Service 1 is calling rate limiting function
         */
        for (int i=0;i<10;i++){
            boolean flag = rateLimit.callRateLimiting();
            System.out.println(flag);
        }
        Thread.sleep(1000);
        /*
            Service 2 is calling rate limiting function
         */
        for (int i=0;i<10;i++){
            boolean flag = rateLimit.callRateLimiting();
            System.out.println(flag);
        }
        Thread.sleep(1000);
        /*
            Service 3 is calling rate limiting function
         */
        for (int i=0;i<10;i++){
            boolean flag = rateLimit.callRateLimiting();
            System.out.println(flag);
        }
    }
}

class RateLimit{

    int count = 0;
    public Boolean callRateLimiting(){

        boolean flag = false;

        if(count == 10) count = 0;
        if(count < 5)
        {
            count++;
            flag = true;
        }
        else{
            count++;
            flag = false;
        }
        return flag;
    }
}
