package com.tencent.matrix.trace.b;

public interface c {
    long[] getBuffer();

    int getCurIndex();

    long getFirstTime();

    long getLastDiffTime();

    boolean isRealTrace();

    void onCreate();

    void onDestroy();

    void registerListener(d dVar);

    void reset();

    void unregisterListener(d dVar);
}
