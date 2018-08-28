package com.tencent.mm.plugin.appbrand.permission;

import android.util.SparseIntArray;
import com.tencent.mm.plugin.appbrand.s.j;

class a$1 extends SparseIntArray {
    a$1() {
    }

    public final int get(int i) {
        return super.get(i, j.app_brand_jsapi_ban_banner_hint_other_api);
    }
}
