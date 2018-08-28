package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ActivityOptions;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ax.e;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.p.a;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceInfoCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e.i;
import java.util.Map;

public class AddMoreFriendsUI extends MMPreference {
    private f eOE;
    private final int otl = 4;
    private final int otm = 9;

    public final int Ys() {
        return R.o.add_more_friends;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onResume() {
        CharSequence string;
        super.onResume();
        if (d.QS("brandservice")) {
            this.eOE.bw("find_friends_by_web", false);
        } else {
            this.eOE.bw("find_friends_by_web", true);
        }
        this.eOE.notifyDataSetChanged();
        AddFriendSearchPreference addFriendSearchPreference = (AddFriendSearchPreference) this.eOE.ZZ("find_friends_by_input");
        addFriendSearchPreference.otd = getString(R.l.contact_search_account_hint);
        addFriendSearchPreference.otf = new 3(this);
        PreferenceInfoCategory preferenceInfoCategory = (PreferenceInfoCategory) this.eOE.ZZ("find_friends_info");
        String GF = q.GF();
        String GG = q.GG();
        au.HU();
        String Ww = ap.Ww((String) c.DT().get(6, null));
        if (!bi.oW(GG)) {
            string = getString(R.l.find_friends_my_account, new Object[]{GG});
        } else if (!ab.XT(GF)) {
            string = getString(R.l.find_friends_my_account, new Object[]{GF});
        } else if (bi.oW(Ww)) {
            string = getString(R.l.find_friends_my_qrcode);
        } else {
            string = getString(R.l.find_friends_my_mobile, new Object[]{ap.Wv(Ww)});
        }
        preferenceInfoCategory.setTitle(string);
        preferenceInfoCategory.tgI = R.g.info_qr_code;
        4 4 = new 4(this);
        preferenceInfoCategory.tDA = 4;
        preferenceInfoCategory.tDB = 4;
        ((AddFriendItemPreference) this.eOE.ZZ("find_friends_create_pwdgroup")).mQk = 8;
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        sendBroadcast(intent);
        if (this.tCL != null) {
            Preference ZZ = this.tCL.ZZ("find_friends_by_web");
            if (ZZ != null) {
                ZZ.setEnabled(true);
            }
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        if ("find_friends_by_qrcode".equals(preference.mKey)) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 1);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
            intent.setFlags(65536);
            h.mEJ.h(11265, new Object[]{Integer.valueOf(1)});
            if (!(a.bx(this) || e.Sz())) {
                d.b(this, "scanner", ".ui.BaseScanUI", intent);
            }
            return true;
        } else if ("find_friends_by_other_way".equals(preference.mKey)) {
            if (l.XC() != l.a.eKt) {
                intent = new Intent(this, BindMContactIntroUI.class);
                intent.putExtra("key_upload_scene", 6);
                MMWizardActivity.D(this, intent);
                return true;
            }
            startActivity(new Intent(this, MobileFriendUI.class));
            return true;
        } else if ("find_friends_by_web".equals(preference.mKey)) {
            if (p.zO(0)) {
                ((com.tencent.mm.plugin.websearch.api.i) g.l(com.tencent.mm.plugin.websearch.api.i.class)).a(ad.getContext(), new Runnable() {
                    public final void run() {
                        Intent adR = p.adR();
                        adR.putExtra("KRightBtn", true);
                        adR.putExtra("ftsneedkeyboard", true);
                        adR.putExtra("key_load_js_without_delay", true);
                        adR.putExtra("ftsType", 1);
                        adR.putExtra("ftsbizscene", 9);
                        Map b = p.b(9, true, 0);
                        String zK = p.zK(bi.WU((String) b.get("scene")));
                        b.put("sessionId", zK);
                        b.put("subSessionId", zK);
                        adR.putExtra("sessionId", zK);
                        adR.putExtra("subSessionId", zK);
                        adR.putExtra("rawUrl", p.v(b));
                        Bundle bundle = null;
                        if (VERSION.SDK_INT >= 21) {
                            bundle = ActivityOptions.makeSceneTransitionAnimation(AddMoreFriendsUI.this, new Pair[0]).toBundle();
                        }
                        d.a(AddMoreFriendsUI.this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", adR, bundle);
                    }
                });
                preference.setEnabled(false);
            } else {
                x.e("MicroMsg.AddMoreFriendsUI", "fts h5 template not avail");
            }
            return true;
        } else if ("find_friends_by_radar".equals(preference.mKey)) {
            d.A(this, "radar", ".ui.RadarSearchUI");
            return true;
        } else if ("find_friends_create_pwdgroup".equals(preference.mKey)) {
            h.mEJ.h(11140, new Object[]{Integer.valueOf(1)});
            d.A(this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
            return true;
        } else if (!"find_friends_by_invite".equals(preference.mKey)) {
            return false;
        } else {
            int intExtra = getIntent().getIntExtra("invite_friend_scene", 4);
            h.mEJ.h(14034, new Object[]{Integer.valueOf(intExtra)});
            Intent intent2 = new Intent(this, InviteFriendsBy3rdUI.class);
            intent2.putExtra("Invite_friends", intExtra);
            startActivity(intent2);
            return true;
        }
    }

    protected final void initView() {
        setMMTitle(R.l.add_more_friends_title);
        this.eOE = this.tCL;
        AddFriendItemPreference addFriendItemPreference = new AddFriendItemPreference(this.mController.tml);
        addFriendItemPreference.setKey("find_friends_by_invite");
        addFriendItemPreference.setTitle(R.l.find_friends_by_invite_friend);
        int i = R.k.addfriend_icon_invite;
        addFriendItemPreference.Hu = i;
        Drawable drawable = addFriendItemPreference.mContext.getResources().getDrawable(i);
        if ((drawable == null && addFriendItemPreference.hh != null) || !(drawable == null || addFriendItemPreference.hh == drawable)) {
            addFriendItemPreference.hh = drawable;
            addFriendItemPreference.notifyChanged();
        }
        addFriendItemPreference.setSummary(R.l.find_friends_by_invite_friend_summary);
        if ((bi.getInt(com.tencent.mm.k.g.AT().getValue("InviteFriendsControlFlags"), 0) & 4) > 0) {
            this.eOE.a(addFriendItemPreference, 4);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AddMoreFriendsUI.this.finish();
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }
}
