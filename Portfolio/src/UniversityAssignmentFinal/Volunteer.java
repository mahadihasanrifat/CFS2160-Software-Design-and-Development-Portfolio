package UniversityAssignmentFinal;

//volunteer class to taking information of the volunteers
public class Volunteer {

    //all the variables are private to ensure security

    private String volunteerName;   //String variable to store Volunteer's name
    private int deliveredKit;   //Integer variable to primary store the number of delivered kits
    private int furtherDeliveredKit;    //Integer variable to add further number of delivered kits

    //generated constructors by using intelliJ's generating option
    public Volunteer(String volunteerName, int deliveredKit, int furtherDeliveredKit) {
        this.volunteerName = volunteerName;
        this.deliveredKit = deliveredKit;
        this.furtherDeliveredKit = furtherDeliveredKit;
    }

    //getter to get volunteer name
    public String getVolunteerName() {
        return volunteerName;
    }

    //getter to get the number of primary delivered kit
    public int getDeliveredKit() {
        return deliveredKit;
    }

    //getter to get the number of further added delivered kit
    public int getFurtherDeliveredKit() {
        return furtherDeliveredKit;
    }

    //method to calculate individuals total number of delivered kit
    public int totalIndividualKit() {
        int totalIndividualKit = 0;     //Declaring and initialising variable to storing total kit
        if (furtherDeliveredKit >= 0) {
            totalIndividualKit = deliveredKit + furtherDeliveredKit;
        } else {
            totalIndividualKit = deliveredKit ;
        }
        return totalIndividualKit;
    }

    //method to calculate team member's total salary
    public double teamMemberSalary () {
        double teamMemberSalary = 0.00;     //Declaring and initialising variable to storing total salary
        //using loop for given conditions
        if (totalIndividualKit()<=50) {
            teamMemberSalary = (totalIndividualKit() * 0.15);
        }else if (totalIndividualKit()>50) {
            teamMemberSalary = ((50 * 0.15)+((totalIndividualKit()-50) * 0.20));
        }
        return teamMemberSalary;
    }

    //method to calculate team leader's total salary
    public double teamLeaderSalary () {
        return (teamMemberSalary() + (teamMemberSalary() * 0.20)); //20% extra for team leaders
    }


    //toString method to print details
    @Override
    public String toString() {
        return volunteerName + totalIndividualKit() + teamMemberSalary() ;
    }
}




