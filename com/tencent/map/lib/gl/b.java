package com.tencent.map.lib.gl;

import com.tencent.tencentmap.mapsdk.a.jj;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Hashtable;
import javax.microedition.khronos.opengles.GL10;

public class b {
    private int a;
    private jj<String> b;
    private Hashtable<String, Integer> c = new Hashtable();
    private IntBuffer d;

    public b(int i) {
        this.a = i;
        this.b = new jj(i);
        b();
    }

    private void b() {
        if (this.d == null) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.a * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            this.d = allocateDirect.asIntBuffer();
        }
    }

    public synchronized void a(String str, int i) {
        if (this.c.size() == this.a) {
            b();
            if (this.d != null) {
                Integer num = (Integer) this.c.remove((String) this.b.a());
                if (this.d.position() < this.a) {
                    this.d.put(num.intValue());
                }
            }
        }
        this.b.a(str);
        this.c.put(str, Integer.valueOf(i));
    }

    public synchronized int a(String str) {
        int intValue;
        Integer num = (Integer) this.c.get(str);
        if (num != null) {
            intValue = num.intValue();
        } else {
            intValue = 0;
        }
        return intValue;
    }

    public synchronized void a(GL10 gl10) {
        if (this.d != null) {
            int position = this.d.position();
            if (position > 0) {
                this.d.rewind();
                gl10.glDeleteTextures(position, this.d);
                this.d.clear();
            }
        }
    }

    public synchronized void a() {
        this.c.clear();
        this.b.b();
        if (this.d != null) {
            this.d.clear();
        }
    }

    public synchronized void b(GL10 gl10) {
        if (this.d != null) {
            for (String str : this.c.keySet()) {
                this.d.put(((Integer) this.c.get(str)).intValue());
            }
            a(gl10);
        }
        this.c.clear();
        this.b.b();
    }
}
