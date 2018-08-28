package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.a;
import com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.b;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.sdk.platformtools.x;

class VideoSegmentUI$4 implements d {
    final /* synthetic */ VideoSegmentUI lnn;

    VideoSegmentUI$4(VideoSegmentUI videoSegmentUI) {
        this.lnn = videoSegmentUI;
    }

    public final void P(int i, int i2, int i3) {
        if (i <= 0 || i2 <= 0) {
            x.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged wrong size (%d, %d) invoked = %b", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(VideoSegmentUI.q(this.lnn))});
        } else if (VideoSegmentUI.q(this.lnn)) {
            x.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged surface has invoked");
        } else {
            x.i("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged (%d, %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            VideoSegmentUI.r(this.lnn);
            if (i2 <= 0 || i <= 0) {
                x.e("MicroMsg.VideoSegmentUI", "This video has wrong size (%dx%d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                VideoSegmentUI.m(this.lnn);
                this.lnn.finish();
                VideoSegmentUI.b(this.lnn);
                return;
            }
            a aVar = new a(this.lnn, VideoSegmentUI.s(this.lnn), i2, i, i3, new b(this.lnn, (byte) 0), (byte) 0);
            if (VideoSegmentUI.s(this.lnn).getWidth() <= 0 || VideoSegmentUI.s(this.lnn).getHeight() <= 0) {
                x.i("MicroMsg.VideoSegmentUI", "post init surface task after root measured.");
                VideoSegmentUI.s(this.lnn).post(aVar);
                return;
            }
            aVar.run();
        }
    }
}
