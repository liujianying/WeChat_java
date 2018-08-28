package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;

class a$1 implements OnClickListener {
    final /* synthetic */ a iDD;

    a$1(a aVar) {
        this.iDD = aVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", a.a(this.iDD));
        d.b(a.b(this.iDD), "profile", ".ui.ContactInfoUI", intent);
    }
}
