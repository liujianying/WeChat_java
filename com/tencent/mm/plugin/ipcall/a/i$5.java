package com.tencent.mm.plugin.ipcall.a;

import android.content.Intent;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.plugin.ipcall.ui.IPCallDialUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

class i$5 extends c<qx> {
    final /* synthetic */ i kpj;

    i$5(i iVar) {
        this.kpj = iVar;
        this.sFo = qx.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qx qxVar = (qx) bVar;
        if (qxVar instanceof qx) {
            Intent intent = new Intent(ad.getContext(), IPCallDialUI.class);
            intent.setFlags(268435456);
            intent.putExtra("IPCallTalkUI_contactId", qxVar.cbG.cbH);
            intent.putExtra("IPCallTalkUI_countryCode", qxVar.cbG.cbI);
            intent.putExtra("IPCallTalkUI_nickname", qxVar.cbG.bgn);
            intent.putExtra("IPCallTalkUI_phoneNumber", qxVar.cbG.cbJ);
            ad.getContext().startActivity(intent);
        }
        return false;
    }
}
