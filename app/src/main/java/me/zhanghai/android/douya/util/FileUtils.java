/*
 * Copyright (c) 2017 Zhang Hai <Dreaming.in.Code.ZH@Gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.android.douya.util;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import me.zhanghai.android.douya.BuildConfig;
import me.zhanghai.android.douya.app.ImageTypeFileProvider;

public class FileUtils {

    private FileUtils() {}

    public static File createCaptureImageOutputFile(Context context) throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
        File directory = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        return File.createTempFile("IMG_" + timestamp + "_", ".jpg", directory);
    }

    public static Uri getContentUri(File file, Context context) {
        return ImageTypeFileProvider.getUriForFile(context, BuildConfig.FILE_PROVIDIER_AUTHORITY,
                file);
    }
}
