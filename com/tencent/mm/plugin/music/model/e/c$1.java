package com.tencent.mm.plugin.music.model.e;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import java.nio.ByteBuffer;

class c$1 implements Runnable {
    final /* synthetic */ c lzx;

    c$1(c cVar) {
        this.lzx = cVar;
    }

    public final void run() {
        x.i("MicroMsg.Music.MMPlayer", "starting...");
        Process.setThreadPriority(-19);
        if (bi.oW(this.lzx.lzu)) {
            x.e("MicroMsg.Music.MMPlayer", "source path is null");
            this.lzx.gP(false);
            return;
        }
        this.lzx.ldo = new MediaExtractor();
        try {
            this.lzx.ldo.setDataSource(this.lzx.lzu);
            MediaFormat mediaFormat = null;
            try {
                int readSampleData;
                MediaFormat trackFormat;
                x.e("MicroMsg.Music.MMPlayer", "tractCount is %d", new Object[]{Integer.valueOf(this.lzx.ldo.getTrackCount())});
                for (int i = 0; i < readSampleData; i++) {
                    trackFormat = this.lzx.ldo.getTrackFormat(i);
                    this.lzx.ldm = trackFormat.getString("mime");
                    if (!bi.oW(this.lzx.ldm) && this.lzx.ldm.startsWith("audio/")) {
                        mediaFormat = trackFormat;
                        break;
                    }
                }
                if (mediaFormat == null) {
                    x.e("MicroMsg.Music.MMPlayer", "format is null");
                    this.lzx.dAa = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_WRITE_FILE_FAILED;
                    this.lzx.gP(true);
                    c.a(this.lzx);
                    return;
                }
                x.i("MicroMsg.Music.MMPlayer", "format:%s", new Object[]{mediaFormat});
                this.lzx.sampleRate = mediaFormat.getInteger("sample-rate");
                this.lzx.channels = mediaFormat.getInteger("channel-count");
                this.lzx.duration = mediaFormat.getLong("durationUs");
                try {
                    this.lzx.apD = MediaCodec.createDecoderByType(this.lzx.ldm);
                    this.lzx.apD.configure(mediaFormat, null, null, 0);
                    this.lzx.apD.start();
                    ByteBuffer[] inputBuffers = this.lzx.apD.getInputBuffers();
                    ByteBuffer[] outputBuffers = this.lzx.apD.getOutputBuffers();
                    x.i("MicroMsg.Music.MMPlayer", "Track info: extractorFormat: %s mime: %s sampleRate: %s channels: %s duration: %s", new Object[]{mediaFormat, this.lzx.ldm, Integer.valueOf(this.lzx.sampleRate), Integer.valueOf(this.lzx.channels), Long.valueOf(this.lzx.duration)});
                    this.lzx.ldo.selectTrack(0);
                    BufferInfo bufferInfo = new BufferInfo();
                    Object obj = null;
                    Object obj2 = null;
                    int i2 = 0;
                    this.lzx.lAa.lAe = 3;
                    this.lzx.onStart();
                    ByteBuffer[] byteBufferArr = outputBuffers;
                    loop1:
                    while (obj2 == null && i2 < 50) {
                        try {
                            this.lzx.bix();
                            if (!this.lzx.bit()) {
                                break loop1;
                            }
                            int dequeueInputBuffer;
                            i2++;
                            if (obj == null) {
                                dequeueInputBuffer = this.lzx.apD.dequeueInputBuffer(1000);
                                if (dequeueInputBuffer >= 0) {
                                    Object obj3;
                                    readSampleData = this.lzx.ldo.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                                    if (readSampleData < 0) {
                                        x.e("MicroMsg.Music.MMPlayer", "saw input EOS. Stopping playback");
                                        obj3 = 1;
                                        readSampleData = 0;
                                    } else {
                                        this.lzx.presentationTimeUs = this.lzx.ldo.getSampleTime();
                                        this.lzx.tK(this.lzx.duration == 0 ? 0 : (int) ((100 * this.lzx.presentationTimeUs) / this.lzx.duration));
                                        obj3 = obj;
                                    }
                                    this.lzx.apD.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.lzx.presentationTimeUs, obj3 != null ? 4 : 0);
                                    if (obj3 == null) {
                                        this.lzx.ldo.advance();
                                    }
                                    obj = obj3;
                                } else {
                                    x.e("MicroMsg.Music.MMPlayer", "inputBufIndex " + dequeueInputBuffer);
                                }
                            }
                            readSampleData = this.lzx.apD.dequeueOutputBuffer(bufferInfo, 1000);
                            if (readSampleData >= 0) {
                                Object obj4;
                                if (bufferInfo.size > 0) {
                                    dequeueInputBuffer = 0;
                                } else {
                                    dequeueInputBuffer = i2;
                                }
                                ByteBuffer byteBuffer = byteBufferArr[readSampleData];
                                byte[] bArr = new byte[bufferInfo.size];
                                byteBuffer.get(bArr);
                                byteBuffer.clear();
                                if (bArr.length > 0) {
                                    if (this.lzx.aga == null) {
                                        if (this.lzx.createAudioTrack()) {
                                            this.lzx.aga.play();
                                        } else {
                                            x.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
                                            this.lzx.dAa = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SET_RANGE_FAILED;
                                            this.lzx.gP(true);
                                            return;
                                        }
                                    }
                                    this.lzx.aga.write(bArr, 0, bArr.length);
                                    this.lzx.lzv = true;
                                }
                                this.lzx.apD.releaseOutputBuffer(readSampleData, false);
                                if ((bufferInfo.flags & 4) != 0) {
                                    x.e("MicroMsg.Music.MMPlayer", "saw output EOS.");
                                    obj4 = 1;
                                } else {
                                    obj4 = obj2;
                                }
                                i2 = dequeueInputBuffer;
                                obj2 = obj4;
                            } else if (readSampleData == -3) {
                                outputBuffers = this.lzx.apD.getOutputBuffers();
                                x.i("MicroMsg.Music.MMPlayer", "output buffers have changed.");
                                byteBufferArr = outputBuffers;
                            } else if (readSampleData == -2) {
                                trackFormat = this.lzx.apD.getOutputFormat();
                                x.i("MicroMsg.Music.MMPlayer", "output format has changed to " + trackFormat);
                                this.lzx.sampleRate = trackFormat.getInteger("sample-rate");
                                this.lzx.channels = trackFormat.getInteger("channel-count");
                                c.c(this.lzx);
                            } else {
                                x.i("MicroMsg.Music.MMPlayer", "dequeueOutputBuffer returned " + readSampleData);
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "error", new Object[0]);
                            this.lzx.dAa = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RANGE_NOT_MATCH;
                            this.lzx.gP(true);
                        } finally {
                            c.a(this.lzx);
                            c.b(this.lzx);
                            c.c(this.lzx);
                            this.lzx.lzu = null;
                            this.lzx.ldm = null;
                            this.lzx.sampleRate = 0;
                            this.lzx.channels = 0;
                            this.lzx.presentationTimeUs = 0;
                            this.lzx.duration = 0;
                        }
                    }
                    boolean z = (this.lzx.duration / 1000) - (this.lzx.presentationTimeUs / 1000) < 2000;
                    if (i2 >= 50) {
                        x.e("MicroMsg.Music.MMPlayer", "onError, noOutputCounter:%d", new Object[]{Integer.valueOf(i2)});
                        this.lzx.dAa = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_RANGE_NOT_MATCH;
                        this.lzx.gP(true);
                    } else {
                        x.i("MicroMsg.Music.MMPlayer", "onStop, isComplete:%b", new Object[]{Boolean.valueOf(z)});
                        this.lzx.gQ(z);
                    }
                    c.a(this.lzx);
                    c.b(this.lzx);
                    c.c(this.lzx);
                    this.lzx.lzu = null;
                    this.lzx.ldm = null;
                    this.lzx.sampleRate = 0;
                    this.lzx.channels = 0;
                    this.lzx.presentationTimeUs = 0;
                    this.lzx.duration = 0;
                    x.i("MicroMsg.Music.MMPlayer", "stopping...");
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.Music.MMPlayer", e2, "createDecoderByType", new Object[0]);
                    this.lzx.dAa = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_PARSER_CONTENT_FAILED;
                    this.lzx.gP(true);
                    c.a(this.lzx);
                    c.b(this.lzx);
                }
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.Music.MMPlayer", e22, "get media format from media extractor", new Object[0]);
                this.lzx.dAa = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_TOTAL_SIZE_NOT_SAME;
            }
        } catch (Throwable e222) {
            x.printErrStackTrace("MicroMsg.Music.MMPlayer", e222, "set extractor data source", new Object[0]);
            this.lzx.dAa = TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_HTTP_LOCATION_HEADER_IS_NULL;
            this.lzx.gP(true);
        }
    }
}
