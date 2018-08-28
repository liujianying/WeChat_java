package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.x;

public final class f {
    public static boolean a(String str, Context context, x xVar, String str2) {
        if (bi.oW(str)) {
            return false;
        }
        c cVar = null;
        if (str.startsWith("weixin://openNativeUrl/weixinHB")) {
            cVar = new a();
        } else {
            boolean z;
            if (str == null || !(str.startsWith("weixin://openNativeUrl/myDeviceList") || str.startsWith("weixin://openNativeUrl/bindMyDevice"))) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                cVar = new b();
            } else {
                if (str == null || !(str.startsWith("weixin://wesport/recommend") || str.startsWith("weixin://openNativeUrl/rankMyHomepage") || str.startsWith("weixin://openNativeUrl/rankSetting"))) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    cVar = new d();
                }
            }
        }
        if (cVar == null || !cVar.a(str, context, xVar, str2)) {
            return false;
        }
        return true;
    }
}
