package com.tencent.mm.plugin.game.gamewebview.jsapi;

import com.tencent.mm.plugin.game.gamewebview.ui.d;

public class a$a {
    private int fFd;
    private d jGq;

    public a$a(d dVar, int i) {
        this.jGq = dVar;
        this.fFd = i;
    }

    public final void tp(String str) {
        if (this.jGq != null) {
            this.jGq.E(this.fFd, str);
        }
        this.jGq = null;
    }
}
