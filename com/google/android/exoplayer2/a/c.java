package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Arrays;

@TargetApi(21)
public final class c {
    public static final c afy = new c(new int[]{2}, 2);
    private final int afA;
    final int[] afz;

    public static c W(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
        return (registerReceiver == null || registerReceiver.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) == 0) ? afy : new c(registerReceiver.getIntArrayExtra("android.media.extra.ENCODINGS"), registerReceiver.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 0));
    }

    private c(int[] iArr, int i) {
        if (iArr != null) {
            this.afz = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.afz);
        } else {
            this.afz = new int[0];
        }
        this.afA = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (Arrays.equals(this.afz, cVar.afz) && this.afA == cVar.afA) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.afA + (Arrays.hashCode(this.afz) * 31);
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.afA + ", supportedEncodings=" + Arrays.toString(this.afz) + "]";
    }
}
