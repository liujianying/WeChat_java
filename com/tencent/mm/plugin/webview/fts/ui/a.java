package com.tencent.mm.plugin.webview.fts.ui;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.webview.fts.c.c;

public final class a {
    float fHh = 0.0f;
    int gbA = -1;
    int gbB = 0;
    Runnable gbC = new 1(this);
    View gbu;
    GestureDetector gbw;
    int gby = 0;
    float gbz = 0.0f;
    Context mContext;
    int pPW = a.pPZ;
    b pPX;

    public a(Context context, View view, b bVar) {
        this.mContext = context;
        this.pPX = bVar;
        this.gbu = view;
        this.gbw = new GestureDetector(this.mContext, new SimpleOnGestureListener() {
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                a.this.gbu.postDelayed(a.this.gbC, 200);
                return true;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                a.this.gbu.removeCallbacks(a.this.gbC);
                a.this.pPX.ajK();
                return true;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                float f3 = 1.0f;
                float f4 = 0.0f;
                if (!(motionEvent == null || motionEvent2 == null)) {
                    if (a.this.pPW == a.pPZ) {
                        if (Math.abs(f) > Math.abs(f2)) {
                            a.this.pPW = a.pQc;
                        } else if (motionEvent.getX() < ((float) (a.this.gbu.getMeasuredWidth() / 2))) {
                            a.this.pPW = a.pQb;
                        } else {
                            a.this.pPW = a.pQa;
                        }
                    }
                    float x = motionEvent2.getX() - motionEvent.getX();
                    float y = motionEvent2.getY() - motionEvent.getY();
                    a aVar = a.this;
                    if (aVar.pPW == a.pQc) {
                        if (aVar.gbA == -1) {
                            aVar.pPX.ajL();
                            aVar.gbA = aVar.pPX.getCurrentPosition();
                        }
                        aVar.gbB = aVar.pPX.e(aVar.gbA, x);
                    } else if (aVar.pPW == a.pQb) {
                        x = (((y * -1.0f) / ((float) aVar.gbu.getMeasuredHeight())) * 1.2f) + aVar.fHh;
                        if (x >= 0.0f) {
                            f4 = x > 1.0f ? 1.0f : x;
                        }
                        Context context = aVar.mContext;
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
                        aVar.pPX.ab(f4);
                    } else if (aVar.pPW == a.pQa) {
                        int i;
                        y *= -1.0f;
                        f3 = y / ((float) aVar.gbu.getMeasuredHeight());
                        AudioManager audioManager = (AudioManager) aVar.mContext.getSystemService("audio");
                        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                        float f5 = 1.2f * (f3 * ((float) streamMaxVolume));
                        int i2 = (int) f5;
                        if (i2 == 0 && Math.abs(f5) > 0.2f) {
                            if (y > 0.0f) {
                                i = 1;
                            } else if (y < 0.0f) {
                                i = -1;
                            }
                            i += aVar.gby;
                            if (i < 0) {
                                i = 0;
                            } else if (i >= streamMaxVolume) {
                                i = streamMaxVolume;
                            }
                            audioManager.setStreamVolume(3, i, 0);
                            aVar.pPX.aa(((float) i) / ((float) streamMaxVolume));
                        }
                        i = i2;
                        i += aVar.gby;
                        if (i < 0) {
                            i = 0;
                        } else if (i >= streamMaxVolume) {
                            i = streamMaxVolume;
                        }
                        audioManager.setStreamVolume(3, i, 0);
                        aVar.pPX.aa(((float) i) / ((float) streamMaxVolume));
                    }
                }
                return true;
            }
        });
        this.fHh = c.cA(context);
    }
}
