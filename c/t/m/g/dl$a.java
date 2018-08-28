package c.t.m.g;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationUtils;

class dl$a {
    double a;
    double b;
    long c;
    int d;

    dl$a() {
    }

    public final String toString() {
        return "[" + this.a + "," + this.b + "]";
    }

    static dl$a a(TencentLocation tencentLocation) {
        int i = 2;
        dl$a dl_a = new dl$a();
        dl_a.a = tencentLocation.getLatitude();
        dl_a.b = tencentLocation.getLongitude();
        dl_a.c = tencentLocation.getTime();
        tencentLocation.getSpeed();
        if (TencentLocationUtils.isFromGps(tencentLocation)) {
            if (tencentLocation.getAccuracy() < 100.0f) {
                i = 3;
            }
            dl_a.d = i;
        } else {
            if (tencentLocation.getAccuracy() >= 500.0f) {
                i = 1;
            }
            dl_a.d = i;
        }
        return dl_a;
    }
}
