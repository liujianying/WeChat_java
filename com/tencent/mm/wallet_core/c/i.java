package com.tencent.mm.wallet_core.c;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.g.b.a.c;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.protocal.c.aw;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class i extends m {
    public b diG;
    public e diJ;
    public int pmS = 0;
    public String pmT = "";
    public int pmU = 0;
    public String pmV = "";
    public int pmW = 0;
    public String uXh = "";
    public String uXi = "";
    public String uXj = "";
    public boolean uXk = false;
    protected String uXl;
    public boolean uXm = false;
    private Map<String, String> uXn = new HashMap();
    public boolean uXo = false;

    public abstract void J(boolean z, boolean z2);

    public abstract String OT(String str);

    public abstract void a(int i, String str, JSONObject jSONObject);

    public abstract void a(b bVar, bhy bhy);

    public abstract void b(b bVar, bhy bhy);

    public abstract int bNX();

    public abstract n d(b bVar);

    public void a(c cVar, JSONObject jSONObject) {
    }

    public boolean bOn() {
        return false;
    }

    public final void aB(Map<String, String> map) {
        Map map2;
        if (map2 == null) {
            map2 = new HashMap();
        }
        if (map2 != null) {
            map2.remove(OpenSDKTool4Assistant.EXTRA_UIN);
        }
        if (this.uXn == null) {
            this.uXn = new HashMap();
        }
        if (this.uXn != null) {
            this.uXn.remove(OpenSDKTool4Assistant.EXTRA_UIN);
        }
        Object[] toArray = map2.keySet().toArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < toArray.length) {
                Object obj = toArray[i2];
                String str = (String) map2.get(obj);
                if (this.uXn.containsKey(obj)) {
                    this.uXn.remove(obj);
                }
                this.uXn.put((String) obj, str);
                i = i2 + 1;
            } else {
                F(this.uXn);
                return;
            }
        }
    }

    public final void F(Map<String, String> map) {
        Map map2;
        if (map2 == null) {
            map2 = new HashMap();
        }
        if (map2 != null) {
            map2.remove(OpenSDKTool4Assistant.EXTRA_UIN);
        }
        if (!f.cfE()) {
            map2.put("jsapi_reqkey", f.cfF());
        }
        this.uXn = map2;
        J(true, true);
        if (map2 != null) {
            Object[] toArray = map2.keySet().toArray();
            Arrays.sort(toArray);
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            for (Object obj : toArray) {
                String str = (String) map2.get(obj);
                if (!bi.oW(str)) {
                    if (i != 0) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(obj);
                    stringBuilder.append("=");
                    b(stringBuilder, str);
                    i = true;
                }
            }
            if (com.tencent.mm.sdk.a.b.chp()) {
                x.v("MicroMsg.NetScenePayBase", "RQ: Cmd : " + bNX() + ", req = " + stringBuilder.toString() + " " + toString() + " " + bi.cjd().toString());
            } else {
                x.i("MicroMsg.NetScenePayBase", "RQ: Cmd : " + bNX() + ", req = " + stringBuilder.toString() + " " + toString());
            }
            String OT = OT(stringBuilder.toString());
            stringBuilder.append(i != 0 ? "&" : "");
            stringBuilder.append("WCPaySign");
            stringBuilder.append("=");
            stringBuilder.append(OT);
            a(this.diG, new bhy().bq(stringBuilder.toString().getBytes()));
        }
        x.i("MicroMsg.NetScenePayBase", "setRequestData getPayCgicmd: %s type: %s this: %s cgi %s ", new Object[]{Integer.valueOf(bNX()), Integer.valueOf(getType()), toString(), this.diG.uri});
    }

    public void b(StringBuilder stringBuilder, String str) {
        stringBuilder.append(str);
    }

    public final void aC(Map<String, String> map) {
        boolean z = false;
        J(false, false);
        if (map != null) {
            aw bOL = com.tencent.mm.plugin.wallet_core.model.i.bOL();
            if (bOL != null) {
                x.i("MicroMsg.NetScenePayBase", "location found");
                map.put("province", bOL.csK);
                if (!map.containsKey("city")) {
                    map.put("city", bOL.csL);
                }
                map.put("location_timestamp", bOL.raY);
                map.put("encrypt_key", bOL.rbc);
                map.put("encrypt_userinfo", bOL.rbb);
                if (com.tencent.mm.plugin.wallet_core.model.i.bOO()) {
                    map.put("encrypt_cellinfo", bOL.rbd);
                }
            }
            Object[] toArray = map.keySet().toArray();
            Arrays.sort(toArray);
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (true) {
                boolean z2 = z;
                if (i >= toArray.length) {
                    break;
                }
                Object obj = toArray[i];
                String str = (String) map.get(obj);
                if (!bi.oW(str)) {
                    if (z2) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(obj);
                    stringBuilder.append("=");
                    stringBuilder.append(str);
                }
                z = i + 1;
            }
            if (com.tencent.mm.sdk.a.b.chp()) {
                x.d("MicroMsg.NetScenePayBase", "Cmd : " + bNX() + ", wxreq = " + stringBuilder.toString());
            }
            x.d("MicroMsg.NetScenePayBase", "wxreq: " + stringBuilder.toString());
            b(this.diG, new bhy().bq(stringBuilder.toString().getBytes()));
        }
    }

    public final void a(PayInfo payInfo, Map<String, String> map, Map<String, String> map2) {
        a(payInfo, map, map2, false);
    }

    public final void a(PayInfo payInfo, Map<String, String> map, Map<String, String> map2, boolean z) {
        Map map22;
        if (map22 == null) {
            map22 = new HashMap();
        }
        if (payInfo == null) {
            x.e("MicroMsg.NetScenePayBase", "Cmd : " + bNX() + ", payInfo is null");
            map22.put("devicename", Build.MODEL);
            aC(map22);
            return;
        }
        map.put("req_key", payInfo.bOd);
        map.put("partner_id", payInfo.partnerId);
        map.put("pay_sign", payInfo.cdL);
        if (payInfo.qUO >= 0) {
            map.put("auto_deduct_flag", payInfo.qUO);
        }
        if (payInfo.bVY > 0) {
            map.put("pay_scene", payInfo.bVY);
        }
        if (payInfo.bVZ >= 0) {
            map.put("bindbankscene", payInfo.bVZ);
        }
        if (!bi.oW(payInfo.qUP)) {
            map.put("deduct_bank_type", payInfo.qUP);
        }
        if (!bi.oW(payInfo.qUQ)) {
            map.put("deduct_bind_serial", payInfo.qUQ);
        }
        if (z) {
            map.put("use_touch", "0");
        } else {
            map.put("use_touch", payInfo.pxN);
        }
        map.put("fp_identify_num", payInfo.pxO);
        if (!TextUtils.isEmpty(payInfo.bQb)) {
            map.put("encrypted_pay_info", URLEncoder.encode(payInfo.bQb));
        }
        if (!TextUtils.isEmpty(payInfo.bQc)) {
            map.put("encrypted_rsa_sign", URLEncoder.encode(payInfo.bQc));
        }
        map22.put("uuid", payInfo.fMk);
        map22.put("appid", payInfo.appId);
        map22.put("appsource", payInfo.pCO);
        map22.put("channel", payInfo.bVU);
        map22.put("devicename", Build.MODEL);
        map22.put("soter_req", payInfo.bVE);
    }

    public final void e(int i, int i2, String str, q qVar) {
        int i3;
        Exception e;
        c cVar;
        Map z;
        if (af.eye && 1686 == bNX()) {
            i = 3;
            i2 = -1;
        }
        x.i("MicroMsg.NetScenePayBase", "cgi: %d, rrType %d, rrCgi %s, PayCgicmd %s, errType %d, errCode %d, errMsg %s, this: %s ", new Object[]{Integer.valueOf(getType()), Integer.valueOf(qVar.getType()), qVar.getUri(), Integer.valueOf(bNX()), Integer.valueOf(i), Integer.valueOf(i2), str, toString()});
        n d = d((b) qVar);
        int i4 = d.rPw;
        String str2 = d.rPx;
        int i5 = d.uXp;
        String str3 = d.iwT;
        String string = ad.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.wallet_data_err);
        JSONObject jSONObject = null;
        String b = ab.b(d.rPv);
        if (bi.oW(b)) {
            x.w("MicroMsg.NetScenePayBase", "hy: respString is null");
            i3 = -10088;
        } else {
            JSONObject jSONObject2;
            try {
                jSONObject2 = new JSONObject(b);
                try {
                    this.uXl = jSONObject2.optString("error_detail_url");
                    i3 = jSONObject2.getInt("retcode");
                    string = jSONObject2.optString("retmsg");
                    this.uXh = jSONObject2.optString("pay_flag");
                    this.uXi = jSONObject2.optString("return_url");
                    this.uXj = jSONObject2.optString("wappay_jumped_url");
                    this.pmS = jSONObject2.optInt("is_gen_cert");
                    this.pmT = jSONObject2.optString("crt_token");
                    this.pmU = jSONObject2.optInt("is_hint_crt");
                    jSONObject = jSONObject2.optJSONObject("crt_wording");
                    if (jSONObject != null) {
                        this.pmV = jSONObject.toString();
                    } else {
                        this.pmV = "";
                    }
                    this.pmW = jSONObject2.optInt("is_ignore_crt");
                    if (jSONObject2.optInt("del_cert", 0) != 0) {
                        s.cDi();
                        x.i("MicroMsg.NetScenePayBase", "clean token %s", new Object[]{s.cDh()});
                        s.cDi().abV(r4);
                    }
                    this.uXm = true;
                    jSONObject = jSONObject2;
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Exception e3) {
                e = e3;
                jSONObject2 = null;
                x.w("MicroMsg.NetScenePayBase", "hy: json resolve error: error when resolving error code : " + e.toString());
                i3 = -10089;
                str3 = ad.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.wallet_json_err);
                jSONObject = jSONObject2;
                x.i("MicroMsg.NetScenePayBase", "tenpayResp: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", new Object[]{Integer.valueOf(getType()), Integer.valueOf(bNX()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i4), str2, Integer.valueOf(i5), str3, Integer.valueOf(i3), string, jSONObject, toString()});
                cVar = new c(i, i2, str);
                if (i == 0) {
                }
                x.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
                z = bl.z(str, "e");
                if (z != null) {
                    x.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
                    cVar.Yy = (String) z.get(".e.Content");
                } else if (i2 == -1 || i2 == -500) {
                    x.w("MicroMsg.NetScenePayBase", "hy: network error");
                    cVar.Yy = ad.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.wallet_net_err);
                } else {
                    x.w("MicroMsg.NetScenePayBase", "hy: unknown system error");
                    cVar.Yy = ad.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.wallet_data_err);
                }
                if (i == 0) {
                    try {
                        x.e("MicroMsg.NetScenePayBase", "errType is OK, reportCellInfo do nothing");
                    } catch (Exception e4) {
                        x.e("MicroMsg.NetScenePayBase", "reportCellInfo error. %s", new Object[]{e4.getMessage()});
                    }
                } else if (com.tencent.mm.plugin.wallet_core.model.i.bOO()) {
                    aw bOL = com.tencent.mm.plugin.wallet_core.model.i.bOL();
                    if (!(bOL == null || bi.oW(bOL.rbc) || bi.oW(bOL.rbd))) {
                        int bNX = bNX();
                        String str4 = bOL.rbc;
                        String str5 = bOL.rbb;
                        String str6 = bOL.rbd;
                        if (!bi.oW(str6)) {
                            int length = str6.length();
                            String str7 = "";
                            str3 = "";
                            b = "";
                            string = "";
                            String str8 = "";
                            if (length > 5000) {
                                x.e("MicroMsg.NetScenePayBase", "reportCellInfo. cell info is too long to report");
                            } else if (length > 4000) {
                                str7 = str6.substring(0, BaseReportManager.MAX_READ_COUNT);
                                str3 = str6.substring(BaseReportManager.MAX_READ_COUNT, 2000);
                                b = str6.substring(2000, 3000);
                                string = str6.substring(3000, 4000);
                                str8 = str6.substring(4000, length);
                            } else if (length > 3000) {
                                str7 = str6.substring(0, BaseReportManager.MAX_READ_COUNT);
                                str3 = str6.substring(BaseReportManager.MAX_READ_COUNT, 2000);
                                b = str6.substring(2000, 3000);
                                string = str6.substring(3000, length);
                            } else if (length > 2000) {
                                str7 = str6.substring(0, BaseReportManager.MAX_READ_COUNT);
                                str3 = str6.substring(BaseReportManager.MAX_READ_COUNT, 2000);
                                b = str6.substring(2000, length);
                            } else if (length > BaseReportManager.MAX_READ_COUNT) {
                                str7 = str6.substring(0, BaseReportManager.MAX_READ_COUNT);
                                str3 = str6.substring(BaseReportManager.MAX_READ_COUNT, length);
                            } else if (length > 0) {
                                str7 = str6.substring(0, length);
                            }
                            x.e("MicroMsg.NetScenePayBase", "reportCellInfo do report");
                            c cVar2 = new c();
                            cVar2.cgm = bNX;
                            cVar2.cgn = i;
                            cVar2.cgo = i2;
                            cVar2.cgp = str4;
                            cVar2.cgq = str5;
                            cVar2.cgr = String.valueOf(length);
                            cVar2.cgs = str7;
                            cVar2.cgt = str3;
                            cVar2.cgu = b;
                            cVar2.cgv = string;
                            cVar2.cgw = str8;
                            cVar2.RD();
                        }
                    }
                } else {
                    x.e("MicroMsg.NetScenePayBase", "shouldReportCellInfo is false, reportCellInfo do nothing");
                }
                if (jSONObject != null) {
                    x.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
                } else if ((cVar.errType == 0 && cVar.errCode == 0) || brf()) {
                    a(cVar.errCode, cVar.Yy, jSONObject);
                } else {
                    x.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
                }
                a(cVar, jSONObject);
                if (this.uXk) {
                    x.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
                } else {
                    this.diJ.a(cVar.errType, cVar.errCode, cVar.Yy, this);
                }
            }
        }
        x.i("MicroMsg.NetScenePayBase", "tenpayResp: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", new Object[]{Integer.valueOf(getType()), Integer.valueOf(bNX()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i4), str2, Integer.valueOf(i5), str3, Integer.valueOf(i3), string, jSONObject, toString()});
        cVar = new c(i, i2, str);
        if (i == 0 || i2 != 0) {
            x.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
            z = bl.z(str, "e");
            if (z != null) {
                x.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
                cVar.Yy = (String) z.get(".e.Content");
            } else if (i2 == -1 || i2 == -500) {
                x.w("MicroMsg.NetScenePayBase", "hy: network error");
                cVar.Yy = ad.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.wallet_net_err);
            } else {
                x.w("MicroMsg.NetScenePayBase", "hy: unknown system error");
                cVar.Yy = ad.getContext().getString(com.tencent.mm.plugin.wxpay.a.i.wallet_data_err);
            }
        } else if (i4 != 0) {
            x.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: plat ret is error");
            cVar.e(BaseReportManager.MAX_READ_COUNT, i4, str2, 1);
        } else if (i5 != 0) {
            x.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: errType is error");
            cVar.e(BaseReportManager.MAX_READ_COUNT, i5, str3, 2);
        } else if (i3 != 0) {
            x.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: retCode is error");
            if (i3 == -10089 || i3 == -10088) {
                cVar.e(BaseReportManager.MAX_READ_COUNT, 2, string, 2);
            } else {
                cVar.e(BaseReportManager.MAX_READ_COUNT, i3, string, 2);
            }
        } else {
            x.i("MicroMsg.NetScenePayBase", "hy: all's OK");
        }
        if (i == 0) {
            try {
                x.e("MicroMsg.NetScenePayBase", "errType is OK, reportCellInfo do nothing");
            } catch (Exception e42) {
                x.e("MicroMsg.NetScenePayBase", "reportCellInfo error. %s", new Object[]{e42.getMessage()});
            }
        } else if (com.tencent.mm.plugin.wallet_core.model.i.bOO()) {
            aw bOL2 = com.tencent.mm.plugin.wallet_core.model.i.bOL();
            if (!(bOL2 == null || bi.oW(bOL2.rbc) || bi.oW(bOL2.rbd))) {
                int bNX2 = bNX();
                String str42 = bOL2.rbc;
                String str52 = bOL2.rbb;
                String str62 = bOL2.rbd;
                if (!bi.oW(str62)) {
                    int length2 = str62.length();
                    String str72 = "";
                    str3 = "";
                    b = "";
                    string = "";
                    String str82 = "";
                    if (length2 > 5000) {
                        x.e("MicroMsg.NetScenePayBase", "reportCellInfo. cell info is too long to report");
                    } else if (length2 > 4000) {
                        str72 = str62.substring(0, BaseReportManager.MAX_READ_COUNT);
                        str3 = str62.substring(BaseReportManager.MAX_READ_COUNT, 2000);
                        b = str62.substring(2000, 3000);
                        string = str62.substring(3000, 4000);
                        str82 = str62.substring(4000, length2);
                    } else if (length2 > 3000) {
                        str72 = str62.substring(0, BaseReportManager.MAX_READ_COUNT);
                        str3 = str62.substring(BaseReportManager.MAX_READ_COUNT, 2000);
                        b = str62.substring(2000, 3000);
                        string = str62.substring(3000, length2);
                    } else if (length2 > 2000) {
                        str72 = str62.substring(0, BaseReportManager.MAX_READ_COUNT);
                        str3 = str62.substring(BaseReportManager.MAX_READ_COUNT, 2000);
                        b = str62.substring(2000, length2);
                    } else if (length2 > BaseReportManager.MAX_READ_COUNT) {
                        str72 = str62.substring(0, BaseReportManager.MAX_READ_COUNT);
                        str3 = str62.substring(BaseReportManager.MAX_READ_COUNT, length2);
                    } else if (length2 > 0) {
                        str72 = str62.substring(0, length2);
                    }
                    x.e("MicroMsg.NetScenePayBase", "reportCellInfo do report");
                    c cVar22 = new c();
                    cVar22.cgm = bNX2;
                    cVar22.cgn = i;
                    cVar22.cgo = i2;
                    cVar22.cgp = str42;
                    cVar22.cgq = str52;
                    cVar22.cgr = String.valueOf(length2);
                    cVar22.cgs = str72;
                    cVar22.cgt = str3;
                    cVar22.cgu = b;
                    cVar22.cgv = string;
                    cVar22.cgw = str82;
                    cVar22.RD();
                }
            }
        } else {
            x.e("MicroMsg.NetScenePayBase", "shouldReportCellInfo is false, reportCellInfo do nothing");
        }
        if (jSONObject != null) {
            x.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
        } else if ((cVar.errType == 0 && cVar.errCode == 0) || brf()) {
            a(cVar.errCode, cVar.Yy, jSONObject);
        } else {
            x.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
        }
        a(cVar, jSONObject);
        if (this.uXk) {
            x.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
        } else {
            this.diJ.a(cVar.errType, cVar.errCode, cVar.Yy, this);
        }
    }

    public String blM() {
        return null;
    }

    public boolean brf() {
        return false;
    }

    public boolean bkT() {
        reset();
        return false;
    }

    public final int baY() {
        return bNX();
    }

    public final String cCY() {
        return this.uXl;
    }

    public boolean bkU() {
        return true;
    }
}
