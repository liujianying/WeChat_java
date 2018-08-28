package com.tencent.mm.plugin.appbrand.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.b.a;
import com.tencent.mm.modelappbrand.b.f;
import com.tencent.mm.plugin.appbrand.config.d;
import com.tencent.mm.plugin.appbrand.config.d$b;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e$c;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.s$e;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.widget.actionbar.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

@SuppressLint({"ViewConstructor"})
final class b extends com.tencent.mm.ui.statusbar.b implements l {
    private g fdO;
    private ThreeDotsLoadingView gtb;
    private ImageView gum;
    private ImageView gun;
    private TextView guo;
    private LinearLayout gup;
    private c guq;
    private d$b gur = d$b.PORTRAIT;

    public b(Context context, g gVar) {
        super(context);
        this.fdO = gVar;
        x.i("MicroMsg.AppBrandGameUILoadingSplash", "init");
        setClickable(true);
        setLayoutParams(new LayoutParams(-1, -1));
        LayoutInflater.from(getContext()).inflate(h.app_brand_splash_game_ui, this);
        this.gum = (ImageView) findViewById(s.g.app_brand_game_loading_avatar);
        this.gum.setImageDrawable(a.JZ());
        this.guo = (TextView) findViewById(s.g.app_brand_game_loading_name);
        this.gun = (ImageView) findViewById(s.g.app_brand_game_wagame_name);
        this.gtb = (ThreeDotsLoadingView) findViewById(s.g.app_brand_game_loading_view);
        this.gup = (LinearLayout) findViewById(s.g.app_brand_game_loading_ab_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtb.getLayoutParams();
        this.guq = c.a.c(getContext(), this.fdO);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 21;
        layoutParams2.rightMargin = com.tencent.mm.bp.a.ae(getContext(), s$e.app_brand_game_mode_icon_margin_right);
        layoutParams2.topMargin = com.tencent.mm.bp.a.ae(getContext(), s$e.app_brand_game_mode_icon_margin_top);
        this.gup.addView(this.guq.getActionView(), layoutParams2);
        d.b(this.fdO.fcq);
        this.gur = d.cu(getContext());
        x.i("MicroMsg.AppBrandGameUILoadingSplash", "mLastDeviceOrientation :%s", new Object[]{this.gur});
        if (this.gur == d$b.LANDSCAPE) {
            layoutParams.topMargin = com.tencent.mm.bp.a.ae(getContext(), s$e.app_brand_game_splash_loading_landspace_top_margin);
            this.guo.setPadding(0, 0, 0, 0);
            this.gtb.setLayoutParams(layoutParams);
        } else {
            layoutParams.topMargin = com.tencent.mm.bp.a.ae(getContext(), s$e.app_brand_game_splash_loading_portrait_top_margin);
            this.guo.setPadding(0, 0, 0, com.tencent.mm.bp.a.ae(getContext(), s$e.app_brand_game_splash_icon_portrait_top_padding));
            this.gtb.setLayoutParams(layoutParams);
        }
        ar(-1, true);
        this.guq.setBackgroundColor(0);
        this.guq.setForegroundStyle("black");
        this.guq.setNavBackOrClose(false);
        OnClickListener anonymousClass2 = new OnClickListener() {
            public final void onClick(View view) {
                e.a(b.this.fdO.mAppId, e$c.CLOSE);
                b.this.fdO.finish();
            }
        };
        this.guq.setCloseButtonClickListener(anonymousClass2);
        this.guq.setBackButtonClickListener(anonymousClass2);
        if (this.guq instanceof com.tencent.mm.plugin.appbrand.widget.actionbar.b) {
            ((com.tencent.mm.plugin.appbrand.widget.actionbar.b) this.guq).dl(true);
        }
        if (getContext() != null && (getContext() instanceof Activity)) {
            Window window = ((Activity) getContext()).getWindow();
            if (window != null) {
                j.c(window, true);
            }
        }
        this.gtb.cAG();
    }

    public final void bL(String str, String str2) {
        com.tencent.mm.modelappbrand.b.b.Ka().a(this.gum, str, null, f.dGr);
        this.guo.setText(str2);
    }

    public final void anm() {
        x.w("MicroMsg.AppBrandGameUILoadingSplash", "animateHide");
        post(new 1(this));
    }

    public final void ann() {
    }

    public final void a(com.tencent.mm.plugin.appbrand.config.a.d dVar) {
    }

    public final View getView() {
        return this;
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.i("MicroMsg.AppBrandGameUILoadingSplash", "onLayout changed:%s", new Object[]{Boolean.valueOf(z)});
        super.onLayout(z, i, i2, i3, i4);
        d.b(this.fdO.fcq);
        d$b cu = d.cu(getContext());
        x.i("MicroMsg.AppBrandGameUILoadingSplash", "curDeviceOrientation: %s,mLastDeviceOrientation: %s", new Object[]{cu, this.gur});
        if (cu != this.gur) {
            this.gur = cu;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gtb.getLayoutParams();
            if (cu == d$b.LANDSCAPE) {
                layoutParams.topMargin = com.tencent.mm.bp.a.ae(getContext(), s$e.app_brand_game_splash_loading_landspace_top_margin);
                this.guo.setPadding(0, 0, 0, 0);
            } else {
                layoutParams.topMargin = com.tencent.mm.bp.a.ae(getContext(), s$e.app_brand_game_splash_loading_portrait_top_margin);
                this.guo.setPadding(0, 0, 0, com.tencent.mm.bp.a.ae(getContext(), s$e.app_brand_game_splash_icon_portrait_top_padding));
            }
            this.gtb.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void setProgress(int i) {
    }
}
