package org.b.d;

import java.util.HashMap;
import java.util.Map;

public final class c extends f {
    public Map<String, String> vKu = new HashMap();

    public final /* bridge */ /* synthetic */ void addHeader(String str, String str2) {
        super.addHeader(str, str2);
    }

    public final /* bridge */ /* synthetic */ e cKs() {
        return super.cKs();
    }

    public final /* bridge */ /* synthetic */ j cKt() {
        return super.cKt();
    }

    public final /* bridge */ /* synthetic */ String cKu() {
        return super.cKu();
    }

    public final /* bridge */ /* synthetic */ String cKv() {
        return super.cKv();
    }

    public final /* bridge */ /* synthetic */ g cKw() {
        return super.cKw();
    }

    public final /* bridge */ /* synthetic */ e cKx() {
        return super.cKx();
    }

    public final /* bridge */ /* synthetic */ String cKy() {
        return super.cKy();
    }

    public final /* bridge */ /* synthetic */ void gD(String str, String str2) {
        super.gD(str, str2);
    }

    public final /* bridge */ /* synthetic */ String getUrl() {
        return super.getUrl();
    }

    public c(j jVar, String str) {
        super(jVar, str);
    }

    public final void gC(String str, String str2) {
        Map map = this.vKu;
        if (str.startsWith("oauth_") || str.equals("scope")) {
            map.put(str, str2);
        } else {
            throw new IllegalArgumentException(String.format("OAuth parameters must either be '%s' or start with '%s'", new Object[]{"scope", "oauth_"}));
        }
    }

    public final String toString() {
        return String.format("@OAuthRequest(%s, %s)", new Object[]{super.cKt(), super.getUrl()});
    }
}
