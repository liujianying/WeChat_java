package com.tencent.mm.plugin.voip.video;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;

public final class e implements SurfaceTextureListener {
    int mWidth = 320;
    private final String oTK = "DecodeTextureView";
    public MMTextureView oTL;
    public SurfaceTexture oTM;
    int oTN = aq.CTRL_BYTE;

    public e() {
        x.d("DecodeTextureView", "steve:  new DecodeTextureView instance");
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        x.d("DecodeTextureView", "onSurfaceTextureAvailable size=" + i + "x" + i2 + ", st=" + surfaceTexture);
        if (this.oTM == null) {
            this.oTM = surfaceTexture;
            v2protocal.oPW = new Surface(surfaceTexture);
            x.i("DecodeTextureView", "steve: pass decoder surface successfully!");
        }
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.d("DecodeTextureView", "onSurfaceTextureSizeChanged size=" + i + "x" + i2 + ", st=" + surfaceTexture);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        x.d("DecodeTextureView", "onSurfaceTextureDestroyed st=" + surfaceTexture);
        return this.oTM == null;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
