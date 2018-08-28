package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.plugin.account.friend.a.a;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.1;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a.10;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;

class NormalUserFooterPreference$a$1$1 implements d {
    final /* synthetic */ 1 lXz;

    NormalUserFooterPreference$a$1$1(1 1) {
        this.lXz = 1;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        a aVar = null;
        NormalUserFooterPreference normalUserFooterPreference;
        Intent intent;
        NormalUserFooterPreference.a aVar2;
        View inflate;
        TextView textView;
        CheckBox checkBox;
        switch (menuItem.getItemId()) {
            case 1:
                this.lXz.lXy.lXw.dHn.ci("hide_btn");
                this.lXz.lXy.lXw.dHn.doNotify();
                NormalUserFooterPreference.a aVar3 = this.lXz.lXy;
                normalUserFooterPreference = aVar3.lXw;
                au.HU();
                NormalUserFooterPreference.a(normalUserFooterPreference, c.FR().Yg(NormalUserFooterPreference.a(aVar3.lXw).field_username));
                if (com.tencent.mm.l.a.gd(NormalUserFooterPreference.a(aVar3.lXw).field_type)) {
                    intent = new Intent();
                    intent.putExtra("Contact_Scene", NormalUserFooterPreference.l(aVar3.lXw));
                    intent.putExtra("Contact_User", NormalUserFooterPreference.a(aVar3.lXw).field_username);
                    intent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(aVar3.lXw).getIntent().getStringExtra("Contact_RoomNickname"));
                    intent.putExtra("contact_phone_number_list", NormalUserFooterPreference.a(aVar3.lXw).csZ);
                    String str = "";
                    if (!NormalUserFooterPreference.a(aVar3.lXw).BH()) {
                        String stringExtra = NormalUserFooterPreference.b(aVar3.lXw).getIntent().getStringExtra("Contact_Mobile_MD5");
                        String stringExtra2 = NormalUserFooterPreference.b(aVar3.lXw).getIntent().getStringExtra("Contact_full_Mobile_MD5");
                        if (bi.oW(stringExtra) && bi.oW(stringExtra2)) {
                            if (!bi.oW(NormalUserFooterPreference.a(aVar3.lXw).field_username)) {
                                aVar = b.getAddrUploadStg().pp(NormalUserFooterPreference.a(aVar3.lXw).field_username);
                            }
                        } else if (!(bi.oW(stringExtra) && bi.oW(stringExtra2))) {
                            aVar = b.getAddrUploadStg().pq(stringExtra);
                            if (aVar == null || bi.oW(aVar.Xh())) {
                                aVar = b.getAddrUploadStg().pq(stringExtra2);
                            }
                        }
                        if (!(aVar == null || bi.oW(aVar.Xh()))) {
                            str = bi.oV(aVar.Xp()).replace(" ", "");
                        }
                    }
                    intent.putExtra("contact_phone_number_by_md5", str);
                    com.tencent.mm.plugin.profile.a.ezn.n(intent, aVar3.lXw.mContext);
                    return;
                }
                aVar3.JH(NormalUserFooterPreference.a(aVar3.lXw).field_username);
                return;
            case 2:
                if (NormalUserFooterPreference.a(this.lXz.lXy.lXw).BC()) {
                    s.m(NormalUserFooterPreference.a(this.lXz.lXy.lXw));
                    h.bA(NormalUserFooterPreference.b(this.lXz.lXy.lXw), NormalUserFooterPreference.b(this.lXz.lXy.lXw).getString(R.l.contact_info_unset_favour_start_biz_tips));
                } else {
                    s.l(NormalUserFooterPreference.a(this.lXz.lXy.lXw));
                    h.bA(NormalUserFooterPreference.b(this.lXz.lXy.lXw), NormalUserFooterPreference.b(this.lXz.lXy.lXw).getString(R.l.contact_info_favour_start_biz_tips));
                }
                normalUserFooterPreference = this.lXz.lXy.lXw;
                au.HU();
                NormalUserFooterPreference.a(normalUserFooterPreference, c.FR().Yg(NormalUserFooterPreference.a(this.lXz.lXy.lXw).field_username));
                return;
            case 3:
                Intent intent2 = new Intent();
                intent2.putExtra("sns_permission_userName", NormalUserFooterPreference.a(this.lXz.lXy.lXw).field_username);
                intent2.putExtra("sns_permission_anim", true);
                intent2.putExtra("sns_permission_block_scene", 1);
                com.tencent.mm.bg.d.b(NormalUserFooterPreference.b(this.lXz.lXy.lXw), "sns", ".ui.SnsPermissionUI", intent2);
                return;
            case 4:
                aVar2 = this.lXz.lXy;
                intent = new Intent();
                intent.putExtra("Select_Talker_Name", NormalUserFooterPreference.a(aVar2.lXw).field_username);
                intent.putExtra("Select_block_List", NormalUserFooterPreference.a(aVar2.lXw).field_username);
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("Select_Send_Card", true);
                intent.putExtra("mutil_select_is_ret", true);
                com.tencent.mm.plugin.profile.a.ezn.a(intent, NormalUserFooterPreference.b(aVar2.lXw));
                return;
            case 5:
                if (NormalUserFooterPreference.a(this.lXz.lXy.lXw).BA()) {
                    NormalUserFooterPreference.a.a(this.lXz.lXy);
                    return;
                }
                inflate = View.inflate(this.lXz.lXy.lXw.mContext, R.i.mm_alert_checkbox, null);
                inflate.setPadding(0, 0, 0, 0);
                textView = (TextView) inflate.findViewById(R.h.mm_alert_dialog_info);
                textView.setPadding(0, 0, 0, 0);
                textView.setText(ab.XR(NormalUserFooterPreference.a(this.lXz.lXy.lXw).field_username) ? R.l.contact_info_movein_blacklist_confirm_for_openim : R.l.contact_info_movein_blacklist_confirm);
                checkBox = (CheckBox) inflate.findViewById(R.h.mm_alert_dialog_cb);
                checkBox.setChecked(false);
                textView = (TextView) inflate.findViewById(R.h.mm_alert_dialog_cb_txt);
                textView.setText(R.l.contact_info_movein_blacklist_expose_confirm);
                if (NormalUserFooterPreference.a(this.lXz.lXy.lXw).getSource() == 18) {
                    checkBox.setVisibility(0);
                    textView.setVisibility(0);
                } else {
                    checkBox.setVisibility(8);
                    textView.setVisibility(8);
                }
                h.a(this.lXz.lXy.lXw.mContext, true, this.lXz.lXy.lXw.mContext.getString(R.l.contact_info_movein_blacklist), inflate, this.lXz.lXy.lXw.mContext.getString(R.l.app_ok), this.lXz.lXy.lXw.mContext.getString(R.l.app_cancel), new 1(this, checkBox), null);
                return;
            case 6:
                inflate = View.inflate(this.lXz.lXy.lXw.mContext, R.i.mm_alert_checkbox, null);
                inflate.setPadding(0, 0, 0, 0);
                textView = (TextView) inflate.findViewById(R.h.mm_alert_dialog_info);
                textView.setPadding(0, 0, 0, 0);
                textView.setText(s.hc(NormalUserFooterPreference.a(this.lXz.lXy.lXw).field_username) ? this.lXz.lXy.lXw.mContext.getString(R.l.del_groupcard_warning, new Object[]{NormalUserFooterPreference.a(this.lXz.lXy.lXw).BL()}) : this.lXz.lXy.lXw.mContext.getString(R.l.del_contact_warning, new Object[]{NormalUserFooterPreference.a(this.lXz.lXy.lXw).BL()}));
                checkBox = (CheckBox) inflate.findViewById(R.h.mm_alert_dialog_cb);
                checkBox.setChecked(false);
                textView = (TextView) inflate.findViewById(R.h.mm_alert_dialog_cb_txt);
                textView.setText(R.l.contact_info_movein_blacklist_expose_confirm);
                if (NormalUserFooterPreference.a(this.lXz.lXy.lXw).getSource() == 18) {
                    checkBox.setVisibility(0);
                    textView.setVisibility(0);
                } else {
                    checkBox.setVisibility(8);
                    textView.setVisibility(8);
                }
                h.a(this.lXz.lXy.lXw.mContext, true, this.lXz.lXy.lXw.mContext.getString(R.l.contact_info_delete_contact), inflate, this.lXz.lXy.lXw.mContext.getString(R.l.app_delete), this.lXz.lXy.lXw.mContext.getString(R.l.app_cancel), new 2(this, checkBox), null, R.e.alert_btn_color_warn);
                return;
            case 7:
                aVar2 = this.lXz.lXy;
                x.d("MicroMsg.NormalUserFooterPreference", "dealAddShortcut, username = " + NormalUserFooterPreference.a(aVar2.lXw).field_username);
                com.tencent.mm.plugin.base.model.b.V(NormalUserFooterPreference.b(aVar2.lXw), NormalUserFooterPreference.a(aVar2.lXw).field_username);
                ah.i(new 10(aVar2), 1000);
                return;
            case 9:
                NormalUserFooterPreference.a.c(this.lXz.lXy);
                return;
            default:
                return;
        }
    }
}
