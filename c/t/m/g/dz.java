package c.t.m.g;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import org.json.JSONException;
import org.json.JSONObject;

final class dz {
    public static final dz a = new dz();
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public final Bundle m = new Bundle();

    dz() {
    }

    private dz(dz dzVar) {
        if (dzVar.m.size() > 0) {
            this.m.putAll(dzVar.m);
            return;
        }
        this.b = dzVar.b;
        this.c = dzVar.c;
        this.d = dzVar.d;
        this.e = dzVar.e;
        this.f = dzVar.f;
        this.g = dzVar.g;
        this.h = dzVar.h;
        this.i = dzVar.i;
        this.j = dzVar.j;
        this.k = dzVar.k;
        this.l = dzVar.l;
    }

    public static dz a(dz dzVar) {
        if (dzVar == null) {
            return null;
        }
        return new dz(dzVar);
    }

    public dz(JSONObject jSONObject) {
        try {
            if (jSONObject.has("admin_level_1")) {
                String string = jSONObject.getString("nation");
                String string2 = jSONObject.getString("admin_level_1");
                String string3 = jSONObject.getString("admin_level_2");
                String string4 = jSONObject.getString("admin_level_3");
                String string5 = jSONObject.getString("locality");
                String string6 = jSONObject.getString("sublocality");
                String string7 = jSONObject.getString("route");
                this.m.putString("nation", string);
                this.m.putString("admin_level_1", string2);
                this.m.putString("admin_level_2", string3);
                this.m.putString("admin_level_3", string4);
                this.m.putString("locality", string5);
                this.m.putString("sublocality", string6);
                this.m.putString("route", string7);
                return;
            }
            this.c = jSONObject.getString("name");
            this.d = jSONObject.getString(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            this.b = jSONObject.getString("nation");
            this.e = jSONObject.getString("province");
            this.f = jSONObject.getString("city");
            this.g = jSONObject.getString("district");
            this.h = jSONObject.getString("town");
            this.i = jSONObject.getString("village");
            this.j = jSONObject.getString("street");
            this.k = jSONObject.getString("street_no");
            Object optString = jSONObject.optString("mergedname");
            Object optString2 = jSONObject.optString("mergedaddr");
            if (!TextUtils.isEmpty(optString)) {
                this.c = optString;
            }
            if (!TextUtils.isEmpty(optString2)) {
                this.l = optString2;
            }
        } catch (JSONException e) {
            throw e;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("SubnationData{");
        stringBuilder.append("name=").append(this.c).append(",");
        stringBuilder.append("address=").append(this.l).append(",");
        stringBuilder.append("code=").append(this.d).append(",");
        stringBuilder.append("nation=").append(this.b).append(",");
        stringBuilder.append("province=").append(this.e).append(",");
        stringBuilder.append("city=").append(this.f).append(",");
        stringBuilder.append("district=").append(this.g).append(",");
        stringBuilder.append("town=").append(this.h).append(",");
        stringBuilder.append("village=").append(this.i).append(",");
        stringBuilder.append("street=").append(this.j).append(",");
        stringBuilder.append("street_no=").append(this.k).append(",");
        stringBuilder.append("bundle").append(this.m).append(",");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
