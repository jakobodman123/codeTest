package tasks;

import util.UserJsonHandler;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;

public class Methods {
    public static void main(String args[]) throws JsonParseException, JsonMappingException, IOException {
        // prints för alla uppgifter

        // Huvuduppgift 1 (Java)
        UserJsonHandler jsonUsers = new UserJsonHandler();
        String users = jsonUsers.getUsers();
        System.out.println(users);
        String reversedUsernames = reversedUsers(users);
        System.out.println(reversedUsernames);

        
        String input = "[{\"id\":1,\"firstname\":\"Anna\",\"lastname\":\"Graham\",\"username\":\"angr\",\"age\":30},{\"id\":2,\"firstname\":\"Ervin\",\"lastname\":\"Howell\",\"username\":\"erho\",\"age\":24}]";
        String withPalindrom = reversedUsers(input);
        System.out.println(withPalindrom);

        // Huvuduppgift 2 (Kluringar)

        // Metod 1 Skriv en metod som kan hitta det n-te största talet i en lista av tal
        List<Integer> numbers = new ArrayList<>();
        numbers.add(77);
        numbers.add(23);
        numbers.add(194);
        numbers.add(387);
        numbers.add(5);

        int largestNumber = findLargestNumber(numbers);
        System.out.println("Largest number in the list is: " + largestNumber);

        // Metod 2 Skriv en metod som lägger till nollor framför tal, 1 ska bli "00001"
        // och 100 ska bli "00100"
        System.out.println(formatedNumbers(0));
        System.out.println(formatedNumbers(1234));
        System.out.println(formatedNumbers(-567));
        System.out.println(formatedNumbers(2147483647));
        System.out.println(formatedNumbers(-2147483648));

    }

    // använder stringbuilders reverse metod och skickar tillbaka den omvända Stringen
    private static String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }

    private static List<User> jsonToUser(String s) {
        // Omvandlar Json String till en Lista en User
        ObjectMapper mapper = new ObjectMapper();
        try {
            return Arrays.asList(mapper.readValue(s, User[].class));
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private static String userToJson(List<User> u) {
        // omvandlar tillbaka till json format
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(u);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing userlist to JSON", e);
        }
    }

    public static String reversedUsers(String users) {
        List<User> userList = jsonToUser(users);
        // använder reverseString metoden på förnamn för varje User objekt i listan
        for (User u : userList) {
            String reverseUsername = reverseString(u.getFirstName());        
            // Väljer att inte ändra Json format genom att lägga till en extra variabel utan istället lägga till taggen i Username
            if (u.getFirstName().equalsIgnoreCase(reverseUsername)) {
                u.setFirstName(reverseUsername + " *Palindrom*"); // lägger till en Tag om det är en palindrom
            } else {
                u.setFirstName(reverseUsername);
            }
        }
        String json = userToJson(userList);
        return json;
    }

    public static int findLargestNumber(List<Integer> numbers) {
        // execption på tom lista
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List must not be null or empty");
        }
        // itererar genom lista och jämför varje integer för att hitta största talen
        // lite mer complex implementering än Collections.sort men mer effektive metod
        int largestNumber = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            if (currentNumber > largestNumber) {
                largestNumber = currentNumber;
            }
        }
        return largestNumber;
    }

    public static String formatedNumbers(int n) {
        // använder string format för att sätta en 5 char längd på stringen, och fylla
        // överblivade char med 0 om n är mindre än 5 char
        if (n >= 0 && n < 10000) { // om n är inom 0 och 10000 används standard format
            return String.format("%05d", n);
        } else if (n >= -9999 && n < 0) { // om n är inom -1 och -9999 används en extra char för att - tecken ska kunna
                                          // representeras
            return String.format("%06d", n);
        } else { // om n är utanför dessa ramar skickas bara stringen då det inte längre har
                 // något behov av padding
            return Integer.toString(n);
        }
    }
}
