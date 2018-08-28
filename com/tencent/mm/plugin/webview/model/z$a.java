package com.tencent.mm.plugin.webview.model;

import android.os.Bundle;
import com.tencent.mm.k.g;
import com.tencent.mm.sdk.platformtools.x;

public final class z$a {
    public static Bundle bUf() {
        x.d("MicroMsg.OauthAuthorizeLogic", "getOauthHostPaths : %s", new Object[]{g.AU().G("WebViewConfig", "oauthHostPath")});
        Bundle bundle = new Bundle();
        bundle.putString("oauth_host_paths", r0);
        return bundle;
    }
}
