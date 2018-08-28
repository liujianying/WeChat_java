package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;

class CleanChattingDetailUI$2 implements OnClickListener {
    final /* synthetic */ CleanChattingDetailUI hSj;

    CleanChattingDetailUI$2(CleanChattingDetailUI cleanChattingDetailUI) {
        this.hSj = cleanChattingDetailUI;
    }

    public final void onClick(View view) {
        b a = CleanChattingDetailUI.a(this.hSj);
        if (a.gUV.size() == a.gvR.size()) {
            a.gUV.clear();
        } else {
            for (int i = 0; i < a.gvR.size(); i++) {
                a.gUV.add(Integer.valueOf(i));
            }
        }
        a.aBx();
        CleanChattingDetailUI.a(this.hSj).notifyDataSetChanged();
    }
}
