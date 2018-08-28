package com.tencent.map.lib.gl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

public class a {
    public static int a;

    static {
        long maxMemory = Runtime.getRuntime().maxMemory();
        if (maxMemory <= 16777216) {
            a = 1;
        } else if (maxMemory >= 67108864) {
            a = 2;
        } else {
            a = 0;
        }
    }

    public static FloatBuffer a(int i) {
        ByteBuffer allocateDirect;
        ByteBuffer.allocate(0);
        try {
            allocateDirect = ByteBuffer.allocateDirect(i * 4);
        } catch (OutOfMemoryError e) {
            allocateDirect = ByteBuffer.allocateDirect(i * 4);
        }
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.rewind();
        return asFloatBuffer;
    }

    public static FloatBuffer a(float[] fArr, FloatBuffer floatBuffer) {
        int length = fArr.length;
        if (floatBuffer == null || floatBuffer.capacity() != length) {
            floatBuffer = a(length);
        }
        floatBuffer.put(fArr);
        floatBuffer.rewind();
        return floatBuffer;
    }

    public static ShortBuffer b(int i) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        asShortBuffer.rewind();
        return asShortBuffer;
    }

    public static ShortBuffer a(short[] sArr, ShortBuffer shortBuffer) {
        int length = sArr.length;
        if (shortBuffer == null || shortBuffer.capacity() != length) {
            shortBuffer = b(length);
        }
        shortBuffer.put(sArr);
        shortBuffer.rewind();
        return shortBuffer;
    }
}
