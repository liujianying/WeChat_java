package com.tencent.mm.plugin.webview.fts.b.a.a;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class a {
    public String bPS;
    public String pPP;
    public String pPQ;
    public String pPR;
    public String pPS;
    public String pPT;
    public String pPU;
    public boolean pPV;

    public a(String str) {
        boolean z = true;
        Object str2 = new String(bi.readFromFile(str));
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("there is no test data");
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            this.bPS = jSONObject.optString("appid");
            this.pPP = jSONObject.optString("versionType");
            try {
                this.pPQ = jSONObject.optJSONObject("queryIntent").toString();
            } catch (Throwable e) {
                x.printErrStackTrace("WidgetUiTestInfo", e, "", new Object[0]);
            }
            this.pPR = jSONObject.optString("realQuery");
            try {
                this.pPS = jSONObject.optJSONObject("testData").toString();
            } catch (Throwable e2) {
                x.printErrStackTrace("WidgetUiTestInfo", e2, "", new Object[0]);
            }
            this.pPT = jSONObject.optString("domResultPath");
            this.pPU = jSONObject.optString("widgetPicDir");
            if (jSONObject.optInt("onlyPic") != 1) {
                z = false;
            }
            this.pPV = z;
        } catch (Throwable e3) {
            throw new IllegalArgumentException(e3);
        }
    }
}
