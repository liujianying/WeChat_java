package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;

public class SightLocationWidget extends LocationWidget {
    public SightLocationWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SightLocationWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected int getNormalStateImageResource() {
        return i.sight_icon_location_normal;
    }

    protected int getSelectedStateImageResource() {
        return i.sight_icon_location_selected;
    }

    protected int getLayoutResource() {
        return g.location_widget;
    }
}
