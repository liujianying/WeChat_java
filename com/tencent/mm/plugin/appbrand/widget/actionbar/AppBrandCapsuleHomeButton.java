package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.plugin.appbrand.s.i;

public final class AppBrandCapsuleHomeButton extends AppBrandOptionButton {
    public AppBrandCapsuleHomeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppBrandCapsuleHomeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final int getImageButtonResource() {
        return i.app_brand_actionbar_capsule_home_dark;
    }
}
