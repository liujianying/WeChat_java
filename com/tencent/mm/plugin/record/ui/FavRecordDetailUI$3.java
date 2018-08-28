package com.tencent.mm.plugin.record.ui;

import android.app.Dialog;
import com.tencent.mm.R;
import com.tencent.mm.ui.widget.snackbar.b;

class FavRecordDetailUI$3 implements Runnable {
    final /* synthetic */ Dialog iYD;
    final /* synthetic */ FavRecordDetailUI msF;

    FavRecordDetailUI$3(FavRecordDetailUI favRecordDetailUI, Dialog dialog) {
        this.msF = favRecordDetailUI;
        this.iYD = dialog;
    }

    public final void run() {
        this.iYD.dismiss();
        b.h(this.msF, this.msF.getString(R.l.finish_sent));
    }
}
