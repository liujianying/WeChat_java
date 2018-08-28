package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import com.tencent.mm.sdk.platformtools.t;

@Deprecated
public final class j extends t {
    public static final int Ag() {
        return sFR;
    }

    @TargetApi(11)
    public static final void j(Activity activity) {
        if (activity != null) {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            sFR = (activity.getResources().getDisplayMetrics().heightPixels - a.h(activity)) - rect.top;
        }
    }
}
