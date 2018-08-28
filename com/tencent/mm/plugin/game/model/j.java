package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class j {
    JSONObject jLQ = new JSONObject();

    protected j(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.GameServerData", "Null or nil json string");
            return;
        }
        try {
            this.jLQ = new JSONObject(str);
        } catch (JSONException e) {
            x.e("MicroMsg.GameServerData", "Json parsing error");
        }
    }

    protected final JSONArray optJSONArray(String str) {
        return this.jLQ.optJSONArray(str);
    }

    private static String i(JSONObject jSONObject, String str) {
        if (jSONObject == null || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str);
    }

    protected static LinkedList<d> m(JSONArray jSONArray) {
        LinkedList<d> linkedList = new LinkedList();
        if (jSONArray == null || jSONArray.length() == 0) {
            x.i("MicroMsg.GameServerData", "Null or empty json array");
            return linkedList;
        }
        x.i("MicroMsg.GameServerData", "Parsing json AppInfo, size: %d", new Object[]{Integer.valueOf(jSONArray.length())});
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj;
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                x.e("MicroMsg.GameServerData", "Invalid json object");
                obj = null;
            } else {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("YYB");
                String i2 = i(optJSONObject, "appID");
                if (bi.oW(i2)) {
                    x.e("MicroMsg.GameServerData", "No AppID field, abort");
                    obj = null;
                } else {
                    x.i("MicroMsg.GameServerData", "Parsing AppID: %s", new Object[]{i2});
                    obj = new d();
                    obj.field_appId = i2;
                    obj.field_appName = i(optJSONObject, "name");
                    obj.field_appIconUrl = i(optJSONObject, "iconURL");
                    obj.field_appType = ",1,";
                    obj.field_packageName = i(optJSONObject, "AndroidPackageName");
                    obj.di(i(optJSONObject, "downloadURL"));
                    obj.dl(i(optJSONObject, "AndroidApkMd5"));
                    i2 = i(optJSONObject, "GooglePlayDownloadUrl");
                    int optInt = optJSONObject.optInt("GooglePlayDownloadFlag");
                    obj.dm(i2);
                    if (!bi.oW(i2)) {
                        x.i("MicroMsg.GameServerData", "GooglePlay URL: %s, Download Flag: %d", new Object[]{i2, Integer.valueOf(optInt)});
                        obj.eA(optInt);
                    }
                    if (optJSONObject2 != null) {
                        obj.eA(optJSONObject2.optInt("AndroidDownloadFlag"));
                    }
                    if (optJSONObject2 != null) {
                        obj.dr(i(optJSONObject2, "DownloadUrl"));
                        obj.ds(i(optJSONObject2, "ApkMd5"));
                        obj.dp(i(optJSONObject2, "PreemptiveUrl"));
                        obj.dq(i(optJSONObject2, "ExtInfo"));
                        obj.eB(optJSONObject2.optInt("SupportedVersionCode"));
                    }
                    obj.jLc = i(optJSONObject, "desc");
                    obj.jLb = i(optJSONObject, "brief");
                    obj.type = optJSONObject.optInt("type", 0);
                    obj.status = optJSONObject.optInt("status");
                    obj.jLe = i(optJSONObject, "webURL");
                    obj.jLf = i(optJSONObject, "adUrl");
                    obj.bHF = i(optJSONObject, "noticeid");
                    obj.jLg = optJSONObject.optBoolean("isSubscribed");
                    obj.versionCode = optJSONObject.optInt("versionCode");
                    if (optJSONObject2 != null) {
                        obj.jLh = i(optJSONObject2, "DownloadTipsWording");
                        obj.jLi = i(optJSONObject2, "BackBtnWording");
                        obj.jLj = i(optJSONObject2, "DownloadBtnWording");
                    }
                }
            }
            if (obj != null) {
                linkedList.add(obj);
            }
        }
        return linkedList;
    }
}
