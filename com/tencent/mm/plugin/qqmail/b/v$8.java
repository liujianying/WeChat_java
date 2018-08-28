package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ab.f;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.qqmail.b.v.a;
import com.tencent.mm.sdk.platformtools.x;

class v$8 implements f {
    final /* synthetic */ v mdU;
    final /* synthetic */ a mdV;

    v$8(v vVar, a aVar) {
        this.mdU = vVar;
        this.mdV = aVar;
    }

    public final void a(int i, int i2, l lVar) {
        x.i("MicroMsg.ShareModeMailAppService", "composeSend, offset: %d, totalLen: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i >= i2) {
            x.i("MicroMsg.ShareModeMailAppService", "finish send");
            if (this.mdV != null) {
                this.mdV.bou();
            }
        }
    }
}
