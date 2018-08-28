package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.graphics.Bitmap;
import com.tencent.mm.ac.m;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI.a;
import com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI.d;
import com.tencent.mm.sdk.platformtools.bi;

class ContactSearchResultUI$d$1 extends a {
    final /* synthetic */ d otv;

    ContactSearchResultUI$d$1(d dVar) {
        this.otv = dVar;
        super((byte) 0);
    }

    public final void run() {
        if (!bi.oW(this.username) && !bi.oW(this.otv.username) && this.username.equals(this.otv.username)) {
            Bitmap d = m.d(this.username, this.iconUrl, 0);
            if (d != null && !d.isRecycled()) {
                d dVar = this.otv;
                if (dVar.eCl != null) {
                    au.Em().H(dVar);
                }
            }
        }
    }
}
