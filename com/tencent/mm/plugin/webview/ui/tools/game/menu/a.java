package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import com.tencent.mm.R;
import com.tencent.mm.protocal.c.atl;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public static final List<atl> qgo = new LinkedList();

    static {
        atl atl = new atl();
        atl.bHD = ad.getResources().getString(R.l.game_menu_share_to_friend);
        atl.lPl = "game_menu_icon_share_to_friend";
        atl.rWP = 1;
        atl.rWO = 1;
        atl.rDF = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.qgw.code;
        qgo.add(atl);
        atl = new atl();
        atl.bHD = ad.getResources().getString(R.l.game_menu_exit);
        atl.lPl = "game_menu_icon_exit";
        atl.rWP = 2;
        atl.rWO = 2;
        atl.rDF = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.qgv.code;
        qgo.add(atl);
        atl = new atl();
        atl.bHD = ad.getResources().getString(R.l.game_menu_refresh);
        atl.lPl = "game_menu_icon_refresh";
        atl.rWP = 4;
        atl.rWO = 5;
        atl.rDF = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.qgy.code;
        qgo.add(atl);
        atl = new atl();
        atl.bHD = ad.getResources().getString(R.l.game_menu_collect);
        atl.lPl = "game_menu_icon_collect";
        atl.rWP = 3;
        atl.rWO = 6;
        atl.rDF = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.qgx.code;
        qgo.add(atl);
        atl = new atl();
        atl.bHD = ad.getResources().getString(R.l.game_menu_complaint);
        atl.lPl = "game_menu_icon_complaint";
        atl.rWP = 6;
        atl.rWO = 7;
        atl.rDF = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.qgA.code;
        qgo.add(atl);
        atl = new atl();
        atl.bHD = ad.getResources().getString(R.l.game_menu_add_to_desktop);
        atl.lPl = "game_menu_icon_add_to_desktop";
        atl.rWP = 5;
        atl.rWO = 8;
        atl.rDF = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.qgz.code;
        qgo.add(atl);
    }
}
