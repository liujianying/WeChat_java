package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.voiceprint.model.h.1;
import com.tencent.mm.sdk.platformtools.x;

class h$1$1 implements e {
    final /* synthetic */ 1 oFg;

    h$1$1(1 1) {
        this.oFg = 1;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.NetSceneRsaVertifyVoicePrint", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            this.oFg.oFf.a(this.oFg.oFf.dIX, this.oFg.oFf.diJ);
        } else {
            this.oFg.oFf.diJ.a(i, i2, "", this.oFg.oFf);
        }
    }
}
