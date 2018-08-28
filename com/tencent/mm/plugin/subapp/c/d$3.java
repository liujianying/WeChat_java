package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.g.a.sr;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bd;

class d$3 extends c<sr> {
    final /* synthetic */ d orm;

    d$3(d dVar) {
        this.orm = dVar;
        super(0);
        this.sFo = sr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sr srVar = (sr) bVar;
        e Oj = e.Oj(srVar.cdw.bVv);
        bd bdVar = srVar.cdw.bGS;
        if (Oj != null) {
            d bGs = d.bGs();
            String str = bdVar.field_talker;
            String str2 = srVar.cdw.description;
            String V = h.V(ad.getContext(), Oj.orn);
            String str3 = "";
            if (V != null && V.length() > 0) {
                String[] split = V.split(";");
                str3 = str3 + split[0];
                if (split.length > 1) {
                    str3 = str3 + split[1];
                }
            }
            if (str2 != null) {
                str3 = str3 + str2;
            }
            bGs.f(str, str3, bdVar.field_createTime);
        }
        return false;
    }
}
