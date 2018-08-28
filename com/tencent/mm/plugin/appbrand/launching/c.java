package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.tencent.mm.bg.d;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.f;
import com.tencent.mm.plugin.appbrand.launching.ac.1;
import com.tencent.mm.plugin.appbrand.launching.ad.a;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class c implements Runnable {
    private volatile String appId;
    private final int fii;
    private final int fmv;
    private final String fqx;
    private final a geQ;
    private AppBrandStatObject geR;
    private final String username;

    public c(LaunchParcel launchParcel, a aVar) {
        this.geQ = aVar;
        this.fmv = launchParcel.fmv;
        this.appId = launchParcel.appId;
        this.username = launchParcel.username;
        this.fii = launchParcel.version;
        this.geR = launchParcel.ghm;
        this.fqx = launchParcel.fqx;
    }

    public c(String str, int i, AppBrandStatObject appBrandStatObject, a aVar) {
        this.geQ = aVar;
        this.appId = str;
        this.fmv = i;
        this.username = null;
        this.fii = 0;
        this.geR = appBrandStatObject;
        this.fqx = null;
    }

    public final void run() {
        Pair akM;
        WxaAttributes wxaAttributes;
        Throwable e;
        try {
            akM = new ab(this.username, this.appId, this.fmv, this.fii, this.geR == null ? 0 : this.geR.scene, this.fqx).call();
            try {
                wxaAttributes = (WxaAttributes) akM.first;
            } catch (Exception e2) {
                e = e2;
                x.printErrStackTrace("MicroMsg.AppBrandPreLaunchProcess", e, "get attr ", new Object[0]);
                wxaAttributes = null;
                if (wxaAttributes != null) {
                    boolean z;
                    String str = wxaAttributes.field_appId;
                    u uVar = new u(str);
                    if (g.AT().getInt("WeAppForbiddenSwitch", 0) == 1) {
                        x.i("MicroMsg.AppBrand.PreLaunchCheckForOversea", "startApp, WeAppForbiddenSwitch == 1, go webview, appId %s", new Object[]{uVar.appId});
                        Intent putExtra = new Intent().putExtra("rawUrl", n.qx(uVar.appId)).putExtra("forceHideShare", true);
                        Context context = ad.getContext();
                        if (!(context instanceof Activity)) {
                            putExtra.addFlags(268435456);
                        }
                        d.b(context, "webview", ".ui.tools.WebViewUI", putExtra);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        z = true;
                    } else {
                        if (2 == this.fmv) {
                            z = e.vD(str);
                            int afr = new ad(str, ac.aI(str, 2), ac.aI(str, 10001), z).afr();
                            x.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", new Object[]{str, Integer.valueOf(afr), Boolean.valueOf(z)});
                            a ld = a.ld(afr);
                            if (ld == null) {
                                switch (afr) {
                                    case -13003:
                                        x.lc(j.app_brand_demo_pkg_user_not_in_white_list);
                                        com.tencent.mm.plugin.appbrand.report.a.G(str, 12, 3);
                                        z = false;
                                        break;
                                    case -13002:
                                        x.lc(j.app_brand_demo_pkg_has_been_deleted);
                                        com.tencent.mm.plugin.appbrand.report.a.G(str, 13, 3);
                                        z = false;
                                        break;
                                    default:
                                        if (z) {
                                            z = true;
                                            break;
                                        }
                                        x.um(ad.getResources().getString(j.app_brand_preparing_comm_err_code, new Object[]{Integer.valueOf(3), Integer.valueOf(afr)}));
                                        z = false;
                                        break;
                                }
                            } else if (!z) {
                                switch (1.ggD[ld.ordinal()]) {
                                    case 1:
                                        z = true;
                                        break;
                                    case 2:
                                        x.lc(j.app_brand_demo_pkg_cgi_timeout);
                                        com.tencent.mm.plugin.appbrand.report.a.G(str, 13, 3);
                                        z = false;
                                        break;
                                    default:
                                        x.lc(j.app_brand_demo_pkg_cgi_fail);
                                        com.tencent.mm.plugin.appbrand.report.a.G(str, 13, 3);
                                        z = false;
                                        break;
                                }
                            } else {
                                z = true;
                            }
                            if (!z) {
                                z = true;
                            }
                        }
                        if (this.fmv == 0) {
                            int i;
                            if (1 == wxaAttributes.ael().fsi) {
                                AppBrand404PageUI.show(j.app_brand_launching_release_version_not_published_yet);
                                com.tencent.mm.plugin.appbrand.report.a.G(wxaAttributes.field_appId, 14, 1);
                                i = 0;
                            } else {
                                z = true;
                            }
                            if (i == 0) {
                                z = true;
                            }
                        }
                        z = false;
                    }
                    if (z) {
                        onError();
                        return;
                    }
                    f.aee();
                    AppBrandInitConfig a = f.a(wxaAttributes);
                    a.fig = this.fmv;
                    a.fqz = ((Boolean) akM.second).booleanValue();
                    this.appId = a.appId;
                    if (this.fmv == 0) {
                        a.fqt = wxaAttributes.ael().foV;
                        a.fqu = wxaAttributes.ael().fqu;
                    } else {
                        a.extInfo = ((h) com.tencent.mm.plugin.appbrand.app.e.x(h.class)).aH(this.appId, this.fmv);
                        try {
                            JSONObject fU = com.tencent.mm.v.g.fU(a.extInfo);
                            a.fqt = fU.optString("device_orientation");
                            a.fqu = fU.optString("client_js_ext_info");
                            a.fqw = fU.optBoolean("open_remote", false);
                        } catch (Exception e3) {
                        }
                    }
                    if (this.geR == null) {
                        this.geR = new AppBrandStatObject();
                    }
                    AppBrandStatObject appBrandStatObject = this.geR;
                    if (this.geQ != null) {
                        this.geQ.d(a, appBrandStatObject);
                    }
                }
                x.i("MicroMsg.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
                onError();
                return;
            }
        } catch (Exception e4) {
            e = e4;
            akM = null;
        }
        if (wxaAttributes != null) {
            x.i("MicroMsg.AppBrandPreLaunchProcess", "onGetWxaAttr null return");
            onError();
            return;
        }
        boolean z2;
        String str2 = wxaAttributes.field_appId;
        u uVar2 = new u(str2);
        if (g.AT().getInt("WeAppForbiddenSwitch", 0) == 1) {
            x.i("MicroMsg.AppBrand.PreLaunchCheckForOversea", "startApp, WeAppForbiddenSwitch == 1, go webview, appId %s", new Object[]{uVar2.appId});
            Intent putExtra2 = new Intent().putExtra("rawUrl", n.qx(uVar2.appId)).putExtra("forceHideShare", true);
            Context context2 = ad.getContext();
            if (!(context2 instanceof Activity)) {
                putExtra2.addFlags(268435456);
            }
            d.b(context2, "webview", ".ui.tools.WebViewUI", putExtra2);
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            z2 = true;
        } else {
            if (2 == this.fmv) {
                z2 = e.vD(str2);
                int afr2 = new ad(str2, ac.aI(str2, 2), ac.aI(str2, 10001), z2).afr();
                x.i("MicroMsg.AppBrand.PrepareStepOpBan", "checkDemoInfo, appId %s, ret %d, ignoreCgiError %b", new Object[]{str2, Integer.valueOf(afr2), Boolean.valueOf(z2)});
                a ld2 = a.ld(afr2);
                if (ld2 == null) {
                    switch (afr2) {
                        case -13003:
                            x.lc(j.app_brand_demo_pkg_user_not_in_white_list);
                            com.tencent.mm.plugin.appbrand.report.a.G(str2, 12, 3);
                            z2 = false;
                            break;
                        case -13002:
                            x.lc(j.app_brand_demo_pkg_has_been_deleted);
                            com.tencent.mm.plugin.appbrand.report.a.G(str2, 13, 3);
                            z2 = false;
                            break;
                        default:
                            if (z2) {
                                z2 = true;
                                break;
                            }
                            x.um(ad.getResources().getString(j.app_brand_preparing_comm_err_code, new Object[]{Integer.valueOf(3), Integer.valueOf(afr2)}));
                            z2 = false;
                            break;
                    }
                } else if (!z2) {
                    switch (1.ggD[ld2.ordinal()]) {
                        case 1:
                            z2 = true;
                            break;
                        case 2:
                            x.lc(j.app_brand_demo_pkg_cgi_timeout);
                            com.tencent.mm.plugin.appbrand.report.a.G(str2, 13, 3);
                            z2 = false;
                            break;
                        default:
                            x.lc(j.app_brand_demo_pkg_cgi_fail);
                            com.tencent.mm.plugin.appbrand.report.a.G(str2, 13, 3);
                            z2 = false;
                            break;
                    }
                } else {
                    z2 = true;
                }
                if (!z2) {
                    z2 = true;
                }
            }
            if (this.fmv == 0) {
                int i2;
                if (1 == wxaAttributes.ael().fsi) {
                    AppBrand404PageUI.show(j.app_brand_launching_release_version_not_published_yet);
                    com.tencent.mm.plugin.appbrand.report.a.G(wxaAttributes.field_appId, 14, 1);
                    i2 = 0;
                } else {
                    z2 = true;
                }
                if (i2 == 0) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        if (z2) {
            onError();
            return;
        }
        f.aee();
        AppBrandInitConfig a2 = f.a(wxaAttributes);
        a2.fig = this.fmv;
        a2.fqz = ((Boolean) akM.second).booleanValue();
        this.appId = a2.appId;
        if (this.fmv == 0) {
            a2.fqt = wxaAttributes.ael().foV;
            a2.fqu = wxaAttributes.ael().fqu;
        } else {
            a2.extInfo = ((h) com.tencent.mm.plugin.appbrand.app.e.x(h.class)).aH(this.appId, this.fmv);
            try {
                JSONObject fU2 = com.tencent.mm.v.g.fU(a2.extInfo);
                a2.fqt = fU2.optString("device_orientation");
                a2.fqu = fU2.optString("client_js_ext_info");
                a2.fqw = fU2.optBoolean("open_remote", false);
            } catch (Exception e32) {
            }
        }
        if (this.geR == null) {
            this.geR = new AppBrandStatObject();
        }
        AppBrandStatObject appBrandStatObject2 = this.geR;
        if (this.geQ != null) {
            this.geQ.d(a2, appBrandStatObject2);
        }
    }

    private void onError() {
        if (this.geQ != null) {
            this.geQ.d(null, null);
        }
    }
}
