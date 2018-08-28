package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class g$3 implements a {
    final /* synthetic */ g iuX;

    g$3(g gVar) {
        this.iuX = gVar;
    }

    public final void e(int i, Object... objArr) {
        int i2;
        JSONException e;
        if (i == 15 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof byte[])) {
            int intValue = ((Integer) objArr[0]).intValue();
            try {
                x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "file transfer update json %s", new String((byte[]) objArr[1]));
                int i3 = new JSONObject(r1).getInt("progress");
                try {
                    g.a(this.iuX, (String) this.iuX.iuW.get(Integer.valueOf(intValue)), i3);
                    if (i3 >= 100) {
                        this.iuX.iuW.remove(Integer.valueOf(intValue));
                    }
                    i2 = i3;
                } catch (JSONException e2) {
                    e = e2;
                    i2 = i3;
                    x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in file transfer update callback %s", e);
                    x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", Integer.valueOf(i2));
                }
            } catch (JSONException e3) {
                e = e3;
                i2 = 0;
            }
            x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "progress %d", Integer.valueOf(i2));
        }
    }
}
