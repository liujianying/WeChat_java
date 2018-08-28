package com.tencent.mm.plugin.appbrand.media.record.a;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.mm.plugin.appbrand.media.encode.M4aAudioFormatJni;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

public final class a extends b {
    int giR = 2;
    private MediaCodec giS;
    BufferInfo giT;
    private final int giU = 100;
    private String mFilePath = "";

    public final boolean e(String str, int i, int i2, int i3) {
        boolean z;
        x.i("MicroMsg.Record.AACAudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mFilePath = str;
        try {
            x.i("MicroMsg.Record.AACAudioEncoder", "initCodec");
            this.giT = new BufferInfo();
            MediaFormat createAudioFormat = MediaFormat.createAudioFormat(this.giV, i, i2);
            createAudioFormat.setInteger("bitrate", i3);
            createAudioFormat.setInteger("aac-profile", this.giR);
            this.giS = MediaCodec.createEncoderByType(this.giV);
            this.giS.configure(createAudioFormat, null, null, 1);
            this.giS.start();
            x.i("MicroMsg.Record.AACAudioEncoder", "encoder start to work");
            z = false;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Record.AACAudioEncoder", e, "initCodec", new Object[0]);
            z = true;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Record.AACAudioEncoder", e2, "initCodec", new Object[0]);
            z = true;
        }
        if (z) {
            x.i("MicroMsg.Record.AACAudioEncoder", "initCodec  fail,");
            h.li(21);
            return false;
        }
        x.i("MicroMsg.Record.AACAudioEncoder", "initCodec ok");
        if (M4aAudioFormatJni.createM4aFile(str, i2, i, this.giR) == 0) {
            x.i("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api ok,");
            return true;
        }
        x.i("MicroMsg.Record.AACAudioEncoder", "createM4aFile m4a jni api fail,");
        h.li(22);
        return false;
    }

    public final boolean a(boolean z, byte[] bArr, int i) {
        if (bArr == null) {
            x.e("MicroMsg.Record.AACAudioEncoder", "pcm is null");
            return false;
        } else if (this.giS != null) {
            x.i("MicroMsg.Record.AACAudioEncoder", "encodePCMToAAC endOfStream:%b", new Object[]{Boolean.valueOf(z)});
            ByteBuffer[] inputBuffers = this.giS.getInputBuffers();
            ByteBuffer[] outputBuffers = this.giS.getOutputBuffers();
            int dequeueInputBuffer = this.giS.dequeueInputBuffer(100);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(bArr);
                byteBuffer.position(0);
                byteBuffer.limit(bArr.length);
                x.i("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex:%d, data length:%d", new Object[]{Integer.valueOf(dequeueInputBuffer), Integer.valueOf(bArr.length)});
                if (z) {
                    this.giS.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, System.nanoTime(), 4);
                    inputBuffers = outputBuffers;
                } else {
                    this.giS.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, System.nanoTime(), 0);
                    inputBuffers = outputBuffers;
                }
            } else {
                x.e("MicroMsg.Record.AACAudioEncoder", "inputBufferIndex %d", new Object[]{Integer.valueOf(dequeueInputBuffer)});
                inputBuffers = outputBuffers;
            }
            while (true) {
                dequeueInputBuffer = this.giS.dequeueOutputBuffer(this.giT, 100);
                if (dequeueInputBuffer == -1) {
                    x.d("MicroMsg.Record.AACAudioEncoder", "no output available, break");
                    break;
                } else if (dequeueInputBuffer == -3) {
                    x.e("MicroMsg.Record.AACAudioEncoder", "output buff change");
                    inputBuffers = this.giS.getOutputBuffers();
                } else if (dequeueInputBuffer == -2) {
                    x.e("MicroMsg.Record.AACAudioEncoder", "encoder output format changed: " + this.giS.getOutputFormat());
                } else if (dequeueInputBuffer < 0) {
                    x.e("MicroMsg.Record.AACAudioEncoder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[]{Integer.valueOf(dequeueInputBuffer)});
                } else {
                    x.i("MicroMsg.Record.AACAudioEncoder", "outputBufferIndex %d", new Object[]{Integer.valueOf(dequeueInputBuffer)});
                    ByteBuffer byteBuffer2 = inputBuffers[dequeueInputBuffer];
                    if (byteBuffer2 == null) {
                        throw new RuntimeException("outputBuffer " + dequeueInputBuffer + " was null");
                    }
                    if ((this.giT.flags & 2) != 0) {
                        x.e("MicroMsg.Record.AACAudioEncoder", "flags is BUFFER_FLAG_CODEC_CONFIG, don't writ data into file");
                    } else {
                        int i2 = this.giT.size;
                        byte[] bArr2 = new byte[i2];
                        byteBuffer2.get(bArr2, 0, i2);
                        int writeAudioBuff = M4aAudioFormatJni.writeAudioBuff(bArr2, i2);
                        d(bArr2, i2, false);
                        if (writeAudioBuff == 0) {
                            x.i("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff ok,");
                        } else {
                            x.i("MicroMsg.Record.AACAudioEncoder", "writeAudioBuff buff fail,");
                        }
                    }
                    this.giS.releaseOutputBuffer(dequeueInputBuffer, false);
                    if ((this.giT.flags & 4) != 0) {
                        if (z) {
                            x.e("MicroMsg.Record.AACAudioEncoder", "reach the end, and end to encode the data");
                        } else {
                            x.w("MicroMsg.Record.AACAudioEncoder", "reached end of stream unexpectedly");
                        }
                    }
                }
            }
            return true;
        } else {
            x.e("MicroMsg.Record.AACAudioEncoder", "mEncoder is null");
            return false;
        }
    }

    public final void flush() {
        x.i("MicroMsg.Record.AACAudioEncoder", "flush");
        d(new byte[0], 0, true);
    }

    public final void close() {
        x.i("MicroMsg.Record.AACAudioEncoder", "close");
        if (this.giS != null) {
            this.giS.stop();
            this.giS.release();
            this.giS = null;
        }
        M4aAudioFormatJni.closeM4aFile();
    }
}
