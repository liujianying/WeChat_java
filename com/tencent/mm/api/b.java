package com.tencent.mm.api;

import android.content.Context;
import android.widget.FrameLayout;

public abstract class b extends FrameLayout {
    l bwK = new 1(this);

    public abstract void setActionBarCallback(e eVar);

    public abstract void setActionBarVisible(boolean z);

    public abstract void setAutoShowFooterAndBar(boolean z);

    public abstract void setFooterVisible(boolean z);

    public b(Context context) {
        super(context);
    }

    public void setSelectedFeatureListener(l lVar) {
        this.bwK = lVar;
    }

    public l getSelectedFeatureListener() {
        return this.bwK;
    }
}
