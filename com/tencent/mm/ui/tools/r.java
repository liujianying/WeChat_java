package com.tencent.mm.ui.tools;

import android.content.Context;
import com.tencent.mm.bp.a;
import com.tencent.mm.w.a.f;

public final class r {
    public static int hd(Context context) {
        if (Float.compare(a.fe(context), 1.125f) > 0) {
            return f.unread_count_shape_large;
        }
        return f.unread_count_shape;
    }
}
