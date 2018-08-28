package com.tencent.mm.plugin.webview.fts;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.bp.a;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j extends t {
    Context context;

    static /* synthetic */ void a(j jVar, JSONObject jSONObject, Bundle bundle, r rVar) {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        Object optString = jSONObject.optString("rangeKey");
        if (TextUtils.isEmpty(optString)) {
            JSONArray optJSONArray = jSONObject.optJSONArray("range");
            while (i < optJSONArray.length()) {
                arrayList.add(optJSONArray.getString(i));
                i++;
            }
        } else {
            JSONArray optJSONArray2 = jSONObject.optJSONArray("range");
            while (i < optJSONArray2.length()) {
                arrayList.add(optJSONArray2.getJSONObject(i).optString(optString));
                i++;
            }
        }
        i = jSONObject.optInt(DownloadSettingTable$Columns.VALUE);
        b bVar = new b(jVar.context, arrayList);
        bVar.GC(i);
        bVar.uLl = new 4(jVar, bVar, bundle, rVar);
        bVar.GB(a.fromDPToPix(jVar.context, 288));
        bVar.show();
    }

    public j(Context context) {
        this.context = context;
    }

    public final void a(String str, String str2, r rVar) {
        ah.A(new 1(this, str2, str, rVar));
    }
}
