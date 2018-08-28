package com.tencent.mm.compatible.c;

import android.media.AudioManager;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static boolean a(AudioManager audioManager) {
        if (ar.vZ()) {
            return false;
        }
        x.i("MicroMsg.BluetoothUtil", "stop DeviceInfo mCommonInfo getStartBluetoothSco:%s,getStopBluetoothInBU:%s ", Integer.valueOf(q.deW.ddx), Integer.valueOf(q.deW.ddw));
        if ((q.deW.ddw == 1 || q.deW.ddx == -1) && audioManager.isBluetoothScoOn()) {
            x.i("MicroMsg.BluetoothUtil", "BluetoothUtil stopBluetoothSco stack: %s", bi.cjd());
            audioManager.stopBluetoothSco();
        }
        return true;
    }
}
