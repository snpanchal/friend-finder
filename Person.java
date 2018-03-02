/**
 * @author Shyam Panchal
 * Old Scona Academic High School - Computer Science IB
 *
 * This class represents a person's personal
 * profile. It includes their introductory
 * details, like name, age, school, etc.
 */
class Person {
    //Person's details
    String name;
    int age;
    String school;
    String subject;
    String movie;
    String tvShow;
    String hobby;
    String futureCareer;
    String food;
    String skill;
    int numMatches = 0;

    /**
     * This is the constructor method for the
     * person's personal profile.
     * @param name the person's name
     * @param age the person's age
     * @param school the school the person goes
     *               to
     * @param subject the person's favourite subject
     * @param movie the person's favourite movie
     * @param tvShow the person's favourite TV
     *               show
     * @param hobby the person's favourite hobby
     * @param futureCareer the person's goals for
     *                     the future
     * @param food the person's favourite food
     * @param skill on of the person's personality
     *              skills (patience, perseverance,
     *              loyalty, etc.)
     */
    Person(String name, int age, String school, String subject, String movie, String tvShow, String hobby, String futureCareer, String food, String skill) {
        this.name = name;
        this.age = age;
        this.school = school;
        this.subject = subject;
        this.movie = movie;
        this.tvShow = tvShow;
        this.hobby = hobby;
        this.futureCareer = futureCareer;
        this.food = food;
        this.skill = skill;
    }
}
