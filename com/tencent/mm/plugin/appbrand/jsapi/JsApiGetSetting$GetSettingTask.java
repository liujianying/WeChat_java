package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.v;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.protocal.c.cgi;
import com.tencent.mm.protocal.c.cgj;
import com.tencent.mm.protocal.c.eb;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class JsApiGetSetting$GetSettingTask extends MainProcessTask {
    public static final Creator<JsApiGetSetting$GetSettingTask> CREATOR = new 2();
    private String fFQ;
    public int fFw;
    public l fcy;
    public String mAppId;

    public JsApiGetSetting$GetSettingTask(Parcel parcel) {
        g(parcel);
    }

    public final void aaj() {
        x.i("MicroMsg.JsApiGetSetting", "runInClientProcess");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("errMsg", "getSetting:ok");
            jSONObject.put("authSetting", new JSONArray(bi.oV(this.fFQ)));
        } catch (JSONException e) {
            x.e("MicroMsg.JsApiGetSetting", "set json error!");
        }
        this.fcy.E(this.fFw, jSONObject.toString());
        c.az(this);
    }

    public final void aai() {
        a aVar = new a();
        aVar.dIG = new cgi();
        aVar.dIH = new cgj();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp_getauthinfo";
        aVar.dIF = 1196;
        aVar.dII = 0;
        aVar.dIJ = 0;
        cgi cgi = new cgi();
        cgi.appId = this.mAppId;
        aVar.dIG = cgi;
        v.a(aVar.KT(), new v.a() {
            public final int a(int i, int i2, String str, b bVar, com.tencent.mm.ab.l lVar) {
                x.d("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (i == 0 && i2 == 0) {
                    cgj cgj = (cgj) bVar.dIE.dIL;
                    if (cgj == null) {
                        x.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq failed, response is null!");
                    } else {
                        int i3 = cgj.sAE.errCode;
                        String str2 = cgj.sAE.Yy;
                        if (i3 == 0) {
                            LinkedList linkedList = cgj.sAF;
                            JSONArray jSONArray = new JSONArray();
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                eb ebVar = (eb) it.next();
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("scope", ebVar.scope);
                                    jSONObject.put(OpenSDKTool4Assistant.EXTRA_STATE, ebVar.state);
                                    jSONObject.put("desc", ebVar.rep);
                                    jSONArray.put(jSONObject);
                                } catch (Exception e) {
                                    x.e("MicroMsg.JsApiGetSetting", "parse json failed : %s", new Object[]{e.getMessage()});
                                }
                            }
                            JsApiGetSetting$GetSettingTask.this.fFQ = jSONArray.toString();
                            x.d("MicroMsg.JsApiGetSetting", "authInfo %s", new Object[]{jSONArray});
                        } else {
                            x.e("MicroMsg.JsApiGetSetting", "WxaAppGetAuthInfoReq error %s", new Object[]{str2});
                        }
                    }
                    JsApiGetSetting$GetSettingTask.this.a();
                }
                return 0;
            }
        }, true);
    }

    public final void g(Parcel parcel) {
        this.fFQ = parcel.readString();
        this.mAppId = parcel.readString();
        this.fFw = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fFQ);
        parcel.writeString(this.mAppId);
        parcel.writeInt(this.fFw);
    }
}
