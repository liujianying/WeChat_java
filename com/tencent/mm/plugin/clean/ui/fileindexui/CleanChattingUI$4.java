package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;

class CleanChattingUI$4 implements OnClickListener {
    final /* synthetic */ CleanChattingUI hSr;

    CleanChattingUI$4(CleanChattingUI cleanChattingUI) {
        this.hSr = cleanChattingUI;
    }

    public final void onClick(View view) {
        a a = CleanChattingUI.a(this.hSr);
        if (a.gUV.size() == a.getCount()) {
            a.gUV.clear();
        } else {
            for (int i = 0; i < a.getCount(); i++) {
                a.gUV.add(Integer.valueOf(i));
            }
        }
        a.notifyDataSetChanged();
        a.hRQ.a(a.gUV);
    }
}
