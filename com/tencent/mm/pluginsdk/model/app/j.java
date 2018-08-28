package com.tencent.mm.pluginsdk.model.app;

import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.ab.d;
import com.tencent.mm.ab.d.a;
import com.tencent.mm.ab.d.b;
import com.tencent.mm.ak.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.ai;
import com.tencent.mm.g.a.bt;
import com.tencent.mm.g.a.f;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.r;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.g.a.sr;
import com.tencent.mm.g.a.tm;
import com.tencent.mm.g.a.tv;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g;
import com.tencent.mm.y.k;
import java.util.Map;

public final class j implements d {
    a qzR = null;

    public static String c(by byVar) {
        String a = ab.a(byVar.rcj);
        String a2 = ab.a(byVar.rck);
        if (!bi.oW(a) && !bi.oW(a2)) {
            return fB(a, ab.a(byVar.rcl));
        }
        x.e("MicroMsg.AppMessageExtension", "empty fromuser or touser");
        return null;
    }

    public static String fB(String str, String str2) {
        if (bi.oW(str2)) {
            return null;
        }
        if (s.fq(str)) {
            int iA = bd.iA(str2);
            if (iA != -1) {
                str2 = (str2 + " ").substring(iA + 2).trim();
            }
        }
        return bi.WT(str2);
    }

    public final b b(a aVar) {
        x.d("MicroMsg.AppMessageExtension", "process add app message");
        by byVar = aVar.dIN;
        String c = c(byVar);
        g.a gp = g.a.gp(c);
        if (gp == null) {
            x.e("MicroMsg.AppMessageExtension", "parse app message failed, insert failed");
            return null;
        } else if (gp.dyi) {
            au.HU();
            c.DT().set(352273, c);
            au.HU();
            c.DT().set(352274, Long.valueOf(System.currentTimeMillis()));
            new a(c).cbI();
            return null;
        } else {
            String str;
            f SW = ao.bmf().SW(gp.appId);
            String str2 = "MicroMsg.AppMessageExtension";
            String str3 = "check version appid:%s, msgVer:%d, appVer:%s";
            Object[] objArr = new Object[3];
            objArr[0] = gp.appId;
            objArr[1] = Integer.valueOf(gp.cbu);
            if (SW == null) {
                str = "null";
            } else {
                str = Integer.valueOf(SW.field_appVersion);
            }
            objArr[2] = str;
            x.i(str2, str3, objArr);
            if (SW == null || SW.field_appVersion < gp.cbu) {
                ao.bme().SU(gp.appId);
            }
            b a = a(aVar, ab.a(byVar.rcl), gp);
            if (a.bGS == null) {
                return null;
            }
            com.tencent.mm.storage.bd bdVar = a.bGS;
            if (bdVar.cky()) {
                if (!bi.oW(gp.dzc)) {
                    tv tvVar = new tv();
                    tvVar.cfB.bVv = gp.dzc;
                    com.tencent.mm.sdk.b.a.sFg.m(tvVar);
                }
                return a;
            } else if (bdVar.getType() == 301989937) {
                return a;
            } else {
                if (bdVar.getType() == -1879048190) {
                    sr srVar = new sr();
                    srVar.cdw.bVv = c;
                    srVar.cdw.description = gp.description;
                    srVar.cdw.bGS = bdVar;
                    com.tencent.mm.sdk.b.a.sFg.m(srVar);
                }
                if (bdVar.getType() == 49 && !bi.oW(gp.canvasPageXml)) {
                    f fVar = new f();
                    fVar.bGg.bGh = gp.canvasPageXml;
                    com.tencent.mm.sdk.b.a.sFg.m(fVar);
                }
                g gVar = new g();
                gp.a(gVar);
                gVar.field_msgId = bdVar.field_msgId;
                if (ao.cbY().fI(bdVar.field_msgId) != null || !ao.cbY().b(gVar)) {
                    return null;
                }
                if (gp.type == 40) {
                    b fH = ao.asF().fH(bdVar.field_msgId);
                    k gv = k.gv(c);
                    if (fH == null) {
                        l.a(null, bdVar.field_msgId, 0, null, null, gv.dzu, gp.type, 0);
                    }
                    au.DF().a(new ac(bdVar.field_msgId, bdVar.field_msgSvrId, null), 0);
                }
                return a;
            }
        }
    }

