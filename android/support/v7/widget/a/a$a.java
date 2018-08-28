package android.support.v7.widget.a;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.RecyclerView.e;
import android.support.v7.widget.a.c.a;
import android.support.v7.widget.a.c.b;
import android.support.v7.widget.a.c.c;
import android.view.animation.Interpolator;
import java.util.List;

public abstract class a$a {
    private static final b Yg;
    private static final Interpolator Yh = new 1();
    private static final Interpolator Yi = new 2();
    private int Yj = -1;

    public abstract boolean a(RecyclerView$t recyclerView$t, RecyclerView$t recyclerView$t2);

    public abstract int hm();

    public abstract void ht();

    static /* synthetic */ boolean C(RecyclerView recyclerView) {
        return (B(recyclerView) & 16711680) != 0;
    }

    static /* synthetic */ void a(a$a a_a, Canvas canvas, RecyclerView recyclerView, RecyclerView$t recyclerView$t, List list, int i, float f, float f2) {
        int i2;
        int size = list.size();
        for (i2 = 0; i2 < size; i2++) {
            a$c a_c = (a$c) list.get(i2);
            if (a_c.Yk == a_c.Ym) {
                a_c.Yr = z.Q(a_c.Sh.SU);
            } else {
                a_c.Yr = a_c.Yk + (a_c.mf * (a_c.Ym - a_c.Yk));
            }
            if (a_c.Yl == a_c.Yn) {
                a_c.Ys = z.R(a_c.Sh.SU);
            } else {
                a_c.Ys = a_c.Yl + (a_c.mf * (a_c.Yn - a_c.Yl));
            }
            int save = canvas.save();
            a_a.a(canvas, recyclerView, a_c.Sh, a_c.Yr, a_c.Ys, a_c.XQ, false);
            canvas.restoreToCount(save);
        }
        if (recyclerView$t != null) {
            i2 = canvas.save();
            a_a.a(canvas, recyclerView, recyclerView$t, f, f2, i, true);
            canvas.restoreToCount(i2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 21) {
            Yg = new c();
        } else if (VERSION.SDK_INT >= 11) {
            Yg = new b();
        } else {
            Yg = new a();
        }
    }

    public static int ao(int i, int i2) {
        int i3 = i & 789516;
        if (i3 == 0) {
            return i;
        }
        int i4 = (i3 ^ -1) & i;
        if (i2 == 0) {
            return i4 | (i3 << 2);
        }
        return (i4 | ((i3 << 1) & -789517)) | (((i3 << 1) & 789516) << 2);
    }

    public static int ap(int i, int i2) {
        int i3 = i & 3158064;
        if (i3 == 0) {
            return i;
        }
        int i4 = (i3 ^ -1) & i;
        if (i2 == 0) {
            return i4 | (i3 >> 2);
        }
        return (i4 | ((i3 >> 1) & -3158065)) | (((i3 >> 1) & 3158064) >> 2);
    }

    static int B(RecyclerView recyclerView) {
        return ap(3342387, z.I(recyclerView));
    }

    public static boolean hn() {
        return true;
    }

    public boolean ho() {
        return true;
    }

    public boolean hp() {
        return true;
    }

    public static int hq() {
        return 0;
    }

    public static float hr() {
        return 0.5f;
    }

    public float hs() {
        return 0.5f;
    }

    public static float J(float f) {
        return f;
    }

    public static float K(float f) {
        return f;
    }

    public static RecyclerView$t a(RecyclerView$t recyclerView$t, List<RecyclerView$t> list, int i, int i2) {
        int width = i + recyclerView$t.SU.getWidth();
        int height = i2 + recyclerView$t.SU.getHeight();
        int i3 = -1;
        int left = i - recyclerView$t.SU.getLeft();
        int top = i2 - recyclerView$t.SU.getTop();
        int size = list.size();
        int i4 = 0;
        RecyclerView$t recyclerView$t2 = null;
        while (i4 < size) {
            int right;
            RecyclerView$t recyclerView$t3 = (RecyclerView$t) list.get(i4);
            if (left > 0) {
                right = recyclerView$t3.SU.getRight() - width;
                if (right < 0 && recyclerView$t3.SU.getRight() > recyclerView$t.SU.getRight()) {
                    right = Math.abs(right);
                    if (right > i3) {
                        recyclerView$t2 = recyclerView$t3;
                        if (left < 0) {
                            i3 = recyclerView$t3.SU.getLeft() - i;
                            if (i3 > 0 && recyclerView$t3.SU.getLeft() < recyclerView$t.SU.getLeft()) {
                                i3 = Math.abs(i3);
                                if (i3 > right) {
                                    recyclerView$t2 = recyclerView$t3;
                                    if (top < 0) {
                                        right = recyclerView$t3.SU.getTop() - i2;
                                        if (right > 0 && recyclerView$t3.SU.getTop() < recyclerView$t.SU.getTop()) {
                                            right = Math.abs(right);
                                            if (right > i3) {
                                                recyclerView$t2 = recyclerView$t3;
                                                if (top > 0) {
                                                    i3 = recyclerView$t3.SU.getBottom() - height;
                                                    if (i3 < 0 && recyclerView$t3.SU.getBottom() > recyclerView$t.SU.getBottom()) {
                                                        i3 = Math.abs(i3);
                                                        if (i3 > right) {
                                                            i4++;
                                                            recyclerView$t2 = recyclerView$t3;
                                                        }
                                                    }
                                                }
                                                i3 = right;
                                                recyclerView$t3 = recyclerView$t2;
                                                i4++;
                                                recyclerView$t2 = recyclerView$t3;
                                            }
                                        }
                                    }
                                    right = i3;
                                    if (top > 0) {
                                        i3 = recyclerView$t3.SU.getBottom() - height;
                                        if (i3 < 0 && recyclerView$t3.SU.getBottom() > recyclerView$t.SU.getBottom()) {
                                            i3 = Math.abs(i3);
                                            if (i3 > right) {
                                                i4++;
                                                recyclerView$t2 = recyclerView$t3;
                                            }
                                        }
                                    }
                                    i3 = right;
                                    recyclerView$t3 = recyclerView$t2;
                                    i4++;
                                    recyclerView$t2 = recyclerView$t3;
                                }
                            }
                        }
                        i3 = right;
                        if (top < 0) {
                            right = recyclerView$t3.SU.getTop() - i2;
                            if (right > 0 && recyclerView$t3.SU.getTop() < recyclerView$t.SU.getTop()) {
                                right = Math.abs(right);
                                if (right > i3) {
                                    recyclerView$t2 = recyclerView$t3;
                                    if (top > 0) {
                                        i3 = recyclerView$t3.SU.getBottom() - height;
                                        if (i3 < 0 && recyclerView$t3.SU.getBottom() > recyclerView$t.SU.getBottom()) {
                                            i3 = Math.abs(i3);
                                            if (i3 > right) {
                                                i4++;
                                                recyclerView$t2 = recyclerView$t3;
                                            }
                                        }
                                    }
                                    i3 = right;
                                    recyclerView$t3 = recyclerView$t2;
                                    i4++;
                                    recyclerView$t2 = recyclerView$t3;
                                }
                            }
                        }
                        right = i3;
                        if (top > 0) {
                            i3 = recyclerView$t3.SU.getBottom() - height;
                            if (i3 < 0 && recyclerView$t3.SU.getBottom() > recyclerView$t.SU.getBottom()) {
                                i3 = Math.abs(i3);
                                if (i3 > right) {
                                    i4++;
                                    recyclerView$t2 = recyclerView$t3;
                                }
                            }
                        }
                        i3 = right;
                        recyclerView$t3 = recyclerView$t2;
                        i4++;
                        recyclerView$t2 = recyclerView$t3;
                    }
                }
            }
            right = i3;
            if (left < 0) {
                i3 = recyclerView$t3.SU.getLeft() - i;
                if (i3 > 0 && recyclerView$t3.SU.getLeft() < recyclerView$t.SU.getLeft()) {
                    i3 = Math.abs(i3);
                    if (i3 > right) {
                        recyclerView$t2 = recyclerView$t3;
                        if (top < 0) {
                            right = recyclerView$t3.SU.getTop() - i2;
                            if (right > 0 && recyclerView$t3.SU.getTop() < recyclerView$t.SU.getTop()) {
                                right = Math.abs(right);
                                if (right > i3) {
                                    recyclerView$t2 = recyclerView$t3;
                                    if (top > 0) {
                                        i3 = recyclerView$t3.SU.getBottom() - height;
                                        if (i3 < 0 && recyclerView$t3.SU.getBottom() > recyclerView$t.SU.getBottom()) {
                                            i3 = Math.abs(i3);
                                            if (i3 > right) {
                                                i4++;
                                                recyclerView$t2 = recyclerView$t3;
                                            }
                                        }
                                    }
                                    i3 = right;
                                    recyclerView$t3 = recyclerView$t2;
                                    i4++;
                                    recyclerView$t2 = recyclerView$t3;
                                }
                            }
                        }
                        right = i3;
                        if (top > 0) {
                            i3 = recyclerView$t3.SU.getBottom() - height;
                            if (i3 < 0 && recyclerView$t3.SU.getBottom() > recyclerView$t.SU.getBottom()) {
                                i3 = Math.abs(i3);
                                if (i3 > right) {
                                    i4++;
                                    recyclerView$t2 = recyclerView$t3;
                                }
                            }
                        }
                        i3 = right;
                        recyclerView$t3 = recyclerView$t2;
                        i4++;
                        recyclerView$t2 = recyclerView$t3;
                    }
                }
            }
            i3 = right;
            if (top < 0) {
                right = recyclerView$t3.SU.getTop() - i2;
                if (right > 0 && recyclerView$t3.SU.getTop() < recyclerView$t.SU.getTop()) {
                    right = Math.abs(right);
                    if (right > i3) {
                        recyclerView$t2 = recyclerView$t3;
                        if (top > 0) {
                            i3 = recyclerView$t3.SU.getBottom() - height;
                            if (i3 < 0 && recyclerView$t3.SU.getBottom() > recyclerView$t.SU.getBottom()) {
                                i3 = Math.abs(i3);
                                if (i3 > right) {
                                    i4++;
                                    recyclerView$t2 = recyclerView$t3;
                                }
                            }
                        }
                        i3 = right;
                        recyclerView$t3 = recyclerView$t2;
                        i4++;
                        recyclerView$t2 = recyclerView$t3;
                    }
                }
            }
            right = i3;
            if (top > 0) {
                i3 = recyclerView$t3.SU.getBottom() - height;
                if (i3 < 0 && recyclerView$t3.SU.getBottom() > recyclerView$t.SU.getBottom()) {
                    i3 = Math.abs(i3);
                    if (i3 > right) {
                        i4++;
                        recyclerView$t2 = recyclerView$t3;
                    }
                }
            }
            i3 = right;
            recyclerView$t3 = recyclerView$t2;
            i4++;
            recyclerView$t2 = recyclerView$t3;
        }
        return recyclerView$t2;
    }

    public void e(RecyclerView$t recyclerView$t, int i) {
        if (recyclerView$t != null) {
            Yg.bz(recyclerView$t.SU);
        }
    }

    public void c(RecyclerView recyclerView, RecyclerView$t recyclerView$t) {
        Yg.by(recyclerView$t.SU);
    }

    public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView$t recyclerView$t, float f, float f2, int i, boolean z) {
        Yg.a(canvas, recyclerView, recyclerView$t.SU, f, f2, i, z);
    }

