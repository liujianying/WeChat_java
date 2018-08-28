package com.tencent.mm.plugin.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;

public class ObservableTextureView extends MMTextureView implements SurfaceTextureListener {
    protected SurfaceTexture aCZ;
    protected b oEJ;
    private boolean oEK = false;

    public ObservableTextureView(Context context) {
        super(context);
        init();
    }

    public ObservableTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ObservableTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void init() {
        setSurfaceTextureListener(this);
        this.aCZ = getSurfaceTexture();
    }

    public boolean isAvailable() {
        return this.oEK;
    }

    public void setTextureChangeCallback(b bVar) {
        this.oEJ = bVar;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.ObservableTextureView", "onSurfaceTextureAvailable");
        crS();
        this.oEK = true;
        if (this.oEJ != null) {
            this.oEJ.d(surfaceTexture);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.d("MicroMsg.ObservableTextureView", "onSurfaceTextureSizeChanged");
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        x.i("MicroMsg.ObservableTextureView", "onSurfaceTextureDestroyed");
        this.oEK = false;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
