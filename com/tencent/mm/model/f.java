package com.tencent.mm.model;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Looper;
import android.util.Base64;
import com.tencent.mm.R;
import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.ab.d.c;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.z;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.g.a.ia;
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.a.mm;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.k.g;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.constants.ConstantsAPI$AppSupportContentFlag;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.aj;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.protocal.c.axa;
import com.tencent.mm.protocal.c.axb;
import com.tencent.mm.protocal.c.axc;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.protocal.y;
import com.tencent.mm.r.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.bd;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class f implements m {
    private long dAw = -1;
    public a dAx;

    public interface a {
        void cX(String str);
    }

    public final b a(String str, Map<String, String> map, com.tencent.mm.ab.d.a aVar) {
        d ba;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int i;
        ai Yq;
        long j;
        bd bdVar;
        int i2;
        b bVar;
        by byVar = aVar.dIN;
        String a = ab.a(byVar.rcl);
        b bVar2 = null;
        if (str != null) {
            if (str.equals("addcontact")) {
                byVar.rcl = ab.oT((String) map.get(".sysmsg.addcontact.content"));
                byVar.jQd = 1;
                ba = c.ba(Integer.valueOf(1));
                bVar2 = ba == null ? null : ba.b(aVar);
            }
        }
        if (str != null) {
            if (str.equals("dynacfg")) {
                g.AT().a(a, map, false);
                g.AU();
                if (com.tencent.mm.k.c.AF() == 2) {
                    h.mEJ.k(10879, "");
                }
                x.d("MicroMsg.BigBallSysCmdMsgConsumer", "Mute_Room_Disable:" + Integer.toString(bi.getInt(g.AT().getValue("MuteRoomDisable"), 0)));
            }
        }
        if (str != null) {
            if (str.equals("dynacfg_split")) {
                g.AT().a(a, map, true);
            }
        }
        if (str != null) {
            if (str.equals("banner")) {
                str2 = (String) map.get(".sysmsg.mainframebanner.$type");
                str3 = (String) map.get(".sysmsg.mainframebanner.showtype");
                str4 = (String) map.get(".sysmsg.mainframebanner.data");
                if (str2 != null && str2.length() > 0) {
                    try {
                        bc.Ig().a(new bb(Integer.valueOf(str2).intValue(), Integer.valueOf(str3).intValue(), str4));
                    } catch (Exception e) {
                        x.e("MicroMsg.BigBallSysCmdMsgConsumer", e.toString());
                    }
                }
                str3 = (String) map.get(".sysmsg.friendrecommand.touser");
                if (!(((String) map.get(".sysmsg.friendrecommand.fromuser")) == null || str3 == null)) {
                    try {
                        au.HU().Gt().a(str3, true, null);
                    } catch (Exception e2) {
                        x.e("MicroMsg.BigBallSysCmdMsgConsumer", e2.toString());
                    }
                }
                str2 = (String) map.get(".sysmsg.banner.securitybanner.chatname");
                str3 = (String) map.get(".sysmsg.banner.securitybanner.wording");
                str4 = (String) map.get(".sysmsg.banner.securitybanner.linkname");
                str5 = (String) map.get(".sysmsg.banner.securitybanner.linksrc");
                str6 = (String) map.get(".sysmsg.banner.securitybanner.showtype");
                if (!(bi.oW(str2) || bi.oW(str6))) {
                    try {
                        boolean z;
                        if (str6.equals("1")) {
                            z = true;
                        } else {
                            z = false;
                        }
                        au.HU().Gu().a(str2, z, new String[]{str3, str4, str5});
                    } catch (Exception e22) {
                        x.e("MicroMsg.BigBallSysCmdMsgConsumer", "[oneliang]" + e22.toString());
                    }
                }
                au.HU().Gv().r(map);
            }
        }
        if (!bi.oW(str)) {
            if (str.equals("midinfo")) {
                str2 = (String) map.get(".sysmsg.midinfo.json_buffer");
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "QueryMid time[%s] json[%s]  [%s] ", new Object[]{(String) map.get(".sysmsg.midinfo.time_interval"), str2, a});
                i = bi.getInt(str3, 0);
                if (((long) i) > 86400 && ((long) i) < 864000) {
                    au.HU();
                    c.DT().set(331777, Long.valueOf(bi.VE() + ((long) i)));
                }
                if (!bi.oW(str2)) {
                    com.tencent.mm.plugin.report.b.d.KE(str2);
                }
            }
        }
        if (str != null) {
            if (str.equals("revokemsg")) {
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_SUBTYPE_REVOKE");
                str2 = (String) map.get(".sysmsg.revokemsg.session");
                str4 = (String) map.get(".sysmsg.revokemsg.replacemsg");
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "ashutest::[oneliang][xml parse] ,msgId:%s,replaceMsg:%s ", new Object[]{(String) map.get(".sysmsg.revokemsg.newmsgid"), str4});
                long j2 = 0;
                try {
                    j2 = bi.getLong((String) map.get(".sysmsg.revokemsg.newmsgid"), 0);
                    au.HU();
                    bd I = c.FT().I(str2, j2);
                    bd al = bd.al(I);
                    if ((I.cqa & 4) != 4) {
                        I.setContent(str4);
                        I.setType(10000);
                        bd.a(I, aVar);
                        au.HU();
                        c.FT().a(I.field_msgId, I);
                    }
                    au.HU();
                    Yq = c.FW().Yq(I.field_talker);
                    if (Yq != null && Yq.field_unReadCount > 0) {
                        au.HU();
                        if (Yq.field_unReadCount >= c.FT().S(I)) {
                            Yq.eV(Yq.field_unReadCount - 1);
                            au.HU();
                            c.FW().a(Yq, Yq.field_username);
                        }
                    }
                    if (aVar != null && aVar.dIO) {
                        aw awVar = new aw();
                        awVar.field_originSvrId = j2;
                        if (I.field_msgId == 0) {
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke but msg id is 0 originSvrId[%d]", new Object[]{Long.valueOf(j2)});
                            awVar.field_content = a;
                            awVar.field_createTime = (long) byVar.lOH;
                            awVar.field_flag = bd.c(aVar);
                            awVar.field_fromUserName = ab.a(byVar.rcj);
                            awVar.field_toUserName = ab.a(byVar.rck);
                            awVar.field_newMsgId = byVar.rcq;
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr insert ret[%b], systemRowid[%d]", new Object[]{Boolean.valueOf(o.PO().PL().b(awVar)), Long.valueOf(awVar.sKx)});
                            return null;
                        }
                        x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and has done delete info, originSvrId[%d]", new Object[]{Long.valueOf(j2)});
                        o.PO().PL().a(awVar, true, new String[0]);
                        au.HU();
                        c.FT().ea(j2);
                        if (!(Yq == null || aVar.dIN == null || Yq.field_lastSeq != ((long) aVar.dIN.rcr))) {
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault lastseq[%s], firstUnDeliverSeq[%s]", new Object[]{Long.valueOf(Yq.field_lastSeq), Long.valueOf(Yq.field_firstUnDeliverSeq)});
                            au.HU();
                            bd GF = c.FT().GF(Yq.field_username);
                            if (GF != null) {
                                Yq.au(GF.field_msgSeq);
                                au.HU();
                                int a2 = c.FW().a(Yq, Yq.field_username);
                                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbadcr get a revoke and fix fault by [%s, %s] lastseq[%s], firstUnDeliverSeq[%s], update[%s]", new Object[]{Long.valueOf(GF.field_msgSvrId), Long.valueOf(GF.field_msgSeq), Long.valueOf(Yq.field_lastSeq), Long.valueOf(Yq.field_firstUnDeliverSeq), Integer.valueOf(a2)});
                            }
                        }
                    }
                    if (I.field_msgId == 0 && (aVar == null || !aVar.dIO)) {
                        x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summer revoke msg id is 0 and svrid[%d]", new Object[]{Long.valueOf(j2)});
                        au.HU();
                        c.FT().ea(j2);
                    }
                    oc ocVar = new oc();
                    ocVar.bYY.bJC = I.field_msgId;
                    ocVar.bYY.bYZ = str4;
                    ocVar.bYY.bXQ = I;
                    ocVar.bYY.bZa = al;
                    ocVar.bYY.bZb = j2;
                    com.tencent.mm.sdk.b.a.sFg.m(ocVar);
                    if (al != null) {
                        com.tencent.mm.kernel.g.Em().H(new 3(this, al));
                    }
                } catch (Throwable e3) {
                    j = j2;
                    x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e3, "[oneliang][revokeMsg] msgId:%d,error:%s", new Object[]{Long.valueOf(j), e3.toString()});
                }
                return null;
            }
        }
        if (str != null) {
            if (str.equals("clouddelmsg")) {
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "mm hit MM_DATA_SYSCMD_NEWXML_CLOUD_DEL_MSG");
                str2 = (String) map.get(".sysmsg.clouddelmsg.delcommand");
                str3 = (String) map.get(".sysmsg.clouddelmsg.msgid");
                str4 = (String) map.get(".sysmsg.clouddelmsg.fromuser");
                int indexOf = a.indexOf("<msg>");
                int indexOf2 = a.indexOf("</msg>");
                if (indexOf == -1 || indexOf2 == -1) {
                    str5 = "";
                } else {
                    str5 = ay.au(bl.z(a.substring(indexOf, indexOf2 + 6), "msg"));
                }
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], delcommand:%s, msgid:%s, fromuser:%s, sysmsgcontent:%s", new Object[]{str2, str3, str4, str5});
                try {
                    au.HU();
                    LinkedList dJ = c.FT().dJ(str4, str3);
                    if (dJ == null || dJ.size() <= 0) {
                        x.e("MicroMsg.BigBallSysCmdMsgConsumer", "get null by getByBizClientMsgId");
                        return null;
                    }
                    Iterator it = dJ.iterator();
                    while (it.hasNext()) {
                        bdVar = (bd) it.next();
                        if (bdVar == null) {
                            x.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo == null");
                        } else if (bdVar.field_msgSvrId < 0) {
                            x.e("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], invalid msgInfo.msgId = %s, srvId = %s", new Object[]{Long.valueOf(bdVar.field_msgId), Long.valueOf(bdVar.field_msgSvrId)});
                        } else {
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "[hakon][clouddelmsg], msgInfo.msgId = %s, srvId = %s", new Object[]{Long.valueOf(bdVar.field_msgId), Long.valueOf(bdVar.field_msgSvrId)});
                            i2 = bi.getInt(str2, 0);
                            if (i2 == 1) {
                                au.HU();
                                c.FT().R(bdVar.field_talker, bdVar.field_msgSvrId);
                            } else if (i2 == 2 && bdVar.cky()) {
                                bdVar.setContent(str5);
                                bd.a(bdVar, aVar);
                                au.HU();
                                c.FT().b(bdVar.field_msgSvrId, bdVar);
                                au.HU();
                                ai Yq2 = c.FW().Yq(bdVar.field_talker);
                                if (Yq2 != null && Yq2.field_unReadCount > 0) {
                                    au.HU();
                                    if (Yq2.field_unReadCount >= c.FT().S(bdVar)) {
                                        Yq2.eV(Yq2.field_unReadCount - 1);
                                        au.HU();
                                        c.FW().a(Yq2, Yq2.field_username);
                                    }
                                }
                            }
                            oc ocVar2 = new oc();
                            ocVar2.bYY.bJC = bdVar.field_msgId;
                            ocVar2.bYY.bYZ = str5;
                            ocVar2.bYY.bXQ = bdVar;
                            com.tencent.mm.sdk.b.a.sFg.m(ocVar2);
                        }
                    }
                    return null;
                } catch (Throwable e32) {
                    x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e32, "[hakon][clouddelmsg], BizClientMsgId:%d,error:%s", new Object[]{str3, e32.toString()});
                }
            }
        }
        if (str != null) {
            if (str.equals("updatepackage")) {
                String str7;
                String str8;
                int i3;
                String str9;
                int i4;
                Object[] objArr;
                int i5;
                ba = c.ba(Integer.valueOf(-1879048175));
                if (ba == null) {
                    bVar = null;
                } else {
                    bVar = ba.b(aVar);
                }
                if (str != null) {
                    if (str.equals("deletepackage")) {
                        ba = c.ba(Integer.valueOf(-1879048174));
                        if (ba == null) {
                            bVar = null;
                        } else {
                            bVar = ba.b(aVar);
                        }
                    }
                }
                if (str != null) {
                    if (str.equals("delchatroommember")) {
                        str3 = ab.a(byVar.rcj);
                        au.HU();
                        bdVar = c.FT().I(str3, byVar.rcq);
                        Object obj = null;
                        if (bdVar.field_msgId > 0) {
                            obj = 1;
                        }
                        bdVar.ax(byVar.rcq);
                        if (!(aVar != null && aVar.dIO && aVar.dIQ)) {
                            bdVar.ay(bd.o(str3, (long) byVar.lOH));
                        }
                        bdVar.setType(10002);
                        bdVar.setContent(a);
                        bdVar.eX(0);
                        bdVar.ep(str3);
                        bdVar.dt(byVar.rco);
                        bd.a(bdVar, aVar);
                        if (obj == null) {
                            bd.i(bdVar);
                        } else {
                            au.HU();
                            c.FT().b(byVar.rcq, bdVar);
                        }
                    }
                }
                if (str != null) {
                    if (str.equals("WakenPush") && this.dAw != byVar.rcq) {
                        this.dAw = byVar.rcq;
                        x.i("MicroMsg.BigBallSysCmdMsgConsumer", "dzmonster[subType wakenpush]");
                        cc ccVar = new cc(map);
                        str7 = (String) ccVar.dzf.get(".sysmsg.WakenPush.PushContent");
                        str3 = (String) ccVar.dzf.get(".sysmsg.WakenPush.Jump");
                        str2 = (String) ccVar.dzf.get(".sysmsg.WakenPush.ExpiredTime");
                        str8 = (String) ccVar.dzf.get(".sysmsg.WakenPush.Username");
                        x.d("MicroMsg.WakenPushMsgExtension", "dzmonster[xml parse of wakenpush,pushContent:%s, jump:%s, expiredTime %s]", new Object[]{str7, str3, str2});
                        str2 = g.AT().getValue("WakenPushDeepLinkBitSet");
                        x.d("MicroMsg.WakenPushMsgExtension", "dzmonster[config of WakenPushDeepLinkBitSet:%s", new Object[]{str2});
                        j = !bi.oW(str2) ? bi.getLong(str2, 0) : 0;
                        Bitmap a3 = com.tencent.mm.aa.c.a(str8, false, -1);
                        al notification = au.getNotification();
                        if (bi.oW(str3)) {
                            x.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[url is null]");
                            str4 = "com.tencent.mm.ui.LauncherUI";
                        } else if ((4 & j) == 4 && str3.startsWith("weixin://dl/moments")) {
                            str4 = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
                        } else if ((j & 262144) == 262144 && str3.startsWith("weixin://dl/recommendation")) {
                            str4 = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
                        } else {
                            x.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[unable to deal with the deep link:%s)", new Object[]{str3});
                            str4 = "com.tencent.mm.ui.LauncherUI";
                        }
                        Intent intent = new Intent();
                        intent.setClassName(ad.getContext(), str4);
                        intent.setFlags(536870912);
                        intent.putExtra("LauncherUI.Show.Update.DialogMsg", (String) ccVar.dzf.get(".sysmsg.WakenPush.PushContent"));
                        if (!str3.equals("weixin://dl/update_newest_version")) {
                            intent.putExtra("LauncherUI.Show.Update.Url", (String) ccVar.dzf.get(".sysmsg.WakenPush.Jump"));
                        }
                        h.mEJ.a(405, 32, 1, true);
                        Notification a4 = notification.a(PendingIntent.getActivity(ad.getContext(), UUID.randomUUID().hashCode(), intent, 134217728), ad.getContext().getString(R.l.app_name), str7, str7, a3, str8);
                        a4.flags |= 16;
                        au.getNotification().a(a4, false);
                        h.mEJ.a(405, 31, 1, true);
                        bVar = null;
                    }
                }
                if (str != null) {
                    if (str.equals("DisasterNotice")) {
                        str2 = (String) map.get(".sysmsg.NoticeId");
                        x.i("MicroMsg.BigBallSysCmdMsgConsumer", "disaster noticeID:%s, content:%s", new Object[]{str2, (String) map.get(".sysmsg.Content")});
                        SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("disaster_pref", 4);
                        str5 = sharedPreferences.getString("disaster_noticeid_list_key", "");
                        if (!str5.contains(str2)) {
                            String[] split = str5.split(";");
                            if (split == null || split.length <= 10) {
                                str4 = str5;
                            } else {
                                str4 = "";
                                for (String str62 : split) {
                                    String[] split2 = str62.split(",");
                                    try {
                                        if (bi.bG(bi.getLong(split2[0], 0)) < 1296000) {
                                            str4 = str4 + split2[0] + "," + split2[1] + ";";
                                        }
                                    } catch (Exception e4) {
                                        x.e("MicroMsg.BigBallSysCmdMsgConsumer", "MM_DATA_SYSCMD_NEWXML_DISASTER_NOTICE parseLong error:%s", new Object[]{e4});
                                    }
                                }
                            }
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "update noticeIdList %s -> %s", new Object[]{str5, str4 + bi.VE() + "," + str2 + ";"});
                            sharedPreferences.edit().putString("disaster_noticeid_list_key", str4).commit();
                        }
                        new ag(Looper.getMainLooper()).post(new 1(this, str2));
                        byVar.rcl = ab.oT(str3);
                        byVar.jQd = 1;
                        ba = c.ba(Integer.valueOf(1));
                        if (ba == null) {
                            bVar = null;
                        } else {
                            bVar = ba.b(aVar);
                        }
                    }
                }
                if (str != null) {
                    if (str.equals("EmotionKv")) {
                        str2 = (String) map.get(".sysmsg.EmotionKv.K");
                        str9 = (String) map.get(".sysmsg.EmotionKv.I");
                        if (str2 == null) {
                            str3 = "";
                        } else {
                            str3 = str2;
                        }
                        x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]", new Object[]{Integer.valueOf(str3.length()), str3, str9});
                        byte[] bytes = y.cgr().qXe.getBytes();
                        byte[] bytes2 = y.cgr().qXf.getBytes();
                        byte[] bArr = null;
                        try {
                            bArr = au.DF().dJs.Lr().Lo();
                        } catch (Throwable e322) {
                            x.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE :%s ", new Object[]{bi.i(e322)});
                        }
                        if (bi.bC(bArr)) {
                            x.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  ecdh  is null .");
                            return null;
                        }
                        PByteArray pByteArray = new PByteArray();
                        if (bi.oW(str3) || bi.bC(bytes2) || bi.bC(bytes) || bi.bC(bArr)) {
                            a = "MicroMsg.BigBallSysCmdMsgConsumer";
                            String str10 = "summercck emotionkv param len err pcKeylen:%d, keynlen:%d, keyelen:%d, ecdhlen:%d";
                            Object[] objArr2 = new Object[4];
                            if (str3 == null) {
                                i4 = -1;
                            } else {
                                i4 = str3.length();
                            }
                            objArr2[0] = Integer.valueOf(i4);
                            objArr2[1] = Integer.valueOf(bytes2 == null ? -1 : bytes2.length);
                            objArr2[2] = Integer.valueOf(bytes == null ? -1 : bytes.length);
                            objArr2[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                            x.w(a, str10, objArr2);
                        } else {
                            au.HU();
                            MMProtocalJni.genClientCheckKVRes(c.Df(), str3, bytes, bytes2, bArr, pByteArray);
                        }
                        byte[] bArr2 = pByteArray.value;
                        aqc aqc = new aqc();
                        if (pByteArray.value != null) {
                            aqc.mEl = new String(pByteArray.value);
                        } else {
                            aqc.mEl = "";
                        }
                        str4 = "MicroMsg.BigBallSysCmdMsgConsumer";
                        str5 = "summercck emotionkv res len:%d val len:%d, content[%s]";
                        objArr = new Object[3];
                        objArr[0] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
                        objArr[1] = Integer.valueOf(aqc.mEl.length());
                        objArr[2] = com.tencent.mm.a.g.u(aqc.mEl.getBytes());
                        x.i(str4, str5, objArr);
                        aqc.rSD = str9;
                        au.HU();
                        c.FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(59, aqc));
                        return null;
                    }
                }
                if (str != null) {
                    if (str.equals("globalalert")) {
                        str2 = (String) map.get(".sysmsg.uuid");
                        i3 = bi.getInt((String) map.get(".sysmsg.id"), -1);
                        int i6 = bi.getInt((String) map.get(".sysmsg.important"), -1);
                        if (bi.oW(str2) || i3 < 0 || i6 < 0) {
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d] is illegal ret", new Object[]{str2, Integer.valueOf(i3), Integer.valueOf(i6)});
                            return null;
                        }
                        str3 = (String) map.get(".sysmsg.title");
                        str4 = (String) map.get(".sysmsg.msg");
                        if (bi.oW(str3) && bi.oW(str4)) {
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert title[%s], msg[%s] is illegal ret", new Object[]{str3, str4});
                            return null;
                        }
                        str5 = (String) map.get(".sysmsg.btnlist.btn.$title");
                        int i7 = bi.getInt((String) map.get(".sysmsg.btnlist.btn.$id"), -1);
                        i5 = bi.getInt((String) map.get(".sysmsg.btnlist.btn.$actiontype"), -1);
                        str62 = (String) map.get(".sysmsg.btnlist.btn");
                        if (bi.oW(str5) || i7 < 0 || i5 < 0) {
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert first btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal ret", new Object[]{str5, Integer.valueOf(i7), Integer.valueOf(i5)});
                            return null;
                        }
                        String str11 = (String) map.get(".sysmsg.btnlist.btn1.$title");
                        int i8 = bi.getInt((String) map.get(".sysmsg.btnlist.btn1.$id"), -1);
                        int i9 = bi.getInt((String) map.get(".sysmsg.btnlist.btn1.$actiontype"), -1);
                        str9 = (String) map.get(".sysmsg.btnlist.btn1");
                        boolean z2 = true;
                        if (bi.oW(str11) || i8 < 0 || i9 < 0) {
                            z2 = false;
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert sec btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal only one btn", new Object[]{str5, Integer.valueOf(i7), Integer.valueOf(i5)});
                        }
                        ia iaVar = new ia();
                        com.tencent.mm.protocal.b.a.b bVar3 = new com.tencent.mm.protocal.b.a.b();
                        iaVar.bRy.bRz = bVar3;
                        bVar3.id = i3;
                        bVar3.title = str3;
                        bVar3.bIr = str4;
                        bVar3.qXY = new LinkedList();
                        com.tencent.mm.protocal.b.a.a aVar2 = new com.tencent.mm.protocal.b.a.a();
                        aVar2.id = i7;
                        aVar2.actionType = i5;
                        aVar2.qXW = str5;
                        aVar2.qXX = str62;
                        bVar3.qXY.add(aVar2);
                        if (z2) {
                            com.tencent.mm.protocal.b.a.a aVar3 = new com.tencent.mm.protocal.b.a.a();
                            aVar3.id = i8;
                            aVar3.actionType = i9;
                            aVar3.qXW = str11;
                            aVar3.qXX = str9;
                            bVar3.qXY.add(aVar3);
                        }
                        boolean m = com.tencent.mm.sdk.b.a.sFg.m(iaVar);
                        x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d], title[%s], msg[%s], twoBtn[%b], publish[%b]", new Object[]{str2, Integer.valueOf(i3), Integer.valueOf(i6), str3, str4, Boolean.valueOf(z2), Boolean.valueOf(m)});
                        return null;
                    }
                }
                if (str != null) {
                    if (str.equals("yybsigcheck")) {
                        h.mEJ.a(322, 14, 1, false);
                        long currentTimeMillis = System.currentTimeMillis();
                        str2 = (String) map.get(".sysmsg.yybsigcheck.yybsig.nocheckmarket");
                        x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket[%s], wording[%s], url[%s]", new Object[]{str2, (String) map.get(".sysmsg.yybsigcheck.yybsig.wording"), (String) map.get(".sysmsg.yybsigcheck.yybsig.url")});
                        h hVar = h.mEJ;
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = Integer.valueOf(4014);
                        objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                        hVar.h(11098, objArr3);
                        if (bi.oW(str2)) {
                            x.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket is nil and return");
                            h.mEJ.a(322, 15, 1, false);
                            h hVar2 = h.mEJ;
                            Object[] objArr4 = new Object[2];
                            objArr4[0] = Integer.valueOf(4015);
                            objArr4[1] = String.format("%s|%s", new Object[]{str7, str8});
                            hVar2.h(11098, objArr4);
                            return null;
                        }
                        String[] split3 = str2.split(";");
                        str4 = "MicroMsg.BigBallSysCmdMsgConsumer";
                        str5 = "summertoken newxml infoStrs len is %d";
                        objArr = new Object[1];
                        objArr[0] = Integer.valueOf(split3 == null ? -1 : split3.length);
                        x.d(str4, str5, objArr);
                        if (split3 == null || split3.length == 0) {
                            h.mEJ.a(322, 16, 1, false);
                            h.mEJ.h(11098, new Object[]{Integer.valueOf(4016), str2});
                            return null;
                        }
                        ArrayList arrayList = new ArrayList();
                        i = 0;
                        while (true) {
                            i5 = i;
                            if (i5 >= split3.length) {
                                break;
                            }
                            String str12 = split3[i5];
                            if (bi.oW(str12)) {
                                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStr is nil index:%d, continue", new Object[]{Integer.valueOf(i5)});
                            } else {
                                String[] split4 = str12.split(",");
                                str5 = "MicroMsg.BigBallSysCmdMsgConsumer";
                                str62 = "summertoken newxml fields len is %d";
                                Object[] objArr5 = new Object[1];
                                objArr5[0] = Integer.valueOf(split4 == null ? -1 : split4.length);
                                x.d(str5, str62, objArr5);
                                if (split4 == null || split4.length != 3) {
                                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is invalid index:%d, continue", new Object[]{Integer.valueOf(i5)});
                                } else {
                                    try {
                                        arrayList.add(new aj.c(split4[0], Integer.valueOf(split4[1]).intValue(), split4[2]));
                                    } catch (Exception e5) {
                                        x.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml parse info index:%d, e:%s", new Object[]{Integer.valueOf(i5), e5.getMessage()});
                                        h.mEJ.a(322, 17, 1, false);
                                        h.mEJ.h(11098, new Object[]{Integer.valueOf(4017), str12});
                                    }
                                }
                            }
                            i = i5 + 1;
                        }
                        if (arrayList.size() == 0) {
                            x.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size is 0 and return");
                            h.mEJ.a(322, 18, 1, false);
                            hVar = h.mEJ;
                            objArr3 = new Object[2];
                            objArr3[0] = Integer.valueOf(4018);
                            objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                            hVar.h(11098, objArr3);
                            return null;
                        }
                        x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size[%d], usesSystemApi[%b], containLowerMarket[%b], take[%d]ms", new Object[]{Integer.valueOf(arrayList.size()), Boolean.valueOf(bi.getInt(g.AT().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0), Boolean.valueOf(aj.a(ad.getContext(), arrayList, bi.getInt(g.AT().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        if (aj.a(ad.getContext(), arrayList, bi.getInt(g.AT().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)) {
                            au.HS().setInt(46, 0);
                            h.mEJ.a(322, 19, 1, true);
                            hVar = h.mEJ;
                            objArr3 = new Object[2];
                            objArr3[0] = Integer.valueOf(4019);
                            objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                            hVar.h(11098, objArr3);
                        } else {
                            au.HS().setInt(46, 4);
                            ip ipVar = new ip();
                            ipVar.bSb.bSc = str7;
                            ipVar.bSb.url = str8;
                            com.tencent.mm.sdk.b.a.sFg.m(ipVar);
                            h.mEJ.a(322, 20, 1, true);
                            hVar = h.mEJ;
                            objArr3 = new Object[2];
                            objArr3[0] = Integer.valueOf(4020);
                            objArr3[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                            hVar.h(11098, objArr3);
                        }
                        return null;
                    }
                }
                if (str != null) {
                    if (str.equals("qy_status_notify")) {
                        str2 = (String) map.get(".sysmsg.chat_id");
                        map.get(".sysmsg.last_create_time");
                        str3 = (String) map.get(".sysmsg.brand_username");
                        j = e.li(str2);
                        if (j == -1) {
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify bizLocalId == -1,%s", new Object[]{str2});
                            return null;
                        }
                        i4 = z.Nb().bd(j).field_newUnReadCount;
                        z.Nb().bf(j);
                        com.tencent.mm.ac.a.c ak = z.Na().ak(j);
                        au.HU();
                        Yq = c.FW().Yq(str3);
                        if (Yq == null) {
                            x.w("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify cvs == null:%s", new Object[]{str3});
                            return null;
                        } else if (ak.hu(1)) {
                            if (Yq.field_unReadMuteCount <= i4) {
                                Yq.fb(0);
                                au.HU();
                                c.FW().a(Yq, str3);
                                au.getNotification().cancelNotification(str3);
                            } else {
                                Yq.fb(Yq.field_unReadMuteCount - i4);
                                au.HU();
                                c.FW().a(Yq, str3);
                            }
                            return null;
                        } else {
                            if (Yq.field_unReadCount <= i4) {
                                au.HU();
                                c.FW().Ys(str3);
                                au.getNotification().cancelNotification(str3);
                            } else {
                                Yq.fa(0);
                                Yq.fd(0);
                                Yq.eV(Yq.field_unReadCount - i4);
                                au.HU();
                                c.FW().a(Yq, str3);
                            }
                            return null;
                        }
                    }
                }
                if (str != null) {
                    if (str.equals("qy_chat_update")) {
                        e.n((String) map.get(".sysmsg.brand_username"), (String) map.get(".sysmsg.chat_id"), (String) map.get(".sysmsg.ver"));
                    }
                }
                if (str != null) {
                    if (str.equals("bindmobiletip")) {
                        i = bi.getInt((String) map.get(".sysmsg.bindmobiletip.forcebind"), 0);
                        str4 = bi.oV((String) map.get(".sysmsg.bindmobiletip.deviceid"));
                        str5 = bi.oV((String) map.get(".sysmsg.bindmobiletip.wording"));
                        str2 = new String(Base64.decode(str4.getBytes(), 0));
                        x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbindmobile forceBind:%d,decodeDeviceId[%s],localDeviceId[%s],woridingStr[%s]", new Object[]{Integer.valueOf(i), str2, new String(com.tencent.mm.bk.b.bi(q.zz().getBytes()).Cz(16).lR), str5});
                        if (bi.oW(str2) || str2.equals(r4)) {
                            au.HU();
                            c.DT().a(com.tencent.mm.storage.aa.a.sQC, Boolean.valueOf(true));
                            au.HU();
                            c.DT().a(com.tencent.mm.storage.aa.a.sQD, Boolean.valueOf(i == 1));
                            au.HU();
                            c.DT().a(com.tencent.mm.storage.aa.a.sQE, str5);
                        }
                        return null;
                    }
                }
                if (str != null) {
                    if (str.equals("ClientCheckConsistency")) {
                        axa axa = new axa();
                        axa.ecE = (String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.fullpathfilename");
                        axa.saf = bi.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.fileoffset"), 0);
                        axa.sag = bi.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.checkbuffersize"), 0);
                        axa.rko = bi.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.seq"), 0);
                        axa.sah = f(axa.ecE, (long) axa.saf, (long) axa.sag);
                        axa.ruE = (int) gx(axa.ecE);
                        axa.sai = com.tencent.mm.plugin.normsg.a.b.lFJ.bjz() ? 1 : 0;
                        axa.rth = w.zQ();
                        axa.saj = f(axa.ecE, Integer.valueOf(axa.saf), Integer.valueOf(axa.sag), Integer.valueOf(axa.rko), axa.sah, Integer.valueOf(axa.ruE), Integer.valueOf(axa.sai), Integer.valueOf(axa.rth));
                        au.HU();
                        c.FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(61, axa));
                    }
                }
                if (str != null) {
                    if (str.equals("ClientCheckHook")) {
                        axc axc = new axc();
                        axc.rko = bi.getInt((String) map.get(".sysmsg.ClientCheckHook.clientcheck.seq"), 0);
                        axc.sal = com.tencent.mm.plugin.normsg.a.b.lFJ.gV(false);
                        axc.sai = com.tencent.mm.plugin.normsg.a.b.lFJ.bjz() ? 1 : 0;
                        axc.rth = w.zQ();
                        axc.saj = f(Integer.valueOf(axc.rko), axc.sal, Integer.valueOf(axc.sai), Integer.valueOf(axc.rth));
                        au.HU();
                        c.FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(62, axc));
                    }
                }
                if (str != null) {
                    if (str.equals("ClientCheckGetAppList")) {
                        axb axb = new axb();
                        axb.rko = bi.getInt((String) map.get(".sysmsg.ClientCheckGetAppList.clientcheck.seq"), 0);
                        axb.sak = com.tencent.mm.plugin.normsg.a.b.lFJ.bjD();
                        axb.sai = com.tencent.mm.plugin.normsg.a.b.lFJ.bjz() ? 1 : 0;
                        axb.rth = w.zQ();
                        axb.saj = f(Integer.valueOf(axb.rko), axb.sak, Integer.valueOf(axb.sai), Integer.valueOf(axb.rth));
                        au.HU();
                        c.FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(63, axb));
                    }
                }
                if (str != null) {
                    if (str.equals("ClientCheckGetExtInfo")) {
                        com.tencent.mm.sdk.f.e.a(new 2(this, map), "syscmd_rpt_cc");
                    }
                }
                if (!bi.oW(str)) {
                    if (str.equals("functionmsg")) {
                        x.d("MicroMsg.BigBallSysCmdMsgConsumer", "subtype functionmsg");
                        com.tencent.mm.r.c Ch = i.Ch();
                        x.l("MicroMsg.FunctionMsgFetcher", "fetchFromNewXml, newXmlMsgQueue.size: %s, addMsg.createTime: %s", new Object[]{Integer.valueOf(Ch.diB.size()), Integer.valueOf(byVar.lOH)});
                        map.put("FUNCTION_MSG_ADD_MSG_CREATE_TIME_KEY", String.valueOf(byVar.lOH));
                        Ch.diB.add(map);
                        Ch.BX();
                    }
                }
                if (!bi.oW(str)) {
                    if (str.equals("paymsg")) {
                        x.d("MicroMsg.BigBallSysCmdMsgConsumer", "payMsg, payMsgType: %s, MsgId: %s, fromUsername: %s, toUsername: %s, paymsgid: %s, appMsgContentEncode: %s, ", new Object[]{Integer.valueOf(bi.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0)), Long.valueOf(byVar.rcq), (String) map.get(".sysmsg.paymsg.fromusername"), (String) map.get(".sysmsg.paymsg.tousername"), (String) map.get(".sysmsg.paymsg.paymsgid"), (String) map.get(".sysmsg.paymsg.appmsgcontent")});
                        try {
                            str2 = URLDecoder.decode((String) map.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
                            if (!bi.oW(str2)) {
                                mm mmVar = new mm();
                                mmVar.bXt.type = i2;
                                mmVar.bXt.content = str2;
                                mmVar.bXt.bSS = str3;
                                mmVar.bXt.toUser = str4;
                                mmVar.bXt.bXu = str5;
                                com.tencent.mm.sdk.b.a.sFg.m(mmVar);
                            }
                        } catch (Throwable e3222) {
                            x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e3222, "", new Object[0]);
                            x.d("MicroMsg.BigBallSysCmdMsgConsumer", "pay msg, parse failed: %s", new Object[]{e3222.getMessage()});
                        }
                    }
                }
                return bVar;
            }
        }
        bVar = bVar2;
        if (str != null) {
            if (str.equals("deletepackage")) {
                ba = c.ba(Integer.valueOf(-1879048174));
                if (ba == null) {
                    bVar = null;
                } else {
                    bVar = ba.b(aVar);
                }
            }
        }
        if (str != null) {
            if (str.equals("delchatroommember")) {
                str3 = ab.a(byVar.rcj);
                au.HU();
                bdVar = c.FT().I(str3, byVar.rcq);
                Object obj2 = null;
                if (bdVar.field_msgId > 0) {
                    obj2 = 1;
                }
                bdVar.ax(byVar.rcq);
                if (!(aVar != null && aVar.dIO && aVar.dIQ)) {
                    bdVar.ay(bd.o(str3, (long) byVar.lOH));
                }
                bdVar.setType(10002);
                bdVar.setContent(a);
                bdVar.eX(0);
                bdVar.ep(str3);
                bdVar.dt(byVar.rco);
                bd.a(bdVar, aVar);
                if (obj2 == null) {
                    bd.i(bdVar);
                } else {
                    au.HU();
                    c.FT().b(byVar.rcq, bdVar);
                }
            }
        }
        if (str != null) {
            if (str.equals("WakenPush") && this.dAw != byVar.rcq) {
                this.dAw = byVar.rcq;
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "dzmonster[subType wakenpush]");
                cc ccVar2 = new cc(map);
                str7 = (String) ccVar2.dzf.get(".sysmsg.WakenPush.PushContent");
                str3 = (String) ccVar2.dzf.get(".sysmsg.WakenPush.Jump");
                str2 = (String) ccVar2.dzf.get(".sysmsg.WakenPush.ExpiredTime");
                str8 = (String) ccVar2.dzf.get(".sysmsg.WakenPush.Username");
                x.d("MicroMsg.WakenPushMsgExtension", "dzmonster[xml parse of wakenpush,pushContent:%s, jump:%s, expiredTime %s]", new Object[]{str7, str3, str2});
                str2 = g.AT().getValue("WakenPushDeepLinkBitSet");
                x.d("MicroMsg.WakenPushMsgExtension", "dzmonster[config of WakenPushDeepLinkBitSet:%s", new Object[]{str2});
                j = !bi.oW(str2) ? bi.getLong(str2, 0) : 0;
                Bitmap a32 = com.tencent.mm.aa.c.a(str8, false, -1);
                al notification2 = au.getNotification();
                if (bi.oW(str3)) {
                    x.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[url is null]");
                    str4 = "com.tencent.mm.ui.LauncherUI";
                } else if ((4 & j) == 4 && str3.startsWith("weixin://dl/moments")) {
                    str4 = "com.tencent.mm.plugin.sns.ui.SnsTimeLineUI";
                } else if ((j & 262144) == 262144 && str3.startsWith("weixin://dl/recommendation")) {
                    str4 = "com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI";
                } else {
                    x.e("MicroMsg.WakenPushMsgExtension", "dzmonster:dealDeepLink[unable to deal with the deep link:%s)", new Object[]{str3});
                    str4 = "com.tencent.mm.ui.LauncherUI";
                }
                Intent intent2 = new Intent();
                intent2.setClassName(ad.getContext(), str4);
                intent2.setFlags(536870912);
                intent2.putExtra("LauncherUI.Show.Update.DialogMsg", (String) ccVar2.dzf.get(".sysmsg.WakenPush.PushContent"));
                if (!str3.equals("weixin://dl/update_newest_version")) {
                    intent2.putExtra("LauncherUI.Show.Update.Url", (String) ccVar2.dzf.get(".sysmsg.WakenPush.Jump"));
                }
                h.mEJ.a(405, 32, 1, true);
                Notification a42 = notification2.a(PendingIntent.getActivity(ad.getContext(), UUID.randomUUID().hashCode(), intent2, 134217728), ad.getContext().getString(R.l.app_name), str7, str7, a32, str8);
                a42.flags |= 16;
                au.getNotification().a(a42, false);
                h.mEJ.a(405, 31, 1, true);
                bVar = null;
            }
        }
        if (str != null) {
            if (str.equals("DisasterNotice")) {
                str2 = (String) map.get(".sysmsg.NoticeId");
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "disaster noticeID:%s, content:%s", new Object[]{str2, (String) map.get(".sysmsg.Content")});
                SharedPreferences sharedPreferences2 = ad.getContext().getSharedPreferences("disaster_pref", 4);
                str5 = sharedPreferences2.getString("disaster_noticeid_list_key", "");
                if (!str5.contains(str2)) {
                    String[] split5 = str5.split(";");
                    if (split5 == null || split5.length <= 10) {
                        str4 = str5;
                    } else {
                        str4 = "";
                        for (String str622 : split5) {
                            String[] split22 = str622.split(",");
                            try {
                                if (bi.bG(bi.getLong(split22[0], 0)) < 1296000) {
                                    str4 = str4 + split22[0] + "," + split22[1] + ";";
                                }
                            } catch (Exception e42) {
                                x.e("MicroMsg.BigBallSysCmdMsgConsumer", "MM_DATA_SYSCMD_NEWXML_DISASTER_NOTICE parseLong error:%s", new Object[]{e42});
                            }
                        }
                    }
                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "update noticeIdList %s -> %s", new Object[]{str5, str4 + bi.VE() + "," + str2 + ";"});
                    sharedPreferences2.edit().putString("disaster_noticeid_list_key", str4).commit();
                }
                new ag(Looper.getMainLooper()).post(new 1(this, str2));
                byVar.rcl = ab.oT(str3);
                byVar.jQd = 1;
                ba = c.ba(Integer.valueOf(1));
                if (ba == null) {
                    bVar = null;
                } else {
                    bVar = ba.b(aVar);
                }
            }
        }
        if (str != null) {
            if (str.equals("EmotionKv")) {
                str2 = (String) map.get(".sysmsg.EmotionKv.K");
                str9 = (String) map.get(".sysmsg.EmotionKv.I");
                if (str2 == null) {
                    str3 = "";
                } else {
                    str3 = str2;
                }
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summercck emotionkv pcKeyStr len:%d, content[%s] pcId[%s]", new Object[]{Integer.valueOf(str3.length()), str3, str9});
                byte[] bytes3 = y.cgr().qXe.getBytes();
                byte[] bytes22 = y.cgr().qXf.getBytes();
                byte[] bArr3 = null;
                try {
                    bArr3 = au.DF().dJs.Lr().Lo();
                } catch (Throwable e32222) {
                    x.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE :%s ", new Object[]{bi.i(e32222)});
                }
                if (bi.bC(bArr3)) {
                    x.e("MicroMsg.BigBallSysCmdMsgConsumer", "DISASTER_NOTICE  ecdh  is null .");
                    return null;
                }
                PByteArray pByteArray2 = new PByteArray();
                if (bi.oW(str3) || bi.bC(bytes22) || bi.bC(bytes3) || bi.bC(bArr3)) {
                    a = "MicroMsg.BigBallSysCmdMsgConsumer";
                    String str102 = "summercck emotionkv param len err pcKeylen:%d, keynlen:%d, keyelen:%d, ecdhlen:%d";
                    Object[] objArr22 = new Object[4];
                    if (str3 == null) {
                        i4 = -1;
                    } else {
                        i4 = str3.length();
                    }
                    objArr22[0] = Integer.valueOf(i4);
                    objArr22[1] = Integer.valueOf(bytes22 == null ? -1 : bytes22.length);
                    objArr22[2] = Integer.valueOf(bytes3 == null ? -1 : bytes3.length);
                    objArr22[3] = Integer.valueOf(bArr3 == null ? -1 : bArr3.length);
                    x.w(a, str102, objArr22);
                } else {
                    au.HU();
                    MMProtocalJni.genClientCheckKVRes(c.Df(), str3, bytes3, bytes22, bArr3, pByteArray2);
                }
                byte[] bArr22 = pByteArray2.value;
                aqc aqc2 = new aqc();
                if (pByteArray2.value != null) {
                    aqc2.mEl = new String(pByteArray2.value);
                } else {
                    aqc2.mEl = "";
                }
                str4 = "MicroMsg.BigBallSysCmdMsgConsumer";
                str5 = "summercck emotionkv res len:%d val len:%d, content[%s]";
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(bArr22 == null ? -1 : bArr22.length);
                objArr[1] = Integer.valueOf(aqc2.mEl.length());
                objArr[2] = com.tencent.mm.a.g.u(aqc2.mEl.getBytes());
                x.i(str4, str5, objArr);
                aqc2.rSD = str9;
                au.HU();
                c.FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(59, aqc2));
                return null;
            }
        }
        if (str != null) {
            if (str.equals("globalalert")) {
                str2 = (String) map.get(".sysmsg.uuid");
                i3 = bi.getInt((String) map.get(".sysmsg.id"), -1);
                int i62 = bi.getInt((String) map.get(".sysmsg.important"), -1);
                if (bi.oW(str2) || i3 < 0 || i62 < 0) {
                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d] is illegal ret", new Object[]{str2, Integer.valueOf(i3), Integer.valueOf(i62)});
                    return null;
                }
                str3 = (String) map.get(".sysmsg.title");
                str4 = (String) map.get(".sysmsg.msg");
                if (bi.oW(str3) && bi.oW(str4)) {
                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert title[%s], msg[%s] is illegal ret", new Object[]{str3, str4});
                    return null;
                }
                str5 = (String) map.get(".sysmsg.btnlist.btn.$title");
                int i72 = bi.getInt((String) map.get(".sysmsg.btnlist.btn.$id"), -1);
                i5 = bi.getInt((String) map.get(".sysmsg.btnlist.btn.$actiontype"), -1);
                str622 = (String) map.get(".sysmsg.btnlist.btn");
                if (bi.oW(str5) || i72 < 0 || i5 < 0) {
                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert first btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal ret", new Object[]{str5, Integer.valueOf(i72), Integer.valueOf(i5)});
                    return null;
                }
                String str112 = (String) map.get(".sysmsg.btnlist.btn1.$title");
                int i82 = bi.getInt((String) map.get(".sysmsg.btnlist.btn1.$id"), -1);
                int i92 = bi.getInt((String) map.get(".sysmsg.btnlist.btn1.$actiontype"), -1);
                str9 = (String) map.get(".sysmsg.btnlist.btn1");
                boolean z22 = true;
                if (bi.oW(str112) || i82 < 0 || i92 < 0) {
                    z22 = false;
                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert sec btn btnStr[%s], btnId[%d] btnActionType[%d] is illegal only one btn", new Object[]{str5, Integer.valueOf(i72), Integer.valueOf(i5)});
                }
                ia iaVar2 = new ia();
                com.tencent.mm.protocal.b.a.b bVar32 = new com.tencent.mm.protocal.b.a.b();
                iaVar2.bRy.bRz = bVar32;
                bVar32.id = i3;
                bVar32.title = str3;
                bVar32.bIr = str4;
                bVar32.qXY = new LinkedList();
                com.tencent.mm.protocal.b.a.a aVar22 = new com.tencent.mm.protocal.b.a.a();
                aVar22.id = i72;
                aVar22.actionType = i5;
                aVar22.qXW = str5;
                aVar22.qXX = str622;
                bVar32.qXY.add(aVar22);
                if (z22) {
                    com.tencent.mm.protocal.b.a.a aVar32 = new com.tencent.mm.protocal.b.a.a();
                    aVar32.id = i82;
                    aVar32.actionType = i92;
                    aVar32.qXW = str112;
                    aVar32.qXX = str9;
                    bVar32.qXY.add(aVar32);
                }
                boolean m2 = com.tencent.mm.sdk.b.a.sFg.m(iaVar2);
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summeralert uuid[%s], id[%d], important[%d], title[%s], msg[%s], twoBtn[%b], publish[%b]", new Object[]{str2, Integer.valueOf(i3), Integer.valueOf(i62), str3, str4, Boolean.valueOf(z22), Boolean.valueOf(m2)});
                return null;
            }
        }
        if (str != null) {
            if (str.equals("yybsigcheck")) {
                h.mEJ.a(322, 14, 1, false);
                long currentTimeMillis2 = System.currentTimeMillis();
                str2 = (String) map.get(".sysmsg.yybsigcheck.yybsig.nocheckmarket");
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket[%s], wording[%s], url[%s]", new Object[]{str2, (String) map.get(".sysmsg.yybsigcheck.yybsig.wording"), (String) map.get(".sysmsg.yybsigcheck.yybsig.url")});
                h hVar3 = h.mEJ;
                Object[] objArr32 = new Object[2];
                objArr32[0] = Integer.valueOf(4014);
                objArr32[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                hVar3.h(11098, objArr32);
                if (bi.oW(str2)) {
                    x.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml nocheckmarket is nil and return");
                    h.mEJ.a(322, 15, 1, false);
                    h hVar22 = h.mEJ;
                    Object[] objArr42 = new Object[2];
                    objArr42[0] = Integer.valueOf(4015);
                    objArr42[1] = String.format("%s|%s", new Object[]{str7, str8});
                    hVar22.h(11098, objArr42);
                    return null;
                }
                String[] split32 = str2.split(";");
                str4 = "MicroMsg.BigBallSysCmdMsgConsumer";
                str5 = "summertoken newxml infoStrs len is %d";
                objArr = new Object[1];
                objArr[0] = Integer.valueOf(split32 == null ? -1 : split32.length);
                x.d(str4, str5, objArr);
                if (split32 == null || split32.length == 0) {
                    h.mEJ.a(322, 16, 1, false);
                    h.mEJ.h(11098, new Object[]{Integer.valueOf(4016), str2});
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                i = 0;
                while (true) {
                    i5 = i;
                    if (i5 >= split32.length) {
                        break;
                    }
                    String str122 = split32[i5];
                    if (bi.oW(str122)) {
                        x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml infoStr is nil index:%d, continue", new Object[]{Integer.valueOf(i5)});
                    } else {
                        String[] split42 = str122.split(",");
                        str5 = "MicroMsg.BigBallSysCmdMsgConsumer";
                        str622 = "summertoken newxml fields len is %d";
                        Object[] objArr52 = new Object[1];
                        objArr52[0] = Integer.valueOf(split42 == null ? -1 : split42.length);
                        x.d(str5, str622, objArr52);
                        if (split42 == null || split42.length != 3) {
                            x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml fields len is invalid index:%d, continue", new Object[]{Integer.valueOf(i5)});
                        } else {
                            try {
                                arrayList2.add(new aj.c(split42[0], Integer.valueOf(split42[1]).intValue(), split42[2]));
                            } catch (Exception e52) {
                                x.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml parse info index:%d, e:%s", new Object[]{Integer.valueOf(i5), e52.getMessage()});
                                h.mEJ.a(322, 17, 1, false);
                                h.mEJ.h(11098, new Object[]{Integer.valueOf(4017), str122});
                            }
                        }
                    }
                    i = i5 + 1;
                }
                if (arrayList2.size() == 0) {
                    x.w("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size is 0 and return");
                    h.mEJ.a(322, 18, 1, false);
                    hVar3 = h.mEJ;
                    objArr32 = new Object[2];
                    objArr32[0] = Integer.valueOf(4018);
                    objArr32[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                    hVar3.h(11098, objArr32);
                    return null;
                }
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summertoken newxml marketList size[%d], usesSystemApi[%b], containLowerMarket[%b], take[%d]ms", new Object[]{Integer.valueOf(arrayList2.size()), Boolean.valueOf(bi.getInt(g.AT().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0), Boolean.valueOf(aj.a(ad.getContext(), arrayList2, bi.getInt(g.AT().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                if (aj.a(ad.getContext(), arrayList2, bi.getInt(g.AT().getValue("YYBVerifyMarketUseSystemApi"), 0) != 0)) {
                    au.HS().setInt(46, 0);
                    h.mEJ.a(322, 19, 1, true);
                    hVar3 = h.mEJ;
                    objArr32 = new Object[2];
                    objArr32[0] = Integer.valueOf(4019);
                    objArr32[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                    hVar3.h(11098, objArr32);
                } else {
                    au.HS().setInt(46, 4);
                    ip ipVar2 = new ip();
                    ipVar2.bSb.bSc = str7;
                    ipVar2.bSb.url = str8;
                    com.tencent.mm.sdk.b.a.sFg.m(ipVar2);
                    h.mEJ.a(322, 20, 1, true);
                    hVar3 = h.mEJ;
                    objArr32 = new Object[2];
                    objArr32[0] = Integer.valueOf(4020);
                    objArr32[1] = String.format("%s|%s|%s", new Object[]{str2, str7, str8});
                    hVar3.h(11098, objArr32);
                }
                return null;
            }
        }
        if (str != null) {
            if (str.equals("qy_status_notify")) {
                str2 = (String) map.get(".sysmsg.chat_id");
                map.get(".sysmsg.last_create_time");
                str3 = (String) map.get(".sysmsg.brand_username");
                j = e.li(str2);
                if (j == -1) {
                    x.i("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify bizLocalId == -1,%s", new Object[]{str2});
                    return null;
                }
                i4 = z.Nb().bd(j).field_newUnReadCount;
                z.Nb().bf(j);
                com.tencent.mm.ac.a.c ak2 = z.Na().ak(j);
                au.HU();
                Yq = c.FW().Yq(str3);
                if (Yq == null) {
                    x.w("MicroMsg.BigBallSysCmdMsgConsumer", "qy_status_notify cvs == null:%s", new Object[]{str3});
                    return null;
                } else if (ak2.hu(1)) {
                    if (Yq.field_unReadMuteCount <= i4) {
                        Yq.fb(0);
                        au.HU();
                        c.FW().a(Yq, str3);
                        au.getNotification().cancelNotification(str3);
                    } else {
                        Yq.fb(Yq.field_unReadMuteCount - i4);
                        au.HU();
                        c.FW().a(Yq, str3);
                    }
                    return null;
                } else {
                    if (Yq.field_unReadCount <= i4) {
                        au.HU();
                        c.FW().Ys(str3);
                        au.getNotification().cancelNotification(str3);
                    } else {
                        Yq.fa(0);
                        Yq.fd(0);
                        Yq.eV(Yq.field_unReadCount - i4);
                        au.HU();
                        c.FW().a(Yq, str3);
                    }
                    return null;
                }
            }
        }
        if (str != null) {
            if (str.equals("qy_chat_update")) {
                e.n((String) map.get(".sysmsg.brand_username"), (String) map.get(".sysmsg.chat_id"), (String) map.get(".sysmsg.ver"));
            }
        }
        if (str != null) {
            if (str.equals("bindmobiletip")) {
                i = bi.getInt((String) map.get(".sysmsg.bindmobiletip.forcebind"), 0);
                str4 = bi.oV((String) map.get(".sysmsg.bindmobiletip.deviceid"));
                str5 = bi.oV((String) map.get(".sysmsg.bindmobiletip.wording"));
                str2 = new String(Base64.decode(str4.getBytes(), 0));
                x.i("MicroMsg.BigBallSysCmdMsgConsumer", "summerbindmobile forceBind:%d,decodeDeviceId[%s],localDeviceId[%s],woridingStr[%s]", new Object[]{Integer.valueOf(i), str2, new String(com.tencent.mm.bk.b.bi(q.zz().getBytes()).Cz(16).lR), str5});
                if (bi.oW(str2) || str2.equals(r4)) {
                    au.HU();
                    c.DT().a(com.tencent.mm.storage.aa.a.sQC, Boolean.valueOf(true));
                    au.HU();
                    c.DT().a(com.tencent.mm.storage.aa.a.sQD, Boolean.valueOf(i == 1));
                    au.HU();
                    c.DT().a(com.tencent.mm.storage.aa.a.sQE, str5);
                }
                return null;
            }
        }
        if (str != null) {
            if (str.equals("ClientCheckConsistency")) {
                axa axa2 = new axa();
                axa2.ecE = (String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.fullpathfilename");
                axa2.saf = bi.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.fileoffset"), 0);
                axa2.sag = bi.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.checkbuffersize"), 0);
                axa2.rko = bi.getInt((String) map.get(".sysmsg.ClientCheckConsistency.clientcheck.seq"), 0);
                axa2.sah = f(axa2.ecE, (long) axa2.saf, (long) axa2.sag);
                axa2.ruE = (int) gx(axa2.ecE);
                axa2.sai = com.tencent.mm.plugin.normsg.a.b.lFJ.bjz() ? 1 : 0;
                axa2.rth = w.zQ();
                axa2.saj = f(axa2.ecE, Integer.valueOf(axa2.saf), Integer.valueOf(axa2.sag), Integer.valueOf(axa2.rko), axa2.sah, Integer.valueOf(axa2.ruE), Integer.valueOf(axa2.sai), Integer.valueOf(axa2.rth));
                au.HU();
                c.FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(61, axa2));
            }
        }
        if (str != null) {
            if (str.equals("ClientCheckHook")) {
                axc axc2 = new axc();
                axc2.rko = bi.getInt((String) map.get(".sysmsg.ClientCheckHook.clientcheck.seq"), 0);
                axc2.sal = com.tencent.mm.plugin.normsg.a.b.lFJ.gV(false);
                axc2.sai = com.tencent.mm.plugin.normsg.a.b.lFJ.bjz() ? 1 : 0;
                axc2.rth = w.zQ();
                axc2.saj = f(Integer.valueOf(axc2.rko), axc2.sal, Integer.valueOf(axc2.sai), Integer.valueOf(axc2.rth));
                au.HU();
                c.FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(62, axc2));
            }
        }
        if (str != null) {
            if (str.equals("ClientCheckGetAppList")) {
                axb axb2 = new axb();
                axb2.rko = bi.getInt((String) map.get(".sysmsg.ClientCheckGetAppList.clientcheck.seq"), 0);
                axb2.sak = com.tencent.mm.plugin.normsg.a.b.lFJ.bjD();
                axb2.sai = com.tencent.mm.plugin.normsg.a.b.lFJ.bjz() ? 1 : 0;
                axb2.rth = w.zQ();
                axb2.saj = f(Integer.valueOf(axb2.rko), axb2.sak, Integer.valueOf(axb2.sai), Integer.valueOf(axb2.rth));
                au.HU();
                c.FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(63, axb2));
            }
        }
        if (str != null) {
            if (str.equals("ClientCheckGetExtInfo")) {
                com.tencent.mm.sdk.f.e.a(new 2(this, map), "syscmd_rpt_cc");
            }
        }
        if (bi.oW(str)) {
            if (str.equals("functionmsg")) {
                x.d("MicroMsg.BigBallSysCmdMsgConsumer", "subtype functionmsg");
                com.tencent.mm.r.c Ch2 = i.Ch();
                x.l("MicroMsg.FunctionMsgFetcher", "fetchFromNewXml, newXmlMsgQueue.size: %s, addMsg.createTime: %s", new Object[]{Integer.valueOf(Ch2.diB.size()), Integer.valueOf(byVar.lOH)});
                map.put("FUNCTION_MSG_ADD_MSG_CREATE_TIME_KEY", String.valueOf(byVar.lOH));
                Ch2.diB.add(map);
                Ch2.BX();
            }
        }
        if (bi.oW(str)) {
            if (str.equals("paymsg")) {
                x.d("MicroMsg.BigBallSysCmdMsgConsumer", "payMsg, payMsgType: %s, MsgId: %s, fromUsername: %s, toUsername: %s, paymsgid: %s, appMsgContentEncode: %s, ", new Object[]{Integer.valueOf(bi.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0)), Long.valueOf(byVar.rcq), (String) map.get(".sysmsg.paymsg.fromusername"), (String) map.get(".sysmsg.paymsg.tousername"), (String) map.get(".sysmsg.paymsg.paymsgid"), (String) map.get(".sysmsg.paymsg.appmsgcontent")});
                try {
                    str2 = URLDecoder.decode((String) map.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
                    if (!bi.oW(str2)) {
                        mm mmVar2 = new mm();
                        mmVar2.bXt.type = i2;
                        mmVar2.bXt.content = str2;
                        mmVar2.bXt.bSS = str3;
                        mmVar2.bXt.toUser = str4;
                        mmVar2.bXt.bXu = str5;
                        com.tencent.mm.sdk.b.a.sFg.m(mmVar2);
                    }
                } catch (Throwable e322222) {
                    x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e322222, "", new Object[0]);
                    x.d("MicroMsg.BigBallSysCmdMsgConsumer", "pay msg, parse failed: %s", new Object[]{e322222.getMessage()});
                }
            }
        }
        return bVar;
    }

    private static String f(String str, long j, long j2) {
        InputStream inputStream;
        Throwable e;
        String bE;
        ZipFile zipFile;
        try {
            if (str.startsWith("@")) {
                zipFile = new ZipFile(ad.getContext().getApplicationInfo().sourceDir);
                try {
                    inputStream = zipFile.getInputStream(zipFile.getEntry(str.substring(1)));
                } catch (Exception e2) {
                    e = e2;
                    inputStream = null;
                } catch (Throwable th) {
                    e = th;
                    inputStream = null;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw e;
                }
            }
            inputStream = FileOp.openRead(str);
            zipFile = null;
            while (j > 0) {
                try {
                    j -= inputStream.skip(j);
                } catch (Exception e5) {
                    e = e5;
                }
            }
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[2048];
            while (j2 > 0) {
                int read = inputStream.read(bArr, 0, (int) Math.min(ConstantsAPI$AppSupportContentFlag.MMAPP_SUPPORT_XLSX, j2));
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
                j2 -= (long) read;
            }
            bE = bi.bE(instance.digest());
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                }
            }
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e7) {
                }
            }
        } catch (Exception e8) {
            e = e8;
            zipFile = null;
            inputStream = null;
            try {
                x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
                bE = "";
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e9) {
                    }
                }
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e10) {
                    }
                }
                return bE;
            } catch (Throwable th2) {
                e = th2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e32) {
                    }
                }
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e42) {
                    }
                }
                throw e;
            }
        } catch (Throwable th3) {
            e = th3;
            zipFile = null;
            inputStream = null;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e322) {
                }
            }
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e422) {
                }
            }
            throw e;
        }
        return bE;
    }

    private static long gx(String str) {
        Throwable e;
        Throwable th;
        long j = -1;
        if (!str.startsWith("@")) {
            return FileOp.mI(str);
        }
        ZipFile zipFile;
        try {
            zipFile = new ZipFile(ad.getContext().getApplicationInfo().sourceDir);
            try {
                ZipEntry entry = zipFile.getEntry(str.substring(1));
                if (entry == null) {
                    try {
                        zipFile.close();
                        return j;
                    } catch (IOException e2) {
                        return j;
                    }
                }
                j = entry.getSize();
                try {
                    zipFile.close();
                    return j;
                } catch (IOException e3) {
                    return j;
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (IOException e5) {
            e = e5;
            zipFile = null;
            try {
                x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
                if (zipFile == null) {
                    return j;
                }
                try {
                    zipFile.close();
                    return j;
                } catch (IOException e6) {
                    return j;
                }
            } catch (Throwable th2) {
                th = th2;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e7) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e72) {
                }
            }
            throw th;
        }
    }

    private static String f(Object... objArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            for (Object obj : objArr) {
                int i;
                if (obj instanceof String) {
                    byteArrayOutputStream.write(((String) obj).getBytes());
                } else if (obj instanceof Integer) {
                    int intValue = ((Integer) obj).intValue();
                    for (i = 0; i < 4; i++) {
                        byteArrayOutputStream.write(intValue & 255);
                        intValue >>= 8;
                    }
                } else if (obj instanceof Long) {
                    long longValue = ((Long) obj).longValue();
                    for (i = 0; i < 8; i++) {
                        byteArrayOutputStream.write((int) (255 & longValue));
                        longValue >>= 8;
                    }
                } else if (obj instanceof Boolean) {
                    if (((Boolean) obj).booleanValue()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    byteArrayOutputStream.write(i);
                } else {
                    x.e("MicroMsg.BigBallSysCmdMsgConsumer", "Invalid object class: %s", new Object[]{obj});
                    return "";
                }
            }
            return bi.bE(MessageDigest.getInstance("MD5").digest(byteArrayOutputStream.toByteArray()));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BigBallSysCmdMsgConsumer", e, "", new Object[0]);
            return "";
        }
    }
}
