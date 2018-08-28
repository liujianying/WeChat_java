package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.voiceprint.model.g.1;
import com.tencent.mm.sdk.platformtools.x;

class g$1$1 implements e {
    final /* synthetic */ 1 oFe;

    g$1$1(1 1) {
        this.oFe = 1;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            this.oFe.oFd.a(this.oFe.oFd.dIX, this.oFe.oFd.diJ);
        } else {
            this.oFe.oFd.diJ.a(i, i2, "", this.oFe.oFd);
        }
    }
}
