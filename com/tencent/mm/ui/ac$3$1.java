package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.LauncherUI.b;
import com.tencent.mm.ui.ac.3;

class ac$3$1 implements OnApplyWindowInsetsListener {
    final /* synthetic */ 3 tpw;

    ac$3$1(3 3) {
        this.tpw = 3;
    }

    @TargetApi(20)
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        if (windowInsets != null) {
            x.i("MicroMsg.LauncherUI.NewChattingTabUI", "OnApplyWindowInsetsListener %s", new Object[]{windowInsets});
            windowInsets.consumeSystemWindowInsets();
            b bVar = this.tpw.tpr.tpe;
            FitSystemWindowLayoutView fitSystemWindowLayoutView = this.tpw.tpu;
            windowInsets.getSystemWindowInsetTop();
            bVar.a(fitSystemWindowLayoutView, new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom()), this.tpw.tpv);
        }
        return windowInsets;
    }
}
