package com.tencent.mm.plugin.topstory.ui.video;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.plugin.websearch.ui.b;

public final class c {
    float fHh = 0.0f;
    int gbA = -1;
    int gbB = 0;
    Runnable gbC = new Runnable() {
        public final void run() {
            c.this.ozM.ajJ();
        }
    };
    View gbu;
    private GestureDetector gbw;
    int gby = 0;
    float gbz = 0.0f;
    Context mContext;
    int ozL = a.ozQ;
    d ozM;
    boolean ozN;
    boolean ozO;

    public c(Context context, View view, d dVar) {
        this.mContext = context;
        this.ozM = dVar;
        this.gbu = view;
        this.gbw = new GestureDetector(this.mContext, new SimpleOnGestureListener() {
            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                c.this.gbu.postDelayed(c.this.gbC, 200);
                return true;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                c.this.gbu.removeCallbacks(c.this.gbC);
                c.this.ozM.ajK();
                return true;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                float f3 = 1.0f;
                float f4 = 0.0f;
                if (!(motionEvent == null || motionEvent2 == null)) {
                    if (c.this.ozL == a.ozQ) {
                        if (Math.abs(f) > Math.abs(f2)) {
                            c.this.ozL = a.ozT;
                        } else if (motionEvent.getX() < ((float) (c.this.gbu.getMeasuredWidth() / 2))) {
                            c.this.ozL = a.ozS;
                        } else {
                            c.this.ozL = a.ozR;
                        }
                    }
                    float x = motionEvent2.getX() - motionEvent.getX();
                    float y = motionEvent2.getY() - motionEvent.getY();
                    c cVar = c.this;
                    if (cVar.ozL == a.ozT) {
                        if (cVar.gbA == -1) {
                            cVar.ozM.ajL();
                            cVar.gbA = cVar.ozM.getCurrentPosition();
                        }
                        cVar.gbB = cVar.ozM.e(cVar.gbA, x);
                    } else if (cVar.ozL == a.ozS && cVar.ozO) {
                        x = (((y * -1.0f) / ((float) cVar.gbu.getMeasuredHeight())) * 1.2f) + cVar.fHh;
                        if (x >= 0.0f) {
                            f4 = x > 1.0f ? 1.0f : x;
                        }
                        Context context = cVar.mContext;
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
                        cVar.ozM.ab(f4);
                    } else if (cVar.ozL == a.ozR && cVar.ozN) {
                        int i;
                        y *= -1.0f;
                        f3 = y / ((float) cVar.gbu.getMeasuredHeight());
                        AudioManager audioManager = (AudioManager) cVar.mContext.getSystemService("audio");
                        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                        float f5 = 1.2f * (f3 * ((float) streamMaxVolume));
                        int i2 = (int) f5;
                        if (i2 == 0 && Math.abs(f5) > 0.2f) {
                            if (y > 0.0f) {
                                i = 1;
                            } else if (y < 0.0f) {
                                i = -1;
                            }
                            i += cVar.gby;
                            if (i < 0) {
                                i = 0;
                            } else if (i >= streamMaxVolume) {
                                i = streamMaxVolume;
                            }
                            audioManager.setStreamVolume(3, i, 0);
                            cVar.ozM.aa(((float) i) / ((float) streamMaxVolume));
                        }
                        i = i2;
                        i += cVar.gby;
                        if (i < 0) {
                            i = 0;
                        } else if (i >= streamMaxVolume) {
                            i = streamMaxVolume;
                        }
                        audioManager.setStreamVolume(3, i, 0);
                        cVar.ozM.aa(((float) i) / ((float) streamMaxVolume));
                    }
                }
                return true;
            }
        });
        this.fHh = b.cA(context);
    }

    public final void E(MotionEvent motionEvent) {
        if (this.ozM.bHY()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.gbz = motionEvent.getRawX();
                this.gby = ((AudioManager) this.mContext.getSystemService("audio")).getStreamVolume(3);
                this.fHh = b.cA(this.mContext);
            }
            this.gbw.onTouchEvent(motionEvent);
            if (actionMasked == 1 || actionMasked == 3) {
                if (this.ozL == a.ozT) {
                    this.ozM.f(this.gbB, motionEvent.getRawX() - this.gbz);
                    this.gbA = -1;
                    this.gbB = 0;
                    this.gbz = 0.0f;
                } else if (this.ozL == a.ozR) {
                    ((AudioManager) this.mContext.getSystemService("audio")).getStreamMaxVolume(3);
                    this.ozM.ajM();
                } else if (this.ozL == a.ozS) {
                    this.ozM.ajN();
                }
                this.ozL = a.ozQ;
                return;
            }
            return;
        }
        this.ozL = a.ozQ;
    }
}
