package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class ChangeNumView extends TextView {
    private int max = 0;
    private int min = 0;
    private int ouh = -1;
    private int pzt = 0;
    private boolean pzu = false;
    private final int pzv = 100;

    public ChangeNumView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChangeNumView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setInteral(int i) {
        this.ouh = i;
    }
}
