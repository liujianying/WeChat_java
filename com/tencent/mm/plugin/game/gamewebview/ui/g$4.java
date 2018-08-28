package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.sdk.platformtools.x;

class g$4 implements Runnable {
    final /* synthetic */ g jKj;
    final /* synthetic */ d jKk;

    g$4(g gVar, d dVar) {
        this.jKj = gVar;
        this.jKk = dVar;
    }

    public final void run() {
        if (this.jKj.jIJ.isFinishing()) {
            x.i("MicroMsg.GameWebViewMenuHelp", "tryShow sheet failed, the activity has been destroyed.");
        } else {
            this.jKk.bXO();
        }
    }
}
