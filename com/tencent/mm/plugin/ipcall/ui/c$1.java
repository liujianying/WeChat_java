package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.ipcall.a.g.c;

class c$1 implements OnClickListener {
    final /* synthetic */ c ktD;

    c$1(c cVar) {
        this.ktD = cVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof Integer) {
            c rA = this.ktD.rA(((Integer) view.getTag()).intValue());
            Intent intent = new Intent(c.a(this.ktD), IPCallUserProfileUI.class);
            intent.putExtra("IPCallProfileUI_contactid", rA.field_contactId);
            intent.putExtra("IPCallProfileUI_systemUsername", rA.field_systemAddressBookUsername);
            intent.putExtra("IPCallProfileUI_wechatUsername", rA.field_wechatUsername);
            c.b(this.ktD).startActivity(intent);
        }
    }
}
