package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class CleanChattingUI$3 implements OnClickListener {
    final /* synthetic */ CleanChattingUI hSr;

    CleanChattingUI$3(CleanChattingUI cleanChattingUI) {
        this.hSr = cleanChattingUI;
    }

    public final void onClick(View view) {
        h.a(this.hSr, this.hSr.getString(R.l.confirm_delete_chatting), "", this.hSr.getString(R.l.delete), this.hSr.getString(R.l.cancel), new 1(this), new 2(this));
    }
}
