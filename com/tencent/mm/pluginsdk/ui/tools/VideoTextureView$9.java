package com.tencent.mm.pluginsdk.ui.tools;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.x;

class VideoTextureView$9 implements SurfaceTextureListener {
    final /* synthetic */ VideoTextureView qUl;

    VideoTextureView$9(VideoTextureView videoTextureView) {
        this.qUl = videoTextureView;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        if (VideoTextureView.j(this.qUl)) {
            if (VideoTextureView.a(this.qUl) != null) {
                VideoTextureView.a(this.qUl).pause();
                if (VideoTextureView.m(this.qUl)) {
                    VideoTextureView.a(this.qUl).setVolume(0.0f, 0.0f);
                } else {
                    VideoTextureView.a(this.qUl).setVolume(1.0f, 1.0f);
                }
            }
            VideoTextureView.a(this.qUl, false);
        }
        if (VideoTextureView.n(this.qUl) > 0 && VideoTextureView.o(this.qUl) != null) {
            VideoTextureView.o(this.qUl).bfs();
            VideoTextureView.p(this.qUl);
        }
        VideoTextureView.a(this.qUl, System.currentTimeMillis());
        if (VideoTextureView.q(this.qUl)) {
            x.i("MicroMsg.VideoTextureView", "%d flush surface pause now time[%d]", new Object[]{Integer.valueOf(this.qUl.hashCode()), Integer.valueOf(this.qUl.getCurrentPosition())});
            if (VideoTextureView.a(this.qUl) != null) {
                VideoTextureView.a(this.qUl).pause();
                this.qUl.setMute(VideoTextureView.m(this.qUl));
            }
            VideoTextureView.r(this.qUl);
        }
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.VideoTextureView", "on texture size changed width : " + i + " height : " + i2);
        if (VideoTextureView.a(this.qUl) != null && VideoTextureView.s(this.qUl) && VideoTextureView.b(this.qUl) == i && VideoTextureView.c(this.qUl) == i2) {
            VideoTextureView.a(this.qUl).start();
        }
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        x.i("MicroMsg.VideoTextureView", "%d on texture destroyed mIsPrepared[%b]", new Object[]{Integer.valueOf(this.qUl.hashCode()), Boolean.valueOf(VideoTextureView.s(this.qUl))});
        VideoTextureView.a(this.qUl, null);
        if (VideoTextureView.a(this.qUl) == null || !VideoTextureView.s(this.qUl)) {
            VideoTextureView.t(this.qUl);
            VideoTextureView.b(this.qUl, false);
        } else if (this.qUl.isPlaying()) {
            VideoTextureView.b(this.qUl, true);
            VideoTextureView.a(this.qUl).pause();
        }
        return false;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        VideoTextureView.d(this.qUl, i);
        VideoTextureView.e(this.qUl, i2);
        this.qUl.crS();
        VideoTextureView.a(this.qUl, new Surface(surfaceTexture));
        x.i("MicroMsg.VideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", new Object[]{Integer.valueOf(this.qUl.hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(VideoTextureView.s(this.qUl)), Integer.valueOf(VideoTextureView.u(this.qUl).hashCode())});
        if (VideoTextureView.a(this.qUl) == null || !VideoTextureView.s(this.qUl)) {
            VideoTextureView.v(this.qUl);
        } else {
            VideoTextureView.a(this.qUl).setSurface(VideoTextureView.u(this.qUl));
            if (VideoTextureView.w(this.qUl)) {
                VideoTextureView.a(this.qUl).start();
            } else {
                VideoTextureView.a(this.qUl, true);
                VideoTextureView.a(this.qUl).setVolume(0.0f, 0.0f);
                VideoTextureView.a(this.qUl).start();
            }
            VideoTextureView.b(this.qUl, false);
        }
        if (VideoTextureView.x(this.qUl) != null) {
            VideoTextureView.x(this.qUl).SP();
        }
    }
}
