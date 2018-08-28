package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.account.bind.ui.d.1;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.pluginsdk.ui.applet.a.b;
import com.tencent.mm.ui.e;

class d$1$2 implements b {
    final /* synthetic */ 1 eIF;
    final /* synthetic */ a eIx;

    d$1$2(1 1, a aVar) {
        this.eIF = 1;
        this.eIx = aVar;
    }

    public final boolean pm(String str) {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", this.eIx.getUsername());
        intent.putExtra("Contact_Nick", this.eIx.Xm());
        intent.putExtra("Contact_Scene", 13);
        intent.putExtra("sayhi_with_sns_perm_send_verify", true);
        intent.putExtra("sayhi_with_sns_perm_add_remark", true);
        intent.putExtra("sayhi_with_jump_to_profile", true);
        intent.putExtra(e.a.ths, str);
        d.b(d.b(this.eIF.eIE), "profile", ".ui.SayHiWithSnsPermissionUI", intent, 1);
        return true;
    }
}
