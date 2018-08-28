package com.tencent.mm.plugin.appbrand.compat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.compat.a.b.c;
import com.tencent.mm.plugin.appbrand.compat.a.b.e;
import com.tencent.mm.plugin.appbrand.compat.a.b.f;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.compat.a.b.i;
import com.tencent.mm.plugin.appbrand.compat.a.b.j;
import com.tencent.mm.plugin.appbrand.compat.a.b.k;
import com.tencent.mm.plugin.appbrand.compat.a.b.l;
import com.tencent.mm.plugin.appbrand.compat.a.b.m;
import com.tencent.mm.plugin.appbrand.compat.a.b.n;
import com.tencent.mm.plugin.appbrand.compat.a.b.o;
import com.tencent.mm.plugin.appbrand.compat.a.b.p;
import com.tencent.mm.plugin.appbrand.compat.a.b.q;
import com.tencent.mm.plugin.appbrand.compat.m.a;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

final class d implements b {
    final FrameLayout fos;
    final SoSoMapView fot;

    d(Context context, boolean z) {
        this.fos = new FrameLayout(context);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.fos.setBackgroundColor(0);
        this.fos.setLayoutParams(layoutParams);
        TencentMapOptions tencentMapOptions = new TencentMapOptions();
        tencentMapOptions.setMapType(0);
        tencentMapOptions.enableHandDrawMap(z);
        tencentMapOptions.setMapType(0);
        this.fot = new SoSoMapView(context, tencentMapOptions);
        this.fos.addView(this.fot, new FrameLayout.LayoutParams(-1, -1));
        this.fos.setTag(R.h.app_brand_map_view_controller, this);
    }

    public final void adv() {
        this.fot.onCreate(null);
    }

    public final void onResume() {
        this.fot.onResume();
    }

    public final void onPause() {
        this.fot.onPause();
    }

    public final void onDestroy() {
        this.fot.onDestroy();
    }

    public final View getView() {
        return this.fos;
    }

    public final f adw() {
        LatLng mapCenter = this.fot.getMap().getMapCenter();
        return new f(mapCenter.getLatitude(), mapCenter.getLongitude());
    }

    public final f g(double d, double d2) {
        return new f(d, d2);
    }

    public final q adx() {
        return new j(this.fot.getProjection());
    }

    public final void b(double d, double d2, int i) {
        TencentMap map = this.fot.getMap();
        if (map != null) {
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(d, d2), (float) i));
        }
    }

    public final void setCenter(double d, double d2) {
        this.fot.getIController().setCenter(d, d2);
    }

    public final void jS(int i) {
        TencentMap map = this.fot.getMap();
        if (map != null) {
            map.animateCamera(CameraUpdateFactory.zoomTo((float) i));
        }
    }

    public final void animateTo(double d, double d2) {
        this.fot.getIController().animateTo(d, d2);
    }

    public final int getZoomLevel() {
        return this.fot.getMap().getZoomLevel();
    }

    public final void clean() {
        this.fot.clean();
    }

    public final void d(List<f> list, int i) {
        Builder builder = new Builder();
        Iterable linkedList = new LinkedList();
        for (f fVar : list) {
            if (fVar instanceof f) {
                linkedList.add(((f) fVar).foC);
            } else {
                linkedList.add(new LatLng(fVar.adG(), fVar.adH()));
            }
        }
        builder.include(linkedList);
        this.fot.getMap().animateCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), i));
    }

    public final void a(m mVar) {
        this.fot.getMap().setOnMapLoadedListener(new 1(this, mVar));
    }

    public final void a(final l lVar) {
        this.fot.getMap().setOnMapClickListener(new OnMapClickListener() {
            public final void onMapClick(LatLng latLng) {
                if (lVar != null) {
                    l lVar = lVar;
                    k.b(latLng);
                    lVar.adO();
                }
            }
        });
    }

    public final void a(final k kVar) {
        this.fot.getMap().setOnMapCameraChangeListener(new OnMapCameraChangeListener() {
            public final void onCameraChange(CameraPosition cameraPosition) {
                if (kVar != null) {
                    k kVar = kVar;
                    k.b(cameraPosition);
                    kVar.adM();
                }
            }

            public final void onCameraChangeFinish(CameraPosition cameraPosition) {
                if (kVar != null) {
                    k kVar = kVar;
                    k.b(cameraPosition);
                    kVar.adN();
                }
            }
        });
    }

    public final void a(j jVar) {
        this.fot.getMap().setOnInfoWindowClickListener(new 4(this, jVar));
    }

    public final void a(final n nVar) {
        this.fot.getMap().setOnMarkerClickListener(new OnMarkerClickListener() {
            public final boolean onMarkerClick(Marker marker) {
                return nVar != null && nVar.c(new g(marker));
            }
        });
    }

    public final void a(e eVar) {
        InfoWindowAdapter infoWindowAdapter;
        TencentMap map = this.fot.getMap();
        if (eVar == null) {
            infoWindowAdapter = null;
        } else {
            infoWindowAdapter = new 6(this, eVar);
        }
        map.setInfoWindowAdapter(infoWindowAdapter);
    }

    public final i ady() {
        return new h();
    }

    public final h a(i iVar) {
        Marker addMarker;
        if (iVar instanceof h) {
            addMarker = this.fot.getMap().addMarker(((h) iVar).foF);
        } else {
            addMarker = null;
            Assert.assertTrue("Should use IAppBrandMapView.createMarkersOptions to initiate MarkerOptions!", true);
        }
        return new g(addMarker);
    }

    public final c adz() {
        return new c();
    }

    public final b.b a(c cVar) {
        Circle addCircle;
        if (cVar instanceof c) {
            addCircle = this.fot.getMap().addCircle(((c) cVar).for);
        } else {
            addCircle = null;
            Assert.assertTrue("Should use IAppBrandMapView.createMarkersOptions to initiate CircleOptions!", true);
        }
        return new a(addCircle);
    }

    public final o a(p pVar) {
        Polyline addPolyline;
        if (pVar instanceof i) {
            addPolyline = this.fot.getMap().addPolyline(((i) pVar).foG);
        } else {
            addPolyline = null;
            Assert.assertTrue("Should use IAppBrandMapView.createPolylineOptions to initiate PolylineOptions!", true);
        }
        return new m.b(addPolyline);
    }

    public final p adA() {
        return new i();
    }

    public final void adB() {
        this.fot.getUiSettings().setTiltGesturesEnabled(false);
    }

    public final void adC() {
        this.fot.getUiSettings().setRotateGesturesEnabled(false);
    }

    public final void adD() {
        this.fot.getMap().setMapAnchor(0.5f, 0.5f);
    }
}
