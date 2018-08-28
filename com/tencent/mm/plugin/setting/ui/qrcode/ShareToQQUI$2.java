package com.tencent.mm.plugin.setting.ui.qrcode;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.c;

class ShareToQQUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ ShareToQQUI mPF;

    ShareToQQUI$2(ShareToQQUI shareToQQUI) {
        this.mPF = shareToQQUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        l wVar;
        ShareToQQUI.a(this.mPF);
        if (ShareToQQUI.b(this.mPF) == 2 || ShareToQQUI.b(this.mPF) == 1) {
            boolean z;
            boolean z2;
            String obj = ShareToQQUI.c(this.mPF).getText().toString();
            if (ShareToQQUI.b(this.mPF) == 1) {
                z = true;
            } else {
                z = false;
            }
            if (ShareToQQUI.b(this.mPF) == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            wVar = new w(obj, z, z2);
        } else if (ShareToQQUI.b(this.mPF) == 4) {
            long c = bi.c((Long) g.Ei().DT().get(65831, null));
            String oV = bi.oV((String) g.Ei().DT().get(65830, null));
            if (bi.bH(c) > 86400000 && oV.length() > 0) {
                c cVar = new c("290293790992170");
                cVar.aaT(oV);
                new com.tencent.mm.plugin.account.model.g(cVar, new 1(this)).Yl();
            }
            wVar = new w(ShareToQQUI.c(this.mPF).getText().toString());
        } else {
            h.i(this.mPF.mController.tml, i.share_at_least_one_item, i.app_tip);
            return true;
        }
        g.DF().a(wVar, 0);
        ShareToQQUI shareToQQUI = this.mPF;
        ActionBarActivity actionBarActivity = this.mPF.mController.tml;
        this.mPF.getString(i.app_tip);
        ShareToQQUI.a(shareToQQUI, h.a(actionBarActivity, this.mPF.getString(i.app_sending), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                g.DF().c(wVar);
            }
        }));
        return true;
    }
}
