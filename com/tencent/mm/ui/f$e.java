package com.tencent.mm.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.f$e.c;
import java.util.LinkedList;

class f$e {
    final /* synthetic */ f thN;
    com.tencent.mm.ui.f$e.b thR;
    private c thS;
    LinkedList<Integer> thT;
    int thU;

    class b extends ag {
        boolean thX;
        public final int thY = 1;
        public final int thZ = 2;

        public b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (!this.thX) {
                synchronized (f$e.this) {
                    f$e.this.thU = f$e.this.cpf();
                    x.i(f$e.this.thN.TAG, "newcursor updateWorkerRefresh status %d", new Object[]{Integer.valueOf(f$e.this.thU)});
                }
                if (message.what == 1) {
                    f.d(f$e.this.thN);
                } else if (message.what == 2) {
                    f.a(f$e.this.thN, (f$c) message.obj, false, true);
                }
            }
        }
    }

    static /* synthetic */ void a(f$e f_e) {
        int cpf;
        synchronized (f_e) {
            cpf = f_e.cpf();
            f_e.thT.clear();
        }
        a aVar = new a(f_e, cpf);
        if (aVar.thV == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            f$c f_c = new f$c(aVar.thW.thN, aVar.thW.thN.coW());
            cpf = f_c.getCount();
            x.i(aVar.thW.thN.TAG, "newcursor fillCursor last : %d  count %d ", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(cpf)});
            b bVar = aVar.thW.thR;
            Message obtain = Message.obtain();
            obtain.obj = f_c;
            obtain.what = 2;
            bVar.sendMessage(obtain);
            return;
        }
        aVar.thW.thR.sendEmptyMessage(1);
    }

    public f$e(f fVar) {
        this.thN = fVar;
        cpc();
    }

    private void cpc() {
        this.thR = new b(Looper.getMainLooper());
        this.thS = new c(this, au.Em().lnJ.getLooper());
    }

    private void cpd() {
        c cVar = this.thS;
        cVar.removeMessages(cVar.tib);
        cVar.removeMessages(cVar.tic);
        b bVar = this.thR;
        bVar.thX = true;
        bVar.removeMessages(1);
        bVar.removeMessages(2);
        this.thT.clear();
        this.thU = 0;
    }

    public final synchronized void cpe() {
        x.i(this.thN.TAG, "newcursor resetQueue ");
        cpd();
        cpc();
    }

    public final synchronized void quit() {
        x.i(this.thN.TAG, "newcursor quit ");
        cpd();
    }

    final int cpf() {
        if (this.thT.size() > 1) {
            return 2;
        }
        if (this.thT.size() == 1) {
            return ((Integer) this.thT.get(0)).intValue();
        }
        return 0;
    }

    public final synchronized boolean cpg() {
        return this.thU != 0;
    }

    final synchronized void cph() {
        this.thS.lastUpdateTime = System.currentTimeMillis();
    }

    final synchronized int cpi() {
        return this.thU;
    }

    final synchronized void DH(int i) {
        if (!this.thT.contains(Integer.valueOf(i))) {
            this.thT.add(Integer.valueOf(i));
        }
        this.thU = cpf();
        c cVar = this.thS;
        cVar.sendEmptyMessage(cVar.tic);
    }
}
