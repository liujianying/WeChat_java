package com.tencent.mm.plugin.appbrand.jsapi.l;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.net.URLEncoder;
import org.json.JSONObject;

public class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 45;
    private static final String NAME = "reportAction";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString(DownloadSettingTable$Columns.VALUE);
        x.i("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey =  %s, actionValue =  %s", new Object[]{optString, optString2});
        if (bi.oW(optString) || bi.oW(optString2)) {
            x.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue is null");
            lVar.E(i, f("fail", null));
        } else if (optString.length() <= 0 || optString.length() > 32 || optString2.length() <= 0 || optString2.length() > 1024) {
            x.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue size is bad");
            lVar.E(i, f("fail", null));
        } else {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty(lVar.mAppId)) {
                x.e("MicroMsg.JsApiReportAction", "doReportActionInfo, appId is empty");
                lVar.E(i, f("fail", null));
                return;
            }
            x.i("MicroMsg.JsApiReportAction", "doReportActionInfo, appId %s", new Object[]{lVar.mAppId});
            int i2 = 0;
            if (ao.isConnected(lVar.getContext())) {
                if (ao.isWifi(lVar.getContext())) {
                    i2 = 1;
                } else if (ao.is4G(lVar.getContext())) {
                    i2 = 4;
                } else if (ao.is3G(lVar.getContext())) {
                    i2 = 3;
                } else if (ao.is2G(lVar.getContext())) {
                    i2 = 2;
                }
                x.i("MicroMsg.JsApiReportAction", "doReportActionInfo, get networkType %d", new Object[]{Integer.valueOf(i2)});
            }
            long VE = bi.VE();
            x.d("MicroMsg.JsApiReportAction", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", new Object[]{Long.valueOf(VE), Integer.valueOf(13579), r12, Integer.valueOf(i2), str2, str3, str, optString, optString2});
            String str4 = "";
            String str5 = "";
            String str6 = "";
            String str7 = "";
            try {
                str4 = URLEncoder.encode(bi.oV(str2), "UTF-8");
                str5 = URLEncoder.encode(str3, "UTF-8");
                str6 = URLEncoder.encode(optString, "UTF-8");
                str7 = URLEncoder.encode(optString2, "UTF-8");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiReportAction", e, "", new Object[0]);
            }
            h.mEJ.h(13579, new Object[]{r12, Integer.valueOf(i2), str4, str5, str, str6, str7, Long.valueOf(VE), Long.valueOf(VE)});
            lVar.E(i, f("ok", null));
        }
    }

    public final void a(p pVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString(DownloadSettingTable$Columns.VALUE);
        x.i("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey =  %s, actionValue =  %s", new Object[]{optString, optString2});
        if (bi.oW(optString) || bi.oW(optString2)) {
            x.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue is null");
            pVar.E(i, f("fail", null));
        } else if (optString.length() <= 0 || optString.length() > 32 || optString2.length() <= 0 || optString2.length() > 1024) {
            x.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue size is bad");
            pVar.E(i, f("fail", null));
        } else {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (TextUtils.isEmpty(pVar.mAppId)) {
                x.e("MicroMsg.JsApiReportAction", "doReportActionInfo, appId is empty");
                pVar.E(i, f("fail", null));
                return;
            }
            x.i("MicroMsg.JsApiReportAction", "doReportActionInfo, appId %s", new Object[]{pVar.mAppId});
            int i2 = 0;
            if (ao.isConnected(pVar.mContext)) {
                if (ao.isWifi(pVar.mContext)) {
                    i2 = 1;
                } else if (ao.is4G(pVar.mContext)) {
                    i2 = 4;
                } else if (ao.is3G(pVar.mContext)) {
                    i2 = 3;
                } else if (ao.is2G(pVar.mContext)) {
                    i2 = 2;
                }
                x.i("MicroMsg.JsApiReportAction", "doReportActionInfo, get networkType %d", new Object[]{Integer.valueOf(i2)});
            }
            long VE = bi.VE();
            x.d("MicroMsg.JsApiReportAction", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", new Object[]{Long.valueOf(VE), Integer.valueOf(13579), r12, Integer.valueOf(i2), str2, str3, str, optString, optString2});
            String str4 = "";
            String str5 = "";
            String str6 = "";
            String str7 = "";
            try {
                str4 = URLEncoder.encode(bi.oV(str2), "UTF-8");
                str5 = URLEncoder.encode(str3, "UTF-8");
                str6 = URLEncoder.encode(optString, "UTF-8");
                str7 = URLEncoder.encode(optString2, "UTF-8");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.JsApiReportAction", e, "", new Object[0]);
            }
            h.mEJ.h(13579, new Object[]{r12, Integer.valueOf(i2), str4, str5, str, str6, str7, Long.valueOf(VE), Long.valueOf(VE)});
            pVar.E(i, f("ok", null));
        }
    }
}
