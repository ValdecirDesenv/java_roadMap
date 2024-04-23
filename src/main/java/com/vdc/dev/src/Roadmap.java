/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.vdc.dev.src;

import com.vdc.dev.autoboxing.AutoBoxingSample;
import com.vdc.dev.code.Book;
import com.vdc.dev.enums.Calendar;
import com.vdc.dev.multithreading.JobTask_c1;
import com.vdc.dev.multithreading.JobTask_c2;
import com.vdc.dev.utils.Math_op;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author vdc
 */
public class Roadmap {

    public static void main(String[] args) {

//        System.out.println(Dice.sidesOfDice);
//        
//        Dice d1 = new Dice();
//        Dice d2 = new Dice();
//        
//        System.out.println(" ? ");
//        
//        for (int i = 0; i < 10; i++) {
//            System.out.println(" Dice 1: " + d1.roll());
//            System.out.println(" Dice 2: " + d2.roll());            
//        }
//        
//        System.out.println(" done ! ");
//        
//        System.out.println(" Dice 1: " + d1.getFaceValue());
//        System.out.println(" Dice 2: " + d2.getFaceValue());    
//        
//        
//        // Creating a Predicate to check if a string is a palindrome
//        Predicate<String> isPalindrome = str -> {
//            // Remove non-alphanumeric characters and convert to lowercase
//            String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
//            // Check if the clean string is equal to its reverse
//            return cleanStr.equals(new StringBuilder(cleanStr).reverse().toString());
//        };
//
//        
//        
//        // Test the Predicate
//        System.out.println("Is palindrome: " + isPalindrome.test("radar")); // Output: Is palindrome: true
//        System.out.println("Is palindrome: " + isPalindrome.test("hello")); // Output: Is palindrome: false
//        System.out.println("Is palindrome: " + isPalindrome.test("A man, a plan, a canal, Panama")); 
//        
//        
        
        
//        
//        callEnumSample();
//        callSerialization();
//        callThreadsSample();
//        callonePsqrtNumber();
//        callAutoBoxSample();
//        callPractiseLamda();
//        callStreamsApi();
//        callString();
//        callUtilsCode();
          //callMetchSimbols();
          callRepeatedWord();
System.out.println("Hello Java best neil code!");
    }
    
    
    
    
    public static void callEnumSample(){
         //==================== Enum ===========
        Calendar month = Calendar.MARCH;
        System.out.println(month.getName() + " is month number " + month.getValue());      
        for (Calendar months: Calendar.values()){
            System.out.println(" Enum value :" + months.name() +" n:" + months.getValue());
        }
        System.out.println("\n");
    }
    
    
    public static void callSerialization(){
         //==================== Serialization ===========
        Book bo = new Book("Sky Blue", 500);
        bo.setValueForServerOnly(3800);

        String filename = "resources//Book.obj";        
        File fileNamePath = new File(filename).getAbsoluteFile();        
        InputStream fileIn = Roadmap.class.getResourceAsStream(filename);        
        FileOutputStream fileOut =null;
        ObjectOutputStream objOut = null;
        
        //Serialization
        try {
            fileOut = new FileOutputStream(fileNamePath);
            objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(bo);
            fileOut.close();
            System.out.println(" ValueForServerOnly " + bo.getValueForServerOnly() +" \n");
            System.out.println(" Obj serialized !");
            
        } catch (Exception e) {
            System.out.println(" IOException " + e.getMessage());
        }
        
        ObjectInputStream objIn = null;        
        //Deserialization
        try {
            fileIn = new FileInputStream(fileNamePath);
            objIn = new ObjectInputStream(fileIn);
            
            Book bookStreamed = (Book)objIn.readObject();

            System.out.println(" ValueForServerOnly " + bookStreamed.getValueForServerOnly()+" \n");
            System.out.println(" Obj deserialized ! " + bookStreamed);
            
            objIn.close();
            fileIn.close();
        } catch (Exception e) {
            System.out.println(" IOException " + e.getMessage());
        }
         System.out.println("\n");
        //============================================== 
    }

    private static void callThreadsSample() {
        Math_op op = new Math_op();
        
        JobTask_c1 td_c1 = new JobTask_c1(op, 5, 7);
        Thread td_c2 = new Thread(new JobTask_c2(op,5, 2));
        
        td_c1.start();
        td_c2.start();
        
    }

    private static void callonePsqrtNumber() {
        Math_op op = new Math_op();
        System.out.println("one div square some of 5 times -> 1/sqrt(4) = " + op.getSomeOnePsqrt(4,4) );
    }

    private static void callAutoBoxSample() {
        AutoBoxingSample obj =  new AutoBoxingSample();
        obj.sampleAutobox();
    }

