package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.tencent.mm.ab.e;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.b.l.b;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.protocal.c.and;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h extends b implements e {
    public static int mYM = 3;
    private float cXm = -85.0f;
    private float cXn = -1000.0f;
    private a cXs = new 1(this);
    private c dMm;
    private int mLy = -1000;
    private d mYH;
    public Collection<a> mYI = null;
    private int mYJ = 10001;
    private int mYK = 10002;
    private int mYL = 10003;

    public h(l.a aVar) {
        super(aVar);
    }

    public final void init() {
        au.DF().a(658, (e) this);
        buo();
    }

    public final void reset() {
        if (this.mYH != null) {
            au.DF().c(this.mYH);
        }
    }

    public final void start() {
        x.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]:start");
        init();
        reset();
        if (this.dMm == null) {
            buo();
        }
        this.dMm.b(this.cXs, true);
        if (!(VERSION.RELEASE.equals("6.0") || VERSION.RELEASE.equals("6.0.0") || VERSION.SDK_INT < 23)) {
            boolean isProviderEnabled;
            LocationManager locationManager = (LocationManager) ad.getContext().getSystemService("location");
            if (locationManager != null) {
                isProviderEnabled = locationManager.isProviderEnabled("gps");
            } else {
                isProviderEnabled = true;
            }
            if (!isProviderEnabled) {
                new ag().postDelayed(new 2(this), 1000);
                return;
            }
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.getState() != 12) {
            new ag().postDelayed(new 3(this), 1000);
        } else if (defaultAdapter == null) {
            new ag().postDelayed(new 4(this), 1000);
        } else {
            int size;
            String str = "MicroMsg.ShakeIbeaconService";
            String str2 = "[oneliang][ShakeIbeaconService][shakezb]:beaconCollection.size:%d";
            Object[] objArr = new Object[1];
            if (this.mYI != null) {
                size = this.mYI.size();
            } else {
                size = 0;
            }
            objArr[0] = Integer.valueOf(size);
            x.i(str, str2, objArr);
            this.mYH = new d(this.mYI, this.cXm, this.cXn, this.mLy);
            au.DF().a(this.mYH, 0);
        }
    }

    public final void pause() {
        if (this.dMm != null) {
            this.dMm.c(this.cXs);
        }
    }

    public final void resume() {
        if (this.dMm != null) {
            this.dMm.a(this.cXs, true);
        }
    }

    private void buo() {
        this.dMm = c.OB();
        this.dMm.a(this.cXs, true);
    }

    public final void bup() {
        super.bup();
        au.DF().b(658, (e) this);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService]onSceneEnd :netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (i == 0 && i2 == 0) {
            d dVar = (d) lVar;
            if (658 == lVar.getType() && dVar.action == 1) {
                and and = (and) dVar.dZf.dIE.dIL;
                if (and.rPT.rsj == 0) {
                    x.i("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb]onSceneEnd :message:%s,tips:%s,result:%s", and.rPT.jPH, and.rPT.lRx, Integer.valueOf(and.rPT.rsj));
                    try {
                        JSONObject jSONObject = new JSONObject(and.rPT.jPH);
                        JSONArray jSONArray = jSONObject.getJSONArray("msgs");
                        JSONObject jSONObject2 = jSONObject.getJSONObject("guide_switch");
                        int i3 = jSONObject2.getInt("channel_open_method");
                        long j = jSONObject2.getLong("channel_open_time");
                        int i4 = jSONObject2.getInt("shake_tab_display");
                        int i5 = jSONObject.getJSONObject("gated_launch_option").getInt("tab_state");
                        au.HU();
                        com.tencent.mm.model.c.DT().a(aa.a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_METHOD_INT, Integer.valueOf(i3));
                        au.HU();
                        com.tencent.mm.model.c.DT().a(aa.a.USERINFO_IBEACON_PUSH_CHANNEL_OPEN_TIME_LONG, Long.valueOf(j));
                        au.HU();
                        com.tencent.mm.model.c.DT().a(aa.a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, Integer.valueOf(i4));
                        au.HU();
                        com.tencent.mm.model.c.DT().a(aa.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(i5));
                        x.i("MicroMsg.ShakeIbeaconService", "[shakezb]channel_open_method is " + i3 + " ,channel_open_time is " + j + ", shake_tab_display is " + i4);
                        int length = jSONArray.length();
                        List list = null;
                        com.tencent.mm.plugin.shake.b.e buC = m.buC();
                        buC.buu();
                        if (length > 0) {
                            list = new ArrayList();
                            for (i5 = 0; i5 < length; i5++) {
                                d dVar2 = new d();
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i5);
                                String string = jSONObject3.getString("url");
                                String string2 = jSONObject3.getString("content");
                                String string3 = jSONObject3.getString("title");
                                String string4 = jSONObject3.getString("picurl");
                                String string5 = jSONObject3.getString("shopid");
                                JSONObject jSONObject4 = jSONObject3.getJSONObject("beacon");
                                String string6 = jSONObject4.getString("uuid");
                                String string7 = jSONObject4.getString("major");
                                String string8 = jSONObject4.getString("minor");
                                int i6 = jSONObject3.getInt("guide_state");
                                String string9 = jSONObject3.getString("wxa_username");
                                String string10 = jSONObject3.getString("wxa_path");
                                int i7 = jSONObject3.getInt("wxa_version_type");
                                dVar2.field_type = 11;
                                dVar2.field_username = string3;
                                dVar2.field_nickname = string3;
                                dVar2.field_signature = string2;
                                dVar2.field_province = string4;
                                dVar2.field_city = string;
                                if (i6 == 1) {
                                    dVar2.field_sex = mYM;
                                }
                                dVar2.field_lvbuffer = (String.valueOf(string5) + "," + String.valueOf(string6) + "," + String.valueOf(string7) + "," + String.valueOf(string8)).getBytes("utf-8");
                                dVar2.field_insertBatch = 2;
                                dVar2.field_reserved3 = string9 + "," + string10 + "," + i7;
                                list.add(dVar2);
                                buC.a(dVar2, true);
                                if (dVar2.field_sex == mYM && i3 == 1) {
                                    a(dVar2);
                                }
                            }
                        }
                        this.mWQ.d(list, 1);
                        return;
                    } catch (Exception e) {
                        x.e("MicroMsg.ShakeIbeaconService", "[oneliang][ShakeIbeaconService][shakezb] parse error.%s", bi.oV(e.getMessage()));
                        this.mWQ.d(null, 1);
                        return;
                    }
                } else if (and.rPT.rsj == this.mYJ) {
                    this.mWQ.d(null, 6);
                    return;
                } else if (and.rPT.rsj == this.mYK) {
                    this.mWQ.d(null, 7);
                    return;
                } else if (and.rPT.rsj == this.mYL) {
                    this.mWQ.d(null, 8);
                    return;
                } else {
                    this.mWQ.d(null, 1);
                    return;
                }
            }
            return;
        }
        this.mWQ.d(null, 3);
    }

    public static void a(d dVar) {
        if (dVar != null && dVar.field_sex == mYM) {
            String str;
            au.HU();
            com.tencent.mm.model.c.DT().a(aa.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.valueOf(true));
            long VE = bi.VE();
            au.HU();
            com.tencent.mm.model.c.DT().a(aa.a.USERINFO_IBEACON_PUSH_OPEN_TIEMSTAMP_LONG, Long.valueOf(VE));
            try {
                str = new String(dVar.field_lvbuffer, "utf-8");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ShakeIbeaconService", e, "%s", "Unsupported");
                str = null;
            }
            if (str != null) {
                String[] split = str.split(",");
                if (split.length == 4) {
                    au.HU();
                    com.tencent.mm.model.c.DT().a(aa.a.USERINFO_IBEACON_PUSH_SHOP_ID_LONG, Long.valueOf(split[0]));
                }
            }
        }
    }

    public static void b(d dVar) {
        if (dVar != null) {
            String str;
            try {
                str = new String(dVar.field_lvbuffer, "utf-8");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ShakeIbeaconService", e, "%s", "Unsupported");
                str = null;
            }
            if (str != null) {
                String[] split = str.split(",");
                if (split.length == 4) {
                    String str2 = split[1];
                    String str3 = split[2];
                    str = split[3];
                    a aVar = new a();
                    aVar.fMk = str2;
                    aVar.major = bi.getInt(str3, 0);
                    aVar.minor = bi.getInt(str, 0);
                }
            }
        }
    }
}
