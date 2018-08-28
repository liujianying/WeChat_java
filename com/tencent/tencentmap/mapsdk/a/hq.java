package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.MapLanguage;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.d;
import com.tencent.map.lib.gl.JNI;
import com.tencent.map.lib.gl.JNICallback;
import com.tencent.map.lib.gl.JNICallback$c;
import com.tencent.map.lib.gl.JNICallback.a;
import com.tencent.map.lib.gl.JNICallback.b;
import com.tencent.map.lib.gl.JNICallback.e;
import com.tencent.map.lib.gl.JNICallback.f;
import com.tencent.map.lib.gl.JNICallback.h;
import com.tencent.map.lib.gl.JNICallback.j;
import com.tencent.map.lib.gl.JNICallback.k;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.map.lib.mapstructure.MaskLayer;
import com.tencent.map.lib.mapstructure.Polygon2D;
import com.tencent.map.lib.mapstructure.TappedElement;
import com.tencent.map.lib.mapstructure.TrafficRequestItem;
import com.tencent.map.lib.util.SystemUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.opengles.GL10;

public class hq implements a, e, h, jh {
    private static boolean i = true;
    private JNI a = new JNI();
    private long b;
    private ie c;
    private ji d = new ji();
    private jh e;
    private e f;
    private hv g;
    private long h = 0;
    private int j = 0;
    private float k = 1.0f;

    public hq(Context context, hv hvVar) {
        this.d.a(this);
        this.g = hvVar;
        this.k = context.getResources().getDisplayMetrics().density;
        if (i) {
            jk.a(context, "txmapengine");
        }
    }

    public void a(ie ieVar) {
        this.c = ieVar;
    }

    public void a(jg jgVar) {
        this.d.a(jgVar);
    }

    public void a(e eVar) {
        this.f = eVar;
    }

    public void a() {
        this.d.a();
        if (this.d != null) {
            this.d.a(null);
        }
        if (this.b != 0) {
            synchronized (this) {
                this.a.nativeDestroyEngine(this.b);
                this.b = 0;
            }
        }
    }

    public boolean a(Context context, if ifVar, String str, String str2, String str3, float f) {
        boolean a = hw.a();
        int[] iArr = new int[1];
        this.b = this.a.nativeInitEngine(str, str2, str3, SystemUtil.getDensity(context), 256, SystemUtil.getDensity(context), iArr, a, MapLanguage.LAN_CHINESE.ordinal());
        if (iArr[0] != 0) {
            d.a("init engine fail:" + iArr[0]);
            this.b = 0;
            return false;
        }
        this.a.initCallback(ifVar, this, this, this, this.g.a(), this.b);
        this.a.nativeSetTrafficColor(this.b, -14803236, -15611905, -11088785, -16777063);
        return true;
    }

    public boolean b() {
        if (this.b == 0) {
            return false;
        }
        return this.a.nativeGenerateTextures(this.b);
    }

    public boolean c() {
        if (this.b == 0) {
            return false;
        }
        this.a.nativeDrawFrame(this.b);
        return true;
    }

    public int d() {
        if (this.b == 0) {
            return -1;
        }
        return this.a.nativeClearCache(this.b);
    }

    public void e() {
        if (this.b != 0) {
            this.a.nativeLockEngine(this.b);
        }
    }

    public void f() {
        if (this.b != 0) {
            this.a.nativeUnlockEngine(this.b);
        }
    }

    public boolean g() {
        if (this.b == 0) {
            return true;
        }
        boolean nativeIsMapDrawFinished;
        synchronized (this) {
            nativeIsMapDrawFinished = this.a.nativeIsMapDrawFinished(this.b);
        }
        return nativeIsMapDrawFinished;
    }

    public int a(byte[] bArr, int i, boolean z, boolean z2) {
        int i2;
        synchronized (this) {
            if (this.b == 0) {
                i2 = -1;
            } else {
                i2 = this.a.nativeRefreshTrafficData(this.b, bArr, i, z, z2);
            }
        }
        return i2;
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        if (this.b != 0) {
            synchronized (this) {
                this.a.nativeCheckTrafficBlockCache(this.b, i, i2, i3, i4, i5);
            }
        }
    }

