package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.g.a.ll;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.base.h;

class SettingsModifyNameUI$1 extends c<ll> {
    final /* synthetic */ SettingsModifyNameUI mSW;

    SettingsModifyNameUI$1(SettingsModifyNameUI settingsModifyNameUI) {
        this.mSW = settingsModifyNameUI;
        super(0);
        this.sFo = ll.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ll llVar = (ll) bVar;
        String str = llVar.bVN.bVO;
        String str2 = llVar.bVN.bVP;
        int i = llVar.bVN.ret;
        if (i != 0 && str2 != null) {
            h.b(this.mSW, str2, str, true);
            if (SettingsModifyNameUI.a(this.mSW) != null) {
                ((i) g.l(i.class)).FQ().c(SettingsModifyNameUI.a(this.mSW));
            }
        } else if (i == 0 && SettingsModifyNameUI.b(this.mSW)) {
            g.Ei().DT().set(4, SettingsModifyNameUI.c(this.mSW).getText().toString());
            this.mSW.finish();
        }
        if (SettingsModifyNameUI.d(this.mSW) != null) {
            SettingsModifyNameUI.d(this.mSW).dismiss();
        }
        return true;
    }
}
