package org.b.a.a;

import org.b.d.i;

public class c extends b {
    public String cKr() {
        return "http://api.twitter.com/oauth/access_token";
    }

    public String cKq() {
        return "http://api.twitter.com/oauth/request_token";
    }

    public final String b(i iVar) {
        return String.format("https://api.twitter.com/oauth/authorize?oauth_token=%s", new Object[]{iVar.token});
    }
}
