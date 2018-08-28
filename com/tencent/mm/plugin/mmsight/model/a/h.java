package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import com.tencent.mm.e.b.c;
import com.tencent.mm.plugin.mmsight.model.a.c.a;
import com.tencent.mm.plugin.mmsight.model.a.c.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

@TargetApi(16)
public class h implements c {
    int audioSampleRate;
    c bDp = null;
    private int dQF;
    int giA;
    private final int giU = 100;
    MediaCodec lhN;
    private MediaFormat lhO;
    private BufferInfo lhP;
    long lhQ = 0;
    int lhR;
    int lhS;
    long lhT;
    long lhU;
    private int lhV;
    boolean lhW = false;
    boolean lhX = false;
    a lhY = null;
    o lhZ;
    ag lia = new 1(this, Looper.getMainLooper());
    protected boolean lib;
    boolean lic;
    final Object lid = new byte[0];
    b lie;
    boolean lif = false;
    ag lig;
    Runnable lih = new 2(this);
    private c.a lii = new 3(this);
    private long startTime = 0;

    public h(int i, int i2) {
        this.dQF = i2;
        this.audioSampleRate = i;
        this.lhZ = null;
        x.i("MicroMsg.MMSightAACMediaCodecRecorder", "create MMSightAACMediaCodecRecorder, audioBitrate: %s, audioSampleRate: %s", new Object[]{Integer.valueOf(this.dQF), Integer.valueOf(this.audioSampleRate)});
    }

