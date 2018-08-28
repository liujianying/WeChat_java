package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.ab.f;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd.a;

@Deprecated
public interface l {
    String B(String str, String str2);

    Bitmap a(Activity activity, int i, int i2, Intent intent);

    com.tencent.mm.ab.l a(f fVar);

    void a(Context context, ab abVar, a aVar, Bundle bundle, String str);

    void a(Context context, a aVar, Bundle bundle);

    void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, String str5);

    void a(Intent intent, String str);

    void a(aue aue, String str);

    void a(String str, String str2, String str3, long j);

    boolean a(Context context, int i, int i2, String str);

    boolean a(ab abVar);

    com.tencent.mm.ab.l aG(boolean z);

    boolean b(Context context, int i, int i2, String str);

    void bb(Context context);

    String cS(String str);

    boolean cT(String str);

    boolean cU(String str);

    void cV(String str);

    void eu(int i);

    boolean f(Activity activity);

    void g(Activity activity);

    String h(Context context, String str, String str2);

    String q(Context context, String str);

    boolean r(Context context, String str);

    String s(String str, int i);

    void vl();

    void vn();

    void vo();

    Intent vp();

    boolean vq();

    void vr();

    boolean vs();
}
