package com.tencent.mm.plugin.mmsight.segment;

import android.widget.Toast;
import com.tencent.mm.plugin.mmsight.segment.c.a;
import com.tencent.mm.plugin.mmsight.segment.k.f;
import com.tencent.mm.sdk.platformtools.x;

class VideoSegmentUI$12 implements a {
    final /* synthetic */ VideoSegmentUI lnn;

    VideoSegmentUI$12(VideoSegmentUI videoSegmentUI) {
        this.lnn = videoSegmentUI;
    }

    public final void gw(boolean z) {
        if (z) {
            Toast.makeText(this.lnn, f.mmsight_clip_failed, 1).show();
            x.e("MicroMsg.VideoSegmentUI", "Not Supported init SegmentSeekBar failed.");
            VideoSegmentUI.m(this.lnn);
            this.lnn.finish();
            VideoSegmentUI.b(this.lnn);
            return;
        }
        if (!(this.lnn.isFinishing() || VideoSegmentUI.j(this.lnn) == null)) {
            VideoSegmentUI.a(this.lnn, VideoSegmentUI.j(this.lnn).getDurationMs());
            x.i("MicroMsg.VideoSegmentUI", "SeekBar.onPrepared success %d", new Object[]{Integer.valueOf(VideoSegmentUI.e(this.lnn))});
            try {
                if (VideoSegmentUI.d(this.lnn) != null) {
                    VideoSegmentUI.d(this.lnn).setLoop((int) (((float) VideoSegmentUI.e(this.lnn)) * VideoSegmentUI.j(this.lnn).beM()), (int) (((float) VideoSegmentUI.e(this.lnn)) * VideoSegmentUI.j(this.lnn).beN()));
                }
            } catch (Exception e) {
            }
        }
        VideoSegmentUI.o(this.lnn).countDown();
    }
}
