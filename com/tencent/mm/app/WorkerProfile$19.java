package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.og;
import com.tencent.mm.plugin.base.stub.WXBizEntryActivity;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WorkerProfile$19 extends c<og> {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$19(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
        super(0);
        this.sFo = og.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        og ogVar = (og) bVar;
        Context context = ogVar.bZf.context;
        if (context == null) {
            x.e("MicroMsg.WorkerProfile", "add card to wx event, context is null");
        } else {
            String str;
            String str2;
            String[] strArr = ogVar.bZf.bGj;
            if (strArr == null || strArr.length <= 0) {
                str = null;
                str2 = null;
            } else {
                String str3 = strArr[0];
                str = g.u(p.bh(ogVar.bZf.context, strArr[0])[0].toByteArray());
                str2 = str3;
            }
            String[] strArr2 = ogVar.bZf.selectionArgs;
            if (strArr2 != null && strArr2.length >= 6) {
                Intent intent = new Intent(context, WXBizEntryActivity.class);
                intent.addFlags(268435456).addFlags(134217728).addFlags(67108864);
                intent.putExtra("key_way", 4);
                intent.putExtra("appId", strArr2[0]);
                intent.putExtra("timeStamp", strArr2[1]);
                intent.putExtra("nonceStr", strArr2[2]);
                intent.putExtra("packageExt", strArr2[5]);
                intent.putExtra("signtype", strArr2[3]);
                intent.putExtra("paySignature", strArr2[4]);
                intent.putExtra("key_wxapi_package_name", str2);
                intent.putExtra("key_wxapi_sign", str);
                intent.putExtra("key_command_id", 13);
                context.startActivity(intent);
            }
        }
        return false;
    }
}
