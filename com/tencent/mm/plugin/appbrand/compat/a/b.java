package com.tencent.mm.plugin.appbrand.compat.a;

import android.graphics.Bitmap;
import android.view.View;
import java.util.List;

public interface b {

    public interface e {
        View a(h hVar);

        void bG(View view);
    }

    public interface g {
        f adE();

        f adF();
    }

    public interface h extends d {
        f adI();

        void b(f fVar);

        View getMarkerView();

        float getRotation();

        Object getTag();

        void hideInfoWindow();

        boolean isInfoWindowShown();

        void remove();

        void set2Top();

        void setRotation(float f);

        void showInfoWindow();
    }

    public interface j {
        void b(h hVar);
    }

    public interface p {
        void c(Iterable<f> iterable);

        void jT(int i);

        void jU(int i);

        void jV(int i);

        void jW(int i);

        void setDottedLine(boolean z);

        void u(Bitmap bitmap);
    }

    b a(c cVar);

    h a(i iVar);

    o a(p pVar);

    void a(e eVar);

    void a(j jVar);

    void a(k kVar);

    void a(l lVar);

    void a(m mVar);

    void a(n nVar);

    p adA();

    void adB();

    void adC();

    void adD();

    void adv();

    f adw();

    q adx();

    i ady();

    c adz();

    void animateTo(double d, double d2);

    void b(double d, double d2, int i);

    void clean();

    void d(List<f> list, int i);

    f g(double d, double d2);

    View getView();

    int getZoomLevel();

    void jS(int i);

    void onDestroy();

    void onPause();

    void onResume();

    void setCenter(double d, double d2);
}
