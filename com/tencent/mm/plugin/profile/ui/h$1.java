package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bi;

class h$1 implements a {
    final /* synthetic */ h lWf;

    h$1(h hVar) {
        this.lWf = hVar;
    }

    public final void of(int i) {
    }

    public final void og(int i) {
        if (this.lWf.lWe.Cb(i)) {
            String Cc = this.lWf.lWe.Cc(i);
            if (!bi.oW(Cc)) {
                Intent intent = new Intent();
                intent.setClass(this.lWf.context, ContactInfoUI.class);
                intent.putExtra("Contact_User", Cc);
                intent.putExtra("Contact_RoomNickname", this.lWf.hLB.gT(Cc));
                this.lWf.context.startActivity(intent);
            }
        }
    }

    public final void aAK() {
    }

    public final void oh(int i) {
    }
}
