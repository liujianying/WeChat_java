package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;

class NewBizInfoSettingUI$2 implements OnClickListener {
    final /* synthetic */ d bAy;
    final /* synthetic */ NewBizInfoSettingUI lZc;

    NewBizInfoSettingUI$2(NewBizInfoSettingUI newBizInfoSettingUI, d dVar) {
        this.lZc = newBizInfoSettingUI;
        this.bAy = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.bAy.field_hadAlert = 1;
        this.bAy.field_brandFlag |= 4;
        NewBizInfoSettingUI.a(this.lZc, this.bAy, true);
        c.bT(NewBizInfoSettingUI.a(this.lZc).field_username, 906);
    }
}
