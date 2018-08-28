package com.tencent.tencentmap.mapsdk.a;

import java.net.MalformedURLException;
import java.net.URL;

public class tm extends th {
    private String[] b = new String[]{"https://s0.map.gtimg.com/oversea", "https://s1.map.gtimg.com/oversea", "https://s2.map.gtimg.com/oversea", "https://s3.map.gtimg.com/oversea"};

    public tm(int i) {
        super(i);
    }

    public URL a(int i, int i2, int i3, Object... objArr) {
        String str = this.b[a(i + i2, this.b.length)];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("?");
        stringBuilder.append("z=").append(i3);
        stringBuilder.append("&x=").append(i);
        stringBuilder.append("&y=").append(i2);
        stringBuilder.append("&styleid=").append(sn.e());
        stringBuilder.append("&scene=").append(sn.f());
        stringBuilder.append("&version=").append(sn.g());
        stringBuilder.append("&ch=").append(sl.q());
        try {
            return new URL(stringBuilder.toString());
        } catch (MalformedURLException e) {
            return null;
        }
    }
}
