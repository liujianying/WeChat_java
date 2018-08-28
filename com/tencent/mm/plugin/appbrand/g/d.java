package com.tencent.mm.plugin.appbrand.g;

import java.nio.ByteBuffer;

public interface d extends c {
    boolean agi();

    ByteBuffer getNativeBuffer(int i);

    int getNativeBufferId();

    void setNativeBuffer(int i, ByteBuffer byteBuffer);
}
