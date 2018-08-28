package com.tencent.mm.plugin.appbrand.performance;

import android.util.SparseArray;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.appbrand.s.j;

public final class b {
    public static final int[] gpE = new int[4];
    public static final SparseArray<Integer> gpF = new SparseArray();

    static {
        gpE[0] = j.app_brand_performance_basic;
        gpE[1] = j.app_brand_performance_init;
        gpE[2] = j.app_brand_performance_render;
        gpE[3] = j.app_brand_performance_other;
        gpF.put(s$l.AppCompatTheme_buttonStyleSmall, Integer.valueOf(j.app_brand_performance_cpu));
        gpF.put(s$l.AppCompatTheme_checkboxStyle, Integer.valueOf(j.app_brand_performance_memory));
        gpF.put(s$l.AppCompatTheme_checkedTextViewStyle, Integer.valueOf(j.app_brand_performance_memory_delta));
        gpF.put(av.CTRL_INDEX, Integer.valueOf(j.app_brand_performance_download));
        gpF.put(202, Integer.valueOf(j.app_brand_performance_launching));
        gpF.put(203, Integer.valueOf(j.app_brand_performance_switch));
        gpF.put(301, Integer.valueOf(j.app_brand_performance_first_render));
        gpF.put(302, Integer.valueOf(j.app_brand_performance_re_render));
        gpF.put(303, Integer.valueOf(j.app_brand_performance_fps));
        gpF.put(401, Integer.valueOf(j.app_brand_performance_storage));
        gpF.put(402, Integer.valueOf(j.app_brand_performance_to_logic));
        gpF.put(403, Integer.valueOf(j.app_brand_performance_to_logic_data));
        gpF.put(404, Integer.valueOf(j.app_brand_performance_to_logic_native));
        gpF.put(405, Integer.valueOf(j.app_brand_performance_to_view));
        gpF.put(406, Integer.valueOf(j.app_brand_performance_to_view_data));
        gpF.put(JsApiPrivateAddContact.CTRL_INDEX, Integer.valueOf(j.app_brand_performance_to_view_native));
    }
}
