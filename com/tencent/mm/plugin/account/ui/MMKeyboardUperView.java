package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class MMKeyboardUperView extends ScrollView {
    private int defaultHeight = -1;
    private View eSn;
    private Runnable eSo = new 1(this);
    private Runnable eSp = new Runnable() {
        public final void run() {
            MMKeyboardUperView.this.eSn.setVisibility(0);
        }
    };

    public MMKeyboardUperView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MMKeyboardUperView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setupUperView(View view) {
        this.eSn = view;
        this.defaultHeight = -1;
    }
}
