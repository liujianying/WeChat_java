package com.tencent.mm.plugin.pwdgroup.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMCallBackScrollView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMKeyBoardView;
import com.tencent.mm.plugin.pwdgroup.ui.widget.MMPwdInputView;
import com.tencent.mm.pluginsdk.model.lbs.Location;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMScrollGridView;
import java.util.HashMap;
import java.util.LinkedList;

public class FacingCreateChatRoomAllInOneUI extends MMActivity implements e {
    private a cXs = new a() {
        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "lat:%f lng:%f accuracy:%f", new Object[]{Float.valueOf(f2), Float.valueOf(f), Double.valueOf(d2)});
            if (z) {
                Location location = new Location(f2, f, (int) d2, i, "", "");
                if (!location.ccc()) {
                    FacingCreateChatRoomAllInOneUI.this.lZB = location;
                    FacingCreateChatRoomAllInOneUI.this.lZy = true;
                    FacingCreateChatRoomAllInOneUI.e(FacingCreateChatRoomAllInOneUI.this);
                }
            } else {
                FacingCreateChatRoomAllInOneUI.this.lZy = false;
            }
            return false;
        }
    };
    private ProgressDialog eEX;
    private String eHp;
    private boolean hiW = false;
    private boolean lZA = false;
    private Location lZB;
    private String lZC;
    private MMPwdInputView lZD;
    private View lZE;
    private ProgressBar lZF;
    private TextView lZG;
    private MMKeyBoardView lZH;
    private TextView lZI;
    private boolean lZJ = false;
    private boolean lZK = false;
    private LinkedList<vt> lZL = new LinkedList();
    private HashMap<String, vt> lZM = new HashMap();
    private LinkedList<vt> lZN = new LinkedList();
    private a lZO;
    private View lZP;
    private TextView lZQ;
    private MMScrollGridView lZR;
    private View lZS;
    private View lZT;
    private Button lZU;
    private MMCallBackScrollView lZV;
    private TextView lZW;
    private boolean lZX = false;
    private ah lZY = new ah();
    private al lZZ = new al(new 1(this), false);
    private c lZv;
    private boolean lZw = false;
    private boolean lZx;
    private boolean lZy;
    private boolean lZz;
    private ag mHandler = new 11(this);
    private com.tencent.mm.plugin.pwdgroup.a.a maa;
    private com.tencent.mm.plugin.pwdgroup.a.a mab;
    private int mad;
    private Animation mae;
    private AnimationSet maf;
    private Animation mag;
    public OnMenuItemClickListener mah = new 12(this);
    public MMPwdInputView.a mai = new 13(this);
    private OnClickListener maj = new OnClickListener() {
        public final void onClick(View view) {
            FacingCreateChatRoomAllInOneUI.this.lZJ = false;
            FacingCreateChatRoomAllInOneUI.d(FacingCreateChatRoomAllInOneUI.this);
        }
    };
    public MMKeyBoardView.a mak = new 15(this);
    private al mal = new al(new 17(this), false);

    static /* synthetic */ void a(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        if (facingCreateChatRoomAllInOneUI.hiW || facingCreateChatRoomAllInOneUI.lZB == null) {
            x.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cancel refresh chat room member.");
            return;
        }
        x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[tryDoSearchScene]-----------");
        facingCreateChatRoomAllInOneUI.maa = new com.tencent.mm.plugin.pwdgroup.a.a(0, facingCreateChatRoomAllInOneUI.lZC, facingCreateChatRoomAllInOneUI.eHp, facingCreateChatRoomAllInOneUI.lZB.dRS, facingCreateChatRoomAllInOneUI.lZB.dRT, facingCreateChatRoomAllInOneUI.lZB.accuracy, facingCreateChatRoomAllInOneUI.lZB.bUi, facingCreateChatRoomAllInOneUI.lZB.mac, facingCreateChatRoomAllInOneUI.lZB.bUk);
        au.DF().a(facingCreateChatRoomAllInOneUI.maa, 0);
    }

    static /* synthetic */ void d(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        facingCreateChatRoomAllInOneUI.getString(R.l.app_tip);
        facingCreateChatRoomAllInOneUI.eEX = h.a((Context) facingCreateChatRoomAllInOneUI, facingCreateChatRoomAllInOneUI.getString(R.l.app_waiting), true, new 5(facingCreateChatRoomAllInOneUI));
        facingCreateChatRoomAllInOneUI.bnU();
        au.DF().a(new com.tencent.mm.plugin.pwdgroup.a.a(1, facingCreateChatRoomAllInOneUI.lZC, facingCreateChatRoomAllInOneUI.eHp, facingCreateChatRoomAllInOneUI.lZB.dRS, facingCreateChatRoomAllInOneUI.lZB.dRT, facingCreateChatRoomAllInOneUI.lZB.accuracy, facingCreateChatRoomAllInOneUI.lZB.bUi, facingCreateChatRoomAllInOneUI.lZB.mac, facingCreateChatRoomAllInOneUI.lZB.bUk), 0);
    }

    static /* synthetic */ void e(FacingCreateChatRoomAllInOneUI facingCreateChatRoomAllInOneUI) {
        x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[tryGetChatRoomUser]");
        if (facingCreateChatRoomAllInOneUI.mal != null) {
            facingCreateChatRoomAllInOneUI.mal.SO();
        }
        if (facingCreateChatRoomAllInOneUI.lZy) {
            if (facingCreateChatRoomAllInOneUI.lZx) {
                facingCreateChatRoomAllInOneUI.uQ(a.mas);
            }
            if (facingCreateChatRoomAllInOneUI.lZy && facingCreateChatRoomAllInOneUI.lZx && !facingCreateChatRoomAllInOneUI.lZz) {
                x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "do tryGetChatRoomUser");
                facingCreateChatRoomAllInOneUI.lZz = true;
                facingCreateChatRoomAllInOneUI.lZx = false;
                facingCreateChatRoomAllInOneUI.mab = new com.tencent.mm.plugin.pwdgroup.a.a(0, facingCreateChatRoomAllInOneUI.lZC, "", facingCreateChatRoomAllInOneUI.lZB.dRS, facingCreateChatRoomAllInOneUI.lZB.dRT, facingCreateChatRoomAllInOneUI.lZB.accuracy, facingCreateChatRoomAllInOneUI.lZB.bUi, facingCreateChatRoomAllInOneUI.lZB.mac, facingCreateChatRoomAllInOneUI.lZB.bUk);
                au.DF().a(facingCreateChatRoomAllInOneUI.mab, 0);
                return;
            }
            return;
        }
        x.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "tryGetChatRoomUser location is no ready.");
        facingCreateChatRoomAllInOneUI.uQ(a.mas);
        if (facingCreateChatRoomAllInOneUI.mal != null) {
            facingCreateChatRoomAllInOneUI.mal.J(15000, 15000);
        }
    }

    protected final int getLayoutId() {
        return R.i.facing_create_chatroom_allin;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper checkPermission checkCamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
        if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
            bnS();
        }
    }

    private void bnS() {
        this.lZv = c.OB();
        this.lZv.a(this.cXs, true);
        au.DF().a(653, this);
        getWindow().getDecorView().setSystemUiVisibility(1280);
        initView();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    bnS();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            FacingCreateChatRoomAllInOneUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            FacingCreateChatRoomAllInOneUI.this.finish();
                        }
                    }, new 2(this));
                    return;
                }
            default:
                return;
        }
    }

    protected void onResume() {
        if (this.lZv != null) {
            this.lZv.a(this.cXs, true);
        }
        if (this.lZX) {
            bnT();
        }
        super.onResume();
    }

    protected void onPause() {
        if (this.lZv != null) {
            this.lZv.c(this.cXs);
        }
        if (this.lZX) {
            bnU();
        }
        super.onPause();
    }

    protected void onDestroy() {
        au.DF().b(653, this);
        if (this.lZv != null) {
            this.lZv.c(this.cXs);
        }
        if (!this.lZK) {
            au.DF().cancel(653);
            if (this.lZB != null) {
                this.mab = new com.tencent.mm.plugin.pwdgroup.a.a(2, this.lZC, "", this.lZB.dRS, this.lZB.dRT, this.lZB.accuracy, this.lZB.bUi, this.lZB.mac, this.lZB.bUk);
                au.DF().a(this.mab, 0);
            }
        }
        if (this.lZX) {
            bnU();
        }
        super.onDestroy();
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final void initView() {
        setMMTitle(R.l.find_friends_create_pwdgroup);
        setBackBtn(this.mah);
        lF(getResources().getColor(R.e.transparent));
        this.lZE = findViewById(R.h.facing_loading_container);
        this.lZF = (ProgressBar) findViewById(R.h.facing_loading);
        this.lZG = (TextView) findViewById(R.h.facing_loading_msg);
        this.lZH = (MMKeyBoardView) findViewById(R.h.facing_keyboard);
        this.lZI = (TextView) findViewById(R.h.facing_input_msg);
        this.lZD = (MMPwdInputView) findViewById(R.h.facing_input);
        this.lZD.setOnFinishInputListener(this.mai);
        this.lZD.requestFocus();
        this.lZH.setOnInputDeleteListener(this.mak);
        uQ(a.mar);
        this.lZP = findViewById(R.h.facing_content_container);
        this.lZQ = (TextView) findViewById(R.h.facing_content_msg);
        this.lZR = (MMScrollGridView) findViewById(R.h.facing_content_member);
        this.lZR.setVisibility(4);
        this.lZU = (Button) findViewById(R.h.facing_enter_chatroom);
        this.lZU.setOnClickListener(this.maj);
        this.lZS = findViewById(R.h.facing_enter_container);
        this.lZT = findViewById(R.h.facing_enter_div);
        this.lZQ.setText(R.l.facing_detail_tip);
        this.lZV = (MMCallBackScrollView) findViewById(R.h.facing_scroll);
        this.lZW = (TextView) findViewById(R.h.facing_input_copy);
        this.lZV.setMMOnScrollListener(new 3(this));
        this.lZO = new a(this);
        this.lZR.setAdapter(this.lZO);
        this.lZO.setData(this.lZL);
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (lVar.getType()) {
            case 653:
                com.tencent.mm.plugin.pwdgroup.a.a aVar = (com.tencent.mm.plugin.pwdgroup.a.a) lVar;
                int i3 = aVar.bOa;
                if (i3 == 0) {
                    this.lZz = false;
                    if (this.lZX) {
                        if (this.lZZ != null) {
                            this.lZZ.J(3000, 3000);
                        }
                        if (i == 0 && i2 == 0) {
                            this.lZY.H(new 7(this, aVar.bnR().rbQ));
                            this.eHp = aVar.bnR().rwj;
                            return;
                        }
                        return;
                    } else if (i == 0 && i2 == 0) {
                        uQ(a.mar);
                        this.mad = this.lZI.getHeight();
                        x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "mFacingInputMsgViewHeigth:%d", new Object[]{Integer.valueOf(this.mad)});
                        this.mae = AnimationUtils.loadAnimation(this, R.a.faded_out);
                        this.mag = AnimationUtils.loadAnimation(this, R.a.enter_view_in);
                        this.maf = new AnimationSet(true);
                        this.maf.addAnimation(AnimationUtils.loadAnimation(this, R.a.scroll_view_in));
                        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-this.mad));
                        translateAnimation.setDuration(300);
                        this.maf.addAnimation(translateAnimation);
                        this.mae.setDuration(200);
                        this.maf.setDuration(300);
                        this.mag.setDuration(300);
                        this.mae.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.maf.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.mag.setInterpolator(new AccelerateDecelerateInterpolator());
                        this.maf.setFillAfter(true);
                        translateAnimation.setFillAfter(true);
                        this.maf.setAnimationListener(new 4(this));
                        this.lZD.setVisibility(4);
                        this.lZD.setAnimation(translateAnimation);
                        this.lZH.startAnimation(this.mae);
                        this.lZE.startAnimation(this.mae);
                        this.lZI.startAnimation(this.mae);
                        this.lZS.startAnimation(this.mag);
                        this.lZP.startAnimation(this.maf);
                        this.lZS.setVisibility(4);
                        this.lZH.setVisibility(8);
                        this.lZI.setVisibility(8);
                        this.lZX = true;
                        bnT();
                        return;
                    } else if (i2 == -431) {
                        this.lZw = true;
                        uQ(a.mat);
                        return;
                    } else {
                        this.lZw = true;
                        uQ(a.mau);
                        return;
                    }
                } else if (i3 == 3) {
                    if (i != 0 || i2 != 0) {
                        if (i2 == -431) {
                            uQ(a.mat);
                            this.lZw = true;
                            return;
                        }
                        uQ(a.mau);
                        return;
                    }
                    return;
                } else if (i3 != 1) {
                    aYM();
                    return;
                } else if (i == 0 && i2 == 0) {
                    aYM();
                    x.d("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "ChatRoomName is:%s", new Object[]{aVar.bnR().rvj});
                    this.lZK = true;
                    finish();
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", r0);
                    com.tencent.mm.plugin.pwdgroup.a.ezn.e(intent, this);
                    return;
                } else if (i2 == -432 && !this.lZJ) {
                    this.lZJ = true;
                    this.mHandler.sendEmptyMessageDelayed(10002, 3000);
                    return;
                } else if (i2 == -23) {
                    aYM();
                    zK(getString(R.l.facing_join_group_overmember));
                    if (this.lZZ != null) {
                        this.lZZ.J(3000, 3000);
                        return;
                    }
                    return;
                } else {
                    aYM();
                    com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
                    if (eV != null) {
                        eV.a(this.mController.tml, null, null);
                    } else {
                        zK(getString(R.l.radar_join_group_unknow_error));
                    }
                    if (this.lZZ != null) {
                        this.lZZ.J(3000, 3000);
                        return;
                    }
                    return;
                }
            default:
                x.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "cpan[onSceneEnd] unknow scene type");
                return;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private void he(boolean z) {
        if (this.lZH != null) {
            this.lZH.setKeyBoardEnable(z);
        }
    }

    private void uQ(int i) {
        if (this.lZG != null) {
            switch (10.maq[i - 1]) {
                case 1:
                    he(true);
                    this.lZw = false;
                    this.lZA = false;
                    this.lZF.setVisibility(8);
                    this.lZG.setVisibility(8);
                    return;
                case 2:
                    he(false);
                    this.lZG.setText(R.l.radar_join_group_verify_tip);
                    this.lZF.setVisibility(0);
                    this.lZG.setVisibility(8);
                    return;
                case 3:
                    he(true);
                    this.lZF.setVisibility(8);
                    this.lZG.setVisibility(0);
                    this.lZG.setText(R.l.radar_join_group_simplepwd_error);
                    bnV();
                    return;
                case 4:
                    he(true);
                    this.lZF.setVisibility(8);
                    this.lZG.setVisibility(0);
                    this.lZG.setText(R.l.radar_join_group_unknow_error);
                    bnV();
                    return;
                default:
                    x.w("MicroMsg.Facing.FacingCreateChatRoomAllInONeUI", "unknow statue tip");
                    return;
            }
        }
    }

    private void aYM() {
        if (this.eEX != null && this.eEX.isShowing()) {
            this.eEX.dismiss();
        }
    }

    private void zK(String str) {
        h.a((Context) this, str, "", getString(R.l.app_ok), new 6(this));
    }

    private void bnT() {
        this.hiW = false;
        if (this.lZZ != null) {
            this.lZZ.J(0, 0);
        }
    }

    private void bnU() {
        this.hiW = true;
        if (this.lZZ != null) {
            this.lZZ.SO();
        }
        au.DF().c(this.maa);
    }

    private void bnV() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.a.alpha_out);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.a.alpha_in);
        loadAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        loadAnimation.setAnimationListener(new 8(this, loadAnimation2));
        loadAnimation2.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                if (FacingCreateChatRoomAllInOneUI.this.lZH != null) {
                    FacingCreateChatRoomAllInOneUI.this.lZH.setKeyBoardEnable(true);
                }
            }
        });
        if (this.lZD != null) {
            this.lZD.startAnimation(loadAnimation);
        }
        if (this.lZH != null) {
            this.lZH.setKeyBoardEnable(false);
        }
    }
}
