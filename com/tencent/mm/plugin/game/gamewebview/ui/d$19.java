package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.sdk.platformtools.bd;

class d$19 extends bd<String> {
    final /* synthetic */ d jJO;

    d$19(d dVar, String str) {
        this.jJO = dVar;
        super(1000, str, (byte) 0);
    }

    protected final /* synthetic */ Object run() {
        return d.n(this.jJO) == null ? "" : d.n(this.jJO).getTitle();
    }
}
