package com.tencent.mm.plugin.card.ui;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.ui.view.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements ActivityLifecycleCallbacks {
    private int hBn = 0;

    public static Application ano() {
        return (Application) ad.getContext().getApplicationContext();
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
        if (this.hBn < 0) {
            if (activity == null || !(activity instanceof CardDetailUI)) {
                g.Em().H(new 1(this));
            } else {
                CardDetailUI cardDetailUI = (CardDetailUI) activity;
                if (cardDetailUI.hBC != null) {
                    com.tencent.mm.plugin.card.ui.view.g gVar = cardDetailUI.hBC.hCa;
                    if (gVar != null && (gVar instanceof m)) {
                        x.i("MicroMsg.CardAcitivityLifecycleListener", "CardAcitivityLifecycleListener on activity from background to foreground！is showing CardDetailUI,updateCodeView!");
                        cardDetailUI.hBC.hCa.d(c.hIA);
                    }
                }
            }
        }
        this.hBn++;
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
        this.hBn--;
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }
}
