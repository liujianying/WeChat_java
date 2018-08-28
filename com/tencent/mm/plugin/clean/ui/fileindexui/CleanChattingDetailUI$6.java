package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;

class CleanChattingDetailUI$6 implements Runnable {
    final /* synthetic */ CleanChattingDetailUI hSj;
    final /* synthetic */ long hSl;

    CleanChattingDetailUI$6(CleanChattingDetailUI cleanChattingDetailUI, long j) {
        this.hSj = cleanChattingDetailUI;
        this.hSl = j;
    }

    public final void run() {
        CleanChattingDetailUI.c(this.hSj).dismiss();
        Intent intent = new Intent();
        intent.putExtra("key_pos", CleanChattingDetailUI.d(this.hSj));
        intent.putExtra("key_delete_size", CleanChattingDetailUI.e(this.hSj));
        this.hSj.setResult(1000, intent);
        h.b(this.hSj, this.hSj.getString(R.l.clean_del_data_ok_tip, new Object[]{bi.bF(this.hSl)}), "", true);
    }
}
