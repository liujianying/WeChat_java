package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.rd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.appbrand.a;
import com.tencent.mm.ui.base.n$d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.conversation.BaseConversationUI.b;
import com.tencent.mm.ui.tools.k;
import java.math.BigInteger;
import java.util.List;

@Keep
public class AppBrandServiceConversationUI$AppBrandServiceConversationFmUI extends b implements n$d {
    private static final int CONTEXT_MENU_LONGCLICK_ACCEPT_MSG = 1;
    private static final int CONTEXT_MENU_LONGCLICK_DELETE = 3;
    private static final int CONTEXT_MENU_LONGCLICK_REFUSE_MSG = 2;
    private static final String TAG = "MicroMsg.AppBrandServiceConversationFmUI";
    private d adapter;
    private a appBrandServiceActionSheet;
    private ListView appbrandMessageLV;
    private k contextMenuHelper;
    private ai conversation;
    private TextView emptyTipTv;
    private int fromScene;
    private boolean isDeleteCancel = false;
    private String mAppId;
    private String mSceneId;
    private String superUsername;
    private String talker = "";
    private p tipDialog = null;

    public void onActivityCreated(Bundle bundle) {
        x.i(TAG, "onActivityCreated");
        super.onActivityCreated(bundle);
        this.superUsername = getStringExtra("Contact_User");
        if (TextUtils.isEmpty(this.superUsername)) {
            this.superUsername = "appbrandcustomerservicemsg";
        }
        this.fromScene = getIntExtra("app_brand_conversation_from_scene", 1);
        x.i(TAG, "fromScene:%d", new Object[]{Integer.valueOf(this.fromScene)});
        au.HU();
        this.mSceneId = System.currentTimeMillis() + intToString(c.Df());
        initView();
        addIconOptionMenu(1, R.k.app_brand_setting, new 1(this));
        au.HU();
        c.FW().a(this.adapter);
        cleadAllServiceAppBrandUnreadCount();
        enterConversationReport();
        batchSyncForWxaContact();
    }

    private void cleadAllServiceAppBrandUnreadCount() {
        com.tencent.mm.sdk.b.a.sFg.m(new o());
    }

    protected int getLayoutId() {
        return R.i.tmessage;
    }

    public String getUserName() {
        return this.superUsername;
    }

    public void onDestroy() {
        if (au.HX()) {
            au.HU();
            c.FW().b(this.adapter);
        }
        batchSyncForWxaContact();
        if (this.adapter != null) {
            this.adapter.onDestroy();
        }
        super.onDestroy();
    }

    public void onResume() {
        x.i(TAG, "on resume");
        if (this.adapter != null) {
            this.adapter.onResume();
        }
        super.onResume();
    }

    public void onPause() {
        x.i(TAG, "on pause");
        au.HU();
        c.FW().Ys(this.superUsername);
        if (this.adapter != null) {
            this.adapter.onPause();
        }
        super.onPause();
    }

    private void batchSyncForWxaContact() {
        if (this.adapter != null && this.adapter.getCount() != 0) {
            x.i(TAG, "batchSyncForWxaContact, size:%d", new Object[]{Integer.valueOf(this.adapter.getCount())});
            if (this.adapter instanceof a) {
                List list = ((a) this.adapter).dhI;
                if (list != null && list.size() > 0) {
                    ((com.tencent.mm.plugin.appbrand.n.c) g.l(com.tencent.mm.plugin.appbrand.n.c.class)).al(list);
                }
            }
        }
    }

    private String intToString(int i) {
        return new BigInteger(Integer.toBinaryString(i), 2).toString();
    }

    private void enterConversationReport() {
        String str = "";
        if (this.adapter == null) {
            x.d(TAG, "adapter is null!");
            return;
        }
        int i;
        Object obj;
        int i2;
        au.HU();
        ai Yq = c.FW().Yq("appbrandcustomerservicemsg");
        if (Yq == null || bi.oW(Yq.field_username)) {
            i = 0;
        } else {
            i = Yq.field_unReadCount;
        }
        Yq = (ai) this.adapter.getItem(0);
        if (Yq == null || bi.oW(Yq.field_username)) {
            String obj2 = str;
        } else {
            String oV = bi.oV(Yq.field_content);
            WxaAttributes rR = ((com.tencent.mm.plugin.appbrand.n.c) g.l(com.tencent.mm.plugin.appbrand.n.c.class)).rR(Yq.field_username);
            this.mAppId = rR == null ? null : rR.field_appId;
            obj2 = oV;
        }
        if (i > 0) {
            int count = this.adapter.getCount();
            int i3 = 0;
            i2 = 0;
            while (i3 < count) {
                int i4;
                Yq = (ai) this.adapter.getItem(i3);
                if (Yq.field_unReadMuteCount + Yq.field_unReadCount > 0) {
                    i4 = i2 + 1;
                } else {
                    i4 = i2;
                }
                i3++;
                i2 = i4;
            }
        } else {
            i2 = 0;
        }
        x.d(TAG, "stev report(%s), sceneId : %s, unReadCount %d, unReadAppCount %d, lastPushAppId %s, lastPushMsg %s", new Object[]{Integer.valueOf(13797), this.mSceneId, Integer.valueOf(i), Integer.valueOf(i2), this.mAppId, obj2});
        h.mEJ.h(13797, new Object[]{this.mSceneId, Integer.valueOf(i), Integer.valueOf(i2), this.mAppId, Long.valueOf(bi.VE()), Integer.valueOf(0), obj2});
    }

