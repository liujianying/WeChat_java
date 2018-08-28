package com.tencent.matrix.resource.e;

import android.content.Context;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.LayoutInflater;
import android.widget.Toast;
import com.tencent.matrix.d.b;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public final class c {
    private final d bsu;
    final Context mContext;
    private final Handler mMainHandler;

    public interface a {
        void a(com.tencent.matrix.resource.analyzer.model.a aVar);
    }

    public c(Context context, d dVar) {
        this(context, dVar, new Handler(Looper.getMainLooper()));
    }

    private c(Context context, d dVar, Handler handler) {
        this.mContext = context;
        this.bsu = dVar;
        this.mMainHandler = handler;
    }

    public final File tC() {
        File file;
        File tD = this.bsu.tD();
        if (tD == null) {
            file = null;
        } else {
            UUID randomUUID = UUID.randomUUID();
            file = new File(tD, "dump_" + Long.toHexString(randomUUID.getMostSignificantBits()) + Long.toHexString(randomUUID.getLeastSignificantBits()) + ".hprof");
        }
        if (file == null) {
            b.w("Matrix.AndroidHeapDumper", "hprof file is null.", new Object[0]);
            return null;
        } else if (file.getParentFile().canWrite()) {
            final com.tencent.matrix.resource.d.a.a aVar = new com.tencent.matrix.resource.d.a.a();
            this.mMainHandler.post(new Runnable() {
                public final void run() {
                    final Toast toast = new Toast(c.this.mContext);
                    toast.setDuration(1);
                    toast.setGravity(16, 0, 0);
                    toast.setView(LayoutInflater.from(c.this.mContext).inflate(com.tencent.matrix.resource.b.a.resource_canary_toast_wait_for_heapdump, null));
                    toast.show();
                    Looper.myQueue().addIdleHandler(new IdleHandler() {
                        public final boolean queueIdle() {
                            com.tencent.matrix.resource.d.a.a aVar = aVar;
                            aVar.bsq.set(toast);
                            aVar.bsr.countDown();
                            return false;
                        }
                    });
                }
            });
            if (aVar.c(TimeUnit.SECONDS)) {
                try {
                    Debug.dumpHprofData(file.getAbsolutePath());
                    if (aVar.bsr.getCount() > 0) {
                        throw new IllegalStateException("Call wait() and check its result");
                    }
                    final Toast toast = (Toast) aVar.bsq.get();
                    this.mMainHandler.post(new Runnable() {
                        public final void run() {
                            toast.cancel();
                        }
                    });
                    return file;
                } catch (Throwable e) {
                    b.printErrStackTrace("Matrix.AndroidHeapDumper", e, "failed to dump heap into file: %s.", file.getAbsolutePath());
                    return null;
                }
            }
            b.w("Matrix.AndroidHeapDumper", "give up dumping heap, waiting for toast too long.", new Object[0]);
            return null;
        } else {
            b.w("Matrix.AndroidHeapDumper", "hprof file path: %s cannot be written.", file.getAbsolutePath());
            return null;
        }
    }
}
