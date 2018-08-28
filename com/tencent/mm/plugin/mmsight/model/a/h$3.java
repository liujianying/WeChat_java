package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.e.b.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

class h$3 implements a {
    final /* synthetic */ h lij;

    h$3(h hVar) {
        this.lij = hVar;
    }

    public final void s(byte[] bArr, int i) {
        int i2 = 0;
        this.lij.lia.sendEmptyMessage(0);
        if (!this.lij.lhW) {
            i2 = 1;
        }
        if (i2 == 0) {
            this.lij.giA += 128;
        }
        boolean z = this.lij.lib;
        if (i2 == 0) {
            h hVar = this.lij;
            if (0 == hVar.lhQ) {
                hVar.lhQ = System.nanoTime();
            }
            if (hVar.lhZ != null && hVar.lhZ.lju <= 0) {
                hVar.lhZ.lju = System.nanoTime();
            }
            if (hVar.lhN != null) {
                if (hVar.lhN == null) {
                    x.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:" + z);
                } else {
                    try {
                        ByteBuffer[] inputBuffers = hVar.lhN.getInputBuffers();
                        int dequeueInputBuffer = hVar.lhN.dequeueInputBuffer(100);
                        hVar.lhR = dequeueInputBuffer;
                        if (dequeueInputBuffer < 0) {
                            x.d("MicroMsg.MMSightAACMediaCodecRecorder", "audio no input available, drain first");
                            hVar.gu(false);
                        }
                        if (hVar.lhN == null) {
                            x.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:" + z);
                        } else if (hVar.lhR >= 0) {
                            ByteBuffer byteBuffer = inputBuffers[hVar.lhR];
                            byteBuffer.clear();
                            byteBuffer.put(bArr);
                            byteBuffer.position(0);
                            hVar.lhS = bArr.length;
                            hVar.lhT = System.nanoTime();
                            hVar.lhT -= (long) ((hVar.lhS / hVar.audioSampleRate) / 1000000000);
                            if (hVar.lhS == -3) {
                                x.e("MicroMsg.MMSightAACMediaCodecRecorder", "Audio read error");
                            }
                            hVar.lhU = (hVar.lhT - (hVar.lhZ != null ? hVar.lhZ.lju : hVar.lhQ)) / 1000;
                            x.v("MicroMsg.MMSightAACMediaCodecRecorder", "queueing " + hVar.lhS + " audio bytes with pts " + hVar.lhU + ", end:" + z + ", enqueue:" + hVar.lhR);
                            if (z) {
                                x.i("MicroMsg.MMSightAACMediaCodecRecorder", "EOS received in sendAudioToEncoder");
                                hVar.lhN.queueInputBuffer(hVar.lhR, 0, hVar.lhS, hVar.lhU, 4);
                            } else {
                                hVar.lhN.queueInputBuffer(hVar.lhR, 0, hVar.lhS, hVar.lhU, 0);
                            }
                        }
                    } catch (Throwable th) {
                        x.e("MicroMsg.MMSightAACMediaCodecRecorder", "_offerAudioEncoder exception " + th.getMessage());
                    }
                }
                hVar.gu(z);
            }
        }
        if (z && !this.lij.lif) {
            synchronized (this.lij.lid) {
                if (this.lij.lie != null) {
                    x.i("MicroMsg.MMSightAACMediaCodecRecorder", "do aac stop callback");
                    this.lij.lie.bei();
                    this.lij.lie = null;
                } else {
                    x.w("MicroMsg.MMSightAACMediaCodecRecorder", "aac stop callback is null");
                }
                this.lij.lic = true;
            }
            this.lij.lif = true;
            this.lij.lig.removeCallbacks(this.lij.lih);
            this.lij.lig.post(this.lij.lih);
        }
    }

    public final void aN(int i, int i2) {
        x.w("MicroMsg.MMSightAACMediaCodecRecorder", "on rec error, %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }
}
