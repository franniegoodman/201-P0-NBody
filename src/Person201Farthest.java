/**
 * reads a file containing Person201 objects and determines the two people furthest away from one another
 * returns the names of those two people as well as the distance between them
 * @author Frannie Goodman
 */
import java.util.*;

public class Person201Farthest{
    public static void main(String[] args) throws Exception {
            String file = "data/large.txt";
            double max = 0;
            Person201 a = null;
            Person201 b = null;
            Person201[] people = Person201Utilities.readFile(file);
            Hashtable<Double,ArrayList<Person201>> myDict = new Hashtable<>();
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
                pair.add(farthestPerson);
                pair.add(p);
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
                
            System.out.printf("farthest distance is %3.2f between %s and %s\n",max,a.getName(),b.getName());
        }
}