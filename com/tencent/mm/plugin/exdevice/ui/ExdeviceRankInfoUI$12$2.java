package com.tencent.mm.plugin.exdevice.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.12;

class ExdeviceRankInfoUI$12$2 implements Runnable {
    final /* synthetic */ 12 iFH;

    ExdeviceRankInfoUI$12$2(12 12) {
        this.iFH = 12;
    }

    public final void run() {
        Toast.makeText(this.iFH.iFG, R.l.exdevice_open_rank_list_failed, 1).show();
        this.iFH.iFG.finish();
    }
}
