package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.plugin.appbrand.canvas.h;
import com.tencent.mm.plugin.appbrand.canvas.widget.a.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MCanvasView extends View implements a {
    private final d fnD = new d(this);
    private final Set<OnAttachStateChangeListener> fnE = new LinkedHashSet();
    private Bitmap mBitmap;

    public MCanvasView(Context context) {
        super(context);
    }

    public MCanvasView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onDraw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            if (this.mBitmap == null || this.mBitmap.isRecycled() || this.mBitmap.getWidth() != measuredWidth || this.mBitmap.getHeight() != measuredHeight) {
                if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
                    this.mBitmap.recycle();
                }
                this.mBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
                x.v("MicroMsg.MCanvasView", "create a new bitmap(id : %s, w : %s, h : %s)", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight)});
            }
            if (this.mBitmap == null) {
                x.d("MicroMsg.MCanvasView", "bitmap is null.");
                return;
            }
            this.mBitmap.eraseColor(0);
            h hVar = new h(this.mBitmap);
            d(hVar);
            canvas.drawBitmap(hVar.mBitmap, 0.0f, 0.0f, null);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
            this.mBitmap.recycle();
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            this.mBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Config.ARGB_8888);
            x.v("MicroMsg.MCanvasView", "onSizeChanged, create a new bitmap(id : %s, w : %s, h : %s)", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight)});
        }
    }

    public final boolean d(Canvas canvas) {
        return this.fnD.d(canvas);
    }

    public final void adk() {
        if (z.ai(this)) {
            postInvalidate();
        } else {
            post(new 1(this));
        }
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
        return 3;
    }

    public final void m(Runnable runnable) {
        post(runnable);
    }

    public f getDrawContext() {
        return this.fnD.getDrawContext();
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
        return 685;
    }

    public int getDrawCostTimeReportId() {
        return 684;
    }

    public void setStartTime(long j) {
        this.fnD.setStartTime(j);
    }

    public final void adm() {
        this.fnD.adm();
    }
}
