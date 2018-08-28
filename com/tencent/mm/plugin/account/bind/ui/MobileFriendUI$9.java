package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;

class MobileFriendUI$9 implements OnCancelListener {
    final /* synthetic */ MobileFriendUI eIS;

    MobileFriendUI$9(MobileFriendUI mobileFriendUI) {
        this.eIS = mobileFriendUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (MobileFriendUI.a(this.eIS) != null) {
            g.DF().c(MobileFriendUI.a(this.eIS));
        }
    }
}
