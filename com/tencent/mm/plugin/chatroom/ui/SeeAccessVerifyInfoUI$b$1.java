package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.chatroom.ui.SeeAccessVerifyInfoUI.a;
import com.tencent.mm.plugin.chatroom.ui.SeeAccessVerifyInfoUI.b;
import com.tencent.mm.sdk.platformtools.bi;

class SeeAccessVerifyInfoUI$b$1 implements OnClickListener {
    final /* synthetic */ b hOD;
    final /* synthetic */ int hW;

    SeeAccessVerifyInfoUI$b$1(b bVar, int i) {
        this.hOD = bVar;
        this.hW = i;
    }

    public final void onClick(View view) {
        String BL;
        String str = ((a) this.hOD.hoC.get(this.hW)).nickname;
        String str2 = null;
        if (SeeAccessVerifyInfoUI.c(this.hOD.hOz) != null) {
            str2 = SeeAccessVerifyInfoUI.c(this.hOD.hOz).gT(((a) this.hOD.hoC.get(this.hW)).username);
        }
        if (bi.oW(str2)) {
            SeeAccessVerifyInfoUI.b(this.hOD.hOz);
            BL = c.FR().Yg(bi.oV(((a) this.hOD.hoC.get(this.hW)).username)).BL();
        } else {
            BL = str2;
        }
        SeeAccessVerifyInfoUI.a(this.hOD.hOz, ((a) this.hOD.hoC.get(this.hW)).username, BL, str, true);
    }
}
