package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public class m$b {
    public String lPj;
    public String mYX;
    public String thumbUrl;
    public String title;

    private m$b() {
    }

    public static m$b Le(String str) {
        Map z = bl.z(str, "nativepay");
        if (z == null) {
            return null;
        }
        try {
            m$b m_b = new m$b();
            m_b.title = bi.oV((String) z.get(".nativepay.title"));
            m_b.thumbUrl = bi.oV((String) z.get(".nativepay.thumburl"));
            m_b.mYX = bi.oV((String) z.get(".nativepay.wx_pay_url"));
            m_b.lPj = bi.oV((String) z.get(".nativepay.price"));
            return m_b;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
            return null;
        }
    }
}
