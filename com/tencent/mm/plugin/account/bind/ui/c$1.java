package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.account.bind.ui.b.b;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e;
import java.util.LinkedList;

class c$1 implements b {
    final /* synthetic */ c eIv;

    c$1(c cVar) {
        this.eIv = cVar;
    }

    public final void c(int i, String str, int i2) {
        x.d("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)});
        final a aVar = (a) this.eIv.getItem(i);
        if (aVar == null) {
            x.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", new Object[]{str});
            return;
        }
        x.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", new Object[]{aVar.toString()});
        if (aVar.status == 1) {
            com.tencent.mm.pluginsdk.ui.applet.a aVar2 = new com.tencent.mm.pluginsdk.ui.applet.a(c.a(this.eIv), new 1(this));
            aVar2.qHX = new com.tencent.mm.pluginsdk.ui.applet.a.b() {
                public final boolean pm(String str) {
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", aVar.getUsername());
                    intent.putExtra("Contact_Nick", aVar.Xm());
                    intent.putExtra("Contact_Scene", 13);
                    intent.putExtra("sayhi_with_sns_perm_send_verify", true);
                    intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                    intent.putExtra("sayhi_with_jump_to_profile", true);
                    intent.putExtra(e.a.ths, str);
                    d.b(c.b(c$1.this.eIv), "profile", ".ui.SayHiWithSnsPermissionUI", intent, 1);
                    return true;
                }
            };
            if (c.c(this.eIv) instanceof MobileFriendUI) {
                ((MobileFriendUI) c.e(this.eIv)).geJ = new 3(this, aVar);
            }
            aVar2.eNh = aVar.Xh();
            aVar2.qIe = false;
            LinkedList linkedList = new LinkedList();
            linkedList.add(Integer.valueOf(13));
            aVar2.b(aVar.getUsername(), linkedList, false);
        }
    }
}
