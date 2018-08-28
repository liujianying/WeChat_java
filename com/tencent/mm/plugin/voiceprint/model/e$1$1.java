package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.voiceprint.model.e.1;
import com.tencent.mm.sdk.platformtools.x;

class e$1$1 implements e {
    final /* synthetic */ 1 oEV;

    e$1$1(1 1) {
        this.oEV = 1;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            this.oEV.oEU.a(this.oEV.oEU.dIX, this.oEV.oEU.diJ);
        } else {
            this.oEV.oEU.diJ.a(i, i2, "", this.oEV.oEU);
        }
    }
}
