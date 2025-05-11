package webdriver;

import org.testng.annotations.Test;

import java.util.Random;

public class Topic_02_Random_Library {
    //Biến khai báo ở đây là biến Global
    //Biến khai báo ở phần Test là biến local (chỉ sử dụng trong TC đó được)
    String prefixEmail ="Kim";
    String postFixEmail ="@gmail.com";

    @Test
    public void TC_01_testEmail() {
        //Nếu chỉ dùng rand.nextInt() thì sẽ lấy được cả số âm và dương
        //Nếu muốn giới hạn 5 số nguyên dưương thì điền 5 số 9 vào trong nextInt()

        Random rand = new Random();
        System.out.println(prefixEmail + rand.nextInt(99999) + postFixEmail);
    }

}
