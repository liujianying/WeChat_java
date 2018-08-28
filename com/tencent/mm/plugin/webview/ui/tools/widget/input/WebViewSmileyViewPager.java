package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.ui.base.CustomViewPager;

public class WebViewSmileyViewPager extends CustomViewPager {
    private int gLc = 0;
    private int gLd = 0;
    private c qlL;
    private a qlU;

    public WebViewSmileyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (d.fR(9)) {
            setOverScrollMode(2);
        }
    }

    public void setPanelManager(c cVar) {
        this.qlL = cVar;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.qlL != null && (((i > 0 && i3 != i) || (i2 > 0 && i4 != i2)) && ((i2 > 0 && i2 != this.gLc) || (i > 0 && i != this.gLd)))) {
            this.qlL.gKZ = i2;
            this.qlL.gLa = i;
            if (this.qlU != null) {
                this.qlU.aqf();
            }
        }
        if (i2 > 0) {
            this.gLc = i2;
        }
        if (i > 0) {
            this.gLd = i;
        }
    }

    public void setOnSizeChangedListener(a aVar) {
        this.qlU = aVar;
    }
}
