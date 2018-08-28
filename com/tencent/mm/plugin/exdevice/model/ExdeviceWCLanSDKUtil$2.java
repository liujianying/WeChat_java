package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dp;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class ExdeviceWCLanSDKUtil$2 implements a {
    final /* synthetic */ ExdeviceWCLanSDKUtil ivm;

    ExdeviceWCLanSDKUtil$2(ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil) {
        this.ivm = exdeviceWCLanSDKUtil;
    }

    public final void e(int i, Object... objArr) {
        String string;
        Exception e;
        String str = null;
        if (i == 14 && objArr != null && objArr.length > 0 && (objArr[0] instanceof byte[])) {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(new String((byte[]) objArr[0])).getJSONObject("deviceInfo");
                try {
                    string = jSONObject.getString("deviceType");
                    try {
                        str = jSONObject.getString("deviceId");
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    string = str;
                }
            } catch (Exception e4) {
                e = e4;
                jSONObject = str;
                string = str;
            }
            if (string != null || str == null) {
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
            }
            x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get device deviceType =" + string + ",deviceId = " + str);
            if (ad.aHe().Al(str) == null) {
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "hdInfo null, %s", new Object[]{str});
                return;
            }
            this.ivm.iuK.put(str, jSONObject.toString().getBytes());
            dp dpVar = new dp();
            dpVar.bLx.byN = str;
            if (this.ivm.ivh.containsKey(str)) {
                String str2 = (String) this.ivm.ivh.get(str);
                if (!bi.oW(str2)) {
                    dpVar.bLx.bLy = str2.getBytes();
                }
                this.ivm.ivh.remove(str);
            }
            dpVar.bLx.aoy = false;
            com.tencent.mm.sdk.b.a.sFg.m(dpVar);
            return;
        }
        return;
        x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in get device profile callback %s", new Object[]{e});
        if (string != null) {
        }
        x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceType or deviceId is null in mWCLanGetDeviceProfileCallbackReceiver! ");
    }
}
