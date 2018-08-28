package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.z;
import com.tencent.mm.g.c.am;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.chatting.ChatFooterCustom;
import com.tencent.mm.ui.chatting.b.a.a;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.b.b.h;
import com.tencent.mm.ui.chatting.b.b.l;
import com.tencent.mm.ui.chatting.b.b.m;
import com.tencent.mm.ui.chatting.b.b.w;
import com.tencent.mm.ui.chatting.b.b.y;
import com.tencent.mm.ui.chatting.p;
import com.tencent.mm.ui.chatting.u;
import com.tencent.mm.ui.chatting.x;
import com.tencent.mm.ui.widget.snackbar.b;
import com.tencent.wcdb.FileUtils;

@a(cwo = m.class)
public class q extends a implements m {
    protected ChatFooter laA;
    private final d qLx = new 1(this);
    private p tPI;
    protected ChatFooterCustom tPJ;
    private int tPK = 0;
    private u tPL;
    private x tPM;
    private AnimationSet tPN;
    private String tPO = null;
    private int tPP;
    private int tPQ;
    private boolean tPR = false;
    private boolean tPS = false;
    public boolean tPT = false;
    private long tPU = 0;

    public final ChatFooter cvb() {
        return this.laA;
    }

    public final ChatFooterCustom cvc() {
        return this.tPJ;
    }

    private void cvd() {
        if (!this.bAG.tTq.isCurrentActivity) {
            this.bAG.tTs.ctZ();
            if (this.laA != null) {
                ChatFooter chatFooter = this.laA;
                View findViewById = chatFooter.findViewById(R.h.chatting_mode_switcher);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                chatFooter.setSwitchButtonMode(0);
                chatFooter.mHandler.removeMessages(1002);
                if (chatFooter.qLq != null) {
                    chatFooter.qLq.setVisibility(8);
                }
                if (chatFooter.qLr != null) {
                    chatFooter.qLr.setVisibility(8);
                }
                if (chatFooter.qLs != null) {
                    chatFooter.qLs.setVisibility(8);
                }
                if (chatFooter.iZf != null) {
                    chatFooter.iZf.setVisibility(8);
                }
                chatFooter.kXG.setVisibility(8);
                if (chatFooter.iZh != null) {
                    chatFooter.iZh.setVisibility(8);
                }
                if (chatFooter.iZi != null) {
                    chatFooter.iZi.setVisibility(8);
                }
                if (chatFooter.iZg != null) {
                    chatFooter.iZg.setVisibility(8);
                }
                if (chatFooter.qHf != null) {
                    chatFooter.qHf.setVisibility(8);
                    chatFooter.qHi = false;
                    chatFooter.qHf.destroy();
                    if (chatFooter.kXF != null) {
                        chatFooter.kXF.setVisibility(0);
                    }
                }
                if (chatFooter.iZf != null) {
                    chatFooter.iZf.setVisibility(8);
                }
                if (chatFooter.oxv != null) {
                    chatFooter.oxv.setVisibility(8);
                }
                if (chatFooter.oxs != null) {
                    chatFooter.oxs.update();
                }
                if (chatFooter.qLl != null) {
                    chatFooter.qLl.setVisibility(8);
                }
                if (chatFooter.qLo != null) {
                    chatFooter.qLo.setVisibility(8);
                }
                chatFooter.qLk = (AppPanel) chatFooter.findViewById(R.h.chatting_app_panel);
                if (chatFooter.qLk != null) {
                    chatFooter.setAppPanelVisible(8);
                    AppPanel appPanel = chatFooter.qLk;
                    if (appPanel.mMj != null) {
                        appPanel.mMj.setToScreen(0);
                    }
                }
                if (chatFooter.kXH != null) {
                    chatFooter.kXH.destroy();
                    chatFooter.qLo.removeView(chatFooter.kXH);
                    chatFooter.kXH = null;
                }
                chatFooter.ceM();
                ChatFooter chatFooter2 = this.laA;
                chatFooter2.kXF.setText("");
                chatFooter2.kN(false);
                this.laA.qLy.qMA = null;
            }
        }
    }

    public final String cve() {
        return this.tPO;
    }

    public final void cvf() {
        try {
            if (this.laA.ceI()) {
                this.laA.setBottomPanelVisibility(8);
            }
        } catch (Exception e) {
        }
    }

