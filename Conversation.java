import java.util.Scanner; 

class Conversation {

  // This part will checks user input for mirror words
  public static boolean checkforwords(String takeIn) {
    // here is where we use the .contains() method to check if the input has mirror words
    boolean checkInside = false;
    if ((takeIn.contains("I"))|| (takeIn.contains("You"))|| (takeIn.contains("you")) || (takeIn.contains("my"))|| (takeIn.contains("My"))|| (takeIn.contains("You're"))|| (takeIn.contains("you're"))|| (takeIn.contains("You are")) || (takeIn.contains("you are")) || (takeIn.contains("I'm")) || (takeIn.contains("i'm")) || (takeIn.contains("am")) || (takeIn.contains("Am")) || (takeIn.contains("Are")) || (takeIn.contains("are"))) {
      checkInside = true;
    }
      
    return checkInside;

      }
  


  // creates mirror statement to respond to user
  public static String replaceWords(String takeIn) {
    // here is where we use the .replaceAll() method to replace mirror words with their counterparts
    takeIn = takeIn.replaceAll("you're", "I am");
    // takeIn = takeIn.replaceAll("i", "you"); we have to replace all the I's with you 
    takeIn= takeIn.replaceAll("you are", "I am");
    takeIn = takeIn.replaceAll("You are", "I am");
    takeIn = takeIn.replaceAll("you", "me");
    takeIn = takeIn.replaceAll("are", "am");
    takeIn = takeIn.replaceAll("Are", "Am");
    takeIn = takeIn.replaceAll("i'm", "You're");
    takeIn = takeIn.replaceAll("I'm", "You're"); 
    takeIn = takeIn.replaceAll("I", "You");
    takeIn = takeIn.replaceAll("my", "your");
    takeIn = takeIn.replaceAll("My", "Your");
    takeIn = takeIn.replace(".", "?");

    return takeIn;
  }
  public static void main(String[] arguments){

    Scanner myObj = new Scanner(System.in);
    System.out.print("Hello there! Enter how many you want to do: ");
    // saves the number of rounds that the user wants
    int enterRounds = myObj.nextInt();
    // creates the array for the transcript
    String[] transcript = new String[2*enterRounds+2];
    System.out.println("I'd like: " + enterRounds + " round(s)");
    System.out.println("What's on your mind? ");
    transcript[0] = "What's on your mind? ";
    myObj.nextLine();
    
    String[] responses = {"woahh", "Very interesting!", "Tell me more...", "Why do you say that?", "hmmm...", "for real", "for real", "hmrrr...", "oh no", "very cool", "Relatable"};
    int transcriptIndex = 1;

      while(enterRounds > 0){
        enterRounds = enterRounds - 1;
        // transcriptIndex = transcriptIndex;
        // this will take  in the user input
        String takeIn = myObj.nextLine();
        // now we have to add the user input to transcript
        transcript[transcriptIndex] = takeIn;
        transcriptIndex = transcriptIndex + 1;
        // this the call function to check for mirror words
        Boolean checking = checkforwords(takeIn); 
        // if this is true, create mirror statement
        if (checking == true) {
          String storemirror = replaceWords(takeIn);
          transcript[transcriptIndex] = storemirror;
          System.out.println(storemirror);
          transcriptIndex = transcriptIndex + 1;
 
        // if false print the generic statement and save to transcript
        } else {
          String chosenResponse = responses[transcriptIndex];
          transcript[transcriptIndex] = chosenResponse;
          System.out.println(chosenResponse); 
          transcriptIndex = transcriptIndex + 1;
        }
        
      
          // call function to make mirror statement
          // add our mirror statement to the transcript
          // print the mirror statement returned by the function
        // else
          // choose a generic response using enterRounds as an index for responses
          // save that generic response to transcript
          // print that generic response
    }
    // say  to the user in a print statement
      System.out.println("Bye, have a nice day");
    // now we use the goodbye into the transcript
      transcript[transcriptIndex] = "Bye, have a nice day";
    // now we print the transcript.
    System.out.println("\n-------------------------------");  
    System.out.println("Here's what we talked about today AKA the Transcript: ");
    System.out.println("-------------------------------\n");
      for(String printall : transcript){
        System.out.println(printall);
      }
    // this will end the program
    myObj.close();
    System.exit(0);
  }
}