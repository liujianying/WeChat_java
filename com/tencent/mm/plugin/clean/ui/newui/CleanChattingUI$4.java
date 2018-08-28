package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;

class CleanChattingUI$4 implements OnClickListener {
    final /* synthetic */ CleanChattingUI hTu;

    CleanChattingUI$4(CleanChattingUI cleanChattingUI) {
        this.hTu = cleanChattingUI;
    }

    public final void onClick(View view) {
        a b = CleanChattingUI.b(this.hTu);
        if (b.gUV.size() == b.getCount()) {
            b.gUV.clear();
        } else {
            for (int i = 0; i < b.getCount(); i++) {
                b.gUV.add(Integer.valueOf(i));
            }
        }
        b.notifyDataSetChanged();
        b.hTk.a(b.gUV);
    }
}
