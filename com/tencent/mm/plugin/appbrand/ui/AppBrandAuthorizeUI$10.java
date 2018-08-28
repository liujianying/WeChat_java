package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.protocal.c.eb;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import java.util.List;

class AppBrandAuthorizeUI$10 implements Runnable {
    final /* synthetic */ AppBrandAuthorizeUI guf;
    final /* synthetic */ List guk;

    AppBrandAuthorizeUI$10(AppBrandAuthorizeUI appBrandAuthorizeUI, List list) {
        this.guf = appBrandAuthorizeUI;
        this.guk = list;
    }

    public final void run() {
        x.d("MicroMsg.AppBrandAuthorizeUI", "initAuthItem authItems.size = %d", new Object[]{Integer.valueOf(this.guk.size())});
        for (eb ebVar : this.guk) {
            boolean z;
            CheckBoxPreference checkBoxPreference = new CheckBoxPreference(this.guf);
            checkBoxPreference.tDr = false;
            checkBoxPreference.setKey(ebVar.scope);
            checkBoxPreference.setTitle(ebVar.rep);
            if (ebVar.state == 1) {
                z = true;
            } else {
                z = false;
            }
            checkBoxPreference.qpJ = z;
            this.guf.gua.a(checkBoxPreference);
        }
        this.guf.gua.notifyDataSetChanged();
        x.d("MicroMsg.AppBrandAuthorizeUI", "initAuthItem finish");
    }
}
