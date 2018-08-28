package com.tencent.mm.plugin.account.friend.ui;

import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.view.MenuItem;
import android.widget.ImageView;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.1;
import com.tencent.mm.ui.base.n.a;
import java.util.HashMap;

class InviteFriendUI$1$1 implements a {
    final /* synthetic */ HashMap eMw;
    final /* synthetic */ PackageManager eMx;
    final /* synthetic */ 1 eMy;

    InviteFriendUI$1$1(1 1, HashMap hashMap, PackageManager packageManager) {
        this.eMy = 1;
        this.eMw = hashMap;
        this.eMx = packageManager;
    }

    public final void a(ImageView imageView, MenuItem menuItem) {
        imageView.setImageDrawable(((ResolveInfo) this.eMw.get(menuItem.getTitle())).loadIcon(this.eMx));
    }
}
