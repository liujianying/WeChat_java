package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.TimeUnit;

class VideoSegmentUI$d implements Runnable {
    final /* synthetic */ VideoSegmentUI lnn;

    private VideoSegmentUI$d(VideoSegmentUI videoSegmentUI) {
        this.lnn = videoSegmentUI;
    }

    /* synthetic */ VideoSegmentUI$d(VideoSegmentUI videoSegmentUI, byte b) {
        this(videoSegmentUI);
    }

    public final void run() {
        boolean await;
        try {
            await = VideoSegmentUI.o(this.lnn).await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            x.e("MicroMsg.VideoSegmentUI", "count down latch error %s", new Object[]{e});
            await = false;
        }
        if (await) {
            try {
                if (!(VideoSegmentUI.t(this.lnn) || this.lnn.isFinishing() || VideoSegmentUI.u(this.lnn) == null || !VideoSegmentUI.u(this.lnn).isValid())) {
                    if (VideoSegmentUI.d(this.lnn) != null) {
                        VideoSegmentUI.d(this.lnn).a(null);
                        VideoSegmentUI.d(this.lnn).a(null);
                        VideoSegmentUI.d(this.lnn).release();
                        VideoSegmentUI.v(this.lnn);
                    }
                    try {
                        VideoSegmentUI.a(this.lnn, VideoSegmentUI.u(this.lnn));
                        VideoSegmentUI.d(this.lnn).setSurface(VideoSegmentUI.u(this.lnn));
                        ah.A(new 1(this));
                        return;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.VideoSegmentUI", e2, "init segmentPlayer second time %s", new Object[]{e2.getMessage()});
                        this.lnn.finish();
                        return;
                    }
                }
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.VideoSegmentUI", e22, "Finished when init", new Object[0]);
                this.lnn.finish();
                return;
            }
        }
        String str = "MicroMsg.VideoSegmentUI";
        String str2 = "Waiting Prepared error result[%b] needFinish[%b] isFinishing[%b] mSurface is null[%b]";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(await);
        objArr[1] = Boolean.valueOf(VideoSegmentUI.t(this.lnn));
        objArr[2] = Boolean.valueOf(this.lnn.isFinishing());
        objArr[3] = Boolean.valueOf(VideoSegmentUI.u(this.lnn) == null);
        x.w(str, str2, objArr);
        this.lnn.finish();
    }
}
