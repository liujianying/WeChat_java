package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.pe;
import com.tencent.mm.g.a.pe.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends c<pe> implements e {
    private pe htx;

    public a() {
        this.sFo = pe.class.getName().hashCode();
    }

    private boolean a(pe peVar) {
        if (!g.Eg().Dx()) {
            x.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent account is not ready");
            return false;
        } else if (!(peVar instanceof pe)) {
            return false;
        } else {
            this.htx = peVar;
            Object obj = this.htx.caa.cac;
            String str = this.htx.caa.cad;
            int i = this.htx.caa.cae;
            if (TextUtils.isEmpty(obj)) {
                x.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent card_id is empty");
                awy();
                return false;
            }
            g.Eh().dpP.a(651, this);
            x.i("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent doscene from scene " + i);
            g.Eh().dpP.a(new o(obj, i, "", str, "", "", 0, 0, null), 0);
            return true;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof o) {
            b bVar = new b();
            x.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is success");
                o oVar = (o) lVar;
                int i3 = oVar.hwV;
                String str2 = oVar.hwU;
                String str3 = oVar.hwW;
                if (i3 == 0) {
                    x.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return ok ");
                    bVar.bLW = true;
                    CardInfo cardInfo = new CardInfo();
                    f.a(cardInfo, str2);
                    if (TextUtils.isEmpty(cardInfo.field_card_id)) {
                        x.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return card_id is empty ");
                        bVar.cac = "";
                    } else {
                        bVar.cac = cardInfo.field_card_id;
                    }
                    am.axn().putValue("key_accept_card_info", cardInfo);
                } else {
                    x.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return false, retCode " + i3 + " retMsg" + str3);
                    bVar.bLW = false;
                }
            } else {
                x.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is fail");
                bVar.bLW = false;
            }
            g.Eh().dpP.b(651, this);
            this.htx.cab = bVar;
            awy();
        }
    }

    private void awy() {
        if (this.htx.bJX != null) {
            this.htx.bJX.run();
        }
        this.htx = null;
    }
}
