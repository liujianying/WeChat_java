package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.c;

class SnsMsgUI$12 implements c {
    final /* synthetic */ SnsMsgUI nYl;

    SnsMsgUI$12(SnsMsgUI snsMsgUI) {
        this.nYl = snsMsgUI;
    }

    public final int cl(View view) {
        return SnsMsgUI.c(this.nYl).getPositionForView(view);
    }
}
