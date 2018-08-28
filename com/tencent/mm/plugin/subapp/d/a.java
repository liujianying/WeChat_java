package com.tencent.mm.plugin.subapp.d;

import com.tencent.mm.g.a.fl;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends c<fl> {
    public a() {
        this.sFo = fl.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fl flVar = (fl) bVar;
        if (flVar == null) {
            return false;
        }
        if (bi.oW(flVar.bNO.fileName)) {
            x.e("MicroMsg.VoiceTransformTextClickEventListener", "alvinluo fileName is null");
            return false;
        }
        p ow = m.TI().ow(flVar.bNO.fileName);
        if (ow == null) {
            x.e("MicroMsg.VoiceTransformTextClickEventListener", "alvinluo voiceInfo is null");
            return false;
        }
        String str;
        int i;
        if (flVar.bNO.bNP == 1 || flVar.bNO.bNP == 2) {
            str = ow.clientId;
            i = flVar.bNO.scene;
            x.i("MicroMsg.VoiceTransformTextReporter", "alvinluo reportTransformTextClick voiceId: %s, clickScene: %d", new Object[]{str, Integer.valueOf(i)});
            h.mEJ.h(14220, new Object[]{Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str});
        } else if (flVar.bNO.bNP == 3) {
            str = ow.clientId;
            i = flVar.bNO.scene;
            x.i("MicroMsg.VoiceTransformTextReporter", "alvinluo reportTransformTextDoubleClick voiceId: %s, clickScene: %d", new Object[]{str, Integer.valueOf(i)});
            h.mEJ.h(14220, new Object[]{Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str});
        }
        return true;
    }
}
