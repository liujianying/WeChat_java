package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView.2;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$2$1 implements Runnable {
    final /* synthetic */ boolean dSv;
    final /* synthetic */ 2 nPI;
    final /* synthetic */ String sl;

    OnlineVideoView$2$1(2 2, boolean z, String str) {
        this.nPI = 2;
        this.dSv = z;
        this.sl = str;
    }

    public final void run() {
        x.i("MicroMsg.OnlineVideoView", "%d weixin download finish[%b], go to prepare video", new Object[]{Integer.valueOf(this.nPI.nPH.hashCode()), Boolean.valueOf(this.dSv)});
        if (OnlineVideoView.e(this.nPI.nPH) != null && this.dSv && bi.fS(OnlineVideoView.e(this.nPI.nPH).ksA, this.sl)) {
            aq.eA(OnlineVideoView.a(this.nPI.nPH), "");
            String a = aq.a(OnlineVideoView.a(this.nPI.nPH), OnlineVideoView.e(this.nPI.nPH));
            if (!bi.oW(a)) {
                this.nPI.nPH.aX(a, false);
            }
        }
    }
}
