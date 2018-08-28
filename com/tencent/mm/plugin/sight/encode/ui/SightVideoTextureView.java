package com.tencent.mm.plugin.sight.encode.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.x;

@TargetApi(14)
public class SightVideoTextureView extends SightCameraView {
    private boolean mMute;
    private String nck;
    private MediaPlayer ngO;
    private TextureView ngP;
    private SurfaceTexture ngQ;
    private Surface ngR;
    private boolean ngS;

    public SightVideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ngP = null;
        this.ngQ = null;
        this.ngR = null;
        this.ngP = (TextureView) findViewById(R.h.surface_camera);
        this.ngP.setSurfaceTextureListener(new 1(this));
    }

    public SightVideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected void setIsMute(boolean z) {
        if (this.ngO != null) {
            try {
                if (!this.ngO.isPlaying()) {
                    return;
                }
                if (z) {
                    try {
                        this.ngO.setVolume(0.0f, 0.0f);
                        return;
                    } catch (Exception e) {
                        x.w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 0, 0 Fail: %s", new Object[]{e.getMessage()});
                        return;
                    }
                }
                bwA();
                try {
                    this.ngO.setVolume(1.0f, 1.0f);
                } catch (Exception e2) {
                    x.w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 1, 1 Fail: %s", new Object[]{e2.getMessage()});
                }
            } catch (Exception e22) {
                x.w("MicroMsg.SightVideoTextureView", "setIsMute %B, check MediaPlayer playing Fail: %s", new Object[]{Boolean.valueOf(z), e22.getMessage()});
            }
        }
    }

    public final void aP(String str, boolean z) {
        x.i("MicroMsg.SightVideoTextureView", "start play video, path %s, mute %B, wantPlay %B", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(this.ngS)});
        this.nck = str;
        this.mMute = z;
        if (this.ngQ == null) {
            x.w("MicroMsg.SightVideoTextureView", "play video fail, texture is null");
            this.ngS = true;
            return;
        }
        this.ngS = false;
        au.Em().H(new 2(this, str, z));
    }

    public final boolean isPlaying() {
        try {
            return this.ngO == null ? false : this.ngO.isPlaying();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SightVideoTextureView", e, "", new Object[0]);
            return false;
        }
    }

    public final void bwy() {
        x.i("MicroMsg.SightVideoTextureView", "stop play video, wantPlay %B", new Object[]{Boolean.valueOf(this.ngS)});
        if (this.ngO != null || this.ngS) {
            au.Em().H(new 3(this));
        } else {
            x.w("MicroMsg.SightVideoTextureView", "mediaplayer is null, do nothing when stop play video");
        }
    }

    protected int getSurfaceWidth() {
        if (this.ngP != null) {
            return this.ngP.getWidth();
        }
        return 0;
    }

    protected int getSurfaceHeight() {
        if (this.ngP != null) {
            return this.ngP.getHeight();
        }
        return 0;
    }

    protected Surface getPreviewSurface() {
        if (this.ngQ != null) {
            return new Surface(this.ngQ);
        }
        return null;
    }

    public void setFixPreviewRate(float f) {
        LayoutParams layoutParams = this.ngP.getLayoutParams();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        x.i("MicroMsg.SightVideoTextureView", "setFixPreviewRate [%f], dm[%d, %d]", new Object[]{Float.valueOf(f), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels)});
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = (int) (((float) displayMetrics.widthPixels) / f);
        x.i("MicroMsg.SightVideoTextureView", "setFixPreviewRate width:%d, height:%d", new Object[]{Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height)});
        this.ngP.setLayoutParams(layoutParams);
        super.setPreviewRate(f);
    }
}
