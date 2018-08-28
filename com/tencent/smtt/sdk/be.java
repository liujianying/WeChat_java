package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.e.a.a.a;
import com.tencent.e.a.a.b;

class be {
    private static be e = null;
    bh a = null;
    Context b;
    b c;
    a d;

    private be(Context context) {
        this.b = context.getApplicationContext();
        this.a = new bh(this.b);
    }

    public static synchronized be a(Context context) {
        be beVar;
        synchronized (be.class) {
            if (e == null) {
                e = new be(context);
            }
            beVar = e;
        }
        return beVar;
    }

    public void a(int i, int i2, Intent intent) {
    }

    void a(Activity activity, int i) {
        this.a.a(activity, i);
    }

    public boolean a() {
        this.a.a();
        return this.a.b();
    }

    public boolean a(String str, Bundle bundle, b bVar) {
        Object this;
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (!TextUtils.isEmpty(str)) {
            bundle.putString("videoUrl", str);
        }
        if (bVar != null) {
            this.a.a();
            if (!this.a.b()) {
                return false;
            }
            this.c = bVar;
            this.d = new bf(this);
            bundle.putInt("callMode", 3);
        } else {
            bundle.putInt("callMode", 1);
        }
        bh bhVar = this.a;
        if (bVar == null) {
            this = null;
        }
        bhVar.a(bundle, this);
        return true;
    }
}
