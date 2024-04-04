import Components.Entities.Customer;
import Components.Entities.InsuranceCard;

import java.time.LocalDate;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        Customer[] customers = new Customer[20];
        InsuranceCard[] insuranceCards = new InsuranceCard[20];

        for (int i = 0; i < 20; i++) {
            String idNumber = String.format("c-%07d", i); // 7자리 숫자로 만듭니다.
            customers[i] = new Customer(idNumber, "Customer" + i);

            int cardNum = i * 100000000; // 10자리 숫자로 만듭니다.
            LocalDate expirationDate = LocalDate.now().plusYears(1); // 만료 날짜를 현재로부터 1년 후로 설정합니다.
            insuranceCards[i] = new InsuranceCard(cardNum, customers[i], expirationDate, "PolicyOwner" + i);
        }

        // 출력하여 확인
    }
}
