package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager.LayoutParams;

public final class f {
    float fHh = 0.0f;
    int gbA = -1;
    int gbB = 0;
    Runnable gbC = new 1(this);
    View gbu;
    int gbv = a.gbE;
    GestureDetector gbw;
    b gbx;
    int gby = 0;
    float gbz = 0.0f;
    Context mContext;

    public interface b {
        void aa(float f);

        void ab(float f);

        void ajJ();

        void ajK();

        void ajL();

        void ajM();

        void ajN();

        int e(int i, float f);

        void f(int i, float f);

        int getCurrentPosition();
    }

    public f(Context context, View view, b bVar) {
        this.mContext = context;
        this.gbx = bVar;
        this.gbu = view;
        this.gbw = new GestureDetector(this.mContext, new SimpleOnGestureListener() {
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                f.this.gbu.postDelayed(f.this.gbC, 200);
                return true;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                f.this.gbu.removeCallbacks(f.this.gbC);
                f.this.gbx.ajK();
                return true;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                float f3 = 1.0f;
                float f4 = 0.0f;
                if (!(motionEvent == null || motionEvent2 == null)) {
                    if (f.this.gbv == a.gbE) {
                        if (Math.abs(f) > Math.abs(f2)) {
                            f.this.gbv = a.gbH;
                        } else if (motionEvent.getX() < ((float) (f.this.gbu.getMeasuredWidth() / 2))) {
                            f.this.gbv = a.gbG;
                        } else {
                            f.this.gbv = a.gbF;
                        }
                    }
                    float x = motionEvent2.getX() - motionEvent.getX();
                    float y = motionEvent2.getY() - motionEvent.getY();
                    f fVar = f.this;
                    if (fVar.gbv == a.gbH) {
                        if (fVar.gbA == -1) {
                            fVar.gbx.ajL();
                            fVar.gbA = fVar.gbx.getCurrentPosition();
                        }
                        fVar.gbB = fVar.gbx.e(fVar.gbA, x);
                    } else if (fVar.gbv == a.gbG) {
                        x = (((y * -1.0f) / ((float) fVar.gbu.getMeasuredHeight())) * 1.2f) + fVar.fHh;
                        if (x >= 0.0f) {
                            f4 = x > 1.0f ? 1.0f : x;
                        }
                        Context context = fVar.mContext;
                        if (context instanceof Activity) {
                            if (f4 < 0.01f) {
                                f3 = 0.01f;
                            } else if (f4 <= 1.0f) {
                                f3 = f4;
                            }
                            Activity activity = (Activity) context;
                            LayoutParams attributes = activity.getWindow().getAttributes();
                            attributes.screenBrightness = f3;
                            activity.getWindow().setAttributes(attributes);
                        }
                        fVar.gbx.ab(f4);
                    } else if (fVar.gbv == a.gbF) {
                        int i;
                        y *= -1.0f;
                        f3 = y / ((float) fVar.gbu.getMeasuredHeight());
                        AudioManager audioManager = (AudioManager) fVar.mContext.getSystemService("audio");
                        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                        float f5 = 1.2f * (f3 * ((float) streamMaxVolume));
                        int i2 = (int) f5;
                        if (i2 == 0 && Math.abs(f5) > 0.2f) {
                            if (y > 0.0f) {
                                i = 1;
                            } else if (y < 0.0f) {
                                i = -1;
                            }
                            i += fVar.gby;
                            if (i < 0) {
                                i = 0;
                            } else if (i >= streamMaxVolume) {
                                i = streamMaxVolume;
                            }
                            audioManager.setStreamVolume(3, i, 0);
                            fVar.gbx.aa(((float) i) / ((float) streamMaxVolume));
                        }
                        i = i2;
                        i += fVar.gby;
                        if (i < 0) {
                            i = 0;
                        } else if (i >= streamMaxVolume) {
                            i = streamMaxVolume;
                        }
                        audioManager.setStreamVolume(3, i, 0);
                        fVar.gbx.aa(((float) i) / ((float) streamMaxVolume));
                    }
                }
                return true;
            }
        });
        this.fHh = g.cA(context);
    }
}
