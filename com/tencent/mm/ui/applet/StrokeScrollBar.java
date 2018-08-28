package com.tencent.mm.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.VerticalScrollBar;

public class StrokeScrollBar extends VerticalScrollBar {
    protected final void aAV() {
        this.kuW = new String[18];
        for (int i = 0; i < this.kuW.length; i++) {
            this.kuW[i] = Integer.toString(i + 3) + "劃";
        }
        this.kuU = 2.0f;
        this.kuV = 79;
    }

    public StrokeScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected int getToastLayoutId() {
        return R.i.show_head_toast_stroke;
    }
}
