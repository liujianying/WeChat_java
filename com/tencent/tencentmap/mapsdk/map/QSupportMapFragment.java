package com.tencent.tencentmap.mapsdk.map;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.tencentmap.mapsdk.a.i;

public class QSupportMapFragment extends Fragment {
    private MapView mapView;

    public static QSupportMapFragment newInstance() {
        return new QSupportMapFragment();
    }

    public MapView getMapView() {
        return this.mapView;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle == null) {
            bundle = getArguments();
        }
        if (this.mapView == null) {
            this.mapView = new MapView(layoutInflater.getContext());
            this.mapView.onCreate(bundle);
        }
        i.a("js", "QSupportMapFragment onCreateView ");
        return this.mapView;
    }

    public void onResume() {
        super.onResume();
        this.mapView.onResume();
    }

    public void onPause() {
        super.onPause();
        this.mapView.onPause();
    }

    public void onDestroyView() {
        this.mapView.onDestroyView();
        super.onDestroyView();
    }

    public void onDestroy() {
        this.mapView.onDestroy();
        super.onDestroy();
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.mapView.onSaveInstanceState(bundle);
        super.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
