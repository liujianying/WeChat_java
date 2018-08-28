package com.tencent.mm.plugin.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mm.sdk.platformtools.x;

public class ObservableSurfaceView extends SurfaceView implements Callback {
    protected SurfaceHolder fnG;
    private a oEF = null;
    protected boolean oEG = false;
    protected boolean oEH = false;
    protected boolean oEI = false;

    public ObservableSurfaceView(Context context) {
        super(context);
        init();
    }

    public ObservableSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ObservableSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.fnG = getHolder();
        this.fnG.addCallback(this);
    }

    public SurfaceHolder getSurfaceHolder() {
        return this.fnG;
    }

    public void setNeedSetType(boolean z) {
        this.oEI = z;
        if (this.oEI) {
            this.fnG.setType(3);
        }
    }

    public void setSurfaceChangeCallback(a aVar) {
        this.oEF = aVar;
        if (this.oEI) {
            this.fnG.setType(3);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.oEG = true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        x.d("MicroMsg.ObservableSurfaceView", "surfaceChanged");
        this.oEH = true;
        try {
            this.fnG.removeCallback(this);
        } catch (Exception e) {
        }
        this.fnG = surfaceHolder;
        this.fnG.addCallback(this);
        if (this.oEF != null) {
            this.oEF.a(this.fnG);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.oEG = false;
        this.oEH = false;
    }

    public final boolean bIT() {
        return this.oEG;
    }
}
