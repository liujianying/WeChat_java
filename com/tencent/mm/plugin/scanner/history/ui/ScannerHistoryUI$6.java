package com.tencent.mm.plugin.scanner.history.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.scanner.c;

class ScannerHistoryUI$6 implements OnClickListener {
    final /* synthetic */ ScannerHistoryUI mFo;

    ScannerHistoryUI$6(ScannerHistoryUI scannerHistoryUI) {
        this.mFo = scannerHistoryUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        c.brZ().diF.fV("ScanHistoryItem", "delete from ScanHistoryItem");
        ScannerHistoryUI.c(this.mFo);
        ScannerHistoryUI.a(this.mFo).a(null, null);
    }
}
