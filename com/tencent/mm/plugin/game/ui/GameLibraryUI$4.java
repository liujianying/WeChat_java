package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.aj;
import com.tencent.mm.sdk.platformtools.ah;

class GameLibraryUI$4 implements Runnable {
    final /* synthetic */ byte[] jXt;
    final /* synthetic */ GameLibraryUI jZN;

    GameLibraryUI$4(GameLibraryUI gameLibraryUI, byte[] bArr) {
        this.jZN = gameLibraryUI;
        this.jXt = bArr;
    }

    public final void run() {
        final aj ajVar = new aj(this.jXt);
        ah.A(new Runnable() {
            public final void run() {
                GameLibraryUI.a(GameLibraryUI$4.this.jZN, ajVar, false);
            }
        });
    }
}
