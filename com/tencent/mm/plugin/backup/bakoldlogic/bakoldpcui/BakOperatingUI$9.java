package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import com.tencent.mm.R;

class BakOperatingUI$9 implements Runnable {
    final /* synthetic */ int eNW;
    final /* synthetic */ BakOperatingUI haO;

    BakOperatingUI$9(BakOperatingUI bakOperatingUI, int i) {
        this.haO = bakOperatingUI;
        this.eNW = i;
    }

    public final void run() {
        if (BakOperatingUI.h(this.haO) != null) {
            BakOperatingUI.h(this.haO).setProgress(this.eNW);
        }
        if (BakOperatingUI.i(this.haO) != null && BakOperatingUI.k(this.haO) != null) {
            BakOperatingUI.i(this.haO).setText(this.haO.getString(R.l.bak_chat_pc_merge_progress_tip) + this.eNW + "%");
            BakOperatingUI.k(this.haO).setText(this.haO.getString(R.l.bak_chat_to_pc_merging_tip));
        }
    }
}
