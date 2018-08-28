package com.tencent.tencentmap.mapsdk.a;

import android.view.ViewGroup;

public interface ld extends mq {

    public enum b {
        LEFT_BOTTOM(0),
        CENTER_BOTTOM(4),
        RIGHT_BOTTOM(1),
        LEFT_TOP(3),
        CENTER_TOP(5),
        RIGHT_TOP(2);
        
        public final int g;

        private b(int i) {
            this.g = i;
        }

        public static b a(int i) {
            if (i < 0 || i >= values().length) {
                i = 0;
            }
            b bVar = LEFT_BOTTOM;
            for (b bVar2 : values()) {
                if (bVar2.g == i) {
                    return bVar2;
                }
            }
            return bVar;
        }
    }

    void a();

    boolean a(ViewGroup viewGroup);
}
