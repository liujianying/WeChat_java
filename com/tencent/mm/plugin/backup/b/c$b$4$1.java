package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.backup.b.c.b.4;
import com.tencent.mm.plugin.backup.f.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;

class c$b$4$1 implements e {
    final /* synthetic */ boolean gSK;
    final /* synthetic */ ae gSL;
    final /* synthetic */ 4 gSM;

    c$b$4$1(4 4, boolean z, ae aeVar) {
        this.gSM = 4;
        this.gSK = z;
        this.gSL = aeVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i(this.gSM.gSD.TAG, "Send Tag finish last:%b  cv:%s [%d,%d,%s] tag[%s,%s]", new Object[]{Boolean.valueOf(this.gSK), this.gSL, Integer.valueOf(i), Integer.valueOf(i2), str, this.gSM.gSD.gSv, ((d) lVar).gXU.hcR});
        if (this.gSK && this.gSM.gSD.gSv.equals(r0)) {
            this.gSL.open();
        }
    }
}
