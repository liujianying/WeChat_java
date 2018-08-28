package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.a$i;
import com.tencent.mm.g.a.eu;
import com.tencent.mm.plugin.base.stub.WXBizEntryActivity;
import com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

class WorkerProfile$8 extends c<eu> {
    final /* synthetic */ WorkerProfile bzO;

    WorkerProfile$8(WorkerProfile workerProfile) {
        this.bzO = workerProfile;
        this.sFo = eu.class.getName().hashCode();
    }

    private static boolean a(eu euVar) {
        if (euVar == null) {
            x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event is null.");
            return false;
        } else if (!(euVar instanceof eu)) {
            x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event is not a instance of ExtCallBizEvent.");
            return false;
        } else if (euVar.bMx == null) {
            x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event.data is null.");
            return false;
        } else {
            Intent intent;
            switch (euVar.bMx.op) {
                case a$i.AppCompatTheme_actionModeStyle /*27*/:
                    if (euVar.bMx.selectionArgs == null || euVar.bMx.selectionArgs.length < 2) {
                        x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent selectionArgs error.");
                        return true;
                    }
                    Object encode;
                    String str = "";
                    Object obj = euVar.bMx.selectionArgs[0];
                    String str2 = euVar.bMx.selectionArgs[1];
                    if (euVar.bMx.selectionArgs.length >= 3) {
                        Object oV = bi.oV(euVar.bMx.selectionArgs[2]);
                        try {
                            encode = URLEncoder.encode(oV, "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            encode = oV;
                        }
                    } else {
                        String encode2 = str;
                    }
                    if (obj == null || str2 == null) {
                        x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent wrong args, %s, %s", new Object[]{obj, str2});
                        return true;
                    }
                    int i;
                    if (euVar.bMx.selectionArgs.length >= 4) {
                        str = euVar.bMx.selectionArgs[3];
                        if (!bi.oW(str)) {
                            i = bi.getInt(str, 0);
                            x.i("MicroMsg.WorkerProfile", "ExtCallBizEvent jump biz tempSession");
                            str = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{str2, obj, encode2, Integer.valueOf(i), Integer.valueOf(0)});
                            intent = new Intent(euVar.bMx.context, WXCustomSchemeEntryActivity.class);
                            intent.addFlags(268435456);
                            intent.setData(Uri.parse(str));
                            intent.putExtra("translate_link_scene", 1);
                            euVar.bMx.context.startActivity(intent);
                            return true;
                        }
                    }
                    i = 0;
                    x.i("MicroMsg.WorkerProfile", "ExtCallBizEvent jump biz tempSession");
                    str = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[]{str2, obj, encode2, Integer.valueOf(i), Integer.valueOf(0)});
                    intent = new Intent(euVar.bMx.context, WXCustomSchemeEntryActivity.class);
                    intent.addFlags(268435456);
                    intent.setData(Uri.parse(str));
                    intent.putExtra("translate_link_scene", 1);
                    euVar.bMx.context.startActivity(intent);
                    return true;
                case a$i.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    x.i("MicroMsg.WorkerProfile", "ExtCallBizEvent open exdevice rank list.");
                    Context context = euVar.bMx.context;
                    intent = new Intent(context, WXBizEntryActivity.class);
                    intent.addFlags(268435456);
                    intent.putExtra("key_command_id", 11);
                    context.startActivity(intent);
                    return true;
                default:
                    return a(euVar.bMx.context, euVar.bMx.selectionArgs, euVar.bMx.bGj, euVar.bMx.source, euVar.bMx.bMy);
            }
        }
    }

    private static boolean a(Context context, String[] strArr, String[] strArr2, int i, String str) {
        if (context == null) {
            x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:context is null.");
            context = ad.getContext();
        }
        if (strArr == null || strArr.length < 2) {
            x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:args error.");
            return false;
        }
        int i2;
        int length = strArr.length;
        for (i2 = 0; i2 < length; i2++) {
            x.i("MicroMsg.WorkerProfile", "arg : %s", new Object[]{strArr[i2]});
        }
        String str2 = strArr[0];
        String str3 = strArr[1];
        String str4 = null;
        if (strArr.length > 2) {
            str4 = strArr[2];
        }
        length = 0;
        if (strArr.length > 3) {
            length = bi.getInt(strArr[3], 0);
        }
        int i3 = 0;
        if (strArr.length > 4) {
            i3 = bi.getInt(strArr[4], 0);
        }
        x.i("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:source(%d)", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 1:
                if (strArr2 == null || strArr2.length == 0) {
                    x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:packageNames is null or nil.");
                    return false;
                }
            case 2:
                if (bi.oW(str)) {
                    x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:fromURL(%s) is null or nil.", new Object[]{str});
                    return false;
                }
                break;
            default:
                x.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:source is out of range.");
                return false;
        }
        x.i("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener: appId(%s), toUserName(%s), extInfo(%s), fromURL(%s)", new Object[]{str2, str3, str4, str});
        if (bi.oW(str2) || bi.oW(str3)) {
            x.e("MicroMsg.WorkerProfile", "appId or toUsername is null or nil.");
            return false;
        }
        int i4 = 0;
        if (length == 1) {
            i4 = 8;
        } else if (length == 0) {
            i4 = 7;
        }
        Intent intent = new Intent(context, WXBizEntryActivity.class);
        intent.putExtra("key_command_id", i4);
        intent.putExtra("appId", str2);
        intent.putExtra("toUserName", str3);
        intent.putExtra("extInfo", str4);
        intent.putExtra("source", i);
        intent.putExtra("scene", length);
        intent.putExtra("jump_profile_type", i3);
        intent.addFlags(268435456).addFlags(67108864);
        if (strArr2 != null && strArr2.length > 0) {
            ArrayList arrayList = new ArrayList();
            for (Object add : strArr2) {
                arrayList.add(add);
            }
            intent.putStringArrayListExtra("androidPackNameList", arrayList);
        }
        context.startActivity(intent);
        return true;
    }
}
