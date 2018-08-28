package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.nu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

class af$35 extends c<nu> {
    final /* synthetic */ af nqT;

    af$35(af afVar) {
        this.nqT = afVar;
        this.sFo = nu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        nu nuVar = (nu) bVar;
        ArrayList arrayList = nuVar.bYN.bYO;
        String str = nuVar.bYN.bYP;
        x.i("MicroMsg.SnsCore", "ResendSnsByUpdateXmlEvent, try resend sns");
        ah.A(new 1(this, arrayList, str));
        return false;
    }
}
