package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.aty;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ManageChatroomUI extends MMPreference {
    private SharedPreferences duR = null;
    private f eOE;
    CheckBoxPreference hMP;
    private String hMQ;
    private String hMR;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.ManageChatroomUI", "[onCreate]");
        this.hMQ = getIntent().getStringExtra("RoomInfo_Id");
        this.hMR = getIntent().getStringExtra("room_owner_name");
        this.eOE = this.tCL;
        if (this.eOE != null) {
            setMMTitle(R.l.manage_chatroom_title);
            this.hMP = (CheckBoxPreference) this.eOE.ZZ("allow_by_identity");
            this.eOE.bw("select_enable_qrcode", true);
            this.eOE.bw("select_into_room_type", true);
            setBackBtn(new 1(this));
        }
    }

    protected void onResume() {
        boolean z = false;
        au.HU();
        u ih = c.Ga().ih(this.hMQ);
        if (ih != null && this.duR == null) {
            this.duR = getSharedPreferences(getPackageName() + "_preferences", 0);
            Editor edit = this.duR.edit();
            String str = "allow_by_identity";
            if (ih.ckN() == 2) {
                z = true;
            }
            edit.putBoolean(str, z).commit();
        }
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public final int Ys() {
        return R.o.manage_room_pref;
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 2;
        String str = preference.mKey;
        x.d("MicroMsg.ManageChatroomUI", "[onPreferenceTreeClick] key:%s", new Object[]{str});
        if (str.equals("room_transfer_room_ower")) {
            x.i("MicroMsg.ManageChatroomUI", "[selectNewRoomOwner] roomId:%s", new Object[]{this.hMQ});
            str = bi.c(m.gI(this.hMQ), ",");
            Intent intent = new Intent();
            intent.putExtra("Block_list", q.GF());
            intent.putExtra("Chatroom_member_list", str);
            intent.putExtra("frome_scene", 2);
            intent.putExtra("RoomInfo_Id", this.hMQ);
            intent.putExtra("is_show_owner", false);
            intent.putExtra("title", getString(R.l.room_select_new_owner));
            intent.setClass(this, SelectMemberUI.class);
            startActivity(intent);
        } else if (str.equals("allow_by_identity")) {
            boolean isChecked = this.hMP.isChecked();
            h.mEJ.a(219, 22, 1, true);
            x.i("MicroMsg.ManageChatroomUI", "[selectAllowByIdentity] roomId:%s isOpen:%s", new Object[]{this.hMQ, Boolean.valueOf(isChecked)});
            aty aty = new aty();
            aty.rvj = bi.oV(this.hMQ);
            if (!isChecked) {
                i = 0;
            }
            aty.mEc = i;
            a aVar = new a(66, aty);
            au.HU();
            c.FQ().b(aVar);
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    x.i("MicroMsg.ManageChatroomUI", "[openVerify] roomId:%s, type:%s", new Object[]{this.hMQ, Integer.valueOf(intent.getIntExtra("into_room_type", -1))});
                    aty aty = new aty();
                    aty.rvj = bi.oV(this.hMQ);
                    aty.mEc = r0;
                    a aVar = new a(66, aty);
                    au.HU();
                    c.FQ().b(aVar);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
