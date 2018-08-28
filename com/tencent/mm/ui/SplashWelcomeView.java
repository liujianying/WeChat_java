package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bt;
import com.tencent.mm.plugin.setting.model.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SplashWelcomeView extends FrameLayout implements ap {
    private Bitmap bitmap;
    private boolean hasDrawed;
    private volatile boolean tqw;
    private volatile boolean tqx;
    private ImageView tqy;
    private int tqz;

    public SplashWelcomeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        gr(context);
    }

    public SplashWelcomeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        gr(context);
    }

    private void gr(Context context) {
        SharedPreferences sharedPreferences;
        String I;
        if (ad.cic()) {
            sharedPreferences = ad.getContext().getSharedPreferences("switch_account_preferences", 0);
            try {
                x.i("SplashWelcomeView", "transit to switch account %s", Boolean.valueOf(sharedPreferences.getBoolean("transit_to_switch_account", false)));
                if (sharedPreferences.getBoolean("transit_to_switch_account", false)) {
                    sharedPreferences.edit().putBoolean("transit_to_switch_account", false).commit();
                    View inflate = ((Activity) context).getLayoutInflater().inflate(R.i.settings_switch_account, null);
                    SwitchAccountGridView switchAccountGridView = (SwitchAccountGridView) inflate.findViewById(R.h.switch_account_grid);
                    switchAccountGridView.setRowCount(1);
                    switchAccountGridView.setClickable(false);
                    inflate.findViewById(R.h.switch_account_delete_btn).setVisibility(8);
                    inflate.findViewById(R.h.switch_account_cancel_btn).setVisibility(8);
                    TextView textView = (TextView) inflate.findViewById(R.h.switch_account_title);
                    x.i("SplashWelcomeView", "activity resources %s, application resources %s", context.getResources(), ad.getResources());
                    textView.setText(context.getResources().getString(R.l.settings_switch_account_login_title));
                    Set<String> IH = bt.dDs.IH();
                    I = at.dBv.I("login_weixin_username", "");
                    Map hashMap = new HashMap();
                    if (bi.oW(I) || IH.contains(I)) {
                        for (String str : IH) {
                            hashMap.put(str, new SwitchAccountModel(str, bt.dDs.getString(str, "login_user_name"), bt.dDs.getString(str, "last_avatar_path"), bt.dDs.getString(str, "last_logout_no_pwd_ticket"), bi.WU(bt.dDs.getString(str, "last_login_use_voice"))));
                        }
                    } else {
                        hashMap.put(I, new SwitchAccountModel(I, at.dBv.I("login_user_name", ""), at.dBv.HL(), at.dBv.I("last_logout_no_pwd_ticket", ""), bi.WU(at.dBv.I("last_login_use_voice", ""))));
                    }
                    switchAccountGridView.setUseSystemDecoder(true);
                    switchAccountGridView.L(hashMap);
                    switchAccountGridView.setLastLoginWxUsername(I);
                    switchAccountGridView.setLogoutState(true);
                    switchAccountGridView.bum();
                    addView(inflate, new LayoutParams(-1, -1));
                    return;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("SplashWelcomeView", e, "show switch account view with exception!", new Object[0]);
            }
        }
        this.tqy = new SplashImageView(context);
        this.tqy.setScaleType(ScaleType.CENTER_CROP);
        ((SplashImageView) this.tqy).setOnDrawListener(this);
        addView(this.tqy, new LayoutParams(-1, -1));
        try {
            if (ad.cic()) {
                sharedPreferences = ad.getContext().getSharedPreferences("system_config_prefs", 0);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                x.i("SplashWelcomeView", "beginTime:%s,endTime:%s,currentTime:%s", Long.valueOf(sharedPreferences.getLong("new_launch_image_begin_time", 0)), Long.valueOf(sharedPreferences.getLong("new_launch_image_end_time", 0)), Long.valueOf(currentTimeMillis));
                I = b.duN + "splashWelcomeImg";
                if (currentTimeMillis <= sharedPreferences.getLong("new_launch_image_begin_time", 0) || currentTimeMillis >= r6) {
                    x.i("SplashWelcomeView", "change launch image activity is finished!");
                    e.deleteFile(I);
                    return;
                }
                Object obj;
                this.tqz = sharedPreferences.getInt("launch_fail_times", 0);
                int i = sharedPreferences.getInt("launch_last_status", 0);
                if (i == 1) {
                    x.i("SplashWelcomeView", "last launch status is 'start'.");
                    this.tqz++;
                    sharedPreferences.edit().putInt("launch_fail_times", this.tqz).commit();
                } else if (i == 2) {
                    x.i("SplashWelcomeView", "last launch status is 'end'.");
                }
                sharedPreferences.edit().putInt("launch_last_status", 1).apply();
                if (this.tqz >= 3) {
                    x.i("SplashWelcomeView", "launch exceed max failed times, %d", Integer.valueOf(this.tqz));
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    com.tencent.mm.sdk.f.e.post(new Runnable() {
                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            /*
                            r6 = this;
                            r2 = 1;
                            r4 = 0;
                            r0 = r3;
                            r0 = com.tencent.mm.a.e.cn(r0);
                            if (r0 == 0) goto L_0x0084;
                        L_0x000a:
                            r0 = r3;	 Catch:{ Exception -> 0x0053 }
                            r1 = 0;
                            r2 = r3;	 Catch:{ Exception -> 0x0053 }
                            r2 = com.tencent.mm.a.e.cm(r2);	 Catch:{ Exception -> 0x0053 }
                            r0 = com.tencent.mm.a.e.e(r0, r1, r2);	 Catch:{ Exception -> 0x0053 }
                            if (r0 == 0) goto L_0x0045;
                        L_0x0019:
                            r1 = r0.length;	 Catch:{ Exception -> 0x0053 }
                            if (r1 <= 0) goto L_0x0045;
                        L_0x001c:
                            r1 = com.tencent.mm.ui.SplashWelcomeView.this;	 Catch:{ Exception -> 0x0053 }
                            r2 = 0;
                            r3 = r0.length;	 Catch:{ Exception -> 0x0053 }
                            r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r2, r3);	 Catch:{ Exception -> 0x0053 }
                            r1.bitmap = r0;	 Catch:{ Exception -> 0x0053 }
                            r0 = "SplashWelcomeView";
                            r1 = "ready to play animation, hasDrawed %s";
                            r2 = 1;
                            r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0053 }
                            r3 = 0;
                            r4 = com.tencent.mm.ui.SplashWelcomeView.this;	 Catch:{ Exception -> 0x0053 }
                            r4 = r4.hasDrawed;	 Catch:{ Exception -> 0x0053 }
                            r4 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0053 }
                            r2[r3] = r4;	 Catch:{ Exception -> 0x0053 }
                            com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ Exception -> 0x0053 }
                            r0 = com.tencent.mm.ui.SplashWelcomeView.this;	 Catch:{ Exception -> 0x0053 }
                            r0.tqx = true;	 Catch:{ Exception -> 0x0053 }
                        L_0x0045:
                            r0 = com.tencent.mm.ui.SplashWelcomeView.this;
                            r0 = r0.hasDrawed;
                            if (r0 == 0) goto L_0x0052;
                        L_0x004d:
                            r0 = com.tencent.mm.ui.SplashWelcomeView.this;
                            r0.cqT();
                        L_0x0052:
                            return;
                        L_0x0053:
                            r0 = move-exception;
                            r1 = "SplashWelcomeView";
                            r2 = "decode new welcome image error: %s";
                            r3 = 1;
                            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0075 }
                            r4 = 0;
                            r5 = r0.getMessage();	 Catch:{ all -> 0x0075 }
                            r3[r4] = r5;	 Catch:{ all -> 0x0075 }
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ all -> 0x0075 }
                            r0 = com.tencent.mm.ui.SplashWelcomeView.this;
                            r0 = r0.hasDrawed;
                            if (r0 == 0) goto L_0x0052;
                        L_0x006f:
                            r0 = com.tencent.mm.ui.SplashWelcomeView.this;
                            r0.cqT();
                            goto L_0x0052;
                        L_0x0075:
                            r0 = move-exception;
                            r1 = com.tencent.mm.ui.SplashWelcomeView.this;
                            r1 = r1.hasDrawed;
                            if (r1 == 0) goto L_0x0083;
                        L_0x007e:
                            r1 = com.tencent.mm.ui.SplashWelcomeView.this;
                            r1.cqT();
                        L_0x0083:
                            throw r0;
                        L_0x0084:
                            r0 = "SplashWelcomeView";
                            r1 = "cannot find %s";
                            r2 = new java.lang.Object[r2];
                            r3 = r3;
                            r2[r4] = r3;
                            com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
                            goto L_0x0052;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.SplashWelcomeView.1.run():void");
                        }
                    }, "readWelcomeBg");
                    return;
                }
                return;
            }
            x.i("SplashWelcomeView", "not main process, only load default splash bitmap.");
        } catch (Throwable e2) {
            x.printErrStackTrace("SplashWelcomeView", e2, "%s", e2.getMessage());
        }
    }

    private synchronized void cqT() {
        if (!this.tqw) {
            this.tqw = true;
            if (this.bitmap != null) {
                try {
                    ah.A(new Runnable() {
                        public final void run() {
                            x.d("SplashWelcomeView", "set top imageView");
                            final View imageView = new ImageView(SplashWelcomeView.this.getContext());
                            imageView.setScaleType(ScaleType.CENTER_CROP);
                            imageView.setImageBitmap(SplashWelcomeView.this.bitmap);
                            imageView.setAlpha(0.0f);
                            SplashWelcomeView.this.addView(imageView, new LayoutParams(-1, -1));
                            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(1000);
                            duration.addUpdateListener(new AnimatorUpdateListener() {
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    imageView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                }
                            });
                            duration.start();
                            x.i("SplashWelcomeView", "start play animation");
                        }
                    });
                } catch (Throwable e) {
                    x.printErrStackTrace("SplashWelcomeView", e, "%s", e.getMessage());
                }
            }
        }
        return;
    }

    public final void aRL() {
        x.i("SplashWelcomeView", "hasDrawed:%s", Boolean.valueOf(this.hasDrawed));
        if (!this.hasDrawed) {
            this.hasDrawed = true;
            if (this.tqx && !this.tqw) {
                cqT();
            }
        }
    }
}
