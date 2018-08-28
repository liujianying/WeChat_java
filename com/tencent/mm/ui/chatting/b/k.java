package com.tencent.mm.ui.chatting.b;

import android.text.TextUtils;
import android.widget.AbsListView;
import com.tencent.mm.ac.f;
import com.tencent.mm.booter.z;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.c;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.ag;
import com.tencent.mm.ui.chatting.b.b.i;
import com.tencent.mm.ui.chatting.b.b.p;
import java.util.HashSet;

@a(cwo = i.class)
public class k extends a implements i {
    private static String tPh = "100134";
    private long hej = 0;
    private boolean tOB = false;
    private HashSet<Long> tPc = new HashSet();
    private HashSet<Long> tPd = new HashSet();
    private HashSet<Long> tPe = new HashSet();
    private int tPf = 0;
    private boolean tPg = false;
    private long tPi = 0;
    private boolean tPj = false;
    private String tPk = null;
    private long tPl = 0;
    private int tPm = 0;

    public final void aV(final bd bdVar) {
        if (!this.tPc.contains(Long.valueOf(bdVar.field_msgSvrId))) {
            this.tPc.add(Long.valueOf(bdVar.field_msgSvrId));
            e.post(new Runnable() {
                final /* synthetic */ boolean tPn = false;

                public final void run() {
                    ((com.tencent.mm.plugin.sns.b.i) g.l(com.tencent.mm.plugin.sns.b.i.class)).Z(bdVar);
                    bd bdVar = bdVar;
                    boolean z = this.tPn;
                    PString pString = new PString();
                    PString pString2 = new PString();
                    if (com.tencent.mm.ui.chatting.a.a(bdVar, pString, pString2)) {
                        String str = pString.value;
                        String str2 = pString2.value;
                        String str3 = bdVar.field_talker;
                        boolean endsWith = str3.endsWith("@chatroom");
                        String GF = bdVar.field_isSend == 1 ? q.GF() : endsWith ? com.tencent.mm.model.bd.iB(bdVar.field_content) : str3;
                        d dVar = new d();
                        dVar.r("20source_publishid", str + ",");
                        dVar.r("21uxinfo", str2 + ",");
                        dVar.r("22clienttime", bi.VF() + ",");
                        dVar.r("23source_type", (bdVar.getType() == 62 ? 1 : 2) + ",");
                        dVar.r("24scene", (endsWith ? 4 : 3) + ",");
                        dVar.r("25scene_chatname", str3 + ",");
                        dVar.r("26scene_username", GF + ",");
                        dVar.r("27curr_publishid", ",");
                        dVar.r("28curr_msgid", bdVar.field_msgSvrId + ",");
                        dVar.r("29curr_favid", "0,");
                        dVar.r("30isdownload", (z ? 1 : 0) + ",");
                        dVar.r("31chatroom_membercount", (endsWith ? m.gK(str3) : 0) + ",");
                        ((com.tencent.mm.plugin.sns.b.i) g.l(com.tencent.mm.plugin.sns.b.i.class)).b(((com.tencent.mm.plugin.sns.b.i) g.l(com.tencent.mm.plugin.sns.b.i.class)).C(bdVar), dVar);
                        x.i("MicroMsg.AdVideoStatistic", "report snsad_video_exposure: " + dVar.wF());
                        h.mEJ.h(12989, new Object[]{dVar});
                    }
                }
            }, "ChattingUI.adVideoExposeReport");
        }
    }

    public final void aW(bd bdVar) {
        if (!this.tPd.contains(Long.valueOf(bdVar.field_msgSvrId))) {
            this.tPd.add(Long.valueOf(bdVar.field_msgSvrId));
            e.post(new 2(this, bdVar), "ChattingUI.expExposeReport");
        }
    }

    public final void aX(bd bdVar) {
        if (!this.tPg) {
            this.tPg = true;
            c fJ = com.tencent.mm.model.c.c.Jx().fJ(tPh);
            if (fJ.isValid()) {
                this.tPf = ai.getInt((String) fJ.ckq().get("needUploadData"), 0);
            }
        }
        if (this.tPf != 0 && !this.tPe.contains(Long.valueOf(bdVar.field_msgSvrId))) {
            e.post(new 3(this, bdVar), "ChattingUI.appExposeReport");
        }
    }

    private void cuV() {
        int i = 0;
        if (this.tPj) {
            long currentTimeMillis = System.currentTimeMillis() - this.tPi;
            this.tPi = 0;
            this.tPj = false;
            h hVar = h.mEJ;
            long[] jArr = new long[]{0, 200, 400, 600, 800, 1000, 1500, 2000};
            while (i < 8) {
                if (currentTimeMillis < jArr[i]) {
                    break;
                } else if (i == 7) {
                    i = 8;
                    break;
                } else {
                    i++;
                }
            }
            i = -1;
            hVar.a(109, (long) i, 1, true);
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            com.tencent.mm.bv.d.cov().dh(ChattingUI.class.getName() + ".Listview", 4);
        }
    }

    public final void cpF() {
        if (bi.oW(this.bAG.getTalkerUserName())) {
            h.mEJ.a(110, 0, 1, true);
        }
    }

