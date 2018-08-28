package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

public class OpenGlView extends GLSurfaceView {
    private static String TAG = "OpenGlView";
    public boolean nAK;
    public boolean oUZ;
    public boolean oVa;
    public int oVb;
    WeakReference<OpenGlRender> oVc;

    public void dT(int i, int i2) {
        setLayoutParams(new LayoutParams(i, i2));
    }

    public OpenGlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oUZ = false;
        this.oVa = true;
        this.nAK = false;
        this.oVb = 1;
        this.oVb = OpenGlRender.bMg();
        getHolder().addCallback(this);
        try {
            getHolder().setType(2);
        } catch (Exception e) {
            try {
                getHolder().setType(1);
            } catch (Exception e2) {
                try {
                    getHolder().setType(0);
                } catch (Exception e3) {
                }
            }
        }
        if (this.oVb == 2) {
            setEGLContextFactory(new c());
            setEGLConfigChooser(new b());
        }
    }

    public void setRenderer(OpenGlRender openGlRender) {
        this.oVc = new WeakReference(openGlRender);
        super.setRenderer(openGlRender);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        x.i(TAG, "surfaceCreated");
        super.surfaceCreated(surfaceHolder);
        OpenGlRender openGlRender = (OpenGlRender) this.oVc.get();
        x.i(OpenGlRender.TAG, "%s surfaceCreated", new Object[]{Integer.valueOf(openGlRender.hashCode())});
        openGlRender.Init(OpenGlRender.bMg(), new WeakReference(openGlRender), openGlRender.mRenderMode);
        openGlRender.setParam(openGlRender.oUn, openGlRender.oUo, openGlRender.oUp, openGlRender.mRenderMode);
        openGlRender.setMode(((OpenGlView) openGlRender.oUx.get()).getWidth(), ((OpenGlView) openGlRender.oUx.get()).getHeight(), 0, openGlRender.mRenderMode);
        openGlRender.oUu = true;
        openGlRender.oUq = true;
        openGlRender.requestRender();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        x.i(TAG, "surfaceDestroyed");
        OpenGlRender openGlRender = (OpenGlRender) this.oVc.get();
        x.i(OpenGlRender.TAG, "%s onSurfaceDestroyed, mfInited: %s", new Object[]{Integer.valueOf(openGlRender.hashCode()), Boolean.valueOf(openGlRender.oUq)});
        if (openGlRender.oUq) {
            openGlRender.oUq = false;
            openGlRender.Uninit(openGlRender.mRenderMode);
            x.i(OpenGlRender.TAG, "%s steve: after Uninit in onSurfaceDestroyed", new Object[]{Integer.valueOf(openGlRender.hashCode())});
            openGlRender.oUl = 0;
            openGlRender.oUv = 0;
            openGlRender.oUw = 0;
        }
        super.surfaceDestroyed(surfaceHolder);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        x.i(TAG, "surfaceChanged, format: %s, w: %s, h: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        super.surfaceChanged(surfaceHolder, i, i2, i3);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void dU(int i, int i2) {
    }
}
