package com.tencent.b.a.a;

import android.content.Context;
import android.provider.Settings.System;

public final class o extends q {
    public o(Context context) {
        super(context);
    }

    protected final boolean tL() {
        return s.o(this.context, "android.permission.WRITE_SETTINGS");
    }

    protected final String read() {
        String string;
        synchronized (this) {
            string = System.getString(this.context.getContentResolver(), s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="));
        }
        return string;
    }

    protected final void write(String str) {
        synchronized (this) {
            p.aG(this.context).u(s.decode("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
        }
    }

    protected final a tM() {
        a aVar;
        synchronized (this) {
            aVar = new a(System.getString(this.context.getContentResolver(), s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U=")));
            new StringBuilder("read readCheckEntity from Settings.System:").append(aVar.toString());
        }
        return aVar;
    }

    protected final void a(a aVar) {
        synchronized (this) {
            new StringBuilder("write CheckEntity to Settings.System:").append(aVar.toString());
            p.aG(this.context).u(s.decode("4kU71lN96TJUomD1vOU9lgj9U+kKmxDPLVM+zzjst5U="), aVar.toString());
        }
    }
}
