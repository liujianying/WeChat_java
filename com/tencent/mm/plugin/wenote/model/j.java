package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.vz;
import com.tencent.mm.protocal.c.we;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;

public final class j extends d {
    private static HashMap<String, l> qox = new HashMap();
    private wn bOW = new wn();
    private boolean bUY;
    private String bVJ;
    private c msX = null;
    private int qnY = 0;
    private int qnZ = 0;
    private String qoa;
    private Long qov;
    private boolean qow = false;

    static /* synthetic */ void a(j jVar) {
        if (qox.containsKey(jVar.bVJ)) {
            jVar.qnE = (l) qox.get(jVar.bVJ);
            return;
        }
        jVar.qnE = new l();
        jVar.qnE.bJC = jVar.qov.longValue();
        jVar.qnE.qoX = jVar.bVJ;
        if (jVar.msX != null && jVar.msX.dzs != null) {
            if (jVar.msX.qYa != null) {
                jVar.qnE.qoZ = jVar.msX.qYa.rBA;
                jVar.qnE.qoY = jVar.msX.qYa.rBz;
                jVar.qnE.qpa = jVar.msX.qYb;
            }
            jVar.qnE.msv = jVar.msX.dzs;
            jVar.qnE.bjS = 0;
            qox.put(jVar.bVJ, jVar.qnE);
        }
    }

    public j() {
        this.qnG.clear();
        com.tencent.mm.plugin.fav.ui.c.aMi();
    }

    public final void a(String str, Long l, boolean z, Context context, int i, int i2, wn wnVar) {
        this.bVJ = str;
        this.qov = l;
        this.bUY = z;
        this.qnY = i;
        this.qnZ = i2;
        this.bOW = wnVar;
        mw mwVar = new mw();
        mwVar.bXL.type = 0;
        mwVar.bXL.bXN = str;
        a.sFg.m(mwVar);
        this.msX = mwVar.bXM.bXV;
        if (!(this.msX == null || this.msX.dzs == null || this.msX.dzs.size() <= 1)) {
            mw mwVar2 = new mw();
            mwVar2.bXL.type = 9;
            mwVar2.bXL.bOz = (vx) this.msX.dzs.get(0);
            mwVar2.bXL.bJC = this.qov.longValue();
            a.sFg.m(mwVar2);
            this.qow = mwVar2.bXM.bXX;
        }
        if (this.msX == null || this.msX.qYa == null) {
            this.qoa = null;
        } else {
            this.qoa = this.msX.qYa.rBz + ";" + this.msX.qYa.rBA + ";" + this.msX.qYb;
        }
        Intent intent = new Intent();
        intent.putExtra("note_open_from_scene", 1);
        intent.putExtra("edit_status", this.qnN);
        intent.putExtra("note_msgid", this.qov);
        intent.putExtra("record_show_share", this.bUY);
        intent.putExtra("fav_note_xml", this.bVJ);
        intent.putExtra("fav_note_out_of_date", this.qow);
        intent.putExtra("fav_note_scroll_to_position", this.qnY);
        intent.putExtra("fav_note_scroll_to_offset", this.qnZ);
        intent.putExtra("fav_note_scroll_to_offset", this.qnZ);
        if (!bi.oW(this.qoa)) {
            intent.putExtra("fav_note_link_source_info", this.qoa);
        }
        intent.putExtra("key_detail_fav_scene", this.bOW.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.bOW.iVT);
        intent.putExtra("key_detail_fav_index", this.bOW.index);
        d.b(context, "wenote", ".ui.nativenote.NoteEditorUI", intent);
        au.Em().H(new 1(this));
    }

    public final String b(vx vxVar) {
        mw mwVar = new mw();
        mwVar.bXL.type = 1;
        mwVar.bXL.bOz = vxVar;
        mwVar.bXL.bJC = this.qov.longValue();
        a.sFg.m(mwVar);
        return mwVar.bXM.bXW;
    }

    public final String c(vx vxVar) {
        mw mwVar = new mw();
        mwVar.bXL.type = 1;
        mwVar.bXL.bOz = vxVar;
        mwVar.bXL.bJC = this.qov.longValue();
        a.sFg.m(mwVar);
        return mwVar.bXM.bOX;
    }

    public final void n(vx vxVar) {
        mw mwVar = new mw();
        mwVar.bXL.type = 8;
        mwVar.bXL.bOz = vxVar;
        mwVar.bXL.bJC = this.qov.longValue();
        mwVar.bXL.bOX = "";
        a.sFg.m(mwVar);
    }

    public final void a(vx vxVar, String str) {
        mw mwVar = new mw();
        mwVar.bXL.type = 8;
        mwVar.bXL.bOz = vxVar;
        mwVar.bXL.bJC = this.qov.longValue();
        mwVar.bXL.bOX = str;
        a.sFg.m(mwVar);
    }

    public final void aX(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("message_id", this.qov);
        intent.putExtra("record_xml", this.bVJ);
        intent.putExtra("record_data_id", ((n) this.qnI.get(str)).jdM);
        d.b(ad.getContext(), "record", ".ui.RecordMsgFileUI", intent);
    }

    public final void aZ(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("message_id", this.qov);
        intent.putExtra("record_data_id", ((n) this.qnI.get(str)).jdM);
        intent.putExtra("record_xml", this.bVJ);
        d.b(ad.getContext(), "record", ".ui.RecordMsgImageUI", intent);
    }

    public final void aY(Context context, String str) {
        vz vzVar;
        String str2 = null;
        vx vxVar = ((n) this.qnI.get(str)).qpb;
        if (vxVar.rAi != null) {
            we weVar = vxVar.rAi.rAL;
            vzVar = vxVar.rAi.rAJ;
        } else {
            vzVar = null;
        }
        if (vzVar != null) {
            if (bi.oW(vzVar.rBh)) {
                str2 = r.gT(vzVar.bSS);
            } else {
                str2 = r.gT(vzVar.rBh);
            }
        }
        com.tencent.mm.plugin.wenote.model.a.r rVar = (com.tencent.mm.plugin.wenote.model.a.r) this.qnI.get(str);
        if (rVar == null) {
            h.bA(ad.getContext(), ad.getContext().getString(R.l.favorite_record_loc_error));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kwebmap_slat", rVar.lat);
        intent.putExtra("kwebmap_lng", rVar.lng);
        intent.putExtra("kPoiName", rVar.kFa);
        intent.putExtra("Kwebmap_locaion", rVar.dRH);
        if (rVar.qpq >= 0.0d) {
            intent.putExtra("kwebmap_scale", rVar.qpq);
        }
        intent.putExtra("kisUsername", str2);
        intent.putExtra("kwebmap_from_to", true);
        intent.putExtra("KFavLocSigleView", true);
        intent.putExtra("kFavCanDel", false);
        intent.putExtra("kFavCanRemark", false);
        d.b(ad.getContext(), "location", ".ui.RedirectUI", intent);
    }
}
