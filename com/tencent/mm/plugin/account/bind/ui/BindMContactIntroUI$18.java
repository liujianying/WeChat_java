package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

class BindMContactIntroUI$18 implements Runnable {
    final /* synthetic */ BindMContactIntroUI eGe;

    BindMContactIntroUI$18(BindMContactIntroUI bindMContactIntroUI) {
        this.eGe = bindMContactIntroUI;
    }

    public final void run() {
        if (l.XA()) {
            BindMContactIntroUI.WM();
            BindMContactIntroUI.j(this.eGe).setText(this.eGe.getString(j.bind_mcontact_friend_btn_text));
            BindMContactIntroUI.a(this.eGe, a.eKt);
            boolean a = bi.a((Boolean) g.Ei().DT().get(12322, Boolean.valueOf(false)), false);
            if (BindMContactIntroUI.i(this.eGe) && a) {
                h.mEJ.h(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, new Object[]{Integer.valueOf(3), Integer.valueOf(3)});
            }
        }
    }
}
