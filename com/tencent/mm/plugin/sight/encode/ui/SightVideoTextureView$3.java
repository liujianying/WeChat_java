package com.tencent.mm.plugin.sight.encode.ui;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class SightVideoTextureView$3 implements Runnable {
    final /* synthetic */ SightVideoTextureView ngT;

    SightVideoTextureView$3(SightVideoTextureView sightVideoTextureView) {
        this.ngT = sightVideoTextureView;
    }

    public final void run() {
        try {
            this.ngT.bwB();
            SightVideoTextureView.e(this.ngT).stop();
            SightVideoTextureView.e(this.ngT).release();
            if (SightVideoTextureView.f(this.ngT) != null && SightVideoTextureView.f(this.ngT).isValid()) {
                SightVideoTextureView.f(this.ngT).release();
                SightVideoTextureView.a(this.ngT, null);
            }
        } catch (Throwable e) {
            x.w("MicroMsg.SightVideoTextureView", "stop play video error: %s, %s", e.getMessage(), bi.i(e));
        }
        SightVideoTextureView.a(this.ngT, null);
    }

    public final String toString() {
        return super.toString() + "|stopPlayVideo";
    }
}
