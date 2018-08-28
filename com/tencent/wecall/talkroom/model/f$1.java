package com.tencent.wecall.talkroom.model;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp.ErrCode;
import com.tencent.mm.plugin.appbrand.jsapi.share.b;
import com.tencent.mm.plugin.multi.talk;
import com.tencent.mm.plugin.multi.talk.a;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.g;
import com.tencent.pb.talkroom.sdk.e;
import com.tencent.wecall.talkroom.model.g.3;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class f$1 implements a {
    final /* synthetic */ f vyi;

    f$1(f fVar) {
        this.vyi = fVar;
    }

    public final void keep_OnOpenSuccess() {
        int[] iArr = null;
        this.vyi.vxH.kqL = 1;
        c.d("TalkRoomService", new Object[]{"engine OnOpenSuccess"});
        if (f.a(this.vyi) != 4) {
            c.x("TalkRoomService", new Object[]{"has exit the talkroom state:%d", Integer.valueOf(f.a(this.vyi))});
            return;
        }
        try {
            f fVar = this.vyi;
            c cHG = c.cHG();
            Object b = f.b(this.vyi);
            if (!TextUtils.isEmpty(b)) {
                TalkRoom adg = cHG.adg(b);
                if (adg != null) {
                    List cHA = adg.cHA();
                    if (cHA != null) {
                        int[] iArr2 = new int[cHA.size()];
                        StringBuffer stringBuffer = new StringBuffer();
                        for (int i = 0; i < cHA.size(); i++) {
                            d dVar = (d) cHA.get(i);
                            if (dVar != null) {
                                iArr2[i] = dVar.cHJ();
                                stringBuffer.append(iArr2[i]);
                                stringBuffer.append(",");
                            }
                        }
                        c.x("TalkRoomManager", new Object[]{"getAllMemberIds memberIds: ", stringBuffer.toString()});
                        iArr = iArr2;
                    }
                }
            }
            f.a(fVar, iArr);
            if (f.c(this.vyi) != null) {
                b c = f.c(this.vyi);
                boolean yJ = f.yJ();
                if (com.tencent.pb.common.a.a.vbD) {
                    if (yJ) {
                        c.vwZ.tf(401);
                    } else {
                        c.vwZ.tf(402);
                    }
                }
            }
            f.d(this.vyi);
            f.c(this.vyi);
            e cHX = f.cHX();
            if (cHX != null) {
                cHX.bfO();
            }
            talk talk = f.c(this.vyi).vwZ;
            if (com.tencent.pb.common.a.a.vbD) {
                AtomicInteger atomicInteger = new AtomicInteger();
                AtomicInteger atomicInteger2 = new AtomicInteger();
                talk.getSampleRate(atomicInteger, atomicInteger2);
                int i2 = atomicInteger.get();
                int i3 = atomicInteger2.get();
                talk.lsT = i2;
                talk.lsU = i3;
                c.x("VoipAdapterUtil", new Object[]{"adapterInitv2engineSampleRate getSampleRate:", Integer.valueOf(talk.lsT), Integer.valueOf(talk.lsU)});
            }
        } catch (Throwable th) {
            c.x("TalkRoomService", new Object[]{"keep_OnOpenSuccess:  ", th});
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                try {
                    c.w("TalkRoomService", new Object[]{"initMediaComponent"});
                    f.e(f$1.this.vyi);
                } catch (Throwable th) {
                    c.x("TalkRoomService", new Object[]{"keep_OnOpenSuccess initMediaComponent:  ", th});
                }
            }
        });
        h hVar = this.vyi.vxH;
        if (hVar.vzj == 0) {
            hVar.vyY = 0;
        } else {
            hVar.vyY = System.currentTimeMillis() - hVar.vzj;
        }
        c.d(h.TAG, new Object[]{"endFirstSendPcm", Long.valueOf(hVar.vyY), Long.valueOf(hVar.vzj)});
        g f = f.f(this.vyi);
        3 3 = new 3(f);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            3.run();
        } else {
            f.handler.post(3);
        }
    }

    public final void keep_OnError(int i) {
        int i2 = -401;
        int i3 = 207;
        int i4 = -3007;
        int i5 = 103;
        switch (i) {
            case ErrCode.ERR_AUTH_DENIED /*-4*/:
                i3 = 206;
                i4 = -3006;
                i5 = 115;
                i2 = -400;
                break;
            case -3:
                i3 = 205;
                i5 = 114;
                i4 = -3005;
                break;
            case -2:
                i3 = 204;
                i5 = 113;
                i4 = -3004;
                break;
            case -1:
                i3 = b.CTRL_INDEX;
                i5 = 112;
                i4 = -3003;
                break;
            default:
                i2 = -400;
                break;
        }
        h.Iw(i4);
        this.vyi.vxH.Ix(i3);
        c.d("TalkRoomService", new Object[]{"engine exitTalkRoom engineCallback OnError:", Integer.valueOf(i)});
        this.vyi.a(f.b(this.vyi), f.g(this.vyi), f.h(this.vyi), i5, true);
        f.f(this.vyi).h(i2, null);
    }

    public final void keep_OnNotify(int i) {
        c.x("TalkRoomService", new Object[]{"keep_OnNotify eventCode: ", Integer.valueOf(i)});
        if (i == 5) {
            this.vyi.vxH.vyW = 1;
            h hVar = this.vyi.vxH;
            if (hVar.vzj == 0) {
                hVar.vyX = 0;
            } else {
                hVar.vyX = System.currentTimeMillis() - hVar.vzj;
            }
            c.d(h.TAG, new Object[]{"endRecvFirstPcm", Long.valueOf(hVar.vzj), Long.valueOf(hVar.vyX)});
            f.i(this.vyi);
            f.j(this.vyi);
        }
    }

    public final void keep_OnReportEngineRecv(String str, int i) {
        c.d("TalkRoomService", new Object[]{"keep_OnReportEngineRecv:", Integer.valueOf(i), str});
        StringBuilder stringBuilder = new StringBuilder(g.ach(this.vyi.vxT));
        stringBuilder.append(",");
        stringBuilder.append(str);
        h.adp(stringBuilder.toString());
    }

    public final void keep_OnReportEngineSend(String str) {
        c.d("TalkRoomService", new Object[]{"keep_OnReportEngineSend:", str});
        StringBuilder stringBuilder = new StringBuilder(g.ach(this.vyi.vxT));
        stringBuilder.append(",");
        stringBuilder.append(str);
        h.adq(stringBuilder.toString());
    }

    public final void keep_OnReportChannel(String str) {
        c.d("TalkRoomService", new Object[]{"keep_OnReportChannel:", str});
        StringBuilder stringBuilder = new StringBuilder(g.ach(this.vyi.vxT));
        stringBuilder.append(",");
        stringBuilder.append(str);
        h.adr(stringBuilder.toString());
    }
}
