package com.tencent.mm.plugin.multitalk.a;

import android.os.SystemClock;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.pb.talkroom.sdk.b;
import com.tencent.pb.talkroom.sdk.e;

class c$1 implements e {
    final /* synthetic */ c ltg;

    c$1(c cVar) {
        this.ltg = cVar;
    }

    public final boolean m(int i, String str, String str2) {
        switch (i) {
            case 0:
                x.v(str, str2);
                break;
            case 1:
                x.d(str, str2);
                break;
            case 2:
                x.i(str, str2);
                break;
            case 3:
                x.w(str, str2);
                break;
            case 4:
                x.e(str, str2);
                break;
            case 5:
                x.f(str, str2);
                break;
            default:
                x.v(str, str2);
                break;
        }
        return false;
    }

    public final boolean c(int i, int i2, byte[] bArr) {
        x.i("MicroMsg.MT.MultiTalkEngine", "sendMultiTalkReq " + i + " cmdid " + i2);
        au.DF().a(new n(i, i2, bArr), 0);
        return false;
    }

    public final boolean bfN() {
        int zj = m.zj();
        x.i("MicroMsg.MT.MultiTalkEngine", "loadVoipCodecLib cpuFlag:" + zj);
        if ((zj & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            d.y(ad.getContext(), "libvoipCodec_v7a.so");
        } else if ((zj & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
            d.y(ad.getContext(), "libvoipCodec.so");
        } else {
            d.y(ad.getContext(), "libvoipCodec_v5.so");
        }
        return true;
    }

    public final int zj() {
        return m.zj();
    }

    public final int bfO() {
        au.HU();
        String cmX = c.DU().cmX();
        q.fd(cmX);
        x.i("MicroMsg.MT.MultiTalkEngine", "MTSDK audioAdapter startRecord setMultiTalkAppCmd info: " + cmX);
        c.a(this.ltg);
        return 0;
    }

    public final boolean gG(boolean z) {
        x.i("MicroMsg.MT.MultiTalkEngine", "setMultiTalkSpeaker %b", new Object[]{Boolean.valueOf(z)});
        this.ltg.ltb.fT(z);
        return true;
    }

    public final int a(int i, int i2, b bVar) {
        this.ltg.lte = bVar;
        int a = this.ltg.ltb.a(this.ltg.ltf, i, i2);
        x.i("MicroMsg.MT.MultiTalkEngine", "isSpeakerOn=%b isHandsFree=%b", new Object[]{Boolean.valueOf(au.HV().yJ()), Boolean.valueOf(o.bgN().ltn)});
        if (au.HV().yJ() != o.bgN().ltn && o.bgN().koX.alf()) {
            this.ltg.ltb.fT(o.bgN().ltn);
        }
        return a;
    }

    public final int a(int i, int i2, com.tencent.pb.talkroom.sdk.c cVar) {
        this.ltg.ltd = cVar;
        this.ltg.ltc = new com.tencent.mm.e.b.c(i, 1, 7);
        this.ltg.ltc.ey(i2);
        this.ltg.ltc.aN(true);
        this.ltg.ltc.wm();
        this.ltg.ltc.bDQ = -19;
        this.ltg.ltc.t(1, false);
        this.ltg.ltc.aM(true);
        this.ltg.ltc.bEb = this.ltg.bEs;
        if (this.ltg.ltc.wn()) {
            return 1;
        }
        return -1;
    }

    public final boolean bfP() {
        x.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer");
        b bVar = this.ltg.ltb;
        synchronized (bVar.lsX) {
            x.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlay, isStart: %s %s", new Object[]{Boolean.valueOf(bVar.bTv), Integer.valueOf(bVar.hashCode())});
            if (bVar.bTv) {
                com.tencent.mm.plugin.voip.model.b bVar2 = bVar.kpV;
                if (bVar2 != null) {
                    bVar.lsZ.dgA = SystemClock.elapsedRealtime();
                    bVar2.bJv();
                    x.i("MicroMsg.MT.MultiTalkAudioPlayer", "stopPlaying cost: " + bVar.lsZ.Ad());
                    bVar2.bJs();
                    bVar.bTv = false;
                    bVar.kpV = null;
                    au.HV().yO();
                    au.HV().setMode(0);
                }
                bVar.kqe.ej(ad.getContext());
                au.HV().yC();
                au.HV().b(bVar);
                bVar.epT.zY();
            }
        }
        return true;
    }

    public final boolean bfQ() {
        x.i("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkRecord");
        try {
            if (this.ltg.ltc != null) {
                this.ltg.ltc.bEb = null;
                this.ltg.ltc.we();
            }
            this.ltg.ltc = null;
            return true;
        } catch (Exception e) {
            x.w("MicroMsg.MT.MultiTalkEngine", "stopMultiTalkPlayer :" + e);
            return false;
        }
    }

    public final int bfR() {
        int i = 0;
        x.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkPlayVolume");
        if (this.ltg.ltb != null) {
            b bVar = this.ltg.ltb;
            if (bVar.kpV != null) {
                i = bVar.kpV.bJx();
            }
        }
        return (int) ((((float) au.HV().getStreamVolume(i)) / ((float) au.HV().getStreamMaxVolume(i))) * 100.0f);
    }

    public final int bfS() {
        x.i("MicroMsg.MT.MultiTalkEngine", "getMultiTalkRecordReadNum");
        if (this.ltg.ltc != null) {
            return this.ltg.ltc.wp();
        }
        return -2;
    }

    public final int bfT() {
        x.d("MicroMsg.MT.MultiTalkEngine", "getAudioRecorderErrorCode");
        if (this.ltg.ltc != null) {
            return this.ltg.ltc.bDF;
        }
        return 0;
    }

    public final int bfU() {
        x.d("MicroMsg.MT.MultiTalkEngine", "getAudioPlayerErrorCode");
        if (this.ltg.ltb == null) {
            return 0;
        }
        b bVar = this.ltg.ltb;
        if (bVar.kpV != null) {
            return bVar.kpV.bJw();
        }
        return 0;
    }
}
