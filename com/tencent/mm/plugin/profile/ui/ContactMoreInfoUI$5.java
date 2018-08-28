package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.fts.a.e;

class ContactMoreInfoUI$5 implements OnClickListener {
    final /* synthetic */ int dhD;
    final /* synthetic */ ContactMoreInfoUI lVo;

    ContactMoreInfoUI$5(ContactMoreInfoUI contactMoreInfoUI, int i) {
        this.lVo = contactMoreInfoUI;
        this.dhD = i;
    }

    public final void onClick(View view) {
        e.qe(this.dhD);
        if (this.dhD > 0) {
            Intent intent = new Intent(this.lVo, CommonChatroomInfoUI.class);
            intent.putExtra("Select_Talker_Name", ContactMoreInfoUI.b(this.lVo).field_username);
            this.lVo.startActivity(intent);
        }
    }
}
