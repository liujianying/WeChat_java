package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.y.g;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.List;

class j$6 implements OnClickListener {
    final /* synthetic */ j tOS;

    j$6(j jVar) {
        this.tOS = jVar;
    }

    private void b(ch chVar) {
        int i;
        chVar.bJF.nd = this.tOS.bAG.tTq;
        chVar.bJF.bJM = 41;
        chVar.bJF.bJO = new 1(this);
        a.sFg.m(chVar);
        if (chVar.bJG.ret == 0) {
            i = 1;
        } else {
            i = 2;
        }
        List<bd> c = j.c(this.tOS);
        long VE = bi.VE();
        for (bd bdVar : c) {
            if (bdVar.aQm()) {
                g.a gp = g.a.gp(bi.WT(bdVar.field_content));
                if (!(gp == null || gp.type != 5 || bi.oW(gp.url))) {
                    int i2;
                    if (bdVar.cky()) {
                        i2 = 1;
                    } else {
                        i2 = 2;
                    }
                    x.d("MicroMsg.ChattingMoreBtnBarHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), gp.url, Long.valueOf(VE), Integer.valueOf(i2), Integer.valueOf(2), Integer.valueOf(1)});
                    String str = "";
                    try {
                        str = URLEncoder.encode(gp.url, "UTF-8");
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ChattingMoreBtnBarHelper", e, "", new Object[0]);
                    }
                    h.mEJ.h(13378, new Object[]{str, Long.valueOf(VE), Integer.valueOf(i2), Integer.valueOf(2), Integer.valueOf(i)});
                }
            }
        }
        if (chVar.bJG.ret != 0) {
            return;
        }
        if (14 != chVar.bJF.type) {
            x.d("MicroMsg.ChattingMoreBtnBarHelper", "not record type, do not report");
        } else if (chVar.bJF.bJI == null) {
            x.e("MicroMsg.ChattingMoreBtnBarHelper", "want to report record fav, but type count is null");
        } else {
            h.mEJ.h(11142, new Object[]{Integer.valueOf(chVar.bJF.bJI.rBY), Integer.valueOf(chVar.bJF.bJI.rBZ), Integer.valueOf(chVar.bJF.bJI.rCa), Integer.valueOf(chVar.bJF.bJI.rCb), Integer.valueOf(chVar.bJF.bJI.rCc), Integer.valueOf(chVar.bJF.bJI.rCd), Integer.valueOf(chVar.bJF.bJI.rCe), Integer.valueOf(chVar.bJF.bJI.rCf), Integer.valueOf(chVar.bJF.bJI.rCg), Integer.valueOf(chVar.bJF.bJI.rCh), Integer.valueOf(chVar.bJF.bJI.rCi), Integer.valueOf(chVar.bJF.bJI.rCj), Integer.valueOf(chVar.bJF.bJI.rCk), Integer.valueOf(chVar.bJF.bJI.rCl), Integer.valueOf(chVar.bJF.bJI.rCm)});
        }
    }

    public final void onClick(View view) {
        List<bd> c = j.c(this.tOS);
        HashSet hashSet = new HashSet();
        for (bd bdVar : c) {
            if (bdVar.aQm()) {
                g.a gp = g.a.gp(bdVar.field_content);
                if (!(gp == null || gp.type != 6 || bi.oW(gp.dwu))) {
                    b d = l.d(bdVar, gp.bGP);
                    if (!(d == null || (e.cn(d.field_fileFullPath) && ((long) e.cm(d.field_fileFullPath)) == d.field_totalLen))) {
                        x.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadTpFileAndFav startDownload msgID:%d", new Object[]{Long.valueOf(bdVar.field_msgId)});
                        hashSet.add(Long.valueOf(bdVar.field_msgId));
                        i iVar = new i();
                        iVar.dPV = new 4(this, d, bdVar, hashSet);
                        iVar.field_mediaId = d.a("checkExist", bi.VF(), bdVar.field_talker, bdVar.field_msgId);
                        iVar.field_aesKey = gp.dwK;
                        iVar.field_fileType = 19;
                        iVar.field_authKey = gp.dwA;
                        iVar.dPW = gp.dwu;
                        if (d == null || bi.oW(d.field_fileFullPath)) {
                            au.HU();
                            iVar.field_fullpath = l.al(c.Gk(), gp.title, gp.dwp);
                        } else {
                            iVar.field_fullpath = d.field_fileFullPath;
                        }
                        if (!com.tencent.mm.modelcdntran.g.ND().b(iVar, -1)) {
                            x.e("MicroMsg.ChattingMoreBtnBarHelper", "openim attach download failed before rescend");
                        }
                    }
                }
            }
            if (bdVar.ckA()) {
                int i;
                com.tencent.mm.ak.e bq = o.Pf().bq(bdVar.field_msgSvrId);
                if (bdVar.field_isSend == 1) {
                    i = bq.ON() ? 1 : 0;
                } else if (bq.ON()) {
                    i = !e.cn(o.Pf().o(f.a(bq).dTL, "", "")) ? 0 : 1;
                } else {
                    i = 0;
                }
                if (bq.offset < bq.dHI || bq.dHI == 0) {
                    x.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadImgAndFav start  msgID:%d", new Object[]{Long.valueOf(bdVar.field_msgId)});
                    hashSet.add(Long.valueOf(bdVar.field_msgId));
                    o.Pg().a(bq.dTK, bdVar.field_msgId, i, bdVar, R.g.chat_img_template, new 3(this, bdVar, hashSet));
                }
            }
            if (bdVar.cmj() || bdVar.cmk()) {
                r nW = t.nW(bdVar.field_imgPath);
                if (!(nW == null || nW.status == 199)) {
                    hashSet.add(Long.valueOf(bdVar.field_msgId));
                    com.tencent.mm.modelvideo.o.Ta().a(new 2(this, bdVar, hashSet), Looper.getMainLooper());
                    x.i("MicroMsg.ChattingMoreBtnBarHelper", "oreh downloadVideoAndFav start  msgID:%d, fileName:%s", new Object[]{Long.valueOf(bdVar.field_msgId), bdVar.field_imgPath});
                    if (nW.To()) {
                        x.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete online video");
                        t.oa(bdVar.field_imgPath);
                    } else {
                        x.i("MicroMsg.ChattingMoreBtnBarHelper", "start complete offline video");
                        t.nS(bdVar.field_imgPath);
                    }
                }
            }
        }
        g(hashSet);
    }

    private void g(HashSet<Long> hashSet) {
        if (hashSet.isEmpty()) {
            new ag(Looper.getMainLooper()).post(new 5(this));
        }
    }

    public final void cuU() {
        final List<bd> c = j.c(this.tOS);
        if (j.dC(c)) {
            com.tencent.mm.ui.base.h.a(this.tOS.bAG.tTq.getContext(), this.tOS.bAG.tTq.getContext().getString(R.l.favorite_fail_remuxing_error), "", this.tOS.bAG.tTq.getContext().getString(R.l.I_known), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return;
        }
        bd bdVar;
        final ch chVar = new ch();
        x.d("MicroMsg.ChattingMoreBtnBarHelper", "want fav msgs from %s", new Object[]{j.e(this.tOS).field_username});
        if (c != null && c.size() == 1) {
            bdVar = (bd) c.get(0);
            if (bdVar != null && (bdVar.aQm() || bdVar.cky())) {
                String ic = u.ic(bdVar.field_msgSvrId);
                u.b v = u.Hx().v(ic, true);
                v.p("prePublishId", "msg_" + bdVar.field_msgSvrId);
                v.p("preUsername", com.tencent.mm.ui.chatting.viewitems.b.a(bdVar, j.d(this.tOS), ((com.tencent.mm.ui.chatting.b.b.c) this.tOS.bAG.O(com.tencent.mm.ui.chatting.b.b.c.class)).cur()));
                v.p("preChatName", j.e(this.tOS).field_username);
                v.p("preMsgIndex", Integer.valueOf(0));
                v.p("sendAppMsgScene", Integer.valueOf(1));
                ((com.tencent.mm.plugin.sns.b.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.sns.b.i.class)).a("adExtStr", v, bdVar);
                chVar.bJF.bJK = ic;
            }
        }
        if (com.tencent.mm.pluginsdk.model.g.a(this.tOS.bAG.tTq.getContext(), chVar, j.e(this.tOS).field_username, c, false, true)) {
            for (bd bdVar2 : c) {
                if (bdVar2.aQm()) {
                    com.tencent.mm.modelstat.b.ehL.b(bdVar2, com.tencent.mm.y.h.g(bdVar2));
                } else {
                    com.tencent.mm.modelstat.b.ehL.x(bdVar2);
                }
            }
            b(chVar);
            dG(j.c(this.tOS));
        } else if (j.c(this.tOS).size() > 1) {
            String string;
            Context context = this.tOS.bAG.tTq.getContext();
            String string2 = chVar.bJF.bJL >= 0 ? this.tOS.bAG.tTq.getContext().getString(R.l.favorite_fail_recordtype_error) : this.tOS.bAG.tTq.getContext().getString(R.l.favorite_fail_record_expired_bigfile);
            String str = "";
            if (chVar.bJF.bJL >= 0) {
                string = this.tOS.bAG.tTq.getContext().getString(R.l.confirm_dialog_ok);
            } else {
                string = this.tOS.bAG.tTq.getContext().getString(R.l.plugin_favorite_opt);
            }
            com.tencent.mm.ui.base.h.a(context, string2, str, string, this.tOS.bAG.tTq.getContext().getString(R.l.confirm_dialog_cancel), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    for (bd bdVar : c) {
                        if (!bdVar.cmm() && !bdVar.cml()) {
                            if (chVar.bJF.type == 14 && chVar.bJF.bJH.rBI.size() == 0) {
                                j$6.this.tOS.cuQ();
                                return;
                            }
                            j$6.this.b(chVar);
                            j$6.dG(j.c(j$6.this.tOS));
                            return;
                        }
                    }
                }
            }, null);
        } else {
            com.tencent.mm.ui.base.h.i(this.tOS.bAG.tTq.getContext(), chVar.bJF.bJL, 0);
        }
    }

    private static void dG(List<bd> list) {
        for (bd a : list) {
            com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.c.tFU, com.tencent.mm.ui.chatting.a.d.tFZ, a, 0);
        }
    }
}
