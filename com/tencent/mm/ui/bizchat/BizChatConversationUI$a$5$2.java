package com.tencent.mm.ui.bizchat;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.ac.c;
import com.tencent.mm.ac.z;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a.5;
import com.tencent.mm.ui.g;

class BizChatConversationUI$a$5$2 implements d {
    final /* synthetic */ 5 tED;

    BizChatConversationUI$a$5$2(5 5) {
        this.tED = 5;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Intent intent;
        switch (menuItem.getItemId()) {
            case 1:
                a.m(this.tED.tEC);
                return;
            case 2:
                g.o(this.tED.tEC.getContext(), a.a(this.tED.tEC), 6);
                return;
            case 3:
                if (bi.oW(a.c(this.tED.tEC))) {
                    a.a(this.tED.tEC, z.MY().kA(a.a(this.tED.tEC)).Mg());
                }
                if (!bi.oW(a.c(this.tED.tEC)) && z.Nk().km(a.c(this.tED.tEC))) {
                    z.Nh();
                    c.a(a.c(this.tED.tEC), null);
                }
                intent = new Intent();
                intent.putExtra("Contact_User", a.a(this.tED.tEC));
                com.tencent.mm.bg.d.b(this.tED.tEC.thisActivity(), "profile", ".ui.ContactInfoUI", intent);
                return;
            case 4:
                if (bi.oW(a.a(this.tED.tEC))) {
                    x.e("MicroMsg.BizChatConversationFmUI", "brandUserName null");
                    return;
                }
                intent = new Intent(this.tED.tEC.getContext(), BizChatFavUI.class);
                intent.putExtra("Contact_User", a.a(this.tED.tEC));
                intent.addFlags(67108864);
                this.tED.tEC.startActivity(intent);
                return;
            default:
                return;
        }
    }
}
