package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class ResizeLayout extends LinearLayout {
    private a eWS = null;

    public interface a {
        void YE();
    }

    public ResizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnSizeChanged(a aVar) {
        this.eWS = aVar;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (this.eWS != null) {
            this.eWS.YE();
        }
        super.onSizeChanged(i, i2, i3, i4);
    }
}
