package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u$b;
import com.tencent.mm.plugin.base.stub.WXBizEntryActivity;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WorkerProfile$15 extends c<oh> {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$15(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
        this.sFo = oh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        oh ohVar = (oh) bVar;
        String[] strArr = ohVar.bZg.selectionArgs;
        if (strArr == null || strArr.length == 0) {
            x.e("MicroMsg.WorkerProfile", "args is null");
        } else if (strArr.length <= 0) {
            x.e("MicroMsg.WorkerProfile", "args must contain appid");
        } else {
            String str;
            String str2;
            String str3;
            Context context = ohVar.bZg.context;
            String str4 = strArr[0];
            strArr = ohVar.bZg.bGj;
            if (strArr == null || strArr.length <= 0) {
                str = null;
                str2 = null;
            } else {
                str3 = strArr[0];
                str = g.u(p.bh(ohVar.bZg.context, strArr[0])[0].toByteArray());
                str2 = str3;
            }
            x.i("MicroMsg.WorkerProfile", "sdk open offlinePay, appid = %s, package = %s", new Object[]{str4, str2});
            x.i("MicroMsg.WorkerProfile", "url format = %s", new Object[]{String.format("weixin://dl/offlinepay/?appid=%s", new Object[]{str4})});
            Intent intent = new Intent(context, WXBizEntryActivity.class);
            intent.setData(Uri.parse(str3));
            intent.addFlags(268435456);
            intent.putExtra("key_package_name", str2);
            intent.putExtra("translate_link_scene", 1);
            intent.putExtra("key_package_signature", str);
            intent.putExtra("key_command_id", 24);
            u$b v = u.Hx().v("key_data_center_session_id", true);
            v.p("key_package_name", str2);
            v.p("key_package_signature", str);
            x.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", new Object[]{str2, str});
            context.startActivity(intent);
        }
        return true;
    }
}
