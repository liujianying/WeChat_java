package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.a.i;

class SettingsModifyEmailAddrUI$28 implements OnClickListener {
    final /* synthetic */ SettingsModifyEmailAddrUI mSQ;

    SettingsModifyEmailAddrUI$28(SettingsModifyEmailAddrUI settingsModifyEmailAddrUI) {
        this.mSQ = settingsModifyEmailAddrUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(this.mSQ, RegByMobileSetPwdUI.class);
        intent.putExtra("kintent_hint", this.mSQ.getString(i.settings_unbind_set_password_tip));
        intent.putExtra("from_unbind", true);
        this.mSQ.startActivityForResult(intent, 1);
    }
}
