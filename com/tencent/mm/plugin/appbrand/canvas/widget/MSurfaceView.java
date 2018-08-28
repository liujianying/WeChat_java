package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
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

public class MSurfaceView extends SurfaceView implements Callback, a {
    private final d fnD = new d(this);
    private final Set<OnAttachStateChangeListener> fnE = new LinkedHashSet();
    private SurfaceHolder fnG;
    private ag fnH;
    private Runnable fnI = new 1(this);
    private volatile boolean nY;

    public MSurfaceView(Context context) {
        super(context);
        init();
    }

    public MSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.fnG = getHolder();
        this.fnG.addCallback(this);
        this.fnG.setFormat(-3);
        Paint paint = new Paint();
        paint.setColor(-1);
        this.fnD.getDrawContext().fnk = paint;
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        x.i("MicroMsg.MSurfaceView", "surfaceCreated(%s)", new Object[]{Integer.valueOf(hashCode())});
        this.nY = false;
        if (this.fnH == null) {
            HandlerThread cZ = e.cZ("MSurfaceView#Rending-Thread", -19);
            cZ.start();
            this.fnH = new ag(cZ.getLooper());
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        x.i("MicroMsg.MSurfaceView", "surfaceChanged(%s)", new Object[]{Integer.valueOf(hashCode())});
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        x.i("MicroMsg.MSurfaceView", "surfaceDestroyed(%s)", new Object[]{Integer.valueOf(hashCode())});
        this.nY = true;
        this.fnH.getLooper().quit();
        this.fnH = null;
    }

    public void draw(Canvas canvas) {
        x.i("MicroMsg.MSurfaceView", "draw(%s)", new Object[]{Integer.valueOf(hashCode())});
        canvas.drawColor(0, Mode.CLEAR);
        super.draw(canvas);
    }

    public final void adk() {
        m(new 2(this));
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
        return 2;
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
        return 667;
    }

    public int getDrawCostTimeReportId() {
        return 668;
    }

    public void setStartTime(long j) {
        this.fnD.setStartTime(j);
    }

    public final void adm() {
        this.fnD.adm();
    }
}
