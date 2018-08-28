package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

class g$5 implements a {
    final /* synthetic */ g iuX;

    g$5(g gVar) {
        this.iuX = gVar;
    }

    public final void e(int i, Object... objArr) {
        if (i == 12 && objArr != null && objArr.length >= 2 && (objArr[0] instanceof Integer) && (objArr[1] instanceof byte[])) {
            int intValue = ((Integer) objArr[0]).intValue();
            byte[] bArr = (byte[]) objArr[1];
            if (intValue > 0) {
                String str = (String) this.iuX.iuW.get(Integer.valueOf(intValue));
                if (str != null) {
                    try {
                        x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive response json %s", new Object[]{new String(bArr)});
                        JSONObject jSONObject = new JSONObject(r2);
                        if (jSONObject.isNull("errcode") || jSONObject.getInt("errcode") == 0) {
                            g.cx(str, this.iuX.iuA);
                            x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send data success!");
                            return;
                        }
                        g.cx(str, this.iuX.iuB);
                        x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send msg failed data %s", new Object[]{r2});
                        return;
                    } catch (JSONException e) {
                        x.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode mUseWCLanDeviceServiceCmdId failed %s", new Object[]{e});
                        return;
                    }
                }
            }
            x.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive cmdId =" + intValue);
        }
    }
}
