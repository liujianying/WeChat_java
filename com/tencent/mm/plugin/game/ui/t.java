package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.al;
import com.tencent.mm.plugin.game.model.bd;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.a.c.a;

public final class t implements OnClickListener, e {
    private d jMa = null;
    int jNv;
    DialogInterface.OnClickListener kcI = null;
    private Context mContext;

    public t(Context context) {
        this.mContext = context;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof d) {
            this.jMa = (d) view.getTag();
            x.i("MicroMsg.GameSubscriptionClickListener", "Clicked appid = " + this.jMa.field_appId);
            g.DF().a(1219, this);
            g.DF().a(new bd(this.jMa.field_appId, w.chP(), this.jMa.bHF, this.jMa.jLo), 0);
            return;
        }
        x.e("MicroMsg.GameSubscriptionClickListener", "No GameAppInfo");
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i == 0 && i2 == 0 && lVar.getType() == 1219) {
            g.DF().b(1219, this);
            al alVar = new al(((bd) lVar).ivx.dIE.dIL);
            b bVar = new b();
            bVar.kcM = Boolean.valueOf(alVar.jOd.jPk);
            bVar.title = alVar.jOd.bHD;
            bVar.content = alVar.jOd.jPH;
            if (alVar.jOd.jTs != null) {
                bVar.kcN = new a();
                bVar.kcN.message = alVar.jOd.jTs.jPH;
                bVar.kcN.kcK = alVar.jOd.jTs.jPI;
                bVar.kcN.kcL = alVar.jOd.jTs.jPJ;
                bVar.kcN.url = alVar.jOd.jTs.jPK;
            }
            this.jMa.jLg = bVar.kcM.booleanValue();
            if (!bi.oW(bVar.title)) {
                if (bVar.kcN != null) {
                    String str2 = bVar.kcN.url;
                    a aVar = new a(this.mContext);
                    aVar.abt(bVar.title);
                    aVar.abu(bVar.kcN.message);
                    aVar.mF(false);
                    aVar.abx(bVar.kcN.kcK).a(true, new 1(this, str2));
                    aVar.aby(bVar.kcN.kcL).b(this.kcI);
                    aVar.anj().show();
                    return;
                } else if (!bi.oW(bVar.content)) {
                    a aVar2 = new a(this.mContext);
                    aVar2.abt(bVar.title);
                    aVar2.abu(bVar.content);
                    aVar2.mF(false);
                    aVar2.Gt(i.game_subscription_dialog_positive).a(this.kcI);
                    aVar2.anj().show();
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        a aVar3 = new a(this.mContext);
        aVar3.Gr(i.game_subsription_failed);
        aVar3.Gt(i.game_subscription_dialog_positive);
        aVar3.anj().show();
    }
}
