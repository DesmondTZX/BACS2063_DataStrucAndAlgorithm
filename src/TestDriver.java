import adt.HashMap;
import entity.Programme;

public class TestDriver {
    public static void main(String[] args) {
        HashMap<Integer,Programme> map = new HashMap<>(3);
        Programme p1 = new Programme(1234,"Computer Science","Diploma",7,"FOCS");
        Programme p2 = new Programme(1235,"Computer Engineering","Degree",14,"FOCS");
        Programme p3 = new Programme(1236,"Information Technology","Degree",14,"FOCS");
        Programme p4 = new Programme(1237,"Information Technology","Degree",14,"FOCS");
        Programme p5 = new Programme(1238,"Information Technology","Degree",14,"FOCS");
        Programme p6 = new Programme(1239,"Information Technology","Degree",14,"FOCS");
        Programme p7 = new Programme(1240,"Information Technology","Degree",14,"FOCS");
        Programme p8 = new Programme(1241,"Information Technology","Degree",14,"FOCS");

        map.put(p1.getCode(), p1);
        map.put(p2.getCode(), p2);
        map.put(p3.getCode(), p3);
        map.put(p4.getCode(), p4);
        map.put(p5.getCode(), p5);
        map.put(p6.getCode(), p6);
        System.out.println(map.getCapacity());


        //remove
        System.out.println(map.remove(1234));
        System.out.println(map.remove(1235));
        System.out.println(map.remove(1236));

        //get
        System.out.println(map.get(1234));
        System.out.println(map.get(1235));
        System.out.println(map.get(1236));
        System.out.println(map.get(1237));
        System.out.println(map.get(1238));
        System.out.println(map.get(1239));
        System.out.println(map.get(1240));
        System.out.println(map.get(1241));


        System.out.println(map);



    }
}
