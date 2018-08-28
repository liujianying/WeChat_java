package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.w;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

class h$a {
    int aFt;
    ByteArrayOutputStream aFu = new ByteArrayOutputStream();
    final /* synthetic */ h aFv;

    public h$a(h hVar) {
        this.aFv = hVar;
    }

    public final boolean b(c cVar) {
        w.ah(cVar);
        if (this.aFt + 1 > ac.nZ()) {
            return false;
        }
        String a = this.aFv.a(cVar, false);
        if (a == null) {
            this.aFv.aFn.nr().a(cVar, "Error formatting hit");
            return true;
        }
        byte[] bytes = a.getBytes();
        int length = bytes.length;
        if (length > ac.nV()) {
            this.aFv.aFn.nr().a(cVar, "Hit size exceeds the maximum size limit");
            return true;
        }
        if (this.aFu.size() > 0) {
            length++;
        }
        if (this.aFu.size() + length > ((Integer) aj.aHR.get()).intValue()) {
            return false;
        }
        try {
            if (this.aFu.size() > 0) {
                this.aFu.write(h.mQ());
            }
            this.aFu.write(bytes);
            this.aFt++;
            return true;
        } catch (IOException e) {
            this.aFv.g("Failed to write payload when batching hits", e);
            return true;
        }
    }
}
