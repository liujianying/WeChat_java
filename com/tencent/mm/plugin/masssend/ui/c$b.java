package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.masssend.a.a;
import com.tencent.mm.plugin.masssend.a.h;

class c$b implements OnClickListener {
    private String id;
    final /* synthetic */ c laQ;

    public c$b(c cVar, String str) {
        this.laQ = cVar;
        this.id = str;
    }

    public final void onClick(View view) {
        a Gi = h.bco().Gi(this.id);
        Intent intent = new Intent(c.a(this.laQ), MassSendMsgUI.class);
        intent.putExtra("mass_send_contact_list", Gi.bcj());
        intent.putExtra("mass_send_again", true);
        c.a(this.laQ).startActivity(intent);
    }
}
