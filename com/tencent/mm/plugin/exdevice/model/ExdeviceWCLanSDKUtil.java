package com.tencent.mm.plugin.exdevice.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mm.g.a.dn;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import org.json.JSONObject;

public final class ExdeviceWCLanSDKUtil {
    BroadcastReceiver hiJ;
    HashMap<String, byte[]> iuK;
    HashMap<String, Boolean> iuM;
    a iuN;
    a iuP;
    private int ivd;
    private int ive;
    a ivf;
    a ivg;
    HashMap<String, String> ivh;
    boolean ivi;
    boolean ivj;
    boolean ivk;
    int ivl;
    Context mContext;

    public ExdeviceWCLanSDKUtil() {
        this.ivd = 0;
        this.ive = 0;
        this.iuK = new HashMap();
        this.iuM = new HashMap();
        this.ivh = new HashMap();
        this.mContext = null;
        this.ivi = false;
        this.ivj = false;
        this.ivk = false;
        this.ivi = true;
        this.ivj = true;
        this.iuK.clear();
        this.iuM.clear();
        this.ivh.clear();
        this.mContext = ad.getContext();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        if (this.hiJ == null) {
            this.hiJ = new LanStateChangeReceiver(this);
        }
        this.mContext.registerReceiver(this.hiJ, intentFilter);
        this.ivf = new 1(this);
        this.iuN = new 2(this);
        this.iuP = new 3(this);
        this.ivg = new 4(this);
    }

    public final boolean h(boolean z, String str) {
        if (str == null || !this.iuK.containsKey(str)) {
            x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in openOrCloseDevice");
            return false;
        }
        byte[] bArr = (byte[]) this.iuK.get(str);
        try {
            JSONObject jSONObject = new JSONObject();
            if (z) {
                x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "open device!");
                jSONObject.put("cmd", "open");
            } else {
                x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "close device!");
                jSONObject.put("cmd", "close");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("wxmsg_jsapi", jSONObject);
            jSONObject = new JSONObject();
            jSONObject.put("services", jSONObject2);
            this.ive = Java2CExDevice.useWCLanDeviceService(bArr, jSONObject.toString().getBytes());
            if (this.ive != 0) {
                x.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get openOrCloseDevice mCallBackCmdId =" + this.ive);
            } else {
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "openOrCloseDevice error!");
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
            x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in openOrCloseDevice");
            return false;
        }
    }

    public final boolean aj(String str, boolean z) {
        if (str == null || !this.iuK.containsKey(str)) {
            x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in connectWCLanDevice");
            return false;
        }
        byte[] bArr = (byte[]) this.iuK.get(str);
        this.ivk = true;
        if (z) {
            try {
                String string = new JSONObject(new String(bArr)).getString("deviceType");
                x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice deviceId: " + str);
                if (Java2CExDevice.connectWCLanDevice(bArr, false) != 0) {
                    x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "connectWCLanDevice error!");
                    return false;
                }
                dn dnVar = new dn();
                dnVar.bLu.byN = str;
                dnVar.bLu.bLv = 1;
                dnVar.bLu.bKC = string;
                com.tencent.mm.sdk.b.a.sFg.m(dnVar);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in connectWCLanDevice!");
                return false;
            }
        }
        h(false, str);
        x.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "disconnectWCLanDevice...");
        Java2CExDevice.disconnectWCLanDevice(bArr);
        return true;
    }

    public final boolean cy(String str, String str2) {
        if (!zY(str)) {
            x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "deviceId " + str + " not connected!");
            return false;
        } else if (str == null || !this.iuK.containsKey(str)) {
            x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "mDevClassInfo is null in useWCLanDeviceService");
            return false;
        } else {
            byte[] bArr = (byte[]) this.iuK.get(str);
            this.ivd = 0;
            try {
                boolean z;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", str2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("wxmsg_jsapi", jSONObject);
                jSONObject = new JSONObject();
                jSONObject.put("services", jSONObject2);
                this.ivd = Java2CExDevice.useWCLanDeviceService(bArr, jSONObject.toString().getBytes());
                if (this.ivd != 0) {
                    z = true;
                    x.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "get useWCLanDeviceService mCallBackCmdId =" + this.ivd);
                } else {
                    x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "useWCLanDeviceService error!");
                    z = false;
                }
                return z;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", e, "", new Object[0]);
                x.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON encode failed in useWCLanDeviceService");
                return false;
            }
        }
    }

    public final boolean zY(String str) {
        if (str == null || !this.iuM.containsKey(str)) {
            return false;
        }
        return ((Boolean) this.iuM.get(str)).booleanValue();
    }
}
