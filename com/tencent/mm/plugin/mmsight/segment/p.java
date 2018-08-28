package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.a.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@TargetApi(18)
public final class p extends a {
    private int lhM;
    private a lmT;
    private a lmU;

    public final void a(String str, String str2, VideoTransPara videoTransPara) {
        super.a(str, str2, videoTransPara);
    }

    public final int x(long j, long j2) {
        m.sX(h.beW());
        int x = super.x(j, j2);
        if (x == -1) {
            m.sY(h.beW());
        }
        return x;
    }

    protected final int a(MediaExtractor mediaExtractor, List<a> list, List<a> list2) {
        this.lmT = (a) list2.get(0);
        if (!(list == null || list.size() == 0)) {
            this.lmU = (a) list.get(0);
        }
        if (a(mediaExtractor, this.lkN <= 0 ? 1048576 : this.lkN, this.lhM, this.lkH) != -1) {
            return 0;
        }
        x.e("VideoClipperAPI18", "transcodeAndMux error");
        release();
        return -1;
    }

    private int a(MediaExtractor mediaExtractor, int i, int i2, String str) {
        Throwable e;
        x.i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(88) ");
        h hVar = null;
        try {
            h hVar2 = new h();
            try {
                int i3;
                hVar2.aBL = this.lkL;
                hVar2.lkn = this.lkM;
                VideoTransPara videoTransPara = this.lkP;
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "setVideoPara: %s", new Object[]{videoTransPara});
                hVar2.lln = videoTransPara;
                if (this.lkQ == 90 || this.lkQ == 270) {
                    hVar2.cR(videoTransPara.height, videoTransPara.width);
                } else {
                    hVar2.cR(videoTransPara.width, videoTransPara.height);
                }
                hVar2.lkm = str;
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "setSrcVideoRotate: %s", new Object[]{Integer.valueOf(this.lkQ)});
                hVar2.bYE = i3;
                x.i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(101) ");
                try {
                    x.i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(118) ");
                    mediaExtractor.selectTrack(this.lmT.index);
                    mediaExtractor.seekTo(this.lkL * 1000, 0);
                    try {
                        VideoTransPara videoTransPara2 = this.lkP;
                        this.lhM = MP4MuxerJNI.initDataBuf(videoTransPara2.duration > 0 ? videoTransPara2.duration : 10);
                        long VG = bi.VG();
                        i3 = this.lmT.index;
                        hVar2.llE = mediaExtractor;
                        hVar2.llF = i3;
                        if (hVar2.e(this.lmT.ljB) < 0) {
                            try {
                                MP4MuxerJNI.releaseDataBuf(this.lhM);
                                mediaExtractor.release();
                                j.lin.Fm();
                            } catch (Exception e2) {
                            }
                            throw new l("init decoder error");
                        }
                        int i4;
                        if (!bi.oW(hVar2.lkm)) {
                            String simpleMp4Info = SightVideoJNI.getSimpleMp4Info(hVar2.lkm);
                            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "src file: %s", new Object[]{simpleMp4Info});
                            if (!bi.oW(simpleMp4Info)) {
                                try {
                                    int i5 = (int) new JSONObject(simpleMp4Info).getDouble("videoFPS");
                                    double d = (hVar2.lln == null || hVar2.lln.fps <= 0) ? 30.0d : (double) hVar2.lln.fps;
                                    hVar2.lkp = (int) Math.ceil(((double) i5) / d);
                                    x.i("MicroMsg.MediaCodecFFMpegTranscoder", "frameDropInterval: %s, videoFPS: %s, targetFPS: %s", new Object[]{Integer.valueOf(hVar2.lkp), Integer.valueOf(i5), Double.valueOf(d)});
                                } catch (Throwable e3) {
                                    x.printErrStackTrace("MicroMsg.MediaCodecFFMpegTranscoder", e3, "calcFrameDropCount error: %s", new Object[]{e3.getMessage()});
                                }
                            }
                        }
                        hVar2.llG.sV(hVar2.lkp);
                        hVar2.llG.F(new h$1(hVar2));
                        VG = bi.bI(VG);
                        mediaExtractor.unselectTrack(this.lmT.index);
                        boolean z = false;
                        if (this.lmU != null) {
                            long VG2 = bi.VG();
                            z = a(mediaExtractor, i, i2);
                            x.i("VideoClipperAPI18", "process audio used %sms, compressAudio: %s", new Object[]{Long.valueOf(bi.bI(VG2)), Boolean.valueOf(z)});
                        }
                        long VG3 = bi.VG();
                        String beJ = beJ();
                        x.i("VideoClipperAPI18", "process video used %sms", new Object[]{Long.valueOf(VG)});
                        x.i("VideoClipperAPI18", "start muxing, tempPath: %s", new Object[]{beJ});
                        m.C(h.beW(), VG);
                        int i6 = 1;
                        int i7 = videoTransPara2.audioSampleRate;
                        int i8 = videoTransPara2.dQF;
                        if (!z) {
                            try {
                                i6 = this.lmU.ljB.getInteger("channel-count");
                                i7 = this.lmU.ljB.getInteger("sample-rate");
                                i8 = this.lmU.ljB.getInteger("bitrate");
                                i3 = i7;
                                i4 = i6;
                            } catch (Exception e4) {
                                x.e("VideoClipperAPI18", "get audio channel count error: %s", new Object[]{e4.getMessage()});
                            }
                            x.e("VideoClipperAPI18", "final muxing channel count: %s, aac sample rate: %s, aacBitRate: %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i8)});
                            if (MP4MuxerJNI.muxingForX264(i3, 1024, 2, i4, beJ, (float) videoTransPara2.fps, (int) (this.lkM - this.lkL), null, 0) >= 0) {
                                x.e("VideoClipperAPI18", "muxingForX264 failed! %d", new Object[]{Integer.valueOf(MP4MuxerJNI.muxingForX264(i3, 1024, 2, i4, beJ, (float) videoTransPara2.fps, (int) (this.lkM - this.lkL), null, 0))});
                                throw new l("muxingForX264 failed!");
                            }
                            if (this.lkQ > 0) {
                                SightVideoJNI.tagRotateVideo(beJ(), this.lkG, this.lkQ);
                            } else {
                                FileOp.av(beJ(), this.lkG);
                            }
                            x.i("VideoClipperAPI18", "mux and tagRotate used %sms", new Object[]{Long.valueOf(bi.bI(VG3))});
                            long VG4 = bi.VG();
                            SightVideoJNI.tagMP4Dscp(this.lkG, CaptureMMProxy.getInstance().getWeixinMeta());
                            x.i("VideoClipperAPI18", "tagMP4Dscp used %sms", new Object[]{Long.valueOf(bi.bI(VG4))});
                            try {
                                MP4MuxerJNI.releaseDataBuf(this.lhM);
                                mediaExtractor.release();
                                j.lin.Fm();
                            } catch (Exception e5) {
                            }
                            try {
                                hVar2.release();
                            } catch (Exception e6) {
                            }
                            return 0;
                        }
                        i3 = i7;
                        i4 = i6;
                        x.e("VideoClipperAPI18", "final muxing channel count: %s, aac sample rate: %s, aacBitRate: %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i8)});
                        if (MP4MuxerJNI.muxingForX264(i3, 1024, 2, i4, beJ, (float) videoTransPara2.fps, (int) (this.lkM - this.lkL), null, 0) >= 0) {
                            if (this.lkQ > 0) {
                                SightVideoJNI.tagRotateVideo(beJ(), this.lkG, this.lkQ);
                            } else {
                                FileOp.av(beJ(), this.lkG);
                            }
                            x.i("VideoClipperAPI18", "mux and tagRotate used %sms", new Object[]{Long.valueOf(bi.bI(VG3))});
                            long VG42 = bi.VG();
                            SightVideoJNI.tagMP4Dscp(this.lkG, CaptureMMProxy.getInstance().getWeixinMeta());
                            x.i("VideoClipperAPI18", "tagMP4Dscp used %sms", new Object[]{Long.valueOf(bi.bI(VG42))});
                            try {
                                MP4MuxerJNI.releaseDataBuf(this.lhM);
                                mediaExtractor.release();
                                j.lin.Fm();
                            } catch (Exception e52) {
                            }
                            try {
                                hVar2.release();
                            } catch (Exception e62) {
                            }
                            return 0;
                        }
                        x.e("VideoClipperAPI18", "muxingForX264 failed! %d", new Object[]{Integer.valueOf(MP4MuxerJNI.muxingForX264(i3, 1024, 2, i4, beJ, (float) videoTransPara2.fps, (int) (this.lkM - this.lkL), null, 0))});
                        throw new l("muxingForX264 failed!");
                    } catch (Throwable e32) {
                        x.w("VideoClipperAPI18", "The source video file is malformed %s", new Object[]{e32.getMessage()});
                        throw new RuntimeException(e32);
                    } catch (Throwable th) {
                        try {
                            MP4MuxerJNI.releaseDataBuf(this.lhM);
                            mediaExtractor.release();
                            j.lin.Fm();
                        } catch (Exception e7) {
                        }
                    }
                } catch (Throwable e322) {
                    try {
                        x.printErrStackTrace("VideoClipperAPI18", e322, "Transcode and mux failed %s", new Object[]{e322.getMessage()});
                        return -1;
                    } finally {
                        try {
                            hVar2.release();
                        } catch (Exception e8) {
                        }
                    }
                }
            } catch (Exception e9) {
                e322 = e9;
                hVar = hVar2;
            }
        } catch (Exception e10) {
            e322 = e10;
            x.printErrStackTrace("VideoClipperAPI18", e322, "trascodeAndMux error", new Object[0]);
            if (hVar != null) {
                hVar.release();
            }
            return -1;
        }
    }

    private boolean a(MediaExtractor mediaExtractor, int i, int i2) {
        if (this.lmU == null) {
            return false;
        }
        mediaExtractor.selectTrack(this.lmU.index);
        mediaExtractor.seekTo(this.lkL * 1000, 0);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
        try {
            this.lmU.ljB.getInteger("channel-count");
        } catch (Exception e) {
            x.e("VideoClipperAPI18", "get channel count error: %s", new Object[]{Integer.valueOf(1)});
        }
        x.i("VideoClipperAPI18", "audio channel count");
        if (CaptureMMProxy.getInstance().getInt(aa.a.sUJ, 0) == 1) {
            g gVar = new g(mediaExtractor, this.lmU.ljB, this.lkL, this.lkM, this.lkP);
            gVar.llo = true;
            try {
                gVar.llj = MediaCodec.createDecoderByType(gVar.ldm);
                gVar.llj.configure(gVar.lll, null, null, 0);
                gVar.llj.start();
                gVar.lll = gVar.llj.getOutputFormat();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e2, "init decoder error: %s", new Object[]{e2.getMessage()});
            }
            try {
                gVar.llm = new MediaFormat();
                gVar.llm.setString("mime", "audio/mp4a-latm");
                gVar.llm.setInteger("aac-profile", 2);
                gVar.llm.setInteger("sample-rate", gVar.lln.audioSampleRate);
                gVar.llm.setInteger("channel-count", 1);
                gVar.llm.setInteger("bitrate", gVar.lln.dQF);
                gVar.llm.setInteger("max-input-size", 16384);
                gVar.llk = MediaCodec.createEncoderByType(gVar.ldm);
                gVar.llk.configure(gVar.llm, null, null, 1);
                gVar.llj.start();
            } catch (Exception e3) {
                x.e("MicroMsg.MediaCodecAACTranscoder", "init encoder error: %s", new Object[]{e3.getMessage()});
                gVar.llo = false;
                gVar.llp = new ArrayList();
                gVar.llk.release();
                gVar.llk = null;
            }
            x.i("MicroMsg.MediaCodecAACTranscoder", "init finish, canEncodeDecodeBothExist: %s", new Object[]{Boolean.valueOf(gVar.llo)});
            gVar.beT();
            return true;
        }
        while (true) {
            allocateDirect.clear();
            int readSampleData = mediaExtractor.readSampleData(allocateDirect, 0);
            x.d("VideoClipperAPI18", "sampleSize: %d", new Object[]{Integer.valueOf(readSampleData)});
            if (readSampleData <= 0) {
                x.i("VideoClipperAPI18", "VideoClipperAPI18.muxAudio size = %d. Saw eos.", new Object[]{Integer.valueOf(readSampleData)});
                break;
            } else if (mediaExtractor.getSampleTime() >= this.lkM * 1000) {
                break;
            } else if (mediaExtractor.getSampleTrackIndex() != this.lmU.index) {
                x.e("VideoClipperAPI18", "track index not match! break");
                break;
            } else {
                allocateDirect.position(0);
                MP4MuxerJNI.writeAACData(i2, allocateDirect, readSampleData);
                mediaExtractor.advance();
            }
        }
        return false;
    }

    public final int Ht(String str) {
        Throwable th;
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                String extractMetadata;
                mediaMetadataRetriever.setDataSource(str);
                if (d.fR(17)) {
                    extractMetadata = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    extractMetadata = SightVideoJNI.getMp4Rotate(str);
                }
                x.d("VideoClipperAPI18", "findRotationMessage sDegree = " + extractMetadata);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(18);
                x.d("VideoClipperAPI18", "findRotationMessage sHeight = " + extractMetadata2);
                x.d("VideoClipperAPI18", "findRotationMessage sWidth = " + extractMetadata3);
                int i = bi.getInt(extractMetadata, 0);
                mediaMetadataRetriever.release();
                return i;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
    }
}
