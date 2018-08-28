package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class MobileFriendUI$5 implements OnClickListener {
    final /* synthetic */ MobileFriendUI eIS;

    MobileFriendUI$5(MobileFriendUI mobileFriendUI) {
        this.eIS = mobileFriendUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.mEJ.h(11438, new Object[]{Integer.valueOf(6)});
        x.i("MicroMsg.MobileFriendUI", "[cpan] kv report logid:%d scene:%d", new Object[]{Integer.valueOf(11438), Integer.valueOf(6)});
        g.Ei().DT().set(12322, Boolean.valueOf(true));
        ((a) g.n(a.class)).syncUploadMContactStatus(true, true);
        MobileFriendUI.h(this.eIS);
    }
}
