package com.tencent.mm.ui.chatting.b;

import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class s$2 implements OnClickListener {
    final /* synthetic */ OnMenuItemClickListener hBy;
    final /* synthetic */ s tQv;

    s$2(s sVar, OnMenuItemClickListener onMenuItemClickListener) {
        this.tQv = sVar;
        this.hBy = onMenuItemClickListener;
    }

    public final void onClick(View view) {
        if (!this.tQv.bAG.tTq.isScreenEnable()) {
            x.w("MicroMsg.ChattingUI.HeaderComponent", "Actionbar customView onclick screen not enable");
        } else if (this.hBy != null) {
            this.hBy.onMenuItemClick(null);
        }
    }
}
