package com.d.a.a;

import android.net.wifi.ScanResult;
import android.os.Handler;
import com.d.a.a.r.f;
import com.d.a.a.u.e;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.appbrand.s$l;
import java.lang.ref.WeakReference;
import java.util.List;

abstract class b extends a {
    private z bgC;

    private static class a implements Runnable {
        private final WeakReference<b> bgD;
        private final p bgE;

        private a(b bVar, p pVar) {
            if (bVar == null || pVar == null) {
                throw new Exception("CoreAssembly: HandleMsgTask: null arg");
            }
            this.bgD = new WeakReference(bVar);
            this.bgE = pVar;
        }

        /* synthetic */ a(b bVar, p pVar, byte b) {
            this(bVar, pVar);
        }

        public final void run() {
            b bVar = (b) this.bgD.get();
            if (bVar != null) {
                switch (this.bgE.what) {
                    case 202:
                        f fVar = (f) this.bgE;
                        if (fVar.bjW == 1) {
                            bVar.a(fVar.bjX, fVar.bjx, fVar.bjy);
                            return;
                        } else {
                            bVar.a(fVar.bjW, fVar.message, fVar.bjx, fVar.bjy);
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    abstract void a(double d, double d2, int i, int i2, int i3, int i4, int i5, float f, long j, long j2);

    abstract void a(float f, float f2, int i, float f3, float f4, float f5, long j);

    abstract void a(int i, String str, long j, long j2);

    abstract void a(x xVar, long j, long j2);

    abstract void a(List<ScanResult> list, long j, long j2);

    b() {
        super(new d[]{ab.sZ(), r.sC(), u.sT(), k.sy()});
    }

    synchronized void a(Handler handler, com.d.a.a.d.a aVar) {
        if (handler == null) {
            throw new Exception("CoreAssembly: master thread handler must be specified and cannot be null");
        }
        this.bgC = z.a(handler);
        super.a(handler, aVar);
    }

    final void a(Handler handler, Handler[] handlerArr) {
        handlerArr[0] = handler;
        handlerArr[1] = null;
        handlerArr[2] = handler;
        handlerArr[3] = handler;
    }

    final void a(com.d.a.a.d.a aVar, com.d.a.a.d.a[] aVarArr) {
        aVarArr[0] = aVar;
        aVarArr[1] = null;
        aVarArr[2] = null;
        aVarArr[3] = a(aVar);
    }

    public void a(p pVar) {
        switch (pVar.what) {
            case s$l.AppCompatTheme_buttonStyleSmall /*101*/:
                a(((com.d.a.a.ab.a) pVar).bng, pVar.bjx, pVar.bjy);
                return;
            case av.CTRL_INDEX /*201*/:
                b(pVar);
                return;
            case 202:
                b(pVar);
                return;
            case 301:
                e eVar = (e) pVar;
                a(eVar.x, eVar.y, eVar.blZ, eVar.blX, eVar.blY, eVar.aex, eVar.bjy);
                return;
            case 401:
                com.d.a.a.k.b bVar = (com.d.a.a.k.b) pVar;
                a(bVar.lat, bVar.lng, Double.valueOf(bVar.biE).intValue(), Math.round(bVar.biF), Math.round(bVar.aex), bVar.biH, bVar.biI, bVar.biG, bVar.biJ, bVar.bjy);
                return;
            default:
                return;
        }
    }

    com.d.a.a.k.a a(com.d.a.a.d.a aVar) {
        if (aVar == null) {
            return null;
        }
        return new com.d.a.a.k.a(Math.max(aVar.bgK, 10000));
    }

    private void b(p pVar) {
        if (this.bgC != null) {
            try {
                this.bgC.execute(new a(this, pVar, (byte) 0));
            } catch (Exception e) {
            }
        }
    }
}
