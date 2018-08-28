package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bk.b;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.g.a.bt;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g extends c<bt> implements e {
    private static final String hTO = (com.tencent.mm.compatible.util.e.bnE + "wallet/voice/");
    private static final b hTP = b.Uw("元");
    private MediaPlayer hTQ;
    private MediaPlayer hTR;
    public ConcurrentLinkedQueue<b> hTS;
    private boolean hTT;
    private int hTU;
    private int hTV;
    private long hTW;
    private WeakReference<ArrayList<String>> hTX;

    static /* synthetic */ void e(g gVar) {
        x.i("MicroMsg.F2fRcvVoiceListener", "reset user vol: %s", new Object[]{Integer.valueOf(gVar.hTU)});
        f.yz().aP(3, gVar.hTU);
    }

    public g() {
        this.hTT = false;
        this.sFo = bt.class.getName().hashCode();
    }

    private List<String> aBH() {
        if (this.hTX == null || this.hTX.get() == null) {
            x.i("MicroMsg.F2fRcvVoiceListener", "refer is null");
            this.hTX = new WeakReference(new ArrayList(bi.fQ((String) com.tencent.mm.kernel.g.Ei().DT().get(a.sZG, ""), ",")));
        }
        return (List) this.hTX.get();
    }

    private synchronized boolean yD(String str) {
        boolean z;
        if (bi.oW(str)) {
            x.w("MicroMsg.F2fRcvVoiceListener", "illegal no: %s, not do play", new Object[]{str});
            z = true;
        } else {
            List subList;
            List aBH = aBH();
            for (String equals : aBH()) {
                if (equals.equals(str)) {
                    x.i("MicroMsg.F2fRcvVoiceListener", "has played tradeno: %s", new Object[]{str});
                    z = true;
                    break;
                }
            }
            aBH.add(str);
            if (aBH.size() > 3) {
                x.i("MicroMsg.F2fRcvVoiceListener", "over max size, do remove");
                int size = aBH.size();
                subList = aBH.subList(size - 3, size);
            } else {
                subList = aBH;
            }
            com.tencent.mm.kernel.g.Ei().DT().a(a.sZG, bi.c(subList, ","));
            z = false;
        }
        return z;
    }

    private static boolean n(String str, byte[] bArr) {
        com.tencent.mm.kernel.g.Ek();
        if (!com.tencent.mm.kernel.g.Ei().isSDCardAvailable()) {
            x.i("MicroMsg.F2fRcvVoiceListener", "sd card not available");
            return false;
        } else if (FileOp.l(str, bArr) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean aBI() {
        x.i("MicroMsg.F2fRcvVoiceListener", "delete files");
        return com.tencent.mm.a.e.co(hTO);
    }

    private synchronized void aBJ() {
        boolean z = false;
        synchronized (this) {
            if (System.currentTimeMillis() - this.hTW > 10000) {
                x.i("MicroMsg.F2fRcvVoiceListener", "last has outdate: %s", new Object[]{Long.valueOf(this.hTW)});
                this.hTT = false;
            }
            if (this.hTT) {
                x.i("MicroMsg.F2fRcvVoiceListener", "is playing, return");
            } else {
                this.hTT = true;
                this.hTW = System.currentTimeMillis();
                b bVar = (b) this.hTS.poll();
                f yz = f.yz();
                int streamMaxVolume = yz.getStreamMaxVolume(3);
                this.hTU = yz.getStreamVolume(3);
                this.hTV = Math.round(((float) streamMaxVolume) * 0.4f);
                x.i("MicroMsg.F2fRcvVoiceListener", "curVol: %s, maxVol: %s, minVol: %s", new Object[]{Integer.valueOf(this.hTU), Integer.valueOf(streamMaxVolume), Integer.valueOf(this.hTV)});
                if (VERSION.SDK_INT >= 23) {
                    z = yz.daT.isStreamMute(3);
                    x.i("MicroMsg.F2fRcvVoiceListener", "isMute: %s", new Object[]{Boolean.valueOf(z)});
                }
                if (this.hTU > 0 && this.hTU < this.hTV && !z) {
                    yz.aP(3, this.hTV);
                }
                if (bVar != null) {
                    int i = i.collect_prefix_voice;
                    if (bVar.hUe == 2) {
                        i = i.md_prefix_voice;
                    }
                    if (bi.oW(bVar.fileName)) {
                        this.hTQ = a.a(ad.getContext(), i, new 4(this), new OnErrorListener() {
                            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                x.e("MicroMsg.F2fRcvVoiceListener", "no need play money error");
                                g.e(g.this);
                                g.this.hTT = false;
                                g.this.hTQ = null;
                                return false;
                            }
                        });
                        h.mEJ.a(699, 2, 1, false);
                    } else {
                        x.i("MicroMsg.F2fRcvVoiceListener", "play prefix voice: %d", new Object[]{Integer.valueOf(r2)});
                        this.hTQ = a.a(ad.getContext(), i, new 1(this, bVar), new 2(this));
                        if (this.hTQ != null) {
                            x.i("MicroMsg.F2fRcvVoiceListener", "prefix duration: %s", new Object[]{Integer.valueOf(this.hTQ.getDuration())});
                            ah.i(new 3(this), (long) (r0 + BaseReportManager.MAX_READ_COUNT));
                        }
                    }
                } else {
                    this.hTT = false;
                }
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        File file;
        String str2;
        b bVar;
        if (lVar instanceof i) {
            i iVar = (i) lVar;
            b bVar2;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[]{iVar});
                bVar2 = new b(this, (byte) 0);
                bVar2.hUe = 1;
                bVar2.bJh = iVar.bJh;
                this.hTS.add(bVar2);
                aBJ();
            } else if (iVar.hUi.hUm == 0) {
                file = new File(hTO);
                if (file.exists() || file.mkdirs()) {
                    str2 = hTO + UUID.randomUUID().toString() + ".tmp";
                    x.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[]{str2});
                    if (n(str2, iVar.hUi.rpX.lR)) {
                        bVar = new b(this, (byte) 0);
                        bVar.fileName = str2;
                        bVar.bOS = iVar.hUi.rpW;
                        bVar.hUe = 1;
                        bVar.bJh = iVar.bJh;
                        this.hTS.add(bVar);
                        aBJ();
                        return;
                    }
                    x.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
                    return;
                }
                x.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
            } else if (iVar.hUi.hUm <= 100) {
                x.i("MicroMsg.F2fRcvVoiceListener", "play default sound only");
                bVar2 = new b(this, (byte) 0);
                bVar2.hUe = 1;
                bVar2.bJh = iVar.bJh;
                this.hTS.add(bVar2);
                aBJ();
            } else {
                x.w("MicroMsg.F2fRcvVoiceListener", "retcode > 100, don't play");
            }
        } else if (lVar instanceof n) {
            n nVar = (n) lVar;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[]{nVar});
            } else if (nVar.hUC.hUm == 0) {
                file = new File(hTO);
                if (file.exists() || file.mkdirs()) {
                    str2 = hTO + UUID.randomUUID().toString() + ".tmp";
                    x.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[]{str2});
                    if (n(str2, nVar.hUC.rpX.lR)) {
                        bVar = new b(this, (byte) 0);
                        bVar.fileName = str2;
                        bVar.bOS = nVar.hUC.rpW;
                        bVar.hUe = 2;
                        this.hTS.add(bVar);
                        aBJ();
                        return;
                    }
                    x.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
                    return;
                }
                x.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
            }
        }
    }
}
