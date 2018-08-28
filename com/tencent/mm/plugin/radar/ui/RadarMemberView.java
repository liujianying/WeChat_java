package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.b;
import b.e.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.radar.a;
import com.tencent.mm.plugin.radar.a.f;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.protocal.c.beq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.widget.a.c;

public final class RadarMemberView extends RelativeLayout {
    private static final String TAG = TAG;
    static final /* synthetic */ d[] mkL = new d[]{(d) b.c.b.j.a(new b.c.b.i(b.c.b.j.X(RadarMemberView.class), "avatarHolder", "getAvatarHolder()Landroid/view/View;")), (d) b.c.b.j.a(new b.c.b.i(b.c.b.j.X(RadarMemberView.class), "avatarCopy", "getAvatarCopy()Landroid/widget/ImageView;")), (d) b.c.b.j.a(new b.c.b.i(b.c.b.j.X(RadarMemberView.class), "avatarCopyContainer", "getAvatarCopyContainer()Landroid/view/View;")), (d) b.c.b.j.a(new b.c.b.i(b.c.b.j.X(RadarMemberView.class), "confirmBtn", "getConfirmBtn()Landroid/widget/Button;")), (d) b.c.b.j.a(new b.c.b.i(b.c.b.j.X(RadarMemberView.class), "confirmBtnDisabled", "getConfirmBtnDisabled()Landroid/widget/TextView;")), (d) b.c.b.j.a(new b.c.b.i(b.c.b.j.X(RadarMemberView.class), "memberNameTv", "getMemberNameTv()Landroid/widget/TextView;")), (d) b.c.b.j.a(new b.c.b.i(b.c.b.j.X(RadarMemberView.class), "modifyNameBtn", "getModifyNameBtn()Landroid/widget/Button;")), (d) b.c.b.j.a(new b.c.b.i(b.c.b.j.X(RadarMemberView.class), "sayHiTv", "getSayHiTv()Landroid/widget/TextView;")), (d) b.c.b.j.a(new b.c.b.i(b.c.b.j.X(RadarMemberView.class), "exposeTv", "getExposeTv()Landroid/widget/TextView;"))};
    private static final int mld = 0;
    private static final int mle = 1;
    public static final a mlf = new a((byte) 0);
    private View eIU;
    private c eIW;
    private ab guS;
    private TextView jxy;
    private EditText meN;
    private View mkM;
    private final b mkN = i.D(this, a.c.radar_popup_holder);
    private final b mkO = i.D(this, a.c.radar_avatar_copy_iv);
    private final b mkP = i.D(this, a.c.radar_avatar_container);
    private final b mkQ = i.D(this, a.c.radar_confirm_btn);
    private final b mkR = i.D(this, a.c.radar_confirm_btn_disabled);
    private final b mkS = i.D(this, a.c.radar_member_nickname);
    private final b mkT = i.D(this, a.c.radar_member_modify_name);
    private final b mkU = i.D(this, a.c.radar_say_hi);
    private int[] mkV;
    private final b mkW = i.D(this, a.c.expose_radar_user);
    private boolean mkX;
    private bq mkY;
    private b mkZ;
    private beq mkp;
    private e mkq;
    private final OnClickListener mla = ((OnClickListener) new h(this));
    private final d mlb = new d(this);
    private TextView mlc;

    public static final class i implements AnimationListener {
        final /* synthetic */ RadarMemberView mlg;

        i(RadarMemberView radarMemberView) {
            this.mlg = radarMemberView;
        }

        public final void onAnimationStart(Animation animation) {
            b.c.b.e.i((Object) animation, "animation");
        }

        public final void onAnimationRepeat(Animation animation) {
            b.c.b.e.i((Object) animation, "animation");
        }

        public final void onAnimationEnd(Animation animation) {
            b.c.b.e.i((Object) animation, "animation");
            a aVar = RadarMemberView.mlf;
            x.d(RadarMemberView.TAG, "popup animation end");
            d d = this.mlg.mlb;
            a aVar2 = RadarMemberView.mlf;
            d.sendEmptyMessage(RadarMemberView.mld);
        }
    }

    public static final class j implements TextWatcher {
        final /* synthetic */ RadarMemberView mlg;

        j(RadarMemberView radarMemberView) {
            this.mlg = radarMemberView;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            b.c.b.e.i((Object) charSequence, "s");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            b.c.b.e.i((Object) charSequence, "s");
        }

