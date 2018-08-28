package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.a.o;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.d.m.3;
import com.tencent.mm.plugin.card.model.ag;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;

@a(3)
public class CardGiftAcceptUI extends MMActivity implements OnClickListener, e {
    private final String TAG = "MicroMsg.CardGiftAcceptUI";
    private String bTT;
    private String bYo;
    private int dxI;
    private String dxJ;
    private RelativeLayout hCJ;
    private RelativeLayout hCK;
    private ImageView hCL;
    private TextView hCM;
    private TextView hCN;
    private ImageView hCO;
    private Button hCP;
    private LinearLayout hCQ;
    private TextView hCR;
    private LinearLayout hCS;
    private TextView hCT;
    private ImageView hCU;
    private ImageView hCV;
    private RelativeLayout hCW;
    private ag hCX;
    private q hCY;
    private p tipDialog = null;

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.card.a.e.card_gift_accept_ui_new;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dxJ = getIntent().getStringExtra("key_order_id");
        this.dxI = getIntent().getIntExtra("key_biz_uin", -1);
        this.bYo = getIntent().getStringExtra("key_from_user_name");
        this.bTT = getIntent().getStringExtra("key_chatroom_name");
        x.i("MicroMsg.CardGiftAcceptUI", "onCreate, orderId:%s, bizUin:%s, fromUserName:%s", new Object[]{this.dxJ, Integer.valueOf(this.dxI), this.bYo});
        if (this.dxI == -1) {
            x.e("MicroMsg.CardGiftAcceptUI", "bizUin is -1, fail!");
            d.a(this, "", true);
        } else if (this.dxJ == null) {
            x.e("MicroMsg.CardGiftAcceptUI", "orderId is null, fail");
            d.a(this, "", true);
        } else {
            if (!bi.oW(this.bYo)) {
                h.mEJ.h(13866, new Object[]{Integer.valueOf(1), this.dxJ, o.getString(this.dxI), this.bYo});
            }
            initView();
            g.Eh().dpP.a(1171, this);
            g.Eh().dpP.a(1136, this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        g.Eh().dpP.b(1171, this);
        g.Eh().dpP.b(1136, this);
    }

    protected final void initView() {
        this.hCJ = (RelativeLayout) findViewById(com.tencent.mm.plugin.card.a.d.card_gift_accept_root);
        this.hCK = (RelativeLayout) findViewById(com.tencent.mm.plugin.card.a.d.card_gift_receive_rl);
        this.hCL = (ImageView) findViewById(com.tencent.mm.plugin.card.a.d.card_gift_receive_sender_avatar);
        this.hCM = (TextView) findViewById(com.tencent.mm.plugin.card.a.d.card_gift_receive_sender_nickname);
        this.hCN = (TextView) findViewById(com.tencent.mm.plugin.card.a.d.card_gift_receive_content);
        this.hCO = (ImageView) findViewById(com.tencent.mm.plugin.card.a.d.iv_package_card);
        this.hCP = (Button) findViewById(com.tencent.mm.plugin.card.a.d.card_gift_recieve_open);
        this.hCR = (TextView) findViewById(com.tencent.mm.plugin.card.a.d.card_gift_receive_outOfCardWording);
        this.hCT = (TextView) findViewById(com.tencent.mm.plugin.card.a.d.card_gift_receive_seeOtherWording);
        this.hCW = (RelativeLayout) findViewById(com.tencent.mm.plugin.card.a.d.card_gift_recieve_close_btn);
        this.hCU = (ImageView) findViewById(com.tencent.mm.plugin.card.a.d.card_gift_receive_arrow);
        this.hCV = (ImageView) findViewById(com.tencent.mm.plugin.card.a.d.see_other_arrow);
        this.hCQ = (LinearLayout) findViewById(com.tencent.mm.plugin.card.a.d.out_of_card_wording_layout);
        this.hCS = (LinearLayout) findViewById(com.tencent.mm.plugin.card.a.d.see_other_wording_layout);
        this.hCW.setOnClickListener(this);
        this.hCJ.setOnClickListener(this);
        this.hCK.setOnClickListener(this);
        this.hCQ.setOnClickListener(this);
        this.hCS.setOnClickListener(this);
        this.mController.contentView.setVisibility(8);
        this.tipDialog = com.tencent.mm.ui.base.h.a(this.mController.tml, getString(com.tencent.mm.plugin.card.a.g.loading_tips), true, new 1(this));
        g.Eh().dpP.a(new ag(this.dxI, this.dxJ, this.bTT), 0);
        if (this.tipDialog != null) {
            this.tipDialog.show();
        }
    }

    private static Drawable b(Drawable drawable, ColorStateList colorStateList) {
        Drawable g = android.support.v4.b.a.a.g(drawable);
        android.support.v4.b.a.a.a(g, colorStateList);
        return g;
    }

    private void cj(int i, int i2) {
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setStroke(2, i);
        gradientDrawable.setCornerRadius(6.0f);
        this.hCP.setBackground(gradientDrawable);
    }

    public void onClick(View view) {
        if (view.getId() == com.tencent.mm.plugin.card.a.d.card_gift_recieve_open || view.getId() == com.tencent.mm.plugin.card.a.d.out_of_card_wording_layout) {
            if (this.hCP.getVisibility() == 0) {
                int bc = bi.bc(this.hCX.hxq, getResources().getColor(com.tencent.mm.plugin.card.a.a.card_gift_accept_button_default_border_color));
                cj(bc, bc);
                this.hCP.setTextColor(getResources().getColor(com.tencent.mm.plugin.card.a.a.white));
            }
            ayG();
            if (!bi.oW(this.bYo)) {
                h.mEJ.h(13866, new Object[]{Integer.valueOf(2), this.dxJ, o.getString(this.dxI), this.bYo});
            }
        } else if (view.getId() == com.tencent.mm.plugin.card.a.d.card_gift_recieve_close_btn) {
            finish();
        } else if (view.getId() == com.tencent.mm.plugin.card.a.d.card_gift_accept_root) {
            finish();
        } else if (view.getId() == com.tencent.mm.plugin.card.a.d.see_other_wording_layout) {
            g.Eh().dpP.a(new q(this.dxI, this.dxJ, this.bTT, Boolean.valueOf(true)), 0);
            if (this.tipDialog != null) {
                this.tipDialog.show();
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (i != 0 || i2 != 0) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (lVar instanceof ag) {
                x.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                d.a(this, str, true);
            } else if (lVar instanceof q) {
                x.e("MicroMsg.CardGiftAcceptUI", "NetSceneGetCardGiftInfo onSceneEnd fail, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                d.a(this, str, true);
            }
        } else if (lVar instanceof ag) {
            this.hCX = (ag) lVar;
            x.i("MicroMsg.CardGiftAcceptUI", "ignore:%b", new Object[]{Boolean.valueOf(this.hCX.hxo)});
            if (this.hCX.hxo) {
                x.i("MicroMsg.CardGiftAcceptUI", "NetScenePreAcceptGiftCard ignore is true~so ignore it");
                ayG();
                return;
            }
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            if (this.hCX == null) {
                x.e("MicroMsg.CardGiftAcceptUI", "preAcceptGiftCard is null");
            } else {
                int fromDPToPix;
                MarginLayoutParams marginLayoutParams;
                this.hCN.setText(this.hCX.content);
                this.hCM.setText(j.a(this, this.hCX.bYo, this.hCM.getTextSize()));
                if (this.hCX.status == 0) {
                    if (bi.oW(this.hCX.hxn)) {
                        this.hCP.setVisibility(0);
                        this.hCP.setText(getResources().getString(com.tencent.mm.plugin.card.a.g.card_gift_accepted_title));
                        this.hCP.setOnClickListener(this);
                    } else {
                        this.hCP.setVisibility(0);
                        this.hCP.setText(this.hCX.hxn);
                        this.hCP.setOnClickListener(this);
                    }
                } else if (this.hCX.status == 1 || this.hCX.status != 2) {
                    this.hCP.setVisibility(8);
                    this.hCP.setOnClickListener(null);
                } else if (bi.oW(this.hCX.hxn)) {
                    this.hCP.setVisibility(8);
                    this.hCP.setOnClickListener(null);
                } else {
                    this.hCP.setVisibility(0);
                    this.hCP.setBackgroundDrawable(null);
                    this.hCP.setText(this.hCX.hxn);
                    this.hCP.setTextColor(getResources().getColor(com.tencent.mm.plugin.card.a.a.black));
                    this.hCP.setTextSize(1, 17.0f);
                    this.hCP.setOnClickListener(null);
                }
                if (!bi.oW(this.hCX.hxr)) {
                    this.hCP.setVisibility(8);
                    this.hCS.setVisibility(8);
                    this.hCQ.setVisibility(0);
                    this.hCR.setText(this.hCX.hxr);
                }
                if (!bi.oW(this.hCX.hxs)) {
                    this.hCQ.setVisibility(8);
                    this.hCS.setVisibility(0);
                    this.hCT.setText(this.hCX.hxs);
                }
                if (!bi.oW(this.hCX.hxm)) {
                    fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(this, 15);
                    c.a aVar = new c.a();
                    aVar.dXB = com.tencent.mm.compatible.util.e.bnE;
                    com.tencent.mm.ak.o.Pk();
                    aVar.dXU = null;
                    aVar.dXA = m.xr(this.hCX.hxm);
                    aVar.dXy = true;
                    aVar.dXW = true;
                    aVar.dXX = (float) fromDPToPix;
                    aVar.dXw = true;
                    aVar.dXN = com.tencent.mm.plugin.card.a.c.my_card_package_defaultlogo;
                    com.tencent.mm.ak.o.Pj().a(this.hCX.hxm, this.hCL, aVar.Pt());
                }
                if (!bi.oW(this.hCX.hxp)) {
                    com.tencent.mm.ak.o.Pj().a(this.hCX.hxp, this.hCO);
                }
                if (!bi.oW(this.hCX.hxq) && this.hCP.getVisibility() == 0) {
                    fromDPToPix = bi.bc(this.hCX.hxq, getResources().getColor(com.tencent.mm.plugin.card.a.a.card_gift_accept_button_default_border_color));
                    cj(fromDPToPix, getResources().getColor(com.tencent.mm.plugin.card.a.a.card_gift_accept_button_default_bg_color));
                    this.hCP.setTextColor(fromDPToPix);
                }
                if (!bi.oW(this.hCX.hxq) && this.hCR.getVisibility() == 0) {
                    this.hCR.setTextColor(bi.bc(this.hCX.hxq, getResources().getColor(com.tencent.mm.plugin.card.a.a.card_gift_accept_button_default_border_color)));
                    fromDPToPix = getResources().getColor(com.tencent.mm.plugin.card.a.a.card_gift_accept_button_default_border_color);
                    if (!bi.oW(this.hCX.hxq)) {
                        fromDPToPix = bi.bc(this.hCX.hxq, fromDPToPix);
                    }
                    this.hCU.setImageDrawable(b(this.hCU.getDrawable(), ColorStateList.valueOf(fromDPToPix)));
                }
                if (!bi.oW(this.hCX.hxq) && this.hCT.getVisibility() == 0) {
                    this.hCT.setTextColor(bi.bc(this.hCX.hxq, getResources().getColor(com.tencent.mm.plugin.card.a.a.card_gift_accept_button_default_border_color)));
                    fromDPToPix = getResources().getColor(com.tencent.mm.plugin.card.a.a.card_gift_accept_button_default_border_color);
                    if (!bi.oW(this.hCX.hxq)) {
                        fromDPToPix = bi.bc(this.hCX.hxq, fromDPToPix);
                    }
                    this.hCV.setImageDrawable(b(this.hCV.getDrawable(), ColorStateList.valueOf(fromDPToPix)));
                    marginLayoutParams = (MarginLayoutParams) this.hCP.getLayoutParams();
                    marginLayoutParams.topMargin -= com.tencent.mm.bp.a.fromDPToPix(this, 20);
                    this.hCP.setLayoutParams(marginLayoutParams);
                }
                if (this.hCP.getVisibility() == 0 && this.hCS.getVisibility() == 8) {
                    marginLayoutParams = (MarginLayoutParams) this.hCP.getLayoutParams();
                    marginLayoutParams.bottomMargin += com.tencent.mm.bp.a.fromDPToPix(this, 28);
                    this.hCP.setLayoutParams(marginLayoutParams);
                }
            }
            View view = this.hCK;
            Animation scaleAnimation = new ScaleAnimation(0.0f, 0.96f, 0.0f, 0.96f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300);
            scaleAnimation.setInterpolator(new OvershootInterpolator());
            scaleAnimation.setFillAfter(true);
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.96f, 1.0f, 0.96f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation2.setDuration(100);
            scaleAnimation2.setFillAfter(true);
            scaleAnimation.setAnimationListener(new 3(view, scaleAnimation2));
            if (view != null) {
                view.startAnimation(scaleAnimation);
            }
            this.mController.contentView.setVisibility(0);
        } else if (lVar instanceof q) {
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            x.i("MicroMsg.CardGiftAcceptUI", "accept gift card is success!");
            this.hCY = (q) lVar;
            Intent intent = new Intent(this, CardGiftReceiveUI.class);
            intent.putExtra("key_order_id", this.dxJ);
            intent.putExtra("key_biz_uin", this.dxI);
            intent.putExtra("key_gift_into", this.hCY.hwX);
            intent.putExtra("key_from_group_chat_room", !bi.oW(this.bTT));
            startActivity(intent);
            finish();
        }
    }

    private void ayG() {
        g.Eh().dpP.a(new q(this.dxI, this.dxJ, this.bTT, Boolean.valueOf(false)), 0);
        if (this.tipDialog != null) {
            this.tipDialog.show();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            x.e("MicroMsg.CardGiftAcceptUI", "onKeyDown finishUI");
            if (this.tipDialog != null && this.tipDialog.isShowing()) {
                this.tipDialog.dismiss();
            }
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }
}
