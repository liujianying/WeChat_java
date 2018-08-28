package com.tencent.mm.plugin.appbrand.launching.b;

import android.net.Uri;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.appbrand.ui.AppBrand404PageUI;

final class d extends a {
    d() {
    }

    final void a(Uri uri, int i) {
        switch (1.ghg[i - 1]) {
            case 1:
                AppBrand404PageUI.show(j.app_brand_barcode_parameter_error);
                return;
            case 2:
                AppBrand404PageUI.show(j.app_brand_barcode_result_dev_code_exipred);
                return;
            case 3:
                AppBrand404PageUI.show(j.app_brand_qrcode_result_uin_invalid);
                return;
            case 4:
                return;
            default:
                AppBrand404PageUI.show(j.app_brand_error);
                return;
        }
    }
}
