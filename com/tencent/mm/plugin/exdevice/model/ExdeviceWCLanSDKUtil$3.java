package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.g.a.dn;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class ExdeviceWCLanSDKUtil$3 implements a {
    final /* synthetic */ ExdeviceWCLanSDKUtil ivm;

    ExdeviceWCLanSDKUtil$3(ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil) {
        this.ivm = exdeviceWCLanSDKUtil;
    }

    public final void e(int i, Object... objArr) {
        int intValue;
        Throwable e;
        String str = null;
        if (i == 13 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof String) && (objArr[1] instanceof Integer)) {
            String string;
            String str2 = (String) objArr[0];
            intValue = ((Integer) objArr[1]).intValue();
            try {
                JSONObject jSONObject = new JSONObject(new String(str2));
                string = jSONObject.getString("deviceId");
                try {
                    str = jSONObject.getString("deviceType");
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                string = str;
            }
            switch (intValue) {
                case 1:
                    this.ivm.ivl = 2;
                    this.ivm.iuM.put(string, Boolean.valueOf(true));
                    x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device connect!");
                    break;
                default:
                    this.ivm.ivl = 0;
                    this.ivm.iuM.put(string, Boolean.valueOf(false));
                    x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device disconnect!");
                    break;
            }
            if (this.ivm.ivk) {
                if (this.ivm.ivl == 2) {
                    this.ivm.h(true, string);
                }
                dn dnVar = new dn();
                dnVar.bLu.byN = string;
                dnVar.bLu.bLv = this.ivm.ivl;
                dnVar.bLu.bKC = str;
                com.tencent.mm.sdk.b.a.sFg.m(dnVar);
            }
        }
        return;
        x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
        x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in device ConnState notify callback");
        switch (intValue) {
            case 1:
                this.ivm.ivl = 2;
                this.ivm.iuM.put(string, Boolean.valueOf(true));
                x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device connect!");
                break;
            default:
                this.ivm.ivl = 0;
                this.ivm.iuM.put(string, Boolean.valueOf(false));
                x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device disconnect!");
                break;
        }
        if (this.ivm.ivk) {
            if (this.ivm.ivl == 2) {
                this.ivm.h(true, string);
            }
            dn dnVar2 = new dn();
            dnVar2.bLu.byN = string;
            dnVar2.bLu.bLv = this.ivm.ivl;
            dnVar2.bLu.bKC = str;
            com.tencent.mm.sdk.b.a.sFg.m(dnVar2);
        }
    }
}
