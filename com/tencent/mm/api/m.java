package com.tencent.mm.api;

import android.content.Context;
import android.graphics.Rect;

public abstract class m {
    public static b bwV;
    public a bwU;

    public static class a {
        public int bwW;
        public boolean bwX;
        public boolean bwY;
        public String path;
        public Rect rect;

        public a(String str, int i, boolean z, boolean z2, Rect rect) {
            this.bwW = i;
            this.path = str;
            this.bwX = z;
            this.bwY = z2;
            this.rect = rect;
        }
    }

    public abstract void a(j jVar);

    public abstract b aQ(Context context);

    public abstract void onDestroy();

    public abstract boolean tW();

    public abstract k tX();

    public void a(a aVar) {
        this.bwU = aVar;
    }
}
