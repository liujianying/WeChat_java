package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.b;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.t.d;

public class aa$c extends d {
    public aa$c(a aVar) {
        super(aVar);
    }

    public final void a(View view, a aVar, bd bdVar) {
        boolean z;
        String trim;
        b GS;
        iy iyVar;
        String str;
        Intent intent;
        bd bdVar2 = ((au) view.getTag()).bXQ;
        String str2 = bdVar2.field_content;
        if (bdVar2.field_isSend == 0) {
            z = true;
        } else {
            z = false;
        }
        String str3 = "";
        if (z) {
            str3 = bdVar2.field_talker;
        }
        if (s.fq(bdVar2.field_talker) && z && !((c) this.tKy.O(c.class)).cur()) {
            int iA = com.tencent.mm.model.bd.iA(str2);
            if (iA != -1) {
                str3 = str2.substring(0, iA).trim();
                trim = str2.substring(iA + 1).trim();
                au.HU();
                GS = com.tencent.mm.model.c.FT().GS(trim);
                trim = (ai.oW(str3) || !s.fq(str3)) ? str3 : "";
                iyVar = new iy();
                iyVar.bSB.bSv = 1;
                iyVar.bSB.bGS = bdVar2;
                com.tencent.mm.sdk.b.a.sFg.m(iyVar);
                str = iyVar.bSC.bPu;
                if ((ai.oW(iyVar.bSC.bSE) || !ai.oW(str)) && !"err_not_started".equals(str)) {
                    intent = new Intent();
                    intent.putExtra("kMsgId", bdVar2.field_msgId);
                    intent.putExtra("map_view_type", 1);
                    intent.putExtra("kwebmap_slat", GS.kCw);
                    intent.putExtra("kwebmap_lng", GS.kCx);
                    intent.putExtra("kwebmap_scale", GS.bSz);
                    intent.putExtra("kPoiName", GS.kFa);
                    intent.putExtra("kisUsername", r.gT(trim));
                    intent.putExtra("Kwebmap_locaion", str);
                    au.HU();
                    intent.putExtra("kimg_path", com.tencent.mm.model.c.Gb());
                    intent.putExtra("map_talker_name", bdVar2.field_talker);
                    intent.putExtra("view_type_key", 0);
                    intent.putExtra("kwebmap_from_to", true);
                    intent.putExtra("kPoi_url", GS.qyA);
                    intent.putExtra("soso_street_view_url", ai.aG(bdVar2.field_reserved, ""));
                    h.mEJ.h(12809, new Object[]{Integer.valueOf(2), ""});
                    com.tencent.mm.bg.d.a(this.tKy.tTo, "location", ".ui.RedirectUI", intent, 2002, new 1(this));
                }
                x.e("MicroMsg.LocationClickListener", "location not valid or subcore not started");
                return;
            }
        }
        trim = str2;
        au.HU();
        GS = com.tencent.mm.model.c.FT().GS(trim);
        if (!ai.oW(str3)) {
        }
        iyVar = new iy();
        iyVar.bSB.bSv = 1;
        iyVar.bSB.bGS = bdVar2;
        com.tencent.mm.sdk.b.a.sFg.m(iyVar);
        str = iyVar.bSC.bPu;
        if (ai.oW(iyVar.bSC.bSE)) {
        }
        intent = new Intent();
        intent.putExtra("kMsgId", bdVar2.field_msgId);
        intent.putExtra("map_view_type", 1);
        intent.putExtra("kwebmap_slat", GS.kCw);
        intent.putExtra("kwebmap_lng", GS.kCx);
        intent.putExtra("kwebmap_scale", GS.bSz);
        intent.putExtra("kPoiName", GS.kFa);
        intent.putExtra("kisUsername", r.gT(trim));
        intent.putExtra("Kwebmap_locaion", str);
        au.HU();
        intent.putExtra("kimg_path", com.tencent.mm.model.c.Gb());
        intent.putExtra("map_talker_name", bdVar2.field_talker);
        intent.putExtra("view_type_key", 0);
        intent.putExtra("kwebmap_from_to", true);
        intent.putExtra("kPoi_url", GS.qyA);
        intent.putExtra("soso_street_view_url", ai.aG(bdVar2.field_reserved, ""));
        h.mEJ.h(12809, new Object[]{Integer.valueOf(2), ""});
        com.tencent.mm.bg.d.a(this.tKy.tTo, "location", ".ui.RedirectUI", intent, 2002, new 1(this));
    }
}
