package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import com.tencent.mm.plugin.sns.i.g;

public class SightRangeWidget extends RangeWidget {
    public SightRangeWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SightRangeWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected int getLayoutResource() {
        return g.sight_range_layout;
    }

    protected int getMaxTagNameLen() {
        return 10;
    }

    public final boolean a(int i, int i2, Intent intent, AtContactWidget atContactWidget) {
        super.a(i, i2, intent, atContactWidget);
        if (atContactWidget != null) {
            if (getLabelRange() == 1) {
                atContactWidget.setVisibility(4);
                atContactWidget.bBN();
            } else {
                atContactWidget.setVisibility(0);
            }
        }
        return true;
    }
}