        public final void afterTextChanged(Editable editable) {
            boolean z = false;
            b.c.b.e.i((Object) editable, "s");
            int length = 50 - editable.length();
            if (length < 0) {
                length = 0;
            }
            TextView f = this.mlg.mlc;
            if (f != null) {
                f.setText(String.valueOf(length));
            }
            c g = this.mlg.eIW;
            if (g != null) {
                Button button = g.getButton(-1);
                if (button != null) {
                    if (editable.length() > 0) {
                        z = true;
                    }
                    button.setEnabled(z);
                }
            }
        }
    }

    static final class l implements DialogInterface.OnClickListener {
        final /* synthetic */ RadarMemberView mlg;

        l(RadarMemberView radarMemberView) {
            this.mlg = radarMemberView;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            c g = this.mlg.eIW;
            if (g != null) {
                g.dismiss();
            }
            this.mlg.eIW = null;
        }
    }

    private final ImageView getAvatarCopy() {
        return (ImageView) this.mkO.getValue();
    }

    private final View getAvatarCopyContainer() {
        return (View) this.mkP.getValue();
    }

    private final View getAvatarHolder() {
        return (View) this.mkN.getValue();
    }

    private final Button getConfirmBtn() {
        return (Button) this.mkQ.getValue();
    }

    private final TextView getConfirmBtnDisabled() {
        return (TextView) this.mkR.getValue();
    }

    private final TextView getExposeTv() {
        return (TextView) this.mkW.getValue();
    }

    private final TextView getMemberNameTv() {
        return (TextView) this.mkS.getValue();
    }

    private final Button getModifyNameBtn() {
        return (Button) this.mkT.getValue();
    }

