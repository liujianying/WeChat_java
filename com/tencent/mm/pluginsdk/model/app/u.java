package com.tencent.mm.pluginsdk.model.app;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ad;

public class u implements a<Bundle, IPCBoolean> {
    public final /* synthetic */ void a(Object obj, c cVar) {
        Bundle bundle = (Bundle) obj;
        if (bundle != null && "com.tencent.mm".equals(e.Cs())) {
            String string = bundle.getString("appId");
            String string2 = bundle.getString("extInfo");
            f bk = g.bk(string, true);
            if (bk != null) {
                WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                wXAppExtendObject.extInfo = string2;
                WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                wXMediaMessage.sdkVer = 620823808;
                wXMediaMessage.messageExt = string2;
                boolean a = g.a(ad.getContext(), bk.field_appId, wXMediaMessage, 2, null, null);
                if (cVar != null) {
                    cVar.at(new IPCBoolean(a));
                }
            }
        }
    }
}
