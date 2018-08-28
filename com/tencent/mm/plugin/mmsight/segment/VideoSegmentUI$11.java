package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.segment.a.a.c;
import com.tencent.mm.sdk.platformtools.x;

class VideoSegmentUI$11 implements c {
    final /* synthetic */ VideoSegmentUI lnn;

    VideoSegmentUI$11(VideoSegmentUI videoSegmentUI) {
        this.lnn = videoSegmentUI;
    }

    public final void bH(Object obj) {
        try {
            if (VideoSegmentUI.d(this.lnn) != null) {
                VideoSegmentUI.d(this.lnn).start();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "hy: exception when onSeekComplete waiting for starting", new Object[0]);
        }
    }
}
