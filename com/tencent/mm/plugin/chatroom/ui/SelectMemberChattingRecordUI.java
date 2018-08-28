package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.design.a$i;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd.b;
import com.tencent.mm.storage.bd.d;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.g.a;
import java.util.Map;

public class SelectMemberChattingRecordUI extends MMActivity {
    private static final f<Integer, c> dzj = new f(32);
    private String cZH;
    private p fUo;
    private String hMQ;
    private MMLoadMoreListView hPi;
    private View hPj;
    private a hPk;
    private String hPl;
    private int hou = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.SelectMemberChattingRecordUI", "[onCreate]");
        this.hMQ = getIntent().getStringExtra("RoomInfo_Id");
        this.hPl = getIntent().getStringExtra("room_member");
        x.i("MicroMsg.SelectMemberChattingRecordUI", "roomId:%s", new Object[]{this.hMQ});
        this.cZH = getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE);
        if (!bi.oW(this.hPl) && q.gQ(this.hPl)) {
            au.HU();
            this.hou = com.tencent.mm.model.c.FT().Hc(this.hMQ);
        } else if (!q.gQ(this.hPl)) {
            au.HU();
            this.hou = com.tencent.mm.model.c.FT().dI(this.hMQ, this.hPl);
        }
        initView();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.fUo != null && this.fUo.isShowing()) {
            this.fUo.dismiss();
        }
    }

    protected final void initView() {
        super.initView();
        setMMTitle(bi.oV(this.cZH));
        this.hPi = (MMLoadMoreListView) findViewById(R.h.member_list);
        this.hPi.crC();
        this.hPk = new a(this, this, this.hMQ, this.hPl, this.hou);
        this.hPi.setAdapter(this.hPk);
        this.hPj = findViewById(R.h.select_member_ui_hint_ll);
        if ((this.hou == 0 ? 1 : 0) != 0) {
            this.hPj.setVisibility(0);
            this.hPi.setVisibility(8);
        }
        this.hPi.setOnItemClickListener(new 1(this));
        this.hPi.setOnLoadMoreListener(new 2(this));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SelectMemberChattingRecordUI.this.setResult(0);
                SelectMemberChattingRecordUI.this.finish();
                return true;
            }
        });
    }

    protected static String a(u uVar, String str) {
        if (uVar == null) {
            return null;
        }
        return uVar.gT(str);
    }

    protected final int getLayoutId() {
        return R.i.select_member_chatting_record_ui;
    }

    public static String a(Context context, int i, String str, String str2, int i2) {
        String str3 = "";
        a gp = a.gp(str);
        switch (i) {
            case -1879048186:
                return context.getString(R.l.record_share_location_with_title, new Object[]{gp.title});
            case -1879048185:
            case -1879048183:
            case -1879048176:
                return context.getString(R.l.record_app_with_title, new Object[]{gp.title});
            case 1:
                return str.substring(str.indexOf(":\n") + 1);
            case 3:
            case 23:
            case a$i.AppCompatTheme_actionModeCopyDrawable /*33*/:
                return context.getString(R.l.app_pic);
            case a$i.AppCompatTheme_actionModePasteDrawable /*34*/:
                n nVar = new n(str);
                return context.getString(R.l.record_voice_with_time, new Object[]{Integer.valueOf((int) com.tencent.mm.modelvoice.q.bD(nVar.time))});
            case a$i.AppCompatTheme_actionModeFindDrawable /*37*/:
                if (str == null || str.length() <= 0) {
                    return str3;
                }
                d YY = d.YY(str);
                if (YY.otZ == null || YY.otZ.length() <= 0) {
                    return str3;
                }
                switch (YY.scene) {
                    case 18:
                        return context.getString(R.l.fmt_say_hello_to_you, new Object[]{YY.getDisplayName()});
                    case 22:
                    case 23:
                    case 24:
                    case 26:
                    case a$i.AppCompatTheme_actionModeStyle /*27*/:
                    case a$i.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                    case a$i.AppCompatTheme_actionModeBackground /*29*/:
                        return context.getString(R.l.fmt_shake_say_hello_to_you, new Object[]{YY.getDisplayName()});
                    case 25:
                        return context.getString(R.l.fmt_bottle_say_hello_to_you, new Object[]{YY.getDisplayName()});
                    default:
                        return context.getString(R.l.fmt_want_to_be_your_friend, new Object[]{YY.getDisplayName()});
                }
            case a$i.AppCompatTheme_dialogTheme /*42*/:
            case 66:
                if (bi.oV(str).length() <= 0) {
                    return str3;
                }
                CharSequence iB = bd.iB(str);
                if (!TextUtils.isEmpty(iB)) {
                    CharSequence str22 = iB;
                }
                au.HU();
                com.tencent.mm.storage.bd.a GR = com.tencent.mm.model.c.FT().GR(str);
                au.HU();
                str3 = com.tencent.mm.model.c.FR().Yg(str22).BL();
                if (s.fq(str3)) {
                    str3 = m.F(m.gL(str3));
                }
                if (i2 == 1) {
                    return context.getString(R.l.fmt_card_from, new Object[]{str3, GR.getDisplayName()});
                }
                return context.getString(R.l.fmt_card_to, new Object[]{str3, GR.getDisplayName()});
            case a$i.AppCompatTheme_dialogPreferredPadding /*43*/:
            case 62:
                return context.getString(62 == i ? R.l.app_shortvideo : R.l.app_video);
            case a$i.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                return context.getString(R.l.app_emoji);
            case a$i.AppCompatTheme_homeAsUpIndicator /*48*/:
                au.HU();
                b GS = com.tencent.mm.model.c.FT().GS(str);
                return context.getString(R.l.record_location_with_title, new Object[]{GS.label});
            case a$i.AppCompatTheme_actionButtonStyle /*49*/:
                if (gp == null) {
                    x.e("MicroMsg.SelectMemberChattingRecordUI", "decode msg content failed");
                    return "";
                }
                switch (gp.type) {
                    case 2:
                        return context.getString(R.l.app_pic);
                    case 3:
                        return context.getString(R.l.record_music_with_title, new Object[]{gp.title});
                    case 4:
                        return context.getString(R.l.record_video_with_title, new Object[]{gp.title});
                    case 5:
                        return context.getString(R.l.record_url_with_title, new Object[]{gp.getTitle()});
                    case 6:
                        return context.getString(R.l.record_file_with_title, new Object[]{gp.title});
                    case 7:
                        return str3;
                    case 8:
                        return context.getString(R.l.app_emoji2);
                    case 15:
                    case 26:
                    case a$i.AppCompatTheme_actionModeStyle /*27*/:
                        return context.getString(R.l.app_emoji);
                    case 17:
                        return context.getString(R.l.record_location_with_title, new Object[]{gp.title});
                    case 19:
                        return context.getString(R.l.record_record_with_title, new Object[]{gp.title});
                    case 24:
                        c cVar;
                        String str4 = gp.dwW;
                        if (bi.oW(str4)) {
                            x.e("MicroMsg.SelectMemberChattingRecordUI", "xml is null");
                            cVar = null;
                        } else {
                            int hashCode = str4.hashCode();
                            cVar = (c) dzj.get(Integer.valueOf(hashCode));
                            if (cVar != null) {
                                x.d("MicroMsg.SelectMemberChattingRecordUI", "get record msg data from cache");
                            } else {
                                Map z = str4.trim().startsWith("<recordinfo>") ? bl.z(str4, "recordinfo") : bl.z("<recordinfo>" + str4 + "</recordinfo>", "recordinfo");
                                if (z == null) {
                                    x.e("MicroMsg.SelectMemberChattingRecordUI", "values is null: %s", new Object[]{str4});
                                    cVar = null;
                                } else {
                                    c cVar2 = new c();
                                    cVar2.title = (String) z.get(".recordinfo.title");
                                    cVar2.desc = (String) z.get(".recordinfo.desc");
                                    cVar2.qXZ = (String) z.get(".recordinfo.favusername");
                                    dzj.put(Integer.valueOf(hashCode), cVar2);
                                    cVar = cVar2;
                                }
                            }
                        }
                        str3 = cVar == null ? "" : cVar.desc;
                        return context.getString(R.l.record_note_with_title, new Object[]{bi.aG(str3, "")});
                    case 25:
                        return context.getString(R.l.app_designer_share);
                    default:
                        return "";
                }
            case 369098801:
            case 452984881:
                return context.getString(R.l.record_card_with_title, new Object[]{gp.title});
            case 419430449:
                str3 = context.getString(R.l.record_remittance_with_title);
                if (gp == null) {
                    return str3;
                }
                int i3 = i2 == 1 ? 1 : 0;
                switch (gp.dxy) {
                    case 1:
                        if (i3 != 0) {
                            return context.getString(R.l.appmsg_remittance_digest_payer_wait);
                        }
                        return context.getString(R.l.appmsg_remittance_digest_receiver_wait);
                    case 3:
                        if (i3 != 0) {
                            return context.getString(R.l.appmsg_remittance_digest_receiver_collected);
                        }
                        return context.getString(R.l.appmsg_remittance_digest_payer_collected);
                    case 4:
                        if (i3 != 0) {
                            return context.getString(R.l.appmsg_remittance_digest_receiver_refused);
                        }
                        return context.getString(R.l.appmsg_remittance_digest_payer_refused);
                    default:
                        return bi.oV(gp.title);
                }
            case 436207665:
            case 469762097:
                if (gp == null) {
                    x.e("MicroMsg.SelectMemberChattingRecordUI", "decode msg content failed");
                    return "";
                } else if (i2 == 1) {
                    return context.getString(R.l.record_c2c_with_title, new Object[]{gp.dxZ, gp.dxW});
                } else {
                    return context.getString(R.l.record_c2c_with_title, new Object[]{gp.dxZ, gp.dxV});
                }
            case 503316529:
                if (gp == null) {
                    x.e("MicroMsg.SelectMemberChattingRecordUI", "decode msg content failed");
                    return "";
                } else if (i2 == 1) {
                    return context.getString(R.l.record_c2c_with_title, new Object[]{gp.dxZ, gp.dyn});
                } else {
                    return context.getString(R.l.record_c2c_with_title, new Object[]{gp.dxZ, gp.dym});
                }
            case 520093745:
                return context.getString(R.l.record_card_with_title, new Object[]{""});
            default:
                return str3;
        }
    }
}
