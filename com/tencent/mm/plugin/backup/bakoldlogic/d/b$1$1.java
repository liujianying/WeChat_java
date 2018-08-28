package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.mm.plugin.backup.bakoldlogic.d.b.1;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1$1 implements a {
    final /* synthetic */ 1 hbf;

    b$1$1(1 1) {
        this.hbf = 1;
    }

    public final boolean Ks() {
        x.i("MicroMsg.BakOldTempDbModel", "initTempDB onPostExecute");
        this.hbf.hbc.run();
        b.wz();
        return false;
    }

    public final boolean Kr() {
        b.atq();
        b.a(this.hbf.hbe, new PLong(), new PLong(), new PLong(), this.hbf.hbc, this.hbf.hbd);
        return true;
    }

    public final String toString() {
        return super.toString() + "|initTempDB";
    }
}