    public int at(int i, String str) {
        String str2;
        String str3;
        Object[] objArr;
        if (!(this.lhX || this.bDp == null)) {
            str2 = "MicroMsg.MMSightAACMediaCodecRecorder";
            str3 = "call init, before pcmRecorder stop, stopCallback null ? %B";
            objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.lie == null);
            x.e(str2, str3, objArr);
            this.bDp.we();
        }
        if (this.lhN != null) {
            boolean z;
            str2 = "MicroMsg.MMSightAACMediaCodecRecorder";
            str3 = "call init, before audioEncoder stop, stopCallback null ? %B";
            objArr = new Object[1];
            if (this.lie == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.e(str2, str3, objArr);
            this.lhN.stop();
            this.lhN.release();
            this.lhN = null;
            if (this.lie != null) {
                this.lie.bei();
                this.lie = null;
            }
        }
        this.giA = 0;
        this.lib = false;
        synchronized (this.lid) {
            try {
                this.lic = false;
                this.lie = null;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        if (!this.lhX) {
            this.bDp = new c(this.audioSampleRate, 1, 5);
            this.bDp.ey(128);
            this.bDp.aM(false);
            this.bDp.bEb = this.lii;
        }
        if (this.lig == null) {
            x.i("MicroMsg.MMSightAACMediaCodecRecorder", "create pcm control handler");
            this.lig = new ag();
        } else if (this.lig.getLooper() != Looper.myLooper()) {
            x.w("MicroMsg.MMSightAACMediaCodecRecorder", "error pcm control handler looper[%s, %s], recreate handler", new Object[]{this.lig.getLooper(), Looper.myLooper()});
            this.lig = new ag();
        }
        x.i("MicroMsg.MMSightAACMediaCodecRecorder", "sample rate %d, audio rate %d", new Object[]{Integer.valueOf(this.audioSampleRate), Integer.valueOf(this.dQF)});
        try {
            this.lhP = new BufferInfo();
            this.lhO = new MediaFormat();
            this.lhO.setString("mime", "audio/mp4a-latm");
            this.lhO.setInteger("aac-profile", 2);
            this.lhO.setInteger("sample-rate", this.audioSampleRate);
            this.lhO.setInteger("channel-count", 1);
            this.lhO.setInteger("bitrate", this.dQF);
            this.lhO.setInteger("max-input-size", 16384);
            this.lhN = MediaCodec.createEncoderByType("audio/mp4a-latm");
            this.lhN.configure(this.lhO, null, null, 1);
            this.lhN.start();
            this.lhW = false;
            return 0;
        } catch (Throwable th2) {
            this.lhW = false;
            throw th2;
        }
    }

    public final int a(a aVar) {
        int i = 0;
        x.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, onPcmReady: %s", new Object[]{aVar});
        this.lhY = aVar;
        if (!this.lhX) {
            if (this.bDp == null) {
                x.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, pcmrecorder is null");
                return -1;
            } else if (!this.bDp.wn()) {
                i = -1;
            }
        }
        return i;
    }

    public final int a(b bVar) {
        boolean z;
        String str = "MicroMsg.MMSightAACMediaCodecRecorder";
        String str2 = "call stop, pcmRecorder null[%B], old stopCallback null[%B]new stopCallback null[%B], pcmMarkStop[%B]";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(this.bDp == null);
        if (this.lie == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(bVar == null);
        objArr[3] = Boolean.valueOf(this.lib);
        x.i(str, str2, objArr);
        if (this.bDp == null && !this.lhX) {
            return -1;
        }
        this.lib = true;
        synchronized (this.lid) {
            this.lie = bVar;
            if (this.lic && bVar != null) {
                x.i("MicroMsg.MMSightAACMediaCodecRecorder", "has stop, directly call stop callback");
                bVar.bei();
                this.lie = null;
            }
        }
        ah.i(new 4(this), 500);
        return 0;
    }

    public final void clear() {
        x.i("MicroMsg.MMSightAACMediaCodecRecorder", "clear");
        try {
            if (this.lhN != null) {
                x.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop encoder");
                this.lhN.stop();
                this.lhN.release();
                this.lhN = null;
            }
            if (this.bDp != null && !this.lhX) {
                x.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop pcm recorder");
                this.bDp.we();
                this.bDp = null;
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightAACMediaCodecRecorder", "clear error: %s", new Object[]{e.getMessage()});
        }
    }

    public final void bef() {
        this.lhW = true;
    }

    public final c.a beg() {
        return this.lii;
    }

    public final void gt(boolean z) {
        this.lhX = z;
    }

    final void gu(boolean z) {
        if (this.lhN == null) {
            x.w("MicroMsg.MMSightAACMediaCodecRecorder", "drain audio encoder error, encoder is null, end:" + z);
            return;
        }
        try {
            ByteBuffer[] outputBuffers = this.lhN.getOutputBuffers();
            while (true) {
                this.lhV = this.lhN.dequeueOutputBuffer(this.lhP, 100);
                x.v("MicroMsg.MMSightAACMediaCodecRecorder", "outputBufferIndex-->%s", new Object[]{Integer.valueOf(this.lhV)});
                if (this.lhV == -1) {
                    x.d("MicroMsg.MMSightAACMediaCodecRecorder", "no output available, break");
                    return;
                } else if (this.lhV == -3) {
                    outputBuffers = this.lhN.getOutputBuffers();
                } else if (this.lhV == -2) {
                    MediaFormat outputFormat = this.lhN.getOutputFormat();
                    x.d("MicroMsg.MMSightAACMediaCodecRecorder", "encoder output format changed: " + outputFormat);
                    if (this.lhZ != null) {
                        this.lhZ.d(outputFormat);
                    }
                } else if (this.lhV < 0) {
                    x.v("MicroMsg.MMSightAACMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[]{Integer.valueOf(this.lhV)});
                } else {
                    x.v("MicroMsg.MMSightAACMediaCodecRecorder", "perform encoding");
                    ByteBuffer byteBuffer = outputBuffers[this.lhV];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + this.lhV + " was null");
                    }
                    if ((this.lhP.flags & 2) != 0) {
                        x.v("MicroMsg.MMSightAACMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[]{Integer.valueOf(this.lhP.size), Boolean.valueOf(bex())});
                        if (bex()) {
                            this.lhP.size = 0;
                        }
                    }
                    if (this.lhP.size != 0) {
                        if (!(this.lhZ == null || this.lhZ.bTv)) {
                            this.lhZ.d(this.lhN.getOutputFormat());
                        }
                        byteBuffer.position(this.lhP.offset);
                        byteBuffer.limit(this.lhP.offset + this.lhP.size);
                        e(byteBuffer, this.lhP);
                    }
                    this.lhN.releaseOutputBuffer(this.lhV, false);
                    if ((this.lhP.flags & 4) != 0) {
                        if (z) {
                            x.w("MicroMsg.MMSightAACMediaCodecRecorder", "do stop audio encoder");
                            this.lhN.stop();
                            this.lhN.release();
                            this.lhN = null;
                            return;
                        }
                        x.w("MicroMsg.MMSightAACMediaCodecRecorder", "reached end of stream unexpectedly");
                        return;
                    }
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightAACMediaCodecRecorder", "drainEncoder error: %s", new Object[]{e.getMessage()});
        }
    }

    protected void e(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.lhZ != null && (bufferInfo.flags & 4) == 0) {
            this.lhZ.f(byteBuffer, bufferInfo);
        }
    }

    protected boolean bex() {
        return false;
    }
}
