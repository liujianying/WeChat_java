package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.ar.f;
import com.tencent.mm.bt.h;
import com.tencent.mm.g.a.bc;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI;
import com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.pluginsdk.g.a.a.m;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.bnv;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.r;
import com.tencent.mm.storage.emotion.t;
import com.tencent.mm.storage.emotion.u;
import com.tencent.mm.storage.emotion.v;
import com.tencent.mm.y.g$a;
import com.tencent.recovery.util.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public final class g implements d {
    public final EmojiInfo zi(String str) {
        return i.aEA().igx.Zy(str);
    }

    public final EmojiInfo c(EmojiInfo emojiInfo) {
        if (emojiInfo.field_catalog == EmojiGroupInfo.tcz && emojiInfo.field_type == EmojiInfo.tcI && emojiInfo.getContent().length() > 0 && EmojiInfo.Dr(bi.getInt(emojiInfo.getContent(), 0))) {
            Cursor Du = i.aEA().igx.Du(bi.getInt(emojiInfo.getContent(), 0));
            if (Du != null && Du.getCount() > 1) {
                int eF = bi.eF(Du.getCount() - 1, 0);
                emojiInfo = new EmojiInfo();
                Du.moveToPosition(eF);
                emojiInfo.d(Du);
            }
            if (Du != null) {
                Du.close();
            }
        }
        return emojiInfo;
    }

    public final boolean a(Context context, EmojiInfo emojiInfo, int i, String str) {
        if (context == null) {
            x.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. context is null");
            return false;
        } else if (emojiInfo == null) {
            x.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. emoji is null");
            return false;
        } else {
            Intent intent = new Intent();
            intent.setClass(context, EmojiAddCustomDialogUI.class);
            intent.putExtra("extra_id", emojiInfo.Xh());
            intent.putExtra("extra_scence", i);
            intent.addFlags(65536);
            intent.putExtra("extra_username", str);
            context.startActivity(intent);
            return true;
        }
    }

    public final void a(Context context, bd bdVar) {
        if (context == null || bdVar == null) {
            x.w("MicroMsg.emoji.EmojiMgrImpl", "context or msg is null");
            return;
        }
        an YJ = an.YJ(bdVar.field_content);
        g$a gp = g$a.gp(bdVar.field_content);
        if (gp == null) {
            gp = new g$a();
            gp.dwq = YJ.bKg;
        }
        EmojiInfo Zy = i.aEA().igx.Zy(gp.dwq);
        long j;
        if (bdVar.field_isSend == 1) {
            if (Zy == null || !Zy.cnv()) {
                j = bdVar.field_msgId;
                c(gp);
                return;
            }
            a(context, gp.dwq, gp.appId, gp.appName, bdVar.field_msgSvrId, bdVar.field_talker, bdVar.field_content);
        } else if (Zy == null || !Zy.cnv()) {
            j = bdVar.field_msgId;
            c(gp);
        } else {
            a(context, Zy.Xh(), gp.appId, gp.appName, bdVar.field_msgSvrId, bdVar.field_talker, bdVar.field_content);
        }
    }

    public final boolean o(Context context, String str, String str2) {
        if (context == null) {
            x.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: context is null");
            return false;
        } else if (bi.oW(str) || bi.oW(str2)) {
            x.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: userName or imgPath is null");
            return false;
        } else {
            EmojiInfo Zy = i.aEA().igx.Zy(str2);
            if (Zy == null) {
                x.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: emoji not found, imgPath %s", new Object[]{str2});
                return false;
            }
            if (Zy.field_type == EmojiInfo.tcL || Zy.field_type == EmojiInfo.tcM) {
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                StringBuilder stringBuilder = new StringBuilder();
                au.HU();
                String stringBuilder2 = stringBuilder.append(c.Gg()).append(Zy.Xh()).toString();
                if (e.cn(stringBuilder2 + "_thumb")) {
                    wXMediaMessage.thumbData = e.e(stringBuilder2 + "_thumb", 0, e.cm(stringBuilder2 + "_thumb"));
                } else {
                    wXMediaMessage.setThumbImage(Zy.gi(context));
                }
                wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
                l.a(wXMediaMessage, Zy.field_app_id, null, str, 0, Zy.Xh());
            } else {
                EmojiInfo emojiInfo;
                if (Zy.field_type == EmojiInfo.tcI) {
                    Cursor Du = EmojiInfo.Dr(Zy.field_catalog) ? i.aEA().igx.Du(Zy.field_catalog) : (Zy.field_catalog == EmojiInfo.tcD && Zy.getContent().length() > 0 && EmojiInfo.Dr(bi.getInt(Zy.getContent(), 0))) ? i.aEA().igx.Du(bi.getInt(Zy.getContent(), 0)) : null;
                    if (Du != null) {
                        int eF = bi.eF(Du.getCount() - 1, 0);
                        emojiInfo = new EmojiInfo();
                        Du.moveToPosition(eF);
                        emojiInfo.d(Du);
                        Du.close();
                        i.aEu().a(str, emojiInfo, null);
                    }
                }
                emojiInfo = Zy;
                i.aEu().a(str, emojiInfo, null);
            }
            return true;
        }
    }

    public final void a(String str, EmojiInfo emojiInfo, bd bdVar) {
        if (emojiInfo != null || bdVar != null) {
            if (emojiInfo == null) {
                emojiInfo = i.aEA().igx.Zy(bdVar.field_imgPath);
            }
            i.aEu().a(str, emojiInfo, bdVar);
        }
    }

    private static void a(Context context, String str, String str2, String str3, long j, String str4, String str5) {
        if (str.equals("-1")) {
            x.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
            return;
        }
        EmojiInfo Zy = i.aEA().igx.Zy(str);
        if (Zy == null) {
            x.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
            return;
        }
        Intent intent = new Intent(context, CustomSmileyPreviewUI.class);
        intent.putExtra("custom_smiley_preview_md5", str);
        if (str2 != null) {
            intent.putExtra("custom_smiley_preview_appid", str2);
        } else {
            intent.putExtra("custom_smiley_preview_appid", Zy.field_app_id);
        }
        intent.putExtra("custom_smiley_preview_appname", str3);
        intent.putExtra("msg_id", j);
        intent.putExtra("msg_content", str5);
        if (s.fq(str4)) {
            str4 = com.tencent.mm.model.bd.iB(str5);
        }
        intent.putExtra("msg_sender", str4);
        context.startActivity(intent);
    }

    private static void c(g$a g_a) {
        i.aED();
        if (g_a == null) {
            x.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "msg content is null");
            return;
        }
        String str = g_a.dwq;
        if (bi.oW(str)) {
            x.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "md5 is null.");
            return;
        }
        EmojiInfo emojiInfo = new EmojiInfo();
        emojiInfo.field_md5 = str;
        emojiInfo.field_app_id = g_a.appId;
        emojiInfo.field_catalog = EmojiInfo.tcB;
        emojiInfo.field_size = g_a.dwo;
        emojiInfo.field_temp = 1;
        emojiInfo.field_state = EmojiInfo.tcR;
        i.aEA().igx.o(emojiInfo);
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        au.DF().a(new com.tencent.mm.plugin.emoji.f.e(linkedList), 0);
        com.tencent.mm.plugin.emoji.model.c.bi(str, 0);
        x.d("MicroMsg.emoji.EmojiAppMsgDownloadService", "start change cdn url. md5:%s", new Object[]{str});
    }

    public final ap cu(String str, String str2) {
        Map z = bl.z(str, "msg");
        if (z == null) {
            x.w("MicroMsg.emoji.EmojiMgrImpl", "get from xml, but attrs is null");
            return null;
        }
        ap a = ap.a(z, str2, str, "");
        if (a != null) {
            return a;
        }
        x.w("MicroMsg.emoji.EmojiMgrImpl", "parserEmojiXml error " + str);
        return null;
    }

    public final void d(EmojiInfo emojiInfo) {
        i.aEA().igx.p(emojiInfo);
    }

    public final String zj(String str) {
        return EmojiLogic.zj(str);
    }

    public final String a(Context context, WXMediaMessage wXMediaMessage, String str) {
        return EmojiLogic.b(context, wXMediaMessage, str);
    }

    public final boolean a(String str, String str2, long j, String str3, a aVar) {
        boolean z = false;
        com.tencent.mm.plugin.emoji.model.d aEu = i.aEu();
        x.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml " + str2);
        ap a = ap.a(bl.z(str2, "msg"), str, str2, str3);
        if (a == null) {
            x.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
        } else {
            a.bYu = j;
            x.i("MicroMsg.emoji.EmojiService", "summerbadcr prepareEmoji msgSvrId[%d], stack[%s]", new Object[]{Long.valueOf(j), bi.cjd()});
            aEu.zD(a.bKk);
            if (!EmojiLogic.zC(n.aEk())) {
                z = true;
            }
            aEu.a(a, aVar, z);
        }
        return true;
    }

    public final List<EmojiInfo> zk(String str) {
        au.HU();
        if (c.isSDCardAvailable()) {
            return (ArrayList) i.aEA().igx.zk(str);
        }
        return new ArrayList();
    }

    public final String Gq() {
        return com.tencent.mm.kernel.g.Ei().dqp;
    }

    public final String zf(String str) {
        return i.aEv().zf(str);
    }

    public final boolean zl(String str) {
        return i.aEA().igy.Zt(str);
    }

    public final ArrayList<String> zm(String str) {
        a aEv = i.aEv();
        if (!aEv.mInit) {
            aEv.aDI();
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        int abd = com.tencent.mm.ui.tools.g.abd(str);
        if (abd < aEv.ieL || abd > aEv.ieM) {
            x.d("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
            return null;
        }
        if (!(bi.oW(str) || aEv.ieQ == null)) {
            String toLowerCase = str.toLowerCase();
            ArrayList arrayList3 = new ArrayList();
            if (aEv.ieP.containsKey(toLowerCase)) {
                arrayList3.addAll((Collection) aEv.ieO.get(aEv.ieP.get(toLowerCase)));
            } else {
                arrayList3.add(toLowerCase);
            }
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                ArrayList arrayList4 = (ArrayList) aEv.ieQ.get((String) it.next());
                if (!(arrayList4 == null || arrayList4.isEmpty())) {
                    arrayList.addAll(arrayList4);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList, aEv.ieR);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList2.add(((a.a) arrayList.get(i)).bKg);
            }
        }
        x.d("MicroMsg.emoji.EmojiDescNewMgr", "cpan[check desc]User time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return arrayList2;
    }

    public final String zn(String str) {
        return EmojiLogic.zn(str);
    }

    public final String zo(String str) {
        return EmojiLogic.zo(str);
    }

    public final int zp(String str) {
        return EmojiLogic.zp(str);
    }

    public final String zq(String str) {
        return EmojiLogic.zq(str);
    }

    public final int e(EmojiInfo emojiInfo) {
        if (emojiInfo != null) {
            if (emojiInfo.field_catalog == EmojiInfo.tcF || String.valueOf(EmojiInfo.tcF).equals(emojiInfo.field_groupId)) {
                return R.g.jsb;
            }
            if (emojiInfo.field_catalog == EmojiInfo.tcG || String.valueOf(EmojiInfo.tcG).equals(emojiInfo.field_groupId)) {
                return R.g.dice;
            }
        }
        return 0;
    }

    public final int[] f(EmojiInfo emojiInfo) {
        if (emojiInfo != null) {
            if (emojiInfo.field_catalog == EmojiInfo.tcF) {
                return new int[]{R.g.jsb_j, R.g.jsb_s, R.g.jsb_b};
            } else if (emojiInfo.field_catalog == EmojiInfo.tcG) {
                return new int[]{R.g.dice_action_0, R.g.dice_action_1, R.g.dice_action_2, R.g.dice_action_3};
            }
        }
        return null;
    }

    public final byte[] a(EmojiInfo emojiInfo) {
        return e.aDM().a(emojiInfo);
    }

    public final void onDestroy() {
    }

    public final boolean aDP() {
        return n.aEi();
    }

    public final ArrayList<q> aDQ() {
        return i.aEA().igF.aDQ();
    }

    public final ArrayList<String> aDR() {
        return i.aEA().igF.aDR();
    }

    public final ArrayList<com.tencent.mm.storage.emotion.s> aDS() {
        return i.aEA().igG.aDS();
    }

    public final boolean p(ArrayList<q> arrayList) {
        r rVar = i.aEA().igF;
        if (arrayList.size() <= 0) {
            x.i("MicroMsg.emoji.NewSmileyInfoStorage", "insertSmileyInfoList failed. list is null.");
        } else {
            long dO;
            h hVar;
            if (rVar.diF instanceof h) {
                h hVar2 = (h) rVar.diF;
                dO = hVar2.dO(Thread.currentThread().getId());
                hVar = hVar2;
            } else {
                dO = -1;
                hVar = null;
            }
            rVar.diF.delete("SmileyInfo", null, null);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                rVar.b((q) it.next());
            }
            int i = -1;
            if (hVar != null) {
                i = hVar.gp(dO);
            }
            if (i >= 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean q(ArrayList<com.tencent.mm.storage.emotion.s> arrayList) {
        t tVar = i.aEA().igG;
        if (arrayList.size() <= 0) {
            x.i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList failed. list is null.");
        } else {
            long dO;
            h hVar;
            if (tVar.diF instanceof h) {
                h hVar2 = (h) tVar.diF;
                dO = hVar2.dO(Thread.currentThread().getId());
                hVar = hVar2;
            } else {
                dO = -1;
                hVar = null;
            }
            tVar.diF.delete("SmileyPanelConfigInfo", null, null);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                tVar.b((com.tencent.mm.storage.emotion.s) it.next());
            }
            int i = -1;
            if (hVar != null) {
                i = hVar.gp(dO);
            }
            if (i >= 0) {
                return true;
            }
        }
        return false;
    }

    public final String cv(String str, String str2) {
        au.HU();
        return EmojiLogic.L(c.Gg(), str, str2);
    }

    public final f aDT() {
        return i.aEd().aDT();
    }

    public final void zr(String str) {
        if (bi.oW(str)) {
            x.i("MicroMsg.emoji.EmojiCommandMgr", "emoji command is null.");
        }
        if ("sync".equalsIgnoreCase(str)) {
            au.HU();
            c.DT().a(aa.a.sOT, Boolean.valueOf(true));
            au.HU();
            c.DT().a(aa.a.sOY, Boolean.valueOf(true));
            au.HU();
            c.DT().a(aa.a.sPb, Long.valueOf(0));
            au.HU();
            c.DT().a(aa.a.sOS, Long.valueOf(0));
            au.DF().a(new com.tencent.mm.plugin.emoji.f.e(), 0);
            au.DF().a(new n(8, null, 15, true), 0);
        } else if ("rcheart".equalsIgnoreCase(str)) {
            i.aEA().igy.cnu();
        } else if ("recover".equalsIgnoreCase(str)) {
            x.i("MicroMsg.emoji.EmojiCommandMgr", "recover   begin");
            i.aEA().igx.gg(ad.getContext());
            i.aEA().igy.gg(ad.getContext());
            x.i("MicroMsg.emoji.EmojiCommandMgr", "recover   end");
        } else if ("clean".equalsIgnoreCase(str)) {
            x.i("MicroMsg.emoji.EmojiCommandMgr", "begin clean");
            d aDL = d.aDL();
            au.HU();
            aDL.zh(c.Gg());
            au.HU();
            c.DT().a(aa.a.sOY, Boolean.valueOf(true));
            x.i("MicroMsg.emoji.EmojiCommandMgr", "end clean");
        } else if ("dump".equalsIgnoreCase(str)) {
            x.i("MicroMsg.emoji.EmojiCommandMgr", "begin dump emoji db info:");
            ArrayList arrayList = (ArrayList) i.aEA().igy.cng();
            if (arrayList.size() > 0) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) arrayList.get(i);
                    x.i("MicroMsg.emoji.EmojiCommandMgr", "i:%d group info:%s", new Object[]{Integer.valueOf(i), emojiGroupInfo.toString()});
                }
            }
            Cursor cursor = null;
            try {
                cursor = i.aEA().igx.axc();
                if (cursor == null || !cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    x.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
                }
                do {
                    new EmojiInfo().d(cursor);
                    x.i("MicroMsg.emoji.EmojiCommandMgr", "emoji info:%s", new Object[]{r1.toString()});
                } while (cursor.moveToNext());
                if (cursor != null) {
                    cursor.close();
                }
                x.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
            } catch (Exception e) {
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } else if ("config".equalsIgnoreCase(str)) {
            b$c.qCd.e(37, 1, -1, false);
            b$c.qCd.e(37, 2, -1, false);
            au.HU();
            c.DT().a(aa.a.sPi, Integer.valueOf(0));
            au.HU();
            c.DT().a(aa.a.sPj, Integer.valueOf(0));
            au.HU();
            c.DT().a(aa.a.sPl, Integer.valueOf(0));
            au.DF().a(new m(37), 0);
            bc bcVar = new bc();
            bcVar.bIB.filePath = com.tencent.mm.compatible.util.e.bnE + "CheckResUpdate/37.1.data.decompressed";
            bcVar.bIB.bIC = 37;
            bcVar.bIB.bID = 1;
            bc bcVar2 = new bc();
            bcVar2.bIB.filePath = com.tencent.mm.compatible.util.e.bnE + "CheckResUpdate/37.2.data.decompressed";
            bcVar2.bIB.bIC = 37;
            bcVar2.bIB.bID = 2;
            i.aEd();
            i.a(bcVar, true);
            i.aEd();
            i.b(bcVar2, true);
        } else if ("tuzki".equalsIgnoreCase(str)) {
            com.tencent.mm.plugin.emoji.f.a.aEF();
            com.tencent.mm.plugin.emoji.f.a.aEG();
        }
    }

    public final bnv aDU() {
        return i.aEA().igA.aDU();
    }

    public final void a(bnv bnv) {
        i.aEA().igA.b(bnv);
    }

    public final int aDV() {
        return i.aEA().igx.ln(true);
    }

    public final int zs(String str) {
        return i.aEA().igx.zs(str);
    }

    public final boolean a(EmojiGroupInfo emojiGroupInfo) {
        return i.aEA().igy.c(emojiGroupInfo, new String[]{"productID"});
    }

    public final ArrayList<EmojiGroupInfo> aDW() {
        return i.aEA().aDW();
    }

    public final int aDX() {
        return i.aEA().aDX();
    }

    public final ArrayList<EmojiInfo> aDY() {
        return i.aEA().aDY();
    }

    public final ArrayList<EmojiInfo> zt(String str) {
        l aEA = i.aEA();
        if (l.igO == null) {
            l.igO = new HashMap();
        }
        if (l.igL) {
            l.igO.clear();
            l.igL = false;
        }
        if (!l.igO.containsKey(str)) {
            au.HU();
            if (c.isSDCardAvailable()) {
                l.igO.put(str, (ArrayList) aEA.igx.zk(str));
            }
        }
        return (ArrayList) l.igO.get(str);
    }

    public final com.tencent.mm.ak.a.a aDZ() {
        return i.aDZ();
    }

    public final void g(j.a aVar) {
        i.aEA().igx.d(aVar);
    }

    public final void h(j.a aVar) {
        i.aEA().igx.c(aVar);
    }

    public final void i(j.a aVar) {
        i.aEA().igy.d(aVar);
    }

    public final void j(j.a aVar) {
        if (((com.tencent.mm.kernel.b.h) com.tencent.mm.kernel.g.Ef().DM()).ES()) {
            i.aEA().igy.c(aVar);
        }
    }

    public final boolean aEa() {
        return n.aEn();
    }

    public final void bg(String str, int i) {
        v vVar = i.aEA().igI;
        if (!Util.oW(str)) {
            if (vVar.tdh == null) {
                vVar.cnP();
            }
            u uVar = (u) vVar.tdh.get(str);
            if (uVar == null) {
                uVar = new u();
                uVar.aAL = str;
                vVar.tdh.put(str, uVar);
            }
            uVar.position = i;
            uVar.tdg++;
            uVar.dDj = System.currentTimeMillis();
            String str2 = "event_update_recent";
            if (vVar.tdh == null) {
                vVar.cnP();
            }
            vVar.b(str2, 0, Integer.valueOf(vVar.tdh.size()));
        }
    }

    public final List<u> aEb() {
        return i.aEA().igI.aEb();
    }

    public final void aEc() {
        v vVar = i.aEA().igI;
        List<u> aEb = vVar.aEb();
        JSONArray jSONArray = new JSONArray();
        for (u uVar : aEb) {
            if (uVar.bpY() != null) {
                jSONArray.put(uVar.bpY());
                if (jSONArray.length() >= 9) {
                    break;
                }
            }
        }
        com.tencent.mm.kernel.g.Ei().DT().a(aa.a.tae, jSONArray.toString());
        vVar.tdh = null;
    }

    public final void k(j.a aVar) {
        i.aEA().igI.c(aVar);
    }

    public final void l(j.a aVar) {
        i.aEA().igI.d(aVar);
    }
}
