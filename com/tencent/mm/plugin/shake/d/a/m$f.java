package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public class m$f {
    public String bgn;
    public String mYZ;
    public String userName;

    private m$f() {
    }

    public static m$f Li(String str) {
        Map z = bl.z(str, "bizprofile");
        if (z == null) {
            return null;
        }
        try {
            m$f m_f = new m$f();
            m_f.bgn = bi.oV((String) z.get(".bizprofile.nickname"));
            m_f.userName = bi.oV((String) z.get(".bizprofile.username"));
            m_f.mYZ = bi.oV((String) z.get(".bizprofile.showchat"));
            return m_f;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
            return null;
        }
    }
}
