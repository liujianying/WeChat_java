package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.bu.a;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX$Resp;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class as implements ad {
    private static k<ad, Bundle> tNy = new 1();
    private Context context;
    private final Map<String, Req> tNB = new HashMap();

    public as(Context context) {
        this.context = context;
    }

    public static void ah(Bundle bundle) {
        tNy.ci(bundle);
        tNy.doNotify();
    }

    public final void ag(Bundle bundle) {
        x.d("MicroMsg.WXAppMessageShower", "handleResp, appid = " + Uri.parse(bundle.getString("_mmessage_content")).getQueryParameter("appid"));
        ShowMessageFromWX$Resp showMessageFromWX$Resp = new ShowMessageFromWX$Resp(bundle);
        x.i("MicroMsg.WXAppMessageShower", "handleResp, errCode = " + showMessageFromWX$Resp.errCode + ", type = " + showMessageFromWX$Resp.getType());
        if (((Req) this.tNB.get(showMessageFromWX$Resp.transaction)) == null) {
            x.e("MicroMsg.WXAppMessageShower", "invalid resp, check transaction failed, transaction=" + showMessageFromWX$Resp.transaction);
        } else {
            this.tNB.remove(showMessageFromWX$Resp.transaction);
        }
    }

    public final void a(String str, WXMediaMessage wXMediaMessage, String str2, String str3) {
        x.d("MicroMsg.WXAppMessageShower", "request pkg = %s, openId = %s", new Object[]{str, str3});
        a.post(new 2(this, wXMediaMessage, str3, str, str2));
    }
}
