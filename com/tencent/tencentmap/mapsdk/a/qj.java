package com.tencent.tencentmap.mapsdk.a;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;

public class qj implements Marker {
    private pa a;
    private qn b;

    public qj(qn qnVar, pa paVar) {
        this.b = qnVar;
        this.a = paVar;
        if (this.b != null && this.b.a() != null) {
            synchronized (qj.class) {
                this.b.a().add(this.a);
            }
        }
    }

    public float getAlpha() {
        if (this.a != null) {
            return this.a.l();
        }
        return 0.0f;
    }

    public String getId() {
        if (this.a != null) {
            return this.a.g();
        }
        return null;
    }

    public LatLng getPosition() {
        if (this.a != null) {
            return qo.a(this.a.i());
        }
        return null;
    }

    public float getRotation() {
        if (this.a != null) {
            return this.a.q();
        }
        return 0.0f;
    }

    public String getSnippet() {
        if (this.a != null) {
            return this.a.k();
        }
        return null;
    }

    public String getTitle() {
        if (this.a != null) {
            return this.a.j();
        }
        return null;
    }

    public void hideInfoWindow() {
        if (this.a != null) {
            this.a.o();
        }
    }

    public boolean isDraggable() {
        if (this.a != null) {
            return this.a.m();
        }
        return false;
    }

    public boolean isInfoWindowShown() {
        if (this.a != null) {
            return this.a.p();
        }
        return false;
    }

    public boolean isVisible() {
        if (this.a != null) {
            return this.a.r();
        }
        return false;
    }

    public void remove() {
        if (this.a != null) {
            synchronized (qj.class) {
                if (!(this.b == null || this.b.a() == null)) {
                    this.b.a().remove(this.a);
                }
            }
            this.a.f();
        }
    }

    public void setAlpha(float f) {
        if (this.a != null) {
            this.a.b(f);
        }
    }

    public void setAnchor(float f, float f2) {
        if (this.a != null) {
            this.a.a(f, f2);
        }
    }

    public void setDraggable(boolean z) {
        if (this.a != null) {
            this.a.a(z);
        }
    }

    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (this.a != null && bitmapDescriptor != null) {
            this.a.a(oo.a(bitmapDescriptor.getBitmap()));
        }
    }

    public void setPosition(LatLng latLng) {
        if (this.a != null) {
            this.a.a(qo.a(latLng));
        }
    }

    public void setRotation(float f) {
        if (this.a != null) {
            this.a.a(f);
        }
    }

    public void setSnippet(String str) {
        if (this.a != null) {
            this.a.b(str);
        }
    }

    public void setTitle(String str) {
        if (this.a != null) {
            this.a.a(str);
        }
    }

    public void setVisible(boolean z) {
        if (this.a != null) {
            this.a.b(z);
        }
    }

    public void showInfoWindow() {
        if (this.a != null) {
            this.a.n();
        }
    }

    public void set2Top() {
        if (this.b != null && this.b.a() != null) {
            synchronized (qj.class) {
                int size = this.b.a().size();
                for (pa paVar : this.b.a()) {
                    int t;
                    if (paVar.t() > ((float) size)) {
                        t = (int) paVar.t();
                    } else {
                        t = size;
                    }
                    size = t;
                }
                this.a.c(size < Integer.MAX_VALUE ? (float) (size + 1) : 2.14748365E9f);
            }
        }
    }

    public View getMarkerView() {
        return null;
    }

    public void setMarkerView(View view) {
        if (this.a != null) {
            this.a.a(oo.a(view));
        }
    }

    public void setInfoWindowHideAnimation(Animation animation) {
    }

    public void setInfoWindowShowAnimation(Animation animation) {
    }

    public Object getTag() {
        if (this.a != null) {
            return this.a.z();
        }
        return null;
    }

    public void setTag(Object obj) {
        if (this.a != null) {
            this.a.a(obj);
        }
    }

    public void setZIndex(float f) {
        if (this.a != null) {
            this.a.c(f);
        }
    }

    public float getZIndex() {
        if (this.a != null) {
            return this.a.t();
        }
        return 0.0f;
    }
}