    static String a(byte[] bArr, boolean z, boolean z2) {
        return o.Pf().a(9, bArr, z, CompressFormat.PNG, z2);
    }

    private b a(a aVar, String str, g.a aVar2) {
        com.tencent.mm.storage.bd bdVar;
        com.tencent.mm.ak.a.a Pj;
        String str2;
        com.tencent.mm.ak.a.a.c.a aVar3;
        int i;
        com.tencent.mm.storage.bd bdVar2;
        b bVar;
        Map z;
        ml mlVar;
        mp mpVar;
        Map map;
        long currentTimeMillis;
        bt btVar;
        int i2;
        String oV;
        by byVar = aVar.dIN;
        au.HU();
        com.tencent.mm.plugin.messenger.foundation.a.a.f FT = c.FT();
        au.HU();
        i FZ = c.FZ();
        String GF = q.GF();
        String a = ab.a(byVar.rcj);
        String a2 = ab.a(byVar.rck);
        Object obj = (FZ.has(a) || GF.equals(a)) ? 1 : null;
        bd.b iF = bd.iF(byVar.rco);
        String str3 = null;
        if (iF != null) {
            str3 = iF.dCl;
        }
        String str4 = s.hK(str3) ? "notifymessage" : obj != null ? a2 : a;
        com.tencent.mm.storage.bd I = FT.I(str4, byVar.rcq);
        x.i("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage svrid:%d localid:%d", new Object[]{Long.valueOf(byVar.rcq), Long.valueOf(I.field_msgId)});
        if (I.field_msgId != 0 && I.field_createTime + 604800000 < bd.o(str4, (long) byVar.lOH)) {
            x.w("MicroMsg.AppMessageExtension", "dkmsgid doInsertMessage msg Too Old Remove it. svrid:%d localid:%d", new Object[]{Long.valueOf(byVar.rcq), Long.valueOf(I.field_msgId)});
            bd.aU(I.field_msgId);
            I.setMsgId(0);
        }
        if (I.field_msgId == 0) {
            I = new com.tencent.mm.storage.bd();
            I.ax(byVar.rcq);
            I.ay(bd.o(str4, (long) byVar.lOH));
            bdVar = I;
        } else {
            bdVar = I;
        }
        if (aVar2.dwl != null) {
            bdVar.ew(aVar2.dwl.cGK);
            x.i("MicroMsg.AppMessageExtension", "[chatting_exp] expidstr:%s", new Object[]{bdVar.cGK});
        }
        bdVar.setType(l.d(aVar2));
        bdVar.setContent(bdVar.cky() ? aVar2.content : str);
        if (bdVar.cky()) {
            bdVar.eu(aVar2.cGB);
        }
        if (byVar.rcm == 2 && bdVar.field_msgId == 0) {
            Object obj2;
            switch (bdVar.getType()) {
                case -1879048191:
                case -1879048190:
                case -1879048189:
                    obj2 = 1;
                    break;
                default:
                    obj2 = null;
                    break;
            }
            if (obj2 == null) {
                boolean z2 = aVar2.type == 2;
                byte[] a3 = ab.a(byVar.rcn);
                if (af.exs) {
                    x.w("MicroMsg.AppMessageExtension", "Test.useCdnDownThumb  set img buf null !!!!!!!");
                    a3 = null;
                }
                if (!bi.bC(a3)) {
                    if (aVar2.type == 33 || aVar2.type == 36) {
                        str3 = o.Pf().a(a3, CompressFormat.PNG);
                    } else {
                        str3 = a(a3, z2, bdVar.cmm());
                    }
                    if (bi.oW(str3)) {
                        x.w("MicroMsg.AppMessageExtension", "thumbData MsgInfo content:%s", new Object[]{bdVar.field_content});
                    }
                    if (!bi.oW(str3)) {
                        bdVar.eq(str3);
                        x.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path" + str3);
                    }
                } else if (!bi.oW(aVar2.dwE) && !bi.oW(aVar2.dwL)) {
                    long j = bdVar.field_msgSvrId;
                    str3 = aVar2.dwL;
                    String str5 = aVar2.dwE;
                    int i3 = aVar2.dwF;
                    x.i("MicroMsg.AppMessageExtension", "getThumbByCdn msgsvrid:%d aes:%s thumblen:%d url:%s talker:%s bigThumb:%b", new Object[]{Long.valueOf(bdVar.field_msgSvrId), str3, Integer.valueOf(i3), str5, str4, Boolean.valueOf(z2)});
                    long VF = bi.VF();
                    int i4 = aVar2 != null ? aVar2.type : 0;
                    String o = o.Pf().o(bi.VF(), "", "");
                    com.tencent.mm.modelcdntran.i iVar = new com.tencent.mm.modelcdntran.i();
                    iVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("downappthumb", bdVar.field_createTime, str4, String.valueOf(j));
                    iVar.field_fullpath = o;
                    iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_THUMBIMAGE;
                    iVar.field_totalLen = i3;
                    iVar.field_aesKey = str3;
                    iVar.field_fileId = str5;
                    iVar.field_priority = com.tencent.mm.modelcdntran.b.dOl;
                    iVar.field_chattype = s.fq(str4) ? 1 : 0;
                    x.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 1] chatType[%d] talker[%s] ", new Object[]{Integer.valueOf(iVar.field_chattype), str4});
                    iVar.dPV = new 1(this, j, str5, VF, i3, str4, o, i4, z2);
                    com.tencent.mm.modelcdntran.g.ND().b(iVar, -1);
                } else if (!bi.oW(aVar2.thumburl)) {
                    x.d("MicroMsg.AppMessageExtension", "get cdn image " + aVar2.thumburl);
                    str3 = com.tencent.mm.a.g.u((bi.VF()).getBytes());
                    GF = o.Pf().getFullPath(str3);
                    o.Pf();
                    str3 = com.tencent.mm.ak.g.lM(str3);
                    Pj = o.Pj();
                    str2 = aVar2.thumburl;
                    aVar3 = new com.tencent.mm.ak.a.a.c.a();
                    aVar3.dXA = GF;
                    aVar3.dXy = true;
                    Pj.a(str2, null, aVar3.Pt());
                    bdVar.eq(str3);
                    x.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path " + GF);
                }
                if (obj == null) {
                    bdVar.eX(1);
                    bdVar.ep(str4);
                    i = byVar.hcd;
                    bdVar2 = bdVar;
                } else {
                    bdVar.eX(0);
                    bdVar.ep(str4);
                    if (byVar.hcd > 3) {
                        i = byVar.hcd;
                        bdVar2 = bdVar;
                    } else {
                        i = 3;
                        bdVar2 = bdVar;
                    }
                }
                bdVar2.setStatus(i);
                if (aVar2.type == 2001 && aVar2.showType == 1) {
                    if (!TextUtils.isEmpty(aVar2.dyf) || TextUtils.isEmpty(aVar2.dyg) || aVar2.dyh <= 0) {
                        x.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
                    } else {
                        x.i("MicroMsg.AppMessageExtension", "ljd:this is new year msg! send predownload image event!");
                        ai aiVar = new ai();
                        aiVar.bHG = new ai.a();
                        aiVar.bHG.bHI = aVar2.dyg;
                        aiVar.bHG.bHH = aVar2.dyf;
                        aiVar.bHG.bHJ = aVar2.dyh;
                        com.tencent.mm.sdk.b.a.sFg.m(aiVar);
                    }
                }
                if (aVar2.type == 2001) {
                    try {
                        if (!bi.cX(aVar2.dyr)) {
                            for (String str32 : aVar2.dyr) {
                                String[] split = str32.split(",");
                                if (split != null && split.length > 0) {
                                    str32 = split[0];
                                    if (!bi.oW(str32) && str32.equals(q.GF())) {
                                        bdVar.fg(bdVar.field_flag | 8);
                                        x.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
                                        p(true, bdVar.field_talker);
                                    }
                                }
                            }
                        } else if (!"1001".equals(aVar2.dyb)) {
                            tm tmVar = new tm();
                            tmVar.ceZ.bWW = str;
                            com.tencent.mm.sdk.b.a.sFg.m(tmVar);
                            p(false, bdVar.field_talker);
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.AppMessageExtension", "check c2c payer list error: %s", new Object[]{e.getMessage()});
                    }
                    x.i("MicroMsg.AppMessageExtension", "paymsgid: %s", new Object[]{aVar2.dye});
                }
                bdVar.dt(byVar.rco);
                if (iF != null) {
                    bdVar.ev(iF.dCq);
                    bdVar.et(iF.dCp);
                }
                bd.a(bdVar, aVar);
                if (bdVar.field_msgId != 0) {
                    bdVar.setMsgId(bd.i(bdVar));
                    r rVar = new r();
                    rVar.bGR.bGS = bdVar;
                    rVar.bGR.bGT = aVar2;
                    com.tencent.mm.sdk.b.a.sFg.m(rVar);
                    bVar = new b(bdVar, true);
                } else {
                    FT.b(byVar.rcq, bdVar);
                    bVar = new b(bdVar, false);
                }
                if (bdVar.getType() == 301989937 && s.hI(bdVar.field_talker)) {
                    bdVar.setMsgId(0);
                }
                if (bdVar.cmg() && "notifymessage".equals(bdVar.field_talker)) {
                    z = bl.z(bdVar.field_content, "msg");
                    if (z != null) {
                        String oV2 = bi.oV((String) z.get(".msg.fromusername"));
                        if (com.tencent.mm.storage.ab.gr(oV2)) {
                            ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.n.c.class)).b(oV2, null);
                            x.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", new Object[]{oV2});
                        }
                    }
                }
                if (bdVar.getType() == 536870961) {
                    com.tencent.mm.y.b bVar2 = (com.tencent.mm.y.b) aVar2.u(com.tencent.mm.y.b.class);
                    mn mnVar = new mn();
                    mnVar.bXv.bXs = bdVar.field_msgId;
                    mnVar.bXv.bXw = bVar2.bXu;
                    mnVar.bXv.bWW = str;
                    if (bdVar.field_isSend == 1) {
                        x.d("MicroMsg.AppMessageExtension", "fromuser: %s, touser: %s", new Object[]{a, a2});
                        mnVar.bXv.username = bdVar.field_talker;
                    }
                    com.tencent.mm.sdk.b.a.sFg.m(mnVar);
                    if (mnVar.bXv.bWW != null) {
                        bdVar.setContent(mnVar.bXv.bWW);
                        FT.a(bdVar.field_msgId, bdVar);
                    }
                }
                if (!bi.oW(aVar2.dyk) && bdVar.getType() == 436207665) {
                    mlVar = new ml();
                    mlVar.bXr.bXs = bdVar.field_msgId;
                    mlVar.bXr.bWW = str;
                    com.tencent.mm.sdk.b.a.sFg.m(mlVar);
                }
                if (aVar2.type == 2000 && !bi.oW(aVar2.dxB)) {
                    mpVar = new mp();
                    mpVar.bXy.bXz = aVar2.dxB;
                    mpVar.bXy.bJC = bdVar.field_msgId;
                    mpVar.bXy.bXA = aVar2;
                    com.tencent.mm.sdk.b.a.sFg.m(mpVar);
                    p(false, bdVar.field_talker);
                }
                map = aVar2.dzf;
                str2 = bi.aG((String) map.get(".msg.appmsg.ext_pay_info.pay_type"), "");
                if ((str2.equals("wx_f2f") || str2.equals("wx_md")) && bVar.dIR) {
                    currentTimeMillis = System.currentTimeMillis() - bdVar.field_createTime;
                    x.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", new Object[]{str2, Long.valueOf(bdVar.field_createTime), Long.valueOf(System.currentTimeMillis())});
                    btVar = new bt();
                    i2 = bi.getInt((String) map.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
                    oV = bi.oV((String) map.get(".msg.appmsg.ext_pay_info.pay_feetype"));
                    str32 = bi.oV((String) map.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
                    if (!(i2 <= 0 || bi.oW(oV) || bi.oW(str32))) {
                        btVar.bJf.fee = i2;
                        btVar.bJf.bJg = oV;
                        btVar.bJf.bJh = str32;
                        btVar.bJf.bJi = str2;
                        btVar.bJf.btC = currentTimeMillis;
                        btVar.bJf.source = 0;
                        com.tencent.mm.sdk.b.a.sFg.m(btVar);
                    }
                }
                return bVar;
            }
        }
        if (!bi.oW(aVar2.thumburl)) {
            x.d("MicroMsg.AppMessageExtension", "get cdn image " + aVar2.thumburl);
            str32 = com.tencent.mm.a.g.u((bi.VF()).getBytes());
            if (aVar2.type == 2001) {
                str32 = com.tencent.mm.a.g.u((aVar2.thumburl).getBytes());
            }
            GF = o.Pf().getFullPath(str32);
            o.Pf();
            str32 = com.tencent.mm.ak.g.lM(str32);
            Pj = o.Pj();
            str2 = aVar2.thumburl;
            aVar3 = new com.tencent.mm.ak.a.a.c.a();
            aVar3.dXA = GF;
            aVar3.dXy = true;
            Pj.a(str2, null, aVar3.Pt());
            bdVar.eq(str32);
            x.d("MicroMsg.AppMessageExtension", "new thumbnail saved, path " + GF);
        }
        if (obj == null) {
            bdVar.eX(0);
            bdVar.ep(str4);
            if (byVar.hcd > 3) {
                i = byVar.hcd;
                bdVar2 = bdVar;
            } else {
                i = 3;
                bdVar2 = bdVar;
            }
        } else {
            bdVar.eX(1);
            bdVar.ep(str4);
            i = byVar.hcd;
            bdVar2 = bdVar;
        }
        bdVar2.setStatus(i);
        if (TextUtils.isEmpty(aVar2.dyf)) {
        }
        x.e("MicroMsg.AppMessageExtension", "ljd:this is new year msg! don't send predownload image event, because image preload data is illegal!");
        if (aVar2.type == 2001) {
            try {
                if (!bi.cX(aVar2.dyr)) {
                    for (String str322 : aVar2.dyr) {
                        String[] split2 = str322.split(",");
                        if (split2 != null && split2.length > 0) {
                            str322 = split2[0];
                            if (!bi.oW(str322) && str322.equals(q.GF())) {
                                bdVar.fg(bdVar.field_flag | 8);
                                x.i("MicroMsg.AppMessageExtension", "check c2c payer list, myself is payer, add red flag");
                                p(true, bdVar.field_talker);
                            }
                        }
                    }
                } else if (!"1001".equals(aVar2.dyb)) {
                    tm tmVar2 = new tm();
                    tmVar2.ceZ.bWW = str;
                    com.tencent.mm.sdk.b.a.sFg.m(tmVar2);
                    p(false, bdVar.field_talker);
                }
            } catch (Exception e2) {
                x.e("MicroMsg.AppMessageExtension", "check c2c payer list error: %s", new Object[]{e2.getMessage()});
            }
            x.i("MicroMsg.AppMessageExtension", "paymsgid: %s", new Object[]{aVar2.dye});
        }
        bdVar.dt(byVar.rco);
        if (iF != null) {
            bdVar.ev(iF.dCq);
            bdVar.et(iF.dCp);
        }
        bd.a(bdVar, aVar);
        if (bdVar.field_msgId != 0) {
            FT.b(byVar.rcq, bdVar);
            bVar = new b(bdVar, false);
        } else {
            bdVar.setMsgId(bd.i(bdVar));
            r rVar2 = new r();
            rVar2.bGR.bGS = bdVar;
            rVar2.bGR.bGT = aVar2;
            com.tencent.mm.sdk.b.a.sFg.m(rVar2);
            bVar = new b(bdVar, true);
        }
        bdVar.setMsgId(0);
        z = bl.z(bdVar.field_content, "msg");
        if (z != null) {
            String oV22 = bi.oV((String) z.get(".msg.fromusername"));
            if (com.tencent.mm.storage.ab.gr(oV22)) {
                ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.n.c.class)).b(oV22, null);
                x.d("MicroMsg.AppMessageExtension", "trigger to get app brand WxaInfo(%s)", new Object[]{oV22});
            }
        }
        if (bdVar.getType() == 536870961) {
            com.tencent.mm.y.b bVar22 = (com.tencent.mm.y.b) aVar2.u(com.tencent.mm.y.b.class);
            mn mnVar2 = new mn();
            mnVar2.bXv.bXs = bdVar.field_msgId;
            mnVar2.bXv.bXw = bVar22.bXu;
            mnVar2.bXv.bWW = str;
            if (bdVar.field_isSend == 1) {
                x.d("MicroMsg.AppMessageExtension", "fromuser: %s, touser: %s", new Object[]{a, a2});
                mnVar2.bXv.username = bdVar.field_talker;
            }
            com.tencent.mm.sdk.b.a.sFg.m(mnVar2);
            if (mnVar2.bXv.bWW != null) {
                bdVar.setContent(mnVar2.bXv.bWW);
                FT.a(bdVar.field_msgId, bdVar);
            }
        }
        mlVar = new ml();
        mlVar.bXr.bXs = bdVar.field_msgId;
        mlVar.bXr.bWW = str;
        com.tencent.mm.sdk.b.a.sFg.m(mlVar);
        mpVar = new mp();
        mpVar.bXy.bXz = aVar2.dxB;
        mpVar.bXy.bJC = bdVar.field_msgId;
        mpVar.bXy.bXA = aVar2;
        com.tencent.mm.sdk.b.a.sFg.m(mpVar);
        p(false, bdVar.field_talker);
        map = aVar2.dzf;
        str2 = bi.aG((String) map.get(".msg.appmsg.ext_pay_info.pay_type"), "");
        currentTimeMillis = System.currentTimeMillis() - bdVar.field_createTime;
        x.i("MicroMsg.AppMessageExtension", "pay voice msg: %s, create: %s, current: %s", new Object[]{str2, Long.valueOf(bdVar.field_createTime), Long.valueOf(System.currentTimeMillis())});
        btVar = new bt();
        i2 = bi.getInt((String) map.get(".msg.appmsg.ext_pay_info.pay_fee"), 0);
        oV = bi.oV((String) map.get(".msg.appmsg.ext_pay_info.pay_feetype"));
        str322 = bi.oV((String) map.get(".msg.appmsg.ext_pay_info.pay_outtradeno"));
        btVar.bJf.fee = i2;
        btVar.bJf.bJg = oV;
        btVar.bJf.bJh = str322;
        btVar.bJf.bJi = str2;
        btVar.bJf.btC = currentTimeMillis;
        btVar.bJf.source = 0;
        com.tencent.mm.sdk.b.a.sFg.m(btVar);
        return bVar;
    }

    private static void p(boolean z, String str) {
        if (!bi.oW(str)) {
            x.i("MicroMsg.AppMessageExtension", "updateC2CAAMsgMark, mark: %s, talker: %s", new Object[]{Boolean.valueOf(z), str});
            au.HU();
            com.tencent.mm.storage.ai Yq = c.FW().Yq(str);
            if (Yq != null) {
                if (z) {
                    Yq.gf(16777216);
                } else {
                    Yq.gg(16777216);
                }
                au.HU();
                c.FW().a(Yq, str);
            }
        }
    }

    public final void h(com.tencent.mm.storage.bd bdVar) {
        if (bdVar == null) {
            x.e("MicroMsg.AppMessageExtension", "[onPreDelMessage] msg == null");
            return;
        }
        x.d("MicroMsg.AppMessageExtension", "onPreDelMessage " + bdVar.field_imgPath);
        sq sqVar = new sq();
        sqVar.cdv.path = bdVar.field_imgPath;
        com.tencent.mm.sdk.b.a.sFg.m(sqVar);
        String str = bdVar.field_content;
        if (str != null) {
            g.a gp = g.a.gp(str);
            if (gp != null && gp.type == 6) {
                FileOp.deleteFile(e.dgj + gp.title);
                FileOp.deleteFile(e.dgj + gp.title + "_tmp");
            }
        }
    }

    public final boolean a(a aVar, String str, long j, String str2, String str3, int i, String str4) {
        String o = o.Pf().o("Note_" + str, "", "");
        if (FileOp.cn(o)) {
            return false;
        }
        this.qzR = aVar;
        com.tencent.mm.modelcdntran.i iVar = new com.tencent.mm.modelcdntran.i();
        iVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("downappthumb", j, str4, str);
        iVar.field_fullpath = o;
        iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
        iVar.field_totalLen = i;
        iVar.field_aesKey = str2;
        iVar.field_fileId = str3;
        iVar.field_priority = com.tencent.mm.modelcdntran.b.dOl;
        iVar.field_chattype = s.fq(str4) ? 1 : 0;
        x.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 2] chatType[%d] user[%s] ", new Object[]{Integer.valueOf(iVar.field_chattype), str4});
        iVar.dPV = new 2(this, str3, aVar);
        com.tencent.mm.modelcdntran.g.ND().b(iVar, -1);
        return true;
    }
}
