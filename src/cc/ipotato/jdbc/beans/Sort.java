package cc.ipotato.jdbc.beans;

/**
 * Created by haohao on 2018/5/25.
 */
public class Sort {
    private int sid;
    private String sname;
    private double sprice;
    private String sdesc;

    public Sort(int sid, String sname, double sprice, String sdesc) {
        this.sid = sid;
        this.sname = sname;
        this.sprice = sprice;
        this.sdesc = sdesc;
    }

    public Sort() {}

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setSprice(double sprice) {
        this.sprice = sprice;
    }

    public void setSdesc(String sdesc) {
        this.sdesc = sdesc;
    }

    public int getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public double getSprice() {
        return sprice;
    }

    public String getSdesc() {
        return sdesc;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", sprice=" + sprice +
                ", sdesc='" + sdesc + '\'' +
                '}';
    }
}
