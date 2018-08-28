package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.z;
import com.tencent.mm.bg.d;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class BizChatroomInfoUI$7 implements a {
    final /* synthetic */ BizChatroomInfoUI tFD;

    BizChatroomInfoUI$7(BizChatroomInfoUI bizChatroomInfoUI) {
        this.tFD = bizChatroomInfoUI;
    }

    public final void of(int i) {
        BizChatroomInfoUI.a(this.tFD, i);
    }

    public final void og(int i) {
        boolean z = true;
        j EE = this.tFD.EE(i);
        if (EE == null || bi.oW(EE.field_profileUrl)) {
            String str = "MicroMsg.BizChatroomInfoUI";
            String str2 = "onItemNormalClick userInfo == null:%s";
            Object[] objArr = new Object[1];
            if (EE != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.w(str, str2, objArr);
            return;
        }
        x.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick Url:%s", new Object[]{EE.field_profileUrl});
        z.Ng();
        h.a(EE.field_userId, EE.field_brandUserName, this.tFD);
        Intent intent = new Intent();
        intent.putExtra("rawUrl", EE.field_profileUrl);
        intent.putExtra("useJs", true);
        d.b(this.tFD.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
    }

    public final void aAK() {
        if (BizChatroomInfoUI.b(this.tFD) != null) {
            BizChatroomInfoUI.b(this.tFD).cdV();
        }
    }

    public final void oh(int i) {
        BizChatroomInfoUI.c(this.tFD);
    }
}
