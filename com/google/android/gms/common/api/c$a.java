package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.google.android.gms.c.m;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.h.a;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.signin.d;
import com.google.android.gms.signin.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class c$a {
    private Account aIy;
    public final Set<Scope> aJT = new HashSet();
    private int aJU;
    private View aJV;
    private String aJW;
    private String aJX;
    private final Map<a<?>, a> aJY = new m();
    public final Map<a<?>, Object> aJZ = new m();
    public FragmentActivity aKa;
    public int aKb = -1;
    public int aKc = -1;
    public c$c aKd;
    public Looper aKe;
    public b aKf = b.oq();
    public a.a<? extends d, e> aKg = com.google.android.gms.signin.b.baU;
    public final ArrayList<c.b> aKh = new ArrayList();
    public final ArrayList<c$c> aKi = new ArrayList();
    private e.a aKj = new e.a();
    public final Context mContext;

    public c$a(Context context) {
        this.mContext = context;
        this.aKe = context.getMainLooper();
        this.aJW = context.getPackageName();
        this.aJX = context.getClass().getName();
    }

    public final void a(u uVar, c cVar) {
        int i = this.aKb;
        c$c c_c = this.aKd;
        w.j(cVar, "GoogleApiClient instance cannot be null");
        w.d(uVar.aLR.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        uVar.aLR.put(i, new u.a(uVar, i, cVar, c_c));
        if (uVar.mg && !uVar.aLN) {
            cVar.connect();
        }
    }

    public final h oB() {
        return new h(this.aIy, this.aJT, this.aJY, this.aJU, this.aJV, this.aJW, this.aJX, this.aKj.qU());
    }
}
