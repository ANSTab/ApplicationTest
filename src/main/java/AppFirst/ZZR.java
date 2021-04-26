package AppFirst;



public class ZZR {
    private String name;
    private String dv;
    private String vid;

    @Override
    public String toString() {
        return "ZZR{" +
                "name='" + name + '\'' +
                ", dv='" + dv + '\'' +
                ", vid='" + vid + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public ZZR(String name, String dv, String vid) {
        this.name = name;
        this.dv = dv;
        this.vid = vid;
    }
}
