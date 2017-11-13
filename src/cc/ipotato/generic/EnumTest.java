package cc.ipotato.generic;

/**
 * Created by Hello on 2017/11/13.
 */

enum COLOR{
    RED("红色"), GREEN("绿色"), BLUE("蓝色");
    private String title;
    private COLOR(String title){
        this.title = title;
    }
    public String toString(){
        return this.title;
    }

}
public class EnumTest {
    public static void main(String[] args) {
        COLOR c = COLOR.BLUE;
        System.out.println(c.ordinal());
        for(COLOR i : COLOR.values()) {
            System.out.println(i);
        }
        switch(c){
            case BLUE:
                System.out.println("BLUE");
        }
     }
}
