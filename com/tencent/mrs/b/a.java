package com.tencent.mrs.b;

import android.content.Context;
import com.tencent.matrix.c.b;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.mrs.core.MrsLogic.PhoneInfo;
import com.tencent.mm.loader.stub.c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import org.json.JSONObject;

public final class a extends com.tencent.matrix.b.a {
    final HashMap<String, ArrayList<b>> uZW = new HashMap();

    public a(Context context) {
        super(context);
    }

    public final void b(b bVar) {
        super.b(bVar);
        if (!MatrixReport.isInstalled()) {
            ArrayList arrayList = (ArrayList) this.uZW.get(bVar.tag);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(bVar);
            com.tencent.matrix.d.b.i("Matrix.PluginListener", "matrix report is not init, wait to report plugin:%s, content:%s", bVar.tag, bVar.brm);
        } else if ("memory".equals(bVar.tag)) {
            JSONObject jSONObject = bVar.brm;
            if (jSONObject != null) {
                String optString = jSONObject.optString("resultZipPath");
                if (optString == null || optString.length() == 0) {
                    MatrixReport.with().report(bVar.tag, bVar.brm);
                    return;
                }
                Properties properties = new Properties();
                properties.put("Uin", c.duQ.I("last_login_uin", "0"));
                properties.put("ClientVersion", String.valueOf(MatrixReport.with().getClientVersion()));
                properties.put("Revision", MatrixReport.with().getRevision());
                properties.put("ReportTime", String.valueOf(System.currentTimeMillis()));
                properties.put("process", jSONObject.optString("process"));
                PhoneInfo phoneInfo = MatrixReport.with().getPhoneInfo();
                properties.put("DeviceModel", phoneInfo.deviceModel);
                properties.put("OSName", phoneInfo.osName);
                properties.put("OSVersion", phoneInfo.osVersion);
                if (com.tencent.matrix.resource.c.a.a(new File(optString), properties)) {
                    MatrixReport.with().report(bVar, new File(optString));
                }
            }
        } else {
            MatrixReport.with().report(bVar.tag, bVar.brm);
        }
    }
}
