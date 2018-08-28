package com.tencent.mm.pluginsdk.wallet;

import com.tencent.mm.g.a.lp;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;
import java.util.Map;
import org.json.JSONObject;

public final class g {
    public String appId;
    public int bJY;
    public String bVW;
    public String bVX;
    public int bVY;
    public int bVZ;
    public String dBl;
    public String extInfo;
    public String nonceStr;
    public String packageExt;
    public String partnerId;
    public int qUV;
    public int qUW = 0;
    public String qUX;
    public int qUY = 0;
    public String signType;
    public String timeStamp;
    public String url;

    public g(Map<String, Object> map) {
        this.appId = (String) map.get("appId");
        this.partnerId = (String) map.get("partnerId");
        this.signType = (String) map.get("signType");
        this.nonceStr = (String) map.get("nonceStr");
        this.timeStamp = (String) map.get("timeStamp");
        this.packageExt = (String) map.get("package");
        this.bVW = (String) map.get("paySign");
        this.url = (String) map.get("url");
        this.bVX = (String) map.get("src_username");
        this.bVY = bi.getInt((String) map.get("scene"), 0);
        if (this.bVY == 0) {
            this.bVY = bi.getInt((String) map.get("pay_scene"), 0);
        }
        this.bJY = bi.getInt((String) map.get("pay_channel"), 0);
        this.extInfo = bi.oV((String) map.get("ext_info"));
        this.qUX = bi.oV((String) map.get("token"));
        this.qUY = bi.getInt(bi.aG((String) map.get("result_jump_mode"), "0"), 0);
    }

    public g(JSONObject jSONObject) {
        this.appId = jSONObject.optString("appId");
        this.partnerId = jSONObject.optString("partnerId");
        this.signType = jSONObject.optString("signType");
        this.nonceStr = jSONObject.optString("nonceStr");
        this.timeStamp = jSONObject.optString("timeStamp");
        this.packageExt = jSONObject.optString("package");
        this.bVW = jSONObject.optString("paySign");
        this.dBl = jSONObject.optString("cookie");
        this.url = jSONObject.optString("url");
        this.bVX = jSONObject.optString("src_username");
        this.bVY = jSONObject.optInt("scene", 0);
        if (this.bVY == 0) {
            this.bVY = jSONObject.optInt("pay_scene", 0);
        }
        this.bJY = jSONObject.optInt("pay_channel", 0);
        this.extInfo = jSONObject.optString("ext_info", "");
        this.qUX = jSONObject.optString("token", "");
        this.qUY = bi.getInt(jSONObject.optString("result_jump_mode", "0"), 0);
        this.qUW = jSONObject.optInt("pay_for_wallet_type", 0);
    }

    public g(lp lpVar) {
        if (lpVar != null && lpVar.bVV != null) {
            this.appId = lpVar.bVV.appId;
            this.partnerId = lpVar.bVV.partnerId;
            this.signType = lpVar.bVV.signType;
            this.nonceStr = lpVar.bVV.nonceStr;
            this.timeStamp = lpVar.bVV.timeStamp;
            this.packageExt = lpVar.bVV.packageExt;
            this.bVW = lpVar.bVV.bVW;
            this.url = lpVar.bVV.url;
            this.bVX = lpVar.bVV.bVX;
            this.bVY = lpVar.bVV.bVY;
            this.bJY = lpVar.bVV.bJY;
            this.bVZ = lpVar.bVV.bVZ;
        }
    }

    public static int eC(int i, int i2) {
        if (i == 1037 && i2 > 0) {
            return i2;
        }
        return i;
    }

    public static int eD(int i, int i2) {
        int eC = eC(i, i2);
        if (eC == TbsLog.TBSLOG_CODE_SDK_BASE || eC == 1018 || eC == 1017 || eC == 1033) {
            eC = 0;
        } else if (eC == 1019) {
            eC = 1;
        } else if (eC == 1010) {
            eC = 5;
        } else if (eC == 1007 || eC == 1008) {
            eC = 6;
        } else if (eC == 1009) {
            eC = 7;
        } else if (eC == 1035 || eC == 1020) {
            eC = 8;
        } else if (eC == 1011 || eC == 1047 || eC == 1025) {
            eC = 12;
        } else if (eC == 1012 || eC == 1032 || eC == 1048 || eC == 1050) {
            eC = 13;
        } else if (eC == 1005 || eC == 1027 || eC == 1042 || eC == 1006) {
            eC = 15;
        } else if (eC == 1024 || eC == 1021) {
            eC = 16;
        } else if (eC == 1029 || eC == 1028) {
            eC = 23;
        } else if (eC == 1013 || eC == 1031 || eC == 1049) {
            eC = 24;
        } else if (eC == 1001 || eC == 1003) {
            eC = 25;
        } else if (eC == 1045 || eC == 1046) {
            eC = 26;
        } else if (eC == 1022) {
            eC = 27;
        } else if (eC == 1023) {
            eC = 28;
        } else if (eC == 1026) {
            eC = 29;
        } else if (eC == 1039) {
            eC = 30;
        } else if (eC == 1034 || eC == 1060) {
            eC = 31;
        } else if (eC == 1014 || eC == 1043 || eC == 1044 || eC == 1036) {
            eC = 32;
        }
        x.i("MicroMsg.WalletJsapiData", "parsePayChannelByScene, scene: %s, rawScene: %s, resultChannel: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(eC)});
        return eC;
    }
}
