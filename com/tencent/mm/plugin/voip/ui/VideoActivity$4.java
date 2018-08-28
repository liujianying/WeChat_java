package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.b.b;

class VideoActivity$4 implements Runnable {
    final /* synthetic */ VideoActivity oQn;

    VideoActivity$4(VideoActivity videoActivity) {
        this.oQn = videoActivity;
    }

    public final void run() {
        if (b.yW(VideoActivity.b(this.oQn)) && !VideoActivity.c(this.oQn) && VideoActivity.d(this.oQn) != null) {
            VideoActivity.d(this.oQn).co(this.oQn.getString(R.l.voip_callout_timeout_prompt), 10000);
        }
    }
}
