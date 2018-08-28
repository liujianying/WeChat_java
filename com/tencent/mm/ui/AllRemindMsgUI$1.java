package com.tencent.mm.ui;

import android.support.v7.widget.RecyclerView.c;
import com.tencent.mm.sdk.platformtools.x;

class AllRemindMsgUI$1 extends c {
    final /* synthetic */ AllRemindMsgUI tgf;

    AllRemindMsgUI$1(AllRemindMsgUI allRemindMsgUI) {
        this.tgf = allRemindMsgUI;
    }

    public final void onChanged() {
        super.onChanged();
        x.i("MicroMsg.emoji.AllRemindMsgUI", "[onChanged] size:%s", new Object[]{Integer.valueOf(AllRemindMsgUI.a(this.tgf).getItemCount())});
        if (AllRemindMsgUI.a(this.tgf).getItemCount() == 0) {
            AllRemindMsgUI.b(this.tgf).setVisibility(0);
            AllRemindMsgUI.c(this.tgf).setVisibility(8);
            return;
        }
        AllRemindMsgUI.b(this.tgf).setVisibility(8);
        AllRemindMsgUI.c(this.tgf).setVisibility(0);
    }
}
