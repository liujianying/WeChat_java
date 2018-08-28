package com.tencent.mm.modelvoiceaddr;

import android.os.Message;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class e$2 extends ag {
    final /* synthetic */ e eqC;

    e$2(e eVar) {
        this.eqC = eVar;
    }

    public final void handleMessage(Message message) {
        if (message.what == 2) {
            if (this.eqC.eqy != null) {
                this.eqC.eqy.TZ();
            }
        } else if (message.what == 0) {
            if (e.b(this.eqC) == 0) {
                x.d("MicroMsg.SceneVoiceAddr", "addSceneEndListener MMFunc_UploadInputVoice");
                g.DF().a(349, this.eqC);
            } else {
                g.DF().a(b.CTRL_INDEX, this.eqC);
            }
            if (e.b(this.eqC) != 0) {
                e.a(this.eqC, new c(e.d(this.eqC), e.b(this.eqC)));
            } else if (e.c(this.eqC)) {
                e.a(this.eqC, new d(e.d(this.eqC), 1));
            } else {
                e.a(this.eqC, new d(e.d(this.eqC), 0));
            }
            g.DF().a(e.e(this.eqC), 0);
        } else if (message.what == 3 && this.eqC.eqy != null) {
            this.eqC.eqy.a(new String[0], -1);
        }
    }
}
