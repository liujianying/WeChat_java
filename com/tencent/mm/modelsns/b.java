package com.tencent.mm.modelsns;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.c.bqt;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsMediaPlayer$TbsMediaPlayerListener;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    private static boolean eet = false;
    private static AtomicInteger egZ = new AtomicInteger(0);
    public Object egQ = null;
    public int egR = 1;
    public int egS;
    public int egT;
    public int egU;
    public StringBuffer egV = new StringBuffer();
    public StringBuffer egW = new StringBuffer();
    public StringBuffer egX = new StringBuffer();
    public StringBuffer egY = new StringBuffer();
    public int opType = 0;
    public long timeStamp;

    static /* synthetic */ void a(b bVar) {
        d dVar = new d();
        dVar.r("\n\nmodel", bVar.egR + ",");
        dVar.r("opType", bVar.opType + ",");
        dVar.r("timeStamp", bVar.timeStamp + ",");
        dVar.r("seq", bVar.egS + ",");
        dVar.r("netWork", bVar.egT + ",");
        dVar.r("page", bVar.egU + ",");
        dVar.r("StatusDesc1", bVar.egV.toString() + ",");
        dVar.r("DataFlowSourceInfo", bVar.egW.toString() + ",");
        dVar.r("DataFlowResultInfo", bVar.egX.toString() + ",");
        dVar.r("StatusDesc2", bVar.egY.toString() + ", ");
        dVar.ehd.append("bindkey: " + bVar.egQ);
        x.d("MicroMsg.StatisticsOplog", "report logbuffer: " + dVar.wF());
        f.mDy.h(12645, new Object[]{dVar});
    }

    public static b io(int i) {
        return new b(i, 1);
    }

    public static b ip(int i) {
        return new b(i, 4);
    }

    public final boolean Rz() {
        int i = c.ehb;
        if (i == 0) {
            return false;
        }
        if (i == 1) {
            if (this.opType >= 501 && this.opType <= TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_VIDEO_TRACK_LAGGING) {
                return true;
            }
            if (this.opType >= TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START && this.opType <= 1000) {
                return true;
            }
        }
        if (i == 2 && this.opType >= TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START && this.opType <= 1000) {
            return true;
        }
        if (i == 3 && this.opType >= 501 && this.opType <= TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_VIDEO_TRACK_LAGGING) {
            return true;
        }
        if (i == 4) {
            if (this.opType >= TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_BUFFERING_START && this.opType <= 1000) {
                return true;
            }
            if (this.opType >= 501 && this.opType <= TbsMediaPlayer$TbsMediaPlayerListener.MEDIA_INFO_VIDEO_TRACK_LAGGING) {
                return true;
            }
        }
        return false;
    }

    public b(int i, int i2) {
        this.opType = i;
        this.egU = i2;
        if (Rz()) {
            this.timeStamp = System.currentTimeMillis();
            if (ao.isWifi(ad.getContext())) {
                this.egT = 4;
            } else if (ao.is4G(ad.getContext())) {
                this.egT = 3;
            } else if (ao.is3G(ad.getContext())) {
                this.egT = 2;
            } else if (ao.is2G(ad.getContext())) {
                this.egT = 1;
            } else {
                this.egT = 0;
            }
            this.egS = egZ.incrementAndGet();
        }
    }

    public final boolean iq(int i) {
        this.egQ = Integer.valueOf(i);
        return true;
    }

    public final void update() {
        if (Rz()) {
            this.timeStamp = System.currentTimeMillis();
            this.egS = egZ.incrementAndGet();
        }
    }

    public final b nb(String str) {
        if (Rz()) {
            if (this.egV.length() != 0) {
                this.egV.append("||" + str);
            } else if (bi.oW(str)) {
                this.egV.append(" ");
            } else {
                this.egV.append(str);
            }
        }
        return this;
    }

    public final b ir(int i) {
        return nb(String.valueOf(i));
    }

    public final b nc(String str) {
        if (Rz()) {
            if (this.egW.length() == 0) {
                this.egW.append(str);
            } else {
                this.egW.append("||" + str);
            }
        }
        return this;
    }

    public final b RA() {
        this.egW = new StringBuffer();
        return this;
    }

    public final b RB() {
        this.egV = new StringBuffer();
        return this;
    }

    public final b nd(String str) {
        if (Rz()) {
            if (this.egX.length() == 0) {
                this.egX.append(str);
            } else {
                this.egX.append("||" + str);
            }
        }
        return this;
    }

    public final b bP(boolean z) {
        return nb(z ? "1" : "0");
    }

    public final b is(int i) {
        if (Rz()) {
            if (this.egW.length() == 0) {
                this.egW.append(i);
            } else {
                this.egW.append("||" + i);
            }
        }
        return this;
    }

    public static void RC() {
        x.i("MicroMsg.StatisticsOplog", "wait op");
    }

    public final boolean RD() {
        if (!Rz()) {
            return false;
        }
        e.post(new 1(this), "StatisticsOplog");
        return true;
    }

    public final byte[] Lv() {
        bqt bqt = new bqt();
        bqt.opType = this.opType;
        bqt.egU = this.egU;
        bqt.egR = this.egR;
        bqt.timeStamp = this.timeStamp;
        bqt.egS = this.egS;
        bqt.egT = this.egT;
        bqt.soR = this.egV.toString();
        bqt.soS = this.egY.toString();
        bqt.soT = this.egW.toString();
        bqt.soU = this.egX.toString();
        try {
            return bqt.toByteArray();
        } catch (Exception e) {
            x.e("MicroMsg.StatisticsOplog", "putIntent " + e.getMessage());
            return null;
        }
    }

    public final void b(Intent intent, String str) {
        byte[] Lv = Lv();
        if (Lv != null) {
            intent.putExtra(str, Lv);
        }
    }

    public static b j(Bundle bundle) {
        byte[] byteArray = bundle.getByteArray("intent_key_StatisticsOplog");
        return byteArray == null ? null : L(byteArray);
    }

    public static b p(Intent intent) {
        return c(intent, "intent_key_StatisticsOplog");
    }

    public static b c(Intent intent, String str) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return L(byteArrayExtra);
    }

    private static b L(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        bqt bqt = new bqt();
        try {
            bqt.aG(bArr);
            b bVar = new b(bqt.opType, bqt.egU);
            bVar.egR = bqt.egR;
            bVar.timeStamp = bqt.timeStamp;
            bVar.egS = bqt.egS;
            bVar.egT = bqt.egT;
            bVar.egV = new StringBuffer(bqt.soR);
            bVar.egY = new StringBuffer(bqt.soS);
            bVar.egW = new StringBuffer(bqt.soT);
            bVar.egX = new StringBuffer(bqt.soU);
            return bVar;
        } catch (Exception e) {
            x.e("MicroMsg.StatisticsOplog", "putIntent " + e.getMessage());
            return null;
        }
    }
}
