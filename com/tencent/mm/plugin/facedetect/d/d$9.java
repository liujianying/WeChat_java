package com.tencent.mm.plugin.facedetect.d;

import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.d.a.b;
import com.tencent.mm.plugin.facedetect.d.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class d$9 implements b {
    final /* synthetic */ d iPx;

    d$9(d dVar) {
        this.iPx = dVar;
    }

    public final void aKb() {
        synchronized (this.iPx.iPq) {
            x.i("MicroMsg.NumberFaceMotion", "hy: triggered read symbol");
            if (!this.iPx.iPk && this.iPx.iPl) {
                this.iPx.iPk = true;
                d.b(this.iPx);
            }
        }
    }

    public final void onError(int i) {
        synchronized (this.iPx.iPq) {
            x.w("MicroMsg.NumberFaceMotion", "hy: on voice prepare error: %d", new Object[]{Integer.valueOf(i)});
            switch (i) {
                case 11:
                    this.iPx.iPi = true;
                    break;
                default:
                    this.iPx.iPr = true;
                    this.iPx.iPs = new a(ad.getResources().getString(h.permission_microphone_request_again_msg));
                    break;
            }
        }
    }
}
