package com.d.a.a;

import android.os.Handler;
import android.util.SparseArray;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class z {
    private static z bmX;
    private static final SparseArray<z> bmY = new SparseArray();
    private final ExecutorService bmZ;
    private final Handler handler;

    private z(Handler handler) {
        if (handler != null) {
            this.bmZ = null;
        } else {
            this.bmZ = Executors.newSingleThreadExecutor();
        }
        this.handler = handler;
    }

    static z a(Handler handler) {
        if (handler != null) {
            int hashCode = handler.getLooper().hashCode();
            z zVar = (z) bmY.get(hashCode);
            if (zVar != null) {
                return zVar;
            }
            zVar = new z(handler);
            bmY.put(hashCode, zVar);
            return zVar;
        }
        if (bmX == null) {
            bmX = new z(null);
        }
        return bmX;
    }

    final void execute(Runnable runnable) {
        if (this.handler != null) {
            this.handler.post(runnable);
        } else {
            this.bmZ.execute(runnable);
        }
    }
}
