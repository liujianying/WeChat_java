package com.tencent.mm.sdk.c;

import com.tencent.mm.sdk.c.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

public class b$b {
    public int dkb;
    public String host;
    public int mcx = 0;
    public Map<String, String> mcy = null;
    public Map<String, String> mcz = null;
    public String sFu;
    public a sFv = null;
    public String uri;

    public final String getUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!(this.uri.startsWith("http://") || this.uri.startsWith("https://"))) {
            stringBuilder.append(this.sFu + this.host);
        }
        stringBuilder.append(this.uri);
        if (this.mcy == null) {
            return stringBuilder.toString();
        }
        stringBuilder.append('?');
        Object obj = 1;
        Iterator it = this.mcy.keySet().iterator();
        while (true) {
            Object obj2 = obj;
            if (!it.hasNext()) {
                return stringBuilder.toString();
            }
            String str = (String) it.next();
            stringBuilder.append(obj2 != null ? "" : "&").append(URLEncoder.encode(str, "utf-8")).append('=').append(URLEncoder.encode(bi.oV((String) this.mcy.get(str)), "utf-8"));
            obj = null;
        }
    }

    public final String toString() {
        try {
            return getUrl();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.HttpWrapperBase", e, "", new Object[0]);
            return "";
        }
    }
}
