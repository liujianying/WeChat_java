package com.tencent.mm.plugin.mmsight.segment;

import android.view.View;
import com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.c;
import com.tencent.mm.plugin.mmsight.segment.a.c.a;

class VideoSegmentUI$3 implements a {
    final /* synthetic */ VideoSegmentUI lnn;
    private Runnable lno;

    VideoSegmentUI$3(VideoSegmentUI videoSegmentUI) {
        this.lnn = videoSegmentUI;
    }

    public final void sZ(int i) {
        if (VideoSegmentUI.j(this.lnn) != null) {
            if (this.lno != null) {
                ((View) VideoSegmentUI.j(this.lnn)).removeCallbacks(this.lno);
            }
            this.lno = new c(VideoSegmentUI.j(this.lnn), i, VideoSegmentUI.e(this.lnn));
            ((View) VideoSegmentUI.j(this.lnn)).post(this.lno);
        }
    }
}
