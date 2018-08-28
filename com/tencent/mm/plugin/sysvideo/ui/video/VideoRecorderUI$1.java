package com.tencent.mm.plugin.sysvideo.ui.video;

import android.os.SystemClock;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.i.e;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class VideoRecorderUI$1 implements a {
    final /* synthetic */ VideoRecorderUI ovr;

    VideoRecorderUI$1(VideoRecorderUI videoRecorderUI) {
        this.ovr = videoRecorderUI;
    }

    public final boolean vD() {
        if (VideoRecorderUI.a(this.ovr) == -1) {
            VideoRecorderUI.a(this.ovr, SystemClock.elapsedRealtime());
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - VideoRecorderUI.a(this.ovr);
        VideoRecorderUI.b(this.ovr).setText(e.iR((int) (elapsedRealtime / 1000)));
        if (elapsedRealtime > 30000 || elapsedRealtime < 20000) {
            VideoRecorderUI.c(this.ovr).setVisibility(8);
        } else {
            long j = (30000 - elapsedRealtime) / 1000;
            VideoRecorderUI.c(this.ovr).setVisibility(0);
            VideoRecorderUI.c(this.ovr).setText(this.ovr.getResources().getQuantityString(R.j.video_recorder_time_limit, (int) j, new Object[]{Long.valueOf(j)}));
        }
        if (elapsedRealtime >= 30000) {
            x.v("MicroMsg.VideoRecorderUI", "record stop on countdown");
            VideoRecorderUI.d(this.ovr);
            VideoRecorderUI.a(this.ovr, -1);
            return false;
        }
        VideoRecorderUI.a(this.ovr, VideoRecorderUI.e(this.ovr) % 2);
        if (VideoRecorderUI.e(this.ovr) == 0) {
            VideoRecorderUI.f(this.ovr).setVisibility(4);
        } else {
            VideoRecorderUI.f(this.ovr).setVisibility(0);
        }
        VideoRecorderUI.g(this.ovr);
        return true;
    }
}
