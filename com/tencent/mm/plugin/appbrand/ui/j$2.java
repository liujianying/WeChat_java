package com.tencent.mm.plugin.appbrand.ui;

import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.tencent.mm.sdk.platformtools.x;

class j$2 implements OnSystemUiVisibilityChangeListener {
    final /* synthetic */ Window gwT;

    j$2(Window window) {
        this.gwT = window;
    }

    public final void onSystemUiVisibilityChange(int i) {
        x.d("MicroMsg.AppBrandUIUtil", "visibility = " + i);
        if ((i & 4) == 0) {
            this.gwT.getDecorView().setSystemUiVisibility(j.d(this.gwT));
        }
    }
}