    public TrafficRequestItem[] h() {
        TrafficRequestItem[] trafficRequestItemArr = null;
        if (this.b != 0) {
            synchronized (this) {
                int[] nativeFetchLackedTrafficBlocks = this.a.nativeFetchLackedTrafficBlocks(this.b);
                if (nativeFetchLackedTrafficBlocks == null || nativeFetchLackedTrafficBlocks.length == 0) {
                } else {
                    trafficRequestItemArr = new TrafficRequestItem[(nativeFetchLackedTrafficBlocks.length / 6)];
                    for (int i = 0; i < nativeFetchLackedTrafficBlocks.length / 6; i++) {
                        trafficRequestItemArr[i] = new TrafficRequestItem();
                        trafficRequestItemArr[i].level = nativeFetchLackedTrafficBlocks[i * 6];
                        trafficRequestItemArr[i].blockNo = nativeFetchLackedTrafficBlocks[(i * 6) + 1];
                        trafficRequestItemArr[i].minLon = nativeFetchLackedTrafficBlocks[(i * 6) + 2];
                        trafficRequestItemArr[i].minLat = nativeFetchLackedTrafficBlocks[(i * 6) + 3];
                        trafficRequestItemArr[i].maxLon = nativeFetchLackedTrafficBlocks[(i * 6) + 4];
                        trafficRequestItemArr[i].maxLat = nativeFetchLackedTrafficBlocks[(i * 6) + 5];
                    }
                }
            }
        }
        return trafficRequestItemArr;
    }

    public int a(Polygon2D polygon2D) {
        if (this.b == 0) {
            return 0;
        }
        int nativeAddPolygon;
        synchronized (this) {
            nativeAddPolygon = this.a.nativeAddPolygon(this.b, polygon2D);
        }
        return nativeAddPolygon;
    }

    public void b(Polygon2D polygon2D) {
        if (this.b != 0) {
            synchronized (this) {
                this.a.nativeUpdatePolygon(this.b, polygon2D.polygonId, polygon2D.borldLineId, polygon2D);
            }
        }
    }

    public void a(int i, int i2) {
        if (this.b != 0 && i >= 0 && this.g != null) {
            this.g.a(new 1(this, i, i2));
        }
    }

    public int a(MaskLayer maskLayer) {
        if (this.b == 0) {
            return 0;
        }
        return this.a.nativeAddMaskLayer(this.b, maskLayer);
    }

    public void b(int i, int i2) {
        if (this.b != 0) {
            this.a.nativeUpdateMaskLayer(this.b, i, i2);
        }
    }

    public void a(int i) {
        if (this.b != 0) {
            this.a.nativeRemoveMaskLayer(this.b, i);
        }
    }

    public GeoPoint a(byte[] bArr, float f, float f2) {
        if (this.b == 0) {
            return new GeoPoint();
        }
        GeoPoint geoPoint;
        synchronized (this) {
            double[] dArr = new double[2];
            this.a.nativeFromScreenLocation(this.b, bArr, f, f2, dArr);
            geoPoint = new GeoPoint((int) (dArr[1] * 1000000.0d), (int) (dArr[0] * 1000000.0d));
        }
        return geoPoint;
    }

    public PointF a(byte[] bArr, double d, double d2) {
        if (this.b == 0) {
            return new PointF();
        }
        PointF pointF;
        synchronized (this) {
            float[] fArr = new float[2];
            this.a.nativeToScreenLocation(this.b, bArr, d, d2, fArr);
            pointF = new PointF(fArr[0], fArr[1]);
        }
        return pointF;
    }

    public void i() {
        if (this.b != 0) {
            this.g.a(new hv.a() {
                public void a(GL10 gl10) {
                    hq.this.a.nativeShowStreetRoad(hq.this.b);
                }
            });
        }
    }

    public void j() {
        if (this.b != 0) {
            synchronized (this) {
                this.a.nativeHideStreetRoad(this.b);
            }
        }
    }

