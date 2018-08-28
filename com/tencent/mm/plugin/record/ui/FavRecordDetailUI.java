package com.tencent.mm.plugin.record.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.record.b.b;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import java.util.List;

public class FavRecordDetailUI extends RecordMsgBaseUI {
    private boolean bUY = true;
    private a iXr = new 1(this);
    private g jaq;
    private long msC = -1;
    private boolean msD = true;
    private boolean msE = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void bqA() {
        this.msC = getIntent().getLongExtra("key_detail_info_id", -1);
        this.bUY = getIntent().getBooleanExtra("show_share", true);
        this.jaq = b.eo(this.msC);
        if (this.jaq == null) {
            finish();
            return;
        }
        F(this.jaq);
        b bVar = new b();
        bVar.msw = this.jaq;
        bVar.msv = this.jaq.field_favProto.rBI;
        List<vx> list = bVar.msv;
        if (list == null) {
            this.msD = false;
        } else if (list.size() == 0) {
            this.msD = false;
        } else {
            for (vx vxVar : list) {
                if (vxVar.rAw != 0) {
                    this.msD = false;
                    break;
                }
            }
            this.msD = true;
        }
        super.bqA();
        this.msU.a(bVar);
        List list2 = bVar.msv;
        if (list2 != null) {
            e.post(new 4(this, list2), "calc_fav_record_info");
        }
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().c(this.iXr);
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().a(((d) this.msU).msy);
    }

    protected final h bqB() {
        return new d(this, new c(this));
    }

    protected void onResume() {
        super.onResume();
        b bVar = (b) ((d) this.msU).msQ;
        if (bVar.msw != null) {
            g eo = b.eo(bVar.msw.field_localId);
            if (eo != null && eo.field_favProto != null) {
                Object obj;
                LinkedList linkedList = eo.field_favProto.rBI;
                for (vx contains : bVar.msv) {
                    if (!linkedList.contains(contains)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    bVar = new b();
                    bVar.msw = eo;
                    bVar.msv = eo.field_favProto.rBI;
                    this.msU.a(bVar);
                }
            }
        }
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().d(this.iXr);
        if (this.msU != null) {
            ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavCdnStorage().b(((d) this.msU).msy);
        }
        this.msE = true;
        super.onDestroy();
    }

    protected final String bqC() {
        if (14 == this.jaq.field_type && !bi.oW(this.jaq.field_favProto.title)) {
            return this.jaq.field_favProto.title;
        }
        wr wrVar = this.jaq.field_favProto.rBG;
        if (wrVar == null || bi.oW(wrVar.rBh)) {
            x.v("MicroMsg.FavRecordDetailUI", "display name, from item info user[%s]", new Object[]{this.jaq.field_fromUser});
            return h.gU(this.jaq.field_fromUser);
        }
        String gT = r.gT(wrVar.rBh);
        String gU;
        if (q.GF().equals(wrVar.bSS)) {
            gU = h.gU(wrVar.toUser);
            if (!bi.aG(gU, "").equals(wrVar.toUser)) {
                gT = gT + " - " + gU;
            }
        } else {
            gU = h.gU(wrVar.bSS);
            if (!bi.aG(gU, "").equals(wrVar.bSS)) {
                gT = gT + " - " + gU;
            }
        }
        x.v("MicroMsg.FavRecordDetailUI", "display name, source from[%s] to[%s]", new Object[]{wrVar.bSS, wrVar.toUser});
        return gT;
    }

    protected final String bqD() {
        LinkedList linkedList = this.jaq.field_favProto.rBI;
        if (linkedList.size() > 0) {
            return ((vx) linkedList.getFirst()).rAm;
        }
        return null;
    }

    protected final String bqE() {
        LinkedList linkedList = this.jaq.field_favProto.rBI;
        if (linkedList.size() > 0) {
            return ((vx) linkedList.getLast()).rAm;
        }
        return null;
    }

    protected final void bqF() {
        if (this.bUY) {
            addIconOptionMenu(0, R.l.top_item_desc_more, R.g.mm_title_btn_menu, new 2(this));
        }
    }

    protected final void c(int i, int i2, Intent intent) {
        if (4097 == i && -1 == i2) {
            fz fzVar = new fz();
            fzVar.bOL.type = 32;
            fzVar.bOL.bJA = this.msC;
            com.tencent.mm.sdk.b.a.sFg.m(fzVar);
            if (fzVar.bOM.bPd) {
                com.tencent.mm.ui.base.h.bA(this.mController.tml, getString(R.l.Fav_NotDownload_CannotForward));
                return;
            }
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            p a = com.tencent.mm.ui.base.h.a(this.mController.tml, getString(R.l.favorite_forward_tips), false, null);
            fz fzVar2 = new fz();
            fzVar2.bOL.type = 13;
            fzVar2.bOL.context = this.mController.tml;
            fzVar2.bOL.toUser = stringExtra;
            fzVar2.bOL.bOR = stringExtra2;
            fzVar2.bOL.bJA = this.msC;
            fzVar2.bOL.bOQ = new 3(this, a);
            com.tencent.mm.sdk.b.a.sFg.m(fzVar2);
        }
    }
}
