package com.tencent.tencentmap.mapsdk.a;

import java.net.MalformedURLException;
import java.net.URL;

public final class tk extends th {
    private String[] b = new String[]{"https://m0.map.gtimg.com/hwap", "https://m1.map.gtimg.com/hwap", "https://m2.map.gtimg.com/hwap", "https://m3.map.gtimg.com/hwap"};

    public tk(int i) {
        super(i);
    }

    public final URL a(int i, int i2, int i3, Object... objArr) {
        int i4 = ro.a;
        boolean z = false;
        Object obj = null;
        String str = null;
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    i4 = Integer.parseInt(objArr[0].toString());
                    if (objArr.length == 3) {
                        str = objArr[1].toString();
                        z = Boolean.parseBoolean(objArr[2].toString());
                    } else if (objArr.length == 2) {
                        obj = 7 == Integer.parseInt(objArr[1].toString()) ? 1 : null;
                    }
                }
            } catch (Exception e) {
            }
        }
        try {
            int a = a(i + i2, this.b.length);
            int pow = (int) ((Math.pow(2.0d, (double) i3) - ((double) i2)) - 1.0d);
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append(this.b[a]);
            stringBuilder.append("?");
            stringBuilder.append("z=");
            stringBuilder.append(i3 - 1);
            stringBuilder.append("&x=");
            stringBuilder.append(i);
            stringBuilder.append("&y=");
            stringBuilder.append(pow);
            stringBuilder.append("&styleid=");
            if (obj != null) {
                stringBuilder.append(7);
            } else {
                stringBuilder.append(sn.a());
            }
            stringBuilder.append("&version=");
            stringBuilder.append(i4);
            StringBuffer stringBuffer = new StringBuffer(stringBuilder.toString());
            if (z) {
                stringBuffer.append("&md5=").append(str);
            }
            return new URL(stringBuffer.toString());
        } catch (MalformedURLException e2) {
            new StringBuilder("Error new URL with str:").append(null);
            return null;
        }
    }
}
