package Day6_Dropdown_SeleniumWaits;

import com.github.javafaker.Faker;
import org.junit.Test;
public class C01_Faker {
    // Faker üretmek için Faker Class'ından bir obje üretilir ve var olan meth.ları kullanırız
    @Test
    public void fakerExample(){
        // Faker objesini oluşturuyoruz
        Faker faker = new Faker();

        // Random bilgi verir
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.address().fullAddress());
    }
}
