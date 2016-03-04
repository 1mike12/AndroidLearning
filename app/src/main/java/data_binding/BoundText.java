package data_binding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.databinding.ObservableParcelable;
import database.Contact;
import mike.customview.BR;

/**
 * Created by mike on 3/4/16.
 */
public class BoundText {
    public final ObservableField<String> name = new ObservableField<>();
}
