package UniversityAssignmentFinal;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

//VolunteerTeam class for team
public class VolunteerTeam {


    ArrayList <Volunteer> teamMemberArrayList = new ArrayList<>();      //Arraylist for storing team member's data
    ArrayList <Volunteer> teamLeaderArrayList = new ArrayList<>();      //Arraylist for storing team leader's data
    ArrayList <Volunteer> mergedVolunteerArrayList = new ArrayList<>();      //Arraylist for merging two arraylist in a same arraylist

    //empty constructor
    public VolunteerTeam() {
    }

    //method to add member details in teamMemberArrayList
    public void addMember(Volunteer volunteer) {
        teamMemberArrayList.add(volunteer);
    }

    //method to add leader details in teamLeaderArrayList
    public void addLeader(Volunteer volunteer) {
        teamLeaderArrayList.add(volunteer);
    }

    //method to merge two arraylist together
    public void mergedVolunteerArrayList() {
        mergedVolunteerArrayList.addAll(teamMemberArrayList);
        mergedVolunteerArrayList.addAll(teamLeaderArrayList);
    }


    //method to count the number of team's total delivered kits
    public void totalTeamDeliveredKit () {
        int totalTeamDeliveredKit = 0;      //declaring and initialising variable
        for (Volunteer volunteer : mergedVolunteerArrayList) {
            totalTeamDeliveredKit = totalTeamDeliveredKit + volunteer.totalIndividualKit();
        }
        System.out.println("Total number of delivered kits by the team: "+ totalTeamDeliveredKit + "\n");     //Print team's total delivered kit
    }

    //method to count team's total salary
    public void totalTeamSalary() {
        double totalTeamLeaderSalary = 0.00;    //declaring and initialising variable to store team leaders salary
        double totalTeamMemberSalary = 0.00;    //declaring and initialising variable to store team members salary
        for (Volunteer volunteer : teamLeaderArrayList) {
            totalTeamLeaderSalary = totalTeamLeaderSalary + volunteer.teamLeaderSalary();
        }
        for (Volunteer volunteer : teamMemberArrayList) {
            totalTeamMemberSalary = totalTeamMemberSalary + volunteer.teamMemberSalary();
        }
        System.out.println(("Total Salary of the Team: "
                +formatTheSalary(totalTeamLeaderSalary
                + totalTeamMemberSalary)));      //Printing team's total salary
    }

    //method to print table and team details
    public String printTeamDetails () {
        StringBuilder stringBuilder = new StringBuilder();      //StringBuilder class and creating its object

        for (Volunteer volunteer : mergedVolunteerArrayList) {
            if (volunteer.getFurtherDeliveredKit()>=0) {
                if (teamLeaderArrayList.contains(volunteer)) {
                    stringBuilder.append(String.format("%-50s | %-50s | %-50s",("Team Leader's Name: "+volunteer.getVolunteerName()
                                    +" TL"), ("Total Delivered Kit: "+volunteer.totalIndividualKit()),
                            ("Total Salary :"+formatTheSalary(volunteer.teamLeaderSalary()))));
                    stringBuilder.append("\n");
                } else {
                    stringBuilder.append(String.format("%-50s | %-50s | %-50s",("Team Member's Name: "+volunteer.getVolunteerName()),
                            ("Total Delivered Kit: "+volunteer.totalIndividualKit()),
                            ("Total Salary :"+formatTheSalary(volunteer.teamMemberSalary()))));
                    stringBuilder.append("\n");
                }
            } else {
                if (teamLeaderArrayList.contains(volunteer)) {
                    stringBuilder.append(String.format("%-50s | %-50s | %-50s",("Team Leader's Name: "+volunteer.getVolunteerName()
                                    +" TL"), ("Total Delivered Kit: "+volunteer.totalIndividualKit()+" | Invalid further kits"),
                            ("Total Salary :"+formatTheSalary(volunteer.teamLeaderSalary()))));
                    stringBuilder.append("\n");
                } else {
                    stringBuilder.append(String.format("%-50s | %-50s | %-50s",("Team Member's Name: "+volunteer.getVolunteerName()),
                            ("Total Delivered Kit: "+volunteer.totalIndividualKit()+" | Invalid further kits"),
                            ("Total Salary :"+formatTheSalary(volunteer.teamMemberSalary()))));
                    stringBuilder.append("\n");
                }

            }
        }
        return stringBuilder.toString();
    }

    //method formatting the salary
    //two decimal place, rounded and £ included
    public String formatTheSalary(double symbolIncludedSalary) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.UK);
        return numberFormat.format(symbolIncludedSalary);
    }

    //comparator interface to compare information, first in descending by the delivery of the kits, secondly by alphabetical order
    Comparator <Volunteer> volunteerComparator = Comparator.comparing(Volunteer::totalIndividualKit).
            reversed().thenComparing(Volunteer::getVolunteerName);

    //method to sort the merged arraylist
    public void sortMergedArrayList () {
        mergedVolunteerArrayList.sort(volunteerComparator);
    }

}