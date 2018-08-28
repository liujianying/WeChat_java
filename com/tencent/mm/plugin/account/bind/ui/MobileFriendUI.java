package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.a$f;
import com.tencent.mm.plugin.account.a$g;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l$a;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.o;
import java.util.List;

public class MobileFriendUI extends MMActivity implements e {
    private ProgressDialog eHw = null;
    private ListView eIM;
    b eIN;
    private View eIO;
    private al eIP;
    String eIQ;
    private TextView eIR = null;
    private TextView emptyTipTv = null;

    static /* synthetic */ void e(MobileFriendUI mobileFriendUI) {
        if (l.XC() != l$a.SUCC && l.XC() != l$a.SUCC_UNLOAD) {
            mobileFriendUI.eIO.setVisibility(0);
            mobileFriendUI.eIO.setOnClickListener(new 7(mobileFriendUI));
            mobileFriendUI.eIM.setVisibility(8);
            mobileFriendUI.emptyTipTv.setVisibility(8);
        } else if (mobileFriendUI.eIN.getCount() <= 0) {
            mobileFriendUI.emptyTipTv.setVisibility(0);
            mobileFriendUI.eIM.setVisibility(8);
            mobileFriendUI.eIO.setVisibility(8);
        } else {
            mobileFriendUI.emptyTipTv.setVisibility(8);
            mobileFriendUI.eIM.setVisibility(0);
            mobileFriendUI.eIO.setVisibility(8);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(j.mobile_friend_title);
        ((b) ((a) g.n(a.class)).getAddrUploadStg()).dCZ.fV("qqlist", "update addr_upload2 set reserved4=0");
        g.DF().a(32, this);
        g.DF().a(133, this);
        initView();
        x.i("MicroMsg.MobileFriendUI", "summerper checkPermission checkContacts[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null))});
        if (com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            getData();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.MobileFriendUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case f$k.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    getData();
                    return;
                } else {
                    h.a(this, getString(j.permission_contacts_request_again_msg), getString(j.permission_tips_title), getString(j.jump_to_settings), getString(j.app_cancel), false, new 1(this), new 8(this));
                    return;
                }
            default:
                return;
        }
    }

    private void getData() {
        if (!l.XB()) {
            ActionBarActivity actionBarActivity = this.mController.tml;
            getString(j.app_tip);
            this.eHw = h.a(actionBarActivity, getString(j.mobile_friend_loading), true, new 9(this));
            if (this.eIN.getCount() != 0) {
                List XJ = l.XJ();
                List XI = l.XI();
                if (XJ.size() == 0 && XI.size() == 0) {
                    g.DF().a(new ab(), 0);
                    return;
                }
                this.eIP = new al(l.XJ(), l.XI());
                g.DF().a(this.eIP, 0);
            } else if (!((a) g.n(a.class)).syncAddrBook(new 10(this)) && this.eHw != null) {
                this.eHw.dismiss();
                this.eHw = null;
            }
        }
    }

    protected void onResume() {
        super.onResume();
        this.eIN.notifyDataSetChanged();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        f.iU("2");
        g.DF().b(32, this);
        g.DF().b(133, this);
        this.eIN.aYc();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return a$g.mobile_friend;
    }

    protected final void initView() {
        boolean z;
        this.emptyTipTv = (TextView) findViewById(a$f.mobile_friend_empty_msg_tip_tv);
        this.emptyTipTv.setText(j.mobile_friend_empty_qmsg_tip);
        this.eIR = (TextView) findViewById(a$f.empty_mobile_friend_search_tip_tv);
        this.eIR.setText(j.mobile_search_no_friend);
        this.eIO = findViewById(a$f.mobile_friend_mobile_not_bind_ll);
        this.eIM = (ListView) findViewById(a$f.mobile_friend_lv);
        o oVar = new o((byte) 0);
        oVar.uBw = new 11(this);
        a(oVar);
        if (com.tencent.mm.model.a.g.IW().iP("2") != null) {
            String str = com.tencent.mm.model.a.g.IW().iP("2").value;
            if (str.equals("0")) {
                z = false;
            } else if (str.equals("1")) {
                z = true;
            } else {
                z = true;
            }
            f.iT("2");
        } else {
            z = true;
        }
        x.i("MicroMsg.MobileFriendUI", "ABTest Type, NEW(%B)", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.eIN = new d(this, new 13(this));
        } else {
            this.eIN = new c(this, new 12(this));
        }
        this.eIM.setAdapter(this.eIN);
        this.eIM.setOnItemClickListener(new 14(this));
        this.eIN.a(new 15(this));
        if (!(l.XC() == l$a.SUCC || l.XC() == l$a.SUCC_UNLOAD)) {
            this.eIO = findViewById(a$f.mobile_friend_mobile_not_bind_ll);
            this.eIO.setVisibility(0);
            this.eIO.setOnClickListener(new 2(this));
            this.eIM.setVisibility(8);
        }
        setBackBtn(new 3(this));
        4 4 = new 4(this);
        if (!q.Hi() || l.XB()) {
            h.a(this, j.bind_mcontact_bind_alert_content, j.app_tip, j.app_ok, j.app_cancel, new 5(this), new 6(this));
        }
    }

    public final void b(com.tencent.mm.plugin.account.friend.a.a aVar) {
        if (bi.oW(aVar.getUsername())) {
            x.e("MicroMsg.MobileFriendUI", "username is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", aVar.getUsername());
        intent.putExtra("Contact_Nick", aVar.Xm());
        intent.putExtra("Contact_Mobile_MD5", aVar.Xh());
        intent.putExtra("Contact_Alias", aVar.eJM);
        intent.putExtra("Contact_Sex", aVar.eJH);
        intent.putExtra("Contact_Signature", aVar.eJK);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.aq(aVar.eJQ, aVar.eJI, aVar.eJJ));
        intent.putExtra("Contact_Scene", 13);
        intent.putExtra("Contact_ShowUserName", false);
        com.tencent.mm.plugin.account.a.a.ezn.d(intent, this);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (lVar.getType() == 32 && this.eHw != null) {
            this.eHw.dismiss();
            this.eHw = null;
        }
        if (!(i == 0 && i2 == 0)) {
            x.e("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + i + ", errCode = " + i2);
        }
        if (lVar.getType() == 133) {
            g.DF().a(new ab(), 0);
        }
        if (i == 0 && i2 == 0) {
            if (lVar.getType() == 32) {
                ((a) g.n(a.class)).updateAllContact();
            }
            this.eIN.a(null, null);
        } else if (lVar.getType() == 32) {
            Toast.makeText(this, j.mobile_friend_err, 0).show();
        }
    }
}
