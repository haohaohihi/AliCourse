import java.util.Base64;

public class Base64Test {
    public static void main(String[] args) {
        String o_s = "www.baidu.cm";
        String r_s = Base64.getEncoder().encodeToString(o_s.getBytes());
        System.out.println(r_s);

        byte data[] = Base64.getDecoder().decode(r_s);
        System.out.println(new String(data));

    }
}
