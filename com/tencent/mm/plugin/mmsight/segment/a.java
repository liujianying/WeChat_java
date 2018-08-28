package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@TargetApi(16)
public abstract class a implements f {
    private String ijZ;
    String lkG;
    String lkH;
    private MediaExtractor lkI;
    private List<a> lkJ = new ArrayList();
    private List<a> lkK = new ArrayList();
    long lkL;
    long lkM;
    int lkN = -1;
    private boolean lkO = false;
    VideoTransPara lkP;
    int lkQ = -1;

    public abstract int Ht(String str);

    public void a(String str, String str2, VideoTransPara videoTransPara) {
        x.d("BaseMediaCodecClipper", "init() called with: src = [" + str + "], dst = [" + str2 + "], para = [" + videoTransPara + "]");
        long VG = bi.VG();
        if (bi.oW(str) || bi.oW(str2) || videoTransPara == null) {
            throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument's null or nil. src = %s; dst = %s; param = %s", new Object[]{str, str2, videoTransPara}));
        }
        File file = new File(str);
        File file2 = new File(str2);
        if (FileOp.cn(str) && file.canRead() && file.length() != 0) {
            this.lkH = str;
            this.lkG = str2;
            this.lkP = videoTransPara;
            this.lkI = new MediaExtractor();
            this.lkI.setDataSource(str);
            a(this.lkI);
            if (this.lkJ == null || this.lkJ.size() == 0) {
                throw new o("Can not find video or audio track in this video file.");
            }
            this.lkN = beK();
            this.lkQ = Ht(str);
            this.lkO = true;
            x.e("BaseMediaCodecClipper", "init cost time %dms", Long.valueOf(bi.bI(VG)));
            return;
        }
        throw new IllegalArgumentException(String.format(Locale.CHINA, "Argument src video file can not be read or empty %s", new Object[]{str}));
    }

    private void a(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            if (trackFormat.containsKey("mime") && !bi.oW(trackFormat.getString("mime"))) {
                String string = trackFormat.getString("mime");
                x.i("BaseMediaCodecClipper", "mime: %s", string);
                if (string.startsWith("audio/")) {
                    this.lkK.add(new a(this, trackFormat, i));
                } else if (string.startsWith("video/")) {
                    this.lkJ.add(new a(this, trackFormat, i));
                }
            }
        }
        x.i("BaseMediaCodecClipper", "findMediaFormat mAudioSelectedTrackList.size() = %d, mVideoSelectedTrackList.size() = %d", Integer.valueOf(this.lkK.size()), Integer.valueOf(this.lkJ.size()));
    }

    public int x(long j, long j2) {
        if (this.lkO) {
            if (j < 0) {
                j = 0;
            }
            this.lkL = j;
            MediaFormat mediaFormat = ((a) this.lkJ.get(0)).ljB;
            if (mediaFormat.containsKey("durationUs")) {
                if (j2 <= 0 || j2 > mediaFormat.getLong("durationUs") / 1000) {
                    j2 = mediaFormat.getLong("durationUs") / 1000;
                }
                this.lkM = j2;
                return a(this.lkI, this.lkK, this.lkJ);
            }
            throw new o("Can not find duration.");
        }
        x.e("BaseMediaCodecClipper", "checkTimeParameter has not been initialized.");
        throw new IllegalStateException("Please init this component first.");
    }

    protected int a(MediaExtractor mediaExtractor, List<a> list, List<a> list2) {
        return 0;
    }

    protected final String beJ() {
        if (this.ijZ == null) {
            this.ijZ = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_clip_temp.mp4";
        }
        return this.ijZ;
    }

    public final void release() {
        this.lkO = false;
        if (this.lkI != null) {
            this.lkI.release();
        }
    }

    private int beK() {
        Iterator it;
        int i;
        a aVar;
        int i2 = -1;
        if (!(this.lkK == null || this.lkK.size() == 0)) {
            it = this.lkK.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                aVar = (a) it.next();
                if (aVar.ljB.containsKey("max-input-size")) {
                    i2 = Math.max(aVar.ljB.getInteger("max-input-size"), i);
                } else {
                    i2 = i;
                }
            }
            i2 = i;
        }
        if (this.lkJ == null || this.lkJ.size() == 0) {
            return i2;
        }
        it = this.lkJ.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                return i;
            }
            aVar = (a) it.next();
            if (aVar.ljB.containsKey("max-input-size")) {
                i2 = Math.max(aVar.ljB.getInteger("max-input-size"), i);
            } else {
                i2 = i;
            }
        }
    }
}
