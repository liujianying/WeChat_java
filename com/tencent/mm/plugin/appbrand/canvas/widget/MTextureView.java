package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MTextureView extends TextureView implements SurfaceTextureListener, a {
    private final d fnD = new d(this);
    private final Set<OnAttachStateChangeListener> fnE = new LinkedHashSet();
    private volatile ag fnH;
    private Runnable fnI = new 1(this);
    private volatile boolean fnK;
    private volatile Object mLock = new Object();

    public MTextureView(Context context) {
        super(context);
        init();
    }

    public MTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setSurfaceTextureListener(this);
        ((Activity) getContext()).getWindow().setFlags(16777216, 16777216);
        Paint paint = new Paint();
        paint.setColor(-1);
        this.fnD.getDrawContext().fnk = paint;
    }

    public final void adk() {
        if (this.fnH != null) {
            this.fnH.removeCallbacks(this.fnI);
            this.fnH.post(this.fnI);
        }
    }

    public final void m(Runnable runnable) {
        if (this.fnH != null) {
            this.fnH.post(runnable);
        }
    }

    public f getDrawContext() {
        return this.fnD.getDrawContext();
    }

    public final boolean d(Canvas canvas) {
        return this.fnD.d(canvas);
    }

    public final void a(JSONArray jSONArray, a aVar) {
        this.fnD.a(jSONArray, aVar);
    }

    public final void b(JSONArray jSONArray, a aVar) {
        this.fnD.b(jSONArray, aVar);
    }

    public final void adl() {
        this.fnD.adl();
    }

    public void setId(String str) {
        this.fnD.setId(str);
    }

    public int getType() {
        return 1;
    }

    public void addOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        if (!this.fnE.contains(onAttachStateChangeListener)) {
            this.fnE.add(onAttachStateChangeListener);
            super.addOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    public void removeOnAttachStateChangeListener(OnAttachStateChangeListener onAttachStateChangeListener) {
        this.fnE.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    public final void onPause() {
        this.fnD.onPause();
    }

    public final void onResume() {
        this.fnD.onResume();
    }

    public final boolean isPaused() {
        return this.fnD.fmT;
    }

    public String getSessionId() {
        return this.fnD.getSessionId();
    }

    public void setSessionId(String str) {
        this.fnD.setSessionId(str);
    }

    public int getDrawActionCostTimeReportId() {
        return 682;
    }

    public int getDrawCostTimeReportId() {
        return 683;
    }

    public void setStartTime(long j) {
        this.fnD.setStartTime(j);
    }

    public final void adm() {
        this.fnD.adm();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        x.v("MicroMsg.MTextureView", "onSurfaceTextureAvailable");
        if (this.fnH == null) {
            HandlerThread cZ = e.cZ("MTextureView#Rending-Thread", -19);
            cZ.start();
            this.fnH = new ag(cZ.getLooper());
        }
        Canvas lockCanvas = lockCanvas();
        if (lockCanvas != null) {
            lockCanvas.drawColor(-1);
            unlockCanvasAndPost(lockCanvas);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.v("MicroMsg.MTextureView", "onSurfaceTextureSizeChanged");
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        x.v("MicroMsg.MTextureView", "onSurfaceTextureDestroyed");
        this.fnH.removeCallbacks(this.fnI);
        this.fnH.getLooper().quit();
        synchronized (this.mLock) {
            if (this.fnK) {
                try {
                    this.mLock.wait(1000);
                } catch (Throwable e) {
                    x.e("MicroMsg.MTextureView", "await error : %s", new Object[]{Log.getStackTraceString(e)});
                }
            }
        }
        this.fnH = null;
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
