package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.media.Image;
import android.media.Image.Plane;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

@TargetApi(21)
public final class j extends i {
    public static String TAG = "MicroMsg.MediaCodecTranscodeDecoder21";

    public j(MediaExtractor mediaExtractor, MediaFormat mediaFormat, int i) {
        super(mediaExtractor, mediaFormat, i);
        x.i(TAG, "init ");
    }

    protected final int a(MediaCodecInfo mediaCodecInfo, String str) {
        x.i(TAG, "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[]{str, mediaCodecInfo});
        long VG = bi.VG();
        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        x.i(TAG, "getCapabilitiesForType used %sms", new Object[]{Long.valueOf(bi.bI(VG))});
        x.i(TAG, "color format length: %s", new Object[]{Integer.valueOf(capabilitiesForType.colorFormats.length)});
        int i = 0;
        for (int i2 : capabilitiesForType.colorFormats) {
            x.i(TAG, "capabilities colorFormat: %s", new Object[]{Integer.valueOf(i2)});
            if (sW(i2) && (i2 > i || i2 == 2135033992)) {
                i = i2;
            }
        }
        x.i(TAG, "codec: %s, colorFormat: %s", new Object[]{mediaCodecInfo.getName(), Integer.valueOf(i)});
        return i;
    }

    protected final boolean sW(int i) {
        switch (i) {
            case 2135033992:
                return true;
            default:
                return false;
        }
    }

    protected final boolean beX() {
        if (this.ldq == null) {
            x.e(TAG, "drainDecoder, decoder is null");
            return true;
        }
        int dequeueOutputBuffer = this.ldq.dequeueOutputBuffer(this.ljD, 60000);
        x.i(TAG, "outputBufferIndex-->" + dequeueOutputBuffer);
        while (dequeueOutputBuffer != -1) {
            if (dequeueOutputBuffer == -3) {
                x.i(TAG, "decoder output buffers changed");
            } else if (dequeueOutputBuffer == -2) {
                this.lll = this.ldq.getOutputFormat();
                x.i(TAG, "decoder output format changed: " + this.lll);
            } else if (dequeueOutputBuffer < 0) {
                x.w(TAG, "unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                x.v(TAG, "perform decoding");
                long VG = bi.VG();
                byte[] a = a(this.ldq.getOutputImage(dequeueOutputBuffer));
                x.v(TAG, "perform decoding costImage %s", new Object[]{Long.valueOf(bi.bI(VG))});
                if (a == null) {
                    break;
                } else if (a.length != 0) {
                    BufferInfo bufferInfo = this.ljD;
                    if (a == null) {
                        x.e(TAG, "processDecodeOutputBuffer error! byteBuffer is null");
                    } else {
                        x.i(TAG, "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d", new Object[]{a, bufferInfo, Integer.valueOf(bufferInfo.size)});
                        this.lll = this.ldq.getOutputFormat();
                        if (this.lkS != null) {
                            this.lkS.aB(a);
                        }
                    }
                    this.ldq.releaseOutputBuffer(dequeueOutputBuffer, false);
                    long j = this.ljD.presentationTimeUs;
                    if (this.lkn != 1 && j >= this.lkn * 1000) {
                        x.e(TAG, "exceed endTimeMs");
                        return true;
                    } else if ((this.ljD.flags & 4) == 0) {
                        return false;
                    } else {
                        x.i(TAG, "receive end of stream");
                        try {
                            this.ldq.stop();
                            this.ldq.release();
                            this.ldq = null;
                            return true;
                        } catch (Exception e) {
                            x.e(TAG, "stop and release decoder error: %s", new Object[]{e.getMessage()});
                            return true;
                        }
                    }
                } else {
                    this.ldq.releaseOutputBuffer(dequeueOutputBuffer, false);
                }
            }
            dequeueOutputBuffer = this.ldq.dequeueOutputBuffer(this.ljD, 60000);
            if (dequeueOutputBuffer < 0) {
                break;
            }
        }
        x.i(TAG, "no output from decoder available, break");
        return false;
    }

    public final int beL() {
        return 2;
    }

    private static byte[] a(Image image) {
        int i;
        int format = image.getFormat();
        int width = image.getWidth();
        int height = image.getHeight();
        int i2 = 0;
        Plane[] planes = image.getPlanes();
        x.i(TAG, "planes len %d, datalen: %s width %d height %d format %d", new Object[]{Integer.valueOf(planes.length), Integer.valueOf(((width * height) * ImageFormat.getBitsPerPixel(format)) / 8), Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(format)});
        byte[] i3 = com.tencent.mm.plugin.mmsight.model.a.j.lin.i(Integer.valueOf(i));
        format = 0;
        while (true) {
            i = format;
            if (i >= planes.length) {
                return i3;
            }
            ByteBuffer buffer = planes[i].getBuffer();
            int rowStride = planes[i].getRowStride();
            int pixelStride = planes[i].getPixelStride();
            int i4 = i == 0 ? width : width / 2;
            format = i == 0 ? height : height / 2;
            x.v(TAG, "row planes rowStride %d w %d h %d pixelStride %d", new Object[]{Integer.valueOf(rowStride), Integer.valueOf(i4), Integer.valueOf(format), Integer.valueOf(pixelStride)});
            byte[] i5 = com.tencent.mm.plugin.mmsight.model.a.j.lin.i(Integer.valueOf(rowStride));
            for (int i6 = 0; i6 < format; i6++) {
                int bitsPerPixel = ImageFormat.getBitsPerPixel(35) / 8;
                if (pixelStride == bitsPerPixel) {
                    bitsPerPixel *= i4;
                    buffer.get(i3, i2, bitsPerPixel);
                    if (format - i6 != 1) {
                        buffer.position((buffer.position() + rowStride) - bitsPerPixel);
                    }
                    i2 += bitsPerPixel;
                } else {
                    if (format - i6 == 1) {
                        buffer.get(i5, 0, (width - pixelStride) + 1);
                    } else {
                        buffer.get(i5, 0, rowStride);
                    }
                    bitsPerPixel = 0;
                    while (bitsPerPixel < i4) {
                        int i7 = i2 + 1;
                        i3[i2] = i5[bitsPerPixel * pixelStride];
                        bitsPerPixel++;
                        i2 = i7;
                    }
                }
            }
            com.tencent.mm.plugin.mmsight.model.a.j.lin.F(i5);
            format = i + 1;
        }
    }
}
