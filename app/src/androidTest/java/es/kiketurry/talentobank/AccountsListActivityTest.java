package es.kiketurry.talentobank;

import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.kiketurry.talentobank.ui.accountslist.AccountsListActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class AccountsListActivityTest {
    
    @Rule
    public ActivityTestRule<AccountsListActivity> mActivityRule = new ActivityTestRule<>(AccountsListActivity.class);
    
    @Test
    public void toolbarTitle() {
        CharSequence title = "Listado de Cuentas";
        matchToolbarTitle(title);
    }
    
    @Test
    public void recyclerViewIsVisible() {
        onView(withId(R.id.rv_accounts_list)).check(matches(isDisplayed()));
    }
    
    private static ViewInteraction matchToolbarTitle(
            CharSequence title) {
        return onView(
                allOf(
                        isAssignableFrom(TextView.class),
                        withParent(isAssignableFrom(Toolbar.class))))
                .check(matches(withText(title.toString())));
    }
    
}
