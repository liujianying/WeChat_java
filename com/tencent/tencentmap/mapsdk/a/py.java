package com.tencent.tencentmap.mapsdk.a;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Polyline;
import java.util.List;

public class py implements Polyline {
    private rc a;

    public py(rc rcVar) {
        this.a = rcVar;
    }

    public void remove() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public String getId() {
        if (this.a != null) {
            return this.a.b();
        }
        return null;
    }

    public void setPoints(List<LatLng> list) {
        if (this.a != null) {
            this.a.a(qc.b((List) list));
        }
    }

    public List<LatLng> getPoints() {
        if (this.a != null) {
            return qc.a(this.a.c());
        }
        return null;
    }

    public void setWidth(float f) {
        if (this.a != null) {
            rc rcVar = this.a;
            if (f < 0.0f) {
                f = 0.0f;
            }
            rcVar.a(f);
        }
    }

    public float getWidth() {
        if (this.a != null) {
            return this.a.d();
        }
        return 0.0f;
    }

    public void setColor(int i) {
        if (this.a != null) {
            this.a.a(i);
        }
    }

    public int getColor() {
        if (this.a != null) {
            return this.a.e();
        }
        return 0;
    }

    public void setZIndex(float f) {
        if (this.a != null) {
            this.a.b((float) ((int) f));
        }
    }

    public float getZIndex() {
        if (this.a != null) {
            return this.a.f();
        }
        return 0.0f;
    }

    public void setVisible(boolean z) {
        if (this.a != null) {
            this.a.a(z);
        }
    }

    public boolean isVisible() {
        if (this.a != null) {
            return this.a.g();
        }
        return false;
    }

    public void setGeodesic(boolean z) {
        if (this.a != null) {
            this.a.b(z);
        }
    }

    public boolean isGeodesic() {
        if (this.a != null) {
            return this.a.h();
        }
        return false;
    }

    public void setDottedLine(boolean z) {
        if (this.a != null) {
            this.a.c(z);
        }
    }

    public boolean isDottedLine() {
        if (this.a != null) {
            return this.a.i();
        }
        return false;
    }
}
