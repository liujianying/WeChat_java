package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;

class SeeAccessVerifyInfoUI$2 implements OnClickListener {
    final /* synthetic */ SeeAccessVerifyInfoUI hOz;

    SeeAccessVerifyInfoUI$2(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI) {
        this.hOz = seeAccessVerifyInfoUI;
    }

    public final void onClick(View view) {
        SeeAccessVerifyInfoUI.b(this.hOz);
        ab Yg = c.FR().Yg(bi.oV(SeeAccessVerifyInfoUI.a(this.hOz)));
        String str = Yg.field_nickname;
        String str2 = null;
        if (SeeAccessVerifyInfoUI.c(this.hOz) != null) {
            str2 = SeeAccessVerifyInfoUI.c(this.hOz).gT(SeeAccessVerifyInfoUI.a(this.hOz));
        }
        if (bi.oW(str2)) {
            str2 = Yg.BL();
        }
        SeeAccessVerifyInfoUI.a(this.hOz, SeeAccessVerifyInfoUI.a(this.hOz), str2, str, false);
    }
}
