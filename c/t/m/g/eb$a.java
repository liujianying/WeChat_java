package c.t.m.g;

import android.location.Location;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import org.json.JSONException;

public class eb$a {
    public String a;
    public eb b;
    public int c;
    public String d = "network";
    private Location e;

    public final eb a() {
        eb ebVar;
        if (this.a != null) {
            try {
                ebVar = new eb(this.a, (byte) 0);
            } catch (JSONException e) {
                return eb.a;
            }
        }
        ebVar = eb.c(this.b);
        eb.a(eb.b(eb.b(ebVar, this.c), this.d), this.e);
        TencentExtraKeys.setRawGps(ebVar, this.e);
        return ebVar;
    }

    public final eb$a a(Location location) {
        this.e = new Location(location);
        return this;
    }
}