    private static void callPractiseLamda() {

        ArrayList<String> students = new ArrayList<>();
        students.add("Elliot");
        students.add("Elis");
        students.add("Valdecir");
        //****************** CONSUMER LAMBDA FUNCTION ********************* 
        students.forEach(s -> System.out.println(s));
        // This Lambda used in this forEach is call Consumer 
        // Consumer: It represents an operation that accepts a single 
        //           input argument and returns no result. Its single abstract 
        //           method is void accept(T t), where T represents the type of 
        //           the input argument.
        /*
        
        (parameter) -> {
              // Body of the lambda function
            // Code statements
         };  
        They are widely used in Java for functional programming, event handling,
        and stream processing, among other things.
        */
        // It also can be defined as this:
        Consumer<String> printConsumer = str -> System.out.println(str);

        students.forEach(printConsumer);
        
        
        //****************** FUNCTION LAMBDA FUNCTION ********************* 
        

        Function<Integer, Integer> mydouble = n -> n * n;
        System.out.println(mydouble.apply(8));    
        /*
        (parameter list) -> {
            // Body of the lambda function
            // Code statements
            return result; // (if necessary)
        };    
        */
    
    
        //****************** PREDICATE LAMBDA FUNCTION ********************* 
        IntPredicate isDivByThree = n -> n % 3 == 0;
        System.err.println(isDivByThree.test(57));
        
        
        //****************** Supplier LAMBDA FUNCTION *********************
        Supplier<Double> randomNumber = () -> Math.random() * 100;
        System.err.println(randomNumber.get() + "//n");
        
        
    }

    private static void callStreamsApi() {

        Stream<String> frutStream = Stream.of("banans", "apples","lemon");
        
        // Stream from other collectors
        //ARRAY
        String[] carArray = new String[]{"fusca","brasilia","fiat","bmw"};
        Stream<String> carStream = Arrays.stream(carArray);
        
        
        //LISTS
        List<String> livrosList = List.of("fusca","brasilia","fiat","bmw");
        Stream<String> livroStream = livrosList.stream();
        
        
        //Looping 
        livrosList.stream().forEach(System.out::println);
        livrosList.parallelStream().forEach(System.out::println);
        
        //Match
        boolean isOnList = livrosList.stream()
                .anyMatch(item -> item.contains("brasilia"));
        
        // Filter
        Stream<String> itemsInAisLe = livrosList.stream()
                .filter(item -> item.startsWith("w"));
        
    
        //Map
        List<Integer> numbersList = List.of(2,3,4,3,5);
        List<Integer> doubleNumberStream = numbersList.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        
    }

