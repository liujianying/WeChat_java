package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.mm.ui.base.CustomViewPager;

public class AppBrandSmileyViewPager extends CustomViewPager {
    private c gKF;
    private int gLc = 0;
    private int gLd = 0;
    private b gLe;

    public AppBrandSmileyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (VERSION.SDK_INT >= 9) {
            setOverScrollMode(2);
        }
    }

    public void setPanelManager(c cVar) {
        this.gKF = cVar;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.gKF != null && (((i > 0 && i3 != i) || (i2 > 0 && i4 != i2)) && ((i2 > 0 && i2 != this.gLc) || (i > 0 && i != this.gLd)))) {
            this.gKF.gKZ = i2;
            this.gKF.gLa = i;
            if (this.gLe != null) {
                this.gLe.aqf();
            }
        }
        if (i2 > 0) {
            this.gLc = i2;
        }
        if (i > 0) {
            this.gLd = i;
        }
    }

    public void setOnSizeChangedListener(b bVar) {
        this.gLe = bVar;
    }
}
