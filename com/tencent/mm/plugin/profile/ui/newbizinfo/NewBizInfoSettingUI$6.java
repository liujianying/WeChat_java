package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.mm.model.bd.a;

class NewBizInfoSettingUI$6 implements a {
    final /* synthetic */ NewBizInfoSettingUI lZc;

    NewBizInfoSettingUI$6(NewBizInfoSettingUI newBizInfoSettingUI) {
        this.lZc = newBizInfoSettingUI;
    }

    public final boolean Ip() {
        return NewBizInfoSettingUI.d(this.lZc);
    }

    public final void Io() {
        if (NewBizInfoSettingUI.e(this.lZc) != null) {
            NewBizInfoSettingUI.e(this.lZc).dismiss();
            NewBizInfoSettingUI.f(this.lZc);
        }
    }
}
