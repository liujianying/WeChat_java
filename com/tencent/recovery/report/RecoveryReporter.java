package com.tencent.recovery.report;

import android.content.Context;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.model.RecoveryPersistentItem;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class RecoveryReporter {
    private static File hk(Context context) {
        File file = new File(context.getFilesDir(), "recovery");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static boolean a(Context context, String str, RecoveryPersistentItem recoveryPersistentItem) {
        Throwable e;
        File hk = hk(context);
        RecoveryLog.i("Recovery.RecoveryReporter", "addItem %s", recoveryPersistentItem.cEY());
        File file = new File(hk, str);
        if (file.length() > 2097152) {
            RecoveryLog.i("Recovery.RecoveryReporter", "addItem file size large than 5MB", new Object[0]);
            file.delete();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
            }
        }
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            try {
                fileOutputStream.write((r3 + "\n").getBytes());
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    RecoveryLog.printErrStackTrace("Recovery.RecoveryReporter", e, "addItem", new Object[0]);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    return true;
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e7) {
            e = e7;
            fileOutputStream = null;
            RecoveryLog.printErrStackTrace("Recovery.RecoveryReporter", e, "addItem", new Object[0]);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e52) {
                }
            }
            return true;
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e62) {
                }
            }
            throw e;
        }
        return true;
    }

    public static boolean c(Context context, String str, List<? extends RecoveryPersistentItem> list) {
        Throwable e;
        RecoveryLog.i("Recovery.RecoveryReporter", "addItemList %s %d", str, Integer.valueOf(list.size()));
        File file = new File(hk(context), str);
        if (file.length() > 2097152) {
            RecoveryLog.i("Recovery.RecoveryReporter", "addItem file size large than 5MB", new Object[0]);
            file.delete();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
            }
        }
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            try {
                for (RecoveryPersistentItem cEY : list) {
                    fileOutputStream.write((cEY.cEY() + "\n").getBytes());
                }
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    RecoveryLog.printErrStackTrace("Recovery.RecoveryReporter", e, "addItem %s", str);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    return true;
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e7) {
            e = e7;
            fileOutputStream = null;
            RecoveryLog.printErrStackTrace("Recovery.RecoveryReporter", e, "addItem %s", str);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e52) {
                }
            }
            return true;
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e62) {
                }
            }
            throw e;
        }
        return true;
    }

    public static <T extends RecoveryPersistentItem> List<T> a(Context context, String str, Class<T> cls) {
        Throwable e;
        File hk = hk(context);
        List<T> linkedList = new LinkedList();
        File file = new File(hk, str);
        if (file.length() > 2097152) {
            RecoveryLog.i("Recovery.RecoveryReporter", "getItemList file size large than 5MB", new Object[0]);
            file.delete();
            return linkedList;
        } else if (file.exists()) {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    int read;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) file.length());
                    byte[] bArr = new byte[4096];
                    while (true) {
                        read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    for (String ack : new String(byteArrayOutputStream.toByteArray()).split("\n")) {
                        RecoveryPersistentItem recoveryPersistentItem = (RecoveryPersistentItem) cls.newInstance();
                        if (recoveryPersistentItem.ack(ack)) {
                            linkedList.add(recoveryPersistentItem);
                        } else {
                            RecoveryLog.e("Recovery.RecoveryReporter", "parse item error %s", r4[r3]);
                        }
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        RecoveryLog.printErrStackTrace("Recovery.RecoveryReporter", e, "getItemList", new Object[0]);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        return linkedList;
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileInputStream = null;
                RecoveryLog.printErrStackTrace("Recovery.RecoveryReporter", e, "getItemList", new Object[0]);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e42) {
                    }
                }
                return linkedList;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e52) {
                    }
                }
                throw e;
            }
            return linkedList;
        } else {
            RecoveryLog.i("Recovery.RecoveryReporter", "getItemList file not exist %s", str);
            return linkedList;
        }
    }

    public static void bH(Context context, String str) {
        new File(hk(context), str).delete();
    }
}
