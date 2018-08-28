package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import android.os.SystemClock;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.app.m;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.LauncherUI.b;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.contact.k;
import com.tencent.mm.ui.conversation.j;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import java.util.HashMap;
import java.util.LinkedList;

@a(3)
@TargetApi(11)
public final class HomeUI implements b, LauncherUI$c, LauncherUI$d {
    public static Boolean tjy = Boolean.valueOf(false);
    public static Boolean tjz = Boolean.valueOf(false);
    private String bVX = null;
    View contentView;
    private boolean eLU = true;
    LayoutInflater eMa;
    private long jEP = 0;
    ActionBar mActionBar;
    boolean mQO = true;
    private int nDh = 0;
    private final long oco = 300;
    private long ocp = SystemClock.elapsedRealtime();
    private View olE;
    MMFragmentActivity tiY;
    private final long tjA = 432000000;
    private final long tjB = 604800000;
    int tjC = a.tjX;
    LauncherUI.a tjD;
    j tjE;
    public z tjF = new z();
    OnLayoutChangeListener tjG = new OnLayoutChangeListener() {
        public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        }
    };
    private boolean tjH = w.chL();
    View tjI;
    ImageView tjJ;
    View tjK;
    MenuItem tjL;
    MenuItem tjM;
    c tjN = new 4(this);
    IdleHandler tjO = new 6(this);
    Runnable tjP = new 7(this);
    private LinkedList<Runnable> tjQ = new LinkedList();
    n tjR = new 18(this);
    private final long tjq = 604800000;
    public boolean tjr = false;
    boolean tjs;
    public boolean tjt = false;
    String tju;
    String tjv;
    String tjw;
    ae tjx;
    private final HashMap<String, Object> values = new HashMap();

    /* renamed from: com.tencent.mm.ui.HomeUI$10 */
    class AnonymousClass10 implements OnClickListener {
        final /* synthetic */ int bpX;

        AnonymousClass10(int i) {
            this.bpX = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            try {
                ao.startSettingItent(HomeUI.this.tiY, this.bpX);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.LauncherUI.HomeUI", e, "", new Object[0]);
            }
        }
    }

    public static class FitSystemWindowLayoutView extends FrameLayout {
        private Rect cO = new Rect();
        private int tkb;
        private ViewGroup tkc = null;

        public FitSystemWindowLayoutView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public FitSystemWindowLayoutView(Context context) {
            super(context);
        }

        public int getCacheInsetsTop() {
            return this.tkb;
        }

        public void setActionBarContainer(ViewGroup viewGroup) {
            this.tkc = viewGroup;
        }

        @TargetApi(14)
        public boolean fitSystemWindows(Rect rect) {
            View childAt;
            boolean fitSystemWindows;
            x.i("MicroMsg.LauncherUI", "ashu::fitSystemWindows beg %s, cacheInsetsTop:%d, hashCode:%d", new Object[]{rect.toString(), Integer.valueOf(this.tkb), Integer.valueOf(hashCode())});
            this.tkb = rect.top;
            if (this.tkc != null && (this.tkc.getLayoutParams() instanceof MarginLayoutParams)) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.tkc.getLayoutParams();
                int i = marginLayoutParams.bottomMargin;
                int i2 = marginLayoutParams.rightMargin;
                x.i("MicroMsg.LauncherUI", "try to setFitSystemWindowsBottomRightPadding: %d %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                int i3 = 0;
                while (i3 < getChildCount()) {
                    childAt = getChildAt(i3);
                    if (childAt instanceof TestTimeForChatting) {
                        TestTimeForChatting testTimeForChatting = (TestTimeForChatting) childAt;
                        if (Float.compare((float) i, ((float) com.tencent.mm.bp.a.fromDPToPix(testTimeForChatting.getContext(), 48)) * 1.5f) > 0 || i < 0) {
                            x.w("MicroMsg.TestTimeForChatting", "ERROR bottom padding %d", new Object[]{Integer.valueOf(i)});
                            testTimeForChatting.uCu = 0;
                        } else {
                            testTimeForChatting.uCu = i;
                        }
                        if (Float.compare((float) i2, ((float) com.tencent.mm.bp.a.fromDPToPix(testTimeForChatting.getContext(), 48)) * 1.5f) > 0 || i2 < 0) {
                            x.w("MicroMsg.TestTimeForChatting", "ERROR right padding %d", new Object[]{Integer.valueOf(i)});
                            testTimeForChatting.uCv = 0;
                        } else {
                            testTimeForChatting.uCv = i2;
                        }
                        x.i("MicroMsg.LauncherUI", "setFitSystemWindowsUseActionBarContainer: %d %d OK", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                        ak.z(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    } else {
                        i3++;
                    }
                }
                ak.z(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            this.cO.set(rect);
            if (d.fR(14)) {
                for (int i4 = 0; i4 < getChildCount(); i4++) {
                    childAt = getChildAt(i4);
                    if (childAt instanceof TestTimeForChatting) {
                        childAt.setFitsSystemWindows(true);
                        fitSystemWindows = ((TestTimeForChatting) childAt).fitSystemWindows(rect);
                        childAt.setFitsSystemWindows(false);
                        break;
                    }
                }
            }
            fitSystemWindows = false;
            x.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows child ret %B, ApiLevel %d", new Object[]{Boolean.valueOf(fitSystemWindows), Integer.valueOf(VERSION.SDK_INT)});
            x.d("MicroMsg.LauncherUI", "ashu::fitSystemWindows super ret %B", new Object[]{Boolean.valueOf(super.fitSystemWindows(this.cO))});
            return super.fitSystemWindows(this.cO);
        }
    }

    static /* synthetic */ void cpD() {
        int ff = com.tencent.mm.bp.a.ff(ad.getContext());
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ad.getContext().getSharedPreferences(ad.chY() + "_font_size_report_time", 4).getLong("font_size_report_time", 0) > 604800000) {
            h.mEJ.h(14239, new Object[]{Integer.valueOf(ff)});
            ad.getContext().getSharedPreferences(ad.chY() + "_font_size_report_time", 4).edit().putLong("font_size_report_time", currentTimeMillis).commit();
            x.i("MicroMsg.LauncherUI.HomeUI", "using font size kvReport logID:%d , usingFontSize: %d", new Object[]{Integer.valueOf(14239), Integer.valueOf(ff)});
        }
    }

    static /* synthetic */ void cpE() {
        if (VERSION.SDK_INT < 18) {
            ad.getContext().startService(new Intent(ad.getContext(), NotifyService.class));
        }
    }

    private void updateTitle() {
        CharSequence charSequence;
        String string = getString(R.l.app_name);
        if (com.tencent.mm.protocal.d.qVQ) {
            if (this.tjH) {
                string = string + getString(R.l.alpha_version_alpha);
            } else {
                string = string + " " + getString(R.l.alpha_version_alpha);
            }
        }
        if (this.tjF.cqA() > 0) {
            if (!this.tjH) {
                string = string + " ";
            }
            charSequence = string + "(" + this.tjF.cqA() + ")";
        } else {
            Object charSequence2 = string;
        }
        TextView textView = (TextView) this.mActionBar.getCustomView().findViewById(16908308);
        if (textView != null) {
            textView.setText(charSequence2);
            textView.setTextSize(0, ((float) com.tencent.mm.bp.a.ae(ad.getContext(), R.f.ActionBarTextSize)) * com.tencent.mm.bp.a.fg(ad.getContext()));
            if (this.mQO) {
                textView.setTextColor(this.tiY.getResources().getColor(R.e.white_text_color));
            }
        }
    }

    final void cpw() {
        if (au.HX()) {
            au.HU();
            Boolean valueOf = Boolean.valueOf(ai.d((Boolean) com.tencent.mm.model.c.DT().get(340227, null)));
            if (!(valueOf.booleanValue() || k.ujy.booleanValue())) {
                tjy = Boolean.valueOf(true);
                ly(true);
            }
            long currentTimeMillis = System.currentTimeMillis();
            au.HU();
            currentTimeMillis -= ai.d((Long) com.tencent.mm.model.c.DT().get(340240, null));
            au.HU();
            Boolean valueOf2 = Boolean.valueOf(ai.d((Boolean) com.tencent.mm.model.c.DT().get(340230, null)));
            au.HU();
            Boolean valueOf3 = Boolean.valueOf(ai.d((Boolean) com.tencent.mm.model.c.DT().get(340228, null)));
            au.HU();
            Boolean valueOf4 = Boolean.valueOf(ai.d((Boolean) com.tencent.mm.model.c.DT().get(340229, null)));
            if (valueOf.booleanValue() && valueOf3.booleanValue() && valueOf4.booleanValue() && !valueOf2.booleanValue() && currentTimeMillis >= 432000000) {
                tjz = Boolean.valueOf(true);
                ly(false);
                return;
            }
            return;
        }
        x.e("MicroMsg.LauncherUI.HomeUI", "mmcore has not ready");
    }

    private void ly(boolean z) {
        if (this.olE != null) {
            x.e("MicroMsg.LauncherUI.HomeUI", "tipsView already shown");
            return;
        }
        this.olE = View.inflate(ad.getContext(), R.i.new_user_tutorial, null);
        TextView textView = (TextView) this.olE.findViewById(R.h.new_user_guide_tips);
        if (z) {
            textView.setText(ad.getContext().getString(R.l.add_friend_here));
        } else {
            textView.setText(ad.getContext().getString(R.l.add_chatroom_here));
        }
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 53);
        this.olE.setBackgroundResource(R.g.ofm_pop_up_bg);
        if (this.contentView != null) {
            ((ViewGroup) this.contentView).addView(this.olE, layoutParams);
            this.olE.startAnimation(AnimationUtils.loadAnimation(ad.getContext(), R.a.shake_y));
            this.olE.setOnClickListener(new 24(this, z));
        }
    }

    /* renamed from: c */
    final void a(Boolean bool, Boolean bool2) {
        if (this.olE != null) {
            this.olE.clearAnimation();
            this.olE.setVisibility(8);
            if (bool.booleanValue()) {
                if (bool2.booleanValue()) {
                    au.HU();
                    com.tencent.mm.model.c.DT().set(340227, Boolean.valueOf(true));
                    h.mEJ.a(232, 0, 1, false);
                    tjy = Boolean.valueOf(false);
                } else {
                    au.HU();
                    com.tencent.mm.model.c.DT().set(340230, Boolean.valueOf(true));
                    h.mEJ.a(232, 5, 1, false);
                    tjz = Boolean.valueOf(false);
                }
            }
            this.olE = null;
        }
    }

    /* renamed from: cpx */
    final void f() {
        if (this.tjx != null && au.HX()) {
            if (this.tjx.isShowing()) {
                this.tjx.dismiss();
            } else {
                this.tjx.dZ();
            }
        }
    }

    final void lz(boolean z) {
        if (this.tjx != null && this.tjI != null) {
            if (au.HX()) {
                int i;
                this.tjx.tpK.lG(z);
                if (this.tjx.tpK.tpD > 0) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    this.tjK.setVisibility(0);
                    return;
                } else {
                    this.tjK.setVisibility(8);
                    return;
                }
            }
            x.w("MicroMsg.LauncherUI.HomeUI", "want update more menu new tips, but mmcore not ready");
        }
    }

    final void cpy() {
        if (((com.tencent.mm.plugin.fts.a.n) g.n(com.tencent.mm.plugin.fts.a.n.class)).isFTSIndexReady()) {
            int i = this.tjF.iUy;
            if (i == 0) {
                ((j) this.tjF.cqx()).B(500, 5);
            }
            Intent putExtra = new Intent().putExtra("from_tab_index", i).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
            Bundle bundle = null;
            if (VERSION.SDK_INT >= 21) {
                bundle = ActivityOptions.makeSceneTransitionAnimation(this.tiY, new Pair[0]).toBundle();
            }
            com.tencent.mm.plugin.fts.a.d.b(this.tiY, ".ui.FTSMainUI", putExtra, bundle);
            return;
        }
        Toast.makeText(ad.getContext(), R.l.search_index_not_ready_toast, 0).show();
    }

    public final String getString(int i) {
        return this.tiY.getString(i);
    }

    public final void cpz() {
        au.Em().cii();
        this.tjF.cqB();
        ah.A(this.tjP);
    }

    public final boolean cpA() {
        return this.tjC == a.tjY;
    }

    public final void a(FitSystemWindowLayoutView fitSystemWindowLayoutView, Rect rect, ViewGroup viewGroup) {
        this.tiY.getWindow().getDecorView().getBottom();
        this.tiY.getSupportActionBar().getCustomView().getBottom();
        fitSystemWindowLayoutView.setActionBarContainer(viewGroup);
        fitSystemWindowLayoutView.fitSystemWindows(rect);
    }

    final void initActionBar() {
        if (this.tjD.cpW()) {
            x.w("MicroMsg.LauncherUI.HomeUI", "[initActionBar] isChattingForeground True!");
            return;
        }
        int i;
        x.w("MicroMsg.LauncherUI.HomeUI", "[initActionBar] isChattingForeground False!");
        this.mActionBar.setLogo(new ColorDrawable(this.tiY.getResources().getColor(17170445)));
        this.mActionBar.da();
        this.mActionBar.setDisplayHomeAsUpEnabled(false);
        this.mActionBar.cZ();
        this.mActionBar.db();
        this.mActionBar.setCustomView(com.tencent.mm.kiss.a.b.EY().a(this.tiY, "R.layout.actionbar_title_launcher", R.i.actionbar_title_launcher));
        ImageView imageView = (ImageView) this.mActionBar.getCustomView().findViewById(R.h.actionbar_up_indicator_btn);
        if (imageView != null && this.mQO) {
            imageView.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
        }
        if (this.mQO) {
            i = R.e.dark_actionbar_color;
        } else {
            i = R.e.normal_actionbar_color;
        }
        this.mActionBar.setBackgroundDrawable(new ColorDrawable(this.tiY.getResources().getColor(i)));
        if (VERSION.SDK_INT >= 21) {
            this.tiY.getWindow().setStatusBarColor(this.tiY.getResources().getColor(i));
            if (VERSION.SDK_INT >= 23) {
                View decorView = this.tiY.getWindow().getDecorView();
                i = decorView.getSystemUiVisibility();
                decorView.setSystemUiVisibility(this.mQO ? i & -8193 : i | 8192);
            }
        }
        updateTitle();
        this.mActionBar.getCustomView().findViewById(R.h.actionbar_title_launcher_container).setOnClickListener(new 8(this));
    }

    public final void setTitleBarDoubleClickListener(Runnable runnable) {
        if (!this.tjQ.contains(runnable)) {
            this.tjQ.add(runnable);
        }
    }

    public final void ac(Runnable runnable) {
        this.tjQ.remove(runnable);
    }

    /* renamed from: coF */
    final void q() {
        this.tiY.moveTaskToBack(true);
        if (au.HX()) {
            au.Em().h(new 13(this), 500);
        }
        m vc = m.vc();
        vc.byZ = false;
        vc.bza.removeMessages(-1999);
        vc.bza.removeMessages(-2999);
        vc.bza.sendEmptyMessageDelayed(-1999, 3000);
        vc.bza.sendEmptyMessageDelayed(-2999, 30000);
    }

    public final void cpB() {
        updateTitle();
    }

    final void g(String str, int i, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        if (bundle != null) {
            intent.putExtra("key_close_action", 1);
            intent.putExtra("key_close_data", bundle);
        }
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
        if (i > 0) {
            com.tencent.mm.bg.d.b(this.tiY, "webview", ".ui.tools.WebViewUI", intent, i);
        } else {
            com.tencent.mm.bg.d.b(this.tiY, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    final void z(String str, int i, String str2) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        intent.putExtra("needRedirect", false);
        if (!ai.oW(str2)) {
            intent.putExtra("key_close_action", 2);
            Bundle bundle = new Bundle();
            bundle.putString("close_jump_url", str2);
            bundle.putInt("close_jump_url_request_code", 777);
            intent.putExtra("key_close_data", bundle);
        }
        intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.qWa);
        intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.qVX);
        if (i > 0) {
            com.tencent.mm.bg.d.b(this.tiY, "webview", ".ui.tools.WebViewUI", intent, i);
        } else {
            com.tencent.mm.bg.d.b(this.tiY, "webview", ".ui.tools.WebViewUI", intent);
        }
    }

    public final void cpC() {
        this.tjF.cpC();
    }
}
