package com.tencent.mm.plugin.account.friend.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.MenuItem;
import com.tencent.mm.plugin.account.friend.ui.InviteFriendUI.1;
import com.tencent.mm.ui.base.n.d;
import java.util.HashMap;

class InviteFriendUI$1$4 implements d {
    final /* synthetic */ String eMA;
    final /* synthetic */ HashMap eMw;
    final /* synthetic */ 1 eMy;
    final /* synthetic */ Uri eMz;

    InviteFriendUI$1$4(1 1, HashMap hashMap, Uri uri, String str) {
        this.eMy = 1;
        this.eMw = hashMap;
        this.eMz = uri;
        this.eMA = str;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        String str = menuItem.getTitle();
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(((ResolveInfo) this.eMw.get(str)).activityInfo.packageName, ((ResolveInfo) this.eMw.get(str)).activityInfo.name));
        intent.setAction("android.intent.action.SENDTO");
        intent.setData(this.eMz);
        intent.putExtra("sms_body", this.eMA);
        this.eMy.eMv.startActivity(intent);
    }
}
