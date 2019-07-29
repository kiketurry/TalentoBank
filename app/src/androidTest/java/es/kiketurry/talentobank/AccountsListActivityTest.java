package es.kiketurry.talentobank;

import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.kiketurry.talentobank.ui.accountslist.AccountsListActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
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
