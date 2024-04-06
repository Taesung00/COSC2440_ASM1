import Components.Entities.Claim;
import Components.Entities.Customer;
import Components.Entities.InsuranceCard;
import Functions.Clarification;
import Functions.Order.ClaimOrder;
import Functions.Order.InsuranceCardOrder;
import Functions.Save;

import java.time.LocalDate;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class main {
    public static void main(String[] args) throws IOException {
      Customer c1 =  new Customer("0000001","Mathew");
      c1.Save("Customers",c1.getID(),c1);
      Customer c2 = new Customer("0000002","Arthur");
        c2.Save("Customers",c2.getID(),c2);

        Customer c3 = new Customer("0000003","Jodan");
        c3.Save("Customers",c3.getID(),c3);

        Customer c4 = new Customer("0000004","David");

        c4.Save("Customers",c4.getID(),c4);
        Customer c5 =        new Customer("0000005","Trin");

        c5.Save("Customers",c5.getID(),c5);
        Customer c6 =   new Customer("0000006","Lan");

        c6.Save("Customers",c6.getID(),c6);
        Customer c7 =   new Customer("0000007","Anh");
        c7.Save("Customers",c7.getID(),c7);


        Customer c8 =  new Customer("0000008","Joshua");

        c8.Save("Customers",c8.getID(),c8);
        Customer c9 =  new Customer("0000009","Son");

        c9.Save("Customers",c9.getID(),c9);
        Customer c10 = new Customer("0000010","Henry");

        c10.Save("Customers",c10.getID(),c10);
        Customer c11 =  new Customer("00000011","Zerrad");

        InsuranceCard i1 = new InsuranceCard("0000000001",c1,LocalDate.now(),"Apple");
        i1.Save("InsuranceCards",i1.getCardNum(),i1);
      c1.Save("Customers",c1.getID(),c1);
      InsuranceCard i0 = new InsuranceCard("0000000002",c2,LocalDate.now().minusDays(1),"Samsung");
      i0.Save("InsuranceCards",i0.getCardNum(),i0);
      c2.Save("Customers",c2.getID(),c2);
      InsuranceCard i2 = new InsuranceCard("0000000003",c3,LocalDate.now().plusYears(1),"Apple");
      i2.Save("InsuranceCards",i2.getCardNum(),i2);
      c3.Save("Customers",c3.getID(),c3);
      InsuranceCard i3 = new InsuranceCard("0000000004",c4,LocalDate.now().plusYears(2),"Samsung");
      InsuranceCard i4 = new InsuranceCard("0000000005",c5,LocalDate.now().minusDays(3),"Apple");
      InsuranceCard i5 = new InsuranceCard("0000000006",c6,LocalDate.now(),"Samsung");
      InsuranceCard i6 = new InsuranceCard("0000000007",c7,LocalDate.now(),"Apple");
      InsuranceCard i7 = new InsuranceCard("0000000008",c8,LocalDate.now().plusYears(3),"Samsung");
      InsuranceCard i8 = new InsuranceCard("0000000009",c9,LocalDate.now(),"Apple");
      InsuranceCard i9 = new InsuranceCard("0000000010",c10,LocalDate.now(),"Samsung");
      InsuranceCard i10 = new InsuranceCard("0000000011",c11,LocalDate.now(),"Apple");

      Claim f1 = new Claim("0000000001",LocalDate.now().plusYears(1),c1,i1,LocalDate.now().plusYears(5),34234,"Woori");
      f1.setClaimStatus(Claim.Status.Processing);
      f1.Save("Claims",f1.getID(),f1);
      c1.Save("Customers",c1.getID(),c1);
      i1.Save("InsuranceCards",i1.getCardNum(),i1);
      Claim f2 = new Claim("0000000002",LocalDate.now(),c2,i2,LocalDate.now().plusYears(4),34234342,"Shihan");
      f2.Save("Claims",f2.getID(),f2);
      c2.Save("Customers",c2.getID(),c2);
      i2.Save("InsuranceCards",i2.getCardNum(),i2);
      Claim f3 = new Claim("0000000003",LocalDate.now().plusYears(4),c3,i3,LocalDate.now().plusYears(3),342344123,"Vietnam");
      f3.setClaimStatus(Claim.Status.Done);
      f3.Save("Claims",f3.getID(),f3);
      c3.Save("Customers",c3.getID(),c3);
      i3.Save("InsuranceCards",i3.getCardNum(),i3);
      Claim f4 = new Claim("0000000004",LocalDate.now(),c4,i4,LocalDate.now().plusYears(2),342,"HCMC");
      f4.Save("Claims",f4.getID(),f4);
      c4.Save("Customers",c4.getID(),c4);
      i4.Save("InsuranceCards",i4.getCardNum(),i4);

      ArrayList<Claim> cl1 = ClaimOrder.claimStatusSort();
      for(Claim cli1 : cl1){
        System.out.println(cli1);
      }




    }
}
