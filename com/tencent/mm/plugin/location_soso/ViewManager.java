package com.tencent.mm.plugin.location_soso;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mm.plugin.r.e;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import java.util.HashMap;
import java.util.Map;

public class ViewManager implements e {
    private Map<View, Marker> mMarkerMap = new HashMap();
    private TencentMap mTencentMap;

    public ViewManager(TencentMap tencentMap) {
        this.mTencentMap = tencentMap;
    }

    public void addView(View view, double d, double d2) {
        if (this.mTencentMap != null) {
            this.mMarkerMap.put(view, this.mTencentMap.addMarker(new MarkerOptions().position(new LatLng(d, d2)).markerView(view)));
        }
    }

    public void addPinView(View view, double d, double d2) {
        if (this.mTencentMap != null) {
            this.mMarkerMap.put(view, this.mTencentMap.addMarker(new MarkerOptions().position(new LatLng(d, d2)).anchor(0.5f, 0.5f).markerView(view)));
        }
    }

    public void removeView(View view) {
        if (this.mTencentMap != null) {
            Marker marker = (Marker) this.mMarkerMap.get(view);
            if (marker != null) {
                marker.remove();
            }
        }
    }

    public void updateViewLayout(View view, double d, double d2, boolean z) {
        if (this.mTencentMap != null) {
            Marker marker = (Marker) this.mMarkerMap.get(view);
            marker.setVisible(view.getVisibility() == 0);
            marker.setPosition(new LatLng(d, d2));
            if (z) {
                marker.setMarkerView(view);
            }
            marker.setAnchor(0.5f, 1.0f);
        }
    }

    public void updateLocaitonPinLayout(View view, double d, double d2, boolean z) {
        if (this.mTencentMap != null) {
            Marker marker = (Marker) this.mMarkerMap.get(view);
            marker.setVisible(view.getVisibility() == 0);
            marker.setPosition(new LatLng(d, d2));
            if (z) {
                marker.setMarkerView(view);
            }
            marker.setAnchor(0.5f, 0.5f);
        }
    }

    public void updateRotation(View view, float f) {
        if (this.mTencentMap != null) {
            ((Marker) this.mMarkerMap.get(view)).setRotation(f);
        }
    }

    public void toggleViewVisible(View view) {
        if (this.mTencentMap != null) {
            ((Marker) this.mMarkerMap.get(view)).setVisible(view.getVisibility() == 0);
        }
    }

    public void updateMarkerView(View view) {
        if (this.mTencentMap != null) {
            ((Marker) this.mMarkerMap.get(view)).setMarkerView(view);
        }
    }

    public void setMarker2Top(View view) {
        if (this.mTencentMap != null) {
            ((Marker) this.mMarkerMap.get(view)).set2Top();
        }
    }

    public void setMarkerClick(View view, OnClickListener onClickListener) {
        if (this.mTencentMap != null) {
            this.mTencentMap.setOnInfoWindowClickListener(new 1(this, (Marker) this.mMarkerMap.get(view), onClickListener, view));
        }
    }

    public void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        this.mTencentMap.setInfoWindowAdapter(infoWindowAdapter);
    }

    public void showInfoWindowByView(View view) {
        if (this.mTencentMap != null) {
            ((Marker) this.mMarkerMap.get(view)).showInfoWindow();
        }
    }

    public void setMarkerTag(View view, String str) {
        if (this.mTencentMap != null) {
            ((Marker) this.mMarkerMap.get(view)).setTag(str);
        }
    }

    public void destroy() {
        if (this.mMarkerMap != null) {
            this.mMarkerMap.clear();
        }
    }
}
