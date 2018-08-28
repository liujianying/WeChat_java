package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.x;

public class c$a {
    public final /* synthetic */ c qfX;

    public c$a(c cVar) {
        this.qfX = cVar;
    }

    public final void bXJ() {
        this.qfX.qfV = null;
        this.qfX.mStartTime = 0;
        this.qfX.jUq = 0;
        this.qfX.mStartTime = 0;
        this.qfX.jUr = 0;
    }

    public final void bXK() {
        this.qfX.mStartTime = System.currentTimeMillis();
        this.qfX.jUr = System.currentTimeMillis();
    }

    public final void ab(Bundle bundle) {
        this.qfX.qfV = bundle;
        x.i("MicroMsg.GamePageTimeReport", "setGamePageReportData");
        if (bundle != null && bundle.getBoolean("game_page_report_time_begin")) {
            this.qfX.jUq = 0;
            this.qfX.mStartTime = System.currentTimeMillis();
            this.qfX.jUr = System.currentTimeMillis();
        }
    }

    public final void onResume() {
        if (this.qfX.jUr != 0) {
            this.qfX.jUr = System.currentTimeMillis();
        }
    }

    public final void onPause() {
        if (this.qfX.jUr != 0) {
            this.qfX.jUq += System.currentTimeMillis() - this.qfX.jUr;
        }
    }
}
