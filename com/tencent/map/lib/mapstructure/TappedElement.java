package com.tencent.map.lib.mapstructure;

import com.tencent.tencentmap.mapsdk.a.jm;

public class TappedElement {
    public static final int TYPE_ANNO = 1;
    public static final int TYPE_BLOCKROUTE_ANNO = 7;
    public static final int TYPE_COMPASS = 3;
    public static final int TYPE_INDOORMAP_ANNO = 8;
    public static final int TYPE_LINE = 5;
    public static final int TYPE_LOCATION_MARKER = 6;
    public static final int TYPE_NONE = 0;
    public String name;
    public int nameLen;
    public long param1;
    public int param2;
    public int pixelX;
    public int pixelY;
    public int type;

    private TappedElement() {
    }

    public static TappedElement fromBytes(byte[] bArr) {
        int i = 20;
        TappedElement tappedElement = new TappedElement();
        Object obj = new byte[4];
        System.arraycopy(bArr, 0, obj, 0, 4);
        tappedElement.type = jm.a(obj);
        System.arraycopy(bArr, 4, obj, 0, 4);
        tappedElement.pixelX = jm.a(obj);
        System.arraycopy(bArr, 8, obj, 0, 4);
        tappedElement.pixelY = jm.a(obj);
        System.arraycopy(bArr, 12, obj, 0, 4);
        tappedElement.param2 = jm.a(obj);
        System.arraycopy(bArr, 16, obj, 0, 4);
        tappedElement.nameLen = jm.a(obj);
        if (tappedElement.type != 7) {
            Object obj2 = new byte[64];
            System.arraycopy(bArr, 20, obj2, 0, 64);
            i = 84;
            if (tappedElement.type != 8) {
                tappedElement.name = jm.d(obj2);
            } else {
                tappedElement.name = jm.a(obj2, "UTF8");
            }
        }
        System.arraycopy(bArr, i, obj, 0, 4);
        int a = jm.a(obj);
        System.arraycopy(bArr, i + 4, obj, 0, 4);
        tappedElement.param1 = (long) (jm.a(obj) + (a << 32));
        return tappedElement;
    }
}
