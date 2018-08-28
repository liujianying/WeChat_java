package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity.a;

public final class AppBrandEmbedUI extends AppBrandUI {
    public final long gul = SystemClock.elapsedRealtimeNanos();

    static boolean x(Intent intent) {
        if (intent != null) {
            try {
                if (intent.getComponent() != null && intent.getComponent().getClassName().equals(AppBrandEmbedUI.class.getName())) {
                    return true;
                }
            } catch (Exception e) {
                x.e("MicroMsg.AppBrandEmbedUI", "isIntentForEmbedUI e=%s", new Object[]{e});
                return false;
            }
        }
        return false;
    }

    public final void finish() {
        if (!isFinishing()) {
            anC();
        }
    }

    protected final void initActivityOpenAnimation(Intent intent) {
        if (anl()) {
            super.overridePendingTransition(a.tnC, a.tnD);
        } else {
            super.overridePendingTransition(s.a.appbrand_ui_push_open_enter, s.a.anim_not_change);
        }
    }

    protected final void initActivityCloseAnimation() {
        if (anl()) {
            super.overridePendingTransition(a.tnE, a.tnF);
        } else {
            overridePendingTransition(s.a.anim_not_change, s.a.appbrand_ui_push_close_exit);
        }
    }

    private boolean anl() {
        return (this.gwx == null || this.gwx.aaA() == null || !this.gwx.aaA().aap()) ? false : true;
    }
}
