package org.b.d;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.b.b.a;
import org.b.b.b;
import org.b.g.d;

class f {
    private HttpURLConnection aBv;
    private String charset;
    private Map<String, String> gDj;
    private String rQi = null;
    private String url;
    private boolean vKA = false;
    private Long vKB = null;
    private Long vKC = null;
    private j vKw;
    private e vKx;
    private e vKy;
    private byte[] vKz = null;

    public f(j jVar, String str) {
        this.vKw = jVar;
        this.url = str;
        this.vKx = new e();
        this.vKy = new e();
        this.gDj = new HashMap();
    }

    public g cKw() {
        try {
            String cKu = cKu();
            if (this.aBv == null) {
                System.setProperty("http.keepAlive", this.vKA ? "true" : "false");
                this.aBv = (HttpURLConnection) new URL(cKu).openConnection();
            }
            this.aBv.setRequestMethod(this.vKw.name());
            if (this.vKB != null) {
                this.aBv.setConnectTimeout(this.vKB.intValue());
            }
            if (this.vKC != null) {
                this.aBv.setReadTimeout(this.vKC.intValue());
            }
            i(this.aBv);
            if (this.vKw.equals(j.vKK) || this.vKw.equals(j.vKJ)) {
                HttpURLConnection httpURLConnection = this.aBv;
                byte[] cKA = cKA();
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(cKA.length));
                if (httpURLConnection.getRequestProperty("Content-Type") == null) {
                    httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                }
                httpURLConnection.setDoOutput(true);
                httpURLConnection.getOutputStream().write(cKA);
            }
            return new g(this.aBv);
        } catch (Exception e) {
            throw new a(e);
        }
    }

    public String cKu() {
        e eVar = this.vKx;
        String str = this.url;
        d.j(str, "Cannot append to null URL");
        String cKz = eVar.cKz();
        if (cKz.equals("")) {
            return str;
        }
        return new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str)).append(str.indexOf(63) != -1 ? "&" : Character.valueOf('?')).toString())).append(cKz).toString();
    }

    private void i(HttpURLConnection httpURLConnection) {
        for (String str : this.gDj.keySet()) {
            httpURLConnection.setRequestProperty(str, (String) this.gDj.get(str));
        }
    }

    public void addHeader(String str, String str2) {
        this.gDj.put(str, str2);
    }

    public void gD(String str, String str2) {
        this.vKx.vKv.add(new d(str, str2));
    }

    public e cKs() {
        try {
            e eVar = new e();
            eVar.adU(new URL(this.url).getQuery());
            eVar.a(this.vKx);
            return eVar;
        } catch (Exception e) {
            throw new b("Malformed URL", e);
        }
    }

    public e cKx() {
        return this.vKy;
    }

    public String getUrl() {
        return this.url;
    }

    public String cKy() {
        return this.url.replaceAll("\\?.*", "").replace("\\:\\d{4}", "");
    }

    private byte[] cKA() {
        if (this.vKz != null) {
            return this.vKz;
        }
        try {
            return (this.rQi != null ? this.rQi : this.vKy.cKz()).getBytes(cKv());
        } catch (Exception e) {
            throw new b("Unsupported Charset: " + cKv(), e);
        }
    }

    public j cKt() {
        return this.vKw;
    }

    public String cKv() {
        return this.charset == null ? Charset.defaultCharset().name() : this.charset;
    }

    public String toString() {
        return String.format("@Request(%s %s)", new Object[]{cKt(), getUrl()});
    }
}
