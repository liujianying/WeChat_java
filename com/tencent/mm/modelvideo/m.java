package com.tencent.mm.modelvideo;

import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.c;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m {
    private static int bFl = 0;
    private boolean bFh = false;
    private boolean bFi = false;
    int bFj = 0;
    private a bFn = new a();
    private al bFo = new al(g.Em().lnJ.getLooper(), new al.a() {
        public final boolean vD() {
            m.h(m.this);
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);
    private LinkedList<Long> emS = new LinkedList();
    private Map<Long, a> emT = new HashMap();
    private Map<Long, String> emU = new HashMap();
    private Object emV = new Object();
    String emW;

    /* renamed from: com.tencent.mm.modelvideo.m$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ long emX;

        public AnonymousClass5(long j) {
            this.emX = j;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r10 = this;
            r0 = com.tencent.mm.modelvideo.m.this;
            r8 = r0.emV;
            monitor-enter(r8);
            r0 = com.tencent.mm.modelvideo.m.this;	 Catch:{ all -> 0x00b1 }
            r0 = r0.emU;	 Catch:{ all -> 0x00b1 }
            r2 = r10.emX;	 Catch:{ all -> 0x00b1 }
            r1 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x00b1 }
            r0 = r0.get(r1);	 Catch:{ all -> 0x00b1 }
            r0 = (java.lang.String) r0;	 Catch:{ all -> 0x00b1 }
            r1 = "MicroMsg.SightMassSendService";
            r2 = "cancel item, massSendId %d, cdnClientId %s";
            r3 = 2;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00b1 }
            r4 = 0;
            r6 = r10.emX;	 Catch:{ all -> 0x00b1 }
            r5 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x00b1 }
            r3[r4] = r5;	 Catch:{ all -> 0x00b1 }
            r4 = 1;
            r3[r4] = r0;	 Catch:{ all -> 0x00b1 }
            com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ all -> 0x00b1 }
            r1 = "done_upload_cdn_client_id";
            r1 = r1.equals(r0);	 Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x0045;
        L_0x003a:
            r0 = "MicroMsg.SightMassSendService";
            r1 = "doing mass send cgi, ignore cancel!";
            com.tencent.mm.sdk.platformtools.x.w(r0, r1);	 Catch:{ all -> 0x00b1 }
            monitor-exit(r8);	 Catch:{ all -> 0x00b1 }
        L_0x0044:
            return;
        L_0x0045:
            r1 = com.tencent.mm.sdk.platformtools.bi.oW(r0);	 Catch:{ all -> 0x00b1 }
            if (r1 != 0) goto L_0x006d;
        L_0x004b:
            r1 = com.tencent.mm.modelvideo.m.this;	 Catch:{ all -> 0x00b1 }
            r1 = r1.emU;	 Catch:{ all -> 0x00b1 }
            r2 = r10.emX;	 Catch:{ all -> 0x00b1 }
            r2 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x00b1 }
            r3 = "";
            r1.put(r2, r3);	 Catch:{ all -> 0x00b1 }
            r1 = com.tencent.mm.modelcdntran.g.ND();	 Catch:{ all -> 0x00b1 }
            r1.lw(r0);	 Catch:{ all -> 0x00b1 }
            r0 = com.tencent.mm.modelvideo.m.this;	 Catch:{ all -> 0x00b1 }
            r2 = r10.emX;	 Catch:{ all -> 0x00b1 }
            r1 = 0;
            r4 = 0;
            r0.d(r2, r1, r4);	 Catch:{ all -> 0x00b1 }
        L_0x006d:
            r0 = com.tencent.mm.modelvideo.o.Ta();	 Catch:{ all -> 0x00b1 }
            r6 = r10.emX;	 Catch:{ all -> 0x00b1 }
            r1 = r0.dCZ;	 Catch:{ all -> 0x00b1 }
            r2 = "videoinfo2";
            r3 = "masssendid= ?";
            r4 = 1;
            r4 = new java.lang.String[r4];	 Catch:{ all -> 0x00b1 }
            r5 = 0;
            r9 = java.lang.String.valueOf(r6);	 Catch:{ all -> 0x00b1 }
            r4[r5] = r9;	 Catch:{ all -> 0x00b1 }
            r1 = r1.delete(r2, r3, r4);	 Catch:{ all -> 0x00b1 }
            if (r1 <= 0) goto L_0x00af;
        L_0x008b:
            r1 = new com.tencent.mm.modelvideo.s$a$a;	 Catch:{ all -> 0x00b1 }
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00b1 }
            r3 = "DELETE_";
            r2.<init>(r3);	 Catch:{ all -> 0x00b1 }
            r2 = r2.append(r6);	 Catch:{ all -> 0x00b1 }
            r2 = r2.toString();	 Catch:{ all -> 0x00b1 }
            r3 = com.tencent.mm.modelvideo.s.a.b.eog;	 Catch:{ all -> 0x00b1 }
            r4 = com.tencent.mm.modelvideo.s.a.c.eoj;	 Catch:{ all -> 0x00b1 }
            r5 = 3;
            r1.<init>(r2, r3, r4, r5, r6);	 Catch:{ all -> 0x00b1 }
            r2 = r0.dHn;	 Catch:{ all -> 0x00b1 }
            r2.ci(r1);	 Catch:{ all -> 0x00b1 }
            r0 = r0.dHn;	 Catch:{ all -> 0x00b1 }
            r0.doNotify();	 Catch:{ all -> 0x00b1 }
        L_0x00af:
            monitor-exit(r8);	 Catch:{ all -> 0x00b1 }
            goto L_0x0044;
        L_0x00b1:
            r0 = move-exception;
            monitor-exit(r8);	 Catch:{ all -> 0x00b1 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvideo.m.5.run():void");
        }
    }

    static /* synthetic */ int SW() {
        int i = bFl;
        bFl = i + 1;
        return i;
    }

    static /* synthetic */ int SX() {
        int i = bFl;
        bFl = i - 1;
        return i;
    }

    static /* synthetic */ void h(m mVar) {
        if (!mVar.bFh && mVar.emS.isEmpty()) {
            List<r> Tr = o.Ta().Tr();
            if (Tr.isEmpty()) {
                x.d("MicroMsg.SightMassSendService", "unfinish massinfo count 0");
            } else {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                for (r rVar : Tr) {
                    if (mVar.emT.containsKey(Long.valueOf(rVar.emf))) {
                        x.d("MicroMsg.SightMassSendService", "Mass Send File is Already running %s, massSendId %d", new Object[]{rVar.getFileName(), Long.valueOf(rVar.emf)});
                    } else {
                        x.d("MicroMsg.SightMassSendService", "Get file:" + rVar.getFileName() + " status:" + rVar.status + " user" + rVar.Tj() + " human:" + rVar.Tk() + " massSendId:" + rVar.emf + " massSendList:" + rVar.enU + " create:" + bi.gb(rVar.createTime) + " last:" + bi.gb(rVar.enK) + " now:" + bi.gb(currentTimeMillis) + " " + (currentTimeMillis - rVar.enK));
                        if (rVar.status == 200) {
                            mVar.emS.offer(Long.valueOf(rVar.emf));
                            mVar.emT.put(Long.valueOf(rVar.emf), null);
                        }
                    }
                }
                x.d("MicroMsg.SightMassSendService", "GetNeedRun procing:" + mVar.emT.size() + " [send:" + mVar.emS.size() + "]");
                mVar.emS.size();
            }
        }
        if (!mVar.bFh && mVar.emS.isEmpty()) {
            mVar.wx();
            x.d("MicroMsg.SightMassSendService", "No Data Any More , Stop Service");
        } else if (!mVar.bFh && mVar.emS.size() > 0) {
            Long l = (Long) mVar.emS.poll();
            x.d("MicroMsg.SightMassSendService", "Start Mass Send, ID: %s", new Object[]{l});
            if (l != null) {
                mVar.emT.put(l, new a());
                mVar.bFh = true;
                mVar.emW = mVar.bA(l.longValue());
                if (mVar.emW == null) {
                    mVar.bFh = false;
                    mVar.bFo.J(10, 10);
                    return;
                }
                mVar.emU.put(l, mVar.emW);
            }
        }
    }

    public static void W(List<r> list) {
        if (list != null && !list.isEmpty()) {
            for (r fileName : list) {
                t.nP(fileName.getFileName());
            }
        }
    }

    public static void X(List<r> list) {
        if (list != null && !list.isEmpty()) {
            for (r fileName : list) {
                t.nQ(fileName.getFileName());
            }
        }
    }

    private String bA(long j) {
        List<r> bB = o.Ta().bB(j);
        if (bB.isEmpty()) {
            x.e("MicroMsg.SightMassSendService", "check use cdn fail: mass send video list empty");
            return null;
        }
        r rVar;
        for (r rVar2 : bB) {
            if (s.hP(rVar2.Tj())) {
                x.w("MicroMsg.SightMassSendService", "cdntra not use cdn user:%s, list %s, massSendId %d", new Object[]{rVar2.Tj(), rVar2.enU, Long.valueOf(j)});
                return null;
            }
            com.tencent.mm.modelcdntran.g.ND();
            if (!c.hz(2) && rVar2.enR != 1) {
                r5 = new Object[4];
                com.tencent.mm.modelcdntran.g.ND();
                r5[0] = Boolean.valueOf(c.hz(2));
                r5[1] = Integer.valueOf(rVar2.enR);
                r5[2] = rVar2.enU;
                r5[3] = Long.valueOf(j);
                x.w("MicroMsg.SightMassSendService", "cdntra not use cdn flag:%b getCdnInfo:%d, list %s, massSendId %d", r5);
                return null;
            }
        }
        if (bB == null || bB.isEmpty()) {
            rVar2 = null;
        } else {
            for (int i = 0; i < bB.size(); i++) {
                r nW = t.nW(((r) bB.get(i)).getFileName());
                if (nW != null) {
                    x.i("MicroMsg.SightMassSendService", "check %s ok, index %d, size %d, massSendId %d, massSendList %s", new Object[]{rVar2.getFileName(), Integer.valueOf(i), Integer.valueOf(bB.size()), Long.valueOf(j), rVar2.enU});
                    bB.remove(i);
                    bB.add(i, nW);
                    rVar2 = nW;
                    break;
                }
                x.w("MicroMsg.SightMassSendService", "check %s fail, index %d, size %d, massSendId %d, massSendList %s", new Object[]{rVar2.getFileName(), Integer.valueOf(i), Integer.valueOf(bB.size()), Long.valueOf(j), rVar2.enU});
            }
            rVar2 = null;
        }
        if (rVar2 == null) {
            x.w("MicroMsg.SightMassSendService", "check use cdn fail: no valid info");
            return null;
        }
        String a = d.a("upvideo", rVar2.createTime, rVar2.enU, rVar2.getFileName());
        if (bi.oW(a)) {
            x.w("MicroMsg.SightMassSendService", "cdntra genClientId failed not use cdn file:%s, massSendId %d, massSendList %s", new Object[]{rVar2.getFileName(), Long.valueOf(rVar2.emf), rVar2.enU});
            return null;
        }
        String fileName = rVar2.getFileName();
        o.Ta();
        String nL = s.nL(fileName);
        o.Ta();
        fileName = s.nK(fileName);
        a aVar = new a(this, (byte) 0);
        aVar.dEx = bB;
        aVar.emf = j;
        aVar.emZ = a;
        aVar.startTime = bi.VF();
        aVar.emg = rVar2;
        i iVar = new i();
        iVar.dPV = aVar;
        iVar.field_mediaId = a;
        iVar.field_fullpath = fileName;
        iVar.field_thumbpath = nL;
        iVar.field_fileType = b.MediaType_VIDEO;
        iVar.field_smallVideoFlag = 1;
        iVar.field_talker = rVar2.enU;
        iVar.field_priority = b.dOk;
        iVar.field_needStorage = false;
        iVar.field_isStreamMedia = false;
        Map z = bl.z(rVar2.Tm(), "msg");
        if (z != null) {
            iVar.field_fileId = (String) z.get(".msg.videomsg.$cdnvideourl");
            iVar.field_aesKey = (String) z.get(".msg.videomsg.$aeskey");
        } else {
            x.i("MicroMsg.SightMassSendService", "cdntra parse video recv xml failed");
        }
        if (com.tencent.mm.modelcdntran.g.ND().c(iVar)) {
            for (r rVar22 : bB) {
                if (rVar22.enR != 1) {
                    rVar22.enR = 1;
                    rVar22.bWA = 524288;
                    boolean e = t.e(rVar22);
                    x.i("MicroMsg.SightMassSendService", "update %s useCDN, result %B", new Object[]{rVar22.getFileName(), Boolean.valueOf(e)});
                }
            }
            return a;
        }
        x.e("MicroMsg.SightMassSendService", "cdntra addSendTask failed.");
        return null;
    }

    public final void d(long j, int i, int i2) {
        g.Em().H(new 2(this, j, i, i2));
    }

    private void wx() {
        this.emU.clear();
        this.emT.clear();
        this.emS.clear();
        this.bFh = false;
        this.bFi = false;
        x.d("MicroMsg.SightMassSendService", "Finish service use time(ms):" + this.bFn.Ad());
    }
}
