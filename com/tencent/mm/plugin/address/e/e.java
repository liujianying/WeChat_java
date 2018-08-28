package com.tencent.mm.plugin.address.e;

import android.util.Log;
import com.tencent.mm.plugin.q.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONObject;

public final class e {
    public static String a(b bVar) {
        JSONObject jSONObject = new JSONObject();
        if (bVar == null) {
            return jSONObject.toString();
        }
        try {
            jSONObject.put(DownloadSettingTable$Columns.TYPE, bVar.type);
            if (bVar.type == null || !bVar.type.equals("1")) {
                jSONObject.put("title", bVar.title);
                if (bVar.knC != null) {
                    jSONObject.put("taxNumber", bVar.knC);
                } else {
                    jSONObject.put("taxNumber", "");
                }
                if (bVar.knI != null) {
                    jSONObject.put("companyAddress", bVar.knI);
                } else {
                    jSONObject.put("companyAddress", "");
                }
                if (bVar.knG != null) {
                    jSONObject.put("telephone", bVar.knG);
                } else {
                    jSONObject.put("telephone", "");
                }
                if (bVar.knE != null) {
                    jSONObject.put("bankName", bVar.knE);
                } else {
                    jSONObject.put("bankName", "");
                }
                if (bVar.knD != null) {
                    jSONObject.put("bankAccount", bVar.knD);
                } else {
                    jSONObject.put("bankAccount", "");
                }
                return jSONObject.toString();
            }
            jSONObject.put("title", bVar.knB);
            jSONObject.put("taxNumber", "");
            jSONObject.put("companyAddress", "");
            jSONObject.put("telephone", "");
            jSONObject.put("bankName", "");
            jSONObject.put("bankAccount", "");
            return jSONObject.toString();
        } catch (Throwable e) {
            x.e("MicroMsg.InvoiceUtil", "put json value error : %s", new Object[]{Log.getStackTraceString(e)});
        }
    }
}
