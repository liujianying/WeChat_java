package com.tencent.mm.plugin.sight.encode.ui;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.plugin.sight.encode.ui.SightCameraView.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;

class SightVideoTextureView$1 implements SurfaceTextureListener {
    final /* synthetic */ SightVideoTextureView ngT;

    SightVideoTextureView$1(SightVideoTextureView sightVideoTextureView) {
        this.ngT = sightVideoTextureView;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureAvailable, [%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.ngT.ngA = b.ngK;
        SightVideoTextureView.a(this.ngT, surfaceTexture);
        ((MMTextureView) SightVideoTextureView.a(this.ngT)).crS();
        x.i("MicroMsg.SightVideoTextureView", "available texture %s, wantPlay %B", new Object[]{surfaceTexture, Boolean.valueOf(SightVideoTextureView.b(this.ngT))});
        if (SightVideoTextureView.b(this.ngT)) {
            this.ngT.aP(SightVideoTextureView.c(this.ngT), SightVideoTextureView.d(this.ngT));
        }
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureSizeChanged, [%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.ngT.ngA = b.ngL;
        x.i("MicroMsg.SightVideoTextureView", "changed texture %s", new Object[]{surfaceTexture});
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        x.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureDestroyed");
        this.ngT.ngA = b.ngM;
        SightVideoTextureView.a(this.ngT, null);
        this.ngT.ngC = false;
        x.i("MicroMsg.SightVideoTextureView", "destroyed texture %s", new Object[]{surfaceTexture});
        return true;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
