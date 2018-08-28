package com.tencent.mm.bi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Editable;
import android.view.MotionEvent;
import com.tencent.mm.api.e;
import com.tencent.mm.api.i;
import com.tencent.mm.api.j;
import com.tencent.mm.api.l;
import com.tencent.mm.api.m;
import com.tencent.mm.cache.d;
import com.tencent.mm.d.a;

public interface b {
    boolean I(MotionEvent motionEvent);

    d a(a aVar);

    void a(Editable editable, int i, int i2);

    void a(j jVar, boolean z);

    void a(m.a aVar);

    void a(com.tencent.mm.view.a aVar);

    <T extends com.tencent.mm.d.b> T b(com.tencent.mm.api.d dVar);

    void c(i iVar);

    void cfP();

    com.tencent.mm.view.a cfQ();

    <T extends com.tencent.mm.d.b> T cfR();

    Bitmap cfS();

    boolean cfT();

    m.a getConfig();

    Context getContext();

    float getCurScale();

    com.tencent.mm.api.d[] getFeatures();

    float getInitScale();

    l getSelectedFeatureListener();

    void onAttachedToWindow();

    void onDestroy();

    void onDraw(Canvas canvas);

    void onFinish();

    void setActionBarCallback(e eVar);

    void setAutoShowFooterAndBar(boolean z);

    boolean tW();

    void ua();
}
