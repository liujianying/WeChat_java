package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.x;

class VideoSightCenterView$2 implements f {
    final /* synthetic */ VideoSightCenterView qTQ;

    VideoSightCenterView$2(VideoSightCenterView videoSightCenterView) {
        this.qTQ = videoSightCenterView;
    }

    public final void b(b bVar, long j) {
        if (this.qTQ.duration == 0) {
            this.qTQ.duration = this.qTQ.getDuration();
        }
        if (this.qTQ.ndD != null) {
            x.v("MicroMsg.VideoSightCenterView", "onPlayTime, currentTime: %s, duration: %s", new Object[]{Long.valueOf(j), Integer.valueOf(this.qTQ.duration)});
            VideoSightCenterView.a(this.qTQ, (int) (1000 * j));
            this.qTQ.ndD.ck((int) j, this.qTQ.duration);
        }
    }
}
