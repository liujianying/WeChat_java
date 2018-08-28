package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.model.d;
import com.tencent.mm.plugin.setting.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;

class SettingsModifyEmailAddrUI$27 implements OnMenuItemClickListener {
    final /* synthetic */ SettingsModifyEmailAddrUI mSQ;

    SettingsModifyEmailAddrUI$27(SettingsModifyEmailAddrUI settingsModifyEmailAddrUI) {
        this.mSQ = settingsModifyEmailAddrUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        SettingsModifyEmailAddrUI.a(this.mSQ, SettingsModifyEmailAddrUI.c(this.mSQ).getText().toString().trim());
        if (bi.WF(SettingsModifyEmailAddrUI.d(this.mSQ))) {
            Integer num = (Integer) g.Ei().DT().get(7, null);
            boolean z = (num == null || (num.intValue() & 2) == 0) ? false : true;
            Boolean valueOf = Boolean.valueOf(z);
            if (SettingsModifyEmailAddrUI.d(this.mSQ).equals(SettingsModifyEmailAddrUI.e(this.mSQ)) && valueOf.booleanValue()) {
                this.mSQ.finish();
            } else {
                final d dVar = new d(d.eNX, SettingsModifyEmailAddrUI.d(this.mSQ));
                g.DF().a(dVar, 0);
                SettingsModifyEmailAddrUI settingsModifyEmailAddrUI = this.mSQ;
                Context context = this.mSQ;
                this.mSQ.getString(i.app_tip);
                SettingsModifyEmailAddrUI.a(settingsModifyEmailAddrUI, h.a(context, this.mSQ.getString(i.settings_binding), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        g.DF().c(dVar);
                    }
                }));
                this.mSQ.YC();
            }
        } else {
            h.i(this.mSQ.mController.tml, i.verify_email_err_tip, i.app_tip);
        }
        return true;
    }
}
