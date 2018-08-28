package com.tencent.mm.plugin.game.wepkg;

import com.tencent.mm.sdk.platformtools.x;

class a$5 implements Runnable {
    final /* synthetic */ a kdP;
    final /* synthetic */ boolean kdS;

    a$5(a aVar, boolean z) {
        this.kdP = aVar;
        this.kdS = z;
    }

    public final void run() {
        if (a.e(this.kdP) != null) {
            a.e(this.kdP).evaluateJavascript(String.format("javascript:(function() {window.__usewepkg__=%s;})();", new Object[]{Boolean.valueOf(this.kdS)}), null);
            return;
        }
        x.i("MicroMsg.Wepkg.WePkgPlugin", "injectWepkgState, webview == null");
    }
}
