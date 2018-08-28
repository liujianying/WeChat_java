package com.tencent.mm.ui.bizchat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.a.c;
import com.tencent.mm.ac.a.d.a;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.a.u;
import com.tencent.mm.ac.n;
import com.tencent.mm.ac.z;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.sh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.i;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.preference.SignaturePreference;
import com.tencent.mm.protocal.c.hs;
import com.tencent.mm.protocal.c.hu;
import com.tencent.mm.protocal.c.hv;
import com.tencent.mm.protocal.c.ql;
import com.tencent.mm.protocal.c.qm;
import com.tencent.mm.protocal.c.xr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class BizChatroomInfoUI extends MMPreference implements e, n {
    private static boolean hLS = false;
    private SharedPreferences duR = null;
    private ProgressDialog eHw = null;
    private f eOE;
    private int fromScene;
    private boolean hEj;
    private d hLH = new d(new OnScrollListener() {
        public final void onScrollStateChanged(AbsListView absListView, int i) {
            o.Pj().br(i);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    boolean hLI = false;
    private SignaturePreference hLl;
    private ContactListExpandPreference hLp;
    private CheckBoxPreference hLq;
    private CheckBoxPreference hLr;
    private CheckBoxPreference hLs;
    private boolean hLy = false;
    private int hLz;
    private long hpD;
    private String hpJ;
    private boolean isDeleteCancel = false;
    private j lVG = null;
    private c tDV = null;
    private a tEA = new 3(this);
    private boolean tFA;
    private int tFB;
    private j tFC = null;
    private String tFx;
    private boolean tFy = false;
    private boolean tFz;

    static /* synthetic */ boolean a(BizChatroomInfoUI bizChatroomInfoUI, String str, CharSequence charSequence) {
        String trim = charSequence == null ? "" : charSequence.toString().trim();
        if (trim.equals(str)) {
            x.d("MicroMsg.BizChatroomInfoUI", "same room name return");
            return true;
        } else if (trim.length() == 0) {
            h.bA(bizChatroomInfoUI.mController.tml, bizChatroomInfoUI.getString(R.l.room_chartting_room_null_len_tip));
            return false;
        } else {
            com.tencent.mm.sdk.b.a.sFg.m(new sh());
            bizChatroomInfoUI.tFx = bizChatroomInfoUI.tDV.field_chatName;
            bizChatroomInfoUI.tFB = bizChatroomInfoUI.tDV.field_bitFlag;
            bizChatroomInfoUI.tDV.field_chatName = trim;
            z.Na().b(bizChatroomInfoUI.tDV);
            hs hsVar = new hs();
            hsVar.riE = bizChatroomInfoUI.tDV.field_bizChatServId;
            hsVar.name = trim;
            hsVar.riG = bizChatroomInfoUI.tFB;
            z.Ng();
            com.tencent.mm.ac.a.h.a(bizChatroomInfoUI.tDV.field_brandUserName, hsVar, bizChatroomInfoUI);
            bizChatroomInfoUI.aAG();
            bizChatroomInfoUI.eOE.notifyDataSetChanged();
            return true;
        }
    }

    static /* synthetic */ void c(BizChatroomInfoUI bizChatroomInfoUI) {
        Intent intent = new Intent();
        if (bizChatroomInfoUI.tFy) {
            if (bi.oW(bizChatroomInfoUI.tDV.field_addMemberUrl)) {
                x.w("MicroMsg.BizChatroomInfoUI", "dealAddMemberBtn: addMemberUrl is null");
                Toast.makeText(bizChatroomInfoUI, bizChatroomInfoUI.getString(R.l.bizchat_new_chat_fail), 0).show();
                return;
            }
            intent.putExtra("rawUrl", bizChatroomInfoUI.tDV.field_addMemberUrl);
        } else if (bizChatroomInfoUI.lVG == null || bi.oW(bizChatroomInfoUI.lVG.field_addMemberUrl)) {
            x.w("MicroMsg.BizChatroomInfoUI", "dealAddMemberBtn: addMemberUrl is null");
            Toast.makeText(bizChatroomInfoUI, bizChatroomInfoUI.getString(R.l.bizchat_new_chat_fail), 0).show();
            return;
        } else {
            intent.putExtra("rawUrl", bizChatroomInfoUI.lVG.field_addMemberUrl);
        }
        intent.putExtra("useJs", true);
        com.tencent.mm.bg.d.b(bizChatroomInfoUI.mController.tml, "webview", ".ui.tools.WebViewUI", intent, 1);
    }

    static /* synthetic */ void d(BizChatroomInfoUI bizChatroomInfoUI) {
        x.i("MicroMsg.BizChatroomInfoUI", "deleteChatroom");
        z.Ng();
        g.Eh().dpP.a(new u(bizChatroomInfoUI.hpJ, bizChatroomInfoUI.tDV.field_bizChatServId), 0);
        bizChatroomInfoUI.isDeleteCancel = false;
        bizChatroomInfoUI.getString(R.l.app_tip);
        i.a(bizChatroomInfoUI.hpJ, bizChatroomInfoUI.hpD, new 2(bizChatroomInfoUI, h.a(bizChatroomInfoUI, bizChatroomInfoUI.getString(R.l.app_waiting), true, new 11(bizChatroomInfoUI))));
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Contact_User", bizChatroomInfoUI.hpJ);
        com.tencent.mm.bg.d.b(bizChatroomInfoUI.mController.tml, "brandservice", ".ui.BizChatConversationUI", intent);
        bizChatroomInfoUI.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        z.Na().a(this.tEA, Looper.getMainLooper());
        this.fromScene = getIntent().getIntExtra("key_biz_chat_info_from_scene", -1);
        this.hpJ = getIntent().getStringExtra("Chat_User");
        this.hpD = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.tDV = z.Na().ak(this.hpD);
        this.tFx = this.tDV.field_chatName;
        this.tFy = com.tencent.mm.ac.a.e.lc(this.tDV.field_bizChatServId);
        if (!this.tFy) {
            this.lVG = z.Nc().cz(this.tDV.field_bizChatServId);
        }
        this.tFC = z.Nc().lm(this.hpJ);
        initView();
        if (this.tDV != null && this.tDV.field_bizChatServId != null && this.hpJ != null) {
            if (this.tDV.isGroup()) {
                z.Ng();
                com.tencent.mm.ac.a.h.am(this.tDV.field_bizChatServId, this.hpJ);
                return;
            }
            z.Ng();
            com.tencent.mm.ac.a.h.a(this.tDV.field_bizChatServId, this.hpJ, this);
        }
    }

    public void onResume() {
        aAG();
        updateTitle();
        aAE();
        bnu();
        csy();
        aAC();
        this.eOE.notifyDataSetChanged();
        super.onResume();
        if (!this.hLI) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!bi.oW(stringExtra)) {
                int aab = this.eOE.aab(stringExtra);
                setSelection(aab - 3);
                new ag().postDelayed(new 4(this, aab), 10);
            }
            this.hLI = true;
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        com.tencent.mm.ui.g.a.dismiss();
        com.tencent.mm.ui.g.a.dismiss();
        z.Na().a(this.tEA);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    boolean aah;
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null) {
                        x.i("MicroMsg.BizChatroomInfoUI", "bundle != null");
                        String string = bundleExtra.getString("enterprise_members");
                        x.i("MicroMsg.BizChatroomInfoUI", "enterprise_members:%s", new Object[]{string});
                        if (this.tFy) {
                            aah = aah(string);
                        } else {
                            xr xrVar = new xr();
                            c cVar = new c();
                            cVar.field_addMemberUrl = this.tFC != null ? this.tFC.field_addMemberUrl : null;
                            cVar.field_brandUserName = this.hpJ;
                            if (com.tencent.mm.ac.a.e.a(cVar, string, this.lVG.field_userId, xrVar)) {
                                z.Ng();
                                com.tencent.mm.ac.a.n a = com.tencent.mm.ac.a.h.a(this.hpJ, xrVar, this);
                                getString(R.l.app_tip);
                                this.eHw = h.a(this, getString(R.l.adding_room_mem), true, new 5(this, a));
                                aah = true;
                            } else {
                                aah = false;
                            }
                        }
                    } else {
                        aah = false;
                    }
                    if (!aah) {
                        Toast.makeText(this, getString(R.l.room_change_add_memberfail), 0).show();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private boolean aah(String str) {
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                hv hvVar = new hv();
                for (int i = 0; i < jSONArray.length(); i++) {
                    j jVar;
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("id");
                    j cz = z.Nc().cz(string);
                    if (cz == null) {
                        cz = new j();
                        cz.field_userId = string;
                        jVar = cz;
                    } else {
                        jVar = cz;
                    }
                    jVar.field_userName = jSONObject.getString("nick_name");
                    jVar.field_brandUserName = this.hpJ;
                    jVar.field_headImageUrl = jSONObject.getString("head_img_url");
                    jVar.field_profileUrl = jSONObject.getString("profile_url");
                    jVar.field_UserVersion = jSONObject.getInt("ver");
                    jVar.field_addMemberUrl = this.tFC != null ? this.tFC.field_addMemberUrl : null;
                    if (!z.Nc().b(jVar)) {
                        z.Nc().a(jVar);
                    }
                    hu huVar = new hu();
                    huVar.riL = jVar.field_userId;
                    hvVar.riM.add(huVar);
                }
                a(hvVar, null);
                return true;
            } catch (Throwable e) {
                x.i("MicroMsg.BizChatroomInfoUI", "parse memberJson Exception:%s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.BizChatroomInfoUI", e, "", new Object[0]);
            }
        }
        return false;
    }

    private void a(hv hvVar, hv hvVar2) {
        x.i("MicroMsg.BizChatroomInfoUI", "updateBizChatMemberList()");
        String string = hvVar == null ? getString(R.l.room_del_member) : getString(R.l.adding_room_mem);
        z.Ng();
        com.tencent.mm.ac.a.x a = com.tencent.mm.ac.a.h.a(this.tDV.field_brandUserName, this.tDV.field_bizChatServId, hvVar, hvVar2, this);
        getString(R.l.app_tip);
        this.eHw = h.a(this, string, true, new 6(this, a));
    }

    public final int Ys() {
        return R.o.bizchat_roominfo_pref;
    }

    protected final void initView() {
        this.eOE = this.tCL;
        String str = this.tDV.field_ownerUserId;
        this.hLz = this.tDV.Nn().size();
        if (bi.oW(str)) {
            this.hLy = false;
        } else {
            this.hLy = str.equals(z.Nc().cA(this.hpJ));
        }
        x.d("MicroMsg.BizChatroomInfoUI", "initBaseChatRoomView()");
        this.hLp = (ContactListExpandPreference) this.eOE.ZZ("roominfo_contact_anchor");
        this.hLp.a(this.eOE, this.hLp.mKey);
        this.hLl = (SignaturePreference) this.eOE.ZZ("room_name");
        this.hLq = (CheckBoxPreference) this.eOE.ZZ("room_notify_new_msg");
        this.hLs = (CheckBoxPreference) this.eOE.ZZ("room_placed_to_the_top");
        this.hLr = (CheckBoxPreference) this.eOE.ZZ("room_save_to_contact");
        ContactListExpandPreference contactListExpandPreference = this.hLp;
        boolean z = this.tFy;
        if (contactListExpandPreference.qJA != null) {
            contactListExpandPreference.qJA.qIM.qJb = z;
        }
        contactListExpandPreference = this.hLp;
        z = this.hLy;
        if (contactListExpandPreference.qJA != null) {
            contactListExpandPreference.qJA.qIM.qJa = z;
        }
        if (this.hLy) {
            this.hLp.kG(true).kH(true);
        } else {
            this.hLp.kG(true).kH(false);
        }
        this.hLp.TL(this.tDV.field_ownerUserId);
        this.hLp.cdU();
        this.hLp.cdX();
        if (!this.tFy) {
            this.eOE.bw("room_save_to_contact", true);
            this.eOE.bw("room_name", true);
            this.eOE.bw("room_del_quit", true);
        }
        csy();
        bnu();
        aAE();
        if (this.hLp != null) {
            this.kww.setOnScrollListener(this.hLH);
            this.hLp.a(this.hLH);
            this.hLp.a(new 7(this));
        }
        setBackBtn(new 8(this));
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        String str = preference.mKey;
        if (str.equals("room_name")) {
            String str2 = "";
            if (aAH()) {
                str2 = this.tDV.field_chatName;
            }
            h.a(this.mController.tml, getString(R.l.room_name_modify), str2, "", 32, new 9(this, str2));
        } else if (str.equals("room_notify_new_msg")) {
            this.hEj = !this.hEj;
            w(this.hEj, 1);
            aAE();
        } else if (str.equals("room_placed_to_the_top")) {
            if (this.tFA) {
                z = false;
            }
            this.tFA = z;
            w(this.tFA, 16);
            if (this.tFA) {
                z.Nb().bh(this.tDV.field_bizChatLocalId);
            } else {
                z.Nb().bi(this.tDV.field_bizChatLocalId);
            }
        } else if (str.equals("room_del_quit")) {
            x.d("MicroMsg.BizChatroomInfoUI", " quit " + this.hpD);
            h.a(this.mController.tml, getString(R.l.del_room_mem_comfirm), "", new 10(this), null);
        } else if (str.equals("room_save_to_contact")) {
            if (this.tFz) {
                z = false;
            }
            this.tFz = z;
            w(this.tFz, 8);
            csy();
        }
        return false;
    }

    private void w(boolean z, int i) {
        this.tFB = this.tDV.field_bitFlag;
        this.tFx = this.tDV.field_chatName;
        if (this.tFy) {
            c cVar;
            if (z) {
                cVar = this.tDV;
                cVar.field_bitFlag |= i;
            } else {
                cVar = this.tDV;
                cVar.field_bitFlag &= i ^ -1;
            }
            x.i("MicroMsg.BizChatroomInfoUI", "dealSetMute:bitFlag %s", new Object[]{Integer.valueOf(this.tDV.field_bitFlag)});
            z.Na().b(this.tDV);
        } else {
            j jVar;
            if (z) {
                jVar = this.lVG;
                jVar.field_bitFlag |= i;
            } else {
                jVar = this.lVG;
                jVar.field_bitFlag &= i ^ -1;
            }
            z.Nc().b(this.lVG);
            this.tDV.field_bitFlag = this.lVG.field_bitFlag;
            z.Na().b(this.tDV);
        }
        hs hsVar = new hs();
        hsVar.riE = this.tDV.field_bizChatServId;
        hsVar.riG = this.tDV.field_bitFlag;
        z.Ng();
        com.tencent.mm.ac.a.h.a(this.tDV.field_brandUserName, hsVar, this);
    }

    public final j EE(int i) {
        if (this.hLp.getItem(i) instanceof j) {
            return (j) this.hLp.getItem(i);
        }
        return null;
    }

    private void aAC() {
        if (this.hLp != null) {
            List bk;
            if (this.tFy) {
                bk = com.tencent.mm.ac.a.e.bk(this.hpD);
            } else {
                bk = new LinkedList();
                bk.add(this.tDV.field_bizChatServId);
            }
            if (bk != null) {
                this.hLz = bk.size();
            } else {
                this.hLz = 0;
            }
            if (this.hLz <= 1) {
                this.hLp.kG(true).kH(false);
            } else {
                this.hLp.kG(true).kH(this.hLy);
            }
            this.hLp.p(this.hpJ, bk);
        }
    }

    private void csy() {
        x.d("MicroMsg.BizChatroomInfoUI", "updateSaveToContact()");
        if (this.duR == null) {
            this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.tFy) {
            this.tFz = this.tDV.hu(8);
            this.tFB = this.tDV.field_bitFlag;
        } else {
            this.tFz = this.lVG.hu(8);
            this.tFB = this.lVG.field_bitFlag;
        }
        if (this.tFz) {
            if (this.hLr != null) {
                this.duR.edit().putBoolean("room_save_to_contact", true).commit();
            }
        } else if (this.hLr != null) {
            this.duR.edit().putBoolean("room_save_to_contact", false).commit();
        }
        this.eOE.notifyDataSetChanged();
    }

    private void bnu() {
        x.d("MicroMsg.BizChatroomInfoUI", "updatePlaceTop()");
        if (this.duR == null) {
            this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.tFy) {
            this.tFA = this.tDV.hu(16);
            this.tFB = this.tDV.field_bitFlag;
        } else {
            this.tFA = this.lVG.hu(16);
            this.tFB = this.lVG.field_bitFlag;
        }
        if (this.hLs != null) {
            this.duR.edit().putBoolean("room_placed_to_the_top", this.tFA).commit();
        }
        this.eOE.notifyDataSetChanged();
    }

    private void aAE() {
        if (this.duR == null) {
            this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.tFy) {
            this.hEj = this.tDV.hu(1);
            this.tFB = this.tDV.field_bitFlag;
        } else {
            this.hEj = this.lVG.hu(1);
            this.tFB = this.lVG.field_bitFlag;
        }
        if (this.hEj) {
            setTitleMuteIconVisibility(0);
            if (this.hLq != null) {
                this.duR.edit().putBoolean("room_notify_new_msg", true).commit();
            }
        } else {
            setTitleMuteIconVisibility(8);
            if (this.hLq != null) {
                this.duR.edit().putBoolean("room_notify_new_msg", false).commit();
            }
        }
        this.eOE.notifyDataSetChanged();
    }

    private void aAG() {
        if (this.hLl == null) {
            return;
        }
        if (aAH()) {
            CharSequence charSequence = this.tDV.field_chatName;
            if (charSequence != null && charSequence.length() > 50) {
                charSequence = charSequence.substring(0, 32);
            }
            x.i("MicroMsg.BizChatroomInfoUI", "updateRoomName chatName:%s", new Object[]{charSequence});
            SignaturePreference signaturePreference = this.hLl;
            if (charSequence == null || charSequence.length() <= 0) {
                charSequence = getString(R.l.settings_signature_empty);
            }
            signaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.j.a(this, charSequence));
            return;
        }
        this.hLl.setSummary(getString(R.l.room_has_no_topic));
    }

    private void updateTitle() {
        if (this.tFy) {
            this.hLz = com.tencent.mm.ac.a.e.bj(this.hpD);
            if (this.hLz != 0) {
                setMMTitle(getString(R.l.fmt_chatting_title_group, new Object[]{getString(R.l.roominfo_name), Integer.valueOf(this.hLz)}));
                return;
            }
        }
        setMMTitle(getString(R.l.roominfo_name));
    }

    private boolean aAH() {
        if (bi.oW(this.tFy ? this.tDV.field_chatName : this.lVG.field_userName)) {
            return false;
        }
        return true;
    }

    public final void a(int i, l lVar) {
        if (this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (lVar.getType() == 1355) {
            qm Nt = ((com.tencent.mm.ac.a.n) lVar).Nt();
            ql Nu = ((com.tencent.mm.ac.a.n) lVar).Nu();
            c la = z.Na().la(Nt.ruQ.rDx.riE);
            Intent intent;
            if (la == null) {
                Toast.makeText(ad.getContext(), getString(R.l.room_change_add_memberfail), 0).show();
            } else if (this.fromScene == 2) {
                intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
                intent.putExtra("Contact_User", Nu.riK);
                intent.putExtra("biz_chat_chat_id", la.field_bizChatLocalId);
                com.tencent.mm.bg.d.e(this, ".ui.bizchat.BizChatConversationUI", intent);
            } else {
                intent = new Intent();
                intent.addFlags(67108864);
                intent.putExtra("Chat_User", Nu.riK);
                intent.putExtra("key_biz_chat_id", la.field_bizChatLocalId);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                intent.putExtra("key_is_biz_chat", true);
                com.tencent.mm.plugin.chatroom.a.ezn.e(intent, this);
            }
        } else if (lVar.getType() == 1356) {
            if (i != 0) {
                csA();
            }
        } else if (lVar.getType() == 1353 && i >= 0 && this.lVG != null) {
            this.lVG = z.Nc().cz(this.lVG.field_userId);
            csz();
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar == null) {
            x.e("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], scene is null", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            return;
        }
        x.i("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(lVar.getType())});
        this.hLz = com.tencent.mm.ac.a.e.bj(this.hpD);
        x.d("MicroMsg.BizChatroomInfoUI", "now is " + this.hLz);
        if (this.eHw != null) {
            this.eHw.dismiss();
        }
        com.tencent.mm.h.a eV = com.tencent.mm.h.a.eV(str);
        if (eV != null) {
            eV.a(this, null, null);
        } else if (i == 0 && i2 == 0) {
            lVar.getType();
        } else {
            x.w("MicroMsg.BizChatroomInfoUI", "willen onSceneEnd err:Network not ok");
            csA();
        }
    }

    private void csz() {
        if (this.hLp != null) {
            aAG();
            updateTitle();
            aAE();
            aAC();
            csy();
            bnu();
            this.hLp.notifyChanged();
        }
        this.eOE.notifyDataSetChanged();
    }

    private void csA() {
        x.i("MicroMsg.BizChatroomInfoUI", "dealModChatNameFail reset bizChatName");
        this.tDV.field_chatName = this.tFx;
        this.tDV.field_bitFlag = this.tFB;
        this.hEj = this.tDV.hu(1);
        this.tFz = this.tDV.hu(8);
        this.tFA = this.tDV.hu(16);
        z.Na().b(this.tDV);
        if (this.tFA) {
            z.Nb().bh(this.tDV.field_bizChatLocalId);
        } else if (!this.tFA) {
            z.Nb().bi(this.tDV.field_bizChatLocalId);
        }
        this.duR.edit().putBoolean("room_placed_to_the_top", z.Nb().bg(this.tDV.field_bizChatLocalId)).commit();
        aAG();
        aAE();
        bnu();
        csy();
        Toast.makeText(this, getString(R.l.room_change_fail), 0).show();
    }

    public final com.tencent.mm.ui.base.preference.h a(SharedPreferences sharedPreferences) {
        return new com.tencent.mm.ui.base.preference.a(this, sharedPreferences);
    }
}
