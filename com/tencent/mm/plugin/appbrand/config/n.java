package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.protocal.c.byl;
import com.tencent.mm.protocal.c.cx;
import com.tencent.mm.protocal.c.dh;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public enum n {
    ;

    static cx i(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("AppConfig");
        cx cxVar = new cx();
        if (optJSONObject != null) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("VersionList");
            cxVar.rcX = new LinkedList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    byl byl = new byl();
                    byl.type = optJSONObject2.optInt(DownloadSettingTable$Columns.TYPE);
                    byl.version = optJSONObject2.optInt("version");
                    cxVar.rcX.add(byl);
                }
            }
        }
        return cxVar;
    }

    static String a(dh dhVar) {
        if (dhVar == null) {
            return "AppRunningFlagInfo{null}";
        }
        return "AppRunningFlagInfo{RunningFlag=" + dhVar.rdx + ", StopServiceTime" + dhVar.rdy + ", AppForbiddenReason" + dhVar.rdz + ", SessionOpenForbiddenReason" + dhVar.rdA + ", TimelineOpenForbiddenReason" + dhVar.rdB + "}";
    }
}
