package com.tencent.mm.plugin.exdevice.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Base64;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.g.a.df;
import com.tencent.mm.g.a.dg;
import com.tencent.mm.g.a.di;
import com.tencent.mm.g.a.dt;
import com.tencent.mm.g.a.du;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.g.a.dy;
import com.tencent.mm.g.a.ea;
import com.tencent.mm.g.a.ek;
import com.tencent.mm.g.a.en;
import com.tencent.mm.g.a.ep;
import com.tencent.mm.g.a.eq;
import com.tencent.mm.g.a.hu;
import com.tencent.mm.g.a.kw;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.i.g;
import com.tencent.mm.plugin.exdevice.i.j;
import com.tencent.mm.plugin.exdevice.i.k;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.g.8;
import com.tencent.mm.plugin.exdevice.model.i.a;
import com.tencent.mm.plugin.exdevice.service.ExDeviceService;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.pluginsdk.o.h;
import com.tencent.mm.protocal.c.aef;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {
    private final long bsL = 300000;
    public com.tencent.mm.sdk.b.c hdn = new 21(this);
    public com.tencent.mm.sdk.b.c itA = new 23(this);
    public com.tencent.mm.sdk.b.c itB = new 34(this);
    public com.tencent.mm.sdk.b.c itC = new com.tencent.mm.sdk.b.c<eq>() {
        {
            this.sFo = eq.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            eq eqVar = (eq) bVar;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceUnBindHardDeviceEvent");
            ad.aHl().oZ(0);
            eqVar = eqVar;
            if (bi.oW(eqVar.bMu.bKC)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "brandName is null, can not unbind device");
                return false;
            }
            alx alx = new alx();
            alx.hbO = "";
            alx.reT = eqVar.bMu.bKC;
            au.DF().a(new x(alx, 1), 0);
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c itD = new 43(this);
    public com.tencent.mm.sdk.b.c itE = new 44(this);
    public com.tencent.mm.sdk.b.c itF = new 45(this);
    public com.tencent.mm.sdk.b.c itG = new 46(this);
    public com.tencent.mm.sdk.b.c itH = new 2(this);
    public com.tencent.mm.sdk.b.c itI = new 3(this);
    public com.tencent.mm.sdk.b.c itJ = new 4(this);
    public com.tencent.mm.sdk.b.c itK = new 5(this);
    public com.tencent.mm.sdk.b.c itL = new 6(this);
    public com.tencent.mm.sdk.b.c itM = new com.tencent.mm.sdk.b.c<ea>() {
        {
            this.sFo = ea.class.getName().hashCode();
        }
    };
    public com.tencent.mm.sdk.b.c itN = new 8(this);
    public com.tencent.mm.sdk.b.c itO = new com.tencent.mm.sdk.b.c<df>() {
        {
            this.sFo = df.class.getName().hashCode();
        }
    };
    public com.tencent.mm.sdk.b.c itP = new 10(this);
    public com.tencent.mm.sdk.b.c itQ = new 11(this);
    public com.tencent.mm.sdk.b.c itR = new 13(this);
    public com.tencent.mm.sdk.b.c itS = new 14(this);
    public com.tencent.mm.sdk.b.c itT = new 15(this);
    public com.tencent.mm.sdk.b.c itU = new com.tencent.mm.sdk.b.c<en>() {
        {
            this.sFo = en.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            en enVar = (en) bVar;
            if (enVar == null || !(enVar instanceof en)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "event is not instanceof ExDeviceSimpleBTUploadDataToServerEvent");
                return false;
            }
            enVar = enVar;
            if (e.c(enVar.bMq.mac, enVar.bMq.bKC, enVar.bMq.data)) {
                enVar.bMr.bKE = true;
                return true;
            }
            enVar.bMr.bKE = false;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c itV = new 17(this);
    public com.tencent.mm.sdk.b.c itW = new 18(this);
    public com.tencent.mm.sdk.b.c itX = new 19(this);
    public com.tencent.mm.sdk.b.c itY = new com.tencent.mm.sdk.b.c<kw>() {
        {
            this.sFo = kw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            if (((kw) bVar) == null) {
                x.w("MicroMsg.exdevice.ExdeviceEventManager", "handleOnAuthSyncEvent, event is null.");
            } else {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleOnAuthSyncEvent");
            }
            return false;
        }
    };
    public com.tencent.mm.sdk.b.c itZ = new com.tencent.mm.sdk.b.c<ky>() {
        {
            this.sFo = ky.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "OnSubCoreInited, process : %s", new Object[]{ad.getProcessName()});
            return !ad.cif();
        }
    };
    List<b> itw = new LinkedList();
    Map<String, b> itx = new HashMap();
    public com.tencent.mm.sdk.b.c ity = new 1(this);
    public com.tencent.mm.sdk.b.c itz = new 12(this);
    public com.tencent.mm.sdk.b.c iua = new 24(this);
    public com.tencent.mm.sdk.b.c iub = new 25(this);
    public com.tencent.mm.sdk.b.c iuc = new 26(this);
    public com.tencent.mm.sdk.b.c iud = new com.tencent.mm.sdk.b.c<ep>() {
        {
            this.sFo = ep.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ep epVar = (ep) bVar;
            g gVar = e.this.ium;
            if (!gVar.iuu) {
                x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "stopScanNetworkDevice...");
                Java2CExDevice.stopScanWCLanDevice();
                gVar.iuu = true;
            }
            au.Em().H(new 8(gVar));
            au.DF().b(1717, gVar);
            j.aGV().b(14, gVar.iuN);
            j.aGV().b(12, gVar.iuO);
            j.aGV().b(13, gVar.iuP);
            j.aGV().b(15, gVar.iuQ);
            epVar.bMt.bLW = true;
            return true;
        }
    };
    public com.tencent.mm.sdk.b.c iue = new 28(this);
    public com.tencent.mm.sdk.b.c iuf = new 29(this);
    public com.tencent.mm.sdk.b.c iug = new 30(this);
    public com.tencent.mm.sdk.b.c iuh = new 31(this);
    public com.tencent.mm.sdk.b.c iui = new 32(this);
    public com.tencent.mm.sdk.b.c iuj = new 33(this);
    public com.tencent.mm.sdk.b.c iuk = new 35(this);
    ExdeviceWCLanSDKUtil iul;
    g ium;
    private boolean iun = false;
    private c iuo;
    ag mHandler;

    /* renamed from: com.tencent.mm.plugin.exdevice.model.e$39 */
    class AnonymousClass39 implements a {
        final /* synthetic */ dw iur;

        AnonymousClass39(dw dwVar) {
            this.iur = dwVar;
        }

        public final void ew(boolean z) {
            if (z) {
                e.this.Y(this.iur.bLH.op, this.iur.bLH.userName);
            }
        }
    }

    private class c implements Runnable {
        List<com.tencent.mm.plugin.exdevice.h.b> dEx;

        public c(List<com.tencent.mm.plugin.exdevice.h.b> list) {
            this.dEx = list;
        }

        public final void run() {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "Wifi device heart beat");
            if (this.dEx != null && this.dEx.size() > 0) {
                for (com.tencent.mm.plugin.exdevice.h.b bVar : this.dEx) {
                    u.aHG().a(new k(bVar.field_brandName, bVar.field_deviceType, bVar.field_deviceID, 1));
                }
                e.this.mHandler.postDelayed(this, 300000);
            }
        }
    }

    public e() {
        HandlerThread Xs = com.tencent.mm.sdk.f.e.Xs("wifi_device_heart_beat");
        Xs.start();
        this.mHandler = new ag(Xs.getLooper());
    }

    final boolean c(b bVar) {
        dg dgVar = (dg) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "ExDeviceGetLanDeviceInfosEvent: brandName=%s, context=%s", new Object[]{dgVar.bKS.bKC, dgVar.bKS.context});
        if (zU(dgVar.bKS.bKC)) {
            LinkedList An = ad.aHe().An(dgVar.bKS.bKC);
            JSONArray jSONArray = new JSONArray();
            try {
                Iterator it = An.iterator();
                while (it.hasNext()) {
                    com.tencent.mm.plugin.exdevice.h.b bVar2 = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                    if (!An.isEmpty() && bi.oV(bVar2.field_connProto).contains("4")) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("deviceId", bVar2.field_deviceID);
                        if (this.iul.zY(bVar2.field_deviceID)) {
                            jSONObject.put("state", "connected");
                        } else {
                            jSONObject.put("state", "disconnected");
                        }
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[]{e.getMessage()});
            }
            dgVar.bKT.bKR = jSONArray;
            dgVar.bKT.bKE = true;
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[]{jSONArray.toString()});
        } else {
            dgVar.bKT.bKR = null;
            dgVar.bKT.bKE = false;
        }
        return true;
    }

    static boolean f(String str, List<com.tencent.mm.plugin.exdevice.h.b> list) {
        String host = Uri.parse(str).getHost();
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "is url...");
        JSONArray jSONArray = null;
        boolean z = false;
        for (com.tencent.mm.plugin.exdevice.h.b bVar : list) {
            String str2 = bVar.cCX;
            String str3 = bVar.cCY;
            if (str3 != null && str3.length() > 0 && str2 != null && str2.contains("wxmsg_url")) {
                JSONArray jSONArray2;
                try {
                    jSONArray2 = new JSONObject(str3).getJSONArray("wxmsg_url");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", e, "", new Object[0]);
                    jSONArray2 = jSONArray;
                }
                int length = jSONArray2.length();
                int i = 0;
                while (i < length) {
                    try {
                        if (jSONArray2.getString(i).equals(host)) {
                            z = true;
                            break;
                        }
                        i++;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceEventManager", e2, "", new Object[0]);
                    }
                }
                if (z) {
                    break;
                }
                jSONArray = jSONArray2;
            }
        }
        return z;
    }

    static boolean g(String str, List<com.tencent.mm.plugin.exdevice.h.b> list) {
        if (str == null) {
            return false;
        }
        boolean z;
        hu huVar = new hu();
        huVar.bRf.bKW = str;
        com.tencent.mm.sdk.b.a.sFg.m(huVar);
        bsu bsu = huVar.bRg.bRh;
        int i = bsu.sqc.ruz;
        String str2;
        if (i == 1) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "is photo...");
            for (com.tencent.mm.plugin.exdevice.h.b bVar : list) {
                str2 = bVar.cCX;
                if (str2 != null && str2.contains("wxmsg_image")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else if (i == 4) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "is music...");
            for (com.tencent.mm.plugin.exdevice.h.b bVar2 : list) {
                str2 = bVar2.cCX;
                if (str2 != null && str2.contains("wxmsg_music")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else if (i == 15) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "is sight...");
            for (com.tencent.mm.plugin.exdevice.h.b bVar22 : list) {
                str2 = bVar22.cCX;
                if (str2 != null && str2.contains("wxmsg_video")) {
                    z = true;
                    break;
                }
            }
            z = false;
        } else {
            z = i == 3 ? f(bsu.sqc.jPK, (List) list) : false;
        }
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "isSupportsSnsInfo = " + z + ", snsLocalId = " + str);
        return z;
    }

    static boolean d(b bVar) {
        df dfVar = (df) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetDeviceInfosEvent: brandName=%s, context=%s", new Object[]{dfVar.bKP.bKC, dfVar.bKP.context});
        LinkedList An = ad.aHe().An(dfVar.bKP.bKC);
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator it = An.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.exdevice.h.b bVar2 = (com.tencent.mm.plugin.exdevice.h.b) it.next();
                if (!An.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("deviceId", bVar2.field_deviceID);
                    if (u.aHF().cL(bVar2.field_mac)) {
                        jSONObject.put("state", "connected");
                    } else {
                        jSONObject.put("state", "disconnected");
                    }
                    jSONArray.put(jSONObject);
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "Ex in handleGetDeviceInfosEvent, %s", new Object[]{e.getMessage()});
        }
        dfVar.bKQ.bKR = jSONArray;
        dfVar.bKQ.bKE = true;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "GetDeviceInfos: %s", new Object[]{jSONArray.toString()});
        return true;
    }

    static boolean e(b bVar) {
        ea eaVar = (ea) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSendDataToDeviceEvent: brandName=%s, deviceId=%s", new Object[]{eaVar.bLO.bKC, eaVar.bLO.byN});
        if (bi.bC(eaVar.bLO.data)) {
            eaVar.bLP.bKE = false;
            return false;
        }
        com.tencent.mm.plugin.exdevice.h.b Al = ad.aHe().Al(eaVar.bLO.byN);
        if (Al == null) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
            eaVar.bLP.bKE = false;
            return false;
        } else if (!u.aHF().cL(Al.field_mac)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't connect");
            eaVar.bLP.bKE = false;
            return false;
        } else if (u.aHF().cR(Al.field_mac)) {
            if (aa.aHb().iuY) {
                aa.aHb().pa(a(Al));
            }
            u.aHG().a(new g(eaVar.bLO.data, 10001, Al.field_mac));
            eaVar.bLP.bKE = true;
            return true;
        } else {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "haven't authed");
            eaVar.bLP.bKE = false;
            return false;
        }
    }

    static int a(com.tencent.mm.plugin.exdevice.h.b bVar) {
        if (bi.oV(bVar.field_connProto).contains("1")) {
            return 1;
        }
        if (bi.oV(bVar.field_connProto).contains("3")) {
            return 0;
        }
        return -1;
    }

    final boolean f(b bVar) {
        di diVar = (di) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleGetTicketEvent: brandName=%s, deviceId=%s, type=%d", new Object[]{diVar.bLa.bKC, diVar.bLa.byN, Integer.valueOf(diVar.bLa.type)});
        aef aef = new aef();
        aef.rIr = diVar.bLa.type;
        aef.rIs = 0;
        aef.rgS = new alx();
        aef.rgS.hbO = diVar.bLa.byN;
        aef.rgS.reT = diVar.bLa.bKC;
        LinkedList linkedList = new LinkedList();
        linkedList.add(aef);
        36 36 = new 36(this, diVar);
        z zVar = new z(linkedList, diVar.bLa.bKC, diVar.bLa.bLc);
        au.DF().a(543, 36);
        if (au.DF().a(zVar, 0)) {
            return false;
        }
        x.e("MicroMsg.exdevice.ExdeviceEventManager", "MMCore.getNetSceneQueue().doScene failed!!!");
        au.DF().b(543, 36);
        diVar.bLb.bLd = true;
        diVar.bLb.bLe = null;
        if (diVar.bJX == null) {
            return true;
        }
        diVar.bJX.run();
        return true;
    }

    final boolean g(b bVar) {
        dy dyVar = (dy) bVar;
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleScanDeviceEvent: brandName=%s, op=%s, btVersion=%s", new Object[]{dyVar.bLJ.bKC, Boolean.valueOf(dyVar.bLJ.bKD), Integer.valueOf(dyVar.bLJ.bLL)});
        int i = dyVar.bLJ.bLL;
        if (!(i == 0 || i == 1)) {
            if (com.tencent.mm.plugin.h.a.e.a.cT(ad.getContext())) {
                x.w("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, use defalut BLE", new Object[]{Integer.valueOf(i)});
                i = 0;
            } else {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "invalid btVersion %s, return fail", new Object[]{Integer.valueOf(i)});
                dyVar.bLK.bKE = false;
                return false;
            }
        }
        if (dyVar.bLJ.bKD) {
            aa aHb = aa.aHb();
            String str = dyVar.bLJ.bKC;
            AnonymousClass37 anonymousClass37 = new aa.a() {
                public final void a(String str, byte[] bArr, boolean z) {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "OnScanDevice %s", new Object[]{str});
                    if (bArr == null) {
                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, isCompleted=%s", new Object[]{str, Boolean.valueOf(z)});
                    } else {
                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnScanDeviceResult. deviceId=%s, base64(broadcastData)=%s, isCompleted=%s", new Object[]{str, Base64.encodeToString(bArr, 0), Boolean.valueOf(z)});
                    }
                    dv dvVar = new dv();
                    dvVar.bLG.bLy = bArr;
                    dvVar.bLG.byN = str;
                    dvVar.bLG.aoy = z;
                    com.tencent.mm.sdk.b.a.sFg.a(dvVar, Looper.getMainLooper());
                }
            };
            x.i("MicroMsg.exdevice.ScanDeviceLogic", "startScanDevice, brandName=%s", new Object[]{str});
            if (bi.oW(str)) {
                x.i("MicroMsg.exdevice.ScanDeviceLogic", "brand name is null");
            } else {
                aHb.ius = str;
                aHb.ivM = anonymousClass37;
                aHb.ivN.clear();
                Iterator it = aHb.ivO.iterator();
                while (it.hasNext()) {
                    l lVar = (l) it.next();
                    if (lVar != null) {
                        au.DF().c(lVar);
                    }
                }
                aHb.ivO.clear();
                synchronized (aa.dMd) {
                    aa.ivP.clear();
                }
                if (aHb.iuY) {
                    x.w("MicroMsg.exdevice.ScanDeviceLogic", "still scanning. just change brand name and callback");
                } else {
                    aHb.iuY = true;
                    au.DF().a(542, aHb);
                    ad.aHl().a(i, aHb);
                    x.i("MicroMsg.exdevice.ScanDeviceLogic", "should start scan, startTimer");
                    aHb.eVk.J(12000, 12000);
                }
            }
        } else {
            aa.aHb().pa(i);
        }
        dyVar.bLK.bKE = true;
        return true;
    }

    static boolean zU(String str) {
        d kH = f.kH(str);
        if (kH == null) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
            return false;
        }
        d.b bG = kH.bG(false);
        if (bG != null && bG.Ms() != null && bG.Ms().MC()) {
            return true;
        }
        x.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
        return false;
    }

    static boolean a(com.tencent.mm.plugin.exdevice.h.b bVar, int i, int i2) {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleSwitchViewEvent");
        if (bVar == null) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null.");
            return false;
        }
        String str = bVar.field_brandName;
        com.tencent.mm.plugin.exdevice.service.f.a cN = u.aHF().cN(bVar.field_mac);
        if (cN == null) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
            return false;
        }
        if (cN.bLv == 2) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "notify the connect device %s", new Object[]{str});
            u.aHG().a(new j(i, i2, bVar.field_mac));
        }
        ad.aHl().oZ(i == 1 ? 1 : 0);
        if (i == 2) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "now exit chattingui, do not notify change the subtitle");
            al alVar = (al) ad.aHl().itf.remove(Long.valueOf(bVar.field_mac));
            if (alVar != null) {
                alVar.SO();
            }
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "Device close strategy(%d)", new Object[]{Integer.valueOf(bVar.field_closeStrategy)});
            if (!((bVar.field_closeStrategy & 1) == 0 && u.aHF().cR(cN.iyK) && (2 == cN.bLv || cN.bLv == 0))) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "now the device is not auth or not connect  or closeStrategy is to close after exit, try to stop connetct, connet state is %d, device is %s", new Object[]{Integer.valueOf(cN.bLv), str});
                if (u.aHG().isY != null) {
                    u.aHG().isY.cT(cN.iyK);
                }
            }
            if (f.b(bVar)) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "try to disconnect simpleBTDevice(%s).", new Object[]{Long.valueOf(bVar.field_mac)});
                zV(com.tencent.mm.plugin.exdevice.j.b.cY(bVar.field_mac));
            }
            return true;
        } else if (2 == cN.bLv || h.qyk == null || !h.qyk.bSp()) {
            return true;
        } else {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "getWearCommand is null or wear has connected in the brandName.");
            return false;
        }
    }

    final boolean f(List<com.tencent.mm.plugin.exdevice.h.b> list, int i) {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleWifiDeviceSwitchViewEvent");
        if (list.size() == 0) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "HardDeviceInfo is null or nil.");
            return false;
        }
        int i2 = -1;
        switch (i) {
            case 1:
                if (this.iun) {
                    this.mHandler.removeCallbacks(this.iuo);
                }
                this.iuo = new c(list);
                this.mHandler.postDelayed(this.iuo, 300000);
                this.iun = true;
                i2 = 2;
                break;
            case 2:
                if (this.iun) {
                    this.mHandler.removeCallbacks(this.iuo);
                    this.iun = false;
                }
                i2 = 0;
                break;
        }
        for (com.tencent.mm.plugin.exdevice.h.b bVar : list) {
            u.aHG().a(new k(bVar.field_brandName, bVar.field_deviceType, bVar.field_deviceID, i2));
        }
        return true;
    }

    static boolean aGO() {
        LinkedList aHK = ad.aHe().aHK();
        if (aHK.isEmpty()) {
            x.i("MicroMsg.exdevice.ExdeviceEventManager", "get harddevice info is null or empty");
            return false;
        }
        ad.aHl().oZ(2);
        Iterator it = aHK.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.exdevice.h.b bVar = (com.tencent.mm.plugin.exdevice.h.b) it.next();
            au.HU();
            ab Yg = com.tencent.mm.model.c.FR().Yg(bVar.field_brandName);
            if (Yg == null || !com.tencent.mm.l.a.gd(Yg.field_type)) {
                x.e("MicroMsg.exdevice.ExdeviceEventManager", "%s is not my contact now, may be has been deleted", new Object[]{bVar.field_brandName});
            } else if ((bVar.field_connStrategy & 4) == 0) {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect Strategy is %d, no need to sync in main ui", new Object[]{Integer.valueOf(bVar.field_connStrategy)});
            } else {
                x.i("MicroMsg.exdevice.ExdeviceEventManager", "now try to connect %s", new Object[]{bVar.field_brandName});
                ad.aHl().a(bVar.field_brandName, bVar.field_mac, 0, true);
            }
        }
        return true;
    }

    static boolean aGP() {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "receive StopAllChannelEvent");
        ad.aHl();
        d.ev(false);
        ad.aHl().aGN();
        return true;
    }

    final boolean Y(int i, String str) {
        x.v("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI.");
        d kH = f.kH(str);
        if (kH == null) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "bizInfo is null");
            return false;
        }
        d.b bG = kH.bG(false);
        if (bG != null) {
            d.b.b Ms = bG.Ms();
            if (Ms != null && Ms.MC()) {
                List<com.tencent.mm.plugin.exdevice.h.b> An = ad.aHe().An(str);
                if (Ms.dLA == 1) {
                    List<com.tencent.mm.plugin.exdevice.h.b> aHK = ad.aHe().aHK();
                    if (aHK.size() != 0) {
                        for (com.tencent.mm.plugin.exdevice.h.b bVar : aHK) {
                            x.i("MicroMsg.exdevice.ExdeviceEventManager", "BLE hard device info, mac(%s), deviceId(%s), deviceType(%s), SimpleProtol(%d)", new Object[]{Long.valueOf(bVar.field_mac), bVar.field_deviceID, bVar.field_deviceType, Long.valueOf(bVar.cCW)});
                            if (0 != (bVar.cCW & 1)) {
                                An.add(bVar);
                            }
                        }
                    }
                }
                if (An == null) {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo is null.");
                    return false;
                } else if (An.size() == 0) {
                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "handleInChattingUI, hdInfo size is 0.");
                    return true;
                } else {
                    int i2 = 0;
                    int i3 = 0;
                    for (com.tencent.mm.plugin.exdevice.h.b bVar2 : An) {
                        if (bVar2 == null) {
                            x.e("MicroMsg.exdevice.ExdeviceEventManager", "hdInfo error");
                        } else if (bi.oV(bVar2.field_connProto).contains("4")) {
                            x.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Wifi biz, continue.", new Object[]{bVar2.field_brandName});
                        } else if ((bVar2.field_connStrategy & 16) != 0) {
                            x.i("MicroMsg.exdevice.ExdeviceEventManager", "%s, Connect stragegy(%d) ignore connection on chat, continue!!!", new Object[]{bVar2.field_brandName, Integer.valueOf(bVar2.field_connStrategy)});
                        } else {
                            int i4;
                            int i5;
                            int i6;
                            int i7;
                            if (bi.oV(bVar2.field_connProto).contains("1")) {
                                i7 = i2 + 1;
                                if (com.tencent.mm.plugin.h.a.e.a.atW()) {
                                    i4 = 1;
                                    i5 = i3;
                                    i6 = i7;
                                } else {
                                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "%s, device is BC, but you phone not support BC.", new Object[]{bVar2.field_brandName});
                                    i2 = i7;
                                }
                            } else if (bi.oV(bVar2.field_connProto).contains("3")) {
                                i7 = i3 + 1;
                                if (com.tencent.mm.plugin.h.a.e.a.cT(ad.getContext())) {
                                    i4 = 0;
                                    i5 = i7;
                                    i6 = i2;
                                } else {
                                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "device is BLE, but you phone not support BLE.");
                                    i3 = i7;
                                }
                            } else {
                                i4 = -1;
                                i5 = i3;
                                i6 = i2;
                            }
                            x.i("MicroMsg.exdevice.ExdeviceEventManager", "receive ExDeviceOpInChattingUIEventListener, op(%d), brandName(%s), connProto(%s),", new Object[]{Integer.valueOf(i), bVar2.field_brandName, bVar2.field_connProto});
                            if (i == 0) {
                                d aHl = ad.aHl();
                                long j = bVar2.field_mac;
                                x.i("MicroMsg.exdevice.ExdeviceConnectManager", "StopSyncTimer, device Id = %d", new Object[]{Long.valueOf(j)});
                                if (aHl.itg.containsKey(Long.valueOf(j))) {
                                    x.i("MicroMsg.exdevice.ExdeviceConnectManager", "Switch from main view to chatting view before exdevice sync timeout, just stop MTimerHandler");
                                    al alVar = (al) aHl.itg.remove(Long.valueOf(j));
                                    if (alVar != null) {
                                        alVar.SO();
                                    } else {
                                        x.e("MicroMsg.exdevice.ExdeviceConnectManager", "Remove deviceId(%d) from syncTimeOutMap failed!!!", new Object[]{Long.valueOf(j)});
                                    }
                                }
                                if (u.aHF().cL(bVar2.field_mac)) {
                                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "Enter chatting ui, find this deivce has been connected aready, device name = %s, device id = %d", new Object[]{bVar2.field_brandName, Long.valueOf(bVar2.field_mac)});
                                    if (u.aHF().cR(bVar2.field_mac)) {
                                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "This device is auth aready");
                                        e(bVar2.field_brandName, bVar2.field_url, 2, bVar2.field_deviceID);
                                        i3 = i5;
                                        i2 = i6;
                                    } else {
                                        x.i("MicroMsg.exdevice.ExdeviceEventManager", "This device has been connected but not auth yet.");
                                        i3 = i5;
                                        i2 = i6;
                                    }
                                } else if (!com.tencent.mm.plugin.exdevice.service.d.de(ad.getContext())) {
                                    x.e("MicroMsg.exdevice.ExdeviceEventManager", "service not running");
                                    i3 = i5;
                                    i2 = i6;
                                } else if (f.b(bVar2)) {
                                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect simple device, mac(%s), brandName(%s)", new Object[]{com.tencent.mm.plugin.exdevice.j.b.cY(bVar2.field_mac), bVar2.field_brandName});
                                    a(bVar2.field_brandName + bVar2.field_mac, new a(this, bVar2.field_brandName, com.tencent.mm.plugin.exdevice.j.b.cY(bVar2.field_mac), bVar2.field_url, bVar2.field_deviceID));
                                    zW(com.tencent.mm.plugin.exdevice.j.b.cY(bVar2.field_mac));
                                    i3 = i5;
                                    i2 = i6;
                                } else {
                                    x.i("MicroMsg.exdevice.ExdeviceEventManager", "Connect AirSync device, mac(%s), brandName(%s)", new Object[]{com.tencent.mm.plugin.exdevice.j.b.cY(bVar2.field_mac), bVar2.field_brandName});
                                    ad.aHl().oZ(1);
                                    ad.aHl().a(Long.valueOf(bVar2.field_mac), bVar2.field_connStrategy);
                                    ad.aHl().a(bVar2.field_brandName, bVar2.field_mac, i4);
                                    i3 = i5;
                                    i2 = i6;
                                }
                            } else if (i != 1) {
                                if (i == 2) {
                                    if (f.b(bVar2)) {
                                        zV(com.tencent.mm.plugin.exdevice.j.b.cY(bVar2.field_mac));
                                        i3 = i5;
                                        i2 = i6;
                                    } else {
                                        ad.aHl();
                                        d.cB(bVar2.field_mac);
                                    }
                                }
                                i3 = i5;
                                i2 = i6;
                            } else if (f.b(bVar2)) {
                                a(bVar2.field_brandName + bVar2.field_mac, new a(this, bVar2.field_brandName, com.tencent.mm.plugin.exdevice.j.b.cY(bVar2.field_mac), bVar2.field_url, bVar2.field_deviceID));
                                zW(com.tencent.mm.plugin.exdevice.j.b.cY(bVar2.field_mac));
                                i3 = i5;
                                i2 = i6;
                            } else {
                                ad.aHl().a(Long.valueOf(bVar2.field_mac), bVar2.field_connStrategy);
                                ad.aHl().a(bVar2.field_brandName, bVar2.field_mac, i4);
                                i3 = i5;
                                i2 = i6;
                            }
                        }
                    }
                    if (i2 + i3 <= 0) {
                        bj(str, -1);
                    } else if (!com.tencent.mm.plugin.h.a.e.a.atY()) {
                        x.w("MicroMsg.exdevice.ExdeviceEventManager", "System bluetooth is close");
                        bj(str, 0);
                    } else if (i3 > 0 && i2 == 0 && !com.tencent.mm.plugin.h.a.e.a.cT(ad.getContext())) {
                        bj(str, 1);
                    }
                    return true;
                }
            }
        }
        x.e("MicroMsg.exdevice.ExdeviceEventManager", "this is not hardware biz");
        return false;
    }

    private static boolean aGQ() {
        if (!com.tencent.mm.plugin.h.a.e.a.cT(ad.getContext())) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
            return false;
        } else if (com.tencent.mm.plugin.h.a.e.a.atY()) {
            return true;
        } else {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "Bluetooth is not open, Just leave");
            return false;
        }
    }

    public static boolean aGR() {
        x.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTScanDevice");
        if (aGQ()) {
            ad.aHq().aGU();
            return true;
        }
        x.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
        return false;
    }

    public static boolean zV(String str) {
        x.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTDisconnectDevice, mac(%s).", new Object[]{str});
        if (!aGQ()) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
            return false;
        } else if (bi.oW(str)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
            return false;
        } else {
            ad.aHq();
            h.cB(com.tencent.mm.plugin.exdevice.j.b.Az(str));
            return true;
        }
    }

    public final boolean zW(String str) {
        x.d("MicroMsg.exdevice.ExdeviceEventManager", "handleExDeviceSimpleBTConnectDevice");
        if (!aGQ()) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "isBTOpenAndBLESupported return false");
            return false;
        } else if (bi.oW(str)) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "mac is null or nil");
            return false;
        } else {
            ad.aHq().a(com.tencent.mm.plugin.exdevice.j.b.Az(str), new 40(this));
            return true;
        }
    }

    public final boolean o(String str, byte[] bArr) {
        String str2;
        String str3;
        Object[] objArr;
        if (bi.oW(str) || bi.bC(bArr)) {
            String str4;
            int i;
            str2 = "MicroMsg.exdevice.ExdeviceEventManager";
            str3 = "input error. mac = %s, dataLen = %d";
            objArr = new Object[2];
            if (bi.oW(str)) {
                str4 = "null";
            } else {
                str4 = "mac";
            }
            objArr[0] = str4;
            if (bi.bC(bArr)) {
                i = 0;
            } else {
                i = bArr.length;
            }
            objArr[1] = Integer.valueOf(i);
            x.e(str2, str3, objArr);
            return false;
        }
        str2 = "MicroMsg.exdevice.ExdeviceEventManager";
        str3 = "handleExDeviceSimpleBTSendDataToDevice. mac = %s, dataLen = %d";
        objArr = new Object[2];
        objArr[0] = bi.oW(str) ? "null" : str;
        objArr[1] = Integer.valueOf(bi.bC(bArr) ? 0 : bArr.length);
        x.e(str2, str3, objArr);
        long Az = com.tencent.mm.plugin.exdevice.j.b.Az(str);
        com.tencent.mm.plugin.exdevice.service.f.a cO = ad.aHq().iuZ.cO(Az);
        if (cO == null) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "can not find the hardevice connect state");
            return false;
        } else if (cO.bLv != 2) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "device is not connected.");
            return false;
        } else {
            ad.aHq();
            return h.a(Az, bArr, new 41(this));
        }
    }

    public static boolean c(String str, String str2, byte[] bArr) {
        String str3;
        String str4;
        Object[] objArr;
        if (bi.oW(str) || bi.oW(str2) || bi.bC(bArr)) {
            int i;
            str3 = "MicroMsg.exdevice.ExdeviceEventManager";
            str4 = "input error. mac = %s, brandName = %s, dataLen = %d";
            objArr = new Object[3];
            if (bi.oW(str)) {
                str = "null";
            }
            objArr[0] = str;
            if (bi.oW(str2)) {
                str2 = "null";
            }
            objArr[1] = str2;
            if (bi.bC(bArr)) {
                i = 0;
            } else {
                i = bArr.length;
            }
            objArr[2] = Integer.valueOf(i);
            x.e(str3, str4, objArr);
            return false;
        }
        str3 = "MicroMsg.exdevice.ExdeviceEventManager";
        str4 = "handleExDeviceSimpleBTUploadDataToServer. mac = %s, brandName = %s, dataLen = %d";
        objArr = new Object[3];
        objArr[0] = bi.oW(str) ? "null" : str;
        objArr[1] = bi.oW(str2) ? "null" : str2;
        objArr[2] = Integer.valueOf(bi.bC(bArr) ? 0 : bArr.length);
        x.d(str3, str4, objArr);
        com.tencent.mm.plugin.exdevice.h.b cX = ad.aHe().cX(com.tencent.mm.plugin.exdevice.j.b.Az(str));
        if (cX == null) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "device(mac=%s) not found in brand(brandName=%s)", new Object[]{str, str2});
            return false;
        }
        com.tencent.mm.plugin.h.a.b.a.a ad = com.tencent.mm.plugin.h.a.b.a.a.ad(bArr);
        if (1 != ad.hgC) {
            x.e("MicroMsg.exdevice.ExdeviceEventManager", "not step profile type %d != %d", new Object[]{Long.valueOf(1), Long.valueOf(ad.hgC)});
            return false;
        }
        com.tencent.mm.plugin.h.a.b.a.f fVar = (com.tencent.mm.plugin.h.a.b.a.f) ad;
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        ((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.sport.b.b.class)).a(cX.field_deviceID, cX.field_deviceType, (int) (instance.getTimeInMillis() / 1000), (int) (System.currentTimeMillis() / 1000), fVar.hip, "");
        return true;
    }

    public final void h(String str, String str2, boolean z) {
        List<b> linkedList;
        synchronized (this.itw) {
            linkedList = new LinkedList(this.itw);
        }
        for (b j : linkedList) {
            j.j(str, str2, z);
        }
        linkedList.clear();
        for (b j2 : this.itx.values()) {
            j2.j(str, str2, z);
        }
        x.d("MicroMsg.exdevice.ExdeviceEventManager", "simple BT on scan result: broadcastName=" + str + ", mac=" + str2 + ", isCompleted=" + z);
        ek ekVar = new ek();
        ekVar.bMl.bMf = str;
        ekVar.bMl.mac = str2;
        ekVar.bMl.aoy = z;
        com.tencent.mm.sdk.b.a.sFg.a(ekVar, Looper.getMainLooper());
    }

    public static void e(String str, String str2, int i, String str3) {
        lb lbVar = new lb();
        lbVar.bVp.op = 2;
        lbVar.bVp.bSJ = str;
        lbVar.bVp.bLv = i;
        lbVar.bVp.url = str2;
        lbVar.bVp.byN = str3;
        com.tencent.mm.sdk.b.a.sFg.a(lbVar, Looper.getMainLooper());
    }

    public static void bj(String str, int i) {
        lb lbVar = new lb();
        lbVar.bVp.op = 1;
        lbVar.bVp.bSJ = str;
        lbVar.bVp.aAk = i;
        com.tencent.mm.sdk.b.a.sFg.a(lbVar, Looper.getMainLooper());
    }

    public static void d(String str, String str2, byte[] bArr) {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnRecvDataFromDevice. deviceId=%s, brandName=%s", new Object[]{str, str2});
        du duVar = new du();
        duVar.bLF.byN = str;
        duVar.bLF.bKC = str2;
        duVar.bLF.data = bArr;
        com.tencent.mm.sdk.b.a.sFg.a(duVar, Looper.getMainLooper());
    }

    public static void ai(String str, boolean z) {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "notifyOnDeviceBindStateChange. deviceId=%s, isBound=%s", new Object[]{str, Boolean.valueOf(z)});
        dt dtVar = new dt();
        dtVar.bLE.byN = str;
        dtVar.bLE.bKz = z;
        com.tencent.mm.sdk.b.a.sFg.a(dtVar, Looper.getMainLooper());
    }

    public final boolean a(b bVar) {
        if (bVar == null || this.itw.contains(bVar)) {
            return false;
        }
        return this.itw.add(bVar);
    }

    public final boolean b(b bVar) {
        return bVar != null && this.itw.remove(bVar);
    }

    private b a(String str, b bVar) {
        return (b) this.itx.put(str, bVar);
    }

    static boolean aGS() {
        x.i("MicroMsg.exdevice.ExdeviceEventManager", "Wechat exit, stop ExDeviceService.");
        Context context = ad.getContext();
        try {
            ad.aHl().aGN();
        } catch (Throwable e) {
            x.w("MicroMsg.exdevice.ExDeviceServiceHelper", "unbindService() Service is not start by bindService.%s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.exdevice.ExDeviceServiceHelper", e, "", new Object[0]);
        }
        context.stopService(new Intent(context, ExDeviceService.class));
        return true;
    }
}
