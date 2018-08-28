package android.support.v4.view;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.support.v4.view.aj.AnonymousClass1;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class ai {
    public static final g xh;
    public WeakReference<View> xd;
    private Runnable xe = null;
    private Runnable xf = null;
    private int xg = -1;

    interface g {
        void a(ai aiVar, View view);

        void a(ai aiVar, View view, float f);

        void a(ai aiVar, View view, am amVar);

        void a(View view, long j);

        void a(View view, ao aoVar);

        void a(View view, Interpolator interpolator);

        long aq(View view);

        void b(ai aiVar, View view);

        void b(ai aiVar, View view, float f);

        void b(View view, long j);

        void c(ai aiVar, View view, float f);

        void d(ai aiVar, View view, float f);

        void e(ai aiVar, View view, float f);
    }

    static class a implements g {
        WeakHashMap<View, Runnable> xi = null;

        class a implements Runnable {
            WeakReference<View> cB;
            ai xj;

            /* synthetic */ a(a aVar, ai aiVar, View view, byte b) {
                this(aiVar, view);
            }

            private a(ai aiVar, View view) {
                this.cB = new WeakReference(view);
                this.xj = aiVar;
            }

            public final void run() {
                View view = (View) this.cB.get();
                if (view != null) {
                    a.this.c(this.xj, view);
                }
            }
        }

        a() {
        }

        public void a(View view, long j) {
        }

        public void a(ai aiVar, View view, float f) {
            d(aiVar, view);
        }

        public void b(ai aiVar, View view, float f) {
            d(aiVar, view);
        }

        public void c(ai aiVar, View view, float f) {
            d(aiVar, view);
        }

        public long aq(View view) {
            return 0;
        }

        public void a(View view, Interpolator interpolator) {
        }

        public void b(View view, long j) {
        }

        public void d(ai aiVar, View view, float f) {
            d(aiVar, view);
        }

        public void e(ai aiVar, View view, float f) {
            d(aiVar, view);
        }

        public void a(ai aiVar, View view) {
            d(aiVar, view);
        }

        public void b(ai aiVar, View view) {
            if (this.xi != null) {
                Runnable runnable = (Runnable) this.xi.get(view);
                if (runnable != null) {
                    view.removeCallbacks(runnable);
                }
            }
            c(aiVar, view);
        }

        public void a(ai aiVar, View view, am amVar) {
            view.setTag(2113929216, amVar);
        }

        public void a(View view, ao aoVar) {
        }

        final void c(ai aiVar, View view) {
            am amVar;
            Object tag = view.getTag(2113929216);
            if (tag instanceof am) {
                amVar = (am) tag;
            } else {
                amVar = null;
            }
            Runnable c = aiVar.xe;
            Runnable d = aiVar.xf;
            aiVar.xe = null;
            aiVar.xf = null;
            if (c != null) {
                c.run();
            }
            if (amVar != null) {
                amVar.p(view);
                amVar.q(view);
            }
            if (d != null) {
                d.run();
            }
            if (this.xi != null) {
                this.xi.remove(view);
            }
        }

        private void d(ai aiVar, View view) {
            Runnable runnable = null;
            if (this.xi != null) {
                runnable = (Runnable) this.xi.get(view);
            }
            if (runnable == null) {
                runnable = new a(this, aiVar, view, (byte) 0);
                if (this.xi == null) {
                    this.xi = new WeakHashMap();
                }
                this.xi.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }
    }

    static class b extends a {
        WeakHashMap<View, Integer> xl = null;

        static class a implements am {
            ai xj;
            boolean xm;

            a(ai aiVar) {
                this.xj = aiVar;
            }

            public final void p(View view) {
                am amVar;
                this.xm = false;
                if (this.xj.xg >= 0) {
                    z.a(view, 2, null);
                }
                if (this.xj.xe != null) {
                    Runnable c = this.xj.xe;
                    this.xj.xe = null;
                    c.run();
                }
                Object tag = view.getTag(2113929216);
                if (tag instanceof am) {
                    amVar = (am) tag;
                } else {
                    amVar = null;
                }
                if (amVar != null) {
                    amVar.p(view);
                }
            }

            public final void q(View view) {
                if (this.xj.xg >= 0) {
                    z.a(view, this.xj.xg, null);
                    this.xj.xg = -1;
                }
                if (VERSION.SDK_INT >= 16 || !this.xm) {
                    am amVar;
                    if (this.xj.xf != null) {
                        Runnable d = this.xj.xf;
                        this.xj.xf = null;
                        d.run();
                    }
                    Object tag = view.getTag(2113929216);
                    if (tag instanceof am) {
                        amVar = (am) tag;
                    } else {
                        amVar = null;
                    }
                    if (amVar != null) {
                        amVar.q(view);
                    }
                    this.xm = true;
                }
            }

            public final void ar(View view) {
                am amVar;
                Object tag = view.getTag(2113929216);
                if (tag instanceof am) {
                    amVar = (am) tag;
                } else {
                    amVar = null;
                }
                if (amVar != null) {
                    amVar.ar(view);
                }
            }
        }

        b() {
        }

        public final void a(View view, long j) {
            view.animate().setDuration(j);
        }

        public final void a(ai aiVar, View view, float f) {
            view.animate().alpha(f);
        }

        public final void b(ai aiVar, View view, float f) {
            view.animate().translationX(f);
        }

        public final void c(ai aiVar, View view, float f) {
            view.animate().translationY(f);
        }

        public final long aq(View view) {
            return view.animate().getDuration();
        }

        public final void a(View view, Interpolator interpolator) {
            view.animate().setInterpolator(interpolator);
        }

        public final void b(View view, long j) {
            view.animate().setStartDelay(j);
        }

        public final void d(ai aiVar, View view, float f) {
            view.animate().scaleX(f);
        }

        public final void e(ai aiVar, View view, float f) {
            view.animate().scaleY(f);
        }

        public final void a(ai aiVar, View view) {
            view.animate().cancel();
        }

        public final void b(ai aiVar, View view) {
            view.animate().start();
        }

        public void a(ai aiVar, View view, am amVar) {
            view.setTag(2113929216, amVar);
            view.animate().setListener(new AnonymousClass1(new a(aiVar), view));
        }
    }

    static class d extends b {
        d() {
        }

        public final void a(ai aiVar, View view, am amVar) {
            if (amVar != null) {
                view.animate().setListener(new ak.AnonymousClass1(amVar, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    static class c extends d {
        c() {
        }
    }

    static class e extends c {
        e() {
        }

        public final void a(View view, ao aoVar) {
            AnimatorUpdateListener animatorUpdateListener = null;
            if (aoVar != null) {
                animatorUpdateListener = new al.AnonymousClass1(aoVar, view);
            }
            view.animate().setUpdateListener(animatorUpdateListener);
        }
    }

    static class f extends e {
        f() {
        }
    }

    ai(View view) {
        this.xd = new WeakReference(view);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            xh = new f();
        } else if (i >= 19) {
            xh = new e();
        } else if (i >= 18) {
            xh = new c();
        } else if (i >= 16) {
            xh = new d();
        } else if (i >= 14) {
            xh = new b();
        } else {
            xh = new a();
        }
    }

    public final ai h(long j) {
        View view = (View) this.xd.get();
        if (view != null) {
            xh.a(view, j);
        }
        return this;
    }

    public final ai t(float f) {
        View view = (View) this.xd.get();
        if (view != null) {
            xh.a(this, view, f);
        }
        return this;
    }

    public final ai u(float f) {
        View view = (View) this.xd.get();
        if (view != null) {
            xh.b(this, view, f);
        }
        return this;
    }

    public final ai v(float f) {
        View view = (View) this.xd.get();
        if (view != null) {
            xh.c(this, view, f);
        }
        return this;
    }

    public final ai c(Interpolator interpolator) {
        View view = (View) this.xd.get();
        if (view != null) {
            xh.a(view, interpolator);
        }
        return this;
    }

    public final ai i(long j) {
        View view = (View) this.xd.get();
        if (view != null) {
            xh.b(view, j);
        }
        return this;
    }

    public final ai w(float f) {
        View view = (View) this.xd.get();
        if (view != null) {
            xh.d(this, view, f);
        }
        return this;
    }

    public final ai x(float f) {
        View view = (View) this.xd.get();
        if (view != null) {
            xh.e(this, view, f);
        }
        return this;
    }

    public final void cancel() {
        View view = (View) this.xd.get();
        if (view != null) {
            xh.a(this, view);
        }
    }

    public final void start() {
        View view = (View) this.xd.get();
        if (view != null) {
            xh.b(this, view);
        }
    }

    public final ai a(am amVar) {
        View view = (View) this.xd.get();
        if (view != null) {
            xh.a(this, view, amVar);
        }
        return this;
    }

    public final ai a(ao aoVar) {
        View view = (View) this.xd.get();
        if (view != null) {
            xh.a(view, aoVar);
        }
        return this;
    }
}
