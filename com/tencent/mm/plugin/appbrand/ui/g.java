package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.b.a;
import com.tencent.mm.modelappbrand.b.f;
import com.tencent.mm.plugin.appbrand.config.a.d;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.widget.actionbar.c;
import com.tencent.mm.ui.statusbar.b;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

@SuppressLint({"ViewConstructor"})
final class g extends b implements l {
    private com.tencent.mm.plugin.appbrand.g fdO;
    private ThreeDotsLoadingView gtb;
    private ImageView gum = ((ImageView) findViewById(com.tencent.mm.plugin.appbrand.s.g.app_brand_loading_avatar));
    private TextView guo;
    private LinearLayout gup;
    private c guq;
    private View gwH;
    private View gwI;

    static /* synthetic */ void b(g gVar) {
        try {
            gVar.fdO.fcz.getCurrentPage().getCurrentPageView().alP();
        } catch (NullPointerException e) {
        }
    }

    public g(Context context, com.tencent.mm.plugin.appbrand.g gVar) {
        super(context);
        this.fdO = gVar;
        setClickable(true);
        setLayoutParams(new LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(h.app_brand_splash_ui, this);
        this.gum.setImageDrawable(a.JZ());
        this.guo = (TextView) findViewById(com.tencent.mm.plugin.appbrand.s.g.app_brand_loading_name);
        this.gtb = (ThreeDotsLoadingView) findViewById(com.tencent.mm.plugin.appbrand.s.g.app_brand_loading_view);
        this.gup = (LinearLayout) findViewById(com.tencent.mm.plugin.appbrand.s.g.app_brand_loading_fake_ab_container);
        this.gwI = findViewById(com.tencent.mm.plugin.appbrand.s.g.app_brand_loading_top_area);
        this.gwH = findViewById(com.tencent.mm.plugin.appbrand.s.g.app_brand_loading_root);
        this.guq = c.a.c(getContext(), this.fdO);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 21;
        layoutParams.rightMargin = com.tencent.mm.bp.a.ae(getContext(), e.app_brand_game_mode_icon_margin_right);
        this.gup.addView(this.guq.getActionView(), layoutParams);
        this.guo.getLayoutParams().height = com.tencent.mm.plugin.appbrand.widget.a.cM(getContext());
        ar(-1, true);
        this.guq.setBackgroundColor(0);
        this.guq.setForegroundStyle("black");
        this.guq.setNavBackOrClose(false);
        2 2 = new 2(this);
        this.guq.setCloseButtonClickListener(2);
        this.guq.setBackButtonClickListener(2);
        if (this.guq instanceof com.tencent.mm.plugin.appbrand.widget.actionbar.b) {
            ((com.tencent.mm.plugin.appbrand.widget.actionbar.b) this.guq).dl(true);
        }
        this.gtb.cAG();
    }

    public final void bL(String str, String str2) {
        com.tencent.mm.modelappbrand.b.b.Ka().a(this.gum, str, null, f.dGr);
        this.guo.setText(str2);
    }

    public final void anm() {
        post(new 1(this));
    }

    public final void ann() {
        this.guq.setNavHidden(true);
    }

    public final void a(d dVar) {
    }

    public final View getView() {
        return this;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getContext() instanceof Activity) {
            j.c(((Activity) getContext()).getWindow(), false);
        }
    }

    public final boolean hasOverlappingRendering() {
        return false;
    }

    public final void setProgress(int i) {
    }
}