    public final void cpG() {
        this.tPi = System.currentTimeMillis();
        this.tPj = true;
        if (!(this.bAG.oLT == null || this.bAG.getTalkerUserName() == null)) {
            int i;
            int i2;
            int i3;
            int i4;
            b.ehL.cE(this.bAG.getTalkerUserName());
            if (!q.GF().equals(this.bAG.getTalkerUserName())) {
                ar arVar = new ar();
                arVar.bIf.bIg = true;
                com.tencent.mm.sdk.b.a.sFg.m(arVar);
            }
            boolean BD = ((ag) this.bAG.O(ag.class)).BD();
            if ("notification_messages".equals(this.bAG.getTalkerUserName())) {
                i = 1;
                i2 = 0;
                i3 = 8;
            } else {
                boolean i42;
                if (s.hf(this.bAG.getTalkerUserName())) {
                    com.tencent.mm.ui.chatting.b.b.c cVar = (com.tencent.mm.ui.chatting.b.b.c) this.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class);
                    if (cVar.cur()) {
                        if (BD) {
                            i42 = 0;
                        } else {
                            i42 = true;
                        }
                        if (cVar.cus()) {
                            i2 = cVar.cup().Nn().size();
                            i3 = 5;
                            i = i42;
                        } else {
                            i = i42;
                            i2 = 0;
                            i3 = 4;
                        }
                    } else if (f.kL(this.bAG.getTalkerUserName())) {
                        i = BD ? 0 : 1;
                        i2 = 0;
                        i3 = 3;
                    } else if (f.kM(this.bAG.getTalkerUserName())) {
                        i = 1;
                        i2 = 0;
                        i3 = 0;
                    } else if (f.kI(this.bAG.getTalkerUserName())) {
                        i42 = true;
                        i = 0;
                    } else {
                        i42 = true;
                        i = 0;
                    }
                } else if (s.fq(this.bAG.getTalkerUserName())) {
                    i42 = m.gK(this.bAG.getTalkerUserName());
                    i = BD ? 0 : 1;
                    i2 = i42;
                    i3 = 2;
                } else if (BD) {
                    i = 0;
                    i42 = true;
                } else {
                    i = 1;
                    i42 = true;
                }
                i2 = 0;
                boolean i32 = i42;
            }
            if (this.bAG.cwq()) {
                i32 = 0;
            } else {
                i42 = i32;
                for (String equals : s.dAV) {
                    if (equals.equals(this.bAG.getTalkerUserName())) {
                        i42 = 0;
                    }
                }
                i32 = i42;
            }
            if (i32 != 0) {
                au.HU();
                com.tencent.mm.storage.ai Yq = com.tencent.mm.model.c.FW().Yq(this.bAG.getTalkerUserName());
                i42 = Yq == null ? 0 : Yq.field_unReadCount;
                z zVar = z.cXH;
                String talkerUserName = this.bAG.getTalkerUserName();
                if (zVar.cXR == null) {
                    zVar.cXR = q.GF();
                }
                if (!zVar.cXR.equals(talkerUserName)) {
                    if (zVar.cXL != null) {
                        x.i("MicroMsg.StayTimeReport", "enterChattingUI, not close:%s", new Object[]{zVar.cXL.cXY});
                        zVar.eG(zVar.cXL.cXY);
                    }
                    if (zVar.cXI.Di(6) == 0) {
                        zVar.cXI.setLong(4, ai.VE());
                    }
                    com.tencent.mm.sdk.b.a.sFg.a(zVar.cXJ);
                    com.tencent.mm.sdk.b.a.sFg.a(zVar.cXK);
                    zVar.cXL = new z.a(zVar);
                    zVar.cXL.cYd = zVar.cXM;
                    zVar.cXM = 0;
                    zVar.cXL.cXY = talkerUserName;
                    zVar.cXP = ai.VG();
                    zVar.cXL.type = i32;
                    zVar.cXL.cXZ = i;
                    zVar.cXL.bGz = i42;
                    zVar.cXL.cYa = i2;
                    zVar.cXL.cYb = ai.VE();
                    x.i("MicroMsg.StayTimeReport", "enter chattingUI: chatUser:%s----type:%d, notifyOpen:%d, unreadCount:%d, membercount:%d", new Object[]{talkerUserName, Integer.valueOf(i32), Integer.valueOf(i), Integer.valueOf(i42), Integer.valueOf(i2)});
                }
            }
        }
        this.tOB = true;
        xP();
    }

    public final void cpH() {
    }

    public final void cpI() {
        if (!this.tOB) {
            xP();
        }
        this.tOB = false;
    }

    private void xP() {
        this.tPk = null;
        if (!q.GF().equals(this.bAG.getTalkerUserName()) && s.fq(this.bAG.getTalkerUserName())) {
            this.tPk = this.bAG.getTalkerUserName();
            this.hej = (com.tencent.mm.model.bd.Ik() / 1000) * 1000;
            this.tPm = 0;
            au.Em().H(new 4(this, this.tPk));
        }
        com.tencent.mm.modelstat.d.b(3, "ChattingUI" + this.bAG.tTq.getIdentityString(), hashCode());
        cuV();
    }

    public final void cpJ() {
        if (!TextUtils.isEmpty(this.tPk) && s.fq(this.bAG.getTalkerUserName())) {
            this.tPl = com.tencent.mm.model.bd.Ik();
            String str = this.tPk;
            this.tPk = "";
            int cvB = ((p) this.bAG.O(p.class)).cvB();
            if (cvB == 2) {
                ((p) this.bAG.O(p.class)).cvA();
            }
            int i = 0;
            if (s.fq(this.bAG.getTalkerUserName()) && this.bAG.oLT.csI == 0) {
                i = 1;
            }
            au.Em().H(new 5(this, str, cvB, i));
        }
    }

    public final void cpK() {
        z.cXH.eG(this.bAG.getTalkerUserName());
        b.ehL.xP();
        ar arVar = new ar();
        arVar.bIf.bIg = false;
        com.tencent.mm.sdk.b.a.sFg.m(arVar);
    }
}
