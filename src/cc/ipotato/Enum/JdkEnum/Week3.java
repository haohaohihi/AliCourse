package cc.ipotato.Enum.JdkEnum;

public enum Week3 {
    MON("星期一") {
        public void show() {
            System.out.println("MON: 星期一");
        }
    }, TUE("星期二") {
        public void show() {
            System.out.println("TUE: 星期二");
        }
    }, WES("星期三") {
        public void show() {
            System.out.println("WES: 星期三");
        }
    };

    private String name;
    private Week3(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public abstract void show();
}
