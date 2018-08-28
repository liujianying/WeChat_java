package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.map.lib.util.SystemUtil;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.smtt.sdk.TbsReaderView$ReaderCallback;
import com.tencent.tencentmap.mapsdk.a.kk.b;
import com.tencent.tencentmap.mapsdk.a.pg.a;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.microedition.khronos.opengles.GL10;

public class kg extends ke {
    private static final int[] u = new int[]{TbsReaderView$ReaderCallback.GET_BAR_ANIMATING, TbsReaderView$ReaderCallback.GET_BAR_ANIMATING, TbsReaderView$ReaderCallback.GET_BAR_ANIMATING, TbsReaderView$ReaderCallback.GET_BAR_ANIMATING, TbsReaderView$ReaderCallback.GET_BAR_ANIMATING, TbsReaderView$ReaderCallback.GET_BAR_ANIMATING, TbsReaderView$ReaderCallback.GET_BAR_ANIMATING, TbsReaderView$ReaderCallback.GET_BAR_ANIMATING, TbsReaderView$ReaderCallback.GET_BAR_ANIMATING, TbsReaderView$ReaderCallback.GET_BAR_ANIMATING, TbsReaderView$ReaderCallback.GET_BAR_ANIMATING, TbsReaderView$ReaderCallback.GET_BAR_ANIMATING, 3500, 2000, 1500, 1000, 720, 500, 320, JsApiSetBackgroundAudioState.CTRL_INDEX, 80};
    private String A;
    private int B = -1;
    private List<Integer> C;
    private int D = 0;
    private final String E = (v() + "_arrow_texture_");
    private final float F;
    private b G = new 1(this);
    private iq a = null;
    private pf b = null;
    private ArrayList<a> c = null;
    private ArrayList<GeoPoint> d = null;
    private float e;
    private ks f = null;
    private boolean g = false;
    private int[] h = null;
    private int[] i = null;
    private int[] j = null;
    private a k;
    private String l = null;
    private int m = 12;
    private kk n;
    private float o;
    private a p = null;
    private float q = 1.0f;
    private int r = 0;
    private boolean s = false;
    private boolean t = true;
    private float v = 0.0f;
    private int w = 0;
    private ArrayList<GeoPoint> x;
    private boolean y = false;
    private boolean z = false;

    public kg(ks ksVar) {
        this.f = ksVar;
        this.c = new ArrayList();
        this.F = ksVar.getResources().getDisplayMetrics().density;
    }

    public void a(int i, List<ox> list) {
        this.w = i;
        if (list != null) {
            int size = list.size();
            if (size > 0) {
                this.x = new ArrayList();
                for (int i2 = 0; i2 < size; i2++) {
                    ox oxVar = (ox) list.get(i2);
                    if (oxVar != null) {
                        GeoPoint a = kh.a(oxVar);
                        if (a != null) {
                            this.x.add(a);
                        }
                    }
                }
            }
        }
    }

    public void a(Bitmap bitmap) {
        com.tencent.map.lib.util.b.b(this.E + this.D);
        StringBuilder append = new StringBuilder().append(this.E);
        int i = this.D + 1;
        this.D = i;
        String stringBuilder = append.append(i).toString();
        com.tencent.map.lib.util.b.a(stringBuilder, bitmap);
        this.A = stringBuilder;
    }

    public void a(int i) {
        this.B = i;
    }

    public void a(List<ox> list) {
        this.v = 0.0f;
        this.c.clear();
        if (list != null) {
            int size = list.size();
            if (size > 0) {
                GeoPoint geoPoint = null;
                this.d = new ArrayList();
                int i = 0;
                while (i < size) {
                    a aVar;
                    ox oxVar = (ox) list.get(i);
                    if (oxVar != null) {
                        GeoPoint a = kh.a(oxVar);
                        if (a != null) {
                            aVar = new a(a);
                            this.d.add(aVar);
                            if (geoPoint != null) {
                                this.v += a((GeoPoint) aVar, geoPoint);
                                aVar.a = this.v;
                                aVar.b = geoPoint.b + 1;
                            }
                            this.c.add(aVar);
                            i++;
                            geoPoint = aVar;
                        }
                    }
                    aVar = geoPoint;
                    i++;
                    geoPoint = aVar;
                }
            }
        }
    }

