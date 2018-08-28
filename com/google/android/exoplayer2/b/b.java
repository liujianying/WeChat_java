package com.google.android.exoplayer2.b;

import android.media.MediaCodec.CryptoInfo;
import com.google.android.exoplayer2.i.t;

public final class b {
    public int ahT;
    public int ahU;
    public final CryptoInfo ahV;
    public final a ahW;
    public byte[] iv;
    public byte[] key;
    public int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;

    public b() {
        CryptoInfo cryptoInfo;
        a aVar = null;
        if (t.SDK_INT >= 16) {
            cryptoInfo = new CryptoInfo();
        } else {
            cryptoInfo = null;
        }
        this.ahV = cryptoInfo;
        if (t.SDK_INT >= 24) {
            aVar = new a(this.ahV, (byte) 0);
        }
        this.ahW = aVar;
    }
}
