import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Shyam Panchal
 * Old Scona Academic High School - Computer Science IB
 *
 * This class represents an algorithm that asks
 * the user for their details and lets them know
 * about any matches from a fictitious group of
 * people.
 */
public class FriendSuggester {
    private static ArrayList<Person> matches = new ArrayList<>();//Any people that have matches with the user

    /**
     * This method counts similarities between the
     * user and each of the people whose details are
     * in the file.
     * @param person the user
     * @throws FileNotFoundException if the file of
     * people is not found
     */
    private static void matchCounter(Person person) throws FileNotFoundException {
        Scanner people = new Scanner(new File("files/people.txt"));

        while (people.hasNext()) {
            //Collects person's details from files
            String name = people.nextLine();
            int age = Integer.parseInt(people.nextLine());
            String school = people.nextLine();
            String subject = people.nextLine();
            String movie = people.nextLine();
            String tvShow = people.nextLine();
            String hobby = people.nextLine();
            String futureCareer = people.nextLine();
            String food = people.nextLine();
            String skill  = people.nextLine();
            //Instantiates person
            Person currentPerson = new Person(name, age, school, subject, movie, tvShow, hobby, futureCareer, food, skill);

            //Compares user details to current person's details gathered from file
            //and increments number of matches if similarities are found
            if (person.school.equals(school.toLowerCase())) {
                currentPerson.numMatches++;
            }
            if (person.subject.equals(subject.toLowerCase())) {
                currentPerson.numMatches++;
            }
            if (person.movie.equals(movie.toLowerCase())) {
                currentPerson.numMatches++;
            }
            if (person.tvShow.equals(tvShow.toLowerCase())) {
                currentPerson.numMatches++;
            }
            if (person.hobby.equals(hobby.toLowerCase())) {
                currentPerson.numMatches++;
            }
            if (person.futureCareer.equals(futureCareer.toLowerCase())) {
                currentPerson.numMatches++;
            }
            if (person.food.equals(food.toLowerCase())) {
                currentPerson.numMatches++;
            }
            if (person.skill.equals(skill.toLowerCase())) {
                currentPerson.numMatches++;
            }

            //If current person has 1 or more similarities with user, add them to ArrayList of matches
            if (currentPerson.numMatches > 0) {
                matches.add(currentPerson);
            }
        }
    }

    /**
     * This is a bubble sort method to rank people
     * from the file highest to lowest based on how
     * many similarities they have with the user.
     */
    private static void rankMatches() {
        boolean sorted = false;

        while (!sorted) {
            sorted = true;

            for (int i = 0; i < matches.size() - 1; i++) {
                if (matches.get(i).numMatches < matches.get(i + 1).numMatches) {
                    Person temp = matches.get(i + 1);
                    matches.set(i + 1, matches.get(i));
                    matches.set(i, temp);

                    sorted = false;
                }
            }
        }
    }

    /**
     * This method retrieves the details for a
     * person the user is matched to. It implements
     * sequential searching to look for that person
     * in the ArrayList matches.
     * @param searchName name of the person the
     *                   user would like to see
     *                   the details for
     */
    private static void getFriendInfo(String searchName) {
        Person foundPerson = null;

        //Searches through array
        for (Person person : matches) {
            if (person.name.toLowerCase().equals(searchName)) {
                foundPerson = person;
                break;
            }
        }

        //If the person is not found
        if (foundPerson == null) {
            System.out.println("The person you are searching for was not found.");
            return;
        }

        //Prints out details of the person user searched for
        String title = foundPerson.name + "'s details";
        System.out.println(title);
        for (int i = 0; i < title.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println("Name: " + foundPerson.name);
        System.out.println("Age: " + foundPerson.age);
        System.out.println("School: " + foundPerson.school);
        System.out.println("Favourite Subject: " + foundPerson.subject);
        System.out.println("Favourite Movie: " + foundPerson.movie);
        System.out.println("Favourite TV Show: " + foundPerson.tvShow);
        System.out.println("Favourite Hobby: " + foundPerson.hobby);
        System.out.println("Future Career: " + foundPerson.futureCareer);
        System.out.println("Favourite Food: " + foundPerson.food);
        System.out.println("Personality Skill: " + foundPerson.skill);
        System.out.println("Similarities: " + foundPerson.numMatches);
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to this Friend Finder system!");
        //Asks user about their details
        System.out.print("What is your first name? ");
        String name = in.next().toLowerCase();
        System.out.print("What is your age? ");
        int age = in.nextInt();
        System.out.print("What school do you go to? ");
        String school = in.nextLine().toLowerCase();
        in.nextLine();
        System.out.print("What is your favourite subject? ");
        String subject = in.next().toLowerCase();
        System.out.print("What is your favourite movie? ");
        String movie = in.nextLine().toLowerCase();
        in.nextLine();
        System.out.print("What is your favourite TV show? ");
        String tvShow = in.nextLine().toLowerCase();
        System.out.print("What is something you like to do in your free time? ");
        String hobby = in.nextLine().toLowerCase();
        System.out.print("What is your goal for yourself as a future career? ");
        String futureCareer = in.nextLine().toLowerCase();
        System.out.print("What is your favourite food? ");
        String food = in.nextLine().toLowerCase();
        System.out.print("What is one personality skill (patience, perseverance, etc.) that you have? ");
        String skill = in.nextLine().toLowerCase();
        Person user = new Person(name, age, school, subject, movie, tvShow, hobby, futureCareer, food, skill);

        matchCounter(user);//Calculate similarities of people in file to user
        rankMatches();//Ranks people with similarities in terms of how many similarities they have

        //If there actually are matches
        if (matches.size() != 0) {
            System.out.println("People that matched with you");
            System.out.println("----------------------------");
            //Print out people that have similarities
            for (Person person : matches) {
                System.out.println((matches.indexOf(person) + 1) + ". " + person.name);
            }

            //Asks if user wants to retrieve details about someone
            System.out.print("Would you like to know more about a friend (enter 'Yes' or 'No')? ");
            String choice = in.next().toLowerCase();
            while (!choice.equals("yes") && !choice.equals("no")) {
                System.out.print("Please type 'Yes' or 'No': ");
                choice = in.next().toLowerCase();
            }

            //If user wants to retrieve someone's details
            while (choice.equals("yes")) {
                System.out.print("Who would you like to know more about (enter the person's first name from the above list)? ");
                String searchName = in.next().toLowerCase();
                getFriendInfo(searchName);

                System.out.print("Would you like to know more about another friend (enter 'Yes' or 'No')? ");
                choice = in.next().toLowerCase();
                while (!choice.equals("yes") && !choice.equals("no")) {
                    System.out.print("Please type 'Yes' or 'No': ");
                    choice = in.next().toLowerCase();
                }
            }
        }
        //If there are no matches
        else {
            System.out.println("Sorry, but no matches could be found.");
        }

        System.out.println("Thank you for using this Friend Finder system!");
    }

}
