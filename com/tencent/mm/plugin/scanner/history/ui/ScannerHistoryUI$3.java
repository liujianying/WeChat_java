package com.tencent.mm.plugin.scanner.history.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.mm.sdk.platformtools.x;

class ScannerHistoryUI$3 implements OnItemLongClickListener {
    final /* synthetic */ ScannerHistoryUI mFo;

    ScannerHistoryUI$3(ScannerHistoryUI scannerHistoryUI) {
        this.mFo = scannerHistoryUI;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            x.i("MicroMsg.ScannerHistoryUI", "onItemLongClick pos is 0");
        } else {
            if (i > 0) {
                i--;
            }
            if (i < ScannerHistoryUI.a(this.mFo).getCount()) {
                ScannerHistoryUI.b(this.mFo, i);
            }
        }
        return true;
    }
}
