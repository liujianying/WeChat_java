package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase;
import com.tencent.mm.plugin.appbrand.widget.input.panel.c;

final class AppBrandSmileyPanel extends AppBrandSmileyPanelBase {
    private int gIc = 0;
    int gId = -1;
    private boolean mInLayout = false;

    public AppBrandSmileyPanel(Context context) {
        super(context);
    }

    public AppBrandSmileyPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final c apD() {
        return new ag();
    }

    protected final void onMeasure(int i, int i2) {
        if (isShown()) {
            int min;
            int[] anG;
            if (!j.fC(getContext())) {
                getManager();
                anG = c.anG();
                min = (Math.min(anG[0], anG[1]) / 2) - getContext().getResources().getDimensionPixelSize(e.ChattingFootEditMinHeigh);
            } else if (this.gId > 0) {
                min = this.gId;
            } else if (this.gIc > 0) {
                min = this.gIc;
            } else {
                getManager();
                anG = c.anG();
                min = (Math.max(anG[0], anG[1]) / 2) - getContext().getResources().getDimensionPixelSize(e.ChattingFootEditMinHeigh);
                this.gIc = min;
            }
            bZ(i, MeasureSpec.makeMeasureSpec(min, 1073741824));
            return;
        }
        bZ(i, MeasureSpec.makeMeasureSpec(0, Integer.MIN_VALUE));
    }

    public final void setVisibility(int i) {
        md(i);
        if (i == 0) {
            initView();
        }
    }

    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mInLayout = true;
        super.onLayout(z, i, i2, i3, i4);
        this.mInLayout = false;
    }

    final boolean apE() {
        if (d.fR(18)) {
            return super.isInLayout();
        }
        return this.mInLayout;
    }
}
