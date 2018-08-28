package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;

class MobileFriendUI$6 implements OnClickListener {
    final /* synthetic */ MobileFriendUI eIS;

    MobileFriendUI$6(MobileFriendUI mobileFriendUI) {
        this.eIS = mobileFriendUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.Ei().DT().set(12322, Boolean.valueOf(false));
        ((a) g.n(a.class)).syncUploadMContactStatus(false, true);
        this.eIS.finish();
    }
}
