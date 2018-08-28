package com.tencent.mm.plugin.sysvideo.ui.video;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mm.sdk.platformtools.x;

class VideoRecorderUI$3 implements Callback {
    final /* synthetic */ VideoRecorderUI ovr;

    VideoRecorderUI$3(VideoRecorderUI videoRecorderUI) {
        this.ovr = videoRecorderUI;
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        x.d("MicroMsg.VideoRecorderUI", "surfaceCreated");
        if (VideoRecorderUI.h(this.ovr).a(this.ovr, VideoRecorderUI.q(this.ovr)) != 0) {
            VideoRecorderUI.s(this.ovr);
        }
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        x.d("MicroMsg.VideoRecorderUI", "surfaceDestroyed");
        VideoRecorderUI.b(this.ovr, true);
        VideoRecorderUI.h(this.ovr).ccP();
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        x.d("MicroMsg.VideoRecorderUI", "surfaceChanged for:" + i + " w:" + i2 + " h:" + i3);
        if (VideoRecorderUI.h(this.ovr).b(surfaceHolder) != 0) {
            VideoRecorderUI.s(this.ovr);
        }
        VideoRecorderUI.a(this.ovr, false);
        VideoRecorderUI.b(this.ovr, false);
        VideoRecorderUI.x(this.ovr);
    }
}
