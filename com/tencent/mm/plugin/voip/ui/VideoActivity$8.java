package com.tencent.mm.plugin.voip.ui;

class VideoActivity$8 implements Runnable {
    final /* synthetic */ VideoActivity oQn;
    final /* synthetic */ String oQp;

    VideoActivity$8(VideoActivity videoActivity, String str) {
        this.oQn = videoActivity;
        this.oQp = str;
    }

    public final void run() {
        if (VideoActivity.d(this.oQn) != null) {
            VideoActivity.d(this.oQn).OH(this.oQp);
        }
    }
}
