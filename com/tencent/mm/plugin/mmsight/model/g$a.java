package com.tencent.mm.plugin.mmsight.model;

import android.hardware.Camera.Size;
import java.util.Comparator;

class g$a implements Comparator<Size> {
    private g$a() {
    }

    /* synthetic */ g$a(byte b) {
        this();
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Size size = (Size) obj;
        Size size2 = (Size) obj2;
        int i = size.height * size.width;
        int i2 = size2.height * size2.width;
        if (i2 < i) {
            return -1;
        }
        return i2 > i ? 1 : 0;
    }
}
