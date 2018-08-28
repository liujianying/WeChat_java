package e;

import com.tencent.tencentmap.mapsdk.a.md;
import com.tencent.tencentmap.mapsdk.a.me;
import com.tencent.tencentmap.mapsdk.a.mf;
import java.util.ArrayList;

public final class a extends mf {
    static ArrayList<Integer> a = new ArrayList();
    public ArrayList<Integer> vHt = null;
    public short vHu = (short) 0;
    public short vHv = (short) 0;

    public final void writeTo(me meVar) {
        meVar.a(this.vHt, 0);
        meVar.a(this.vHu, 1);
        meVar.a(this.vHv, 2);
    }

    static {
        a.add(Integer.valueOf(0));
    }

    public final void readFrom(md mdVar) {
        this.vHt = (ArrayList) mdVar.a(a, 0, true);
        this.vHu = mdVar.a(this.vHu, 1, true);
        this.vHv = mdVar.a(this.vHv, 2, true);
    }
}
