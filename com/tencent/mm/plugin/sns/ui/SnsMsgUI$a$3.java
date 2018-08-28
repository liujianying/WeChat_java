package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.SnsMsgUI.a;

class SnsMsgUI$a$3 implements OnClickListener {
    final /* synthetic */ String dMs;
    final /* synthetic */ a nYq;

    SnsMsgUI$a$3(a aVar, String str) {
        this.nYq = aVar;
        this.dMs = str;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", this.dMs);
        com.tencent.mm.plugin.sns.c.a.ezn.d(intent, this.nYq.nYl);
    }
}
