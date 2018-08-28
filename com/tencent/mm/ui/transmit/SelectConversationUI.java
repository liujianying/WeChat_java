package com.tencent.mm.ui.transmit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ca;
import com.tencent.mm.model.r;
import com.tencent.mm.openim.a.b$a;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.plugin.base.stub.d;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.pluginsdk.ui.applet.g$a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.l;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.a.f;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.w;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.y;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

@a(19)
public class SelectConversationUI extends MMBaseSelectContactUI {
    private static final int uEf = s.s(new int[]{1, 2});
    private long bJA;
    private long bJC;
    private String bWW;
    private bd bXQ;
    private int eCt;
    private int fromScene = 0;
    private List<String> gRN;
    private String hvD = null;
    private String imagePath = null;
    private int[] jfV = new int[]{R.h.chatting_note_thumb_iv_0, R.h.chatting_note_thumb_iv_1, R.h.chatting_note_thumb_iv_2, R.h.chatting_note_thumb_iv_3, R.h.chatting_note_thumb_iv_4};
    private int msgType;
    private TextView tFu;
    private OnMenuItemClickListener uEA = new 16(this);
    private OnMenuItemClickListener uEB = new 17(this);
    private int uEg;
    private boolean uEh = false;
    private boolean uEi = false;
    private boolean uEj = false;
    private boolean uEk = false;
    private boolean uEl = false;
    private boolean uEm = false;
    private boolean uEn = false;
    private int uEo;
    private boolean uEp = false;
    private String uEq;
    private String uEr;
    private Boolean uEs = Boolean.valueOf(false);
    private boolean uEt = false;
    private boolean uEu = false;
    private List<String> uEv = null;
    private ReportArgs uEw;
    private String uEx;
    private String uEy = null;
    private String uEz;
    private int ubT = -1;
    private boolean ukn;
    private boolean ulx = false;

    static /* synthetic */ void b(SelectConversationUI selectConversationUI, Intent intent) {
        if (s.fb(selectConversationUI.eCt, GLIcon.TOP)) {
            selectConversationUI.az(intent);
            selectConversationUI.finish();
            return;
        }
        g$a g_a = new g$a(selectConversationUI.mController.tml);
        g_a.bZ(selectConversationUI.uEv);
        if (selectConversationUI.ulx) {
            selectConversationUI.a(g_a, selectConversationUI.uEq);
            a(intent, selectConversationUI.uEq, selectConversationUI.uEv);
        } else if (selectConversationUI.uEi) {
            if (selectConversationUI.bJA != -1) {
                fx fxVar = new fx();
                fxVar.bOG.bJA = selectConversationUI.bJA;
                fxVar.bOG.bOH = g_a;
                fxVar.bOG.bHj = selectConversationUI.mController.tml;
                com.tencent.mm.sdk.b.a.sFg.m(fxVar);
            } else if (selectConversationUI.msgType == 17 && selectConversationUI.uEo != 0) {
                g_a.TH(new StringBuffer(selectConversationUI.getResources().getString(R.l.app_multi_msg)).append(selectConversationUI.mController.tml.getString(R.l.retransmit_msg_count, new Object[]{Integer.valueOf(selectConversationUI.uEo)})).toString());
            }
        } else if (selectConversationUI.uEj) {
            HashMap hashMap = (HashMap) selectConversationUI.getIntent().getSerializableExtra("webview_params");
            g_a.TI((String) hashMap.get("img_url")).cdP();
            String str = (String) hashMap.get("title");
            String str2 = (String) hashMap.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
            g_a.TH(new StringBuffer(selectConversationUI.getResources().getString(R.l.app_url)).append(str).toString());
            g_a.a(new 14(selectConversationUI, str2));
        } else if (selectConversationUI.uEk) {
            selectConversationUI.a(g_a);
        } else {
            selectConversationUI.b(g_a);
            selectConversationUI.c(g_a);
        }
        g_a.g(Boolean.valueOf(true)).BX(R.l.app_send).a(new 15(selectConversationUI, intent)).eIW.show();
    }

    public void onCreate(Bundle bundle) {
        e.k(this);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("Select_App_Id");
        String stringExtra2 = getIntent().getStringExtra("Select_Open_Id");
        x.i("MicroMsg.SelectConversationUI", "onCreate, appId = " + stringExtra + ", openId = " + stringExtra2);
        if (!(ai.oW(stringExtra) || ai.oW(stringExtra2))) {
            new d(this, stringExtra, stringExtra2, new 1(this)).atx();
        }
        e.l(this);
    }

