package com.tencent.mm.plugin.exdevice.model;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.mm.ak.o;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.dd;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.bv;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.exdevice.b.k;
import com.tencent.mm.plugin.exdevice.f.b.b.a;
import com.tencent.mm.plugin.exdevice.f.b.b.b;
import com.tencent.mm.plugin.exdevice.f.b.b.e;
import com.tencent.mm.plugin.exdevice.h.c;
import com.tencent.mm.plugin.exdevice.i.g;
import com.tencent.mm.plugin.exdevice.service.f;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class ad implements ar {
    private static HashMap<Integer, d> cVM;
    private ab iwh = new ab();
    private b iwi;
    private c iwj;
    private com.tencent.mm.plugin.exdevice.f.b.b.d iwk;
    private a iwl;
    private b iwm;
    private e iwn;
    private e iwo;
    private d iwp;
    private com.tencent.mm.plugin.exdevice.f.b.c iwq;
    private com.tencent.mm.plugin.exdevice.f.b.a iwr;
    private com.tencent.mm.plugin.exdevice.f.a.c iws;
    private com.tencent.mm.ak.a.a iwt = null;
    private com.tencent.mm.ak.a.a.c iwu = null;
    private af iwv;
    private h iww;
    private bv.a iwx = new bv.a() {
        public final void a(com.tencent.mm.ab.d.a aVar) {
            if (ad.aHk() != null) {
                Object obj;
                ad.aHk();
                by byVar = aVar.dIN;
                x.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer");
                String a = ab.a(byVar.rcl);
                if (bi.oW(a)) {
                    x.e("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "msg content is null");
                } else {
                    Map z = bl.z(a, "sysmsg");
                    if (z != null && z.size() > 0) {
                        a = (String) z.get(".sysmsg.$type");
                        if (!bi.oW(a) && a.equalsIgnoreCase("wcdevicemsg")) {
                            a = (String) z.get(".sysmsg.wcdevicemsg.xml.ToUserName");
                            String str = (String) z.get(".sysmsg.wcdevicemsg.xml.FromUserName");
                            long j = bi.getLong((String) z.get(".sysmsg.wcdevicemsg.xml.CreateTime"), -1);
                            String str2 = (String) z.get(".sysmsg.wcdevicemsg.xml.MsgType");
                            String str3 = (String) z.get(".sysmsg.wcdevicemsg.xml.DeviceType");
                            String str4 = (String) z.get(".sysmsg.wcdevicemsg.xml.DeviceID");
                            int i = bi.getInt((String) z.get(".sysmsg.wcdevicemsg.xml.DeviceStatus"), -1);
                            x.i("MicroMsg.exdevice.ExDeviceWifiStatusMessageHandler", "parseMessageFromServer:tousr=" + a + ",fromuser=" + str + ",createtime=" + j + ",msgtype=" + str2 + ",devicetype=" + str3 + ",deviceid=" + str4 + ",devicestatus=" + i);
                            com.tencent.mm.plugin.exdevice.h.b Al = ad.aHe().Al(str4);
                            if (Al != null && bi.oV(Al.field_connProto).contains("4") && bi.oV(str2).contains("device_status")) {
                                if (i != 0) {
                                    ad.aHp();
                                    e.e(Al.field_brandName, Al.field_url, 2, Al.field_deviceID);
                                } else {
                                    ad.aHp();
                                    e.e(Al.field_brandName, Al.field_url, 4, Al.field_deviceID);
                                }
                                obj = 1;
                                if (obj == null) {
                                    a = ab.a(byVar.rcl);
                                    if (bi.oW(a)) {
                                        x.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
                                        return;
                                    }
                                    Map z2 = bl.z(a, "sysmsg");
                                    if (z2 == null || z2.size() <= 0) {
                                        x.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
                                        return;
                                    }
                                    a = (String) z2.get(".sysmsg.$type");
                                    if (bi.oW(a) || !a.equalsIgnoreCase("wcdevicemsg")) {
                                        x.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, type not wcdevicemsg");
                                        return;
                                    }
                                    x.i("MicroMsg.exdevice.ExDeviceMessageService", "newXml wcdevicemsg msgType = %s", new Object[]{bi.oV((String) z2.get(".sysmsg.wcdevicemsg.xml.MsgType"))});
                                    if (bi.oV((String) z2.get(".sysmsg.wcdevicemsg.xml.MsgType")).equals("device_relation")) {
                                        dd ddVar = new dd();
                                        ddVar.bKK.bKL = true;
                                        com.tencent.mm.sdk.b.a.sFg.m(ddVar);
                                        return;
                                    }
                                    a = (String) z2.get(".sysmsg.wcdevicemsg.xml.Content");
                                    x.i("MicroMsg.exdevice.ExDeviceMessageService", "contentBase64 = %s", new Object[]{a});
                                    if (bi.oW(a)) {
                                        x.e("MicroMsg.exdevice.ExDeviceMessageService", "Fuck off: contentBase64 is null");
                                        return;
                                    }
                                    try {
                                        byte[] decode = Base64.decode(a, 0);
                                        if (bi.bC(decode)) {
                                            x.e("MicroMsg.exdevice.ExDeviceMessageService", "null == decodedContent");
                                            return;
                                        }
                                        long j2 = bi.getLong((String) z2.get(".sysmsg.wcdevicemsg.xml.SessionID"), -1);
                                        x.i("MicroMsg.exdevice.ExDeviceMessageService", "------NewXml Receive------sessionId = %d, deviceId = %s, message content = %s, length = %d", new Object[]{Long.valueOf(j2), (String) z2.get(".sysmsg.wcdevicemsg.xml.DeviceID"), a, Integer.valueOf(decode.length)});
                                        Al = ad.aHe().Al(str);
                                        if (Al == null) {
                                            x.e("MicroMsg.exdevice.ExDeviceMessageService", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
                                        } else if (0 == j2) {
                                            u.aHG().a(new g(decode, 0, Al.field_mac));
                                        } else {
                                            k aGF = k.aGF();
                                            x.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Recivce sendDataToManufacturerResponse, sessionId = %d", new Object[]{Long.valueOf(j2)});
                                            Assert.assertTrue(j2 >= 0);
                                            k.c cVar = new k.c((byte) 0);
                                            cVar.mSessionId = j2;
                                            cVar.hfA = decode;
                                            aGF.mHandler.obtainMessage(3, cVar).sendToTarget();
                                        }
                                    } catch (Throwable e) {
                                        x.e("MicroMsg.exdevice.ExDeviceMessageService", "decode failed!!! %s", new Object[]{e.getMessage()});
                                        x.printErrStackTrace("MicroMsg.exdevice.ExDeviceMessageService", e, "", new Object[0]);
                                    }
                                }
                            }
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    a = ab.a(byVar.rcl);
                    if (bi.oW(a)) {
                        x.e("MicroMsg.exdevice.ExDeviceMessageService", "msg content is null");
                        return;
                    }
                    Map z22 = bl.z(a, "sysmsg");
                    if (z22 == null || z22.size() <= 0) {
                        x.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, no sysmsg");
                        return;
                    }
                    a = (String) z22.get(".sysmsg.$type");
                    if (bi.oW(a) || !a.equalsIgnoreCase("wcdevicemsg")) {
                        x.e("MicroMsg.exdevice.ExDeviceMessageService", "receiveMessage, type not wcdevicemsg");
                        return;
                    }
                    x.i("MicroMsg.exdevice.ExDeviceMessageService", "newXml wcdevicemsg msgType = %s", new Object[]{bi.oV((String) z22.get(".sysmsg.wcdevicemsg.xml.MsgType"))});
                    if (bi.oV((String) z22.get(".sysmsg.wcdevicemsg.xml.MsgType")).equals("device_relation")) {
                        dd ddVar2 = new dd();
                        ddVar2.bKK.bKL = true;
                        com.tencent.mm.sdk.b.a.sFg.m(ddVar2);
                        return;
                    }
                    a = (String) z22.get(".sysmsg.wcdevicemsg.xml.Content");
                    x.i("MicroMsg.exdevice.ExDeviceMessageService", "contentBase64 = %s", new Object[]{a});
                    if (bi.oW(a)) {
                        x.e("MicroMsg.exdevice.ExDeviceMessageService", "Fuck off: contentBase64 is null");
                        return;
                    }
                    try {
                        byte[] decode2 = Base64.decode(a, 0);
                        if (bi.bC(decode2)) {
                            x.e("MicroMsg.exdevice.ExDeviceMessageService", "null == decodedContent");
                            return;
                        }
                        long j22 = bi.getLong((String) z22.get(".sysmsg.wcdevicemsg.xml.SessionID"), -1);
                        x.i("MicroMsg.exdevice.ExDeviceMessageService", "------NewXml Receive------sessionId = %d, deviceId = %s, message content = %s, length = %d", new Object[]{Long.valueOf(j22), (String) z22.get(".sysmsg.wcdevicemsg.xml.DeviceID"), a, Integer.valueOf(decode2.length)});
                        Al = ad.aHe().Al(str);
                        if (Al == null) {
                            x.e("MicroMsg.exdevice.ExDeviceMessageService", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
                        } else if (0 == j22) {
                            u.aHG().a(new g(decode2, 0, Al.field_mac));
                        } else {
                            k aGF2 = k.aGF();
                            x.i("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Recivce sendDataToManufacturerResponse, sessionId = %d", new Object[]{Long.valueOf(j22)});
                            Assert.assertTrue(j22 >= 0);
                            k.c cVar2 = new k.c((byte) 0);
                            cVar2.mSessionId = j22;
                            cVar2.hfA = decode2;
                            aGF2.mHandler.obtainMessage(3, cVar2).sendToTarget();
                        }
                    } catch (Throwable e2) {
                        x.e("MicroMsg.exdevice.ExDeviceMessageService", "decode failed!!! %s", new Object[]{e2.getMessage()});
                        x.printErrStackTrace("MicroMsg.exdevice.ExDeviceMessageService", e2, "", new Object[0]);
                    }
                }
            }
        }
    };
    m.b iwy = new 9(this);

    static /* synthetic */ void a(ad adVar) {
        try {
            ah.i(new 2(adVar), 30000);
        } catch (Throwable e) {
            x.e("MicroMsg.exdevice.SubCoreExDevice", "[hakon][step] exception in deviceFeaturesKVStat, %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.exdevice.SubCoreExDevice", e, "", new Object[0]);
        }
    }

    static {
        HashMap hashMap = new HashMap();
        cVM = hashMap;
        hashMap.put(Integer.valueOf("HARDDEVICEINFO_TABLE".hashCode()), new 1());
        cVM.put(Integer.valueOf("HARDDEVICERANKINFO_TABLE".hashCode()), new 3());
        cVM.put(Integer.valueOf("HARDDEVICERANKFOLLOWINFO_TABLE".hashCode()), new 4());
        cVM.put(Integer.valueOf("HARDDEVICELIKEINFO_TABLE".hashCode()), new 5());
        cVM.put(Integer.valueOf("HARDDEVICECHAMPIONINFO_TABLE".hashCode()), new 6());
        cVM.put(Integer.valueOf("HARDDEVICERANKDETAILINFO_TABLE".hashCode()), new 7());
    }

    public ad() {
        if (this.iwp == null) {
            this.iwp = new d();
        }
        if (this.iwo == null) {
            this.iwo = new e();
        }
        x.i("MicroMsg.exdevice.SubCoreExDevice", "create SubCoreExDevice.");
        com.tencent.mm.sdk.b.a.sFg.b(this.iwo.itZ);
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    private static ad aHd() {
        au.HN();
        ad adVar = (ad) bs.iK("plugin.exdevice");
        if (adVar != null) {
            return adVar;
        }
        x.w("MicroMsg.exdevice.SubCoreExDevice", "not found in MMCore, new one");
        adVar = new ad();
        au.HN().a("plugin.exdevice", adVar);
        return adVar;
    }

    public static c aHe() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aHd().iwj == null) {
            ad aHd = aHd();
            au.HU();
            aHd.iwj = new c(com.tencent.mm.model.c.FO());
        }
        return aHd().iwj;
    }

    public static com.tencent.mm.plugin.exdevice.f.b.b.d aHf() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aHd().iwk == null) {
            ad aHd = aHd();
            au.HU();
            aHd.iwk = new com.tencent.mm.plugin.exdevice.f.b.b.d(com.tencent.mm.model.c.FO());
        }
        return aHd().iwk;
    }

    public static a aHg() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aHd().iwl == null) {
            ad aHd = aHd();
            au.HU();
            aHd.iwl = new a(com.tencent.mm.model.c.FO());
        }
        return aHd().iwl;
    }

    public static com.tencent.mm.ak.a.a aHh() {
        if (aHd().iwt == null) {
            aHd().iwt = o.Pj();
        }
        return aHd().iwt;
    }

    public static com.tencent.mm.ak.a.a.c Aa(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.exdevice.SubCoreExDevice", "newImageOptions failed, url is null or nil, return default.");
            ad aHd = aHd();
            if (aHd.iwu == null) {
                com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
                o.Pk();
                aVar.dXU = null;
                aVar.dXF = 640;
                aVar.dXE = 640;
                aVar.dXw = false;
                aVar.dXy = true;
                aHd.iwu = aVar.Pt();
            }
            return aHd().iwu;
        }
        com.tencent.mm.ak.a.a.c.a aVar2 = new com.tencent.mm.ak.a.a.c.a();
        aVar2.dXF = 640;
        aVar2.dXE = 640;
        aVar2.dXw = false;
        aVar2.dXx = true;
        au.HU();
        aVar2.dXB = com.tencent.mm.model.c.Gb();
        return aVar2.Pt();
    }

    public static b aHi() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aHd().iwm == null) {
            ad aHd = aHd();
            au.HU();
            aHd.iwm = new b(com.tencent.mm.model.c.FO());
        }
        return aHd().iwm;
    }

    public static e aHj() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aHd().iwn == null) {
            ad aHd = aHd();
            au.HU();
            aHd.iwn = new e(com.tencent.mm.model.c.FO());
        }
        return aHd().iwn;
    }

    public static b aHk() {
        com.tencent.mm.kernel.g.Eg().Ds();
        if (aHd().iwi == null) {
            aHd().iwi = new b();
        }
        return aHd().iwi;
    }

    public static d aHl() {
        if (aHd().iwp == null) {
            aHd().iwp = new d();
        }
        return aHd().iwp;
    }

    public static com.tencent.mm.plugin.exdevice.f.b.c aHm() {
        if (aHd().iwq == null) {
            aHd().iwq = new com.tencent.mm.plugin.exdevice.f.b.c();
        }
        return aHd().iwq;
    }

    public static com.tencent.mm.plugin.exdevice.f.b.a aHn() {
        if (aHd().iwr == null) {
            aHd().iwr = new com.tencent.mm.plugin.exdevice.f.b.a();
        }
        return aHd().iwr;
    }

    public static com.tencent.mm.plugin.exdevice.f.a.c aHo() {
        if (aHd().iws == null) {
            aHd().iws = new com.tencent.mm.plugin.exdevice.f.a.c();
        }
        return aHd().iws;
    }

    public static e aHp() {
        if (aHd().iwo == null) {
            aHd().iwo = new e();
        }
        return aHd().iwo;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        au.HU();
        com.tencent.mm.model.c.FR().a(this.iwy);
        au.DF().a(538, k.aGF());
        this.iwv = new af();
        com.tencent.mm.sdk.b.a.sFg.b(this.iwh);
        au.getSysCmdMsgExtension().a("wcdevicemsg", this.iwx, true);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itA);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itB);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itC);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itV);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itz);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().ity);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itD);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itE);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itF);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itW);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itG);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itH);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itI);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itK);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itJ);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itO);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itM);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itN);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itP);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itX);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().hdn);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itL);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itQ);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itR);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itS);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itT);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().iug);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().iuh);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().iui);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().iuk);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().iuj);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().iua);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().iub);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().iuc);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().iud);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().iue);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().iuf);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itY);
        com.tencent.mm.sdk.b.a.sFg.b(aHp().itZ);
        i iVar = i.ivn;
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "addSceneEndListener");
        au.DF().a(539, iVar);
        com.tencent.mm.compatible.a.a.a(19, new com.tencent.mm.compatible.a.a.a() {
            public final void run() {
                ad.a(ad.this);
            }
        });
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        au.HU();
        com.tencent.mm.model.c.FR().b(this.iwy);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().itA);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().itB);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().itC);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().itV);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().itX);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().itz);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().ity);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().itD);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().itE);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().itF);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().itW);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().iug);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().iuh);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().iui);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().iuk);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().iuj);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().iua);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().iub);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().iuc);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().iud);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().iue);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().iuf);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().itH);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().itY);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().itZ);
        x.i("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "releaseAllSharePreferences");
        SharedPreferences sharedPreferences = com.tencent.mm.sdk.platformtools.ad.getContext().getSharedPreferences("exdevice_pref", 0);
        if (sharedPreferences == null) {
            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "null == sp");
        } else if (!sharedPreferences.edit().clear().commit()) {
            x.e("MicroMsg.exdevice.ExdeviceSharePreferencesManager", "sp.edit().clear().commit() Failed!!!");
        }
        f aHF = u.aHF();
        x.i("MicroMsg.exdevice.ExdeviceInfoManager", "delAllDeviceAuthFlag");
        if (aHF.iyJ == null) {
            x.e("MicroMsg.exdevice.ExdeviceInfoManager", "null == exdeviceInfoList");
        } else {
            for (Entry entry : aHF.iyJ.entrySet()) {
                f.a aVar = (f.a) entry.getValue();
                aVar.iyN = false;
                entry.setValue(aVar);
            }
        }
        au.DF().b(538, k.aGF());
        k.isJ = null;
        com.tencent.mm.sdk.b.a.sFg.c(this.iwh);
        au.getSysCmdMsgExtension().b("wcdevicemsg", this.iwx, true);
        com.tencent.mm.sdk.b.a.sFg.c(aHp().itG);
        if (aHd().iwi != null) {
            aHd();
        }
        i iVar = i.ivn;
        x.i("MicroMsg.exdevice.GetBoundDeviceLogic", "removeSceneEndListener");
        au.DF().b(539, iVar);
        d dVar = aHd().iwp;
        if (!(dVar.itf == null || dVar.itf.isEmpty())) {
            for (Entry entry2 : dVar.itf.entrySet()) {
                ((al) entry2.getValue()).SO();
            }
            dVar.itf.clear();
        }
        if (aHd().iwq != null) {
            com.tencent.mm.plugin.exdevice.f.b.c cVar = aHd().iwq;
            au.DF().b(1042, cVar);
            au.DF().b(1041, cVar);
            au.DF().b(1043, cVar);
            au.DF().b(1040, cVar);
        }
        if (aHd().iwt != null) {
            aHd().iwt.detach();
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.iwv.cXu);
    }

    public static h aHq() {
        if (aHd().iww == null) {
            aHd().iww = new h();
        }
        return aHd().iww;
    }
}
