package com.tencent.tencentmap.mapsdk.a;

import com.tencent.map.lib.b;

public abstract class ko implements b {
    public static final String b(String str) {
        if (str.equals("poi_icon.png")) {
            return "poi_icon_file.png";
        }
        if (str.equals("poi_icon_navi.png")) {
            return "poi_icon_file_nav.png";
        }
        if (str.equals("poi_icon_sat.png")) {
            return "poi_icon_file_sat.png";
        }
        if (str.equals("poi_icon_dark.png")) {
            return "poi_icon_file_dark.png";
        }
        if (str.equals("color_texture_flat_style.png")) {
            return "color_texture_flat_style.png";
        }
        if (str.equals("color_arrow_texture.png")) {
            return "color_arrow_texture";
        }
        if (str.equals("color_point_texture.png")) {
            return "color_point_texture.png";
        }
        if (str.equals("color_texture_flat_style_cap.png")) {
            return "color_texture_cap.png";
        }
        if (str.equals("route_arrow_texture.png")) {
            return "route_arrow_texture";
        }
        if (str.equals("poi_icon_indoor.png")) {
            return "indoor_icon.png";
        }
        return str;
    }

    public static final int c(String str) {
        return -1;
    }
}
