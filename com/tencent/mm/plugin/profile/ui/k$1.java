package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.l.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements OnClickListener {
    final /* synthetic */ k lWx;

    k$1(k kVar) {
        this.lWx = kVar;
    }

    public final void onClick(View view) {
        k kVar = this.lWx;
        if (kVar.guS == null) {
            x.e("MicroMsg.ContactWidgetNormal", "contact is null");
        } else if (a.gd(kVar.guS.field_type)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_Scene", kVar.eLK);
            intent.putExtra("Contact_User", kVar.guS.field_username);
            intent.putExtra("Contact_RoomNickname", kVar.bOb.getIntent().getStringExtra("Contact_RoomNickname"));
            intent.putExtra("view_mode", true);
            intent.putExtra("contact_phone_number_by_md5", kVar.lWv);
            intent.putExtra("contact_phone_number_list", kVar.guS.csZ);
            com.tencent.mm.plugin.profile.a.ezn.n(intent, kVar.bOb);
        } else if (bi.oW(kVar.guS.field_encryptUsername)) {
            kVar.JG(kVar.guS.field_username);
        } else {
            kVar.JG(kVar.guS.field_encryptUsername);
        }
    }
}
