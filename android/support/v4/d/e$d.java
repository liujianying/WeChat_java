package android.support.v4.d;

import android.support.v4.d.e.c;

abstract class e$d implements d {
    private final c to;

    protected abstract boolean bN();

    public e$d(c cVar) {
        this.to = cVar;
    }

    public final boolean a(CharSequence charSequence, int i) {
        if (charSequence == null || i < 0 || charSequence.length() - i < 0) {
            throw new IllegalArgumentException();
        } else if (this.to == null) {
            return bN();
        } else {
            switch (this.to.b(charSequence, i)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return bN();
            }
        }
    }
}
