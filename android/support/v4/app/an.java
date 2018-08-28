package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;

public final class an implements Iterable<Intent> {
    private static final b qM;
    public final ArrayList<Intent> qN = new ArrayList();
    public final Context qO;

    public interface a {
        Intent getSupportParentActivityIntent();
    }

    interface b {
    }

    static class c implements b {
        c() {
        }
    }

    static class d implements b {
        d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            qM = new d();
        } else {
            qM = new c();
        }
    }

    private an(Context context) {
        this.qO = context;
    }

    public static an N(Context context) {
        return new an(context);
    }

    public final an a(ComponentName componentName) {
        int size = this.qN.size();
        try {
            Intent a = v.a(this.qO, componentName);
            while (a != null) {
                this.qN.add(size, a);
                a = v.a(this.qO, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public final Iterator<Intent> iterator() {
        return this.qN.iterator();
    }
}
