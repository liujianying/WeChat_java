package com.tencent.mm.plugin.wear.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicInteger;

public class WearYoUI extends Activity {
    private ImageView eCl;
    private TextView eTm;
    private Vibrator hni;
    private c oQk = new 5(this);
    private ImageView pKk;
    private ImageView pKl;
    private ImageView pKm;
    private ObjectAnimator[][] pKn = ((ObjectAnimator[][]) Array.newInstance(ObjectAnimator.class, new int[]{3, 3}));
    private c pKo = new 2(this);
    private boolean pKp;
    private AtomicInteger pKq = new AtomicInteger();
    private Runnable pKr = new 3(this);
    private BroadcastReceiver pKs = new 4(this);
    private String username;

    private class a implements AnimatorListener {
        private int fHo = 1;

        public a(int i) {
            this.fHo = i;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            if (this.fHo == 2) {
                x.v("MicroMsg.Wear.WearYoUI", "onAnimationEnd count: %d", new Object[]{Integer.valueOf(WearYoUI.this.pKq.get())});
                if (WearYoUI.this.pKq.get() > 0) {
                    WearYoUI.this.pKq.decrementAndGet();
                    ah.i(WearYoUI.this.pKr, 1000);
                    return;
                }
                WearYoUI.this.eCl.animate().setListener(null);
                WearYoUI.this.pKp = false;
            } else if (this.fHo == 1) {
                WearYoUI.this.eCl.animate().scaleX(1.0f);
                WearYoUI.this.eCl.animate().scaleY(1.0f);
                WearYoUI.this.eCl.animate().setDuration(100);
                WearYoUI.this.eCl.animate().start();
                WearYoUI.this.eCl.animate().setListener(new a(2));
            }
        }

        public final void onAnimationCancel(Animator animator) {
            WearYoUI.this.pKp = false;
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    static /* synthetic */ void b(WearYoUI wearYoUI) {
        if (wearYoUI.pKp) {
            wearYoUI.pKq.addAndGet(1);
            x.v("MicroMsg.Wear.WearYoUI", "startAnimation count: %d", new Object[]{Integer.valueOf(wearYoUI.pKq.get())});
            return;
        }
        wearYoUI.pKp = true;
        ah.A(wearYoUI.pKr);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(4718592);
        setContentView(R.i.wear_yo_ui);
        this.hni = (Vibrator) getSystemService("vibrator");
        this.username = getIntent().getStringExtra("key_talker");
        this.eCl = (ImageView) findViewById(R.h.avatar_iv);
        this.eTm = (TextView) findViewById(R.h.nickname_tv);
        this.pKk = (ImageView) findViewById(R.h.avatar_wave_1_iv);
        this.pKl = (ImageView) findViewById(R.h.avatar_wave_2_iv);
        this.pKm = (ImageView) findViewById(R.h.avatar_wave_3_iv);
        b.n(this.eCl, this.username);
        this.eTm.setText(r.gT(this.username));
        this.eCl.setOnClickListener(new 1(this));
        com.tencent.mm.sdk.b.a.sFg.b(this.pKo);
        com.tencent.mm.sdk.b.a.sFg.b(this.oQk);
        a(0, this.pKk, 0);
        a(1, this.pKl, 1300);
        a(2, this.pKm, 2600);
        this.hni.vibrate(200);
        registerReceiver(this.pKs, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        overridePendingTransition(R.a.dialog_enter, R.a.dialog_exit);
    }

    private void a(int i, ImageView imageView, long j) {
        this.pKn[i][0] = ObjectAnimator.ofFloat(imageView, "scaleX", new float[]{1.0f, 2.5f});
        this.pKn[i][0].setRepeatCount(-1);
        this.pKn[i][0].setStartDelay(j);
        this.pKn[i][0].setDuration(3900);
        this.pKn[i][0].start();
        this.pKn[i][1] = ObjectAnimator.ofFloat(imageView, "scaleY", new float[]{1.0f, 2.5f});
        this.pKn[i][1].setRepeatCount(-1);
        this.pKn[i][1].setStartDelay(j);
        this.pKn[i][1].setDuration(3900);
        this.pKn[i][1].start();
        this.pKn[i][2] = ObjectAnimator.ofFloat(imageView, "alpha", new float[]{1.0f, 0.0f});
        this.pKn[i][2].setRepeatCount(-1);
        this.pKn[i][2].setInterpolator(new AccelerateInterpolator());
        this.pKn[i][2].setStartDelay(j);
        this.pKn[i][2].setDuration(3900);
        this.pKn[i][2].start();
    }

    public void onClickCheck(View view) {
        x.i("MicroMsg.Wear.WearYoUI", "onClickCheck %s", new Object[]{this.username});
        au.DF().a(new com.tencent.mm.plugin.wear.model.d.b(this.username), 0);
        finish();
    }

    public void onClickNoCheck(View view) {
        x.i("MicroMsg.Wear.WearYoUI", "onClickNoCheck %s", new Object[]{this.username});
        finish();
    }

    protected void onDestroy() {
        for (int i = 0; i < this.pKn.length; i++) {
            for (ObjectAnimator cancel : this.pKn[i]) {
                cancel.cancel();
            }
        }
        unregisterReceiver(this.pKs);
        com.tencent.mm.sdk.b.a.sFg.c(this.oQk);
        com.tencent.mm.sdk.b.a.sFg.c(this.pKo);
        com.tencent.mm.plugin.wear.model.a.bSl().pIT.bSB();
        super.onDestroy();
    }
}
