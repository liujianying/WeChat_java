package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dp;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class ExdeviceWCLanSDKUtil$1 implements a {
    final /* synthetic */ ExdeviceWCLanSDKUtil ivm;

    ExdeviceWCLanSDKUtil$1(ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil) {
        this.ivm = exdeviceWCLanSDKUtil;
    }

    public final void e(int i, Object... objArr) {
        String string;
        Throwable e;
        if (i == 10 && objArr != null) {
            String string2;
            try {
                JSONObject jSONObject = new JSONObject(new String((byte[]) objArr[0]));
                JSONObject jSONObject2 = jSONObject.getJSONObject("deviceInfo");
                string = jSONObject2.getString("deviceType");
                try {
                    string2 = jSONObject2.getString("deviceId");
                } catch (Exception e2) {
                    e = e2;
                    string2 = null;
                }
                try {
                    if (!jSONObject.isNull("manufacturerData")) {
                        this.ivm.ivh.put(string2, jSONObject.getString("manufacturerData"));
                    }
                    dp dpVar = new dp();
                    dpVar.bLx.byN = string2;
                    if (this.ivm.ivh.containsKey(string2)) {
                        String str = (String) this.ivm.ivh.get(string2);
                        if (!bi.oW(str)) {
                            dpVar.bLx.bLy = str.getBytes();
                        }
                        this.ivm.ivh.remove(string2);
                    }
                    dpVar.bLx.aoy = false;
                    com.tencent.mm.sdk.b.a.sFg.m(dpVar);
                } catch (Exception e3) {
                    e = e3;
                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                    x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "json decode failed in disc package callback!");
                    if (string != null) {
                    }
                    x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanDeviceDiscPackageCallbackReceiver! ");
                }
            } catch (Exception e4) {
                e = e4;
                string2 = null;
                string = null;
            }
            if (string != null || string2 == null) {
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanDeviceDiscPackageCallbackReceiver! ");
            }
        }
    }
}
