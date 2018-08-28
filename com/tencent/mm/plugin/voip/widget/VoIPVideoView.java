package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.smtt.sdk.WebView;

public class VoIPVideoView extends MMTextureView implements SurfaceTextureListener {
    private static final int[] lwq = new int[]{452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295};
    private SurfaceTexture aCZ;
    private int far;
    private int fas;
    private Paint lwr;
    private float oVU = 0.4f;
    private int oVV = 30;
    private int oVW = 30;
    private int oVX = 15;
    private float oVY = 0.02f;

    public VoIPVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public VoIPVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.lwr = new Paint();
        this.lwr.setColor(WebView.NIGHT_MODE_COLOR);
        this.lwr.setFilterBitmap(true);
        this.lwr.setTextSize(40.0f);
        setSurfaceTextureListener(this);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        String str = "MicroMsg.VoIP.VoIPVideoView";
        String str2 = "onSurfaceTextureAvailable %b %d %d";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(surfaceTexture != null);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        x.i(str, str2, objArr);
        this.aCZ = surfaceTexture;
        this.far = i;
        this.fas = i2;
        crS();
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z;
        String str = "MicroMsg.VoIP.VoIPVideoView";
        String str2 = "onSurfaceTextureSizeChanged %b %d %d";
        Object[] objArr = new Object[3];
        if (surfaceTexture != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        x.i(str, str2, objArr);
        this.far = i;
        this.fas = i2;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        boolean z = true;
        String str = "MicroMsg.VoIP.VoIPVideoView";
        String str2 = "onSurfaceTextureDestroyed %b";
        Object[] objArr = new Object[1];
        if (surfaceTexture == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        this.aCZ = null;
        this.fas = 0;
        this.far = 0;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        boolean z = true;
        String str = "MicroMsg.VoIP.VoIPVideoView";
        String str2 = "onSurfaceTextureUpdated %b";
        Object[] objArr = new Object[1];
        if (surfaceTexture == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
    }
}
