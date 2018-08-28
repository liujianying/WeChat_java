package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class nn {
    private a<String, Bitmap> a;

    static class a<K, V> {
        byte[] a = new byte[0];
        private LinkedHashMap<K, V> b;
        private int c;

        public a(int i) {
            this.c = i;
            this.b = new LinkedHashMap<K, V>(((int) Math.ceil((double) (((float) i) / 0.75f))) + 1, 0.75f, true) {
                protected boolean removeEldestEntry(Entry<K, V> entry) {
                    return size() > a.this.c;
                }
            };
        }

        public V a(K k) {
            V v;
            synchronized (this.a) {
                v = this.b.get(k);
            }
            return v;
        }

        public void a(K k, V v) {
            synchronized (this.a) {
                this.b.put(k, v);
            }
        }

        public void a() {
            synchronized (this.a) {
                this.b.clear();
            }
        }
    }

    public nn(int i) {
        this.a = new a(i);
    }

    public void a() {
        this.a.a();
    }

    public void a(String str, Bitmap bitmap) {
        this.a.a(str, bitmap);
    }

    public Bitmap a(String str) {
        return (Bitmap) this.a.a((Object) str);
    }
}
