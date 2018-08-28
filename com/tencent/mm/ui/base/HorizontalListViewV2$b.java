package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.widget.Scroller;

@TargetApi(11)
final class HorizontalListViewV2$b {
    static {
        if (VERSION.SDK_INT < 11) {
            throw new RuntimeException("sdk is >= 11!");
        }
    }

    public static void a(Scroller scroller) {
        if (scroller != null) {
            scroller.setFriction(0.009f);
        }
    }
}
