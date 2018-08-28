package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
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

public class qo {
    public static int a = 1;

    public static void a(float f) {
        a = (int) (((double) (f / 2.0f)) + 0.5d);
    }

    public static ox a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new ox(latLng.getLatitude(), latLng.getLongitude());
    }

    public static LatLng a(ox oxVar) {
        if (oxVar == null) {
            return null;
        }
        return new LatLng(oxVar.a, oxVar.b);
    }

    public static List<LatLng> a(List<ox> list) {
        if (list == null) {
            return null;
        }
        ox[] oxVarArr = (ox[]) list.toArray(new ox[list.size()]);
        List<LatLng> arrayList = new ArrayList();
        for (ox a : oxVarArr) {
            arrayList.add(a(a));
        }
        return arrayList;
    }

    public static List<ox> b(List<LatLng> list) {
        if (list == null) {
            return null;
        }
        LatLng[] latLngArr = (LatLng[]) list.toArray(new LatLng[list.size()]);
        List<ox> arrayList = new ArrayList();
        for (LatLng a : latLngArr) {
            arrayList.add(a(a));
        }
        return arrayList;
    }

    public static or a(CameraPosition cameraPosition) {
        if (cameraPosition == null) {
            return null;
        }
        return new or(a(cameraPosition.getTarget()), b(cameraPosition.getZoom()), 0.0f, 0.0f);
    }

    public static CameraPosition a(or orVar) {
        if (orVar == null) {
            return null;
        }
        return new CameraPosition(a(orVar.a), c(orVar.b));
    }

    public static VisibleRegion a(pj pjVar) {
        if (pjVar == null) {
            return null;
        }
        return new VisibleRegion(a(pjVar.a), a(pjVar.b), a(pjVar.c), a(pjVar.d), a(pjVar.e));
    }

    public static float b(float f) {
        return f - ((float) a);
    }

    public static float c(float f) {
        return ((float) a) + f;
    }

    static oy a(LatLngBounds latLngBounds) {
        if (latLngBounds == null || latLngBounds.getNortheast() == null || latLngBounds.getSouthwest() == null) {
            return null;
        }
        return new oy(new ox(latLngBounds.getSouthwest().getLatitude(), latLngBounds.getSouthwest().getLongitude()), new ox(latLngBounds.getNortheast().getLatitude(), latLngBounds.getNortheast().getLongitude()));
    }

    static LatLngBounds a(oy oyVar) {
        if (oyVar == null || oyVar.b == null || oyVar.a == null) {
            return null;
        }
        return new LatLngBounds(new LatLng(oyVar.a.a, oyVar.a.b), new LatLng(oyVar.b.a, oyVar.b.b));
    }

    public static ot a(CircleOptions circleOptions) {
        if (circleOptions == null) {
            return null;
        }
        ot otVar = new ot();
        ox a = a(circleOptions.getCenter());
        if (a != null) {
            otVar.a(a);
        }
        otVar.a(a(circleOptions.getCenter())).b(circleOptions.getFillColor()).a(circleOptions.getRadius()).a(circleOptions.getStrokeColor()).a(circleOptions.getStrokeWidth() / qi.a()).a(circleOptions.isVisible()).c((int) circleOptions.getZIndex());
        return otVar;
    }

    public static pb a(MarkerOptions markerOptions) {
        pb pbVar = null;
        if (markerOptions != null) {
            ox a = a(markerOptions.getPosition());
            if (a != null) {
                pbVar = new pb(a);
                pbVar.b(markerOptions.getAlpha()).b(markerOptions.isVisible()).a(markerOptions.isDraggable()).a(markerOptions.getAnchorU(), markerOptions.getAnchorV()).a(markerOptions.getRotation()).c((float) markerOptions.getZIndex());
                if (markerOptions.getIcon() != null) {
                    pbVar.a(oo.a(markerOptions.getIcon().getBitmap()));
                }
                if (markerOptions.getMarkerView() != null) {
                    pbVar.a(oo.a(markerOptions.getMarkerView()));
                }
                if (markerOptions.getSnippet() != null) {
                    pbVar.b(markerOptions.getSnippet());
                }
                if (markerOptions.getTitle() != null) {
                    pbVar.a(markerOptions.getTitle());
                }
                if (markerOptions.getTag() != null) {
                    pbVar.a(markerOptions.getTag());
                }
            }
        }
        return pbVar;
    }

    public static pg a(PolylineOptions polylineOptions) {
        if (polylineOptions == null) {
            return null;
        }
        pg pgVar = new pg();
        Iterable b = b(polylineOptions.getPoints());
        if (b == null || b.size() == 0) {
            return null;
        }
        pgVar.a(b);
        pgVar.c((int) polylineOptions.getZIndex()).a(polylineOptions.getWidth()).a(polylineOptions.isVisible()).a(polylineOptions.getColor()).b(polylineOptions.getEdgeColor()).b(polylineOptions.getEdgeWidth());
        if (polylineOptions.getArrowTexture() != null) {
            pgVar.b(true);
            pgVar.d((int) polylineOptions.getArrowGap());
            Matrix matrix = new Matrix();
            matrix.postRotate(-90.0f);
            Bitmap bitmap = polylineOptions.getArrowTexture().getBitmap();
            bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), true);
            pgVar.a(oo.a(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true)));
        }
        if (polylineOptions.isDottedLine()) {
            List arrayList = new ArrayList();
            arrayList.add(Integer.valueOf((int) (3.0f * polylineOptions.getWidth())));
            arrayList.add(Integer.valueOf((int) polylineOptions.getWidth()));
            pgVar.b(arrayList);
        }
        return pgVar;
    }

    public static pe a(PolygonOptions polygonOptions) {
        if (polygonOptions == null) {
            return null;
        }
        pe peVar = new pe();
        Iterable b = b(polygonOptions.getPoints());
        if (b == null || b.size() <= 2) {
            return null;
        }
        peVar.b(b);
        peVar.a(polygonOptions.isVisible()).c((int) polygonOptions.getZIndex()).a(polygonOptions.getStrokeWidth() / qi.a()).a(polygonOptions.getStrokeColor()).b(polygonOptions.getFillColor());
        return peVar;
    }

    static x a(CameraUpdate cameraUpdate, aa aaVar) {
        if (cameraUpdate == null || cameraUpdate.getParams() == null) {
            return null;
        }
        CameraParameter params = cameraUpdate.getParams();
        switch (cameraUpdate.getParams().cameraUpdate_type) {
            case 0:
                return y.a();
            case 1:
                return y.b();
            case 2:
                return y.a(params.scrollBy_xPixel, params.scrollBy_yPixel);
            case 3:
                float f = params.zoomTo_zoom < aaVar.getMap().f() ? aaVar.getMap().f() : params.zoomTo_zoom > aaVar.getMap().e() ? aaVar.getMap().e() : params.zoomTo_zoom;
                return y.a(b(f));
            case 4:
                return y.b(params.zoomBy_amount);
            case 5:
                return y.a(params.zoomBy_Point_amount, params.zoomBy_Point_focus);
            case 6:
                return y.a(a(params.newCameraPosition));
            case 7:
                return y.a(a(params.newLatLng));
            case 8:
                return y.a(a(params.newLatLngZoom_latlng), b(params.newLatLngZoom_zoom));
            case 9:
                return y.a(a(params.newLatLngBounds_bounds), params.newLatLngBounds_padding, params.newLatLngBounds_padding, params.newLatLngBounds_padding, params.newLatLngBounds_padding);
            case 10:
                int i;
                int i2;
                int i3;
                int i4;
                if (aaVar == null || aaVar.getWidth() == 0 || aaVar.getWidth() == 0) {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                } else {
                    if (params.newLatLngBounds_dimension_width < aaVar.getWidth()) {
                        i = (aaVar.getWidth() / 2) - ((params.newLatLngBounds_dimension_width / 2) - params.newLatLngBounds_dimension_padding);
                        i2 = i;
                        i4 = i;
                    } else {
                        i2 = 0;
                        i4 = 0;
                    }
                    if (params.newLatLngBounds_dimension_height < aaVar.getHeight()) {
                        int height = (aaVar.getHeight() / 2) - ((params.newLatLngBounds_dimension_height / 2) - params.newLatLngBounds_dimension_padding);
                        i = height;
                        i3 = height;
                    } else {
                        i = 0;
                        i3 = 0;
                    }
                }
                return y.a(a(params.newLatLngBounds_dimension_bounds), i2, i4, i3, i);
            default:
                return null;
        }
    }
}
