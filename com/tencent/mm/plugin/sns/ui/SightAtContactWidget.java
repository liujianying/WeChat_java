package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;

public class SightAtContactWidget extends AtContactWidget {
    @TargetApi(11)
    public SightAtContactWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public SightAtContactWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected int getLayoutResource() {
        return g.sight_at_layout;
    }

    protected int getWithDrawableId() {
        return i.sight_icon_mention;
    }

    protected int getWithEmptyDrawableId() {
        return i.sight_icon_mention;
    }
}
