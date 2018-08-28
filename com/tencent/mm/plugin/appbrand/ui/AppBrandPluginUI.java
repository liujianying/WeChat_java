package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;

@a(1)
public class AppBrandPluginUI extends AppBrandUI {
    private boolean guX = false;

    protected void initActivityOpenAnimation(Intent intent) {
        super.overridePendingTransition(MMFragmentActivity.a.tnC, MMFragmentActivity.a.tnD);
    }

    protected void initActivityCloseAnimation() {
        if (!this.guX) {
            super.overridePendingTransition(MMFragmentActivity.a.tnE, MMFragmentActivity.a.tnF);
        }
    }

    public void onSwipeBack() {
        super.onSwipeBack();
        this.guX = true;
    }

    public final boolean Xf() {
        return true;
    }
}
