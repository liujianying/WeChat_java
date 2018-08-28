package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.mm.plugin.backup.a.a;
import java.util.HashMap;

public final class d extends a {
    private static String TAG = "MicroMsg.BakOldItemFactory";
    private static d gZd;
    private HashMap<Integer, j> gVR;

    public static d asM() {
        if (gZd == null) {
            d dVar = new d();
            gZd = dVar;
            a(dVar);
        }
        return gZd;
    }

    public final void aqK() {
        gZd = null;
    }

    public final j mN(int i) {
        if (this.gVR == null) {
            this.gVR = new HashMap();
            this.gVR.put(Integer.valueOf(3), new e());
            this.gVR.put(Integer.valueOf(47), new c());
            this.gVR.put(Integer.valueOf(49), new b());
            this.gVR.put(Integer.valueOf(34), new h());
            g gVar = new g();
            this.gVR.put(Integer.valueOf(43), gVar);
            this.gVR.put(Integer.valueOf(44), gVar);
            this.gVR.put(Integer.valueOf(62), gVar);
            f fVar = new f();
            this.gVR.put(Integer.valueOf(48), fVar);
            this.gVR.put(Integer.valueOf(42), fVar);
            this.gVR.put(Integer.valueOf(66), fVar);
            this.gVR.put(Integer.valueOf(10000), fVar);
            this.gVR.put(Integer.valueOf(1), fVar);
            this.gVR.put(Integer.valueOf(37), fVar);
            this.gVR.put(Integer.valueOf(40), fVar);
            this.gVR.put(Integer.valueOf(50), fVar);
        }
        return (j) this.gVR.get(Integer.valueOf(i));
    }
}
