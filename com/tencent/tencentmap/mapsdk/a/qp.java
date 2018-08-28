package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.map.UiSettings;

public class qp implements UiSettings {
    private ae a;

    public qp(ae aeVar) {
        this.a = aeVar;
    }

    public boolean isAnimationEnabled() {
        return false;
    }

    public void setAnimationEnabled(boolean z) {
    }

    public void setScaleControlsEnabled(boolean z) {
        if (this.a != null) {
            this.a.g(z);
        }
    }

    public void setScrollGesturesEnabled(boolean z) {
        if (this.a != null) {
            this.a.b(z);
        }
    }

    public void setZoomGesturesEnabled(boolean z) {
        if (this.a != null) {
            this.a.c(z);
        }
    }

    public void setAllGesturesEnabled(boolean z) {
        if (this.a != null) {
            this.a.f(z);
        }
    }

    public void setLogoPosition(int i) {
        if (this.a != null) {
            this.a.b(i);
        }
    }

    public void setScaleViewPosition(int i) {
        if (this.a != null) {
            switch (i) {
                case 1:
                    i = 4;
                    break;
                case 2:
                    i = 1;
                    break;
            }
            this.a.a(i);
        }
    }

    public boolean isScaleControlsEnabled() {
        if (this.a != null) {
            return this.a.c();
        }
        return false;
    }

    public void setTiltGesturesEnabled(boolean z) {
        if (this.a != null) {
            this.a.d(z);
        }
    }

    public void setRotateGesturesEnabled(boolean z) {
        if (this.a != null) {
            this.a.e(z);
        }
    }

    public boolean isTiltGesturesEnabled() {
        if (this.a == null) {
            return false;
        }
        return this.a.a();
    }

    public boolean isRotateGesturesEnabled() {
        if (this.a == null) {
            return false;
        }
        return this.a.b();
    }
}
