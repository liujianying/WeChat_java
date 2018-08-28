package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class jo {
    public final Rect a = new Rect();
    public int[] b;
    public int[] c;
    public int[] d;

    private static void a(int[] iArr, ByteBuffer byteBuffer) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = byteBuffer.getInt();
        }
    }

    private static void a(int i) {
        if (i == 0 || (i & 1) != 0) {
            throw new RuntimeException("invalid nine-patch: " + i);
        }
    }

    public static jo a(byte[] bArr) {
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder());
        if (order.get() == (byte) 0) {
            return null;
        }
        jo joVar = new jo();
        joVar.b = new int[order.get()];
        joVar.c = new int[order.get()];
        joVar.d = new int[order.get()];
        a(joVar.b.length);
        a(joVar.c.length);
        order.getInt();
        order.getInt();
        joVar.a.left = order.getInt();
        joVar.a.right = order.getInt();
        joVar.a.top = order.getInt();
        joVar.a.bottom = order.getInt();
        order.getInt();
        a(joVar.b, order);
        a(joVar.c, order);
        a(joVar.d, order);
        return joVar;
    }
}
