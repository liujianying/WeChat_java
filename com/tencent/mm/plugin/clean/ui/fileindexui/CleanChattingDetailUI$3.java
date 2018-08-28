package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class CleanChattingDetailUI$3 implements OnClickListener {
    final /* synthetic */ CleanChattingDetailUI hSj;

    CleanChattingDetailUI$3(CleanChattingDetailUI cleanChattingDetailUI) {
        this.hSj = cleanChattingDetailUI;
    }

    public final void onClick(View view) {
        h.a(this.hSj, this.hSj.getString(R.l.confirm_delete_file), "", this.hSj.getString(R.l.delete), this.hSj.getString(R.l.cancel), new 1(this), new 2(this));
    }
}
