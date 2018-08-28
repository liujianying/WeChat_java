package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.game.d.ao;
import com.tencent.mm.sdk.platformtools.x;

class CreateOrJoinChatroomUI$2 implements a {
    final /* synthetic */ CreateOrJoinChatroomUI jUb;

    CreateOrJoinChatroomUI$2(CreateOrJoinChatroomUI createOrJoinChatroomUI) {
        this.jUb = createOrJoinChatroomUI;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        ao aoVar = (ao) bVar.dIE.dIL;
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.CreateOrJoinChatroomUI", "Join Url: %s", new Object[]{aoVar.jQW});
            CreateOrJoinChatroomUI.a(this.jUb);
            CreateOrJoinChatroomUI.a(this.jUb, r0);
        } else {
            x.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 4) {
                CreateOrJoinChatroomUI.a(this.jUb, aoVar.iwS);
            } else {
                CreateOrJoinChatroomUI.a(this.jUb, -1);
            }
            CreateOrJoinChatroomUI.a(this.jUb);
            this.jUb.finish();
        }
        return 0;
    }
}
