package com.tencent.tencentmap.mapsdk.a;

import java.net.MalformedURLException;
import java.net.URL;

public final class tj extends th {
    private String[] b = new String[]{"https://p0.map.gtimg.com/sateTiles", "https://p1.map.gtimg.com/sateTiles", "https://p2.map.gtimg.com/sateTiles", "https://p3.map.gtimg.com/sateTiles"};

    public tj(int i) {
        super(i);
    }

    public final URL a(int i, int i2, int i3, Object... objArr) {
        int pow = (int) ((Math.pow(2.0d, (double) i3) - ((double) i2)) - 1.0d);
        try {
            return new URL(this.b[a(i + pow, 4)] + '/' + i3 + '/' + (i >> 4) + '/' + (pow >> 4) + '/' + i + '_' + pow + ".jpg");
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
