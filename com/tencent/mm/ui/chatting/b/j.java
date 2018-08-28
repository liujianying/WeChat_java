package com.tencent.mm.ui.chatting.b;

import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.ChattingFooterMoreBtnBar;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.ag;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.b.b.h;
import com.tencent.mm.ui.chatting.b.b.m;
import com.tencent.mm.ui.chatting.b.b.p;
import com.tencent.mm.ui.chatting.b.b.w;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.tools.o.b;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@a(cwo = h.class)
public class j extends a implements ah, h {
    public static at tOP = new at(5, "MicroMsg.ChattingMoreBtnBarHelper");
    private ab bTk;
    private o eMS;
    private k fUH;
    private boolean hasInit = false;
    private Animation nen;
    private boolean tGg;
    private boolean tKh = false;
    private ChattingFooterMoreBtnBar tOQ;
    private boolean tOR = true;

    public final void aT(bd bdVar) {
        boolean z;
        if (this.hasInit) {
            x.e("MicroMsg.ChattingMoreBtnBarHelper", "[init] hasInit!");
        } else {
            this.hasInit = true;
            if (this.tOQ == null) {
                ((ViewStub) this.bAG.findViewById(R.h.viewstub_chatting_more_btn)).inflate();
                this.tOQ = (ChattingFooterMoreBtnBar) this.bAG.findViewById(R.h.chatting_footer_more_btn_bar);
            }
            if (((w) this.bAG.O(w.class)).cvT()) {
                x.w("MicroMsg.ChattingMoreBtnBarHelper", "is in show search chat result");
                if (this.eMS != null) {
                    this.eMS.uBw = null;
                }
            } else {
                this.eMS = new o((byte) 0);
                this.eMS.uBw = new b() {
                    public final void pk(String str) {
                        x.v("MicroMsg.ChattingMoreBtnBarHelper", "on edit change");
                        w wVar = (w) j.this.bAG.O(w.class);
                        if (!bi.oW(str)) {
                            x.v("MicroMsg.ChattingMoreBtnBarHelper", "enter search mode");
                            j.this.tOQ.setVisibility(8);
                            wVar.cvM();
                            if (wVar.cvP() != null) {
                                wVar.cvP().pi(str);
                            }
                        } else if (wVar.cvT()) {
                            if (wVar.cvP() != null) {
                                wVar.cvP().pi("");
                            }
                            wVar.Fd(-1);
                        } else if (j.this.tKh) {
                            wVar.cvN();
                            j.this.tOQ.setVisibility(0);
                            j.this.tOQ.EO(((g) j.this.bAG.O(g.class)).boX());
                        } else {
                            wVar.cvN();
                            j.this.tOQ.setVisibility(8);
                        }
                    }

                    public final void WW() {
                        x.v("MicroMsg.ChattingMoreBtnBarHelper", "onQuitSearch");
                        g gVar = (g) j.this.bAG.O(g.class);
                        if (gVar.isInEditMode()) {
                            ((w) j.this.bAG.O(w.class)).cvN();
                            j.this.tOQ.setVisibility(0);
                            j.this.tOQ.EO(gVar.boX());
                        }
                    }

                    public final void WX() {
                        x.v("MicroMsg.ChattingMoreBtnBarHelper", "onEnterSearch");
                        com.tencent.mm.plugin.report.service.h.mEJ.a(219, 21, 1, true);
                        if (((g) j.this.bAG.O(g.class)).isInEditMode()) {
                            ((w) j.this.bAG.O(w.class)).cvM();
                            j.this.tOQ.setVisibility(8);
                        }
                    }

                    public final boolean pj(String str) {
                        return false;
                    }

                    public final void WY() {
                    }

                    public final void WZ() {
                    }
                };
            }
            this.tOQ.c(3, new 2(this));
            this.tOQ.c(2, new 3(this));
            this.tOQ.c(1, new 4(this));
            this.tOQ.c(0, new 5(this));
            this.tOQ.c(4, new 6(this));
            this.nen = AnimationUtils.loadAnimation(this.bAG.tTq.getContext(), R.a.push_up_in);
            ((g) this.bAG.O(g.class)).c(new 1(this));
            this.fUH = new k(this.bAG.tTq.getContext());
        }
        this.bTk = this.bAG.oLT;
        if (s.fq(this.bAG.getTalkerUserName()) || ((c) this.bAG.O(c.class)).cus()) {
            z = true;
        } else {
            z = false;
        }
        this.tGg = z;
        this.tOQ.ctt();
        this.bAG.tTq.getController().addSearchMenu(true, this.eMS);
        this.tOQ.startAnimation(this.nen);
        this.tOQ.setVisibility(0);
        this.tKh = true;
        ((w) this.bAG.O(w.class)).cvN();
        g gVar = (g) this.bAG.O(g.class);
        gVar.ctO();
        gVar.ctM();
        gVar.gt(bdVar.field_msgId);
        this.tOQ.EO(gVar.boX());
        ((com.tencent.mm.ui.chatting.b.b.k) this.bAG.O(com.tencent.mm.ui.chatting.b.b.k.class)).cuY();
        this.bAG.YC();
        cuR();
        ((m) this.bAG.O(m.class)).cvk();
        com.tencent.mm.plugin.report.service.h.mEJ.h(10811, new Object[]{Integer.valueOf(1)});
        if (this.bTk.ckW()) {
            com.tencent.mm.ui.chatting.c.a aVar = this.bAG;
            x.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d", new Object[]{Integer.valueOf(R.h.menu_search)});
            aVar.tTr.removeOptionMenu(r3);
        }
        ((p) this.bAG.O(p.class)).cvz();
    }

