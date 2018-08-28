package com.tencent.mm.plugin.shake.d.a;

import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.bl;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.anc;
import com.tencent.mm.protocal.c.and;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends l implements k {
    int action;
    final b dZf;
    private e diJ;
    private long mYE;

    public d(Collection<h$a> collection, float f, float f2, int i) {
        int i2;
        this.action = 1;
        this.mYE = 0;
        this.action = 1;
        a aVar = new a();
        aVar.dIG = new anc();
        aVar.dIH = new and();
        aVar.uri = "/cgi-bin/micromsg-bin/ibeaconboardcast";
        aVar.dIF = 658;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.dZf = aVar.KT();
        bl IC = bl.IC();
        String oV = bi.oV(IC.dDf);
        String oV2 = bi.oV(IC.dDe);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        anc anc = (anc) this.dZf.dID.dIL;
        anc.rPS = bi.oV(null);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"Beacons\":[");
        if (collection != null) {
            i2 = 0;
            int size = collection.size();
            Iterator it = collection.iterator();
            while (true) {
                int i3 = i2;
                if (!it.hasNext()) {
                    break;
                }
                h$a h_a = (h$a) it.next();
                stringBuilder.append("{\"UUID\":\"" + h_a.fMk + "\",\"Location\":{\"Major\":" + h_a.major + ",\"Minor\":" + h_a.minor + "},\"Distance\":" + h_a.ees + ",\"Extra\":\"\",\"MacAddress\":\"" + h_a.mYO + "\",\"Rssi\":\"" + h_a.mYP + "\",\"MeasurePower\":\"" + h_a.mYQ + "\"}");
                if (i3 < size - 1) {
                    stringBuilder.append(",");
                }
                i2 = i3 + 1;
            }
        }
        i2 = 1;
        boolean hasSystemFeature = ad.getContext().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
        if (defaultAdapter != null && defaultAdapter.getState() == 12 && VERSION.SDK_INT >= 18 && hasSystemFeature) {
            i2 = 0;
        }
        stringBuilder.append("],\"Action\":1,\"LBS\":{\"Latitude\":" + f + ",\"Longitude\":" + f2 + ",\"Province\":\"" + oV + "\",\"City\":\"" + oV2 + "\"},\"MachineID\":\"" + q.zz() + "\",\"ZBBeaconState\":\"" + i2 + "\"}");
        anc.jSA = stringBuilder.toString();
        String str = "MicroMsg.NetSceneShakeIbeacon";
        oV = "[oneliang]beaconCollection.size:%d,json:%s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(collection != null ? collection.size() : 0);
        objArr[1] = anc.jSA;
        x.i(str, oV, objArr);
        o.a(2008, f2, f, i);
    }

    public final int getType() {
        return 658;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.mYE = System.currentTimeMillis();
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
        this.mYE = System.currentTimeMillis() - this.mYE;
        h.mEJ.h(11497, new Object[]{String.valueOf((int) (((double) (this.mYE / 1000)) + 0.5d)), Integer.valueOf(1), Integer.valueOf((int) this.mYE)});
        int i4;
        String string;
        JSONObject jSONObject;
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end ok");
            and and = (and) this.dZf.dIE.dIL;
            try {
                JSONObject jSONObject2 = new JSONObject(((anc) this.dZf.dID.dIL).jSA);
                JSONArray jSONArray = jSONObject2.getJSONArray("Beacons");
                int length = jSONArray.length();
                JSONObject jSONObject3 = jSONObject2.getJSONObject("LBS");
                i4 = jSONObject2.getInt("Action");
                String string2 = jSONObject3.getString("Latitude");
                string = jSONObject3.getString("Longitude");
                if (length > 0) {
                    jSONObject = jSONArray.getJSONObject(0);
                    String string3 = jSONObject.getString("UUID");
                    jSONObject = jSONObject.getJSONObject("Location");
                    int i5 = jSONObject.getInt("Major");
                    int i6 = jSONObject.getInt("Minor");
                    if (and.rPT.rsj == 0) {
                        String str2 = and.rPT.jPH;
                        if (i4 == 1 && str2 != null && !str2.equals("") && new JSONObject(str2).getJSONArray("msgs").length() == 0) {
                            h.mEJ.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(length), string3, Integer.valueOf(i5), Integer.valueOf(i6), string2, string, Integer.valueOf(2), Integer.valueOf(and.rPT.rsj)});
                            return;
                        }
                        return;
                    }
                    h.mEJ.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(length), string3, Integer.valueOf(i5), Integer.valueOf(i6), string2, string, Integer.valueOf(2), Integer.valueOf(and.rPT.rsj)});
                    return;
                }
                h.mEJ.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(length), "", Integer.valueOf(0), Integer.valueOf(0), string2, string, Integer.valueOf(2), Integer.valueOf(and.rPT.rsj)});
                return;
            } catch (JSONException e) {
                x.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
                return;
            }
        }
        x.d("MicroMsg.NetSceneShakeIbeacon", "[oneliang][NetSceneShakeIbeacon]:net end not ok");
        try {
            jSONObject = new JSONObject(((anc) this.dZf.dID.dIL).jSA);
            JSONArray jSONArray2 = jSONObject.getJSONArray("Beacons");
            i4 = jSONArray2.length();
            jSONObject = jSONObject.getJSONObject("LBS");
            String string4 = jSONObject.getString("Latitude");
            String string5 = jSONObject.getString("Longitude");
            if (i4 > 0) {
                JSONObject jSONObject4 = jSONArray2.getJSONObject(0);
                string = jSONObject4.getString("UUID");
                jSONObject4 = jSONObject4.getJSONObject("Location");
                int i7 = jSONObject4.getInt("Major");
                int i8 = jSONObject4.getInt("Minor");
                h.mEJ.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(i4), string, Integer.valueOf(i7), Integer.valueOf(i8), string4, string5, Integer.valueOf(1), Integer.valueOf(i3)});
                return;
            }
            h.mEJ.h(12659, new Object[]{Integer.valueOf(1), Integer.valueOf(i4), "", Integer.valueOf(0), Integer.valueOf(0), string4, string5, Integer.valueOf(1), Integer.valueOf(i3)});
        } catch (JSONException e2) {
            x.e("MicroMsg.NetSceneShakeIbeacon", "parse IBeaconBoardcastRequest json error!");
        }
    }
}
