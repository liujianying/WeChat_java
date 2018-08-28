package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class kz {
    private Context a;
    private WeakReference<b> b;

    public interface b {
        void a(boolean z);
    }

    public kz(Context context, b bVar) {
        this.a = context;
        this.b = new WeakReference(bVar);
    }

    public void a() {
        new a(this, null).execute(new Context[]{this.a});
    }

    private int a(String str, int i) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.optInt("error", -1) != 0) {
            return i;
        }
        jSONObject = jSONObject.optJSONObject("info");
        if (jSONObject != null) {
            return jSONObject.optInt("scenic", i);
        }
        return i;
    }

    private String a(Context context) {
        if (context == null) {
            return "";
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (NameNotFoundException e) {
        }
        if (applicationInfo == null) {
            return "";
        }
        if (applicationInfo.metaData == null) {
            return "";
        }
        return applicationInfo.metaData.getString(kh.b);
    }
}