    protected final void Wj() {
        super.Wj();
        this.uEh = getIntent().getBooleanExtra("select_is_ret", false);
        this.fromScene = getIntent().getIntExtra("scene_from", 0);
        x.i("MicroMsg.SelectConversationUI", "from scene:%d", new Object[]{Integer.valueOf(this.fromScene)});
        if (this.fromScene == 1) {
            this.uEi = true;
        } else if (this.fromScene == 2 || this.fromScene == 10) {
            this.uEj = true;
        } else if (this.fromScene == 3) {
            this.uEk = true;
        } else if (this.fromScene == 6) {
            this.uEl = true;
        } else if (this.fromScene == 7) {
            this.uEm = true;
        }
        this.uEn = getIntent().getBooleanExtra("send_to_biz", false);
        this.ubT = getIntent().getIntExtra("Retr_Biz_Msg_Selected_Msg_Index", -1);
        this.bJA = getIntent().getLongExtra("select_fav_local_id", -1);
        this.uEo = getIntent().getIntExtra("select_fav_select_count", 0);
        this.uEt = getIntent().getBooleanExtra("mutil_select_is_ret", false);
        this.ulx = getIntent().getBooleanExtra("Select_Send_Card", false);
        this.uEp = getIntent().getBooleanExtra("Retr_Big_File", false);
        if (this.ulx) {
            this.uEq = getIntent().getStringExtra("Select_Talker_Name");
        }
        this.eCt = getIntent().getIntExtra("Select_Conv_Type", uEf);
        this.msgType = getIntent().getIntExtra("Retr_Msg_Type", -1);
        this.bJC = getIntent().getLongExtra("Retr_Msg_Id", -1);
        au.HU();
        this.bXQ = c.FT().dW(this.bJC);
        this.imagePath = getIntent().getStringExtra("image_path");
        this.uEy = getIntent().getStringExtra("ad_video_title");
        this.hvD = getIntent().getStringExtra("desc_title");
        this.uEx = getIntent().getStringExtra("Retr_Msg_thumb_path");
        this.bWW = getIntent().getStringExtra("Retr_Msg_content");
        this.uEz = getIntent().getStringExtra("Retr_fav_xml_str");
        if (this.bWW == null && this.bXQ != null) {
            this.bWW = this.bXQ.field_content;
        }
        this.uEw = (ReportArgs) getIntent().getParcelableExtra("Select_Report_Args");
        Collection hashSet = new HashSet();
        hashSet.addAll(s.cyz());
        String stringExtra = getIntent().getStringExtra("Select_block_List");
        if (!ai.oW(stringExtra)) {
            hashSet.addAll(ai.h(stringExtra.split(",")));
        }
        if (s.fb(this.eCt, 2)) {
            Collection cyA = s.cyA();
            s.h(cyA);
            hashSet.addAll(cyA);
        }
        this.gRN = new ArrayList();
        this.gRN.addAll(hashSet);
        if (s.fb(this.eCt, 1)) {
            this.ukn = true;
        }
        if (this.uEt) {
            this.uEv = new LinkedList();
            if (this.uEt) {
                a(1, getString(R.l.app_multi_selected), this.uEA, b.tmX);
                Wp();
            }
        }
    }

    protected final o Wn() {
        return new w(this, this.gRN, this.ukn, this.uEu, this.uEn, this.eCt);
    }

