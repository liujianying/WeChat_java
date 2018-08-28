package com.tencent.mm.plugin.game.gamewebview.ui;

import android.webkit.WebView.FindListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

class d$10 implements FindListener {
    final /* synthetic */ d jJO;

    d$10(d dVar) {
        this.jJO = dVar;
    }

    public final void onFindResultReceived(int i, int i2, boolean z) {
        if (!(!z || d.G(this.jJO) || bi.oW(d.F(this.jJO).getSearchContent()))) {
            if (i2 == 0) {
                h.mEJ.a(608, 3, 1, false);
            } else {
                h.mEJ.a(608, 2, 1, false);
            }
            d.a(this.jJO, true);
        }
        d.F(this.jJO).q(i, i2, z);
    }
}
