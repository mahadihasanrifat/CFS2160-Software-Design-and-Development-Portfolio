package UniversityAssignmentFinal;

//main method
public class Main {

    //main class
    public static void main(String[] args) {

        //creating object of another class
        VolunteerTeam volunteerTeam = new VolunteerTeam();

        //calling different class's methods by object to add team members and team leaders into the arraylists
        volunteerTeam.addLeader(new Volunteer("Rabia",385,15));
        volunteerTeam.addLeader(new Volunteer("Gabrielle",400,-12));
        volunteerTeam.addMember(new Volunteer("Sofya",127, 13));
        volunteerTeam.addMember(new Volunteer("Steve",46, 9));
        volunteerTeam.addMember(new Volunteer("Mohammed",273, 27));
        volunteerTeam.addMember(new Volunteer("Amaara",129, 33));
        volunteerTeam.addMember(new Volunteer("Ayub",129, 39));
        volunteerTeam.addMember(new Volunteer("Tony",17, 106));
        volunteerTeam.addMember(new Volunteer("Kamal",130,32));

        //merging two arraylist into a single arraylist
        volunteerTeam.mergedVolunteerArrayList();

        //printing unsorted team details
        System.out.println("\n------Unsorted Team Details------\n");
        System.out.println(volunteerTeam.printTeamDetails());

        //calling method from different class to sort the data
        volunteerTeam.sortMergedArrayList();

        //printing sorted team details
        System.out.println("------Sorted Team Details------\n");
        System.out.println(volunteerTeam.printTeamDetails());

        //calling method to print total number of delivered kits by the team
        volunteerTeam.totalTeamDeliveredKit();
        //calling method to print total salary of the team
        volunteerTeam.totalTeamSalary();

    }
}
