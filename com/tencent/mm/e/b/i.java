package com.tencent.mm.e.b;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class i implements e {
    private static int bFl = 0;
    public static boolean bFm = true;
    Queue<String> bFd = new LinkedList();
    Queue<p> bFe = new LinkedList();
    Map<String, a> bFf = new HashMap();
    private boolean bFg = false;
    private boolean bFh = false;
    private boolean bFi = false;
    public int bFj = 0;
    private long bFk = 0;
    a bFn = new a();
    private al bFo = new al(g.Em().lnJ.getLooper(), new 3(this), false);

    static /* synthetic */ void h(i iVar) {
        p pVar;
        iVar.bFk = System.currentTimeMillis();
        if ((!iVar.bFg && iVar.bFe.size() == 0) || (!iVar.bFh && iVar.bFd.size() == 0)) {
            List<p> TN = q.TN();
            if (!(TN == null || TN.size() == 0)) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String gb = bi.gb(currentTimeMillis);
                for (p pVar2 : TN) {
                    if (iVar.bFf.containsKey(pVar2.fileName)) {
                        x.d("MicroMsg.SceneVoiceService", "File is Already running:" + pVar2.fileName);
                    } else {
                        x.i("MicroMsg.SceneVoiceService", "Get file:" + pVar2.fileName + " status:" + pVar2.status + " user" + pVar2.bWJ + " human:" + pVar2.enF + " create:" + bi.gb(pVar2.createTime) + " last:" + bi.gb(pVar2.enK) + " now:" + bi.gb(currentTimeMillis) + " " + (currentTimeMillis - pVar2.enK));
                        if (pVar2.TL()) {
                            if (currentTimeMillis - pVar2.enK > 80 && pVar2.status == 5) {
                                x.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fileName + " last:" + bi.gb(pVar2.enK) + " now:" + gb + " msgLocalId:" + pVar2.enN + " status:" + pVar2.status);
                                if (pVar2.enN == 0) {
                                    pVar2.enK = System.currentTimeMillis() / 1000;
                                    pVar2.bWA = 320;
                                    m.TI().a(pVar2.fileName, pVar2);
                                } else {
                                    q.nP(pVar2.fileName);
                                }
                            }
                            if (currentTimeMillis - pVar2.enK > 300 && pVar2.status == 6) {
                                x.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fileName + " last:" + bi.gb(pVar2.enK) + " now:" + gb + " msgLocalId:" + pVar2.enN + " status:" + pVar2.status);
                                if (pVar2.enN == 0) {
                                    pVar2.enK = System.currentTimeMillis() / 1000;
                                    pVar2.bWA = 320;
                                    m.TI().a(pVar2.fileName, pVar2);
                                } else {
                                    q.nP(pVar2.fileName);
                                }
                            }
                            if (pVar2.enH >= pVar2.emu) {
                                x.i("MicroMsg.SceneVoiceService", "file: " + pVar2.fileName + " stat:" + pVar2.status + " now:" + pVar2.enH + " net:" + pVar2.emu);
                            } else {
                                iVar.bFe.offer(pVar2);
                                iVar.bFf.put(pVar2.fileName, null);
                            }
                        }
                        if (pVar2.TM()) {
                            x.i("MicroMsg.SceneVoiceService", "now " + currentTimeMillis + "info.getLastModifyTime()  " + pVar2.enK + "  info.getStatus() " + pVar2.status + "  info.getCreateTime() " + pVar2.createTime);
                            if (currentTimeMillis - pVar2.enK > 10 && (pVar2.status == 2 || pVar2.status == 1)) {
                                x.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fileName + " last:" + bi.gb(pVar2.enK) + " now:" + gb);
                                q.nP(pVar2.fileName);
                            } else if (currentTimeMillis - pVar2.createTime > 600 && pVar2.status == 3) {
                                x.e("MicroMsg.SceneVoiceService", "time out file: " + pVar2.fileName + " last:" + bi.gb(pVar2.enK) + " now:" + gb);
                                q.nP(pVar2.fileName);
                            } else if (pVar2.bWJ.length() <= 0) {
                                x.e("MicroMsg.SceneVoiceService", "Create a new ChatRoom? , set username first :" + pVar2.fileName);
                            } else {
                                iVar.bFd.offer(pVar2.fileName);
                                iVar.bFf.put(pVar2.fileName, null);
                            }
                        }
                    }
                }
                x.i("MicroMsg.SceneVoiceService", "GetNeedRun procing:" + iVar.bFf.size() + " [recv:" + iVar.bFe.size() + ",send:" + iVar.bFd.size() + "]");
                iVar.bFe.size();
                iVar.bFd.size();
            }
        }
        if (iVar.bFg || iVar.bFe.size() != 0 || iVar.bFh || iVar.bFd.size() != 0) {
            if (!iVar.bFg && iVar.bFe.size() > 0) {
                Object obj;
                pVar2 = (p) iVar.bFe.poll();
                String str = pVar2.fileName;
                if (((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().dY(pVar2.bYu)) {
                    x.i("MicroMsg.SceneVoiceService", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", new Object[]{Long.valueOf(pVar2.bYu)});
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    x.i("MicroMsg.SceneVoiceService", "Start Recv :" + str);
                    if (str != null) {
                        iVar.bFf.put(str, new a());
                        iVar.bFg = true;
                        g.DF().a(new com.tencent.mm.modelvoice.e(pVar2), 0);
                    }
                } else if (bi.oV(pVar2.fileName).length() > 0) {
                    m.TI().jy(pVar2.fileName);
                    return;
                } else {
                    x.i("MicroMsg.SceneVoiceService", "[oneliang] the length of voice info file name is zero");
                    return;
                }
            }
            if (!iVar.bFh && iVar.bFd.size() > 0) {
                String str2 = (String) iVar.bFd.poll();
                x.i("MicroMsg.SceneVoiceService", "Start Send :" + str2);
                if (str2 != null) {
                    iVar.bFf.put(str2, new a());
                    iVar.bFh = true;
                    g.DF().a(new f(str2), 0);
                    return;
                }
                return;
            }
            return;
        }
        iVar.wx();
        x.i("MicroMsg.SceneVoiceService", "No Data Any More , Stop Service");
    }

    static /* synthetic */ int wy() {
        int i = bFl;
        bFl = i + 1;
        return i;
    }

    static /* synthetic */ int wz() {
        int i = bFl;
        bFl = i - 1;
        return i;
    }

    public i() {
        g.DF().a(127, this);
        g.DF().a(128, this);
    }

    public final void a(int i, int i2, String str, l lVar) {
        g.Em().H(new 1(this, lVar, i, i2));
    }

    private void wx() {
        this.bFf.clear();
        this.bFd.clear();
        this.bFe.clear();
        this.bFh = false;
        this.bFg = false;
        this.bFi = false;
        x.i("MicroMsg.SceneVoiceService", "Finish service use time(ms):" + this.bFn.Ad());
    }

    public final void run() {
        g.Em().H(new 2(this));
    }
}
