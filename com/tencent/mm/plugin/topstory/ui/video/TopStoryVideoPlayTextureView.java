package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import com.tencent.mm.plugin.u.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class TopStoryVideoPlayTextureView extends VideoPlayerTextureView {
    private Object lock = new Object();

    public TopStoryVideoPlayTextureView(Context context) {
        super(context);
    }

    public TopStoryVideoPlayTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TopStoryVideoPlayTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setVideoPath(String str) {
        super.setVideoPath(str);
    }

    protected final void aMN() {
        x.i("MicroMsg.TopStory.TopStoryVideoPlayTextureView", "%d open video [%s]", new Object[]{Integer.valueOf(hashCode()), this.path});
        synchronized (this.lock) {
            if (this.qTy != null) {
                this.qTy.ldz = null;
                this.qTy.ldy.stop();
                this.qTy.release();
                this.qTy = null;
            }
            if (bi.oW(this.path)) {
                x.w("MicroMsg.TopStory.TopStoryVideoPlayTextureView", "%d open video but path is null.", new Object[]{Integer.valueOf(hashCode())});
                return;
            }
            try {
                this.Fd = false;
                this.qTy = new i(Looper.getMainLooper());
                this.qTy.setPath(this.path);
                this.qTy.setIOnlineCache(this.ldj);
                this.qTy.setNeedResetExtractor(this.ldb);
                this.qTy.setIsOnlineVideoType(this.ldc);
                this.qTy.ldz = this.qTK;
                this.qTy.setSurface(this.mSurface);
                this.qTy.gr(this.qTH);
                if (this.mSurface != null) {
                    this.qTy.bdz();
                } else if (this.qTD) {
                    this.qTy.bdz();
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoPlayTextureView", e, "prepare async error %s", new Object[]{e.getMessage()});
                if (this.ndD != null) {
                    this.ndD.onError(-1, -1);
                }
            }
        }
    }

    public final void stop() {
        e.post(new 1(this), "player-stop");
    }

    public final boolean start() {
        boolean start;
        synchronized (this.lock) {
            start = super.start();
        }
        return start;
    }

    public final void pause() {
        synchronized (this.lock) {
            super.pause();
        }
    }

    public final void x(double d) {
        synchronized (this.lock) {
            super.x(d);
        }
    }

    public void setMute(boolean z) {
        synchronized (this.lock) {
            super.setMute(z);
        }
    }
}
