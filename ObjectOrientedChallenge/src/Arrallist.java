import java.util.ArrayList;

public class Arrallist {

    private ArrayList<String> list=new ArrayList<String>();

    public void addItem(String name){
        if(list.contains(name)){
            System.out.println("List already have that item");
        }
        else{
            list.add(name);
        }

    }
    public void search(String Item){
        if(list.contains(Item)){
            System.out.println("Item found in the list");
        }
        else
            System.out.println(" Item not found ");
    }
    public void display(){
        System.out.println("*****************LIST ITEMS*************************");
        for(int i=0;i<list.size();i++){
            System.out.println("\t"+(i+1)+"  "+list.get(i));
        }
        System.out.println("****************************************************");
    }
    public void removeItem(String ItemName){
        int a=list.indexOf(ItemName);
        list.remove(a);
        System.out.println("Item " + ItemName + " has been removed from the list");
    }
    public void modifyItem(String ItemName,String NewItem){
        int a=list.indexOf(ItemName);
        list.set(a,NewItem);
        System.out.println(" New item "+NewItem+" has been added.");
    }
}
