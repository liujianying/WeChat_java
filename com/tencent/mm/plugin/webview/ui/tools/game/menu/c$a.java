package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map.Entry;

public enum c$a {
    HVGAME_MENU_ACTION_DEFAULT(0),
    HVGAME_MENU_ACTION_JUMP_H5(1),
    HVGAME_MENU_ACTION_EXIT(2),
    HVGAME_MENU_ACTION_SHARE_TO_FRIEND(3),
    HVGAME_MENU_ACTION_COLLECT(4),
    HVGAME_MENU_ACTION_REFRESH(7),
    HVGAME_MENU_ACTION_ADD_TO_DESKTOP(8),
    HVGAME_MENU_ACTION_COMPLAINT(9),
    HVGAME_MENU_ACTION_CUSTOM(10);
    
    private static EnumMap<c$a, Integer> qgC;
    int code;

    static {
        qgC = new EnumMap(c$a.class);
        Iterator it = EnumSet.allOf(c$a.class).iterator();
        while (it.hasNext()) {
            c$a c_a = (c$a) it.next();
            qgC.put(c_a, Integer.valueOf(c_a.code));
        }
    }

    private c$a(int i) {
        this.code = i;
    }

    public static boolean Ba(int i) {
        return qgC.containsValue(Integer.valueOf(i));
    }

    public static c$a Bb(int i) {
        for (Entry entry : qgC.entrySet()) {
            if (((Integer) entry.getValue()).intValue() == i) {
                return (c$a) entry.getKey();
            }
        }
        return HVGAME_MENU_ACTION_DEFAULT;
    }
}