    public void a(pg pgVar) {
        if (pgVar != null) {
            if (pgVar.e() == -1.0f) {
                d(this.F * 9.0f);
            } else {
                d(pgVar.e());
            }
            b(pgVar.f());
            if (!pgVar.k() || pgVar.h() > 0) {
                c((float) pgVar.h());
            } else {
                c(1.0f);
            }
            a_(pgVar.i());
            a(pgVar.l());
            b(pgVar.j());
            a(pgVar.p());
            c(pgVar.m());
            b(pgVar.u());
            b(pgVar.v());
            this.j = pgVar.w();
            this.r = pgVar.o();
            a(pgVar.d());
            a(pgVar.a(), pgVar.b());
            if (pgVar.r() != null) {
                a(pgVar.r().a(this.f.getContext()));
            }
            a(pgVar.s());
            this.t = pgVar.q();
            ol n = pgVar.n();
            if (n != null) {
                a(n.a);
            }
            int[][] g = pgVar.g();
            if (g != null && g.length == 2) {
                int[] iArr = g[0];
                int[] iArr2 = g[1];
                if (!(iArr == null || iArr2 == null || iArr.length != iArr2.length)) {
                    a(iArr, iArr2);
                }
            }
            this.k = a(pgVar.c());
            h();
        }
    }

    public void b(boolean z) {
        this.g = z;
    }

    public void b(int i) {
        super.b(i);
    }

    private void h() {
        if (this.N) {
            if (this.d != null && this.d.size() >= 2) {
                if (this.a == null) {
                    this.f.getMap();
                    this.a = new iq(j());
                    this.f.getMap().a(this.a);
                } else {
                    this.a.a(j());
                }
                this.f.getMap().a();
            }
        } else if (this.a != null) {
            this.f.getMap().b(this.a);
            this.a = null;
        }
    }

    public void a(String str) {
        this.l = str;
        this.k = a.b;
    }

    private void i() {
        if (this.a != null) {
            this.f.getMap().b(this.a);
            this.a = null;
        }
    }

    private a a(a aVar) {
        if (aVar != a.a) {
            return aVar;
        }
        if (this.h == null || this.h.length <= 0) {
            return (this.L < 0 || this.L >= this.m) ? a.c : a.b;
        } else {
            int i = 0;
            int length = this.h.length;
            while (i < length) {
                if (this.h[i] < 0 || this.h[i] >= this.m) {
                    return a.c;
                }
                i++;
            }
            return a.b;
        }
    }

