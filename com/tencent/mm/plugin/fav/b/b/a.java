package com.tencent.mm.plugin.fav.b.b;

import com.tencent.mm.g.a.cc;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends c<cc> {
    public a() {
        this.sFo = cc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        cc ccVar = (cc) bVar;
        x.i("MicroMsg.Fav.DelFavoriteItemListener", "do delete favitem, localId %d", new Object[]{Long.valueOf(ccVar.bJy.bJA)});
        g dy = ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(ccVar.bJy.bJA);
        ccVar.bJz.bJm = com.tencent.mm.plugin.fav.a.b.i(dy);
        return false;
    }
}
