package com.tencent.mm.plugin.game.ui.tab;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.bp.a;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f$a;
import com.tencent.mm.plugin.game.f$b;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.GameTabData;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.s;
import com.tencent.mm.plugin.game.model.v;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMFragmentActivity;

public class GameTabWidget extends LinearLayout {
    public static int kda = 0;
    private a kdb;
    private Activity mActivity;

    static /* synthetic */ void a(GameTabWidget gameTabWidget) {
        int count = gameTabWidget.kdb.getCount();
        if (count != 0) {
            LayoutParams layoutParams = new LinearLayout.LayoutParams(a.fk(gameTabWidget.mActivity) / count, -1);
            for (int i = 0; i < count; i++) {
                View view = gameTabWidget.kdb.getView(i, null, gameTabWidget);
                if (view != null) {
                    view.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            try {
                                GameTabWidget.a(GameTabWidget.this.mActivity, (TabItem) view.getTag(), false, false, false);
                            } catch (Exception e) {
                                x.e("MicroMsg.GameTabWidget", "selectTab err:%s", new Object[]{e.getMessage()});
                            }
                        }
                    });
                    view.setLayoutParams(layoutParams);
                    gameTabWidget.addView(view);
                }
            }
        }
    }

    public GameTabWidget(Context context) {
        super(context);
        co(context);
    }

    public GameTabWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        co(context);
    }

    public GameTabWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        co(context);
    }

    private void co(Context context) {
        this.mActivity = (Activity) context;
        setLayoutParams(new LayoutParams(-1, -2));
        setBackgroundResource(f$b.game_tab_bg);
        setOrientation(0);
    }

    public void setAdapter(a aVar) {
        this.kdb = aVar;
        aVar.registerDataSetObserver(new 1(this));
        aVar.notifyDataSetChanged();
    }

    public static void a(Activity activity, TabItem tabItem, boolean z, boolean z2, boolean z3) {
        if (activity != null && tabItem != null && !c.ao(activity, tabItem.jumpUrl)) {
            String stringExtra = activity.getIntent().getStringExtra("tab_key");
            if (!bi.oV(tabItem.jOl).equals(stringExtra)) {
                boolean z4;
                x.i("MicroMsg.GameTabWidget", "current_page:%s, next_page:%s, hasAnimation:%b", new Object[]{activity.getClass().getSimpleName(), tabItem.jOs, Boolean.valueOf(z)});
                Intent intent = new Intent();
                intent.setClassName(activity, tabItem.jOs);
                Bundle extras = activity.getIntent().getExtras();
                if (extras != null) {
                    intent.putExtras(extras);
                } else {
                    extras = new Bundle();
                }
                Bundle bundle = new Bundle();
                bundle.putString("tab_key", tabItem.jOl);
                GameTabData gameTabData = (GameTabData) extras.getParcelable("tab_data");
                if (gameTabData != null) {
                    boolean z5;
                    TabItem tabItem2 = (TabItem) gameTabData.jOi.get(bi.oV(stringExtra));
                    if (tabItem2 != null) {
                        tabItem2.jOt = true;
                    }
                    tabItem2 = (TabItem) gameTabData.jOi.get(tabItem.jOl);
                    if (tabItem2 != null) {
                        z5 = tabItem2.jOt;
                    } else {
                        z5 = false;
                    }
                    bundle.putParcelable("tab_data", gameTabData);
                    z4 = z5;
                } else {
                    z4 = false;
                }
                if (!z3) {
                    an.a(activity, tabItem.bYq, tabItem.jOu, activity.getIntent().getIntExtra("game_report_from_scene", 0), an.Dx(tabItem.jLt));
                }
                if (!tabItem.jOn) {
                    bundle.putString("rawUrl", tabItem.jumpUrl);
                    bundle.putBoolean("KRightBtn", true);
                    bundle.putBoolean("isWebwx", true);
                    bundle.putBoolean("show_bottom", false);
                    bundle.putString("title", activity.getString(i.game_wechat_game));
                    bundle.putBoolean("forceHideShare", true);
                    bundle.putBoolean("disable_swipe_back", true);
                    bundle.putBoolean("show_native_web_view", true);
                    bundle.putBoolean("disable_progress_bar", true);
                    bundle.putBoolean("disable_bounce_scroll", true);
                    bundle.putInt("screen_orientation", 1);
                    bundle.putString("KPublisherId", "game_center_entrance");
                    bundle.putInt("geta8key_scene", 32);
                    if (!(gameTabData == null || gameTabData.jOj == null)) {
                        bundle.putString("status_bar_style", gameTabData.jOj.jOk);
                        bundle.putInt("customize_status_bar_color", gameTabData.jOj.color);
                    }
                    bundle.putBoolean("game_check_float", z3);
                    stringExtra = bundle.getString("rawUrl");
                    if (!bi.oW(stringExtra)) {
                        if (z3) {
                            boolean booleanExtra = intent.getBooleanExtra("from_find_more_friend", false);
                            int intExtra = intent.getIntExtra("game_report_from_scene", 0);
                            if (booleanExtra) {
                                ((b) g.l(b.class)).aSi();
                                s aTZ = v.aTZ();
                                bundle.putString("rawUrl", o.a(stringExtra, aTZ));
                                if (aTZ != null) {
                                    aTZ.aTW();
                                    if (aTZ.jMI.jNf) {
                                        bundle.putString("game_transparent_float_url", aTZ.jMI.url);
                                    }
                                    bundle.putInt("game_sourceScene", intExtra);
                                }
                            }
                        } else {
                            bundle.remove("game_transparent_float_url");
                            bundle.remove("game_sourceScene");
                        }
                    }
                }
                intent.putExtras(bundle);
                a(activity, intent, z, z2, z4, tabItem.jOn);
            }
        }
    }

    public static void a(Activity activity, Intent intent, boolean z, boolean z2, boolean z3, boolean z4) {
        String str = "MicroMsg.GameTabWidget";
        String str2 = "(%s isActivityExist):%b, hasAnimation:%b, forceFinish:%b, isNative:%b";
        Object[] objArr = new Object[5];
        objArr[0] = intent.getComponent() == null ? "" : intent.getComponent().getClassName();
        objArr[1] = Boolean.valueOf(z3);
        objArr[2] = Boolean.valueOf(z);
        objArr[3] = Boolean.valueOf(z2);
        objArr[4] = Boolean.valueOf(z4);
        x.i(str, str2, objArr);
        str = "MicroMsg.GameTabWidget";
        String str3 = (z3 || z4) ? "straight to jump" : "jump to bridge";
        x.i(str, str3);
        if (!z3 && z4) {
            f.a("com.tencent.mm:tools", null, a.class, null);
        }
        if (z3 || z4) {
            kda = 0;
            intent.addFlags(131072);
            activity.startActivity(intent);
        } else {
            Intent intent2 = new Intent(activity, GameTabBridgeUI.class);
            intent2.putExtras(intent.getExtras());
            intent2.putExtra("next_tab_component", intent.getComponent());
            activity.startActivity(intent2);
        }
        if (!(!z2 || activity.isDestroyed() || activity.isFinishing())) {
            activity.finish();
        }
        if (z) {
            activity.overridePendingTransition(MMFragmentActivity.a.tnC, MMFragmentActivity.a.tnD);
        } else {
            activity.overridePendingTransition(f$a.in_no_slide, f$a.in_no_slide);
        }
    }
}
