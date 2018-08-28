package com.tencent.mm.plugin.voip.ui;

import com.tencent.mm.R;

class VideoActivity$9 implements Runnable {
    final /* synthetic */ VideoActivity oQn;

    VideoActivity$9(VideoActivity videoActivity) {
        this.oQn = videoActivity;
    }

    public final void run() {
        if (VideoActivity.d(this.oQn) != null) {
            VideoActivity.d(this.oQn).co(this.oQn.getString(R.l.voip_shutdown_tip), -1);
        }
        VideoActivity.e(this.oQn);
    }
}
