package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.storage.aa.a;

public final class k {
    private static k lio = new k();
    public SightParams lip;

    public static k bey() {
        return lio;
    }

    public static d d(VideoTransPara videoTransPara) {
        switch (j.lgz.dfb) {
            case 1:
                return new l(videoTransPara);
            case 2:
                return new n(videoTransPara);
            default:
                return null;
        }
    }

    public static int bez() {
        return j.lgz.videoBitrate;
    }

    public static int beA() {
        return j.lgz.lfa;
    }

    public static boolean isDebug() {
        if (CaptureMMProxy.getInstance().getInt(a.sUA, 0) == 1) {
            return true;
        }
        return false;
    }

    public static String beB() {
        switch (j.lgz.dfb) {
            case 1:
                return "RECORDER_TYPE_FFMPEG";
            case 2:
                return "ENCODER_MEDIACODEC";
            default:
                return "";
        }
    }
}
