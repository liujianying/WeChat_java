package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public class m$e {
    public String bVX;
    public String egr;
    public String thumbUrl;
    public String title;

    private m$e() {
    }

    public static m$e Lh(String str) {
        Map z = bl.z(str, "h5url");
        if (z == null) {
            return null;
        }
        try {
            m$e m_e = new m$e();
            m_e.title = bi.oV((String) z.get(".h5url.title"));
            m_e.thumbUrl = bi.oV((String) z.get(".h5url.thumburl"));
            m_e.egr = bi.oV((String) z.get(".h5url.link"));
            m_e.bVX = bi.oV((String) z.get(".h5url.username"));
            return m_e;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
            return null;
        }
    }
}
