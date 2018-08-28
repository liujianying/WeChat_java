package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.compat.a.b;
import com.tencent.mm.plugin.appbrand.compat.a.b.h;
import com.tencent.mm.plugin.appbrand.compat.a.b.i;
import com.tencent.mm.plugin.appbrand.compat.a.b.o;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.widget.e.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class c {
    public String appId;
    public Context context;
    public b fSW;
    public boolean fSX;
    public d fSY;
    public j fSZ;
    public Map<String, e> fTa = new HashMap();
    private g fTb = new g(this);
    public i fTc;
    public l fTd;
    public ArrayList<b.b> fTe = new ArrayList();
    public ArrayList<a> fTf = new ArrayList();
    public ArrayList<o> fTg = new ArrayList();
    public ArrayList<c> fTh = new ArrayList();
    boolean isBackground;
    public int mapId;

    public interface k {
        void tE(String str);
    }

    public interface l {
        boolean b(e eVar);
    }

    public interface m {
        void cR(boolean z);
    }

    public c(Context context, String str, int i, b bVar) {
        this.context = context;
        this.appId = str;
        this.mapId = i;
        this.fSW = bVar;
        x.i("MicroMSg.AppBrandMapView", "mapId:%d, init", new Object[]{Integer.valueOf(this.mapId)});
        this.fSW.a(this.fTb);
        this.fSW.adB();
        this.fSW.adC();
        this.fSW.adD();
        this.fSW.a(new 1(this));
        this.fSW.a(new 6(this));
        this.fSW.a(new 7(this));
    }

    public final View getView() {
        return this.fSW.getView();
    }

    public final void cS(boolean z) {
        x.i("MicroMSg.AppBrandMapView", "mapId:%d show location", new Object[]{Integer.valueOf(this.mapId)});
        this.fSX = z;
        if (z) {
            b.a(this);
        } else {
            b.b(this);
        }
    }

    public final void onPause() {
        x.i("MicroMSg.AppBrandMapView", "mapId:%d onPause", new Object[]{Integer.valueOf(this.mapId)});
        this.fSW.onPause();
    }

    public final void onDestroy() {
        x.i("MicroMSg.AppBrandMapView", "mapId:%d onDestroy", new Object[]{Integer.valueOf(this.mapId)});
        ajj();
        ajl();
        ajl();
        ajk();
        ajm();
        ah.A(new 9(this));
        if (this.fSY != null) {
            d dVar = this.fSY;
            if (dVar.fTv != null) {
                dVar.fTv.remove();
                dVar.fTv = null;
            }
        }
    }

    public final com.tencent.mm.plugin.appbrand.widget.e.c a(c$f$a c_f_a) {
        com.tencent.mm.plugin.appbrand.widget.e.c ajh = a.ajh();
        if (ajh == null) {
            ajh = new com.tencent.mm.plugin.appbrand.widget.e.c(this.context);
        }
        ajh.setText("");
        ajh.setTextSize(12);
        ajh.setTextColor(com.tencent.mm.plugin.appbrand.widget.e.c.gMp);
        ajh.setTitlePadding(0);
        ajh.setGravity("center");
        ajh.ca(0, com.tencent.mm.plugin.appbrand.widget.e.c.gMq);
        ajh.setText(c_f_a.content);
        ajh.setTextSize(c_f_a.fTC);
        ajh.setTextColor(c_f_a.color);
        ajh.setTitlePadding(c_f_a.padding);
        ajh.setGravity(c_f_a.fTI);
        ajh.ca(c_f_a.fTD, c_f_a.bgColor);
        return ajh;
    }

    public final void a(String str, e eVar) {
        x.i("MicroMSg.AppBrandMapView", "mapId:%d addMarker markerId:%s", new Object[]{Integer.valueOf(this.mapId), str});
        synchronized (this.fTa) {
            this.fTa.put(str, eVar);
        }
    }

    public final void ajj() {
        x.i("MicroMSg.AppBrandMapView", "mapId:%d removeAllMarker", new Object[]{Integer.valueOf(this.mapId)});
        synchronized (this.fTa) {
            for (e eVar : this.fTa.values()) {
                eVar.fTv.remove();
                if (eVar.fTw != null) {
                    if (eVar.fTw.getMarkerView() != null && (eVar.fTw.getMarkerView() instanceof e)) {
                        a.a((e) eVar.fTw.getMarkerView());
                    }
                    eVar.fTw.remove();
                }
            }
            this.fTa.clear();
        }
    }

    public final e tF(String str) {
        e eVar;
        synchronized (this.fTa) {
            eVar = (e) this.fTa.get(str);
        }
        return eVar;
    }

    public static void a(LinkedList<h> linkedList, e eVar) {
        h hVar = (h) linkedList.get(0);
        hVar.fTN = eVar.fTv.adI().adG();
        hVar.fTM = eVar.fTv.adI().adH();
        int size = linkedList.size();
        for (int i = 1; i < size; i++) {
            hVar = (h) linkedList.get(i - 1);
            h hVar2 = (h) linkedList.get(i);
            if (hVar.rotate == 0.0f) {
                hVar2.fTM = hVar.longitude;
                hVar2.fTN = hVar.latitude;
            } else {
                hVar2.fTM = eVar.fTv.adI().adH();
                hVar2.fTN = eVar.fTv.adI().adG();
            }
        }
    }

    public final boolean a(b bVar, k kVar) {
        Bitmap bitmap = null;
        if (bi.oW(bVar.fTs)) {
            return false;
        }
        View imageView = new ImageView(this.context);
        imageView.setScaleType(ScaleType.FIT_XY);
        if (bVar.fTs.startsWith("wxfile://")) {
            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(this.appId, bVar.fTs);
            if (itemByLocalId != null) {
                bitmap = com.tencent.mm.sdk.platformtools.c.decodeFile(itemByLocalId.dDG, null);
                imageView.setImageBitmap(bitmap);
            }
        } else {
            bitmap = com.tencent.mm.plugin.appbrand.page.o.j(a.pY(this.appId), bVar.fTs);
            if (!(bitmap == null || bitmap.isRecycled())) {
                imageView.setImageBitmap(bitmap);
            }
        }
        int i = bVar.left;
        int i2 = bVar.top;
        LayoutParams layoutParams = new FrameLayout.LayoutParams(bVar.width == 0 ? f.lP(bitmap.getWidth()) : bVar.width, bVar.height == 0 ? f.lP(bitmap.getHeight()) : bVar.height);
        layoutParams.setMargins(i, i2, 0, 0);
        boolean z = bVar.fTt;
        String str = bVar.data;
        imageView.setOnTouchListener(new 4(this, z, imageView));
        imageView.setOnClickListener(new 5(this, z, kVar, str));
        ((ViewGroup) getView()).addView(imageView, layoutParams);
        synchronized (this.fTf) {
            this.fTf.add(new a(this, imageView));
        }
        return true;
    }

    public final void ajk() {
        ViewGroup viewGroup = (ViewGroup) getView();
        synchronized (this.fTf) {
            Iterator it = this.fTf.iterator();
            while (it.hasNext()) {
                viewGroup.removeView(((a) it.next()).fTr);
            }
            this.fTf.clear();
        }
    }

    public final b.f C(float f, float f2) {
        return this.fSW.g((double) f, (double) f2);
    }

    public final void ajl() {
        synchronized (this.fTg) {
            Iterator it = this.fTg.iterator();
            while (it.hasNext()) {
                ((o) it.next()).remove();
            }
            this.fTg.clear();
        }
    }

    public final boolean a(d dVar) {
        if (bi.oW(dVar.fTs)) {
            return false;
        }
        i ady = this.fSW.ady();
        ady.h(dVar.latitude, dVar.longitude);
        Bitmap j = com.tencent.mm.plugin.appbrand.page.o.j(a.pY(this.appId), dVar.fTs);
        if (!(j == null || j.isRecycled())) {
            ady.t(j);
        }
        ady.Y(dVar.rotate);
        h a = this.fSW.a(ady);
        synchronized (this.fTh) {
            this.fTh.add(new c(this, a));
        }
        return true;
    }

    public final void ajm() {
        synchronized (this.fTh) {
            Iterator it = this.fTh.iterator();
            while (it.hasNext()) {
                ((c) it.next()).fTu.remove();
            }
            this.fTh.clear();
        }
    }
}
