package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.account.friend.a.ad.1;
import com.tencent.mm.sdk.platformtools.x;

class ad$1$1 implements e {
    final /* synthetic */ 1 eKX;

    ad$1$1(1 1) {
        this.eKX = 1;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.NetSceneGetSuggestAlias", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            this.eKX.eKW.a(this.eKX.eKW.dIX, this.eKX.eKW.diJ);
        } else {
            this.eKX.eKW.diJ.a(i, i2, "", this.eKX.eKW);
        }
    }
}
