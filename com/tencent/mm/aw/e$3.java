package com.tencent.mm.aw;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class e$3 implements e {
    final /* synthetic */ e ehE;

    e$3(e eVar) {
        this.ehE = eVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (e.c(this.ehE) != null) {
            x.d("MicroMsg.SpeexUploadCore", "onSceneEnd " + ((a) lVar).filename + " filepath " + e.c(this.ehE) + " errCode " + i2);
            if (((a) lVar).filename.equals(e.c(this.ehE))) {
                g.DF().b(d.CTRL_INDEX, e.d(this.ehE));
                if (i2 == 0) {
                    d.RI();
                    d.RK();
                }
                try {
                    x.d("MicroMsg.SpeexUploadCore", "delete " + e.c(this.ehE) + " delete " + new File(e.c(this.ehE)).delete() + " errCode " + i2);
                } catch (Throwable e) {
                    x.e("MicroMsg.SpeexUploadCore", "exception:%s", new Object[]{bi.i(e)});
                } finally {
                    e.RQ().start();
                    e.e(this.ehE);
                }
            }
        }
    }
}
