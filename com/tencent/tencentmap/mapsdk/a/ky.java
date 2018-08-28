package com.tencent.tencentmap.mapsdk.a;

public class ky implements nj {
    private r a;

    public ky(r rVar) {
        this.a = rVar;
    }

    public String a(int i, int i2, int i3) {
        int pow = (int) ((Math.pow(2.0d, (double) i3) - 1.0d) - ((double) i2));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("http://p0.map.gtimg.com/scenic/");
        stringBuffer.append("?z=");
        stringBuffer.append(i3);
        stringBuffer.append("&y=");
        stringBuffer.append(pow);
        stringBuffer.append("&x=");
        stringBuffer.append(i);
        stringBuffer.append("&styleid=");
        stringBuffer.append(7);
        stringBuffer.append("&version=");
        stringBuffer.append(kv.a());
        return stringBuffer.toString();
    }
}
