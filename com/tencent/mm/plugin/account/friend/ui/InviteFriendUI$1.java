package com.tencent.mm.plugin.account.friend.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.a.o;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.ui.tools.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class InviteFriendUI$1 implements OnClickListener {
    final /* synthetic */ InviteFriendUI eMv;

    InviteFriendUI$1(InviteFriendUI inviteFriendUI) {
        this.eMv = inviteFriendUI;
    }

    public final void onClick(View view) {
        String string;
        switch (InviteFriendUI.a(this.eMv)) {
            case 0:
                new g(this.eMv, new 5(this)).g(new int[]{o.cx(InviteFriendUI.b(this.eMv))});
                return;
            case 1:
                String str = (String) g.Ei().DT().get(42, (Object) "");
                if (str == null || str.length() == 0) {
                    str = (String) g.Ei().DT().get(2, (Object) "");
                }
                string = this.eMv.getString(j.invite_sms, new Object[]{str});
                Uri parse = Uri.parse("smsto:" + InviteFriendUI.b(this.eMv));
                Intent intent = new Intent("android.intent.action.SENDTO", parse);
                intent.putExtra("sms_body", string);
                PackageManager packageManager = this.eMv.getPackageManager();
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
                HashMap hashMap = new HashMap();
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    if (!resolveInfo.activityInfo.packageName.equals("com.whatsapp")) {
                        hashMap.put(resolveInfo.activityInfo.name, resolveInfo);
                    }
                }
                if (hashMap.size() == 1) {
                    Iterator it = hashMap.keySet().iterator();
                    if (it.hasNext()) {
                        str = (String) it.next();
                        Intent intent2 = new Intent();
                        intent2.setComponent(new ComponentName(((ResolveInfo) hashMap.get(str)).activityInfo.packageName, ((ResolveInfo) hashMap.get(str)).activityInfo.name));
                        intent2.setAction("android.intent.action.SENDTO");
                        intent2.setData(parse);
                        intent2.putExtra("sms_body", string);
                        this.eMv.startActivity(intent2);
                        InviteFriendUI.c(this.eMv);
                        return;
                    }
                    return;
                } else if (hashMap.size() > 1) {
                    k kVar = new k(this.eMv);
                    kVar.uAx = new 1(this, hashMap, packageManager);
                    kVar.uAy = new 2(this, hashMap, packageManager);
                    kVar.ofp = new 3(this, hashMap);
                    kVar.ofq = new 4(this, hashMap, parse, string);
                    kVar.bEo();
                    InviteFriendUI.c(this.eMv);
                    return;
                } else {
                    Toast.makeText(this.eMv, j.selectsmsapp_none, 1).show();
                    return;
                }
            case 2:
                e hVar = new h(this.eMv, new 6(this));
                string = InviteFriendUI.e(this.eMv);
                String b = InviteFriendUI.b(this.eMv);
                g.DF().a(489, hVar);
                Cursor py = ((com.tencent.mm.plugin.account.friend.a.o) ((a) g.n(a.class)).getGoogleFriendStorage()).py(string);
                if (py == null || py.getCount() <= 1) {
                    hVar.pD(b);
                } else {
                    hVar.e(py);
                }
                if (py != null) {
                    py.close();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
