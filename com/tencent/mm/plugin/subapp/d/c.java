package com.tencent.mm.plugin.subapp.d;

import com.tencent.mm.g.a.fm;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import org.xwalk.core.Log;

public final class c extends com.tencent.mm.sdk.b.c<fm> {
    public c() {
        this.sFo = fm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fm fmVar = (fm) bVar;
        if (fmVar == null) {
            return false;
        }
        if (bi.oW(fmVar.bNQ.fileName)) {
            Log.e("MicroMsg.VoiceTransformResultClickEventListener", "alvinluo fileName is null");
            return false;
        }
        p ow = m.TI().ow(fmVar.bNQ.fileName);
        if (ow == null) {
            Log.e("MicroMsg.VoiceTransformResultClickEventListener", "alvinluo voiceInfo is null");
            return false;
        }
        b.b(ow.clientId, fmVar.bNQ.bNR, fmVar.bNQ.bNS, fmVar.bNQ.bNT, fmVar.bNQ.result);
        return true;
    }
}
