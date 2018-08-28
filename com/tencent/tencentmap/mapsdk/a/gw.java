package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.a.ic.b;
import java.util.List;

public class gw implements hh {
    private ic a;
    private hq b;
    private hv c;

    public gw(gy gyVar) {
        this.c = (hv) gyVar;
        this.a = gyVar.a().j();
        this.b = gyVar.f();
    }

    public void a(float f) {
        this.a.d(f);
    }

    public void a(GeoPoint geoPoint) {
        this.a.a(geoPoint);
    }

    public void a(List<iw> list, Rect rect, a aVar) {
        if (list != null && !list.isEmpty()) {
            Rect rect2 = new Rect(this.c.g());
            if (rect != null) {
                rect2.left += rect.left;
                rect2.right -= rect.right;
                rect2.top += rect.top;
                rect2.bottom -= rect.bottom;
            }
            int width = rect2.width();
            int height = rect2.height();
            hk g = this.c.a().g();
            int f = g.f();
            this.c.a(new 1(this, list, width, height, rect, f, g, aVar));
            if (f != 60) {
                g.e();
                g.g();
            }
        }
    }

    public GeoPoint a(DoublePoint doublePoint) {
        return this.b.a(this.a.r(), (float) doublePoint.x, (float) doublePoint.y);
    }

    public DoublePoint b(GeoPoint geoPoint) {
        double latitudeE6 = ((double) geoPoint.getLatitudeE6()) / 1000000.0d;
        double longitudeE6 = ((double) geoPoint.getLongitudeE6()) / 1000000.0d;
        PointF a = this.b.a(this.a.r(), latitudeE6, longitudeE6);
        return new DoublePoint((double) a.x, (double) a.y);
    }

    public double a(double d) {
        return 0.0d;
    }

    public double a(Point point, Point point2) {
        return 0.0d;
    }

    private Rect a(List<iw> list, hh hhVar) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (iw a : list) {
            Rect a2 = a.a(hhVar);
            if (a2 != null) {
                int i5;
                if (i4 == 0) {
                    i4 = a2.left;
                }
                if (i3 == 0) {
                    i3 = a2.right;
                }
                if (i2 == 0) {
                    i2 = a2.top;
                }
                if (i == 0) {
                    i = a2.bottom;
                }
                if (a2.left < i4) {
                    i4 = a2.left;
                }
                if (a2.right > i3) {
                    i3 = a2.right;
                }
                if (a2.top < i2) {
                    i2 = a2.top;
                }
                if (a2.bottom > i) {
                    i5 = a2.bottom;
                } else {
                    i5 = i;
                }
                i = i5;
            }
        }
        return new Rect(i4, i2, i3, i);
    }

    private boolean a() {
        b q = this.a.q();
        if (q == null) {
            return false;
        }
        if (q.a() == 0.0f && q.b() == 0.0f) {
            return false;
        }
        return true;
    }

    private boolean b() {
        b q = this.a.q();
        if (q == null) {
            return false;
        }
        if (((double) Math.abs(q.a())) > 0.25d || ((double) Math.abs(q.b())) > 0.25d) {
            return true;
        }
        return false;
    }

    private GeoPoint a(GeoPoint geoPoint, Rect rect) {
        if (geoPoint == null) {
            return null;
        }
        DoublePoint b = b(geoPoint);
        if (b == null || rect == null) {
            return null;
        }
        return a(new DoublePoint(b.x - (((double) (rect.left - rect.right)) * 0.5d), b.y - (((double) (rect.top - rect.bottom)) * 0.5d)));
    }

    private GeoPoint a(GeoPoint geoPoint, b bVar) {
        if (geoPoint == null) {
            return null;
        }
        DoublePoint b = b(geoPoint);
        if (b == null || bVar == null) {
            return null;
        }
        double d = b.x;
        double d2 = b.y;
        Rect rect = new Rect(this.c.g());
        int width = rect.width();
        int height = rect.height();
        float a = bVar.a() + 0.5f;
        float b2 = bVar.b() + 0.5f;
        if (((double) a) < 0.25d) {
            d += (0.25d - ((double) a)) * ((double) width);
        } else if (((double) a) > 0.75d) {
            d -= (((double) a) - 0.75d) * ((double) width);
        }
        if (((double) b2) < 0.25d) {
            d2 += ((double) height) * (0.25d - ((double) b2));
        } else if (((double) b2) > 0.75d) {
            d2 -= ((double) height) * (((double) b2) - 0.75d);
        }
        return a(new DoublePoint(d, d2));
    }
}
