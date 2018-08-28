package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.plugin.appbrand.s.f;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.widget.input.af.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw;

public final class t extends LinearLayout {
    private static final int fDq = g.app_brand_keyboard_number;
    private boolean gHT = false;
    private a gHU;
    private AppBrandNumberKeyboardView gHV;
    EditText im;

    public static t bZ(View view) {
        return (t) view.getRootView().findViewById(fDq);
    }

    public static t ca(View view) {
        t bZ = bZ(view);
        if (bZ != null) {
            return bZ;
        }
        l bV = l.bV(view);
        if (bV == null) {
            return null;
        }
        bZ = new t(view.getContext());
        bV.f(bZ, false);
        return bZ;
    }

    private t(Context context) {
        super(context);
        super.setId(fDq);
        setOrientation(1);
        setBackgroundResource(d.navpage);
        LayoutParams layoutParams = new LayoutParams(-1, a.fromDPToPix(getContext(), 30));
        View relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setOnClickListener(new 1(this));
        relativeLayout.setBackgroundResource(f.tenpay_push_down_bg);
        View imageView = new ImageView(getContext());
        imageView.setImageResource(f.tenpay_push_down);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        relativeLayout.addView(imageView, layoutParams2);
        addView(relativeLayout, layoutParams);
        layoutParams = new LayoutParams(-1, a.fromDPToPix(getContext(), 240));
        AppBrandNumberKeyboardView appBrandNumberKeyboardView = new AppBrandNumberKeyboardView(getContext());
        this.gHV = appBrandNumberKeyboardView;
        addView(appBrandNumberKeyboardView, layoutParams);
    }

    public final void setOnDoneListener(a aVar) {
        this.gHU = aVar;
    }

    private void onDone() {
        if (!this.gHT && this.gHU != null) {
            this.gHT = true;
            this.gHU.onDone();
            this.gHT = false;
        }
    }

    public final void setId(int i) {
    }

    public final void setVisibility(int i) {
        if (getVisibility() != i || (getVisibility() != 0 && getVisibility() != 8)) {
            if (i != 0) {
                super.setVisibility(8);
                onDone();
                return;
            }
            super.setVisibility(i);
        }
    }

    public final int getPanelHeight() {
        return a.fromDPToPix(getContext(), aw.CTRL_BYTE);
    }

    public final <_Input extends EditText & com.tencent.mm.plugin.appbrand.widget.input.b.a> void setInputEditText(_Input _input) {
        this.im = _input;
        AppBrandNumberKeyboardView appBrandNumberKeyboardView = this.gHV;
        com.tencent.mm.plugin.appbrand.widget.input.b.a aVar = (com.tencent.mm.plugin.appbrand.widget.input.b.a) _input;
        if (appBrandNumberKeyboardView.gIa == aVar) {
            return;
        }
        if (aVar == null) {
            appBrandNumberKeyboardView.gHZ = null;
            return;
        }
        if (aVar instanceof View) {
            ((View) aVar).requestFocus();
        }
        if (aVar instanceof EditText) {
            b.setNoSystemInputOnEditText((EditText) aVar);
            b.c((EditText) aVar);
        }
        appBrandNumberKeyboardView.gHZ = aVar.apA();
    }

    public final EditText getAttachedEditText() {
        return this.im;
    }

    public final void setXMode(int i) {
        this.gHV.setXMode(i);
    }

    final void apB() {
        if (this.im != null) {
            this.im.clearFocus();
            this.im = null;
            this.gHU = null;
            this.gHT = false;
        }
    }

    protected final void onMeasure(int i, int i2) {
        if (isShown()) {
            i2 = MeasureSpec.makeMeasureSpec(getPanelHeight(), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeAllViews();
    }
}
