package android.support.v4.e;

public final class i {

    public static class c<T> extends b<T> {
        private final Object mLock = new Object();

        public c() {
            super(16);
        }

        public final T bW() {
            T bW;
            synchronized (this.mLock) {
                bW = super.bW();
            }
            return bW;
        }

        public final boolean j(T t) {
            boolean j;
            synchronized (this.mLock) {
                j = super.j(t);
            }
            return j;
        }
    }
}
