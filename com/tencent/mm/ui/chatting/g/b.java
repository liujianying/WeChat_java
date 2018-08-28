package com.tencent.mm.ui.chatting.g;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.h;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.modelvoiceaddr.ui.b$a;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.a.b.f;
import com.tencent.mm.ui.chatting.d.b.a;
import com.tencent.mm.ui.chatting.i;
import com.tencent.mm.ui.chatting.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public abstract class b implements f, a {
    protected ArrayList<com.tencent.mm.ui.chatting.a.b.b> gBc = null;
    protected String gBf;
    protected Context mContext;
    private boolean qUB = false;
    private long tUA = 0;
    protected com.tencent.mm.ui.chatting.d.b.b tXZ;
    com.tencent.mm.ui.chatting.a.b tYa;
    private LinearLayoutManager tYb;
    protected ArrayList<com.tencent.mm.ui.chatting.a.b.b> tYc = null;

    public final /* bridge */ /* synthetic */ void a(com.tencent.mm.ui.chatting.view.a aVar) {
        com.tencent.mm.ui.chatting.d.b.b bVar = (com.tencent.mm.ui.chatting.d.b.b) aVar;
        this.tXZ = bVar;
        bVar.a(this);
    }

    public final /* synthetic */ h cwu() {
        if (this.tYb == null) {
            this.tYb = new LinearLayoutManager();
        }
        return this.tYb;
    }

    public b(Context context) {
        this.mContext = context;
        this.gBc = new ArrayList();
    }

    public final void onDetach() {
        this.tXZ.a(null);
        this.tXZ = null;
        if (this.tYa != null) {
            com.tencent.mm.ui.chatting.a.b.tNS = null;
            com.tencent.mm.ui.chatting.a.b.tNT = null;
        }
    }

    public final g cwF() {
        return new 1(this);
    }

    public final com.tencent.mm.ui.chatting.a.b.b EZ(int i) {
        if (this.gBc == null || this.gBc.size() <= i) {
            return null;
        }
        return (com.tencent.mm.ui.chatting.a.b.b) this.gBc.get(i);
    }

    public final RecyclerView.a aau(String str) {
        this.gBf = str;
        this.tYa = new com.tencent.mm.ui.chatting.a.b(this.mContext, this);
        com.tencent.mm.ui.chatting.a.b.tNS = cwH();
        return this.tYa;
    }

    public final int getCount() {
        if (this.gBc == null) {
            return 0;
        }
        return this.gBc.size();
    }

    public final b$a cwI() {
        return new b$a() {
            private al hPw = new al(au.Em().lnJ.getLooper(), new 1(this), false);
            String tNU = "";

            public final void Uq() {
            }

            public final void Ur() {
            }

            public final void a(boolean z, String[] strArr, long j, int i) {
            }

            public final void WX() {
            }

            public final void WW() {
                x.d("MicroMsg.BaseHistoryListPresenter", "onQuitSearch");
                if (b.this.tXZ != null) {
                    b.this.tXZ.onFinish();
                }
            }

            public final void pk(String str) {
                if (!this.tNU.equals(str)) {
                    this.tNU = str;
                    this.hPw.SO();
                    this.hPw.J(500, 500);
                }
            }

            public final boolean pj(String str) {
                return false;
            }

            public final void WY() {
            }

            public final void WZ() {
                x.i("MicroMsg.BaseHistoryListPresenter", "onSearchEditTextReady");
            }
        };
    }

    protected static String i(bd bdVar, boolean z) {
        String str = null;
        if (bdVar == null) {
            return null;
        }
        if (bdVar.field_isSend == 1) {
            return q.GF();
        }
        if (z) {
            str = com.tencent.mm.model.bd.iB(bdVar.field_content);
        }
        if (bi.oW(str)) {
            return bdVar.field_talker;
        }
        return str;
    }

    public final void d(int i, final bd bdVar) {
        x.i("MicroMsg.BaseHistoryListPresenter", "[handleSelectedItem] index:%s", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 0:
                com.tencent.mm.plugin.report.service.h.mEJ.a(219, 19, 1, true);
                boolean endsWith = this.gBf.toLowerCase().endsWith("@chatroom");
                List arrayList = new ArrayList(1);
                arrayList.add(bdVar);
                k.a(this.mContext, arrayList, endsWith, this.gBf, new 3(this));
                return;
            case 1:
                ch chVar = new ch();
                List arrayList2 = new ArrayList(1);
                arrayList2.add(bdVar);
                if (com.tencent.mm.pluginsdk.model.g.a(this.mContext, chVar, this.gBf, arrayList2, false, false)) {
                    chVar.bJF.bJM = 45;
                    chVar.bJF.activity = (Activity) this.mContext;
                    com.tencent.mm.sdk.b.a.sFg.m(chVar);
                    if (chVar.bJG.ret != -2 && chVar.bJG.ret <= 0 && chVar.bJG.ret <= 0) {
                        if (14 != chVar.bJF.type) {
                            x.d("MicroMsg.BaseHistoryListPresenter", "not record type, do not report");
                            return;
                        } else if (chVar.bJF.bJI == null) {
                            x.e("MicroMsg.BaseHistoryListPresenter", "want to report record fav, but type count is null");
                            return;
                        } else {
                            com.tencent.mm.plugin.report.service.h.mEJ.h(11142, new Object[]{Integer.valueOf(chVar.bJF.bJI.rBY), Integer.valueOf(chVar.bJF.bJI.rBZ), Integer.valueOf(chVar.bJF.bJI.rCa), Integer.valueOf(chVar.bJF.bJI.rCb), Integer.valueOf(chVar.bJF.bJI.rCc), Integer.valueOf(chVar.bJF.bJI.rCd), Integer.valueOf(chVar.bJF.bJI.rCe), Integer.valueOf(chVar.bJF.bJI.rCf), Integer.valueOf(chVar.bJF.bJI.rCg), Integer.valueOf(chVar.bJF.bJI.rCh), Integer.valueOf(chVar.bJF.bJI.rCi), Integer.valueOf(chVar.bJF.bJI.rCj), Integer.valueOf(chVar.bJF.bJI.rCk), Integer.valueOf(chVar.bJF.bJI.rCl), Integer.valueOf(chVar.bJF.bJI.rCm)});
                            return;
                        }
                    }
                    return;
                }
                x.e("MicroMsg.BaseHistoryListPresenter", "[handleFav] err!");
                return;
            case 2:
                com.tencent.mm.plugin.report.service.h.mEJ.h(11627, new Object[]{Integer.valueOf(5)});
                final Set treeSet = new TreeSet();
                treeSet.add(Long.valueOf(bdVar.field_msgId));
                com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(R.l.confirm_delete), "", this.mContext.getString(R.l.delete_message), this.mContext.getString(R.l.app_cancel), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.i("MicroMsg.BaseHistoryListPresenter", "delete message");
                        i.a(b.this.mContext, treeSet, new 1(this));
                    }
                }, null);
                return;
            default:
                return;
        }
    }

    protected final boolean cxG() {
        long j = this.tUA + 30000;
        long currentTimeMillis = System.currentTimeMillis();
        this.tUA = currentTimeMillis;
        if (j < currentTimeMillis) {
            au.HU();
            this.qUB = c.isSDCardAvailable();
        }
        return this.qUB;
    }
}
