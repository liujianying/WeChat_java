package com.tencent.mm.plugin.sight.encode.ui;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class SightVideoTextureView$2 implements Runnable {
    final /* synthetic */ boolean iIq;
    final /* synthetic */ SightVideoTextureView ngT;
    final /* synthetic */ String ngU;

    SightVideoTextureView$2(SightVideoTextureView sightVideoTextureView, String str, boolean z) {
        this.ngT = sightVideoTextureView;
        this.ngU = str;
        this.iIq = z;
    }

    public final void run() {
        if (SightVideoTextureView.e(this.ngT) != null) {
            try {
                SightVideoTextureView.e(this.ngT).stop();
                SightVideoTextureView.e(this.ngT).release();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SightVideoTextureView", e, "", new Object[0]);
                x.w("MicroMsg.SightVideoTextureView", "try to release mediaplayer error");
            }
        }
        try {
            SightVideoTextureView.a(this.ngT, new j());
            SightVideoTextureView.e(this.ngT).setOnCompletionListener(new 1(this));
            SightVideoTextureView.e(this.ngT).setOnErrorListener(new OnErrorListener() {
                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    x.i("MicroMsg.SightVideoTextureView", "play %s error", SightVideoTextureView$2.this.ngU);
                    return false;
                }
            });
            SightVideoTextureView.e(this.ngT).setDataSource(this.ngU);
            SightVideoTextureView.a(this.ngT, this.ngT.getPreviewSurface());
            SightVideoTextureView.e(this.ngT).setSurface(SightVideoTextureView.f(this.ngT));
            SightVideoTextureView.e(this.ngT).setAudioStreamType(3);
            if (this.iIq) {
                SightVideoTextureView.e(this.ngT).setVolume(0.0f, 0.0f);
            } else {
                this.ngT.bwA();
            }
            SightVideoTextureView.e(this.ngT).setScreenOnWhilePlaying(true);
            SightVideoTextureView.e(this.ngT).setLooping(true);
            SightVideoTextureView.e(this.ngT).prepare();
            SightVideoTextureView.e(this.ngT).start();
        } catch (Throwable e2) {
            x.e("MicroMsg.SightVideoTextureView", "play %s, error: %s, %s", this.ngU, e2.getMessage(), bi.i(e2));
        }
    }

    public final String toString() {
        return super.toString() + "|playVideo";
    }
}
