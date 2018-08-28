package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import org.json.JSONObject;

final class be$a {
    public String SNGAppId;
    public String actionFlag;
    public String jOE;
    public String taskApkId;
    public String taskAppId;
    public String taskPackageName;
    public int taskVersion;
    public String uin;
    public String uinType;
    public String via;

    private be$a() {
    }

    public /* synthetic */ be$a(byte b) {
        this();
    }

    public final TMQQDownloaderOpenSDKParam Dz(String str) {
        x.i("MicroMsg.QQDownloaderSDKWrapper", "params is : [%s]", new Object[]{str});
        if (bi.oW(str)) {
            x.e("MicroMsg.QQDownloaderSDKWrapper", "params is null or nil");
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.taskApkId = jSONObject.optString("taskApkId");
                this.via = jSONObject.optString("via");
                this.taskVersion = jSONObject.optInt("taskVersion");
                this.jOE = jSONObject.optString("channelID");
                this.uin = jSONObject.optString("uin");
                this.SNGAppId = jSONObject.optString("SNGAppId");
                this.taskAppId = jSONObject.optString("taskAppId");
                this.uinType = jSONObject.optString("uinType");
                this.taskPackageName = jSONObject.optString("taskPackageName");
                this.actionFlag = jSONObject.optString("actionFlag");
            } catch (Exception e) {
                x.e("MicroMsg.QQDownloaderSDKWrapper", "parse parms failed:[%s]", new Object[]{e.getMessage()});
            }
        }
        return new TMQQDownloaderOpenSDKParam(this.SNGAppId, this.taskAppId, this.taskApkId, this.taskVersion, this.via, this.taskPackageName, this.uin, this.uinType, this.jOE, this.actionFlag);
    }
}