    protected final m Wo() {
        return new q(this, this.gRN, this.uEu, this.scene);
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.tFu == null) {
            if (this.ulx) {
                this.uEg = R.l.select_more_contact;
            } else if (this.fromScene == 10) {
                this.uEg = R.l.open_main_contact_title;
            } else {
                this.uEg = R.l.select_conversation_create;
            }
            12 12 = new 12(this);
            CharSequence string = getString(this.uEg);
            View inflate = y.gq(this).inflate(R.i.group_card_item, null);
            inflate.setOnClickListener(12);
            TextView textView = (TextView) inflate.findViewById(R.h.content_tv);
            textView.setText(string);
            listView.addHeaderView(inflate);
            this.tFu = textView;
        }
        this.tFu.setVisibility(i);
    }

    protected final void bbH() {
        if (this.fromScene == 5) {
            h.a(this, getString(R.l.lucky_money_select_contact_cancel_notify), null, getString(R.l.send), getString(R.l.cancel), true, new 19(this), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    super.f();
                    SelectConversationUI.this.YC();
                }
            });
        } else {
            super.f();
            YC();
        }
        if (this.uEw != null) {
            ReportUtil.a(this, this.uEw);
        }
    }

    public void onBackPressed() {
        super.f();
    }

    public final void iV(int i) {
        int headerViewsCount;
        com.tencent.mm.ui.contact.a.a FM;
        if (this.uEu) {
            headerViewsCount = i - getContentLV().getHeaderViewsCount();
            if (headerViewsCount < 0) {
                x.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[]{Integer.valueOf(i)});
                cAg();
                return;
            }
            n cyp = cyp();
            FM = cyp.FM(headerViewsCount);
            if (FM != null && FM.guS != null) {
                String str = FM.guS.field_username;
                x.i("MicroMsg.SelectConversationUI", "ClickUser=%s", new Object[]{str});
                if (this.uEv.contains(str) || !mx(true)) {
                    if (!abk(str)) {
                        cyv();
                        this.lbw.Ty(str);
                        if (this.uEv.contains(str)) {
                            this.uEv.remove(str);
                        } else {
                            this.uEv.add(str);
                        }
                    }
                    Wp();
                    cyp.notifyDataSetChanged();
                    return;
                }
                cyv();
            }
        } else if (i < getContentLV().getHeaderViewsCount()) {
            x.i("MicroMsg.SelectConversationUI", "Click HeaderView position=%d", new Object[]{Integer.valueOf(i)});
            if (this.ulx) {
                cAh();
            } else {
                cAi();
            }
        } else {
            FM = (com.tencent.mm.ui.contact.a.a) getContentLV().getAdapter().getItem(i);
            if (FM == null) {
                return;
            }
            Intent intent;
            if ((FM instanceof com.tencent.mm.ui.contact.a.b) && ((com.tencent.mm.ui.contact.a.b) FM).bgn == getResources().getString(R.l.address_official_accounts_title)) {
                x.i("MicroMsg.SelectConversationUI", "doCallSelectBizItem");
                intent = new Intent();
                intent.putExtra("list_attr", 16384);
                com.tencent.mm.bg.d.b(this, "brandservice", ".ui.BrandServiceIndexUI", intent, 4);
                this.uEj = true;
            } else if (FM instanceof f) {
                f fVar = (f) FM;
                Intent intent2 = new Intent();
                intent2.putExtra("scene", this.scene);
                Serializable arrayList = new ArrayList();
                for (Object add : fVar.jrx.jrX) {
                    arrayList.add(add);
                }
                intent2.putExtra("query_phrase_list", arrayList);
                com.tencent.mm.bg.d.b(this, ".ui.transmit.MMCreateChatroomUI", intent2, 1);
            } else {
                ab abVar = FM.guS;
                if (abVar != null) {
                    String str2 = abVar.field_username;
                    x.i("MicroMsg.SelectConversationUI", "doClickUser=%s", new Object[]{str2});
                    if (!abk(str2) && !abl(str2)) {
                        Intent intent3 = new Intent();
                        intent3.putExtra("Select_Conv_User", str2);
                        intent = (Intent) getIntent().getParcelableExtra("Select_Conv_NextStep");
                        if (intent != null) {
                            a(intent3, intent);
                        } else if (this.uEh || this.ulx || this.uEi || this.uEj || this.uEk) {
                            n(intent3, str2);
                        } else {
                            az(intent3);
                            finish();
                        }
                        YC();
                    }
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            x.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            x.i("MicroMsg.SelectConversationUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        String stringExtra;
        Intent intent2;
        final String stringExtra2;
        if (i == 1) {
            if (i2 == -1 && intent != null) {
                stringExtra = intent.getStringExtra("Select_Conv_User");
                x.i("MicroMsg.SelectConversationUI", "getIntent = " + getIntent());
                intent2 = (Intent) getIntent().getParcelableExtra("Select_Conv_NextStep");
                if (intent2 != null) {
                    a(intent, intent2);
                } else if (this.uEh || this.ulx || this.uEi || this.uEj || this.uEk) {
                    n(intent, stringExtra);
                } else {
                    az(intent);
                    finish();
                }
            }
        } else if (i == 2) {
            switch (i2) {
                case -1:
                    finish();
                    if (intent != null && intent.getBooleanExtra("Select_stay_in_wx", false)) {
                        intent2 = new Intent(this, TaskRedirectUI.class);
                        intent2.addFlags(268435456);
                        startActivity(intent2);
                        return;
                    }
                    return;
                case 0:
                    if (intent != null) {
                        this.uEw = (ReportArgs) intent.getParcelableExtra("Select_Report_Args");
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 3) {
            switch (i2) {
                case -1:
                    if (intent != null) {
                        stringExtra2 = intent.getStringExtra("received_card_name");
                        if (!bi.oW(stringExtra2) && !abl(stringExtra2)) {
                            g$a g_a = new g$a(this.mController.tml);
                            g_a.bZ(stringExtra2);
                            a(g_a, this.uEq);
                            g_a.g(Boolean.valueOf(true)).BX(R.l.app_send).a(new com.tencent.mm.pluginsdk.ui.applet.q.a() {
                                public final void a(boolean z, String str, int i) {
                                    SelectConversationUI.this.YC();
                                    if (z) {
                                        Intent intent = new Intent();
                                        if (stringExtra2.endsWith("@chatroom")) {
                                            SelectConversationUI.b(intent, SelectConversationUI.this.uEq, stringExtra2);
                                        } else {
                                            SelectConversationUI.a(intent, SelectConversationUI.this.uEq, stringExtra2);
                                        }
                                        intent.putExtra("custom_send_text", str);
                                        SelectConversationUI.this.az(intent);
                                        SelectConversationUI.this.finish();
                                    }
                                }
                            }).eIW.show();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 4) {
            if (i2 == -1 && intent != null) {
                n(intent, intent.getStringExtra("Select_Contact"));
            }
        } else if (i != 5) {
            x.e("MicroMsg.SelectConversationUI", "onActivityResult, unknown requestCode = " + i);
        } else if (i2 == -1 && intent != null) {
            stringExtra = intent.getStringExtra("Select_Conv_User");
            for (String stringExtra22 : this.uEv) {
                this.lbw.Tz(stringExtra22);
            }
            if (ai.oW(stringExtra)) {
                this.uEv.clear();
            } else {
                this.uEv = ai.h(stringExtra.split(","));
            }
            for (String stringExtra222 : this.uEv) {
                this.lbw.bm(stringExtra222, false);
            }
            Wp();
            cyp().notifyDataSetChanged();
        }
    }

    private boolean abk(String str) {
        if (!this.ulx || !ab.XR(this.uEq) || str == null || !str.endsWith("@chatroom")) {
            return false;
        }
        try {
            h.a(this, getString(R.l.share_openim_card_waring), "", null);
        } catch (Throwable th) {
        }
        return true;
    }

    private boolean abl(String str) {
        if (!ab.XR(str)) {
            return false;
        }
        if (this.ulx) {
            au.HU();
            if (ab.Dk(c.FR().Ye(this.uEq).field_verifyFlag)) {
                abm(str);
                return true;
            }
        }
        switch (this.msgType) {
            case 5:
                abm(str);
                return true;
            default:
                return false;
        }
    }

    private void abm(String str) {
        try {
            String gT = r.gT(str);
            h.a(this, getString(R.l.share_openim_forbiden_waring, new Object[]{gT}), "", null);
        } catch (Throwable th) {
        }
    }

    private static void a(Intent intent, String str, String str2) {
        List linkedList = new LinkedList();
        linkedList.add(str2);
        a(intent, str, linkedList);
    }

    private static void a(Intent intent, String str, List<String> list) {
        if (list.size() > 0) {
            intent.putExtra("be_send_card_name", str);
            intent.putExtra("received_card_name", ai.c(list, ","));
            intent.putExtra("Is_Chatroom", false);
        }
    }

    private static void b(Intent intent, String str, String str2) {
        Assert.assertTrue("cardNameToSend is null", str != null);
        intent.putExtra("be_send_card_name", str);
        intent.putExtra("received_card_name", str2);
        intent.putExtra("Is_Chatroom", true);
    }

    private void a(g$a g_a, String str) {
        au.HU();
        c.FR().Ye(str);
        String gT = r.gT(str);
        if (!bi.oW(this.uEr)) {
            gT = this.uEr;
        }
        au.HU();
        ab Ye = c.FR().Ye(str);
        String string = com.tencent.mm.model.s.gU(Ye.field_verifyFlag) ? getResources().getString(R.l.app_friend_card_biz) : ab.XR(str) ? d(this, Ye) : getResources().getString(R.l.app_friend_card_personal);
        g_a.TH(new StringBuffer(string).append(gT).toString());
    }

    public static String d(Context context, ab abVar) {
        if (TextUtils.isEmpty(((com.tencent.mm.openim.a.b) g.l(com.tencent.mm.openim.a.b.class)).g(abVar.field_openImAppid, "openim_card_type_name", b$a.eui))) {
            return context.getResources().getString(R.l.app_friend_card_personal);
        }
        return String.format("[%s]", new Object[]{((com.tencent.mm.openim.a.b) g.l(com.tencent.mm.openim.a.b.class)).g(abVar.field_openImAppid, "openim_card_type_name", b$a.eui)});
    }

    private void a(Intent intent, Intent intent2) {
        x.d("MicroMsg.SelectConversationUI", "has next step, jump now, intent=" + intent2);
        intent2.putExtras(intent.getExtras());
        startActivityForResult(intent2, 2);
        com.tencent.mm.ui.base.b.E(this.mController.tml, intent2);
    }

    private void n(Intent intent, String str) {
        if (!abl(str)) {
            if (s.fb(this.eCt, GLIcon.TOP)) {
                az(intent);
                finish();
            } else if (ai.oW(str)) {
                x.v("MicroMsg.SelectConversationUI", "avatarUseName is null or nil show dialog fail ");
            } else {
                if (com.tencent.mm.model.s.fq(str)) {
                    int gK = com.tencent.mm.model.m.gK(str);
                    if (!this.uEp || gK <= ai.getInt(com.tencent.mm.k.g.AT().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50)) {
                        getString(R.l.select_contact_num, new Object[]{Integer.valueOf(gK)});
                    } else {
                        x.w("MicroMsg.SelectConversationUI", "summerbig SelectConversationUI group limit[%d], count[%d]", new Object[]{Integer.valueOf(ai.getInt(com.tencent.mm.k.g.AT().getValue("CheckBigFileUploadChatroomMemberCountLimit"), 50)), Integer.valueOf(gK)});
                        h.b(this, getString(R.l.select_contact_num_limit_tips_bigfile, new Object[]{Integer.valueOf(r1)}), "", true);
                        return;
                    }
                }
                g$a g_a = new g$a(this.mController.tml);
                g_a.bZ(str);
                String str2;
                if (this.ulx) {
                    a(g_a, this.uEq);
                    if (str.endsWith("@chatroom")) {
                        b(intent, this.uEq, str);
                    } else {
                        a(intent, this.uEq, str);
                    }
                    g_a.g(Boolean.valueOf(true));
                } else if (this.uEi) {
                    if (this.bJA != -1) {
                        c(g_a);
                        fx fxVar = new fx();
                        fxVar.bOG.bJA = this.bJA;
                        fxVar.bOG.bOH = g_a;
                        fxVar.bOG.bOI = this.uEz;
                        fxVar.bOG.bHj = this.mController.tml;
                        com.tencent.mm.sdk.b.a.sFg.m(fxVar);
                    } else if (this.msgType == 17 && this.uEo != 0) {
                        g_a.TH(new StringBuffer(getResources().getString(R.l.app_multi_msg)).append(this.mController.tml.getString(R.l.retransmit_msg_count, new Object[]{Integer.valueOf(this.uEo)})).toString());
                    }
                    g_a.g(Boolean.valueOf(true));
                } else if (this.uEj) {
                    HashMap hashMap = (HashMap) getIntent().getSerializableExtra("webview_params");
                    String str3 = (String) hashMap.get("img_url");
                    String str4 = (String) hashMap.get("title");
                    str2 = (String) hashMap.get(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL);
                    g_a.TH(new StringBuffer(getResources().getString(R.l.app_url)).append(str4).toString());
                    g_a.a(new 22(this, str2));
                    g_a.TI(str3).cdP();
                    g_a.g(Boolean.valueOf(true));
                } else if (this.uEk) {
                    a(g_a);
                } else if (this.uEm) {
                    str2 = getResources().getString(R.l.app_golden_lucky);
                    if (this.hvD != null) {
                        str2 = new StringBuffer(str2).append(this.hvD).toString();
                    }
                    g_a.TH(str2);
                    g_a.g(Boolean.valueOf(false));
                } else {
                    b(g_a);
                    c(g_a);
                    g_a.g(Boolean.valueOf(true));
                }
                g_a.BX(R.l.app_send).a(new 23(this, intent)).eIW.show();
            }
        }
    }

    private void a(g$a g_a) {
        HashMap hashMap = (HashMap) getIntent().getSerializableExtra("appbrand_params");
        int i = ca.getInt(hashMap.get(DownloadSettingTable$Columns.TYPE), 1);
        String f = ca.f(hashMap.get("title"), "");
        String f2 = ca.f(hashMap.get("img_url"), null);
        if (i == 2 || i == 3) {
            String f3 = ca.f(hashMap.get("app_id"), null);
            int i2 = ca.getInt(hashMap.get("pkg_type"), 0);
            int i3 = ca.getInt(hashMap.get("pkg_version"), 0);
            String f4 = ca.f(hashMap.get("cache_key"), null);
            String f5 = ca.f(hashMap.get("path"), null);
            String f6 = ca.f(hashMap.get("delay_load_img_path"), null);
            boolean aW = ca.aW(hashMap.get("is_dynamic"));
            View bH = ((com.tencent.mm.modelappbrand.g) g.l(com.tencent.mm.modelappbrand.g.class)).bH(this);
            String bq = k.bq(this);
            Bundle bundle = new Bundle();
            bundle.putString("app_id", f3);
            bundle.putString("msg_id", String.format("%d-%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
            bundle.putInt("msg_pkg_type", i2);
            bundle.putInt("pkg_version", i3);
            bundle.putString("image_url", f2);
            bundle.putBoolean("is_dynamic_page", aW);
            bundle.putString("title", f);
            bundle.putString("cache_key", f4);
            bundle.putString("msg_path", f5);
            bundle.putString("delay_load_img_path", f6);
            ((com.tencent.mm.modelappbrand.g) g.l(com.tencent.mm.modelappbrand.g.class)).a(bq, bH, bundle);
            g_a.dh(bH);
            g_a.g(Boolean.valueOf(true));
            g_a.cdQ();
            g_a.gFM = new 24(this, bq, bH);
            return;
        }
        g_a.TH(new StringBuffer(getResources().getString(R.l.app_brand_default_name_with_brackets)).append(f).toString());
        g_a.TI(f2).cdP();
        g_a.g(Boolean.valueOf(true));
    }

    private void b(g$a g_a) {
        int orientationInDegree;
        String str;
        mw mwVar;
        switch (this.msgType) {
            case 0:
            case 16:
                Bitmap cAf = cAf();
                if (cAf == null && this.imagePath != null) {
                    Bitmap f = com.tencent.mm.sdk.platformtools.c.f(this.imagePath, com.tencent.mm.bp.a.getDensity(ad.getContext()));
                    orientationInDegree = Exif.fromFile(this.imagePath).getOrientationInDegree();
                    if (orientationInDegree < 0) {
                        orientationInDegree = 0;
                    }
                    cAf = com.tencent.mm.sdk.platformtools.c.b(f, (float) orientationInDegree);
                }
                g_a.c(cAf, 3);
                return;
            case 1:
                g_a.c(cAe(), 2);
                return;
            case 2:
            case 10:
                com.tencent.mm.y.g.a J;
                com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(bi.WT(this.bWW));
                if (this.bXQ.cky() && gp == null) {
                    J = com.tencent.mm.y.g.a.J(bi.WT(this.bWW), bi.WT(this.bWW));
                } else {
                    J = gp;
                }
                if (J != null) {
                    String string;
                    str = J.title;
                    String str2;
                    if (l.e(this.bXQ, this.ubT)) {
                        string = getResources().getString(R.l.app_brand_default_name_with_brackets);
                    } else if (J.type == 5) {
                        string = getResources().getString(R.l.app_url);
                        str2 = J.url;
                    } else if (J.type == 6) {
                        string = getResources().getString(R.l.app_file);
                    } else if (J.type == 24) {
                        str2 = getResources().getString(R.l.app_note);
                        mwVar = new mw();
                        mwVar.bXL.type = 0;
                        mwVar.bXL.bXN = J.dwW;
                        com.tencent.mm.sdk.b.a.sFg.m(mwVar);
                        str = bi.aG(mwVar.bXM.bXV.desc, J.description).replaceAll("\n", " ");
                        string = str2;
                    } else if (J.type == 19) {
                        string = getResources().getString(R.l.app_record);
                    } else if (J.type == 3) {
                        string = getResources().getString(R.l.app_music);
                    } else if (J.type == 4) {
                        string = getResources().getString(R.l.app_video);
                    } else if (J.type == 8) {
                        string = getResources().getString(R.l.app_emoji_share);
                    } else if (J.type != 33 && J.type != 36) {
                        string = getResources().getString(R.l.app_app);
                    } else if (J.dyU == 2 || J.dyU == 3 || J.type == 36) {
                        View bH = ((com.tencent.mm.modelappbrand.g) g.l(com.tencent.mm.modelappbrand.g.class)).bH(this);
                        g_a.dh(bH);
                        g_a.g(Boolean.valueOf(true));
                        g_a.cdQ();
                        str = com.tencent.mm.ak.o.Pf().d(this.bXQ.field_imgPath, false, true);
                        String bq = k.bq(this);
                        Bundle bundle = new Bundle();
                        bundle.putString("app_id", J.dyT);
                        bundle.putString("msg_id", String.format("%d-%d", new Object[]{Integer.valueOf(J.dyZ), Integer.valueOf(J.dyW)}));
                        bundle.putInt("msg_pkg_type", J.dyZ);
                        bundle.putInt("pkg_version", J.dyW);
                        if (!bi.oW(str)) {
                            bundle.putString("image_url", "file://" + str);
                        }
                        com.tencent.mm.y.a aVar = (com.tencent.mm.y.a) J.u(com.tencent.mm.y.a.class);
                        if (aVar != null) {
                            bundle.putBoolean("is_dynamic_page", aVar.dvC);
                            bundle.putString("cache_key", aVar.dvD);
                        }
                        bundle.putString("title", J.title);
                        bundle.putString("msg_path", J.dyR);
                        ((com.tencent.mm.modelappbrand.g) g.l(com.tencent.mm.modelappbrand.g.class)).a(bq, bH, bundle);
                        g_a.gFM = new 25(this, bq, bH);
                        return;
                    } else {
                        string = getResources().getString(R.l.app_brand_default_name_with_brackets);
                    }
                    if (str == null) {
                        str = "";
                    }
                    g_a.TH(new StringBuffer(string).append(str).toString());
                    if (J.thumburl != null) {
                        g_a.TI(J.thumburl).cdP();
                        return;
                    }
                    return;
                } else if (this.uEy != null) {
                    str = getResources().getString(R.l.app_video);
                    g_a.TH(new StringBuffer(str).append(this.uEy).toString());
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.hvD != null) {
                    g_a.TH(new StringBuffer(getResources().getString(R.l.app_file)).append(this.hvD).toString());
                    return;
                }
                return;
            case 4:
                g_a.TH(this.bWW);
                g_a.cdO();
                return;
            case 5:
                if (!bi.oW(this.uEx)) {
                    g_a.TJ(this.uEx);
                    return;
                } else if (bi.oW(this.bXQ.field_imgPath)) {
                    g_a.TJ(this.imagePath);
                    return;
                } else {
                    g_a.TJ(this.bXQ.field_imgPath);
                    return;
                }
            case 8:
                au.HU();
                bd.a GR = c.FT().GR(this.bWW);
                this.uEq = GR.otZ;
                this.uEr = GR.nickname;
                this.uEs = Boolean.valueOf(com.tencent.mm.model.s.gU(GR.pOR));
                a(g_a, this.uEq);
                return;
            case 9:
                au.HU();
                bd.b GS = c.FT().GS(this.bWW);
                str = "";
                if (GS != null) {
                    str = GS.label;
                }
                g_a.TH(this.mController.tml.getString(R.l.app_location) + str);
                return;
            case 11:
                g_a.c(cAe(), 2);
                return;
            case 12:
                mwVar = com.tencent.mm.ui.chatting.k.gL(this.mController.tml);
                if (mwVar.bXL.bXR != null) {
                    orientationInDegree = mwVar.bXL.bXR.size();
                } else {
                    orientationInDegree = 0;
                }
                g_a.TH(new StringBuffer(getResources().getString(R.l.app_multi_msg)).append(this.mController.tml.getString(R.l.retransmit_msg_count, new Object[]{Integer.valueOf(orientationInDegree)})).toString());
                return;
            case 13:
                g_a.TH(new StringBuffer(getResources().getString(R.l.app_multi_record)).append(ai.aG(com.tencent.mm.ui.chatting.k.gL(this.mController.tml).bXM.bXU.title, "")).toString());
                return;
            default:
                return;
        }
    }

    private void c(g$a g_a) {
        switch (this.msgType) {
            case 0:
            case 1:
            case 11:
            case 16:
                g_a.a(new 3(this));
                return;
            case 2:
            case 10:
                com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(bi.WT(this.bWW));
                if (gp == null) {
                    return;
                }
                if (gp.type == 5 && !l.e(this.bXQ, this.ubT)) {
                    g_a.a(new 5(this, gp.url));
                    return;
                } else if (gp.type == 6) {
                    g_a.a(new 6(this));
                    return;
                } else if (gp.type == 24) {
                    g_a.a(new 7(this, gp));
                    return;
                } else if (gp.type == 19) {
                    g_a.a(new 8(this, gp));
                    return;
                } else if (gp.type == 3) {
                    g_a.a(new 9(this, gp));
                    return;
                } else if (gp.type == 4) {
                    g_a.a(new com.tencent.mm.ui.widget.a.c.a.b() {
                        public final void aMV() {
                        }
                    });
                    return;
                } else {
                    return;
                }
            case 3:
                g_a.a(new 13(this));
                return;
            case 4:
                g_a.a(new 2(this));
                return;
            case 9:
                au.HU();
                bd.b GS = c.FT().GS(this.bWW);
                g_a.a(new 4(this, GS, GS.label));
                return;
            case 12:
                com.tencent.mm.ui.chatting.k.gL(this.mController.tml);
                return;
            case 13:
                g_a.a(new 11(this));
                return;
            default:
                return;
        }
    }

    private Bitmap cAe() {
        com.tencent.mm.modelvideo.o.Ta();
        String nL = com.tencent.mm.modelvideo.s.nL(this.bXQ.field_imgPath);
        if (nL == null) {
            nL = this.imagePath;
        }
        return com.tencent.mm.sdk.platformtools.c.Wb(nL);
    }

    private Bitmap cAf() {
        if (this.bXQ == null) {
            return null;
        }
        String str = this.bXQ.field_imgPath;
        com.tencent.mm.ak.g Pf = com.tencent.mm.ak.o.Pf();
        Bitmap b = com.tencent.mm.sdk.platformtools.c.b(Pf.d(str, false, true), com.tencent.mm.bp.a.getDensity(ad.getContext()), 0);
        if (b == null) {
            return b;
        }
        try {
            int orientationInDegree = Exif.fromFile(str).getOrientationInDegree();
            if (orientationInDegree < 0) {
                orientationInDegree = 0;
            }
            return com.tencent.mm.sdk.platformtools.c.b(b, (float) orientationInDegree);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.SelectConversationUI", th, "unexpected exception.", new Object[0]);
            return b;
        }
    }

    private void cAg() {
        x.i("MicroMsg.SelectConversationUI", "doCallSelectContactUIForMultiRetransmit");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_type", 14);
        intent.putExtra("titile", getString(R.l.address_title_select_contact));
        intent.putExtra("list_attr", s.ukK);
        intent.putExtra("already_select_contact", ai.c(this.uEv, ","));
        intent.putExtra("max_limit_num", 9);
        String str = "Forbid_SelectChatRoom";
        boolean z = this.ulx && ab.XR(this.uEq);
        intent.putExtra(str, z);
        this.mController.tml.startActivityForResult(intent, 5);
    }

    private void cAh() {
        boolean z = true;
        x.i("MicroMsg.SelectConversationUI", "doSendCardOrQRCode2CallSelectContactUI");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_attr", s.ukH);
        intent.putExtra("list_type", 3);
        intent.putExtra("be_send_card_name", this.uEq);
        intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
        intent.putExtra("Add_SendCard", true);
        intent.putExtra("titile", getString(R.l.address_title_select_contact));
        String str = "Forbid_SelectChatRoom";
        if (!(this.ulx && ab.XR(this.uEq))) {
            z = false;
        }
        intent.putExtra(str, z);
        this.mController.tml.startActivityForResult(intent, 3);
    }

    private void cAi() {
        x.i("MicroMsg.SelectConversationUI", "doCallSelectContactUI");
        Intent intent = new Intent(this, SelectContactUI.class);
        intent.putExtra("list_type", 5);
        intent.putExtra("titile", getString(R.l.address_title_select_contact));
        if (((this.fromScene == 4 || this.fromScene == 9) && getIntent().getIntExtra("jsapi_select_mode", 0) == 1) || this.fromScene == 10) {
            intent.putExtra("block_contact", getIntent().getStringExtra("Select_block_List"));
            intent.putExtra("list_attr", s.s(new int[]{32, 16, 1, 2, 4, 16384}));
        } else {
            intent.putExtra("list_attr", s.ukJ);
        }
        this.mController.tml.startActivityForResult(intent, 1);
    }

    protected final boolean Wl() {
        return false;
    }

    protected final String Wm() {
        String stringExtra = getIntent().getStringExtra("Select_Conv_ui_title");
        return (stringExtra == null || stringExtra.length() <= 0) ? getString(R.l.select_conversation_title) : stringExtra;
    }

    protected final boolean Wk() {
        return false;
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.ujX || aVar.guS == null) {
            return false;
        }
        return this.uEv.contains(aVar.guS.field_username);
    }

    public final void pf(String str) {
        this.uEv.remove(str);
        cyp().notifyDataSetChanged();
        Wp();
    }

    private void Wp() {
        if (!this.uEt) {
            return;
        }
        if (this.uEv != null && this.uEv.size() > 0) {
            updateOptionMenuText(1, getString(R.l.app_send) + "(" + this.uEv.size() + ")");
            a(this.uEB);
            enableOptionMenu(1, true);
        } else if (this.uEu) {
            updateOptionMenuText(1, getString(R.l.app_single_selected));
            a(this.uEA);
            enableOptionMenu(1, true);
        } else {
            updateOptionMenuText(1, getString(R.l.app_multi_selected));
            a(this.uEA);
            enableOptionMenu(1, true);
        }
    }

    private boolean mx(boolean z) {
        if (!z ? this.uEv.size() > 9 : this.uEv.size() >= 9) {
            return false;
        }
        h.a(this.mController.tml, getString(R.l.select_contact_num_limit_tips_withgroup, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", 9))}), getString(R.l.app_remind), new 18(this));
        return true;
    }

    protected final boolean cyt() {
        return true;
    }

    public final int[] bbG() {
        int[] intArrayExtra = getIntent().getIntArrayExtra("search_range");
        if (this.fromScene != 4 && this.fromScene != 10) {
            return intArrayExtra == null ? super.bbG() : intArrayExtra;
        } else {
            return new int[]{131072};
        }
    }

    private void az(Intent intent) {
        if (this.msgType == 5) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.putExtra("emoji_thumb_path", this.uEx);
            intent.putExtra("emoji_activity_id", getIntent().getStringExtra("emoji_activity_id"));
        }
        super.setResult(-1, intent);
    }
}
