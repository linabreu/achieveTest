/*
Lina Breunlin
CIS 1633 AA Java
October 21, 2019
Program that gives summary data for highschoolers who take a standardized test. Uses arrays to collect data for each grade level then returns the 
numer of students in the grade and the grade's average

Test Data

Inputs (grade level, test score respectively)          Outputs (number of students, Average)                 Passed?
0, 100                                                          3, 76.0                                         Y
0, 50
0, 80
1, 75
1, 90
1, 60                                                           3, 75.0
2, 66                                                           
2, 95
2, 100                                                          3, 87.0
3, 0
3, 55
3, 89
3, 43                                                          4, 46.0




 */
package achievementtest;
import java.util.Scanner;

public class AchievementTest {

    
        public static void main(String[] args) {
        //declare variables and constants
        final int GRADE_LEVELS = 4;  //grades refers to freshman, sophmore, junior or senior- 4 grades at the high school
        int[] scoreTotal = new int [GRADE_LEVELS];
        int[] studentCount = new int [GRADE_LEVELS];
        
        int currGrade = 0; 
        int testScore = 0;
        boolean finished = false;
        String moreScores;
        
        
         System.out.println();
   
         System.out.println("-------------------------------------------------------------------------------------------------------");

         System.out.println("                       --| Artichoke High School Achievement Test Calculator |--                       ");
   
         System.out.println("-------------------------------------------------------------------------------------------------------");
        
        // call method to get the student grade level
        currGrade = getCurrGrade();
        
        //call method to get the student test score
        testScore = getTestScore();
        
             while(currGrade >= 0 && currGrade < GRADE_LEVELS && testScore >= 0 && !finished)
            {
                //add test scores to correct position in the array  
                 scoreTotal[currGrade] = scoreTotal[currGrade] + testScore;
          
                //add +1 to to the counting array
                studentCount[currGrade] = studentCount[currGrade] + 1;
          
                System.out.println("Do you wish to enter more scores? Type Y for yes or N for no.");
          
                 Scanner in = new Scanner (System.in);
          
                moreScores = in.next();
          
            if (moreScores.equals("N"))
                {
                     finished = true;
                }
          
             else
                {
                    currGrade = getCurrGrade();
           
                    testScore = getTestScore();  
                }
            }
        
       getSummary (studentCount, scoreTotal);
    }
    
    
    /**
     get student's grade level from the user
     @return student grade from the user
     */
    
   public static int getCurrGrade() 
   {
       
    //declare variables
    int grade = 0;
    
    Scanner in = new Scanner(System.in);
    
    //prompt user for the students grade level
    
    System.out.println("Please enter the student's grade level (0 for Freshman, 1 for Sophmore, 2 for Junior or 3 for Senior):");
    
    if (in.hasNextInt()) //make sure that user input is valid
        
        {
          grade = in.nextInt();  
        }
    else
        {
          grade = -1;
        }
    return grade;  
   }
   
   
   
       /**
     get student's test scores from the user
     @return students test score
     */
    
   public static int getTestScore() 
   {
       
    //declare variables
    int score = 0;
    final int MAX_SCORE = 100;
 
    
    Scanner in = new Scanner(System.in);
    
    //prompt user for the students test score
    
    System.out.println("Please enter the student's Achievement Test Score");
    
    
    if (in.hasNextInt()) //make sure that user input is valid
    {      
          score = in.nextInt();  
          
            if (score < 0 || score > MAX_SCORE)
                    {
                        System.out.println("Test score must be between 0 and 100.Please retry");
                        score = in.nextInt();  
                    }   
    }
  
    else
        {
          score = -1;
        }
    return score;  
   }
   
     /**
     @param gradeCount = the number of students who took the test in each grade
     @param gradeTotal = the sum of scores for the students in a particular grade who took the test
     
     */
   public static void getSummary(int[] gradeCount, int []gradeTotal)  
   
   {
    String[] grade = {"Freshman", "Sophmore", "Junior", "Senior"};
    
    double average = 0;
    
         System.out.println();
   
         System.out.println("-------------------------------------------------------------------------------------------------------");

         System.out.println("                                  --|Achievement Test Summary|--                                       ");
   
         System.out.println("-------------------------------------------------------------------------------------------------------");
         
         System.out.println(" Grade Level                           Number of Students                                Average Score");
         
         System.out.println("-------------------------------------------------------------------------------------------------------");
         
         //loop through arrays and get results
         
         for (int i=0; i < gradeCount.length; i++ )
             
         {
             
             if (gradeCount[i] == 0)
                 
             {
                gradeCount [i] =0;
                average = 0;
             }
             
             else
             {
             average = gradeTotal[i] / gradeCount[i];
             
             
             System.out.printf("%-20s   %25d    %,45.2f", grade[i] ,gradeCount[i], average); 
             
             System.out.println();  
            }
         }
         
     System.out.println("-------------------------------------------------------------------------------------------------------");     

   }
    
}