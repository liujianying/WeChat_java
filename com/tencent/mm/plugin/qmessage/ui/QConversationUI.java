package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.qmessage.a.c;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.c.aem;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n$d;
import com.tencent.mm.ui.widget.b.a;
import junit.framework.Assert;

public class QConversationUI extends MMActivity implements e {
    private TextView emptyTipTv;
    private n$d hlb = new 5(this);
    private ab ipd;
    private boolean isDeleteCancel = false;
    private boolean lbe = false;
    private ListView mbN;
    private c mbO;
    private c mbP;
    private boolean mbQ = false;
    private String mbR;
    private String mbS;
    private boolean mbT = false;
    private String mbU;

    static /* synthetic */ void a(QConversationUI qConversationUI, String str, String str2) {
        if (str == null) {
            x.d("MicroMsg.QConversationUI", "jacks open QQ appId == null");
            return;
        }
        f bl = g.bl(str, true);
        if (bl == null || !p.r(qConversationUI.mController.tml, bl.field_packageName)) {
            if (bi.oW(str2)) {
                str2 = p.y(qConversationUI.mController.tml, str, "message");
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str2);
            d.b(qConversationUI.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
        } else if (bl.field_status == 3) {
            x.e("MicroMsg.QConversationUI", "requestAppShow fail, app is in blacklist, packageName = " + bl.field_packageName);
        } else if (p.b(qConversationUI.mController.tml, bl)) {
            x.d("MicroMsg.QConversationUI", "jacks open QQ");
            Intent intent2 = new Intent("android.intent.action.MAIN", null);
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.addFlags(268435456);
            intent2.setClassName(bl.field_packageName, aF(qConversationUI.mController.tml, bl.field_packageName));
            intent2.putExtra("platformId", "wechat");
            au.HU();
            Object obj = com.tencent.mm.model.c.DT().get(9, null);
            int intValue = (obj == null || !(obj instanceof Integer)) ? 0 : ((Integer) obj).intValue();
            if (intValue != 0) {
                try {
                    byte[] bytes = String.valueOf(intValue).getBytes("utf-8");
                    byte[] bytes2 = "asdfghjkl;'".getBytes("utf-8");
                    int length = bytes2.length;
                    intValue = 0;
                    int i = 0;
                    while (intValue < length) {
                        byte b = bytes2[intValue];
                        if (i >= bytes.length) {
                            break;
                        }
                        int i2 = i + 1;
                        bytes[i] = (byte) (b ^ bytes[i]);
                        intValue++;
                        i = i2;
                    }
                    intent2.putExtra("tencent_gif", bytes);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.QConversationUI", e, "", new Object[0]);
                }
            }
            try {
                qConversationUI.startActivity(intent2);
            } catch (Exception e2) {
            }
        } else {
            x.e("MicroMsg.QConversationUI", "The app %s signature is incorrect.", new Object[]{bl.field_appName});
            Toast.makeText(qConversationUI.mController.tml, qConversationUI.getString(R.l.game_launch_fail_alert, new Object[]{g.b(qConversationUI.mController.tml, bl, null)}), 1).show();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.tmessage;
    }

    public void onDestroy() {
        this.mbO.aYc();
        if (this.mbP != null) {
            au.DF().c(this.mbP);
            au.DF().b(this.mbP.getType(), this);
            this.mbP = null;
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        bof();
        au.HU();
        com.tencent.mm.model.c.FW().a(this.mbO);
        this.mbO.a(null, null);
    }

    private static void bof() {
        au.HU();
        bd sx = com.tencent.mm.model.c.FT().sx(2);
        if (sx != null && sx.field_msgId > 0) {
            x.d("MicroMsg.QConversationUI", "resetUnread: lastReadTime = " + sx.field_createTime);
            au.HU();
            com.tencent.mm.model.c.DT().set(12295, Long.valueOf(sx.field_createTime));
        }
        au.HU();
        ai Yq = com.tencent.mm.model.c.FW().Yq("qmessage");
        if (Yq == null || bi.oV(Yq.field_username).length() <= 0) {
            x.e("MicroMsg.QConversationUI", "resetUnread: can not find QMessage");
            return;
        }
        Yq.eV(0);
        au.HU();
        if (com.tencent.mm.model.c.FW().a(Yq, Yq.field_username) == -1) {
            x.e("MicroMsg.QConversationUI", "reset qmessage unread failed");
        }
    }

    public void onPause() {
        x.v("MicroMsg.QConversationUI", "on pause");
        au.HU();
        com.tencent.mm.model.c.FW().b(this.mbO);
        bof();
        this.mbO.onPause();
        super.onPause();
    }

    protected final void initView() {
        this.lbe = getIntent().getBooleanExtra("finish_direct", false);
        x.d("MicroMsg.QConversationUI", "isFromSearch  " + this.lbe);
        au.HU();
        this.ipd = com.tencent.mm.model.c.FR().Yg("qmessage");
        String str = "can not find qmessage";
        boolean z = this.ipd != null && ((int) this.ipd.dhP) > 0;
        Assert.assertTrue(str, z);
        this.mbN = (ListView) findViewById(R.h.tmessage_lv);
        this.emptyTipTv = (TextView) findViewById(R.h.empty_msg_tip_tv);
        this.emptyTipTv.setText(R.l.empty_qmsg_tip);
        this.mbO = new c(this, new 1(this));
        this.mbO.setGetViewPositionCallback(new 6(this));
        this.mbO.setPerformItemClickListener(new 7(this));
        this.mbO.a(new 8(this));
        this.mbN.setAdapter(this.mbO);
        this.mbN.setOnItemClickListener(new 9(this));
        this.mbN.setOnItemLongClickListener(new 10(this, new a(this)));
        com.tencent.mm.plugin.qmessage.a.mbs.eu(1010);
        setBackBtn(new 11(this));
        12 12 = new 12(this);
        au.HU();
        this.mbR = (String) com.tencent.mm.model.c.DT().get(77, "");
        au.HU();
        this.mbS = (String) com.tencent.mm.model.c.DT().get(78, "");
        if (this.mbP == null) {
            this.mbP = new c();
            au.DF().a(this.mbP.getType(), this);
        }
        au.DF().a(this.mbP, 0);
        bog();
        com.tencent.mm.plugin.qmessage.a.mbs.eu(1010);
    }

    private static String aF(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            Intent intent = new Intent("android.intent.action.MAIN", null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(packageInfo.packageName);
            ResolveInfo resolveInfo = (ResolveInfo) packageManager.queryIntentActivities(intent, 0).iterator().next();
            if (resolveInfo != null) {
                return resolveInfo.activityInfo.name;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.QConversationUI", e, "", new Object[0]);
        }
        return null;
    }

    private void bog() {
        this.mController.removeAllOptionMenu();
        if (!bi.oW(this.mbR)) {
            this.mbQ = true;
            addIconOptionMenu(0, R.l.actionbar_open_qq, R.k.qq, new 13(this));
        }
        addIconOptionMenu(2, R.l.actionbar_setting, R.k.actionbar_setting_icon, new 2(this));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        if (this.lbe) {
            finish();
            return;
        }
        Intent intent = new Intent();
        intent.addFlags(67108864);
        com.tencent.mm.plugin.qmessage.a.ezn.q(intent, this);
        overridePendingTransition(R.a.anim_not_change, R.a.pop_out);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        ai aiVar = (ai) this.mbO.getItem(((AdapterContextMenuInfo) contextMenuInfo).position);
        au.HU();
        contextMenu.setHeaderTitle(com.tencent.mm.model.c.FR().Yg(aiVar.field_username).BL());
        contextMenu.add(0, 0, 0, R.l.main_delete);
        this.mbU = aiVar.field_username;
    }

    public final void a(int i, int i2, String str, l lVar) {
        String str2 = null;
        x.d("MicroMsg.QConversationUI", "on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (lVar.getType()) {
            case 630:
                if (i == 0 && i2 == 0) {
                    Object obj;
                    String str3;
                    c cVar = (c) lVar;
                    if (cVar.ejL != null) {
                        aem aem = (aem) cVar.ejL.dIE.dIL;
                        if (aem != null) {
                            obj = aem.rIA;
                            if (cVar.ejL != null) {
                                aem = (aem) cVar.ejL.dIE.dIL;
                                if (aem != null) {
                                    str3 = aem.rcY;
                                    if (cVar.ejL != null) {
                                        aem = (aem) cVar.ejL.dIE.dIL;
                                        if (aem != null) {
                                            str2 = aem.rIB;
                                        }
                                    }
                                    if (!bi.oW(str2)) {
                                        this.mbR = str2;
                                        au.HU();
                                        com.tencent.mm.model.c.DT().set(77, str2);
                                    }
                                    this.mbS = str3;
                                    au.HU();
                                    com.tencent.mm.model.c.DT().set(78, str3);
                                    if (!this.mbQ) {
                                        bog();
                                    }
                                    x.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[]{obj, str3, str2});
                                    return;
                                }
                            }
                            str3 = null;
                            if (cVar.ejL != null) {
                                aem = (aem) cVar.ejL.dIE.dIL;
                                if (aem != null) {
                                    str2 = aem.rIB;
                                }
                            }
                            if (bi.oW(str2)) {
                                this.mbR = str2;
                                au.HU();
                                com.tencent.mm.model.c.DT().set(77, str2);
                            }
                            this.mbS = str3;
                            au.HU();
                            com.tencent.mm.model.c.DT().set(78, str3);
                            if (this.mbQ) {
                                bog();
                            }
                            x.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[]{obj, str3, str2});
                            return;
                        }
                    }
                    String obj2 = null;
                    if (cVar.ejL != null) {
                        aem = (aem) cVar.ejL.dIE.dIL;
                        if (aem != null) {
                            str3 = aem.rcY;
                            if (cVar.ejL != null) {
                                aem = (aem) cVar.ejL.dIE.dIL;
                                if (aem != null) {
                                    str2 = aem.rIB;
                                }
                            }
                            if (!bi.oW(str2)) {
                                this.mbR = str2;
                                au.HU();
                                com.tencent.mm.model.c.DT().set(77, str2);
                            }
                            this.mbS = str3;
                            au.HU();
                            com.tencent.mm.model.c.DT().set(78, str3);
                            if (!this.mbQ) {
                                bog();
                            }
                            x.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[]{obj2, str3, str2});
                            return;
                        }
                    }
                    str3 = null;
                    if (cVar.ejL != null) {
                        aem = (aem) cVar.ejL.dIE.dIL;
                        if (aem != null) {
                            str2 = aem.rIB;
                        }
                    }
                    if (bi.oW(str2)) {
                        this.mbR = str2;
                        au.HU();
                        com.tencent.mm.model.c.DT().set(77, str2);
                    }
                    this.mbS = str3;
                    au.HU();
                    com.tencent.mm.model.c.DT().set(78, str3);
                    if (this.mbQ) {
                        bog();
                    }
                    x.d("MicroMsg.QConversationUI", "diaplayName: %s, url: %s, qqScheme: %s", new Object[]{obj2, str3, str2});
                    return;
                }
                return;
            default:
                return;
        }
    }
}
