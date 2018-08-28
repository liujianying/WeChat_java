package com.tencent.tencentmap.mapsdk.dynamic;

import android.content.Context;
import com.tencent.tencentmap.mapsdk.a.pw;
import com.tencent.tencentmap.mapsdk.a.qi;
import com.tencent.tencentmap.mapsdk.map.IMapView;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;

public class c {
    private int a = 1;
    private TencentMapOptions b;

    public void a(int i) {
        this.a = i;
    }

    public IMapView a(Context context, TencentMapOptions tencentMapOptions) {
        this.b = tencentMapOptions;
        this.a = new a(context).a(this.a);
        if (this.a == 0) {
            return new pw(context, this.b);
        }
        return new qi(context, this.b);
    }
}
