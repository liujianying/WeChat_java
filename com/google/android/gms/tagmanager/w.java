package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class w {
    private static w bbM;
    volatile int bbN = a.bbQ;
    volatile String bbO = null;
    private volatile String bbP = null;
    volatile String bbj = null;

    w() {
    }

    private static String by(String str) {
        return str.split("&")[0].split("=")[1];
    }

    static w rw() {
        w wVar;
        synchronized (w.class) {
            if (bbM == null) {
                bbM = new w();
            }
            wVar = bbM;
        }
        return wVar;
    }

    final synchronized boolean f(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    m.rf();
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.bbN = a.bbS;
                    } else {
                        this.bbN = a.bbR;
                    }
                    this.bbP = uri.getQuery().replace("&gtm_debug=x", "");
                    if (this.bbN == a.bbR || this.bbN == a.bbS) {
                        this.bbO = "/r?" + this.bbP;
                    }
                    this.bbj = by(this.bbP);
                } else {
                    if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                        m.rd();
                        z = false;
                    } else if (by(uri.getQuery()).equals(this.bbj)) {
                        new StringBuilder("Exit preview mode for container: ").append(this.bbj);
                        m.rf();
                        this.bbN = a.bbQ;
                        this.bbO = null;
                    } else {
                        z = false;
                    }
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }
}
