package com.tencent.mm.plugin.bottle.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.ToneGenerator;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.i;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.bottle.a.h.a;
import com.tencent.mm.plugin.bottle.a.h.d;
import com.tencent.mm.plugin.bottle.ui.ThrowBottleAnimUI.1;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.MMEditText;

public class ThrowBottleUI extends FrameLayout implements OnClickListener, a {
    private static final int[] erx = new int[]{R.g.amp_land_1, R.g.amp_land_2, R.g.amp_land_3, R.g.amp_land_4, R.g.amp_land_5, R.g.amp_land_6, R.g.amp_land_7, R.g.amp_land_8, R.g.amp_land_9, R.g.amp_land_10, R.g.amp_land_11};
    private static final int[] hnd = new int[]{0, 9, 18, 27, 37, 46, 55, 64, 74, 85, 93, 100};
    final al erD = new al(new 5(this), true);
    ag handler = new ag();
    BottleBeachUI hlO;
    boolean hmZ = true;
    ImageView hml;
    boolean hnA = false;
    @SuppressLint({"HandlerLeak"})
    private final ag hnB = new 8(this);
    final i.a hnC = new 9(this);
    d hne;
    ToneGenerator hnf;
    private long hng = -1;
    Toast hnh;
    Vibrator hni;
    ThrowBottleAnimUI hnj;
    AnimationDrawable hnk;
    ImageView hnl;
    TextView hnm;
    ImageView hnn;
    MMEditText hno;
    View hnp;
    Button hnq;
    ImageButton hnr;
    ThrowBottleFooter hns;
    boolean hnt = false;
    boolean hnu;
    LayoutParams hnv = null;
    private int hnw = 0;
    int hnx = 0;
    private ThrowBottleAnimUI.a hny = new 4(this);
    final al hnz = new al(new 6(this), true);

    public ThrowBottleUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hlO = (BottleBeachUI) context;
    }

    public void setVisibility(int i) {
        this.hml.setVisibility(8);
        if (i == 0) {
            this.hmZ = true;
            this.hnl.setVisibility(8);
            this.hnm.setVisibility(8);
            this.hnm.setWidth(b.b(this.hlO, 120.0f));
            this.hnn.setVisibility(0);
            ((View) this.hno.getParent()).setVisibility(8);
            this.hno.setText("");
            this.hns.setVisibility(0);
            c.d(this.hno).Gi(com.tencent.mm.k.b.Au()).a(null);
            this.hnr.setImageDrawable(com.tencent.mm.bp.a.f(this.hlO, R.g.chatting_setmode_keyboard_btn));
            this.hnq.setBackgroundDrawable(com.tencent.mm.bp.a.f(this.hlO, R.g.record_shape_normal));
            this.hnq.setText(this.hmZ ? R.l.bottle_throw_voice_btn_text : R.l.bottle_throw_text_btn_text);
            ((LinearLayout) this.hlO.findViewById(R.h.bottle_throw_edit_lo)).setVisibility(0);
            this.hlO.getWindow().clearFlags(1024);
        } else {
            this.hlO.getWindow().setFlags(1024, 1024);
        }
        super.setVisibility(i);
    }

    public void onClick(View view) {
        if (R.h.bottle_attach_btn != view.getId()) {
            this.hlO.nm(0);
        } else if (this.hmZ || this.hno.getText().toString().trim().length() <= 0) {
            auF();
        } else {
            h.a(this.hlO, getResources().getString(R.l.bottle_switch_mode_alert_title), null, getResources().getString(R.l.bottle_switch_mode_continue_text), new 3(this), null);
        }
    }

    private void auF() {
        boolean z;
        int i = 8;
        this.hnm.setVisibility(8);
        this.hnn.setVisibility(this.hmZ ? 8 : 0);
        View view = (View) this.hno.getParent();
        if (this.hmZ) {
            i = 0;
        }
        view.setVisibility(i);
        if (this.hmZ) {
            this.hno.requestFocus();
        }
        if (this.hmZ) {
            z = false;
        } else {
            z = true;
        }
        this.hmZ = z;
        this.hnr.setImageDrawable(this.hmZ ? com.tencent.mm.bp.a.f(this.hlO, R.g.chatting_setmode_keyboard_btn) : com.tencent.mm.bp.a.f(this.hlO, R.g.chatting_setmode_voice_btn));
        if (this.hmZ) {
            dL(false);
        } else {
            dL(true);
        }
        this.hnq = (Button) this.hlO.findViewById(R.h.bottle_throw_btn);
        this.hnq.setText(this.hmZ ? R.l.bottle_throw_voice_btn_text : R.l.bottle_throw_text_btn_text);
    }

    private void auG() {
        int left;
        int top;
        int width;
        if (this.hmZ) {
            left = this.hnm.getLeft();
            top = this.hnm.getTop();
            width = this.hnm.getWidth();
        } else {
            left = this.hno.getLeft();
            width = 0;
            top = this.hno.getTop();
        }
        this.hnj = (ThrowBottleAnimUI) this.hlO.findViewById(R.h.bottle_throw_anim_lo);
        this.hnj.setOnThrowEndListener(this.hny);
        ThrowBottleAnimUI throwBottleAnimUI = this.hnj;
        throwBottleAnimUI.hmZ = this.hmZ;
        throwBottleAnimUI.Om = left;
        throwBottleAnimUI.On = top;
        throwBottleAnimUI.hmX = width;
        throwBottleAnimUI.setVisibility(0);
        ah.i(new 1(throwBottleAnimUI), 100);
    }

    private void dL(boolean z) {
        if (z) {
            ((InputMethodManager) this.hlO.getSystemService("input_method")).showSoftInput(this.hno, 0);
        } else {
            ((InputMethodManager) this.hlO.getSystemService("input_method")).hideSoftInputFromWindow(this.hno.getWindowToken(), 2);
        }
    }

    public final boolean auH() {
        x.d("MM.Bottle.ThrowBottleUI", "bottle record stop");
        if (this.hnA) {
            boolean wk;
            this.hlO.getWindow().getDecorView().setKeepScreenOn(false);
            if (this.hnk != null) {
                this.hnk.stop();
            }
            if (this.hne != null) {
                wk = this.hne.wk();
                af.Wq("keep_app_silent");
                this.erD.SO();
                this.hnz.SO();
                this.hng = -1;
            } else {
                wk = false;
            }
            if (wk) {
                auG();
            } else {
                this.hnq.setEnabled(false);
                this.hnq.setBackgroundDrawable(com.tencent.mm.bp.a.f(this.hlO, R.g.record_shape_disable));
                this.hnl.setVisibility(8);
                this.hnm.setVisibility(8);
                this.hnB.sendEmptyMessageDelayed(0, 500);
                au.HU();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    this.hlO.nl(R.l.bottle_throw_rcd_too_short);
                }
            }
        }
        this.hnA = false;
        return false;
    }

    public final void ci(int i, int i2) {
        if (i2 == -2002) {
            this.hlO.nm(0);
            this.hlO.nl(R.l.bottle_banby_expose);
        }
    }
}
