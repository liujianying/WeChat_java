package com.tencent.mm.plugin.appbrand.widget.picker;

import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker.b;

class AppBrandMultiOptionsPicker$1 implements b {
    final /* synthetic */ AppBrandMultiOptionsPicker gMY;

    AppBrandMultiOptionsPicker$1(AppBrandMultiOptionsPicker appBrandMultiOptionsPicker) {
        this.gMY = appBrandMultiOptionsPicker;
    }

    public final void a(YANumberPicker yANumberPicker, int i) {
        if (AppBrandMultiOptionsPicker.a(this.gMY) != null) {
            int intValue = ((Integer) yANumberPicker.getTag(g.app_brand_multi_options_picker_view_index_tag)).intValue();
            d a = AppBrandMultiOptionsPicker.a(this.gMY);
            Object obj = new int[]{intValue, i};
            if (a.gNk != null) {
                a.gNk.bl(obj);
            }
        }
    }
}
