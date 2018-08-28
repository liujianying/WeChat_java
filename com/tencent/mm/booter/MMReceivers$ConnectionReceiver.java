package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.booter.MMReceivers.AlarmReceiver;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.aa$a;
import com.tencent.mm.sdk.platformtools.x;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140819", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class MMReceivers$ConnectionReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (context != null) {
            x.i("MicroMsg.ConnectionReceiver", "onReceive threadID: " + Thread.currentThread().getId());
            if (!b.v(context, "connection")) {
                AlarmReceiver.bn(context);
                x.chR();
            } else if (aa.UY() != null) {
                NetworkInfo networkInfo = null;
                try {
                    networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                } catch (Exception e) {
                    x.e("MicroMsg.ConnectionReceiver", "getActiveNetworkInfo failed. exception: %s", new Object[]{e.getMessage()});
                }
                aa$a UY;
                if (networkInfo == null || networkInfo.getState() != State.CONNECTED) {
                    String str = "MicroMsg.ConnectionReceiver";
                    String str2 = "NetworkAvailable: false, state:%s";
                    Object[] objArr = new Object[1];
                    objArr[0] = networkInfo == null ? "null" : networkInfo.getState();
                    x.i(str, str2, objArr);
                    UY = aa.UY();
                    if (networkInfo != null) {
                        networkInfo.getTypeName();
                    }
                    if (networkInfo != null) {
                        networkInfo.getSubtypeName();
                    }
                    UY.aP(false);
                    return;
                }
                x.i("MicroMsg.ConnectionReceiver", "NetworkAvailable: true");
                UY = aa.UY();
                networkInfo.getTypeName();
                networkInfo.getSubtypeName();
                UY.aP(true);
            }
        }
    }
}
