import java.math.BigDecimal;
import java.math.BigInteger;

public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger bi = new BigInteger("34123449480133333300891348789013809813408");
        BigInteger bia = new BigInteger("344280018888190");
//        System.out.println(bi.add(bia));
//        System.out.println(bi.multiply(bia));
        BigInteger[] result = bi.divideAndRemainder(bia);
        for(BigInteger b: result){
            System.out.println(b);
        }

        double d = 41314109980452313.4134444413;
        System.out.println(new BigDecimal(d).pow(4115134));
    }

}
