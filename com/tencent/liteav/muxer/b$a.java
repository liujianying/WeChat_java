package com.tencent.liteav.muxer;

import android.media.MediaCodec.BufferInfo;
import java.nio.ByteBuffer;

class b$a {
    ByteBuffer a;
    BufferInfo b;

    public b$a(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        this.a = byteBuffer;
        this.b = bufferInfo;
    }

    public ByteBuffer a() {
        return this.a;
    }

    public BufferInfo b() {
        return this.b;
    }
}
