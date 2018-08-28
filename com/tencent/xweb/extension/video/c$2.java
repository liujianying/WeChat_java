package com.tencent.xweb.extension.video;

import org.xwalk.core.R;

class c$2 implements Runnable {
    final /* synthetic */ c vCb;
    final /* synthetic */ boolean vCc;

    c$2(c cVar, boolean z) {
        this.vCb = cVar;
        this.vCc = z;
    }

    public final void run() {
        if (this.vCc) {
            c.k(this.vCb).setImageResource(R.drawable.xweb_video_play_btn);
        } else {
            c.k(this.vCb).setImageResource(R.drawable.xweb_video_stop_btn);
        }
    }
}
