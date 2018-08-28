package com.tencent.mm.plugin.voip.model;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;

class s$5 extends PhoneStateListener {
    final /* synthetic */ s oNG;
    final /* synthetic */ TelephonyManager oNH;

    s$5(s sVar, TelephonyManager telephonyManager) {
        this.oNG = sVar;
        this.oNH = telephonyManager;
    }

    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        int i = 100;
        super.onSignalStrengthsChanged(signalStrength);
        String[] split = signalStrength.toString().split(" ");
        if (this.oNH.getNetworkType() == 13) {
            if (split != null && split.length >= 10) {
                s.yL(Integer.parseInt(split[9]) + 140);
            }
            this.oNG.oNx = "LTE";
        } else {
            int gsmSignalStrength = signalStrength.getGsmSignalStrength();
            if (signalStrength.isGsm() && gsmSignalStrength == 99) {
                s.yL(-1);
            } else {
                s.yL((int) (((float) gsmSignalStrength) * 3.2258065f));
            }
        }
        if (s.asg() <= 100) {
            i = s.asg();
        }
        s.yL(i);
        s.yL(s.asg() < 0 ? 0 : s.asg());
        s.f(this.oNG);
    }
}
