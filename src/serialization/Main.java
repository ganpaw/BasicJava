package serialization;

import java.io.IOException;

/**
 * http://www.journaldev.com/2452/serialization-in-java
 * @author pgandhi
 *
 */
public class Main {
  public static void main(String[] args) {
    String fileName="employee.ser";
    Employee emp = new Employee();
    emp.setId(100);
    emp.setName("Pankaj");
    emp.setSalary(5000);
    
    //serialize to file
    try {
        SerializationUtil.serialize(emp, fileName);
    } catch (IOException e) {
        e.printStackTrace();
        return;
    }
    
    Employee empNew = null;
    try {
        empNew = (Employee) SerializationUtil.deserialize(fileName);
    } catch (ClassNotFoundException | IOException e) {
        e.printStackTrace();
    }
    
    System.out.println("emp Object::"+emp);
    System.out.println("empNew Object::"+empNew);
}
}
