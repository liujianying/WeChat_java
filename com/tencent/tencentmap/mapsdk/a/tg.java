package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.tencentmap.mapsdk.a.tp.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class tg implements a {
    private static final TimeUnit a = TimeUnit.SECONDS;
    private static final int b = Runtime.getRuntime().availableProcessors();
    private sl c;
    private Map<String, List<td>> d = new HashMap();
    private Map<String, List<td>> e = new HashMap();
    private final BlockingQueue<Runnable> f = new LinkedBlockingQueue();
    private final BlockingQueue<Runnable> g = new LinkedBlockingQueue();
    private ExecutorService h;
    private ExecutorService i;
    private ThreadFactory j = new 1(this);

    public tg(sl slVar) {
        int i;
        int i2;
        this.c = slVar;
        if (b < 4) {
            i = 3;
            i2 = 3;
        } else {
            i = 4;
            i2 = 4;
        }
        this.i = new ThreadPoolExecutor(i2, i, 30, TimeUnit.SECONDS, this.g, this.j);
        this.h = new ThreadPoolExecutor(1, 1, 30, a, this.f);
    }

    static /* synthetic */ void a(tg tgVar, td tdVar, boolean z, tf tfVar) {
        String tdVar2 = tdVar.toString();
        synchronized (tgVar.d) {
            List list = (List) tgVar.d.get(tdVar2);
            if (list != null) {
                list.add(tdVar);
            } else {
                list = new ArrayList();
                list.add(tdVar);
                tgVar.d.put(tdVar2, list);
                try {
                    tp tpVar = new tp(tgVar, tdVar);
                    tpVar.a(z);
                    tpVar.a(tfVar);
                    if (!tgVar.i.isShutdown()) {
                        tgVar.i.submit(tpVar);
                    }
                } catch (Exception e) {
                    new StringBuilder("Submit get error:").append(e.getMessage());
                }
            }
        }
        return;
    }

    public final void a() {
        if (this.f != null) {
            this.f.clear();
        }
        if (this.g != null) {
            this.g.clear();
        }
        if (this.h != null) {
            this.h.shutdownNow();
            this.h = null;
        }
        if (this.i != null) {
            this.i.shutdown();
            this.i = null;
        }
    }

    public final void a(tp tpVar) {
        if (tpVar != null) {
            List<td> list;
            String b = tpVar.b();
            Bitmap a = tpVar.a();
            synchronized (this.d) {
                list = (List) this.e.remove(b);
                this.d.remove(b);
            }
            if (!(list == null || a == null || a.isRecycled())) {
                for (td tdVar : list) {
                    if (!tdVar.i()) {
                        tdVar.a(a.copy(a.getConfig(), false));
                    }
                }
            }
            tpVar.c();
        }
        this.c.c().postInvalidate();
    }

    public final void a(ArrayList<tc> arrayList) {
        if (!sz.a(arrayList)) {
            this.f.clear();
            2 2 = new 2(this, arrayList);
            try {
                if (!this.h.isShutdown()) {
                    this.h.execute(2);
                }
            } catch (Exception e) {
                new StringBuilder("getTiles get error:").append(e.getMessage());
            }
        }
    }

    public final void b(tp tpVar) {
        if (tpVar != null) {
            String b = tpVar.b();
            synchronized (this.d) {
                this.e.put(b, (List) this.d.remove(b));
            }
        }
    }
}
