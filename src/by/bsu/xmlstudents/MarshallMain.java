package by.bsu.xmlstudents;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MarshallMain {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Students.class);
            Marshaller m = context.createMarshaller();
            Students st = new Students() { // анонимный класс
                {
                    //добавление первого студента
                    Student.Address addr = new Student.Address("UA", "Kyiv", "Pobedy 4");
                    Student s = new Student("petrov", "Petrov", "fizmat", 637, addr);
                    this.add(s);
                    //добавление второго студента
                    addr = new Student.Address("UA", "Kyiv", "Lukyanivska 23");
                    s = new Student("shimko", "Shimko", "radio", 965, addr);
                    this.add(s);
                }
            };
            m.marshal(st, new FileOutputStream("studs_march.xml"));
            m.marshal(st, System.out);//копия в консоль
            System.out.println("XML -файл создан");
        }catch (FileNotFoundException e) {
            System.out.println("XML - файл не может быть создан" + e);
        }catch (JAXBException e){
            System.out.println(" JAXB - контекст ошибочен"+ e);

        }
    }
}
