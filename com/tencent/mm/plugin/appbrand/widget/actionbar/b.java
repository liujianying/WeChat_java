package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.support.v4.view.z;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.page.a$a;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.plugin.appbrand.s.f;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.ui.statusbar.c;
import com.tencent.mm.ui.statusbar.c.a;
import com.tencent.mm.ui.y;

public final class b extends LinearLayout implements c, a {
    private int AC;
    private AppBrandCapsuleHomeButton gFg;
    private ImageView gFk;
    private int gFl;
    private double gFm;
    private OnClickListener gFn = null;
    private OnClickListener gFo = null;
    private AppBrandCapsuleOptionButton gFr;
    private LinearLayout gFs;
    private boolean gFt;

    public b(Context context, boolean z) {
        super(context);
        this.gFt = z;
        setLayoutParams(new MarginLayoutParams(-1, getActionBarHeight()));
        setGravity(19);
        addView(y.gq(getContext()).inflate(h.app_brand_capsule_bar, this, false));
        this.gFl = -1;
        this.AC = getResources().getColor(d.action_bar_color);
        this.gFm = 1.0d;
        this.gFr = (AppBrandCapsuleOptionButton) findViewById(g.capsulebar_capsule_option_btn);
        this.gFg = (AppBrandCapsuleHomeButton) findViewById(g.capsulebar_capsule_home_btn);
        this.gFk = (ImageView) findViewById(g.capsulebar_capsule_divider);
        this.gFs = (LinearLayout) findViewById(g.capsulebar_capsule_area);
        this.gFg.setOnClickListener(new 1(this));
        this.gFr.setVisibility(0);
        this.gFg.setVisibility(0);
    }

    public final void dl(boolean z) {
        this.gFt = z;
        apc();
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c.ab(j.cJ(getContext())).a(this);
        apc();
    }

    private void apc() {
        if (z.ai(this)) {
            if (this.gFt) {
                setPadding(0, 0, 0, 0);
            } else {
                setPadding(0, Math.max(com.tencent.mm.ui.statusbar.a.aa(j.cJ(getContext())), 0), 0, 0);
            }
            requestLayout();
            return;
        }
        post(new 2(this));
    }

    private int getActionBarHeight() {
        return com.tencent.mm.plugin.appbrand.widget.a.cM(getContext());
    }

    public final void setBackButtonClickListener(OnClickListener onClickListener) {
        this.gFn = onClickListener;
    }

    public final void setCloseButtonClickListener(OnClickListener onClickListener) {
        this.gFo = onClickListener;
    }

    public final void setCapsuleHomeButtonLongClickListener(OnLongClickListener onLongClickListener) {
        this.gFg.setOnLongClickListener(onLongClickListener);
    }

    public final void setMainTitle(String str) {
    }

    public final CharSequence getMainTitle() {
        return null;
    }

    public final void setSubTitle(String str) {
    }

    public final void setTitleAreaOnDoubleClickListener(OnClickListener onClickListener) {
    }

    public final double getBackgroundAlpha() {
        return this.gFm;
    }

    public final void setBackgroundAlpha(double d) {
    }

    public final void setBackgroundColor(String str) {
    }

    public final void setBackgroundColor(int i) {
    }

    public final int getBackgroundColor() {
        return this.AC;
    }

    public final void setOptionButtonClickListener(OnClickListener onClickListener) {
        this.gFr.setOnClickListener(onClickListener);
    }

    public final void dk(boolean z) {
        if (z) {
            this.gFs.setVisibility(0);
        } else {
            this.gFs.setVisibility(8);
        }
        if (z) {
            this.gFr.setVisibility(0);
        } else {
            this.gFr.setVisibility(8);
        }
        if (z) {
            this.gFg.setVisibility(0);
        } else {
            this.gFg.setVisibility(8);
        }
    }

    public final void aoZ() {
        this.gFr.reset();
        this.gFg.reset();
        apb();
    }

    public final void setForegroundStyle(String str) {
        if ("white".equals(str)) {
            this.gFl = -1;
        } else if ("black".equals(str)) {
            this.gFl = -16777216;
        }
        apa();
    }

    public final void setForegroundColor(int i) {
        this.gFl = i;
        apa();
    }

    public final int getForegroundColor() {
        return this.gFl;
    }

    private void apa() {
        apb();
        if (this.gFl == -1) {
            this.gFk.setImageResource(d.app_brand_capsule_divider_dark);
            this.gFs.setBackgroundResource(f.app_brand_game_capsule_dark_background);
            return;
        }
        this.gFk.setImageResource(d.app_brand_capsule_divider_light);
        this.gFs.setBackgroundResource(f.app_brand_game_capsule_light_background);
    }

    private void apb() {
        if (this.gFl == -1) {
            this.gFr.setColor(-1);
            this.gFg.setColor(-1);
            return;
        }
        this.gFr.setColor(-16777216);
        this.gFg.setColor(-16777216);
    }

    public final void setNavBackOrClose(boolean z) {
    }

    public final void setNavHidden(boolean z) {
    }

    public final void setLoadingIconVisibility(boolean z) {
    }

    public final void setOptionBtnStatus(a$a a_a) {
        this.gFr.a(a_a, this.gFl);
    }

    public final View getActionView() {
        return this;
    }

    public final void lH(int i) {
        apc();
    }
}
