package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.map.lib.a;
import com.tencent.map.lib.b;
import com.tencent.map.lib.util.SystemUtil;
import java.io.Closeable;

public class kq extends ii {
    public a a;
    ih b;
    jg c;
    b d;
    private int e;
    private String f;
    private nd g;
    private float h;
    private ad i;

    public kq(Context context, ad adVar) {
        Surface surface;
        if (adVar == null) {
            surface = null;
        } else {
            surface = adVar.d();
        }
        super(context, surface);
        this.e = 0;
        this.f = "UNKNOWN";
        this.g = new nd();
        this.h = 1.0f;
        this.a = new b(this);
        this.b = new d(getContext());
        this.c = new a(this);
        this.d = new c(this);
        this.f = context.getClass().getSimpleName();
        this.i = adVar;
    }

    public void h() {
        Context applicationContext = getContext().getApplicationContext();
        this.h = SystemUtil.getDensity(applicationContext) / 2.0f;
        pn.a().a(applicationContext);
        o a = o.a(applicationContext);
        q.a(a.e());
        q.a(a.f());
        q.a(a.h());
        q.a(a.i());
        q.a(a.g());
        if (this.i != null) {
            if (this.i.a() != null) {
                p.a(this.i.a());
            } else if (this.i.b() != null) {
                p.b(this.i.b());
            }
        }
        kt.a(applicationContext);
        a(this.a, kn.a());
        getMap().b("http://" + jy.a());
        getMap().c(getRouteBlockUrl());
        ku.a(applicationContext, getMap()).a();
    }

    private Bitmap a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Closeable b = q.b(o.a(context).h() + str);
        if (b == null) {
            b = q.b(o.a(context).i() + str);
        }
        if (b == null) {
            if (p.a() != null) {
                b = p.b(context, p.a() + str);
            } else if (p.b() != null) {
                b = q.b(p.b() + str);
            }
        }
        if (b == null) {
            b = p.a(context, str);
        }
        if (b == null) {
            b = p.b(context, str);
        }
        if (b == null) {
            return null;
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(b);
        q.a(b);
        return decodeStream;
    }

    private String getRouteBlockUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://closedroadvector.map.qq.com/closed_road_v2?");
        stringBuilder.append("iszip=true");
        stringBuilder.append("&imei=" + kh.a());
        stringBuilder.append("&pf=android");
        stringBuilder.append("&sdkversion=4.0.8");
        stringBuilder.append("&p=sdk");
        stringBuilder.append("&nettype=" + kh.b());
        return stringBuilder.toString();
    }
}
