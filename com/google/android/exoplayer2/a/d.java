package com.google.android.exoplayer2.a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface d {
    public static final ByteBuffer afB = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    void c(ByteBuffer byteBuffer);

    void flush();

    boolean iT();

    int iY();

    int iZ();

    boolean isActive();

    void ja();

    ByteBuffer jb();

    boolean r(int i, int i2, int i3);

    void reset();
}
