package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.plugin.appbrand.canvas.d;
import com.tencent.mm.plugin.appbrand.canvas.f;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

public class MHardwareAccelerateDrawableView extends View implements a {
    private final d fnD = new d(this);
    private final Set<OnAttachStateChangeListener> fnE = new LinkedHashSet();

    public MHardwareAccelerateDrawableView(Context context) {
        super(context);
        setLayerType(2, null);
    }

    public MHardwareAccelerateDrawableView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayerType(2, null);
    }

    public MHardwareAccelerateDrawableView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayerType(2, null);
    }

    protected void onDraw(Canvas canvas) {
        d(canvas);
    }

    public final void adk() {
        postInvalidate();
    }

    public final void m(Runnable runnable) {
        post(runnable);
    }

    public f getDrawContext() {
        return this.fnD.getDrawContext();
    }

    public final boolean d(Canvas canvas) {
        return this.fnD.d(canvas);
    }

    public final void a(JSONArray jSONArray, a$a a_a) {
        this.fnD.a(jSONArray, a_a);
    }

    public final void b(JSONArray jSONArray, a$a a_a) {
        this.fnD.b(jSONArray, a_a);
    }

    public final void adl() {
        this.fnD.adl();
    }

    public void setId(String str) {
        this.fnD.setId(str);
    }

    public int getType() {
        return 0;
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
