package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import com.tencent.mm.sdk.platformtools.x;

class BakOperatingUI$3 implements Runnable {
    final /* synthetic */ BakOperatingUI haO;

    BakOperatingUI$3(BakOperatingUI bakOperatingUI) {
        this.haO = bakOperatingUI;
    }

    public final void run() {
        x.d("MicroMsg.BakOperatingUI", "BakOperatingUI onOperateCancel");
        BakOperatingUI.o(this.haO);
    }
}
