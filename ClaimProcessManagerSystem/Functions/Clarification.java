package Functions;


/**
 * @author <Taesung Yoon - S3847581>
 */

public abstract class Clarification extends Load /*중복안되면 true 중복되면 false*/{
    public static Boolean duplicationClarify(String componentID){
        String componentType = "";
        if(        componentID.contains("Cl-")
        ){
            componentType= "Claim";
        } else if (        componentID.contains("f-")
        ) {
            componentType="Customer";
        } else if (componentID.contains("I-")) {
            componentType = "InsuranceCard";
        }else{
            return false;
        }

        if(returnAllFileNamesStartWith(componentType).contains(componentID)){
            return false;
        }

        return true;
    }

}
