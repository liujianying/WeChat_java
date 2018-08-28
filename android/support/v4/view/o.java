package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public final class o {
    static final e uS;

    interface e {
        int b(MotionEvent motionEvent, int i);

        int c(MotionEvent motionEvent, int i);

        float d(MotionEvent motionEvent, int i);

        float e(MotionEvent motionEvent, int i);

        float f(MotionEvent motionEvent, int i);

        int f(MotionEvent motionEvent);

        int g(MotionEvent motionEvent);
    }

    static class a implements e {
        a() {
        }

        public int b(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            return -1;
        }

        public int c(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float d(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getX();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float e(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getY();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public int f(MotionEvent motionEvent) {
            return 1;
        }

        public int g(MotionEvent motionEvent) {
            return 0;
        }

        public float f(MotionEvent motionEvent, int i) {
            return 0.0f;
        }
    }

    static class b extends a {
        b() {
        }

        public final int b(MotionEvent motionEvent, int i) {
            return motionEvent.findPointerIndex(i);
        }

        public final int c(MotionEvent motionEvent, int i) {
            return motionEvent.getPointerId(i);
        }

        public final float d(MotionEvent motionEvent, int i) {
            return motionEvent.getX(i);
        }

        public final float e(MotionEvent motionEvent, int i) {
            return motionEvent.getY(i);
        }

        public final int f(MotionEvent motionEvent) {
            return motionEvent.getPointerCount();
        }
    }

    static class c extends b {
        c() {
        }

        public final int g(MotionEvent motionEvent) {
            return motionEvent.getSource();
        }
    }

    static class d extends c {
        d() {
        }

        public final float f(MotionEvent motionEvent, int i) {
            return motionEvent.getAxisValue(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 12) {
            uS = new d();
        } else if (VERSION.SDK_INT >= 9) {
            uS = new c();
        } else if (VERSION.SDK_INT >= 5) {
            uS = new b();
        } else {
            uS = new a();
        }
    }

    public static int d(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int e(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int b(MotionEvent motionEvent, int i) {
        return uS.b(motionEvent, i);
    }

    public static int c(MotionEvent motionEvent, int i) {
        return uS.c(motionEvent, i);
    }

    public static float d(MotionEvent motionEvent, int i) {
        return uS.d(motionEvent, i);
    }

    public static float e(MotionEvent motionEvent, int i) {
        return uS.e(motionEvent, i);
    }

    public static int f(MotionEvent motionEvent) {
        return uS.f(motionEvent);
    }

    public static int g(MotionEvent motionEvent) {
        return uS.g(motionEvent);
    }

    public static float f(MotionEvent motionEvent, int i) {
        return uS.f(motionEvent, i);
    }
}
