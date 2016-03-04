package mike.customview.database;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by mike on 1/19/16.
 */
public class ContactProvider extends ContentProvider {
    private DBHandler database;

    private static final String AUTHORITY = "com.mamlambo.tutorial.tutlist.data.TutListProvider";
    public static final int TUTORIALS = 100;
    public static final int TUTORIAL_ID = 110;

    private static final String TUTORIALS_BASE_PATH = "tutorials";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY
            + "/" + TUTORIALS_BASE_PATH);

    public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE
            + "/mt-tutorial";
    public static final String CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE
            + "/mt-tutorial";

    @Override
    public boolean onCreate() {
        database = new DBHandler(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}