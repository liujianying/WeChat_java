package com.tencent.mm.ar;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class i implements e {
    public i() {
        g.Eh().dpP.a(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        g.Eh().dpP.a(160, this);
        g.Eh().dpP.a(new k(5), 0);
    }

    private void release() {
        g.Eh().dpP.b(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        g.Eh().dpP.b(160, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if ((lVar instanceof n) && ((n) lVar).Lf() == 5) {
            int type = lVar.getType();
            if (type == JsApiGetBackgroundAudioState.CTRL_INDEX) {
                if (i == 0 && i2 == 0) {
                    Qk();
                    m[] ik = r.Qp().ik(5);
                    if (ik == null || ik.length == 0) {
                        x.i("MicroMsg.LangPackageUpdater", "error no pkg found.");
                        release();
                        return;
                    }
                    m mVar = ik[0];
                    x.i("MicroMsg.LangPackageUpdater", "dkregcode Pkg id:" + mVar.id + " version:" + mVar.version + " status:" + mVar.status + " type:" + mVar.bPh);
                    if (5 != mVar.status) {
                        release();
                        return;
                    }
                    g.Eh().dpP.a(new j(mVar.id, 5), 0);
                    return;
                }
                release();
                return;
            } else if (type == 160) {
                if (i == 0 && i2 == 0) {
                    Qk();
                }
                release();
                return;
            } else {
                return;
            }
        }
        x.d("MicroMsg.LangPackageUpdater", "another scene");
    }

    private static void Qk() {
        g.Ei().DT().set(81939, Long.valueOf(bi.VF()));
    }
}
