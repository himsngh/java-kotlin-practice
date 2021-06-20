import java.util.ArrayList;
import java.util.List;

public class Mobile {

    private List<Contacts> mycontact=new ArrayList<>();

    public boolean addContact(Contacts contact){
       if(findContact(contact.getName()) >= 0) {
           System.out.println("Contact already existed ");
           return false;
       }
       mycontact.add(contact);
       return true;
    }
    public boolean updateContact(String name,Contacts newContact){
        int index=findContact(name);
        if(index <0){
            System.out.println("Contact does not exist ");
            return false;
        }
        return updateContact(mycontact.get(index),newContact);
    }
    private boolean updateContact(Contacts oldContact,Contacts newContact){
        int index=findContact(oldContact);
        mycontact.set(index,newContact);
        System.out.println("Contact updated from "+oldContact.getName()+" to new conntact "+newContact.getName());
        return true;
    }
    private int findContact(Contacts contact){
        return mycontact.indexOf(contact);
    }
    private int findContact(String name){
        for(int i=0;i<mycontact.size(); i++){
            Contacts contact=mycontact.get(i);
            if(contact.getName().equalsIgnoreCase(name)){
                return i;
            }
       }
        return -1;
    }
    public boolean searchContact(String name){
        int i=findContact(name);
        if(i>=0){
            return true;
        }
        else
            return false;
    }
    public void deleteContact(String name){
        int index=findContact(name);
        deleteContact(mycontact.get(index));
    }
    private void deleteContact(Contacts contact){
        if(findContact(contact)>=0){
            mycontact.remove(findContact(contact));
            System.out.println("Contact removed :"+contact.getName());
        }
        else
            System.out.println("Contact does not exit.");
    }
    public void displayContact(){
        System.out.println("***********Contact List***********");
        for(int i=0;i<mycontact.size();i++){
            Contacts con=mycontact.get(i);
            System.out.println((i+1)+" \t "+con.getName()+"  -->\t"+con.getPhoneNumber());
         }
    }
    public void displayContact(String name){
        int i=findContact(name);
        System.out.println("Name :\t" + mycontact.get(i).getName() +"\tPhone Number: \t"+mycontact.get(i).getPhoneNumber());
    }

}
