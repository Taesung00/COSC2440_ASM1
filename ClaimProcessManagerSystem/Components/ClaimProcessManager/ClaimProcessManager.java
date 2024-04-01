package Components.ClaimProcessManager;

import java.io.*;

public interface ClaimProcessManager {



    public static void add(){
        String projectRoot = System.getProperty("user.dir");
        System.out.println(projectRoot);
    }
    public static void delete(){}
    public static void  getOne(){}
    public static void  getAll(){}
    public static void  save(){}
    public static void  sortOrder(){}
    public static void saveToReport(){

    }
//    private void SaveUser() throws IOException {
//        String projectRoot = System.getProperty("user.dir");
//        String path = projectRoot+"/-PortManagementSystem-master/-PortManagementSystem-master/src/";
//        PrintWriter output = new PrintWriter(new FileWriter(path+"Data/Users.txt", true));
//        output.println(this.role + " "+ this.userName+ " "+ this.password);
//        output.flush();
//        output.close();
//
//    }
    public static void changingClaimStatus(){}
}
