package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.smtt.sdk.WebView;

public final class r extends q {
    private a goi;
    private b goj;
    private boolean gok = false;
    private LinearLayout gol;
    private TextView gom;
    private View gon;
    private ImageView goo;
    private ImageView goq;
    private ImageView gor;
    private long gos = 0;

    public r(Context context, t tVar) {
        super(context);
        tVar.setCompetitorView(this);
        tVar.cAy();
        this.gol = (LinearLayout) LayoutInflater.from(getContext()).inflate(h.app_brand_pulldown_webview_background, this, false);
        View view = this.gol;
        this.gnV = view;
        this.gnW = new FrameLayout(getContext());
        this.gnW.setLayoutParams(new LayoutParams(-1, -1));
        this.gnW.addView(view);
        this.FU = tVar;
        this.gnX = new FrameLayout(getContext());
        this.gnX.setLayoutParams(new LayoutParams(-1, -1));
        this.gnX.addView(tVar);
        addView(this.gnW);
        addView(this.gnX);
        this.gom = (TextView) findViewById(g.app_brand_pulldown_background_text);
        this.gon = findViewById(g.app_brand_pulldown_background_loading);
        this.goo = (ImageView) findViewById(g.app_brand_pulldown_background_loading0);
        this.goq = (ImageView) findViewById(g.app_brand_pulldown_background_loading1);
        this.gor = (ImageView) findViewById(g.app_brand_pulldown_background_loading2);
    }

    public final void setOnPullDownListener(a aVar) {
        this.goi = aVar;
    }

    public final void setOnPullDownOffsetListener(b bVar) {
        this.goj = bVar;
    }

    protected final void alY() {
        ((AnimationDrawable) this.goo.getDrawable()).start();
        ((AnimationDrawable) this.goq.getDrawable()).start();
        ((AnimationDrawable) this.gor.getDrawable()).start();
        if (this.goi != null) {
            this.goi.alU();
        }
        this.gos = System.currentTimeMillis();
    }

    protected final void alZ() {
        ((AnimationDrawable) this.goo.getDrawable()).stop();
        ((AnimationDrawable) this.goo.getDrawable()).selectDrawable(0);
        ((AnimationDrawable) this.goq.getDrawable()).stop();
        ((AnimationDrawable) this.goq.getDrawable()).selectDrawable(0);
        ((AnimationDrawable) this.gor.getDrawable()).stop();
        ((AnimationDrawable) this.gor.getDrawable()).selectDrawable(0);
    }

    protected final void lq(int i) {
        if (this.goj != null) {
            this.goj.lp(i);
        }
        if (this.gok) {
            if (i > this.gol.getHeight()) {
                i = this.gol.getHeight();
            }
            this.gol.setTranslationY((float) (i - this.gol.getHeight()));
        }
    }

    public final void amb() {
        long currentTimeMillis = System.currentTimeMillis() - this.gos;
        if (currentTimeMillis < 1000) {
            postDelayed(new 1(this), 1000 - currentTimeMillis);
        } else {
            alX();
        }
    }

    protected final int getStayHeight() {
        return this.gol.getHeight();
    }

    public final void setHeadViewHeight(int i) {
        if (i > this.gol.getHeight()) {
            this.gol.getLayoutParams().height = i;
            this.gol.requestLayout();
        }
    }

    public final void aK(String str, int i) {
        setBackgroundTextStyle(str);
        setPullDownBackgroundColor(i);
    }

    public final void setBackgroundTextStyle(String str) {
        if ("light".equals(str)) {
            this.goo.setImageDrawable(d(-1, new float[]{0.2f, 0.6f, 0.4f, 0.2f}));
            this.goq.setImageDrawable(d(-1, new float[]{0.2f, 0.2f, 0.6f, 0.4f}));
            this.gor.setImageDrawable(d(-1, new float[]{0.2f, 0.4f, 0.2f, 0.6f}));
            this.gom.setTextColor(-1);
            this.gom.setAlpha(0.4f);
        } else if ("dark".equals(str) || !"ignore".equals(str)) {
            this.goo.setImageDrawable(d(WebView.NIGHT_MODE_COLOR, new float[]{0.1f, 0.4f, 0.2f, 0.1f}));
            this.goq.setImageDrawable(d(WebView.NIGHT_MODE_COLOR, new float[]{0.1f, 0.1f, 0.4f, 0.2f}));
            this.gor.setImageDrawable(d(WebView.NIGHT_MODE_COLOR, new float[]{0.1f, 0.2f, 0.1f, 0.4f}));
            this.gom.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.gom.setAlpha(0.2f);
        }
    }

    public final void setPullDownText(String str) {
        if (bi.oW(str)) {
            this.gom.setVisibility(8);
            return;
        }
        this.gom.setVisibility(0);
        this.gom.setText(str);
    }

    public final void cE(boolean z) {
        this.gok = z;
        setNeedStay(z);
        this.gon.setVisibility(z ? 0 : 4);
    }

    private static AnimationDrawable d(int i, float[] fArr) {
        AnimationDrawable animationDrawable = new AnimationDrawable();
        animationDrawable.setOneShot(false);
        animationDrawable.addFrame(g(i, fArr[0]), 0);
        animationDrawable.addFrame(g(i, fArr[1]), com.tencent.mm.plugin.appbrand.jsapi.p.h.CTRL_INDEX);
        animationDrawable.addFrame(g(i, fArr[2]), com.tencent.mm.plugin.appbrand.jsapi.p.h.CTRL_INDEX);
        animationDrawable.addFrame(g(i, fArr[3]), com.tencent.mm.plugin.appbrand.jsapi.p.h.CTRL_INDEX);
        return animationDrawable;
    }

    private static Drawable g(int i, float f) {
        Drawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.setIntrinsicHeight(32);
        shapeDrawable.setIntrinsicWidth(32);
        shapeDrawable.getPaint().setColor(i);
        shapeDrawable.getPaint().setAlpha((int) (255.0f * f));
        return shapeDrawable;
    }
}
