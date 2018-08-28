package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import com.tencent.mm.ac.z;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.y.g.a;
import com.tencent.mm.y.i;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class j {
    public static boolean ap(bd bdVar) {
        if (bdVar == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "check is store emoji error, msg is null");
            return true;
        }
        EmojiInfo zi;
        if (bdVar.cmm()) {
            a aVar;
            an anVar = new an(bdVar.field_content);
            a J = a.J(bdVar.field_content, bdVar.field_reserved);
            if (J == null) {
                J = new a();
                J.dwq = anVar.bKg;
                aVar = J;
            } else {
                aVar = J;
            }
            zi = ((c) g.n(c.class)).getEmojiMgr().zi(aVar.dwq);
        } else {
            zi = ((c) g.n(c.class)).getEmojiMgr().zi(bdVar.field_imgPath);
        }
        if (zi != null && (zi.field_catalog == EmojiInfo.tcH || (!bi.oW(zi.field_groupId) && ((c) g.n(c.class)).getEmojiMgr().zl(zi.field_groupId)))) {
            return false;
        }
        if (zi == null || !zi.cnA()) {
            return false;
        }
        return true;
    }

    public static boolean aq(bd bdVar) {
        if (bdVar.cmm()) {
            a aVar;
            an anVar = new an(bdVar.field_content);
            a J = a.J(bdVar.field_content, bdVar.field_reserved);
            if (J == null) {
                J = new a();
                J.dwq = anVar.bKg;
                aVar = J;
            } else {
                aVar = J;
            }
            if (((c) g.n(c.class)).getEmojiMgr().zi(aVar.dwq) == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean ar(bd bdVar) {
        if (bdVar == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "check is game msg error, msg is null");
            return true;
        }
        String iC;
        if (bdVar.field_isSend == 0) {
            iC = com.tencent.mm.model.bd.iC(bdVar.field_content);
        } else {
            iC = bdVar.field_content;
        }
        a gp = a.gp(iC);
        if (gp == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "parse app message content fail");
            return false;
        }
        f bl = com.tencent.mm.pluginsdk.model.app.g.bl(gp.appId, false);
        return bl != null && bl.aaq();
    }

    public static boolean as(bd bdVar) {
        return bdVar.getType() == 419430449;
    }

    public static boolean at(bd bdVar) {
        return bdVar.getType() == 436207665 || bdVar.getType() == 469762097;
    }

    public static boolean au(bd bdVar) {
        if (bdVar == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, check msg error, msg is null");
            return true;
        }
        String iC;
        if (bdVar.field_isSend == 0) {
            iC = com.tencent.mm.model.bd.iC(bdVar.field_content);
        } else {
            iC = bdVar.field_content;
        }
        a gp = a.gp(iC);
        if (gp != null) {
            return gp.type == 33 && gp.dyU == 3;
        } else {
            x.w("MicroMsg.ChattingEditModeLogic", "isAppbrandForbidForwardMsg, parse app message content fail");
            return false;
        }
    }

    public static boolean dz(List<bd> list) {
        if (list == null || list.isEmpty()) {
            x.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to brand msg error, selected item empty");
            return true;
        }
        for (bd bdVar : list) {
            if (bdVar.ckz() || ap(bdVar) || bdVar.cmi() || ar(bdVar) || as(bdVar) || bdVar.getType() == -1879048186 || az(bdVar) || at(bdVar) || ay(bdVar) || au(bdVar)) {
                return true;
            }
            if (aC(bdVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(List<bd> list, ah ahVar) {
        boolean z = true;
        bd bdVar;
        if (list == null || list.isEmpty()) {
            x.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to friend msg error, select item empty");
            return false;
        } else if (list.size() == 1 && ahVar != null && ahVar.cuh()) {
            bdVar = (bd) list.get(0);
            if (aA(bdVar) || bdVar.ckz() || ap(bdVar) || ar(bdVar) || as(bdVar) || bdVar.getType() == -1879048186 || bdVar.getType() == 318767153 || az(bdVar) || at(bdVar) || aB(bdVar) || ay(bdVar) || au(bdVar)) {
                return false;
            }
            return true;
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                boolean z2;
                bdVar = (bd) it.next();
                if (ahVar == null || !ahVar.cuh()) {
                    if (av(bdVar) || aw(bdVar)) {
                        it.remove();
                        z2 = false;
                    }
                    z2 = z;
                } else {
                    if (bdVar.ckz() || ap(bdVar) || ar(bdVar) || as(bdVar) || bdVar.getType() == -1879048186 || az(bdVar) || at(bdVar) || ((av(bdVar) && (ahVar == null || !ahVar.cuh())) || ((aw(bdVar) && (ahVar == null || !ahVar.cuh())) || bdVar.getType() == 318767153 || aA(bdVar) || aB(bdVar) || ay(bdVar) || au(bdVar)))) {
                        it.remove();
                        z = false;
                    }
                    z2 = z;
                }
                z = z2;
            }
            return z;
        }
    }

    private static boolean av(bd bdVar) {
        if (bdVar != null) {
            a gp = a.gp(bdVar.field_content);
            if (gp != null && gp.type == 19) {
                mw mwVar = new mw();
                mwVar.bXL.type = 0;
                mwVar.bXL.bXN = gp.dwW;
                com.tencent.mm.sdk.b.a.sFg.m(mwVar);
                com.tencent.mm.protocal.b.a.c cVar = mwVar.bXM.bXV;
                if (cVar != null) {
                    Iterator it = cVar.dzs.iterator();
                    while (it.hasNext()) {
                        if (!bi.oW(((vx) it.next()).rAG)) {
                            x.e("MicroMsg.ChattingEditModeLogic", "record type subDataItem contain tpurl, type:%d", new Object[]{Integer.valueOf(((vx) it.next()).bjS)});
                            return true;
                        }
                    }
                }
                return gp.dwW != null && gp.dwW.contains("<recordxml>");
            }
        }
        return false;
    }

    private static boolean aw(bd bdVar) {
        if (bdVar != null) {
            a gp = a.gp(bdVar.field_content);
            if (gp != null && gp.type == 24) {
                return true;
            }
        }
        return false;
    }

    public static boolean ax(bd bdVar) {
        if (bdVar == null) {
            return false;
        }
        a gp = a.gp(bdVar.field_content);
        if (gp == null) {
            return false;
        }
        if (gp.type == 6 || gp.type == 5 || gp.type == 19) {
            return true;
        }
        return false;
    }

    public static boolean ay(bd bdVar) {
        if (bdVar == null || !bdVar.cky()) {
            return false;
        }
        return i.gu(bdVar.field_content);
    }

    static boolean az(bd bdVar) {
        if (bdVar != null) {
            a gp = a.gp(bdVar.field_content);
            if (gp != null && gp.type == 16) {
                return true;
            }
            if (gp != null && gp.type == 34) {
                return true;
            }
        }
        return false;
    }

    static boolean aA(bd bdVar) {
        if (!bdVar.cmi()) {
            return false;
        }
        au.HU();
        bd.a GR = com.tencent.mm.model.c.FT().GR(bdVar.field_content);
        if (GR == null || bi.oW(GR.otZ)) {
            return true;
        }
        if (s.hf(GR.otZ)) {
            return false;
        }
        return true;
    }

    private static boolean aB(bd bdVar) {
        if (bdVar != null && bdVar.aQm()) {
            a gp = a.gp(bdVar.field_content);
            if (gp != null && gp.type == 6 && (gp.dws != 0 || gp.dwo > 26214400)) {
                return true;
            }
        }
        return false;
    }

    public static boolean aC(bd bdVar) {
        if (bdVar != null && bdVar.aQm()) {
            a gp = a.gp(bdVar.field_content);
            if (gp != null && gp.type == 6) {
                return true;
            }
        }
        return false;
    }

    public static int dA(List<bd> list) {
        int i = 0;
        if (list == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "get invalid send to friend msg num error, select item empty");
            return 0;
        }
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            bd bdVar = (bd) it.next();
            if (bdVar.ckz() || ap(bdVar) || bdVar.aQo() || ar(bdVar) || as(bdVar) || at(bdVar)) {
                i = i2 + 1;
            } else {
                i = i2;
            }
        }
    }

    public static boolean dB(List<bd> list) {
        if (list == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "check contain undownload file, select item empty");
            return false;
        }
        for (bd bdVar : list) {
            r nI;
            if (bdVar.ckA() || bdVar.cmo()) {
                e bq;
                e eVar = null;
                if (bdVar.field_msgId > 0) {
                    eVar = o.Pf().br(bdVar.field_msgId);
                }
                if ((eVar == null || eVar.dTK <= 0) && bdVar.field_msgSvrId > 0) {
                    bq = o.Pf().bq(bdVar.field_msgSvrId);
                } else {
                    bq = eVar;
                }
                if (bq != null && (bq.offset < bq.dHI || bq.dHI == 0)) {
                    return true;
                }
            } else if (bdVar.cmj()) {
                nI = com.tencent.mm.modelvideo.o.Ta().nI(bdVar.field_imgPath);
                if (!(nI == null || nI.status == 199 || nI.status == 199)) {
                    return true;
                }
            } else if (bdVar.cmm()) {
                if (!aq(bdVar)) {
                    return true;
                }
            } else if (bdVar.aQm()) {
                a J = a.J(bdVar.field_content, bdVar.field_content);
                if (J != null) {
                    switch (J.type) {
                        case 6:
                            b SR = ao.asF().SR(J.bGP);
                            if (SR != null) {
                                if (new File(SR.field_fileFullPath).exists()) {
                                    break;
                                }
                                return true;
                            }
                            return true;
                        default:
                            break;
                    }
                }
                return true;
            } else if (bdVar.cmk()) {
                nI = t.nW(bdVar.field_imgPath);
                if (!(nI == null || nI.status == 199 || nI.status == 199)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public static boolean dC(List<bd> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (bd bdVar : list) {
            if (bdVar.cmj() && com.tencent.mm.pluginsdk.model.j.SN(bdVar.field_imgPath)) {
                return true;
            }
        }
        return false;
    }

    public static boolean dD(List<bd> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (bd cmk : list) {
            if (cmk.cmk()) {
                return true;
            }
        }
        return false;
    }

    public static String p(String str, int i, boolean z) {
        if (z && str != null && i == 0) {
            return com.tencent.mm.model.bd.iC(str);
        }
        return str;
    }

    public static List<String> ctc() {
        String str;
        List<String> hw = z.MY().hw(25);
        com.tencent.mm.ac.e MY = z.MY();
        List<String> arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.ac.e.a(stringBuilder);
        com.tencent.mm.ac.e.c(stringBuilder);
        com.tencent.mm.ac.e.d(stringBuilder);
        com.tencent.mm.ac.e.a(stringBuilder, true);
        stringBuilder.append(" order by ");
        stringBuilder.append(com.tencent.mm.ac.e.MD());
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatLst sql %s", new Object[]{stringBuilder.toString()});
        Cursor rawQuery = MY.rawQuery(r3, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        HashMap hashMap = new HashMap();
        for (String str2 : arrayList) {
            String Mg = com.tencent.mm.ac.f.kH(str2).Mg();
            if (!bi.oW(Mg)) {
                hashMap.put(Mg, str2);
            }
        }
        List<String> linkedList = new LinkedList();
        Collection linkedList2 = new LinkedList();
        for (String str22 : hw) {
            if (!com.tencent.mm.ac.f.kK(str22)) {
                linkedList.add(str22);
            } else if (com.tencent.mm.ac.f.kO(str22)) {
                str22 = com.tencent.mm.ac.f.kH(str22).field_enterpriseFather;
                if (!linkedList2.contains(str22) && com.tencent.mm.ac.f.kM(str22)) {
                    linkedList2.add(str22);
                    str22 = (String) hashMap.get(str22);
                    if (!bi.oW(str22)) {
                        linkedList2.add(str22);
                    }
                }
            }
        }
        for (String str222 : hashMap.values()) {
            if (!(bi.oW(str222) || linkedList2.contains(str222))) {
                linkedList2.add(str222);
            }
        }
        linkedList.addAll(linkedList2);
        x.d("MicroMsg.ChattingEditModeLogic", "get selected accept list, size %d", new Object[]{Integer.valueOf(linkedList.size())});
        return linkedList;
    }

    public static List<String> ctd() {
        List<String> hw = z.MY().hw(25);
        List<String> linkedList = new LinkedList();
        for (String str : hw) {
            if (!com.tencent.mm.ac.f.kK(str)) {
                linkedList.add(str);
            }
        }
        x.d("MicroMsg.ChattingEditModeLogic", "get selected accept list without enterprise, size %d", new Object[]{Integer.valueOf(linkedList.size())});
        return linkedList;
    }

    static boolean a(Context context, String str, bd bdVar, String str2) {
        if (context == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "send %s fail, context is null", new Object[]{str2});
            return false;
        } else if (bi.oW(str)) {
            x.w("MicroMsg.ChattingEditModeLogic", "send %s fail, username is null", new Object[]{str2});
            return false;
        } else if (bdVar != null) {
            return true;
        } else {
            x.w("MicroMsg.ChattingEditModeLogic", "send %s fail, msg is null", new Object[]{str2});
            return false;
        }
    }

    public static void a(Context context, String str, bd bdVar) {
        if (a(context, str, bdVar, "emoji")) {
            String str2;
            String str3 = an.YJ(bdVar.field_content).bKg;
            if (str3 == null || str3.endsWith("-1")) {
                str2 = bdVar.field_imgPath;
            } else {
                str2 = str3;
            }
            if (str2 == null) {
                x.w("MicroMsg.ChattingEditModeLogic", "showAcceptEmojiConnector: filePath is null");
            } else {
                ((c) g.n(c.class)).getEmojiMgr().o(context, str, str2);
            }
        }
    }

    public static void b(Context context, String str, bd bdVar) {
        if (a(context, str, bdVar, "image")) {
            e bq;
            e eVar = null;
            if (bdVar.field_msgId > 0) {
                eVar = o.Pf().br(bdVar.field_msgId);
            }
            if ((eVar == null || eVar.dTK <= 0) && bdVar.field_msgSvrId > 0) {
                bq = o.Pf().bq(bdVar.field_msgSvrId);
            } else {
                bq = eVar;
            }
            if (bq != null) {
                int i = 0;
                if (bq.ON() && !com.tencent.mm.ak.f.a(bq).dTL.startsWith("SERVERID://")) {
                    i = 1;
                }
                String o = o.Pf().o(com.tencent.mm.ak.f.c(bq), "", "");
                String o2 = o.Pf().o(bq.dTN, "th_", "");
                if (!bi.oW(o)) {
                    com.tencent.mm.plugin.messenger.a.g.bcT().a(context, str, o, i, bq.dTV, o2);
                }
            }
        }
    }

    public static void c(Context context, String str, bd bdVar) {
        if (a(context, str, bdVar, "video") && bdVar != null) {
            if (bdVar == null || !bdVar.cmk() || !t.nY(bdVar.field_imgPath)) {
                r nW = t.nW(bdVar.field_imgPath);
                String str2 = bdVar.field_imgPath;
                int i = nW.enQ;
                int i2 = nW.enM;
                String Tm = nW.Tm();
                int type = bdVar.getType();
                x.d("MicroMsg.ChattingEditModeLogic", "copy video fileName %s userName %s export %d videoLength %d", new Object[]{str2, str, Integer.valueOf(i), Integer.valueOf(i2)});
                String nJ = com.tencent.mm.modelvideo.s.nJ(q.GF());
                com.tencent.mm.modelvideo.o.Ta();
                x.d("MicroMsg.ChattingEditModeLogic", "copy video: srcFullPath[%s] destFullPath[%s] srcThumbPath[%s] destThumbPath[%s]", new Object[]{com.tencent.mm.modelvideo.s.nK(str2), com.tencent.mm.modelvideo.s.nK(nJ), com.tencent.mm.modelvideo.s.nL(str2), com.tencent.mm.modelvideo.s.nL(nJ)});
                com.tencent.mm.sdk.platformtools.j.q(r3, r7, false);
                com.tencent.mm.sdk.platformtools.j.q(str2, r8, false);
                t.a(nJ, i2, str, null, i, Tm, type);
                t.nR(nJ);
            }
        }
    }

    public static void a(Context context, String str, bd bdVar, boolean z) {
        if (a(context, str, bdVar, "text")) {
            String p = p(bdVar.field_content, bdVar.field_isSend, z);
            if (bdVar.cmy()) {
                p = p + "\n\n" + p(bdVar.field_transContent, bdVar.field_isSend, z);
            }
            if (p == null || p.equals("")) {
                x.e("MicroMsg.ChattingEditModeLogic", "Transfer text erro: content null");
            } else {
                com.tencent.mm.plugin.messenger.a.g.bcT().D(str, p, s.hQ(str));
            }
        }
    }

    public static void b(Context context, String str, bd bdVar, boolean z) {
        if (!a(context, str, bdVar, "appmsg")) {
            return;
        }
        if (context == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: context is null");
        } else if (bdVar == null) {
            x.w("MicroMsg.ChattingEditModeLogic", "getReaderAppMsgContent: msg is null");
        } else {
            au.HU();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                String str2;
                String d = o.Pf().d(bdVar.field_imgPath, false, false);
                if (ai.oW(d) || d.endsWith("hd") || !FileOp.cn(d + "hd")) {
                    str2 = d;
                } else {
                    str2 = d + "hd";
                }
                try {
                    l wS = ((com.tencent.mm.plugin.biz.a.a) g.l(com.tencent.mm.plugin.biz.a.a.class)).wS(bdVar.field_content);
                    List<m> list = wS.dzs;
                    if (list == null || list.size() <= 0) {
                        if (bdVar == null || !(bdVar.aQm() || bdVar.cky())) {
                            d = null;
                        } else {
                            String ic = u.ic(bdVar.field_msgSvrId);
                            u.b v = u.Hx().v(ic, true);
                            v.p("prePublishId", "msg_" + bdVar.field_msgSvrId);
                            v.p("preUsername", com.tencent.mm.ui.chatting.viewitems.b.a(bdVar, z, false));
                            v.p("preChatName", bdVar.field_talker);
                            v.p("preMsgIndex", Integer.valueOf(0));
                            v.p("sendAppMsgScene", Integer.valueOf(1));
                            ((com.tencent.mm.plugin.sns.b.i) g.l(com.tencent.mm.plugin.sns.b.i.class)).a("adExtStr", v, bdVar);
                            d = ic;
                        }
                        com.tencent.mm.plugin.messenger.a.g.bcT().a(str, bi.readFromFile(str2), bi.WT(bdVar.field_content), d);
                        return;
                    }
                    for (m mVar : list) {
                        a aVar = new a();
                        if (i.gr(mVar.dzD)) {
                            l.b(str, l.a(str, mVar), mVar.dzI);
                        } else {
                            aVar.title = mVar.title;
                            aVar.description = mVar.dzA;
                            aVar.action = "view";
                            aVar.type = 5;
                            aVar.url = mVar.url;
                            aVar.bZG = wS.bZG;
                            aVar.bZH = wS.bZH;
                            aVar.cGB = wS.cGB;
                            aVar.thumburl = mVar.dzy;
                            if (bi.oW(aVar.thumburl) && !bi.oW(aVar.bZG)) {
                                com.tencent.mm.aa.j kc = com.tencent.mm.aa.q.KH().kc(aVar.bZG);
                                if (kc != null) {
                                    aVar.thumburl = kc.Kx();
                                }
                            }
                            com.tencent.mm.plugin.messenger.a.g.bcT().a(str, bi.readFromFile(str2), bi.WT(a.a(aVar, null, null)), null);
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
                    x.e("MicroMsg.ChattingEditModeLogic", "send app msg error : %s", new Object[]{e.getLocalizedMessage()});
                }
            }
        }
    }

    public static void c(Context context, String str, bd bdVar, boolean z) {
        if (a(context, str, bdVar, "location")) {
            com.tencent.mm.plugin.messenger.a.g.bcT().D(str, p(bdVar.field_content, bdVar.field_isSend, z), 48);
        }
    }

    public static void a(Context context, String str, String str2, int i, boolean z) {
        try {
            bd bdVar = new bd();
            bdVar.setContent(str2);
            bdVar.eX(i);
            int indexOf = str2.indexOf("<msg>");
            if (indexOf > 0 && indexOf < str2.length()) {
                str2 = str2.substring(indexOf).trim();
            }
            Map z2 = bl.z(str2, "msg");
            if (z2 != null && z2.size() > 0) {
                bdVar.er(ay.au(z2));
            }
            b(context, str, bdVar, z);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
            x.e("MicroMsg.ChattingEditModeLogic", "retransmit sigle app msg error : %s", new Object[]{e.getLocalizedMessage()});
        }
    }

    public static void b(EmojiInfo emojiInfo, String str) {
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        StringBuilder stringBuilder = new StringBuilder();
        au.HU();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.Gg()).append(emojiInfo.Xh()).toString();
        if (com.tencent.mm.a.e.cm(stringBuilder2 + "_thumb") > 0) {
            wXMediaMessage.thumbData = com.tencent.mm.a.e.e(stringBuilder2 + "_thumb", 0, com.tencent.mm.a.e.cm(stringBuilder2 + "_thumb"));
        } else {
            try {
                InputStream fileInputStream = new FileInputStream(stringBuilder2);
                wXMediaMessage.setThumbImage(BackwardSupportUtil.b.a(fileInputStream, 1.0f));
                fileInputStream.close();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ChattingEditModeLogic", e, "", new Object[0]);
                x.e("MicroMsg.ChattingEditModeLogic", "sendAppMsgEmoji Fail cause there is no thumb");
            }
        }
        wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
        com.tencent.mm.pluginsdk.model.app.l.a(wXMediaMessage, emojiInfo.field_app_id, null, str, 1, emojiInfo.Xh());
    }
}
