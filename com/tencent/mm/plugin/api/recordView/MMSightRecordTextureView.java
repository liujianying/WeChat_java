package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;

class MMSightRecordTextureView extends MMTextureView implements SurfaceTextureListener {
    private d faY;
    private c faZ;
    private int far;
    private int fas;

    public MMSightRecordTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setSurfaceTextureListener(this);
    }

    public MMSightRecordTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setSurfaceTextureListener(this);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.MMSightRecordTextureViewImpl", "onSurfaceTextureAvailable, surface: %s, width: %s, height: %s", new Object[]{surfaceTexture, Integer.valueOf(i), Integer.valueOf(i2)});
        this.far = i;
        this.fas = i2;
        this.faY = new d();
        this.faZ = new c(surfaceTexture, this.faY);
        this.faY.bz(i, i2);
        this.faZ.fbf = true;
        this.faZ.start();
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.MMSightRecordTextureViewImpl", "onSurfaceTextureSizeChanged, surface: %s, width: %s, height: %s", new Object[]{surfaceTexture, Integer.valueOf(i), Integer.valueOf(i2)});
        this.far = i;
        this.fas = i2;
        this.faY.bz(i, i2);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.faZ.fbf = false;
        try {
            this.faZ.join();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSightRecordTextureViewImpl", e, "onSurfaceTextureDestroyed error: %s", new Object[]{e.getMessage()});
        }
        this.faZ = null;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
