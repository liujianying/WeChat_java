package com.tencent.mm.plugin.readerapp.c;

import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class d extends c<mk> {
    public d() {
        this.sFo = mk.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mk mkVar = (mk) bVar;
        switch (mkVar.bXl.opType) {
            case 3:
                boolean a;
                mk.b bVar2 = mkVar.bXm;
                ch chVar = mkVar.bXl.bXn;
                int i = mkVar.bXl.bXo;
                x.i("MicroMsg.Sns.GetFavDataSource", "fav info, newsSvrid is %d, tweetId is %s", new Object[]{Integer.valueOf(i), mkVar.bXl.bXp});
                List aV = g.bpT().aV((long) i);
                if (!aV.isEmpty()) {
                    x.i("MicroMsg.Sns.GetFavDataSource", "fav news msgs");
                    String aG = bi.aG(r1, "");
                    for (int i2 = 0; i2 < aV.size(); i2++) {
                        if (aG.equals(((com.tencent.mm.model.bi) aV.get(i2)).Iv())) {
                            a = b.a(chVar, (com.tencent.mm.model.bi) aV.get(i2), i2);
                            bVar2.bJm = a;
                            break;
                        }
                    }
                }
                chVar.bJF.bJL = g.favorite_fail_argument_error;
                a = false;
                bVar2.bJm = a;
            case 4:
                g.bpT().hh(mkVar.bXl.bXq);
                break;
        }
        return false;
    }
}
