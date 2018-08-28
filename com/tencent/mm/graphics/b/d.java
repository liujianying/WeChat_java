package com.tencent.mm.graphics.b;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Timer;

public enum d {
    ;
    
    public boolean bgH;
    public Timer bno;
    public WeakReference<Context> djp;
    public HashMap<Integer, a> djq;
    public final Object djr;

    private d(String str) {
        this.djp = null;
        this.djq = new HashMap();
        this.bgH = false;
        this.bno = null;
        this.djr = new Object();
    }

    public final void Cl() {
        synchronized (this.djr) {
            if (this.bgH) {
                if (this.bno != null) {
                    this.bno.cancel();
                }
                this.bgH = false;
                return;
            }
        }
    }
}