    private static void callString() {
        String n1 = " oLHarY ";
        String n2 = " verIt ";
        String n3 = " iSso ";
        String n4 = "  ";
        
        List<String> listStr = List.of(n1,n2,n3, n4);
        // Just trimming and printing without saving the it in other var
        listStr.stream().forEach(s -> System.out.println(s.trim()));

        // This one is doing the strimming but also saving at the list trimmed
        List<String> trimmed = listStr.stream()
                .map(s -> s.trim())
                .collect(Collectors.toList());
        
        System.out.println(trimmed);
        
        //----- REMOVING EMPTY -----
        List<String> noEmpty = trimmed.stream()
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
        
        System.out.println(noEmpty);
        //------ NORMALIZED STRING
        List<String> norList = noEmpty.stream()
                .map( s -> s.toLowerCase())
                .collect(Collectors.toList());
        
        System.out.println(norList);
        // ----------- -------- ---
        String text = "MathWorld is an online mathematics reference work, "
                + "created and largely written by Eric W. Weisstein. "
                + "It is sponsored by and licensed to Wolfram Research, "
                + "Inc. and was partially funded by the National Science "
                + "Foundation's National Science Digital Library grant to "
                + "the University of Illinois at Urbana–Champaign.";
        
        
        String[] sentences = text.split("\\.");
        System.out.println("The text has :" + sentences.length + " sentences");
        
        String[] words = text.split(" |-");
        System.out.println("The text has :" + words.length + " words");
        System.out.println(Arrays.asList(words));
        
        // Counting Vowel in a String
        Function<String, Integer> countVowels = str -> {
            return (int) str.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> "AEIOUYaeiouy".indexOf(ch) != -1)
                .count();
            };
        System.out.println(" Number of Vowels " + countVowels.apply(n1));
    }

    private static void callUtilsCode() {
       Integer[] numberss = {-2,-1,3,6,-8};
       
       
       
        List<Integer> numberChList = List.of(numberss);
        
//        Integer maxValue = numberChList.stream()
//                .sorted() // Sort in ascending order
//                .skip(numberss.length - 2) // Skip all elements except the last two
//                .reduce(1, (a, b) -> a * b); // Multiply the two values, starting with 1 as default
       
        List<Integer> sortValues = numberChList.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortValues);
        int max = numberss[0];
        if (numberss.length > 2) {
            int a = sortValues.get(0) * sortValues.get(1);
            int b = sortValues.get(numberss.length -2) * sortValues.get(numberss.length -1);
            max = (a > b) ? a : b;
        }
               
        System.out.println(max);
       

           
    }

    private static void callMetchSimbols() {
        String s = "9ss()()((()))(sdf)fs[asd[sdf]]";
        
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> blockSymbols = Map.of(
            ')', '(',
            ']', '[',
            '>', '<'
        );
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            System.out.println(current);
            if (blockSymbols.containsKey(current)){
                stack.push(current);
                System.out.println(stack);
                continue;
            }
           if (blockSymbols.containsKey(current) && (stack.isEmpty() || blockSymbols.get(current) != stack.pop())){
               System.out.println(stack); 
               return;
            }
        }
        if (stack.isEmpty()) {
            System.out.println(stack);
        }else{
         System.out.println(" open close done");
        }
        
    
    
    
    }

    private static void callRepeatedWord() {
           String text = "Lorem Ipsum is simply dummy text of the printing and "
                   + "typesetting industry. Lorem Ipsum has been the industry's"
                   + " standard dummy text ever since the 1500s, when an "
                   + "unknown printer took a galley of type and scrambled it "
                   + "to make a type specimen book. It has survived not only five "
                   + "centuries, but also the leap into electronic typesetting,"
                   + " remaining essentially unchanged. It was popularised in the "
                   + "1960s with the release of Letraset sheets containing"
                   + " Lorem Ipsum passages, and more recently with desktop"
                   + " publishing software like Aldus PageMaker including "
                   + "versions of Lorem Ipsum.";

                    // Create a Set to store common words to exclude
            Set<String> commonWordsToExclude = new HashSet<>();
            commonWordsToExclude.add("the");
            commonWordsToExclude.add("a");  
            commonWordsToExclude.add("ar");  
            commonWordsToExclude.add("an");  
            commonWordsToExclude.add("it");  
            commonWordsToExclude.add("and");  
            commonWordsToExclude.add("but");  
            commonWordsToExclude.add("is");  
            commonWordsToExclude.add("are");  
            commonWordsToExclude.add("of");  
            commonWordsToExclude.add("on");  
            commonWordsToExclude.add("to");  
            commonWordsToExclude.add("was");  
            commonWordsToExclude.add("were");  
            commonWordsToExclude.add("that");
            commonWordsToExclude.add("i");
            commonWordsToExclude.add("your");
            commonWordsToExclude.add("his");
            commonWordsToExclude.add("their");
            commonWordsToExclude.add("her");
            commonWordsToExclude.add("you");
            commonWordsToExclude.add("me");
            commonWordsToExclude.add("they");
            commonWordsToExclude.add("at");
            commonWordsToExclude.add("be");
            
            
            String[] wordsRegex = text.split("[\\s\\p{Punct}]+");
            
            // Create a Map to store word counts
            Map<String, Integer> wordCountMap = new HashMap<>();

             // Iterate over the words and update the counts in the map
            for (String word : wordsRegex) {
                 // Convert the word to lowercase to ignore case sensitivity
                 String lowercaseWord = word.toLowerCase();

                // Check if the word is not in the set of common words to exclude
                if (!commonWordsToExclude.contains(lowercaseWord)) {
                    // Update the count in the map
                    wordCountMap.put(lowercaseWord, wordCountMap.getOrDefault(lowercaseWord, 0) + 1);
                }
            }
            
             // Find the word with the highest count
             String mostRepeatedWord = "";
             int maxCount = 0;
             for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                 if (entry.getValue() > maxCount) {
                     mostRepeatedWord = entry.getKey();
                     maxCount = entry.getValue();
                 }
             }

             // Print the most repeated word
             System.out.println("Most repeated word: " + mostRepeatedWord + " (count: " + maxCount + ")");

            
            // ******************************* OTHER WAY
//            String[] words = text.toLowerCase().trim()
//                    .split("[\\n\\t\\r.,;:!?(){}]");
            
            String[] words = text.toLowerCase().trim().split("[\\s\\p{Punct}]+");
            
            List<String> commonWords = List.of("the", "a","or","an",
                    "it","and","but","is","are","of","on","to","was","were",
                    "in","that","in","that", "i", "your","his","their","her",
                    "you","me","they","at","be");
            
            List<String> normalized = Arrays.stream(words)
                    .filter(word -> !commonWords.contains(word)
                    && word.length() != 0)
                    .collect(Collectors.toList());                    
            
            if (normalized.size() == 0){
                System.out.println("Nothing to do... no common words");
            }
            
            HashMap<String, Integer> wordCountMaps = new HashMap<>();
            
            for (String str : normalized) {
                wordCountMaps.put(str, wordCountMaps.getOrDefault(str,0) + 1);
            }

            String whoIs = wordCountMaps.entrySet().stream()
                    .collect(Collectors.maxBy(Map.Entry.comparingByValue()))
                    .map(Map.Entry::getKey)
                    .orElse(null);
            System.out.println("********");
            System.out.println(whoIs);
            System.out.println("********");
    }
}

