package com.tencent.mm.plugin.appbrand.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.s.k;

public class d extends RelativeLayout {
    private static final int gNl = Color.parseColor("#F9F9F9");
    private final int gNe;
    private final int gNf;
    private e gNg;
    private FrameLayout gNh;
    private a gNi;
    private boolean gNj;
    b gNk;

    public void setOnResultListener(a aVar) {
        this.gNi = aVar;
    }

    public void setOnValueUpdateListener(b bVar) {
        this.gNk = bVar;
    }

    private void aqs() {
        this.gNi = null;
        this.gNk = null;
    }

    private void g(boolean z, Object obj) {
        if (!this.gNj && this.gNi != null) {
            this.gNj = true;
            this.gNi.f(z, obj);
            this.gNj = false;
        }
    }

    public d(Context context) {
        super(context);
        this.gNe = a.fromDPToPix(context, 48);
        this.gNf = a.fromDPToPix(context, 240);
        setClickable(true);
        setLongClickable(true);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gNf);
        layoutParams.addRule(12);
        View frameLayout = new FrameLayout(getContext());
        frameLayout.setId(g.app_brand_picker_panel_internal_picker);
        frameLayout.setOnClickListener(new 4(this));
        frameLayout.setBackgroundColor(gNl);
        this.gNh = frameLayout;
        addView(frameLayout, layoutParams);
        layoutParams = new RelativeLayout.LayoutParams(-1, this.gNe);
        layoutParams.addRule(2, g.app_brand_picker_panel_internal_picker);
        frameLayout = new RelativeLayout(getContext());
        View cb = cb(j.confirm_dialog_ok, com.tencent.mm.plugin.appbrand.s.d.green_text_color);
        cb.setOnClickListener(new 1(this));
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(11);
        frameLayout.addView(cb, layoutParams2);
        cb = cb(j.confirm_dialog_cancel, com.tencent.mm.plugin.appbrand.s.d.cancel_btn_color);
        cb.setOnClickListener(new 2(this));
        layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(9);
        frameLayout.addView(cb, layoutParams2);
        frameLayout.setOnClickListener(new 3(this));
        frameLayout.setBackgroundColor(gNl);
        addView(frameLayout, layoutParams);
    }

    protected void setPickerImpl(e eVar) {
        if (this.gNg != null) {
            this.gNg.aqp();
        }
        this.gNg = eVar;
        if (this.gNg != null) {
            this.gNg.b(this);
        }
        if (this.gNh != null && this.gNg != null && this.gNg.getView() != null) {
            this.gNh.removeAllViews();
            aqs();
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 17;
            this.gNh.addView(this.gNg.getView(), layoutParams);
        }
    }

    public e getPicker() {
        return this.gNg;
    }

    public void show() {
        if (this.gNg == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (this.gNg != null) {
            this.gNg.a(this);
        }
    }

    public void hide() {
        super.setVisibility(8);
        g(false, null);
        if (this.gNg != null) {
            this.gNg.aqo();
        }
    }

    public void setVisibility(int i) {
        if (i != 0) {
            hide();
        } else {
            super.setVisibility(i);
        }
    }

    protected final int getPanelContentHeight() {
        return this.gNe + this.gNf;
    }

    @SuppressLint({"WrongCall"})
    protected final void bZ(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected void onMeasure(int i, int i2) {
        if (isShown()) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(this.gNe + this.gNf, 1073741824));
        } else {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
        }
    }

    private View cb(int i, int i2) {
        View textView = new TextView(new ContextThemeWrapper(getContext(), k.AppBrandPickerPanelTextButton));
        textView.setTextColor(getResources().getColor(i2));
        textView.setText(i);
        textView.setGravity(17);
        return textView;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        aqs();
        removeAllViews();
    }
}
