package com.tencent.matrix.trace.core;

import android.app.Activity;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import com.tencent.matrix.d.b;
import com.tencent.matrix.trace.b.c;
import com.tencent.matrix.trace.b.d;
import com.tencent.matrix.trace.core.a.a;

public class MethodBeat implements c, a {
    private static final int RELEASE_BUFFER_MSG_ID = 512;
    private static final String TAG = "Matrix.MethodBeat";
    private static final int UPDATE_TIME_MSG_ID = 256;
    private static volatile boolean isBackground;
    private static volatile boolean isCreated = false;
    private static boolean isRealTrace;
    private static long[] sBuffer = new long[10000];
    private static volatile long sCurrentDiffTime;
    private static volatile long sFirstDiffTime = System.currentTimeMillis();
    private static volatile int sIndex = 0;
    private static boolean sIsIn = false;
    private static volatile long sLastDiffTime;
    private static d sListener;
    private static Thread sMainThread = Looper.getMainLooper().getThread();
    private static Handler sReleaseBufferHandler = new Handler(Looper.getMainLooper(), new Callback() {
        public final boolean handleMessage(Message message) {
            if (message.what == MethodBeat.RELEASE_BUFFER_MSG_ID && !MethodBeat.isCreated) {
                b.i(MethodBeat.TAG, "Plugin is never init, release buffer!", new Object[0]);
                MethodBeat.sBuffer = null;
            }
            return true;
        }
    });
    private static Handler sTimeUpdateHandler = new Handler(sTimerUpdateThread.getLooper(), new Callback() {
        public final boolean handleMessage(Message message) {
            if (message.what == 256) {
                MethodBeat.sCurrentDiffTime = (System.nanoTime() / 1000000) - MethodBeat.sLastDiffTime;
                MethodBeat.sTimeUpdateHandler.sendEmptyMessageDelayed(256, 5);
            }
            return true;
        }
    });
    private static HandlerThread sTimerUpdateThread = com.tencent.matrix.d.a.cd("matrix_time_update_thread");

    static {
        long nanoTime = System.nanoTime() / 1000000;
        sLastDiffTime = nanoTime;
        sCurrentDiffTime = nanoTime;
        sTimeUpdateHandler.sendEmptyMessage(256);
        sReleaseBufferHandler.sendEmptyMessageDelayed(RELEASE_BUFFER_MSG_ID, 60000);
    }

    public static void i(int i) {
        if (!isBackground) {
            isRealTrace = true;
            if (isCreated && Thread.currentThread() == sMainThread) {
                if (!sIsIn) {
                    sIsIn = true;
                    mergeData(i, sIndex, true);
                    int i2 = sIndex + 1;
                    sIndex = i2;
                    if (i2 >= 1000000 && sListener != null) {
                        sListener.b(sBuffer);
                        sIndex = 0;
                    }
                    sIsIn = false;
                }
            } else if (!isCreated && Thread.currentThread() == sMainThread && !sIsIn) {
                sIsIn = true;
                if (sIndex < 10000) {
                    mergeData(i, sIndex, true);
                    sIndex++;
                }
                sIsIn = false;
            }
        }
    }

    public static void o(int i) {
        if (!isBackground) {
            if (isCreated && Thread.currentThread() == sMainThread) {
                mergeData(i, sIndex, false);
                int i2 = sIndex + 1;
                sIndex = i2;
                if (i2 >= 1000000 && sListener != null) {
                    sListener.b(sBuffer);
                    sIndex = 0;
                }
            } else if (!isCreated && Thread.currentThread() == sMainThread && sIndex < 10000) {
                mergeData(i, sIndex, false);
                sIndex++;
            }
        }
    }

    public static void at(Activity activity, boolean z) {
        boolean z2 = true;
        String str = TAG;
        String str2 = "[AT] activity: %s, isCreated: %b sListener is null?: %b，isFocus: %b";
        Object[] objArr = new Object[4];
        objArr[0] = activity.getClass().getSimpleName();
        objArr[1] = Boolean.valueOf(isCreated);
        if (sListener != null) {
            z2 = false;
        }
        objArr[2] = Boolean.valueOf(z2);
        objArr[3] = Boolean.valueOf(z);
        b.i(str, str2, objArr);
        if (isCreated && Thread.currentThread() == sMainThread && sListener != null) {
            sListener.a(activity, z, sIndex - 1, sBuffer);
        }
    }

    private static void mergeData(int i, int i2, boolean z) {
        long j = 0;
        if (z) {
            j = Long.MIN_VALUE;
        }
        sBuffer[i2] = (j | (((long) i) << 43)) | (sCurrentDiffTime & 8796093022207L);
    }

    public void onCreate() {
        b.i(TAG, "[onCreate]", new Object[0]);
        if (!isCreated) {
            sTimeUpdateHandler.removeMessages(RELEASE_BUFFER_MSG_ID);
            a.tE().a((a) this);
            isCreated = true;
            if (sBuffer == null || sBuffer.length >= 1000000) {
                sBuffer = new long[1000000];
                return;
            }
            Object obj = sBuffer;
            sBuffer = new long[1000000];
            System.arraycopy(obj, 0, sBuffer, 0, sIndex);
        }
    }

    public void onDestroy() {
        b.i(TAG, "[onDestroy]", new Object[0]);
        if (isCreated) {
            sListener = null;
            isCreated = false;
            sIndex = 0;
            sBuffer = null;
            sTimeUpdateHandler.removeMessages(256);
            sTimeUpdateHandler.removeMessages(RELEASE_BUFFER_MSG_ID);
            sTimerUpdateThread.quit();
            a.tE().b((a) this);
        }
    }

    public boolean isRealTrace() {
        return isRealTrace;
    }

    public long getLastDiffTime() {
        return sLastDiffTime;
    }

    public long getFirstTime() {
        return sFirstDiffTime;
    }

    public void registerListener(d dVar) {
        sListener = dVar;
    }

    public void unregisterListener(d dVar) {
        sListener = null;
    }

    public long[] getBuffer() {
        return sBuffer;
    }

    public int getCurIndex() {
        return sIndex;
    }

    public void reset() {
        sIndex = 0;
    }

    public void onFront(Activity activity) {
        b.i(TAG, "[onFront]: %s", activity.getClass().getSimpleName());
        if (!sTimeUpdateHandler.hasMessages(256)) {
            sTimeUpdateHandler.sendEmptyMessage(256);
        }
        isBackground = false;
        reset();
    }

    public void onBackground(Activity activity) {
        b.i(TAG, "[onBackground]: %s", activity.getClass().getSimpleName());
        sTimeUpdateHandler.removeMessages(256);
        isBackground = true;
    }

    public void onChange(Activity activity, Fragment fragment) {
    }

    public void onActivityCreated(Activity activity) {
        b.i(TAG, "[onActivityCreated]: %s", activity.getClass().getSimpleName());
        if (isBackground && !sTimeUpdateHandler.hasMessages(256)) {
            sTimeUpdateHandler.sendEmptyMessage(256);
        }
    }

    public void onActivityStarted(Activity activity) {
        b.i(TAG, "[onActivityStarted]: %s", activity.getClass().getSimpleName());
        if (isBackground && !sTimeUpdateHandler.hasMessages(256)) {
            sTimeUpdateHandler.sendEmptyMessage(256);
        }
    }

    public void onActivityPause(Activity activity) {
    }
}
