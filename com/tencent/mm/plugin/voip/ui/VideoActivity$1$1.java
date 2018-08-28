package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.plugin.voip.ui.VideoActivity.1;
import com.tencent.mm.sdk.platformtools.x;

class VideoActivity$1$1 implements Runnable {
    final /* synthetic */ 1 oQo;

    VideoActivity$1$1(1 1) {
        this.oQo = 1;
    }

    public final void run() {
        if (this.oQo.oQn.oQd != null && this.oQo.oQn.oQd.get() != null) {
            boolean bKs = ((c) this.oQo.oQn.oQd.get()).bKs();
            boolean bKr = ((c) this.oQo.oQn.oQd.get()).bKr();
            boolean bKl = ((c) this.oQo.oQn.oQd.get()).bKl();
            x.i("MicroMsg.Voip.VideoActivity", "summerkick LogoutEvent ret[%b, %b, %b]", new Object[]{Boolean.valueOf(bKs), Boolean.valueOf(bKr), Boolean.valueOf(bKl)});
        }
    }
}
