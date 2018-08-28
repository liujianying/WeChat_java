package com.tencent.mm.plugin.mmsight;

import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.ConcurrentSkipListSet;

public final class c {
    private static ConcurrentSkipListSet<Integer> ldT = new ConcurrentSkipListSet();

    public static synchronized void sI(int i) {
        synchronized (c.class) {
            try {
                x.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing: %s", new Object[]{Integer.valueOf(i)});
                ldT.add(Integer.valueOf(i));
            } catch (Exception e) {
                x.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxing error: %s", new Object[]{e.getMessage()});
            }
        }
        return;
    }

    public static synchronized void sJ(int i) {
        synchronized (c.class) {
            try {
                x.i("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish: %s", new Object[]{Integer.valueOf(i)});
                ldT.remove(Integer.valueOf(i));
            } catch (Exception e) {
                x.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "markMsgRemuxingFinish error: %s", new Object[]{e.getMessage()});
            }
        }
        return;
    }

    public static synchronized boolean sK(int i) {
        boolean contains;
        synchronized (c.class) {
            try {
                contains = ldT.contains(Integer.valueOf(i));
                x.d("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing: %s, %s", new Object[]{Integer.valueOf(i), Boolean.valueOf(contains)});
            } catch (Exception e) {
                x.e("MicroMsg.MMSightCaptureVideoRemuxStatus", "isMsgRemuxing error: %s", new Object[]{e.getMessage()});
                contains = false;
            }
        }
        return contains;
    }
}
