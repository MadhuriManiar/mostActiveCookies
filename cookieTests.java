import java.io.FileWriter;
import java.util.Random;
class cookieTests{

    public static void main(String [] args) throws Exception{
        try{
            FileWriter writer = new FileWriter("sampleCookieTests.csv");
            StringBuilder build = new StringBuilder();
            for(int i = 0; i < 8; i++){
                build.append(buildCookie());
                build.append('\n');
            }
            writer.write(build.toString());
            writer.close();
        }
        catch(Exception e){

        }
        
    }

    //puts parts of the cookie together
    public static StringBuilder buildCookie(){
        StringBuilder test = new StringBuilder();
        test.append(createCookie());
        test.append(',');
        test.append(findDate());
        test.append(findTime());
        return test;
    }

    //creates random date
    public static StringBuilder findDate(){
        StringBuilder temp = new StringBuilder();
        Random random = new Random();
        int year = 2000 + random.nextInt((22) + 1);
        temp.append(year);
        temp.append('-');
        int month = 1 + random.nextInt((11) + 1);
        if(month < 10)
            temp.append("0");
        temp.append(month);
        temp.append('-');
        int day = 1 + random.nextInt((27) + 1);
        if(day < 10)
            temp.append("0");
        temp.append(day);
        return temp;
    }

    //creates random cookie string
    public static StringBuilder createCookie(){
        StringBuilder temp = new StringBuilder();
        String alphaNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        for(int i = 0; i < 16; i++){
            int num = (int)(alphaNum.length() * Math.random());
            temp.append(alphaNum.charAt(num));
        }
        return temp;
    }

    //creates random time
    public static StringBuilder findTime(){
        StringBuilder temp = new StringBuilder();
        temp.append('T');
        Random random = new Random();
        int hour = 1 + random.nextInt((23) + 1);
        if(hour < 10)
            temp.append("0");
        temp.append(hour);
        temp.append(':');
        int min = 0 + random.nextInt((60));
        if(min <10)
            temp.append('0');
        temp.append(min);
        temp.append(":00");
        temp.append('+');
        temp.append("00:00");
        return temp;
    }

}