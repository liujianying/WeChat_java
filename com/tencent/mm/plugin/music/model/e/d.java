package com.tencent.mm.plugin.music.model.e;

import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public static int tG(int i) {
        x.i("MicroMsg.Music.MusicPlayIdKeyReport", "getQQMusicPlayerErrIdKey, errCode:" + i);
        switch (i) {
            case s$l.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
                return 17;
            case s$l.AppCompatTheme_borderlessButtonStyle /*54*/:
                return 18;
            case s$l.AppCompatTheme_dividerVertical /*55*/:
                return 19;
            case s$l.AppCompatTheme_editTextColor /*62*/:
                return 20;
            case s$l.AppCompatTheme_editTextBackground /*63*/:
                return 21;
            case s$l.AppCompatTheme_imageButtonStyle /*64*/:
                return 22;
            case s$l.AppCompatTheme_textAppearanceSearchResultSubtitle /*66*/:
                return 23;
            case s$l.AppCompatTheme_textColorSearchUrl /*67*/:
                return 24;
            case s$l.AppCompatTheme_listPreferredItemHeight /*69*/:
                return 25;
            case 70:
                return 36;
            case s$l.AppCompatTheme_dropDownListViewStyle /*74*/:
                return 26;
            case s$l.AppCompatTheme_panelMenuListTheme /*80*/:
                return 27;
            case s$l.AppCompatTheme_buttonStyleSmall /*101*/:
                return 28;
            case s$l.AppCompatTheme_checkboxStyle /*102*/:
                return 29;
            case 500:
                return 31;
            case 501:
                return 32;
            case 502:
                return 33;
            case 503:
                return 34;
            case 504:
                return 35;
            case 700:
                return 37;
            case 701:
                return 38;
            default:
                return 30;
        }
    }

    public static int tH(int i) {
        x.i("MicroMsg.Music.MusicPlayIdKeyReport", "getMusicPlayerErrIdKey, errCode:" + i);
        switch (i) {
            case 700:
                return 45;
            case 701:
                return 48;
            case 702:
                return 39;
            case 703:
                return 40;
            case 704:
                return 41;
            case 705:
                return 42;
            case 706:
                return 43;
            case 707:
                return 44;
            default:
                return 189;
        }
    }

    public static int IB(String str) {
        if ("audio/3gpp".equalsIgnoreCase(str)) {
            return 1;
        }
        if ("audio/amr-wb".equalsIgnoreCase(str)) {
            return 2;
        }
        if ("audio/mpeg".equalsIgnoreCase(str) || "audio/mp3".equalsIgnoreCase(str)) {
            return 3;
        }
        if ("audio/mp4a-latm".equalsIgnoreCase(str) || str.startsWith("audio/mp4")) {
            return 4;
        }
        if ("audio/qcelp".equalsIgnoreCase(str)) {
            return 5;
        }
        if ("audio/vorbis".equalsIgnoreCase(str)) {
            return 6;
        }
        if ("audio/opus".equalsIgnoreCase(str)) {
            return 7;
        }
        if ("audio/g711-alaw".equalsIgnoreCase(str)) {
            return 8;
        }
        if ("audio/g711-mlaw".equalsIgnoreCase(str)) {
            return 9;
        }
        if ("audio/raw".equalsIgnoreCase(str)) {
            return 10;
        }
        if ("audio/flac".equalsIgnoreCase(str)) {
            return 11;
        }
        if ("audio/gsm".equalsIgnoreCase(str)) {
            return 12;
        }
        if ("audio/ac3".equalsIgnoreCase(str)) {
            return 13;
        }
        if ("audio/eac3".equalsIgnoreCase(str)) {
            return 14;
        }
        if ("audio/x-ms-wma".equalsIgnoreCase(str)) {
            return 15;
        }
        if ("audio/x-wav".equalsIgnoreCase(str)) {
            return 16;
        }
        if ("audio/x-ape".equalsIgnoreCase(str) || "application/x-ape".equalsIgnoreCase(str)) {
            return 17;
        }
        return 0;
    }
}
