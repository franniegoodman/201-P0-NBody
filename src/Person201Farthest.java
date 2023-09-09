import java.util.*;

public class Person201Farthest{
    public static void main(String[] args) throws Exception {
            String file = "data/large.txt";
            double max = 0;
            Person201 a = null;
            Person201 b = null;
            Person201[] people = Person201Utilities.readFile(file);
            Hashtable<Double,ArrayList<Person201>> myDict = new Hashtable<>();
            //loop through each person in file
            //find person farthest from that person 
            for (Person201 p : people){
                double maxDist = 0.0;
                Person201 farthestPerson = null;
                for (Person201 x : people){
                    double thisDist = Person201Utilities.distance(p.getLatitude(), p.getLongitude(), x.getLatitude(), x.getLongitude());
                    if (thisDist > maxDist){
                        maxDist = thisDist;
                        farthestPerson = x;
                    }
                ArrayList<Person201> pair = new ArrayList<>();
                pair.add(p);
                pair.add(farthestPerson);
                myDict.put(maxDist, pair);
                }
            }
            for(double d : (myDict.keySet())){
                if (d > max){
                    max = d;
                }
            }
            ArrayList<Person201> farthestPeople = myDict.get(max);
            a = farthestPeople.get(0);
            b = farthestPeople.get(1);
            
            //add pair of names & distance to parallel ArrayLists? equivalent of dictionary?
            //find max distance between &  corresponding names 
                
            
            System.out.printf("farthest distance is %3.2f between %s and %s\n",max,a.getName(),b.getName());
        }
}