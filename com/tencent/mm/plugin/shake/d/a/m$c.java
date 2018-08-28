package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public class m$c {
    public String id;
    public String thumbUrl;
    public String title;

    private m$c() {
    }

    public static m$c Lf(String str) {
        Map z = bl.z(str, "product");
        if (z == null) {
            return null;
        }
        try {
            m$c m_c = new m$c();
            m_c.title = bi.oV((String) z.get(".product.title"));
            m_c.thumbUrl = bi.oV((String) z.get(".product.thumburl"));
            m_c.id = bi.oV((String) z.get(".product.product_id"));
            return m_c;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ShakeTVXmlParser", e, "", new Object[0]);
            return null;
        }
    }
}
