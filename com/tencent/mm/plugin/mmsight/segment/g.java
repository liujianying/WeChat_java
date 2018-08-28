package com.tencent.mm.plugin.mmsight.segment;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class g {
    private long aBL;
    String ldm = null;
    private MediaExtractor ldo;
    private long lkn;
    MediaCodec llj;
    MediaCodec llk;
    MediaFormat lll;
    MediaFormat llm;
    VideoTransPara lln;
    boolean llo = true;
    List<byte[]> llp = null;
    private boolean llq = false;
    private boolean llr = false;
    private byte[] lls;
    private HandlerThread llt = null;
    private ag llu = null;

    public g(MediaExtractor mediaExtractor, MediaFormat mediaFormat, long j, long j2, VideoTransPara videoTransPara) {
        this.ldo = mediaExtractor;
        this.lll = mediaFormat;
        this.aBL = j;
        this.lkn = j2;
        this.lln = videoTransPara;
        this.ldm = mediaFormat.getString("mime");
        this.llp = new ArrayList();
        x.i("MicroMsg.MediaCodecAACTranscoder", "create MediaCodecAACTranscoder, startTimeMs: %s, endTimeMs: %s, mime: %s, srcMediaFormat: %s, para: %s", new Object[]{Long.valueOf(j), Long.valueOf(j2), this.ldm, mediaFormat, videoTransPara});
    }

    public final void beT() {
        this.llq = false;
        this.llr = false;
        while (this.llj != null && this.ldo != null) {
            try {
                ByteBuffer[] inputBuffers = this.llj.getInputBuffers();
                int dequeueInputBuffer = this.llj.dequeueInputBuffer(20000);
                if (dequeueInputBuffer < 0) {
                    x.d("MicroMsg.MediaCodecAACTranscoder", "decoder no input buffer available, drain first");
                    beU();
                }
                if (dequeueInputBuffer >= 0) {
                    boolean z;
                    x.d("MicroMsg.MediaCodecAACTranscoder", "decoderInputBufferIndex: %d", new Object[]{Integer.valueOf(dequeueInputBuffer)});
                    ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                    byteBuffer.clear();
                    byteBuffer.position(0);
                    int readSampleData = this.ldo.readSampleData(byteBuffer, 0);
                    long sampleTime = this.ldo.getSampleTime();
                    this.ldo.advance();
                    x.d("MicroMsg.MediaCodecAACTranscoder", "sampleSize: %s, pts: %s", new Object[]{Integer.valueOf(readSampleData), Long.valueOf(sampleTime)});
                    if (sampleTime >= this.lkn * 1000 || sampleTime <= 0 || readSampleData <= 0) {
                        x.i("MicroMsg.MediaCodecAACTranscoder", "reach end time, send EOS and try delay stop decoder");
                        this.llr = true;
                        ah.i(new 1(this), 500);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.llj == null) {
                        return;
                    }
                    if (z) {
                        x.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
                        this.llj.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, 4);
                    } else {
                        this.llj.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, 0);
                    }
                }
                beU();
                if (this.llr && this.llk == null) {
                    return;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e, "startTranscodeBlockLoop error: %s", new Object[]{e.getMessage()});
                return;
            }
        }
        x.e("MicroMsg.MediaCodecAACTranscoder", "startTranscodeBlockLoop error");
    }

    private void beU() {
        if (this.llj != null) {
            try {
                ByteBuffer[] outputBuffers = this.llj.getOutputBuffers();
                BufferInfo bufferInfo = new BufferInfo();
                ByteBuffer[] byteBufferArr = outputBuffers;
                while (true) {
                    int dequeueOutputBuffer = this.llj.dequeueOutputBuffer(bufferInfo, 20000);
                    x.d("MicroMsg.MediaCodecAACTranscoder", "decoderOutputBufferIndex: %s", new Object[]{Integer.valueOf(dequeueOutputBuffer)});
                    if (dequeueOutputBuffer == -1) {
                        x.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
                        return;
                    } else if (dequeueOutputBuffer == -3) {
                        byteBufferArr = this.llj.getOutputBuffers();
                    } else if (dequeueOutputBuffer == -2) {
                        this.lll = this.llj.getOutputFormat();
                        x.i("MicroMsg.MediaCodecAACTranscoder", "srcMediaFormat change: %s", new Object[]{this.lll});
                    } else if (dequeueOutputBuffer < 0) {
                        x.e("MicroMsg.MediaCodecAACTranscoder", "unexpected decoderOutputBufferIndex: %s", new Object[]{Integer.valueOf(dequeueOutputBuffer)});
                    } else {
                        x.v("MicroMsg.MediaCodecAACTranscoder", "perform decoding");
                        ByteBuffer byteBuffer = byteBufferArr[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            x.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve decoderOutputBuffer is null!!");
                            return;
                        }
                        if ((bufferInfo.flags & 2) != 0) {
                            x.e("MicroMsg.MediaCodecAACTranscoder", "ignore BUFFER_FLAG_CODEC_CONFIG");
                            bufferInfo.size = 0;
                        }
                        if (bufferInfo.size > 0) {
                            byteBuffer.position(bufferInfo.offset);
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            a(byteBuffer, bufferInfo, (bufferInfo.flags & 4) != 0);
                        }
                        this.llj.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((bufferInfo.flags & 4) != 0) {
                            x.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
                            if (this.llj != null) {
                                this.llj.stop();
                                this.llj.release();
                                this.llj = null;
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e, "drainDecoder error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    private void a(ByteBuffer byteBuffer, BufferInfo bufferInfo, boolean z) {
        if (byteBuffer != null) {
            x.d("MicroMsg.MediaCodecAACTranscoder", "processDecodeBuffer, EOS: %s, finishGetAllInputAACData: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.llr)});
            if (this.llo) {
                if (!this.llq) {
                    beV();
                    this.llq = true;
                }
                if (this.lls == null) {
                    this.lls = new byte[byteBuffer.remaining()];
                    byteBuffer.get(this.lls, 0, byteBuffer.remaining());
                }
                a(this.lls, bufferInfo.presentationTimeUs, z);
                return;
            }
            Object obj = new byte[byteBuffer.remaining()];
            byteBuffer.get(obj, 0, byteBuffer.remaining());
            this.llp.add(obj);
            if (this.llr || z) {
                try {
                    this.llj.stop();
                    this.llj.release();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e, "", new Object[0]);
                }
                beV();
                this.llq = true;
                int i = 0;
                for (byte[] bArr : this.llp) {
                    boolean z2;
                    long j = bufferInfo.presentationTimeUs;
                    if (i >= this.llp.size() - 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    a(bArr, j, z2);
                    i++;
                }
            }
        }
    }

    private void beV() {
        if (this.llk == null || !this.llo || this.llq) {
            try {
                this.llm = new MediaFormat();
                this.llm.setString("mime", "audio/mp4a-latm");
                this.llm.setInteger("aac-profile", 2);
                this.llm.setInteger("sample-rate", this.lln.audioSampleRate);
                this.llm.setInteger("channel-count", 1);
                this.llm.setInteger("bitrate", this.lln.dQF);
                this.llm.setInteger("max-input-size", 16384);
                this.llk = MediaCodec.createEncoderByType(this.ldm);
                this.llk.configure(this.llm, null, null, 1);
                this.llk.start();
                x.i("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, create new encoder");
                return;
            } catch (Exception e) {
                x.e("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, error: %s", new Object[]{e.getMessage()});
                return;
            }
        }
        this.llj.start();
    }

    private void a(byte[] bArr, long j, boolean z) {
        if (this.llk != null && bArr != null) {
            ByteBuffer[] inputBuffers = this.llk.getInputBuffers();
            int dequeueInputBuffer = this.llk.dequeueInputBuffer(20000);
            if (dequeueInputBuffer < 0) {
                x.d("MicroMsg.MediaCodecAACTranscoder", "encoder no input buffer available, drain first");
                beF();
            }
            if (dequeueInputBuffer >= 0) {
                int i;
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.position(0);
                byteBuffer.put(bArr);
                if (z) {
                    x.i("MicroMsg.MediaCodecAACTranscoder", "last, send EOS and try delay stop encoder");
                    i = 1;
                    ah.i(new 2(this), 500);
                } else {
                    i = 0;
                }
                if (this.llk == null) {
                    return;
                }
                if (i != 0) {
                    x.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
                    this.llk.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 4);
                } else {
                    this.llk.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 0);
                }
            }
            beF();
        }
    }

    private void beF() {
        if (this.llk != null) {
            try {
                ByteBuffer[] outputBuffers = this.llk.getOutputBuffers();
                BufferInfo bufferInfo = new BufferInfo();
                while (true) {
                    int dequeueOutputBuffer = this.llk.dequeueOutputBuffer(bufferInfo, 20000);
                    x.d("MicroMsg.MediaCodecAACTranscoder", "encoderOutputBufferIndex: %s", new Object[]{Integer.valueOf(dequeueOutputBuffer)});
                    if (dequeueOutputBuffer == -1) {
                        x.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
                        return;
                    } else if (dequeueOutputBuffer == -3) {
                        outputBuffers = this.llk.getOutputBuffers();
                    } else if (dequeueOutputBuffer == -2) {
                        this.llm = this.llk.getOutputFormat();
                        x.i("MicroMsg.MediaCodecAACTranscoder", "dstMediaFormat change: %s", new Object[]{this.llm});
                    } else if (dequeueOutputBuffer < 0) {
                        x.e("MicroMsg.MediaCodecAACTranscoder", "unexpected encoderOutputBufferIndex: %s", new Object[]{Integer.valueOf(dequeueOutputBuffer)});
                    } else {
                        x.v("MicroMsg.MediaCodecAACTranscoder", "perform encoding");
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            x.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve encoderOutputBuffer is null!!");
                            return;
                        }
                        if (bufferInfo.size > 0) {
                            byteBuffer.position(bufferInfo.offset);
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            if (byteBuffer != null) {
                                MP4MuxerJNI.writeAACData(0, byteBuffer, bufferInfo.size);
                            }
                        }
                        this.llk.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((bufferInfo.flags & 4) != 0) {
                            x.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
                            if (this.llk != null) {
                                this.llk.stop();
                                this.llk.release();
                                this.llk = null;
                                return;
                            }
                            return;
                        }
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e, "drainEncoder error: %s", new Object[]{e.getMessage()});
            }
        }
    }
}
