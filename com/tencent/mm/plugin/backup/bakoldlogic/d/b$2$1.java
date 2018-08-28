package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.a.e;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.plugin.backup.bakoldlogic.d.b.2;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class b$2$1 implements a {
    final /* synthetic */ 2 hbh;

    b$2$1(2 2) {
        this.hbh = 2;
    }

    public final boolean Ks() {
        x.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb onPostExecute");
        this.hbh.hbg.run();
        com.tencent.mm.sdk.b.a.sFg.m(new pj());
        return false;
    }

    public final boolean Kr() {
        x.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb doInBackground start");
        x.chR();
        b.atr();
        e.k(new File(com.tencent.mm.plugin.backup.bakoldlogic.a.a.asK()));
        a atn = this.hbh.hbe.atn();
        atn.handler.post(new a$2(atn));
        x.i("MicroMsg.BakOldTempDbModel", "bakoldRecoverFromTempDb doInBackground end");
        x.chR();
        return true;
    }

    public final String toString() {
        return super.toString() + "|bakoldRecoverFromTempDb";
    }
}
