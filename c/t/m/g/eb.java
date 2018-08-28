package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class eb implements Parcelable, TencentLocation {
    public static final eb a = new eb(-1);
    public dx b;
    private dw c;
    private int d;
    private int e;
    private String f;
    private dv g;
    private final Bundle h;
    private String i;
    private Location j;
    private final long k;
    private long l;
    private int m;

    static {
        1 1 = new 1();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        String str;
        parcel.writeInt(this.d);
        parcel.writeString(getProvider());
        parcel.writeDouble(getLatitude());
        parcel.writeDouble(getLongitude());
        parcel.writeDouble((double) getAccuracy());
        parcel.writeDouble(getAltitude());
        parcel.writeString(getAddress());
        parcel.writeString(getNation());
        parcel.writeString(getProvince());
        parcel.writeString(getCity());
        parcel.writeString(getDistrict());
        parcel.writeString(getStreet());
        parcel.writeString(getStreetNo());
        if (this.g != null) {
            str = this.g.c.d;
        } else {
            str = "";
        }
        parcel.writeString(str);
        parcel.writeString(getName());
        parcel.writeLong(this.l);
        parcel.writeBundle(this.h);
    }

    public final int describeContents() {
        return 0;
    }

    private eb(int i) {
        this.h = new Bundle();
        this.i = "network";
        this.d = i;
        this.k = SystemClock.elapsedRealtime();
        this.l = System.currentTimeMillis();
    }

    public final void a(Location location) {
        if (this.b != null) {
            double latitude = location.getLatitude();
            double round = ((double) Math.round(location.getLongitude() * 1000000.0d)) / 1000000.0d;
            this.b.a = ((double) Math.round(latitude * 1000000.0d)) / 1000000.0d;
            this.b.b = round;
            this.b.c = location.getAltitude();
            this.b.d = location.getAccuracy();
        }
    }

    private eb(String str) {
        this.h = new Bundle();
        this.i = "network";
        this.k = SystemClock.elapsedRealtime();
        this.l = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject(str);
        try {
            this.b = new dx(jSONObject.getJSONObject("location"));
            try {
                this.c = new dw(jSONObject.getJSONObject("indoorinfo"));
            } catch (Throwable th) {
            }
            this.f = jSONObject.optString("bearing");
            this.e = jSONObject.optInt("fackgps", 0);
            this.l = jSONObject.optLong("timestamp", System.currentTimeMillis());
            try {
                Object optString = jSONObject.optString("icontrol");
                if (!TextUtils.isEmpty(optString)) {
                    this.h.putInt("icontrol", Integer.valueOf(optString.split(",")[0]).intValue());
                }
            } catch (Exception e) {
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("details");
            if (optJSONObject != null) {
                try {
                    this.g = new dv(optJSONObject);
                } catch (JSONException e2) {
                    throw e2;
                }
            }
            jSONObject = jSONObject.optJSONObject("addrdesp");
            if (jSONObject != null && jSONObject.has("detail")) {
                this.g = new dv(jSONObject.optJSONObject("detail"));
            }
            if (this.g != null && this.g.c != null) {
                this.h.putAll(this.g.c.m);
            }
        } catch (JSONException e22) {
            throw e22;
        }
    }

    public final String getProvider() {
        return this.i;
    }

    public final double getLatitude() {
        return this.b != null ? this.b.a : 0.0d;
    }

    public final double getLongitude() {
        return this.b != null ? this.b.b : 0.0d;
    }

    public final double getAltitude() {
        return this.b != null ? this.b.c : 0.0d;
    }

    public final float getAccuracy() {
        return this.b != null ? this.b.d : 0.0f;
    }

    public final String getIndoorBuildingId() {
        return this.c != null ? this.c.a : "";
    }

    public final String getIndoorBuildingFloor() {
        return this.c != null ? this.c.b : "";
    }

    public final int getIndoorLocationType() {
        return this.c != null ? this.c.c : -1;
    }

    public final String getName() {
        if (this.d == 5) {
            return this.h.getString("addrdesp.name");
        }
        return this.d == 3 ? this.g != null ? this.g.c.c : "" : this.b != null ? this.b.e : "";
    }

    public final String getAddress() {
        if (this.d == 5) {
            return this.h.getString("addrdesp.name");
        }
        return this.d == 3 ? this.g != null ? this.g.c.l : "" : this.b != null ? this.b.f : "";
    }

    public final String getNation() {
        return this.g != null ? this.g.c.b : "";
    }

    public final String getProvince() {
        return this.g != null ? this.g.c.e : "";
    }

    public final String getCity() {
        return this.g != null ? this.g.c.f : "";
    }

    public final String getDistrict() {
        return this.g != null ? this.g.c.g : "";
    }

    public final String getTown() {
        return this.g != null ? this.g.c.h : "";
    }

    public final String getVillage() {
        return this.g != null ? this.g.c.i : "";
    }

    public final String getStreet() {
        return this.g != null ? this.g.c.j : "";
    }

    public final String getStreetNo() {
        return this.g != null ? this.g.c.k : "";
    }

    public final Integer getAreaStat() {
        return this.g != null ? Integer.valueOf(this.g.a) : null;
    }

    public final List<TencentPoi> getPoiList() {
        if (this.g != null) {
            return new ArrayList(this.g.b);
        }
        return Collections.emptyList();
    }

    public final String getCityCode() {
        return this.g != null ? this.g.c.d : "";
    }

    public final Bundle getExtra() {
        return this.h;
    }

    public final int getGPSRssi() {
        if (this.j == null) {
            return 0;
        }
        Bundle extras = this.j.getExtras();
        if (extras != null) {
            return extras.getInt("rssi", 0);
        }
        return 0;
    }

    public final float getBearing() {
        return this.j == null ? 0.0f : this.j.getBearing();
    }

    public final float getSpeed() {
        return this.j == null ? 0.0f : this.j.getSpeed();
    }

    public final long getTime() {
        return this.l;
    }

    public final int getCoordinateType() {
        return this.m;
    }

    public final long getElapsedRealtime() {
        return this.k;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("TxLocation{");
        stringBuilder.append("level=").append(this.d).append(",");
        stringBuilder.append("name=").append(getName()).append(",");
        stringBuilder.append("address=").append(getAddress()).append(",");
        stringBuilder.append("provider=").append(getProvider()).append(",");
        stringBuilder.append("latitude=").append(getLatitude()).append(",");
        stringBuilder.append("longitude=").append(getLongitude()).append(",");
        stringBuilder.append("altitude=").append(getAltitude()).append(",");
        stringBuilder.append("accuracy=").append(getAccuracy()).append(",");
        stringBuilder.append("cityCode=").append(getCityCode()).append(",");
        stringBuilder.append("areaStat=").append(getAreaStat()).append(",");
        stringBuilder.append("nation=").append(getNation()).append(",");
        stringBuilder.append("province=").append(getProvince()).append(",");
        stringBuilder.append("city=").append(getCity()).append(",");
        stringBuilder.append("district=").append(getDistrict()).append(",");
        stringBuilder.append("street=").append(getStreet()).append(",");
        stringBuilder.append("streetNo=").append(getStreetNo()).append(",");
        stringBuilder.append("town=").append(getTown()).append(",");
        stringBuilder.append("village=").append(getVillage()).append(",");
        stringBuilder.append("bearing=").append(getBearing()).append(",");
        stringBuilder.append("time=").append(getTime()).append(",");
        stringBuilder.append("poilist=[");
        for (TencentPoi append : getPoiList()) {
            stringBuilder.append(append).append(",");
        }
        stringBuilder.append("]");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public static eb a(eb ebVar, boolean z) {
        if (!(ebVar == null || ebVar.f == null || z)) {
            String str = ebVar.f;
            int i = 0;
            if (str != null && str.split(",").length > 1) {
                i = Integer.parseInt(str.split(",")[1]);
            }
            dx dxVar = ebVar.b;
            if (dxVar != null) {
                try {
                    dxVar.d = (float) e.r((double) dxVar.d, i, -70);
                } catch (UnsatisfiedLinkError e) {
                }
            }
        }
        return ebVar;
    }

    public static eb a(eb ebVar, int i) {
        ebVar.m = i;
        return ebVar;
    }

    public static void a(eb ebVar) {
        if (ebVar == a) {
            throw new JSONException("location failed");
        }
    }

    public final double getDirection() {
        return this.h.getDouble("direction");
    }

    public final int isMockGps() {
        return this.e;
    }

    static /* synthetic */ eb c(eb ebVar) {
        eb ebVar2 = new eb(-1);
        if (ebVar == null) {
            ebVar2.b = new dx();
        } else {
            dx dxVar = ebVar.b;
            dx dxVar2 = new dx();
            if (dxVar != null) {
                dxVar2.a = dxVar.a;
                dxVar2.b = dxVar.b;
                dxVar2.c = dxVar.c;
                dxVar2.d = dxVar.d;
                dxVar2.e = dxVar.e;
                dxVar2.f = dxVar.f;
            }
            ebVar2.b = dxVar2;
            ebVar2.d = ebVar.d;
            ebVar2.f = ebVar.f;
            dv dvVar = ebVar.g;
            if (dvVar == null) {
                dvVar = null;
            } else {
                dv dvVar2 = new dv();
                dvVar2.a = dvVar.a;
                dvVar2.c = dz.a(dvVar.c);
                Iterator it = dvVar.b.iterator();
                while (it.hasNext()) {
                    dvVar2.b.add(new dy((TencentPoi) it.next()));
                }
                dvVar = dvVar2;
            }
            ebVar2.g = dvVar;
            if (ebVar.h.size() > 0) {
                ebVar2.h.putAll(ebVar.h);
            }
        }
        return ebVar2;
    }
}
