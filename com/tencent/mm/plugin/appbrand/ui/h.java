package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.performance.b;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.ui.statusbar.c;
import com.tencent.mm.ui.statusbar.c.a;

public final class h extends LinearLayout implements a {
    private final a[] gwL = new a[4];
    private final SparseArray<b> gwM = new SparseArray();
    private final SparseArray<b> gwN = new SparseArray();
    private int gwO;
    public final String mAppId;

    public h(Context context, String str) {
        super(context);
        this.mAppId = str;
        setClickable(false);
        int i = getContext().getResources().getDisplayMetrics().widthPixels;
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(getContext(), 10);
        int fromDPToPix2 = com.tencent.mm.bp.a.fromDPToPix(getContext(), 4);
        LayoutParams layoutParams = new FrameLayout.LayoutParams((i * 3) / 5, -2);
        layoutParams.gravity = 53;
        setLayoutParams(layoutParams);
        anE();
        setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        setOrientation(1);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) fromDPToPix2);
        gradientDrawable.setColor(-652403418);
        setBackground(gradientDrawable);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 2);
        View textView = new TextView(getContext());
        View view = new View(getContext());
        textView.setTextColor(-1);
        textView.setLayoutParams(layoutParams2);
        textView.setTextSize(1, 14.0f);
        textView.setText(getContext().getString(j.app_brand_performance_title));
        addView(textView);
        layoutParams3.setMargins(0, com.tencent.mm.bp.a.fromDPToPix(getContext(), 10), 0, 0);
        view.setLayoutParams(layoutParams3);
        view.setBackgroundColor(1728053247);
        addView(view);
        anF();
        c.ab((Activity) getContext()).a(this);
    }

    private void anE() {
        if (getLayoutParams() != null && (getLayoutParams() instanceof MarginLayoutParams)) {
            ((MarginLayoutParams) getLayoutParams()).topMargin = com.tencent.mm.plugin.appbrand.widget.a.cM(getContext()) + this.gwO;
            requestLayout();
        }
    }

    private void anF() {
        for (int i = 0; i < 4; i++) {
            a aVar = new a(this, getContext());
            aVar.setText(getContext().getString(b.gpE[i]));
            this.gwL[i] = aVar;
            addView(aVar);
        }
    }

    public final void P(int i, String str) {
        com.tencent.mm.plugin.appbrand.r.c.runOnUiThread(new 1(this, i, str));
    }

    public final void bN(String str, String str2) {
        com.tencent.mm.plugin.appbrand.r.c.runOnUiThread(new 2(this, str, str2));
    }

    public final void lH(int i) {
        this.gwO = i;
        anE();
    }
}
