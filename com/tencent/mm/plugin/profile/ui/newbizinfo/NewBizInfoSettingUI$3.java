package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ac.d;

class NewBizInfoSettingUI$3 implements OnClickListener {
    final /* synthetic */ d bAy;
    final /* synthetic */ NewBizInfoSettingUI lZc;

    NewBizInfoSettingUI$3(NewBizInfoSettingUI newBizInfoSettingUI, d dVar) {
        this.lZc = newBizInfoSettingUI;
        this.bAy = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.bAy.field_hadAlert = 1;
        NewBizInfoSettingUI.a(this.lZc, this.bAy, false);
    }
}
