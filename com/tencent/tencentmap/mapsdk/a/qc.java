package com.tencent.tencentmap.mapsdk.a;

import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.tencentmap.mapsdk.map.CameraParameter;
import com.tencent.tencentmap.mapsdk.map.CameraUpdate;
import java.util.ArrayList;
import java.util.List;

public class qc {
    public static qw a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new qw(latLng.getLatitude(), latLng.getLongitude());
    }

    public static LatLng a(qw qwVar) {
        if (qwVar == null) {
            return null;
        }
        return new LatLng(qwVar.b(), qwVar.c());
    }

    public static List<LatLng> a(List<qw> list) {
        if (list == null) {
            return null;
        }
        List<LatLng> arrayList = new ArrayList();
        for (qw a : list) {
            arrayList.add(a(a));
        }
        return arrayList;
    }

    public static List<qw> b(List<LatLng> list) {
        if (list == null) {
            return null;
        }
        List<qw> arrayList = new ArrayList();
        for (LatLng a : list) {
            arrayList.add(a(a));
        }
        return arrayList;
    }

    public static qs a(CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            return null;
        }
        return new qs(a(cameraPosition.getTarget()), a(cameraPosition.getZoom()));
    }

    public static CameraPosition a(qs qsVar) {
        if (qsVar == null) {
            return null;
        }
        return new CameraPosition(a(qsVar.b()), b(qsVar.c()));
    }

    public static VisibleRegion a(rj rjVar) {
        if (rjVar == null) {
            return null;
        }
        return new VisibleRegion(a(rjVar.a()), a(rjVar.b()), a(rjVar.c()), a(rjVar.d()), a(rjVar.e()));
    }

    public static float a(float f) {
        return f;
    }

    public static float b(float f) {
        return f;
    }

    static qx a(LatLngBounds latLngBounds) {
        if (latLngBounds == null || latLngBounds.getNortheast() == null || latLngBounds.getSouthwest() == null) {
            return null;
        }
        return new qx(new qw(latLngBounds.getSouthwest().getLatitude(), latLngBounds.getSouthwest().getLongitude()), new qw(latLngBounds.getNortheast().getLatitude(), latLngBounds.getNortheast().getLongitude()));
    }

    static LatLngBounds a(qx qxVar) {
        if (qxVar == null || qxVar.c() == null || qxVar.b() == null) {
            return null;
        }
        return new LatLngBounds(new LatLng(qxVar.b().b(), qxVar.b().c()), new LatLng(qxVar.c().b(), qxVar.c().c()));
    }

    public static qu a(CircleOptions circleOptions) {
        if (circleOptions == null) {
            return null;
        }
        qu quVar = new qu();
        qw a = a(circleOptions.getCenter());
        if (a != null) {
            quVar.a(a);
        }
        quVar.a(a(circleOptions.getCenter())).b(circleOptions.getFillColor()).a(circleOptions.getRadius()).a(circleOptions.getStrokeColor()).a(circleOptions.getStrokeWidth()).a(circleOptions.isVisible()).b((float) ((int) circleOptions.getZIndex())).b(circleOptions.getStrokeDash());
        if (circleOptions.getStrokeDashPathEffect() == null) {
            return quVar;
        }
        quVar.a(circleOptions.getStrokeDashPathEffect());
        return quVar;
    }

    public static qz a(MarkerOptions markerOptions) {
        qz qzVar = null;
        if (markerOptions != null) {
            qw a = a(markerOptions.getPosition());
            if (a != null) {
                qzVar = new qz().a(a);
                qzVar.a(markerOptions.getAlpha()).b(markerOptions.isVisible()).a(markerOptions.isDraggable()).a(markerOptions.getAnchorU(), markerOptions.getAnchorV()).b(markerOptions.getRotation());
                if (markerOptions.getIcon() != null) {
                    qzVar.a(qr.a(markerOptions.getIcon().getBitmap()));
                }
                if (markerOptions.getMarkerView() != null) {
                    qzVar.a(markerOptions.getMarkerView());
                }
                if (markerOptions.getSnippet() != null) {
                    qzVar.b(markerOptions.getSnippet());
                }
                if (markerOptions.getTitle() != null) {
                    qzVar.a(markerOptions.getTitle());
                }
                if (markerOptions.getInfoWindowHideAnimation() != null) {
                    qzVar.d(markerOptions.getInfoWindowHideAnimation());
                }
                if (markerOptions.getInfoWindowShowAnimation() != null) {
                    qzVar.a(markerOptions.getInfoWindowShowAnimation());
                }
                if (markerOptions.getShowingAnination() != null) {
                    qzVar.b(markerOptions.getShowingAnination());
                }
                if (markerOptions.getHidingAnination() != null) {
                    qzVar.c(markerOptions.getHidingAnination());
                }
                if (markerOptions.getTag() != null) {
                    qzVar.a(markerOptions.getTag());
                }
            }
        }
        return qzVar;
    }

    public static rd a(PolylineOptions polylineOptions) {
        if (polylineOptions == null) {
            return null;
        }
        rd rdVar = new rd();
        Iterable b = b(polylineOptions.getPoints());
        if (b == null || b.size() == 0) {
            return null;
        }
        rdVar.a(b);
        rdVar.d((float) ((int) polylineOptions.getZIndex())).c(polylineOptions.getWidth()).a(polylineOptions.isVisible()).b(polylineOptions.getColor()).b(polylineOptions.getEdgeWidth()).a(polylineOptions.getEdgeColor()).b(polylineOptions.isGeodesic()).c(polylineOptions.isDottedLine());
        if (polylineOptions.getArrowTexture() != null) {
            rdVar.a(new qq(polylineOptions.getArrowTexture().getBitmap()));
            rdVar.a(polylineOptions.getArrowGap());
        }
        return rdVar;
    }

    public static rb a(PolygonOptions polygonOptions) {
        if (polygonOptions == null) {
            return null;
        }
        rb rbVar = new rb();
        Iterable b = b(polygonOptions.getPoints());
        if (b == null || b.size() <= 2) {
            return null;
        }
        rbVar.a(b);
        rbVar.a(polygonOptions.isVisible()).b((float) ((int) polygonOptions.getZIndex())).a(polygonOptions.getStrokeWidth()).a(polygonOptions.getStrokeColor()).b(polygonOptions.getFillColor());
        return rbVar;
    }

    static tr a(CameraUpdate cameraUpdate) {
        if (cameraUpdate == null || cameraUpdate.getParams() == null) {
            return null;
        }
        CameraParameter params = cameraUpdate.getParams();
        switch (cameraUpdate.getParams().cameraUpdate_type) {
            case 0:
                return ts.a();
            case 1:
                return ts.b();
            case 2:
                return ts.a(params.scrollBy_xPixel, params.scrollBy_yPixel);
            case 3:
                return ts.a(a(params.zoomTo_zoom));
            case 4:
                return ts.b(params.zoomBy_amount);
            case 5:
                return ts.a(params.zoomBy_Point_amount, params.zoomBy_Point_focus);
            case 6:
                return ts.a(a(params.newCameraPosition));
            case 7:
                return ts.a(a(params.newLatLng));
            case 8:
                return ts.a(a(params.newLatLngZoom_latlng), a(params.newLatLngZoom_zoom));
            case 9:
                return ts.a(a(params.newLatLngBounds_bounds), params.newLatLngBounds_padding);
            case 10:
                return ts.a(a(params.newLatLngBounds_dimension_bounds), params.newLatLngBounds_dimension_width, params.newLatLngBounds_dimension_height, params.newLatLngBounds_dimension_padding);
            default:
                return null;
        }
    }
}
