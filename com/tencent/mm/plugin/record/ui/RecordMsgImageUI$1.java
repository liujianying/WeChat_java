package com.tencent.mm.plugin.record.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mm.plugin.record.b.h;

class RecordMsgImageUI$1 implements OnItemSelectedListener {
    final /* synthetic */ RecordMsgImageUI mtp;

    RecordMsgImageUI$1(RecordMsgImageUI recordMsgImageUI) {
        this.mtp = recordMsgImageUI;
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        if (h.d(RecordMsgImageUI.a(this.mtp).getItem(i), RecordMsgImageUI.b(this.mtp))) {
            this.mtp.setMMTitle(String.format("%d/%d", new Object[]{Integer.valueOf(i + 1), Integer.valueOf(RecordMsgImageUI.c(this.mtp).size())}));
            this.mtp.enableOptionMenu(true);
            return;
        }
        this.mtp.enableOptionMenu(false);
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