    private static void a(Canvas canvas, RecyclerView recyclerView, RecyclerView$t recyclerView$t, float f, float f2, int i) {
        Yg.a(canvas, recyclerView, recyclerView$t.SU, f, f2, i);
    }

    public static long f(RecyclerView recyclerView, int i) {
        e itemAnimator = recyclerView.getItemAnimator();
        return itemAnimator == null ? i == 8 ? 200 : 250 : i == 8 ? itemAnimator.RX : itemAnimator.RW;
    }

    public final int a(RecyclerView recyclerView, int i, int i2, long j) {
        float f = 1.0f;
        if (this.Yj == -1) {
            this.Yj = recyclerView.getResources().getDimensionPixelSize(android.support.v7.d.a.a.item_touch_helper_max_drag_scroll_per_frame);
        }
        int signum = (int) (((float) (this.Yj * ((int) Math.signum((float) i2)))) * Yi.getInterpolation(Math.min(1.0f, (((float) Math.abs(i2)) * 1.0f) / ((float) i))));
        if (j <= 2000) {
            f = ((float) j) / 2000.0f;
        }
        int interpolation = (int) (Yh.getInterpolation(f) * ((float) signum));
        if (interpolation != 0) {
            return interpolation;
        }
        if (i2 > 0) {
            return 1;
        }
        return -1;
    }
}
