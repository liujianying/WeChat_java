package com.tencent.mm.ui.chatting;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g$a;

public final class a {
    public static void a(a aVar, bd bdVar) {
        PString pString = new PString();
        PString pString2 = new PString();
        if (a(bdVar, pString, pString2)) {
            a(aVar, bdVar, pString.value, pString2.value);
        }
    }

    public static void a(a aVar, bd bdVar, String str, String str2) {
        String str3 = bdVar.field_talker;
        boolean endsWith = str3.endsWith("@chatroom");
        String GF = bdVar.field_isSend == 1 ? q.GF() : endsWith ? com.tencent.mm.model.bd.iB(bdVar.field_content) : str3;
        d dVar = new d();
        dVar.r("20source_publishid", str + ",");
        dVar.r("21uxinfo", str2 + ",");
        dVar.r("22clienttime", bi.VF() + ",");
        dVar.r("23video_statu", ",");
        dVar.r("24source_type", (bdVar.getType() == 62 ? 1 : 2) + ",");
        dVar.r("25scene", (endsWith ? 4 : 3) + ",");
        dVar.r("26action_type", a.a(aVar) + ",");
        dVar.r("27scene_chatname", str3 + ",");
        dVar.r("28scene_username", GF + ",");
        dVar.r("29curr_publishid", ",");
        dVar.r("30curr_msgid", bdVar.field_msgSvrId + ",");
        dVar.r("31curr_favid", "0,");
        dVar.r("32elapsed_time", "0,");
        dVar.r("33load_time", "0,");
        dVar.r("34is_load_complete", "0,");
        dVar.r("35destination", "0,");
        dVar.r("36chatroom_membercount", (endsWith ? m.gK(str3) : 0) + ",");
        x.i("MicroMsg.AdVideoStatistic", "report snsad_video_action: " + dVar.wF());
        ((c) g.l(c.class)).h(12990, new Object[]{dVar});
    }

    public static void a(c cVar, d dVar, bd bdVar, int i) {
        PString pString = new PString();
        PString pString2 = new PString();
        if (a(bdVar, pString, pString2)) {
            String str = pString.value;
            String str2 = pString2.value;
            String str3 = bdVar.field_talker;
            boolean endsWith = str3.endsWith("@chatroom");
            String GF = bdVar.field_isSend == 1 ? q.GF() : endsWith ? com.tencent.mm.model.bd.iB(bdVar.field_content) : str3;
            d dVar2 = new d();
            dVar2.r("20source_publishid", str + ",");
            dVar2.r("21uxinfo", str2 + ",");
            dVar2.r("22clienttime", bi.VF() + ",");
            dVar2.r("23video_statu", d.a(dVar) + ",");
            dVar2.r("24source_type", (bdVar.getType() == 62 ? 1 : 2) + ",");
            dVar2.r("25scene", (endsWith ? 4 : 3) + ",");
            dVar2.r("26action_type", c.a(cVar) + ",");
            dVar2.r("27scene_chatname", str3 + ",");
            dVar2.r("28scene_username", GF + ",");
            dVar2.r("29curr_publishid", ",");
            dVar2.r("30curr_msgid", bdVar.field_msgSvrId + ",");
            dVar2.r("31curr_favid", "0,");
            dVar2.r("32chatroom_membercount", (endsWith ? m.gK(str3) : 0) + ",");
            dVar2.r("33chatroom_toMemberCount", i + ",");
            x.i("MicroMsg.AdVideoStatistic", "report snsad_video_spread: " + dVar2.wF());
            h.mEJ.h(12991, new Object[]{dVar2});
        }
    }

    public static boolean a(bd bdVar, PString pString, PString pString2) {
        if (bdVar.getType() == 62) {
            r nW = t.nW(bdVar.field_imgPath);
            if (nW == null) {
                return false;
            }
            bri bri = nW.enV;
            if (bri == null || bi.oW(bri.dyP)) {
                return false;
            }
            pString.value = bri.dyQ;
            pString2.value = bri.dyP;
            return true;
        } else if (bdVar.getType() != 49) {
            return false;
        } else {
            boolean fq = s.fq(bdVar.field_talker);
            String str = bdVar.field_content;
            if (fq && bdVar.field_content != null && bdVar.field_isSend == 0) {
                str = com.tencent.mm.model.bd.iC(bdVar.field_content);
            }
            g$a gp = g$a.gp(str);
            if (gp == null || gp.type != 4 || bi.oW(gp.dyJ)) {
                return false;
            }
            pString.value = gp.dyQ;
            pString2.value = gp.dyP;
            return true;
        }
    }
}
