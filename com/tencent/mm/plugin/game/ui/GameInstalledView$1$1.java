package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.ui.GameInstalledView.1;

class GameInstalledView$1$1 implements Runnable {
    final /* synthetic */ 1 jZr;

    GameInstalledView$1$1(1 1) {
        this.jZr = 1;
    }

    public final void run() {
        if (GameInstalledView.a(this.jZr.jZq) == 0) {
            GameInstalledView.b(this.jZr.jZq);
            GameInstalledView.c(this.jZr.jZq).addView(this.jZr.val$view, this.jZr.jZq.jZp);
        }
    }
}
