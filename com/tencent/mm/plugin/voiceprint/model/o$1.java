package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.g.a.sp;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class o$1 implements a {
    final /* synthetic */ o oFw;

    o$1(o oVar) {
        this.oFw = oVar;
    }

    public final boolean vD() {
        this.oFw.oFu += 100;
        this.oFw.oFv += (this.oFw.oFs.getMaxAmplitude() * 100) / 100;
        if (this.oFw.oFu < 3000) {
            return true;
        }
        boolean z;
        o oVar = this.oFw;
        x.d("MicroMsg.VoicePrintNoiseDetector", "onDetectFinish");
        oVar.oFs.we();
        oVar.oFt.SO();
        oVar.oFv /= 30;
        if (oVar.oFv >= 30) {
            z = true;
        } else {
            z = false;
        }
        x.d("MicroMsg.VoicePrintNoiseDetector", "average amplitude: %d, hasNoise:%b", new Object[]{Integer.valueOf(oVar.oFv), Boolean.valueOf(z)});
        sp spVar = new sp();
        spVar.cdt.cdu = z;
        com.tencent.mm.sdk.b.a.sFg.m(spVar);
        return false;
    }
}
