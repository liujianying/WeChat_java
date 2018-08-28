package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.ab.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.protocal.c.aol;
import com.tencent.mm.protocal.c.aom;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ak extends a {
    public static final int CTRL_BYTE = -3;
    public static final String NAME = "preVerifyJSAPI";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiPreVerify", "invoke");
        String optString = jSONObject.optString("verifyAppId");
        String optString2 = jSONObject.optString("verifySignature");
        String optString3 = jSONObject.optString("verifyNonceStr");
        String optString4 = jSONObject.optString("verifyTimestamp");
        String optString5 = jSONObject.optString("verifySignType");
        JSONArray optJSONArray = jSONObject.optJSONArray("verifyJsApiList");
        x.i("MicroMsg.GameJsApiPreVerify", "appid : %s, %s, %s, %s, %s", new Object[]{optString, optString2, optString3, optString4, optString5});
        String currentURL = dVar.getCurrentURL();
        LinkedList linkedList = new LinkedList();
        try {
            x.i("MicroMsg.GameJsApiPreVerify", "jsItem length %s", new Object[]{Integer.valueOf(optJSONArray.length())});
            if (optJSONArray.length() == 0) {
                dVar.E(i, "checkJsApi:param is empty");
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                String string = optJSONArray.getString(i2);
                if (!bi.oW(string)) {
                    linkedList.add(string);
                }
            }
            if (bi.oW(optString) || linkedList.size() <= 0 || bi.oW(currentURL)) {
                x.e("MicroMsg.GameJsApiPreVerify", "handlePreVerify wrong args, %s", new Object[]{optString});
                dVar.E(i, a.f("pre_verify_jsapi:fail_invalid_args", null));
                return;
            }
            b.a aVar = new b.a();
            aVar.dIG = new aol();
            aVar.dIH = new aom();
            aVar.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
            aVar.dIF = 1093;
            aVar.dII = 0;
            aVar.dIJ = 0;
            b KT = aVar.KT();
            aol aol = (aol) KT.dID.dIL;
            aol.url = currentURL;
            aol.bPS = optString;
            aol.rQU = linkedList;
            aol.bJT = optString4;
            aol.rQE = optString3;
            aol.signature = optString2;
            aol.rQF = optString5;
            com.tencent.mm.ipcinvoker.wx_extension.b.a(KT, new a(dVar, i, optString));
        } catch (Exception e) {
            x.w("MicroMsg.GameJsApiPreVerify", "exception occur " + e.getMessage());
            dVar.E(i, "pre_verify_jsapi:fail");
        }
    }
}
