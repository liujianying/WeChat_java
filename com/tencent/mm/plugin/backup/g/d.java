package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.ak.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.a.a;
import com.tencent.mm.plugin.chatroom.b.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends a {
    private static String TAG = "MicroMsg.BackupStorageModel";
    private static d gYO;
    private b gYP;
    private a gYQ;

    public static d asG() {
        if (gYO == null) {
            d dVar = new d();
            gYO = dVar;
            a(dVar);
        }
        return gYO;
    }

    public final void aqK() {
        gYO = null;
    }

    public final b asH() {
        if (this.gYP == null) {
            this.gYP = new b();
        }
        return this.gYP;
    }

    public final a asI() {
        if (this.gYQ == null) {
            this.gYQ = new a();
        }
        return this.gYQ;
    }

    public final void asJ() {
        x.i(TAG, "backupInitStorage");
        b asH = asH();
        au.HU();
        String Gq = c.Gq();
        au.HU();
        x.i("MicroMsg.BackupStorage", "setBackupStorage, accPath:%s, accUin:%d, caller:%s", new Object[]{Gq, Integer.valueOf(c.Df()), bi.cjd()});
        asH.uin = r2;
        asH.dqp = Gq;
        au.HU();
        asH.dqq = c.FO();
        au.HU();
        asH.gYC = c.DT();
        au.HU();
        asH.gYD = c.FR();
        au.HU();
        asH.gYF = c.FW();
        au.HU();
        asH.gYE = c.FT();
        au.HU();
        asH.gYI = c.FZ();
        asH.gYG = o.Pf();
        asH.gYH = i.aEA().igx;
        asH.gYK = ((b) g.l(b.class)).Ga();
        asH.gYJ = com.tencent.mm.modelvideo.o.Ta();
        asH.gYL = com.tencent.mm.plugin.ac.a.bmg();
        asH.gYM = com.tencent.mm.plugin.ac.a.bmf();
        asH.gYN = com.tencent.mm.plugin.ac.a.asF();
    }
}
