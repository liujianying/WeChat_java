package com.tencent.mm.plugin.shake.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.z;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.plugin.shake.e.c;
import com.tencent.mm.protocal.c.aij;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class TVInfoUI extends MMPreference implements e, a {
    private long bJC;
    private TextView eBO;
    protected ProgressDialog eHw = null;
    protected f eOE;
    private ImageView hEf;
    private boolean mJg = false;
    private boolean mLF = false;
    private c.a nbA;
    private b nbB;
    private String nby = "";
    private TextView nbz;

    static /* synthetic */ void b(TVInfoUI tVInfoUI) {
        if (tVInfoUI.nbA == null) {
            x.w("MicroMsg.TVInfoUI", "shareToFriend, but tv is null");
            return;
        }
        h.mEJ.h(10987, new Object[]{Integer.valueOf(4), "", "", ""});
        String a = c.a(tVInfoUI.mController.tml, tVInfoUI.nbA);
        Intent intent = new Intent();
        intent.putExtra("Retr_Msg_content", a);
        intent.putExtra("Retr_Msg_Type", 2);
        if (tVInfoUI.nbB != null && tVInfoUI.mJg) {
            intent.putExtra("Retr_Msg_thumb_path", tVInfoUI.nbB.Vv());
        }
        intent.putExtra("Retr_go_to_chattingUI", false);
        intent.putExtra("Retr_show_success_tips", true);
        com.tencent.mm.plugin.shake.a.ezn.l(intent, tVInfoUI);
    }

    static /* synthetic */ void b(TVInfoUI tVInfoUI, c.a aVar) {
        if (aVar != null && !bi.oW(aVar.field_thumburl)) {
            tVInfoUI.nbB = new b(aVar);
            tVInfoUI.nby = tVInfoUI.nbB.Vx();
            Bitmap a = y.a(tVInfoUI.nbB);
            x.d("MicroMsg.TVInfoUI", "initHeaderImg photo = %s", new Object[]{a});
            if (a != null) {
                tVInfoUI.hEf.setImageBitmap(a);
                tVInfoUI.mJg = true;
                tVInfoUI.bsG();
                return;
            }
            tVInfoUI.hEf.setImageDrawable(tVInfoUI.getResources().getDrawable(R.k.tv_info_thumb_default));
        }
    }

    static /* synthetic */ void c(TVInfoUI tVInfoUI) {
        if (tVInfoUI.nbA == null) {
            x.w("MicroMsg.TVInfoUI", "shareToTimeLine, but tv is null");
            return;
        }
        h.mEJ.h(10987, new Object[]{Integer.valueOf(3), "", "", ""});
        Intent intent = new Intent();
        if (bi.oW(tVInfoUI.nbA.field_topic)) {
            intent.putExtra("KContentObjDesc", tVInfoUI.nbA.field_subtitle);
        } else {
            intent.putExtra("KContentObjDesc", tVInfoUI.nbA.field_topic);
        }
        intent.putExtra("Ksnsupload_title", tVInfoUI.nbA.field_title);
        intent.putExtra("Ksnsupload_link", tVInfoUI.nbA.field_shareurl);
        intent.putExtra("Ksnsupload_appname", tVInfoUI.getString(R.l.scan_type_tv));
        if (k.buA()) {
            intent.putExtra("Ksnsupload_appid", "wxaf060266bfa9a35c");
        }
        intent.putExtra("Ksnsupload_imgurl", tVInfoUI.nbA.field_thumburl);
        if (tVInfoUI.nbB != null && tVInfoUI.mJg) {
            intent.putExtra("KsnsUpload_imgPath", tVInfoUI.nbB.Vv());
        }
        intent.putExtra("Ksnsupload_type", 5);
        intent.putExtra("KUploadProduct_UserData", c.b(tVInfoUI.nbA));
        String ic = u.ic("shake_tv");
        u.Hx().v(ic, true).p("prePublishId", "shake_tv");
        intent.putExtra("reportSessionId", ic);
        d.b(tVInfoUI, "sns", ".ui.SnsUploadUI", intent);
    }

    static /* synthetic */ void d(TVInfoUI tVInfoUI) {
        if (tVInfoUI.nbA == null) {
            x.w("MicroMsg.TVInfoUI", "do favorite, but tv is null");
            return;
        }
        h.mEJ.h(10987, new Object[]{Integer.valueOf(5), "", "", ""});
        ch chVar = new ch();
        wl wlVar = new wl();
        wr wrVar = new wr();
        wu wuVar = new wu();
        wrVar.Vw(q.GF());
        wrVar.Vx(q.GF());
        wrVar.CO(8);
        wrVar.fU(bi.VF());
        if (k.buA()) {
            wrVar.VC("wxaf060266bfa9a35c");
        }
        wuVar.VF(tVInfoUI.nbA.field_title);
        if (bi.oW(tVInfoUI.nbA.field_topic)) {
            wuVar.VG(tVInfoUI.nbA.field_subtitle);
        } else {
            wuVar.VG(tVInfoUI.nbA.field_topic);
        }
        wuVar.VI(c.b(tVInfoUI.nbA));
        wuVar.VH(tVInfoUI.nbA.field_thumburl);
        chVar.bJF.title = tVInfoUI.nbA.field_title;
        chVar.bJF.desc = tVInfoUI.nbA.field_topic;
        chVar.bJF.bJH = wlVar;
        chVar.bJF.type = 15;
        wlVar.a(wrVar);
        wlVar.b(wuVar);
        chVar.bJF.bJM = 12;
        chVar.bJF.activity = tVInfoUI;
        com.tencent.mm.sdk.b.a.sFg.m(chVar);
    }

    protected final int getLayoutId() {
        return R.i.tv_info;
    }

    public final int Ys() {
        return R.o.tv_info_pref;
    }

    public final int auY() {
        return R.i.tv_info_header_view;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        y.b(this);
        initView();
    }

    protected void onResume() {
        super.onResume();
        au.DF().a(552, this);
    }

    protected void onPause() {
        au.DF().b(552, this);
        super.onPause();
    }

    protected void onDestroy() {
        y.c(this);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.scan_tv_detail_title);
        this.eOE = this.tCL;
        this.eBO = (TextView) findViewById(R.h.tvinfo_title);
        this.nbz = (TextView) findViewById(R.h.tvinfo_topic_tv);
        String stringExtra = getIntent().getStringExtra("key_TV_xml");
        if (bi.oW(stringExtra)) {
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_TV_xml_bytes");
            if (byteArrayExtra != null) {
                stringExtra = new String(byteArrayExtra);
            }
        }
        x.d("MicroMsg.TVInfoUI", "tvinfo xml : %s", new Object[]{stringExtra});
        this.nbA = c.Lk(stringExtra);
        if (this.nbA == null) {
            x.e("MicroMsg.TVInfoUI", "initView(), tv == null");
            finish();
            return;
        }
        a(this.nbA);
    }

    private void a(c.a aVar) {
        if (aVar == null) {
            x.e("MicroMsg.TVInfoUI", "refreshViewByProduct(), pd == null");
            finish();
            return;
        }
        this.eBO.setText(aVar.field_title);
        if (bi.oW(aVar.field_topic)) {
            this.nbz.setVisibility(8);
        } else {
            this.nbz.setText(aVar.field_topic);
        }
        this.hEf = (ImageView) findViewById(R.h.tvinfo_header_img);
        if (!bi.oW(aVar.field_playurl)) {
            ImageView imageView = (ImageView) findViewById(R.h.tvinfo_detail_play_img);
            imageView.setVisibility(0);
            imageView.setOnClickListener(new 1(this, aVar));
            this.hEf.setOnClickListener(new 2(this, aVar));
        }
        addIconOptionMenu(0, R.g.mm_title_btn_menu, new 3(this));
        if (!(bi.oW(aVar.field_id) || this.mLF || getIntent().getBooleanExtra("key_TV_come_from_shake", false))) {
            x.d("MicroMsg.TVInfoUI", "GetTVInfo id[%s], scene[%s]", new Object[]{aVar.field_id, Integer.valueOf(getIntent().getIntExtra("key_TV_getProductInfoScene", 0))});
            au.DF().a(new com.tencent.mm.plugin.shake.d.a.b(aVar.field_id, r0), 0);
            this.mLF = true;
        }
        this.hEf.setVisibility(0);
        setBackBtn(new 4(this));
        x.v("MicroMsg.TVInfoUI", "start postToMainThread initBodyView");
        ah.A(new 5(this, aVar));
    }

    private void bsG() {
        this.bJC = getIntent().getLongExtra("key_TVInfoUI_chatting_msgId", 0);
        if (this.bJC > 0 && au.HX()) {
            au.HU();
            bd dW = com.tencent.mm.model.c.FT().dW(this.bJC);
            if (dW.field_msgId > 0) {
                dW.eq(this.nbB.Vv());
                au.HU();
                com.tencent.mm.model.c.FT().a(this.bJC, dW);
            }
        }
    }

    public final boolean a(f fVar, Preference preference) {
        x.d("MicroMsg.TVInfoUI", "onPreferenceTreeClick item: [%s]", new Object[]{preference.mKey});
        if (this.nbA == null || this.nbA.mNX == null) {
            x.e("MicroMsg.TVInfoUI", "tv == null || tv.actionlist == null");
            return false;
        }
        try {
            int intValue = Integer.valueOf(preference.mKey).intValue();
            int i = intValue / 100;
            int i2 = intValue % 100;
            x.v("MicroMsg.TVInfoUI", "keyId=[%s], ii=[%s], jj=[%s]", new Object[]{Integer.valueOf(intValue), Integer.valueOf(i), Integer.valueOf(i2)});
            if (i < 0 || i >= this.nbA.mNX.size()) {
                x.w("MicroMsg.TVInfoUI", "index out of bounds, ii=[%s], list Size=[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.nbA.mNX.size())});
                return false;
            }
            com.tencent.mm.plugin.shake.e.a aVar = (com.tencent.mm.plugin.shake.e.a) this.nbA.mNX.get(i);
            if (aVar == null) {
                x.w("MicroMsg.TVInfoUI", "actionList == null");
                return false;
            } else if (i2 < 0 || i2 >= aVar.egs.size()) {
                x.w("MicroMsg.TVInfoUI", "index out of bounds, jj=[%s], actions Size=[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(aVar.egs.size())});
                return false;
            } else {
                com.tencent.mm.plugin.shake.e.a.a aVar2 = (com.tencent.mm.plugin.shake.e.a.a) aVar.egs.get(i2);
                if (aVar2 == null) {
                    x.w("MicroMsg.TVInfoUI", "action == null");
                    return false;
                }
                x.v("MicroMsg.TVInfoUI", "action type:" + aVar2.type + ", target:" + aVar2.nbK + ", targetDesc:" + aVar2.nbM + ", targetDesc2:" + aVar2.nbN);
                Intent intent;
                if (aVar2.type == 3) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", aVar2.nbK);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("geta8key_scene", 10);
                    intent.putExtra("srcUsername", aVar2.nbN);
                    com.tencent.mm.plugin.shake.a.ezn.j(intent, this);
                } else if (aVar2.type == 4) {
                    au.HU();
                    ab Yg = com.tencent.mm.model.c.FR().Yg(aVar2.nbK);
                    if (Yg != null) {
                        Intent intent2 = new Intent();
                        if (com.tencent.mm.l.a.gd(Yg.field_type) && Yg.ckW()) {
                            z.MY().kA(aVar2.nbK);
                            if (aVar2.nbM.equals("1")) {
                                intent2.putExtra("Chat_User", aVar2.nbK);
                                intent2.putExtra("finish_direct", true);
                                com.tencent.mm.plugin.shake.a.ezn.e(intent2, (Context) this);
                            }
                        }
                        intent2.putExtra("Contact_User", aVar2.nbK);
                        intent2.putExtra("force_get_contact", true);
                        d.b(this, "profile", ".ui.ContactInfoUI", intent2);
                    }
                } else if (aVar2.type == 5) {
                    gw gwVar = new gw();
                    gwVar.bQd.actionCode = 11;
                    gwVar.bQd.result = aVar2.nbK;
                    gwVar.bQd.context = this;
                    gwVar.bJX = null;
                    com.tencent.mm.sdk.b.a.sFg.a(gwVar, Looper.myLooper());
                } else if (aVar2.type == 6) {
                    intent = new Intent();
                    intent.putExtra("key_product_id", aVar2.nbK);
                    intent.putExtra("key_product_scene", 9);
                    d.b(this, "product", ".ui.MallProductUI", intent);
                }
                return true;
            }
        } catch (Throwable e) {
            x.e("MicroMsg.TVInfoUI", "onPreferenceTreeClick, [%s]", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.TVInfoUI", e, "", new Object[0]);
            return false;
        }
    }

    public final void m(String str, Bitmap bitmap) {
        if (str != null) {
            String str2 = "MicroMsg.TVInfoUI";
            String str3 = "onGetPictureFinish pic, url = [%s], bitmap is null ? [%B]";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(bitmap == null);
            x.d(str2, str3, objArr);
            try {
                ah.A(new 7(this, str, bitmap));
                return;
            } catch (Throwable e) {
                x.e("MicroMsg.TVInfoUI", "onGetPictureFinish : [%s]", new Object[]{e.getLocalizedMessage()});
                x.printErrStackTrace("MicroMsg.TVInfoUI", e, "", new Object[0]);
                return;
            }
        }
        x.e("MicroMsg.TVInfoUI", "onUpdate pic, url  is null ");
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar == null) {
            x.w("MicroMsg.TVInfoUI", "scene == null");
        } else if (lVar.getType() != 552) {
        } else {
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.TVInfoUI", "onSceneEnd() errType = [%s], errCode = [%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                Toast.makeText(this, R.l.scan_tv_get_tvinfo_fail_tips, 0).show();
            } else if (this.nbA == null) {
                x.w("MicroMsg.TVInfoUI", "onSceneEnd tv == null");
            } else {
                com.tencent.mm.plugin.shake.d.a.b bVar = (com.tencent.mm.plugin.shake.d.a.b) lVar;
                aij aij = (bVar.diG == null || bVar.diG.dIE.dIL == null) ? null : (aij) bVar.diG.dIE.dIL;
                if (aij == null) {
                    x.w("MicroMsg.TVInfoUI", "onSceneEnd tvInfo == null");
                } else if (aij.rjF != null) {
                    x.d("MicroMsg.TVInfoUI", "onSceneEnd  tvInfo.DescriptionXML != null, res:" + aij.rjF);
                    c.a Lk = c.Lk(aij.rjF);
                    if (this.nbA != null && this.nbA.field_xml != null && Lk != null && Lk.field_xml != null && !this.nbA.field_xml.equals(Lk.field_xml)) {
                        this.nbA = Lk;
                        a(this.nbA);
                    }
                }
            }
        }
    }
}
