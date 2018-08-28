package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.support.v4.app.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class c$9 implements a {
    final /* synthetic */ c fKg;

    c$9(c cVar) {
        this.fKg = cVar;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 128) {
            x.e("MicroMsg.JsApiGetPhoneNumber", "requestSMSPermission requestCode is not for sms");
        } else if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.JsApiGetPhoneNumber";
            String str2 = "requestSMSPermission, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.cjd();
            x.w(str, str2, objArr);
        } else if (iArr[0] == 0) {
            x.i("MicroMsg.JsApiGetPhoneNumber", "requestSMSPermission permission is grant for sms");
            if (this.fKg.fKa != null) {
                this.fKg.fKa.start();
            }
        } else {
            x.e("MicroMsg.JsApiGetPhoneNumber", "requestSMSPermission sys perm denied for sms");
        }
    }
}
