package com.tencent.mm.g.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public final class fb extends com.tencent.mm.sdk.b.b {
    public a bNg;
    public b bNh;

    public static final class a {
        public String[] bGj;
        public int bMB = 0;
        public Context context;
        public String[] selectionArgs;
        public Uri uri;
    }

    public static final class b {
        public Cursor bMC;
    }

    public fb() {
        this((byte) 0);
    }

    private fb(byte b) {
        this.bNg = new a();
        this.bNh = new b();
        this.sFm = false;
        this.bJX = null;
    }
}
