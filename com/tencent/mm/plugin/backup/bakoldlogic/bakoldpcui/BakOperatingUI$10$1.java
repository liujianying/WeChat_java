package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.BakOperatingUI.10;

class BakOperatingUI$10$1 implements Runnable {
    final /* synthetic */ 10 haP;

    BakOperatingUI$10$1(10 10) {
        this.haP = 10;
    }

    public final void run() {
        this.haP.haO.showOptionMenu(false);
        if (BakOperatingUI.h(this.haP.haO) != null) {
            BakOperatingUI.h(this.haP.haO).setProgress(0);
        }
        if (BakOperatingUI.k(this.haP.haO) != null) {
            BakOperatingUI.k(this.haP.haO).setText(this.haP.haO.getString(R.l.bak_chat_to_pc_merging_tip));
        }
        if (BakOperatingUI.l(this.haP.haO) != null) {
            BakOperatingUI.l(this.haP.haO).setText(this.haP.haO.getString(R.l.bak_chat_to_pc_merge_operating_tip));
        }
        if (BakOperatingUI.i(this.haP.haO) != null) {
            BakOperatingUI.i(this.haP.haO).setText(this.haP.haO.getString(R.l.bak_chat_pc_merge_progress_tip) + "0%");
        }
    }
}
