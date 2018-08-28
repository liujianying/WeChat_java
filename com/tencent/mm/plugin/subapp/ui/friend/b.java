package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.az.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.r;

public final class b extends r<ar> {
    private Context context;
    private OnClickListener orM = new 2(this);
    private OnClickListener orN = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b) {
                x.d("MicroMsg.FMessageConversationUI", "verifyOkOnClick onClick");
                com.tencent.mm.pluginsdk.ui.preference.b bVar = (com.tencent.mm.pluginsdk.ui.preference.b) view.getTag();
                at YO = d.SE().YO(bVar.username);
                if (YO == null || YO.field_msgContent == null) {
                    x.e("MicroMsg.FMessageConversationUI", "lastRecvFmsg is null, verify fail, talker = " + bVar.username);
                    return;
                }
                bd.d YY = bd.d.YY(YO.field_msgContent);
                x.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + bVar.username + ", opcode = MM_VERIFYUSER_VERIFYOK");
                if (YY.tbU == 1) {
                    h.a(b.this.context, YY.tbV, null, b.this.context.getString(R.l.fmessage_goto_verify), b.this.context.getString(R.l.app_cancel), true, new 1(this, YO), null);
                    return;
                }
                au.HU();
                bq Hh = c.FS().Hh(bVar.username);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", bVar.username);
                intent.putExtra("Contact_Nick", bVar.nickname);
                if (Hh != null) {
                    intent.putExtra("Contact_RemarkName", Hh.field_conRemark);
                }
                if (!bi.oW(YY.chatroomName)) {
                    au.HU();
                    u ih = c.Ga().ih(YY.chatroomName);
                    if (ih != null) {
                        intent.putExtra("Contact_RoomNickname", ih.gT(YY.otZ));
                    }
                }
                intent.putExtra("Contact_Scene", YY.scene);
                intent.putExtra("Verify_ticket", YY.juZ);
                intent.putExtra("sayhi_with_sns_perm_send_verify", false);
                intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                intent.putExtra("sayhi_with_sns_perm_set_label", true);
                intent.putExtra("sayhi_with_jump_to_profile", true);
                com.tencent.mm.bg.d.b(b.this.context, "profile", ".ui.SayHiWithSnsPermissionUI", intent);
            }
        }
    };

    static class a {
        public TextView lWV;
        public MaskLayout orU;
        public Button orV;
        public Button orW;
        public TextView orX;
        public TextView orY;
        public TextView orZ;

        a() {
        }
    }

    public b(Context context) {
        super(context, new ar());
        this.context = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.context, R.i.fmessage_contact_item, null);
            a aVar2 = new a();
            aVar2.orU = (MaskLayout) view.findViewById(R.h.fmessage_contact_item_avatar);
            aVar2.lWV = (TextView) view.findViewById(R.h.fmessage_contact_item_nick_tv);
            aVar2.orZ = (TextView) view.findViewById(R.h.fmessage_contact_item_digest_tv);
            aVar2.orV = (Button) view.findViewById(R.h.fmessage_contact_add_btn);
            aVar2.orV.setOnClickListener(this.orM);
            aVar2.orW = (Button) view.findViewById(R.h.fmessage_contact_verify_ok_btn);
            aVar2.orW.setOnClickListener(this.orN);
            aVar2.orX = (TextView) view.findViewById(R.h.fmessage_contact_item_verifying_tv);
            aVar2.orY = (TextView) view.findViewById(R.h.fmessage_contact_item_added_tv);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        ar arVar = (ar) getItem(i);
        com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) aVar.orU.getContentView(), arVar.field_talker);
        aVar.lWV.setText(j.a(this.context, arVar.field_displayName, aVar.lWV.getTextSize()));
        com.tencent.mm.pluginsdk.ui.preference.b a;
        if (arVar.field_fmsgSysRowId <= 0) {
            x.w("MicroMsg.FMessageConversationUI", "getView, fconv fmsgSysRowId is invalid, try getLastFmsg");
            at YN = d.SE().YN(arVar.field_talker);
            if (YN == null) {
                x.e("MicroMsg.FMessageConversationUI", "getView, lastFmsg is null, talker = " + arVar.field_talker);
                aVar.orV.setVisibility(8);
                aVar.orW.setVisibility(8);
                aVar.orX.setVisibility(8);
                aVar.orY.setVisibility(8);
                aVar.orZ.setVisibility(8);
            } else {
                a = com.tencent.mm.pluginsdk.ui.preference.b.a(this.context, YN);
                x.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg talker = " + arVar.field_talker);
                if (arVar.field_state == 1) {
                    au.HU();
                    ab Yg = c.FR().Yg(arVar.field_talker);
                    if (!(Yg == null || ((int) Yg.dhP) == 0 || com.tencent.mm.l.a.gd(Yg.field_type))) {
                        d.SF().db(arVar.field_talker, 0);
                    }
                }
                if (a != null) {
                    x.e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + arVar.field_talker);
                    aVar.orV.setVisibility(8);
                    aVar.orW.setVisibility(8);
                    aVar.orX.setVisibility(8);
                    aVar.orY.setVisibility(8);
                    aVar.orZ.setVisibility(8);
                } else {
                    int i2;
                    a.mZZ = arVar.field_addScene;
                    aVar.orZ.setText(j.a(this.context, a.dzA, aVar.orZ.getTextSize()));
                    switch (arVar.field_state) {
                        case 0:
                            int i3;
                            if (arVar.field_fmsgSysRowId <= 0) {
                                x.w("MicroMsg.FMessageConversationUI", "getView, fmsgSysRowId invalid, try use lastRecvFmsg");
                                at YO = d.SE().YO(a.username);
                                i3 = YO == null ? 0 : YO.field_type;
                            } else {
                                i3 = arVar.field_recvFmsgType;
                            }
                            if (i3 == 0 || i3 == 3) {
                                aVar.orV.setVisibility(0);
                                aVar.orV.setTag(a);
                                aVar.orW.setVisibility(8);
                            } else {
                                aVar.orW.setVisibility(0);
                                aVar.orW.setTag(a);
                                aVar.orV.setVisibility(8);
                            }
                            aVar.orX.setVisibility(8);
                            aVar.orY.setVisibility(8);
                            break;
                        case 1:
                            aVar.orY.setVisibility(0);
                            aVar.orV.setVisibility(8);
                            aVar.orW.setVisibility(8);
                            aVar.orX.setVisibility(8);
                            break;
                        case 2:
                            aVar.orX.setVisibility(0);
                            aVar.orV.setVisibility(8);
                            aVar.orW.setVisibility(8);
                            aVar.orY.setVisibility(8);
                            break;
                        default:
                            aVar.orV.setVisibility(8);
                            aVar.orW.setVisibility(8);
                            aVar.orX.setVisibility(8);
                            aVar.orY.setVisibility(8);
                            break;
                    }
                    View findViewById = view.findViewById(R.h.fmessage_contact_item_layout);
                    if (arVar.field_isNew == 0) {
                        i2 = R.g.mm_listitem;
                    } else {
                        i2 = R.g.comm_item_highlight_selector;
                    }
                    findViewById.setBackgroundResource(i2);
                }
            }
        } else {
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(this.context, arVar.field_fmsgSysRowId, arVar.field_fmsgIsSend % 2 == 0, arVar.field_talker, arVar.field_fmsgContent, arVar.field_fmsgType, arVar.field_contentFromUsername, arVar.field_contentNickname, arVar.field_contentPhoneNumMD5, arVar.field_contentFullPhoneNumMD5, arVar.field_contentVerifyContent, arVar.field_addScene);
            x.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg sysrowid = " + arVar.field_fmsgSysRowId + ", talker = " + arVar.field_talker);
            if (arVar.field_state == 1) {
                au.HU();
                ab Yg2 = c.FR().Yg(arVar.field_talker);
                if (!(Yg2 == null || ((int) Yg2.dhP) == 0 || com.tencent.mm.l.a.gd(Yg2.field_type))) {
                    d.SF().db(arVar.field_talker, 0);
                }
            }
            if (a != null) {
                int i22;
                a.mZZ = arVar.field_addScene;
                aVar.orZ.setText(j.a(this.context, a.dzA, aVar.orZ.getTextSize()));
                switch (arVar.field_state) {
                    case 0:
                        int i32;
                        if (arVar.field_fmsgSysRowId <= 0) {
                            x.w("MicroMsg.FMessageConversationUI", "getView, fmsgSysRowId invalid, try use lastRecvFmsg");
                            at YO2 = d.SE().YO(a.username);
                            i32 = YO2 == null ? 0 : YO2.field_type;
                        } else {
                            i32 = arVar.field_recvFmsgType;
                        }
                        if (i32 == 0 || i32 == 3) {
                            aVar.orV.setVisibility(0);
                            aVar.orV.setTag(a);
                            aVar.orW.setVisibility(8);
                        } else {
                            aVar.orW.setVisibility(0);
                            aVar.orW.setTag(a);
                            aVar.orV.setVisibility(8);
                        }
                        aVar.orX.setVisibility(8);
                        aVar.orY.setVisibility(8);
                        break;
                    case 1:
                        aVar.orY.setVisibility(0);
                        aVar.orV.setVisibility(8);
                        aVar.orW.setVisibility(8);
                        aVar.orX.setVisibility(8);
                        break;
                    case 2:
                        aVar.orX.setVisibility(0);
                        aVar.orV.setVisibility(8);
                        aVar.orW.setVisibility(8);
                        aVar.orY.setVisibility(8);
                        break;
                    default:
                        aVar.orV.setVisibility(8);
                        aVar.orW.setVisibility(8);
                        aVar.orX.setVisibility(8);
                        aVar.orY.setVisibility(8);
                        break;
                }
                View findViewById2 = view.findViewById(R.h.fmessage_contact_item_layout);
                if (arVar.field_isNew == 0) {
                    i22 = R.g.mm_listitem;
                } else {
                    i22 = R.g.comm_item_highlight_selector;
                }
                findViewById2.setBackgroundResource(i22);
            } else {
                x.e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + arVar.field_talker);
                aVar.orV.setVisibility(8);
                aVar.orW.setVisibility(8);
                aVar.orX.setVisibility(8);
                aVar.orY.setVisibility(8);
                aVar.orZ.setVisibility(8);
            }
        }
        return view;
    }

    public final void WT() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            setCursor(d.SF().axc());
            notifyDataSetChanged();
            return;
        }
        ah.A(new Runnable() {
            public final void run() {
                b.this.setCursor(d.SF().axc());
                b.this.notifyDataSetChanged();
            }
        });
    }

    protected final void WS() {
        aYc();
        WT();
    }
}
