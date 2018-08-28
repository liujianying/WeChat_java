package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.l;
import com.tencent.mm.ac.a.c;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.n;
import com.tencent.mm.ac.z;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.ui.applet.g;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.protocal.c.xr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.y;
import java.util.HashMap;

@a(19)
public class BizChatSelectConversationUI extends MMBaseSelectContactUI implements n {
    private String hpJ = null;
    private int scene = 0;
    j tEx;
    private TextView tFu;
    private p tipDialog = null;

    static /* synthetic */ void a(BizChatSelectConversationUI bizChatSelectConversationUI) {
        bizChatSelectConversationUI.tEx = z.Nc().cz(z.Nc().cA(bizChatSelectConversationUI.hpJ));
        if (bizChatSelectConversationUI.tEx == null || bi.oW(bizChatSelectConversationUI.tEx.field_addMemberUrl)) {
            String str = "MicroMsg.BizChatSelectConversationUI";
            String str2 = "field_addMemberUrl:%s";
            Object[] objArr = new Object[1];
            objArr[0] = bizChatSelectConversationUI.tEx != null ? bizChatSelectConversationUI.tEx.field_addMemberUrl : null;
            x.i(str, str2, objArr);
            Toast.makeText(bizChatSelectConversationUI, bizChatSelectConversationUI.getString(R.l.bizchat_new_chat_fail), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", bizChatSelectConversationUI.tEx.field_addMemberUrl);
        x.i("MicroMsg.BizChatSelectConversationUI", "KRawUrl :%s", new Object[]{bizChatSelectConversationUI.tEx.field_addMemberUrl});
        intent.putExtra("useJs", true);
        d.b(bizChatSelectConversationUI.mController.tml, "webview", ".ui.tools.WebViewUI", intent, 1);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        this.scene = getIntent().getIntExtra("biz_chat_scene", 1);
        csx();
        String cA = z.Nc().cA(this.hpJ);
        this.tEx = z.Nc().cz(cA);
        String str = "MicroMsg.BizChatSelectConversationUI";
        String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
        Object[] objArr = new Object[3];
        objArr[0] = this.hpJ;
        objArr[1] = cA;
        if (this.tEx == null) {
            z = true;
        }
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (bi.oW(cA) || this.tEx == null || this.tEx.No() || bi.oW(this.tEx.field_addMemberUrl)) {
            z.Ng();
            h.a(this.hpJ, this);
            Context activity = getActivity();
            getString(R.l.app_tip);
            this.tipDialog = com.tencent.mm.ui.base.h.a(activity, getString(R.l.app_waiting), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    BizChatSelectConversationUI.this.finish();
                }
            });
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void csx() {
        if (bi.oW(this.hpJ)) {
            this.hpJ = getIntent().getStringExtra("enterprise_biz_name");
            if (bi.oW(this.hpJ)) {
                x.e("MicroMsg.BizChatSelectConversationUI", "brandUserName is null");
                finish();
            }
        }
    }

    protected final o Wn() {
        csx();
        return new d(this, this.hpJ);
    }

    protected final m Wo() {
        csx();
        return new com.tencent.mm.ui.contact.p(this, this.hpJ);
    }

    protected final void a(ListView listView, int i) {
        super.a(listView, i);
        if (this.tFu == null) {
            1 1 = new 1(this);
            CharSequence string = getString(R.l.select_conversation_create);
            View inflate = y.gq(this).inflate(R.i.group_card_item, null);
            inflate.setOnClickListener(1);
            TextView textView = (TextView) inflate.findViewById(R.h.content_tv);
            textView.setText(string);
            listView.addHeaderView(inflate);
            this.tFu = textView;
        }
        this.tFu.setVisibility(i);
    }

    protected final void bbH() {
        super.bbH();
    }

    public final void iV(int i) {
        if (i < getContentLV().getHeaderViewsCount()) {
            x.i("MicroMsg.BizChatSelectConversationUI", "Click HeaderView position=%d", new Object[]{Integer.valueOf(i)});
        } else if (getContentLV().getAdapter().getItem(i) instanceof a) {
            a aVar = (a) getContentLV().getAdapter().getItem(i);
            if (aVar != null) {
                String str = aVar.username;
                long j = aVar.hpD;
                if (str == null || j == -1) {
                    x.i("MicroMsg.BizChatSelectConversationUI", "onclick err userName:%s,bizChatId:%s", new Object[]{str, Long.valueOf(j)});
                    return;
                }
                a(str, j, aVar.eCh);
            }
        } else {
            x.w("MicroMsg.BizChatSelectConversationUI", "Click HeaderView not BizChatConvDataItem");
        }
    }

    private void a(final String str, final long j, CharSequence charSequence) {
        x.i("MicroMsg.BizChatSelectConversationUI", "doClickUser=%s", new Object[]{str});
        if (this.scene == 2) {
            long j2;
            if (getIntent().getBooleanExtra("enterprise_extra_params", true)) {
                j2 = j;
                g.a(this.mController, j2, getString(R.l.retransmit_to_conv_comfirm2), String.valueOf(charSequence), getString(R.l.app_send), new q.a() {
                    public final void a(boolean z, String str, int i) {
                        if (z) {
                            Intent intent = new Intent();
                            intent.putExtra("enterprise_biz_name", str);
                            intent.putExtra("key_biz_chat_id", j);
                            intent.putExtra("key_is_biz_chat", true);
                            BizChatSelectConversationUI.this.setResult(-1, intent);
                            BizChatSelectConversationUI.this.finish();
                        }
                    }
                });
                return;
            }
            j2 = j;
            g.a(this.mController, j2, getString(R.l.retransmit_to_conv_comfirm2), String.valueOf(charSequence), getString(R.l.app_send), new 3(this, str, j));
        } else if (this.scene == 1) {
            HashMap hashMap = (HashMap) getIntent().getSerializableExtra("enterprise_extra_params");
            String str2 = (String) hashMap.get("title");
            g.a(this.mController, str2, (String) hashMap.get("img_url"), (String) hashMap.get("desc"), true, getResources().getString(R.l.app_send), new q.a() {
                public final void a(boolean z, String str, int i) {
                    if (z) {
                        Intent intent = new Intent();
                        intent.putExtra("enterprise_biz_name", str);
                        intent.putExtra("key_biz_chat_id", j);
                        intent.putExtra("key_is_biz_chat", true);
                        if (!bi.oW(str)) {
                            intent.putExtra("enterprise_share_append_text", str);
                        }
                        BizChatSelectConversationUI.this.setResult(-1, intent);
                        BizChatSelectConversationUI.this.finish();
                    }
                }
            });
        }
    }

    protected final boolean Wl() {
        return false;
    }

    protected final String Wm() {
        return r.gT(this.hpJ);
    }

    protected final boolean Wk() {
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    boolean z;
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null) {
                        String str;
                        x.i("MicroMsg.BizChatSelectConversationUI", "bundle != null");
                        String string = bundleExtra.getString("enterprise_members");
                        xr xrVar = new xr();
                        c cVar = new c();
                        if (this.tEx != null) {
                            str = this.tEx.field_addMemberUrl;
                        } else {
                            str = null;
                        }
                        cVar.field_addMemberUrl = str;
                        cVar.field_brandUserName = this.hpJ;
                        if (!e.a(cVar, string, null, xrVar)) {
                            z = false;
                        } else if (cVar.field_bizChatLocalId != -1) {
                            a(this.hpJ, cVar.field_bizChatLocalId, cVar.field_chatName);
                            z = true;
                        } else {
                            z.Ng();
                            com.tencent.mm.ac.a.n a = h.a(this.hpJ, xrVar, this);
                            getString(R.l.app_tip);
                            this.tipDialog = com.tencent.mm.ui.base.h.a(this, getString(R.l.adding_room_mem), true, new 5(this, a));
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                    if (!z) {
                        Toast.makeText(this, getString(R.l.room_change_add_memberfail), 0).show();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, l lVar) {
        if (this.tipDialog != null && this.tipDialog.isShowing()) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (lVar.getType() == 1355) {
            c la = z.Na().la(((com.tencent.mm.ac.a.n) lVar).Nt().ruQ.rDx.riE);
            if (la == null) {
                Toast.makeText(ad.getContext(), getString(R.l.room_change_add_memberfail), 0).show();
            } else {
                a(this.hpJ, la.field_bizChatLocalId, la.field_chatName);
            }
        }
    }
}
