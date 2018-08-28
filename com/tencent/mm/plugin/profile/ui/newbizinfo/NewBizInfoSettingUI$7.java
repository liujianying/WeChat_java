package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.mm.plugin.base.model.b;

class NewBizInfoSettingUI$7 implements Runnable {
    final /* synthetic */ NewBizInfoSettingUI lZc;

    NewBizInfoSettingUI$7(NewBizInfoSettingUI newBizInfoSettingUI) {
        this.lZc = newBizInfoSettingUI;
    }

    public final void run() {
        b.U(this.lZc, NewBizInfoSettingUI.a(this.lZc).field_username);
    }
}
