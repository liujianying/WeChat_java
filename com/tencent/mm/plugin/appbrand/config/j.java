package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.sdk.platformtools.x;

public enum j {
    ;

    public static long rQ(String str) {
        long j;
        AppBrandSysConfig qa = a.qa(str);
        String str2 = "MicroMsg.AppServiceSettingRemoteManager";
        String str3 = "getMaxFileStorageSize, (null == config) = %b, MaxFileStorageSize = %d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(qa == null);
        objArr[1] = Long.valueOf(qa == null ? -1 : qa.fqZ);
        x.i(str2, str3, objArr);
        if (qa == null || qa.fqZ <= 0) {
            j = 10;
        } else {
            j = qa.fqZ;
        }
        return j * 1048576;
    }
}
