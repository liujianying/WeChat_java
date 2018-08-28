package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.8;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.ui.e.a;

class IPCallUserProfileUI$8$2 implements b {
    final /* synthetic */ 8 kzA;

    IPCallUserProfileUI$8$2(8 8) {
        this.kzA = 8;
    }

    public final boolean pm(String str) {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", IPCallUserProfileUI.c(this.kzA.kzx));
        intent.putExtra("Contact_Scene", 13);
        intent.putExtra(a.ths, str);
        d.b(this.kzA.kzx, "profile", ".ui.SayHiWithSnsPermissionUI", intent);
        return true;
    }
}
