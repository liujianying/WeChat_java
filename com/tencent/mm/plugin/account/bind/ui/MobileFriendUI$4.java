package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;

class MobileFriendUI$4 implements OnClickListener {
    final /* synthetic */ MobileFriendUI eIS;

    MobileFriendUI$4(MobileFriendUI mobileFriendUI) {
        this.eIS = mobileFriendUI;
    }

    public final void onClick(View view) {
        c.a(MobileFriendUI.f(this.eIS));
    }
}
