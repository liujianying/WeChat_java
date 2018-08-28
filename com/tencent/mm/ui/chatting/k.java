package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.design.a$i;
import com.tencent.mm.R;
import com.tencent.mm.aa.j;
import com.tencent.mm.aa.q;
import com.tencent.mm.ac.f;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.m;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u$b;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.chatting.a.d;
import com.tencent.mm.ui.chatting.l.1;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g.a;
import com.tencent.mm.y.i;
import com.tencent.mm.y.l;
import java.io.File;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class k {
    private static a tIE = new a((byte) 0);

    static /* synthetic */ void d(Context context, String str, bd bdVar, boolean z) {
        x.i("MicroMsg.ChattingEditModeRetransmitMsg", "retransmitSingleMsg %s", new Object[]{Long.valueOf(bdVar.field_msgId)});
        if (!j.as(bdVar) && !j.at(bdVar)) {
            boolean fq;
            if (f.eZ(str) && !bdVar.ckA() && !bdVar.isText() && !bdVar.ckz()) {
                x.i("MicroMsg.ChattingEditModeRetransmitMsg", "not bizChatSupport msg:type:%d", new Object[]{Integer.valueOf(bdVar.getType())});
            } else if (bdVar.ckA()) {
                j.b(context, str, bdVar);
            } else if (bdVar.cmj()) {
                j.c(context, str, bdVar);
            } else if (bdVar.cmk()) {
                j.c(context, str, bdVar);
                fq = s.fq(str);
                a.a(fq ? c.tFW : c.tFV, d.tFZ, bdVar, fq ? m.gK(str) : 0);
            } else if (bdVar.isText()) {
                j.a(context, str, bdVar, z);
            } else if (bdVar.cmd() || bdVar.aQm()) {
                fq = s.fq(str);
                a.a(fq ? c.tFW : c.tFV, d.tFZ, bdVar, fq ? m.gK(str) : 0);
                a aVar;
                if (bdVar.cmm()) {
                    if (j.a(context, str, bdVar, "appEmoji")) {
                        an YJ = an.YJ(bdVar.field_content);
                        a J = a.J(bdVar.field_content, bdVar.field_reserved);
                        if (J == null) {
                            J = new a();
                            J.dwq = YJ.bKg;
                            aVar = J;
                        } else {
                            aVar = J;
                        }
                        if (bi.oW(aVar.dwq) || aVar.dwq.equalsIgnoreCase("-1")) {
                            x.e("MicroMsg.ChattingEditModeLogic", "emoji md5 is null. ignore resend");
                            return;
                        }
                        x.d("MicroMsg.ChattingEditModeLogic", "jacks send App Emoji: %s, %s", new Object[]{str, aVar.dwq});
                        EmojiInfo zi = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zi(aVar.dwq);
                        if (zi != null) {
                            j.b(zi, str);
                        } else {
                            x.i("MicroMsg.ChattingEditModeLogic", "emoji is null. content:%s", new Object[]{YJ});
                        }
                    }
                } else if (bdVar.cky()) {
                    try {
                        l wS = ((com.tencent.mm.plugin.biz.a.a) g.l(com.tencent.mm.plugin.biz.a.a.class)).wS(bdVar.field_content);
                        List<com.tencent.mm.y.m> list = wS.dzs;
                        if (list != null) {
                            for (com.tencent.mm.y.m mVar : list) {
                                a aVar2 = new a();
                                if (i.gr(mVar.dzD)) {
                                    l.b(str, l.a(str, mVar), mVar.dzI);
                                } else {
                                    aVar2.title = mVar.title;
                                    aVar2.description = mVar.dzA;
                                    aVar2.action = "view";
                                    aVar2.type = 5;
                                    aVar2.url = mVar.url;
                                    aVar2.bZG = wS.bZG;
                                    aVar2.bZH = wS.bZH;
                                    aVar2.cGB = wS.cGB;
                                    aVar2.thumburl = mVar.dzy;
                                    if (bi.oW(aVar2.thumburl)) {
                                        j kc = q.KH().kc(bdVar.field_talker);
                                        if (kc != null) {
                                            aVar2.thumburl = kc.Kx();
                                        }
                                    }
                                    j.a(context, str, a.a(aVar2, null, null), bdVar.field_isSend, z);
                                }
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
                        x.e("MicroMsg.ChattingEditModeLogic", "[oneliang]retransmit multi app msg error : %s", new Object[]{e.getLocalizedMessage()});
                    }
                } else {
                    String iC = bdVar.field_isSend == 0 ? com.tencent.mm.model.bd.iC(bdVar.field_content) : bdVar.field_content;
                    aVar = a.gp(iC);
                    if (aVar == null) {
                        x.e("MicroMsg.ChattingEditModeRetransmitMsg", "parse app message content fail");
                        return;
                    }
                    com.tencent.mm.pluginsdk.model.app.f bl = com.tencent.mm.pluginsdk.model.app.g.bl(aVar.appId, false);
                    if (bl != null && bl.aaq()) {
                        x.w("MicroMsg.ChattingEditModeRetransmitMsg", "do not forward game msg");
                    } else if (aVar.type == 19) {
                        mw mwVar = new mw();
                        mwVar.bXL.type = 4;
                        mwVar.bXL.bXQ = bdVar;
                        mwVar.bXL.toUser = str;
                        com.tencent.mm.sdk.b.a.sFg.m(mwVar);
                    } else {
                        if (aVar.type == 6 && !bi.oW(aVar.dwu)) {
                            b SZ;
                            Object obj;
                            if (!bi.oW(aVar.dwu)) {
                                SZ = com.tencent.mm.pluginsdk.model.app.l.SZ(aVar.bGP);
                                if (SZ == null) {
                                    com.tencent.mm.pluginsdk.model.app.l.c(bdVar.field_msgId, iC, null);
                                }
                                obj = null;
                                if (SZ != null) {
                                    File file = new File(SZ.field_fileFullPath);
                                    if (file.exists() && file.length() == SZ.field_totalLen) {
                                        obj = 1;
                                    }
                                }
                                if (obj == null) {
                                    com.tencent.mm.modelcdntran.i iVar = new com.tencent.mm.modelcdntran.i();
                                    iVar.dPV = new 5(aVar, SZ, context, str, bdVar, z);
                                    iVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("checkExist", bi.VF(), bdVar.field_talker, bdVar.field_msgId);
                                    iVar.field_aesKey = aVar.dwK;
                                    iVar.field_fileType = 19;
                                    iVar.field_authKey = aVar.dwA;
                                    iVar.dPW = aVar.dwu;
                                    if (SZ == null || bi.oW(SZ.field_fileFullPath)) {
                                        au.HU();
                                        iVar.field_fullpath = com.tencent.mm.pluginsdk.model.app.l.al(com.tencent.mm.model.c.Gk(), aVar.title, aVar.dwp);
                                    } else {
                                        iVar.field_fullpath = SZ.field_fileFullPath;
                                    }
                                    if (!com.tencent.mm.modelcdntran.g.ND().b(iVar, -1)) {
                                        x.e("MicroMsg.ChattingEditModeRetransmitMsg", "openim attach download failed before rescend");
                                        return;
                                    }
                                    return;
                                }
                            }
                            SZ = com.tencent.mm.pluginsdk.model.app.l.SZ(aVar.bGP);
                            obj = null;
                            if (SZ != null) {
                                File file2 = new File(SZ.field_fileFullPath);
                                if (file2.exists() && file2.length() == SZ.field_totalLen) {
                                    obj = 1;
                                }
                            }
                            if (obj == null) {
                                com.tencent.mm.modelcdntran.i iVar2 = new com.tencent.mm.modelcdntran.i();
                                iVar2.dPV = new 5(aVar, SZ, context, str, bdVar, z);
                                iVar2.field_mediaId = com.tencent.mm.modelcdntran.d.a("checkExist", bi.VF(), bdVar.field_talker, bdVar.field_msgId);
                                iVar2.field_aesKey = aVar.dwK;
                                iVar2.field_fileType = 19;
                                iVar2.field_authKey = aVar.dwA;
                                iVar2.dPW = aVar.dwu;
                                if (SZ == null || bi.oW(SZ.field_fileFullPath)) {
                                    au.HU();
                                    iVar2.field_fullpath = com.tencent.mm.pluginsdk.model.app.l.al(com.tencent.mm.model.c.Gk(), aVar.title, aVar.dwp);
                                } else {
                                    iVar2.field_fullpath = SZ.field_fileFullPath;
                                }
                                if (!com.tencent.mm.modelcdntran.g.ND().b(iVar2, -1)) {
                                    x.e("MicroMsg.ChattingEditModeRetransmitMsg", "openim attach download failed before rescend");
                                    return;
                                }
                                return;
                            }
                        }
                        if (aVar.type == 5 && !bi.oW(aVar.url)) {
                            iC = "";
                            try {
                                iC = URLEncoder.encode(aVar.url, "UTF-8");
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", e2, "", new Object[0]);
                            }
                            long VE = bi.VE();
                            x.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), aVar.url, Long.valueOf(VE), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1)});
                            h.mEJ.h(13378, new Object[]{iC, Long.valueOf(VE), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1)});
                        }
                        j.b(context, str, bdVar, z);
                    }
                }
            } else if (bdVar.cmi()) {
                if (j.a(context, str, bdVar, "friendcard")) {
                    String p = j.p(bdVar.field_content, bdVar.field_isSend, z);
                    com.tencent.mm.plugin.messenger.a.g.bcT().D(str, p, ab.XR(bd.a.YV(p).otZ) ? 66 : 42);
                }
            } else if (bdVar.cml() || bdVar.cmm()) {
                if (!j.ap(bdVar)) {
                    j.a(context, str, bdVar);
                }
            } else if (bdVar.aQo()) {
                j.c(context, str, bdVar, z);
            }
        }
    }

    public static void a(Context context, List<bd> list, boolean z, String str, ah ahVar) {
        cte();
        if (context == null) {
            x.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, context is null");
        } else if (list == null || list.isEmpty()) {
            x.w("MicroMsg.ChattingEditModeRetransmitMsg", "do retransmit fail, select item empty");
        } else if (j.a(list, ahVar)) {
            Object obj;
            if (list != null && !list.isEmpty()) {
                for (bd bdVar : list) {
                    String str2 = null;
                    if (!bdVar.cmu()) {
                        if (bdVar.ckA()) {
                            e eVar = null;
                            if (bdVar.field_msgId > 0) {
                                eVar = o.Pf().br(bdVar.field_msgId);
                            }
                            if ((eVar == null || eVar.dTK <= 0) && bdVar.field_msgSvrId > 0) {
                                eVar = o.Pf().bq(bdVar.field_msgSvrId);
                            }
                            if (eVar != null) {
                                str2 = o.Pf().o(com.tencent.mm.ak.f.c(eVar), "", "");
                            }
                        } else if (bdVar.cmk() || bdVar.cmj()) {
                            com.tencent.mm.modelvideo.o.Ta();
                            str2 = com.tencent.mm.modelvideo.s.nK(bdVar.field_imgPath);
                        } else if (bdVar.aQm()) {
                            a gp = a.gp(bdVar.field_content);
                            if (gp != null) {
                                b SZ = com.tencent.mm.pluginsdk.model.app.l.SZ(gp.bGP);
                                if (SZ != null) {
                                    str2 = SZ.field_fileFullPath;
                                }
                            }
                        } else {
                            str2 = bdVar.field_imgPath;
                        }
                        if (bdVar.ckA() || bdVar.cmj() || bdVar.cmk() || j.aC(bdVar)) {
                            obj = (System.currentTimeMillis() - bdVar.field_createTime <= 259200000 || (!bi.oW(str2) && com.tencent.mm.a.e.cn(str2))) ? null : 1;
                            if (obj == null) {
                            }
                        }
                        obj = null;
                        break;
                    }
                }
            } else {
                x.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
            }
            obj = 1;
            if (obj != null) {
                x.i("MicroMsg.ChattingEditModeRetransmitMsg", "slected msg is all expired or clean!!!");
                if (ahVar == null) {
                    return;
                }
                if (ahVar.cuh() || list.size() == 1) {
                    com.tencent.mm.ui.base.h.a(context, context.getString(R.l.expired_msg_warning), context.getString(R.l.app_tip), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                }
                return;
            }
            b(context, list, z, str, ahVar);
        } else {
            com.tencent.mm.ui.base.h.a(context, context.getString(R.l.invalid_friend_msg_warning), "", context.getString(R.l.app_send), context.getString(R.l.app_cancel), (OnClickListener) new 1(list, ahVar, context, z, str), null);
        }
    }

    private static void b(Context context, List<bd> list, boolean z, String str, ah ahVar) {
        if (j.dC(list)) {
            com.tencent.mm.ui.base.h.a(context, context.getString(R.l.contain_remuxing_msg), "", context.getString(R.l.I_known), new 3(ahVar));
            return;
        }
        bd bdVar;
        int i;
        for (bd bdVar2 : list) {
            if (bf.l(bdVar2)) {
                switch (bdVar2.getType() & 65535) {
                    case 1:
                        bdVar2.setContent(context.getString(R.l.app_text));
                        break;
                    case 3:
                        bdVar2.setContent(context.getString(R.l.app_pic));
                        bdVar2.setType(1);
                        break;
                    case a$i.AppCompatTheme_dialogPreferredPadding /*43*/:
                        bdVar2.setContent(context.getString(R.l.app_video));
                        bdVar2.setType(1);
                        break;
                    case a$i.AppCompatTheme_actionButtonStyle /*49*/:
                        bdVar2.setContent(context.getString(R.l.app_unknown_msg));
                        bdVar2.setType(1);
                        break;
                }
                bf.m(bdVar2);
            }
        }
        tIE.tIM = new LinkedList(list);
        tIE.tGg = z;
        tIE.tID = ahVar;
        tIE.bXS = str;
        Intent intent = new Intent(context, MsgRetransmitUI.class);
        if (list.size() == 1) {
            int i2;
            bdVar2 = (bd) list.get(0);
            if (bdVar2.aQm() || bdVar2.cky()) {
                String ic = u.ic(bdVar2.field_msgSvrId);
                u$b v = u.Hx().v(ic, true);
                v.p("prePublishId", "msg_" + bdVar2.field_msgSvrId);
                v.p("preUsername", com.tencent.mm.ui.chatting.viewitems.b.a(bdVar2, z, false));
                v.p("preChatName", bdVar2.field_talker);
                v.p("preMsgIndex", Integer.valueOf(0));
                v.p("sendAppMsgScene", Integer.valueOf(1));
                v.p("moreRetrAction", Boolean.valueOf(true));
                if (z) {
                    v.p("fromScene", Integer.valueOf(2));
                } else {
                    v.p("fromScene", Integer.valueOf(1));
                }
                ((com.tencent.mm.plugin.sns.b.i) g.l(com.tencent.mm.plugin.sns.b.i.class)).a("adExtStr", v, bdVar2);
                intent.putExtra("reportSessionId", ic);
            }
            String str2 = bdVar2.field_content;
            int i3 = 12;
            r nW;
            if (bdVar2.aQo()) {
                i3 = 9;
            } else if (bdVar2.cml()) {
                i3 = 5;
                intent.putExtra("Retr_File_Name", bdVar2.field_imgPath);
            } else if (bdVar2.cmi()) {
                i3 = 8;
            } else if (bdVar2.isText()) {
                i3 = 4;
                if (z && bdVar2.field_isSend == 0) {
                    str2 = com.tencent.mm.model.bd.iC(str2);
                }
            } else if (bdVar2.ckA()) {
                e eVar = null;
                if (bdVar2.field_msgId > 0) {
                    eVar = o.Pf().br(bdVar2.field_msgId);
                }
                if ((eVar == null || eVar.dTK <= 0) && bdVar2.field_msgSvrId > 0) {
                    eVar = o.Pf().bq(bdVar2.field_msgSvrId);
                }
                intent.putExtra("Retr_File_Name", o.Pf().o(com.tencent.mm.ak.f.c(eVar), "", ""));
                i3 = 0;
            } else if (bdVar2.cmk()) {
                nW = t.nW(bdVar2.field_imgPath);
                if (nW != null) {
                    intent.putExtra("Retr_length", nW.enM);
                }
                i3 = 11;
                intent.putExtra("Retr_File_Name", bdVar2.field_imgPath);
            } else if (bdVar2.cmj()) {
                nW = t.nW(bdVar2.field_imgPath);
                if (nW != null) {
                    intent.putExtra("Retr_length", nW.enM);
                }
                i3 = 1;
                intent.putExtra("Retr_File_Name", bdVar2.field_imgPath);
            } else if (bdVar2.aQm()) {
                a gp = a.gp(str2);
                if (gp != null && 19 == gp.type) {
                    i3 = 10;
                } else if (gp != null && 24 == gp.type) {
                    i3 = 10;
                } else if (gp == null || 16 != gp.type) {
                    i3 = 2;
                } else {
                    i3 = 14;
                }
                if (bdVar2.cky()) {
                    intent.putExtra("is_group_chat", z);
                }
            }
            if (bdVar2.cky()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            if (ahVar == null || ahVar.cuh()) {
                intent.putExtra("Retr_Msg_Type", i3);
            } else {
                intent.putExtra("Retr_Msg_Type", 13);
                intent.putExtra("Retr_Multi_Msg_List_from", str);
            }
            intent.putExtra("Retr_Msg_Id", bdVar2.field_msgId);
            intent.putExtra("Retr_Msg_content", str2);
            intent.putExtra("Edit_Mode_Sigle_Msg", true);
            i = i2;
        } else if ((ahVar == null || !ahVar.cuh()) && ((!s.hf(str) || f.eZ(str)) && !s.hP(str))) {
            intent.putExtra("Retr_Msg_Type", 13);
            intent.putExtra("Retr_Multi_Msg_List_from", str);
            i = 2;
        } else {
            intent.putExtra("Retr_Msg_Type", 12);
            i = 2;
        }
        intent.putExtra("Retr_MsgFromScene", i);
        intent.putExtra("Retr_show_success_tips", true);
        context.startActivity(intent);
        au.Em().H(new 1(tIE.tIM));
    }

    public static void j(Context context, String str, boolean z) {
        mw mwVar = new mw();
        mwVar.bXL.type = 5;
        mwVar.bXL.bXR = tIE.tIM;
        mwVar.bXL.toUser = str;
        mwVar.bXL.bXS = tIE.bXS;
        mwVar.bXL.context = context;
        mwVar.bXL.bXn = tIE.bXn;
        mwVar.bXL.bXU = tIE.tIN;
        com.tencent.mm.sdk.b.a.sFg.m(mwVar);
        if (tIE.tIM != null) {
            h.mEJ.h(10811, new Object[]{Integer.valueOf(8), Integer.valueOf(tIE.tIM.size()), Integer.valueOf(tIE.tIM.size() - j.dA(tIE.tIM))});
            for (bd bdVar : tIE.tIM) {
                long VE = bi.VE();
                a gp = a.gp(bi.WT(bdVar.field_content));
                if (!(gp == null || gp.type != 5 || bi.oW(gp.url))) {
                    int i;
                    if (bdVar.cky()) {
                        i = 1;
                    } else {
                        i = 2;
                    }
                    String str2 = "";
                    try {
                        str2 = URLEncoder.encode(gp.url, "UTF-8");
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ChattingEditModeRetransmitMsg", e, "", new Object[0]);
                    }
                    x.d("MicroMsg.ChattingEditModeRetransmitMsg", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), gp.url, Long.valueOf(VE), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1)});
                    h.mEJ.h(13378, new Object[]{str2, Long.valueOf(VE), Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(1)});
                }
            }
        }
        if (z && tIE.tID != null) {
            tIE.tID.b(ah.a.tMy);
        }
    }

    public static void lR(boolean z) {
        if (z && tIE.tID != null) {
            tIE.tID.b(ah.a.tMy);
        }
    }

    public static mw gL(Context context) {
        mw mwVar = new mw();
        mwVar.bXL.type = 6;
        mwVar.bXL.bXR = tIE.tIM;
        mwVar.bXL.bXS = tIE.bXS;
        mwVar.bXL.context = context;
        com.tencent.mm.sdk.b.a.sFg.m(mwVar);
        tIE.bXn = mwVar.bXM.bXn;
        tIE.tIN = mwVar.bXM.bXU;
        return mwVar;
    }

    public static void k(final Context context, final String str, final boolean z) {
        if (context == null) {
            x.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, context is null");
        } else if (bi.oW(str)) {
            x.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, username is empty");
        } else if (tIE.tIM == null || tIE.tIM.isEmpty()) {
            x.w("MicroMsg.ChattingEditModeRetransmitMsg", "do try retransmit fail, select items empty");
        } else {
            x.v("MicroMsg.ChattingEditModeRetransmitMsg", "post to do job, send to %s", new Object[]{str});
            com.tencent.mm.ui.chatting.b.j.tOP.c(new at.a() {
                final /* synthetic */ Runnable bzs = null;

                public final boolean Kr() {
                    if (k.tIE.tIM == null) {
                        return false;
                    }
                    for (bd d : k.tIE.tIM) {
                        k.d(context, str, d, k.tIE.tGg);
                    }
                    return true;
                }

                public final boolean Ks() {
                    if (k.tIE.tIM != null) {
                        h.mEJ.h(10811, new Object[]{Integer.valueOf(5), Integer.valueOf(k.tIE.tIM.size()), Integer.valueOf(k.tIE.tIM.size() - j.dA(k.tIE.tIM))});
                    }
                    if (z) {
                        if (this.bzs != null) {
                            x.v("MicroMsg.ChattingEditModeRetransmitMsg", "call back is not null, do call back");
                            this.bzs.run();
                        }
                        if (k.tIE.tID != null) {
                            k.tIE.tID.b(ah.a.tMy);
                        }
                        k.cte();
                    }
                    return true;
                }
            });
        }
    }

    public static void cte() {
        tIE.tIM = null;
        tIE.tGg = false;
        tIE.tID = null;
        tIE.bXS = null;
        tIE.bXn = null;
        tIE.tIN = null;
    }
}
