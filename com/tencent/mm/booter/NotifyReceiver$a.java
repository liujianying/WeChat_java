package com.tencent.mm.booter;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class NotifyReceiver$a implements e {
    private static long cXd = 0;

    static /* synthetic */ void a(NotifyReceiver$a notifyReceiver$a) {
        g.Ek();
        g.Em().H(new Runnable() {
            public final void run() {
                if (g.Eg().Dx()) {
                    int i;
                    if (bi.f((Integer) g.Ei().DT().get(15, null)) == 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        x.e("MicroMsg.NotifyReceiver", "not init finish , do not post sync task");
                        return;
                    }
                    long VF = bi.VF();
                    if (VF - NotifyReceiver$a.cXd <= 0 || VF - NotifyReceiver$a.cXd >= 10000) {
                        NotifyReceiver$a.cXd = VF;
                        x.i("MicroMsg.NotifyReceiver", "begin post sync task");
                        VF = bi.VG();
                        a.sFg.m(new lw());
                        x.i("MicroMsg.NotifyReceiver", "end post sync task, cost=%d, Idle done", new Object[]{Long.valueOf(bi.bI(VF))});
                        NotifyReceiver$a.this.aF(3000);
                        return;
                    }
                    x.d("MicroMsg.NotifyReceiver", "sync task limit now - last : %d", new Object[]{Long.valueOf(VF - NotifyReceiver$a.cXd)});
                }
            }

            public final String toString() {
                return super.toString() + "|doPostSyncTask";
            }
        });
    }

    public final void a(int i, int i2, String str, l lVar) {
        long j;
        long hashCode = (long) lVar.hashCode();
        if (lVar.getType() == 268369922) {
            j = ((com.tencent.mm.modelmulti.g) lVar).dYY;
        } else {
            j = hashCode;
        }
        try {
            NotifyReceiver.xE().lock();
            synchronized (NotifyReceiver.access$400()) {
                String str2 = "MicroMsg.NotifyReceiver";
                String str3 = "NotifyReceiver onSceneEnd type:%d syncHash: %d hashInMemo: %b isLocking: %b";
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(lVar.getType());
                objArr[1] = Long.valueOf(j);
                objArr[2] = Boolean.valueOf(NotifyReceiver.xF().contains(Long.valueOf(j)));
                objArr[3] = Boolean.valueOf(NotifyReceiver.xD() != null ? NotifyReceiver.xD().isLocking() : false);
                x.i(str2, str3, objArr);
            }
            NotifyReceiver.xF().remove(Long.valueOf(j));
            try {
                NotifyReceiver.xE().unlock();
            } catch (Exception e) {
            }
            try {
                NotifyReceiver.xE().lock();
                if (NotifyReceiver.xF().isEmpty()) {
                    synchronized (NotifyReceiver.access$400()) {
                        if (NotifyReceiver.xD() != null) {
                            NotifyReceiver.xD().unLock();
                        }
                    }
                    x.i("MicroMsg.NotifyReceiver", "all scene done, unlock wakelock.");
                } else {
                    x.i("MicroMsg.NotifyReceiver", "rest %d scene undone, keep wakelock.", new Object[]{Integer.valueOf(NotifyReceiver.xF().size())});
                }
                try {
                    NotifyReceiver.xE().unlock();
                } catch (Exception e2) {
                }
                switch (lVar.getType()) {
                    case 138:
                        if (g.Eg().Dx()) {
                            Looper.myQueue().addIdleHandler(new IdleHandler() {
                                public final boolean queueIdle() {
                                    NotifyReceiver$a.a(NotifyReceiver$a.this);
                                    return false;
                                }
                            });
                            if (i == 0 && i2 == 0 && com.tencent.mm.model.a.FJ()) {
                                try {
                                    g.Ek();
                                    com.tencent.mm.model.a aVar = g.Eg().dps;
                                    if (aVar.dzY > -1) {
                                        aVar.dzY++;
                                    }
                                    x.i("MicroMsg.AccInfoCacheInWorker", "countNormalCgi :%s ", new Object[]{Long.valueOf(aVar.dzY)});
                                    if (aVar.dzY == 2 || aVar.dzY == 5) {
                                        f.mDy.a(226, aVar.dzY == 2 ? 37 : 38, 1, false);
                                        f.mDy.h(11098, new Object[]{Integer.valueOf(2001), Long.valueOf(aVar.dzY)});
                                        break;
                                    }
                                } catch (Throwable th) {
                                    x.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", new Object[]{bi.i(th)});
                                    break;
                                }
                            }
                        }
                        break;
                }
                aF(7000);
            } catch (Throwable th2) {
                try {
                    NotifyReceiver.xE().unlock();
                } catch (Exception e3) {
                }
                throw th2;
            }
        } catch (Throwable th22) {
            try {
                NotifyReceiver.xE().unlock();
            } catch (Exception e4) {
            }
            throw th22;
        }
    }

    private void aF(long j) {
        if (aa.US().getBoolean("is_in_notify_mode", false)) {
            new ag(Looper.myLooper()).postDelayed(new 2(this), j);
        }
    }
}
