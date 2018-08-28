package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.VerticalScrollBar;

public class IPCallAddressScrollbar extends VerticalScrollBar {
    protected final void aAV() {
        this.kuW = new String[]{"↑", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
        this.kuU = 1.3f;
        this.kuV = 79;
    }

    public IPCallAddressScrollbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected int getToastLayoutId() {
        return R.i.show_head_toast;
    }
}
