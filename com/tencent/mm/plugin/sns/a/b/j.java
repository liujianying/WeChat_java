package com.tencent.mm.plugin.sns.a.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class j {
    public static void a(n nVar, boolean z, boolean z2) {
        int i = 2;
        bsu bAJ = nVar.bAJ();
        List list = bAJ.sqc.ruA;
        if (list != null && !list.isEmpty()) {
            if ((bAJ.sqc.ruz == 15 && nVar.xb(32)) || bAJ.sqc.ruz == 18) {
                int i2;
                list.get(0);
                if (nVar.xb(32) && bAJ.sqc.ruz == 15) {
                    bAJ.sqh.dyP = nVar.bAH().ntU;
                    bAJ.sqh.dyQ = bAJ.ksA;
                }
                d dVar = new d();
                dVar.r("20source_publishid", bAJ.sqh.dyQ + ",");
                dVar.r("21uxinfo", bAJ.sqh.dyP + ",");
                dVar.r("22clienttime", bi.VF() + ",");
                dVar.r("23souce_type", (bAJ.sqc.ruz == 15 ? 1 : 2) + ",");
                String str = "24scene";
                StringBuilder stringBuilder = new StringBuilder();
                if (z) {
                    i = 6;
                } else if (bAJ.sqc.ruz == 15) {
                    i = 1;
                }
                dVar.r(str, stringBuilder.append(i).append(",").toString());
                dVar.r("25scene_chatname", ",");
                dVar.r("26scene_username", bAJ.hbL + ",");
                dVar.r("27curr_publishid", bAJ.ksA + ",");
                dVar.r("28curr_msgid", ",");
                dVar.r("29curr_favid", "0,");
                String str2 = "30isdownload";
                stringBuilder = new StringBuilder();
                if (z2) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                dVar.r(str2, stringBuilder.append(i2).append(",").toString());
                dVar.r("31chatroom_membercount", "0,");
                p.a(bAJ.nNV, dVar);
                x.i("MicroMsg.SnsVideoStatistic", "report snsad_video_exposure: " + dVar.wF());
                h.mEJ.h(12989, new Object[]{dVar});
            }
        }
    }

    public static void a(b bVar, a aVar, n nVar) {
        bsu bAJ = nVar.bAJ();
        List list = bAJ.sqc.ruA;
        if (list != null && !list.isEmpty()) {
            if ((bAJ.sqc.ruz == 15 && nVar.xb(32)) || bAJ.sqc.ruz == 18) {
                list.get(0);
                if (nVar.xb(32) && bAJ.sqc.ruz == 15) {
                    bAJ.sqh.dyP = nVar.bAH().ntU;
                    bAJ.sqh.dyQ = bAJ.ksA;
                }
                d dVar = new d();
                dVar.r("20source_publishid", bAJ.sqh.dyQ + ",");
                dVar.r("21uxinfo", bAJ.sqh.dyP + ",");
                dVar.r("22clienttime", bi.VF() + ",");
                dVar.r("23video_statu", ",");
                dVar.r("24source_type", (bAJ.sqc.ruz == 15 ? 1 : 2) + ",");
                dVar.r("25scene", bVar.value + ",");
                dVar.r("26action_type", a.a(aVar) + ",");
                dVar.r("27scene_chatname", ",");
                dVar.r("28scene_username", bAJ.hbL + ",");
                dVar.r("29curr_publishid", bAJ.ksA + ",");
                dVar.r("30curr_msgid", "0,");
                dVar.r("31curr_favid", "0,");
                dVar.r("32elapsed_time", "0,");
                dVar.r("33load_time", "0,");
                dVar.r("34is_load_complete", "0,");
                dVar.r("35destination", "0,");
                dVar.r("36chatroom_membercount", "0,");
                p.a(bAJ.nNV, dVar);
                x.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + dVar.wF());
                ((c) g.l(c.class)).h(12990, new Object[]{dVar});
            }
        }
    }

    public static void a(a aVar, String str, String str2, int i, int i2, String str3, String str4, String str5, long j, int i3, int i4) {
        d dVar = new d();
        dVar.r("20source_publishid", str + ",");
        dVar.r("21uxinfo", str2 + ",");
        dVar.r("22clienttime", bi.VF() + ",");
        dVar.r("23video_statu", ",");
        dVar.r("24source_type", i + ",");
        dVar.r("25scene", i2 + ",");
        dVar.r("26action_type", a.a(aVar) + ",");
        dVar.r("27scene_chatname", str4 + ",");
        dVar.r("28scene_username", str3 + ",");
        dVar.r("29curr_publishid", str5 + ",");
        dVar.r("30curr_msgid", j + ",");
        dVar.r("31curr_favid", i3 + ",");
        dVar.r("32elapsed_time", "0,");
        dVar.r("33load_time", "0,");
        dVar.r("34is_load_complete", "0,");
        dVar.r("35destination", "0,");
        dVar.r("36chatroom_membercount", i4 + ",");
        f.a(str5, dVar);
        x.i("MicroMsg.SnsVideoStatistic", "report snsad_video_action: " + dVar.wF());
        h.mEJ.h(12990, new Object[]{dVar});
    }

    public static void a(d dVar, c cVar, e eVar, int i, n nVar) {
        bsu bAJ = nVar.bAJ();
        List list = bAJ.sqc.ruA;
        if (list != null && !list.isEmpty()) {
            if ((bAJ.sqc.ruz == 15 && nVar.xb(32)) || bAJ.sqc.ruz == 18) {
                list.get(0);
                if (nVar.xb(32) && bAJ.sqc.ruz == 15) {
                    bAJ.sqh.dyP = nVar.bAH().ntU;
                    bAJ.sqh.dyQ = bAJ.ksA;
                }
                d dVar2 = new d();
                dVar2.r("20source_publishid", bAJ.sqh.dyQ + ",");
                dVar2.r("21uxinfo", bAJ.sqh.dyP + ",");
                dVar2.r("22clienttime", bi.VF() + ",");
                dVar2.r("23video_statu", e.a(eVar) + ",");
                dVar2.r("24source_type", (bAJ.sqc.ruz == 15 ? 1 : 2) + ",");
                dVar2.r("25scene", dVar.value + ",");
                dVar2.r("26action_type", cVar.value + ",");
                dVar2.r("27scene_chatname", ",");
                dVar2.r("28scene_username", bAJ.hbL + ",");
                dVar2.r("29curr_publishid", bAJ.ksA + ",");
                dVar2.r("30curr_msgid", "0,");
                dVar2.r("31curr_favid", "0,");
                dVar2.r("32chatroom_membercount", "0,");
                dVar2.r("33chatroom_toMemberCount", i + ",");
                p.a(bAJ.nNV, dVar2);
                x.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + dVar2.wF());
                h.mEJ.h(12991, new Object[]{dVar2});
            }
        }
    }

    public static void a(c cVar, String str, String str2, int i, int i2, String str3, String str4, String str5, long j, int i3, int i4, int i5) {
        d dVar = new d();
        dVar.r("20source_publishid", str + ",");
        dVar.r("21uxinfo", str2 + ",");
        dVar.r("22clienttime", bi.VF() + ",");
        dVar.r("23video_statu", "3,");
        dVar.r("24source_type", i + ",");
        dVar.r("25scene", i2 + ",");
        dVar.r("26action_type", cVar.value + ",");
        dVar.r("27scene_chatname", str4 + ",");
        dVar.r("28scene_username", str3 + ",");
        dVar.r("29curr_publishid", str5 + ",");
        dVar.r("30curr_msgid", j + ",");
        dVar.r("31curr_favid", i3 + ",");
        dVar.r("32chatroom_membercount", i4 + ",");
        dVar.r("33chatroom_toMemberCount", i5 + ",");
        x.i("MicroMsg.SnsVideoStatistic", "report snsad_video_spread: " + dVar.wF());
        f.a(str5, dVar);
        h.mEJ.h(12991, new Object[]{dVar});
    }
}
