package com.tencent.mm.plugin.music.b.a;

import com.tencent.mm.sdk.platformtools.x;

public final class d {
    public static int tL(int i) {
        x.i("MicroMsg.PlayerErrorHandler", "getErrCodeType, errorCode: %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 53:
            case 54:
                return 10003;
            case 55:
            case 63:
            case 64:
            case 101:
            case 701:
            case 703:
            case 705:
                return 10004;
            case 62:
            case 66:
            case 67:
            case 69:
            case 70:
            case 74:
            case 102:
            case 500:
            case 501:
            case 502:
            case 503:
            case 504:
            case 600:
            case 601:
            case 602:
            case 603:
            case 604:
            case 605:
            case 702:
            case 704:
            case 706:
            case 707:
                return 10001;
            case 80:
                return 10002;
            default:
                return -1;
        }
    }

    public static String tM(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("errCode:" + i + ", err:");
        switch (i) {
            case 53:
                stringBuilder.append("file not found");
                break;
            case 54:
                stringBuilder.append("file can not read");
                break;
            case 55:
                stringBuilder.append("unknow format");
                break;
            case 62:
                stringBuilder.append("load or init native decode so fail");
                break;
            case 63:
                stringBuilder.append("get audio info fail");
                break;
            case 64:
                stringBuilder.append("invalid audio info");
                break;
            case 66:
                stringBuilder.append("create AudioTrack fail");
                break;
            case 67:
                stringBuilder.append("decode audio fail");
                break;
            case 69:
                stringBuilder.append("so file not found");
                break;
            case 70:
                stringBuilder.append("create temp file fail");
                break;
            case 74:
                stringBuilder.append("invalid seek or seek fail");
                break;
            case 80:
                stringBuilder.append("connect network fail");
                break;
            case 101:
                stringBuilder.append("recognition audio format error");
                break;
            case 102:
                stringBuilder.append("write AudioTrack data fail");
                break;
            case 500:
                stringBuilder.append("error URL format");
                break;
            case 501:
                stringBuilder.append("error player to prepare");
                break;
            case 502:
                stringBuilder.append("error player to start");
                break;
            case 503:
                stringBuilder.append("error player to pause");
                break;
            case 504:
                stringBuilder.append("error player to stop");
                break;
            case 600:
                stringBuilder.append("error create player fail, exceed max count audio players");
                break;
            case 601:
                stringBuilder.append("error, not found audioId");
                break;
            case 602:
                stringBuilder.append("error, not found param");
                break;
            case 603:
                stringBuilder.append("error, ready exist audioId");
                break;
            case 604:
                stringBuilder.append("error, invalid audioID");
                break;
            case 605:
                stringBuilder.append("error, invalid param");
                break;
            case 701:
                stringBuilder.append("error, invalid param");
                break;
            case 702:
                stringBuilder.append("error, mmplayer set source occur error");
                break;
            case 703:
                stringBuilder.append("error, mmplayer media format error");
                break;
            case 704:
                stringBuilder.append("error, mmplayer create MediaCode error");
                break;
            case 705:
                stringBuilder.append("error, mmplayer get audio info error");
                break;
            case 706:
                stringBuilder.append("error, mmplayer decode error");
                break;
            case 707:
                stringBuilder.append("error, mmplayer create audio track orror");
                break;
            default:
                stringBuilder.append("unknow exception");
                break;
        }
        return stringBuilder.toString();
    }
}
