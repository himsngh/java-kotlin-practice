import java.util.ArrayList;
import java.util.List;

public class Bank {

    private static List<Branch> mybranch=new ArrayList<>();


    public boolean addBranch(Branch branch){
        if(searchBranch(branch.getName())){
            System.out.println("Branch already exist ");
            return false;
        }
        mybranch.add(branch);
        System.out.println("New Branch added -->"+branch.getName());
        return true;
    }

    public boolean addCustomer(Branch branch,String name,double initialTrans){
        if(findBranch(branch)>=0){
            int index=findBranch(branch);
            mybranch.get(index).addCustomer(name,initialTrans);
            System.out.println("New Customer successfully added to the branch");
            return true;
        }
        System.out.println("Branch does not exist");
        return false;
    }

   public boolean addTransaction(Branch branch,String name,double trans){
       if(findBranch(branch)>=0){
           int index=findBranch(branch);
           if(mybranch.get(index).addTransaction(name,trans)){
               return true;
           }
           else{
               System.out.println("Customer doesn't exist in the branch");
               return false;
           }
       }
       return false;
   }
   public void displayBranchList(){
        for(int i=0;i<mybranch.size();i++){
            //System.out.println(mybranch.get(i));
            System.out.println((i+1)+"\t"+mybranch.get(i).getName());
        }
   }

   public void displayList(Branch branch){
        if(findBranch(branch)>=0){
            branch.displayCustomerList();
        }

   }
   public Branch getBranch(String name){
        if(searchBranch(name)) {
            return mybranch.get(findBranch(name));
        }
        System.out.println("Sorry No such branch exist");
        return null;
   }
   public boolean searchBranch(String name){
        if(findBranch(name) >=0){
            return true;
        }
        return false;
   }
    private int findBranch(String name){
        for(int i = 0; i< mybranch.size(); i++){
            if(mybranch.get(i).getName().equalsIgnoreCase(name)){
                return i;
            }
        }
        return -1;
    }
    private int findBranch(Branch branch){
        return mybranch.indexOf(branch);
    }


}
