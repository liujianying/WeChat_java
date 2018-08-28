package com.tencent.mm.plugin.voip.ui;

class VideoActivity$7 implements Runnable {
    final /* synthetic */ int hdX;
    final /* synthetic */ VideoActivity oQn;

    VideoActivity$7(VideoActivity videoActivity, int i) {
        this.oQn = videoActivity;
        this.hdX = i;
    }

    public final void run() {
        VideoActivity.a(this.oQn, this.hdX);
    }
}
