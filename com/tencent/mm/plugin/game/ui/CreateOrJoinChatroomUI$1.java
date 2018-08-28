package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.game.d.z;
import com.tencent.mm.sdk.platformtools.x;

class CreateOrJoinChatroomUI$1 implements a {
    final /* synthetic */ CreateOrJoinChatroomUI jUb;

    CreateOrJoinChatroomUI$1(CreateOrJoinChatroomUI createOrJoinChatroomUI) {
        this.jUb = createOrJoinChatroomUI;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        z zVar = (z) bVar.dIE.dIL;
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.CreateOrJoinChatroomUI", "Create Url: %s", new Object[]{zVar.jQn});
            CreateOrJoinChatroomUI.a(this.jUb);
            CreateOrJoinChatroomUI.a(this.jUb, r0);
        } else {
            x.e("MicroMsg.CreateOrJoinChatroomUI", "CGI return is not OK. (%d, %d)(%s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (i == 4) {
                CreateOrJoinChatroomUI.a(this.jUb, zVar.iwS);
            } else {
                CreateOrJoinChatroomUI.a(this.jUb, -1);
            }
            CreateOrJoinChatroomUI.a(this.jUb);
            this.jUb.finish();
        }
        return 0;
    }
}
