package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.segment.c.b;

class VideoSegmentUI$2 implements b {
    final /* synthetic */ VideoSegmentUI lnn;

    VideoSegmentUI$2(VideoSegmentUI videoSegmentUI) {
        this.lnn = videoSegmentUI;
    }

    public final void K(float f, float f2) {
        if (VideoSegmentUI.d(this.lnn) != null) {
            int e = VideoSegmentUI.e(this.lnn);
            VideoSegmentUI.d(this.lnn).setLoop((int) (((float) e) * f), (int) (((float) e) * f2));
            VideoSegmentUI.d(this.lnn).seekTo((int) (((float) e) * f));
        }
    }

    public final void beO() {
        if (VideoSegmentUI.d(this.lnn) != null) {
            VideoSegmentUI.d(this.lnn).pause();
        }
    }

    public final void L(float f, float f2) {
        if (VideoSegmentUI.d(this.lnn) != null) {
            int e = (int) (((float) VideoSegmentUI.e(this.lnn)) * f);
            VideoSegmentUI.d(this.lnn).setLoop(e, (int) (((float) VideoSegmentUI.e(this.lnn)) * f2));
            VideoSegmentUI.d(this.lnn).seekTo(e);
        }
    }

    public final void M(float f, float f2) {
        if ((f2 - f) * ((float) VideoSegmentUI.e(this.lnn)) <= ((float) VideoSegmentUI.p(this.lnn))) {
            this.lnn.enableOptionMenu(true);
        } else {
            this.lnn.enableOptionMenu(false);
        }
    }
}
