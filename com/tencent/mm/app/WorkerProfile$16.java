package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.net.Uri;
import com.tencent.mm.a.g;
import com.tencent.mm.g.a.of;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.base.stub.WXBizEntryActivity;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;

class WorkerProfile$16 extends c<of> {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$16(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
        this.sFo = of.class.getName().hashCode();
    }

    private static boolean a(of ofVar) {
        String[] strArr = ofVar.bZe.selectionArgs;
        if (strArr == null || strArr.length == 0) {
            x.e("MicroMsg.WorkerProfile", "args is null");
        } else if (strArr.length < 2) {
            x.e("MicroMsg.WorkerProfile", "args must contain appid and username");
        } else {
            int i;
            String str;
            String str2;
            Context context = ofVar.bZe.context;
            String str3 = strArr[0];
            String str4 = strArr[1];
            String str5 = "";
            if (strArr.length > 2) {
                str5 = strArr[2];
            }
            if (strArr.length > 3) {
                i = bi.getInt(strArr[3], 0);
            } else {
                i = 0;
            }
            if (!bi.oW(str5)) {
                String[] split = str5.split("\\?");
                if (split.length > 1) {
                    str5 = split[0] + ".html?" + split[1];
                } else {
                    str5 = split[0] + ".html";
                }
                try {
                    str5 = URLEncoder.encode(str5);
                } catch (Exception e) {
                    x.e("MicroMsg.WorkerProfile", "encode path failed : %s", new Object[]{e.getMessage()});
                    str5 = "";
                }
            }
            String[] strArr2 = ofVar.bZe.bGj;
            if (strArr2 == null || strArr2.length <= 0) {
                str = null;
                str2 = null;
            } else {
                str2 = strArr2[0];
                Signature[] bh = p.bh(ofVar.bZe.context, strArr2[0]);
                str = (bh == null || bh.length <= 0) ? null : g.u(bh[0].toByteArray());
            }
            x.i("MicroMsg.WorkerProfile", "sdk launch wxminiprogram, appid = %s, username = %s, path = %s, type = %d", new Object[]{str3, str4, str5, Integer.valueOf(i)});
            x.i("MicroMsg.WorkerProfile", "sdk launch wxminiprogram, package name = %s, sig = %s", new Object[]{str2, str});
            x.i("MicroMsg.WorkerProfile", "url format = %s", new Object[]{String.format("weixin://dl/jumpWxa/?appid=%s&userName=%s@app&path=%s", new Object[]{str3, str4, str5})});
            Intent intent = new Intent(context, WXBizEntryActivity.class);
            intent.setData(Uri.parse(str5));
            intent.addFlags(268435456);
            intent.putExtra("key_package_name", str2);
            intent.putExtra("translate_link_scene", 1);
            intent.putExtra("key_package_signature", str);
            intent.putExtra("key_command_id", 19);
            b v = u.Hx().v("key_data_center_session_id", true);
            v.p("key_package_name", str2);
            v.p("key_package_signature", str);
            v.p("key_launch_miniprogram_type", Integer.valueOf(i));
            x.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s, type = %d", new Object[]{str2, str, Integer.valueOf(i)});
            context.startActivity(intent);
        }
        return true;
    }
}
