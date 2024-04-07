import Components.Entities.Claim;
import Components.Entities.Customer;
import Components.Entities.InsuranceCard;
import Functions.Clarification;
import Functions.Order.ClaimOrder;
import Functions.Order.InsuranceCardOrder;
import Functions.Save;
import System.UI.UserInterface;

import java.time.LocalDate;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class main {
    public static void main(String[] args) throws IOException {

//      Customer c1 =  new Customer("0000001","Michael");
//      Customer c2 = new Customer("0000002","Arthur");
//        Customer c3 = new Customer("0000003","Jordan");
//        Customer c4 = new Customer("0000004","David");
//        Customer c5 =        new Customer("0000005","Trin");
//        Customer c6 =   new Customer("0000006","Lan");
//        Customer c7 =   new Customer("0000007","Anh");
//        Customer c8 =  new Customer("0000008","Joshua");
//        Customer c9 =  new Customer("0000009","Son");
//        Customer c10 = new Customer("0000010","Henry");
//        Customer c11 =  new Customer("00000011","Gerrad");
//      Customer c12 =  new Customer("00000012","Steven");
//      Customer c13 =  new Customer("00000013","Messi");
//      Customer c14 =  new Customer("00000014","Mbappe");
//      Customer c15 =  new Customer("00000015","Erren");
//      Customer c16 =  new Customer("00000016","Yoon");
//      Customer c17 =  new Customer("00000017","Kim");
//      Customer c18 =  new Customer("00000018","Kenshi");
//      Customer c19 =  new Customer("00000019","Ronaldo");
//      Customer c20 =  new Customer("00000020","Haaland");
//      Customer c21 =  new Customer("00000021","Park");
//      Customer c22 =  new Customer("00000022","Klopp");
//      Customer c23 =  new Customer("00000023","Vandijk");
//      Customer c24 =  new Customer("00000024","Coutinho");
//      Customer c25 =  new Customer("00000025","Salah");
//      Customer c26 =  new Customer("00000026","Mane");
//      Customer c27 =  new Customer("00000027","Cha");
//      InsuranceCard i1 = new InsuranceCard("0000000001",c1,LocalDate.now(),"Apple");
//      InsuranceCard i2 = new InsuranceCard("0000000002",c2,LocalDate.now().plusYears(3),"Samsung");
//      InsuranceCard i3 = new InsuranceCard("0000000003",c3,LocalDate.now().plusYears(1),"Nike");
//      InsuranceCard i4 = new InsuranceCard("0000000004",c4,LocalDate.now(),"Apple");
//      InsuranceCard i5 = new InsuranceCard("0000000005",c5,LocalDate.now().plusYears(1),"RMIT");
//      InsuranceCard i6 = new InsuranceCard("0000000006",c6,LocalDate.now(),"Meta");
//      InsuranceCard i7 = new InsuranceCard("0000000007",c7,LocalDate.now().plusYears(1),"Adidas");
//      InsuranceCard i8 = new InsuranceCard("0000000008",c8,LocalDate.now(),"Cocacola");
//      InsuranceCard i9 = new InsuranceCard("0000000009",c9,LocalDate.now(),"Tottenham");
//      InsuranceCard i10 = new InsuranceCard("0000000010",c10,LocalDate.now().plusYears(1),"BMW");
//      InsuranceCard i11 = new InsuranceCard("0000000011",c11,LocalDate.now(),"Liverpool");
//      InsuranceCard i12 = new InsuranceCard("0000000012",c12,LocalDate.now().plusYears(1),"Liverpool");
//      InsuranceCard i13 = new InsuranceCard("0000000013",c13,LocalDate.now(),"Barcelona");
//      InsuranceCard i14 = new InsuranceCard("0000000014",c14,LocalDate.now(),"Paris");
//      InsuranceCard i15 = new InsuranceCard("0000000015",c15,LocalDate.now(),"Titan");
//      InsuranceCard i16 = new InsuranceCard("0000000016",c16,LocalDate.now().plusYears(2),"Pepsi");
//      InsuranceCard i17 = new InsuranceCard("0000000017",c17,LocalDate.now(),"Samsung");
//      InsuranceCard i18 = new InsuranceCard("0000000018",c18,LocalDate.now(),"Sony");
//      InsuranceCard i19 = new InsuranceCard("0000000019",c19,LocalDate.now().plusYears(2),"Hate");
//      InsuranceCard i20 = new InsuranceCard("0000000020",c20,LocalDate.now(),"City");
//      InsuranceCard i21 = new InsuranceCard("0000000021",c21,LocalDate.now().plusYears(2),"United");
//      InsuranceCard i22 = new InsuranceCard("0000000022",c22,LocalDate.now(),"Liverpool");
//      InsuranceCard i23 = new InsuranceCard("0000000023",c23,LocalDate.now().plusYears(1),"Liverpool");
//      InsuranceCard i24 = new InsuranceCard("0000000024",c24,LocalDate.now(),"Brazil");
//      InsuranceCard i25 = new InsuranceCard("0000000025",c25,LocalDate.now(),"Liverpool");
//      InsuranceCard i26 = new InsuranceCard("0000000026",c26,LocalDate.now().plusYears(3),"Bundesliga");
//      InsuranceCard i27 = new InsuranceCard("0000000027",c27,LocalDate.now(),"Bundesliga");
//
//      c1.setInsuranceCard(i1);
//      c2.setInsuranceCard(i2);
//      c3.setInsuranceCard(i3);
//      c4.setInsuranceCard(i4);
//      c5.setInsuranceCard(i5);
//      c6.setInsuranceCard(i6);
//      c7.setInsuranceCard(i7);
//      c8.setInsuranceCard(i8);
//      c9.setInsuranceCard(i9);
//      c10.setInsuranceCard(i10);
//      c11.setInsuranceCard(i11);
//      c12.setInsuranceCard(i12);
//      c13.setInsuranceCard(i13);
//      c14.setInsuranceCard(i14);
//      c15.setInsuranceCard(i15);
//      c16.setInsuranceCard(i16);
//      c17.setInsuranceCard(i17);
//      c18.setInsuranceCard(i18);
//      c19.setInsuranceCard(i19);
//      c20.setInsuranceCard(i20);
//      c21.setInsuranceCard(i21);
//      c22.setInsuranceCard(i22);
//      c23.setInsuranceCard(i23);
//      c24.setInsuranceCard(i24);
//      c25.setInsuranceCard(i25);
//      c26.setInsuranceCard(i26);
//      c27.setInsuranceCard(i27);
//
//      c1.Save("Customers",c1.getID(),c1);
//      i1.Save("InsuranceCards",i1.getCardNum(),i1);
//      c2.Save("Customers",c2.getID(),c2);
//      i2.Save("InsuranceCards",i2.getCardNum(),i2);
//      c3.Save("Customers",c3.getID(),c3);
//      i3.Save("InsuranceCards",i3.getCardNum(),i3);
//      c4.Save("Customers",c4.getID(),c4);
//      i4.Save("InsuranceCards",i4.getCardNum(),i4);
//      c5.Save("Customers",c5.getID(),c5);
//      i5.Save("InsuranceCards",i5.getCardNum(),i5);
//      c6.Save("Customers",c6.getID(),c6);
//      i6.Save("InsuranceCards",i6.getCardNum(),i6);
//      c7.Save("Customers",c7.getID(),c7);
//      i7.Save("InsuranceCards",i7.getCardNum(),i7);
//      c8.Save("Customers",c8.getID(),c8);
//      i8.Save("InsuranceCards",i8.getCardNum(),i8);
//      c9.Save("Customers",c9.getID(),c9);
//      i9.Save("InsuranceCards",i9.getCardNum(),i9);
//      c10.Save("Customers",c10.getID(),c10);
//      i10.Save("InsuranceCards",i10.getCardNum(),i10);
//      c11.Save("Customers",c11.getID(),c11);
//      i11.Save("InsuranceCards",i11.getCardNum(),i11);
//      c12.Save("Customers",c12.getID(),c12);
//      i12.Save("InsuranceCards",i12.getCardNum(),i12);
//      c13.Save("Customers",c13.getID(),c13);
//      i13.Save("InsuranceCards",i13.getCardNum(),i13);
//      c14.Save("Customers",c14.getID(),c14);
//      i14.Save("InsuranceCards",i14.getCardNum(),i14);
//      c15.Save("Customers",c15.getID(),c15);
//      i15.Save("InsuranceCards",i15.getCardNum(),i15);
//      c16.Save("Customers",c16.getID(),c16);
//      i16.Save("InsuranceCards",i16.getCardNum(),i16);
//      c17.Save("Customers",c17.getID(),c17);
//      i17.Save("InsuranceCards",i17.getCardNum(),i17);
//      c18.Save("Customers",c18.getID(),c18);
//      i18.Save("InsuranceCards",i18.getCardNum(),i18);
//      c19.Save("Customers",c19.getID(),c19);
//      i19.Save("InsuranceCards",i19.getCardNum(),i19);
//      c20.Save("Customers",c20.getID(),c20);
//      i20.Save("InsuranceCards",i20.getCardNum(),i20);
//      c21.Save("Customers",c21.getID(),c21);
//      i21.Save("InsuranceCards",i21.getCardNum(),i21);
//      c22.Save("Customers",c22.getID(),c22);
//      i22.Save("InsuranceCards",i22.getCardNum(),i22);
//      c23.Save("Customers",c23.getID(),c23);
//      i23.Save("InsuranceCards",i23.getCardNum(),i23);
//      c24.Save("Customers",c24.getID(),c24);
//      i24.Save("InsuranceCards",i24.getCardNum(),i24);
//      c25.Save("Customers",c25.getID(),c25);
//      i25.Save("InsuranceCards",i25.getCardNum(),i25);
//      c26.Save("Customers",c26.getID(),c26);
//      i26.Save("InsuranceCards",i26.getCardNum(),i26);
//      c27.Save("Customers",c27.getID(),c27);
//      i27.Save("InsuranceCards",i27.getCardNum(),i27);



    }
}
