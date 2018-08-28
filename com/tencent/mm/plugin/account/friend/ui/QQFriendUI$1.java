package com.tencent.mm.plugin.account.friend.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ac;

class QQFriendUI$1 implements OnCancelListener {
    final /* synthetic */ ac eMU;
    final /* synthetic */ QQFriendUI eMV;

    QQFriendUI$1(QQFriendUI qQFriendUI, ac acVar) {
        this.eMV = qQFriendUI;
        this.eMU = acVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eMU);
    }
}