    public final void cvg() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "visibleCustomFooter customFooter is %s", this.tPJ);
        if (this.tPJ != null) {
            this.tPJ.setVisibility(0);
            if (this.laA != null) {
                this.laA.setVisibility(8);
            }
        }
    }

    public final void cvh() {
        if (this.laA != null) {
            this.laA.setVisibility(0);
            if (this.tPJ != null) {
                this.tPJ.setVisibility(8);
            }
        }
    }

    private void cvi() {
        if (this.laA != null) {
            this.laA.setVisibility(8);
        }
        if (this.tPJ != null) {
            this.tPJ.setVisibility(8);
        }
        this.laA.kN(false);
        this.bAG.YC();
    }

    public final void cvj() {
        this.tPN = new AnimationSet(false);
        Animation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.tPN.setInterpolator(new DecelerateInterpolator(1.5f));
        this.tPN.addAnimation(translateAnimation);
        this.tPN.addAnimation(alphaAnimation);
        this.tPN.setDuration(300);
        this.tPN.setFillBefore(true);
        if (this.laA != null) {
            this.laA.startAnimation(this.tPN);
        }
    }

    public final void cvk() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "triggerFooter");
        if (this.laA == null) {
            this.laA = (ChatFooter) this.bAG.findViewById(R.h.nav_footer);
        }
        if (((h) this.bAG.O(h.class)).cuS() || b.aKp()) {
            if (!this.tPR) {
                this.tPP = this.laA.getVisibility();
            }
            this.laA.r(0, -1, false);
            if (this.tPJ == null) {
                this.tPQ = -1;
            } else if (!this.tPR) {
                this.tPQ = this.tPJ.getVisibility();
            }
            cvi();
            this.tPR = true;
            return;
        }
        this.tPR = false;
        if (this.tPP == 8 && this.tPQ == 8) {
            cvi();
        } else if (this.tPP == 0) {
            cvh();
        } else {
            cvg();
        }
    }

    public final boolean Y(ab abVar) {
        boolean cvR = ((w) this.bAG.O(w.class)).cvR();
        boolean cvQ = ((w) this.bAG.O(w.class)).cvQ();
        boolean cuS = ((h) this.bAG.O(h.class)).cuS();
        boolean cva = ((l) this.bAG.O(l.class)).cva();
        if (cvR || cvQ || cuS || cva) {
            cvi();
            return false;
        }
        if (abVar != null && abVar.ckW()) {
            c cVar = (c) this.bAG.O(c.class);
            if (cVar.cuo() != null) {
                com.tencent.mm.ac.d.b bG = cVar.cuo().bG(false);
                if (bG != null) {
                    if (bG.dKT != null) {
                        bG.dKV = "1".equals(bG.dKT.optString("IsHideInputToolbarInMsg"));
                    }
                    if (bG.dKV) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + abVar.field_username + " is hide tool bar");
                        cvi();
                        return false;
                    }
                }
                if (!(bi.oW(abVar.field_username) || bG == null)) {
                    int intExtra = this.bAG.tTq.getIntExtra("key_temp_session_show_type", 0);
                    switch (bG.Mq()) {
                        case 2:
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "bizinfo name=" + abVar.field_username + " is show custom menu");
                            if (this.tPJ == null) {
                                i.a(this.bAG.tTq, R.h.nav_custom_footer_viewstub);
                                this.tPJ = (ChatFooterCustom) this.bAG.findViewById(R.h.nav_footer_custom);
                                this.tPJ.l((ViewGroup) this.bAG.findViewById(R.h.chatting_content));
                            }
                            com.tencent.mm.ac.d.b.c My = bG.My();
                            if (My != null && My.type == 1) {
                                this.laA.setSwitchButtonMode(1);
                                this.laA.setOnFooterSwitchListener(((c) this.bAG.O(c.class)).cuv());
                                cvh();
                                break;
                            }
                            this.laA.setSwitchButtonMode(0);
                            try {
                                if (!s.hb(abVar.field_username)) {
                                    ChatFooterCustom chatFooterCustom = this.tPJ;
                                    if (chatFooterCustom.tHN != null) {
                                        chatFooterCustom.tHN.setVisibility(0);
                                    }
                                    if (chatFooterCustom.tHO != null) {
                                        chatFooterCustom.tHO.ctb();
                                    }
                                    this.tPJ.setTalker(this.bAG.oLT);
                                    this.tPJ.a(this.bAG.tTq, cVar.cuo(), abVar.field_username);
                                    this.tPJ.setOnFooterSwitchListener(this.qLx);
                                    this.tPJ.setOnProcessClickListener(((c) this.bAG.O(c.class)).cuu());
                                    this.laA.setOnFooterSwitchListener(this.qLx);
                                    if (!((com.tencent.mm.ui.chatting.b.b.s) this.bAG.O(com.tencent.mm.ui.chatting.b.b.s.class)).cvJ() || intExtra != 1) {
                                        cvg();
                                        break;
                                    }
                                    cvh();
                                    break;
                                }
                                this.tPM = new x(this.tPJ);
                                this.tPM.crB();
                                cvg();
                                break;
                            } catch (Throwable e) {
                                if (My == null || My.dLC == null || My.dLC.size() == 0) {
                                    cvh();
                                } else {
                                    this.qLx.kS(true);
                                }
                                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.ChattingUI.FootComponent", e, "", new Object[0]);
                                break;
                            }
                            break;
                        default:
                            cvh();
                            String str = "MicroMsg.ChattingUI.FootComponent";
                            String str2 = "bizinfo name=%s, %b, %d";
                            Object[] objArr = new Object[3];
                            objArr[0] = abVar.field_username;
                            if (bG != null) {
                                cva = true;
                            } else {
                                cva = false;
                            }
                            objArr[1] = Boolean.valueOf(cva);
                            objArr[2] = Integer.valueOf(bG.Mq());
                            com.tencent.mm.sdk.platformtools.x.e(str, str2, objArr);
                            break;
                    }
                }
            }
        }
        return true;
    }

    public final void cvl() {
        int i;
        String talkerUserName = this.bAG.getTalkerUserName();
        if (s.hk(talkerUserName) || ab.XO(talkerUserName)) {
            i = 1;
        } else if (s.hB(talkerUserName)) {
            i = 2;
        } else {
            i = this.bAG.tTq.getIntExtra("Chat_Mode", 0);
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", Integer.valueOf(this.tPK), Integer.valueOf(i));
            if (this.tPK != 0) {
                i = this.tPK;
            }
            String value = g.AT().getValue("DefaultMsgType");
            if (this.tPK == 0 && value != null) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.FootComponent", "config def chatmode is %s", value);
                i = bi.getInt(g.AT().getValue("DefaultMsgType"), 0);
            }
            if (i == 0 && com.tencent.mm.l.a.gd(this.bAG.oLT.field_type)) {
                au.HU();
                i = ((Integer) com.tencent.mm.model.c.DT().get(18, Integer.valueOf(0))).intValue();
            }
            if (i == 0) {
                i = 1;
            }
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.FootComponent", "dkcm getChatMode old:%d intent:%d ", Integer.valueOf(this.tPK), Integer.valueOf(i));
        }
        if (i == 2) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this.bAG.tTq.getContext(), "android.permission.RECORD_AUDIO", 80, "", "")), bi.cjd(), this.bAG.tTq.getContext());
            if (com.tencent.mm.pluginsdk.permission.a.a(this.bAG.tTq.getContext(), "android.permission.RECORD_AUDIO", 80, "", "")) {
                this.laA.ag(i, false);
                return;
            }
            return;
        }
        this.laA.ag(i, false);
    }

    public final void setVoiceInputShowCallback(ChatFooter.c cVar) {
        this.laA.setVoiceInputShowCallback(cVar);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (!(i == 217 || this.tPJ == null)) {
                this.tPJ.k(i, intent);
            }
            switch (i) {
                case HardCoderJNI.SCENE_SEND_MSG /*202*/:
                    if (intent == null) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.ChattingUI.FootComponent", "CONTEXT_MENU_WECHAT_GALLERY_IMAGE intent == null");
                        return;
                    }
                    int intExtra = intent.getIntExtra("Chat_Mode", 1);
                    if (this.laA != null) {
                        this.laA.setMode(intExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i == HardCoderJNI.sHCDBDELAY_WRITE || i == HardCoderJNI.SCENE_RECEIVE_MSG || i == HardCoderJNI.SCENE_SEND_PIC_MSG) {
            this.laA.clearFocus();
        }
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = 0;
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr == null || iArr.length <= 0) {
            String str = "MicroMsg.ChattingUI.FootComponent";
            String str2 = "summerper onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = strArr;
            objArr[3] = bi.cjd();
            com.tencent.mm.sdk.platformtools.x.w(str, str2, objArr);
            return;
        }
        int i3;
        switch (i) {
            case 18:
                if (iArr[0] == 0) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "summerper doFooterSightRequest,footerEventImpl[%s], stack[%s]", this.tPI, bi.cjd());
                    if (this.tPI != null) {
                        p pVar = this.tPI;
                        if (!this.laA.qLk.qKn.qLb.value) {
                            i2 = 2;
                        }
                        pVar.EN(i2);
                        return;
                    }
                    return;
                }
                i3 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.permission_camera_request_again_msg : R.l.permission_microphone_request_again_msg;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(i3), this.bAG.tTq.getMMResources().getString(R.l.permission_tips_title), this.bAG.tTq.getMMResources().getString(R.l.jump_to_settings), this.bAG.tTq.getMMResources().getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            q.this.bAG.tTq.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            case 19:
            case 21:
            case 22:
                if (iArr[0] != 0) {
                    i3 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.permission_camera_request_again_msg : R.l.permission_microphone_request_again_msg;
                    if (iArr[0] != 0) {
                        com.tencent.mm.ui.base.h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(i3), this.bAG.tTq.getMMResources().getString(R.l.permission_tips_title), this.bAG.tTq.getMMResources().getString(R.l.jump_to_settings), this.bAG.tTq.getMMResources().getString(R.l.cancel), false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                q.this.bAG.tTq.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            }
                        }, new 5(this));
                        return;
                    }
                    return;
                } else if (i == 19) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuVideoSelected,footerEventImpl[%s], stack[%s]", this.tPI, bi.cjd());
                    if (this.tPI != null) {
                        this.tPI.bnz();
                        return;
                    }
                    return;
                } else if (i == 21) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipRequest,footerEventImpl[%s], stack[%s]", this.tPI, bi.cjd());
                    if (this.tPI != null) {
                        this.tPI.ctp();
                        return;
                    }
                    return;
                } else {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnEnterMultiTalk,footerEventImpl[%s], stack[%s]", this.tPI, bi.cjd());
                    if (this.tPI != null) {
                        this.tPI.ctn();
                        return;
                    }
                    return;
                }
            case 20:
                if (iArr[0] == 0) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "summerper doImageSelectTakePhotoRequest,footerEventImpl[%s], stack[%s]", this.tPI, bi.cjd());
                    if (this.tPI != null) {
                        this.tPI.ctr();
                        return;
                    }
                    return;
                }
                com.tencent.mm.ui.base.h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.permission_camera_request_again_msg), this.bAG.tTq.getMMResources().getString(R.l.permission_tips_title), this.bAG.tTq.getMMResources().getString(R.l.jump_to_settings), this.bAG.tTq.getMMResources().getString(R.l.cancel), false, new 6(this), null);
                return;
            case 81:
                if (iArr[0] == 0) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "summerper doTalkRoomRequest,footerEventImpl[%s], stack[%s]", this.tPI, bi.cjd());
                    if (this.tPI != null) {
                        this.tPI.ctq();
                        return;
                    }
                    return;
                }
                com.tencent.mm.ui.base.h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.permission_location_request_again_msg), this.bAG.tTq.getMMResources().getString(R.l.permission_tips_title), this.bAG.tTq.getMMResources().getString(R.l.jump_to_settings), this.bAG.tTq.getMMResources().getString(R.l.cancel), false, new 7(this), null);
                return;
            case 82:
            case 83:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a(this.bAG.tTq.getContext(), this.bAG.tTq.getMMResources().getString(R.l.permission_microphone_request_again_msg), this.bAG.tTq.getMMResources().getString(R.l.permission_tips_title), this.bAG.tTq.getMMResources().getString(R.l.jump_to_settings), this.bAG.tTq.getMMResources().getString(R.l.cancel), false, new 8(this), null);
                    return;
                } else if (i == 82) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "summerper doVoipMenuAudioSelected,footerEventImpl[%s], stack[%s]", this.tPI, bi.cjd());
                    if (this.tPI != null) {
                        this.tPI.bny();
                        return;
                    }
                    return;
                } else {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "summerper doOnVoipAudioRequest,footerEventImpl[%s], stack[%s]", this.tPI, bi.cjd());
                    if (this.tPI != null) {
                        this.tPI.cto();
                        return;
                    }
                    return;
                }
            default:
                return;
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "chatting onKeyDown, code:%d action:%d", Integer.valueOf(keyEvent.getKeyCode()), Integer.valueOf(keyEvent.getAction()));
        if (keyEvent.getKeyCode() == 4) {
            if (!this.bAG.eaR) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
            } else if (this.bAG.tTq.isSupportNavigationSwipeBack() && this.bAG.tTq.getSwipeBackLayout().ceH()) {
                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI.FootComponent", "ashutest::onKeyDown back ScrollToFinishing");
                z = true;
                if (z) {
                    return super.onKeyDown(i, keyEvent);
                }
                return true;
            } else {
                if (keyEvent.getAction() == 0) {
                    this.tPS = true;
                    this.tPU = System.currentTimeMillis();
                }
                if (keyEvent.getAction() == 1) {
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.FootComponent", "hasBack %B, %d", Boolean.valueOf(this.tPS), Long.valueOf(System.currentTimeMillis() - this.tPU));
                    if (!this.tPS || System.currentTimeMillis() - this.tPU > 30000) {
                        z = true;
                        if (z) {
                            return super.onKeyDown(i, keyEvent);
                        }
                        return true;
                    }
                    this.tPT = true;
                    h hVar = (h) this.bAG.O(h.class);
                    w wVar = (w) this.bAG.O(w.class);
                    if (hVar.cuS()) {
                        if (wVar.cvO()) {
                            wVar.cvN();
                            hVar.cuT();
                        } else {
                            hVar.cuQ();
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        if (this.laA == null || !this.laA.ceI()) {
                            this.bAG.tTq.csV();
                        } else {
                            this.laA.r(2, 23, false);
                        }
                    }
                }
                z = true;
                if (z) {
                    return true;
                }
                return super.onKeyDown(i, keyEvent);
            }
        } else if (keyEvent.getKeyCode() == 67 && !this.bAG.eaR) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown back key fragment not foreground");
        } else if (!this.bAG.eaR) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "onKeyDown fragment not foreground");
        }
        z = false;
        if (z) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void cun() {
        super.cun();
        if (this.laA != null) {
            this.laA.setFooterEventListener(null);
            this.tPI = null;
            this.laA.setSmileyPanelCallback(null);
            this.laA.setSmileyPanelCallback2(null);
        }
        if (this.tPJ != null) {
            this.tPJ.bDr();
            this.tPJ = null;
        }
        cvd();
        if (this.tPJ != null) {
            this.tPJ.csY();
        }
        j.clearCache();
        if (this.laA != null) {
            ChatFooter chatFooter = this.laA;
            if (chatFooter.qLv != null) {
                chatFooter.qLv.qNf = false;
                chatFooter.qLv.hide();
            }
        }
        if (this.bAG.tTq.isCurrentActivity && this.laA != null) {
            this.laA.destroy();
        }
    }

    public final void cpG() {
        this.tPS = false;
        this.tPT = false;
        this.tPU = 0;
        au.HU();
        am Yq = com.tencent.mm.model.c.FW().Yq(this.bAG.getTalkerUserName());
        if (Yq != null) {
            this.tPK = Yq.field_chatmode;
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.FootComponent", "dkcm init old:%d   ", Integer.valueOf(this.tPK));
        String talkerUserName = this.bAG.getTalkerUserName();
        if (this.laA == null) {
            this.laA = (ChatFooter) this.bAG.findViewById(R.h.nav_footer);
        }
        this.laA.setCattingRootLayoutId(R.h.chatting_bg_ll);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "resetFooter customFooter is %s", this.tPJ);
        if (this.tPJ != null) {
            this.tPJ.bDr();
            this.tPJ.setOnFooterSwitchListener(null);
            this.tPJ.setOnProcessClickListener(null);
            this.laA.setOnFooterSwitchListener(null);
            this.tPJ.csY();
        }
        cvi();
        ChatFooter chatFooter = this.laA;
        if (chatFooter.qLn != null) {
            chatFooter.qLn.setVisibility(0);
        }
        boolean cvR = ((w) this.bAG.O(w.class)).cvR();
        boolean cvQ = ((w) this.bAG.O(w.class)).cvQ();
        boolean z;
        if (cvR || cvQ) {
            cvi();
        } else if (s.hi(talkerUserName)) {
            cvi();
            i.a(this.bAG.tTq, R.h.nav_custom_footer_viewstub);
            z = this.tPJ == null;
            this.tPJ = (ChatFooterCustom) this.bAG.findViewById(R.h.nav_footer_custom);
            if (z) {
                this.tPJ.l((ViewGroup) this.bAG.findViewById(R.h.chatting_content));
            }
            this.tPL = new u(this.tPJ);
            u uVar = this.tPL;
            z = e.bxk == 1;
            uVar.tKI.findViewById(R.h.chatting_footer_switch2input).setVisibility(8);
            uVar.irL = (LinearLayout) uVar.tKI.findViewById(R.h.chatting_footer_menu_container);
            uVar.tKI.findViewById(R.h.chatting_footer_menu_arrow).setVisibility(8);
            uVar.irL.setWeightSum(z ? 1.0f : 2.0f);
            uVar.tKJ = (FrameLayout) uVar.irL.getChildAt(0);
            uVar.tKJ.setVisibility(0);
            uVar.tKJ.setOnClickListener(uVar.tKS);
            ((TextView) uVar.tKJ.getChildAt(0).findViewById(R.h.chatting_footer_menu_text)).setText(R.l.chatfooter_compose_mail);
            uVar.tKJ.getChildAt(0).findViewById(R.h.chatting_footer_menu_icon).setVisibility(8);
            uVar.tKJ.getChildAt(1).setVisibility(8);
            int i;
            if (z) {
                for (i = 1; i < 6; i++) {
                    uVar.irL.getChildAt(i).setVisibility(8);
                }
            } else {
                uVar.tKK = (FrameLayout) uVar.irL.getChildAt(1);
                uVar.tKK.setVisibility(0);
                uVar.tKK.setOnClickListener(uVar.tKT);
                uVar.tKL = (TextView) uVar.tKK.getChildAt(0).findViewById(R.h.chatting_footer_menu_text);
                uVar.tKM = (ImageView) uVar.tKK.getChildAt(0).findViewById(R.h.chatting_footer_menu_icon);
                uVar.tKM.setVisibility(0);
                uVar.ctS();
                au.HU();
                uVar.tKO = ((Integer) com.tencent.mm.model.c.DT().get(aa.a.USERINFO_QQMAIL_UNREAD_COUNT_INT, Integer.valueOf(-1))).intValue();
                if (uVar.tKO >= 0) {
                    uVar.ctU();
                } else {
                    uVar.tKL.setText(R.l.chatfooter_mail_without_unread_count);
                }
                uVar.tKK.getChildAt(1).setVisibility(8);
                for (i = 2; i < 6; i++) {
                    uVar.irL.getChildAt(i).setVisibility(8);
                }
                uVar.tKR = g.AU().getMailAppEnterUlAndroid();
                if (bi.oW(uVar.tKR)) {
                    uVar.tKR = "qqmail://folderlist?app=weixin&action=list&uin=$uin$";
                }
                au.HU();
                uVar.tKR = uVar.tKR.replace("$uin$", new o(bi.f((Integer) com.tencent.mm.model.c.DT().get(9, null))).toString());
                uVar.mim = g.AU().AK();
                uVar.tKP = true;
            }
            cvg();
        } else {
            this.tPL = null;
            if (s.hb(talkerUserName)) {
                cvi();
                i.a(this.bAG.tTq, R.h.nav_custom_footer_viewstub);
                z = this.tPJ == null;
                this.tPJ = (ChatFooterCustom) this.bAG.findViewById(R.h.nav_footer_custom);
                if (z) {
                    this.tPJ.l((ViewGroup) this.bAG.findViewById(R.h.chatting_content));
                }
                this.tPM = new x(this.tPJ);
                this.tPM.crB();
                cvg();
            } else {
                this.tPM = null;
                if (!(s.hj(talkerUserName) || s.hb(talkerUserName) || s.hi(talkerUserName))) {
                    s.Hr();
                    if (!s.hJ(talkerUserName)) {
                        AppPanel appPanel;
                        ChatFooter chatFooter2;
                        h hVar;
                        w wVar;
                        cvh();
                        Y(this.bAG.oLT);
                        cvl();
                        this.laA.setUserName(talkerUserName);
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "initFooterPanelMenu %s", talkerUserName);
                        this.laA.cei();
                        if (((h) this.bAG.O(h.class)).cuS()) {
                            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI.FootComponent", "match shake, in show mode, do not open short video recode view");
                            cvQ = false;
                        } else {
                            cvR = ((w) this.bAG.O(w.class)).cvR();
                            cvQ = ((w) this.bAG.O(w.class)).cvQ();
                            if (cvR || cvQ) {
                                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI.FootComponent", "match shake, in search mode, do not open short video recode view");
                                cvQ = false;
                            } else if (ab.XQ(this.bAG.getTalkerUserName()) || ab.gY(this.bAG.getTalkerUserName())) {
                                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI.FootComponent", "match shake, but is Qcontact or Bcontact");
                                cvQ = false;
                            } else {
                                cvQ = !s.hO(this.bAG.getTalkerUserName());
                            }
                        }
                        if (!cvQ) {
                            this.laA.cer();
                        }
                        if (((c) this.bAG.O(c.class)).cur()) {
                            com.tencent.mm.ac.d kH = f.kH(this.bAG.getTalkerUserName());
                            if (kH == null || kH.field_enterpriseFather == null) {
                                cvQ = false;
                            } else {
                                Cursor kB = z.MY().kB(kH.field_enterpriseFather);
                                cvQ = kB != null && kB.getCount() > 0;
                                if (kB != null) {
                                    kB.close();
                                }
                            }
                            if (cvQ) {
                                appPanel = this.laA.qLk;
                                appPanel.qKn.qLe.value = true;
                                appPanel.ceb();
                            }
                        }
                        if (!this.bAG.cwr()) {
                            this.laA.ceD();
                        }
                        if (!(this.bAG.oLT == null || com.tencent.mm.l.a.gd(this.bAG.oLT.field_type) || s.fq(this.bAG.getTalkerUserName()))) {
                            this.laA.cew();
                        }
                        if (ab.gY(talkerUserName)) {
                            this.laA.cet();
                            this.laA.cez();
                            this.laA.ceA();
                            this.laA.ces();
                            this.laA.ceu();
                            this.laA.cey();
                            this.laA.S(true, true);
                            this.laA.cew();
                            this.laA.cex();
                            this.laA.ceE();
                        }
                        if (ab.XQ(talkerUserName)) {
                            this.laA.cet();
                            this.laA.cez();
                            this.laA.ceA();
                            this.laA.ces();
                            this.laA.ceu();
                            this.laA.cey();
                            this.laA.S(true, true);
                            this.laA.cew();
                            this.laA.cex();
                            this.laA.ceE();
                        }
                        if (ab.XO(talkerUserName)) {
                            this.laA.cet();
                            this.laA.cez();
                            this.laA.ceA();
                            this.laA.ces();
                            this.laA.cep();
                            this.laA.ceu();
                            this.laA.cey();
                            this.laA.S(true, true);
                            this.laA.cew();
                            this.laA.cex();
                            this.laA.ceE();
                        }
                        if (s.hu(talkerUserName)) {
                            this.laA.cet();
                            this.laA.cez();
                            this.laA.ceA();
                            this.laA.ceu();
                            this.laA.cey();
                            this.laA.S(true, true);
                            this.laA.cew();
                            this.laA.cex();
                            this.laA.ceE();
                        }
                        if (s.hr(talkerUserName)) {
                            this.laA.cet();
                            this.laA.S(true, true);
                            this.laA.cey();
                            this.laA.ceE();
                        }
                        au.HU();
                        ab Yg = com.tencent.mm.model.c.FR().Yg(talkerUserName);
                        if (Yg != null && Yg.ckW()) {
                            if (((c) this.bAG.O(c.class)).cur()) {
                                this.laA.cet();
                                this.laA.ceA();
                                this.laA.cey();
                                this.laA.S(true, true);
                                this.laA.cew();
                                this.laA.cex();
                                this.laA.cer();
                                this.laA.cev();
                                this.laA.ceq();
                                this.laA.ceC();
                                this.laA.un();
                            } else {
                                this.laA.cet();
                                this.laA.S(true, true);
                                this.laA.ces();
                                this.laA.cey();
                            }
                        }
                        if (s.fq(this.bAG.getTalkerUserName())) {
                            if (g.AT().getInt("MultitalkBlockCaller", 0) == 0) {
                                this.laA.kP(false);
                                if (this.bAG.cwr() || this.bAG.cwq()) {
                                    this.laA.S(true, true);
                                    this.laA.cex();
                                }
                                com.tencent.mm.bg.d.cfH();
                                if (this.bAG.cwq()) {
                                    this.laA.cey();
                                }
                                if (this.bAG.getTalkerUserName().equals(com.tencent.mm.model.q.GF())) {
                                    this.laA.cey();
                                    this.laA.S(true, true);
                                    this.laA.cew();
                                    this.laA.cex();
                                }
                                this.laA.setAppPanelTip(null);
                                if (ab.XR(this.bAG.oLT.field_username)) {
                                    ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.openim.a.b.class)).aD(this.bAG.oLT.field_openImAppid, this.bAG.oLT.field_descWordingId);
                                    int oD = ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.openim.a.b.class)).oD(this.bAG.oLT.field_openImAppid);
                                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "openim showFlag:%d", Integer.valueOf(oD));
                                    if ((oD & 1) == 0) {
                                        this.laA.cep();
                                    }
                                    if ((oD & 2) == 0) {
                                        this.laA.ceq();
                                    }
                                    if ((oD & 4) == 0) {
                                        appPanel = this.laA.qLk;
                                        appPanel.qKn.qKL.value = false;
                                        appPanel.ceb();
                                    }
                                    if ((oD & 8) == 0) {
                                        this.laA.ces();
                                    }
                                    if ((oD & 16) == 0) {
                                        this.laA.cez();
                                    }
                                    if ((oD & 32) == 0) {
                                        this.laA.cet();
                                    }
                                    if ((oD & 64) == 0) {
                                        this.laA.ceE();
                                    }
                                    if ((oD & FileUtils.S_IWUSR) == 0) {
                                        this.laA.ceu();
                                    }
                                    if ((oD & 256) == 0 || (oD & 8192) == 0) {
                                        this.laA.S((oD & 256) == 0, (oD & 8192) == 0);
                                    }
                                    if ((oD & 512) == 0) {
                                        this.laA.cew();
                                        this.laA.cex();
                                    }
                                    if ((oD & 1024) == 0) {
                                        this.laA.qLk.qKy = true;
                                    }
                                    this.laA.setAppPanelTip(((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.openim.a.b.class)).i(this.bAG.oLT.field_openImAppid, "openim_function_tip", com.tencent.mm.openim.a.b.a.eui));
                                }
                                this.laA.kO(com.tencent.mm.bg.d.cfH());
                                chatFooter2 = this.laA;
                                com.tencent.mm.bg.d.cfH();
                                chatFooter2.kQ(com.tencent.mm.al.b.Pz());
                                this.laA.cey();
                                hVar = (h) this.bAG.O(h.class);
                                wVar = (w) this.bAG.O(w.class);
                                if (hVar.cuS()) {
                                    if (wVar.cvO()) {
                                        wVar.cvN();
                                        hVar.cuT();
                                    } else {
                                        hVar.cuQ();
                                    }
                                }
                            }
                        }
                        this.laA.kP(true);
                        this.laA.S(true, true);
                        this.laA.cex();
                        com.tencent.mm.bg.d.cfH();
                        if (this.bAG.cwq()) {
                            this.laA.cey();
                        }
                        if (this.bAG.getTalkerUserName().equals(com.tencent.mm.model.q.GF())) {
                            this.laA.cey();
                            this.laA.S(true, true);
                            this.laA.cew();
                            this.laA.cex();
                        }
                        this.laA.setAppPanelTip(null);
                        if (ab.XR(this.bAG.oLT.field_username)) {
                            ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.openim.a.b.class)).aD(this.bAG.oLT.field_openImAppid, this.bAG.oLT.field_descWordingId);
                            int oD2 = ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.openim.a.b.class)).oD(this.bAG.oLT.field_openImAppid);
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "openim showFlag:%d", Integer.valueOf(oD2));
                            if ((oD2 & 1) == 0) {
                                this.laA.cep();
                            }
                            if ((oD2 & 2) == 0) {
                                this.laA.ceq();
                            }
                            if ((oD2 & 4) == 0) {
                                appPanel = this.laA.qLk;
                                appPanel.qKn.qKL.value = false;
                                appPanel.ceb();
                            }
                            if ((oD2 & 8) == 0) {
                                this.laA.ces();
                            }
                            if ((oD2 & 16) == 0) {
                                this.laA.cez();
                            }
                            if ((oD2 & 32) == 0) {
                                this.laA.cet();
                            }
                            if ((oD2 & 64) == 0) {
                                this.laA.ceE();
                            }
                            if ((oD2 & FileUtils.S_IWUSR) == 0) {
                                this.laA.ceu();
                            }
                            if ((oD2 & 256) == 0 || (oD2 & 8192) == 0) {
                                this.laA.S((oD2 & 256) == 0, (oD2 & 8192) == 0);
                            }
                            if ((oD2 & 512) == 0) {
                                this.laA.cew();
                                this.laA.cex();
                            }
                            if ((oD2 & 1024) == 0) {
                                this.laA.qLk.qKy = true;
                            }
                            this.laA.setAppPanelTip(((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.openim.a.b.class)).i(this.bAG.oLT.field_openImAppid, "openim_function_tip", com.tencent.mm.openim.a.b.a.eui));
                        }
                        this.laA.kO(com.tencent.mm.bg.d.cfH());
                        chatFooter2 = this.laA;
                        com.tencent.mm.bg.d.cfH();
                        if (com.tencent.mm.al.b.Pz()) {
                        }
                        chatFooter2.kQ(com.tencent.mm.al.b.Pz());
                        this.laA.cey();
                        hVar = (h) this.bAG.O(h.class);
                        wVar = (w) this.bAG.O(w.class);
                        if (hVar.cuS()) {
                            if (wVar.cvO()) {
                                wVar.cvN();
                                hVar.cuT();
                            } else {
                                hVar.cuQ();
                            }
                        }
                    }
                }
                cvi();
            }
        }
        cvd();
        this.tPI = new p(this.bAG, this.laA, this.bAG.getTalkerUserName());
        this.tPI.tJg = this.bAG.tTq.getBooleanExtra("key_need_send_video", true).booleanValue();
        this.laA.setFooterEventListener(this.tPI);
        com.tencent.mm.ui.chatting.w wVar2 = new com.tencent.mm.ui.chatting.w(this.bAG.tTq.getContext(), this.bAG.oLT, this.bAG.getTalkerUserName());
        this.laA.setSmileyPanelCallback(wVar2);
        this.laA.setSmileyPanelCallback2(wVar2);
        cvl();
        this.laA.ceB();
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "isTempSession : %s, showType : %d.", Boolean.valueOf(((com.tencent.mm.ui.chatting.b.b.s) this.bAG.O(com.tencent.mm.ui.chatting.b.b.s.class)).cvJ()), Integer.valueOf(this.bAG.tTq.getIntExtra("key_temp_session_show_type", 0)));
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.FootComponent", "is temp session : %s.", Boolean.valueOf(r0.cvJ()));
        if (((com.tencent.mm.ui.chatting.b.b.s) this.bAG.O(com.tencent.mm.ui.chatting.b.b.s.class)).cvJ()) {
            if (r1 == 1) {
                this.qLx.kS(true);
            } else {
                this.qLx.kS(false);
            }
        }
        Y(this.bAG.oLT);
    }

    public final void cpH() {
    }

    public final void cpI() {
        boolean booleanValue;
        this.tPO = this.bAG.tTq.getStringExtra("smiley_product_id");
        if (this.laA.ceN()) {
            ((y) this.bAG.O(y.class)).keepSignalling();
        }
        if (s.hi(this.bAG.getTalkerUserName()) && this.tPL != null && this.tPL.tKP) {
            this.tPL.ctT();
        }
        ChatFooter chatFooter = this.laA;
        com.tencent.mm.ui.chatting.e eVar = this.bAG.tTq;
        chatFooter.qLN = eVar;
        if (!chatFooter.qHi) {
            chatFooter.findViewById(R.h.chatting_foot_bar_group).setVisibility(0);
        }
        chatFooter.a(eVar.getContext(), eVar.thisActivity());
        chatFooter.qMt = true;
        if (!(bi.oW(this.tPO) || this.laA == null)) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.FootComponent", "deal use smiley panel in product: %s", this.tPO);
            this.laA.setDefaultSmileyByDetail(this.tPO);
            this.laA.cem();
        }
        this.bAG.tTq.getContext().getIntent().putExtra("smiley_product_id", "");
        this.laA.setUserName(this.bAG.getTalkerUserName());
        chatFooter = this.laA;
        String cwp = this.bAG.cwp();
        String talkerUserName = this.bAG.getTalkerUserName();
        chatFooter.bSS = cwp;
        chatFooter.toUser = talkerUserName;
        if (this.bAG.tTq.getBooleanExtra("key_show_bottom_app_panel", false).booleanValue()) {
            chatFooter = this.laA;
            if (chatFooter.qLq != null) {
                chatFooter.qLq.performClick();
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChatFooter", "perform click attach bt to show bottom panel");
            }
        }
        if (Y(this.bAG.oLT)) {
            if (this.laA != null) {
                au.HU();
                booleanValue = ((Boolean) com.tencent.mm.model.c.DT().get(66832, Boolean.valueOf(false))).booleanValue();
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.FootComponent", "jacks refresh Footer Plugin Setting , Enable Enter Button: %B", Boolean.valueOf(booleanValue));
                this.laA.ceO();
                if (booleanValue) {
                    this.laA.ceF();
                    this.laA.ceB();
                }
                if (booleanValue) {
                    this.laA.ceq();
                }
                chatFooter = this.laA;
                if (chatFooter.qLk != null) {
                    chatFooter.qLk.cea();
                }
            }
            ((com.tencent.mm.ui.chatting.b.b.ab) this.bAG.O(com.tencent.mm.ui.chatting.b.b.ab.class)).cuW();
            if (this.laA != null) {
                this.laA.qLk.refresh();
                this.laA.addTextChangedListener(new a(this, (byte) 0));
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "addTextChangedListener");
            }
        }
        boolean cvR = ((w) this.bAG.O(w.class)).cvR();
        boolean cvQ = ((w) this.bAG.O(w.class)).cvQ();
        booleanValue = ((h) this.bAG.O(h.class)).cuS();
        if (cvR || cvQ || booleanValue || this.bAG.oLT == null || this.bAG.oLT.ckW() || s.hL(this.bAG.getTalkerUserName()) || b.aKp()) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "no call visibleFooter again.");
            return;
        }
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "call visibleFooter again.");
        cvh();
    }

    public final void cpJ() {
        if (this.laA != null) {
            ChatFooter chatFooter = this.laA;
            if (chatFooter.qLT != null) {
                chatFooter.kXF.removeTextChangedListener(chatFooter.qLT);
                chatFooter.qLT = null;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.ChattingUI.FootComponent", "removeTextChangeListener");
            this.laA.onPause();
            if (com.tencent.mm.kernel.g.Eg().Dx()) {
                au.HU();
                com.tencent.mm.model.c.DT().set(18, Integer.valueOf(this.laA.getMode()));
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.ChattingUI.FootComponent", "dkcm old:%d footer:%d ", Integer.valueOf(this.tPK), Integer.valueOf(this.laA.getMode()));
                if (this.tPK != this.laA.getMode()) {
                    this.tPK = this.laA.getMode();
                    au.HU();
                    ai Yq = com.tencent.mm.model.c.FW().Yq(this.bAG.getTalkerUserName());
                    if (Yq != null && this.bAG.getTalkerUserName().equals(Yq.field_username)) {
                        Yq.eW(this.tPK);
                        au.HU();
                        com.tencent.mm.model.c.FW().a(Yq, this.bAG.getTalkerUserName());
                    }
                }
                this.laA.aMo();
                return;
            }
            com.tencent.mm.sdk.platformtools.x.w("MicroMsg.ChattingUI.FootComponent", "account not ready");
        }
    }

    public final void cpK() {
    }
}