    public void a(boolean z) {
        if (this.b != 0) {
            this.g.a(new 5(this, z));
        }
    }

    public void k() {
        if (this.b != 0) {
            this.g.a(new 14(this));
        }
    }

    public void l() {
        if (this.b != 0) {
            this.g.a(new 16(this));
        }
    }

    public String a(GeoPoint geoPoint) {
        if (this.b == 0) {
            return "";
        }
        byte[] nativeGetCityName = this.a.nativeGetCityName(this.b, geoPoint);
        if (nativeGetCityName != null) {
            try {
                return new String(nativeGetCityName, "GBK").trim();
            } catch (UnsupportedEncodingException e) {
            }
        }
        return "";
    }

    public void a(String str) {
        if (this.b != 0) {
            this.g.a(new 17(this, str));
        }
    }

    public int a(iq iqVar) {
        if (this.b == 0) {
            return -1;
        }
        int i;
        synchronized (this) {
            int m = iqVar.m();
            boolean z = false;
            if (m == 3) {
                m = 0;
                z = true;
            }
            boolean z2 = false;
            int[] c = iqVar.c();
            if (c[0] == 33) {
                m = 2;
            } else if (c[0] == 20) {
                z2 = true;
            }
            int[] iArr = new int[0];
            if (iqVar.y() != null) {
                iArr = new int[iqVar.y().size()];
                i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= iqVar.y().size()) {
                        break;
                    }
                    iArr[i2] = ((Integer) iqVar.y().get(i2)).intValue();
                    i = i2 + 1;
                }
            }
            int[] iArr2 = new int[0];
            if (iqVar.f() != null) {
                iArr2 = new int[iqVar.f().length];
                for (i = 0; i < iqVar.f().length; i++) {
                    iArr2[i] = iqVar.f()[i];
                }
            }
            i = this.a.nativeCreateLine(this.b, iqVar.c(), iqVar.b(), (GeoPoint[]) iqVar.a().toArray(new GeoPoint[0]), iqVar.q(), iqVar.n(), m, z, z2, iqVar.l(), iqVar.j(), iqVar.t(), iqVar.d(), iqVar.e(), iArr2, iqVar.g(), iArr, iqVar.o());
        }
        return i;
    }

    public void a(int i, boolean z) {
        if (this.b != 0 && i != -1) {
            synchronized (this) {
                this.a.nativeDeleteLine(this.b, (long) i, z);
            }
        }
    }

    public void b(iq iqVar) {
        if (this.b != 0) {
            int r = iqVar.r();
            if (r != -1) {
                synchronized (this) {
                    iq.a p = iqVar.p();
                    if (p == null) {
                        return;
                    }
                    this.a.nativeSetTurnArrow(this.b, (long) r, p.a, p.b);
                }
            }
        }
    }

    public void c(iq iqVar) {
        if (this.b != 0) {
            int r = iqVar.r();
            if (r != -1) {
                this.g.a(new 18(this, r, iqVar.w()));
            }
        }
    }

    public void d(iq iqVar) {
        if (this.b != 0) {
            int r = iqVar.r();
            if (r != -1) {
                synchronized (this) {
                    this.a.nativeSetLineDrawArrow(this.b, (long) r, iqVar.j());
                }
            }
        }
    }

    public void e(iq iqVar) {
        if (this.b != 0) {
            int r = iqVar.r();
            if (r != -1) {
                synchronized (this) {
                    this.a.nativeSetLineDirectionArrowTextureName(this.b, (long) r, iqVar.u());
                }
            }
        }
    }

    public void f(iq iqVar) {
        if (this.b != 0) {
            int r = iqVar.r();
            if (r != -1) {
                synchronized (this) {
                    this.a.nativeSetDrawCap(this.b, (long) r, iqVar.k());
                }
            }
        }
    }

    public void g(iq iqVar) {
        if (this.b != 0) {
            int r = iqVar.r();
            if (r != -1) {
                synchronized (this) {
                    GeoPoint h = iqVar.h();
                    if (h == null) {
                        return;
                    }
                    this.a.nativeLineInsertPoint(this.b, (long) r, h, iqVar.i());
                }
            }
        }
    }

    public void h(iq iqVar) {
        if (this.b != 0) {
            int r = iqVar.r();
            if (r != -1) {
                synchronized (this) {
                    GeoPoint h = iqVar.h();
                    if (h == null) {
                        return;
                    }
                    this.a.nativeLineClearPoint(this.b, (long) r, h, iqVar.i());
                }
            }
        }
    }

    public TappedElement a(float f, float f2) {
        TappedElement tappedElement = null;
        if (this.b != 0) {
            synchronized (this) {
                byte[] nativeOnTap = this.a.nativeOnTap(this.b, f, f2);
                if (nativeOnTap == null) {
                } else {
                    try {
                        tappedElement = TappedElement.fromBytes(nativeOnTap);
                    } catch (Exception e) {
                    }
                }
            }
        }
        return tappedElement;
    }

    public void b(boolean z) {
        if (0 != this.b) {
            synchronized (this) {
                this.a.nativeSetBuilding3DEffect(this.b, z);
            }
        }
    }

    public void m() {
        if (this.b != 0) {
            this.g.a(new 11(this));
        }
    }

    public void a(String str, byte[] bArr) {
        this.g.a(new 19(this, str, bArr));
        if (this.e != null) {
            this.e.a(str, bArr);
        }
    }

    public void b(String str) {
        this.j++;
        if (this.j >= 30) {
            m();
            this.j = 0;
        }
        this.g.a(new 20(this, str));
        if (this.e != null) {
            this.e.b(str);
        }
    }

    public void c(String str) {
        this.d.a(str);
    }

    public void n() {
        if (0 != this.b) {
            this.g.a(new hv.a() {
                public void a(GL10 gl10) {
                    hq.this.a.nativeHideCompass(hq.this.b);
                }
            });
        }
    }

    public int a(String str, double d, double d2, float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, boolean z3, boolean z4, int i) {
        if (0 == this.b) {
            return 0;
        }
        int nativeAddMarker;
        synchronized (this) {
            nativeAddMarker = this.a.nativeAddMarker(this.b, str, d, d2, f, f2, f3, f4, f5, f6, z, z2, z3, z4, i);
        }
        return nativeAddMarker;
    }

    public void a(int i, String str, double d, double d2, float f, float f2, float f3, float f4, float f5, float f6, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        if (0 != this.b) {
            this.g.a(new 22(this, i, str, d, d2, f, f2, f3, f4, f5, f6, z, z2, z3, z4, i2));
        }
    }

    public void a(int[] iArr, int i) {
        if (0 != this.b) {
            synchronized (this) {
                this.a.nativeDeleteIcons(this.b, iArr, i);
            }
        }
    }

    public void c(final boolean z) {
        if (0 != this.b) {
            this.g.a(new hv.a() {
                public void a(GL10 gl10) {
                    hq.this.a.nativeSetCompassVisible(hq.this.b, z);
                }
            });
        }
    }

    public void c(int i, int i2) {
        if (0 != this.b) {
            this.g.a(new 24(this, i, i2));
        }
    }

    public double a(Rect rect, Rect rect2) {
        if (0 == this.b) {
            return 1.0d;
        }
        double nativeGetTargetScale;
        synchronized (this) {
            nativeGetTargetScale = this.a.nativeGetTargetScale(this.b, rect, rect2);
        }
        return nativeGetTargetScale;
    }

    public void a(Rect rect, Rect rect2, boolean z) {
        if (0 != this.b && this.g != null) {
            this.g.a(new 25(this, rect, rect2, z));
        }
    }

    public void d(boolean z) {
        if (this.b != 0 && this.g != null) {
            synchronized (this) {
                this.a.nativeIndoorBuildingEnabled(this.b, z);
            }
        }
    }

    public int o() {
        if (0 == this.b) {
            return -1;
        }
        int nativeGetIndoorCurrentFloorId;
        synchronized (this) {
            nativeGetIndoorCurrentFloorId = this.a.nativeGetIndoorCurrentFloorId(this.b);
        }
        return nativeGetIndoorCurrentFloorId;
    }

    public String[] p() {
        if (0 == this.b) {
            return null;
        }
        String[] nativeGetIndoorFloorNames;
        synchronized (this) {
            nativeGetIndoorFloorNames = this.a.nativeGetIndoorFloorNames(this.b);
        }
        return nativeGetIndoorFloorNames;
    }

    public String b(GeoPoint geoPoint) {
        if (0 == this.b) {
            return null;
        }
        String nativeGetCurIndoorName;
        synchronized (this) {
            nativeGetCurIndoorName = this.a.nativeGetCurIndoorName(this.b, geoPoint);
        }
        return nativeGetCurIndoorName;
    }

    public void e(boolean z) {
        if (0 != this.b) {
            this.g.a(new 3(this, z));
        }
    }

    public void a(float f, float f2, boolean z) {
        if (0 != this.b && this.g != null) {
            this.g.a(new 4(this, f, f2, z));
        }
    }

    public void a(GeoPoint geoPoint, boolean z) {
        if (0 != this.b && this.g != null) {
            this.g.a(new 6(this, geoPoint, z));
        }
    }

    public void c(GeoPoint geoPoint) {
        if (0 != this.b && this.g != null) {
            this.a.nativeSetCenter(this.b, geoPoint, false);
        }
    }

    public GeoPoint q() {
        if (0 == this.b) {
            return null;
        }
        GeoPoint geoPoint;
        synchronized (this) {
            geoPoint = new GeoPoint();
            this.a.nativeGetCenterMapPoint(this.b, geoPoint);
        }
        return geoPoint;
    }

    public void a(final double d, final boolean z) {
        if (0 != this.b && this.g != null) {
            this.g.a(new hv.a() {
                public void a(GL10 gl10) {
                    hq.this.a.nativeSetScale(hq.this.b, d, z);
                }
            });
        }
    }

    public void a(double d) {
        if (0 != this.b && this.g != null) {
            this.a.nativeSetScale(this.b, d, false);
        }
    }

    public float r() {
        if (0 == this.b) {
            return 1.0f;
        }
        float nativeGetScale;
        synchronized (this) {
            nativeGetScale = (float) this.a.nativeGetScale(this.b);
        }
        return nativeGetScale;
    }

    public int s() {
        if (0 == this.b) {
            return ic.a.c;
        }
        int nativeGetScaleLevel;
        synchronized (this) {
            nativeGetScaleLevel = this.a.nativeGetScaleLevel(this.b);
        }
        return nativeGetScaleLevel;
    }

    public void b(float f, float f2) {
        if (0 != this.b && this.g != null) {
            this.g.a(new 8(this, f, f2));
        }
    }

    public void t() {
        if (0 != this.b && this.g != null) {
            this.g.a(new 9(this));
        }
    }

    public void b(float f, float f2, boolean z) {
        if (0 != this.b && this.g != null) {
            this.g.a(new 10(this, z, f, f2));
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        if (0 != this.b && this.g != null) {
            this.g.a(new 12(this, i, i2, i3, i4));
        }
    }

    public void u() {
        if (0 != this.b) {
            synchronized (this) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.h == 0) {
                    this.a.nativeUpdateFrame(this.b, 0.0d);
                } else {
                    this.a.nativeUpdateFrame(this.b, (double) (currentTimeMillis - this.h));
                }
                this.h = currentTimeMillis;
            }
        }
    }

    public boolean v() {
        if (0 == this.b) {
            return false;
        }
        boolean nativeNeedDispaly;
        synchronized (this) {
            nativeNeedDispaly = this.a.nativeNeedDispaly(this.b);
        }
        return nativeNeedDispaly;
    }

    public void f(boolean z) {
        if (0 != this.b) {
            synchronized (this) {
                this.a.nativeSetNeedDisplay(this.b, z);
            }
        }
    }

    public void b(int i) {
        if (0 != this.b) {
            synchronized (this) {
                this.a.nativeSetMaxScaleLevel(this.b, i);
            }
        }
    }

    public void c(int i) {
        if (0 != this.b) {
            synchronized (this) {
                this.a.nativeSetMinScaleLevel(this.b, i);
            }
        }
    }

    public void a(float f) {
        if (0 != this.b) {
            synchronized (this) {
                this.a.nativeSetRotate(this.b, f, false);
            }
        }
    }

    public void b(float f) {
        if (0 != this.b) {
            synchronized (this) {
                this.a.nativeSetSkew(this.b, f, false);
            }
        }
    }

    public void b(int i, boolean z) {
        if (0 != this.b) {
            this.g.a(new 13(this, i, z));
        }
    }

    public float w() {
        if (0 == this.b) {
            return 0.0f;
        }
        return this.a.nativeGetSkew(this.b);
    }

    public float x() {
        if (0 == this.b) {
            return 0.0f;
        }
        return this.a.nativeGetRotate(this.b);
    }

    public int y() {
        if (0 == this.b) {
            return 1;
        }
        int nativeGetMapMode;
        synchronized (this) {
            nativeGetMapMode = this.a.nativeGetMapMode(this.b);
        }
        return nativeGetMapMode;
    }

    public int c(int i, boolean z) {
        if (this.b == 0) {
            return -1;
        }
        int nativeAddHeatTileOverlay;
        synchronized (this) {
            nativeAddHeatTileOverlay = this.a.nativeAddHeatTileOverlay(this.b, i, z);
        }
        return nativeAddHeatTileOverlay;
    }

    public void d(int i) {
        if (this.b != 0) {
            synchronized (this) {
                this.a.nativeRemoveHeatTileOverlay(this.b, i);
            }
        }
    }

    public void e(int i) {
        if (this.b != 0) {
            synchronized (this) {
                this.a.nativeReloadHeatTileOverlay(this.b, i);
            }
        }
    }

    public void f(int i) {
        if (this.g != null) {
            ic e = this.g.e();
            if (e != null) {
                e.a();
            }
        }
    }

    public void z() {
        if (this.f != null) {
            this.f.z();
        }
    }

    public void a(JNICallback.d dVar) {
        this.a.setHeatTileLoadCallback(dVar);
    }

    public void a(j jVar) {
        this.a.setWorldTileLoadCallback(jVar);
    }

    public void a(b bVar) {
        this.a.setHandDrawTileLoadCallback(bVar);
    }

    public void a(JNICallback$c jNICallback$c) {
        this.a.setHandDrawTileWriteCallback(jNICallback$c);
    }

    public void a(k kVar) {
        this.a.setTileWriteCallback(kVar);
    }

    public void a(f fVar) {
        this.a.setMapCallbackGetGLContext(fVar);
    }

    public void d(int i, int i2) {
        if (this.b != 0) {
            this.a.nativeBringElementAbove(this.b, i, i2);
        }
    }

    public void a(List<MapRouteSectionWithName> list, List<GeoPoint> list2) {
        if (0 != this.b) {
            synchronized (this) {
                if (list != null) {
                    if (!(list.isEmpty() || list2 == null || list2.isEmpty())) {
                        int size = list.size();
                        byte[][] bArr = new byte[size][];
                        for (int i = 0; i < size; i++) {
                            MapRouteSectionWithName mapRouteSectionWithName = (MapRouteSectionWithName) list.get(i);
                            if (mapRouteSectionWithName != null) {
                                bArr[i] = mapRouteSectionWithName.toBytes();
                            }
                        }
                        int size2 = list2.size();
                        this.a.nativeAddRouteNameSegments(this.b, bArr, size, (GeoPoint[]) list2.toArray(new GeoPoint[size2]), size2);
                    }
                }
            }
        }
    }

    public void A() {
        if (0 != this.b) {
            synchronized (this) {
                this.a.nativeClearRouteNameSegments(this.b);
            }
        }
    }

    public List<Integer> a(Rect rect, int i) {
        List<Integer> list = null;
        if (0 != this.b) {
            synchronized (this) {
                int[] iArr = new int[100];
                int nativeQueryCityCodeList = this.a.nativeQueryCityCodeList(this.b, rect, i, iArr, 100);
                if (nativeQueryCityCodeList > 0) {
                    list = new ArrayList(nativeQueryCityCodeList);
                    for (int i2 = 0; i2 < nativeQueryCityCodeList; i2++) {
                        list.add(Integer.valueOf(iArr[i2]));
                    }
                }
            }
        }
        return list;
    }

    public void d(String str) {
        if (this.b != 0) {
            synchronized (this) {
                this.a.nativeMapLoadKMLFile(this.b, str);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.List<com.tencent.map.lib.mapstructure.BlockRouteCityData> r8) {
        /*
        r7 = this;
        r0 = 0;
        r2 = r7.b;
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        monitor-enter(r7);
        if (r8 == 0) goto L_0x0012;
    L_0x000c:
        r0 = r8.isEmpty();	 Catch:{ all -> 0x0014 }
        if (r0 == 0) goto L_0x0017;
    L_0x0012:
        monitor-exit(r7);	 Catch:{ all -> 0x0014 }
        goto L_0x0008;
    L_0x0014:
        r0 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x0014 }
        throw r0;
    L_0x0017:
        r6 = r8.size();	 Catch:{ all -> 0x0014 }
        r4 = new int[r6];	 Catch:{ all -> 0x0014 }
        r5 = new int[r6];	 Catch:{ all -> 0x0014 }
        r0 = 0;
        r1 = r0;
    L_0x0021:
        if (r1 >= r6) goto L_0x0037;
    L_0x0023:
        r0 = r8.get(r1);	 Catch:{ all -> 0x0014 }
        r0 = (com.tencent.map.lib.mapstructure.BlockRouteCityData) r0;	 Catch:{ all -> 0x0014 }
        if (r0 == 0) goto L_0x0033;
    L_0x002b:
        r2 = r0.cityCode;	 Catch:{ all -> 0x0014 }
        r4[r1] = r2;	 Catch:{ all -> 0x0014 }
        r0 = r0.version;	 Catch:{ all -> 0x0014 }
        r5[r1] = r0;	 Catch:{ all -> 0x0014 }
    L_0x0033:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0021;
    L_0x0037:
        r1 = r7.a;	 Catch:{ all -> 0x0014 }
        r2 = r7.b;	 Catch:{ all -> 0x0014 }
        r1.nativeLoadBlockRouteCityList(r2, r4, r5, r6);	 Catch:{ all -> 0x0014 }
        monitor-exit(r7);	 Catch:{ all -> 0x0014 }
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.a.hq.a(java.util.List):void");
    }

    public void g(boolean z) {
        if (0 != this.b) {
            synchronized (this) {
                this.a.nativeSetBlockRouteVisible(this.b, z);
            }
        }
    }

    public int B() {
        if (this.b == 0) {
            return 0;
        }
        int nativeGetLanguage;
        synchronized (this) {
            nativeGetLanguage = this.a.nativeGetLanguage(this.b);
        }
        return nativeGetLanguage;
    }

    public void i(iq iqVar) {
        if (this.b != 0) {
            int r = iqVar.r();
            if (r != -1 && iqVar.v() >= 0.0f) {
                int m = iqVar.m();
                if (m == 3 || m == 0) {
                    synchronized (this) {
                        this.a.nativeSetLineArrowSpacing(this.b, r, iqVar.v());
                    }
                    return;
                }
                synchronized (this) {
                    this.a.nativeSetLineFootPrintSpacing(this.b, r, iqVar.v());
                }
            }
        }
    }

    public void e(String str) {
        if (this.b != 0) {
            this.g.a(new 15(this, str));
        }
    }

    public void h(boolean z) {
        if (this.b != 0) {
            this.a.nativeEnablePOI(this.b, z);
        }
    }

    public void i(boolean z) {
        if (this.b != 0) {
            this.a.nativeEnableVectorMap(this.b, z);
        }
    }
}
