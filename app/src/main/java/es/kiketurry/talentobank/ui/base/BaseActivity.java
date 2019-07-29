package es.kiketurry.talentobank.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BasicOperationActivity {
    
    private static final String TAG = BaseActivity.class.getSimpleName();
    protected P presenter;
    
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(getLayout());
        ButterKnife.bind(this);
        this.initView();
        presenter = initializePresenter();
        presenter.setup();
    }
    
    protected abstract int getLayout();
    
    protected abstract P initializePresenter();
    
    protected abstract void initView();
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.destroy();
        }
        presenter = null;
    }
    
    @Override
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
    
    @Override
    public void showKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(view, 0);
        }
    }
}
