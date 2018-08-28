package com.tencent.mm.ui.voicesearch;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.r.a;
import java.util.LinkedList;

public class SearchConversationResultUI extends MMActivity {
    private TextView hSp;
    private ListView uFC;
    private a uFD;
    private String uFE = null;
    private String username;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final void initView() {
        this.uFC = (ListView) findViewById(R.h.voice_search_resultlist);
        this.hSp = (TextView) findViewById(R.h.empty_voicesearch_tip_tv);
        this.uFD = new a(getApplicationContext(), new a() {
            public final void Xa() {
            }

            public final void Xb() {
            }
        });
        if (this.uFD != null) {
            this.uFD.dQ(new LinkedList());
        }
        this.uFC.setAdapter(this.uFD);
        this.hSp.setVisibility(8);
        this.username = getIntent().getStringExtra("SearchConversationResult_User");
        this.uFE = getIntent().getStringExtra("SearchConversationResult_Error");
        setMMTitle(getString(R.l.voice_search_result));
        setBackBtn(new 2(this));
        this.uFC.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= SearchConversationResultUI.this.uFC.getHeaderViewsCount()) {
                    int headerViewsCount = i - SearchConversationResultUI.this.uFC.getHeaderViewsCount();
                    ai aiVar = (ai) SearchConversationResultUI.this.uFD.getItem(headerViewsCount);
                    if (aiVar == null) {
                        x.e("MicroMsg.VoiceSearchResultUI", "null user at position = " + headerViewsCount);
                        return;
                    }
                    x.d("MicroMsg.VoiceSearchResultUI", "username " + aiVar.field_username);
                    Intent intent;
                    if (s.hk(aiVar.field_username)) {
                        if (q.GY()) {
                            d.b(SearchConversationResultUI.this.mController.tml, "tmessage", ".ui.TConversationUI", new Intent().putExtra("finish_direct", true));
                            return;
                        }
                        d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                    } else if (s.hm(aiVar.field_username)) {
                        if (q.GV()) {
                            d.b(SearchConversationResultUI.this.mController.tml, "qmessage", ".ui.QConversationUI", new Intent().putExtra("finish_direct", true));
                            return;
                        }
                        d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                    } else if (s.hl(aiVar.field_username)) {
                        d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                    } else if (s.hq(aiVar.field_username)) {
                        MMAppMgr.cancelNotification(aiVar.field_username);
                        d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                    } else if (s.hi(aiVar.field_username)) {
                        if (q.Hh()) {
                            SearchConversationResultUI.this.a(ChattingUI.class, new Intent().putExtra("Chat_User", aiVar.field_username).putExtra("finish_direct", true));
                        } else {
                            d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                        }
                    } else if (s.hv(aiVar.field_username)) {
                        if (q.Hc()) {
                            intent = new Intent();
                            intent.putExtra("type", 20);
                            d.b(SearchConversationResultUI.this, "readerapp", ".ui.ReaderAppUI", intent);
                            return;
                        }
                        d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                    } else if (s.hD(aiVar.field_username)) {
                        if (q.Hd()) {
                            intent = new Intent();
                            intent.putExtra("type", 11);
                            d.b(SearchConversationResultUI.this, "readerapp", ".ui.ReaderAppUI", intent);
                            return;
                        }
                        d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                    } else if (s.hn(aiVar.field_username)) {
                        d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                    } else if (s.ho(aiVar.field_username)) {
                        if (q.Hf()) {
                            d.b(SearchConversationResultUI.this, "masssend", ".ui.MassSendHistoryUI", new Intent().putExtra("finish_direct", true));
                            return;
                        }
                        d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                    } else if (s.hu(aiVar.field_username)) {
                        if (q.GZ()) {
                            SearchConversationResultUI.this.a(ChattingUI.class, new Intent().putExtra("Chat_User", aiVar.field_username).putExtra("finish_direct", true));
                        } else {
                            d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                        }
                    } else if (s.hs(SearchConversationResultUI.this.username) || s.ht(SearchConversationResultUI.this.username) || s.hp(SearchConversationResultUI.this.username) || s.hx(SearchConversationResultUI.this.username) || s.hy(SearchConversationResultUI.this.username) || s.hj(SearchConversationResultUI.this.username) || s.hG(SearchConversationResultUI.this.username)) {
                        d.b(SearchConversationResultUI.this, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                    } else {
                        SearchConversationResultUI.this.a(ChattingUI.class, new Intent().putExtra("Chat_User", aiVar.field_username).putExtra("finish_direct", true));
                    }
                }
            }
        });
        String str = this.username;
        this.hSp.setVisibility(8);
        if (this.uFD != null) {
            this.uFD.pi(str);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.uFD.aYc();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    protected final int getLayoutId() {
        return R.i.voice_search_result;
    }
}
