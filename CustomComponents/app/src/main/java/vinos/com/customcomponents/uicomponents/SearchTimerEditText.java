package vinos.com.customcomponents.uicomponents;

import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by Admin on 9/14/2017.
 */

public class SearchTimerEditText extends android.support.v7.widget.AppCompatEditText {

    Handler handler;
    String search;
    long time = 1000L;
    Runnable runnable = new Runnable() {
        public void run() {

            if(editTextResultListener == null){
                Log.v("Error","Please add EditTextResultListener");
            }
            if (!search.isEmpty() && editTextResultListener != null) {
                editTextResultListener.onEditTextResult(search);
            }
        }
    };

    public SearchTimerEditText(Context context) {
        super(context);
        handler = new Handler();
        this.addTextChangedListener(textWatcher);
    }

    public SearchTimerEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        handler = new Handler();
        this.addTextChangedListener(textWatcher);
    }

    public SearchTimerEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        handler = new Handler();
        this.addTextChangedListener(textWatcher);
    }


    public void setTimeDelay(Long millisecond){
        this.time = millisecond;
    }

    public interface EditTextResultListener {
        public void onEditTextResult(String text);
    }

    EditTextResultListener editTextResultListener;

    public void setEditTextResultListener(EditTextResultListener editTextResultListener) {
        this.editTextResultListener = editTextResultListener;
    }

    TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


        }

        @Override
        public void afterTextChanged(Editable editable) {

            search = editable.toString().trim();
            handler.removeCallbacks(runnable);
            handler.postDelayed(runnable
                    , time);

        }
    };




}
