package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class n {
    public static String aV(Context context, String str) {
        String str2;
        Assert.assertTrue("MicroMsg.WechatWebViewUserAgentUtil, appendUserAgent fail, context is null, stack = " + bi.cjd(), context != null);
        if (str == null) {
            str2 = " MicroMessenger/";
        } else {
            str2 = str + " MicroMessenger/";
        }
        PackageInfo packageInfo = getPackageInfo(context, ad.getPackageName());
        if (packageInfo != null) {
            str2 = ((str2 + e.aj(null, d.qVN)) + "." + packageInfo.versionCode) + "(" + com.tencent.mm.sdk.platformtools.d.CLIENT_VERSION + ")";
        }
        str2 = (str2 + " NetType/" + ao.fH(ad.getContext())) + " Language/" + w.fD(ad.getContext());
        x.i("MicroMsg.WechatWebViewUserAgentUtil", "appendUserAgent, uaStr = " + str2);
        return str2;
    }

    public static PackageInfo getPackageInfo(Context context, String str) {
        PackageInfo packageInfo = null;
        if (str == null) {
            x.e("MicroMsg.WechatWebViewUserAgentUtil", "getPackageInfo fail, packageName is null");
            return packageInfo;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WechatWebViewUserAgentUtil", e, "", new Object[0]);
            return packageInfo;
        }
    }
}
