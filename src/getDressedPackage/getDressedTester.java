/*
** A simulation of a person who needs to get dressed
** Author: David Johnson
** Date: September 25, 2017
*/

package getDressedPackage;

public class getDressedTester {
    // Testing code for getDressed
    public static void main(String[] args) {
        Person p = new Person();
        
        //System.out.println("Pajamas on? " + p.getPajamasOn());
        //System.out.println("Footwear on? " + p.getFootwearOn());
        //System.out.println("Headwear on? " + p.getHeadwearOn());
        //System.out.println("Socks on? " + p.getSocksOn());
        //System.out.println("Shirt on? " + p.getShirtOn());
        //System.out.println("Jacket on? " + p.getJacketOn());
        //System.out.println("Pants on? " + p.getPantsOn());
        //System.out.println("In house? " + p.getInHouse());

        System.out.println("Next two entries should succeed");
        
        int[] commands = {8,6,4,2,1,7};
        String output = p.input("hot", commands);
        System.out.println(output);
        
        Person a = new Person();
        int[] commands2 = {8,6,3,4,2,5,1,7};
        output = a.input("COLD", commands2);
        System.out.println(output);
        
        System.out.println("\nNext four entries should fail");
        
        Person b = new Person();
        int[] commands3 = {8,6,6};
        output = b.input("hot", commands3);
        System.out.println(output);

        Person c = new Person();
        int[] commands4 = {8,6,3};
        output = c.input("HOT", commands4);
        System.out.println(output);

        Person d = new Person();
        int[] commands5 = {8,6,3,4,2,5,7};
        output = d.input("cold", commands5);
        System.out.println(output);
        
        Person e = new Person();
        int[] commands6 = {6};
        output = e.input("cold", commands6);
        System.out.println(output);        
    }
}