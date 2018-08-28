package com.tencent.mm.compatible.f;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.SparseArray;
import com.tencent.mm.a.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a {
    public static Boolean dfP;

    public static boolean a(String str, String str2, PInt pInt, PBool pBool) {
        if (str == null) {
            pBool.value = false;
            return false;
        } else if (str2 == null) {
            pBool.value = true;
            return false;
        } else if (str.equals(str2)) {
            pInt.value++;
            pBool.value = true;
            return true;
        } else {
            pBool.value = false;
            return false;
        }
    }

    public static List<PackageInfo> be(boolean z) {
        Set hashSet = new HashSet();
        if (z) {
            ActivityManager activityManager = (ActivityManager) ad.getContext().getSystemService("activity");
            if (activityManager != null) {
                try {
                    List<RunningServiceInfo> runningServices = activityManager.getRunningServices(32767);
                    if (runningServices != null) {
                        for (RunningServiceInfo runningServiceInfo : runningServices) {
                            hashSet.add(runningServiceInfo.service.getPackageName());
                        }
                    }
                } catch (SecurityException e) {
                    x.e("MicroMsg.PermissionConfig", "getRunningServices failed");
                }
            }
        }
        PackageManager packageManager = ad.getContext().getPackageManager();
        if (packageManager == null) {
            return null;
        }
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
        if (installedPackages == null || !z) {
            return installedPackages;
        }
        List<PackageInfo> arrayList = new ArrayList();
        for (PackageInfo packageInfo : installedPackages) {
            if (hashSet.contains(packageInfo.packageName)) {
                arrayList.add(packageInfo);
            }
        }
        return arrayList;
    }

    public static void a(String str, List<b> list, List<a> list2) {
        Throwable th;
        if (e.cn(str)) {
            String str2 = ".perm.values.";
            String str3 = "";
            String chP = w.chP();
            if (chP.equals("zh_CN")) {
                chP = "zh_CN";
            } else if (chP.equals("zh_TW") || chP.equals("zh_HK")) {
                chP = str3 + "zh_TW";
            } else {
                chP = str3 + "en";
            }
            BufferedReader bufferedReader = null;
            BufferedReader bufferedReader2;
            try {
                bufferedReader2 = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        str3 = bufferedReader2.readLine();
                        if (str3 != null) {
                            String trim = str3.trim();
                            if (trim.length() != 0) {
                                Map z = bl.z(trim, "perm");
                                if (z == null) {
                                    x.e("MicroMsg.PermissionConfig", "unable to parse xml, " + trim);
                                } else {
                                    str3 = (String) z.get(".perm.type");
                                    if (str3 == null) {
                                        x.e("MicroMsg.PermissionConfig", "invalid config, " + trim);
                                    } else if (str3.equals("1")) {
                                        b bVar = new b((byte) 0);
                                        bVar.dfT = new SparseArray();
                                        bVar.dfU = (String) z.get(".perm.manufacture");
                                        bVar.model = (String) z.get(".perm.model");
                                        bVar.version = (String) z.get(".perm.version_release");
                                        bVar.dfT.append(1, z.get(str2 + chP));
                                        bVar.dfT.append(2, z.get(str2 + "camera." + chP));
                                        bVar.dfS = bi.WU((String) z.get(".perm.check_exception"));
                                        list.add(bVar);
                                    } else if (str3.equals("2")) {
                                        a aVar = new a((byte) 0);
                                        aVar.dfT = new SparseArray();
                                        aVar.byT = (String) z.get(".perm.package");
                                        aVar.dfQ = bi.WU((String) z.get(".perm.min_versioncode"));
                                        aVar.dfR = bi.WU((String) z.get(".perm.max_versioncode"));
                                        aVar.dfT.append(1, z.get(str2 + chP));
                                        aVar.dfT.append(2, z.get(str2 + "camera." + chP));
                                        aVar.dfS = bi.WU((String) z.get(".perm.check_exception"));
                                        list2.add(aVar);
                                    }
                                }
                            }
                        } else {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e) {
                                return;
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        bufferedReader = bufferedReader2;
                        try {
                            x.e("MicroMsg.PermissionConfig", "file not found exception");
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                    return;
                                } catch (IOException e3) {
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e4) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        try {
                            x.e("MicroMsg.PermissionConfig", "read permission config file failed");
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (IOException e6) {
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th3) {
                            th = th3;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException e42) {
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (FileNotFoundException e7) {
                x.e("MicroMsg.PermissionConfig", "file not found exception");
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                        return;
                    } catch (IOException e32) {
                        return;
                    }
                }
                return;
            } catch (IOException e8) {
                bufferedReader2 = null;
                x.e("MicroMsg.PermissionConfig", "read permission config file failed");
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                        return;
                    } catch (IOException e62) {
                        return;
                    }
                }
                return;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader2 = null;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e422) {
                    }
                }
                throw th;
            }
        }
        x.i("MicroMsg.PermissionConfig", "file is not exists");
    }
}
