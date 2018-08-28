package com.tencent.xweb.extension.video;

class VideoStatusLayout$a implements Runnable {
    final /* synthetic */ VideoStatusLayout vBi;

    private VideoStatusLayout$a(VideoStatusLayout videoStatusLayout) {
        this.vBi = videoStatusLayout;
    }

    /* synthetic */ VideoStatusLayout$a(VideoStatusLayout videoStatusLayout, byte b) {
        this(videoStatusLayout);
    }

    public final void run() {
        this.vBi.setVisibility(8);
    }
}
