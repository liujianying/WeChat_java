package com.tencent.mm.kiss.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class b {
    private static b dtf;
    public LayoutInflater Bc;
    private ConcurrentHashMap<String, c> dte = new ConcurrentHashMap();
    public Looper dtg;
    public ag dth;
    public boolean dti = false;
    public boolean dtj = false;
    public b dtk;
    public int mMode = 2;

    private static final class a implements OnAttachStateChangeListener {
        private String dtm;
        private b dtn;
        private c dto = null;

        public a(String str, b bVar) {
            this.dtm = str;
            this.dtn = bVar;
        }

        public final void onViewAttachedToWindow(View view) {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onViewDetachedFromWindow(android.view.View r5) {
            /*
            r4 = this;
            r0 = r4.dtn;
            r0 = r0.dte;
            r1 = r4.dtm;
            r0 = r0.get(r1);
            r0 = (com.tencent.mm.kiss.a.c) r0;
            r1 = r4.dtn;
            r1 = r1.mMode;
            r2 = 1;
            if (r1 != r2) goto L_0x0044;
        L_0x0017:
            if (r0 == 0) goto L_0x0029;
        L_0x0019:
            monitor-enter(r0);
            r1 = r0.dtx;	 Catch:{ all -> 0x0041 }
            r1.remove(r5);	 Catch:{ all -> 0x0041 }
            r1 = r0.dtw;	 Catch:{ all -> 0x0041 }
            r1.add(r5);	 Catch:{ all -> 0x0041 }
            monitor-exit(r0);	 Catch:{ all -> 0x0041 }
            r0 = r4.dto;
            if (r0 == 0) goto L_0x0029;
        L_0x0029:
            r5.removeOnAttachStateChangeListener(r4);
            r0 = r4.dtn;
            r0 = r0.dtk;
            if (r0 == 0) goto L_0x0040;
        L_0x0034:
            r0 = r4.dtn;
            r0 = r0.dtk;
            r1 = r0.init();	 Catch:{ Throwable -> 0x0059 }
            if (r1 != 0) goto L_0x004a;
        L_0x0040:
            return;
        L_0x0041:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0041 }
            throw r1;
        L_0x0044:
            r1 = r4.dtn;
            com.tencent.mm.kiss.a.b.a(r1, r0);
            goto L_0x0029;
        L_0x004a:
            r1 = r0.mHandler;
            r2 = 0;
            r1.removeCallbacksAndMessages(r2);
            r0 = r0.mHandler;
            r1 = 0;
            r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r0.sendEmptyMessageDelayed(r1, r2);
            goto L_0x0040;
        L_0x0059:
            r0 = move-exception;
            goto L_0x0040;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.kiss.a.b.a.onViewDetachedFromWindow(android.view.View):void");
        }
    }

    private static final class b {
        Class dtp;
        Field dtq;
        Class dtr;
        Field dts = null;
        private boolean dtt = false;
        private boolean dtu = false;
        ag mHandler;

        public b(Looper looper) {
            this.mHandler = new ag(looper) {
                public final void handleMessage(Message message) {
                    long nanoTime;
                    try {
                        nanoTime = System.nanoTime();
                        b bVar = b.this;
                        ThreadLocal threadLocal = (ThreadLocal) bVar.dtq.get(null);
                        if (threadLocal != null) {
                            Object obj = threadLocal.get();
                            if (obj != null) {
                                try {
                                    obj = bVar.dts.get(obj);
                                    if (obj != null) {
                                        if (obj instanceof List) {
                                            ((List) obj).clear();
                                        }
                                    }
                                } catch (Throwable e) {
                                    x.printErrStackTrace("KISS.InflateRecycler", e, "", new Object[0]);
                                }
                            }
                        }
                    } catch (Throwable e2) {
                        x.printErrStackTrace("KISS.InflateRecycler", e2, "", new Object[0]);
                    } catch (Throwable th) {
                        return;
                    }
                    long nanoTime2 = System.nanoTime() - nanoTime;
                    x.i("KISS.InflateRecycler", "durtion %s", Long.valueOf(nanoTime2));
                }
            };
        }

        final boolean init() {
            if (this.dtt) {
                return this.dtu;
            }
            this.dtt = true;
            try {
                this.dtp = Class.forName("android.view.ViewRootImpl");
                try {
                    this.dtq = this.dtp.getDeclaredField("sRunQueues");
                    this.dtq.setAccessible(true);
                    try {
                        this.dtr = Class.forName("android.view.ViewRootImpl$RunQueue");
                        try {
                            this.dts = this.dtr.getDeclaredField("mActions");
                            this.dts.setAccessible(true);
                            this.dtu = true;
                            return true;
                        } catch (Throwable e) {
                            x.printErrStackTrace("KISS.InflateRecycler", e, "", new Object[0]);
                            return false;
                        }
                    } catch (Throwable e2) {
                        x.printErrStackTrace("KISS.InflateRecycler", e2, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable e22) {
                    x.printErrStackTrace("KISS.InflateRecycler", e22, "", new Object[0]);
                    return false;
                }
            } catch (Throwable e222) {
                x.printErrStackTrace("KISS.InflateRecycler", e222, "", new Object[0]);
                return false;
            }
        }
    }

    public interface c {
    }

    /* renamed from: com.tencent.mm.kiss.a.b$1 */
    class AnonymousClass1 extends ag {
        public AnonymousClass1(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            x.i("KISS.InflateRecycler", "InflateViewRecycler start %s", Long.valueOf(System.currentTimeMillis()));
            c cVar = (c) message.obj;
            int size = cVar.dty - cVar.dtw.size();
            int i = cVar.Ba;
            x.i("KISS.InflateRecycler", "InflateViewRecycler for %s", cVar.dtm);
            for (int i2 = 0; i2 < size; i2++) {
                try {
                    View inflate = b.this.Bc.inflate(i, cVar.dtA, false);
                    synchronized (cVar) {
                        cVar.dtw.add(inflate);
                    }
                    if (!(cVar.dtz == null || cVar.dtz.length == 0)) {
                        for (int i3 = 0; i3 < cVar.dtz.length; i3 += 2) {
                            View findViewById = inflate.findViewById(cVar.dtz[i3]);
                            if (findViewById != null && (findViewById instanceof ViewStub)) {
                                int i4 = cVar.dtz[i3 + 1];
                                if (i4 != 0) {
                                    ((ViewStub) findViewById).setLayoutResource(i4);
                                }
                                ((ViewStub) findViewById).inflate();
                            }
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("KISS.InflateRecycler", e, "pre inflate failed.", new Object[0]);
                }
            }
            x.i("KISS.InflateRecycler", "InflateViewRecycler end %s", Long.valueOf(System.currentTimeMillis()));
            x.i("KISS.InflateRecycler", "preload done");
        }
    }

    static /* synthetic */ void a(b bVar, c cVar) {
        if (bVar.dti && !bVar.dtj && cVar.dty > cVar.dtw.size()) {
            bVar.dth.sendMessage(bVar.dth.obtainMessage(0, cVar));
        }
    }

    static {
        dtf = null;
        dtf = new b();
    }

    public static b EY() {
        return dtf;
    }

    public final View a(Activity activity, String str, int i) {
        if (this.dtj) {
            x.i("KISS.InflateRecycler", "not support application inflate");
            return activity.getLayoutInflater().inflate(i, null);
        } else if (!this.dti) {
            return activity.getLayoutInflater().inflate(i, null);
        } else {
            c cVar = (c) this.dte.get(str);
            if (cVar != null) {
                View view;
                synchronized (cVar) {
                    view = (View) cVar.dtw.poll();
                    if (this.mMode == 1) {
                        cVar.dtx.add(view);
                    }
                }
                if (view != null) {
                    x.i("KISS.InflateRecycler", "cache reach %s", str);
                    view.addOnAttachStateChangeListener(new a(str, this));
                    return view;
                }
            }
            x.i("KISS.InflateRecycler", "no cache reach %s", str);
            return this.Bc.inflate(i, null);
        }
    }

    public final boolean a(String str, int i, int i2, int... iArr) {
        return a(str, i, i2, null, iArr);
    }

    public final boolean a(String str, int i, int i2, ViewGroup viewGroup, int... iArr) {
        if (!this.dti) {
            return false;
        }
        if (this.dtj) {
            x.i("KISS.InflateRecycler", "not support application inflate");
            return false;
        }
        if (viewGroup != null) {
            if (VERSION.SDK_INT >= 19) {
                Assert.assertFalse(viewGroup.isAttachedToWindow());
            }
            Assert.assertTrue(viewGroup.getParent() == null);
        }
        if (((c) this.dte.get(str)) != null) {
            return false;
        }
        c cVar = new c();
        this.dte.put(str, cVar);
        cVar.dty = i;
        cVar.dtm = str;
        cVar.Ba = i2;
        cVar.dtz = iArr;
        cVar.dtA = viewGroup;
        this.dth.sendMessage(this.dth.obtainMessage(0, cVar));
        return true;
    }
}
