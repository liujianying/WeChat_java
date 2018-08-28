package com.tencent.mm.ui;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.sdk.platformtools.x;

class AllRemindMsgUI$a implements e, Runnable {
    final /* synthetic */ AllRemindMsgUI tgf;

    AllRemindMsgUI$a(AllRemindMsgUI allRemindMsgUI) {
        this.tgf = allRemindMsgUI;
    }

    public final void run() {
        au.DF().a(new n(), 0);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            AllRemindMsgUI.c(this.tgf).setVisibility(0);
            AllRemindMsgUI.e(this.tgf).setVisibility(8);
        } else if (lVar.getType() == 866) {
            com.tencent.mm.sdk.f.e.post(new 1(this, lVar), "MicroMsg.emoji.AllRemindMsgUI[onSceneEnd]");
        }
    }
}
