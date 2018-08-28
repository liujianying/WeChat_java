package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.support.v4.view.ViewPager.e;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyViewPager.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.input.WebViewSmileyViewPager.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMDotView;

public class WebViewSmileyPanel extends LinearLayout implements e, a {
    View FU = null;
    private boolean gIv = false;
    MMActivity gKS;
    private MMDotView gKU;
    private boolean gKV = true;
    c qlL;
    private a qlO;
    private WebViewSmileyViewPager qlP = null;

    public final void a(int i, float f, int i2) {
    }

    public final void O(int i) {
        a bYC = this.qlL.bYC();
        int pageCount = bYC.getPageCount();
        int i2 = i - bYC.gKG;
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
        if (this.qlP != null) {
            this.qlL.gKV = j.fC(getContext());
            b bVar = (b) this.qlP.getAdapter();
            if (bVar != null) {
                bVar.gLf.clear();
                bVar.qlL = this.qlL;
                bVar.notifyDataSetChanged();
            } else {
                bVar = new b();
                bVar.qlL = this.qlL;
                this.qlP.setAdapter(bVar);
            }
            this.qlP.post(new 1(this));
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        aqh();
    }

    protected void onMeasure(int i, int i2) {
        if (this.gIv) {
            super.onMeasure(i, MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
            return;
        }
        j.fC(getContext());
        super.onMeasure(i, i2);
    }

    public WebViewSmileyPanel(Context context) {
        super(context, null);
        init();
    }

    public WebViewSmileyPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setOnTextOperationListener(a aVar) {
        this.qlO = aVar;
        this.qlL.qlS = this.qlO;
    }

    protected final c getManager() {
        return this.qlL;
    }

    private void init() {
        this.gKS = (MMActivity) getContext();
        this.qlL = new c();
        this.qlL.gKE = getContext();
        this.qlL.qlS = this.qlO;
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
            if (this.FU == null || getChildCount() <= 0) {
                if (this.FU == null) {
                    this.FU = View.inflate(ad.getContext(), R.i.webview_smiley_panel, null);
                } else if (this.FU.getParent() != null) {
                    ((ViewGroup) this.FU.getParent()).removeView(this.FU);
                }
                this.qlP = (WebViewSmileyViewPager) this.FU.findViewById(R.h.smiley_panel_view_pager);
                this.qlP.setOnPageChangeListener(this);
                this.qlP.setPanelManager(this.qlL);
                this.qlP.setOnSizeChangedListener(this);
                this.gKU = (MMDotView) this.FU.findViewById(R.h.smiley_panel_dot);
                this.gKU.setDotCount(1);
                aqh();
                addView(this.FU, new LayoutParams(-1, -1));
                return;
            }
            this.FU.setVisibility(0);
        }
    }

    private void aqh() {
        if (this.gKU != null) {
            boolean fC = j.fC(getContext());
            if (fC != this.gKV) {
                RelativeLayout.LayoutParams layoutParams;
                if (fC) {
                    this.gKU.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.f.MiddlePadding));
                    layoutParams = (RelativeLayout.LayoutParams) this.gKU.getLayoutParams();
                    layoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(R.f.emoji_panel_tab_height);
                    this.gKU.setLayoutParams(layoutParams);
                } else {
                    this.gKU.setPadding(0, 0, 0, getContext().getResources().getDimensionPixelSize(R.f.LittlePadding));
                    layoutParams = (RelativeLayout.LayoutParams) this.gKU.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    this.gKU.setLayoutParams(layoutParams);
                }
                this.gKV = fC;
            }
        }
    }
}
