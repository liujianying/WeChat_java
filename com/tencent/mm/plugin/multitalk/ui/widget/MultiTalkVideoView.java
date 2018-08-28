package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;

public class MultiTalkVideoView extends MMTextureView implements SurfaceTextureListener {
    private static final int[] lwq = new int[]{452984831, 369098751, 268435455, 369098751, 268435455, 184549375, 268435455, 184549375, 100663295};
    private SurfaceTexture aCZ;
    private int far;
    private int fas;
    private int index;
    private Paint lwr;
    private a lws = a.lww;
    private int position;
    private String username;

    public MultiTalkVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public MultiTalkVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        this.lwr = new Paint();
        this.lwr.setColor(-16777216);
        this.lwr.setFilterBitmap(false);
        this.lwr.setTextSize(40.0f);
        setSurfaceTextureListener(this);
    }

    public String getUsername() {
        return this.username;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public int getPosition() {
        return this.position;
    }

    public final synchronized void a(int[] iArr, int i, int i2, int i3) {
        if (bhd()) {
            o.bgO().a(this, iArr, i, i2, i3);
        }
    }

    public final synchronized void c(Bitmap bitmap, int i, int i2) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (!(this.aCZ == null || this.far == 0 || this.fas == 0)) {
                    Canvas lockCanvas = lockCanvas(null);
                    if (lockCanvas == null) {
                        x.e("MicroMsg.MT.MultiTalkVideoView", "%s getCanvasError", new Object[]{this.username});
                    } else {
                        Matrix matrix = new Matrix();
                        if (i == OpenGlRender.oUI) {
                            matrix.setRotate(270.0f, (float) (width / 2), (float) (height / 2));
                        } else if (i == OpenGlRender.oUH) {
                            matrix.setRotate(90.0f, (float) (width / 2), (float) (height / 2));
                        }
                        if (i2 == OpenGlRender.oUJ) {
                            matrix.postScale(-1.0f, 1.0f);
                            matrix.postTranslate((float) width, 0.0f);
                        }
                        matrix.postScale(((float) lockCanvas.getWidth()) / ((float) height), ((float) lockCanvas.getHeight()) / ((float) width));
                        lockCanvas.drawColor(0, Mode.CLEAR);
                        if (!bitmap.isRecycled()) {
                            lockCanvas.drawBitmap(bitmap, matrix, this.lwr);
                        }
                        try {
                            unlockCanvasAndPost(lockCanvas);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", e, "drawBitmap unlockCanvasAndPost crash", new Object[0]);
                        }
                    }
                }
            }
        }
        x.e("MicroMsg.MT.MultiTalkVideoView", "DrawBitmap, bitmap is null or recycled");
    }

    public final void bgX() {
        if (bhc()) {
            o.bgO().a(this, true);
        }
    }

    public final void bgY() {
        if (!bi.oW(getUsername())) {
            x.i("MicroMsg.MT.MultiTalkVideoView", "changeToAvatar %s from %s", new Object[]{getUsername(), this.lws.name()});
            this.lws = a.lwu;
            bgX();
        }
    }

    public final void bgZ() {
        x.i("MicroMsg.MT.MultiTalkVideoView", "changeToVideo %s from %s", new Object[]{getUsername(), this.lws.name()});
        this.lws = a.lwv;
    }

    public final void bha() {
        x.i("MicroMsg.MT.MultiTalkVideoView", "changeToNone %s from %s", new Object[]{getUsername(), this.lws.name()});
        this.lws = a.lww;
        this.username = null;
        bhb();
    }

    private void bhb() {
        if (this.aCZ != null && this.far != 0 && this.fas != 0) {
            Canvas lockCanvas = lockCanvas(null);
            if (lockCanvas == null) {
                x.e("MicroMsg.MT.MultiTalkVideoView", "getCanvasError canvas is null");
                return;
            }
            lockCanvas.drawColor(0, Mode.CLEAR);
            lockCanvas.drawColor(-14737113);
            lockCanvas.drawColor(lwq[this.index]);
            try {
                unlockCanvasAndPost(lockCanvas);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MT.MultiTalkVideoView", e, "drawNone unlockCanvasAndPost crash", new Object[0]);
            }
        }
    }

    public final void HS(String str) {
        x.i("MicroMsg.MT.MultiTalkVideoView", "changeUser from %s to %s", new Object[]{this.username, str});
        this.username = str;
    }

    public final void aoV() {
        if (bhc()) {
            o.bgO().a(this, false);
        } else if (bhd()) {
            l$a l_a = (l$a) o.bgO().luz.get(getUsername());
            Bitmap bitmap = l_a != null ? l_a.luC : null;
            if (bitmap != null) {
                c(bitmap, l_a.angle, l_a.luk);
            }
        } else {
            bhb();
        }
    }

    private boolean bhc() {
        return this.lws == a.lwu;
    }

    public final boolean bhd() {
        return this.lws == a.lwv;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = false;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureAvailable %s %b %d %d";
        Object[] objArr = new Object[4];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        x.i(str, str2, objArr);
        this.aCZ = surfaceTexture;
        this.far = i;
        this.fas = i2;
        crS();
        e.post(new 1(this), "onSurfaceTextureAvailable_refreshView");
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = false;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureSizeChanged %s %b %d %d";
        Object[] objArr = new Object[4];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        x.i(str, str2, objArr);
        this.far = i;
        this.fas = i2;
        e.post(new 2(this), "onSurfaceTextureSizeChanged_refreshView");
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        boolean z;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureDestroyed %s %b";
        Object[] objArr = new Object[2];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        this.aCZ = null;
        this.fas = 0;
        this.far = 0;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        boolean z = false;
        String str = "MicroMsg.MT.MultiTalkVideoView";
        String str2 = "onSurfaceTextureUpdated %s %b";
        Object[] objArr = new Object[2];
        objArr[0] = this.username;
        if (surfaceTexture != null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
    }
}
