package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.z;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.widget.b;

public final class f {
    private static int b(AppBrandStatObject appBrandStatObject) {
        if (appBrandStatObject == null) {
            return 0;
        }
        return appBrandStatObject.scene;
    }

    public static void a(Activity activity, AppBrandStatObject appBrandStatObject) {
        boolean z = true;
        if (activity != null && activity.getIntent() != null) {
            boolean z2;
            if (b(appBrandStatObject) == 1023) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                activity.overridePendingTransition(a.appbrand_ui_push_open_enter, a.anim_not_change);
                return;
            }
            if (WXMediaMessage.DESCRIPTION_LENGTH_LIMIT == b(appBrandStatObject)) {
                if (6 == (appBrandStatObject == null ? 0 : appBrandStatObject.cbB)) {
                    z2 = true;
                    if (z2) {
                        Intent intent = activity.getIntent();
                        if (intent == null || !intent.getBooleanExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", false)) {
                            z = false;
                        }
                        if (z) {
                            activity.overridePendingTransition(a.appbrand_ui_push_open_enter, a.anim_not_change);
                            return;
                        } else if (1090 == b(appBrandStatObject)) {
                            activity.overridePendingTransition(a.appbrand_ui_switch_enter, a.appbrand_ui_push_enter_exit);
                            return;
                        } else {
                            activity.overridePendingTransition(a.appbrand_ui_push_open_enter, a.appbrand_ui_push_enter_exit);
                            return;
                        }
                    }
                    activity.overridePendingTransition(MMFragmentActivity.a.tnE, MMFragmentActivity.a.tnF);
                }
            }
            z2 = false;
            if (z2) {
                Intent intent2 = activity.getIntent();
                if (intent2 == null || !intent2.getBooleanExtra("key_appbrand_bring_ui_to_front_from_task_Base_by_task_top_ui", false)) {
                    z = false;
                }
                if (z) {
                    activity.overridePendingTransition(a.appbrand_ui_push_open_enter, a.anim_not_change);
                    return;
                } else if (1090 == b(appBrandStatObject)) {
                    activity.overridePendingTransition(a.appbrand_ui_switch_enter, a.appbrand_ui_push_enter_exit);
                    return;
                } else {
                    activity.overridePendingTransition(a.appbrand_ui_push_open_enter, a.appbrand_ui_push_enter_exit);
                    return;
                }
            }
            activity.overridePendingTransition(MMFragmentActivity.a.tnE, MMFragmentActivity.a.tnF);
        }
    }

    public static void a(g gVar, g gVar2, Runnable runnable) {
        if (gVar != null) {
            a(gVar, gVar.aap() ? MMFragmentActivity.a.tnC : a.appbrand_ui_push_open_enter, null);
            if (gVar2 != null) {
                a(gVar2, gVar.aap() ? MMFragmentActivity.a.tnD : a.anim_not_change, runnable);
            }
        }
    }

    public static void a(final g gVar, int i, final Runnable runnable) {
        if (z.ai(gVar.fcA)) {
            Animation loadAnimation = AnimationUtils.loadAnimation(gVar.fcq, i);
            loadAnimation.setAnimationListener(new b() {
                public final void onAnimationEnd(Animation animation) {
                    if (runnable != null) {
                        ah.A(runnable);
                    }
                }

                public final void onAnimationStart(Animation animation) {
                    gVar.fcA.setWillNotDraw(false);
                }
            });
            gVar.fcA.startAnimation(loadAnimation);
            return;
        }
        gVar.fcA.setWillNotDraw(true);
        gVar.fcA.post(new 1(gVar, i, runnable));
    }
}
