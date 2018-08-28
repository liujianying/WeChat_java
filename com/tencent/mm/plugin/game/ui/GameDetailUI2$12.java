package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.ae;
import com.tencent.mm.sdk.platformtools.ah;

class GameDetailUI2$12 implements Runnable {
    final /* synthetic */ GameDetailUI2 jXr;
    final /* synthetic */ byte[] jXt;

    GameDetailUI2$12(GameDetailUI2 gameDetailUI2, byte[] bArr) {
        this.jXr = gameDetailUI2;
        this.jXt = bArr;
    }

    public final void run() {
        final ae aeVar = new ae(this.jXt);
        ah.A(new Runnable() {
            public final void run() {
                GameDetailUI2.a(GameDetailUI2$12.this.jXr, aeVar);
            }
        });
    }
}
