import java.io.*;
import java.net.*;  
import java.util.Scanner;

public class NameRetrieval {

  public static void main(String[] args) {
 
    // take user input for email id
    System.out.print("Enter an email id: ");
    Scanner input = new Scanner(System.in);
    String inputEmail = input.next();

    // construct URL from id
    String webAddress = "https://www.ecs.soton.ac.uk/people/".concat(inputEmail);

    try {

      // BufferedReader object to read web page
      URL pageURL = new URL(webAddress);
      BufferedReader inputURL = new BufferedReader(new InputStreamReader(pageURL.openStream()));  

      // search web page for name property
      String inputLine;  
      String desiredProperty = "property=\"name\"";
      String name="not found";

      while ((inputLine = inputURL.readLine()) != null) {

        // extract name from line if name property is found
        if (inputLine.contains(desiredProperty)) {
          int startIndex = inputLine.indexOf("\"name\"") + 7;
          int endIndex = inputLine.indexOf("<", startIndex);
          name = inputLine.substring(startIndex, endIndex);
        }

      }

      // output name to user
      System.out.println("Name: " + name);

   } catch (IOException e) {
     e.printStackTrace();
   }

  }

}

//doesn't work if url is not quite same as id, e.g. sdr1, gm1r07