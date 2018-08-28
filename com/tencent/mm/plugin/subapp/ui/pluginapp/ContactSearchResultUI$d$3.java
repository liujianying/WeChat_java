package com.tencent.mm.plugin.subapp.ui.pluginapp;

import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI.d;

class ContactSearchResultUI$d$3 implements Runnable {
    final /* synthetic */ d otv;

    ContactSearchResultUI$d$3(d dVar) {
        this.otv = dVar;
    }

    public final void run() {
        if (this.otv.eCl != null) {
            this.otv.eCl.setImageResource(R.g.brand_default_head);
            this.otv.otu.eR(this.otv.username, this.otv.iconUrl);
            au.Em().h(this.otv.otu, 200);
        }
    }
}
