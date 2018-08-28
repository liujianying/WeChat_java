package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.plugin.wear.model.f.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class g {
    private static int pJD = 0;
    private HashMap<String, f> pJE = new HashMap();

    public final synchronized f PK(String str) {
        f fVar;
        if (this.pJE.containsKey(str)) {
            fVar = (f) ((f) this.pJE.get(str)).clone();
        } else {
            pJD++;
            fVar = new f();
            fVar.talker = str;
            fVar.id = pJD;
            fVar.pJx = a.pJy;
            this.pJE.put(str, fVar);
            fVar = (f) fVar.clone();
        }
        return fVar;
    }

    public final synchronized void PL(String str) {
        x.i("MicroMsg.Wear.WearNotificationMap", "reset notification talker=%s", new Object[]{str});
        if (this.pJE.containsKey(str)) {
            ((f) this.pJE.get(str)).pJx = a.pJy;
            ((f) this.pJE.get(str)).pJw = 0;
        }
    }

    public final synchronized void a(f fVar) {
        x.i("MicroMsg.Wear.WearNotificationMap", "update notification=%s", new Object[]{fVar});
        this.pJE.put(fVar.talker, fVar);
    }

    public final synchronized void PM(String str) {
        if (this.pJE.containsKey(str)) {
            f fVar = (f) this.pJE.get(str);
            fVar.pJx = a.pJB;
            fVar.pJw = 0;
            x.i("MicroMsg.Wear.WearNotificationMap", "Update reply success, notification=%s", new Object[]{fVar});
        }
    }

    public final synchronized void ct(String str, int i) {
        if (this.pJE.containsKey(str)) {
            f fVar = (f) this.pJE.get(str);
            fVar.pJx = a.pJA;
            fVar.pJw = i;
            x.i("MicroMsg.Wear.WearNotificationMap", "Update ignore success, notification=%s", new Object[]{fVar});
        }
    }

    public final synchronized void PN(String str) {
        if (this.pJE.containsKey(str)) {
            ((f) this.pJE.get(str)).pJx = a.pJz;
            x.i("MicroMsg.Wear.WearNotificationMap", "Update showing success, notification=%s", new Object[]{r0});
        }
    }
}
