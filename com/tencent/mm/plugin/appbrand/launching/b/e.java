package com.tencent.mm.plugin.appbrand.launching.b;

import android.net.Uri;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;

final class e extends a {
    e() {
    }

    final void a(Uri uri, int i) {
        int i2 = 1;
        String queryParameter = uri == null ? "" : uri.getQueryParameter("appid");
        switch (1.ghg[i - 1]) {
            case 1:
                int i3;
                if (uri == null || !uri.getBooleanQueryParameter("debug", false)) {
                    boolean i32 = false;
                } else {
                    i32 = 1;
                }
                AppBrand404PageUI.show(j.app_brand_scan_qrcode_parameter_error);
                if (i32 == 0) {
                    i2 = 0;
                }
                a.G(queryParameter, 2, i2 + 1);
                return;
            case 2:
                AppBrand404PageUI.show(j.app_brand_qrcode_result_dev_qrcode_expired);
                a.G("", 3, 2);
                return;
            case 3:
                AppBrand404PageUI.show(j.app_brand_qrcode_result_uin_invalid);
                a.G("", 4, 2);
                return;
            case 4:
                return;
            default:
                AppBrand404PageUI.show(j.app_brand_error);
                return;
        }
    }
}
