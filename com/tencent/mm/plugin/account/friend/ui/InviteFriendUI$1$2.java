package com.tencent.mm.plugin.account.friend.ui;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.1;
import com.tencent.mm.ui.base.n.b;
import java.util.HashMap;

class InviteFriendUI$1$2 implements b {
    final /* synthetic */ HashMap eMw;
    final /* synthetic */ PackageManager eMx;
    final /* synthetic */ 1 eMy;

    InviteFriendUI$1$2(1 1, HashMap hashMap, PackageManager packageManager) {
        this.eMy = 1;
        this.eMw = hashMap;
        this.eMx = packageManager;
    }

    public final void a(TextView textView, MenuItem menuItem) {
        textView.setText(((ResolveInfo) this.eMw.get(menuItem.getTitle())).loadLabel(this.eMx).toString());
    }
}
