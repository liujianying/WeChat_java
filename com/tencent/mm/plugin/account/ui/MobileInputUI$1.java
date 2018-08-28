package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import com.tencent.mm.g.a.iz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class MobileInputUI$1 extends c<iz> {
    final /* synthetic */ MobileInputUI eTe;

    MobileInputUI$1(MobileInputUI mobileInputUI) {
        this.eTe = mobileInputUI;
        this.sFo = iz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        iz izVar = (iz) bVar;
        if (izVar == null || izVar.bSF == null) {
            return false;
        }
        x.i("MicroMsg.MobileInputUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", new Object[]{izVar.bSF.content, izVar.bSF.url});
        Intent intent = new Intent();
        intent.putExtra("key_disaster_content", izVar.bSF.content);
        intent.putExtra("key_disaster_url", izVar.bSF.url);
        intent.setClass(ad.getContext(), DisasterUI.class).addFlags(268435456);
        ad.getContext().startActivity(intent);
        return true;
    }
}
