package com.tencent.mm.plugin.appbrand.widget.input.c;

public enum g {
    LEFT,
    RIGHT,
    CENTER;

    public static g wl(String str) {
        Enum h = d.h(str, g.class);
        g gVar = LEFT;
        if (h != null) {
            Enum gVar2 = h;
        }
        return gVar2;
    }
}
