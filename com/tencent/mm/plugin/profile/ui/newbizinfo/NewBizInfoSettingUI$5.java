package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class NewBizInfoSettingUI$5 implements OnCancelListener {
    final /* synthetic */ NewBizInfoSettingUI lZc;

    NewBizInfoSettingUI$5(NewBizInfoSettingUI newBizInfoSettingUI) {
        this.lZc = newBizInfoSettingUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        NewBizInfoSettingUI.c(this.lZc);
    }
}
