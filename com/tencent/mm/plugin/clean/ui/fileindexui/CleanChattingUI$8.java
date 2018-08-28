package com.tencent.mm.plugin.clean.ui.fileindexui;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;

class CleanChattingUI$8 implements Runnable {
    final /* synthetic */ long hSl;
    final /* synthetic */ CleanChattingUI hSr;

    CleanChattingUI$8(CleanChattingUI cleanChattingUI, long j) {
        this.hSr = cleanChattingUI;
        this.hSl = j;
    }

    public final void run() {
        CleanChattingUI.g(this.hSr).dismiss();
        h.b(this.hSr, this.hSr.getString(R.l.clean_del_data_ok_tip, new Object[]{bi.bF(this.hSl)}), "", true);
        CleanChattingUI.e(this.hSr).setText(this.hSr.getString(R.l.analyse_file_profress, new Object[]{" "}));
    }
}
