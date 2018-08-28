package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.plugin.base.stub.WXBizEntryActivity;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class WorkerProfile$17 extends c<ie> {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$17(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
        this.sFo = ie.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ie ieVar = (ie) bVar;
        Context context = ieVar.bRF.context;
        if (context == null) {
            x.e("MicroMsg.WorkerProfile", "context is null");
        } else {
            String str;
            String str2;
            String[] strArr = ieVar.bRF.bGj;
            if (strArr == null || strArr.length <= 0) {
                str = null;
                str2 = null;
            } else {
                str2 = strArr[0];
                str = g.u(p.bh(ieVar.bRF.context, strArr[0])[0].toByteArray());
            }
            String[] strArr2 = ieVar.bRF.selectionArgs;
            if (strArr2 == null || strArr2.length <= 0) {
                x.e("MicroMsg.WorkerProfile", "args is null");
            } else {
                String str3;
                String str4;
                if (strArr2 == null || strArr2.length <= 1) {
                    str3 = null;
                    str4 = null;
                } else {
                    str4 = strArr2[0];
                    str3 = strArr2[1];
                }
                x.i("MicroMsg.WorkerProfile", "handleScanResult, appid = %s, scanResult = %s", new Object[]{str4, str3});
                if (!(bi.oW(str4) || bi.oW(str3))) {
                    String format = String.format("weixin://dl/handleScanResult?appid=%s&result=%s", new Object[]{str4, str3});
                    Intent intent = new Intent(context, WXBizEntryActivity.class);
                    intent.setData(Uri.parse(format));
                    intent.addFlags(268435456).addFlags(134217728).addFlags(67108864);
                    intent.putExtra("key_command_id", 17);
                    intent.putExtra("key_package_name", str2);
                    intent.putExtra("translate_link_scene", 1);
                    intent.putExtra("key_package_signature", str);
                    context.startActivity(intent);
                    return true;
                }
            }
        }
        return false;
    }
}
