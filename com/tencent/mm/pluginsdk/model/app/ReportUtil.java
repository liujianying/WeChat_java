package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.model.au;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.sdk.platformtools.s;

public final class ReportUtil {
    public static void a(Context context, ReportArgs reportArgs) {
        Bundle bundle;
        Args args;
        if (reportArgs.nc == 1) {
            Resp resp = new Resp();
            resp.transaction = reportArgs.transaction;
            resp.errCode = reportArgs.errCode;
            resp.openId = reportArgs.openId;
            bundle = new Bundle();
            resp.toBundle(bundle);
            p.ae(bundle);
            args = new Args();
            args.targetPkgName = reportArgs.rU;
            args.bundle = bundle;
            MMessageActV2.send(context, args);
            return;
        }
        SendMessageToWX.Resp resp2 = new SendMessageToWX.Resp();
        resp2.errCode = reportArgs.errCode;
        resp2.transaction = reportArgs.transaction;
        resp2.openId = reportArgs.openId;
        bundle = new Bundle();
        resp2.toBundle(bundle);
        p.ae(bundle);
        args = new Args();
        args.targetPkgName = reportArgs.rU;
        args.bundle = bundle;
        MMessageActV2.send(context, args);
    }

    public static ReportArgs c(Bundle bundle, int i) {
        String string = bundle.getString("SendAppMessageWrapper_AppId");
        if (string == null) {
            String string2 = bundle.getString("_mmessage_content");
            if (string2 != null) {
                string = Uri.parse(string2).getQueryParameter("appid");
            }
        }
        if (string == null) {
            string = s.i(bundle, "_wxapi_payreq_appid");
            if (string == null) {
                return null;
            }
        }
        f fVar = new f();
        fVar.field_appId = string;
        if (au.HW() && au.HX()) {
            ao.bmf().b(fVar, new String[0]);
        } else {
            fVar.field_packageName = bundle.getString("_mmessage_appPackage");
        }
        ReportArgs reportArgs = new ReportArgs();
        reportArgs.rU = fVar.field_packageName;
        reportArgs.errCode = i;
        Req req = new Req();
        req.fromBundle(bundle);
        reportArgs.transaction = req.transaction;
        reportArgs.openId = fVar.field_openId;
        reportArgs.nc = bundle.getInt("_wxapi_command_type");
        return reportArgs;
    }
}
