package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class RoomRightUI extends MMPreference implements e {
    private ProgressDialog eHw = null;
    private f eOE;
    private String hNJ = "";
    private int hNK = 0;

    public final int Ys() {
        return R.o.room_right_ui;
    }

    private void aAP() {
        au.HU();
        int a = bi.a((Integer) c.DT().get(135175, null), 0);
        Preference ZZ = this.eOE.ZZ("settings_room_size");
        if (ZZ != null && a > 0) {
            ZZ.setSummary(getResources().getQuantityString(R.j.room_size_count, a, new Object[]{Integer.valueOf(a)}));
            ZZ.setEnabled(false);
        } else if (ZZ != null) {
            this.eOE.c(ZZ);
        }
        this.eOE.ZZ("room_right_max_tip").setTitle(getString(R.l.room_right_max_tip, new Object[]{Integer.valueOf(a)}));
        au.HU();
        int a2 = bi.a((Integer) c.DT().get(135176, null), 0);
        RoomGrantPreference roomGrantPreference = (RoomGrantPreference) this.eOE.ZZ("settings_room_grant");
        if (roomGrantPreference != null && a2 <= 0) {
            this.eOE.c(roomGrantPreference);
        } else if (roomGrantPreference != null) {
            roomGrantPreference.setEnabled(false);
            CharSequence charSequence = getString(R.l.room_right_room_size_num, new Object[]{Integer.valueOf(a2)});
            roomGrantPreference.eGB = charSequence;
            if (roomGrantPreference.hND != null) {
                roomGrantPreference.hND.setText(charSequence);
            }
        }
        Preference ZZ2 = this.eOE.ZZ("room_right_tip");
        Preference ZZ3 = this.eOE.ZZ("room_right_grant_tip");
        if (a2 <= 0) {
            if (ZZ2 != null) {
                this.eOE.c(ZZ2);
            }
            if (ZZ3 != null) {
                this.eOE.c(ZZ3);
            }
            Preference ZZ4 = this.eOE.ZZ("room_grant_to_friend");
            if (ZZ4 != null) {
                this.eOE.c(ZZ4);
            }
            if (roomGrantPreference != null) {
                this.eOE.c(roomGrantPreference);
                return;
            }
            return;
        }
        CharSequence string = getString(R.l.room_right_tip, new Object[]{Integer.valueOf(a2), Integer.valueOf(a)});
        if (ZZ2 != null) {
            ZZ2.setTitle(string);
        }
        string = getString(R.l.room_right_grant_tip, new Object[]{Integer.valueOf(this.hNK)});
        if (ZZ3 != null) {
            ZZ3.setTitle(string);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        au.HU();
        this.hNK = bi.a((Integer) c.DT().get(135177, null), 0);
        au.DF().a(339, this);
        au.DF().a(30, this);
        au.HU();
        c.DT().set(135184, Boolean.valueOf(false));
        initView();
    }

    public void onResume() {
        super.onResume();
        aAP();
        this.eOE.notifyDataSetChanged();
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.mKey.equals("room_grant_to_friend")) {
            Intent intent = new Intent();
            intent.setClassName(ad.getPackageName(), ad.getPackageName() + ".ui.contact.SelectContactUI");
            intent.putExtra("Contact_GroupFilter_Type", "@all.contact.without.chatroom");
            intent.putExtra("List_Type", 4);
            intent.putExtra("select_contact_pick_result", true);
            List linkedList = new LinkedList();
            linkedList.add("officialaccounts");
            intent.putExtra("Block_list", bi.c(linkedList, ","));
            intent.putExtra("Add_SendCard", true);
            intent.putExtra("is_multi_select", false);
            startActivityForResult(intent, 1);
        }
        return false;
    }

    public void onDestroy() {
        super.onDestroy();
        au.DF().b(339, this);
        au.DF().b(30, this);
    }

    protected final void initView() {
        this.eOE = this.tCL;
        setMMTitle(R.l.settings_room_size);
        setBackBtn(new 1(this));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.RoomRightUI", "onAcvityResult requestCode: %d", new Object[]{Integer.valueOf(i)});
        if (i2 == -1 && intent != null) {
            switch (i) {
                case 1:
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    x.d("MicroMsg.RoomRightUI", "pick user %s", new Object[]{stringExtra});
                    if (!bi.oW(stringExtra)) {
                        this.hNJ = stringExtra;
                        stringExtra = this.hNJ;
                        au.HU();
                        ab Yg = c.FR().Yg(stringExtra);
                        h.a(this.mController.tml, getString(R.l.room_grant_to_conf, new Object[]{Yg.BL(), Integer.valueOf(this.hNK)}), "", new 2(this, stringExtra), null);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void J(final LinkedList<String> linkedList) {
        Assert.assertTrue(linkedList.size() > 0);
        String string = ad.getContext().getString(R.l.chatroom_sys_msg_invite_split);
        linkedList.size();
        int i = R.l.room_right_need_vertify;
        Object[] objArr = new Object[1];
        List linkedList2 = new LinkedList();
        if (au.HX()) {
            for (String gT : linkedList) {
                linkedList2.add(r.gT(gT));
            }
        }
        objArr[0] = bi.c(linkedList2, string);
        h.a(this, getString(i, objArr), getString(R.l.app_tip), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                RoomRightUI.a(RoomRightUI.this, linkedList);
            }
        });
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.RoomRightUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eHw != null) {
            this.eHw.dismiss();
        }
        if (lVar.getType() == 339) {
            String str2;
            au.HU();
            ab Yg = c.FR().Yg(this.hNJ);
            if (Yg == null || ((int) Yg.dhP) == 0) {
                str2 = this.hNJ;
            } else {
                str2 = Yg.BL();
            }
            if (i == 0 && i2 == 0) {
                h.b(this, getString(R.l.room_grant_to_friend_ok, new Object[]{str2}), getString(R.l.app_tip), true);
                if (this.eOE != null) {
                    aAP();
                    this.eOE.notifyDataSetChanged();
                }
            } else if (i2 == -251) {
                h.b(this, getString(R.l.room_grant_to_friend_error, new Object[]{str2, Integer.valueOf(this.hNK)}), getString(R.l.app_tip), true);
            } else if (i2 == -44) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(this.hNJ);
                J(linkedList);
            } else if (i2 == -22) {
                h.b(this, getString(R.l.room_grant_to_friend_error_black, new Object[]{str2}), getString(R.l.app_tip), true);
            } else {
                Toast.makeText(this, "err :" + i + " ," + i2, 0).show();
            }
        }
    }
}