    public void customerMsgOperateReport(int i) {
        x.d(TAG, "stev report(%s), eventId : %s, appId %s, sceneId %s", new Object[]{Integer.valueOf(13798), Integer.valueOf(i), this.mAppId, this.mSceneId});
        h.mEJ.h(13798, new Object[]{Integer.valueOf(i), this.mAppId, Integer.valueOf(0), this.mSceneId, Long.valueOf(bi.VE())});
    }

    public void entryCustomerMsgDialogReport(String str, int i) {
        au.HU();
        ai Yq = c.FW().Yq(str);
        if (Yq == null) {
            x.e(TAG, "cvs:%s is null, error", new Object[]{str});
            return;
        }
        int i2 = Yq.field_unReadCount;
        String oV = bi.oV(this.mSceneId);
        x.d(TAG, "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[]{Integer.valueOf(13799), this.mAppId, Integer.valueOf(i), Integer.valueOf(i2), oV});
        h.mEJ.h(13799, new Object[]{this.mAppId, Integer.valueOf(i), Integer.valueOf(i2), oV, Long.valueOf(bi.VE())});
    }

    protected void initView() {
        setMMTitle(getString(R.l.app_brand_customer_service_conversion_ui_title));
        this.appbrandMessageLV = (ListView) findViewById(R.h.tmessage_lv);
        this.emptyTipTv = (TextView) findViewById(R.h.empty_msg_tip_tv);
        this.emptyTipTv.setText(R.l.app_brand_empty_service_msg_tip);
        setBackBtn(new 5(this));
        this.appBrandServiceActionSheet = new a(thisActivity());
        this.adapter = new a(thisActivity(), this.superUsername, new 6(this));
        this.adapter.setGetViewPositionCallback(new 7(this));
        this.adapter.setPerformItemClickListener(new 8(this));
        this.appbrandMessageLV.setAdapter(this.adapter);
        this.contextMenuHelper = new k(thisActivity());
        this.appbrandMessageLV.setOnItemClickListener(new 9(this));
        this.appbrandMessageLV.setOnItemLongClickListener(new 10(this));
        this.adapter.setGetViewPositionCallback(new 11(this));
        this.adapter.setPerformItemClickListener(new 12(this));
        this.adapter.a(new 2(this));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!(this.talker == null || this.talker.isEmpty())) {
            this.talker = "";
        }
        if (i2 == -1) {
        }
    }

    private void setShowView(int i) {
        if (i <= 0) {
            this.emptyTipTv.setVisibility(0);
            this.appbrandMessageLV.setVisibility(8);
            return;
        }
        this.emptyTipTv.setVisibility(8);
        this.appbrandMessageLV.setVisibility(0);
    }

    private void delConversationAndMsg(String str) {
        if (bi.oW(str)) {
            x.e(TAG, "Delete Conversation and messages fail because username is null or nil.");
            return;
        }
        asyncDelMsg(str);
        au.HU();
        c.FW().Yp(str);
    }

    private void asyncDelMsg(String str) {
        x.i(TAG, "async del msg talker:%s", new Object[]{str});
        au.HU();
        bd GD = c.FT().GD(str);
        rd rdVar = new rd();
        rdVar.rvi = new bhz().VO(bi.oV(str));
        rdVar.rcq = GD.field_msgSvrId;
        au.HU();
        c.FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(8, rdVar));
        this.isDeleteCancel = false;
        FragmentActivity thisActivity = thisActivity();
        getString(R.l.app_tip);
        p a = com.tencent.mm.ui.base.h.a(thisActivity, getString(R.l.app_waiting), true, new 3(this));
        customerMsgOperateReport(5);
        com.tencent.mm.model.bd.a(str, new 4(this, a));
    }

    public void onMMMenuItemSelected(MenuItem menuItem, int i) {
        au.HU();
        ab Yg = c.FR().Yg(this.talker);
        if (Yg == null || ((int) Yg.dhP) == 0) {
            x.e(TAG, "changed biz stick status failed, contact is null, talker = " + this.talker);
            return;
        }
        switch (menuItem.getItemId()) {
            case 1:
                this.appBrandServiceActionSheet.username = this.talker;
                this.appBrandServiceActionSheet.scene = this.fromScene;
                this.appBrandServiceActionSheet.trd = this.mSceneId;
                this.appBrandServiceActionSheet.gPm = true;
                this.appBrandServiceActionSheet.show(3);
                return;
            case 2:
                this.appBrandServiceActionSheet.username = this.talker;
                this.appBrandServiceActionSheet.scene = this.fromScene;
                this.appBrandServiceActionSheet.trd = this.mSceneId;
                this.appBrandServiceActionSheet.gPm = true;
                this.appBrandServiceActionSheet.show(4);
                return;
            case 3:
                delConversationAndMsg(this.talker);
                return;
            default:
                return;
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        WxaAttributes rR = ((com.tencent.mm.plugin.appbrand.n.c) g.l(com.tencent.mm.plugin.appbrand.n.c.class)).rR(this.talker);
        int i = (rR == null || (rR.field_appOpt & 2) <= 0) ? 0 : 1;
        if (i != 0) {
            contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.app_brand_menu_accept_msg);
        } else {
            contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.l.app_brand_menu_refuse_msg);
        }
        contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.l.delete_message);
    }
}
