package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public class m$d {
    public String mYY;
    public String thumbUrl;
    public String title;
    public String username;

    private m$d() {
    }

    public static m$d Lg(String str) {
        Map z = bl.z(str, "tempsession");
        if (z == null) {
            return null;
        }
        try {
            m$d m_d = new m$d();
            m_d.title = bi.oV((String) z.get(".tempsession.title"));
            m_d.thumbUrl = bi.oV((String) z.get(".tempsession.thumburl"));
            m_d.username = bi.oV((String) z.get(".tempsession.username"));
            m_d.mYY = bi.oV((String) z.get(".tempsession.deeplinkjumpurl"));
            return m_d;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
            return null;
        }
    }
}