    private final TextView getSayHiTv() {
        return (TextView) this.mkU.getValue();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ boolean i(com.tencent.mm.plugin.radar.ui.RadarMemberView r9) {
        /*
        r2 = 0;
        r6 = 1;
        r5 = 0;
        r0 = r9.meN;
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        r0 = r5;
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = r9.meN;
        if (r0 == 0) goto L_0x0033;
    L_0x000d:
        r0 = r0.getText();
    L_0x0011:
        r0 = java.lang.String.valueOf(r0);
        r0 = (java.lang.CharSequence) r0;
        r1 = r0.length();
        r4 = r1 + -1;
        r7 = r5;
        r3 = r5;
    L_0x001f:
        if (r3 > r4) goto L_0x0041;
    L_0x0021:
        if (r7 != 0) goto L_0x0035;
    L_0x0023:
        r1 = r3;
    L_0x0024:
        r1 = r0.charAt(r1);
        r8 = 32;
        if (r1 > r8) goto L_0x0037;
    L_0x002c:
        r1 = r6;
    L_0x002d:
        if (r7 != 0) goto L_0x003c;
    L_0x002f:
        if (r1 != 0) goto L_0x0039;
    L_0x0031:
        r7 = r6;
        goto L_0x001f;
    L_0x0033:
        r0 = r2;
        goto L_0x0011;
    L_0x0035:
        r1 = r4;
        goto L_0x0024;
    L_0x0037:
        r1 = r5;
        goto L_0x002d;
    L_0x0039:
        r3 = r3 + 1;
        goto L_0x001f;
    L_0x003c:
        if (r1 == 0) goto L_0x0041;
    L_0x003e:
        r4 = r4 + -1;
        goto L_0x001f;
    L_0x0041:
        r1 = r4 + 1;
        r0 = r0.subSequence(r3, r1);
        r1 = r0.toString();
        r0 = r9.mkp;
        if (r0 == 0) goto L_0x0057;
    L_0x004f:
        r3 = com.tencent.mm.plugin.radar.ui.g.mmr;
        r0 = com.tencent.mm.plugin.radar.ui.g.b(r0);
        if (r0 != 0) goto L_0x0149;
    L_0x0057:
        r0 = "";
        r3 = r0;
    L_0x005b:
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r3);
        if (r0 == 0) goto L_0x0063;
    L_0x0061:
        r0 = r5;
        goto L_0x0008;
    L_0x0063:
        r0 = r9.guS;
        if (r0 == 0) goto L_0x0123;
    L_0x0067:
        r0 = r0.Bx();
        if (r0 != r6) goto L_0x0123;
    L_0x006d:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r3 = "service(IMessengerStorage::class.java)";
        b.c.b.e.h(r0, r3);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r3 = r0.FS();
        r0 = r9.guS;
        if (r0 == 0) goto L_0x0119;
    L_0x0083:
        r0 = r0.getUsername();
    L_0x0087:
        r3 = r3.Hh(r0);
        if (r3 == 0) goto L_0x009e;
    L_0x008d:
        r0 = r3.wR();
        r0 = (java.lang.CharSequence) r0;
        if (r0 == 0) goto L_0x009b;
    L_0x0095:
        r0 = b.f.a.U(r0);
        if (r0 == 0) goto L_0x011c;
    L_0x009b:
        r0 = r6;
    L_0x009c:
        if (r0 == 0) goto L_0x0147;
    L_0x009e:
        r0 = r9.guS;
        if (r0 == 0) goto L_0x011f;
    L_0x00a2:
        r0 = r0.wR();
    L_0x00a6:
        r0 = (java.lang.CharSequence) r0;
        if (r0 == 0) goto L_0x00b0;
    L_0x00aa:
        r0 = b.f.a.U(r0);
        if (r0 == 0) goto L_0x0121;
    L_0x00b0:
        r0 = r6;
    L_0x00b1:
        if (r0 != 0) goto L_0x0147;
    L_0x00b3:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r3 = "service(IMessengerStorage::class.java)";
        b.c.b.e.h(r0, r3);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r0 = r0.FS();
        r3 = r9.guS;
        if (r3 == 0) goto L_0x00cd;
    L_0x00c9:
        r2 = r3.wR();
    L_0x00cd:
        r0 = r0.Hh(r2);
        r2 = r0;
    L_0x00d2:
        if (r2 == 0) goto L_0x00fe;
    L_0x00d4:
        r0 = r2.wR();
        r0 = (java.lang.CharSequence) r0;
        if (r0 == 0) goto L_0x00e2;
    L_0x00dc:
        r0 = b.f.a.U(r0);
        if (r0 == 0) goto L_0x00e3;
    L_0x00e2:
        r5 = r6;
    L_0x00e3:
        if (r5 != 0) goto L_0x00fe;
    L_0x00e5:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r3 = "service(IMessengerStorage::class.java)";
        b.c.b.e.h(r0, r3);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r0 = r0.FS();
        r2 = r2.wR();
        r0.Hi(r2);
    L_0x00fe:
        r0 = r9.guS;
        if (r0 == 0) goto L_0x0105;
    L_0x0102:
        r0.dv(r1);
    L_0x0105:
        r0 = r9.guS;
        com.tencent.mm.model.s.b(r0, r1);
    L_0x010a:
        r2 = r9.getMemberNameTv();
        if (r2 == 0) goto L_0x0116;
    L_0x0110:
        r0 = r1;
        r0 = (java.lang.CharSequence) r0;
        r2.setText(r0);
    L_0x0116:
        r0 = r6;
        goto L_0x0008;
    L_0x0119:
        r0 = r2;
        goto L_0x0087;
    L_0x011c:
        r0 = r5;
        goto L_0x009c;
    L_0x011f:
        r0 = r2;
        goto L_0x00a6;
    L_0x0121:
        r0 = r5;
        goto L_0x00b1;
    L_0x0123:
        r0 = r9.guS;
        if (r0 == 0) goto L_0x012a;
    L_0x0127:
        r0.dv(r1);
    L_0x012a:
        r0 = com.tencent.mm.plugin.messenger.foundation.a.i.class;
        r0 = com.tencent.mm.kernel.g.l(r0);
        r2 = "service(IMessengerStorage::class.java)";
        b.c.b.e.h(r0, r2);
        r0 = (com.tencent.mm.plugin.messenger.foundation.a.i) r0;
        r2 = r0.FS();
        r0 = new com.tencent.mm.storage.bq;
        r0.<init>(r3, r1);
        r0 = (com.tencent.mm.sdk.e.c) r0;
        r2.a(r0);
        goto L_0x010a;
    L_0x0147:
        r2 = r3;
        goto L_0x00d2;
    L_0x0149:
        r3 = r0;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.radar.ui.RadarMemberView.i(com.tencent.mm.plugin.radar.ui.RadarMemberView):boolean");
    }

    public final e getState() {
        return this.mkq;
    }

    public final void setState(e eVar) {
        this.mkq = eVar;
    }

    public final beq getMember() {
        return this.mkp;
    }

    public final void setMember(beq beq) {
        this.mkp = beq;
    }

    public final boolean isShowing() {
        return getVisibility() == 0;
    }

    public RadarMemberView(Context context, AttributeSet attributeSet) {
        b.c.b.e.i((Object) context, "context");
        b.c.b.e.i((Object) attributeSet, "attrs");
        super(context, attributeSet);
    }

    public RadarMemberView(Context context, AttributeSet attributeSet, int i) {
        b.c.b.e.i((Object) context, "context");
        b.c.b.e.i((Object) attributeSet, "attrs");
        super(context, attributeSet, i);
    }

    public final void c(String str, e eVar) {
        Object obj = null;
        b.c.b.e.i((Object) str, "username");
        b.c.b.e.i((Object) eVar, "state");
        if (isShowing() && !this.mkX) {
            Object obj2;
            beq beq = this.mkp;
            if (beq != null) {
                obj2 = beq.ryZ;
            } else {
                obj2 = null;
            }
            if (!b.c.b.e.i((Object) str, obj2)) {
                beq = this.mkp;
                if (beq != null) {
                    obj = beq.hbL;
                }
                if (!b.c.b.e.i((Object) str, obj)) {
                    return;
                }
            }
            a(eVar);
        }
    }

    private final void a(e eVar) {
        getExposeTv().setVisibility(0);
        if (eVar != null) {
            switch (c.mkC[eVar.ordinal()]) {
                case 1:
                    getMemberNameTv().setVisibility(0);
                    getModifyNameBtn().setVisibility(0);
                    getConfirmBtn().setText(f.radar_send_verify);
                    getConfirmBtn().setVisibility(0);
                    getConfirmBtnDisabled().setVisibility(8);
                    getSayHiTv().setVisibility(8);
                    return;
                case 2:
                    getMemberNameTv().setVisibility(0);
                    getModifyNameBtn().setVisibility(0);
                    getConfirmBtnDisabled().setText(f.radar_waiting_for_verify);
                    getConfirmBtn().setVisibility(8);
                    getConfirmBtnDisabled().setVisibility(0);
                    getSayHiTv().setVisibility(8);
                    return;
                case 3:
                    getMemberNameTv().setVisibility(0);
                    getModifyNameBtn().setVisibility(0);
                    getConfirmBtnDisabled().setText(f.radar_already_added);
                    getConfirmBtn().setVisibility(8);
                    getConfirmBtnDisabled().setVisibility(0);
                    getSayHiTv().setVisibility(8);
                    return;
                case 4:
                    getMemberNameTv().setVisibility(0);
                    getModifyNameBtn().setVisibility(0);
                    getConfirmBtn().setText(f.radar_add_friend);
                    getConfirmBtn().setVisibility(0);
                    getConfirmBtnDisabled().setVisibility(8);
                    getSayHiTv().setText(getContext().getString(f.radar_say_hi));
                    getSayHiTv().setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public final void setListener(b bVar) {
        b.c.b.e.i((Object) bVar, "listener");
        this.mkZ = bVar;
    }

    public final void a(View view, beq beq, e eVar) {
        com.tencent.mm.kernel.c.a l;
        String wN;
        b.c.b.e.i((Object) view, "view");
        b.c.b.e.i((Object) beq, "member");
        x.d(TAG, "popup");
        this.mkq = eVar;
        this.mkp = beq;
        Button confirmBtn = getConfirmBtn();
        if (confirmBtn != null) {
            confirmBtn.setOnClickListener((OnClickListener) new e(this, beq));
        }
        getModifyNameBtn().setOnClickListener(this.mla);
        setOnTouchListener((OnTouchListener) new f(this));
        getExposeTv().setOnClickListener((OnClickListener) new g(this));
        g gVar = g.mmr;
        String b = g.b(beq);
        if (!b.f.a.U(b)) {
            l = g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class);
            b.c.b.e.h(l, "service(IMessengerStorage::class.java)");
            this.guS = ((com.tencent.mm.plugin.messenger.foundation.a.i) l).FR().Yg(b);
        }
        ab abVar = this.guS;
        if (abVar == null || !abVar.Bx()) {
            l = g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class);
            b.c.b.e.h(l, "service(IMessengerStorage::class.java)");
            this.mkY = ((com.tencent.mm.plugin.messenger.foundation.a.i) l).FS().Hh(b);
            bq bqVar = this.mkY;
            wN = bqVar != null ? bqVar.wN() : null;
        } else {
            abVar = this.guS;
            wN = abVar != null ? abVar.wN() : null;
        }
        TextView memberNameTv = getMemberNameTv();
        CharSequence a = (this.guS == null || bi.oW(wN)) ? com.tencent.mm.pluginsdk.ui.d.j.a(getContext(), beq.hcS, getMemberNameTv().getTextSize()) : com.tencent.mm.pluginsdk.ui.d.j.a(getContext(), wN, getMemberNameTv().getTextSize());
        memberNameTv.setText(a);
        getMemberNameTv().setVisibility(4);
        getModifyNameBtn().setVisibility(4);
        reset();
        this.mkM = view;
        View view2 = this.mkM;
        if (view2 == null) {
            b.c.b.e.cJM();
        }
        view2 = view2.findViewById(a.c.radar_result_item_avatar_iv);
        b.c.b.e.h(view2, "avatarItem!!.findViewByI…ar_result_item_avatar_iv)");
        ImageView imageView = (ImageView) view2;
        View view3 = this.mkM;
        if (view3 == null) {
            b.c.b.e.cJM();
        }
        view3 = view3.findViewById(a.c.radar_avatar_container);
        b.c.b.e.h(view3, "avatarItem!!.findViewByI…d.radar_avatar_container)");
        View view4 = this.mkM;
        if (view4 == null) {
            b.c.b.e.cJM();
        }
        view4.setVisibility(4);
        getAvatarCopy().setImageDrawable(imageView.getDrawable());
        getAvatarCopyContainer().setVisibility(0);
        int[] iArr = new int[2];
        view3.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        getAvatarHolder().getLocationInWindow(iArr2);
        this.mkV = iArr2;
        setVisibility(0);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(1);
        animationSet.setDuration(500);
        float height = ((float) getAvatarHolder().getHeight()) / ((float) view3.getHeight());
        TranslateAnimation translateAnimation = new TranslateAnimation((float) iArr[0], ((float) iArr2[0]) - (((float) ((view3.getWidth() - view3.getHeight()) / 2)) * height), (float) iArr[1], (float) iArr2[1]);
        animationSet.addAnimation(new ScaleAnimation(1.0f, height, 1.0f, height));
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new i(this));
        getAvatarCopyContainer().startAnimation(animationSet);
    }

    public final void dismiss() {
        x.d(TAG, "dismiss");
        if (!this.mkX) {
            this.mkX = true;
            View view = this.mkM;
            if (view == null) {
                b.c.b.e.cJM();
            }
            view = view.findViewById(a.c.radar_avatar_container);
            b.c.b.e.h(view, "avatarItem!!.findViewByI…d.radar_avatar_container)");
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.setFillAfter(true);
            animationSet.setRepeatCount(1);
            animationSet.setDuration(500);
            int[] iArr = this.mkV;
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr2);
            float height = ((float) getAvatarHolder().getHeight()) / ((float) view.getHeight());
            float width = ((float) ((view.getWidth() - view.getHeight()) / 2)) * height;
            if (iArr == null) {
                b.c.b.e.cJM();
            }
            TranslateAnimation translateAnimation = new TranslateAnimation(((float) iArr[0]) - width, (float) iArr2[0], (float) iArr[1], (float) iArr2[1]);
            animationSet.addAnimation(new ScaleAnimation(height, 1.0f, height, 1.0f));
            animationSet.addAnimation(translateAnimation);
            animationSet.setAnimationListener((AnimationListener) new c(this));
            getMemberNameTv().setVisibility(4);
            getModifyNameBtn().setVisibility(4);
            getConfirmBtn().setVisibility(8);
            getConfirmBtnDisabled().setVisibility(8);
            getSayHiTv().setVisibility(8);
            getExposeTv().setVisibility(8);
            getAvatarCopyContainer().startAnimation(animationSet);
        }
    }

    private final void reset() {
        getAvatarCopyContainer().setVisibility(8);
        getMemberNameTv().setVisibility(4);
        getModifyNameBtn().setVisibility(4);
        getConfirmBtn().setVisibility(8);
        getConfirmBtnDisabled().setVisibility(8);
        getSayHiTv().setVisibility(8);
        getExposeTv().setVisibility(8);
    }
}
