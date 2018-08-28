package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ac.m;
import com.tencent.mm.ac.m.a.a;
import com.tencent.mm.ac.z;
import com.tencent.mm.model.au;

class ContactSearchResultUI$d implements a, Runnable {
    public ImageView eCl;
    public TextView eMf;
    public View hod;
    public TextView hoe;
    private View hoh;
    public String iconUrl;
    ContactSearchResultUI.a otu = new 1(this);
    public String username;

    public ContactSearchResultUI$d() {
        z.Ni().a(this);
    }

    public final void run() {
        Bitmap kV = m.kV(this.username);
        if (kV != null) {
            ContactSearchResultUI.bGz().post(new 2(this, kV));
        } else {
            ContactSearchResultUI.bGz().post(new 3(this));
        }
    }

    public final void kX(String str) {
        if (str != null && str.equals(this.username)) {
            this.otu.eR(this.username, this.iconUrl);
            au.Em().h(this.otu, 200);
        }
    }
}
