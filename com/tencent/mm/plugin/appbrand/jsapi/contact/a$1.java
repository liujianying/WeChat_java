package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;

class a$1 implements c {
    final /* synthetic */ String bAj;
    final /* synthetic */ MMActivity fPh;
    final /* synthetic */ a fPi;

    a$1(a aVar, MMActivity mMActivity, String str) {
        this.fPi = aVar;
        this.fPh = mMActivity;
        this.bAj = str;
    }

    public final void ju(int i) {
        Intent intent;
        switch (i) {
            case 0:
                intent = new Intent("android.intent.action.INSERT", Contacts.CONTENT_URI);
                a.a(this.fPi, intent, this.fPh, this.bAj);
                this.fPh.startActivity(intent);
                this.fPh.startActivityForResult(intent, hashCode() & 65535);
                return;
            case 1:
                intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
                intent.setType("vnd.android.cursor.item/person");
                a.a(this.fPi, intent, this.fPh, this.bAj);
                this.fPh.startActivityForResult(intent, hashCode() & 65535);
                return;
            default:
                return;
        }
    }
}
