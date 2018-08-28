package com.tencent.mm.plugin.brandservice.a;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mm.ac.d;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.q;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;

public interface a extends com.tencent.mm.kernel.c.a {
    void a(int i, Context context, String str, String str2, long j, long j2);

    void a(long j, int i, Context context, Activity activity, bd bdVar);

    void a(View view, long j, String str, String str2, int i);

    void a(bd bdVar, Activity activity);

    void a(bd bdVar, Context context);

    void a(m mVar, q qVar, int i, l lVar, View view, boolean z);

    void b(d dVar, Activity activity, ab abVar);
}
