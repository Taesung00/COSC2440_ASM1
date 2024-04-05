package Functions;


/**
 * @author <Taesung Yoon - S3847581>
 */

public class Clarification extends Load /*If not duplicated true ,duplicated false*/{
    public static Boolean duplicationClarify(String componentID){
        if(returnAllComponentsFileName().contains(componentID+".ser")){
            return false;
        }else{
            return true;
        }

    }


}
