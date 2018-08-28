package com.tencent.mm.platformtools;

import android.os.Build.VERSION;
import android.view.View;

public final class s {
    public static void bD(View view) {
        if (view != null && VERSION.SDK_INT >= 11) {
            v vVar = new v();
            if (VERSION.SDK_INT >= 11) {
                view.setLayerType(1, null);
            }
        }
    }
}
