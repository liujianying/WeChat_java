package com.tencent.mm.ui;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.contact.e;

class SingleChatInfoUI$3 implements a {
    final /* synthetic */ SingleChatInfoUI tqo;

    SingleChatInfoUI$3(SingleChatInfoUI singleChatInfoUI) {
        this.tqo = singleChatInfoUI;
    }

    public final void of(int i) {
    }

    public final void og(int i) {
        String Cc = SingleChatInfoUI.b(this.tqo).Cc(i);
        String oV = ai.oV(SingleChatInfoUI.b(this.tqo).Ce(i));
        if (ai.oW(oV)) {
            au.HU();
            bq Hh = c.FS().Hh(Cc);
            if (!(Hh == null || ai.oW(Hh.field_encryptUsername))) {
                oV = Hh.field_conRemark;
            }
        }
        if (!ai.oW(Cc)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", Cc);
            intent.putExtra("Contact_RemarkName", oV);
            intent.putExtra("Contact_Nick", ai.oV(SingleChatInfoUI.b(this.tqo).Cd(i)));
            intent.putExtra("Contact_RoomMember", true);
            au.HU();
            ab Yg = c.FR().Yg(Cc);
            if (Yg != null && ((int) Yg.dhP) > 0 && com.tencent.mm.l.a.gd(Yg.field_type)) {
                e.a(intent, Cc);
            }
            intent.putExtra("Kdel_from", 0);
            d.b(this.tqo, "profile", ".ui.ContactInfoUI", intent, 0);
        }
    }

    public final void aAK() {
        if (SingleChatInfoUI.b(this.tqo) != null) {
            SingleChatInfoUI.b(this.tqo).cdV();
        }
    }

    public final void oh(int i) {
        SingleChatInfoUI.c(this.tqo);
    }
}
