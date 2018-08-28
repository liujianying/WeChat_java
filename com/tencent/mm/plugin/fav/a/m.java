package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class m {
    public static void w(g gVar) {
        if (gVar.field_favProto.rBI != null && !gVar.field_favProto.rBI.isEmpty()) {
            vx vxVar = (vx) gVar.field_favProto.rBI.getFirst();
            wa waVar = vxVar.rAo;
            if (waVar != null) {
                d dVar = new d();
                dVar.r("20source_publishid", waVar.dyQ + ",");
                dVar.r("21uxinfo", waVar.dyP + ",");
                dVar.r("22clienttime", bi.VF() + ",");
                dVar.r("23source_type", (gVar.field_type == 16 ? 1 : 2) + ",");
                dVar.r("24scene", "5,");
                dVar.r("25scene_chatname", ",");
                dVar.r("26scene_username", gVar.field_fromUser + ",");
                dVar.r("27curr_publishid", ",");
                dVar.r("28curr_msgid", "0,");
                dVar.r("29curr_favid", gVar.field_id + ",");
                dVar.r("30isdownload", "0,");
                dVar.r("31chatroom_membercount", "0,");
                ((i) g.l(i.class)).b(vxVar.bZN, dVar);
                x.i("MicroMsg.FavVideoStatistic", "report snsad_video_exposure: " + dVar.wF());
                h.mEJ.h(12989, new Object[]{dVar});
            }
        }
    }

    public static void a(a aVar, g gVar) {
        if (gVar.field_favProto.rBI != null && !gVar.field_favProto.rBI.isEmpty()) {
            wa waVar = ((vx) gVar.field_favProto.rBI.getFirst()).rAo;
            if (waVar != null) {
                d dVar = new d();
                dVar.r("20source_publishid", waVar.dyQ + ",");
                dVar.r("21uxinfo", waVar.dyP + ",");
                dVar.r("22clienttime", bi.VF() + ",");
                dVar.r("23video_statu", ",");
                dVar.r("24source_type", (gVar.field_type == 16 ? 1 : 2) + ",");
                dVar.r("25scene", "5,");
                dVar.r("26action_type", a.a(aVar) + ",");
                dVar.r("27scene_chatname", ",");
                dVar.r("28scene_username", gVar.field_fromUser + ",");
                dVar.r("29curr_publishid", ",");
                dVar.r("30curr_msgid", "0,");
                dVar.r("31curr_favid", gVar.field_id + ",");
                dVar.r("32elapsed_time", "0,");
                dVar.r("33load_time", "0,");
                dVar.r("34is_load_complete", "0,");
                dVar.r("35destination", "0,");
                dVar.r("36chatroom_membercount", "0,");
                x.i("MicroMsg.FavVideoStatistic", "report snsad_video_action: " + dVar.wF());
                ((c) g.l(c.class)).h(12990, dVar);
            }
        }
    }

    public static void a(c cVar, g gVar, d dVar, int i) {
        if (gVar.field_favProto.rBI != null && !gVar.field_favProto.rBI.isEmpty()) {
            wa waVar = ((vx) gVar.field_favProto.rBI.getFirst()).rAo;
            if (waVar != null) {
                d dVar2 = new d();
                dVar2.r("20source_publishid", waVar.dyQ + ",");
                dVar2.r("21uxinfo", waVar.dyP + ",");
                dVar2.r("22clienttime", bi.VF() + ",");
                dVar2.r("23video_statu", d.a(dVar) + ",");
                dVar2.r("24source_type", (gVar.field_type == 16 ? 1 : 2) + ",");
                dVar2.r("25scene", "5,");
                dVar2.r("26action_type", c.a(cVar) + ",");
                dVar2.r("27scene_chatname", ",");
                dVar2.r("28scene_username", gVar.field_fromUser + ",");
                dVar2.r("29curr_publishid", ",");
                dVar2.r("30curr_msgid", "0,");
                dVar2.r("31curr_favid", gVar.field_id + ",");
                dVar2.r("32chatroom_membercount", "0,");
                dVar2.r("33chatroom_toMemberCount", i + ",");
                x.i("MicroMsg.FavVideoStatistic", "report snsad_video_spread: " + dVar2.wF());
                h.mEJ.h(12991, new Object[]{dVar2});
            }
        }
    }
}
