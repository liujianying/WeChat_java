package com.tencent.mm.plugin.sns.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.ap.b;
import com.tencent.mm.plugin.sns.model.r;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.plugin.sns.ui.FlipView;
import com.tencent.mm.plugin.sns.ui.SnsBrowseUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.m;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.bri;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import java.net.URLEncoder;
import java.util.Map;

public final class a implements e, d {
    private Activity activity;
    private ClipboardManager jdw;
    private p nLY;
    private ae nMm;
    private View okr;
    private String oks;
    private bsu okt;
    private int scene;

    public a(Activity activity, int i, ae aeVar) {
        this.activity = activity;
        this.scene = i;
        this.jdw = (ClipboardManager) activity.getSystemService("clipboard");
        this.nMm = aeVar;
    }

    public final void a(View view, String str, bsu bsu) {
        this.okr = view;
        this.oks = str;
        this.okt = bsu;
    }

    private String bEH() {
        if (this.okr != null && (this.okr.getTag() instanceof as) && ((as) this.okr.getTag()).bDG()) {
            b Mq = ap.Mq(af.byo().Nl(this.oks).bAK());
            if (Mq != null) {
                return Mq.result;
            }
        }
        return null;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (this.okr != null) {
            int i2;
            ch chVar;
            n Nl;
            c cVar;
            String str;
            String str2;
            String Ob;
            n Nl2;
            u.b v;
            long VE;
            n Nl3;
            ate ate;
            bsu bsu;
            wl wlVar;
            wr wrVar;
            String bAK;
            m mVar;
            Context context;
            Intent intent;
            ch chVar2;
            com.tencent.mm.modelsns.b io;
            n Nk;
            Intent intent2;
            com.tencent.mm.plugin.sns.ui.ap apVar;
            switch (menuItem.getItemId()) {
                case 0:
                    Object bEH = bEH();
                    if (bi.oW(bEH)) {
                        bEH = this.okt.spZ;
                    }
                    this.jdw.setText(bEH);
                    h.bA(this.activity, this.activity.getString(j.app_copy_ok));
                    i2 = com.tencent.mm.plugin.secinforeport.a.a.mOt;
                    com.tencent.mm.plugin.secinforeport.a.a.f(2, this.okt.ksA, bi.WK(bEH));
                    return;
                case 1:
                    CharSequence bEH2 = bEH();
                    if (bi.oW(bEH2)) {
                        bEH2 = this.okt.spZ;
                    }
                    this.nMm.bxT().eE(this.oks, this.okt.ksA);
                    chVar = new ch();
                    com.tencent.mm.plugin.sns.i.a.a(chVar, this.oks, bEH2);
                    chVar.bJF.activity = this.activity;
                    chVar.bJF.bJM = 30;
                    com.tencent.mm.sdk.b.a.sFg.m(chVar);
                    return;
                case 2:
                    this.nMm.bxT().eE(this.oks, this.okt.ksA);
                    chVar = new ch();
                    Nl = com.tencent.mm.plugin.sns.storage.h.Nl(this.oks);
                    if (Nl.xb(32) && Nl.bAF().bzm()) {
                        Oc(this.oks);
                    } else if (this.okt.csE == 1) {
                        com.tencent.mm.plugin.sns.i.a.a(chVar, this.oks, 0);
                        chVar.bJF.activity = this.activity;
                        chVar.bJF.bJM = 31;
                        com.tencent.mm.sdk.b.a.sFg.m(chVar);
                    } else {
                        com.tencent.mm.plugin.sns.i.a.a(chVar, this.oks, ((com.tencent.mm.plugin.sns.ui.ap) this.okr.getTag()).index);
                        chVar.bJF.activity = this.activity;
                        chVar.bJF.bJM = 31;
                        com.tencent.mm.sdk.b.a.sFg.m(chVar);
                    }
                    if (Nl.xb(32)) {
                        cVar = new c(Nl.bBn(), 11, this.scene == 0 ? 1 : 2, "", Nl.bBr(), Nl.bAK());
                        g.Ek();
                        g.Eh().dpP.a(cVar, 0);
                        return;
                    }
                    return;
                case 3:
                    this.nMm.bxT().eE(this.oks, this.okt.ksA);
                    str = this.okt.sqc.jPK;
                    str2 = this.okt.sqb.ksA;
                    Ob = av.Ob(str);
                    if (bi.oW(Ob)) {
                        x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                        return;
                    }
                    ch chVar3 = new ch();
                    Nl2 = com.tencent.mm.plugin.sns.storage.h.Nl(this.oks);
                    if (Nl2 != null) {
                        str2 = u.ic(Nl2.field_snsId);
                        v = u.Hx().v(str2, true);
                        v.p("prePublishId", "sns_" + i.eF(Nl2.field_snsId));
                        v.p("preUsername", Nl2.field_userName);
                        v.p("preChatName", "");
                        v.p("url", Ob);
                        v.p("preMsgIndex", Integer.valueOf(0));
                        v.p("sendAppMsgScene", Integer.valueOf(1));
                        v.p("adExtStr", Nl2.bAJ().nNV);
                        chVar3.bJF.bJK = str2;
                    }
                    Nl = af.byo().Nl(this.oks);
                    if (Nl != null && this.okt.sqc.ruz == 18) {
                        com.tencent.mm.plugin.sns.a.b.j.a(com.tencent.mm.plugin.sns.a.b.j.d.nkf, com.tencent.mm.plugin.sns.a.b.j.c.njZ, com.tencent.mm.plugin.sns.a.b.j.e.nkk, 0, Nl);
                    }
                    if (bi.oW(this.okt.ogR)) {
                        if (Nl.xb(32)) {
                            cVar = new c(Nl.bBn(), 11, this.scene == 0 ? 1 : 2, "", Nl.bBr(), Nl.bAK());
                            g.Ek();
                            g.Eh().dpP.a(cVar, 0);
                        }
                        com.tencent.mm.plugin.sns.i.a.a(chVar3, Ob, this.oks);
                        chVar3.bJF.activity = this.activity;
                        chVar3.bJF.bJM = 28;
                        com.tencent.mm.sdk.b.a.sFg.m(chVar3);
                        if (chVar3.bJG.ret == 0) {
                            VE = bi.VE();
                            if (!bi.oW(Ob)) {
                                x.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), Ob, Long.valueOf(VE), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1)});
                                str = "";
                                try {
                                    str = URLEncoder.encode(Ob, "UTF-8");
                                } catch (Throwable e) {
                                    x.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", e, "", new Object[0]);
                                }
                                com.tencent.mm.plugin.report.service.h.mEJ.h(13378, new Object[]{str, Long.valueOf(VE), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1)});
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    Oc(Nl.bBe());
                    return;
                case 4:
                    this.nMm.bxT().eE(this.oks, this.okt.ksA);
                    Nl3 = af.byo().Nl(this.oks);
                    if (this.okt.sqc.ruA.size() != 0) {
                        ate = (ate) this.okt.sqc.ruA.get(0);
                        if (Nl3 == null || ate == null) {
                            x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                            return;
                        }
                        ch chVar4 = new ch();
                        if (ate == null || Nl3 == null || Nl3.nJc == 0) {
                            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
                            chVar4.bJF.bJL = j.favorite_fail_argument_error;
                        } else if (af.bxX()) {
                            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                            chVar4.bJF.bJL = j.favorite_fail_system_error;
                        } else {
                            String eF = i.eF(Nl3.field_snsId);
                            eF = String.format("%s#%s", new Object[]{eF, ate.ksA});
                            wl wlVar2 = new wl();
                            wr wrVar2 = new wr();
                            x.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", new Object[]{Nl3.field_userName});
                            wrVar2.Vw(Nl3.field_userName);
                            wrVar2.Vx(q.GF());
                            wrVar2.CO(2);
                            wrVar2.fU(((long) Nl3.field_createTime) * 1000);
                            wrVar2.VB(Nl3.bAK());
                            wrVar2.Vy(eF);
                            vx vxVar = new vx();
                            vxVar.UT(eF);
                            vxVar.UI(ate.jPK);
                            vxVar.UJ(ate.rVI);
                            vxVar.UH(Nl3.bAJ().sqc.jPK);
                            eF = an.s(af.getAccSnsPath(), ate.ksA) + i.e(ate);
                            if (FileOp.cn(eF)) {
                                vxVar.UQ(eF);
                            } else {
                                vxVar.kY(true);
                                vxVar.UK(ate.rVE);
                                xa xaVar = new xa();
                                xaVar.VM(ate.rVE);
                                wlVar2.b(xaVar);
                            }
                            vxVar.CF(7);
                            vxVar.UB(ate.bHD);
                            vxVar.UC(ate.jOS);
                            vxVar.kX(true);
                            wlVar2.rBI.add(vxVar);
                            wlVar2.a(wrVar2);
                            chVar4.bJF.bJH = wlVar2;
                            chVar4.bJF.type = 7;
                            com.tencent.mm.plugin.sns.i.a.a(vxVar, Nl3);
                        }
                        chVar4.bJF.activity = this.activity;
                        chVar4.bJF.bJM = 25;
                        com.tencent.mm.sdk.b.a.sFg.m(chVar4);
                        return;
                    }
                    return;
                case 5:
                    this.nMm.bxT().eE(this.oks, this.okt.ksA);
                    if (this.okt != null) {
                        chVar = new ch();
                        bsu = this.okt;
                        if (bsu == null) {
                            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                            chVar.bJF.bJL = j.favorite_fail_argument_error;
                        } else {
                            wlVar = new wl();
                            wrVar = new wr();
                            wk wkVar = new wk();
                            wrVar.Vw(bsu.hbL);
                            wrVar.Vx(q.GF());
                            wrVar.CO(2);
                            wrVar.fU(bi.VF());
                            if (bsu.sqb != null) {
                                wrVar.VC(bsu.sqb.ksA);
                            }
                            if (bsu.sqc != null) {
                                wkVar.Vp(bsu.sqc.bHD);
                                wkVar.Vq(bsu.sqc.jOS);
                                if (!(bsu.sqc.ruA == null || bsu.sqc.ruA.isEmpty())) {
                                    ate = (ate) bsu.sqc.ruA.get(0);
                                    wkVar.CL(ate.bID);
                                    wkVar.Vs(ate.nME);
                                    wkVar.Vr(ate.rVE);
                                }
                            }
                            chVar.bJF.title = wkVar.title;
                            chVar.bJF.desc = wkVar.desc;
                            chVar.bJF.bJH = wlVar;
                            chVar.bJF.type = 10;
                            wlVar.a(wrVar);
                            wlVar.b(wkVar);
                        }
                        chVar.bJF.activity = this.activity;
                        chVar.bJF.bJM = 26;
                        com.tencent.mm.sdk.b.a.sFg.m(chVar);
                        return;
                    }
                    return;
                case 7:
                    r rVar;
                    bAK = af.byo().Nl(this.oks).bAK();
                    mVar = (m) this.okr.getTag();
                    r rVar2;
                    if (v.ND(bAK)) {
                        rVar2 = new r(v.NE(bAK), 6, mVar.noe);
                        g.Ek();
                        g.Eh().dpP.a(rVar2, 0);
                        rVar = rVar2;
                    } else {
                        rVar2 = new r(v.NE(bAK), 4, mVar.noe);
                        g.Ek();
                        g.Eh().dpP.a(rVar2, 0);
                        rVar = rVar2;
                    }
                    context = this.activity;
                    this.activity.getString(j.app_tip);
                    this.nLY = h.a(context, this.activity.getString(j.sns_deling_sns), true, new 1(this, rVar));
                    return;
                case 8:
                    Nl2 = af.byo().Nl(this.oks);
                    if (Nl2 != null) {
                        com.tencent.mm.plugin.sns.abtest.a.b(Nl2);
                        intent = new Intent();
                        intent.putExtra("sns_permission_snsinfo_svr_id", Nl2.field_snsId);
                        intent.putExtra("sns_permission_userName", Nl2.field_userName);
                        intent.putExtra("sns_permission_anim", true);
                        intent.setClass(this.activity, SnsPermissionUI.class);
                        this.activity.startActivityForResult(intent, 11);
                        return;
                    }
                    return;
                case 9:
                    this.nMm.bxT().eE(this.oks, this.okt.ksA);
                    if (this.okt != null) {
                        chVar = new ch();
                        bsu = this.okt;
                        if (bsu == null) {
                            x.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                            chVar.bJF.bJL = j.favorite_fail_argument_error;
                        } else {
                            wlVar = new wl();
                            wrVar = new wr();
                            wu wuVar = new wu();
                            wrVar.Vw(bsu.hbL);
                            wrVar.Vx(q.GF());
                            wrVar.CO(8);
                            wrVar.fU(bi.VF());
                            if (bsu.sqb != null) {
                                wrVar.VC(bsu.sqb.ksA);
                            }
                            if (bsu.sqc != null) {
                                wuVar.VF(bsu.sqc.bHD);
                                wuVar.VG(bsu.sqc.jOS);
                                if (!(bsu.sqc.ruA == null || bsu.sqc.ruA.isEmpty())) {
                                    ate = (ate) bsu.sqc.ruA.get(0);
                                    wuVar.VI(ate.nME);
                                    wuVar.VH(ate.rVE);
                                }
                            }
                            chVar.bJF.title = wuVar.title;
                            chVar.bJF.desc = wuVar.desc;
                            chVar.bJF.bJH = wlVar;
                            chVar.bJF.type = 15;
                            wlVar.a(wrVar);
                            wlVar.b(wuVar);
                        }
                        chVar.bJF.activity = this.activity;
                        chVar.bJF.bJM = 27;
                        com.tencent.mm.sdk.b.a.sFg.m(chVar);
                        return;
                    }
                    return;
                case 10:
                    this.nMm.bxT().eE(this.oks, this.okt.ksA);
                    Nl2 = com.tencent.mm.plugin.sns.storage.h.Nl(this.oks);
                    if (Nl2.xb(32) && Nl2.bAF().bzm()) {
                        Nl = af.byo().Nl(this.oks);
                        if (Nl != null && Nl.xb(32)) {
                            cVar = new c(Nl.bBn(), 11, this.scene == 0 ? 1 : 2, "", 2, Nl.bAK());
                            g.Ek();
                            g.Eh().dpP.a(cVar, 0);
                        }
                        Oc(this.oks);
                        return;
                    }
                    n Nl4 = af.byo().Nl(this.oks);
                    if (Nl4 != null) {
                        if (Nl4.xb(32)) {
                            com.tencent.mm.plugin.sns.a.b.j.a(com.tencent.mm.plugin.sns.a.b.j.d.nke, com.tencent.mm.plugin.sns.a.b.j.c.njZ, com.tencent.mm.plugin.sns.a.b.j.e.nkk, 0, Nl4);
                            cVar = new c(Nl4.bBn(), 11, this.scene == 0 ? 1 : 2, "", Nl4.bBr(), Nl4.bAK());
                            g.Ek();
                            g.Eh().dpP.a(cVar, 0);
                        }
                        chVar2 = new ch();
                        com.tencent.mm.plugin.sns.i.a.a(chVar2, Nl4);
                        chVar2.bJF.activity = this.activity;
                        chVar2.bJF.bJM = 29;
                        com.tencent.mm.sdk.b.a.sFg.m(chVar2);
                        return;
                    }
                    return;
                case 11:
                    if (this.okr.getTag() instanceof m) {
                        mVar = (m) this.okr.getTag();
                        this.jdw.setText(mVar.jSA);
                        h.bA(this.activity, this.activity.getString(j.app_copy_ok));
                        if (mVar.noe != null) {
                            i2 = com.tencent.mm.plugin.secinforeport.a.a.mOt;
                            com.tencent.mm.plugin.secinforeport.a.a.f(4, this.okt.ksA + ":" + mVar.noe.smh, bi.WK(mVar.jSA));
                            return;
                        }
                        return;
                    }
                    return;
                case 12:
                    ate = (ate) this.okt.sqc.ruA.get(0);
                    str = an.s(af.getAccSnsPath(), ate.ksA) + i.e(ate);
                    intent = new Intent();
                    intent.putExtra("Select_Conv_Type", 3);
                    intent.putExtra("select_is_ret", true);
                    intent.putExtra("mutil_select_is_ret", true);
                    intent.putExtra("image_path", str);
                    intent.putExtra("Retr_Msg_Type", 11);
                    com.tencent.mm.bg.d.b(this.activity, ".ui.transmit.SelectConversationUI", intent, 15);
                    return;
                case 13:
                    com.tencent.mm.plugin.sns.abtest.a.a(this.activity, af.byo().Nl(this.oks));
                    return;
                case 14:
                    Nl3 = af.byo().Nl(this.oks);
                    if (Nl3 != null) {
                        if (this.scene == 0) {
                            io = com.tencent.mm.modelsns.b.io(714);
                        } else {
                            io = com.tencent.mm.modelsns.b.ip(714);
                        }
                        io.nb(i.g(Nl3)).ir(Nl3.field_type).bP(Nl3.xb(32)).nb(Nl3.bBo());
                        io.RD();
                    }
                    ap.o(Nl3);
                    return;
                case 15:
                    if (this.okr.getTag() instanceof m) {
                        mVar = (m) this.okr.getTag();
                        Nk = af.byo().Nk(mVar.nMv);
                        if (Nk != null) {
                            com.tencent.mm.modelsns.b io2;
                            if (this.scene == 0) {
                                io2 = com.tencent.mm.modelsns.b.io(715);
                            } else {
                                io2 = com.tencent.mm.modelsns.b.ip(715);
                            }
                            io2.nb(i.g(Nk)).ir(Nk.field_type).bP(Nk.xb(32)).nb(Nk.bBo());
                            if (mVar.noe != null) {
                                io2.nb(mVar.noe.smh == 0 ? mVar.noe.smk : mVar.noe.smh);
                            } else {
                                io2.nb("");
                            }
                            io2.RD();
                        }
                        ap.a((m) this.okr.getTag());
                        return;
                    }
                    return;
                case 16:
                    ap.p(af.byo().Nl(this.oks));
                    return;
                case 17:
                    if (this.okr.getTag() instanceof m) {
                        ap.b((m) this.okr.getTag());
                        return;
                    }
                    return;
                case 18:
                    context = this.activity;
                    Nk = af.byo().Nl(this.oks);
                    if (Nk != null) {
                        intent2 = new Intent();
                        if (Nk.bAJ().sqc.ruz == 1) {
                            apVar = (com.tencent.mm.plugin.sns.ui.ap) this.okr.getTag();
                            ate a = aj.a(Nk, apVar.index);
                            if (a == null) {
                                x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "send photo fail, mediaObj is null");
                                return;
                            } else {
                                intent2.putExtra("sns_send_data_ui_image_path", FlipView.g(an.s(af.getAccSnsPath(), a.ksA) + i.l(a), context));
                                intent2.putExtra("sns_send_data_ui_image_position", apVar.index);
                            }
                        } else if ((Nk.bAJ().sqc.ruz == 4 || Nk.bAJ().sqc.ruz == 15 || Nk.bAJ().sqc.ruz == 3) && ((ate) Nk.bAJ().sqc.ruA.get(0)) == null) {
                            x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mediaObj is null, send failed!");
                            return;
                        }
                        intent2.putExtra("exdevice_open_scene_type", 1);
                        intent2.putExtra("sns_local_id", this.oks);
                        intent2.putExtra("sns_send_data_ui_activity", true);
                        com.tencent.mm.bg.d.e(this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", intent2);
                        return;
                    }
                    return;
                case 19:
                    Nl2 = af.byo().Nl(this.oks);
                    if (Nl2 == null) {
                        x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but sns info is null.");
                        return;
                    } else if (Nl2.xb(32)) {
                        x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but it is ad");
                        return;
                    } else {
                        ate = (ate) Nl2.bAJ().sqc.ruA.get(0);
                        if (ate == null) {
                            x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute paly video but media is null");
                            return;
                        }
                        bAK = an.s(af.getAccSnsPath(), ate.ksA);
                        str2 = "";
                        if (FileOp.cn(bAK + i.j(ate))) {
                            str2 = bAK + i.e(ate);
                        }
                        if (FileOp.cn(bAK + i.p(ate))) {
                            str2 = bAK + i.n(ate);
                        }
                        Intent intent3 = new Intent();
                        intent3.setClass(this.activity, SnsOnlineVideoActivity.class);
                        intent3.putExtra("intent_thumbpath", str2);
                        intent3.putExtra("intent_localid", this.oks);
                        intent3.putExtra("intent_from_scene", this.scene);
                        intent3.putExtra("intent_ismute", true);
                        if (this.okr != null) {
                            int[] iArr = new int[2];
                            this.okr.getLocationInWindow(iArr);
                            int width = this.okr.getWidth();
                            int height = this.okr.getHeight();
                            intent3.putExtra("img_gallery_left", iArr[0]);
                            intent3.putExtra("img_gallery_top", iArr[1]);
                            intent3.putExtra("img_gallery_width", width);
                            intent3.putExtra("img_gallery_height", height);
                        }
                        this.activity.startActivity(intent3);
                        this.activity.overridePendingTransition(0, 0);
                        return;
                    }
                case 20:
                    this.nMm.bxT().eE(this.oks, this.okt.ksA);
                    Nl2 = com.tencent.mm.plugin.sns.storage.h.Nl(this.oks);
                    if (Nl2.xb(32) && Nl2.bAF().bzm()) {
                        Nl = af.byo().Nl(this.oks);
                        if (Nl != null && Nl.xb(32)) {
                            if (this.okt == null || this.okt.sqc.ruz != 15 || this.okt.sqj == 1) {
                                cVar = new c(Nl.bBn(), 11, this.scene == 0 ? 1 : 2, "", 4, Nl.bAK());
                                g.Ek();
                                g.Eh().dpP.a(cVar, 0);
                            } else {
                                cVar = new c(Nl.bBn(), 11, this.scene == 0 ? 1 : 2, "", 5, Nl.bAK());
                                g.Ek();
                                g.Eh().dpP.a(cVar, 0);
                            }
                        }
                        Oc(this.oks);
                        return;
                    }
                    n Nl5 = af.byo().Nl(this.oks);
                    str = null;
                    if (Nl5 != null && Nl5.xb(32)) {
                        str = Nl5.bBm();
                        if (bi.oW(str)) {
                            str = Nl5.bBl();
                        }
                    }
                    if (bi.oW(str)) {
                        str = this.okt.sqc.jPK;
                        str2 = this.okt.sqb.ksA;
                        Ob = av.Ob(str);
                    } else {
                        Ob = str;
                    }
                    if (bi.oW(Ob)) {
                        x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                        return;
                    }
                    ch chVar5 = new ch();
                    Nl2 = com.tencent.mm.plugin.sns.storage.h.Nl(this.oks);
                    if (Nl2 != null) {
                        str2 = u.ic(Nl2.field_snsId);
                        v = u.Hx().v(str2, true);
                        v.p("prePublishId", "sns_" + i.eF(Nl2.field_snsId));
                        v.p("preUsername", Nl2.field_userName);
                        v.p("preChatName", "");
                        v.p("url", Ob);
                        v.p("preMsgIndex", Integer.valueOf(0));
                        v.p("sendAppMsgScene", Integer.valueOf(1));
                        v.p("adExtStr", Nl2.bAJ().nNV);
                        chVar5.bJF.bJK = str2;
                    }
                    if (Nl5 != null && (this.okt.sqc.ruz == 18 || Nl5.xb(32))) {
                        com.tencent.mm.plugin.sns.a.b.j.a(com.tencent.mm.plugin.sns.a.b.j.d.nkf, com.tencent.mm.plugin.sns.a.b.j.c.njZ, com.tencent.mm.plugin.sns.a.b.j.e.nkk, 0, Nl5);
                        if (this.okt == null || this.okt.sqc.ruz != 15 || this.okt.sqj == 1) {
                            cVar = new c(Nl5.bBn(), 11, this.scene == 0 ? 1 : 2, "", Nl5.bBr(), Nl5.bAK());
                            g.Ek();
                            g.Eh().dpP.a(cVar, 0);
                        } else {
                            cVar = new c(Nl5.bBn(), 11, this.scene == 0 ? 1 : 2, "", 5, Nl5.bAK());
                            g.Ek();
                            g.Eh().dpP.a(cVar, 0);
                        }
                    }
                    if (bi.oW(this.okt.ogR)) {
                        com.tencent.mm.plugin.sns.i.a.a(chVar5, Ob, this.oks);
                        chVar5.bJF.activity = this.activity;
                        chVar5.bJF.bJM = 28;
                        com.tencent.mm.sdk.b.a.sFg.m(chVar5);
                        if (chVar5.bJG.ret == 0) {
                            VE = bi.VE();
                            if (!bi.oW(Ob)) {
                                x.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), Ob, Long.valueOf(VE), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1)});
                                str = "";
                                try {
                                    str = URLEncoder.encode(Ob, "UTF-8");
                                } catch (Throwable e2) {
                                    x.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", e2, "", new Object[0]);
                                }
                                com.tencent.mm.plugin.report.service.h.mEJ.h(13378, new Object[]{str, Long.valueOf(VE), Integer.valueOf(3), Integer.valueOf(2), Integer.valueOf(1)});
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    Oc(Nl5.bBe());
                    return;
                case 21:
                    Nl3 = com.tencent.mm.plugin.sns.storage.h.Nl(this.oks);
                    if (Nl3 == null) {
                        x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, info is null");
                        return;
                    }
                    apVar = (com.tencent.mm.plugin.sns.ui.ap) this.okr.getTag();
                    Context context2 = this.activity;
                    intent2 = menuItem.getIntent();
                    ae aeVar = this.nMm;
                    if (intent2 == null) {
                        x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] intent is null!");
                        return;
                    } else if (aeVar == null) {
                        x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] snsContext is null!");
                        return;
                    } else if (Nl3 == null) {
                        x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
                        return;
                    } else {
                        g.Ek();
                        if (g.Ei().isSDCardAvailable()) {
                            String str3 = apVar.bNH;
                            int i3 = apVar.index;
                            int i4 = apVar.position;
                            bsu = Nl3.bAJ();
                            if (bsu.sqc == null || bsu.sqc.ruA.size() == 0) {
                                x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is ContentObj null");
                                return;
                            }
                            aeVar.bxT().v(Nl3);
                            bsu bAJ = Nl3.bAJ();
                            ate = i3 < bAJ.sqc.ruA.size() ? (ate) bAJ.sqc.ruA.get(i3) : new ate();
                            if (af.byl().B(ate)) {
                                com.tencent.mm.modelsns.b io3 = com.tencent.mm.modelsns.b.io(716);
                                io3.nb(i.g(Nl3)).ir(Nl3.field_type).bP(Nl3.xb(32)).nb(Nl3.bBo()).nb(ate.ksA).ir(i3).ir(bAJ.sqc.ruA.size());
                                io3.RD();
                                io = com.tencent.mm.modelsns.b.io(744);
                                io.nb(i.g(Nl3)).ir(Nl3.field_type).bP(Nl3.xb(32)).nb(Nl3.bBo());
                                io.b(intent2, "intent_key_StatisticsOplog");
                                intent2.putExtra("sns_soon_enter_photoedit_ui", true);
                                intent2.putExtra("sns_gallery_localId", str3);
                                intent2.putExtra("sns_gallery_position", i3);
                                intent2.putExtra("sns_position", i4);
                                intent2.putExtra("sns_gallery_showtype", 1);
                                intent2.putExtra("K_ad_scene", 1);
                                intent2.putExtra("k_is_from_sns_main_timeline", true);
                                intent2.setClass(context2, SnsBrowseUI.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("stat_scene", 3);
                                bundle.putString("stat_msg_id", "sns_" + i.eF(Nl3.field_snsId));
                                bundle.putString("stat_send_msg_user", Nl3.field_userName);
                                intent2.putExtra("_stat_obj", bundle);
                                context2.startActivity(intent2);
                                context2.overridePendingTransition(0, 0);
                                return;
                            }
                            x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] media[%s] is illegal", new Object[]{Integer.valueOf(ate.nkZ)});
                            return;
                        }
                        x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] is not SDCardAvailable");
                        return;
                    }
                case 22:
                    if (this.okt == null) {
                        x.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favNotelink,tlobj is null, return");
                        return;
                    }
                    chVar2 = new ch();
                    com.tencent.mm.plugin.sns.i.a.b(chVar2, this.oks);
                    chVar2.bJF.activity = this.activity;
                    chVar2.bJF.bJM = 28;
                    com.tencent.mm.sdk.b.a.sFg.m(chVar2);
                    return;
                default:
                    return;
            }
        }
    }

    private void Oc(String str) {
        n Nl = af.byo().Nl(str);
        if (Nl != null) {
            String w;
            if (Nl.xb(32)) {
                Nl.bAH();
                com.tencent.mm.plugin.sns.storage.e bBp = Nl.bBp();
                w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(Nl);
                if (!bi.oW(w)) {
                    bBp.field_adxml = w;
                }
                w = bBp.field_adxml;
            } else {
                w = Nl.bAJ().ogR;
            }
            Map z = bl.z(w, "adxml");
            if (z == null) {
                return;
            }
            if (z.containsKey(".adxml.adCanvasInfo")) {
                String ic = u.ic(Nl.field_snsId);
                String aG = bi.aG((String) z.get(".adxml.adCanvasInfo.shareTitle"), "");
                String aG2 = bi.aG((String) z.get(".adxml.adCanvasInfo.shareWebUrl"), "");
                String aG3 = bi.aG((String) z.get(".adxml.adCanvasInfo.shareDesc"), "");
                ch chVar = new ch();
                qs qsVar = new qs();
                qsVar.cbk.cbn = str;
                qsVar.cbk.cbo = chVar;
                qsVar.cbk.url = aG2;
                com.tencent.mm.sdk.b.a.sFg.m(qsVar);
                if (qsVar.cbl.bJm) {
                    chVar.bJF.bJK = ic;
                    chVar.bJF.title = aG;
                    chVar.bJF.desc = aG3;
                    wl wlVar = chVar.bJF.bJH;
                    if (!(wlVar == null || wlVar.rBI == null || wlVar.rBI.size() <= 0 || wlVar.rBI.get(0) == null)) {
                        ((vx) wlVar.rBI.get(0)).Va(w);
                        if (bi.oW(((vx) wlVar.rBI.get(0)).title)) {
                            ((vx) wlVar.rBI.get(0)).UB(chVar.bJF.title);
                        }
                        if (bi.oW(((vx) wlVar.rBI.get(0)).desc)) {
                            ((vx) wlVar.rBI.get(0)).UC(chVar.bJF.desc);
                        }
                    }
                    chVar.bJF.activity = this.activity;
                    chVar.bJF.bJM = 28;
                    com.tencent.mm.sdk.b.a.sFg.m(chVar);
                    return;
                }
                if (chVar.bJF.bJL == 0) {
                    chVar.bJF.bJL = j.favorite_fail_nonsupport;
                }
                h.i(this.activity, chVar.bJF.bJL, 0);
                return;
            }
            h.i(this.activity, j.favorite_fail_parse_error, 0);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 15) {
                n Nl = af.byo().Nl(this.oks);
                ate ate = (ate) this.okt.sqc.ruA.get(0);
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                String str = an.s(af.getAccSnsPath(), ate.ksA) + i.e(ate);
                for (String str2 : bi.F(stringExtra.split(","))) {
                    String str3;
                    if (Nl.xb(32)) {
                        com.tencent.mm.plugin.sns.a.b.j.c cVar;
                        int gK;
                        str3 = an.s(af.getAccSnsPath(), ate.ksA) + i.j(ate);
                        bsu bAJ = Nl.bAJ();
                        com.tencent.mm.plugin.sns.storage.b bAF = Nl.bAF();
                        bri bri = new bri();
                        bri.rBq = ate.oig;
                        bri.dyJ = ate.rVL;
                        if (bAJ.sqc.ruz == 15) {
                            bri.dyP = Nl.bAH().ntU;
                            bri.dyQ = bAJ.ksA;
                        } else {
                            bri.dyP = bAJ.sqh.dyP;
                            bri.dyQ = bAJ.sqh.dyQ;
                        }
                        bri.dyL = bAJ.spZ;
                        bri.dyO = bi.oW(ate.rVO) ? ate.rVE : ate.rVO;
                        if (bAF != null && bAF.nyL == 0) {
                            bri.dyN = bAF.nyN;
                            bri.dyM = bAF.nyM;
                        }
                        x.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[]{str2, str3, str, ate.rVL, Integer.valueOf(ate.oig), Integer.valueOf(i.LQ(str3))});
                        com.tencent.mm.plugin.messenger.a.g.bcT().a(this.activity, str2, str3, str, 43, r7, bri, bAJ.nNV);
                        com.tencent.mm.plugin.messenger.a.g.bcT().dF(stringExtra2, str2);
                        c cVar2 = new c(Nl.bBn(), 12, this.scene == 0 ? 1 : 2, "", 2, Nl.bAK());
                        g.Ek();
                        g.Eh().dpP.a(cVar2, 0);
                        boolean fq = s.fq(str2);
                        com.tencent.mm.plugin.sns.a.b.j.d dVar = com.tencent.mm.plugin.sns.a.b.j.d.nke;
                        if (fq) {
                            cVar = com.tencent.mm.plugin.sns.a.b.j.c.nkb;
                        } else {
                            cVar = com.tencent.mm.plugin.sns.a.b.j.c.nka;
                        }
                        com.tencent.mm.plugin.sns.a.b.j.e eVar = com.tencent.mm.plugin.sns.a.b.j.e.nkk;
                        if (fq) {
                            gK = com.tencent.mm.model.m.gK(str2);
                        } else {
                            gK = 0;
                        }
                        com.tencent.mm.plugin.sns.a.b.j.a(dVar, cVar, eVar, gK, Nl);
                        return;
                    }
                    str3 = an.s(af.getAccSnsPath(), ate.ksA) + i.j(ate);
                    x.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", new Object[]{str2, str3, str, ate.rVL, Integer.valueOf(ate.oig), Integer.valueOf(i.LQ(str3))});
                    com.tencent.mm.plugin.messenger.a.g.bcT().a(this.activity, str2, str3, str, 43, r7, this.okt.nNV);
                    com.tencent.mm.plugin.messenger.a.g.bcT().dF(stringExtra2, str2);
                }
                com.tencent.mm.ui.widget.snackbar.b.h(this.activity, this.activity.getString(j.has_send));
            }
        } else if (i == 15) {
            n Nl2 = af.byo().Nl(this.oks);
            if (Nl2 == null) {
                x.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "menuitemselected and snsinfo is null %s", new Object[]{this.oks});
                return;
            }
            c cVar3 = new c(Nl2.bBn(), 13, this.scene == 0 ? 1 : 2, "", 2, Nl2.bAK());
            g.Ek();
            g.Eh().dpP.a(cVar3, 0);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "onSceneEnd");
        if (this.nLY != null && this.nLY.isShowing()) {
            this.nLY.dismiss();
        }
    }
}
