package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class WxaAttributes$d {
    public int cbu;
    public String foV;
    public String fqu;
    public int fsi;
    public String fsj;
    public int fsk;
    public List<WxaAttributes$e> fsl;
    public boolean fsm;
    public String fsn;

    public static WxaAttributes$d si(String str) {
        if (bi.oW(str)) {
            return null;
        }
        WxaAttributes$d wxaAttributes$d;
        try {
            JSONObject jSONObject = new JSONObject(str);
            wxaAttributes$d = new WxaAttributes$d();
            wxaAttributes$d.cbu = jSONObject.optInt("AppVersion", 0);
            wxaAttributes$d.fsi = jSONObject.optInt("VersionState", -1);
            wxaAttributes$d.fsj = jSONObject.optString("VersionMD5");
            wxaAttributes$d.foV = jSONObject.optString("device_orientation");
            wxaAttributes$d.fqu = jSONObject.optString("client_js_ext_info");
            wxaAttributes$d.fsk = jSONObject.optInt("code_size");
            JSONArray optJSONArray = jSONObject.optJSONArray("module_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                wxaAttributes$d.fsl = new LinkedList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        WxaAttributes$e wxaAttributes$e = new WxaAttributes$e();
                        wxaAttributes$e.bKg = optJSONObject.optString("md5");
                        wxaAttributes$e.name = optJSONObject.optString("name");
                        wxaAttributes$d.fsl.add(wxaAttributes$e);
                    }
                }
            }
            wxaAttributes$d.fsm = jSONObject.optBoolean("UseModule", false);
            wxaAttributes$d.fsn = jSONObject.optString("EntranceModule");
        } catch (Exception e) {
            wxaAttributes$d = null;
        }
        return wxaAttributes$d;
    }
}
