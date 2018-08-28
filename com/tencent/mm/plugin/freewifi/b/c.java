package com.tencent.mm.plugin.freewifi.b;

import android.database.MatrixCursor;
import com.tencent.mm.g.a.ez;
import com.tencent.mm.plugin.freewifi.d.j;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    private static final String[] jjk = new String[]{"ssid", "bssid", "rssi", "isWechatWifi", "wechatShopName", "maxApCount", "intervalSeconds"};
    private static final String[] jjl = new String[]{"errcode", "errmsg", "maxApCount", "intervalSeconds"};
    private int jjm;
    private int jjn;
    private long jjo;

    private static class a {
        private static c jjt = new c();
    }

    /* synthetic */ c(byte b) {
        this();
    }

    static /* synthetic */ void a(ez ezVar, MatrixCursor matrixCursor) {
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setResult. errorcode=%d, errmsg=%s", new Object[]{Integer.valueOf(1), null});
        ezVar.bNa.bNc = matrixCursor;
        ezVar.bNa.bMG = 1;
        if (ezVar.bJX != null) {
            ezVar.bJX.run();
        }
    }

    private c() {
        this.jjm = 200;
        this.jjn = 180;
        this.jjo = 0;
    }

    public static c aOn() {
        return a.jjt;
    }

    public final synchronized void a(ez ezVar) {
        int i = 0;
        synchronized (this) {
            x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "method getWifiList called. reqMaxApCount=" + aOo() + "; reqIntervalSeconds=" + aOp());
            String[] strArr = ezVar.bMZ.bNb;
            if (strArr == null || strArr.length == 0) {
                a(ezVar, 1101, "Args is empty.");
            } else {
                int i2;
                StringBuilder stringBuilder = new StringBuilder();
                for (i2 = 0; i2 < strArr.length; i2++) {
                    stringBuilder.append("args[" + i2 + "] = " + strArr[i2]);
                }
                x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "args: " + stringBuilder.toString());
                try {
                    if (Integer.valueOf(strArr[0]).intValue() != 1) {
                        a(ezVar, 1103, "Wechant installed currently only supports version 1.");
                    } else if (strArr.length != 3) {
                        a(ezVar, 1104, "Args.length should be 3, but now it is " + strArr.length + ".");
                    } else {
                        try {
                            i2 = Integer.valueOf(strArr[2]).intValue();
                            if (i2 != 1 && i2 != 2) {
                                a(ezVar, 1106, "Args[2] should be integer 1 (from setting) or integer 2 (from background).");
                            } else if (aOq() != 0 && System.currentTimeMillis() - aOq() < ((long) aOp()) && i2 == 2) {
                                a(ezVar, 1109, "Request frequence is out of limit. The time btween two background request should be more than  " + this.jjn + " seconds.");
                            } else if (m.isEmpty(strArr[1])) {
                                a(ezVar, 1105, "Args[1] should be an ap list json string, but now it is empty.");
                            } else {
                                LinkedList linkedList = new LinkedList();
                                try {
                                    JSONArray jSONArray = new JSONArray(strArr[1]);
                                    if (jSONArray.length() > aOo()) {
                                        a(ezVar, 1110, "jsonArray.length()=" + jSONArray.length() + ". Too many ap. The number of ap requested per time should be between 1 and " + aOo() + ".");
                                    } else if (jSONArray.length() == 0) {
                                        a(ezVar, 1110, "jsonArray.length()=" + jSONArray.length() + ". Too many ap. The number of ap requested per time should be between 1 and " + aOo() + ".");
                                    } else {
                                        while (i < jSONArray.length()) {
                                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                                            asv asv = new asv();
                                            asv.ssid = m.BQ(jSONObject.getString("ssid"));
                                            asv.bssid = jSONObject.getString("bssid");
                                            asv.bMF = jSONObject.getInt("rssi");
                                            linkedList.add(asv);
                                            i++;
                                        }
                                        new j(linkedList, i2).b(new 1(this, linkedList, i2, ezVar));
                                    }
                                } catch (Exception e) {
                                    a(ezVar, 1105, "Args[1] is not a valid json array value and it should be a string like  [  {    \"ssid\": \"SSID_NAME\",    \"bssid\": \"0e:00:00:00:00:00\",    \"rssi\": -45  }].");
                                }
                            }
                        } catch (Exception e2) {
                            a(ezVar, 1107, "Args[2] is not a valid int value.");
                        }
                    }
                } catch (Exception e3) {
                    a(ezVar, 1102, "Args[0] is not an integer.");
                }
            }
        }
        return;
    }

    private void a(ez ezVar, int i, String str) {
        Exception e;
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "FreeWifiManufacturerGetWifiListHelper setErrorResult. errorcode=%d, errmsg=%s", new Object[]{Integer.valueOf(i), str});
        MatrixCursor matrixCursor;
        try {
            matrixCursor = new MatrixCursor(jjl);
            try {
                matrixCursor.addRow(new Object[]{Integer.valueOf(i), str, Integer.valueOf(aOo()), Integer.valueOf(aOp())});
                ezVar.bNa.bNc = matrixCursor;
                ezVar.bNa.bMG = 1;
                if (ezVar.bJX != null) {
                    ezVar.bJX.run();
                }
            } catch (Exception e2) {
                e = e2;
                if (matrixCursor != null) {
                    matrixCursor.close();
                }
                x.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[]{e});
                ezVar.bNa.bNc = null;
                ezVar.bNa.bMG = 1;
                if (ezVar.bJX != null) {
                    ezVar.bJX.run();
                }
            }
        } catch (Exception e3) {
            e = e3;
            matrixCursor = null;
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            x.e("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "exception in getWifiList syncTaskCur.", new Object[]{e});
            ezVar.bNa.bNc = null;
            ezVar.bNa.bMG = 1;
            if (ezVar.bJX != null) {
                ezVar.bJX.run();
            }
        }
    }

    public final synchronized int aOo() {
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "getReqMaxApCount() returns " + this.jjm);
        return this.jjm;
    }

    public final synchronized void pX(int i) {
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() param reqMaxApCount = " + i);
        this.jjm = i;
        x.i("MicroMsg.FreeWifi.FreeWifiManufacturerGetWifiListHelper", "setReqMaxApCount() this.reqMaxApCount = " + this.jjm);
    }

    public final synchronized int aOp() {
        return this.jjn;
    }

    public final synchronized void pY(int i) {
        this.jjn = i;
    }

    private synchronized long aOq() {
        return this.jjo;
    }

    public final synchronized void dF(long j) {
        this.jjo = j;
    }
}
