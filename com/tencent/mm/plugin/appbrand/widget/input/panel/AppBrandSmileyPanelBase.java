package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.ViewPager.e;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class AppBrandSmileyPanelBase extends LinearLayout implements e, b {
    public View FU = null;
    private boolean gIv = false;
    public c gKF;
    private a gKR;
    public MMActivity gKS;
    private AppBrandSmileyViewPager gKT = null;
    private MMDotView gKU;
    private boolean gKV = true;

    public interface a {
        void apK();

        void append(String str);
    }

    public final void a(int i, float f, int i2) {
    }

    public final void O(int i) {
        a aqi = this.gKF.aqi();
        int pageCount = aqi.getPageCount();
        int i2 = i - aqi.gKG;
        if (pageCount <= 1) {
            this.gKU.setVisibility(4);
            return;
        }
        this.gKU.setVisibility(0);
        this.gKU.setDotCount(pageCount);
        this.gKU.setSelectedDot(i2);
    }

    public final void N(int i) {
    }

    public final void aqf() {
        if (this.gKT != null) {
            this.gKF.gKV = j.fC(getContext());
            com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager.a aVar = (com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager.a) this.gKT.getAdapter();
            if (aVar != null) {
                aVar.gLf.clear();
                aVar.gKF = this.gKF;
                aVar.notifyDataSetChanged();
            } else {
                aVar = new com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyViewPager.a();
                aVar.gKF = this.gKF;
                this.gKT.setAdapter(aVar);
            }
            this.gKT.post(new Runnable() {
                public final void run() {
                    AppBrandSmileyPanelBase.this.O(AppBrandSmileyPanelBase.this.gKT.getCurrentItem());
                }
            });
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aqh();
    }

    public void onMeasure(int i, int i2) {
        if (this.gIv) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
            return;
        }
        j.fC(getContext());
        super.onMeasure(i, i2);
    }

    @SuppressLint({"WrongCall"})
    public final void bZ(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public AppBrandSmileyPanelBase(Context context) {
        super(context, null);
        init();
    }

    public AppBrandSmileyPanelBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setOnTextOperationListener(a aVar) {
        this.gKR = aVar;
        this.gKF.gKY = this.gKR;
    }

    public final c getManager() {
        return this.gKF;
    }

    public final void aqg() {
        if (this.FU != null) {
            this.FU.setVisibility(4);
        }
    }

    private void init() {
        this.gKS = (MMActivity) getContext();
        this.gKF = apD();
        this.gKF.gKE = getContext();
        this.gKF.gKY = this.gKR;
    }

    public c apD() {
        return new c();
    }

    public void setVisibility(int i) {
        if (i == 0) {
            this.gIv = false;
        } else {
            this.gIv = true;
        }
        super.setVisibility(i);
        if (!this.gIv) {
            this.gKS.YC();
            initView();
        }
    }

    public final void md(int i) {
        super.setVisibility(i);
    }

    public final void initView() {
        if (this.FU == null || getChildCount() <= 0) {
            if (this.FU == null) {
                this.FU = View.inflate(ad.getContext(), h.appbrand_smiley_panel, null);
            } else if (this.FU.getParent() != null) {
                ((ViewGroup) this.FU.getParent()).removeView(this.FU);
            }
            this.gKT = (AppBrandSmileyViewPager) this.FU.findViewById(g.smiley_panel_view_pager);
            this.gKT.setOnPageChangeListener(this);
            this.gKT.setPanelManager(this.gKF);
            this.gKT.setOnSizeChangedListener(this);
            this.gKU = (MMDotView) this.FU.findViewById(g.smiley_panel_dot);
            this.gKU.setDotCount(1);
            aqh();
            addView(this.FU, new LayoutParams(-1, -1));
            return;
        }
        this.FU.setVisibility(0);
    }

    private void aqh() {
        if (this.gKU != null) {
            boolean fC = j.fC(getContext());
            if (fC != this.gKV) {
                RelativeLayout.LayoutParams layoutParams;
                if (fC) {
                    this.gKU.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(s.e.MiddlePadding));
                    layoutParams = (RelativeLayout.LayoutParams) this.gKU.getLayoutParams();
                    layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(s.e.emoji_panel_tab_height);
                    this.gKU.setLayoutParams(layoutParams);
                } else {
                    this.gKU.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(s.e.LittlePadding));
                    layoutParams = (RelativeLayout.LayoutParams) this.gKU.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    this.gKU.setLayoutParams(layoutParams);
                }
                this.gKV = fC;
            }
        }
    }
}
