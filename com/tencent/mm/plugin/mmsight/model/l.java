package com.tencent.mm.plugin.mmsight.model;

import android.media.MediaMetadataRetriever;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class l {
    public static boolean a(String str, VideoTransPara videoTransPara, aso aso, d dVar) {
        try {
            if (bi.oW(str) || videoTransPara == null) {
                return false;
            }
            if (aso == null) {
                aso = new aso();
            }
            x.i("MicroMsg.SightSendVideoLogic", "check localCaptureVideo %s videoPath %s videoParams %s, finishPreSendProcess: %s", new Object[]{Boolean.valueOf(aso.rUP), str, videoTransPara, Boolean.valueOf(aso.rUT)});
            if (aso.rUT) {
                x.i("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing, already finish preSendProcess, videoPath: %s", new Object[]{str});
                return false;
            } else if (!aso.rUP || bi.oW(str)) {
                return false;
            } else {
                SightVideoJNI.tagMP4Dscp(str, d.NP().getWeixinMeta());
                if (!bi.oW(aso.rUS)) {
                    SightVideoJNI.tagMp4RecordInfo(str, aso.rUS);
                }
                long VG = bi.VG();
                SightVideoJNI.optimizeMP4(str);
                x.i("MicroMsg.SightSendVideoLogic", "optimizeMP4 used %sms", new Object[]{Long.valueOf(bi.bI(VG))});
                dVar.bcM();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str);
                int i = bi.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i2 = bi.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                int i3 = bi.getInt(mediaMetadataRetriever.extractMetadata(20), 0);
                mediaMetadataRetriever.release();
                x.i("MicroMsg.SightSendVideoLogic", "videopath %d %d %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                x.i("MicroMsg.SightSendVideoLogic", "videoParams %s %s %s", new Object[]{Integer.valueOf(videoTransPara.width), Integer.valueOf(videoTransPara.height), Integer.valueOf(videoTransPara.videoBitrate)});
                int min = Math.min(i, i2);
                boolean z = q.deT.dfl == 1;
                boolean z2 = bi.getInt(((a) g.l(a.class)).AT().getValue("MMSightCheckSendVideoBitrate"), 0) == 1;
                float f = bi.getFloat(((a) g.l(a.class)).AT().getValue("MMSightCheckSendVideoBitrateLimit"), 1.3f);
                x.i("MicroMsg.SightSendVideoLogic", "deviceConfigCheckBitrate: %s, serverConfigCheckBitrate: %s, bitrateLimitRatio: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Float.valueOf(f)});
                Object obj = (z || z2) ? 1 : null;
                if (min > videoTransPara.width && ((min <= videoTransPara.width || min % 16 != 0 || Math.abs(min - videoTransPara.width) >= 16) && (obj == null || ((float) i3) < ((float) videoTransPara.videoBitrate) * f))) {
                    return true;
                }
                if (aso.rUO) {
                    return true;
                }
                if (obj == null || ((float) i3) < ((float) videoTransPara.videoBitrate) * f) {
                    aso.rUT = true;
                    return false;
                }
                x.i("MicroMsg.SightSendVideoLogic", "exceed video bitrate, need remux video");
                h.mEJ.a(440, 205, 1, false);
                return true;
            }
        } catch (Exception e) {
            x.e("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing error: %s %s", new Object[]{e.getMessage(), str});
            if (aso != null) {
                aso.rUT = true;
            }
            return false;
        }
    }

    public static int b(String str, VideoTransPara videoTransPara, aso aso, d dVar) {
        if (aso == null || !aso.rUP || !FileOp.cn(str)) {
            return -1;
        }
        if (aso.rUT) {
            x.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, already finish preSendProcess, videoPath: %s", new Object[]{str});
        }
        try {
            String str2;
            String substring;
            int i;
            String mK = FileOp.mK(str);
            if (mK.endsWith("/")) {
                str2 = mK;
            } else {
                str2 = mK + "/";
            }
            mK = new File(str).getName();
            int lastIndexOf = mK.lastIndexOf(46);
            if (lastIndexOf > 0) {
                substring = mK.substring(0, lastIndexOf);
            } else {
                substring = mK;
            }
            mK = str2 + substring + "_hd";
            if (str.endsWith(".mp4")) {
                mK = mK + ".mp4";
            }
            String str3 = str2 + substring + "tempRemuxing.mp4";
            FileOp.y(str, mK);
            x.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, dir: %s, oldFileName: %s, hdFilePath: %s, remuxingOutputFile: %s extInfotrycount %d", new Object[]{str2, substring, mK, str3, Integer.valueOf(aso.rUQ)});
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(mK);
            int i2 = bi.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            int i3 = bi.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
            int min = Math.min(i2, i3);
            if (min <= videoTransPara.width || (min > videoTransPara.width && min % 16 == 0 && Math.abs(min - videoTransPara.width) < 16)) {
                i = i3;
                min = i2;
            } else {
                if (i2 < i3) {
                    min = videoTransPara.width;
                    i = (int) (((double) i3) / ((1.0d * ((double) i2)) / ((double) min)));
                } else {
                    i = videoTransPara.width;
                    min = (int) (((double) i2) / ((1.0d * ((double) i3)) / ((double) i)));
                }
                if (i % 2 != 0) {
                    i++;
                }
                if (min % 2 != 0) {
                    min++;
                }
            }
            x.i("MicroMsg.SightSendVideoLogic", "start remuxing %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s videoParams: %s", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(min), Integer.valueOf(i), videoTransPara});
            long VG = bi.VG();
            x.i("MicroMsg.SightSendVideoLogic", "doremuxing finish %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s duration: %s, used %sms", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(min), Integer.valueOf(i), Integer.valueOf(SightVideoJNI.remuxing(mK, str3, min, i, videoTransPara.videoBitrate, videoTransPara.dQI, 8, videoTransPara.dQH, 25.0f, 30.0f, null, 0, false)), Long.valueOf(bi.bI(VG))});
            FileOp.av(str3, str);
            long VG2 = bi.VG();
            if (aso.rUP) {
                SightVideoJNI.tagMP4Dscp(str, d.NP().getWeixinMeta());
                if (!bi.oW(aso.rUS)) {
                    SightVideoJNI.tagMp4RecordInfo(str, aso.rUS);
                }
                SightVideoJNI.optimizeMP4(str);
            }
            dVar.bcM();
            x.i("MicroMsg.SightSendVideoLogic", "tagMP4Dscp used %sms", new Object[]{Long.valueOf(bi.bI(VG2))});
            return r2;
        } catch (Exception e) {
            x.e("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg error: %s", new Object[]{e.getMessage()});
            return -1;
        }
    }
}
