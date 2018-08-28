package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.do;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class ExdeviceWCLanSDKUtil$4 implements a {
    final /* synthetic */ ExdeviceWCLanSDKUtil ivm;

    ExdeviceWCLanSDKUtil$4(ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil) {
        this.ivm = exdeviceWCLanSDKUtil;
    }

    public final void e(int i, Object... objArr) {
        byte[] bArr;
        String string;
        String string2;
        Throwable e;
        do doVar;
        if (i == 16 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof String) && (objArr[1] instanceof byte[])) {
            bArr = (byte[]) objArr[1];
            try {
                JSONObject jSONObject = new JSONObject(new String((String) objArr[0]));
                string = jSONObject.getString("deviceType");
                try {
                    string2 = jSONObject.getString("deviceId");
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                string = null;
            }
            x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = " + new String(bArr));
            doVar = new do();
            doVar.bLw.byN = string2;
            doVar.bLw.data = bArr;
            doVar.bLw.bKC = string;
            com.tencent.mm.sdk.b.a.sFg.m(doVar);
        }
        return;
        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
        x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in receive notify callback");
        string2 = null;
        x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = " + new String(bArr));
        doVar = new do();
        doVar.bLw.byN = string2;
        doVar.bLw.data = bArr;
        doVar.bLw.bKC = string;
        com.tencent.mm.sdk.b.a.sFg.m(doVar);
    }
}
