package com.tencent.mm.plugin.appbrand.config;

import android.database.Cursor;
import android.util.Pair;
import com.tencent.mm.g.c.fb;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class WxaAttributes extends fb {
    public static final a fgt;
    public static final String frM;
    private a frN;
    private c frO;
    private d frP;
    private List<WxaEntryInfo> frQ = null;
    private b frR;

    static {
        a aVar = new a();
        aVar.sKy = new Field[19];
        aVar.columns = new String[20];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "usernameHash";
        aVar.sKA.put("usernameHash", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" usernameHash INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.sKz = "usernameHash";
        aVar.columns[1] = "username";
        aVar.sKA.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appId";
        aVar.sKA.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "nickname";
        aVar.sKA.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "brandIconURL";
        aVar.sKA.put("brandIconURL", "TEXT");
        stringBuilder.append(" brandIconURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "roundedSquareIconURL";
        aVar.sKA.put("roundedSquareIconURL", "TEXT");
        stringBuilder.append(" roundedSquareIconURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "bigHeadURL";
        aVar.sKA.put("bigHeadURL", "TEXT");
        stringBuilder.append(" bigHeadURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "smallHeadURL";
        aVar.sKA.put("smallHeadURL", "TEXT");
        stringBuilder.append(" smallHeadURL TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "signature";
        aVar.sKA.put("signature", "TEXT");
        stringBuilder.append(" signature TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "appOpt";
        aVar.sKA.put("appOpt", "INTEGER default '0' ");
        stringBuilder.append(" appOpt INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "registerSource";
        aVar.sKA.put("registerSource", "TEXT");
        stringBuilder.append(" registerSource TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "appInfo";
        aVar.sKA.put("appInfo", "TEXT");
        stringBuilder.append(" appInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[12] = "versionInfo";
        aVar.sKA.put("versionInfo", "TEXT");
        stringBuilder.append(" versionInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "bindWxaInfo";
        aVar.sKA.put("bindWxaInfo", "TEXT");
        stringBuilder.append(" bindWxaInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "dynamicInfo";
        aVar.sKA.put("dynamicInfo", "TEXT");
        stringBuilder.append(" dynamicInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "reserved";
        aVar.sKA.put("reserved", "TEXT");
        stringBuilder.append(" reserved TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "syncTimeSecond";
        aVar.sKA.put("syncTimeSecond", "LONG default '0' ");
        stringBuilder.append(" syncTimeSecond LONG default '0' ");
        stringBuilder.append(", ");
        aVar.columns[17] = "syncVersion";
        aVar.sKA.put("syncVersion", "TEXT");
        stringBuilder.append(" syncVersion TEXT");
        stringBuilder.append(", ");
        aVar.columns[18] = "bizMenu";
        aVar.sKA.put("bizMenu", "TEXT");
        stringBuilder.append(" bizMenu TEXT");
        aVar.columns[19] = "rowid";
        aVar.sql = stringBuilder.toString();
        fgt = aVar;
        frM = i.a(aVar, "WxaAttributesTable");
    }

    public final void d(Cursor cursor) {
        super.d(cursor);
        this.frN = null;
        this.frO = null;
        this.frP = null;
        this.frQ = null;
        this.frR = null;
    }

    protected final a AX() {
        return fgt;
    }

    public final a aej() {
        if (this.frN == null) {
            if (bi.oW(this.field_appInfo)) {
                x.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json is EMPTY");
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(this.field_appInfo);
                this.frN = new a();
                JSONObject optJSONObject = jSONObject.optJSONObject("RunningFlagInfo");
                if (optJSONObject != null) {
                    this.frN.fmc = optJSONObject.optLong("RunningFlag");
                    this.frN.frS = optJSONObject.optString("AppOpenForbiddenUrl");
                }
                optJSONObject = jSONObject.optJSONObject("Network");
                if (optJSONObject != null) {
                    this.frN.frU = s.f(optJSONObject.optJSONArray("RequestDomain"));
                    this.frN.frV = s.f(optJSONObject.optJSONArray("WsRequestDomain"));
                    this.frN.frW = s.f(optJSONObject.optJSONArray("UploadDomain"));
                    this.frN.frX = s.f(optJSONObject.optJSONArray("DownloadDomain"));
                }
                this.frN.dzQ = jSONObject.optString("Template");
                this.frN.frT = jSONObject.optInt("WechatPluginApp", 0);
                this.frN.dCn = jSONObject.optInt("AppServiceType", 0);
                this.frN.frY = jSONObject.optString("fromBusinessUsername");
            } catch (Exception e) {
                x.e("MicroMsg.AppBrand.WxaAttributes", "getAppInfo, json(%s) parse failed ex = %s", new Object[]{this.frN, e});
                this.frN = null;
            }
        }
        return this.frN;
    }

    public final c aek() {
        boolean z = true;
        int i = 0;
        if (this.frO == null) {
            JSONObject jSONObject;
            boolean z2;
            try {
                jSONObject = new JSONObject(this.field_dynamicInfo);
            } catch (Exception e) {
                jSONObject = null;
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            this.frO = new c();
            JSONObject optJSONObject = jSONObject.optJSONObject("NewSetting");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            this.frO.fsb.fsd = optJSONObject.optInt("MaxLocalstorageSize", 5);
            this.frO.fsb.fse = optJSONObject.optInt("MaxCodeSize", 5);
            this.frO.fsb.fqR = optJSONObject.optInt("ExpendedMaxWebviewDepth", 5);
            this.frO.fsb.fqS = optJSONObject.optInt("MaxBackgroundLifespan", TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_INTERRUPTED);
            this.frO.fsb.fqT = optJSONObject.optInt("MaxRequestConcurrent", 5);
            this.frO.fsb.fqU = optJSONObject.optInt("MaxUploadConcurrent", 5);
            this.frO.fsb.fqV = optJSONObject.optInt("MaxDownloadConcurrent", 5);
            this.frO.fsb.fqW = optJSONObject.optInt("MaxWebsocketConnect", 2);
            this.frO.fsb.fqX = optJSONObject.optInt("MaxWorkerConcurrent", 1);
            this.frO.fsb.fqY = optJSONObject.optInt("WebsocketSkipPortCheck", 0) != 0;
            this.frO.fsb.fsf = optJSONObject.optInt("MaxFileStorageSize", 10);
            this.frO.fsb.fsg = optJSONObject.optInt("BackgroundNetworkInterruptedTimeout", 5);
            a aVar = this.frO.fsb;
            if (optJSONObject.optInt("CanKeepAliveByAudioPlay", 0) > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            aVar.frh = z2;
            this.frO.fsb.fri = optJSONObject.optInt("LifeSpanBeforeSuspend", 5);
            this.frO.fsb.frj = optJSONObject.optInt("LifeSpanAfterSuspend", 300);
            a aVar2 = this.frO.fsb;
            if (optJSONObject.optInt("ScanCodeEnableZZM", 0) == 0) {
                z = false;
            }
            aVar2.frk = z;
            JSONArray optJSONArray = jSONObject.optJSONArray("NewCategories");
            if (optJSONArray != null) {
                this.frO.fsc = new LinkedList();
                while (i < optJSONArray.length()) {
                    optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        this.frO.fsc.add(new Pair(optJSONObject.optString("first"), optJSONObject.optString("second")));
                    }
                    i++;
                }
            }
        }
        return this.frO;
    }

    public final d ael() {
        if (this.frP != null || bi.oW(this.field_versionInfo)) {
            return this.frP;
        }
        d si = d.si(this.field_versionInfo);
        this.frP = si;
        return si;
    }

    public final List<WxaEntryInfo> aem() {
        if (this.frQ == null && !bi.oW(this.field_bindWxaInfo)) {
            try {
                JSONArray optJSONArray = new JSONObject(this.field_bindWxaInfo).optJSONArray("bizEntryInfo");
                if (optJSONArray != null) {
                    this.frQ = new LinkedList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("username");
                            if (!bi.oW(optString)) {
                                WxaEntryInfo wxaEntryInfo = new WxaEntryInfo();
                                wxaEntryInfo.username = optString;
                                wxaEntryInfo.title = optJSONObject.optString("title");
                                wxaEntryInfo.iconUrl = optJSONObject.optString("icon_url");
                                this.frQ.add(wxaEntryInfo);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                this.frQ = null;
            }
        }
        return this.frQ;
    }

    public final b aen() {
        if (this.frR == null && !bi.oW(this.field_bizMenu)) {
            try {
                JSONObject jSONObject = new JSONObject(this.field_bizMenu);
                this.frR = new b();
                this.frR.dLm = jSONObject.optInt("interactive_mode", 0);
                this.frR.type = jSONObject.optInt(DownloadSettingTable$Columns.TYPE, 0);
                this.frR.frZ = e(jSONObject.optJSONArray("button_list"));
            } catch (Exception e) {
                this.frR = null;
            }
        }
        return this.frR;
    }

    private List<a> e(JSONArray jSONArray) {
        List<a> arrayList;
        if (jSONArray != null) {
            arrayList = new ArrayList();
            try {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    a aVar = new a();
                    aVar.name = jSONObject.optString("name", "");
                    aVar.type = jSONObject.optInt(DownloadSettingTable$Columns.TYPE);
                    JSONObject jSONObject2 = new JSONObject(jSONObject.optString(DownloadSettingTable$Columns.VALUE, ""));
                    aVar.userName = jSONObject2.optString("userName", "");
                    aVar.bGH = jSONObject2.optString("pagePath", "");
                    aVar.version = jSONObject2.optInt("version");
                    aVar.fsa = e(jSONObject.optJSONArray("sub_button_list"));
                    arrayList.add(aVar);
                }
            } catch (JSONException e) {
                return null;
            }
        }
        arrayList = null;
        return arrayList;
    }

    public final String toString() {
        return "WxaAttributes{field_username='" + this.field_username + '\'' + ", field_appId='" + this.field_appId + '\'' + ", field_nickname='" + this.field_nickname + '\'' + ", field_brandIconURL='" + this.field_brandIconURL + '\'' + ", field_roundedSquareIconURL='" + this.field_roundedSquareIconURL + '\'' + ", field_bigHeadURL='" + this.field_bigHeadURL + '\'' + ", field_smallHeadURL='" + this.field_smallHeadURL + '\'' + ", field_signature='" + this.field_signature + '\'' + ", field_appOpt=" + this.field_appOpt + ", field_registerSource='" + this.field_registerSource + '\'' + ", field_appInfo='" + this.field_appInfo + '\'' + ", field_versionInfo='" + this.field_versionInfo + '\'' + ", field_bindWxaInfo='" + this.field_bindWxaInfo + '\'' + ", field_dynamicInfo='" + this.field_dynamicInfo + '\'' + ", field_bizMenu='" + this.field_bizMenu + '\'' + '}';
    }
}
