package com.google.android.exoplayer2.b;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;

@TargetApi(24)
final class b$a {
    public final CryptoInfo ahV;
    public final Pattern ahX;

    /* synthetic */ b$a(CryptoInfo cryptoInfo, byte b) {
        this(cryptoInfo);
    }

    private b$a(CryptoInfo cryptoInfo) {
        this.ahV = cryptoInfo;
        this.ahX = new Pattern(0, 0);
    }
}
