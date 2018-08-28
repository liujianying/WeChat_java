package com.tencent.mm.plugin.exdevice.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Parcelable;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

public class ExdeviceWCLanSDKUtil$LanStateChangeReceiver extends BroadcastReceiver {
    final /* synthetic */ ExdeviceWCLanSDKUtil ivm;

    public ExdeviceWCLanSDKUtil$LanStateChangeReceiver(ExdeviceWCLanSDKUtil exdeviceWCLanSDKUtil) {
        this.ivm = exdeviceWCLanSDKUtil;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
            Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
            if (parcelableExtra != null) {
                boolean z = ((NetworkInfo) parcelableExtra).getState() == State.CONNECTED;
                x.d("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "isConnected =" + z);
                if (this.ivm.ivj || this.ivm.ivi != z) {
                    dq dqVar = new dq();
                    dqVar.bLz.bLA = z;
                    a.sFg.m(dqVar);
                    this.ivm.ivj = false;
                    this.ivm.ivi = z;
                }
            }
        }
    }
}
