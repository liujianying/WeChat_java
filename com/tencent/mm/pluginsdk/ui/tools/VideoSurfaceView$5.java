package com.tencent.mm.pluginsdk.ui.tools;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mm.sdk.platformtools.x;

class VideoSurfaceView$5 implements Callback {
    final /* synthetic */ VideoSurfaceView qUd;

    VideoSurfaceView$5(VideoSurfaceView videoSurfaceView) {
        this.qUd = videoSurfaceView;
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        x.i("MicroMsg.VideoSurfaceView", "on surface changed %d*%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (VideoSurfaceView.g(this.qUd) != null && VideoSurfaceView.i(this.qUd) && VideoSurfaceView.a(this.qUd) == i2 && VideoSurfaceView.b(this.qUd) == i3) {
            VideoSurfaceView.g(this.qUd).start();
        }
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        x.i("MicroMsg.VideoSurfaceView", "on surface created");
        VideoSurfaceView.a(this.qUd, surfaceHolder);
        VideoSurfaceView.j(this.qUd);
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        x.i("MicroMsg.VideoSurfaceView", "on surface destroyed");
        VideoSurfaceView.a(this.qUd, null);
        if (VideoSurfaceView.g(this.qUd) != null) {
            VideoSurfaceView.e(this.qUd).ck(VideoSurfaceView.g(this.qUd).getCurrentPosition(), VideoSurfaceView.g(this.qUd).getDuration());
            VideoSurfaceView.g(this.qUd).reset();
            VideoSurfaceView.g(this.qUd).release();
            VideoSurfaceView.k(this.qUd);
        }
    }
}
