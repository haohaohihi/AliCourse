package cc.ipotato.Enum.JdkEnum;

public enum Week2 {
    MON("星期一"), TUE("星期二"), WES("星期三");

    private String name;
    private Week2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
