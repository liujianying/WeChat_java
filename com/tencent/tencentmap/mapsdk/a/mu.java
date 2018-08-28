package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.tencentmap.mapsdk.a.ac.b;
import com.tencent.tencentmap.mapsdk.a.ac.m;
import com.tencent.tencentmap.mapsdk.a.af.a;

public class mu extends oa implements od {
    private ks a = null;
    private mr b = null;
    private aa c = null;
    private View d = null;
    private View e = null;
    private View f = null;
    private View g = null;
    private ViewGroup h = null;
    private LinearLayout i = null;
    private boolean j = false;
    private final int k = 1;
    private final int l = 2;
    private af m = null;
    private m n = null;
    private b o = null;
    private Handler p = new 1(this);
    private a q = new 2(this);
    private a r = new a() {
    };

    public mu(aa aaVar, View view) {
        this.a = (ks) view;
        this.c = aaVar;
        this.a.m = this.q;
    }

    public void a() {
        this.p.removeCallbacks(null);
        this.a.b(kd.class);
        this.j = true;
        this.a = null;
        if (this.n != null) {
            this.n = null;
        }
        if (this.o != null) {
            this.o = null;
        }
        if (this.d != null) {
            this.d = null;
        }
        if (this.h != null) {
            this.h.removeAllViews();
            this.h = null;
        }
        if (this.i != null) {
            this.i = null;
        }
        if (this.b != null) {
            this.b = null;
        }
        if (this.c != null) {
            this.c = null;
        }
        if (this.d != null) {
            ViewGroup viewGroup = (ViewGroup) this.d;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            this.d.setBackgroundDrawable(null);
            this.d = null;
        }
    }

