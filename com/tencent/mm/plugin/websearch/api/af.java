package com.tencent.mm.plugin.websearch.api;

import android.content.SharedPreferences;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView.a;

public final class af {
    private static af pMB = new af();
    private SharedPreferences mPref = an.m(ad.getContext(), "com.tencent.mm.plugin.websearch.WebSearchXWeb", 4);
    private boolean pMA = false;
    private volatile boolean pMy = this.mPref.getBoolean("isUseSysWebview", false);
    private long pMz;

    public af() {
        bTq();
    }

    private void bTq() {
        e.post(new 1(this), "WebSearchXWeb-getSwitch");
    }

    public static af bTr() {
        return pMB;
    }

    public final boolean bTs() {
        bTq();
        if (this.pMA) {
            if (this.pMz == 0) {
                this.pMz = this.mPref.getLong("lastCheckTimestamp", 0);
            }
            if (System.currentTimeMillis() - this.pMz > 86400000) {
                e.post(new 2(this, a.hf(ad.getContext()), a.cS(ad.getContext())), "WebSearchXWeb.check");
                this.pMz = System.currentTimeMillis();
                this.mPref.edit().putLong("lastCheckTimestamp", this.pMz).commit();
            }
            return this.pMy;
        }
        x.i("WebSearchXWeb", "check use sys webview switch close");
        return false;
    }
}
