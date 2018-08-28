package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.7;

class VideoSegmentUI$7$2 implements Runnable {
    final /* synthetic */ 7 lnp;
    final /* synthetic */ boolean lnq;
    final /* synthetic */ String lnr;

    VideoSegmentUI$7$2(7 7, boolean z, String str) {
        this.lnp = 7;
        this.lnq = z;
        this.lnr = str;
    }

    public final void run() {
        if (this.lnp.lnn.eHw != null) {
            this.lnp.lnn.eHw.dismiss();
        }
        if (this.lnp.lnn.lne != null) {
            this.lnp.lnn.lne.gv(false);
        }
        VideoSegmentUI.a(this.lnp.lnn, this.lnq, this.lnr);
    }
}
