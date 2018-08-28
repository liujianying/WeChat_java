package com.tencent.mm.z;

import java.io.Closeable;

public interface d extends Closeable {
    int Kn();

    long getSize();

    boolean isOpen();

    void open();

    int readAt(long j, byte[] bArr, int i, int i2);
}
