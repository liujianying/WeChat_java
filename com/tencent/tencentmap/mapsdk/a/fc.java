package com.tencent.tencentmap.mapsdk.a;

import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

public final class fc implements ex {
    public int a = 1;
    public Exception b = null;
    public String c = null;
    public String d = null;
    public byte[] e = null;
    public InputStream f = null;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public HttpResponse j;
    public int k = 0;
    public String l = "";
    public String m = "";

    public final int a() {
        return this.a;
    }

    public final String a(String str) {
        if (this.j != null) {
            Header firstHeader = this.j.getFirstHeader(str);
            if (firstHeader != null) {
                return firstHeader.getValue();
            }
        }
        return null;
    }

    public final Exception b() {
        return this.b;
    }

    public final byte[] c() {
        return this.e;
    }
}
