package com.tencent.tencentmap.mapsdk.a;

import android.graphics.PointF;
import com.tencent.map.lib.thread.AsyncTask;
import com.tencent.tencentmap.mapsdk.a.ht.1;

class ht$1$1 extends AsyncTask<Void, Void, Void> {
    final /* synthetic */ PointF a;
    final /* synthetic */ 1 b;

    ht$1$1(1 1, PointF pointF) {
        this.b = 1;
        this.a = pointF;
    }

    /* renamed from: a */
    protected Void doInBackground(Void... voidArr) {
        this.b.a.a(this.a.x, this.a.y, false);
        return null;
    }
}
