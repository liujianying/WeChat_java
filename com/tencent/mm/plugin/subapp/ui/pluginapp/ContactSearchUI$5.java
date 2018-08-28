package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.a.f;

class ContactSearchUI$5 implements OnCancelListener {
    final /* synthetic */ f hkM;
    final /* synthetic */ ContactSearchUI oty;

    ContactSearchUI$5(ContactSearchUI contactSearchUI, f fVar) {
        this.oty = contactSearchUI;
        this.hkM = fVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.hkM);
    }
}
