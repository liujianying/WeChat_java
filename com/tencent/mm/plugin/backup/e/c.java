package com.tencent.mm.plugin.backup.e;

import com.tencent.mm.plugin.backup.a.a;
import java.util.HashMap;

public final class c extends a {
    private static String TAG = "MicroMsg.BackupItemFactory";
    private static c gVQ;
    private HashMap<Integer, l> gVR;

    public static c arT() {
        if (gVQ == null) {
            c cVar = new c();
            gVQ = cVar;
            a(cVar);
        }
        return gVQ;
    }

    public final void aqK() {
        gVQ = null;
    }

    public final l mE(int i) {
        if (this.gVR == null) {
            this.gVR = new HashMap();
            this.gVR.put(Integer.valueOf(3), new d());
            this.gVR.put(Integer.valueOf(47), new b());
            this.gVR.put(Integer.valueOf(49), new a());
            this.gVR.put(Integer.valueOf(34), new g());
            f fVar = new f();
            this.gVR.put(Integer.valueOf(43), fVar);
            this.gVR.put(Integer.valueOf(44), fVar);
            this.gVR.put(Integer.valueOf(62), fVar);
            e eVar = new e();
            this.gVR.put(Integer.valueOf(48), eVar);
            this.gVR.put(Integer.valueOf(42), eVar);
            this.gVR.put(Integer.valueOf(66), eVar);
            this.gVR.put(Integer.valueOf(10000), eVar);
            this.gVR.put(Integer.valueOf(1), eVar);
            this.gVR.put(Integer.valueOf(37), eVar);
            this.gVR.put(Integer.valueOf(40), eVar);
            this.gVR.put(Integer.valueOf(50), eVar);
        }
        return (l) this.gVR.get(Integer.valueOf(i));
    }
}
