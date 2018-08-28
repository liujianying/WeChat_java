package com.tencent.mm.plugin.webview.modeltools;

import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;

public final class i {
    private final LinkedList<String> pUw = new LinkedList();

    public final void pS(String str) {
        try {
            if (!bi.oW(str)) {
                synchronized (this.pUw) {
                    String str2 = (String) this.pUw.peekLast();
                    String encode = URLEncoder.encode(str);
                    if (str2 == null || !str2.equals(encode)) {
                        this.pUw.addLast(encode);
                    }
                    if (this.pUw.size() > 10) {
                        this.pUw.removeFirst();
                    }
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.WebViewURLRouteList", "add exp = %s", new Object[]{bi.i(e)});
        }
    }

    public final String[] bVe() {
        String[] strArr;
        synchronized (this.pUw) {
            strArr = new String[this.pUw.size()];
            Iterator it = this.pUw.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2 = i + 1;
                strArr[i] = (String) it.next();
                i = i2;
            }
        }
        return strArr;
    }

    public final void bVf() {
        if (b.chp()) {
            StringBuilder stringBuilder = new StringBuilder("routeList: ");
            synchronized (this.pUw) {
                Iterator it = this.pUw.iterator();
                while (it.hasNext()) {
                    stringBuilder.append(URLDecoder.decode((String) it.next())).append("\n");
                }
            }
            x.d("MicroMsg.WebViewURLRouteList", stringBuilder.toString());
        }
    }
}
