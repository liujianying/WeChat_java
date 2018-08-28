package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.signin.e;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class h {
    public final Account aIy;
    public final Set<Scope> aJT;
    private final int aJU;
    private final View aJV;
    public final String aJW;
    final String aJX;
    final Set<Scope> aNO;
    public final Map<a<?>, a> aNP;
    public final e aNQ;
    public Integer aNR;

    public h(Account account, Set<Scope> set, Map<a<?>, a> map, int i, View view, String str, String str2, e eVar) {
        Map map2;
        this.aIy = account;
        this.aJT = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map2 == null) {
            map2 = Collections.EMPTY_MAP;
        }
        this.aNP = map2;
        this.aJV = view;
        this.aJU = i;
        this.aJW = str;
        this.aJX = str2;
        this.aNQ = eVar;
        Set hashSet = new HashSet(this.aJT);
        for (a aVar : this.aNP.values()) {
            hashSet.addAll(aVar.aKn);
        }
        this.aNO = Collections.unmodifiableSet(hashSet);
    }
}
