package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.setting.a.i;

class SettingsAliasResultUI$2 implements OnClickListener {
    final /* synthetic */ SettingsAliasResultUI mRQ;

    SettingsAliasResultUI$2(SettingsAliasResultUI settingsAliasResultUI) {
        this.mRQ = settingsAliasResultUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.mRQ.mController.tml, RegByMobileSetPwdUI.class);
        intent.putExtra("kintent_hint", this.mRQ.getString(i.regbymobile_reg_setpwd_tip_after_set_alias));
        this.mRQ.startActivityForResult(intent, 0);
    }
}
