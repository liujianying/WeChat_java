package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n$d;
import com.tencent.mm.ui.chatting.b.b.s;
import java.util.LinkedList;
import java.util.List;

public class b$c implements OnLongClickListener {
    private int hpr;
    private int hps;
    private OnCreateContextMenuListener mom;
    private com.tencent.mm.ui.chatting.c.a tKy;
    private View tZA;
    final /* synthetic */ b tZs;
    private a tZz = new a();

    class a implements n$d {
        public bd bGS;

        a() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            if (this.bGS == null) {
                x.e("MicroMsg.ChattingItem", "context item select failed, null msg");
                return;
            }
            b$c.this.tZs.a(menuItem, b$c.this.tKy, this.bGS);
            ((s) b$c.this.tKy.O(s.class)).a(menuItem, b$c.this.tZs);
        }
    }

    static /* synthetic */ void a(b$c b_c, ContextMenu contextMenu, bd bdVar, int i) {
        if (!ab.XR(b_c.tKy.getTalkerUserName()) && !ab.gr(b_c.tKy.getTalkerUserName()) && contextMenu != null && (contextMenu instanceof l) && bdVar.getType() != 318767153) {
            if (bdVar.getType() == 49) {
                com.tencent.mm.y.g.a J = com.tencent.mm.y.g.a.J(bdVar.field_content, bdVar.field_reserved);
                if (J == null || J.type == 6 || J.type == 38 || J.type == 39) {
                    return;
                }
            }
            Object obj = contextMenu.findItem(116) != null ? 1 : null;
            l lVar = (l) contextMenu;
            Object linkedList = new LinkedList();
            List<MenuItem> list = lVar.twb;
            for (MenuItem menuItem : list) {
                m mVar;
                if (menuItem.getItemId() == 116) {
                    mVar = new m(b_c.tKy.tTq.getContext(), 134, i);
                    mVar.setTitle(b_c.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_schedule_remind));
                    linkedList.add(menuItem);
                    linkedList.add(mVar);
                } else if (obj == null && menuItem.getItemId() == 100) {
                    mVar = new m(b_c.tKy.tTq.getContext(), 134, i);
                    mVar.setTitle(b_c.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_schedule_remind));
                    linkedList.add(mVar);
                    linkedList.add(menuItem);
                } else {
                    linkedList.add(menuItem);
                }
            }
            list.clear();
            list.addAll(linkedList);
            linkedList.clear();
        }
    }

    public b$c(final b bVar, com.tencent.mm.ui.chatting.c.a aVar) {
        this.tZs = bVar;
        this.tKy = aVar;
        this.mom = new OnCreateContextMenuListener() {
            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                au auVar = (au) view.getTag();
                if (auVar != null) {
                    int i = auVar.position;
                    bd bdVar = auVar.bXQ;
                    if (bdVar == null) {
                        x.e("MicroMsg.ChattingItem", "msg is null!");
                        return;
                    }
                    boolean a = b$c.this.tZs.a(contextMenu, view, bdVar);
                    if (ab.XQ(b$c.this.tKy.getTalkerUserName()) || ab.XO(b$c.this.tKy.getTalkerUserName())) {
                        x.i("MicroMsg.ChattingItem", "on create context menu, match qcontact or tcontact, remove favorite menu item");
                        contextMenu.removeItem(116);
                    }
                    if (a) {
                        if (b$c.this.tKy.cws()) {
                            contextMenu.add(i, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
                        }
                        if ((!bf.l(bdVar) && b$c.this.tZs.cxO() && b$c.this.tKy.cws()) || b$c.this.tKy.oLT.ckW()) {
                            contextMenu.add(i, 122, 0, b$c.this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_more));
                        }
                        if (contextMenu.findItem(123) != null) {
                            contextMenu.removeItem(100);
                        }
                        if (!bf.l(bdVar)) {
                            b$c.a(b$c.this, contextMenu, bdVar, i);
                            return;
                        }
                        return;
                    }
                    if (bdVar.ckA()) {
                        au.HU();
                        if (c.isSDCardAvailable()) {
                            ((com.tencent.mm.ui.chatting.b.b.x) b$c.this.tKy.O(com.tencent.mm.ui.chatting.b.b.x.class)).a(contextMenu, i, bdVar);
                            if (bdVar.field_status == 5) {
                                contextMenu.add(i, s$l.AppCompatTheme_checkedTextViewStyle, 0, b$c.this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_resend_msg_img));
                                f.c(o.Pf().q(bdVar));
                            }
                            if (contextMenu.findItem(123) != null) {
                                contextMenu.removeItem(100);
                            }
                            if (!bf.l(bdVar)) {
                                b$c.a(b$c.this, contextMenu, bdVar, i);
                            }
                        }
                    }
                    if (bdVar.cme()) {
                        contextMenu.add(i, 100, 0, b$c.this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
                    }
                    if (bdVar.field_status == 5) {
                        contextMenu.add(i, s$l.AppCompatTheme_checkedTextViewStyle, 0, b$c.this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_resend_msg_img));
                        f.c(o.Pf().q(bdVar));
                    }
                    if (contextMenu.findItem(123) != null) {
                        contextMenu.removeItem(100);
                    }
                    if (!bf.l(bdVar)) {
                        b$c.a(b$c.this, contextMenu, bdVar, i);
                    }
                }
            }
        };
    }

    public final boolean onLongClick(View view) {
        if (view.getTag(R.h.touch_loc) instanceof int[]) {
            int[] iArr = (int[]) view.getTag(R.h.touch_loc);
            l(view, iArr[0], iArr[1]);
        } else if (!(this.hpr == 0 && this.hps == 0) && this.tZA.equals(view)) {
            l(view, this.hpr, this.hps);
        } else {
            view.setOnTouchListener(new 2(this));
        }
        return true;
    }

    private void l(View view, int i, int i2) {
        au auVar = (au) view.getTag();
        if (auVar != null) {
            this.tZz.bGS = auVar.bXQ;
            new com.tencent.mm.ui.widget.b.a(this.tKy.tTq.getContext()).a(view, this.mom, this.tZz, i, i2);
        }
    }
}
