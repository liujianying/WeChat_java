package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.ble.sdk.c;

import android.support.design.a$i;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.h;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.smtt.sdk.WebView;

public final class f {
    public static String kC(int i) {
        switch (i) {
            case 1:
                return "GATT CONN L2C FAILURE";
            case 8:
                return "GATT CONN TIMEOUT";
            case 19:
                return "GATT CONN TERMINATE PEER USER";
            case 22:
                return "GATT CONN TERMINATE LOCAL HOST";
            case a$i.AppCompatTheme_actionModePasteDrawable /*34*/:
                return "GATT CONN LMP TIMEOUT";
            case 62:
                return "GATT CONN FAIL ESTABLISH";
            case d.CTRL_INDEX /*133*/:
                return "GATT ERROR";
            case ab.CTRL_BYTE /*256*/:
                return "GATT CONN CANCEL ";
            default:
                switch (i) {
                    case 0:
                        return "GATT SUCCESS";
                    case 1:
                        return "GATT INVALID HANDLE";
                    case 2:
                        return "GATT READ NOT PERMIT";
                    case 3:
                        return "GATT WRITE NOT PERMIT";
                    case 4:
                        return "GATT INVALID PDU";
                    case 5:
                        return "GATT INSUF AUTHENTICATION";
                    case 6:
                        return "GATT REQ NOT SUPPORTED";
                    case 7:
                        return "GATT INVALID OFFSET";
                    case 8:
                        return "GATT INSUF AUTHORIZATION";
                    case 9:
                        return "GATT PREPARE Q FULL";
                    case 10:
                        return "GATT NOT FOUND";
                    case 11:
                        return "GATT NOT LONG";
                    case 12:
                        return "GATT INSUF KEY SIZE";
                    case 13:
                        return "GATT INVALID ATTR LEN";
                    case 14:
                        return "GATT ERR UNLIKELY";
                    case 15:
                        return "GATT INSUF ENCRYPTION";
                    case 16:
                        return "GATT UNSUPPORT GRP TYPE";
                    case 17:
                        return "GATT INSUF RESOURCE";
                    case 128:
                        return "GATT NO RESOURCES";
                    case 129:
                        return "GATT INTERNAL ERROR";
                    case 130:
                        return "GATT WRONG STATE";
                    case 131:
                        return "GATT DB FULL";
                    case 132:
                        return "GATT BUSY";
                    case d.CTRL_INDEX /*133*/:
                        return "GATT ERROR";
                    case 134:
                        return "GATT CMD STARTED";
                    case 135:
                        return "GATT ILLEGAL PARAMETER";
                    case h.CTRL_INDEX /*136*/:
                        return "GATT PENDING";
                    case 137:
                        return "GATT AUTH FAIL";
                    case 138:
                        return "GATT MORE";
                    case 139:
                        return "GATT INVALID CFG";
                    case 140:
                        return "GATT SERVICE STARTED";
                    case 141:
                        return "GATT ENCRYPTED NO MITM";
                    case 142:
                        return "GATT NOT ENCRYPTED";
                    case 143:
                        return "GATT CONGESTED";
                    case 253:
                        return "GATT CCCD CFG ERROR";
                    case 254:
                        return "GATT PROCEDURE IN PROGRESS";
                    case WebView.NORMAL_MODE_ALPHA /*255*/:
                        return "GATT VALUE OUT OF RANGE";
                    case 257:
                        return "GATT FAILURE, TOO MANY OPEN CONNECTIONS";
                    default:
                        return "UNKNOWN (" + i + ")";
                }
        }
    }
}
