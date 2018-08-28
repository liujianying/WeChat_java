package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ay.b;
import com.tencent.mm.ay.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bfv;
import com.tencent.mm.protocal.c.btp;
import com.tencent.mm.protocal.c.bxg;
import com.tencent.mm.protocal.c.uh;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o implements e, b {
    public boolean bBc = false;
    public boolean bTv = false;
    public a cXs = new 2(this);
    public c dMm;
    private String kCu;
    public double kCw = -1000.0d;
    public double kCx = -1000.0d;
    public int kCy = -1;
    private int kDD = 0;
    private int kDE = BaseReportManager.MAX_READ_COUNT;
    public i kDF;
    public HashSet<WeakReference<b>> kDG = new HashSet();
    public int kDH = 1;
    public bxg kDI;
    public LocationInfo kDJ = new LocationInfo((byte) 0);
    public boolean kDK = false;
    public boolean kDL = false;
    public int kDM = this.kDH;
    public String kDN = "";
    boolean kDO = false;
    public a kDP = null;
    public int kDQ = -1;
    public boolean kDR = true;
    public long kDS = 0;
    long kDT = 0;
    public i.a kDU = new 3(this);
    ag mHandler = new 1(this, Looper.getMainLooper());
    private int timestamp;

    public final void stop() {
        x.i("MicorMsg.TrackRefreshManager", "stop location");
        if (this.dMm != null) {
            this.dMm.c(this.cXs);
        }
        if (this.kDF != null) {
            this.kDF.b(this.kDU);
        }
        g.DF().b(492, this);
        g.DF().b(490, this);
        g.DF().b(491, this);
        this.kDH = 1;
        this.bTv = false;
        this.kDQ = -1;
        m aZl = l.aZl();
        x.d("MicroMsg.TrackAvatarCacheService", "clearCache");
        for (String str : aZl.kDC.snapshot().keySet()) {
            Bitmap bitmap = (Bitmap) aZl.kDC.get(str);
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
        }
        aZl.kDC.trimToSize(-1);
    }

    public final boolean aZn() {
        return aZs() && this.kDK;
    }

    public final void rP(int i) {
        x.i("MicorMsg.TrackRefreshManager", "track endTrack");
        if (aZs()) {
            String str = this.kCu;
            x.d("MicorMsg.TrackRefreshManager", "exitTrack, scene=%d", new Object[]{Integer.valueOf(i)});
            com.tencent.mm.plugin.location.model.a.a aVar = new com.tencent.mm.plugin.location.model.a.a(str);
            ((uh) aVar.diG.dID.dIL).otY = i;
            g.DF().a(aVar, 0);
            this.kCu = "";
        }
        if (!bi.oW(this.kDN)) {
            com.tencent.mm.plugin.location.a.a FM = l.aZj().FM(this.kDN);
            if (FM != null) {
                FM.bUb.remove(q.GF());
                l.aZj().a(this.kDN, FM.bUb, FM.latitude, FM.longitude, FM.kCs, null, null);
            }
        }
        l.aZj().FN("");
        this.kCu = "";
        this.kDN = "";
        this.kDK = false;
        this.kDL = false;
        this.kCw = -1000.0d;
        this.kCx = -1000.0d;
        this.kCy = -1;
        this.kDQ = -1;
    }

    public final void aZo() {
        x.d("MicorMsg.TrackRefreshManager", "resume refresh");
        this.kDO = false;
        x.d("MicorMsg.TrackRefreshManager", "trigerRefresh");
        if (aZs()) {
            x.d("MicorMsg.TrackRefreshManager", "trigerRefresh, joinSuccess");
            this.dMm = c.OB();
            this.dMm.b(this.cXs, true);
            if (this.kDF == null) {
                this.kDF = l.aZk();
            }
            this.kDF.a(this.kDU);
            aZr();
        }
    }

    public final String SD() {
        return this.kDN;
    }

    public final List<String> aZp() {
        return l.aZj().ns(this.kDN);
    }

    public final void aZq() {
        if (this.kDH == 1) {
            this.kDH = 3;
        } else if (this.kDH == 3) {
            this.kDH = 2;
        }
    }

    public final void aZr() {
        boolean z = true;
        String str;
        if (!this.bTv || !this.kDK || this.kDJ == null) {
            str = "MicorMsg.TrackRefreshManager";
            StringBuilder append = new StringBuilder("error to exit refresh isStart: ").append(this.bTv).append(" isShared: ").append(this.kDK).append(" ");
            if (this.kDJ != null) {
                z = false;
            }
            x.e(str, append.append(z).toString());
        } else if (this.kDI == null || this.kDI.stK.rjj == -1000.0d || this.kDI.stK.rji == -1000.0d) {
            x.e("MicorMsg.TrackRefreshManager", "error to get my location ");
            this.mHandler.sendEmptyMessageDelayed(1, (long) this.kDE);
        } else {
            String GF = q.GF();
            btp btp = new btp();
            btp.sbw = this.kDJ.kCz;
            btp.rjj = this.kDJ.kCw;
            btp.rji = this.kDJ.kCx;
            btp.jPe = GF;
            this.kDI.rdS = GF;
            this.kDI.stK.sds = l.aZk().aZb();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("refreshLoopImpl, [trackRoomId:" + this.kCu + "]");
            switch (this.kDH) {
                case 0:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomUpload ");
                    break;
                case 1:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomDownload ");
                    break;
                case 2:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomUploadAndDownLoad ");
                    break;
                case 3:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomFirstUpload ");
                    stringBuffer.append("[ trackItem " + btp.rjj + " " + btp.rji + " ]");
                    break;
            }
            stringBuffer.append("[ mMyPosiItem " + this.kDI.stK.rjj + " " + this.kDI.stK.rji + " " + this.kDI.stK.sds + " ]");
            x.d("MicorMsg.TrackRefreshManager", stringBuffer.toString());
            str = this.kCu;
            int i = this.kDH;
            bxg bxg = this.kDI;
            int i2 = this.timestamp + 1;
            this.timestamp = i2;
            g.DF().a(new com.tencent.mm.plugin.location.model.a.c(str, i, bxg, i2, btp), 0);
        }
    }

    public final boolean aZs() {
        return !bi.oW(this.kCu);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicorMsg.TrackRefreshManager", "onSceneEnd scene type %d errType %d errCode %d", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        WeakReference weakReference;
        bfv bfv;
        if (lVar.getType() == 490) {
            Iterator it;
            if (i2 == 0 || i2 >= BaseReportManager.MAX_READ_COUNT) {
                this.kCu = ((com.tencent.mm.plugin.location.model.a.b) lVar).kCu;
                l.aZj().FN(this.kCu);
                if (aZs()) {
                    x.i("MicorMsg.TrackRefreshManager", "join sucess %s", new Object[]{this.kCu});
                    LinkedList ns = d.elh.ns(this.kDN);
                    ns.add(q.GF());
                    if (this.kDJ != null) {
                        d.elh.a(this.kDN, ns, this.kDJ.kCw, this.kDJ.kCx, this.kDJ.kCz, "", "");
                    } else {
                        d.elh.a(this.kDN, ns, -1000.0d, -1000.0d, "", "", "");
                    }
                    if (this.kDG != null) {
                        it = this.kDG.iterator();
                        while (it.hasNext()) {
                            weakReference = (WeakReference) it.next();
                            if (!(weakReference == null || weakReference.get() == null)) {
                                ((b) weakReference.get()).aZu();
                            }
                        }
                    }
                    aZr();
                    return;
                }
                return;
            }
            if (i2 == 17 && this.kDG != null) {
                it = this.kDG.iterator();
                while (it.hasNext()) {
                    weakReference = (WeakReference) it.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((b) weakReference.get()).aZv();
                    }
                }
            }
            if (this.kDG != null) {
                Iterator it2 = this.kDG.iterator();
                while (it2.hasNext()) {
                    weakReference = (WeakReference) it2.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((b) weakReference.get()).onError(0, ((com.tencent.mm.plugin.location.model.a.b) lVar).fFG);
                    }
                }
            }
        } else if (i == 0 && i2 == 0) {
            if (lVar.getType() == 492) {
                bfv = ((com.tencent.mm.plugin.location.model.a.c) lVar).kEe;
                if (!(bfv == null || bfv.six == null)) {
                    if (bfv.six.rfn == 12) {
                        this.bBc = true;
                        if (this.kDP != null) {
                            this.kDP.aZt();
                        }
                    } else {
                        this.bBc = false;
                    }
                    x.d("MicorMsg.TrackRefreshManager", "refresh track room, timeout = %b, ret = %d", new Object[]{Boolean.valueOf(this.bBc), Integer.valueOf(bfv.six.rfn)});
                }
                if (this.kDD > 0) {
                    h.mEJ.h(10997, new Object[]{"9", "", Integer.valueOf(this.kDD), Integer.valueOf(0)});
                }
                this.kDD = 0;
                this.kDE = ((com.tencent.mm.plugin.location.model.a.c) lVar).kEb;
                int i3 = ((com.tencent.mm.plugin.location.model.a.c) lVar).kEf;
                if (this.kDG != null && (i3 == 2 || i3 == 1 || i3 == 3)) {
                    Iterator it3 = this.kDG.iterator();
                    while (it3.hasNext()) {
                        weakReference = (WeakReference) it3.next();
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((b) weakReference.get()).a(((com.tencent.mm.plugin.location.model.a.c) lVar).kEe);
                        }
                    }
                }
                if (!(this.kDH == 1)) {
                    aZq();
                }
                this.mHandler.removeMessages(1);
                if (aZs() && !this.kDO && !this.bBc) {
                    this.mHandler.sendEmptyMessageDelayed(1, (long) this.kDE);
                }
            } else if (lVar.getType() == 491) {
                l.aZj().FN("");
            }
        } else if (lVar.getType() == 492) {
            this.kDD++;
            this.mHandler.removeMessages(1);
            if (this.kDD >= 10) {
                this.mHandler.removeMessages(1);
                if (this.kDG != null) {
                    Iterator it4 = this.kDG.iterator();
                    while (it4.hasNext()) {
                        weakReference = (WeakReference) it4.next();
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((b) weakReference.get()).onError(1, ((com.tencent.mm.plugin.location.model.a.c) lVar).fFG);
                        }
                    }
                }
            } else if (aZs() && !this.kDO) {
                bfv = ((com.tencent.mm.plugin.location.model.a.c) lVar).kEe;
                if (!(bfv == null || bfv.six == null)) {
                    if (bfv.six.rfn == 12) {
                        this.bBc = true;
                        if (this.kDP != null) {
                            this.kDP.aZt();
                        }
                    } else {
                        this.bBc = false;
                    }
                    x.d("MicorMsg.TrackRefreshManager", "refresh track room, in error status, timeout = %b, ret = %d", new Object[]{Boolean.valueOf(this.bBc), Integer.valueOf(bfv.six.rfn)});
                }
                if (!this.bBc) {
                    this.mHandler.sendEmptyMessageDelayed(1, (long) this.kDE);
                }
            }
        }
    }
}
