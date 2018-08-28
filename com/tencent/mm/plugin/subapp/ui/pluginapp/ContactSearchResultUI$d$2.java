package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI.d;

class ContactSearchResultUI$d$2 implements Runnable {
    final /* synthetic */ d otv;
    final /* synthetic */ Bitmap otw;

    ContactSearchResultUI$d$2(d dVar, Bitmap bitmap) {
        this.otv = dVar;
        this.otw = bitmap;
    }

    public final void run() {
        if (this.otv.eCl != null && this.otv.eCl.getTag() != null && this.otv.username != null && this.otv.username.equals(this.otv.eCl.getTag())) {
            this.otv.eCl.setImageBitmap(this.otw);
        }
    }
}
