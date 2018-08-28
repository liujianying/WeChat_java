package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.config.a$d;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.widget.actionbar.c;
import com.tencent.mm.plugin.appbrand.widget.actionbar.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.statusbar.b;

@SuppressLint({"ViewConstructor"})
final class d extends b implements l {
    private g fdO;
    private c gnn = a.c(getContext(), this.fdO);
    private Runnable guV;

    public d(Context context, g gVar) {
        super(context);
        this.fdO = gVar;
        addView(this.gnn.getActionView());
        this.gnn.dk(false);
        1 1 = new 1(this);
        this.gnn.setCloseButtonClickListener(1);
        this.gnn.setBackButtonClickListener(1);
        p(ad.getContext().getString(j.app_brand_action_plugin_splash_loading), -1, "black");
        setBackgroundColor(-1);
    }

    private void p(String str, int i, String str2) {
        this.gnn.setMainTitle(str);
        this.gnn.setBackgroundColor(i);
        this.gnn.setForegroundStyle(str2);
        this.gnn.setNavBackOrClose(true);
        this.gnn.setLoadingIconVisibility(true);
        ar(i, "black".equals(str2));
    }

    public final void bL(String str, String str2) {
        this.gnn.setMainTitle(ad.getContext().getString(j.app_brand_action_plugin_splash_loading));
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.guV == null) {
            this.guV = new 2(this);
            postDelayed(this.guV, 1500);
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.guV);
    }

    public final void anm() {
        removeCallbacks(this.guV);
        post(new 3(this));
    }

    public final void ann() {
        this.gnn.setNavHidden(true);
    }

    public final void a(a$d a_d) {
        if (!this.fdO.fcv.foN.adV()) {
            p(a_d.fpf, j.aO(a_d.fpj, -1), a_d.fpg);
            setBackgroundColor(j.aO(a_d.fpc, -1));
        }
    }

    public final View getView() {
        return this;
    }

    public final void setProgress(int i) {
    }
}
