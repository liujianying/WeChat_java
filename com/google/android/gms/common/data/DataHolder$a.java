package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.HashMap;

public class DataHolder$a {
    final String[] aMh;
    final ArrayList<HashMap<String, Object>> aMq;
    private final String aMr;
    private final HashMap<Object, Integer> aMs;
    private boolean aMt;
    private String aMu;

    private DataHolder$a(String[] strArr) {
        this.aMh = (String[]) w.ah(strArr);
        this.aMq = new ArrayList();
        this.aMr = null;
        this.aMs = new HashMap();
        this.aMt = false;
        this.aMu = null;
    }

    /* synthetic */ DataHolder$a(String[] strArr, byte b) {
        this(strArr);
    }
}