    pa a(pb pbVar, mr mrVar) {
        if (this.b == null) {
            this.b = mrVar;
        }
        ke kdVar = new kd(this.a);
        kdVar.a(pbVar);
        this.a.a(kdVar);
        if (this.a.a(kd.class) == null) {
            this.a.a(kd.class, (od) this);
        }
        this.a.getMap().a();
        pa paVar = new pa(pbVar, mrVar, kdVar.v());
        kdVar.x = paVar;
        return paVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void a(java.lang.String r5) {
        /*
        r4 = this;
        r0 = r4.a;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r4.a;
        r1 = r0.e;
        monitor-enter(r1);
        r0 = r4.a;	 Catch:{ all -> 0x0019 }
        r2 = 0;
        r0 = r0.b(r5, r2);	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x0017;
    L_0x0013:
        r2 = r0 instanceof com.tencent.tencentmap.mapsdk.a.kd;	 Catch:{ all -> 0x0019 }
        if (r2 != 0) goto L_0x001c;
    L_0x0017:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        goto L_0x0004;
    L_0x0019:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r0;
    L_0x001c:
        r0.d();	 Catch:{ all -> 0x0019 }
        r0 = r4.a;	 Catch:{ all -> 0x0019 }
        r0 = r0.getMarkerOnTapedId();	 Catch:{ all -> 0x0019 }
        r0 = r5.equals(r0);	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x0034;
    L_0x002b:
        r0 = r4.a;	 Catch:{ all -> 0x0019 }
        r2 = "";
        r3 = 0;
        r0.a(r2, r3);	 Catch:{ all -> 0x0019 }
    L_0x0034:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        r0 = r4.a;
        r0 = r0.getMap();
        r0.a();
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.mu.a(java.lang.String):void");
    }

    void a(String str, float f, float f2) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                } else if (a instanceof kd) {
                    ((kd) a).b(f, f2);
                    this.a.getMap().a();
                }
            }
        }
    }

    void a(String str, boolean z) {
        if (this.a != null) {
            this.a.getMap().a();
        }
    }

    void a(String str, on onVar) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                } else if (a instanceof kd) {
                    ((kd) a).a(onVar);
                    this.a.getMap().a();
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void a(java.lang.String r4, com.tencent.tencentmap.mapsdk.a.ox r5) {
        /*
        r3 = this;
        r0 = r3.a;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r3.a;
        r1 = r0.e;
        monitor-enter(r1);
        r0 = r3.a;	 Catch:{ all -> 0x0014 }
        r0 = r0.a(r4);	 Catch:{ all -> 0x0014 }
        if (r0 != 0) goto L_0x0017;
    L_0x0012:
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        goto L_0x0004;
    L_0x0014:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        throw r0;
    L_0x0017:
        r2 = r0 instanceof com.tencent.tencentmap.mapsdk.a.kd;	 Catch:{ all -> 0x0014 }
        if (r2 != 0) goto L_0x001d;
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        goto L_0x0004;
    L_0x001d:
        r0 = (com.tencent.tencentmap.mapsdk.a.kd) r0;	 Catch:{ all -> 0x0014 }
        r2 = com.tencent.tencentmap.mapsdk.a.kh.a(r5);	 Catch:{ all -> 0x0014 }
        r0.a(r2);	 Catch:{ all -> 0x0014 }
        r0 = r3.a;	 Catch:{ all -> 0x0014 }
        r0 = r0.getMarkerOnTapedId();	 Catch:{ all -> 0x0014 }
        r0 = r4.equals(r0);	 Catch:{ all -> 0x0014 }
        if (r0 == 0) goto L_0x0043;
    L_0x0032:
        r0 = r3.a;	 Catch:{ all -> 0x0014 }
        r0 = r0.f;	 Catch:{ all -> 0x0014 }
        if (r0 == 0) goto L_0x0043;
    L_0x0038:
        r0 = com.tencent.tencentmap.mapsdk.a.kh.a(r5);	 Catch:{ all -> 0x0014 }
        r2 = r3.a;	 Catch:{ all -> 0x0014 }
        r2 = r2.f;	 Catch:{ all -> 0x0014 }
        r2.b(r0);	 Catch:{ all -> 0x0014 }
    L_0x0043:
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        r0 = r3.a;
        r0 = r0.getMap();
        r0.a();
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.mu.a(java.lang.String, com.tencent.tencentmap.mapsdk.a.ox):void");
    }

    void a(String str, String str2) {
        if (this.a != null) {
            synchronized (this.a.e) {
                if (this.a.f == null) {
                } else if (str.equals(this.a.getMarkerOnTapedId())) {
                    this.a.a("", true, true);
                    i(str);
                }
            }
        }
    }

    void b(String str, String str2) {
        if (this.a != null) {
            synchronized (this.a.e) {
                if (this.a.f == null) {
                } else if (str.equals(this.a.getMarkerOnTapedId())) {
                    this.a.a("", true, true);
                    i(str);
                }
            }
        }
    }

    void b(String str, boolean z) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                    return;
                }
                a.a_(z);
                this.a.getMap().a();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean b(java.lang.String r6) {
        /*
        r5 = this;
        r1 = 0;
        r0 = r5.a;
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        r0 = r1;
    L_0x0006:
        return r0;
    L_0x0007:
        r0 = r5.a;
        r2 = r0.e;
        monitor-enter(r2);
        r0 = r5.a;	 Catch:{ all -> 0x00a0 }
        r0 = r0.a(r6);	 Catch:{ all -> 0x00a0 }
        if (r0 != 0) goto L_0x0017;
    L_0x0014:
        monitor-exit(r2);	 Catch:{ all -> 0x00a0 }
        r0 = r1;
        goto L_0x0006;
    L_0x0017:
        r3 = r0 instanceof com.tencent.tencentmap.mapsdk.a.kd;	 Catch:{ all -> 0x00a0 }
        if (r3 != 0) goto L_0x001e;
    L_0x001b:
        monitor-exit(r2);	 Catch:{ all -> 0x00a0 }
        r0 = r1;
        goto L_0x0006;
    L_0x001e:
        r0 = (com.tencent.tencentmap.mapsdk.a.kd) r0;	 Catch:{ all -> 0x00a0 }
        r3 = r0.x;	 Catch:{ all -> 0x00a0 }
        r3 = r3.h();	 Catch:{ all -> 0x00a0 }
        if (r3 != 0) goto L_0x002b;
    L_0x0028:
        monitor-exit(r2);	 Catch:{ all -> 0x00a0 }
        r0 = r1;
        goto L_0x0006;
    L_0x002b:
        r1 = r0.x;	 Catch:{ all -> 0x00a0 }
        r1 = r1.c();	 Catch:{ all -> 0x00a0 }
        if (r1 == 0) goto L_0x00a3;
    L_0x0033:
        r1 = r5.a;	 Catch:{ all -> 0x00a0 }
        r1 = r1.getBubblesOverlay();	 Catch:{ all -> 0x00a0 }
        if (r1 != 0) goto L_0x004b;
    L_0x003b:
        r1 = new com.tencent.tencentmap.mapsdk.a.nr;	 Catch:{ all -> 0x00a0 }
        r3 = r5.a;	 Catch:{ all -> 0x00a0 }
        r3 = r3.getContext();	 Catch:{ all -> 0x00a0 }
        r1.<init>(r3);	 Catch:{ all -> 0x00a0 }
        r3 = r5.a;	 Catch:{ all -> 0x00a0 }
        r3.a(r1);	 Catch:{ all -> 0x00a0 }
    L_0x004b:
        r3 = r0.x;	 Catch:{ all -> 0x00a0 }
        r3 = r3.d();	 Catch:{ all -> 0x00a0 }
        r3 = r1.b(r3);	 Catch:{ all -> 0x00a0 }
        if (r3 != 0) goto L_0x0089;
    L_0x0057:
        r3 = new com.tencent.tencentmap.mapsdk.a.oq;	 Catch:{ all -> 0x00a0 }
        r3.<init>();	 Catch:{ all -> 0x00a0 }
        r4 = r0.x;	 Catch:{ all -> 0x00a0 }
        r4 = r4.e();	 Catch:{ all -> 0x00a0 }
        r3.a(r4);	 Catch:{ all -> 0x00a0 }
        r4 = r0.x;	 Catch:{ all -> 0x00a0 }
        r3.a(r4);	 Catch:{ all -> 0x00a0 }
        r4 = r0.x;	 Catch:{ all -> 0x00a0 }
        r4 = r4.b();	 Catch:{ all -> 0x00a0 }
        r4 = com.tencent.map.lib.util.StringUtil.isEmpty(r4);	 Catch:{ all -> 0x00a0 }
        if (r4 != 0) goto L_0x0096;
    L_0x0076:
        r4 = r0.x;	 Catch:{ all -> 0x00a0 }
        r4 = r4.b();	 Catch:{ all -> 0x00a0 }
        r3.a(r4);	 Catch:{ all -> 0x00a0 }
    L_0x007f:
        r0 = r0.x;	 Catch:{ all -> 0x00a0 }
        r4 = 0;
        r1 = r1.a(r3, r4);	 Catch:{ all -> 0x00a0 }
        r0.a(r1);	 Catch:{ all -> 0x00a0 }
    L_0x0089:
        monitor-exit(r2);	 Catch:{ all -> 0x00a0 }
        r0 = r5.a;
        r0 = r0.getMap();
        r0.a();
        r0 = 1;
        goto L_0x0006;
    L_0x0096:
        r4 = r0.x;	 Catch:{ all -> 0x00a0 }
        r4 = r4.j();	 Catch:{ all -> 0x00a0 }
        r3.a(r4);	 Catch:{ all -> 0x00a0 }
        goto L_0x007f;
    L_0x00a0:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00a0 }
        throw r0;
    L_0x00a3:
        r1 = 0;
        r3 = 0;
        r5.a(r0, r1, r3);	 Catch:{ all -> 0x00a0 }
        goto L_0x0089;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.mu.b(java.lang.String):boolean");
    }

    private void i(String str) {
        ke a = this.a.a(str);
        if (a != null && (a instanceof kd)) {
            a = (kd) a;
            if (a.x.h()) {
                kc kcVar = this.a.f;
                if (kcVar != null && kcVar.j()) {
                    a(a, false, null);
                }
            }
        }
    }

    boolean c(String str) {
        if (this.a == null) {
            return false;
        }
        synchronized (this.a.e) {
            ke a = this.a.a(str);
            if (a == null) {
                return false;
            } else if (a instanceof kd) {
                kd kdVar = (kd) a;
                if (kdVar.x.c()) {
                    nr bubblesOverlay = this.a.getBubblesOverlay();
                    if (bubblesOverlay == null) {
                        return true;
                    }
                    bubblesOverlay.c(kdVar.x.d());
                    return true;
                } else if (str.equals(this.a.getMarkerOnTapedId())) {
                    c();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    boolean d(String str) {
        if (str == null || !str.equals(this.a.getMarkerOnTapedId()) || this.a.f == null || !this.a.f.j()) {
            return false;
        }
        return true;
    }

    private pa j(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        if (this.a == null) {
            return null;
        }
        synchronized (this.a.e) {
            ke a = this.a.a(str);
            if (a == null) {
                return null;
            } else if (a instanceof kd) {
                pa paVar = ((kd) a).x;
                return paVar;
            } else {
                return null;
            }
        }
    }

    public boolean a(ke keVar, boolean z, GeoPoint geoPoint) {
        kd kdVar = (kd) keVar;
        if (kdVar.x.c()) {
            nr bubblesOverlay = this.a.getBubblesOverlay();
            if (bubblesOverlay == null) {
                bubblesOverlay = new nr(this.a.getContext());
                this.a.a(bubblesOverlay);
            }
            if (!bubblesOverlay.b(kdVar.x.d())) {
                oq oqVar = new oq();
                oqVar.a(kdVar.x);
                oqVar.a(kdVar.x.e());
                if (StringUtil.isEmpty(kdVar.x.b())) {
                    oqVar.a(kdVar.x.j());
                } else {
                    oqVar.a(kdVar.x.b());
                }
                kdVar.x.a(bubblesOverlay.a(oqVar, null));
            }
        } else {
            b bVar = new b(null);
            bVar.a = kdVar.v();
            bVar.b = kdVar.g();
            bVar.c = z;
            if (this.p != null) {
                this.p.removeCallbacksAndMessages(bVar);
                Message obtainMessage = this.p.obtainMessage();
                obtainMessage.obj = bVar;
                this.p.sendMessage(obtainMessage);
            }
        }
        return true;
    }

    private void a(b bVar) {
        if (bVar != null && this.a != null) {
            String str = bVar.a;
            boolean z = bVar.c;
            pa j = j(str);
            if (j == null) {
                this.a.a("", true);
            } else if (!(this.a.q != null && z && this.a.q.a(j)) && j.h()) {
                String markerOnTapedId;
                if (!this.a.getMarkerOnTapedId().equals(str)) {
                    synchronized (this.a.e) {
                        if (this.a.f != null) {
                            this.a.f = null;
                        }
                    }
                    z = true;
                } else if (this.a.f != null) {
                    this.a.f.c(false);
                    z = false;
                } else {
                    z = false;
                }
                if (StringUtil.isEmpty(this.a.getMarkerOnTapedId())) {
                    z = false;
                }
                if (this.o == null) {
                    a(j);
                    this.e = this.d;
                    b(j);
                } else {
                    a(j, this.o);
                }
                if (this.e != null && this.e.getParent() == null && this.c.indexOfChild(this.e) < 0) {
                    this.c.addView(this.e, new LayoutParams(-2, -2));
                    this.e.setVisibility(4);
                }
                if (this.f != null && this.f.getParent() == null) {
                    this.c.addView(this.f, new LayoutParams(-2, -2));
                    this.f.setVisibility(4);
                }
                if (this.g != null && this.g.getParent() == null) {
                    this.c.addView(this.g, new LayoutParams(-2, -2));
                    this.g.setVisibility(4);
                }
                if (this.a.f != null) {
                    markerOnTapedId = this.a.getMarkerOnTapedId();
                    if (markerOnTapedId == null || markerOnTapedId.trim().length() == 0) {
                        this.a.f.e(true);
                    } else {
                        this.a.f.e(false);
                    }
                }
                markerOnTapedId = this.a.getMarkerOnTapedId();
                if (markerOnTapedId == null || markerOnTapedId.trim().length() == 0) {
                    if (this.a.f != null) {
                        this.a.f.d(false);
                    }
                } else if (this.a.f != null) {
                    this.a.f.d(true);
                }
                this.a.a(str, true);
                a(z);
            }
        }
    }

    private void a(pa paVar, b bVar) {
        View a = bVar.a(paVar);
        if (a == null) {
            a = bVar.b(paVar);
            if (a == null) {
                a(paVar);
                this.e = this.d;
                return;
            }
            a = a(a);
            if (this.e == null) {
                this.e = a;
            } else if (!this.e.equals(a)) {
                if (this.c.indexOfChild(this.e) >= 0) {
                    this.c.removeView(this.e);
                }
                this.e = a;
            }
        } else if (this.e == null) {
            this.e = a;
        } else if (!this.e.equals(a)) {
            if (this.c.indexOfChild(this.e) >= 0) {
                this.c.removeView(this.e);
            }
            this.e = a;
        }
    }

    private void a(pa paVar) {
        if (this.d == null) {
            this.d = e(paVar);
        } else {
            c(paVar);
        }
    }

    private void b(pa paVar) {
        if (this.f == null) {
            this.f = f(paVar);
        } else {
            d(paVar);
        }
    }

    private void c(pa paVar) {
        if (this.d != null && paVar != null) {
            TextView textView = (TextView) this.d.findViewById(1);
            if (textView != null) {
                CharSequence j = paVar.j();
                if (StringUtil.isEmpty(j)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(j);
                }
            }
            TextView textView2 = (TextView) this.d.findViewById(2);
            if (textView2 != null) {
                CharSequence k = paVar.k();
                if (StringUtil.isEmpty(k)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    textView2.setText(k);
                }
            }
            if (textView != null && textView.getVisibility() != 8) {
                return;
            }
            if (textView2 == null || textView2.getVisibility() == 8) {
                this.d = null;
            }
        }
    }

    private void d(pa paVar) {
        if (this.f != null && paVar != null) {
            CharSequence j;
            TextView textView = (TextView) this.f.findViewById(1);
            if (textView != null) {
                j = paVar.j();
                if (StringUtil.isEmpty(j)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(j);
                }
            }
            textView = (TextView) this.f.findViewById(2);
            if (textView != null) {
                j = paVar.k();
                if (StringUtil.isEmpty(j)) {
                    textView.setVisibility(8);
                    return;
                }
                textView.setVisibility(0);
                textView.setText(j);
            }
        }
    }

    private View a(View view) {
        if (this.h == null) {
            this.h = a(this.c.getContext());
            this.i = new LinearLayout(this.c.getContext());
            this.i.setGravity(17);
            this.i.setOrientation(1);
            this.i.setPadding(10, 10, 10, 30);
            this.h.addView(this.i, new LinearLayout.LayoutParams(-2, -2));
        }
        if (this.i.indexOfChild(view) < 0) {
            this.i.addView(view);
        }
        return this.h;
    }

    private View e(pa paVar) {
        View a = a(this.c.getContext());
        a((ViewGroup) a, this.c.getContext());
        a.setVisibility(8);
        TextView textView = (TextView) a.findViewById(1);
        if (textView != null) {
            CharSequence j = paVar.j();
            if (StringUtil.isEmpty(j)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(j);
            }
        }
        TextView textView2 = (TextView) a.findViewById(2);
        if (textView2 != null) {
            CharSequence k = paVar.k();
            if (StringUtil.isEmpty(k)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(k);
            }
        }
        if ((textView == null || textView.getVisibility() == 8) && (textView2 == null || textView2.getVisibility() == 8)) {
            return null;
        }
        return a;
    }

    private View f(pa paVar) {
        CharSequence j;
        ViewGroup b = b(this.c.getContext());
        b(b, this.c.getContext());
        b.setVisibility(8);
        TextView textView = (TextView) b.findViewById(1);
        if (textView != null) {
            j = paVar.j();
            if (StringUtil.isEmpty(j)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(j);
            }
        }
        textView = (TextView) b.findViewById(2);
        if (textView != null) {
            j = paVar.k();
            if (StringUtil.isEmpty(j)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(j);
            }
        }
        return b;
    }

    private LinearLayout a(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        Bitmap b = kh.b(context, "marker_infowindow.9.png");
        linearLayout.setBackgroundDrawable(new NinePatchDrawable(context.getResources(), b, b.getNinePatchChunk(), new Rect(), null));
        return linearLayout;
    }

    private LinearLayout b(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        Bitmap b = kh.b(context, "marker_infowindow_overturn.9.png");
        linearLayout.setBackgroundDrawable(new NinePatchDrawable(context.getResources(), b, b.getNinePatchChunk(), new Rect(), null));
        return linearLayout;
    }

    private void a(ViewGroup viewGroup, Context context) {
        if (viewGroup != null && context != null) {
            View linearLayout = new LinearLayout(context);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(10, 10, 10, 30);
            View textView = new TextView(context);
            textView.setGravity(3);
            textView.setId(1);
            textView.setTextColor(-16777216);
            textView.setText("Title");
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            textView = new TextView(context);
            textView.setGravity(3);
            textView.setId(2);
            textView.setTextColor(-16777216);
            textView.setText("Snippet");
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            viewGroup.addView(linearLayout);
        }
    }

    private void b(ViewGroup viewGroup, Context context) {
        if (viewGroup != null && context != null) {
            View linearLayout = new LinearLayout(context);
            linearLayout.setGravity(17);
            linearLayout.setOrientation(1);
            linearLayout.setPadding(10, 30, 10, 10);
            View textView = new TextView(context);
            textView.setGravity(3);
            textView.setId(1);
            textView.setTextColor(-16777216);
            textView.setText("Title");
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            textView = new TextView(context);
            textView.setGravity(3);
            textView.setId(2);
            textView.setTextColor(-16777216);
            textView.setText("Snippet");
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            viewGroup.addView(linearLayout);
        }
    }

    private void c() {
        this.a.a("", true);
        this.a.getMap().a();
        synchronized (this.a.e) {
            if (this.a.f == null) {
                return;
            }
            this.a.f.h(false);
        }
    }

    private void a(boolean z) {
        Bitmap bitmap = null;
        Bitmap a = jz.a(this.e);
        if (a != null) {
            Bitmap a2;
            if (this.f != null) {
                a2 = jz.a(this.f);
            } else {
                a2 = null;
            }
            if (this.g != null) {
                bitmap = jz.a(this.g);
            }
            synchronized (this.a.e) {
                if (this.a.f == null) {
                    this.a.f = new kc(this.a);
                    this.a.f.e(true);
                    if (this.a.a(kd.class) == null) {
                        this.a.a(kd.class, (od) this);
                    }
                }
                this.a.f.b(a);
                this.a.f.c(a2);
                this.a.f.d(bitmap);
                this.a.f.b(this.a.a(false), this.a.a(true));
                if (this.a.i != null) {
                    this.a.f.a(this.a.getMarkerOnTapedPosition());
                }
                this.a.f.a(true, z);
            }
            this.a.getMap().a();
        }
    }

    void b() {
        if (this.a != null) {
            this.a.c(kd.class);
            this.a.a("", false);
            this.q.a();
        }
    }

    void a(String str, float f) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                } else if (a instanceof kd) {
                    ((kd) a).a(f);
                    this.a.getMap().a();
                }
            }
        }
    }

    void b(String str, float f) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke a = this.a.a(str);
                if (a == null) {
                } else if (a instanceof kd) {
                    ((kd) a).b(f);
                    this.a.getMap().a();
                }
            }
        }
    }

    float e(String str) {
        if (this.a == null) {
            return 0.0f;
        }
        synchronized (this.a.e) {
            ke a = this.a.a(str);
            if (a == null) {
                return 0.0f;
            } else if (a instanceof kd) {
                float n = ((kd) a).n();
                return n;
            } else {
                return 0.0f;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    com.tencent.tencentmap.mapsdk.a.ox f(java.lang.String r5) {
        /*
        r4 = this;
        r1 = 0;
        r0 = r4.a;
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        r0 = r1;
    L_0x0006:
        return r0;
    L_0x0007:
        r0 = r4.a;
        r2 = r0.e;
        monitor-enter(r2);
        r0 = r4.a;	 Catch:{ all -> 0x002c }
        r0 = r0.a(r5);	 Catch:{ all -> 0x002c }
        if (r0 != 0) goto L_0x0017;
    L_0x0014:
        monitor-exit(r2);	 Catch:{ all -> 0x002c }
        r0 = r1;
        goto L_0x0006;
    L_0x0017:
        r3 = r0 instanceof com.tencent.tencentmap.mapsdk.a.kd;	 Catch:{ all -> 0x002c }
        if (r3 != 0) goto L_0x001e;
    L_0x001b:
        monitor-exit(r2);	 Catch:{ all -> 0x002c }
        r0 = r1;
        goto L_0x0006;
    L_0x001e:
        r0 = (com.tencent.tencentmap.mapsdk.a.kd) r0;	 Catch:{ all -> 0x002c }
        r0 = r0.g();	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x002f;
    L_0x0026:
        r0 = com.tencent.tencentmap.mapsdk.a.kh.a(r0);	 Catch:{ all -> 0x002c }
    L_0x002a:
        monitor-exit(r2);	 Catch:{ all -> 0x002c }
        goto L_0x0006;
    L_0x002c:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x002c }
        throw r0;
    L_0x002f:
        r0 = r1;
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.mu.f(java.lang.String):com.tencent.tencentmap.mapsdk.a.ox");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void c(java.lang.String r4, boolean r5) {
        /*
        r3 = this;
        r0 = r3.a;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r3.a;
        r1 = r0.e;
        monitor-enter(r1);
        r0 = r3.a;	 Catch:{ all -> 0x0014 }
        r0 = r0.a(r4);	 Catch:{ all -> 0x0014 }
        if (r0 != 0) goto L_0x0017;
    L_0x0012:
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        goto L_0x0004;
    L_0x0014:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        throw r0;
    L_0x0017:
        r2 = r0 instanceof com.tencent.tencentmap.mapsdk.a.kd;	 Catch:{ all -> 0x0014 }
        if (r2 != 0) goto L_0x001d;
    L_0x001b:
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        goto L_0x0004;
    L_0x001d:
        r0 = (com.tencent.tencentmap.mapsdk.a.kd) r0;	 Catch:{ all -> 0x0014 }
        r0.b(r5);	 Catch:{ all -> 0x0014 }
        if (r5 != 0) goto L_0x002b;
    L_0x0024:
        r2 = r0.g();	 Catch:{ all -> 0x0014 }
        r0.a(r2);	 Catch:{ all -> 0x0014 }
    L_0x002b:
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.mu.c(java.lang.String, boolean):void");
    }

    boolean g(String str) {
        if (this.a == null) {
            return false;
        }
        synchronized (this.a.e) {
            ke a = this.a.a(str);
            if (a == null) {
                return false;
            } else if (a instanceof kd) {
                boolean o = ((kd) a).o();
                return o;
            } else {
                return false;
            }
        }
    }

    void c(String str, float f) {
        if (this.a != null) {
            synchronized (this.a.e) {
                ke b = this.a.b(str, false);
                if (b == null) {
                    return;
                }
                b.c(f);
                this.a.a(b);
                this.a.getMap().a();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    java.util.List<com.tencent.tencentmap.mapsdk.a.iw> h(java.lang.String r5) {
        /*
        r4 = this;
        r1 = 0;
        r0 = r4.a;
        r2 = r0.e;
        monitor-enter(r2);
        r0 = r4.a;	 Catch:{ all -> 0x0053 }
        r0 = r0.a(r5);	 Catch:{ all -> 0x0053 }
        if (r0 != 0) goto L_0x0011;
    L_0x000e:
        monitor-exit(r2);	 Catch:{ all -> 0x0053 }
        r0 = r1;
    L_0x0010:
        return r0;
    L_0x0011:
        r3 = r0 instanceof com.tencent.tencentmap.mapsdk.a.kd;	 Catch:{ all -> 0x0053 }
        if (r3 != 0) goto L_0x0018;
    L_0x0015:
        monitor-exit(r2);	 Catch:{ all -> 0x0053 }
        r0 = r1;
        goto L_0x0010;
    L_0x0018:
        r0 = (com.tencent.tencentmap.mapsdk.a.kd) r0;	 Catch:{ all -> 0x0053 }
        monitor-exit(r2);	 Catch:{ all -> 0x0053 }
        r1 = new java.util.ArrayList;
        r2 = 2;
        r1.<init>(r2);
        r2 = r0.t();
        r1.add(r2);
        r2 = r4.a;
        r2 = r2.getMarkerOnTapedId();
        if (r2 == 0) goto L_0x0051;
    L_0x0030:
        r2 = r4.a;
        r2 = r2.getMarkerOnTapedId();
        r0 = r0.v();
        r0 = r2.equals(r0);
        if (r0 == 0) goto L_0x0051;
    L_0x0040:
        r0 = r4.a;
        r0 = r0.f;
        if (r0 == 0) goto L_0x0051;
    L_0x0046:
        r0 = r4.a;
        r0 = r0.f;
        r0 = r0.k();
        r1.add(r0);
    L_0x0051:
        r0 = r1;
        goto L_0x0010;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0053 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.mu.h(java.lang.String):java.util.List<com.tencent.tencentmap.mapsdk.a.iw>");
    }

    void a(m mVar) {
        this.n = mVar;
    }

    void a(b bVar) {
        this.o = bVar;
    }
}
