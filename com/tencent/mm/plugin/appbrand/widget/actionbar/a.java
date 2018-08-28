package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.s$e;
import com.tencent.mm.plugin.appbrand.s.d;
import com.tencent.mm.plugin.appbrand.s.f;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.i;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.RingPathTransform;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.b;
import com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.y;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;

public final class a extends LinearLayout implements c {
    private int AC;
    private View gEZ;
    private TextView gFa;
    private TextView gFb;
    private ImageView gFc;
    private View gFd;
    private ImageButton gFe;
    private AppBrandOptionButton gFf;
    private AppBrandCapsuleHomeButton gFg;
    private ProgressBar gFh;
    private CircleProgressDrawable gFi;
    private LinearLayout gFj;
    private ImageView gFk;
    private int gFl;
    private double gFm;
    private OnClickListener gFn = null;
    private OnClickListener gFo = null;
    private long gFp = 0;

    public a(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-1, getActionBarHeight()));
        setGravity(19);
        setBackgroundResource(d.action_bar_color);
        addView(y.gq(getContext()).inflate(h.app_brand_action_bar, this, false));
        this.gFl = -1;
        this.AC = getResources().getColor(d.action_bar_color);
        this.gFm = 1.0d;
        this.gEZ = findViewById(g.actionbar_title_area);
        this.gFa = (TextView) findViewById(g.actionbar_title_main);
        this.gFb = (TextView) findViewById(g.actionbar_title_sub);
        this.gFc = (ImageView) findViewById(g.actionbar_nav_btn);
        this.gFd = findViewById(g.actionbar_nav_area);
        this.gFe = (ImageButton) findViewById(g.actionbar_home_btn);
        this.gFf = (AppBrandOptionButton) findViewById(g.actionbar_capsule_option_btn);
        this.gFg = (AppBrandCapsuleHomeButton) findViewById(g.actionbar_capsule_home_btn);
        this.gFh = (ProgressBar) findViewById(g.actionbar_loading_icon);
        this.gFj = (LinearLayout) findViewById(g.actionbar_capsule_area);
        this.gFk = (ImageView) findViewById(g.actionbar_capsule_divider);
        this.gFi = new CircleProgressDrawable();
        this.gFd.setOnClickListener(new 1(this));
        this.gFg.setOnClickListener(new 2(this));
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
        this.gFa.setText(str);
    }

    public final CharSequence getMainTitle() {
        return this.gFa.getText();
    }

    public final void setSubTitle(String str) {
        if (bi.oW(str)) {
            this.gFb.setVisibility(8);
        } else {
            this.gFb.setVisibility(0);
            this.gFb.setText(str);
        }
        this.gFb.clearAnimation();
    }

    public final void setTitleAreaOnDoubleClickListener(OnClickListener onClickListener) {
        this.gEZ.setOnClickListener(new 3(this, onClickListener));
    }

    public final double getBackgroundAlpha() {
        return this.gFm;
    }

    public final void setBackgroundAlpha(double d) {
        this.gFm = d;
        super.getBackground().setAlpha((int) (255.0d * d));
    }

    public final void setBackgroundColor(String str) {
        this.AC = j.aO(str, this.AC);
        setBackgroundColor(this.AC);
    }

    public final void setBackgroundColor(int i) {
        this.AC = i;
        super.setBackgroundColor(i);
        setBackgroundAlpha(this.gFm);
    }

    public final int getBackgroundColor() {
        return this.AC;
    }

    public final void setOptionButtonClickListener(OnClickListener onClickListener) {
        this.gFf.setOnClickListener(onClickListener);
    }

    public final void dk(boolean z) {
        if (z) {
            this.gFj.setVisibility(0);
        } else {
            this.gFj.setVisibility(8);
        }
        if (z) {
            this.gFf.setVisibility(0);
        } else {
            this.gFf.setVisibility(8);
        }
        if (z) {
            this.gFg.setVisibility(0);
        } else {
            this.gFg.setVisibility(8);
        }
    }

    public final void aoZ() {
        this.gFf.reset();
        this.gFg.reset();
        apb();
    }

    public final void setHomeButtonClickListener(OnClickListener onClickListener) {
        this.gFe.setOnClickListener(onClickListener);
    }

    public final void setForegroundStyle(String str) {
        if ("white".equals(str)) {
            this.gFl = -1;
        } else if ("black".equals(str)) {
            this.gFl = WebView.NIGHT_MODE_COLOR;
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
        this.gFc.setImageResource(i.actionbar_icon_dark_back);
        this.gFc.setColorFilter(this.gFl, Mode.SRC_ATOP);
        this.gFa.setTextColor(this.gFl);
        this.gFb.setTextColor(this.gFl);
        this.gFe.setImageDrawable(j.d(getContext(), i.app_brand_action_bar_homebtn, this.gFl));
        CircleProgressDrawable circleProgressDrawable = this.gFi;
        circleProgressDrawable.jV = this.gFl;
        circleProgressDrawable.invalidateSelf();
        this.gFh.setLayerType(1, null);
        this.gFh.setIndeterminateDrawable(this.gFi);
        apb();
        if (this.gFl == -1) {
            this.gFk.setImageResource(d.app_brand_capsule_divider_dark);
            this.gFj.setBackgroundResource(f.app_brand_game_capsule_dark_background);
            return;
        }
        this.gFk.setImageResource(d.app_brand_capsule_divider_light);
        this.gFj.setBackgroundResource(f.app_brand_game_capsule_light_background);
    }

    private void apb() {
        if (this.gFl == -1) {
            this.gFf.setColor(-1);
            this.gFg.setColor(-1);
            return;
        }
        this.gFf.setColor(WebView.NIGHT_MODE_COLOR);
        this.gFg.setColor(WebView.NIGHT_MODE_COLOR);
    }

    public final void setNavBackOrClose(boolean z) {
        apa();
    }

    public final void setNavHidden(boolean z) {
        int i;
        View view = this.gFd;
        if (z) {
            i = 8;
        } else {
            i = 0;
        }
        view.setVisibility(i);
        view = this.gEZ;
        if (z) {
            i = getContext().getResources().getDimensionPixelSize(s$e.LargePadding);
        } else {
            i = 0;
        }
        view.setPadding(i, 0, 0, 0);
    }

    public final void setLoadingIconVisibility(boolean z) {
        this.gFh.setVisibility(z ? 0 : 8);
        if (z) {
            CircleProgressDrawable circleProgressDrawable = this.gFi;
            circleProgressDrawable.jC.clear();
            ArrayList arrayList = circleProgressDrawable.jC;
            RingPathTransform ringPathTransform = circleProgressDrawable.gEK;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(ringPathTransform, "trimPathStart", new float[]{0.0f, 0.75f});
            ofFloat.setDuration(1333);
            ofFloat.setInterpolator(c.gEM);
            ofFloat.setRepeatCount(-1);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(ringPathTransform, "trimPathEnd", new float[]{0.0f, 0.75f});
            ofFloat2.setDuration(1333);
            ofFloat2.setInterpolator(b.gEM);
            ofFloat2.setRepeatCount(-1);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(ringPathTransform, "trimPathOffset", new float[]{0.0f, 0.25f});
            ofFloat3.setDuration(1333);
            ofFloat3.setInterpolator(com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.a.gEM);
            ofFloat3.setRepeatCount(-1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
            arrayList.add(animatorSet);
            ArrayList arrayList2 = circleProgressDrawable.jC;
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(circleProgressDrawable.gEL, "rotation", new float[]{0.0f, 720.0f});
            ofFloat4.setDuration(6665);
            ofFloat4.setInterpolator(com.tencent.mm.plugin.appbrand.widget.CircleProgressDrawable.a.gEM);
            ofFloat4.setRepeatCount(-1);
            arrayList2.add(ofFloat4);
            this.gFi.start();
            return;
        }
        this.gFi.stop();
    }

    public final void setOptionBtnStatus(com.tencent.mm.plugin.appbrand.page.a.a aVar) {
        this.gFf.a(aVar, this.gFl);
    }

    public final View getActionView() {
        return this;
    }
}
