package com.tencent.mm.plugin.mmsight.segment;

import android.view.View;
import com.tencent.mm.plugin.mmsight.segment.VideoSegmentUI.d;
import com.tencent.mm.sdk.platformtools.x;

class VideoSegmentUI$d$1 implements Runnable {
    final /* synthetic */ d lny;

    VideoSegmentUI$d$1(d dVar) {
        this.lny = dVar;
    }

    public final void run() {
        if (VideoSegmentUI.t(this.lny.lnn) || this.lny.lnn.isFinishing() || VideoSegmentUI.j(this.lny.lnn) == null || VideoSegmentUI.d(this.lny.lnn) == null) {
            x.i("MicroMsg.VideoSegmentUI", "waiting end, main thread, activity not valid.");
            return;
        }
        ((View) VideoSegmentUI.j(this.lny.lnn)).setAlpha(0.0f);
        ((View) VideoSegmentUI.j(this.lny.lnn)).setVisibility(0);
        ((View) VideoSegmentUI.j(this.lny.lnn)).animate().setDuration(300).setStartDelay(200).alpha(1.0f);
        float beM = VideoSegmentUI.j(this.lny.lnn).beM();
        float beN = VideoSegmentUI.j(this.lny.lnn).beN();
        if ((beN - beM) * ((float) VideoSegmentUI.e(this.lny.lnn)) <= ((float) VideoSegmentUI.p(this.lny.lnn))) {
            this.lny.lnn.enableOptionMenu(true);
        }
        VideoSegmentUI.d(this.lny.lnn).setLoop((int) (beM * ((float) VideoSegmentUI.e(this.lny.lnn))), (int) (beN * ((float) VideoSegmentUI.e(this.lny.lnn))));
    }
}
