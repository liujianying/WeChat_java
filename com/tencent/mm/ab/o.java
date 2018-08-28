package com.tencent.mm.ab;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class o implements e {
    private static int dJC = 1;
    private static o dJr = null;
    private boolean dJA = false;
    private al dJB = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean vD() {
            boolean z = false;
            if (o.this.dJy == null) {
                return false;
            }
            x.v("MicroMsg.NetSceneQueue", "onQueueIdle, running=%d, waiting=%d, foreground=%b", Integer.valueOf(o.this.dJu.size()), Integer.valueOf(o.this.dJv.size()), Boolean.valueOf(o.this.foreground));
            a b = o.this.dJy;
            o oVar = o.this;
            if (o.this.dJA && o.this.dJu.isEmpty() && o.this.dJv.isEmpty()) {
                z = true;
            }
            b.a(oVar, z);
            return true;
        }
    }, true);
    public e dJs;
    public ah dJt = null;
    private Vector<l> dJu = new Vector();
    private Vector<l> dJv = new Vector();
    private final Map<Integer, Set<e>> dJw = new HashMap();
    public Boolean dJx = null;
    private final a dJy;
    private long dJz = 21600000;
    public boolean foreground = false;
    private final ag handler = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            o.this.a((l) message.obj, 0);
        }
    };
    private final Object lock = new Object();

    /* renamed from: com.tencent.mm.ab.o$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ int dJE;

        public AnonymousClass4(int i) {
            this.dJE = i;
        }

        public final void run() {
            o.b(o.this, this.dJE);
        }

        public final String toString() {
            return super.toString() + "|cancelImp_" + this.dJE;
        }
    }

    public interface a {
        void a(o oVar);

        void a(o oVar, boolean z);
    }

    public final void bA(boolean z) {
        this.dJA = z;
        if (this.dJA) {
            x.e("MicroMsg.NetSceneQueue", "the working process is ready to be killed");
            al alVar = this.dJB;
            long j = this.dJz;
            alVar.J(j, j);
            return;
        }
        this.dJB.SO();
    }

    public final void a(int i, String str, int i2, boolean z) {
        if (this.dJs == null) {
            x.e("MicroMsg.NetSceneQueue", "logUtil autoAuth  == null");
        } else {
            this.dJs.a(i, str, i2, z);
        }
    }

    public final void bB(boolean z) {
        this.foreground = z;
        this.dJx = Boolean.valueOf(z);
        b.bB(z);
        HardCoderJNI.foreground = z;
        if (this.dJs == null) {
            x.e("MicroMsg.NetSceneQueue", "setForeground autoAuth  == null");
        } else {
            this.dJs.bC(z);
        }
    }

    public final int Lg() {
        try {
            if (this.dJs != null && this.dJs.Ls() != null) {
                return this.dJs.Ls().UA();
            }
            x.e("MicroMsg.NetSceneQueue", "[arthurdan.getNetworkStatus] Notice!!! autoAuth and autoAuth.getNetworkEvent() is null!!!!");
            if (ao.isConnected(ad.getContext())) {
                return 6;
            }
            return 0;
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneQueue", "exception:%s", bi.i(e));
        }
    }

    public final boolean Lh() {
        if (this.dJs != null) {
            return this.dJs.Lh();
        }
        return true;
    }

    public final String getNetworkServerIp() {
        if (this.dJs != null) {
            return this.dJs.getNetworkServerIp();
        }
        return "unknown";
    }

    private o(a aVar) {
        this.dJy = aVar;
    }

    public final void d(e eVar) {
        this.dJs = eVar;
        eVar.bC(this.foreground);
        Lk();
    }

    public static o a(a aVar) {
        if (dJr == null) {
            dJr = new o(aVar);
        }
        return dJr;
    }

    public final void a(int i, e eVar) {
        synchronized (this.dJw) {
            if (!this.dJw.containsKey(Integer.valueOf(i))) {
                this.dJw.put(Integer.valueOf(i), new HashSet());
            }
            if (!((Set) this.dJw.get(Integer.valueOf(i))).contains(eVar) && ((Set) this.dJw.get(Integer.valueOf(i))).add(eVar)) {
                ListenerInstanceMonitor.cc(eVar);
            }
        }
    }

    public final void b(int i, e eVar) {
        synchronized (this.dJw) {
            try {
                if (this.dJw.get(Integer.valueOf(i)) != null && ((Set) this.dJw.get(Integer.valueOf(i))).remove(eVar)) {
                    ListenerInstanceMonitor.cd(eVar);
                }
            } catch (Exception e) {
            }
        }
    }

    public final void reset() {
        if (this.dJs != null) {
            this.dJs.reset();
        }
        Li();
        List<l> list = this.dJv;
        this.dJv = new Vector();
        for (l lVar : list) {
            x.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + lVar.getType());
            lVar.cancel();
            c(3, -1, "doScene failed clearWaitingQueue", lVar);
        }
        list.clear();
    }

    public final void Li() {
        List<l> list = this.dJu;
        this.dJu = new Vector();
        for (l lVar : list) {
            x.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + lVar.getType());
            lVar.cancel();
            c(3, -1, "doScene failed clearRunningQueue", lVar);
        }
        list.clear();
    }

    public final void Lj() {
        x.i("MicroMsg.NetSceneQueue", "resetDispatcher");
        if (this.dJs != null) {
            this.dJs.reset();
            this.dJs = null;
        }
    }

    public final e DJ() {
        return this.dJs;
    }

    public final void cancel(final int i) {
        x.l("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", Integer.valueOf(i));
        this.dJt.H(new Runnable() {
            public final void run() {
                o.a(o.this, i);
            }

            public final String toString() {
                return super.toString() + "|cancelImp_" + i;
            }
        });
    }

    public final void c(l lVar) {
        if (lVar != null) {
            x.l("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", Integer.valueOf(lVar.hashCode()));
            lVar.cancel();
            synchronized (this.lock) {
                this.dJv.remove(lVar);
                this.dJu.remove(lVar);
            }
        }
    }

    public final boolean d(l lVar) {
        return a(lVar, 0);
    }

    public final boolean a(l lVar, int i) {
        boolean z = lVar != null || i >= 0;
        Assert.assertTrue(z);
        String str = "worker thread has not been set";
        if (this.dJt != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        if (!e(lVar)) {
            return false;
        }
        b(lVar, i);
        return true;
    }

    private void b(final l lVar, int i) {
        boolean Ll = Ll();
        int size = this.dJu.size();
        String str = "MicroMsg.NetSceneQueue";
        String str2 = "doSceneImp start: mmcgi type:%d hash[%d,%d] run:%d wait:%d afterSec:%d canDo:%b autoauth:%d";
        Object[] objArr = new Object[8];
        objArr[0] = Integer.valueOf(lVar.getType());
        objArr[1] = Integer.valueOf(lVar.hashCode());
        objArr[2] = Integer.valueOf(lVar.Lb());
        objArr[3] = Integer.valueOf(size);
        objArr[4] = Integer.valueOf(this.dJv.size());
        objArr[5] = Integer.valueOf(i);
        objArr[6] = Boolean.valueOf(Ll);
        objArr[7] = Integer.valueOf(this.dJs == null ? 0 : this.dJs.hashCode());
        x.i(str, str2, objArr);
        if (i == 0 && Ll && this.dJs != null) {
            synchronized (this.lock) {
                this.dJu.add(lVar);
                if (size == this.dJu.size()) {
                    x.w("MicroMsg.NetSceneQueue", "doSceneImp mmcgi  Add to runningQueue wrong  type:%d hash:%d run:[%d ,%d] wait:%d ", Integer.valueOf(lVar.getType()), Integer.valueOf(lVar.hashCode()), Integer.valueOf(size), Integer.valueOf(this.dJu.size()), Integer.valueOf(this.dJv.size()));
                }
            }
            this.dJt.H(new Runnable() {
                public final void run() {
                    int i;
                    String str;
                    String str2;
                    Object[] objArr;
                    int i2 = 0;
                    lVar.dJb = o.this;
                    if (lVar.aBS || o.this.dJs == null) {
                        i = 0;
                    } else {
                        i = lVar.a(o.this.dJs, o.this);
                        if (i >= 0) {
                            str = "MicroMsg.NetSceneQueue";
                            str2 = "On doscene  mmcgi type:%d hash[%d,%d] run:%d wait:%d ret:%d autoauth:%d";
                            objArr = new Object[7];
                            objArr[0] = Integer.valueOf(lVar.getType());
                            objArr[1] = Integer.valueOf(lVar.hashCode());
                            objArr[2] = Integer.valueOf(lVar.Lb());
                            objArr[3] = Integer.valueOf(o.this.dJu.size());
                            objArr[4] = Integer.valueOf(o.this.dJv.size());
                            objArr[5] = Integer.valueOf(i);
                            if (o.this.dJs == null) {
                                i = 0;
                            } else {
                                i = o.this.dJs.hashCode();
                            }
                            objArr[6] = Integer.valueOf(i);
                            x.i(str, str2, objArr);
                            lVar.dJc = false;
                            return;
                        }
                    }
                    str = "MicroMsg.NetSceneQueue";
                    str2 = "doscene mmcgi Failed type:%d hash[%d,%d] cancel[%b] run:%d wait:%d ret:%d autoauth:%d";
                    objArr = new Object[8];
                    objArr[0] = Integer.valueOf(lVar.getType());
                    objArr[1] = Integer.valueOf(lVar.hashCode());
                    objArr[2] = Integer.valueOf(lVar.Lb());
                    objArr[3] = Boolean.valueOf(lVar.aBS);
                    objArr[4] = Integer.valueOf(o.this.dJu.size());
                    objArr[5] = Integer.valueOf(o.this.dJv.size());
                    objArr[6] = Integer.valueOf(i);
                    if (o.this.dJs != null) {
                        i2 = o.this.dJs.hashCode();
                    }
                    objArr[7] = Integer.valueOf(i2);
                    x.w(str, str2, objArr);
                    lVar.dJb = null;
                    synchronized (o.this.lock) {
                        o.this.dJu.remove(lVar);
                    }
                    if (!lVar.aBS) {
                        o.this.handler.post(new Runnable() {
                            public final void run() {
                                o.this.a(3, -1, "doScene failed", lVar);
                            }
                        });
                    }
                }

                public final String toString() {
                    return super.toString() + "|doSceneImp_" + lVar + "_type=" + lVar.getType();
                }
            });
        } else if (i > 0) {
            Message obtain = Message.obtain();
            obtain.obj = lVar;
            this.handler.sendMessageDelayed(obtain, (long) i);
            x.i("MicroMsg.NetSceneQueue", "timed: type=" + lVar.getType() + " id=" + lVar.hashCode() + " cur_after_sec=" + i);
        } else {
            x.i("MicroMsg.NetSceneQueue", "waited: type=" + lVar.getType() + " id=" + lVar.hashCode() + " cur_waiting_cnt=" + this.dJv.size());
            synchronized (this.lock) {
                this.dJv.add(lVar);
            }
            x.i("MicroMsg.NetSceneQueue", "waitingQueue_size = " + this.dJv.size());
        }
        if (this.dJs != null) {
            dJC = 1;
        } else if (this.dJy == null) {
            x.e("MicroMsg.NetSceneQueue", "prepare dispatcher failed, queue idle:%s", this.dJy);
        } else {
            this.dJy.a(this);
            al alVar = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
                private long dJH = 10;

                public final boolean vD() {
                    if (o.this.dJs == null) {
                        long j = this.dJH;
                        this.dJH = j - 1;
                        if (j > 0) {
                            return true;
                        }
                    }
                    o.this.Lk();
                    return false;
                }
            }, true);
            long j = (long) (dJC * 100);
            alVar.J(j, j);
            if (dJC < 512) {
                dJC *= 2;
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        int i3 = 0;
        lVar.dJc = true;
        synchronized (this.lock) {
            this.dJu.remove(lVar);
        }
        String str2 = "MicroMsg.NetSceneQueue";
        String str3 = "onSceneEnd mmcgi type:%d hash[%d,%d] run:%d wait:%d autoauth:%d [%d,%d,%s]";
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(lVar.getType());
        objArr[1] = Integer.valueOf(lVar.hashCode());
        objArr[2] = Integer.valueOf(lVar.Lb());
        objArr[3] = Integer.valueOf(this.dJu.size());
        objArr[4] = Integer.valueOf(this.dJv.size());
        if (this.dJs != null) {
            i3 = this.dJs.hashCode();
        }
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = Integer.valueOf(i);
        objArr[7] = Integer.valueOf(i2);
        objArr[8] = str;
        x.i(str2, str3, objArr);
        Lk();
        c(i, i2, str, lVar);
        if (this.dJA && this.dJu.isEmpty() && this.dJv.isEmpty()) {
            al alVar = this.dJB;
            long j = this.dJz;
            alVar.J(j, j);
        }
    }

    private void c(int i, int i2, String str, l lVar) {
        final l lVar2 = lVar;
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        this.handler.post(new Runnable() {
            public final void run() {
                Set<e> hashSet;
                Set set = (Set) o.this.dJw.get(Integer.valueOf(lVar2.getType()));
                if (set != null && set.size() > 0) {
                    hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (e eVar : hashSet) {
                        if (eVar != null && set.contains(eVar)) {
                            eVar.a(i3, i4, str2, lVar2);
                        }
                    }
                }
                set = (Set) o.this.dJw.get(Integer.valueOf(-1));
                if (set != null && set.size() > 0) {
                    hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (e eVar2 : hashSet) {
                        if (eVar2 != null && set.contains(eVar2)) {
                            eVar2.a(i3, i4, str2, lVar2);
                        }
                    }
                }
            }
        });
    }

    private void Lk() {
        synchronized (this.lock) {
            if (this.dJv.size() > 0) {
                l lVar;
                l lVar2 = (l) this.dJv.get(0);
                int i = lVar2.priority;
                int i2 = 1;
                while (true) {
                    lVar = lVar2;
                    if (i2 >= this.dJv.size()) {
                        break;
                    }
                    if (((l) this.dJv.get(i2)).priority > i) {
                        this.dJv.get(i2);
                        if (Ll()) {
                            lVar2 = (l) this.dJv.get(i2);
                            i = lVar2.priority;
                            i2++;
                        }
                    }
                    lVar2 = lVar;
                    i2++;
                }
                this.dJv.remove(lVar);
                x.i("MicroMsg.NetSceneQueue", "waiting2running waitingQueue_size = " + this.dJv.size());
                b(lVar, 0);
            }
        }
    }

    private boolean Ll() {
        if (this.dJu.size() >= 50) {
            return false;
        }
        return true;
    }

    private boolean e(l lVar) {
        int type = lVar.getType();
        if (lVar.KX()) {
            synchronized (this.lock) {
                l lVar2;
                Iterator it = this.dJu.iterator();
                while (it.hasNext()) {
                    lVar2 = (l) it.next();
                    if (lVar2.getType() == type) {
                        x.i("MicroMsg.NetSceneQueue", "forbid in running: type=" + lVar.getType() + " id=" + lVar.hashCode() + " cur_running_cnt=" + this.dJu.size());
                        if (lVar.b(lVar2)) {
                            return true;
                        } else if (lVar.a(lVar2)) {
                            x.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + lVar.getType() + " id=" + lVar.hashCode() + " cur_running_cnt=" + this.dJu.size() + " ---" + lVar2.hashCode());
                            if (!this.foreground) {
                                x.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + lVar.getType() + "acinfo[" + lVar2.getInfo() + "] scinfo[" + lVar.getInfo() + "]");
                                x.chR();
                                Assert.assertTrue("NetsceneQueue forbid in running diagnostic: type=" + lVar.getType(), false);
                            }
                            c(lVar2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
                it = this.dJv.iterator();
                while (it.hasNext()) {
                    lVar2 = (l) it.next();
                    if (lVar2.getType() == type) {
                        x.i("MicroMsg.NetSceneQueue", "forbid in waiting: type=" + lVar.getType() + " id=" + lVar.hashCode() + " cur_waiting_cnt=" + this.dJv.size());
                        if (lVar.b(lVar2)) {
                            return true;
                        } else if (lVar.a(lVar2)) {
                            x.e("MicroMsg.NetSceneQueue", "forbid in waiting diagnostic: type=" + lVar.getType() + " id=" + lVar.hashCode() + " cur_waiting_cnt=" + this.dJv.size() + " ---" + lVar2.hashCode());
                            if (!this.foreground) {
                                x.chR();
                                Assert.assertTrue("NetsceneQueue forbid in waiting diagnostic: type=" + lVar.getType(), false);
                            }
                            c(lVar2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
