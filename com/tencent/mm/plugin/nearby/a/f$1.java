package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.R;
import com.tencent.mm.az.d;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.a.iu;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ba;

class f$1 extends c<iu> {
    final /* synthetic */ f lBu;

    f$1(f fVar) {
        this.lBu = fVar;
        this.sFo = iu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 3;
        iu iuVar = (iu) bVar;
        bd.b bVar2 = iuVar.bSn.bSo;
        com.tencent.mm.storage.bd bdVar = iuVar.bSn.bGS;
        if (bVar2.dCs != null && bVar2.scene == 1) {
            au.HU();
            com.tencent.mm.model.c.DT().set(73729, Integer.valueOf(1));
            ba baVar = new ba();
            baVar.field_content = bdVar.field_content;
            baVar.field_createtime = bi.VE();
            baVar.field_imgpath = "";
            baVar.field_sayhicontent = ad.getContext().getString(R.l.nearby_say_hi_type_voice);
            baVar.field_sayhiuser = bdVar.field_talker;
            baVar.field_scene = 18;
            if (bdVar.field_status > 3) {
                i = bdVar.field_status;
            }
            baVar.field_status = i;
            baVar.field_svrid = bdVar.field_msgSvrId;
            baVar.field_talker = bdVar.field_talker;
            baVar.field_type = 34;
            baVar.field_isSend = 0;
            baVar.field_sayhiencryptuser = bdVar.field_talker;
            baVar.field_ticket = bVar2.dCs;
            d.SG().a(baVar);
            it itVar = new it();
            itVar.bSl.bSm = bdVar.field_talker;
            a.sFg.m(itVar);
        }
        return false;
    }
}
