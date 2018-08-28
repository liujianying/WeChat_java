package com.tencent.mm.plugin.bottle.ui;

import android.graphics.drawable.AnimationDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.bottle.a.h;
import com.tencent.mm.plugin.bottle.a.h.d;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;

class ThrowBottleUI$2 implements OnTouchListener {
    final /* synthetic */ ThrowBottleUI hnD;

    ThrowBottleUI$2(ThrowBottleUI throwBottleUI) {
        this.hnD = throwBottleUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (view == ThrowBottleUI.f(this.hnD)) {
            switch (motionEvent.getAction()) {
                case 0:
                    if (!ThrowBottleUI.g(this.hnD)) {
                        x.i("MM.Bottle.ThrowBottleUI", "summerper checkPermission checkMicrophone[%b]", new Object[]{Boolean.valueOf(a.a(ThrowBottleUI.h(this.hnD), "android.permission.RECORD_AUDIO", 80, null, null))});
                        if (a.a(ThrowBottleUI.h(this.hnD), "android.permission.RECORD_AUDIO", 80, null, null)) {
                            ThrowBottleUI throwBottleUI = this.hnD;
                            throwBottleUI.hnt = true;
                            throwBottleUI.hnq.setBackgroundDrawable(com.tencent.mm.bp.a.f(throwBottleUI.hlO, R.g.record_shape_press));
                            throwBottleUI.hnq.setText(throwBottleUI.hmZ ? R.l.bottle_throw_voice_btn_pressed_text : R.l.bottle_throw_text_btn_text);
                            if (throwBottleUI.hmZ) {
                                if (!com.tencent.mm.p.a.by(throwBottleUI.getContext()) && !com.tencent.mm.p.a.bw(throwBottleUI.hlO)) {
                                    au.HU();
                                    if (!c.isSDCardAvailable()) {
                                        s.gH(throwBottleUI.hlO);
                                        break;
                                    }
                                    throwBottleUI.hnA = true;
                                    x.v("MM.Bottle.ThrowBottleUI", "record start");
                                    if (throwBottleUI.hne != null) {
                                        throwBottleUI.hne.hka = null;
                                        throwBottleUI.hne = null;
                                    }
                                    throwBottleUI.hne = new d(throwBottleUI.getContext(), throwBottleUI);
                                    throwBottleUI.erD.J(100, 100);
                                    throwBottleUI.hnl.setVisibility(0);
                                    throwBottleUI.hnm.setVisibility(0);
                                    throwBottleUI.hnk = (AnimationDrawable) throwBottleUI.hnm.getBackground();
                                    throwBottleUI.hnk.start();
                                    throwBottleUI.hnn.setVisibility(8);
                                    if (throwBottleUI.hne != null) {
                                        af.Wp("keep_app_silent");
                                        throwBottleUI.hne.dd("_USER_FOR_THROWBOTTLE_");
                                        throwBottleUI.hnu = false;
                                        throwBottleUI.hnz.J(200, 200);
                                        throwBottleUI.hnf.startTone(24);
                                        throwBottleUI.handler.postDelayed(new ThrowBottleUI$7(throwBottleUI), 200);
                                        throwBottleUI.hni.vibrate(50);
                                        throwBottleUI.hne.a(throwBottleUI.hnC);
                                    }
                                    throwBottleUI.hlO.getWindow().getDecorView().setKeepScreenOn(true);
                                    break;
                                }
                                x.d("MM.Bottle.ThrowBottleUI", "voip is running, can't record voice");
                                break;
                            }
                        }
                    }
                    break;
                case 1:
                    ThrowBottleUI.i(this.hnD);
                    ThrowBottleUI.f(this.hnD).setBackgroundDrawable(com.tencent.mm.bp.a.f(ThrowBottleUI.h(this.hnD), R.g.record_shape_normal));
                    ThrowBottleUI.f(this.hnD).setText(ThrowBottleUI.j(this.hnD) ? R.l.bottle_throw_voice_btn_text : R.l.bottle_throw_text_btn_text);
                    if (!ThrowBottleUI.j(this.hnD)) {
                        ThrowBottleUI.l(this.hnD);
                        String trim = ThrowBottleUI.m(this.hnD).getText().toString().trim();
                        if (trim.length() < 5) {
                            ThrowBottleUI.h(this.hnD).nl(R.l.bottle_throw_text_too_short);
                            break;
                        }
                        ThrowBottleUI.m(this.hnD).setText("");
                        h.c cVar = new h.c(trim, this.hnD);
                        ThrowBottleUI.n(this.hnD);
                    } else if (!ThrowBottleUI.k(this.hnD)) {
                        this.hnD.auH();
                    }
                    ThrowBottleUI.o(this.hnD);
                    break;
            }
        }
        return false;
    }
}
