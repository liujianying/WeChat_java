package com.tencent.mm.plugin.freewifi.b;

import android.database.MatrixCursor;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.freewifi.b.a.a;
import com.tencent.mm.plugin.freewifi.d.j;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.asu;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.asw;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class c$1 implements e {
    final /* synthetic */ LinkedList jjp;
    final /* synthetic */ int jjq;
    final /* synthetic */ ez jjr;
    final /* synthetic */ c jjs;

    c$1(c cVar, LinkedList linkedList, int i, ez ezVar) {
        this.jjs = cVar;
        this.jjp = linkedList;
        this.jjq = i;
        this.jjr = ezVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        Exception e;
        synchronized (this.jjs) {
            asu aPe = ((j) lVar).aPe();
            this.jjs.dF(System.currentTimeMillis());
            this.jjs.pY(aPe.jjn <= 0 ? 180 : aPe.jjn);
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "resp.reqMaxApCount=" + aPe.jjm);
            int i3 = aPe.jjm <= 0 ? HardCoderJNI.sHCDBDELAY_WRITE : aPe.jjm;
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "_reqMaxApCount = " + i3);
            this.jjs.pX(i3);
            if (i == 0 && i2 == 0) {
                LinkedList linkedList = aPe.rVd;
                MatrixCursor matrixCursor = null;
                try {
                    MatrixCursor matrixCursor2 = new MatrixCursor(c.aY());
                    try {
                        Map hashMap = new HashMap();
                        i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 >= linkedList.size()) {
                                break;
                            }
                            asw asw = (asw) linkedList.get(i4);
                            hashMap.put(asw.ssid + "-" + asw.bssid, Integer.valueOf(i4));
                            i3 = i4 + 1;
                        }
                        i3 = 0;
                        while (true) {
                            int i5 = i3;
                            if (i5 < this.jjp.size()) {
                                asv asv = (asv) this.jjp.get(i5);
                                asw asw2 = new asw();
                                asw2.ssid = asv.ssid;
                                asw2.bssid = asv.bssid;
                                asw2.bMF = asv.bMF;
                                asw2.rVe = 0;
                                asw2.rVf = null;
                                asw2.jie = 0;
                                asw2.bIQ = null;
                                if (hashMap.get(asw2.ssid + "-" + asw2.bssid) != null) {
                                    Integer num = (Integer) hashMap.get(asw2.ssid + "-" + asw2.bssid);
                                    if (linkedList.get(num.intValue()) != null) {
                                        asw2.rVe = ((asw) linkedList.get(num.intValue())).rVe;
                                        asw2.rVf = ((asw) linkedList.get(num.intValue())).rVf;
                                        asw2.jie = ((asw) linkedList.get(num.intValue())).jie;
                                        asw2.bIQ = ((asw) linkedList.get(num.intValue())).bIQ;
                                    }
                                }
                                if (asw2.jie == 4 || asw2.jie == 31) {
                                    matrixCursor2.addRow(new Object[]{asw2.ssid, asw2.bssid, Integer.valueOf(asw2.bMF), Integer.valueOf(asw2.rVe), asw2.rVf, Integer.valueOf(this.jjs.aOo()), Integer.valueOf(this.jjs.aOp())});
                                    x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", asw2.ssid, asw2.bssid, Integer.valueOf(asw2.bMF), Integer.valueOf(asw2.rVe), asw2.rVf, Integer.valueOf(this.jjs.aOo()), Integer.valueOf(this.jjs.aOp()));
                                    if (asw2.rVe == 1 && this.jjq == 1) {
                                        a.aOl().d(asw2.ssid, asw2.bssid, asw2.bIQ, asw2.jie);
                                        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cached : ssid=%s, bssid=%s, apKey=%s, protocolType=%d. ", asw2.ssid, asw2.bssid, asw2.bIQ, Integer.valueOf(asw2.jie));
                                    }
                                } else {
                                    matrixCursor2.addRow(new Object[]{asw2.ssid, asw2.bssid, Integer.valueOf(asw2.bMF), Integer.valueOf(0), null, Integer.valueOf(this.jjs.aOo()), Integer.valueOf(this.jjs.aOp())});
                                    x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "cursor add row. ssid=%s, bssid=%s, rssi=%d, isWechatwifi=%d, wechatShopName=%s, maxApCount=%d, reqIntervalSeconds=%d", asw2.ssid, asw2.bssid, Integer.valueOf(asw2.bMF), Integer.valueOf(0), null, Integer.valueOf(this.jjs.aOo()), Integer.valueOf(this.jjs.aOp()));
                                }
                                i3 = i5 + 1;
                            } else {
                                c.a(this.jjr, matrixCursor2);
                                return;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        matrixCursor = matrixCursor2;
                        if (matrixCursor != null) {
                            matrixCursor.close();
                        }
                        x.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", e);
                        c.a(this.jjs, this.jjr, 1108, "cursor exception.");
                    }
                } catch (Exception e3) {
                    e = e3;
                    if (matrixCursor != null) {
                        matrixCursor.close();
                    }
                    x.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", e);
                    c.a(this.jjs, this.jjr, 1108, "cursor exception.");
                }
            } else if (i2 == -30035) {
                c.a(this.jjs, this.jjr, 1110, "Too many ap. The number of ap requested per time should be between 1 and " + this.jjs.aOo() + ".");
            } else {
                c.a(this.jjs, this.jjr, 1121, "Server returns errtype= " + i + ", errcode=" + i2 + ", errMsg=" + m.BR(str) + ".");
            }
        }
    }
}
