package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.h;

class CleanChattingUI$2 implements OnItemClickListener {
    final /* synthetic */ CleanChattingUI hSr;

    CleanChattingUI$2(CleanChattingUI cleanChattingUI) {
        this.hSr = cleanChattingUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        c om = CleanChattingUI.a(this.hSr).om(i);
        if (om != null) {
            Intent intent = new Intent(this.hSr, CleanChattingDetailUI.class);
            intent.putExtra("key_username", om.username);
            intent.putExtra("key_pos", i);
            this.hSr.startActivityForResult(intent, 0);
            h.mEJ.a(714, 21, 1, false);
        }
    }
}
