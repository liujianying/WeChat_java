package com.tencent.mm.plugin.fav.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.support.v4.app.Fragment;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.opensdk.modelbase.BaseResp.ErrCode;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.snackbar.a$c;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.vfs.d;
import com.tencent.mm.y.g.a;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static aa<String, Bitmap> iYG = new aa(20);
    private static Map<String, Integer> iYH;

    public static void a(int i, Activity activity, b bVar) {
        a(-1, i, activity, null, null, null, bVar);
    }

    public static void a(int i, int i2, Activity activity, Fragment fragment, a$c a_c, OnClickListener onClickListener, b bVar) {
        if (activity == null && fragment == null) {
            x.e("MicroMsg.FavExportLogic", "handleErrorType activity = null && fragment = null");
            return;
        }
        b 1;
        if (bVar == null) {
            1 = new 1();
        } else {
            1 = bVar;
        }
        if (i2 != 0) {
            Context activity2;
            if (activity == null) {
                activity2 = fragment.getActivity();
            } else {
                activity2 = activity;
            }
            switch (i2) {
                case -9:
                case -8:
                case -7:
                case ErrCode.ERR_BAN /*-6*/:
                case ErrCode.ERR_UNSUPPORT /*-5*/:
                case ErrCode.ERR_AUTH_DENIED /*-4*/:
                    String string;
                    String str = "";
                    Context activity3 = fragment == null ? activity2 : fragment.getActivity();
                    if (i2 == -4) {
                        switch (i) {
                            case 2:
                                string = activity3.getString(i.favorite_expired_image);
                                break;
                            case 4:
                            case 16:
                                string = activity3.getString(i.favorite_expired_video);
                                break;
                            case 8:
                                string = activity3.getString(i.favorite_expired_file);
                                break;
                            case 14:
                                string = activity3.getString(i.favorite_fail_record_expired);
                                break;
                            default:
                                string = str;
                                break;
                        }
                    } else if (i2 == -5) {
                        string = i != 14 ? activity3.getString(i.favorite_big_file) : activity3.getString(i.favorite_fail_record_bigfile);
                    } else if (i2 == -6) {
                        string = activity3.getString(i.favorite_fail_record_expired);
                    } else if (i2 == -7) {
                        string = activity3.getString(i.favorite_fail_record_bigfile);
                    } else if (i2 == -8) {
                        string = activity3.getString(i.favorite_fail_record_expired_bigfile);
                    } else if (i2 != -9) {
                        string = activity3.getString(i.favorite_fail_argument_error);
                    } else if (fragment != null) {
                        com.tencent.mm.ui.widget.snackbar.b.a(fragment, activity3.getString(i.favorite_ok), activity3.getString(i.favorite_add_tag_tips), 1, a_c);
                        return;
                    } else {
                        com.tencent.mm.ui.widget.snackbar.b.a(activity2, activity3.getString(i.favorite_ok), activity3.getString(i.favorite_add_tag_tips), 1, a_c);
                        return;
                    }
                    final OnClickListener onClickListener2 = onClickListener;
                    h.a(activity3, string, "", activity3.getString(i.plugin_favorite_opt), activity3.getString(i.confirm_dialog_cancel), (OnClickListener) new 5(onClickListener, fragment, 1, a_c, activity2), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            if (onClickListener2 != null) {
                                onClickListener2.onClick(dialogInterface, -1);
                            }
                        }
                    }, m.b.wechat_green);
                    return;
                case -2:
                    h.a(activity2, activity2.getString(i.favorite_fail_clean_alert_content), activity2.getString(i.favorite_fail_clean_alert_title), activity2.getString(i.favorite_fail_fav_clean), activity2.getString(i.confirm_dialog_cancel), new 3(activity2, onClickListener), new 4(onClickListener), m.b.wechat_green);
                    return;
                default:
                    h.a(activity2, i2, 0, new 2(onClickListener));
                    return;
            }
        } else if (fragment != null) {
            com.tencent.mm.ui.widget.snackbar.b.a(fragment, fragment.getString(i.favorite_ok), fragment.getString(i.favorite_add_tag_tips), 1, a_c);
        } else if (activity != null) {
            com.tencent.mm.ui.widget.snackbar.b.a(activity, activity.getString(i.favorite_ok), activity.getString(i.favorite_add_tag_tips), 1, a_c);
        }
    }

    public static int a(bd bdVar, ch chVar, boolean z) {
        String str = "";
        x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type is %d", new Object[]{Integer.valueOf(bdVar.getType())});
        if (z || chVar.bJF.bJL <= 0) {
            boolean z2;
            if (chVar.bJF.type == 4 || chVar.bJF.type == 8 || chVar.bJF.type == 16 || chVar.bJF.type == 2) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (chVar.bJF.type == 14 && chVar.bJF.bJH.rBI.size() > 0) {
                vx vxVar = (vx) chVar.bJF.bJH.rBI.getLast();
                if (vxVar.bjS == 4 || vxVar.bjS == 8 || vxVar.bjS == 15 || vxVar.bjS == 2) {
                    z2 = false;
                }
            }
            x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo msg type skipCheck %B", new Object[]{Boolean.valueOf(z2)});
            if (z2) {
                return a(chVar, 0);
            }
            if (chVar.bJF.bJH == null) {
                return a(chVar, -1);
            }
            if (chVar.bJF.bJH.rBI == null) {
                return a(chVar, -1);
            }
            String str2;
            if (System.currentTimeMillis() - bdVar.field_createTime > 259200000) {
                z2 = true;
            } else {
                z2 = false;
            }
            x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo isOverThreeDays %B", new Object[]{Boolean.valueOf(z2)});
            if (1 <= chVar.bJF.bJH.rBI.size()) {
                str2 = ((vx) chVar.bJF.bJH.rBI.getLast()).rzM;
            } else {
                str2 = str;
            }
            if (z2) {
                String str3;
                if (bi.oW(str2) || !d.cn(str2)) {
                    if (bdVar != null && (bdVar.getType() == 43 || bdVar.getType() == 44 || bdVar.getType() == 62)) {
                        r nW = t.nW(bdVar.field_imgPath);
                        if (nW != null && nW.enT == -1) {
                            str2 = nW.Tl();
                            if (d.cn(str2)) {
                                str3 = str2;
                                if (bi.oW(str3)) {
                                    return a(chVar, -4);
                                }
                                ((vx) chVar.bJF.bJH.rBI.getLast()).UP(str3);
                            }
                        }
                    }
                    str3 = null;
                    if (bi.oW(str3)) {
                        return a(chVar, -4);
                    }
                    ((vx) chVar.bJF.bJH.rBI.getLast()).UP(str3);
                } else {
                    str3 = str2;
                }
                if (a(bdVar, chVar, str3, true)) {
                    return a(chVar, -5);
                }
                x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  isOverThreeDays true not big not expired");
            } else if (a(bdVar, chVar, str2, false)) {
                return a(chVar, -5);
            }
            x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  fav data is normal");
            return a(chVar, 0);
        }
        x.i("MicroMsg.FavExportLogic", "(!result)&&(favoriteEvent.data.errorType > FavExportLogic.KEY_FAV_PARA_NO_ERROR)");
        return a(chVar, chVar.bJF.bJL);
    }

    private static int a(ch chVar, int i) {
        int i2 = 1;
        if (chVar.bJF.bJH.rBI != null && chVar.bJF.bJH.rBI.size() > 0) {
            vx vxVar = (vx) chVar.bJF.bJH.rBI.getLast();
            if (i <= 0) {
                switch (i) {
                    case ErrCode.ERR_UNSUPPORT /*-5*/:
                        vxVar.CH(2);
                        vxVar.UP(null);
                        break;
                    case ErrCode.ERR_AUTH_DENIED /*-4*/:
                        vxVar.CH(1);
                        vxVar.UP(null);
                        break;
                    default:
                        vxVar.CH(0);
                        break;
                }
            }
        }
        if (chVar.bJF.bJH.rBI == null || chVar.bJF.bJH.rBI.size() == 0) {
            chVar.bJF.bJL = i;
        } else if (chVar.bJF.bJL != -9) {
            if (i <= 0 && chVar.bJF.bJL <= 0) {
                i2 = 0;
            }
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i3 < chVar.bJF.bJH.rBI.size()) {
                switch (((vx) chVar.bJF.bJH.rBI.get(i3)).rAw) {
                    case 0:
                        i6++;
                        break;
                    case 1:
                        i4++;
                        break;
                    case 2:
                        i5++;
                        break;
                    default:
                        break;
                }
                i3++;
                i4 = i4;
            }
            if (i2 > 0) {
                if (i5 > 0 || i4 > 0) {
                    chVar.bJF.bJL = -9;
                } else {
                    chVar.bJF.bJL = i;
                }
            } else if (i5 > 0) {
                if (i4 > 0) {
                    chVar.bJF.bJL = -8;
                } else if (i6 == 0) {
                    chVar.bJF.bJL = -5;
                } else if (i6 > 0) {
                    chVar.bJF.bJL = -7;
                }
            } else if (i4 > 0) {
                if (i6 == 0) {
                    chVar.bJF.bJL = -4;
                } else if (i6 > 0) {
                    chVar.bJF.bJL = -6;
                }
            }
        }
        return i;
    }

    private static boolean a(bd bdVar, ch chVar, String str, boolean z) {
        a J;
        if (!bi.oW(str)) {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
            if (bVar.exists()) {
                if (bVar.length() > ((long) com.tencent.mm.k.b.AB())) {
                    x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
                    return true;
                }
                x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file not big");
            } else if (!z) {
                x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish ！attachFile.exists()");
                ((vx) chVar.bJF.bJH.rBI.getLast()).UP(null);
            }
        }
        String str2 = bdVar.field_content;
        if (str2 != null) {
            J = a.J(str2, bdVar.field_reserved);
        } else {
            J = null;
        }
        if (J != null) {
            if (J.dws != 0 || J.dwo > com.tencent.mm.k.b.AB()) {
                x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  file is big");
                return true;
            } else if (!(bi.oW(str) || !d.cn(str) || z)) {
                if (((long) J.dwo) > d.abQ(str)) {
                    x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  not download finish content.attachlen > datasize");
                    ((vx) chVar.bJF.bJH.rBI.getLast()).UP(null);
                }
            }
        }
        if (str2 == null || J == null) {
            x.i("MicroMsg.FavExportLogic", "checkMsgLegalInfo  (xml == null ) ||(content == null)");
        }
        return false;
    }

    static {
        iYH = new HashMap();
        Map hashMap = new HashMap();
        iYH = hashMap;
        hashMap.put("avi", Integer.valueOf(m.h.app_attach_file_icon_video));
        iYH.put("m4v", Integer.valueOf(m.h.app_attach_file_icon_video));
        iYH.put("vob", Integer.valueOf(m.h.app_attach_file_icon_video));
        iYH.put("mpeg", Integer.valueOf(m.h.app_attach_file_icon_video));
        iYH.put("mpe", Integer.valueOf(m.h.app_attach_file_icon_video));
        iYH.put("asx", Integer.valueOf(m.h.app_attach_file_icon_video));
        iYH.put("asf", Integer.valueOf(m.h.app_attach_file_icon_video));
        iYH.put("f4v", Integer.valueOf(m.h.app_attach_file_icon_video));
        iYH.put("flv", Integer.valueOf(m.h.app_attach_file_icon_video));
        iYH.put("mkv", Integer.valueOf(m.h.app_attach_file_icon_video));
        iYH.put("wmv", Integer.valueOf(m.h.app_attach_file_icon_video));
        iYH.put("wm", Integer.valueOf(m.h.app_attach_file_icon_video));
        iYH.put("3gp", Integer.valueOf(m.h.app_attach_file_icon_video));
        iYH.put("mp4", Integer.valueOf(m.h.app_attach_file_icon_video));
        iYH.put("rmvb", Integer.valueOf(m.h.app_attach_file_icon_video));
        iYH.put("rm", Integer.valueOf(m.h.app_attach_file_icon_video));
        iYH.put("ra", Integer.valueOf(m.h.app_attach_file_icon_video));
        iYH.put("ram", Integer.valueOf(m.h.app_attach_file_icon_video));
        iYH.put("mp3pro", Integer.valueOf(m.h.app_attach_file_icon_music));
        iYH.put("vqf", Integer.valueOf(m.h.app_attach_file_icon_music));
        iYH.put("cd", Integer.valueOf(m.h.app_attach_file_icon_music));
        iYH.put("md", Integer.valueOf(m.h.app_attach_file_icon_music));
        iYH.put("mod", Integer.valueOf(m.h.app_attach_file_icon_music));
        iYH.put("vorbis", Integer.valueOf(m.h.app_attach_file_icon_music));
        iYH.put("au", Integer.valueOf(m.h.app_attach_file_icon_music));
        iYH.put("amr", Integer.valueOf(m.h.app_attach_file_icon_music));
        iYH.put("silk", Integer.valueOf(m.h.app_attach_file_icon_music));
        iYH.put("wma", Integer.valueOf(m.h.app_attach_file_icon_music));
        iYH.put("mmf", Integer.valueOf(m.h.app_attach_file_icon_music));
        iYH.put("mid", Integer.valueOf(m.h.app_attach_file_icon_music));
        iYH.put("midi", Integer.valueOf(m.h.app_attach_file_icon_music));
        iYH.put("mp3", Integer.valueOf(m.h.app_attach_file_icon_music));
        iYH.put("aac", Integer.valueOf(m.h.app_attach_file_icon_music));
        iYH.put("ape", Integer.valueOf(m.h.app_attach_file_icon_music));
        iYH.put("aiff", Integer.valueOf(m.h.app_attach_file_icon_music));
        iYH.put("aif", Integer.valueOf(m.h.app_attach_file_icon_music));
        iYH.put("jfif", Integer.valueOf(m.h.app_attach_file_icon_pic));
        iYH.put("tiff", Integer.valueOf(m.h.app_attach_file_icon_pic));
        iYH.put("tif", Integer.valueOf(m.h.app_attach_file_icon_pic));
        iYH.put("jpe", Integer.valueOf(m.h.app_attach_file_icon_pic));
        iYH.put("dib", Integer.valueOf(m.h.app_attach_file_icon_pic));
        iYH.put("jpeg", Integer.valueOf(m.h.app_attach_file_icon_pic));
        iYH.put("jpg", Integer.valueOf(m.h.app_attach_file_icon_pic));
        iYH.put("png", Integer.valueOf(m.h.app_attach_file_icon_pic));
        iYH.put("bmp", Integer.valueOf(m.h.app_attach_file_icon_pic));
        iYH.put("gif", Integer.valueOf(m.h.app_attach_file_icon_pic));
        iYH.put("rar", Integer.valueOf(m.h.app_attach_file_icon_rar));
        iYH.put("zip", Integer.valueOf(m.h.app_attach_file_icon_rar));
        iYH.put("7z", Integer.valueOf(m.h.app_attach_file_icon_rar));
        iYH.put("iso", Integer.valueOf(m.h.app_attach_file_icon_rar));
        iYH.put("cab", Integer.valueOf(m.h.app_attach_file_icon_rar));
        iYH.put("doc", Integer.valueOf(m.h.app_attach_file_icon_word));
        iYH.put("docx", Integer.valueOf(m.h.app_attach_file_icon_word));
        iYH.put("ppt", Integer.valueOf(m.h.app_attach_file_icon_ppt));
        iYH.put("pptx", Integer.valueOf(m.h.app_attach_file_icon_ppt));
        iYH.put("xls", Integer.valueOf(m.h.app_attach_file_icon_excel));
        iYH.put("xlsx", Integer.valueOf(m.h.app_attach_file_icon_excel));
        iYH.put("txt", Integer.valueOf(m.h.app_attach_file_icon_txt));
        iYH.put("rtf", Integer.valueOf(m.h.app_attach_file_icon_txt));
        iYH.put("pdf", Integer.valueOf(m.h.app_attach_file_icon_pdf));
        iYH.put("unknown", Integer.valueOf(m.h.app_attach_file_icon_unknow));
    }

    public static Bitmap at(String str, boolean z) {
        boolean z2 = true;
        if (bi.oW(str)) {
            return null;
        }
        Bitmap bitmap = (Bitmap) iYG.get(str);
        if (bitmap != null) {
            x.d("MicroMsg.FavExportLogic", "get bm from cache %s", new Object[]{str});
            return bitmap;
        } else if (z) {
            return null;
        } else {
            if (!d.cn(str)) {
                return null;
            }
            int i;
            x.d("MicroMsg.FavExportLogic", "get from cache fail, try to decode from file");
            Options options = new Options();
            options.inJustDecodeBounds = true;
            bitmap = BitmapFactory.decodeFile(str, options);
            if (bitmap != null) {
                x.i("MicroMsg.FavExportLogic", "bitmap recycle %s", new Object[]{bitmap});
                bitmap.recycle();
            }
            boolean z3 = z.bv(options.outWidth, options.outHeight) && options.outWidth > 480;
            boolean z4;
            if (!z.bu(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z3 || z4) {
                int i2 = options.outHeight;
                i = options.outWidth;
                while (i * i2 > 2764800) {
                    i >>= 1;
                    i2 >>= 1;
                }
                i = Math.max(1, i);
                i2 = Math.max(1, i2);
                x.w("MicroMsg.FavExportLogic", "fit long picture, beg %d*%d, after %d*%d", new Object[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i), Integer.valueOf(i2)});
            }
            i = ExifHelper.VX(str);
            if (MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                bitmap = MMNativeJpeg.decodeAsBitmap(str);
                String str2 = "MicroMsg.FavExportLogic";
                String str3 = "Progressive jpeg, result isNull:%b";
                Object[] objArr = new Object[1];
                if (bitmap != null) {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                x.i(str2, str3, objArr);
            } else {
                bitmap = com.tencent.mm.sdk.platformtools.c.cU(str, 0);
            }
            if (bitmap == null) {
                x.e("MicroMsg.FavExportLogic", "getSuitableBmp fail, temBmp is null, filePath = " + str);
                return null;
            }
            bitmap = com.tencent.mm.sdk.platformtools.c.b(bitmap, (float) i);
            iYG.put(str, bitmap);
            return bitmap;
        }
    }

    public static int Bx(String str) {
        Integer num = (Integer) iYH.get(str);
        if (num == null) {
            return ((Integer) iYH.get("unknown")).intValue();
        }
        return num.intValue();
    }

    @TargetApi(8)
    public static Bitmap By(String str) {
        if (com.tencent.mm.compatible.util.d.fR(8)) {
            return ThumbnailUtils.createVideoThumbnail(str, 1);
        }
        return null;
    }

    public static void aMi() {
    }
}
