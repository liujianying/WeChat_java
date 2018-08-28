package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.chatting.f.c;
import com.tencent.mm.ui.x;

final class f$b implements c {
    f$b() {
    }

    public final boolean a(String str, Context context, x xVar, String str2) {
        if (bi.oW(str)) {
            return false;
        }
        if (!str.startsWith("weixin://openNativeUrl/myDeviceList")) {
            return str.startsWith("weixin://openNativeUrl/bindMyDevice") ? false : false;
        } else {
            Intent intent = new Intent();
            intent.putExtra("device_brand_name", str2);
            d.b(context, "exdevice", ".ui.ExdeviceManageDeviceUI", intent);
            return true;
        }
    }
}
