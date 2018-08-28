package android.support.v4.e;

public final class h<F, S> {
    public final F first;
    public final S second;

    private h(F f, S s) {
        this.first = f;
        this.second = s;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (d(hVar.first, this.first) && d(hVar.second, this.second)) {
            return true;
        }
        return false;
    }

    private static boolean d(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.first == null ? 0 : this.first.hashCode();
        if (this.second != null) {
            i = this.second.hashCode();
        }
        return hashCode ^ i;
    }

    public static <A, B> h<A, B> e(A a, B b) {
        return new h(a, b);
    }
}
