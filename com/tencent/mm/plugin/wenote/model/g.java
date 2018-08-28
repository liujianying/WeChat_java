package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.c;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.plugin.wenote.model.a.t;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import java.util.Iterator;

public final class g extends d implements e {
    private static HashMap<com.tencent.mm.plugin.fav.a.g, l> qnX = new HashMap();
    private wn bOW = new wn();
    public boolean bUY = true;
    public long bVe = -1;
    private com.tencent.mm.plugin.fav.a.g jaq;
    public String qnV;
    public String qnW = "";
    private int qnY = 0;
    private int qnZ = 0;
    public String qoa;
    public int qob = 0;
    public long qoc = 0;
    public String qod;
    public String qoe;

    public g() {
        this.qnG.clear();
        this.qnF = null;
        qnL = "";
        this.qnN = false;
        c.aMi();
        au.DF().a(426, this);
    }

    public final void a(long j, Context context, Boolean bool, int i, int i2, wn wnVar) {
        this.bVe = j;
        this.bUY = bool.booleanValue();
        this.qnY = i;
        this.qnZ = i2;
        this.bOW = wnVar;
        this.jaq = f.eo(this.bVe);
        if (this.jaq != null) {
            if (this.qoc <= 0) {
                this.qoc = this.jaq.field_updateTime;
            }
            this.qnO = this.jaq.field_favProto;
            this.qnF = this.jaq;
        }
        if (this.qob == 0 && this.qnO.rBG != null) {
            this.qob = this.qnO.rBG.bJt;
        }
        R(context, 2);
        au.Em().H(new 2(this));
    }

    public final void R(Context context, int i) {
        Intent intent = new Intent();
        intent.putExtra("note_open_from_scene", i);
        if (i == 4) {
            intent.putExtra("fav_note_thumbpath", this.qod);
            intent.putExtra("fav_note_link_sns_xml", this.qoe);
        }
        intent.putExtra("edit_status", this.qnN);
        intent.putExtra("show_share", this.bUY);
        intent.putExtra("note_fav_localid", this.bVe);
        intent.putExtra("note_link_sns_localid", this.qnV);
        intent.putExtra("fav_note_xml", this.qnW);
        intent.putExtra("fav_note_scroll_to_position", this.qnY);
        intent.putExtra("fav_note_scroll_to_offset", this.qnZ);
        intent.putExtra("fav_note_link_source_info", this.qoa);
        intent.putExtra("note_fav_post_scene", this.qob);
        intent.putExtra("key_detail_fav_scene", this.bOW.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.bOW.iVT);
        intent.putExtra("key_detail_fav_index", this.bOW.index);
        intent.putExtra("key_detail_fav_query", this.bOW.bWm);
        intent.putExtra("key_detail_fav_sessionid", this.bOW.bJK);
        intent.putExtra("key_detail_fav_tags", this.bOW.iVW);
        d.b(context, "wenote", ".ui.nativenote.NoteEditorUI", intent);
    }

    public final String b(vx vxVar) {
        return f.o(vxVar);
    }

    public final String c(vx vxVar) {
        return f.c(vxVar);
    }

    public final void n(vx vxVar) {
        l lVar = this.qnE;
        fz fzVar = new fz();
        fzVar.bOL.type = 28;
        fzVar.bOL.bJA = lVar.msw.field_localId;
        fzVar.bOL.bON = vxVar;
        fzVar.bOL.path = "";
        fzVar.bOL.bOS = 18;
        a.sFg.m(fzVar);
    }

    public final void a(vx vxVar, String str) {
        l lVar = this.qnE;
        fz fzVar = new fz();
        fzVar.bOL.type = 28;
        fzVar.bOL.bJA = lVar.msw.field_localId;
        fzVar.bOL.bON = vxVar;
        fzVar.bOL.path = str;
        fzVar.bOL.bOS = 18;
        a.sFg.m(fzVar);
    }

    public final void aX(Context context, String str) {
        t tVar = (t) this.qnI.get(str);
        Intent intent = new Intent();
        intent.putExtra("fav_open_from_wnnote", true);
        intent.putExtra("fav_note_xml", this.qnW);
        if (tVar != null) {
            intent.putExtra("key_detail_data_id", Sg(str));
        }
        intent.putExtra("key_detail_can_delete", false);
        intent.putExtra("key_detail_info_id", this.bVe);
        intent.putExtra("key_detail_fav_scene", this.bOW.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.bOW.iVT);
        intent.putExtra("key_detail_fav_index", this.bOW.index);
        b.a(context, ".ui.detail.FavoriteFileDetailUI", intent, 1);
    }

    public final void aZ(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("fav_open_from_wnnote", true);
        intent.putExtra("fav_note_xml", this.qnW);
        if (this.qnI.get(str) != null) {
            intent.putExtra("key_detail_data_id", ((n) this.qnI.get(str)).jdM);
        }
        intent.putExtra("key_detail_info_id", this.bVe);
        intent.putExtra("key_detail_fav_scene", this.bOW.scene);
        intent.putExtra("key_detail_fav_sub_scene", this.bOW.iVT);
        intent.putExtra("key_detail_fav_index", this.bOW.index);
        b.a(context, ".ui.FavImgGalleryUI", intent, 1);
    }

    public final void aY(Context context, String str) {
        String str2 = "";
        r rVar = (r) this.qnI.get(str);
        if (rVar == null) {
            h.bA(context, ad.getContext().getString(R.l.favorite_record_loc_error));
            return;
        }
        Intent intent = new Intent();
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
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kFavInfoLocalId", this.bVe);
        intent.putExtra("kFavCanDel", false);
        intent.putExtra("kFavCanRemark", false);
        d.b(context, "location", ".ui.RedirectUI", intent, 1);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (lVar.getType() == 426) {
            fz fzVar = new fz();
            fzVar.bOL.bKq = lVar;
            fzVar.bOL.type = 31;
            a.sFg.m(fzVar);
            if (!bi.oW(fzVar.bOM.path) && i2 == -435) {
                x.e("MicroMsg.WNNoteFavProcess", "wenote conflict when commit");
            }
            au.DF().b(426, this);
        }
    }

    public final void Sd(String str) {
        this.qnW = str;
    }

    public final String bZc() {
        return this.qnW;
    }

    private String Sg(String str) {
        com.tencent.mm.plugin.fav.a.g eo = f.eo(this.bVe);
        if (eo == null) {
            return ((n) this.qnI.get(str)).jdM;
        }
        Iterator it = eo.field_favProto.rBI.iterator();
        while (it.hasNext()) {
            vx vxVar = (vx) it.next();
            if (!bi.oW(vxVar.rAq) && vxVar.rAq.equals(str)) {
                return vxVar.jdM;
            }
        }
        return ((n) this.qnI.get(str)).jdM;
    }
}
