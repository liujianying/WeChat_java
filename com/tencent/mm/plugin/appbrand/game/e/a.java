package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.magicbrush.handler.image.MBCanvasContentHolder;
import com.tencent.mm.plugin.appbrand.game.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public enum a {
    ;

    private a(String str) {
    }

    public final MBCanvasContentHolder kt(int i) {
        return b(new a(i, (byte) 0));
    }

    public final MBCanvasContentHolder ahj() {
        return b(new b((byte) 0));
    }

    public static MBCanvasContentHolder ku(int i) {
        MBCanvasContentHolder mBCanvasContentHolder = null;
        if (ahk()) {
            try {
                return new a(i, (byte) 0).ahl();
            } catch (Exception e) {
                x.e("MicroMsg.WAGameCanvasSnapshotHandler", "getScreenCanvas Direct [%s]", new Object[]{e});
                return mBCanvasContentHolder;
            }
        }
        x.e("MicroMsg.WAGameCanvasSnapshotHandler", "CurrentThread is not glThread, please post to GLThread. [%s]", new Object[]{Thread.currentThread()});
        return mBCanvasContentHolder;
    }

    private MBCanvasContentHolder b(Callable<MBCanvasContentHolder> callable) {
        i iVar = null;
        int i = 0;
        if (ahk()) {
            x.e("MicroMsg.WAGameCanvasSnapshotHandler", "Current thread is [%s], dismiss this task", new Object[]{Thread.currentThread()});
        } else {
            i = 1;
        }
        if (i == 0) {
            return null;
        }
        final FutureTask futureTask = new FutureTask(callable);
        AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.appbrand.game.i.a() {
            public final void agf() {
                futureTask.run();
            }
        };
        i iVar2 = i.fAb;
        if (!iVar2.fAc.contains(anonymousClass1)) {
            iVar2.fAc.add(anonymousClass1);
        }
        try {
            MBCanvasContentHolder mBCanvasContentHolder = (MBCanvasContentHolder) futureTask.get(2500, TimeUnit.MILLISECONDS);
            if (mBCanvasContentHolder != null) {
                return mBCanvasContentHolder;
            }
            futureTask.cancel(true);
            x.w("MicroMsg.WAGameCanvasSnapshotHandler", "postGetCanvasShotSyncOnRenderThread bitmap is null");
            i.fAb.a(anonymousClass1);
            return null;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WAGameCanvasSnapshotHandler", e, "hy: AppBrandGame getScreenShotsBitmap InterruptedException", new Object[0]);
            futureTask.cancel(true);
            return iVar;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WAGameCanvasSnapshotHandler", e2, "hy: AppBrandGame getScreenShotsBitmap ExecutionException", new Object[0]);
            futureTask.cancel(true);
            return iVar;
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.WAGameCanvasSnapshotHandler", e22, "hy: AppBrandGame getScreenShotsBitmap TimeoutException", new Object[0]);
            futureTask.cancel(true);
            return iVar;
        } finally {
            iVar = i.fAb;
            iVar.a(anonymousClass1);
            return iVar;
        }
    }

    private static boolean ahk() {
        String name = Thread.currentThread().getName();
        return name != null && name.startsWith("GLThread");
    }
}
