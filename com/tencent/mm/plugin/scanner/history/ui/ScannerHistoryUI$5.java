package com.tencent.mm.plugin.scanner.history.ui;

import com.tencent.mm.plugin.scanner.history.a.a;
import com.tencent.mm.ui.base.h.c;

class ScannerHistoryUI$5 implements c {
    final /* synthetic */ int eKj;
    final /* synthetic */ ScannerHistoryUI mFo;

    ScannerHistoryUI$5(ScannerHistoryUI scannerHistoryUI, int i) {
        this.mFo = scannerHistoryUI;
        this.eKj = i;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                a aVar = (a) ScannerHistoryUI.a(this.mFo).getItem(this.eKj);
                if (aVar != null) {
                    com.tencent.mm.plugin.scanner.c.brZ().a(aVar, new String[0]);
                    ScannerHistoryUI.c(this.mFo);
                    ScannerHistoryUI.a(this.mFo).a(null, null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
