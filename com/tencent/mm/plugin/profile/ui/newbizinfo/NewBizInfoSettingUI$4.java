package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;

class NewBizInfoSettingUI$4 implements OnClickListener {
    final /* synthetic */ NewBizInfoSettingUI lZc;

    NewBizInfoSettingUI$4(NewBizInfoSettingUI newBizInfoSettingUI) {
        this.lZc = newBizInfoSettingUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        NewBizInfoSettingUI.b(this.lZc);
        c.bT(NewBizInfoSettingUI.a(this.lZc).field_username, 910);
    }
}
