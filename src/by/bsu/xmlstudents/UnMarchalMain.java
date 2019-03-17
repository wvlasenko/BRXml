package by.bsu.xmlstudents;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class UnMarchalMain {
    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Students.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("studs_march1.xml");
            Students students = (Students) u.unmarshal(reader);
            System.out.println(students);
        }catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
