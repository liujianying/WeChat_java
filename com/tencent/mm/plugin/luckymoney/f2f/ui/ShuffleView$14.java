package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.graphics.Rect;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.sdk.platformtools.x;

class ShuffleView$14 implements OnGestureListener {
    final /* synthetic */ ShuffleView kPn;

    ShuffleView$14(ShuffleView shuffleView) {
        this.kPn = shuffleView;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        x.d("ShuffleView", "gesture down");
        switch (ShuffleView.l(this.kPn).kPs) {
            case 4:
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int i = 0;
                while (i < ShuffleView.d(this.kPn)) {
                    Rect a = ShuffleView.a(this.kPn, i);
                    if (a == null || !a.contains(x, y)) {
                        i++;
                    } else {
                        View view = (View) ShuffleView.e(this.kPn).get(i);
                        if (ShuffleView.h(this.kPn) != view && ShuffleView.h(this.kPn) != null) {
                            ShuffleView.m(this.kPn);
                        } else if (ShuffleView.h(this.kPn) == view) {
                            x.i("ShuffleView", "down on the select card");
                            return true;
                        }
                        ShuffleView.b(this.kPn, i);
                        return true;
                    }
                }
                return false;
            default:
                return false;
        }
    }

    public final void onShowPress(MotionEvent motionEvent) {
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        switch (ShuffleView.l(this.kPn).kPs) {
            case 4:
                if (ShuffleView.h(this.kPn) != null) {
                    x.d("ShuffleView", "click the select card");
                    if (ShuffleView.n(this.kPn) != null) {
                        ShuffleView.n(this.kPn).cN(ShuffleView.f(this.kPn), ShuffleView.d(this.kPn));
                    }
                    ShuffleView.m(this.kPn);
                }
                if (ShuffleView.k(this.kPn) != null) {
                    if (ShuffleView.n(this.kPn) != null) {
                        ShuffleView.n(this.kPn).rZ(ShuffleView.d(this.kPn));
                    }
                    ShuffleView.c(this.kPn, ShuffleView.i(this.kPn));
                }
                return true;
            default:
                return false;
        }
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent2.getActionMasked() == 2) {
            int x = (int) motionEvent2.getX();
            int y = (int) motionEvent2.getY();
            switch (ShuffleView.l(this.kPn).kPs) {
                case 4:
                    View view;
                    if (Math.abs(f2) < ((float) ShuffleView.o(this.kPn))) {
                        for (int i = 0; i < ShuffleView.d(this.kPn); i++) {
                            Rect a = ShuffleView.a(this.kPn, i);
                            if (a != null && a.contains(x, y)) {
                                view = (View) ShuffleView.e(this.kPn).get(i);
                                if (ShuffleView.h(this.kPn) != view && ShuffleView.h(this.kPn) != null) {
                                    ShuffleView.m(this.kPn);
                                } else if (ShuffleView.h(this.kPn) == view) {
                                    x.i("ShuffleView", "scroll on the select card");
                                }
                                if (ShuffleView.k(this.kPn) != view) {
                                    ShuffleView.p(this.kPn);
                                    ShuffleView.b(this.kPn, i);
                                }
                            }
                        }
                    }
                    if (Math.abs(f) < ((float) ShuffleView.o(this.kPn))) {
                        x.d("ShuffleView", "scroll distanceY:" + f2);
                        if (ShuffleView.k(this.kPn) != null) {
                            view = ShuffleView.k(this.kPn);
                        } else if (ShuffleView.h(this.kPn) != null) {
                            view = ShuffleView.h(this.kPn);
                        } else {
                            view = null;
                        }
                        if (view != null) {
                            x.i("ShuffleView", "scroll translationY:" + view.getTranslationY() + "," + (view.getHeight() / 7));
                            if (((int) view.getTranslationY()) > (-view.getHeight()) / 7) {
                                if (view.getTranslationY() != 0.0f) {
                                    if (f2 >= 0.0f) {
                                        if (((int) (view.getTranslationY() - f2)) > (-view.getHeight()) / 7) {
                                            view.setTranslationY(view.getTranslationY() - f2);
                                            break;
                                        }
                                        view.setTranslationY((float) ((-view.getHeight()) / 7));
                                        break;
                                    } else if (view.getTranslationY() - f2 < 0.0f) {
                                        view.setTranslationY(view.getTranslationY() - f2);
                                        break;
                                    } else {
                                        view.setTranslationY(0.0f);
                                        break;
                                    }
                                } else if (f2 > 0.0f && Math.abs(f2) > ((float) ShuffleView.o(this.kPn))) {
                                    if (((int) f2) < view.getHeight() / 7) {
                                        view.setTranslationY(view.getTranslationY() - f2);
                                        break;
                                    }
                                    view.setTranslationY((float) ((-view.getHeight()) / 7));
                                    break;
                                }
                            } else if (f2 < 0.0f && Math.abs(f2) > ((float) ShuffleView.o(this.kPn))) {
                                if (((int) f2) <= (-view.getHeight()) / 7) {
                                    view.setTranslationY(0.0f);
                                } else {
                                    view.setTranslationY(view.getTranslationY() - f2);
                                }
                                if (view == ShuffleView.h(this.kPn)) {
                                    ShuffleView.a(this.kPn, ShuffleView.h(this.kPn));
                                    ShuffleView.d(this.kPn, ShuffleView.f(this.kPn));
                                    if (ShuffleView.q(this.kPn).isStarted()) {
                                        x.i("ShuffleView", "scroll when select view is animation");
                                        ShuffleView.q(this.kPn).cancel();
                                    }
                                    ShuffleView.b(this.kPn, null);
                                    ShuffleView.e(this.kPn, 0);
                                    break;
                                }
                            }
                        }
                    }
                    break;
            }
        }
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        x.i("ShuffleView", "fling up " + f2);
        if (f2 >= ((float) (-ShuffleView.r(this.kPn)))) {
            return false;
        }
        switch (ShuffleView.l(this.kPn).kPs) {
            case 4:
                if (ShuffleView.h(this.kPn) != null) {
                    ShuffleView.m(this.kPn);
                }
                if (ShuffleView.k(this.kPn) != null) {
                    if (ShuffleView.n(this.kPn) != null) {
                        ShuffleView.n(this.kPn).rZ(ShuffleView.d(this.kPn));
                    }
                    ShuffleView.c(this.kPn, ShuffleView.i(this.kPn));
                    break;
                }
                break;
        }
        return true;
    }
}
