package com.tencent.mm.plugin.appbrand.widget.picker;

public final class AppBrandMultiOptionsPicker$a {
    public final String[] gMZ;
    public final int gNa;

    public AppBrandMultiOptionsPicker$a(String[] strArr, int i) {
        this.gMZ = strArr;
        this.gNa = Math.max(0, Math.min(i, strArr.length - 1));
    }
}
