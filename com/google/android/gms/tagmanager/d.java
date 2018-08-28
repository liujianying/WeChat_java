package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class d {
    private static d bbC;
    final ConcurrentMap<am, Boolean> bbA;
    private final an bbB;
    private final a bbx;
    private final c bby;
    final ad bbz;
    private final Context mContext;

    private d(Context context, a aVar, c cVar, ad adVar) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.bbz = adVar;
        this.bbx = aVar;
        this.bbA = new ConcurrentHashMap();
        this.bby = cVar;
        this.bby.a(new 1(this));
        this.bby.a(new ag(this.mContext));
        this.bbB = new an();
        if (VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new 3(this));
        }
    }

    static /* synthetic */ void a(d dVar, String str) {
        for (am bz : dVar.bbA.keySet()) {
            bz.bz(str);
        }
    }

    public static d av(Context context) {
        d dVar;
        synchronized (d.class) {
            if (bbC == null) {
                if (context == null) {
                    m.rb();
                    throw new NullPointerException();
                }
                bbC = new d(context, new 2(), new c(new ap(context)), ae.rA());
            }
            dVar = bbC;
        }
        return dVar;
    }

    final synchronized boolean f(Uri uri) {
        boolean z;
        w rw = w.rw();
        if (rw.f(uri)) {
            String str = rw.bbj;
            switch (4.bbE[rw.bbN - 1]) {
                case 1:
                    for (am amVar : this.bbA.keySet()) {
                        if (amVar.rE().equals(str)) {
                            amVar.rF();
                            amVar.refresh();
                        }
                    }
                    break;
                case 2:
                case 3:
                    for (am amVar2 : this.bbA.keySet()) {
                        String str2;
                        if (amVar2.rE().equals(str)) {
                            str2 = rw.bbO;
                            amVar2.rF();
                            amVar2.refresh();
                        } else {
                            if (amVar2.bcT) {
                                m.rb();
                                str2 = "";
                            } else {
                                str2 = amVar2.bcS.rG();
                            }
                            if (str2 != null) {
                                amVar2.rF();
                                amVar2.refresh();
                            }
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
