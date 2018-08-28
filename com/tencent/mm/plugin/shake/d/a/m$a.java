package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public class m$a {
    public String path;
    public String thumbUrl;
    public String title;
    public String username;
    public int version;

    private m$a() {
    }

    public static m$a Ld(String str) {
        Map z = bl.z(str, "program");
        if (z == null) {
            return null;
        }
        try {
            m$a m_a = new m$a();
            m_a.title = bi.oV((String) z.get(".program.title"));
            m_a.thumbUrl = bi.oV((String) z.get(".program.thumburl"));
            m_a.username = bi.oV((String) z.get(".program.username"));
            m_a.path = bi.oV((String) z.get(".program.path"));
            m_a.version = bi.getInt((String) z.get(".program.version"), 0);
            return m_a;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
            return null;
        }
    }
}
