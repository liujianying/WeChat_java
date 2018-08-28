package com.tencent.mm.modelsns;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.sdk.platformtools.x;

public class a$a {
    public String egA;
    public String egB;
    public String egC;
    public int egD = -1;
    public int egE = -1;
    public int videoBitRate = -1;
    public int videoFrameRate = -1;
    public int videoHeight = -1;
    public int videoWidth = -1;

    public static a$a na(String str) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        a$a a_a = new a$a();
        a_a.egA = str;
        try {
            mediaExtractor.setDataSource(str);
            int trackCount = mediaExtractor.getTrackCount();
            MediaFormat mediaFormat = null;
            MediaFormat mediaFormat2 = null;
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                if (trackFormat.containsKey("mime")) {
                    String string = trackFormat.getString("mime");
                    x.i("MicroMsg.ShareSnsImpl", "find video mime : %s", new Object[]{string});
                    if (string != null) {
                        if (string.startsWith("video/")) {
                            if (mediaFormat2 == null) {
                                mediaFormat2 = trackFormat;
                            }
                        } else if (string.startsWith("audio/") && r0 == null) {
                            mediaFormat = trackFormat;
                        }
                        if (!(mediaFormat == null || r1 == null)) {
                            break;
                        }
                    }
                    continue;
                } else {
                    x.i("MicroMsg.ShareSnsImpl", "find video mime : not found.");
                }
            }
            MediaFormat mediaFormat3 = mediaFormat;
            if (mediaFormat2 != null) {
                a_a.egD = !mediaFormat2.containsKey("durationUs") ? 0 : (int) (mediaFormat2.getLong("durationUs") / 1000);
                a_a.videoHeight = !mediaFormat2.containsKey("height") ? 0 : mediaFormat2.getInteger("height");
                a_a.videoWidth = !mediaFormat2.containsKey("width") ? 0 : mediaFormat2.getInteger("width");
                a_a.egB = !mediaFormat2.containsKey("mime") ? "" : mediaFormat2.getString("mime");
                a_a.videoBitRate = !mediaFormat2.containsKey("bitrate") ? 0 : mediaFormat2.getInteger("bitrate");
                a_a.egE = !mediaFormat2.containsKey("i-frame-interval") ? 0 : mediaFormat2.getInteger("i-frame-interval");
                a_a.videoFrameRate = !mediaFormat2.containsKey("frame-rate") ? 0 : mediaFormat2.getInteger("frame-rate");
            }
            if (mediaFormat3 != null) {
                a_a.egC = !mediaFormat3.containsKey("mime") ? "" : mediaFormat3.getString("mime");
            }
            mediaExtractor.release();
        } catch (Exception e) {
            x.i("MicroMsg.ShareSnsImpl", "Video extractor init failed. video path = [%s] e = [%s]", new Object[]{str, e.getMessage()});
            mediaExtractor.release();
        } catch (Throwable th) {
            mediaExtractor.release();
            throw th;
        }
        return a_a;
    }
}
