package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class SnsTagDetailUI$9 implements a {
    final /* synthetic */ SnsTagDetailUI obJ;

    SnsTagDetailUI$9(SnsTagDetailUI snsTagDetailUI) {
        this.obJ = snsTagDetailUI;
    }

    public final void of(int i) {
        String Cc = this.obJ.hLp.Cc(i);
        x.d("MicroMsg.SnsTagDetailUI", "roomPref del " + i + " userName : " + Cc);
        g.Ek();
        if (bi.aG((String) g.Ei().DT().get(2, null), "").equals(Cc)) {
            h.i(this.obJ.mController.tml, j.room_delete_self_tip, j.app_tip);
            return;
        }
        this.obJ.yp(Cc);
        if (!(this.obJ.obG + " " + bi.c(this.obJ.jzp, ",")).equals(this.obJ.bKg) || this.obJ.noJ == 0) {
            this.obJ.enableOptionMenu(true);
        } else {
            this.obJ.enableOptionMenu(false);
        }
    }

    public final void oh(int i) {
        x.d("MicroMsg.SnsTagDetailUI", "roomPref add " + i);
        SnsTagDetailUI.a(this.obJ);
    }

    public final void og(int i) {
        String Cc = this.obJ.hLp.Cc(i);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", Cc);
        com.tencent.mm.plugin.sns.c.a.ezn.d(intent, this.obJ);
    }

    public final void aAK() {
        if (this.obJ.hLp != null) {
            this.obJ.hLp.cdV();
        }
    }
}
