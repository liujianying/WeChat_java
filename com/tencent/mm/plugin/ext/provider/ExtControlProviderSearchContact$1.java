package com.tencent.mm.plugin.ext.provider;

import android.database.Cursor;
import com.tencent.mm.pluginsdk.d.a.b;

class ExtControlProviderSearchContact$1 implements Runnable {
    final /* synthetic */ Cursor fmH;
    final /* synthetic */ b heb;
    final /* synthetic */ ExtControlProviderSearchContact iKA;

    ExtControlProviderSearchContact$1(ExtControlProviderSearchContact extControlProviderSearchContact, Cursor cursor, b bVar) {
        this.iKA = extControlProviderSearchContact;
        this.fmH = cursor;
        this.heb = bVar;
    }

    public final void run() {
        ExtControlProviderSearchContact.a(this.iKA, ExtControlProviderSearchContact.h(this.fmH));
        this.heb.countDown();
    }
}
