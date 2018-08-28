package com.tencent.mm.plugin.appbrand.launching.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.d;
import com.tencent.mm.plugin.appbrand.dynamic.k.b;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;

abstract class a {
    abstract void a(Uri uri, int i);

    a() {
    }

    final int a(Context context, String str, int i, Bundle bundle) {
        int i2;
        x.i("MicroMsg.AppBrand.AbsLinkOpener", "handle url = %s", new Object[]{str});
        Uri uri = null;
        if (bi.oW(str)) {
            i2 = a.ggZ;
        } else {
            Uri parse = Uri.parse(str);
            String queryParameter;
            String queryParameter2;
            AppBrandStatObject appBrandStatObject;
            if ((bi.getInt(parse.getQueryParameter("debug"), 0) > 0 ? 1 : null) != null) {
                i2 = bi.getInt(parse.getQueryParameter("ret"), 0);
                if (i2 == 1) {
                    i2 = a.gha;
                    uri = parse;
                } else if (i2 == 2) {
                    i2 = a.ghb;
                    uri = parse;
                } else {
                    queryParameter = parse.getQueryParameter("appid");
                    String queryParameter3 = parse.getQueryParameter("username");
                    String oV = bi.oV(parse.getQueryParameter("path"));
                    String queryParameter4 = parse.getQueryParameter("codeurl");
                    String queryParameter5 = parse.getQueryParameter("md5");
                    String queryParameter6 = parse.getQueryParameter("pageurl");
                    String queryParameter7 = parse.getQueryParameter("pagemd5");
                    long j = bi.getLong(parse.getQueryParameter("test_lifespan"), 7200);
                    if (bi.oW(queryParameter) || bi.oW(queryParameter3) || bi.oW(queryParameter4)) {
                        x.i("MicroMsg.AppBrand.AbsLinkOpener", "appId = %s, username = %s, codeURL = %s, invalid, return", new Object[]{queryParameter, queryParameter3, queryParameter4});
                        i2 = a.ggZ;
                        uri = parse;
                    } else {
                        boolean a = e.abi().a(queryParameter, 1, queryParameter4, queryParameter5, 0, bi.VE() + j);
                        if (!(bi.oW(queryParameter6) || bi.oW(queryParameter7))) {
                            e.abi().a(queryParameter, 10000, queryParameter6, queryParameter7, 0, bi.VE() + j);
                            i2 = b.bH(0, 1);
                            if (i2 == 10000) {
                                Parcelable bundle2 = new Bundle();
                                bundle2.putString("appId", queryParameter);
                                bundle2.putInt("debugType", i2);
                                f.a("com.tencent.mm", bundle2, d.class, null);
                            }
                        }
                        if (a) {
                            com.tencent.mm.plugin.appbrand.task.e.aN(queryParameter, 1);
                        }
                        queryParameter2 = parse.getQueryParameter("json_extinfo");
                        LaunchParamsOptional launchParamsOptional = new LaunchParamsOptional();
                        launchParamsOptional.dFz = queryParameter2;
                        ((h) e.x(h.class)).n(queryParameter, 1, queryParameter2);
                        appBrandStatObject = new AppBrandStatObject();
                        a(str, i, appBrandStatObject, bundle);
                        AppBrandLaunchProxyUI.a(context, queryParameter3, oV, 1, -1, appBrandStatObject, launchParamsOptional);
                        i2 = a.ggY;
                        uri = parse;
                    }
                }
            } else {
                queryParameter2 = parse.getQueryParameter("username");
                queryParameter = bi.oV(parse.getQueryParameter("path"));
                int i3 = bi.getInt(parse.getQueryParameter("version"), 0);
                int i4 = bi.getInt(parse.getQueryParameter("type"), 0);
                if (bi.oW(queryParameter2)) {
                    x.i("MicroMsg.AppBrand.AbsLinkOpener", "username = %s, invalid, return", new Object[]{queryParameter2});
                    i2 = a.ggZ;
                    uri = parse;
                } else {
                    appBrandStatObject = new AppBrandStatObject();
                    a(str, i, appBrandStatObject, bundle);
                    AppBrandLaunchProxyUI.a(context, queryParameter2, queryParameter, i4, i3, appBrandStatObject, null);
                    i2 = a.ggY;
                    uri = parse;
                }
            }
        }
        a(uri, i2);
        return i2;
    }

    private static void a(String str, int i, AppBrandStatObject appBrandStatObject, Bundle bundle) {
        appBrandStatObject.scene = i;
        appBrandStatObject.bGG = p.encode(str);
        appBrandStatObject.cbB = c.h(i, bundle);
        appBrandStatObject.cbC = c.i(i, bundle);
        if (i == 1037 || i == TXLiveConstants.PUSH_EVT_ROOM_IN) {
            appBrandStatObject.cbA = 0;
        } else {
            appBrandStatObject.cbA = i;
        }
    }
}
