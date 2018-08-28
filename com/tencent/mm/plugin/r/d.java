package com.tencent.mm.plugin.r;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnTouchListener;
import java.util.Collection;
import java.util.Set;

public interface d {
    void addPinView(View view, double d, double d2);

    void addView(Object obj, double d, double d2, String str);

    void clean();

    void destroy();

    Collection<Object> getChilds();

    b getIController();

    int getMapCenterX();

    int getMapCenterY();

    Point getPointByGeoPoint(double d, double d2);

    Set<String> getTags();

    Object getViewByItag(String str);

    e getViewManager();

    int getZoom();

    int getZoomLevel();

    void invalidate();

    void removeView(View view);

    Object removeViewByTag(String str);

    void setBuiltInZoomControls(boolean z);

    void setMapViewOnTouchListener(OnTouchListener onTouchListener);

    void updateLocaitonPinLayout(View view, double d, double d2);

    void zoomToSpan(double d, double d2, double d3, double d4);
}
