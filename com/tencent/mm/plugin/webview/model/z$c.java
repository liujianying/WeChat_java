package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.webview.model.z.b;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class z$c {
    public static boolean a(String str, String str2, int i, d dVar, z.d dVar2, b bVar, int i2) {
        if (dVar == null) {
            x.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize invoker null");
            return false;
        }
        x.i("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorize scene: %d", new Object[]{Integer.valueOf(i)});
        dVar2.c(new 1(dVar2, bVar));
        Bundle bundle = new Bundle();
        bundle.putString("oauth_url", str);
        bundle.putString("biz_username", str2);
        bundle.putInt("scene", i);
        bundle.putInt("webview_binder_id", i2);
        try {
            bVar.add(1254);
            dVar.s(1254, bundle);
            return true;
        } catch (RemoteException e) {
            x.w("MicroMsg.OauthAuthorizeLogic", "invoker.doScene exp : %s", new Object[]{e.getLocalizedMessage()});
            return false;
        }
    }

    static void a(d dVar, String str, int i, ArrayList<String> arrayList, b bVar, boolean z, int i2) {
        if (dVar == null) {
            x.e("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm invoker null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("oauth_url", str);
        bundle.putInt("opt", i);
        bundle.putStringArrayList("scopes", arrayList);
        bundle.putInt("webview_binder_id", i2);
        if (z) {
            try {
                bVar.add(1373);
            } catch (RemoteException e) {
                x.w("MicroMsg.OauthAuthorizeLogic", "doOauthAuthorizeConfirm doScene exp : %s", new Object[]{e.getLocalizedMessage()});
                return;
            }
        }
        dVar.s(1373, bundle);
    }

    public static boolean b(String str, d dVar) {
        if (z.bUd() == null && !z.bUe()) {
            try {
                Bundle g = dVar.g(94, new Bundle());
                String str2 = null;
                if (g != null) {
                    str2 = g.getString("oauth_host_paths");
                }
                if (bi.oW(str2)) {
                    str2 = "open.weixin.qq.com/connect/oauth2/authorize";
                }
                z.B(str2.split(";"));
                z.yU();
            } catch (RemoteException e) {
                x.w("MicroMsg.OauthAuthorizeLogic", "isOauthHost exp:%s", new Object[]{e.getLocalizedMessage()});
                return false;
            }
        }
        if (z.bUd() == null || z.bUd().length == 0) {
            x.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost sOauthHostPaths nil");
            return false;
        }
        Uri parse = Uri.parse(str);
        String str3 = parse.getAuthority() + parse.getPath();
        if (bi.oW(str3)) {
            x.i("MicroMsg.OauthAuthorizeLogic", "isOauthHost target nil");
            return false;
        }
        x.d("MicroMsg.OauthAuthorizeLogic", "isOauthHost target:%s", new Object[]{str3});
        for (String equalsIgnoreCase : z.bUd()) {
            if (str3.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(d dVar) {
        try {
            Bundle g = dVar.g(93, new Bundle());
            if (g != null) {
                return g.getBoolean("is_oauth_native");
            }
            x.w("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept Bundle isOauthNative null");
            return false;
        } catch (RemoteException e) {
            x.w("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept exp:%s", new Object[]{e.getLocalizedMessage()});
            return false;
        }
    }

    public static String Qj(String str) {
        if (bi.oW(str)) {
            return null;
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("appid");
            if (!bi.oW(queryParameter)) {
                return queryParameter;
            }
            x.i("MicroMsg.OauthAuthorizeLogic", "parseAppId try case not sensitive, oauthUrl:%s", new Object[]{str});
            return Uri.parse(str.toLowerCase()).getQueryParameter("appid");
        } catch (Exception e) {
            return null;
        }
    }
}
