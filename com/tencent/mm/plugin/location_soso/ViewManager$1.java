package com.tencent.mm.plugin.location_soso;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;

class ViewManager$1 implements OnInfoWindowClickListener {
    final /* synthetic */ ViewManager this$0;
    final /* synthetic */ OnClickListener val$listener;
    final /* synthetic */ Marker val$marker;
    final /* synthetic */ View val$view;

    ViewManager$1(ViewManager viewManager, Marker marker, OnClickListener onClickListener, View view) {
        this.this$0 = viewManager;
        this.val$marker = marker;
        this.val$listener = onClickListener;
        this.val$view = view;
    }

    public void onInfoWindowClick(Marker marker) {
        if (marker == this.val$marker) {
            this.val$listener.onClick(this.val$view);
        }
    }
}