    public final void aU(bd bdVar) {
        if (bdVar == null) {
            x.w("MicroMsg.ChattingMoreBtnBarHelper", "perform search mode click msg item fail, msg is null");
            return;
        }
        g gVar = (g) this.bAG.O(g.class);
        if (gVar.gt(bdVar.field_msgId)) {
            this.tOQ.EO(gVar.boX());
            this.tOQ.setVisibility(0);
            this.eMS.czQ();
        }
    }

    private List<bd> cuP() {
        List<bd> linkedList = new LinkedList();
        for (Long longValue : ((g) this.bAG.O(g.class)).ctL()) {
            x.v("MicroMsg.ChattingMoreBtnBarHelper", "select msg id %d", new Object[]{Long.valueOf(longValue.longValue())});
            au.HU();
            linkedList.add(com.tencent.mm.model.c.FT().dW(r4));
        }
        Collections.sort(linkedList, new 7(this));
        return linkedList;
    }

    public final void cuQ() {
        this.bAG.tTq.getController().addSearchMenu(false, this.eMS);
        this.tOQ.setVisibility(8);
        ((g) this.bAG.O(g.class)).aMw();
        ((w) this.bAG.O(w.class)).cvN();
        this.tKh = false;
        cuR();
        ((com.tencent.mm.ui.chatting.b.b.k) this.bAG.O(com.tencent.mm.ui.chatting.b.b.k.class)).cuZ();
        ((m) this.bAG.O(m.class)).cvk();
        this.bAG.YC();
        com.tencent.mm.ui.chatting.k.cte();
    }

    private void cuR() {
        if (this.tKh) {
            this.bAG.showOptionMenu(false);
        } else {
            ((com.tencent.mm.ui.chatting.b.b.o) this.bAG.O(com.tencent.mm.ui.chatting.b.b.o.class)).cvp();
        }
        ((ag) this.bAG.O(ag.class)).cwm();
    }

    public final void a(ah.a aVar) {
    }

    public final boolean cuS() {
        return this.tKh;
    }

    public final void cuT() {
        if (this.eMS != null) {
            this.eMS.czQ();
            this.eMS.uBw = null;
        }
    }

    public final void cug() {
        cuQ();
    }

    public final void b(ah.a aVar) {
        cuQ();
    }

    public final boolean cuh() {
        return this.tOR;
    }
}
