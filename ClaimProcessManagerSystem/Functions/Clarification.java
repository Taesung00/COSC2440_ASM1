package Functions;


/**
 * @author <Taesung Yoon - S3847581>
 */

public class Clarification extends Load /*If not duplicated true ,duplicated false*/{
    public static Boolean duplicationClarify(String componentID){
        String componentType = "";
        if(        componentID.contains("c-")
        ){
            componentType= "Claim";
        } else if (        componentID.contains("f-")
        ) {
            componentType="Customer";
        } else{
            componentType = "InsuranceCard";
        }

        if(returnAllFileNamesStartWith(componentType).contains(componentID)){
            return false;
        }

        return true;
    }


}
