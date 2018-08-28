package com.tencent.liteav;

import android.media.MediaFormat;
import com.tencent.liteav.basic.f.b;

public interface c$a {
    void onEncAudio(byte[] bArr, long j, int i, int i2);

    void onEncVideo(b bVar);

    void onEncVideoFormat(MediaFormat mediaFormat);

    void onRecordPcm(byte[] bArr, long j, int i, int i2, int i3);
}
