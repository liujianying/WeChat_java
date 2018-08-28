package com.tencent.liteav.audio.impl.Play;

import android.media.AudioTrack;
import com.tencent.liteav.audio.impl.Play.d.a;
import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

class d$1 extends a {
    final /* synthetic */ d a;

    d$1(d dVar, String str) {
        this.a = dVar;
        super(dVar, str);
    }

    public void run() {
        int i = 3;
        a();
        try {
            int i2;
            if (d.a(this.a) == 1) {
                i2 = 2;
            } else {
                i2 = 3;
            }
            if (d.b(this.a) != 8) {
                i = 2;
            }
            AudioTrack audioTrack = new AudioTrack(3, d.c(this.a), i2, i, AudioTrack.getMinBufferSize(d.c(this.a), i2, i), 1);
            TXCLog.i(d.e(), "create audio track, samplerate:" + d.c(this.a) + ", channels:" + d.a(this.a) + ", bits:" + d.b(this.a));
            try {
                audioTrack.play();
                d.a(this.a, true);
                this.a.a(d.d(this.a), d.e(this.a));
                int i3 = 100;
                int i4 = 0;
                while (this.b) {
                    byte[] nativeGetMixedTracksData = b.nativeGetMixedTracksData(2048);
                    if (nativeGetMixedTracksData == null || nativeGetMixedTracksData.length <= 0) {
                        try {
                            sleep(5);
                        } catch (InterruptedException e) {
                        }
                    } else {
                        if (d.f(this.a)) {
                            Arrays.fill(nativeGetMixedTracksData, (byte) 0);
                        }
                        if (i3 != 0 && i4 < 800) {
                            short[] sArr = new short[(nativeGetMixedTracksData.length / 2)];
                            ByteBuffer.wrap(nativeGetMixedTracksData).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(sArr);
                            for (i2 = 0; i2 < sArr.length; i2++) {
                                sArr[i2] = (short) (sArr[i2] / i3);
                            }
                            ByteBuffer.wrap(nativeGetMixedTracksData).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().put(sArr);
                            i4 += nativeGetMixedTracksData.length / ((d.c(this.a) * 2) / 1000);
                            i3 = (i3 * (800 - i4)) / 800;
                        }
                        audioTrack.write(nativeGetMixedTracksData, 0, nativeGetMixedTracksData.length);
                    }
                }
                try {
                    audioTrack.pause();
                    audioTrack.flush();
                    audioTrack.stop();
                    audioTrack.release();
                } catch (Exception e2) {
                }
                TXCLog.e(d.e(), "mult-player thread stop finish!");
            } catch (Exception e3) {
            }
        } catch (Exception e4) {
        }
    }
}
