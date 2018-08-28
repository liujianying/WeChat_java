package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

class g$4 implements a {
    final /* synthetic */ g iuX;

    g$4(g gVar) {
        this.iuX = gVar;
    }

    public final void e(int i, Object... objArr) {
        Exception e;
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3 = null;
        if (i == 14 && objArr != null && objArr.length > 0 && (objArr[0] instanceof byte[])) {
            JSONObject jSONObject4;
            try {
                Object string;
                Object string2;
                JSONObject jSONObject5 = new JSONObject(new String((byte[]) objArr[0]));
                jSONObject4 = jSONObject5.getJSONObject("deviceInfo");
                try {
                    string = jSONObject4.getString("deviceType");
                    try {
                        string2 = jSONObject4.getString("deviceId");
                    } catch (Exception e2) {
                        e = e2;
                        jSONObject = jSONObject3;
                    }
                } catch (Exception e3) {
                    e = e3;
                    jSONObject = jSONObject3;
                    jSONObject2 = jSONObject3;
                }
                JSONObject jSONObject6;
                int size;
                int i2;
                try {
                    if (jSONObject5.isNull("profile")) {
                        x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "json have not profile, return");
                        return;
                    }
                    JSONArray jSONArray = jSONObject5.getJSONArray("profile");
                    x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package profiles %s", jSONArray.toString());
                    jSONObject6 = jSONObject4;
                    if (!(string == null || string2 == null)) {
                        x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", string, string2);
                    }
                    size = this.iuX.iuI.size();
                    i2 = 0;
                    while (i2 < size) {
                        if (((b) this.iuX.iuI.get(i2)).field_deviceID.equals(string2) && ((b) this.iuX.iuI.get(i2)).field_deviceType.equals(string) && ((b) this.iuX.iuI.get(i2)).cCX.contains("wechat_to_device") && !this.iuX.iuJ.contains(this.iuX.iuI.get(i2))) {
                            this.iuX.iuK.put(string2, jSONObject6.toString());
                            this.iuX.iuJ.add(this.iuX.iuI.get(i2));
                            g.aR(this.iuX.iuJ);
                        }
                        i2++;
                    }
                } catch (Exception e4) {
                    e = e4;
                    Object jSONObject7 = string2;
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in discover package callback %s", e);
                    jSONObject6 = jSONObject4;
                    string2 = jSONObject7;
                    x.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", string, string2);
                    size = this.iuX.iuI.size();
                    i2 = 0;
                    while (i2 < size) {
                        if (((b) this.iuX.iuI.get(i2)).field_deviceID.equals(string2) && ((b) this.iuX.iuI.get(i2)).field_deviceType.equals(string) && ((b) this.iuX.iuI.get(i2)).cCX.contains("wechat_to_device") && !this.iuX.iuJ.contains(this.iuX.iuI.get(i2))) {
                            this.iuX.iuK.put(string2, jSONObject6.toString());
                            this.iuX.iuJ.add(this.iuX.iuI.get(i2));
                            g.aR(this.iuX.iuJ);
                        }
                        i2++;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                jSONObject4 = jSONObject3;
                jSONObject7 = jSONObject3;
                jSONObject2 = jSONObject3;
            }
        }
    }
}
