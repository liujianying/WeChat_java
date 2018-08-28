package com.tencent.tencentmap.mapsdk.a;

public final class or {
    public ox a;
    public final float b;
    public final float c;
    public final float d;

    public static final class a {
        private ox a;
        private float b;
        private float c = Float.MIN_VALUE;
        private float d = Float.MIN_VALUE;

        public final a a(ox oxVar) {
            this.a = oxVar;
            return this;
        }

        public final a a(float f) {
            this.b = f;
            return this;
        }

        public final a b(float f) {
            this.c = f;
            return this;
        }

        public final a c(float f) {
            this.d = f;
            return this;
        }

        public final or a() {
            return new or(this.a, this.b, this.c, this.d);
        }
    }

    or(int i, ox oxVar, float f, float f2, float f3) {
        this.a = oxVar;
        this.b = f;
        this.c = f2;
        this.d = f3;
    }

    public or(ox oxVar, float f, float f2, float f3) {
        this(1, oxVar, f, f2, f3);
    }

    public static a a() {
        return new a();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof or)) {
            return false;
        }
        or orVar = (or) obj;
        if (this.a.equals(orVar.a) && Float.floatToIntBits(this.b) == Float.floatToIntBits(orVar.b) && Float.floatToIntBits(this.c) == Float.floatToIntBits(orVar.c) && Float.floatToIntBits(this.d) == Float.floatToIntBits(orVar.d)) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "latlng:" + this.a.a + "," + this.a.b + ",zoom:" + this.b + ",tilt=" + this.c + ",bearing:" + this.d;
    }
}
