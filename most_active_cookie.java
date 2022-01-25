import java.io.BufferedReader;
import java.util.*;
import java.io.FileReader;
import java.io.File;

class most_active_cookie{

    public static void main(String [] args) throws Exception{
        //System.out.println(args[0]);
        Map<String, Integer> cookies = new HashMap<>();
        String [] getName = new String [2];
        String date = "";
        boolean cookiePresent = false;
        int numCookies = 0;
        String read = "";
        try{
            BufferedReader file = new BufferedReader(new FileReader(args[0]));
            //loops through each line of the cookie file
            while((read = file.readLine()) != null ){
                getName = read.split(",");//gets the date of the cookie
                date = getName[1];
                //System.out.println(date);
                if(date.startsWith(args[2])){ //checks to see if the input is equal to the date
                    cookiePresent = true;
                    //System.out.println(cookiePresent);
                    cookies.put(getName[0], cookies.getOrDefault(getName[0], 0)+1); //add to hashmap if date is the same
                    numCookies = Math.max(numCookies, cookies.get(getName[0])); //find max amount of cookies for the date
                }
                else if(cookiePresent)
                    break;
                else if(file.readLine() == null)
                    break;
            }
            file.close();
            //prints cookies
            for(String cookie : cookies.keySet()){
                if(cookies.get(cookie) == numCookies)
                    System.out.println(cookie);
            }
        }
        catch(Exception e){
            System.out.println("IO Exception");
        }
    }
}