    private int d(int i) {
        int i2;
        if (i >= this.m) {
            i2 = this.m - 1;
        } else {
            i2 = i;
        }
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    private ir j() {
        ir irVar = new ir();
        if (this.l != null) {
            irVar.a(this.l);
        }
        int[][] d = d(this.d);
        irVar.c(this.g);
        irVar.d((float) this.B);
        irVar.a(this.d);
        if (this.r == 0) {
            int a = a(this.f.getContext(), this.l);
            if (a > 0) {
                irVar.b(this.J > ((float) a) ? (float) a : this.J);
            } else {
                irVar.b(this.J);
            }
        } else {
            irVar.b(this.J);
        }
        if (this.k == a.c) {
            irVar.b(true);
            if (this.e * 2.0f > this.J) {
                this.e = this.J / 3.0f;
            }
            irVar.c(this.e);
        }
        int[] e = e();
        if (this.t) {
            irVar.a(d[1]);
            if (this.e <= 0.0f || e == null || e.length <= 0) {
                irVar.b(d[0]);
            } else {
                irVar.a(d[0], e);
            }
        } else {
            irVar.a(new int[]{0});
            if (this.e <= 0.0f || e == null || e.length <= 0) {
                irVar.b(new int[]{this.L});
            } else {
                irVar.a(new int[]{this.L}, new int[]{e[0]});
            }
        }
        irVar.a(this.o);
        irVar.a(this.r);
        irVar.b((int) this.M);
        irVar.e(this.s);
        if (this.w > 0 && this.w <= 3) {
            irVar.a(this.w, this.x);
        }
        irVar.f(this.y);
        irVar.a(this.z);
        irVar.d(this.t);
        irVar.b(this.A);
        irVar.b(this.C);
        return irVar;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof kg)) {
            return false;
        }
        return TextUtils.equals(v(), ((kg) obj).v());
    }

    public int hashCode() {
        return v().hashCode();
    }

    public void a(GL10 gl10) {
        if (this.N) {
            b(gl10);
        } else if (this.a != null) {
            this.a.z();
        }
    }

    protected boolean b(GL10 gl10) {
        if (this.n == null || !this.n.d()) {
            return false;
        }
        this.n.c();
        if (this.n instanceof kl) {
            this.d = c(this.c);
            if (this.d.size() >= 2) {
                h();
            }
        } else if (this.n instanceof kj) {
            h();
        }
        this.f.getMap().a();
        if (this.n.e()) {
            this.n.a(null);
            this.n = null;
        }
        return true;
    }

    public boolean a(float f, float f2) {
        if (this.N && this.a != null) {
            return this.a.a(this.f.getMap().s(), f, f2);
        }
        return false;
    }

    public float a(GeoPoint geoPoint, GeoPoint geoPoint2) {
        if (geoPoint == null || geoPoint2 == null || geoPoint == null) {
            return 0.0f;
        }
        return (float) (Math.hypot((double) (geoPoint.getLatitudeE6() - geoPoint2.getLatitudeE6()), (double) (geoPoint.getLongitudeE6() - geoPoint2.getLongitudeE6())) + 0.0d);
    }

    private ArrayList<GeoPoint> c(List<a> list) {
        ArrayList<GeoPoint> arrayList = new ArrayList();
        if (list == null || list.size() < 2) {
            return arrayList;
        }
        float f = this.p.a;
        float f2 = f - (this.q * f);
        float f3 = f + ((this.v - this.p.a) * this.q);
        a aVar = null;
        int i = 0;
        while (i < list.size()) {
            a aVar2 = (a) list.get(i);
            if (aVar2.a > f2 && aVar2.a < f3) {
                if (aVar != null && aVar.a < f2) {
                    a a = a(aVar, aVar2, (f2 - aVar.a) / (aVar2.a - aVar.a));
                    a.b = aVar.b;
                    arrayList.add(a);
                }
                arrayList.add(aVar2);
            } else if (aVar2.a > f3) {
                if (aVar != null && aVar.a < f3) {
                    a a2 = a(aVar, aVar2, (f3 - aVar.a) / (aVar2.a - aVar.a));
                    a2.b = aVar2.b;
                    arrayList.add(a2);
                }
                return arrayList;
            } else if (Float.compare(aVar2.a, f2) == 0 || Float.compare(aVar2.a, f3) == 0) {
                arrayList.add(aVar2);
            }
            i++;
            aVar = aVar2;
        }
        return arrayList;
    }

    private a a(a aVar, a aVar2, float f) {
        a aVar3 = new a();
        int longitudeE6 = aVar2.getLongitudeE6() - aVar.getLongitudeE6();
        int latitudeE6 = aVar2.getLatitudeE6() - aVar.getLatitudeE6();
        aVar3.setLatitudeE6(Math.round(((float) latitudeE6) * f) + aVar.getLatitudeE6());
        aVar3.setLongitudeE6(Math.round(((float) longitudeE6) * f) + aVar.getLongitudeE6());
        aVar3.a = aVar.a + ((aVar2.a - aVar.a) * f);
        return aVar3;
    }

    private int[][] d(List<GeoPoint> list) {
        int i;
        int d;
        int[][] iArr;
        if (this.h == null || this.i == null || list == null || this.h.length == 0 || this.i.length == 0 || list.isEmpty()) {
            i = this.L;
            if (this.k == a.b) {
                d = d(i);
            } else {
                d = i;
            }
            iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{2, 1});
            iArr[0][0] = d;
            iArr[1][0] = 0;
            return iArr;
        }
        int i2;
        if (this.h == null || this.i == null) {
            d = 0;
        } else {
            d = Math.min(this.h.length, this.i.length);
        }
        int[] iArr2 = new int[d];
        for (i = 0; i < d; i++) {
            iArr2[i] = this.h[i];
            if (this.k == a.b) {
                iArr2[i] = d(iArr2[i]);
            }
        }
        Map treeMap = new TreeMap();
        a aVar = (a) list.get(0);
        int i3 = 1;
        while (i3 < d) {
            if (aVar.b <= this.i[i3]) {
                treeMap.put(Integer.valueOf(0), Integer.valueOf(iArr2[i3 - 1]));
                i2 = i3;
                break;
            }
            i3++;
        }
        i2 = 0;
        if (i3 == d && treeMap.size() == 0) {
            treeMap.put(Integer.valueOf(0), Integer.valueOf(iArr2[d - 1]));
            i2 = d;
        }
        a aVar2 = aVar;
        int i4 = 1;
        int i5 = i2;
        while (i4 < list.size()) {
            aVar = (a) list.get(i4);
            i2 = i5;
            int i6 = i5;
            while (i2 < d && aVar.b > this.i[i2] && aVar2.b <= this.i[i2]) {
                treeMap.put(Integer.valueOf(i4 - 1), Integer.valueOf(iArr2[i2]));
                i6++;
                i2++;
            }
            aVar2 = aVar;
            i4++;
            i5 = i6;
        }
        iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{2, treeMap.size()});
        i3 = 0;
        for (Entry entry : treeMap.entrySet()) {
            iArr[0][i3] = ((Integer) entry.getValue()).intValue();
            iArr[1][i3] = ((Integer) entry.getKey()).intValue();
            i3++;
        }
        return iArr;
    }

    private float a(a aVar, a aVar2, GeoPoint geoPoint, a aVar3) {
        int longitudeE6 = aVar.getLongitudeE6();
        int latitudeE6 = aVar.getLatitudeE6();
        int longitudeE62 = aVar2.getLongitudeE6();
        int latitudeE62 = aVar2.getLatitudeE6();
        int longitudeE63 = geoPoint.getLongitudeE6();
        int latitudeE63 = geoPoint.getLatitudeE6();
        float f = (float) (((longitudeE62 - longitudeE6) * (longitudeE63 - longitudeE6)) + ((latitudeE62 - latitudeE6) * (latitudeE63 - latitudeE6)));
        if (f <= 0.0f) {
            aVar3.setLatitudeE6(aVar.getLatitudeE6());
            aVar3.setLongitudeE6(aVar.getLongitudeE6());
            aVar3.a = aVar.a;
            return (float) Math.hypot((double) (longitudeE63 - longitudeE6), (double) (latitudeE63 - latitudeE6));
        }
        double d = (double) (((longitudeE62 - longitudeE6) * (longitudeE62 - longitudeE6)) + ((latitudeE62 - latitudeE6) * (latitudeE62 - latitudeE6)));
        if (((double) f) >= d) {
            aVar3.setLatitudeE6(aVar2.getLatitudeE6());
            aVar3.setLongitudeE6(aVar2.getLongitudeE6());
            aVar3.a = aVar2.a;
            return (float) Math.hypot((double) (longitudeE63 - longitudeE62), (double) (latitudeE63 - latitudeE62));
        }
        f = (float) (((double) f) / d);
        float f2 = (((float) (longitudeE62 - longitudeE6)) * f) + ((float) longitudeE6);
        float f3 = (((float) (latitudeE62 - latitudeE6)) * f) + ((float) latitudeE6);
        aVar3.setLongitudeE6(Math.round(f2));
        aVar3.setLatitudeE6(Math.round(f3));
        aVar3.a = aVar.a + ((aVar2.a - aVar.a) * f);
        return (float) Math.hypot((double) (((float) longitudeE63) - f2), (double) (((float) latitudeE63) - f3));
    }

    public boolean a() {
        return this.N;
    }

    public void b() {
    }

    public void c() {
        h();
    }

    public void d() {
        i();
        if (this.c != null) {
            this.c.clear();
            this.c = null;
        }
        if (this.d != null) {
            this.d.clear();
            this.d = null;
        }
        com.tencent.map.lib.util.b.b(this.A);
        this.f = null;
    }

    public void a(int[] iArr, int[] iArr2) {
        this.h = iArr;
        this.i = iArr2;
        this.k = a(a.a);
    }

    public int[] e() {
        return this.j;
    }

    public boolean q() {
        return true;
    }

    public void a(pf pfVar) {
        this.b = pfVar;
    }

    public pf f() {
        return this.b;
    }

    public void a(float f) {
        this.o = f;
    }

    public void c(boolean z) {
        this.z = z;
    }

    public void b(List<Integer> list) {
        this.C = list;
    }

    public void b(float f) {
        this.e = f;
    }

    public void a(kk kkVar) {
        if (this.n != null) {
            this.n.a();
            this.n.a(null);
        }
        if (kkVar instanceof kl) {
            a((kl) kkVar);
        } else if (kkVar instanceof kj) {
            a((kj) kkVar);
        } else {
            this.n = null;
        }
    }

    private void a(kl klVar) {
        this.n = klVar;
        this.p = a(kh.a(klVar.f()));
        if (this.p == null) {
            throw new RuntimeException("Error, start point not found.");
        }
        klVar.a(this.G);
        klVar.a(null, null);
        this.f.getMap().a();
    }

    private void a(kj kjVar) {
        this.n = kjVar;
        this.n.a(this.G);
        this.n.a(null, null);
        this.f.getMap().a();
    }

    private a a(GeoPoint geoPoint) {
        float f = Float.MAX_VALUE;
        a aVar = null;
        a aVar2 = new a();
        if (this.c != null && this.c.size() >= 2 && geoPoint != null) {
            a aVar3 = (a) this.c.get(0);
            int i = 1;
            while (true) {
                a aVar4 = aVar3;
                if (i >= this.c.size()) {
                    break;
                }
                a aVar5;
                aVar3 = (a) this.c.get(i);
                float a = a(aVar4, aVar3, geoPoint, aVar2);
                if (a < f) {
                    aVar5 = new a();
                    aVar = aVar2;
                } else {
                    aVar5 = aVar2;
                    a = f;
                }
                i++;
                aVar2 = aVar5;
                f = a;
            }
        }
        return aVar;
    }

    public iq g() {
        return this.a;
    }

    private int a(Context context, String str) {
        if (context == null) {
            return 0;
        }
        Bitmap b = b(context, str);
        if (b == null) {
            return 0;
        }
        int height = b.getHeight();
        if (height <= 0) {
            return 0;
        }
        return (int) ((Math.pow(2.0d, 25.0d) / Math.pow((double) height, 2.0d)) / ((double) SystemUtil.getDensity(context)));
    }

    private Bitmap b(Context context, String str) {
        Bitmap bitmap = null;
        InputStream c = c(context, str);
        if (c != null) {
            try {
                bitmap = BitmapFactory.decodeStream(c);
                if (c != null) {
                    try {
                        c.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Exception e2) {
                if (c != null) {
                    try {
                        c.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable th) {
                if (c != null) {
                    try {
                        c.close();
                    } catch (IOException e4) {
                    }
                }
            }
        }
        return bitmap;
    }

    private InputStream c(Context context, String str) {
        InputStream inputStream = null;
        if (context == null || StringUtil.isEmpty(str)) {
            return inputStream;
        }
        AssetManager assets = context.getAssets();
        if (assets == null) {
            return inputStream;
        }
        try {
            return assets.open(str);
        } catch (IOException e) {
            return inputStream;
        }
    }
}
