package com.tencent.mm.plugin.appbrand.game.page;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.sdk.platformtools.x;

@SuppressLint({"ViewConstructor"})
public final class c extends n {
    private b fCD = null;

    public c(Context context, g gVar) {
        super(context, gVar);
    }

    public final void V(String str, boolean z) {
        if (z) {
            getCurrentPage().loadUrl(str);
            getReporter().a(getCurrentPageView(), null, aa.AUTO_RE_LAUNCH);
            return;
        }
        x.e("MicroMsg.WAGamePageContainer", "reLaunch without auto is not support here");
    }

    public final void sW(String str) {
        runOnUiThread(new 1(this, str));
    }

    public final synchronized b getCurrentPage() {
        return this.fCD;
    }

    public final d getCurrentPageView() {
        return getCurrentPage().getCurrentPageView();
    }

    public final void c(String str, String str2, int[] iArr) {
    }

    public final int getPageCount() {
        return 1;
    }

    public final void agJ() {
        runOnUiThread(new 2(this));
    }

    public final void ko(int i) {
        agJ();
    }

    public final void agK() {
        getCurrentPage().agF();
    }

    public final void agL() {
        getCurrentPage().agE();
    }

    public final void agI() {
        getCurrentPage().agI();
    }

    public final boolean agM() {
        return false;
    }
}
