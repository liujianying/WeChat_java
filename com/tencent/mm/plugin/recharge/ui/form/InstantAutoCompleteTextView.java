package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.sdk.platformtools.x;

public class InstantAutoCompleteTextView extends AutoCompleteTextView {
    private boolean mqO;

    public InstantAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InstantAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void dismissDropDown() {
        super.dismissDropDown();
        x.d("TestAutoCompleteTextView", "dismiss");
    }

    public void setShowAlways(boolean z) {
        this.mqO = z;
    }

    public boolean enoughToFilter() {
        return this.mqO || super.enoughToFilter();
    }
}
