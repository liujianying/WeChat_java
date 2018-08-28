package e;

import com.tencent.tencentmap.mapsdk.a.md;
import com.tencent.tencentmap.mapsdk.a.me;
import com.tencent.tencentmap.mapsdk.a.mf;

public final class c extends mf {
    public String bvp = "";
    public String imei = "";
    public String srZ = "";
    public long uin = 0;
    public String vHA = "";
    public String vHB = "";
    public long vHw = 0;
    public int vHx = 0;
    public String vHy = "";
    public boolean vHz = true;
    public String version = "";
    public double x = 0.0d;
    public double y = 0.0d;

    public final void writeTo(me meVar) {
        meVar.a(this.vHw, 0);
        meVar.a(this.srZ, 1);
        meVar.a(this.uin, 2);
        meVar.a(this.vHx, 3);
        if (this.imei != null) {
            meVar.a(this.imei, 4);
        }
        meVar.a(this.x, 5);
        meVar.a(this.y, 6);
        if (this.vHy != null) {
            meVar.a(this.vHy, 7);
        }
        if (this.version != null) {
            meVar.a(this.version, 8);
        }
        meVar.a(this.vHz, 9);
        if (this.vHA != null) {
            meVar.a(this.vHA, 10);
        }
        if (this.vHB != null) {
            meVar.a(this.vHB, 11);
        }
        if (this.bvp != null) {
            meVar.a(this.bvp, 12);
        }
    }

    public final void readFrom(md mdVar) {
        this.vHw = mdVar.a(this.vHw, 0, true);
        this.srZ = mdVar.a(1, true);
        this.uin = mdVar.a(this.uin, 2, true);
        this.vHx = mdVar.a(this.vHx, 3, true);
        this.imei = mdVar.a(4, false);
        this.x = mdVar.a(this.x, 5, false);
        this.y = mdVar.a(this.y, 6, false);
        this.vHy = mdVar.a(7, false);
        this.version = mdVar.a(8, false);
        this.vHz = mdVar.a(this.vHz, 9, false);
        this.vHA = mdVar.a(10, false);
        this.vHB = mdVar.a(11, false);
        this.bvp = mdVar.a(12, false);
    }
}
